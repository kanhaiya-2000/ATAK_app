package com.atakmap.android.uastool.tflite.tracking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Vibrator;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.o;
import com.atakmap.android.overlay.b;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.overlays.mapshot.MapShotController;
import com.atakmap.android.uastool.overlays.moasic.GLSurfaceLayer;
import com.atakmap.android.uastool.overlays.moasic.SurfaceLayer;
import com.atakmap.android.uastool.prefs.CameraPreferenceFragment;
import com.atakmap.android.uastool.tflite.Detector;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.user.g;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.assets.Icon;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.layer.a;
import com.atakmap.map.layer.opengl.GLLayerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class DetectedItemsList implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static String TAG = "DetectedItemsList";
    private static final Paint paint;
    public ArrayList<Detection> detectionList;
    public ArrayList<a> layerList;
    private boolean shouldDropMarker;
    private boolean shouldVibrate;

    static {
        Paint paint2 = new Paint();
        paint = paint2;
        paint2.setColor(-65536);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2.0f);
    }

    public static class Detection {
        public FieldOfView fieldOfView;
        public ao marker;
        public GeoPoint point;
        public Detector.Recognition recognition;

        public boolean equals(Detection detection) {
            return detection.point.distanceTo(this.point) < 15.0d && this.recognition.getTitle().equals(detection.recognition.getTitle());
        }

        public void createMarker() {
            this.marker = new ao(UUID.randomUUID().toString() + "_DETECTION");
            Icon.Builder builder = new Icon.Builder();
            builder.setImageUri(0, "asset:/icons/default.png");
            builder.setAnchor(24, 24);
            this.marker.a(builder.build());
            this.marker.setZOrder(-10000.0d);
            this.marker.setTitle("");
            this.marker.setVisible(true);
            this.marker.setMovable(true);
            this.marker.setClickable(true);
            this.marker.setMetaString("how", "h-e");
            this.marker.setTouchable(true);
            this.marker.setEditable(true);
            this.marker.setMetaBoolean("removable", true);
            this.marker.setMetaBoolean("movable", true);
            this.marker.setMetaBoolean("clickable", true);
            update(this.point, this.recognition);
            UASItem.getUASToolGroup().d(this.marker);
        }

        public void update(GeoPoint geoPoint, Detector.Recognition recognition2) {
            this.point = geoPoint;
            this.recognition = recognition2;
        }

        public void dispose() {
            UASItem.getUASToolGroup().g(this.marker);
        }
    }

    public DetectedItemsList() {
        this.shouldDropMarker = false;
        this.shouldVibrate = false;
        this.detectionList = new ArrayList<>();
        this.layerList = new ArrayList<>();
        this.shouldDropMarker = UASToolDropDownReceiver.getSharedPrefs().getBoolean(CameraPreferenceFragment.PREF_CAMERA_OBJECTDETECTION_MAPSHOT, false);
        this.shouldVibrate = UASToolDropDownReceiver.getSharedPrefs().getBoolean(CameraPreferenceFragment.PREF_CAMERA_OBJECTDETECTION_VIBRATE, false);
        UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
    }

    public void add(GeoPoint geoPoint, Detector.Recognition recognition, Bitmap bitmap, UASItem uASItem) {
        Vibrator vibrator;
        if (geoPoint != null) {
            Detection detection = new Detection();
            detection.point = geoPoint;
            detection.recognition = recognition;
            if (uASItem != null) {
                detection.fieldOfView = uASItem.computeFov();
            }
            boolean z = false;
            Iterator<Detection> it = this.detectionList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Detection next = it.next();
                if (next.equals(detection)) {
                    z = true;
                    next.update(geoPoint, recognition);
                    break;
                }
            }
            if (!z) {
                this.detectionList.add(detection);
                new Canvas(bitmap).drawRect(recognition.getLocation(), paint);
                if (this.shouldDropMarker) {
                    dropMapshotMarker(detection, bitmap, uASItem);
                }
                if (this.shouldVibrate && (vibrator = (Vibrator) MapView.getMapView().getContext().getSystemService("vibrator")) != null) {
                    vibrator.vibrate(500);
                }
            }
        }
    }

    public void dispose() {
        Iterator<Detection> it = this.detectionList.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
        Iterator<a> it2 = this.layerList.iterator();
        while (it2.hasNext()) {
            MapView.getMapView().b(MapView.a.c, it2.next());
        }
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r8 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dropMapshotMarker(com.atakmap.android.uastool.tflite.tracking.DetectedItemsList.Detection r7, android.graphics.Bitmap r8, com.atakmap.android.uastool.UASItem r9) {
        /*
            r6 = this;
            if (r9 != 0) goto L_0x000a
            java.lang.String r7 = TAG
            java.lang.String r8 = "Can not drop mapshot without a valid UASItem"
            com.atakmap.coremap.log.Log.e(r7, r8)
            return
        L_0x000a:
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "map"
            java.lang.String r1 = com.atakmap.android.uastool.UASToolDropDownReceiver.getPicSavePath(r1, r0)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            r3 = 1
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0043 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0043 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0031 }
            r5 = 90
            r8.compress(r2, r5, r4)     // Catch:{ all -> 0x0031 }
            r4.flush()     // Catch:{ all -> 0x0031 }
            r4.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0063
        L_0x0031:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r2 = move-exception
            if (r8 == 0) goto L_0x003f
            r4.close()     // Catch:{ all -> 0x003a }
            goto L_0x0042
        L_0x003a:
            r4 = move-exception
            r8.addSuppressed(r4)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0042
        L_0x003f:
            r4.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0042:
            throw r2     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Mapshot failed: "
            r2.append(r4)
            java.lang.String r4 = r8.getLocalizedMessage()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r2, r3)
            java.lang.String r2 = TAG
            java.lang.String r4 = "Mapshot Error: "
            com.atakmap.coremap.log.Log.d(r2, r4, r8)
        L_0x0063:
            com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
            java.lang.String r8 = com.atakmap.android.uastool.UASToolDropDownReceiver.addEXIFData(r1, r9)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 == 0) goto L_0x007d
            boolean r7 = r6.dropMarker(r0, r7)
            if (r7 == 0) goto L_0x0077
            goto L_0x0091
        L_0x0077:
            java.lang.String r7 = "Camerashot failed to drop map marker."
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r7, r3)
            goto L_0x0091
        L_0x007d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Camerashot failed to write EXIF data: "
            r7.append(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r7, r3)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tflite.tracking.DetectedItemsList.dropMapshotMarker(com.atakmap.android.uastool.tflite.tracking.DetectedItemsList$Detection, android.graphics.Bitmap, com.atakmap.android.uastool.UASItem):void");
    }

    public void dropMapShotOverlayLayer(Detection detection, Bitmap bitmap) {
        String str = TAG;
        Log.d(str, "Field of View: " + detection.fieldOfView);
        if (detection.fieldOfView == null || !detection.fieldOfView.isValid()) {
            UASToolDropDownReceiver.toast("could not add layer");
            return;
        }
        GLLayerFactory.a(GLSurfaceLayer.SPI);
        SurfaceLayer surfaceLayer = new SurfaceLayer(UASToolDropDownReceiver.getInstance().getPluginContext(), detection.fieldOfView, detection.recognition.getTitle(), bitmap);
        MapView.getMapView().a(MapView.a.c, surfaceLayer);
        surfaceLayer.setVisible(true);
        AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.REFRESH_HIERARCHY"));
        this.layerList.add(surfaceLayer);
    }

    private boolean dropMarker(String str, Detection detection) {
        GeoPoint geoPoint = detection.point;
        if (geoPoint != null) {
            g.a aVar = new g.a(geoPoint);
            aVar.b(str);
            aVar.f(false);
            aVar.a("b-i-x-i");
            ao a = aVar.a();
            if (a == null) {
                return false;
            }
            a.setTitle(String.format("%s %.0f%%", new Object[]{detection.recognition.getTitle(), Float.valueOf(detection.recognition.getConfidence().floatValue() * 100.0f)}));
            a.setMetaBoolean("removable", true);
            a.persist(MapView.getMapView().getMapEventDispatcher(), (Bundle) null, getClass());
            o c = MapView.getMapView().getRootGroup().c(MapShotController.UAS_GROUP_NAME);
            if (c == null) {
                c = new o(MapShotController.UAS_GROUP_NAME);
                MapView.getMapView().getMapOverlayManager().f(new b(MapView.getMapView(), c));
            }
            c.d(a);
            return true;
        }
        UASToolDropDownReceiver.toast("Unable to drop map marker for picture (no GPS?)", 1);
        return false;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals(CameraPreferenceFragment.PREF_CAMERA_OBJECTDETECTION_MAPSHOT)) {
            this.shouldDropMarker = sharedPreferences.getBoolean(CameraPreferenceFragment.PREF_CAMERA_OBJECTDETECTION_MAPSHOT, false);
        } else if (str.equals(CameraPreferenceFragment.PREF_CAMERA_OBJECTDETECTION_VIBRATE)) {
            this.shouldVibrate = sharedPreferences.getBoolean(CameraPreferenceFragment.PREF_CAMERA_OBJECTDETECTION_VIBRATE, false);
        }
    }
}
