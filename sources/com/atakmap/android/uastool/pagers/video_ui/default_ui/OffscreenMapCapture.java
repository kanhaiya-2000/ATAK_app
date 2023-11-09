package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.widget.LinearLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.coremap.log.Log;
import indago.serialization.JsonKeyConstants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OffscreenMapCapture {
    public static final int COORDS_PER_VERTEX = 2;
    private static final String TAG = "OffscreenMapCapture";
    public static final int vertexStride = 8;
    final int[] colorRenderBuffer = new int[1];
    final Runnable getAndSetImage = new Runnable() {
        /* access modifiers changed from: package-private */
        public boolean glFlushErrors(String str, boolean z) {
            if (!z) {
                Log.d(OffscreenMapCapture.TAG, "*** " + str);
            }
            boolean z2 = false;
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError == 0) {
                    return z2;
                }
                if (!z) {
                    Log.d(OffscreenMapCapture.TAG, "err " + Integer.toString(glGetError, 16));
                }
                z2 = true;
            }
        }

        private boolean initializeFBO(int i, int i2) {
            glFlushErrors((String) null, true);
            GLES20.glGenFramebuffers(1, OffscreenMapCapture.this.textureFrameBuffer, 0);
            glFlushErrors("glGenFramebuffers", false);
            GLES20.glGenRenderbuffers(1, OffscreenMapCapture.this.colorRenderBuffer, 0);
            glFlushErrors("glGenRenderbuffers", false);
            GLES20.glGenTextures(1, OffscreenMapCapture.this.textures, 0);
            GLES20.glBindTexture(3553, OffscreenMapCapture.this.textures[0]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexImage2D(3553, 0, 6407, OffscreenMapCapture._nextPowerOf2(i), OffscreenMapCapture._nextPowerOf2(i2), 0, 6407, 33635, (Buffer) null);
            glFlushErrors("offscreen texture create", false);
            GLES20.glBindRenderbuffer(36161, OffscreenMapCapture.this.colorRenderBuffer[0]);
            glFlushErrors("glBindRenderbuffer", false);
            GLES20.glRenderbufferStorage(36161, 33189, OffscreenMapCapture._nextPowerOf2(i), OffscreenMapCapture._nextPowerOf2(i2));
            glFlushErrors("glRenderbufferStorage", false);
            GLES20.glBindRenderbuffer(36161, 0);
            glFlushErrors("glBindRenderbuffer", false);
            glFlushErrors("glBindRenderbuffer", false);
            GLES20.glBindFramebuffer(36160, OffscreenMapCapture.this.textureFrameBuffer[0]);
            glFlushErrors("glBindFramebuffer", false);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, OffscreenMapCapture.this.textures[0], 0);
            glFlushErrors("glFramebufferTexture2D", false);
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, OffscreenMapCapture.this.colorRenderBuffer[0]);
            glFlushErrors("glFramebufferRenderbuffer", false);
            if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
                return true;
            }
            return false;
        }

        public void run() {
            GLES20.glGetIntegerv(36006, OffscreenMapCapture.this.prevFrameBuffer, 0);
            int width = MapView.getMapView().getWidth();
            int height = MapView.getMapView().getHeight();
            float[] fArr = new float[4];
            GLES20.glGetFloatv(2978, fArr, 0);
            synchronized (OffscreenMapCapture.this.textures) {
                if (OffscreenMapCapture.this.textureFrameBuffer[0] == 0) {
                    initializeFBO(width, height);
                } else {
                    GLES20.glBindFramebuffer(36160, OffscreenMapCapture.this.textureFrameBuffer[0]);
                }
                GLES20.glViewport(0, 0, width, height);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(17664);
                MapView.getMapView().getGLSurface().getGLMapView().render();
                GLES20.glBindFramebuffer(36160, OffscreenMapCapture.this.prevFrameBuffer[0]);
            }
            GLES20.glViewport((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
            OffscreenMapCapture.this.refreshQueued = false;
        }
    };
    GLSurfaceView glView = null;
    FloatBuffer imageVertexBuffer = null;
    boolean isGettingAndSettingImages = false;
    LinearLayout linearLayout;
    Thread offscreenRefreshThread;
    final int[] prevFrameBuffer = new int[1];
    int prog = -1;
    boolean refreshQueued;
    GLES20Renderer renderer = null;
    final float[] squareVertices = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
    final Runnable stopGettingAndSettingImage = new Runnable() {
        public void run() {
            GLES20.glDeleteTextures(1, OffscreenMapCapture.this.textures, 0);
            GLES20.glDeleteRenderbuffers(1, OffscreenMapCapture.this.colorRenderBuffer, 0);
            GLES20.glDeleteFramebuffers(1, OffscreenMapCapture.this.textureFrameBuffer, 0);
            OffscreenMapCapture.this.imageVertexBuffer = null;
            OffscreenMapCapture.this.textures[0] = 0;
            OffscreenMapCapture.this.colorRenderBuffer[0] = 0;
            OffscreenMapCapture.this.textureFrameBuffer[0] = 0;
        }
    };
    final int[] textureFrameBuffer = new int[1];
    final int[] textures = new int[1];

    /* access modifiers changed from: private */
    public static int _nextPowerOf2(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public class GLES20Renderer implements GLSurfaceView.Renderer {
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        }

        public GLES20Renderer() {
        }

        public void onDrawFrame(GL10 gl10) {
            float f;
            float f2;
            float f3;
            if (OffscreenMapCapture.this.imageVertexBuffer == null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(OffscreenMapCapture.this.squareVertices.length * 4);
                allocateDirect.order(ByteOrder.nativeOrder());
                OffscreenMapCapture.this.imageVertexBuffer = allocateDirect.asFloatBuffer();
                OffscreenMapCapture.this.imageVertexBuffer.put(OffscreenMapCapture.this.squareVertices);
                OffscreenMapCapture.this.imageVertexBuffer.position(0);
            }
            if (OffscreenMapCapture.this.prog < 0) {
                OffscreenMapCapture.this.prog = ShaderInfo.loadImageShader();
            }
            GLES20.glUseProgram(OffscreenMapCapture.this.prog);
            int width = MapView.getMapView().getWidth();
            int height = MapView.getMapView().getHeight();
            synchronized (OffscreenMapCapture.this.textures) {
                if (OffscreenMapCapture.this.textures[0] != 0) {
                    OffscreenMapCapture.this.glView.getWidth();
                    OffscreenMapCapture.this.glView.getHeight();
                    float access$000 = ((float) OffscreenMapCapture._nextPowerOf2(width)) / ((float) OffscreenMapCapture._nextPowerOf2(height));
                    if (access$000 > 1.0f) {
                        f3 = 1.0f;
                        f2 = 1.0f;
                        f = 0.0f;
                    } else {
                        f3 = 1.0f / access$000;
                        access$000 = 1.0f;
                        f2 = 0.0f;
                        f = 1.0f;
                    }
                    GLES20.glUniform2f(GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "xyscale"), access$000, f3);
                    GLES20.glUniform2f(GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "center"), f2, f);
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "rot"), (float) ((((double) 0.0f) * 3.141592653589793d) - 2.858407346410207d));
                    int glGetUniformLocation = GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "no_alpha");
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "alpha"), 1.0f);
                    if (glGetUniformLocation >= 0) {
                        GLES20.glUniform1f(glGetUniformLocation, 0.0f);
                    }
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "multip"), 1.0f);
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "addv"), 0.0f);
                    int glGetAttribLocation = GLES20.glGetAttribLocation(OffscreenMapCapture.this.prog, JsonKeyConstants.POSITION);
                    GLES20.glEnableVertexAttribArray(glGetAttribLocation);
                    GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, OffscreenMapCapture.this.imageVertexBuffer);
                    GLES20.glUniform1i(GLES20.glGetUniformLocation(OffscreenMapCapture.this.prog, "s_texture"), 0);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, OffscreenMapCapture.this.textures[0]);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glDisableVertexAttribArray(glGetAttribLocation);
                    GLES20.glBindTexture(3553, 0);
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0054 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OffscreenMapCapture(android.widget.LinearLayout r7) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 8
            float[] r0 = new float[r0]
            r0 = {1065353216, 1065353216, -1082130432, 1065353216, 1065353216, -1082130432, -1082130432, -1082130432} // fill-array
            r6.squareVertices = r0
            r0 = 0
            r6.glView = r0
            r1 = 1
            int[] r2 = new int[r1]
            r6.prevFrameBuffer = r2
            int[] r2 = new int[r1]
            r6.colorRenderBuffer = r2
            int[] r2 = new int[r1]
            r6.textureFrameBuffer = r2
            int[] r2 = new int[r1]
            r6.textures = r2
            r2 = 0
            r6.isGettingAndSettingImages = r2
            r6.imageVertexBuffer = r0
            r6.renderer = r0
            com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$1 r0 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$1
            r0.<init>()
            r6.stopGettingAndSettingImage = r0
            com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$2 r0 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$2
            r0.<init>()
            r6.getAndSetImage = r0
            r0 = -1
            r6.prog = r0
            r6.linearLayout = r7
            javax.microedition.khronos.egl.EGLContext[] r3 = new javax.microedition.khronos.egl.EGLContext[r1]
            com.atakmap.android.maps.MapView r4 = com.atakmap.android.maps.MapView.getMapView()
            com.atakmap.map.opengl.GLMapSurface r4 = r4.getGLSurface()
            com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$3 r5 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$3
            r5.<init>(r3)
            r4.queueEvent(r5)
            monitor-enter(r3)
            r4 = r3[r2]     // Catch:{ all -> 0x0096 }
            if (r4 != 0) goto L_0x0054
            r3.wait()     // Catch:{ InterruptedException -> 0x0054 }
        L_0x0054:
            monitor-exit(r3)     // Catch:{ all -> 0x0096 }
            r4 = r3[r2]
            if (r4 != 0) goto L_0x005d
            javax.microedition.khronos.egl.EGLContext r4 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            r3[r2] = r4
        L_0x005d:
            android.opengl.GLSurfaceView r2 = new android.opengl.GLSurfaceView
            android.content.Context r4 = r7.getContext()
            r2.<init>(r4)
            r6.glView = r2
            r2.setZOrderMediaOverlay(r1)
            android.opengl.GLSurfaceView r2 = r6.glView
            com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$4 r4 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$4
            r4.<init>(r3)
            r2.setEGLContextFactory(r4)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r2.<init>(r0, r0)
            android.opengl.GLSurfaceView r0 = r6.glView
            r0.setLayoutParams(r2)
            android.opengl.GLSurfaceView r0 = r6.glView
            r0.setPreserveEGLContextOnPause(r1)
            android.opengl.GLSurfaceView r0 = r6.glView
            com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$GLES20Renderer r1 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture$GLES20Renderer
            r1.<init>()
            r6.renderer = r1
            r0.setRenderer(r1)
            android.opengl.GLSurfaceView r0 = r6.glView
            r7.addView(r0)
            return
        L_0x0096:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0096 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.default_ui.OffscreenMapCapture.<init>(android.widget.LinearLayout):void");
    }

    public void setVisibility(int i) {
        this.glView.setVisibility(i);
    }

    public void capture(boolean z) {
        this.isGettingAndSettingImages = z;
        if (z) {
            this.refreshQueued = false;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    while (Thread.currentThread() == OffscreenMapCapture.this.offscreenRefreshThread) {
                        Thread thread = OffscreenMapCapture.this.offscreenRefreshThread;
                        if (!Thread.interrupted()) {
                            try {
                                Thread.sleep(500);
                                if (Thread.currentThread() == OffscreenMapCapture.this.offscreenRefreshThread && OffscreenMapCapture.this.isGettingAndSettingImages && !OffscreenMapCapture.this.refreshQueued) {
                                    OffscreenMapCapture.this.refreshQueued = true;
                                    MapView.getMapView().getGLSurface().queueEvent(OffscreenMapCapture.this.getAndSetImage);
                                }
                            } catch (InterruptedException unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            });
            this.offscreenRefreshThread = thread;
            thread.setPriority(5);
            this.offscreenRefreshThread.setDaemon(true);
            this.offscreenRefreshThread.start();
            return;
        }
        Thread thread2 = this.offscreenRefreshThread;
        if (thread2 != null) {
            thread2.interrupt();
            this.offscreenRefreshThread = null;
        }
        MapView.getMapView().getGLSurface().queueEvent(this.stopGettingAndSettingImage);
    }
}
