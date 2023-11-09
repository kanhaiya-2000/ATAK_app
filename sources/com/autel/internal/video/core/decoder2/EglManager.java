package com.autel.internal.video.core.decoder2;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.autel.internal.video.core.decoder2.common.EglEnvNew;
import com.autel.internal.video.core.decoder2.common.FilterType;
import com.autel.internal.video.core.decoder2.render.BlackAndWhiteFilterRenderer;
import com.autel.internal.video.core.decoder2.render.GLRendererBase;
import com.autel.internal.video.core.decoder2.render.NormalRenderer;
import com.autel.internal.video.core.decoder2.render.OverExposureFilterRenderer;
import com.autel.internal.video.core.decoder2.utils.GLUtil;
import com.autel.internal.video.core.decoder2.utils.RenderSizeUtils;
import com.autel.sdk.C4926R;
import com.autel.util.log.AutelLog;

public class EglManager {
    private final int MSG_DECODE_FRAME = 1;
    private final int MSG_INIT_RENDER = 0;
    private final int MSG_STOP_RENDER = 5;
    private final int MSG_UPDATE_FILTER_RENDER = 2;
    private final int MSG_UPDATE_SIZE_RENDER = 3;
    private final int PLAYER_DESTROY = 1;
    private final int PLAYER_PAUSE = 3;
    private final int PLAYER_RESTART = -1;
    private final int PLAYER_START = 2;
    private final int PLAYER_STOP = 0;
    private boolean beginRender;
    private FilterType curFilterType = FilterType.UNKNOWN;
    /* access modifiers changed from: private */
    public long curPts;
    private Handler dataHandler;
    /* access modifiers changed from: private */
    public volatile boolean decoding;
    long delay_time = 0;
    private HandlerThread eglRenderThread;
    private boolean hasInit;
    private boolean hasRenderLast = false;
    private GLRendererBase lastFrameRenderer;
    /* access modifiers changed from: private */
    public CodecManager mCodecManager;
    private EglEnvNew mEglEnvNew;

    /* renamed from: mH */
    private int f8491mH;
    private int mImageId = C4926R.drawable.expo1280;
    private volatile boolean mOverExpoEnable;
    /* access modifiers changed from: private */
    public volatile int mPlayStatus = 0;
    private long mPtsBase = -1;
    private float[] mSTMatrix = new float[16];
    private SurfaceTexture mTexture;
    private int mTextureID;
    private long mTimeBase = -1;
    private volatile SurfaceTexture mUISurface;
    private GLRendererBase mVideoRenderer;

    /* renamed from: mW */
    private int f8492mW;

    /* renamed from: mX */
    private int f8493mX;

    /* renamed from: mY */
    private int f8494mY;
    /* access modifiers changed from: private */
    public boolean renderInit;
    /* access modifiers changed from: private */
    public final Object statusLock = new int[0];
    protected boolean useOpenGl;

