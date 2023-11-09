package com.autel.internal.video.core.decoder2;

import android.graphics.SurfaceTexture;
import com.autel.internal.video.core.decoder2.common.EglEnvNew;
import com.autel.internal.video.core.decoder2.common.FilterType;
import com.autel.internal.video.core.decoder2.render.BlackAndWhiteFilterRenderer;
import com.autel.internal.video.core.decoder2.render.GLRendererBase;
import com.autel.internal.video.core.decoder2.render.NormalRenderer;
import com.autel.internal.video.core.decoder2.render.OverExposureFilterRenderer;
import com.autel.internal.video.core.decoder2.utils.GLUtil;
import com.autel.sdk.C4926R;

public class RenderHandleNew {
    private FilterType curFilterType = FilterType.UNKNOWN;
    long delay_time = 0;
    private BlackAndWhiteFilterRenderer lastFrameRenderer;
    private EglEnvNew mEglEnv = new EglEnvNew();

    /* renamed from: mH */
    private int f8501mH;
    private int mImageId = C4926R.drawable.expo1280;
    private boolean mInit = false;
    private long mPtsBase = -1;
    private float[] mSTMatrix = new float[16];
    private SurfaceTexture mSurface;
    private int mTexTureID;
    private SurfaceTexture mTexture;
    private long mTimeBase = -1;
    private GLRendererBase mVideoRenderer;

    /* renamed from: mW */
    private int f8502mW;

    /* renamed from: mX */
    private int f8503mX;

    /* renamed from: mY */
    private int f8504mY;

    public void start(SurfaceTexture surfaceTexture, boolean z) {
        while (!this.mInit) {
            ImageHandleInit(surfaceTexture);
        }
        setCurFilterType(z ? FilterType.OverExposure : FilterType.Normal);
    }

    public void VideoWinSet(int i, int i2, int i3, int i4) {
        this.f8503mX = i;
        this.f8504mY = i2;
        this.f8502mW = i3;
        this.f8501mH = i4;
    }

    private void ImageHandleInit(SurfaceTexture surfaceTexture) {
        try {
            this.mEglEnv.resumeSurface(surfaceTexture);
            this.mTexTureID = GLUtil.textureGen(36197, true);
            this.mTexture = new SurfaceTexture(this.mTexTureID);
            this.mInit = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        if (this.mInit) {
            return this.mTexture;
        }
        return null;
    }

    public void setOverExpoBackground(int i) {
        this.mImageId = i;
    }

    public void setCurFilterType(FilterType filterType) {
        if (!this.curFilterType.equals(filterType)) {
            this.curFilterType = filterType;
            int i = C49041.f8505xea4520ea[filterType.ordinal()];
            if (i == 1) {
                this.mVideoRenderer = new OverExposureFilterRenderer(this.mImageId);
            } else if (i != 2) {
                this.mVideoRenderer = new NormalRenderer();
            } else {
                this.mVideoRenderer = new BlackAndWhiteFilterRenderer();
            }
        }
    }

    /* renamed from: com.autel.internal.video.core.decoder2.RenderHandleNew$1 */
    /* synthetic */ class C49041 {

        /* renamed from: $SwitchMap$com$autel$internal$video$core$decoder2$common$FilterType */
        static final /* synthetic */ int[] f8505xea4520ea;

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
                f8505xea4520ea = r0
                com.autel.internal.video.core.decoder2.common.FilterType r1 = com.autel.internal.video.core.decoder2.common.FilterType.OverExposure     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8505xea4520ea     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.video.core.decoder2.common.FilterType r1 = com.autel.internal.video.core.decoder2.common.FilterType.BlackAndWhite     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.video.core.decoder2.RenderHandleNew.C49041.<clinit>():void");
        }
    }

    public FilterType getCurFilterType() {
        return this.curFilterType;
    }

    public void renderLastFrame() {
        if (this.mInit) {
            this.mTexture.getTransformMatrix(this.mSTMatrix);
            if (this.lastFrameRenderer == null) {
                this.lastFrameRenderer = new BlackAndWhiteFilterRenderer();
            }
            this.lastFrameRenderer.renderDraw(this.f8503mX, this.f8504mY, this.f8502mW, this.f8501mH, 0.0f, this.mSTMatrix, this.mTexTureID);
            this.mEglEnv.eglFlush();
        }
    }

    public void renderAvailableFrame(long j) {
        if (this.mInit) {
            this.mTexture.updateTexImage();
            this.mTexture.getTransformMatrix(this.mSTMatrix);
            this.mVideoRenderer.renderDraw(this.f8503mX, this.f8504mY, this.f8502mW, this.f8501mH, 0.0f, this.mSTMatrix, this.mTexTureID);
            waitToDisplay(j);
            this.mEglEnv.eglFlush();
        }
    }

    private void waitToDisplay(long j) {
        long j2 = this.mPtsBase;
        if (j2 == -1 || j2 > j) {
            this.mPtsBase = j;
            this.mTimeBase = System.currentTimeMillis();
        }
        long j3 = ((j - this.mPtsBase) / 90) + this.mTimeBase;
        long currentTimeMillis = j3 - System.currentTimeMillis();
        int i = (currentTimeMillis > 0 ? 1 : (currentTimeMillis == 0 ? 0 : -1));
        if (i > 0 && currentTimeMillis <= 30) {
            do {
            } while (j3 - System.currentTimeMillis() > 0);
        } else if (i < 0 || currentTimeMillis > 30) {
            this.mPtsBase = j;
            this.mTimeBase = System.currentTimeMillis();
        }
    }

    public void stop() {
        if (this.mInit) {
            GLUtil.deleteTexture(this.mTexTureID);
            this.mTexTureID = -1;
            EglEnvNew eglEnvNew = this.mEglEnv;
            if (eglEnvNew != null) {
                eglEnvNew.stopSurface();
            }
            SurfaceTexture surfaceTexture = this.mTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mTexture = null;
            }
            this.mInit = false;
        }
    }

    public void release() {
        int i = this.mTexTureID;
        if (i != -1) {
            GLUtil.deleteTexture(i);
            this.mTexTureID = -1;
        }
        GLRendererBase gLRendererBase = this.mVideoRenderer;
        if (gLRendererBase != null) {
            gLRendererBase.release();
            this.mVideoRenderer = null;
        }
        EglEnvNew eglEnvNew = this.mEglEnv;
        if (eglEnvNew != null) {
            eglEnvNew.release();
            this.mEglEnv = null;
        }
        SurfaceTexture surfaceTexture = this.mTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mTexture = null;
        }
    }
}
