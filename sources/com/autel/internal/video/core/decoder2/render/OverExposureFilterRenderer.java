package com.autel.internal.video.core.decoder2.render;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.autel.internal.sdk.AutelBaseApplication;
import com.autel.internal.video.core.decoder2.utils.GLUtil;
import java.nio.ByteBuffer;

public class OverExposureFilterRenderer extends GLRendererBase {
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require \nvarying highp vec2 v_texcoord; \nvarying highp vec4 v_overexp_texcoord; \nuniform samplerExternalOES sTexture; \nuniform sampler2D s_texture_overexp; \n// use alpha channel to store lumaince \n// const highp vec4 luminanceVec = vec4(0.2126, 0.7152, 0.0722, 1.0); \nvoid main() {\nhighp vec4 rgb_color = texture2D(sTexture, v_texcoord); \nhighp vec4 over_exposed_tex_color = texture2D(s_texture_overexp, v_overexp_texcoord.xy);  \nhighp float lumaince = 0.2568*rgb_color.r+0.5041*rgb_color.g+0.0979*rgb_color.b+0.0625;  \nhighp float blend_factor = clamp(lumaince*64.0 - v_overexp_texcoord.w, 0.0 ,1.0)*v_overexp_texcoord.z;  \nhighp vec4 ret_color = mix(rgb_color, over_exposed_tex_color, blend_factor); \ngl_FragColor = vec4(ret_color.xyz, 1.0); \n}\n";
    private static final String VERTEX_SHADER = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\n//x:width in {0, 1}, y:height in {0, 1} z:offset in {0, 1}, w:blend factor\nuniform vec4 overexp_texture_param;\nvarying vec2 v_texcoord;\nvarying vec4 v_overexp_texcoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    v_texcoord = (uSTMatrix * aTextureCoord).xy;\n    v_overexp_texcoord = vec4(v_texcoord.x * overexp_texture_param.x + overexp_texture_param.z, v_texcoord.y * overexp_texture_param.y, ceil(overexp_texture_param.w), overexp_texture_param.w*64.0);}\n";
    private static final float mThreshold = 0.85f;
    public final String TAG = "OverExposureFilterRenderer";
    private int mBackGroundID;
    private int mBmpWidth;
    private int mBmpheight;
    private long mCurrMs;
    private int mOverTexParamHandle;
    private int mTexTureID = -1;
    private int msTextureOverExpHandle;

    /* access modifiers changed from: protected */
    public String fragmentProgram() {
        return FRAGMENT_SHADER;
    }

    /* access modifiers changed from: protected */
    public String verticesProgram() {
        return VERTEX_SHADER;
    }

    public OverExposureFilterRenderer(int i) {
        this.mBackGroundID = i;
        renderInit();
    }

    /* access modifiers changed from: protected */
    public void renderOpenGLInitExtra() {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(AutelBaseApplication.getAppContext().getResources(), this.mBackGroundID, options);
            this.mBmpWidth = decodeResource.getWidth();
            int height = decodeResource.getHeight();
            this.mBmpheight = height;
            ByteBuffer allocate = ByteBuffer.allocate(this.mBmpWidth * height * 4);
            decodeResource.copyPixelsToBuffer(allocate);
            allocate.clear();
            int textureGen = GLUtil.textureGen(3553, true);
            this.mTexTureID = textureGen;
            GLES20.glBindTexture(3553, textureGen);
            GLES20.glTexImage2D(3553, 0, 6408, this.mBmpWidth, this.mBmpheight, 0, 6408, 5121, allocate);
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mRenderProgram, "s_texture_overexp");
            this.msTextureOverExpHandle = glGetUniformLocation;
            exceptHandle(glGetUniformLocation, "s_texture_overexp");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mRenderProgram, "overexp_texture_param");
            this.mOverTexParamHandle = glGetUniformLocation2;
            exceptHandle(glGetUniformLocation2, "overexp_texture_param");
            this.mCurrMs = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void renderOpenGlDrawExtra() {
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.mTexTureID);
        GLES20.glUniform1i(this.msTextureOverExpHandle, 1);
        GLES20.glUniform4f(this.mOverTexParamHandle, ((float) this.mScreenW) / ((float) this.mBmpWidth), ((float) this.mScreenH) / ((float) this.mBmpheight), ((float) (System.currentTimeMillis() - this.mCurrMs)) / 32000.0f, mThreshold);
    }

    public void release() {
        super.release();
        int i = this.mTexTureID;
        if (i != -1) {
            GLUtil.deleteTexture(i);
            this.mTexTureID = -1;
        }
    }
}
