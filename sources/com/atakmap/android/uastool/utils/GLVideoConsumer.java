package com.atakmap.android.uastool.utils;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import atak.core.agk;
import atak.core.agl;
import atak.core.agn;
import com.atakmap.coremap.log.Log;
import com.atakmap.lang.Unsafe;
import com.partech.mobilevid.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;

public class GLVideoConsumer implements d {
    private static final String TAG = "GLVideoConsumer";
    /* access modifiers changed from: private */
    public final BitmapReporter bitmapReporter;
    private Thread bitmapReporterThread;
    protected final Set<BitmapUpdateListener> bitmapUpdateListeners = new HashSet();
    private boolean started = false;
    /* access modifiers changed from: private */
    public final VideoConsumerRunnable videoConsumerRunnable;
    private Thread videoConsumerThread;

    public interface BitmapUpdateListener {
        void onBitmapUpdate(Bitmap bitmap);
    }

    /* renamed from: b */
    public void mo10886b() {
    }

    public GLVideoConsumer(EGLContext eGLContext, boolean z) {
        this.videoConsumerRunnable = new VideoConsumerRunnable(eGLContext, z);
        this.bitmapReporter = new BitmapReporter();
    }

    public Bitmap getCurrentBitmap() {
        return this.videoConsumerRunnable.getBitmap();
    }

    /* renamed from: a */
    public void mo10883a(int i, int i2) {
        this.videoConsumerRunnable.sourceSizeUpdate(i, i2);
    }

    /* renamed from: a */
    public void mo10882a() {
        this.videoConsumerRunnable.finishUseOfPreviousFrame();
    }

    /* renamed from: a */
    public void mo10884a(int i, long j, float[] fArr) {
        this.videoConsumerRunnable.frameUpdate(i, j, fArr);
    }

    public void addBitmapUpdateListener(BitmapUpdateListener bitmapUpdateListener) {
        this.bitmapUpdateListeners.add(bitmapUpdateListener);
    }

    public void removeBitmapUpdateListener(BitmapUpdateListener bitmapUpdateListener) {
        this.bitmapUpdateListeners.remove(bitmapUpdateListener);
    }

    public void start() {
        synchronized (this.videoConsumerRunnable) {
            if (!this.started) {
                this.started = true;
                Thread thread = new Thread(this.videoConsumerRunnable);
                this.videoConsumerThread = thread;
                thread.setName(TAG);
                this.videoConsumerThread.start();
                try {
                    this.videoConsumerRunnable.waitUntilPrepared();
                    Thread thread2 = new Thread(this.bitmapReporter);
                    this.bitmapReporterThread = thread2;
                    thread2.setName("BitmapReporter");
                    this.bitmapReporterThread.start();
                } catch (VideoConsumerException e) {
                    this.started = false;
                    this.videoConsumerThread = null;
                    throw e;
                }
            }
        }
    }

    public void stop() {
        synchronized (this.videoConsumerRunnable) {
            this.videoConsumerRunnable.requestStop();
            this.started = false;
            this.videoConsumerThread = null;
            this.bitmapReporterThread.interrupt();
            this.bitmapReporterThread = null;
        }
    }

    public static class VideoConsumerException extends Exception {
        public VideoConsumerException() {
        }

        public VideoConsumerException(String str) {
            super(str);
        }

        public VideoConsumerException(String str, Throwable th) {
            super(str, th);
        }
    }

    private class BitmapReporter implements Runnable {
        private BitmapReporter() {
        }

        public void bitmapUpdate() {
            synchronized (this) {
                notifyAll();
            }
        }

        private void notifyBitmapUpdate() {
            Bitmap bitmap = GLVideoConsumer.this.videoConsumerRunnable.getBitmap();
            if (bitmap != null) {
                for (BitmapUpdateListener onBitmapUpdate : GLVideoConsumer.this.bitmapUpdateListeners) {
                    onBitmapUpdate.onBitmapUpdate(Bitmap.createBitmap(bitmap));
                }
                bitmap.recycle();
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0010 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r1 = this;
            L_0x0000:
                boolean r0 = java.lang.Thread.interrupted()
                if (r0 != 0) goto L_0x0014
                monitor-enter(r1)
                r1.wait()     // Catch:{ InterruptedException -> 0x0010 }
                r1.notifyBitmapUpdate()     // Catch:{ InterruptedException -> 0x0010 }
                goto L_0x0010
            L_0x000e:
                r0 = move-exception
                goto L_0x0012
            L_0x0010:
                monitor-exit(r1)     // Catch:{ all -> 0x000e }
                goto L_0x0000
            L_0x0012:
                monitor-exit(r1)     // Catch:{ all -> 0x000e }
                throw r0
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.GLVideoConsumer.BitmapReporter.run():void");
        }
    }