    public EglManager(CodecManager codecManager) {
        this.mCodecManager = codecManager;
        HandlerThread handlerThread = this.eglRenderThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread("egl render thread");
            this.eglRenderThread = handlerThread2;
            handlerThread2.start();
            this.dataHandler = new MyHandler(this.eglRenderThread.getLooper());
        }
    }

    public void initEgl(boolean z) {
        this.useOpenGl = z;
        if (!z) {
            this.beginRender = false;
        } else if (this.mEglEnvNew == null) {
            EglEnvNew eglEnvNew = new EglEnvNew();
            this.mEglEnvNew = eglEnvNew;
            eglEnvNew.initEgl();
        }
        this.hasInit = true;
    }

    public void startRender(SurfaceTexture surfaceTexture) {
        synchronized (this.statusLock) {
            this.mUISurface = surfaceTexture;
            if (this.mPlayStatus > 1) {
                this.mPlayStatus = -1;
            } else {
                initRender();
            }
        }
    }

    /* access modifiers changed from: private */
    public void initRender() {
        this.renderInit = false;
        this.mPlayStatus = 2;
        this.dataHandler.sendEmptyMessage(0);
    }

    /* access modifiers changed from: private */
    public void startRender() {
        if (this.hasInit) {
            if (this.useOpenGl) {
                while (!this.beginRender) {
                    this.mEglEnvNew.resumeSurface(this.mUISurface);
                    this.mTextureID = GLUtil.textureGen(36197, true);
                    this.mTexture = new SurfaceTexture(this.mTextureID);
                    if (this.mOverExpoEnable) {
                        if (!(this.mVideoRenderer instanceof OverExposureFilterRenderer)) {
                            this.mVideoRenderer = new OverExposureFilterRenderer(this.mImageId);
                        }
                    } else if (!(this.mVideoRenderer instanceof NormalRenderer)) {
                        this.mVideoRenderer = new NormalRenderer();
                    }
                    this.beginRender = true;
                }
            }
            if (!this.eglRenderThread.isAlive()) {
                this.eglRenderThread.start();
            }
            if (!this.mCodecManager.allowEglRender()) {
                Log.v("videoDecodeBug", "startRender not allowed");
                return;
            }
            Log.v("videoDecodeBug", "startRender allowed");
            if (!this.dataHandler.hasMessages(0)) {
                Log.v("videoDecodeBug", "startRender mOverExpoEnable " + this.mOverExpoEnable + " mVideoRenderer " + this.mVideoRenderer);
                this.dataHandler.sendEmptyMessage(1);
            }
        }
    }

    public void stopRender() {
        synchronized (this.statusLock) {
            if (this.mPlayStatus > 1 || this.mPlayStatus == -1) {
                this.mPlayStatus = 0;
                this.mUISurface = null;
                this.dataHandler.removeCallbacksAndMessages((Object) null);
                this.dataHandler.sendEmptyMessage(5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handStopRender() {
        if (this.hasInit) {
            GLUtil.deleteTexture(this.mTextureID);
            this.mTextureID = -1;
            EglEnvNew eglEnvNew = this.mEglEnvNew;
            if (eglEnvNew != null) {
                eglEnvNew.stopSurface();
            }
            SurfaceTexture surfaceTexture = this.mTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mTexture = null;
            }
            this.beginRender = false;
        }
    }

    public void renderSizeChanged(int i, int i2, int i3, int i4) {
        int[] renderSize = RenderSizeUtils.getRenderSize(i, i2, i3, i4);
        updateWindowSize(renderSize[0], renderSize[1], renderSize[2], renderSize[3]);
    }

    private void updateWindowSize(int i, int i2, int i3, int i4) {
        this.f8493mX = i;
        this.f8494mY = i2;
        this.f8492mW = i3;
        this.f8491mH = i4;
    }

    public void setOverExpo(boolean z, int i) {
        this.mOverExpoEnable = z;
        Message message = new Message();
        message.what = 2;
        message.arg1 = (this.mOverExpoEnable ? FilterType.OverExposure : FilterType.Normal).value();
        this.mImageId = i;
        this.dataHandler.sendMessage(message);
    }

    public void resumeRender() {
        synchronized (this.statusLock) {
            if (this.mPlayStatus == 3) {
                this.mPlayStatus = 2;
            }
        }
    }

    public void pauseRender() {
        synchronized (this.statusLock) {
            if (this.mPlayStatus > 1) {
                this.mPlayStatus = 3;
            }
        }
    }

    public void destroy() {
        this.hasInit = false;
        synchronized (this.statusLock) {
            this.mPlayStatus = 1;
        }
        int i = this.mTextureID;
        if (i != -1) {
            GLUtil.deleteTexture(i);
            this.mTextureID = -1;
        }
        GLRendererBase gLRendererBase = this.mVideoRenderer;
        if (gLRendererBase != null) {
            gLRendererBase.release();
            this.mVideoRenderer = null;
        }
        EglEnvNew eglEnvNew = this.mEglEnvNew;
        if (eglEnvNew != null) {
            eglEnvNew.release();
            this.mEglEnvNew = null;
        }
        SurfaceTexture surfaceTexture = this.mTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mTexture = null;
        }
        this.dataHandler.removeCallbacksAndMessages((Object) null);
        this.eglRenderThread.quit();
    }

    /* access modifiers changed from: private */
    public void renderLastFrame() {
        if (this.beginRender && !this.hasRenderLast) {
            this.mTexture.getTransformMatrix(this.mSTMatrix);
            if (this.lastFrameRenderer == null) {
                this.lastFrameRenderer = new BlackAndWhiteFilterRenderer();
            }
            this.lastFrameRenderer.renderDraw(this.f8493mX, this.f8494mY, this.f8492mW, this.f8491mH, 0.0f, this.mSTMatrix, this.mTextureID);
            this.mEglEnvNew.eglFlush();
            this.hasRenderLast = true;
        }
    }

    /* access modifiers changed from: private */
    public void renderAvailableFrame(long j) {
        if (this.beginRender) {
            this.mTexture.updateTexImage();
            this.mTexture.getTransformMatrix(this.mSTMatrix);
            this.mVideoRenderer.renderDraw(this.f8493mX, this.f8494mY, this.f8492mW, this.f8491mH, 0.0f, this.mSTMatrix, this.mTextureID);
            waitToDisplay(j);
            this.mEglEnvNew.eglFlush();
        }
        this.hasRenderLast = false;
    }

    private void waitToDisplay(long j) {
        long j2 = this.mPtsBase;
        if (j2 == -1 || j2 > j) {
            this.mPtsBase = j;
            this.mTimeBase = System.currentTimeMillis();
        }
        long currentTimeMillis = (((j - this.mPtsBase) / 90) + this.mTimeBase) - System.currentTimeMillis();
        int i = (currentTimeMillis > 0 ? 1 : (currentTimeMillis == 0 ? 0 : -1));
        if (i > 0 && currentTimeMillis <= 30) {
            SystemClock.sleep(currentTimeMillis);
        } else if (i < 0 || currentTimeMillis > 30) {
            this.mPtsBase = j;
            this.mTimeBase = System.currentTimeMillis();
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        if (this.beginRender) {
            return this.mTexture;
        }
        return null;
    }

    /* renamed from: com.autel.internal.video.core.decoder2.EglManager$1 */
    /* synthetic */ class C49021 {

        /* renamed from: $SwitchMap$com$autel$internal$video$core$decoder2$common$FilterType */
        static final /* synthetic */ int[] f8495xea4520ea;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.autel.internal.video.core.decoder2.common.FilterType[] r0 = com.autel.internal.video.core.decoder2.common.FilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8495xea4520ea = r0
                com.autel.internal.video.core.decoder2.common.FilterType r1 = com.autel.internal.video.core.decoder2.common.FilterType.OverExposure     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8495xea4520ea     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.video.core.decoder2.common.FilterType r1 = com.autel.internal.video.core.decoder2.common.FilterType.BlackAndWhite     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.video.core.decoder2.EglManager.C49021.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void setCurFilterType(FilterType filterType) {
        this.curFilterType = filterType;
        int i = C49021.f8495xea4520ea[filterType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (!(this.mVideoRenderer instanceof NormalRenderer)) {
                    this.mVideoRenderer = new NormalRenderer();
                }
            } else if (!(this.mVideoRenderer instanceof BlackAndWhiteFilterRenderer)) {
                this.mVideoRenderer = new BlackAndWhiteFilterRenderer();
            }
        } else if (!(this.mVideoRenderer instanceof OverExposureFilterRenderer)) {
            this.mVideoRenderer = new OverExposureFilterRenderer(this.mImageId);
        }
    }

    public boolean isOverExposureEnabled() {
        return FilterType.OverExposure == this.curFilterType;
    }

    private class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                EglManager.this.startRender();
                boolean unused = EglManager.this.renderInit = true;
            } else if (i == 1) {
                if (EglManager.this.mPlayStatus > 1) {
                    boolean unused2 = EglManager.this.decoding = true;
                }
                while (EglManager.this.mPlayStatus > 1 && !hasMessages(2)) {
                    long decodeFrame = EglManager.this.mCodecManager.decodeFrame();
                    if (decodeFrame > 0) {
                        if (EglManager.this.curPts != decodeFrame) {
                            long unused3 = EglManager.this.curPts = decodeFrame;
                            if (EglManager.this.mPlayStatus != 3) {
                                EglManager.this.renderAvailableFrame(decodeFrame);
                            }
                            EglManager.this.mCodecManager.onRenderFrameTimestamp(decodeFrame);
                        }
                    } else if (decodeFrame == -2) {
                        AutelLog.debug_i("videoDecodeBug", "renderLastFrame last last last");
                        EglManager.this.renderLastFrame();
                    } else if (decodeFrame == -3) {
                        AutelLog.debug_i("videoDecodeBug", "decode MSG_RESET_CODEC pts-> " + decodeFrame);
                        try {
                            EglManager.this.mCodecManager.resetCodec();
                        } catch (Exception e) {
                            e.printStackTrace();
                            AutelLog.debug_i("codec_reset", "reset exception " + e.getMessage());
                        }
                    }
                }
                synchronized (EglManager.this.statusLock) {
                    if (EglManager.this.mPlayStatus == -1) {
                        EglManager.this.initRender();
                    } else {
                        boolean unused4 = EglManager.this.decoding = false;
                    }
                }
            } else if (i != 2) {
                if (i == 5) {
                    EglManager.this.handStopRender();
                }
            } else if (!hasMessages(1) && EglManager.this.renderInit) {
                EglManager.this.setCurFilterType(FilterType.find(message.arg1));
                sendEmptyMessage(1);
            }
        }
    }

    public boolean isDecoding() {
        return this.decoding;
    }
}
