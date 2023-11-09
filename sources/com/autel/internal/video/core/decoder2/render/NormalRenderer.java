package com.autel.internal.video.core.decoder2.render;

import android.opengl.GLES20;

public class NormalRenderer extends GLRendererBase {
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float yuv_scale_uniform;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord)*yuv_scale_uniform;\n}\n";
    public static final String TAG = "NormalRenderer";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private float mScale = 1.0f;
    private int mYuvScaleHandle;

    /* access modifiers changed from: protected */
    public String fragmentProgram() {
        return FRAGMENT_SHADER;
    }

    /* access modifiers changed from: protected */
    public String verticesProgram() {
        return VERTEX_SHADER;
    }

    /* access modifiers changed from: protected */
    public void renderOpenGLInitExtra() {
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mRenderProgram, "yuv_scale_uniform");
        this.mYuvScaleHandle = glGetUniformLocation;
        if (glGetUniformLocation < 0) {
            throw new RuntimeException("Unable to locate '" + this.mYuvScaleHandle + "' in program");
        }
    }

    /* access modifiers changed from: protected */
    public void renderOpenGlDrawExtra() {
        GLES20.glUniform1f(this.mYuvScaleHandle, this.mScale);
    }

    public void YuvScaleSet(float f) {
        this.mScale = f;
    }

    public void release() {
        super.release();
    }
}
