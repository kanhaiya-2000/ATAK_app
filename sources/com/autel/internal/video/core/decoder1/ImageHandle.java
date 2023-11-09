package com.autel.internal.video.core.decoder1;

import android.graphics.SurfaceTexture;
import android.os.Build;

public class ImageHandle implements SurfaceTexture.OnFrameAvailableListener {
    private final String TAG = "ImageHandle";
    private EglEnv mEglEnv;

    /* renamed from: mH */
    private int f8485mH;
    private int mImageId;
    private ImageVampix mImageVampix;
    private boolean mInit = false;
    private OverExposure mOverExpo;
    private boolean mOverExpoSwitch = false;
    private long mPtsBase = -1;
    private float[] mSTMatrix = new float[16];
    private int mTexTureID;
    private SurfaceTexture mTexture;
    private long mTimeBase = -1;
    private VideoRenderer mVideoRenderer;

    /* renamed from: mW */
    private int f8486mW;

    /* renamed from: mX */
    private int f8487mX;

    /* renamed from: mY */
    private int f8488mY;
    private SurfaceTexture surface;

    public ImageHandle(int i, SurfaceTexture surfaceTexture, boolean z) {
        this.mImageId = i;
        this.surface = surfaceTexture;
        this.mOverExpoSwitch = z;
    }

    public void VideoWinSet(int i, int i2, int i3, int i4) {
        this.f8487mX = i;
        this.f8488mY = i2;
        this.f8486mW = i3;
        this.f8485mH = i4;
    }

    public boolean ImageHandleInit() {
        try {
            EglEnv eglEnv = new EglEnv(this.surface);
            this.mEglEnv = eglEnv;
            eglEnv.eglInit();
            VideoRenderer videoRenderer = new VideoRenderer();
            this.mVideoRenderer = videoRenderer;
            videoRenderer.renderInit();
            ImageVampix imageVampix = new ImageVampix();
            this.mImageVampix = imageVampix;
            imageVampix.renderInit();
            this.mTexTureID = GLUtil.textureGen(36197, true);
            this.mTexture = new SurfaceTexture(this.mTexTureID);
            this.mInit = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        if (!this.mInit) {
            return null;
        }
        return this.mTexture;
    }

    public synchronized void renderLastFrame() {
        if (this.mInit) {
            drawToFrameBuffer(1);
            this.mEglEnv.eglFlush();
        }
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.mInit) {
            this.mTexture.updateTexImage();
            drawToFrameBuffer(0);
            long needWait = needWait(Build.VERSION.SDK_INT >= 16 ? VideoDecoder.minfo.presentationTimeUs : 0);
            if (needWait > 0) {
                try {
                    Thread.sleep(needWait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.mEglEnv.eglFlush();
        }
    }

    public void setOverExposure(int i, boolean z) {
        if (i != 0) {
            this.mImageId = i;
            this.mOverExpoSwitch = z;
            return;
        }
        this.mOverExpoSwitch = false;
    }

    public boolean isOverExposureEnabled() {
        return this.mOverExpoSwitch;
    }

    private void drawToFrameBuffer(int i) {
        this.mTexture.getTransformMatrix(this.mSTMatrix);
        if (i != 0) {
            this.mImageVampix.renderDraw(this.f8487mX, this.f8488mY, this.f8486mW, this.f8485mH, 0.0f, this.mSTMatrix, this.mTexTureID);
        } else if (this.mOverExpoSwitch) {
            if (this.mOverExpo == null) {
                OverExposure overExposure = new OverExposure(this.mImageId);
                this.mOverExpo = overExposure;
                overExposure.renderInit();
            }
            this.mOverExpo.renderDraw(this.f8487mX, this.f8488mY, this.f8486mW, this.f8485mH, 0.0f, this.mSTMatrix, this.mTexTureID);
        } else {
            this.mVideoRenderer.renderDraw(this.f8487mX, this.f8488mY, this.f8486mW, this.f8485mH, 0.0f, this.mSTMatrix, this.mTexTureID);
        }
    }

    private long needWait(long j) {
        long j2 = this.mPtsBase;
        if (j2 == -1 || j2 > j) {
            this.mPtsBase = j;
            this.mTimeBase = System.currentTimeMillis();
        }
        long j3 = this.mPtsBase;
        long currentTimeMillis = ((((j - j3) / 90000) * 1000) + j3) - System.currentTimeMillis();
        if (currentTimeMillis < 50 && currentTimeMillis >= 0) {
            return currentTimeMillis;
        }
        this.mPtsBase = j;
        this.mTimeBase = System.currentTimeMillis();
        return 0;
    }

    public void release() {
        if (this.mInit) {
            this.mInit = false;
            GLUtil.deleteTexture(this.mTexTureID);
            this.mTexTureID = -1;
            VideoRenderer videoRenderer = this.mVideoRenderer;
            if (videoRenderer != null) {
                videoRenderer.release();
                this.mVideoRenderer = null;
            }
            ImageVampix imageVampix = this.mImageVampix;
            if (imageVampix != null) {
                imageVampix.release();
                this.mImageVampix = null;
            }
            OverExposure overExposure = this.mOverExpo;
            if (overExposure != null) {
                overExposure.release();
                this.mOverExpo = null;
            }
            EglEnv eglEnv = this.mEglEnv;
            if (eglEnv != null) {
                eglEnv.release();
                this.mEglEnv = null;
            }
            SurfaceTexture surfaceTexture = this.mTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mTexture = null;
            }
            SurfaceTexture surfaceTexture2 = this.surface;
            if (surfaceTexture2 != null) {
                surfaceTexture2.release();
                this.surface = null;
            }
        }
    }
}
