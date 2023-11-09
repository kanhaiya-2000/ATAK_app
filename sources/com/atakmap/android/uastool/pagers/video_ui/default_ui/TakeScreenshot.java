package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.graphics.Bitmap;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.widgets.w;
import com.atakmap.lang.Unsafe;
import com.atakmap.opengl.GLES20FixedPipeline;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class TakeScreenshot {
    /* access modifiers changed from: private */
    public int _height = this._mapView.getHeight();
    /* access modifiers changed from: private */
    public TakeScreenshotCaptureListener _listener;
    private MapView _mapView;
    /* access modifiers changed from: private */
    public int _width;

    TakeScreenshot(TakeScreenshotCaptureListener takeScreenshotCaptureListener) {
        this._listener = takeScreenshotCaptureListener;
        MapView mapView = MapView.getMapView();
        this._mapView = mapView;
        this._width = mapView.getWidth();
    }

    /* access modifiers changed from: private */
    public void readPixels() {
        int i;
        ByteBuffer a = Unsafe.a(this._width * this._height * 4);
        a.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = a.asIntBuffer();
        GLES20FixedPipeline.glReadPixels(0, 0, this._width, this._height, 6408, 5121, asIntBuffer);
        final Bitmap createBitmap = Bitmap.createBitmap(this._width, this._height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[this._width];
        for (int i2 = 0; i2 < this._height; i2++) {
            asIntBuffer.clear();
            asIntBuffer.position(this._width * i2);
            asIntBuffer.limit(asIntBuffer.position() + this._width);
            asIntBuffer.get(iArr);
            int i3 = 0;
            while (true) {
                i = this._width;
                if (i3 >= i) {
                    break;
                }
                int i4 = iArr[i3];
                iArr[i3] = ((i4 & 255) << 16) | (-16711936 & i4) | ((16711680 & i4) >> 16);
                i3++;
            }
            createBitmap.setPixels(iArr, 0, i, 0, (this._height - i2) - 1, i, 1);
        }
        asIntBuffer.clear();
        C18071 r0 = new Thread("TakeSnapshot-Complete") {
            public void run() {
                TakeScreenshot.this._listener.onCaptureCompleted(createBitmap);
            }
        };
        r0.setPriority(5);
        r0.start();
    }

    /* access modifiers changed from: private */
    public void init() {
        this._listener.onCaptureStarted();
        this._mapView.getGLSurface().queueEvent(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:35:0x00fe  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x0103  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x010a  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0111  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    r0 = 1
                    int[] r1 = new int[r0]
                    int[] r2 = new int[r0]
                    r3 = 36160(0x8d40, float:5.0671E-41)
                    r4 = 0
                    r5 = 0
                    com.atakmap.opengl.GLTexture r6 = new com.atakmap.opengl.GLTexture     // Catch:{ all -> 0x00e8 }
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot r7 = com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot.this     // Catch:{ all -> 0x00e8 }
                    int r7 = r7._width     // Catch:{ all -> 0x00e8 }
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot r8 = com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot.this     // Catch:{ all -> 0x00e8 }
                    int r8 = r8._height     // Catch:{ all -> 0x00e8 }
                    android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x00e8 }
                    r6.<init>(r7, r8, r9)     // Catch:{ all -> 0x00e8 }
                    r6.init()     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glGenFramebuffers(r0, r1, r4)     // Catch:{ all -> 0x00e6 }
                    r5 = r1[r4]     // Catch:{ all -> 0x00e6 }
                    if (r5 == 0) goto L_0x00de
                    com.atakmap.opengl.GLES20FixedPipeline.glGenRenderbuffers(r0, r2, r4)     // Catch:{ all -> 0x00e6 }
                    r5 = r2[r4]     // Catch:{ all -> 0x00e6 }
                    if (r5 == 0) goto L_0x00d6
                    r5 = r2[r4]     // Catch:{ all -> 0x00e6 }
                    r7 = 36161(0x8d41, float:5.0672E-41)
                    com.atakmap.opengl.GLES20FixedPipeline.glBindRenderbuffer(r7, r5)     // Catch:{ all -> 0x00e6 }
                    r5 = 33189(0x81a5, float:4.6508E-41)
                    int r8 = r6.getTexWidth()     // Catch:{ all -> 0x00e6 }
                    int r9 = r6.getTexHeight()     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glRenderbufferStorage(r7, r5, r8, r9)     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glBindRenderbuffer(r7, r4)     // Catch:{ all -> 0x00e6 }
                    r5 = r1[r4]     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glBindFramebuffer(r3, r5)     // Catch:{ all -> 0x00e6 }
                    r5 = 36064(0x8ce0, float:5.0536E-41)
                    r8 = 3553(0xde1, float:4.979E-42)
                    int r9 = r6.getTexId()     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glFramebufferTexture2D(r3, r5, r8, r9, r4)     // Catch:{ all -> 0x00e6 }
                    r5 = 36096(0x8d00, float:5.0581E-41)
                    r8 = r2[r4]     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glFramebufferRenderbuffer(r3, r5, r7, r8)     // Catch:{ all -> 0x00e6 }
                    int r5 = com.atakmap.opengl.GLES20FixedPipeline.glCheckFramebufferStatus(r3)     // Catch:{ all -> 0x00e6 }
                    r7 = 36053(0x8cd5, float:5.0521E-41)
                    if (r5 != r7) goto L_0x00b5
                    r5 = 0
                    com.atakmap.opengl.GLES20FixedPipeline.glClearColor(r5, r5, r5, r5)     // Catch:{ all -> 0x00e6 }
                    r5 = 16384(0x4000, float:2.2959E-41)
                    com.atakmap.opengl.GLES20FixedPipeline.glClear(r5)     // Catch:{ all -> 0x00e6 }
                    com.atakmap.android.maps.MapView r5 = com.atakmap.android.maps.MapView.getMapView()     // Catch:{ all -> 0x00e6 }
                    com.atakmap.map.opengl.GLMapSurface r5 = r5.getGLSurface()     // Catch:{ all -> 0x00e6 }
                    com.atakmap.map.opengl.GLMapView r5 = r5.getGLMapView()     // Catch:{ all -> 0x00e6 }
                    r5.render()     // Catch:{ all -> 0x00e6 }
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot r5 = com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot.this     // Catch:{ all -> 0x00e6 }
                    r5.readPixels()     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glBindFramebuffer(r3, r4)     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteFramebuffers(r0, r1, r4)     // Catch:{ all -> 0x00e6 }
                    r1[r4] = r4     // Catch:{ all -> 0x00e6 }
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteRenderbuffers(r0, r2, r4)     // Catch:{ all -> 0x00e6 }
                    r2[r4] = r4     // Catch:{ all -> 0x00e6 }
                    r6.release()     // Catch:{ all -> 0x00e6 }
                    r5 = r1[r4]
                    if (r5 == 0) goto L_0x009d
                    com.atakmap.opengl.GLES20FixedPipeline.glBindFramebuffer(r3, r4)
                L_0x009d:
                    r3 = r1[r4]
                    if (r3 == 0) goto L_0x00a4
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteFramebuffers(r0, r1, r4)
                L_0x00a4:
                    r1 = r2[r4]
                    if (r1 == 0) goto L_0x00ab
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteRenderbuffers(r0, r2, r4)
                L_0x00ab:
                    com.atakmap.android.maps.MapView r0 = com.atakmap.android.maps.MapView.getMapView()
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$2 r1 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$2
                    r1.<init>()
                    goto L_0x011d
                L_0x00b5:
                    java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x00e6 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e6 }
                    r7.<init>()     // Catch:{ all -> 0x00e6 }
                    java.lang.String r8 = "Failed to set up FBO, code=0x"
                    r7.append(r8)     // Catch:{ all -> 0x00e6 }
                    int r8 = com.atakmap.opengl.GLES20FixedPipeline.glGetError()     // Catch:{ all -> 0x00e6 }
                    r9 = 16
                    java.lang.String r8 = java.lang.Integer.toString(r8, r9)     // Catch:{ all -> 0x00e6 }
                    r7.append(r8)     // Catch:{ all -> 0x00e6 }
                    java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e6 }
                    r5.<init>(r7)     // Catch:{ all -> 0x00e6 }
                    throw r5     // Catch:{ all -> 0x00e6 }
                L_0x00d6:
                    java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x00e6 }
                    java.lang.String r7 = "Failed to create Depth Buffer"
                    r5.<init>(r7)     // Catch:{ all -> 0x00e6 }
                    throw r5     // Catch:{ all -> 0x00e6 }
                L_0x00de:
                    java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x00e6 }
                    java.lang.String r7 = "Failed to create FBO"
                    r5.<init>(r7)     // Catch:{ all -> 0x00e6 }
                    throw r5     // Catch:{ all -> 0x00e6 }
                L_0x00e6:
                    r5 = move-exception
                    goto L_0x00ec
                L_0x00e8:
                    r6 = move-exception
                    r10 = r6
                    r6 = r5
                    r5 = r10
                L_0x00ec:
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$1 r7 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$1     // Catch:{ all -> 0x0121 }
                    java.lang.String r8 = "TakeSnapshot-Complete"
                    r7.<init>(r8, r5)     // Catch:{ all -> 0x0121 }
                    r5 = 5
                    r7.setPriority(r5)     // Catch:{ all -> 0x0121 }
                    r7.start()     // Catch:{ all -> 0x0121 }
                    r5 = r1[r4]
                    if (r5 == 0) goto L_0x0101
                    com.atakmap.opengl.GLES20FixedPipeline.glBindFramebuffer(r3, r4)
                L_0x0101:
                    if (r6 == 0) goto L_0x0106
                    r6.release()
                L_0x0106:
                    r3 = r1[r4]
                    if (r3 == 0) goto L_0x010d
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteFramebuffers(r0, r1, r4)
                L_0x010d:
                    r1 = r2[r4]
                    if (r1 == 0) goto L_0x0114
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteRenderbuffers(r0, r2, r4)
                L_0x0114:
                    com.atakmap.android.maps.MapView r0 = com.atakmap.android.maps.MapView.getMapView()
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$2 r1 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$2
                    r1.<init>()
                L_0x011d:
                    r0.post(r1)
                    return
                L_0x0121:
                    r5 = move-exception
                    r7 = r1[r4]
                    if (r7 == 0) goto L_0x0129
                    com.atakmap.opengl.GLES20FixedPipeline.glBindFramebuffer(r3, r4)
                L_0x0129:
                    if (r6 == 0) goto L_0x012e
                    r6.release()
                L_0x012e:
                    r3 = r1[r4]
                    if (r3 == 0) goto L_0x0135
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteFramebuffers(r0, r1, r4)
                L_0x0135:
                    r1 = r2[r4]
                    if (r1 == 0) goto L_0x013c
                    com.atakmap.opengl.GLES20FixedPipeline.glDeleteRenderbuffers(r0, r2, r4)
                L_0x013c:
                    com.atakmap.android.maps.MapView r0 = com.atakmap.android.maps.MapView.getMapView()
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$2 r1 = new com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot$2$2
                    r1.<init>()
                    r0.post(r1)
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.default_ui.TakeScreenshot.C18082.run():void");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void snap() {
        MapView.getMapView().post(new Runnable() {
            public void run() {
                ((w) MapView.getMapView().b("rootLayoutWidget")).a_(false);
                TakeScreenshot.this.init();
            }
        });
    }
}
