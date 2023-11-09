package com.autel.internal.video.core.decoder2;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import atakplugin.UASTool.bfu;
import com.autel.common.video.OnRenderFrameInfoListener;
import com.autel.internal.video.core.decoder2.common.StreamData;
import com.autel.internal.video.core.decoder2.common.VideoDefaultParams;
import com.autel.internal.video.core.decoder2.common.VideoStreamReadListener;
import com.autel.internal.video.core.decoder2.utils.VideoDecoderLogUtils;
import com.autel.util.log.AutelLog;
import com.autel.video.NetWorkProxyJni;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class CodecManager {
    private final long INFO_TRY_AGAIN_LATER = -1;
    private final long LAST_FRAME_RENDER = -2;
    private final long OUTPUT_ERROR = -3;
    private final int PLAYER_DESTROY = 1;
    private final int PLAYER_PAUSE = 3;
    private final int PLAYER_RESTART = -1;
    private final int PLAYER_START = 2;
    private final int PLAYER_STOP = 0;
    private final int RESET_DECODE = 3;
    private final int ReadStreamFailed = 1500;
    private final int ReadStreamSuccess = 15;
    private final int START_DECODE = 1;
    private final int STOP_DECODE = 2;
    private final AtomicBoolean allowEgl = new AtomicBoolean(false);
    private CodecHandler codecHandler;
    private HandlerThread codecThread;
    private int curFrameHeight = VideoDefaultParams.mFormatHeight;
    private int curFrameWidth = VideoDefaultParams.mFormatWidth;
    private byte[] curPpsData;
    private int curPpsLen;
    private byte[] curSpsData;
    private int curSpsLen;
    private int curSurfaceHeight;
    private int curSurfaceWidth;
    private final long dequeueTimeout = 50000;
    byte[] frame = new byte[1048576];
    private boolean hasVideoStreamComeIn;
    private long iFramReadStamp = 0;
    private int inIndex;
    StreamData inputFrame = new StreamData();
    public volatile boolean isCameraConnected;
    boolean isReadStreamDataNotReset;
    private boolean isRenderLastFramed;
    EglManager mEglManager = new EglManager(this);
    MediaCodec.BufferInfo mInfo = new MediaCodec.BufferInfo();
    private ByteBuffer mInputBuffer;
    private ByteBuffer[] mInputBuffers;
    MediaCodec mMediaCodec;
    private volatile boolean mMediaCodecInit;
    /* access modifiers changed from: private */
    public volatile int mPlayStatus = 0;
    long mStreamHandle = 0;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private volatile boolean msg_done = true;
    private volatile boolean notResetting = true;
    private OnRenderFrameInfoListener onRenderFrameInfoListener;
    int outIndex;
    final long readGap = 15000000;
    private int readStreamFailedTimes = 0;
    private int readStreamId;
    private int read_timeout_cnt = 0;
    private volatile boolean resetLocked;
    private byte[] sps_pps_Buf = new byte[2100];
    /* access modifiers changed from: private */
    public final Object statusLock = new int[0];
    private int timeGap4ReadStream = 15;
    private long try_again_start_time = 0;
    private boolean useOpenGL;
    private VideoStreamReadListener videoStreamReadListener;
    private int waitIframeCount = 0;

    public static class CodecManagerHolder {
        public static CodecManager mCodecManager = new CodecManager();
    }

    public static CodecManager getInstance() {
        return CodecManagerHolder.mCodecManager;
    }

    protected CodecManager() {
    }

    public void initCodec() {
        HandlerThread handlerThread = this.codecThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread("media codec thread");
            this.codecThread = handlerThread2;
            handlerThread2.start();
            this.codecHandler = new CodecHandler(this.codecThread.getLooper());
        }
    }

    public void startDecode(SurfaceTexture surfaceTexture, int i, int i2, boolean z) {
        AutelLog.debug_i("videoDecodeBug", "startDecode ++++++ ");
        this.curSurfaceWidth = i;
        this.curSurfaceHeight = i2;
        this.mSurfaceTexture = surfaceTexture;
        this.isRenderLastFramed = false;
        this.useOpenGL = z;
        synchronized (this.statusLock) {
            if (this.mPlayStatus > 1) {
                this.mPlayStatus = -1;
            }
        }
        if (this.mPlayStatus != -1) {
            this.codecHandler.sendEmptyMessage(1);
        }
    }

    public void stopCodec() {
        AutelLog.debug_i("videoDecodeBug", "stopCodec ++++++ ");
        synchronized (this.statusLock) {
            this.mPlayStatus = 0;
            this.mSurfaceTexture = null;
            this.codecHandler.removeCallbacksAndMessages((Object) null);
            synchronized (this.allowEgl) {
                this.allowEgl.set(false);
                this.allowEgl.notify();
            }
            this.codecHandler.sendEmptyMessage(2);
        }
    }

    public void destroyCodec() {
        this.codecThread.quit();
        this.mPlayStatus = 1;
        stopCodecInternal();
        EglManager eglManager = this.mEglManager;
        if (eglManager != null) {
            eglManager.destroy();
        }
    }

    public void setOverExpo(boolean z, int i) {
        Log.v("videoDecodeBug", "setOverExpo ");
        EglManager eglManager = this.mEglManager;
        if (eglManager != null) {
            eglManager.setOverExpo(z, i);
        }
    }

    public boolean isOverExposureEnabled() {
        EglManager eglManager = this.mEglManager;
        return eglManager != null && eglManager.isOverExposureEnabled();
    }

    public void resumeRender() {
        Log.v("videoDecodeBug", "resumeRender ");
        EglManager eglManager = this.mEglManager;
        if (eglManager != null) {
            eglManager.resumeRender();
        }
    }

    public void pauseRender() {
        Log.v("videoDecodeBug", "pauseRender ");
        EglManager eglManager = this.mEglManager;
        if (eglManager != null) {
            eglManager.pauseRender();
        }
    }

    public boolean allowEglRender() {
        if (this.mMediaCodecInit) {
            return true;
        }
        synchronized (this.allowEgl) {
            if (!this.allowEgl.get()) {
                try {
                    this.allowEgl.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.allowEgl.get();
    }

    public void surfaceSizeChanged(int i, int i2) {
        this.curSurfaceWidth = i;
        this.curSurfaceHeight = i2;
        EglManager eglManager = this.mEglManager;
        if (eglManager != null) {
            eglManager.renderSizeChanged(this.curFrameWidth, this.curFrameHeight, i, i2);
        }
    }

    private MediaCodec getMediaCodec() {
        if (this.mMediaCodec == null) {
            try {
                this.mMediaCodec = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.mMediaCodec;
    }

    public long decodeFrame() {
        MediaCodec mediaCodec;
        if (!this.mMediaCodecInit) {
            return -1;
        }
        while (true) {
            mediaCodec = this.mMediaCodec;
            if (mediaCodec == null) {
                this.mMediaCodec = getMediaCodec();
            } else {
                try {
                    break;
                } catch (Exception unused) {
                    return -3;
                }
            }
        }
        this.outIndex = mediaCodec.dequeueOutputBuffer(this.mInfo, 50000);
        long j = this.mInfo.presentationTimeUs;
        if (this.outIndex == -1) {
            long handleDequeueTimeOut = handleDequeueTimeOut();
            AutelLog.debug_i("videoDecodeBug", "handleDequeueTimeOut " + handleDequeueTimeOut);
            return handleDequeueTimeOut;
        }
        this.try_again_start_time = System.currentTimeMillis();
        this.isRenderLastFramed = false;
        return j;
    }

    public void releaseOutput() {
        if (this.outIndex >= 0 && this.mMediaCodecInit) {
            try {
                this.mMediaCodec.releaseOutputBuffer(this.outIndex, true);
            } catch (Exception e) {
                AutelLog.debug_i("codec_reset", "releaseOutput exception " + e.getMessage());
            }
        }
    }

    private long handleDequeueTimeOut() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.try_again_start_time;
        if (j == 0) {
            this.try_again_start_time = currentTimeMillis;
            return -1;
        }
        long j2 = currentTimeMillis - j;
        if (j2 <= 5300 || j2 >= 5700) {
            if (j2 > 5700 && j2 < 6000) {
                this.isRenderLastFramed = true;
                return -1;
            } else if (j2 < 8000) {
                return -1;
            } else {
                VideoDecoderLogUtils.writeNecessaryLog("******* MediaCodec is offline. *******");
                this.try_again_start_time = 0;
                if (!this.hasVideoStreamComeIn) {
                    return -1;
                }
                VideoDecoderLogUtils.writeNecessaryLog("******* hasVideoStreamComeIn == true. *******");
                return -3;
            }
        } else if (!this.isRenderLastFramed) {
            return -2;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public void readStreamData() {
        this.iFramReadStamp = System.currentTimeMillis();
        while (this.mPlayStatus > 1) {
            this.read_timeout_cnt = 0;
            this.isReadStreamDataNotReset = true;
            while (this.mStreamHandle == 0) {
                this.mStreamHandle = NetWorkProxyJni.OpenStream();
            }
            AutelLog.debug_i("videoDecodeBug", "OpenStream " + this.mStreamHandle);
            while (this.mPlayStatus > 1 && this.isReadStreamDataNotReset) {
                long nanoTime = System.nanoTime();
                if (this.notResetting) {
                    this.resetLocked = false;
                    inputBuffer(this.frame, this.inputFrame);
                } else {
                    this.resetLocked = true;
                }
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
            AutelLog.debug_i("videoDecodeBug", "CloseStream " + this.mStreamHandle + "  mPlayStatus  " + this.mPlayStatus + "  isReadStreamDataNotReset  " + this.isReadStreamDataNotReset);
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
        int ReadStream = NetWorkProxyJni.ReadStream(this.mStreamHandle, bArr, bArr.length, this.timeGap4ReadStream);
        this.readStreamId = ReadStream;
        if (ReadStream > 0) {
            try {
                streamData.parseData(bArr);
                if (!this.mMediaCodecInit && streamData.isIframe()) {
                    initIFrameDecoder(streamData);
                    if (!this.mMediaCodecInit) {
                        this.isReadStreamDataNotReset = false;
                        VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder failed to reset ======");
                    }
                }
                if (System.currentTimeMillis() - this.iFramReadStamp > 4000) {
                    this.iFramReadStamp = bfu.f2629b;
                    AutelLog.debug_i("VIDEODECODERLOG", "********** ForceKeyFrame *********** " + this.iFramReadStamp);
                    NetWorkProxyJni.ForceKeyFrame(0);
                }
                if (this.mMediaCodecInit) {
                    VideoStreamReadListener videoStreamReadListener2 = this.videoStreamReadListener;
                    if (videoStreamReadListener2 != null) {
                        videoStreamReadListener2.onDataRecv(streamData);
                    }
                    if (streamData.getHeight() > 0 && !(this.curFrameWidth == streamData.getWidth() && this.curFrameHeight == streamData.getHeight())) {
                        this.curFrameWidth = streamData.getWidth();
                        this.curFrameHeight = streamData.getHeight();
                        Log.v("RenderFrameSizeChanged", "onRenderFrameSizeChanged width " + this.curFrameWidth + " height:" + this.curFrameHeight);
                        EglManager eglManager = this.mEglManager;
                        if (eglManager != null) {
                            eglManager.renderSizeChanged(this.curFrameWidth, this.curFrameHeight, this.curSurfaceWidth, this.curSurfaceHeight);
                        }
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
                    int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(50000);
                    this.inIndex = dequeueInputBuffer;
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer byteBuffer = this.mInputBuffers[dequeueInputBuffer];
                        this.mInputBuffer = byteBuffer;
                        byteBuffer.clear();
                        this.mInputBuffer.put(streamData.getFrameData());
                        this.mMediaCodec.queueInputBuffer(this.inIndex, 0, streamData.getSize(), streamData.getPts(), 0);
                    } else {
                        AutelLog.debug_i("videoDecodeBug", "mMediaCodec reset 1111====== ");
                        resetCodecInternal();
                        NetWorkProxyJni.ForceKeyFrame(0);
                    }
                    this.timeGap4ReadStream = 15;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            int i = this.read_timeout_cnt + 1;
            this.read_timeout_cnt = i;
            int i2 = this.timeGap4ReadStream;
            if (i2 == 15) {
                if (i % 15 == 0) {
                    this.isReadStreamDataNotReset = false;
                    this.timeGap4ReadStream = 1500;
                    this.readStreamFailedTimes = 0;
                }
            } else if (i2 == 1500) {
                this.isReadStreamDataNotReset = false;
                int i3 = this.readStreamFailedTimes + 1;
                this.readStreamFailedTimes = i3;
                if (i3 > 3) {
                    this.hasVideoStreamComeIn = false;
                    VideoDecoderLogUtils.writeNecessaryLog("******* No video stream data.*******");
                }
            }
        }
    }

    private boolean checkoutSps() {
        for (int i = 0; i < this.inputFrame.getSps().length; i++) {
            if (this.curSpsData[i] != this.inputFrame.getSps()[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkoutPps() {
        for (int i = 0; i < this.inputFrame.getPps().length; i++) {
            if (this.curPpsData[i] != this.inputFrame.getPps()[i]) {
                return false;
            }
        }
        return true;
    }

    private void initIFrameDecoder(StreamData streamData) {
        VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ======");
        stopCodecInternal();
        Log.v("videoDecodeBug", "stopCodecInternal ");
        while (this.mMediaCodec == null) {
            this.mMediaCodec = getMediaCodec();
        }
        Log.v("videoDecodeBug", "getMediaCodec ");
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
        this.curSpsLen = streamData.getSps_len();
        this.curPpsLen = streamData.getPps_len();
        this.curPpsData = streamData.getPps();
        this.curSpsData = streamData.getSps();
        createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(streamData.getSps(), 0, streamData.getSps_len()));
        createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(streamData.getPps(), 0, streamData.getPps_len()));
        configureMediaCodec(createVideoFormat);
        this.mMediaCodec.start();
        this.mInputBuffers = this.mMediaCodec.getInputBuffers();
        this.mMediaCodecInit = true;
        synchronized (this.allowEgl) {
            if (this.allowEgl.compareAndSet(false, true)) {
                this.allowEgl.notify();
            }
        }
        AutelLog.debug_i("videoDecodeBug", "initIFrameDecoder " + this.mMediaCodecInit);
    }

    public void setOnRenderFrameInfoListener(OnRenderFrameInfoListener onRenderFrameInfoListener2) {
        this.onRenderFrameInfoListener = onRenderFrameInfoListener2;
        if (onRenderFrameInfoListener2 != null) {
            onRenderFrameInfoListener2.onRenderFrameSizeChanged(this.curFrameWidth, this.curFrameHeight);
        }
    }

    public void setVideoStreamReadListener(VideoStreamReadListener videoStreamReadListener2) {
        this.videoStreamReadListener = videoStreamReadListener2;
        if (videoStreamReadListener2 != null) {
            videoStreamReadListener2.onDataRecv(this.inputFrame);
        }
    }

    /* access modifiers changed from: private */
    public void stopCodecInternal() {
        this.mMediaCodecInit = false;
        MediaCodec mediaCodec = this.mMediaCodec;
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

    public void resetCodec() {
        this.notResetting = false;
        do {
        } while (!this.resetLocked);
        resetCodecInternal();
        this.notResetting = true;
        this.resetLocked = false;
    }

    private void resetCodecInternal() {
        stopCodecInternal();
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.release();
        }
        this.mMediaCodec = null;
        while (this.mMediaCodec == null) {
            this.mMediaCodec = getMediaCodec();
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
        createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.inputFrame.getSps(), 0, this.inputFrame.getSps_len()));
        createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(this.inputFrame.getPps(), 0, this.inputFrame.getPps_len()));
        configureMediaCodec(createVideoFormat);
        this.mMediaCodec.start();
        this.mInputBuffers = this.mMediaCodec.getInputBuffers();
    }

    private void configureMediaCodec(MediaFormat mediaFormat) {
        Log.v("videoDecodeBug", "getSurfaceTexture before useOpenGL " + this.useOpenGL);
        if (this.useOpenGL) {
            SurfaceTexture surfaceTexture = null;
            while (surfaceTexture == null) {
                surfaceTexture = this.mEglManager.getSurfaceTexture();
            }
            Log.v("videoDecodeBug", "getSurfaceTexture after ");
            VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ======mRenderHandle != null ");
            MediaCodec mediaCodec = this.mMediaCodec;
            Surface surface = new Surface(surfaceTexture);
            this.mSurface = surface;
            mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            return;
        }
        MediaCodec mediaCodec2 = this.mMediaCodec;
        Surface surface2 = new Surface(this.mSurfaceTexture);
        this.mSurface = surface2;
        mediaCodec2.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
        VideoDecoderLogUtils.writeNecessaryLog("====== initIFrameDecoder() ====== mRenderHandle == null");
    }

    public void onRenderFrameTimestamp(long j) {
        OnRenderFrameInfoListener onRenderFrameInfoListener2 = this.onRenderFrameInfoListener;
        if (onRenderFrameInfoListener2 != null) {
            onRenderFrameInfoListener2.onRenderFrameTimestamp(j);
        }
        releaseOutput();
    }

    /* access modifiers changed from: private */
    public void startEgl() {
        this.mEglManager.initEgl(this.useOpenGL);
        this.mEglManager.startRender(this.mSurfaceTexture);
        this.mEglManager.renderSizeChanged(this.curFrameWidth, this.curFrameHeight, this.curSurfaceWidth, this.curSurfaceHeight);
    }

    public class CodecHandler extends Handler {
        public CodecHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                synchronized (CodecManager.this.statusLock) {
                    int unused = CodecManager.this.mPlayStatus = 2;
                }
                CodecManager.this.startEgl();
                CodecManager.this.readStreamData();
                synchronized (CodecManager.this.statusLock) {
                    if (CodecManager.this.mPlayStatus == -1) {
                        sendEmptyMessage(1);
                    }
                }
            } else if (i == 2) {
                if (CodecManager.this.mEglManager != null) {
                    CodecManager.this.mEglManager.stopRender();
                    do {
                    } while (CodecManager.this.mEglManager.isDecoding());
                }
                CodecManager.this.stopCodecInternal();
            }
        }
    }

    private void sendCodecMsg(int i) {
        this.codecHandler.removeCallbacksAndMessages((Object) null);
        this.codecHandler.sendEmptyMessage(i);
    }

    public int getPlayStatus() {
        return this.mPlayStatus;
    }

    public boolean getElgAllow() {
        return this.allowEgl.get();
    }
}