    private class VideoConsumerRunnable implements Runnable {
        private Bitmap bitmap;
        private boolean bitmapUpdated = false;
        private int[] colorRenderBuffer;
        private EGLContext context;
        private boolean continueToRun;
        private int curTextureId;
        private long curTimestamp;
        private float[] curTransform;
        private EGLDisplay display;
        private EGLSurface eglSurface;
        private final boolean forYUV;
        private boolean handlingFrame;
        private boolean isPrepared;
        private final Object lockBitmap = new Object();
        private final Object lockTextureId = new Object();
        private Exception prepException;
        private agn program;
        private final EGLContext sharedContext;
        private int sourceHeight = 0;
        private int sourceWidth = 0;
        private int[] textureFrameBuffer;

        public VideoConsumerRunnable(EGLContext eGLContext, boolean z) {
            this.forYUV = z;
            this.sharedContext = eGLContext;
            this.curTransform = new float[16];
            this.continueToRun = true;
            this.handlingFrame = false;
        }

        public void requestStop() {
            synchronized (this) {
                this.continueToRun = false;
                notifyAll();
            }
        }

        public void prepare() {
            this.display = EGL14.eglGetDisplay(0);
            eglFlushErrors("eglGetDisplay", false);
            int[] iArr = new int[2];
            EGL14.eglInitialize(this.display, iArr, 0, iArr, 1);
            eglFlushErrors("eglInitialize", false);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(this.display, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            eglFlushErrors("eglChooseConfig", false);
            this.context = EGL14.eglCreateContext(this.display, eGLConfigArr[0], this.sharedContext, new int[]{12440, 2, 12344}, 0);
            eglFlushErrors("eglCreateContext", false);
            this.eglSurface = EGL14.eglCreatePbufferSurface(this.display, eGLConfigArr[0], new int[]{12375, 1, 12374, 1, 12344}, 0);
            eglFlushErrors("eglCreatePbufferSurface", false);
            EGLDisplay eGLDisplay = this.display;
            EGLSurface eGLSurface = this.eglSurface;
            boolean eglMakeCurrent = EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.context);
            eglFlushErrors("eglMakeCurrent", false);
            if (eglMakeCurrent) {
                try {
                    this.program = new agn(this.forYUV);
                    synchronized (this) {
                        this.isPrepared = true;
                        notifyAll();
                    }
                } catch (agl e) {
                    Log.e(GLVideoConsumer.TAG, "Creating GL Program failed", e);
                    throw new VideoConsumerException("Failed to create GL Program", e);
                }
            } else {
                Log.e(GLVideoConsumer.TAG, "Init GL failed");
                throw new VideoConsumerException("Init GL failed");
            }
        }

