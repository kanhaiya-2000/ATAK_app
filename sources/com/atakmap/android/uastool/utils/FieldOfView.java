package com.atakmap.android.uastool.utils;

import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.coords.GeoCalculations;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import com.atakmap.math.PointD;
import indago.serialization.JsonValueConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class FieldOfView {
    public static final double DEFAULT_TARGET_DISTANCE_METERS = 300.0d;
    public static final double MAX_FOV_DISTANCE = 10000.0d;
    private static final double MAX_GIMBAL_PITCH_ANGLE = -2.0d;
    private static final String TAG = "FieldOfView";
    private static final ag segmentGroup = null;
    private static final Set<ai> segmentItems = new HashSet();

    /* renamed from: bl */
    public PointD f8420bl;

    /* renamed from: br */
    public PointD f8421br;
    public AtomicReference<GeoPoint> center = new AtomicReference<>((Object) null);
    public long lastUpdateTime;

    /* renamed from: tl */
    public PointD f8422tl;

    /* renamed from: tr */
    public PointD f8423tr;

    public String toString() {
        return String.format("TL:%s TR:%s BR:%s BL:%s", new Object[]{this.f8422tl, this.f8423tr, this.f8421br, this.f8420bl});
    }

    private static CotDetail getPolyLineVertex(PointD pointD) {
        CotDetail cotDetail = new CotDetail("vertex");
        cotDetail.setAttribute(FlightLogger.LOCS_LONGITUDE, String.valueOf(pointD.y));
        cotDetail.setAttribute(FlightLogger.LOCS_LATITUDE, String.valueOf(pointD.x));
        cotDetail.setAttribute("hae", JsonValueConstants.VERSION);
        return cotDetail;
    }

    public CotDetail getSpiShape() {
        CotDetail cotDetail = new CotDetail("shape");
        CotDetail cotDetail2 = new CotDetail("polyline");
        cotDetail2.setAttribute("closed", "true");
        cotDetail2.addChild(getPolyLineVertex(this.f8422tl));
        cotDetail2.addChild(getPolyLineVertex(this.f8423tr));
        cotDetail2.addChild(getPolyLineVertex(this.f8421br));
        cotDetail2.addChild(getPolyLineVertex(this.f8420bl));
        cotDetail.addChild(cotDetail2);
        return cotDetail;
    }

    private static boolean isValid(PointD pointD) {
        return pointD != null && !Double.isNaN(pointD.x) && !Double.isNaN(pointD.y);
    }

    private static void invalidate(PointD pointD) {
        if (pointD != null) {
            pointD.x = Double.NaN;
            pointD.y = Double.NaN;
        }
    }

    public boolean isValid() {
        return isValid(this.f8422tl) && isValid(this.f8423tr) && isValid(this.f8421br) && isValid(this.f8420bl);
    }

    public void invalidate() {
        invalidate(this.f8422tl);
        invalidate(this.f8423tr);
        invalidate(this.f8421br);
        invalidate(this.f8420bl);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.atakmap.android.uastool.utils.FieldOfView computeFov(com.atakmap.coremap.maps.coords.GeoPoint r17, double r18, double r20, double r22, double r24, boolean r26) {
        /*
            r1 = r17
            r2 = 0
            if (r1 == 0) goto L_0x010e
            boolean r0 = r17.isValid()
            if (r0 != 0) goto L_0x000d
            goto L_0x010e
        L_0x000d:
            com.atakmap.android.uastool.utils.FieldOfView r3 = new com.atakmap.android.uastool.utils.FieldOfView
            r3.<init>()
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r24 / r4
            double r6 = java.lang.Math.toRadians(r6)
            double r6 = java.lang.Math.tan(r6)
            double r4 = r22 / r4
            double r4 = java.lang.Math.toRadians(r4)
            double r4 = java.lang.Math.tan(r4)
            r8 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            com.atakmap.android.uastool.utils.Matrix3D r0 = transformCameraToDrone(r18, r20)     // Catch:{ Exception -> 0x00a0 }
            com.atakmap.android.uastool.utils.Point3D r10 = new com.atakmap.android.uastool.utils.Point3D     // Catch:{ Exception -> 0x00a0 }
            double r11 = -r6
            r13 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r18 = r10
            r19 = r11
            r21 = r4
            r23 = r13
            r18.<init>(r19, r21, r23)     // Catch:{ Exception -> 0x00a0 }
            com.atakmap.coremap.maps.coords.GeoPoint r10 = getProjectionPoint(r1, r0, r10)     // Catch:{ Exception -> 0x00a0 }
            com.atakmap.android.uastool.utils.Point3D r13 = new com.atakmap.android.uastool.utils.Point3D     // Catch:{ Exception -> 0x009b }
            r14 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r18 = r13
            r19 = r6
            r21 = r4
            r23 = r14
            r18.<init>(r19, r21, r23)     // Catch:{ Exception -> 0x009b }
            com.atakmap.coremap.maps.coords.GeoPoint r13 = getProjectionPoint(r1, r0, r13)     // Catch:{ Exception -> 0x009b }
            com.atakmap.android.uastool.utils.Point3D r14 = new com.atakmap.android.uastool.utils.Point3D     // Catch:{ Exception -> 0x0097 }
            double r4 = -r4
            r15 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r18 = r14
            r19 = r6
            r21 = r4
            r23 = r15
            r18.<init>(r19, r21, r23)     // Catch:{ Exception -> 0x0097 }
            com.atakmap.coremap.maps.coords.GeoPoint r6 = getProjectionPoint(r1, r0, r14)     // Catch:{ Exception -> 0x0097 }
            com.atakmap.android.uastool.utils.Point3D r7 = new com.atakmap.android.uastool.utils.Point3D     // Catch:{ Exception -> 0x0094 }
            r18 = r7
            r19 = r11
            r21 = r4
            r23 = r8
            r18.<init>(r19, r21, r23)     // Catch:{ Exception -> 0x0094 }
            com.atakmap.coremap.maps.coords.GeoPoint r4 = getProjectionPoint(r1, r0, r7)     // Catch:{ Exception -> 0x0094 }
            com.atakmap.android.uastool.utils.Point3D r5 = new com.atakmap.android.uastool.utils.Point3D     // Catch:{ Exception -> 0x0092 }
            r7 = 0
            r11 = 0
            r14 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r18 = r5
            r19 = r7
            r21 = r11
            r23 = r14
            r18.<init>(r19, r21, r23)     // Catch:{ Exception -> 0x0092 }
            com.atakmap.coremap.maps.coords.GeoPoint r2 = getProjectionPoint(r1, r0, r5)     // Catch:{ Exception -> 0x0092 }
            goto L_0x00ac
        L_0x0092:
            r0 = move-exception
            goto L_0x00a5
        L_0x0094:
            r0 = move-exception
            r4 = r2
            goto L_0x00a5
        L_0x0097:
            r0 = move-exception
            r4 = r2
            r6 = r4
            goto L_0x00a5
        L_0x009b:
            r0 = move-exception
            r4 = r2
            r6 = r4
            r13 = r6
            goto L_0x00a5
        L_0x00a0:
            r0 = move-exception
            r4 = r2
            r6 = r4
            r10 = r6
            r13 = r10
        L_0x00a5:
            java.lang.String r5 = TAG
            java.lang.String r7 = "error"
            com.atakmap.coremap.log.Log.e(r5, r7, r0)
        L_0x00ac:
            r7 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            if (r13 == 0) goto L_0x00ee
            if (r10 == 0) goto L_0x00ee
            if (r4 == 0) goto L_0x00ee
            if (r6 != 0) goto L_0x00ba
            goto L_0x00ee
        L_0x00ba:
            double r11 = r1.distanceTo(r13)
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x00ea
            double r11 = r1.distanceTo(r10)
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x00cb
            goto L_0x00ea
        L_0x00cb:
            com.atakmap.math.PointD r0 = geoPointToPointD(r13)
            r3.f8422tl = r0
            com.atakmap.math.PointD r0 = geoPointToPointD(r10)
            r3.f8423tr = r0
            com.atakmap.math.PointD r0 = geoPointToPointD(r4)
            r3.f8421br = r0
            com.atakmap.math.PointD r0 = geoPointToPointD(r6)
            r3.f8420bl = r0
            long r4 = java.lang.System.currentTimeMillis()
            r3.lastUpdateTime = r4
            goto L_0x00f1
        L_0x00ea:
            r3.invalidate()
            goto L_0x00f1
        L_0x00ee:
            r3.invalidate()
        L_0x00f1:
            if (r2 == 0) goto L_0x0108
            double r4 = r1.distanceTo(r2)
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0108
            boolean r0 = r2.isValid()
            if (r0 != 0) goto L_0x0102
            goto L_0x0108
        L_0x0102:
            java.util.concurrent.atomic.AtomicReference<com.atakmap.coremap.maps.coords.GeoPoint> r0 = r3.center
            r0.set(r2)
            goto L_0x010d
        L_0x0108:
            java.util.concurrent.atomic.AtomicReference<com.atakmap.coremap.maps.coords.GeoPoint> r0 = r3.center
            r0.set(r1)
        L_0x010d:
            return r3
        L_0x010e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.FieldOfView.computeFov(com.atakmap.coremap.maps.coords.GeoPoint, double, double, double, double, boolean):com.atakmap.android.uastool.utils.FieldOfView");
    }

    public static PointD geoPointToPointD(GeoPoint geoPoint) {
        return new PointD(geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude());
    }

    public static GeoPoint pointDToGeoPoint(PointD pointD) {
        return new GeoPoint(pointD.x, pointD.y, pointD.z);
    }

    public List<GeoPoint> getFieldOfViewList() {
        if (!isValid()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(pointDToGeoPoint(this.f8422tl));
        arrayList.add(pointDToGeoPoint(this.f8423tr));
        arrayList.add(pointDToGeoPoint(this.f8421br));
        arrayList.add(pointDToGeoPoint(this.f8420bl));
        return arrayList;
    }

    public static Matrix3D transformDroneToCamera(double d, double d2) {
        return Matrix3D.getPitchMatrix(d).dot(Matrix3D.getRotateZMatrix(d2));
    }

    public static Matrix3D transformCameraToDrone(double d, double d2) {
        return transformDroneToCamera(d, d2).transpose();
    }

    public static GeoPoint getProjectionPoint(GeoPoint geoPoint, Matrix3D matrix3D, Point3D point3D) {
        double d;
        double altitude = geoPoint.getAltitude();
        double a = ElevationManager.a(geoPoint.getLatitude(), geoPoint.getLongitude(), (ElevationManager.b) null);
        Point3D unitVector = new Point3D(0.0d, 0.0d, altitude - a).toUnitVector();
        int i = 0;
        GeoPoint geoPoint2 = null;
        while (true) {
            if (i >= 3) {
                d = a;
                break;
            }
            Point3D point3D2 = new Point3D(0.0d, 0.0d, a - altitude);
            Point3D transform = matrix3D.transform(point3D);
            double dot = unitVector.dot(point3D2) / unitVector.dot(transform);
            if (dot >= 0.0d) {
                return null;
            }
            Point3D scale = transform.toUnitVector().scale(dot);
            double XYMagnitude = scale.XYMagnitude();
            if (XYMagnitude > 10000.0d) {
                return null;
            }
            geoPoint2 = GeoCalculations.pointAtDistance(geoPoint, Math.toDegrees(Math.atan2(scale.x, scale.y)), XYMagnitude);
            double a2 = ElevationManager.a(geoPoint2.getLatitude(), geoPoint2.getLongitude(), (ElevationManager.b) null);
            if (a - a2 < a * 0.1d) {
                d = a2;
                break;
            }
            i++;
            a = a2;
        }
        return new GeoPoint(geoPoint2.getLatitude(), geoPoint2.getLongitude(), d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092 A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.atakmap.android.uastool.utils.FieldOfView computeFOVFromEXIF(androidx.exifinterface.media.ExifInterface r33) {
        /*
            r1 = r33
            java.lang.String r0 = "GPSImgDirection"
            java.lang.String r2 = "GPSAltitude"
            java.lang.String r3 = "ImgPitch"
            java.lang.String r4 = "VerticalFOV"
            java.lang.String r5 = "HorizontalFOV"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = 0
            if (r1 == 0) goto L_0x011f
            r8 = 1
            java.lang.String r9 = "UserComment"
            java.lang.String r9 = r1.getAttribute(r9)     // Catch:{ Exception -> 0x00b1 }
            double[] r10 = r33.getLatLong()     // Catch:{ Exception -> 0x00b1 }
            r11 = 0
            r12 = 0
            if (r9 == 0) goto L_0x0082
            boolean r14 = r9.isEmpty()     // Catch:{ Exception -> 0x0080 }
            if (r14 != 0) goto L_0x0082
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0080 }
            r14.<init>(r9)     // Catch:{ Exception -> 0x0080 }
            boolean r9 = r14.has(r5)     // Catch:{ Exception -> 0x0080 }
            if (r9 == 0) goto L_0x0082
            boolean r9 = r14.has(r4)     // Catch:{ Exception -> 0x0080 }
            if (r9 == 0) goto L_0x0082
            boolean r9 = r14.has(r3)     // Catch:{ Exception -> 0x0080 }
            if (r9 == 0) goto L_0x0082
            boolean r9 = r1.hasAttribute(r2)     // Catch:{ Exception -> 0x0080 }
            if (r9 == 0) goto L_0x0082
            boolean r9 = r1.hasAttribute(r0)     // Catch:{ Exception -> 0x0080 }
            if (r9 == 0) goto L_0x0082
            if (r10 == 0) goto L_0x0082
            double r15 = r14.getDouble(r5)     // Catch:{ Exception -> 0x0080 }
            double r17 = r14.getDouble(r4)     // Catch:{ Exception -> 0x0080 }
            double r19 = r14.getDouble(r3)     // Catch:{ Exception -> 0x0080 }
            r27 = r10[r11]     // Catch:{ Exception -> 0x0080 }
            r29 = r10[r8]     // Catch:{ Exception -> 0x0080 }
            double r25 = r1.getAltitude(r12)     // Catch:{ Exception -> 0x0080 }
            r21 = r27
            r23 = r29
            double r21 = com.atakmap.coremap.maps.conversion.EGM96.getHAE(r21, r23, r25)     // Catch:{ Exception -> 0x0080 }
            double r12 = r1.getAttributeDouble(r0, r12)     // Catch:{ Exception -> 0x0080 }
            r25 = r12
            r23 = r19
            r13 = r27
            r27 = r17
            r17 = r21
            r31 = r15
            r15 = r29
            r29 = r31
            goto L_0x0090
        L_0x0080:
            r0 = move-exception
            goto L_0x00b3
        L_0x0082:
            r15 = r12
            r17 = r15
            r23 = r17
            r25 = r23
            r27 = r25
            r29 = r27
            r11 = 1
            r13 = r29
        L_0x0090:
            if (r11 != 0) goto L_0x00ae
            com.atakmap.coremap.maps.coords.GeoPoint r12 = com.atakmap.coremap.maps.coords.GeoPoint.createMutable()     // Catch:{ Exception -> 0x0080 }
            r19 = 0
            r21 = 0
            com.atakmap.coremap.maps.coords.GeoPoint r15 = r12.set(r13, r15, r17, r19, r21)     // Catch:{ Exception -> 0x0080 }
            r0 = 0
            r16 = r23
            r18 = r25
            r20 = r27
            r22 = r29
            r24 = r0
            com.atakmap.android.uastool.utils.FieldOfView r0 = computeFov(r15, r16, r18, r20, r22, r24)     // Catch:{ Exception -> 0x0080 }
            goto L_0x00af
        L_0x00ae:
            r0 = r7
        L_0x00af:
            r8 = r11
            goto L_0x00bb
        L_0x00b1:
            r0 = move-exception
            r10 = r7
        L_0x00b3:
            java.lang.String r9 = TAG
            java.lang.String r11 = "Unable to compute FOV from passed EXIF data"
            com.atakmap.coremap.log.Log.d(r9, r11, r0)
            r0 = r7
        L_0x00bb:
            if (r8 != 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00c8
            boolean r8 = r0.isValid()
            if (r8 != 0) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            r7 = r0
            goto L_0x0126
        L_0x00c8:
            boolean r0 = r1.hasAttribute(r5)
            java.lang.String r8 = ", "
            if (r0 != 0) goto L_0x00d6
            r6.append(r5)
            r6.append(r8)
        L_0x00d6:
            boolean r0 = r1.hasAttribute(r4)
            if (r0 != 0) goto L_0x00e2
            r6.append(r4)
            r6.append(r8)
        L_0x00e2:
            boolean r0 = r1.hasAttribute(r3)
            if (r0 != 0) goto L_0x00ee
            r6.append(r3)
            r6.append(r8)
        L_0x00ee:
            boolean r0 = r1.hasAttribute(r2)
            if (r0 != 0) goto L_0x00fa
            r6.append(r2)
            r6.append(r8)
        L_0x00fa:
            if (r10 != 0) goto L_0x0104
            java.lang.String r0 = "LatLon"
            r6.append(r0)
            r6.append(r8)
        L_0x0104:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Missing values: "
            r1.append(r2)
            java.lang.String r2 = r6.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.atakmap.coremap.log.Log.d(r0, r1)
            goto L_0x0126
        L_0x011f:
            java.lang.String r0 = TAG
            java.lang.String r1 = "ExifInterface passed was null"
            com.atakmap.coremap.log.Log.d(r0, r1)
        L_0x0126:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.FieldOfView.computeFOVFromEXIF(androidx.exifinterface.media.ExifInterface):com.atakmap.android.uastool.utils.FieldOfView");
    }
}
