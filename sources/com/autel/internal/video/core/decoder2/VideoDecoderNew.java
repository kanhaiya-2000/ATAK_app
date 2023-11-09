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

public class VideoDecoderNew {
    /* access modifiers changed from: private */
    public static HandlerThread dataHandlerThread = new HandlerThread("frame data handler thread");
    private static MediaCodec mDecoder;
    /* access modifiers changed from: private */
    public static RenderHandleNew mRenderHandle = new RenderHandleNew();
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
    public final Object decoderHasInit = new Object();
    private final long dequeueTimeout = 50000;
    byte[] frame = new byte[1048576];
    private boolean hasVideoStreamComeIn;
    private int inIndex;
    StreamData inputFrame = new StreamData();
    private volatile boolean isCameraConnected;
    boolean isReadStreamDataNotReset;
    private boolean isRenderLastFramed;
    /* access modifiers changed from: private */
    public volatile boolean mDecoderInit = false;
    /* access modifiers changed from: private */
    public SurfaceTexture mDisplaySurface;
    private ByteBuffer mInputBuffer;
    private ByteBuffer[] mInputBuffers;
    /* access modifiers changed from: private */
    public volatile int mPlayStatus = 0;
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

    public VideoDecoderNew(SurfaceTexture surfaceTexture, int i, int i2, boolean z) {
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
        RenderHandleNew renderHandleNew = mRenderHandle;
        if (renderHandleNew != null) {
            renderHandleNew.setOverExpoBackground(i);
        }
    }

