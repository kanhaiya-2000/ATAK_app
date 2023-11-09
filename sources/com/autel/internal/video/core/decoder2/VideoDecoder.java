package com.autel.internal.video.core.decoder2;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.autel.common.video.OnRenderFrameInfoListener;
import com.autel.internal.video.core.decoder2.common.FilterType;
import com.autel.internal.video.core.decoder2.common.StreamData;
import com.autel.internal.video.core.decoder2.common.VideoDecoderException;
import com.autel.internal.video.core.decoder2.common.VideoDefaultParams;
import com.autel.internal.video.core.decoder2.utils.HandlerThreadUtils;
import com.autel.internal.video.core.decoder2.utils.RenderSizeUtils;
import com.autel.internal.video.core.decoder2.utils.VideoDecoderLogUtils;
import com.autel.video.NetWorkProxyJni;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoDecoder {
    private final int MSG_DECODE_FRAME = 1;
    private final int MSG_INIT_CODEC = 0;
    private final int MSG_RESET_CODEC = 4;
    private final int MSG_UPDATE_FILTER_RENDER = 2;
    private final int MSG_UPDATE_SIZE_RENDER = 3;
    private final int PLAYER_DESTROY = 1;
    private final int PLAYER_PAUSE = 3;
    private final int PLAYER_START = 2;
    private final int PLAYER_STOP = 0;
    private final int ReadStreamFailed = 1500;
    private final int ReadStreamSuccess = 15;
    private final String TAG = "AutelVideoDecoder";
    private final int VALUE_NO_RESET = 0;
    private final int VALUE_RESETING = 1;
    private int curFrameHeight = VideoDefaultParams.mFormatHeight;
    private int curFrameWidth = VideoDefaultParams.mFormatWidth;
    /* access modifiers changed from: private */
    public int curSurfaceHeight;
    /* access modifiers changed from: private */
    public int curSurfaceWidth;
    /* access modifiers changed from: private */
    public Handler dataHandler;
    /* access modifiers changed from: private */
    public HandlerThread dataHandlerThread;
    /* access modifiers changed from: private */
    public final Object decoderHasInit = new Object();
    private final long dequeueTimeout = 50000;
    byte[] frame = new byte[1048576];
    private boolean hasVideoStreamComeIn;
    private int inIndex;
    StreamData inputFrame = new StreamData();
    private volatile boolean isCameraConnected;
    boolean isReadStreamDataNotReset;
    private boolean isRenderLastFramed;
    private MediaCodec mDecoder;
    /* access modifiers changed from: private */
    public volatile boolean mDecoderInit = false;
    /* access modifiers changed from: private */
    public SurfaceTexture mDisplaySurface;
    private ByteBuffer mInputBuffer;
    private ByteBuffer[] mInputBuffers;
    /* access modifiers changed from: private */
    public volatile int mPlayStatus = 0;
    /* access modifiers changed from: private */
    public RenderHandle mRenderHandle;
    long mStreamHandle = 0;
    private Surface mSurface;
    /* access modifiers changed from: private */
    public MediaCodec.BufferInfo minfo;
    private OnRenderFrameInfoListener onRenderFrameInfoListener;
    final long readGap = 15000000;
    private int readStreamFailedTimes = 0;
    private int readStreamId;
    /* access modifiers changed from: private */
    public Thread readStreamThread;
    private int read_timeout_cnt = 0;
    /* access modifiers changed from: private */
    public AtomicInteger resetStatus = new AtomicInteger(0);
    private byte[] sps_pps_Buf = new byte[2100];
    private int timeGap4ReadStream = 15;
    private long try_again_start_time = 0;
    private boolean useOpenGL;
    private int waitIframeCount = 0;

    public VideoDecoder(SurfaceTexture surfaceTexture, int i, int i2, boolean z) {
        this.mDisplaySurface = surfaceTexture;
        this.curSurfaceWidth = i;
        this.curSurfaceHeight = i2;
        setPlayStatus(2);
        this.useOpenGL = z;
    }

    public void startDecode() {
        VideoDecoderLogUtils.writeNecessaryLog("====== startDecode() ======", true, false);
        startDataHandler(this.useOpenGL);
        startReadStreamDataHandler();
    }

    public void setOnRenderFrameInfoListener(OnRenderFrameInfoListener onRenderFrameInfoListener2) {
        this.onRenderFrameInfoListener = onRenderFrameInfoListener2;
        if (onRenderFrameInfoListener2 != null) {
            onRenderFrameInfoListener2.onRenderFrameSizeChanged(this.curFrameWidth, this.curFrameHeight);
        }
    }

    public void setCameraConnected(boolean z) {
        this.isCameraConnected = z;
    }

    public void setOverExpoBackground(int i) {
        RenderHandle renderHandle = this.mRenderHandle;
        if (renderHandle != null) {
            renderHandle.setOverExpoBackground(i);
        }
    }

    public void setOverExpo(boolean z) {
        if (this.mRenderHandle != null) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = (z ? FilterType.OverExposure : FilterType.Normal).value();
            this.dataHandler.sendMessage(message);
        }
    }

    public boolean isOverExposureEnabled() {
        RenderHandle renderHandle = this.mRenderHandle;
        return renderHandle != null && renderHandle.getCurFilterType().equals(FilterType.OverExposure);
    }

    public void setSurfaceSize(int i, int i2) {
        this.curSurfaceWidth = i;
        this.curSurfaceHeight = i2;
        sendRenderSizeChangedMessage();
    }

    private void sendRenderSizeChangedMessage() {
        if (this.mRenderHandle != null) {
            Message message = new Message();
            message.what = 3;
            message.obj = RenderSizeUtils.getRenderSize(this.curFrameWidth, this.curFrameHeight, this.curSurfaceWidth, this.curSurfaceHeight);
            this.dataHandler.sendMessage(message);
        }
    }

    public void resume() {
        VideoDecoderLogUtils.writeNecessaryLog("====== resume() ======");
        if (this.mPlayStatus == 3) {
            setPlayStatus(2);
        }
    }

    public void pause() {
        VideoDecoderLogUtils.writeNecessaryLog("====== pause() ======");
        if (this.mPlayStatus == 2) {
            setPlayStatus(3);
        }
    }

    private void setPlayStatus(int i) {
        synchronized (this.decoderHasInit) {
            this.mPlayStatus = i;
            this.decoderHasInit.notify();
        }
    }

    public synchronized void destroy() {
        VideoDecoderLogUtils.writeNecessaryLog("====== destroy() ======", false, true);
        this.timeGap4ReadStream = 15;
        this.isReadStreamDataNotReset = true;
        setPlayStatus(1);
        this.mInputBuffer = null;
        this.onRenderFrameInfoListener = null;
        new Thread("VideoDecoder destroy") {
            public void run() {
                HandlerThreadUtils.cancelHandlerThread(VideoDecoder.this.dataHandlerThread, VideoDecoder.this.dataHandler);
                while (true) {
                    if (!VideoDecoder.this.readStreamThread.isAlive() && !VideoDecoder.this.dataHandlerThread.isAlive()) {
                        break;
                    }
                }
                VideoDecoder.this.releaseImageHandle();
                VideoDecoder.this.releaseCodec();
                if (VideoDecoder.this.mDisplaySurface != null) {
                    try {
                        VideoDecoder.this.mDisplaySurface.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                SurfaceTexture unused = VideoDecoder.this.mDisplaySurface = null;
            }
        }.start();
    }

    private void startReadStreamDataHandler() {
        C49062 r0 = new Thread("read stream data thread") {
            public void run() {
                VideoDecoder.this.readStreamData();
            }
        };
        this.readStreamThread = r0;
        r0.start();
    }

    /* access modifiers changed from: private */
    public void readStreamData() {
        while (this.mPlayStatus > 1) {
            this.read_timeout_cnt = 0;
            this.isReadStreamDataNotReset = true;
            while (this.mStreamHandle == 0 && this.mPlayStatus > 1) {
                this.mStreamHandle = NetWorkProxyJni.OpenStream();
            }
            while (this.mPlayStatus > 1 && this.isReadStreamDataNotReset) {
                long nanoTime = System.nanoTime();
                inputBuffer(this.frame, this.inputFrame);
                long nanoTime2 = (nanoTime + 15000000) - System.nanoTime();
                if (nanoTime2 > 0) {
                    long j = nanoTime2 / 1000000;
                    if (j == 0) {
                        do {
                        } while ((nanoTime2 + System.nanoTime()) - System.nanoTime() > 0);
                    } else {
                        Long.signum(j);
                        try {
                            Thread.sleep(j, (int) (nanoTime2 - (1000000 * j)));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            long j2 = this.mStreamHandle;
            if (j2 != 0) {
                NetWorkProxyJni.CloseStream(j2);
            }
            this.mStreamHandle = 0;
            if (!this.isReadStreamDataNotReset) {
                VideoDecoderLogUtils.writeNecessaryLog("====== startToReset ======");
            }
        }
    }

    private void inputBuffer(byte[] bArr, StreamData streamData) {
        if (this.resetStatus.get() != 1) {
            int ReadStream = NetWorkProxyJni.ReadStream(this.mStreamHandle, bArr, bArr.length, this.timeGap4ReadStream);
            this.readStreamId = ReadStream;
            if (ReadStream > 0) {
                try {
                    streamData.parseData(bArr);
                    if (!this.mDecoderInit && streamData.isIframe()) {
                        initIFrameDecoder(streamData);
                        if (!this.mDecoderInit) {
                            this.isReadStreamDataNotReset = false;
                            VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder failed to reset ======");
                        }
                    }
                    if (!this.mDecoderInit) {
                        int i = this.waitIframeCount + 1;
                        this.waitIframeCount = i;
                        if (i >= 31) {
                            initCodec();
                            this.waitIframeCount = 0;
                            VideoDecoderLogUtils.writeNecessaryLog("====== to initCodec ======");
                        } else if (i % 10 == 0) {
                            this.isReadStreamDataNotReset = false;
                            VideoDecoderLogUtils.writeNecessaryLog("====== no Iframe come to reset ======");
                        }
                    } else {
                        if (!(this.mRenderHandle == null || streamData.getHeight() <= 0 || this.curFrameWidth * streamData.getHeight() == this.curFrameHeight * streamData.getWidth())) {
                            this.curFrameWidth = streamData.getWidth();
                            this.curFrameHeight = streamData.getHeight();
                            sendRenderSizeChangedMessage();
                            OnRenderFrameInfoListener onRenderFrameInfoListener2 = this.onRenderFrameInfoListener;
                            if (onRenderFrameInfoListener2 != null) {
                                onRenderFrameInfoListener2.onRenderFrameSizeChanged(this.curFrameWidth, this.curFrameHeight);
                            }
                        }
                        if (this.read_timeout_cnt >= 100) {
                            VideoDecoderLogUtils.writeNecessaryLog("******* video stream is online. *******");
                        }
                        this.read_timeout_cnt = 0;
                        this.hasVideoStreamComeIn = true;
                        int dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(50000);
                        this.inIndex = dequeueInputBuffer;
                        if (dequeueInputBuffer >= 0) {
                            ByteBuffer byteBuffer = this.mInputBuffers[dequeueInputBuffer];
                            this.mInputBuffer = byteBuffer;
                            byteBuffer.clear();
                            this.mInputBuffer.put(streamData.getFrameData());
                            this.mDecoder.queueInputBuffer(this.inIndex, 0, streamData.getSize(), streamData.getPts(), 0);
                        }
                        this.timeGap4ReadStream = 15;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                int i2 = this.read_timeout_cnt + 1;
                this.read_timeout_cnt = i2;
                int i3 = this.timeGap4ReadStream;
                if (i3 == 15) {
                    if (i2 % 15 == 0) {
                        this.isReadStreamDataNotReset = false;
                        this.timeGap4ReadStream = 1500;
                        this.readStreamFailedTimes = 0;
                    }
                } else if (i3 == 1500) {
                    this.isReadStreamDataNotReset = false;
                    int i4 = this.readStreamFailedTimes + 1;
                    this.readStreamFailedTimes = i4;
                    if (i4 > 3) {
                        this.hasVideoStreamComeIn = false;
                        VideoDecoderLogUtils.writeNecessaryLog("******* No video stream data.*******");
                    }
                }
            }
        }
    }

    private void initIFrameDecoder(StreamData streamData) {
        try {
            VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ======");
            this.mDecoder = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(streamData.getSps(), 0, streamData.getSps_len()));
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(streamData.getPps(), 0, streamData.getPps_len()));
            if (this.useOpenGL) {
                while (this.mRenderHandle == null) {
                }
                MediaCodec mediaCodec = this.mDecoder;
                Surface surface = new Surface(this.mRenderHandle.getSurfaceTexture());
                this.mSurface = surface;
                mediaCodec.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            } else {
                MediaCodec mediaCodec2 = this.mDecoder;
                Surface surface2 = new Surface(this.mDisplaySurface);
                this.mSurface = surface2;
                mediaCodec2.configure(createVideoFormat, surface2, (MediaCrypto) null, 0);
            }
            this.mDecoder.start();
            this.mInputBuffers = this.mDecoder.getInputBuffers();
            synchronized (this.decoderHasInit) {
                if (!this.mDecoderInit) {
                    this.mDecoderInit = true;
                    this.decoderHasInit.notify();
                }
            }
        } catch (Exception unused) {
            this.mDecoder = null;
        }
    }

    private void initIFrameDecoder(byte[] bArr, int i, byte[] bArr2, int i2) {
        try {
            releaseCodec();
            this.mDecoder = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr, 0, i));
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2, 0, i2));
            if (this.useOpenGL) {
                while (this.mRenderHandle == null) {
                }
                MediaCodec mediaCodec = this.mDecoder;
                Surface surface = new Surface(this.mRenderHandle.getSurfaceTexture());
                this.mSurface = surface;
                mediaCodec.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            } else {
                MediaCodec mediaCodec2 = this.mDecoder;
                Surface surface2 = new Surface(this.mDisplaySurface);
                this.mSurface = surface2;
                mediaCodec2.configure(createVideoFormat, surface2, (MediaCrypto) null, 0);
            }
            this.mDecoder.start();
            this.mInputBuffers = this.mDecoder.getInputBuffers();
            synchronized (this.decoderHasInit) {
                if (!this.mDecoderInit) {
                    this.mDecoderInit = true;
                    this.decoderHasInit.notify();
                }
            }
        } catch (Exception unused) {
            this.mDecoder = null;
        }
    }

    private void startDataHandler(final boolean z) {
        HandlerThread handlerThread = new HandlerThread("frame data handler thread");
        this.dataHandlerThread = handlerThread;
        handlerThread.start();
        this.dataHandler = new Handler(this.dataHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    try {
                        Log.e("performanceLog", " destroy mPlayStatus " + VideoDecoder.this.mPlayStatus);
                        while (VideoDecoder.this.mPlayStatus <= 1) {
                            synchronized (VideoDecoder.this.decoderHasInit) {
                                VideoDecoder.this.decoderHasInit.wait();
                                Log.e("performanceLog", " destroy wait 1 mPlayStatus " + VideoDecoder.this.mPlayStatus);
                                if (VideoDecoder.this.mPlayStatus == 1) {
                                    return;
                                }
                            }
                        }
                        if (z) {
                            VideoDecoder.this.initImageHandle();
                            VideoDecoder videoDecoder = VideoDecoder.this;
                            videoDecoder.setSurfaceSize(videoDecoder.curSurfaceWidth, VideoDecoder.this.curSurfaceHeight);
                        }
                        while (!VideoDecoder.this.mDecoderInit) {
                            synchronized (VideoDecoder.this.decoderHasInit) {
                                if (!VideoDecoder.this.mDecoderInit) {
                                    VideoDecoder.this.decoderHasInit.wait();
                                }
                                Log.e("performanceLog", " destroy wait 1 mPlayStatus " + VideoDecoder.this.mPlayStatus);
                                if (VideoDecoder.this.mPlayStatus == 1) {
                                    return;
                                }
                            }
                        }
                        MediaCodec.BufferInfo unused = VideoDecoder.this.minfo = new MediaCodec.BufferInfo();
                        sendEmptyMessage(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (i == 1) {
                    while (VideoDecoder.this.mPlayStatus > 1 && !hasMessages(2)) {
                        try {
                            if (!hasMessages(3)) {
                                VideoDecoder.this.decodeFrame();
                            } else {
                                return;
                            }
                        } catch (Exception unused2) {
                            if (VideoDecoder.this.mPlayStatus > 1) {
                                VideoDecoder.this.resetStatus.set(1);
                                removeCallbacksAndMessages((Object) null);
                                sendEmptyMessageDelayed(4, 10);
                                return;
                            }
                            return;
                        }
                    }
                } else if (i == 2) {
                    VideoDecoder.this.mRenderHandle.setCurFilterType(FilterType.find(message.arg1));
                    sendEmptyMessage(1);
                } else if (i == 3) {
                    int[] iArr = (int[]) message.obj;
                    VideoDecoder.this.mRenderHandle.VideoWinSet(iArr[0], iArr[1], iArr[2], iArr[3]);
                    sendEmptyMessage(1);
                } else if (i == 4) {
                    VideoDecoder.this.resetCodec();
                }
            }
        };
        sendDataHandlerEmptyMessage(0);
    }

    private void sendDataHandlerEmptyMessage(int i) {
        if (this.dataHandler != null && this.mPlayStatus > 1) {
            this.dataHandler.sendEmptyMessage(i);
        }
    }

    private void sendDataHandlerEmptyMessageDelayed(int i, long j) {
        if (this.dataHandler != null && this.mPlayStatus > 1) {
            this.dataHandler.sendEmptyMessageDelayed(i, j);
        }
    }

    /* access modifiers changed from: private */
    public void releaseImageHandle() {
        RenderHandle renderHandle = this.mRenderHandle;
        if (renderHandle != null) {
            renderHandle.release();
        }
        this.mRenderHandle = null;
    }

    /* access modifiers changed from: private */
    public void initImageHandle() {
        if (this.mRenderHandle == null || this.mDisplaySurface != null) {
            RenderHandle renderHandle = new RenderHandle(this.mDisplaySurface, false);
            this.mRenderHandle = renderHandle;
            renderHandle.handlerInit();
        }
    }

    /* access modifiers changed from: private */
    public void releaseCodec() {
        MediaCodec mediaCodec = this.mDecoder;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.mDecoder.release();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.mDecoder = null;
                throw th;
            }
            this.mDecoder = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    /* access modifiers changed from: private */
    public void resetCodec() {
        VideoDecoderLogUtils.writeNecessaryLog("====== resetCodec() ======");
        while (this.resetStatus.get() == 1) {
            if (initCodec()) {
                this.resetStatus.set(0);
            }
        }
        sendDataHandlerEmptyMessage(1);
    }

    private boolean initCodec() {
        releaseCodec();
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("flags", 2);
            if (Build.VERSION.SDK_INT < 21) {
                createVideoFormat.setInteger("color-format", 21);
            }
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
            this.mDecoder = createDecoderByType;
            if (this.useOpenGL) {
                while (this.mRenderHandle == null) {
                }
                VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ======mRenderHandle != null ");
                MediaCodec mediaCodec = this.mDecoder;
                Surface surface = new Surface(this.mRenderHandle.getSurfaceTexture());
                this.mSurface = surface;
                mediaCodec.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            } else {
                Surface surface2 = new Surface(this.mDisplaySurface);
                this.mSurface = surface2;
                createDecoderByType.configure(createVideoFormat, surface2, (MediaCrypto) null, 0);
                VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ====== mRenderHandle == null");
            }
            this.mDecoder.start();
            this.mInputBuffers = this.mDecoder.getInputBuffers();
            synchronized (this.decoderHasInit) {
                if (!this.mDecoderInit) {
                    this.mDecoderInit = true;
                    this.decoderHasInit.notify();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.mDecoder = null;
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void decodeFrame() {
        int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.minfo, 50000);
        if (dequeueOutputBuffer >= 0) {
            renderFrame(dequeueOutputBuffer);
        } else if (dequeueOutputBuffer == -1) {
            handleDequeueTimeOut();
        }
    }

    private void renderFrame(int i) {
        if (this.mPlayStatus == 3) {
            this.mDecoder.releaseOutputBuffer(i, false);
        } else {
            long j = this.minfo.presentationTimeUs;
            RenderHandle renderHandle = this.mRenderHandle;
            if (renderHandle != null) {
                renderHandle.renderAvailableFrame(j);
            }
            OnRenderFrameInfoListener onRenderFrameInfoListener2 = this.onRenderFrameInfoListener;
            if (onRenderFrameInfoListener2 != null) {
                onRenderFrameInfoListener2.onRenderFrameTimestamp(j);
            }
            this.mDecoder.releaseOutputBuffer(i, true);
        }
        this.try_again_start_time = 0;
        this.isRenderLastFramed = false;
    }

    private void handleDequeueTimeOut() {
        if (this.resetStatus.get() != 1) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.try_again_start_time;
            if (j == 0) {
                this.try_again_start_time = currentTimeMillis;
                return;
            }
            long j2 = currentTimeMillis - j;
            if (j2 <= 5300 || j2 >= 5500) {
                if (j2 > 5700 && j2 < 6000) {
                    this.isRenderLastFramed = true;
                } else if (j2 >= 8000) {
                    VideoDecoderLogUtils.writeNecessaryLog("******* MediaCodec is offline. *******");
                    this.try_again_start_time = 0;
                    if (this.hasVideoStreamComeIn) {
                        VideoDecoderLogUtils.writeNecessaryLog("******* hasVideoStreamComeIn == true. *******");
                        throw new VideoDecoderException();
                    }
                }
            } else if (!this.isRenderLastFramed && this.mRenderHandle != null && !this.isCameraConnected) {
                this.mRenderHandle.renderLastFrame();
            }
        } else {
            this.try_again_start_time = 0;
        }
    }
}
