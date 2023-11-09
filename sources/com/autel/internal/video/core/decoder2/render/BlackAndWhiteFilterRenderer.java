package com.autel.internal.video.core.decoder2.render;

public class BlackAndWhiteFilterRenderer extends GLRendererBase {
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\nhighp vec4 rgb_color = texture2D(sTexture, vTextureCoord); \nhighp float lumaince = 0.2568*rgb_color.r+0.5041*rgb_color.g+0.0979*rgb_color.b+0.0625;  \ngl_FragColor = vec4(lumaince, lumaince, lumaince, 1.0); \n}\n";
    public static final String TAG = "BlackAndWhiteFilterRenderer";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private float mScale = 1.0f;
    private int mYuvScaleHandle;

    /* access modifiers changed from: protected */
    public String fragmentProgram() {
        return FRAGMENT_SHADER;
    }

    /* access modifiers changed from: protected */
    public void renderOpenGLInitExtra() {
    }

    /* access modifiers changed from: protected */
    public void renderOpenGlDrawExtra() {
    }

    /* access modifiers changed from: protected */
    public String verticesProgram() {
        return VERTEX_SHADER;
    }

    public void YuvScaleSet(float f) {
        this.mScale = f;
    }

    public void release() {
        super.release();
    }
}
