package com.autel.internal.video.core.decoder2.common;

import android.graphics.SurfaceTexture;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EglEnv {
    private final String TAG = "EglEnv";
    private EGL10 mEgl;
    private EGLConfig[] mEglConfigs;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    private boolean mInit = false;
    private SurfaceTexture mSurface;

    public EglEnv(SurfaceTexture surfaceTexture) {
        this.mSurface = surfaceTexture;
    }

    public void eglInit() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEglDisplay = eglGetDisplay;
        if (!eglGetDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                this.mEglConfigs = eGLConfigArr;
                if (this.mEgl.eglChooseConfig(this.mEglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, eGLConfigArr, eGLConfigArr.length, new int[1])) {
                    EGLContext eglCreateContext = this.mEgl.eglCreateContext(this.mEglDisplay, this.mEglConfigs[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    this.mEglContext = eglCreateContext;
                    if (!eglCreateContext.equals(EGL10.EGL_NO_CONTEXT)) {
                        EGLSurface eglCreateWindowSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfigs[0], this.mSurface, (int[]) null);
                        this.mEglSurface = eglCreateWindowSurface;
                        if (!eglCreateWindowSurface.equals(EGL10.EGL_NO_SURFACE)) {
                            EGL10 egl102 = this.mEgl;
                            EGLDisplay eGLDisplay = this.mEglDisplay;
                            EGLSurface eGLSurface = this.mEglSurface;
                            if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                                this.mInit = true;
                                return;
                            }
                            throw new RuntimeException("eglMakeCurrent failed");
                        }
                        throw new RuntimeException("unable to create window mSurface");
                    }
                    throw new RuntimeException("unable to create context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.mEglDisplay = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        throw new RuntimeException("unable to get EGL10 display");
    }

    public void eglFlush() {
        if (this.mInit) {
            this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
        }
    }

    public void release() {
        if (this.mInit) {
            this.mInit = false;
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
            if (eGLDisplay2 != null && eGLDisplay2 != EGL10.EGL_NO_DISPLAY) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = EGL10.EGL_NO_DISPLAY;
            }
        }
    }
}
