package com.autel.internal.video.core.decoder2.utils;

import android.opengl.GLES20;
import android.util.Log;

public class GLUtil {
    public static final String TAG = "GLUtil";
    public static boolean mAbort = false;

    public static int textureGen(int i, boolean z) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        GLES20.glBindTexture(i, i2);
        GLES20.glTexParameterf(i, 10241, 9728.0f);
        GLES20.glTexParameterf(i, 10240, 9729.0f);
        if (!z) {
            GLES20.glTexParameteri(i, 10242, 33071);
            GLES20.glTexParameteri(i, 10243, 33071);
        } else {
            GLES20.glTexParameteri(i, 10242, 10497);
            GLES20.glTexParameteri(i, 10243, 10497);
        }
        return i2;
    }

    public static void checkGLErr(String str) {
        int glGetError;
        do {
            glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Log.e("GLUtil", str + ": glError " + glGetError);
            } else {
                return;
            }
        } while (!mAbort);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public static void deleteTexture(int i) {
        if (i >= 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }
}
