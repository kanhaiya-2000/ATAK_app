package com.atakmap.android.uastool.overlays.moasic;

import android.content.Context;
import android.graphics.Bitmap;
import com.atakmap.android.maps.ar;
import com.atakmap.android.menu.k;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.coremap.maps.coords.GeoBounds;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.GeoPointMetaData;
import com.atakmap.coremap.maps.coords.MutableGeoBounds;
import com.atakmap.map.layer.a;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SurfaceLayer extends a {
    public static final String TAG = "SurfaceLayer";
    private final List<OnChangedListener> _listeners = new ArrayList();
    private String friendlyName = "";
    protected int[] layerARGB;
    protected int layerHeight;
    protected int layerWidth;
    protected final GeoPoint lowerLeft;
    protected final GeoPoint lowerRight;
    private final ar metaShape;
    private final Context pluginContext;
    protected final GeoPoint upperLeft;
    protected final GeoPoint upperRight;

    public interface OnChangedListener {
        void onChanged();
    }

    public void setFriendlyName(String str) {
        if (str != null && !str.isEmpty()) {
            this.friendlyName = str;
        }
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public SurfaceLayer(Context context, FieldOfView fieldOfView, String str, Bitmap bitmap) {
        super(str);
        this.pluginContext = context;
        GeoPoint createMutable = GeoPoint.createMutable();
        this.upperLeft = createMutable;
        GeoPoint createMutable2 = GeoPoint.createMutable();
        this.upperRight = createMutable2;
        GeoPoint createMutable3 = GeoPoint.createMutable();
        this.lowerRight = createMutable3;
        GeoPoint createMutable4 = GeoPoint.createMutable();
        this.lowerLeft = createMutable4;
        createMutable.set(fieldOfView.f8422tl.x, fieldOfView.f8422tl.y);
        createMutable2.set(fieldOfView.f8423tr.x, fieldOfView.f8423tr.y);
        createMutable3.set(fieldOfView.f8421br.x, fieldOfView.f8421br.y);
        createMutable4.set(fieldOfView.f8420bl.x, fieldOfView.f8420bl.y);
        this.layerWidth = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.layerHeight = height;
        int i = this.layerWidth;
        int[] iArr = new int[(height * i)];
        this.layerARGB = iArr;
        bitmap.getPixels(iArr, 0, i, 0, 0, i, height);
        C15731 r10 = new ar(UUID.randomUUID().toString()) {
            public GeoPointMetaData[] getMetaDataPoints() {
                return GeoPointMetaData.wrap(SurfaceLayer.this.getPoints());
            }

            public GeoPoint[] getPoints() {
                return SurfaceLayer.this.getPoints();
            }

            public GeoBounds getBounds(MutableGeoBounds mutableGeoBounds) {
                return SurfaceLayer.this.getBounds();
            }
        };
        this.metaShape = r10;
        r10.setMetaString(FlightLogger.LOG_CALLSIGN, str);
        r10.setMetaString("shapeName", str);
        r10.setType("uastool_imaging_layer");
        r10.setMetaString("menu", k.a(context, "menus/layer_menu.xml"));
    }

    public SurfaceLayer(Context context, String str, Bitmap bitmap, GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3, GeoPoint geoPoint4) {
        super(str);
        this.pluginContext = context;
        GeoPoint createMutable = GeoPoint.createMutable();
        this.upperLeft = createMutable;
        GeoPoint createMutable2 = GeoPoint.createMutable();
        this.upperRight = createMutable2;
        GeoPoint createMutable3 = GeoPoint.createMutable();
        this.lowerRight = createMutable3;
        GeoPoint createMutable4 = GeoPoint.createMutable();
        this.lowerLeft = createMutable4;
        createMutable.set(geoPoint);
        createMutable2.set(geoPoint2);
        createMutable3.set(geoPoint4);
        createMutable4.set(geoPoint3);
        this.layerWidth = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.layerHeight = height;
        int i = this.layerWidth;
        int[] iArr = new int[(height * i)];
        this.layerARGB = iArr;
        bitmap.getPixels(iArr, 0, i, 0, 0, i, height);
        C15742 r11 = new ar(UUID.randomUUID().toString()) {
            public GeoPointMetaData[] getMetaDataPoints() {
                return GeoPointMetaData.wrap(SurfaceLayer.this.getPoints());
            }

            public GeoPoint[] getPoints() {
                return SurfaceLayer.this.getPoints();
            }

            public GeoBounds getBounds(MutableGeoBounds mutableGeoBounds) {
                return SurfaceLayer.this.getBounds();
            }
        };
        this.metaShape = r11;
        r11.setMetaString(FlightLogger.LOG_CALLSIGN, str);
        r11.setMetaString("shapeName", str);
        r11.setType("uastool_imaging_layer");
        r11.setMetaString("menu", k.a(context, "menus/layer_menu.xml"));
    }

    public GeoBounds getBounds() {
        return GeoBounds.createFromPoints(getPoints());
    }

    public GeoPoint[] getPoints() {
        return new GeoPoint[]{this.upperLeft, this.upperRight, this.lowerRight, this.lowerLeft};
    }

    public ar getMetaShape() {
        return this.metaShape;
    }

    public void update(FieldOfView fieldOfView, Bitmap bitmap) {
        if (fieldOfView != null && fieldOfView.isValid() && bitmap != null && !bitmap.isRecycled()) {
            this.upperLeft.set(fieldOfView.f8422tl.x, fieldOfView.f8422tl.y);
            this.upperRight.set(fieldOfView.f8423tr.x, fieldOfView.f8423tr.y);
            this.lowerRight.set(fieldOfView.f8421br.x, fieldOfView.f8421br.y);
            this.lowerLeft.set(fieldOfView.f8420bl.x, fieldOfView.f8420bl.y);
            this.layerWidth = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.layerHeight = height;
            int i = this.layerWidth;
            int[] iArr = new int[(height * i)];
            this.layerARGB = iArr;
            bitmap.getPixels(iArr, 0, i, 0, 0, i, height);
            onChanged();
        }
    }

    public synchronized void onChanged() {
        for (OnChangedListener onChanged : this._listeners) {
            onChanged.onChanged();
        }
    }

    public synchronized void addOnChangedListener(OnChangedListener onChangedListener) {
        if (!this._listeners.contains(onChangedListener)) {
            this._listeners.add(onChangedListener);
        }
    }

    public synchronized void removeOnChangedListener(OnChangedListener onChangedListener) {
        this._listeners.remove(onChangedListener);
    }
}
