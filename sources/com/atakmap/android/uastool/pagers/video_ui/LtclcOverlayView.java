package com.atakmap.android.uastool.pagers.video_ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.icons.IconsMapAdapter;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.bb;
import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.uastool.utils.Point3D;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.atakmap.math.PointD;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LtclcOverlayView extends SurfaceView {
    private static final boolean DEBUG_SHOW_FOV_REGION = false;
    private static final double EARTH_RADIUS = 6378137.0d;
    /* access modifiers changed from: private */
    public static final String TAG = "LtclcOverlayView";
    private final AtomicReference<GeoPoint> centerPoint = new AtomicReference<>((Object) null);
    private final AtomicReference<GeoPoint> dronePosition = new AtomicReference<>();
    private final ExecutorService fovUpdater = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1));
    private final ReentrantReadWriteLock geoRefLock = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */
    public GestureDetector gestureDetector;
    private Double gimbalPitch;
    private Double horizontalFov;
    private IconsMapAdapter iconAdapter;
    private volatile boolean isOperator;
    private final long lastUpdateMs = -1;
    private final AtomicReference<FieldOfView> mFieldOfView = new AtomicReference<>((Object) null);
    protected UASItem selectedUASItem;
    private Double sensorHeading;
    private boolean useDted;
    private Double verticalFov;
    private final AtomicInteger viewHeight = new AtomicInteger(-1);
    private final AtomicInteger viewWidth = new AtomicInteger(-1);

    public static class HorizontalVertical {
        float horizontal;
        float vertical;
    }

    public static class LatLon {
        public double alt;
        public double lat;
        public double lon;
    }

    private void buildPolyline() {
    }

    public void setDimension(int i, int i2) {
        if (this.viewHeight.get() != i2 || this.viewWidth.get() != i) {
            this.viewWidth.set(i);
            this.viewHeight.set(i2);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            setLayoutParams(layoutParams);
            postInvalidate();
            String str = TAG;
            Log.d(str, "Requesting resize to " + i + "x" + i2);
        }
    }

    public void setIsOperator(boolean z) {
        this.isOperator = z;
    }

    public void setDronePosition(GeoPoint geoPoint) {
        this.dronePosition.set(geoPoint);
    }

    public void setFieldOfView(FieldOfView fieldOfView) {
        this.mFieldOfView.set(fieldOfView);
        if (fieldOfView != null && fieldOfView.isValid()) {
            buildPolyline();
        }
    }

    private static void setTitle(ao aoVar, String str) {
        aoVar.setTitle(str);
        aoVar.setMetaString(FlightLogger.LOG_CALLSIGN, str);
    }

    public FieldOfView getFieldOfView() {
        FieldOfView fieldOfView = this.mFieldOfView.get();
        if (fieldOfView == null || !fieldOfView.isValid()) {
            return null;
        }
        return this.mFieldOfView.get();
    }

    private void setupMarker(ao aoVar, String str) {
        aoVar.setClickable(true);
        aoVar.setMetaString("stayopen", "true");
        setTitle(aoVar, "");
        aoVar.a(new Rect(-32, -32, 32, 32));
        aoVar.setMetaBoolean("editable", false);
        aoVar.setMetaBoolean("movable", false);
        aoVar.setMetaBoolean("removable", true);
        aoVar.setType(str);
        aoVar.setMetaString("how", "m-g");
        aoVar.setMetaInteger(UASTask.COTDETAIL_COLOR, Color.argb(255, 255, 0, 255));
        this.iconAdapter.a(aoVar);
        aoVar.setVisible(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void updateTouchMarker(com.atakmap.coremap.maps.coords.GeoPoint r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.atakmap.android.uastool.UASItem r0 = r1.selectedUASItem     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r2 == 0) goto L_0x000c
            r0.setCrossHairLocation(r2)     // Catch:{ all -> 0x000e }
        L_0x000c:
            monitor-exit(r1)
            return
        L_0x000e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.LtclcOverlayView.updateTouchMarker(com.atakmap.coremap.maps.coords.GeoPoint):void");
    }

    /* access modifiers changed from: private */
    public boolean handleSingleTap(MotionEvent motionEvent) {
        onClick(new PointD((double) motionEvent.getX(), (double) motionEvent.getY()));
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public boolean handleLongPress(MotionEvent motionEvent) {
        this.geoRefLock.readLock().lock();
        try {
            cotPointOnClick(new PointD((double) motionEvent.getX(), (double) motionEvent.getY()), this.useDted);
            this.geoRefLock.readLock().unlock();
            return true;
        } catch (Throwable th) {
            this.geoRefLock.readLock().unlock();
            throw th;
        }
    }

    private void initGestureDetector(Context context) {
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public void onShowPress(MotionEvent motionEvent) {
            }

            public boolean onDown(MotionEvent motionEvent) {
                return LtclcOverlayView.this.selectedUASItem.isGimbalControlEnabled();
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                LtclcOverlayView.this.onDoubleClick();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return LtclcOverlayView.this.handleSingleTap(motionEvent);
            }

            public void onLongPress(MotionEvent motionEvent) {
                boolean unused = LtclcOverlayView.this.handleLongPress(motionEvent);
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (LtclcOverlayView.this.selectedUASItem.isGimbalControlEnabled()) {
                    return LtclcOverlayView.this.gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
    }

    public LtclcOverlayView(Context context) {
        super(context);
        init();
    }

    public LtclcOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            this.iconAdapter = new IconsMapAdapter(MapView.getMapView().getContext());
        }
        initGestureDetector(getContext());
        setZOrderOnTop(true);
        getHolder().setFormat(-2);
    }

    public double getHorizontalFov() {
        this.geoRefLock.readLock().lock();
        try {
            if (this.horizontalFov == null) {
                this.horizontalFov = Double.valueOf(0.0d);
            }
            return this.horizontalFov.doubleValue();
        } finally {
            this.geoRefLock.readLock().unlock();
        }
    }

    public double getVerticalFov() {
        this.geoRefLock.readLock().lock();
        try {
            if (this.verticalFov == null) {
                this.verticalFov = Double.valueOf(0.0d);
            }
            return this.verticalFov.doubleValue();
        } finally {
            this.geoRefLock.readLock().unlock();
        }
    }

    public Double getGimbalPitch() {
        this.geoRefLock.readLock().lock();
        try {
            if (this.gimbalPitch == null) {
                this.gimbalPitch = Double.valueOf(0.0d);
            }
            return this.gimbalPitch;
        } finally {
            this.geoRefLock.readLock().unlock();
        }
    }

    public void updateGeoreference(double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        if (this.geoRefLock.writeLock().tryLock()) {
            try {
                GeoPoint geoPoint = new GeoPoint(d, d2, d3);
                this.useDted = z;
                this.dronePosition.set(geoPoint);
                this.gimbalPitch = Double.valueOf(d4);
                this.sensorHeading = Double.valueOf(d5);
                this.horizontalFov = Double.valueOf(d6);
                this.verticalFov = Double.valueOf(d7);
                final GeoPoint geoPoint2 = geoPoint;
                final double d8 = d4;
                final double d9 = d5;
                final double d10 = d7;
                final double d11 = d6;
                final boolean z2 = z;
                this.fovUpdater.submit(new Runnable() {
                    public void run() {
                        FieldOfView computeFov = FieldOfView.computeFov(geoPoint2, d8, d9, d10, d11, z2);
                        LtclcOverlayView.this.setDronePosition(geoPoint2);
                        LtclcOverlayView.this.setFieldOfView(computeFov);
                    }
                });
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                this.geoRefLock.writeLock().unlock();
                throw th;
            }
            this.geoRefLock.writeLock().unlock();
            return;
        }
        Log.d(TAG, "geoRefLock FAILED");
    }

    public GeoPoint getCenterPoint() {
        FieldOfView fieldOfView = this.mFieldOfView.get();
        if (fieldOfView == null) {
            return null;
        }
        return fieldOfView.center.get();
    }

    public double[] getFrameAngleCoordinates(double d, double d2, double d3) {
        LatLon latLon = new LatLon();
        GeoPoint dronePosition2 = getDronePosition();
        if (dronePosition2 == null) {
            return null;
        }
        latLon.lat = dronePosition2.getLatitude();
        latLon.lon = dronePosition2.getLongitude();
        latLon.alt = dronePosition2.getAltitude();
        LatLon latLon2 = new LatLon();
        latLon2.lat = d;
        latLon2.lon = d2;
        latLon2.alt = d3;
        double course = getCourse(latLon, latLon2);
        double pitch = getPitch(latLon, latLon2);
        if (this.gimbalPitch == null) {
            this.gimbalPitch = Double.valueOf(0.0d);
        }
        double doubleValue = pitch - this.gimbalPitch.doubleValue();
        if (this.sensorHeading == null) {
            this.sensorHeading = Double.valueOf(0.0d);
        }
        return new double[]{((course - this.sensorHeading.doubleValue()) + 360.0d) % 360.0d, doubleValue};
    }

    /* access modifiers changed from: protected */
    public GeoPoint getDronePosition() {
        return this.dronePosition.get();
    }

    public synchronized void setControlEnabled(boolean z) {
        if (z) {
            if (this.isOperator) {
                UASToolDropDownReceiver.getInstance().getOperatorPager().getOperatorControlFragment().getVideoUI().resetScale();
            } else {
                UASToolDropDownReceiver.getInstance().getObserverPager().getObserverControlFragment().getVideoUI().resetScale();
            }
            setClickable(true);
            UASToolDropDownReceiver.toast("Gimbal Control enabled", 0);
        } else {
            updateTouchMarker((GeoPoint) null);
            UASToolDropDownReceiver.toast("Gimbal Control disabled", 0);
        }
    }

    private synchronized void onClick(PointD pointD) {
        this.geoRefLock.readLock().lock();
        try {
            onClick(pointD, this.useDted);
        } finally {
            this.geoRefLock.readLock().unlock();
        }
    }

    private Point3D clickToFovDelta(PointD pointD) {
        int i = (int) pointD.x;
        int i2 = (int) pointD.y;
        int width = getWidth();
        int height = getHeight();
        try {
            if (this.selectedUASItem.getHFOV() > 0.0d && this.selectedUASItem.getVFOV() > 0.0d) {
                return new Point3D(Math.tan(Math.toRadians((0.5d - ((double) (((float) i) / ((float) width)))) * this.selectedUASItem.getHFOV())), Math.tan(Math.toRadians((0.5d - ((double) (((float) i2) / ((float) height)))) * this.selectedUASItem.getVFOV())), -1.0d);
            }
        } catch (Exception e) {
            String str = TAG;
            Log.d(str, "Error computing FOV angular delta");
            Log.d(str, e.getMessage());
        }
        return new Point3D(-1.0d, -1.0d, -1.0d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.atakmap.coremap.maps.coords.GeoPoint clickToGeoPoint(com.atakmap.math.PointD r20, boolean r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            double r2 = r0.x
            int r2 = (int) r2
            double r3 = r0.y
            int r3 = (int) r3
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            java.lang.String r6 = TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Point in video: ("
            r7.append(r8)
            r7.append(r2)
            java.lang.String r8 = ", "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r9 = ") with max ("
            r7.append(r9)
            r7.append(r4)
            r7.append(r8)
            r7.append(r5)
            java.lang.String r8 = ")"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.atakmap.coremap.log.Log.d(r6, r7)
            r6 = 0
            r7 = 0
            com.atakmap.android.uastool.UASItem r9 = r1.selectedUASItem     // Catch:{ Exception -> 0x0083 }
            boolean r9 = r9.supportsMatrixAr()     // Catch:{ Exception -> 0x0083 }
            if (r9 == 0) goto L_0x0092
            com.atakmap.android.uastool.UASItem r9 = r1.selectedUASItem     // Catch:{ Exception -> 0x0083 }
            double r9 = r9.getHFOV()     // Catch:{ Exception -> 0x0083 }
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 <= 0) goto L_0x0092
            com.atakmap.android.uastool.UASItem r9 = r1.selectedUASItem     // Catch:{ Exception -> 0x0083 }
            double r9 = r9.getVFOV()     // Catch:{ Exception -> 0x0083 }
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 <= 0) goto L_0x0092
            com.atakmap.android.uastool.utils.Point3D r0 = r19.clickToFovDelta(r20)     // Catch:{ Exception -> 0x0083 }
            com.atakmap.android.uastool.UASItem r9 = r1.selectedUASItem     // Catch:{ Exception -> 0x0083 }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = r9.getGeoPoint()     // Catch:{ Exception -> 0x0083 }
            com.atakmap.android.uastool.UASItem r10 = r1.selectedUASItem     // Catch:{ Exception -> 0x0083 }
            double r10 = r10.getGimbalPitch()     // Catch:{ Exception -> 0x0083 }
            com.atakmap.android.uastool.UASItem r12 = r1.selectedUASItem     // Catch:{ Exception -> 0x0083 }
            double r12 = r12.getGimbalAngle()     // Catch:{ Exception -> 0x0083 }
            com.atakmap.android.uastool.utils.Matrix3D r10 = com.atakmap.android.uastool.utils.FieldOfView.transformCameraToDrone(r10, r12)     // Catch:{ Exception -> 0x0083 }
            com.atakmap.coremap.maps.coords.GeoPoint r0 = com.atakmap.android.uastool.utils.FieldOfView.getProjectionPoint(r9, r10, r0)     // Catch:{ Exception -> 0x0083 }
            if (r0 == 0) goto L_0x0093
            return r0
        L_0x0083:
            r0 = move-exception
            java.lang.String r9 = TAG
            java.lang.String r10 = "Error computing Ltclc by angle"
            com.atakmap.coremap.log.Log.d(r9, r10)
            java.lang.String r0 = r0.getMessage()
            com.atakmap.coremap.log.Log.d(r9, r0)
        L_0x0092:
            r0 = r6
        L_0x0093:
            java.util.concurrent.atomic.AtomicReference<com.atakmap.android.uastool.utils.FieldOfView> r9 = r1.mFieldOfView
            java.lang.Object r9 = r9.get()
            com.atakmap.android.uastool.utils.FieldOfView r9 = (com.atakmap.android.uastool.utils.FieldOfView) r9
            if (r9 == 0) goto L_0x01f3
            boolean r10 = r9.isValid()
            if (r10 == 0) goto L_0x01f3
            boolean r10 = r1.isUniqueCorners(r9)
            if (r10 == 0) goto L_0x01f3
            com.atakmap.math.PointD r11 = new com.atakmap.math.PointD
            r11.<init>(r7, r7)
            com.atakmap.math.PointD r12 = new com.atakmap.math.PointD
            double r13 = (double) r4
            r12.<init>(r13, r7)
            com.atakmap.math.PointD r0 = new com.atakmap.math.PointD
            double r4 = (double) r5
            r0.<init>(r13, r4)
            com.atakmap.math.PointD r14 = new com.atakmap.math.PointD
            r14.<init>(r7, r4)
            com.atakmap.math.PointD r15 = r9.f8422tl
            com.atakmap.math.PointD r4 = r9.f8423tr
            com.atakmap.math.PointD r5 = r9.f8421br
            com.atakmap.math.PointD r7 = r9.f8420bl
            r13 = r0
            r16 = r4
            r17 = r5
            r18 = r7
            com.atakmap.math.Matrix r0 = com.atakmap.math.Matrix.mapQuads(r11, r12, r13, r14, r15, r16, r17, r18)
            com.atakmap.math.PointD r4 = new com.atakmap.math.PointD
            double r7 = (double) r2
            double r2 = (double) r3
            r4.<init>(r7, r2)
            com.atakmap.math.PointD r0 = r0.transform(r4, r6)
            com.atakmap.coremap.maps.coords.GeoPoint r2 = new com.atakmap.coremap.maps.coords.GeoPoint
            double r3 = r0.x
            double r5 = r0.y
            r2.<init>(r3, r5)
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Got transform result: "
            r4.append(r5)
            java.lang.String r5 = r2.toStringRepresentation()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.atakmap.coremap.log.Log.d(r3, r4)
            r3 = 4
            com.atakmap.coremap.maps.coords.GeoPoint[] r4 = new com.atakmap.coremap.maps.coords.GeoPoint[r3]
            com.atakmap.math.PointD r5 = r9.f8422tl
            com.atakmap.coremap.maps.coords.GeoPoint r5 = com.atakmap.android.uastool.utils.FieldOfView.pointDToGeoPoint(r5)
            r6 = 0
            r4[r6] = r5
            com.atakmap.math.PointD r5 = r9.f8423tr
            com.atakmap.coremap.maps.coords.GeoPoint r5 = com.atakmap.android.uastool.utils.FieldOfView.pointDToGeoPoint(r5)
            r7 = 1
            r4[r7] = r5
            r5 = 2
            com.atakmap.math.PointD r8 = r9.f8421br
            com.atakmap.coremap.maps.coords.GeoPoint r8 = com.atakmap.android.uastool.utils.FieldOfView.pointDToGeoPoint(r8)
            r4[r5] = r8
            r5 = 3
            com.atakmap.math.PointD r8 = r9.f8420bl
            com.atakmap.coremap.maps.coords.GeoPoint r8 = com.atakmap.android.uastool.utils.FieldOfView.pointDToGeoPoint(r8)
            r4[r5] = r8
            r5 = r4[r6]
            double r8 = r2.distanceTo(r5)
            r10 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r5 = 1
        L_0x0133:
            if (r7 >= r3) goto L_0x014d
            r12 = r4[r7]
            double r12 = r2.distanceTo(r12)
            int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r14 > 0) goto L_0x0144
            r5 = r6
            r6 = r7
            r10 = r8
            r8 = r12
            goto L_0x014a
        L_0x0144:
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 > 0) goto L_0x014a
            r5 = r7
            r10 = r12
        L_0x014a:
            int r7 = r7 + 1
            goto L_0x0133
        L_0x014d:
            double r12 = r8 + r10
            double r10 = r10 / r12
            r3 = r4[r6]
            double r6 = r3.getAltitude()
            double r10 = r10 * r6
            double r8 = r8 / r12
            r3 = r4[r5]
            double r3 = r3.getAltitude()
            double r8 = r8 * r3
            double r3 = r10 + r8
            java.lang.String r5 = TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Estimated alt of clicked pt: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            com.atakmap.coremap.log.Log.d(r5, r6)
            if (r21 == 0) goto L_0x01e2
            com.atakmap.android.uastool.pagers.video_ui.LtclcOverlayView$LatLon r2 = new com.atakmap.android.uastool.pagers.video_ui.LtclcOverlayView$LatLon
            r2.<init>()
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r19.getDronePosition()
            double r7 = r6.getLatitude()
            r2.lat = r7
            double r7 = r6.getLongitude()
            r2.lon = r7
            double r7 = r6.getAltitude()
            r2.alt = r7
            com.atakmap.android.uastool.pagers.video_ui.LtclcOverlayView$LatLon r7 = new com.atakmap.android.uastool.pagers.video_ui.LtclcOverlayView$LatLon
            r7.<init>()
            double r8 = r0.x
            r7.lat = r8
            double r8 = r0.y
            r7.lon = r8
            r7.alt = r3
            double r3 = getCourse(r2, r7)
            double r7 = getPitch(r2, r7)
            com.atakmap.android.uastool.utils.Matrix3D r0 = com.atakmap.android.uastool.utils.FieldOfView.transformCameraToDrone(r7, r3)
            com.atakmap.android.uastool.utils.Point3D r2 = new com.atakmap.android.uastool.utils.Point3D
            r8 = 0
            r10 = 0
            r12 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r7 = r2
            r7.<init>(r8, r10, r12)
            com.atakmap.coremap.maps.coords.GeoPoint r0 = com.atakmap.android.uastool.utils.FieldOfView.getProjectionPoint(r6, r0, r2)
            if (r0 != 0) goto L_0x01c9
            java.lang.String r2 = "Got null result from dted altitude estimation."
            com.atakmap.coremap.log.Log.d(r5, r2)
            goto L_0x01fa
        L_0x01c9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Point with dted: "
            r2.append(r3)
            java.lang.String r3 = r0.toStringRepresentation()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.atakmap.coremap.log.Log.d(r5, r2)
            goto L_0x01fa
        L_0x01e2:
            com.atakmap.coremap.maps.coords.GeoPoint r0 = new com.atakmap.coremap.maps.coords.GeoPoint
            double r13 = r2.getLatitude()
            double r15 = r2.getLongitude()
            r12 = r0
            r17 = r3
            r12.<init>(r13, r15, r17)
            goto L_0x01fa
        L_0x01f3:
            java.lang.String r2 = TAG
            java.lang.String r3 = "Missing four corners, cannot georectify clicked point."
            com.atakmap.coremap.log.Log.w(r2, r3)
        L_0x01fa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.LtclcOverlayView.clickToGeoPoint(com.atakmap.math.PointD, boolean):com.atakmap.coremap.maps.coords.GeoPoint");
    }

    private boolean isUniqueCorners(FieldOfView fieldOfView) {
        if (fieldOfView == null) {
            return false;
        }
        PointD[] pointDArr = {fieldOfView.f8422tl, fieldOfView.f8423tr, fieldOfView.f8421br, fieldOfView.f8420bl};
        int i = 0;
        while (i < 4) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < 4; i3++) {
                if (pointDArr[i].x == pointDArr[i3].x && pointDArr[i].y == pointDArr[i3].y) {
                    return false;
                }
            }
            i = i2;
        }
        return true;
    }

    private CotEvent createMarker(GeoPoint geoPoint, String str) {
        CotEvent cotEvent = new CotEvent();
        cotEvent.setHow("h-e");
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addSeconds(300));
        cotEvent.setType("a-u-G");
        cotEvent.setUID(str);
        cotEvent.setPoint(new CotPoint(geoPoint));
        CotDetail cotDetail = new CotDetail("detail");
        CotDetail cotDetail2 = new CotDetail(UasC2Event.ContactDetail.detailName);
        cotDetail2.setAttribute(FlightLogger.LOG_CALLSIGN, "POI-" + str.substring(0, 5));
        cotDetail.addChild(cotDetail2);
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    private void dropCotPoint(GeoPoint geoPoint) {
        CotMapComponent.i().a(createMarker(geoPoint, UUID.randomUUID().toString()));
        UASToolDropDownReceiver.toast("PoI dropped on map", 0);
    }

    private synchronized void cotPointOnClick(PointD pointD, boolean z) {
        GeoPoint clickToGeoPoint = clickToGeoPoint(pointD, z);
        if (clickToGeoPoint != null) {
            try {
                String str = TAG;
                Log.d(str, "Geospatial translated touch point: " + clickToGeoPoint);
                dropCotPoint(clickToGeoPoint);
            } catch (Exception e) {
                Log.w(TAG, "Problem translating point on video to lat/lon", e);
            }
        } else {
            Log.w(TAG, "Translated point was NULL, not sure why.");
        }
        return;
    }

    private void onClick(PointD pointD, boolean z) {
        GeoPoint clickToGeoPoint = clickToGeoPoint(pointD, z);
        Point3D clickToFovDelta = clickToFovDelta(pointD);
        if (clickToGeoPoint == null && clickToFovDelta == null) {
            try {
                UASToolDropDownReceiver.toast("Unable to calculate location for touch point", 0);
                Log.w(TAG, "Unable to calculate location for touch point");
            } catch (Exception e) {
                UASToolDropDownReceiver.toast("Problem translating point on video to lat/lon: " + e.getLocalizedMessage(), 0);
                Log.w(TAG, "Problem translating point on video to lat/lon", e);
            }
        } else {
            String str = TAG;
            Log.d(str, "Geospatial translated touch point: " + clickToGeoPoint);
            if (this.selectedUASItem.isGimbalControlEnabled()) {
                this.selectedUASItem.taskSensor(clickToGeoPoint, clickToFovDelta);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onDoubleClick() {
        this.geoRefLock.readLock().lock();
        try {
            resetGimbal();
        } finally {
            this.geoRefLock.readLock().unlock();
        }
    }

    public void resetGimbal() {
        this.selectedUASItem.resetGimbalPitchAndYaw();
    }

    public static HorizontalVertical convertAngleStrengthToHorizontalVertical(int i, int i2) {
        HorizontalVertical horizontalVertical = new HorizontalVertical();
        horizontalVertical.horizontal = 0.0f;
        horizontalVertical.vertical = 0.0f;
        float f = ((float) i2) / 100.0f;
        double d = (double) ((float) i);
        horizontalVertical.horizontal = ((float) Math.cos(Math.toRadians(d))) * f;
        horizontalVertical.vertical = f * ((float) Math.sin(Math.toRadians(d)));
        return horizontalVertical;
    }

    private void addListeners(ao aoVar, final ag agVar, final bb bbVar) {
        aoVar.addOnGroupChangedListener(new ai.c() {
            public void onItemAdded(ai aiVar, ag agVar) {
            }

            public void onItemRemoved(ai aiVar, ag agVar) {
                if (bbVar != null) {
                    String access$400 = LtclcOverlayView.TAG;
                    Log.d(access$400, "Item " + aiVar.getUID() + " was removed, removing associated " + bbVar.getClass().getSimpleName());
                    ag agVar2 = agVar;
                    if (agVar2 != null) {
                        agVar2.g(bbVar);
                    } else {
                        String access$4002 = LtclcOverlayView.TAG;
                        Log.w(access$4002, "Problem removing shape associated with item " + aiVar.getUID());
                    }
                }
                aiVar.removeOnGroupChangedListener(this);
            }
        });
    }

    public List<GeoPoint> getFieldOfViewList() {
        FieldOfView fieldOfView = this.mFieldOfView.get();
        if (fieldOfView == null || !fieldOfView.isValid()) {
            return null;
        }
        return fieldOfView.getFieldOfViewList();
    }

    public static double getCourse(LatLon latLon, LatLon latLon2) {
        double radians = Math.toRadians(latLon.lat);
        double radians2 = Math.toRadians(latLon2.lat);
        double radians3 = Math.toRadians(latLon2.lon) - Math.toRadians(latLon.lon);
        return Math.toDegrees(Math.atan2(Math.sin(radians3) * Math.cos(radians2), (Math.cos(radians) * Math.sin(radians2)) - ((Math.sin(radians) * Math.cos(radians2)) * Math.cos(radians3))) % 6.283185307179586d);
    }

    public static double getPitch(LatLon latLon, LatLon latLon2) {
        double distanceBetween = distanceBetween(latLon, latLon2);
        if (distanceBetween < 0.0d) {
            distanceBetween *= -1.0d;
        }
        double d = latLon.alt - latLon2.alt;
        if (d == 0.0d) {
            d = 1.0d;
        }
        if (d < 0.0d) {
            return Math.toDegrees(Math.atan2(latLon2.alt - latLon.alt, distanceBetween));
        }
        return Math.toDegrees(Math.atan2(distanceBetween, d)) - 90.0d;
    }

    private static double distanceBetween(LatLon latLon, LatLon latLon2) {
        double radians = Math.toRadians(latLon.lat);
        double radians2 = Math.toRadians(latLon2.lat);
        double radians3 = Math.toRadians(latLon.lon);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((radians2 - radians) / 2.0d), 2.0d) + (Math.cos(radians) * Math.cos(radians2) * Math.pow(Math.sin((Math.toRadians(latLon2.lon) - radians3) / 2.0d), 2.0d)))) * 2.0d * EARTH_RADIUS;
    }
}