    public void setOverExpo(boolean z) {
        if (mRenderHandle != null) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = (z ? FilterType.OverExposure : FilterType.Normal).value();
            this.dataHandler.sendMessage(message);
        }
    }

    public boolean isOverExposureEnabled() {
        RenderHandleNew renderHandleNew = mRenderHandle;
        return renderHandleNew != null && renderHandleNew.getCurFilterType().equals(FilterType.OverExposure);
    }

    public void setSurfaceSize(int i, int i2) {
        this.curSurfaceWidth = i;
        this.curSurfaceHeight = i2;
        sendRenderSizeChangedMessage();
    }

    private void sendRenderSizeChangedMessage() {
        if (mRenderHandle != null) {
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

    private void startReadStreamDataHandler() {
        C49081 r0 = new Thread("read stream data thread") {
            public void run() {
                VideoDecoderNew.this.readStreamData();
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
                        if (!(mRenderHandle == null || streamData.getHeight() <= 0 || this.curFrameWidth * streamData.getHeight() == this.curFrameHeight * streamData.getWidth())) {
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
                        int dequeueInputBuffer = mDecoder.dequeueInputBuffer(50000);
                        this.inIndex = dequeueInputBuffer;
                        if (dequeueInputBuffer >= 0) {
                            ByteBuffer byteBuffer = this.mInputBuffers[dequeueInputBuffer];
                            this.mInputBuffer = byteBuffer;
                            byteBuffer.clear();
                            this.mInputBuffer.put(streamData.getFrameData());
                            mDecoder.queueInputBuffer(this.inIndex, 0, streamData.getSize(), streamData.getPts(), 0);
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
            stopCodec();
            if (mDecoder == null) {
                mDecoder = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(streamData.getSps(), 0, streamData.getSps_len()));
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(streamData.getPps(), 0, streamData.getPps_len()));
            if (this.useOpenGL) {
                SurfaceTexture surfaceTexture = null;
                while (surfaceTexture == null) {
                    surfaceTexture = mRenderHandle.getSurfaceTexture();
                }
                MediaCodec mediaCodec = mDecoder;
                Surface surface = new Surface(surfaceTexture);
                this.mSurface = surface;
                mediaCodec.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            } else {
                MediaCodec mediaCodec2 = mDecoder;
                Surface surface2 = new Surface(this.mDisplaySurface);
                this.mSurface = surface2;
                mediaCodec2.configure(createVideoFormat, surface2, (MediaCrypto) null, 0);
            }
            mDecoder.start();
            this.mInputBuffers = mDecoder.getInputBuffers();
            synchronized (this.decoderHasInit) {
                if (!this.mDecoderInit) {
                    this.mDecoderInit = true;
                    this.decoderHasInit.notify();
                }
            }
        } catch (Exception unused) {
            mDecoder = null;
        }
    }

    private void initIFrameDecoder(byte[] bArr, int i, byte[] bArr2, int i2) {
        try {
            stopCodec();
            if (mDecoder == null) {
                mDecoder = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr, 0, i));
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2, 0, i2));
            if (this.useOpenGL) {
                MediaCodec mediaCodec = mDecoder;
                Surface surface = new Surface(mRenderHandle.getSurfaceTexture());
                this.mSurface = surface;
                mediaCodec.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            } else {
                MediaCodec mediaCodec2 = mDecoder;
                Surface surface2 = new Surface(this.mDisplaySurface);
                this.mSurface = surface2;
                mediaCodec2.configure(createVideoFormat, surface2, (MediaCrypto) null, 0);
            }
            mDecoder.start();
            this.mInputBuffers = mDecoder.getInputBuffers();
            synchronized (this.decoderHasInit) {
                if (!this.mDecoderInit) {
                    this.mDecoderInit = true;
                    this.decoderHasInit.notify();
                }
            }
        } catch (Exception unused) {
            mDecoder = null;
        }
    }

    private void startDataHandler(final boolean z) {
        if (!dataHandlerThread.isAlive()) {
            dataHandlerThread.start();
        }
        this.dataHandler = new Handler(dataHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    try {
                        Log.e("performanceLog", " destroy mPlayStatus " + VideoDecoderNew.this.mPlayStatus);
                        while (VideoDecoderNew.this.mPlayStatus <= 1) {
                            synchronized (VideoDecoderNew.this.decoderHasInit) {
                                VideoDecoderNew.this.decoderHasInit.wait();
                                Log.e("performanceLog", " destroy wait 1 mPlayStatus " + VideoDecoderNew.this.mPlayStatus);
                                if (VideoDecoderNew.this.mPlayStatus == 1) {
                                    return;
                                }
                            }
                        }
                        if (z) {
                            VideoDecoderNew.this.startRenderHandle();
                            VideoDecoderNew videoDecoderNew = VideoDecoderNew.this;
                            videoDecoderNew.setSurfaceSize(videoDecoderNew.curSurfaceWidth, VideoDecoderNew.this.curSurfaceHeight);
                        }
                        while (!VideoDecoderNew.this.mDecoderInit) {
                            synchronized (VideoDecoderNew.this.decoderHasInit) {
                                if (!VideoDecoderNew.this.mDecoderInit) {
                                    VideoDecoderNew.this.decoderHasInit.wait();
                                }
                                Log.e("performanceLog", " destroy wait 1 mPlayStatus " + VideoDecoderNew.this.mPlayStatus);
                                if (VideoDecoderNew.this.mPlayStatus == 1) {
                                    return;
                                }
                            }
                        }
                        MediaCodec.BufferInfo unused = VideoDecoderNew.this.minfo = new MediaCodec.BufferInfo();
                        sendEmptyMessage(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (i == 1) {
                    while (VideoDecoderNew.this.mPlayStatus > 1 && !hasMessages(2)) {
                        try {
                            if (!hasMessages(3)) {
                                VideoDecoderNew.this.decodeFrame();
                            } else {
                                return;
                            }
                        } catch (Exception unused2) {
                            if (VideoDecoderNew.this.mPlayStatus > 1) {
                                VideoDecoderNew.this.resetStatus.set(1);
                                removeCallbacksAndMessages((Object) null);
                                sendEmptyMessageDelayed(4, 10);
                                return;
                            }
                            return;
                        }
                    }
                } else if (i == 2) {
                    VideoDecoderNew.mRenderHandle.setCurFilterType(FilterType.find(message.arg1));
                    sendEmptyMessage(1);
                } else if (i == 3) {
                    int[] iArr = (int[]) message.obj;
                    VideoDecoderNew.mRenderHandle.VideoWinSet(iArr[0], iArr[1], iArr[2], iArr[3]);
                    sendEmptyMessage(1);
                } else if (i == 4) {
                    VideoDecoderNew.this.resetCodec();
                }
            }
        };
        sendDataHandlerEmptyMessage(0);
    }

    public synchronized void stopDecode() {
        this.timeGap4ReadStream = 15;
        this.isReadStreamDataNotReset = true;
        setPlayStatus(1);
        this.mInputBuffer = null;
        this.onRenderFrameInfoListener = null;
        Handler handler = this.dataHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.dataHandler = null;
        }
        new Thread("VideoDecoder stop") {
            public void run() {
                do {
                } while (VideoDecoderNew.this.readStreamThread.isAlive());
                VideoDecoderNew.this.stopCodec();
                VideoDecoderNew.this.stopImageHandle();
                boolean unused = VideoDecoderNew.this.mDecoderInit = false;
                if (VideoDecoderNew.this.mDisplaySurface != null) {
                    try {
                        VideoDecoderNew.this.mDisplaySurface.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                SurfaceTexture unused2 = VideoDecoderNew.this.mDisplaySurface = null;
            }
        }.start();
    }

    public synchronized void destroy() {
        VideoDecoderLogUtils.writeNecessaryLog("====== destroy() ======", false, true);
        this.timeGap4ReadStream = 15;
        this.isReadStreamDataNotReset = true;
        this.mDecoderInit = false;
        setPlayStatus(1);
        this.mInputBuffer = null;
        this.onRenderFrameInfoListener = null;
        new Thread("VideoDecoder destroy") {
            public void run() {
                HandlerThreadUtils.cancelHandlerThread(VideoDecoderNew.dataHandlerThread, VideoDecoderNew.this.dataHandler);
                while (true) {
                    if (!VideoDecoderNew.this.readStreamThread.isAlive() && !VideoDecoderNew.dataHandlerThread.isAlive()) {
                        break;
                    }
                }
                VideoDecoderNew.this.releaseImageHandle();
                VideoDecoderNew.this.releaseCodec();
                if (VideoDecoderNew.this.mDisplaySurface != null) {
                    try {
                        VideoDecoderNew.this.mDisplaySurface.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                SurfaceTexture unused = VideoDecoderNew.this.mDisplaySurface = null;
            }
        }.start();
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
    public void stopImageHandle() {
        RenderHandleNew renderHandleNew = mRenderHandle;
        if (renderHandleNew != null) {
            renderHandleNew.stop();
        }
    }

    /* access modifiers changed from: private */
    public void releaseImageHandle() {
        RenderHandleNew renderHandleNew = mRenderHandle;
        if (renderHandleNew != null) {
            renderHandleNew.release();
        }
        mRenderHandle = null;
    }

    /* access modifiers changed from: private */
    public void startRenderHandle() {
        SurfaceTexture surfaceTexture = this.mDisplaySurface;
        if (surfaceTexture != null) {
            mRenderHandle.start(surfaceTexture, false);
        }
    }

    /* access modifiers changed from: private */
    public void stopCodec() {
        MediaCodec mediaCodec = mDecoder;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    /* access modifiers changed from: private */
    public void releaseCodec() {
        MediaCodec mediaCodec = mDecoder;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                mDecoder.release();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                mDecoder = null;
                throw th;
            }
            mDecoder = null;
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
        stopCodec();
        try {
            if (mDecoder == null) {
                mDecoder = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("flags", 2);
            if (Build.VERSION.SDK_INT < 21) {
                createVideoFormat.setInteger("color-format", 21);
            }
            if (this.useOpenGL) {
                SurfaceTexture surfaceTexture = null;
                while (surfaceTexture == null) {
                    surfaceTexture = mRenderHandle.getSurfaceTexture();
                }
                VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ======mRenderHandle != null ");
                MediaCodec mediaCodec = mDecoder;
                Surface surface = new Surface(surfaceTexture);
                this.mSurface = surface;
                mediaCodec.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            } else {
                MediaCodec mediaCodec2 = mDecoder;
                Surface surface2 = new Surface(this.mDisplaySurface);
                this.mSurface = surface2;
                mediaCodec2.configure(createVideoFormat, surface2, (MediaCrypto) null, 0);
                VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ====== mRenderHandle == null");
            }
            mDecoder.start();
            this.mInputBuffers = mDecoder.getInputBuffers();
            synchronized (this.decoderHasInit) {
                if (!this.mDecoderInit) {
                    this.mDecoderInit = true;
                    this.decoderHasInit.notify();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            mDecoder = null;
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void decodeFrame() {
        int dequeueOutputBuffer = mDecoder.dequeueOutputBuffer(this.minfo, 50000);
        if (dequeueOutputBuffer >= 0) {
            renderFrame(dequeueOutputBuffer);
        } else if (dequeueOutputBuffer == -1) {
            handleDequeueTimeOut();
        }
    }

    private void renderFrame(int i) {
        if (this.mPlayStatus == 3) {
            mDecoder.releaseOutputBuffer(i, false);
        } else {
            long j = this.minfo.presentationTimeUs;
            RenderHandleNew renderHandleNew = mRenderHandle;
            if (renderHandleNew != null) {
                renderHandleNew.renderAvailableFrame(j);
            }
            OnRenderFrameInfoListener onRenderFrameInfoListener2 = this.onRenderFrameInfoListener;
            if (onRenderFrameInfoListener2 != null) {
                onRenderFrameInfoListener2.onRenderFrameTimestamp(j);
            }
            mDecoder.releaseOutputBuffer(i, true);
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
            } else if (!this.isRenderLastFramed && mRenderHandle != null && !this.isCameraConnected) {
                mRenderHandle.renderLastFrame();
            }
        } else {
            this.try_again_start_time = 0;
        }
    }
}
