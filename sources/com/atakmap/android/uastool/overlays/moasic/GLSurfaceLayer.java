package com.atakmap.android.uastool.overlays.moasic;

import android.graphics.Bitmap;
import android.util.Pair;
import com.atakmap.android.uastool.overlays.moasic.SurfaceLayer;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.g;
import com.atakmap.map.layer.Layer;
import com.atakmap.map.layer.opengl.GLLayer2;
import com.atakmap.map.layer.opengl.GLLayerSpi2;
import com.atakmap.map.layer.opengl.a;
import com.atakmap.map.opengl.GLMapView;
import com.atakmap.opengl.GLTexture;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public class GLSurfaceLayer extends a implements SurfaceLayer.OnChangedListener {
    public static final GLLayerSpi2 SPI = new GLLayerSpi2() {
        public int getPriority() {
            return 1;
        }

        public GLLayer2 create(Pair<g, Layer> pair) {
            if (!(pair.second instanceof SurfaceLayer)) {
                return null;
            }
            return new GLSurfaceLayer((g) pair.first, (SurfaceLayer) pair.second);
        }
    };
    /* access modifiers changed from: private */
    public Data frame;
    private final SurfaceLayer subject;

    public GLSurfaceLayer(g gVar, SurfaceLayer surfaceLayer) {
        super(gVar, surfaceLayer);
        this.subject = surfaceLayer;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8982a() {
        GLSurfaceLayer.super.a();
        this.subject.addOnChangedListener(this);
        this.frame = new Data();
        setData(this.subject.layerARGB, this.subject.layerWidth, this.subject.layerHeight, this.subject.upperLeft, this.subject.upperRight, this.subject.lowerRight, this.subject.lowerLeft);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8983a(GLMapView gLMapView) {
        gLMapView.forward(this.frame.points, this.frame.vertexCoordinates);
        if (this.frame.texture != null) {
            this.frame.texture.draw(4, 5126, this.frame.textureCoordinates, this.frame.vertexCoordinates);
        }
    }

    public void release() {
        this.subject.removeOnChangedListener(this);
        Data data = this.frame;
        if (!(data == null || data.texture == null)) {
            this.frame.texture.release();
        }
        this.frame = null;
        GLSurfaceLayer.super.release();
    }

    public void setData(int[] iArr, int i, int i2, GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3, GeoPoint geoPoint4) {
        int[] iArr2 = iArr;
        final int i3 = i;
        final int i4 = i2;
        final Bitmap createBitmap = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
        final GeoPoint geoPoint5 = new GeoPoint(geoPoint);
        final GeoPoint geoPoint6 = new GeoPoint(geoPoint2);
        final GeoPoint geoPoint7 = new GeoPoint(geoPoint3);
        final GeoPoint geoPoint8 = new GeoPoint(geoPoint4);
        this.b.queueEvent(new Runnable() {
            public void run() {
                try {
                    if (GLSurfaceLayer.this.frame != null) {
                        GLSurfaceLayer.this.frame.update(createBitmap, i3, i4, geoPoint5, geoPoint6, geoPoint7, geoPoint8);
                    }
                } finally {
                    createBitmap.recycle();
                }
            }
        });
    }

    public void onChanged() {
        setData(this.subject.layerARGB, this.subject.layerWidth, this.subject.layerHeight, this.subject.upperLeft, this.subject.upperRight, this.subject.lowerRight, this.subject.lowerLeft);
    }

    private static class Data {
        final DoubleBuffer points = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asDoubleBuffer();
        GLTexture texture = null;
        final ByteBuffer textureCoordinates = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        final FloatBuffer vertexCoordinates = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();

        Data() {
        }

        /* access modifiers changed from: package-private */
        public void update(Bitmap bitmap, int i, int i2, GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3, GeoPoint geoPoint4) {
            GLTexture gLTexture = this.texture;
            if (gLTexture == null || gLTexture.getTexWidth() < i || this.texture.getTexHeight() < i2) {
                GLTexture gLTexture2 = this.texture;
                if (gLTexture2 != null) {
                    gLTexture2.release();
                }
                this.texture = new GLTexture(i, i2, bitmap.getConfig());
            }
            this.texture.load((Buffer) null, 0, 0, i, i2);
            this.textureCoordinates.clear();
            this.textureCoordinates.putFloat(0.0f);
            this.textureCoordinates.putFloat(0.0f);
            float f = (float) i;
            this.textureCoordinates.putFloat(f / ((float) this.texture.getTexWidth()));
            this.textureCoordinates.putFloat(0.0f);
            this.textureCoordinates.putFloat(f / ((float) this.texture.getTexWidth()));
            float f2 = (float) i2;
            this.textureCoordinates.putFloat(f2 / ((float) this.texture.getTexHeight()));
            this.textureCoordinates.putFloat(0.0f);
            this.textureCoordinates.putFloat(f2 / ((float) this.texture.getTexHeight()));
            this.textureCoordinates.flip();
            this.points.clear();
            this.points.put(geoPoint.getLongitude());
            this.points.put(geoPoint.getLatitude());
            this.points.put(geoPoint2.getLongitude());
            this.points.put(geoPoint2.getLatitude());
            this.points.put(geoPoint3.getLongitude());
            this.points.put(geoPoint3.getLatitude());
            this.points.put(geoPoint4.getLongitude());
            this.points.put(geoPoint4.getLatitude());
            this.points.flip();
            this.texture.load(bitmap);
        }
    }
}
