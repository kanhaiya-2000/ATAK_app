package com.autel.internal.video.core.decoder2.render;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.autel.internal.video.core.decoder2.utils.GLUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public abstract class GLRendererBase {
    private static final String TAG = "OpenGLRenderBase";
    private final int SCREEN_BYTES = 20;
    private float[] mMVPMatrixFloat = new float[16];
    protected int mRenderProgram;
    protected int mScreenH;
    private final float[] mScreenVertices = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    protected int mScreenW;
    private FloatBuffer mVerticesBuf;
    private int maPositionHandle;
    private int maTextureCoordHandle;
    private int msTextureHandle;
    private int muMVPMatrixHandle;
    private int muSTMatrixHandle;

    /* access modifiers changed from: protected */
    public abstract String fragmentProgram();

    /* access modifiers changed from: protected */
    public abstract void renderOpenGLInitExtra();

    /* access modifiers changed from: protected */
    public abstract void renderOpenGlDrawExtra();

    /* access modifiers changed from: protected */
    public abstract String verticesProgram();

    public GLRendererBase() {
        renderInit();
    }

    /* access modifiers changed from: protected */
    public void renderInit() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.mScreenVertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mVerticesBuf = asFloatBuffer;
        asFloatBuffer.put(this.mScreenVertices).position(0);
        buildRenderer();
        renderOpenGLInitExtra();
    }

    public void renderDraw(int i, int i2, int i3, int i4, float f, float[] fArr, int i5) {
        GLES20.glViewport(i, i2, i3, i4);
        this.mScreenW = i3;
        this.mScreenH = i4;
        GLUtil.checkGLErr("glViewport");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLUtil.checkGLErr("glClear");
        GLES20.glUseProgram(this.mRenderProgram);
        GLUtil.checkGLErr("glUseProgram");
        this.mVerticesBuf.position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mVerticesBuf);
        GLUtil.checkGLErr("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        GLUtil.checkGLErr("glEnableVertexAttribArray maPosition");
        this.mVerticesBuf.position(3);
        GLES20.glVertexAttribPointer(this.maTextureCoordHandle, 2, 5126, false, 20, this.mVerticesBuf);
        GLUtil.checkGLErr("glVertexAttribPointer maTextureCoord");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordHandle);
        GLUtil.checkGLErr("glEnableVertexAttribArray maTextureCoord");
        Matrix.setRotateM(this.mMVPMatrixFloat, 0, f, 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrixFloat, 0);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i5);
        GLES20.glUniform1i(this.msTextureHandle, 0);
        renderOpenGlDrawExtra();
        GLES20.glDrawArrays(5, 0, 4);
        GLUtil.checkGLErr("glDrawArrays");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, 0);
    }

    private int buildRenderer() {
        int buildShader = buildShader(35633, verticesProgram());
        if (buildShader == 0) {
            Log.e(TAG, "can not create vertex shader");
            return -1;
        }
        int buildShader2 = buildShader(35632, fragmentProgram());
        if (buildShader2 == 0) {
            Log.e(TAG, "can not create fregment shader");
            return -1;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        this.mRenderProgram = glCreateProgram;
        if (glCreateProgram == 0) {
            Log.e(TAG, "can not create a shader programe");
            return -1;
        }
        GLES20.glAttachShader(glCreateProgram, buildShader);
        GLES20.glAttachShader(this.mRenderProgram, buildShader2);
        GLES20.glLinkProgram(this.mRenderProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(this.mRenderProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e(TAG, "can not link renderer program");
            Log.e(TAG, GLES20.glGetProgramInfoLog(this.mRenderProgram));
            this.mRenderProgram = 0;
            return -1;
        }
        GLES20.glDeleteShader(buildShader);
        GLES20.glDeleteShader(buildShader2);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mRenderProgram, "aPosition");
        this.maPositionHandle = glGetAttribLocation;
        if (glGetAttribLocation < 0) {
            Log.e(TAG, "glGetAttribLocation aPosition err.");
        }
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mRenderProgram, "aTextureCoord");
        this.maTextureCoordHandle = glGetAttribLocation2;
        if (glGetAttribLocation2 < 0) {
            Log.e(TAG, "glGetAttribLocation aTextureCoord err.");
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mRenderProgram, "uMVPMatrix");
        this.muMVPMatrixHandle = glGetUniformLocation;
        if (glGetUniformLocation < 0) {
            Log.e(TAG, "glGetAttribLocation uMVPMatrix err.");
        }
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mRenderProgram, "uSTMatrix");
        this.muSTMatrixHandle = glGetUniformLocation2;
        if (glGetUniformLocation2 < 0) {
            Log.e(TAG, "glGetAttribLocation uSTMatrix err.");
        }
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.mRenderProgram, "sTexture");
        this.msTextureHandle = glGetUniformLocation3;
        if (glGetUniformLocation3 < 0) {
            Log.e(TAG, "glGetAttribLocation sTexture err.");
        }
        return 0;
    }

    private int buildShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLUtil.checkGLErr("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLUtil.checkGLErr("glShaderSource type=" + i);
        GLES20.glCompileShader(glCreateShader);
        GLUtil.checkGLErr("glCompileShader type=" + i);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e(TAG, "Could not compile shader " + i + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e(TAG, sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    /* access modifiers changed from: protected */
    public void exceptHandle(int i, String str) {
        if (i < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public void release() {
        int i = this.mRenderProgram;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
            this.mRenderProgram = 0;
        }
    }
}
