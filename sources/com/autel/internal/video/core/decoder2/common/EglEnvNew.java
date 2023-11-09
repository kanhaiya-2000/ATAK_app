package com.autel.internal.video.core.decoder2.common;

import android.graphics.SurfaceTexture;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EglEnvNew {
    final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    final int EGL_OPENGL_ES2_BIT = 4;
    private final String TAG = "EglEnv";
    int[] attrlists = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
    int[] contextConfigs = {12440, 2, 12344};
    private EGL10 mEgl;
    private EGLConfig[] mEglConfigs = new EGLConfig[1];
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    private boolean mInit = false;
    int[] num = new int[1];

    public void initEgl() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEglDisplay = eglGetDisplay;
        if (!eglGetDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                EGL10 egl102 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                int[] iArr = this.attrlists;
                EGLConfig[] eGLConfigArr = this.mEglConfigs;
                if (egl102.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, eGLConfigArr.length, this.num)) {
                    EGLContext eglCreateContext = this.mEgl.eglCreateContext(this.mEglDisplay, this.mEglConfigs[0], EGL10.EGL_NO_CONTEXT, this.contextConfigs);
                    this.mEglContext = eglCreateContext;
                    if (eglCreateContext.equals(EGL10.EGL_NO_CONTEXT)) {
                        throw new RuntimeException("unable to create context");
                    }
                    return;
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.mEglDisplay = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        throw new RuntimeException("unable to get EGL10 display");
    }

    public void resumeSurface(SurfaceTexture surfaceTexture) {
        EGLSurface eglCreateWindowSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfigs[0], surfaceTexture, (int[]) null);
        this.mEglSurface = eglCreateWindowSurface;
        if (!eglCreateWindowSurface.equals(EGL10.EGL_NO_SURFACE)) {
            EGL10 egl10 = this.mEgl;
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                this.mInit = true;
                return;
            }
            throw new RuntimeException("eglMakeCurrent failed");
        }
        throw new RuntimeException("unable to create window mSurface");
    }

    public void eglFlush() {
        if (this.mInit) {
            this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
        }
    }

    public void stopSurface() {
        if (this.mInit) {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != null) {
                this.mEgl.eglDestroySurface(this.mEglDisplay, eGLSurface);
            }
            this.mEglSurface = null;
            this.mInit = false;
        }
    }

    public void release() {
        EGLDisplay eGLDisplay = this.mEglDisplay;
        if (!(eGLDisplay == null || eGLDisplay == EGL10.EGL_NO_DISPLAY)) {
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        }
        EGLSurface eGLSurface = this.mEglSurface;
        if (!(eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE)) {
            this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            this.mEglSurface = EGL10.EGL_NO_SURFACE;
        }
        EGLContext eGLContext = this.mEglContext;
        if (!(eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT)) {
            this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
            this.mEglContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLDisplay eGLDisplay2 = this.mEglDisplay;
        if (!(eGLDisplay2 == null || eGLDisplay2 == EGL10.EGL_NO_DISPLAY)) {
            this.mEgl.eglTerminate(this.mEglDisplay);
            this.mEglDisplay = EGL10.EGL_NO_DISPLAY;
        }
        this.mInit = false;
    }
}