        /* access modifiers changed from: package-private */
        public boolean eglFlushErrors(String str, boolean z) {
            boolean z2 = false;
            while (true) {
                int eglGetError = EGL14.eglGetError();
                if (eglGetError == 12288) {
                    return z2;
                }
                if (!z) {
                    Log.d(GLVideoConsumer.TAG, "*** " + str);
                }
                Log.d(GLVideoConsumer.TAG, "err " + Integer.toString(eglGetError, 16));
                z2 = true;
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
        /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:19:0x0001, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void waitUntilPrepared() {
            /*
                r3 = this;
                monitor-enter(r3)
            L_0x0001:
                boolean r0 = r3.isPrepared     // Catch:{ all -> 0x001d }
                if (r0 != 0) goto L_0x000d
                java.lang.Exception r0 = r3.prepException     // Catch:{ all -> 0x001d }
                if (r0 != 0) goto L_0x000d
                r3.wait()     // Catch:{ InterruptedException -> 0x0001 }
                goto L_0x0001
            L_0x000d:
                java.lang.Exception r0 = r3.prepException     // Catch:{ all -> 0x001d }
                if (r0 != 0) goto L_0x0013
                monitor-exit(r3)
                return
            L_0x0013:
                com.atakmap.android.uastool.utils.GLVideoConsumer$VideoConsumerException r0 = new com.atakmap.android.uastool.utils.GLVideoConsumer$VideoConsumerException     // Catch:{ all -> 0x001d }
                java.lang.String r1 = "Failed to prepare encoder"
                java.lang.Exception r2 = r3.prepException     // Catch:{ all -> 0x001d }
                r0.<init>(r1, r2)     // Catch:{ all -> 0x001d }
                throw r0     // Catch:{ all -> 0x001d }
            L_0x001d:
                r0 = move-exception
                monitor-exit(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.GLVideoConsumer.VideoConsumerRunnable.waitUntilPrepared():void");
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
        /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:11:0x0001, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void finishUseOfPreviousFrame() {
            /*
                r1 = this;
                monitor-enter(r1)
            L_0x0001:
                boolean r0 = r1.handlingFrame     // Catch:{ all -> 0x000b }
                if (r0 == 0) goto L_0x0009
                r1.wait()     // Catch:{ InterruptedException -> 0x0001 }
                goto L_0x0001
            L_0x0009:
                monitor-exit(r1)
                return
            L_0x000b:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.GLVideoConsumer.VideoConsumerRunnable.finishUseOfPreviousFrame():void");
        }

        public synchronized void frameUpdate(int i, long j, float[] fArr) {
            synchronized (this.lockTextureId) {
                this.curTextureId = i;
                System.arraycopy(fArr, 0, this.curTransform, 0, 16);
                this.curTimestamp = j;
                this.handlingFrame = true;
                notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|20) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x002e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r2 = this;
                r0 = 1
                r2.continueToRun = r0
                r0 = 0
                r2.handlingFrame = r0
                r2.prepare()     // Catch:{ VideoConsumerException -> 0x0033 }
            L_0x0009:
                monitor-enter(r2)
                boolean r1 = r2.continueToRun     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x001a
                monitor-exit(r2)     // Catch:{ all -> 0x0030 }
                monitor-enter(r2)
                r2.handlingFrame = r0     // Catch:{ all -> 0x0017 }
                r2.notifyAll()     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            L_0x001a:
                r2.handleFrame()     // Catch:{ all -> 0x0030 }
                r2.handlingFrame = r0     // Catch:{ all -> 0x0030 }
                r2.notifyAll()     // Catch:{ all -> 0x0030 }
                com.atakmap.android.uastool.utils.GLVideoConsumer r1 = com.atakmap.android.uastool.utils.GLVideoConsumer.this     // Catch:{ all -> 0x0030 }
                com.atakmap.android.uastool.utils.GLVideoConsumer$BitmapReporter r1 = r1.bitmapReporter     // Catch:{ all -> 0x0030 }
                r1.bitmapUpdate()     // Catch:{ all -> 0x0030 }
                r2.wait()     // Catch:{ InterruptedException -> 0x002e }
            L_0x002e:
                monitor-exit(r2)     // Catch:{ all -> 0x0030 }
                goto L_0x0009
            L_0x0030:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0030 }
                throw r0
            L_0x0033:
                r0 = move-exception
                r2.prepException = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.GLVideoConsumer.VideoConsumerRunnable.run():void");
        }

        private void handleFrame() {
            int i;
            synchronized (this.lockBitmap) {
                int i2 = this.sourceWidth;
                if (!(i2 == 0 || (i = this.sourceHeight) == 0)) {
                    if (initializeFBO(i2, i)) {
                        try {
                            this.program.a(agk.a, this.curTransform, this.curTextureId);
                        } catch (agl e) {
                            Log.e(GLVideoConsumer.TAG, "GL Drawing error!", e);
                        }
                        Bitmap bitmap2 = this.bitmap;
                        this.bitmap = setBitmap();
                        this.bitmapUpdated = true;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                    } else {
                        Log.e(GLVideoConsumer.TAG, "Initialize FBO failed");
                    }
                }
            }
        }

        public Bitmap getBitmap() {
            Bitmap bitmap2;
            synchronized (this.lockBitmap) {
                bitmap2 = null;
                Bitmap bitmap3 = this.bitmap;
                if (bitmap3 != null) {
                    bitmap2 = Bitmap.createBitmap(bitmap3);
                }
            }
            return bitmap2;
        }

        private boolean initializeFBO(int i, int i2) {
            int[] iArr = this.textureFrameBuffer;
            if (iArr != null) {
                GLES20.glDeleteFramebuffers(1, iArr, 0);
            }
            int[] iArr2 = this.colorRenderBuffer;
            if (iArr2 != null) {
                GLES20.glDeleteRenderbuffers(1, iArr2, 0);
            }
            glFlushErrors((String) null, true);
            int[] iArr3 = new int[1];
            this.textureFrameBuffer = iArr3;
            GLES20.glGenFramebuffers(1, iArr3, 0);
            glFlushErrors("glGenFramebuffers", false);
            GLES20.glBindFramebuffer(36160, this.textureFrameBuffer[0]);
            glFlushErrors("glBindFramebuffer", false);
            int[] iArr4 = new int[1];
            this.colorRenderBuffer = iArr4;
            GLES20.glGenRenderbuffers(1, iArr4, 0);
            glFlushErrors("glGenRenderbuffers", false);
            GLES20.glBindRenderbuffer(36161, this.colorRenderBuffer[0]);
            glFlushErrors("glBindRenderbuffer", false);
            GLES20.glRenderbufferStorage(36161, 36194, i, i2);
            glFlushErrors("glRenderbufferStorage", false);
            GLES20.glFramebufferRenderbuffer(36160, 36064, 36161, this.colorRenderBuffer[0]);
            glFlushErrors("glFramebufferRenderbuffer", false);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            glFlushErrors("glCheckFramebufferStatus", false);
            GLES20.glViewport(0, 0, i, i2);
            glFlushErrors("glViewport", false);
            if (glCheckFramebufferStatus == 36053) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean glFlushErrors(String str, boolean z) {
            boolean z2 = false;
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError == 0) {
                    return z2;
                }
                if (!z) {
                    Log.d(GLVideoConsumer.TAG, "*** " + str);
                }
                Log.d(GLVideoConsumer.TAG, "err " + Integer.toString(glGetError, 16));
                z2 = true;
            }
        }

        private Bitmap setBitmap() {
            int i;
            int i2;
            ByteBuffer a = Unsafe.a(this.sourceWidth * this.sourceHeight * 4);
            a.order(ByteOrder.nativeOrder());
            IntBuffer asIntBuffer = a.asIntBuffer();
            int i3 = this.sourceWidth;
            if (i3 == 0 || (i = this.sourceHeight) == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i, Bitmap.Config.ARGB_8888);
            asIntBuffer.clear();
            GLES20.glFinish();
            glFlushErrors("glFinish", false);
            GLES20.glReadPixels(0, 0, this.sourceWidth, this.sourceHeight, 6408, 5121, a);
            glFlushErrors("glReadPixels", false);
            int[] iArr = new int[this.sourceWidth];
            for (int i4 = 0; i4 < this.sourceHeight; i4++) {
                asIntBuffer.clear();
                asIntBuffer.position(this.sourceWidth * i4);
                asIntBuffer.limit(asIntBuffer.position() + this.sourceWidth);
                asIntBuffer.get(iArr);
                int i5 = 0;
                while (true) {
                    i2 = this.sourceWidth;
                    if (i5 >= i2) {
                        break;
                    }
                    int i6 = iArr[i5];
                    iArr[i5] = ((i6 & 255) << 16) | (-16711936 & i6) | ((16711680 & i6) >> 16);
                    i5++;
                }
                createBitmap.setPixels(iArr, 0, i2, 0, (this.sourceHeight - i4) - 1, i2, 1);
            }
            return createBitmap;
        }

        public void sourceSizeUpdate(int i, int i2) {
            this.sourceWidth = i;
            this.sourceHeight = i2;
            GLES20.glViewport(0, 0, i, i2);
            glFlushErrors("glViewport", false);
        }
    }
}
