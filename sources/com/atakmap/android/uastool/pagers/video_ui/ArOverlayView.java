package com.atakmap.android.uastool.pagers.video_ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.bb;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.uastool.utils.Matrix3D;
import com.atakmap.android.uastool.utils.Point3D;
import com.atakmap.android.util.b;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.DistanceCalculations;
import com.atakmap.coremap.maps.coords.GeoBounds;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import com.atakmap.map.layer.Layer;
import com.atakmap.map.layer.feature.Feature;
import com.atakmap.map.layer.feature.geometry.c;
import com.atakmap.map.layer.g;
import com.atakmap.map.layer.h;
import com.atakmap.math.Matrix;
import com.atakmap.math.PointD;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArOverlayView extends LtclcOverlayView implements UASItem.UasItemUpdateListener {
    private static final double AR_CUTOFF_RANGE = 5000.0d;
    private static final int AR_ITEM_DEFAULT_SIZE = 50;
    private static final int AR_ITEM_MAX_SIZE = 80;
    private static final int AR_ITEM_MIN_SIZE = 20;
    private static final int BITMAP_CACHE_MAX_SIZE = 20;
    private static final boolean DEBUG_SHOW_4CORNERS_IN_AR = false;
    private static final boolean DEBUG_SHOW_FOV_REGION = false;
    private static final double DEFAULT_ALPHA_PERCENT = 0.5d;
    private static final boolean SHOW_SPI_IN_AR = false;
    /* access modifiers changed from: private */
    public static final String TAG = "ArOverlayView";
    private final Paint BITMAP_PAINT;
    private final Paint DEFAULT_PAINT;
    private final Paint SPOT_PAINT;
    private final Paint TEXT_PAINT;
    private final AtomicBoolean arEnabled = new AtomicBoolean(true);
    private final LinkedHashMap<String, Bitmap> bitmapCache = new LinkedHashMap<String, Bitmap>(20, 1.0f, true) {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > 20;
        }
    };
    private ElevationManager.b elevationParams;
    /* access modifiers changed from: private */
    public long fovUpdateTime = 0;
    boolean fovWasHidden = false;
    private AssetManager mAssetManager;
    private final Set<OverlayItem> mKmlOverlayItems = new LinkedHashSet();
    private long mKmzLastUpdateTime;
    /* access modifiers changed from: private */
    public final Set<OverlayItem> mOverlayItems = new LinkedHashSet();
    private Resources mResources;
    private final ReentrantReadWriteLock paintLock;
    private final AtomicReference<String> platformCallsignRef = new AtomicReference<>((Object) null);
    float scale = 1.0f;
    HashMap<Integer, Paint> teamPaintMap;
    private ScheduledExecutorService updateFovExecutor = null;
    /* access modifiers changed from: private */
    public final AtomicReference<FieldOfView> zeroAltFov = new AtomicReference<>();

    private void buildPolyline() {
    }

    public ArOverlayView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.DEFAULT_PAINT = paint;
        Paint paint2 = new Paint();
        this.BITMAP_PAINT = paint2;
        Paint paint3 = new Paint();
        this.TEXT_PAINT = paint3;
        this.SPOT_PAINT = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setTextSize(45.0f);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10.0f);
        paint.setColor(-256);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAlpha(127);
        paint2.setAlpha(127);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTypeface(Typeface.SANS_SERIF);
        paint3.setTextSize(45.0f);
        paint3.setAntiAlias(true);
        paint3.setStrokeWidth(50.0f);
        paint3.setColor(-256);
        paint3.setStyle(Paint.Style.FILL);
        this.paintLock = new ReentrantReadWriteLock();
        this.teamPaintMap = new HashMap<>();
        init();
    }

    public ArOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.DEFAULT_PAINT = paint;
        Paint paint2 = new Paint();
        this.BITMAP_PAINT = paint2;
        Paint paint3 = new Paint();
        this.TEXT_PAINT = paint3;
        this.SPOT_PAINT = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setTextSize(45.0f);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10.0f);
        paint.setColor(-256);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAlpha(127);
        paint2.setAlpha(127);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTypeface(Typeface.SANS_SERIF);
        paint3.setTextSize(45.0f);
        paint3.setAntiAlias(true);
        paint3.setStrokeWidth(50.0f);
        paint3.setColor(-256);
        paint3.setStyle(Paint.Style.FILL);
        this.paintLock = new ReentrantReadWriteLock();
        this.teamPaintMap = new HashMap<>();
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Resources resources = MapView.getMapView().getResources();
            this.mResources = resources;
            this.mAssetManager = resources.getAssets();
            this.platformCallsignRef.set(UASToolDropDownReceiver.getInstance().getCallsign());
        }
        ElevationManager.b bVar = new ElevationManager.b();
        this.elevationParams = bVar;
        bVar.e = 1;
        this.elevationParams.g = true;
        setWillNotDraw(false);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.updateFovExecutor = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (!ArOverlayView.this.mOverlayItems.isEmpty() && System.currentTimeMillis() - ArOverlayView.this.fovUpdateTime >= 2000 && ArOverlayView.this.zeroAltFov.get() != null) {
                    ArOverlayView.this.setFieldOfView((FieldOfView) null);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void setDroneCallsign(String str) {
        this.platformCallsignRef.set(str);
    }

    public void setScale(float f) {
        this.scale = f;
    }

    static class OverlayItem {
        double alt;
        boolean bTeamMember;
        Bitmap bitmap;
        int color;
        double lat;
        double lon;
        String markerType;
        String text;
        String uid;

        OverlayItem() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof OverlayItem) {
                return ((OverlayItem) obj).uid.equals(this.uid);
            }
            return false;
        }

        public int hashCode() {
            return this.uid.hashCode() + 23421;
        }

        public String toString() {
            return "text=" + this.text + " " + "lat=" + this.lat + " " + "lon=" + this.lon + " " + "alt=" + this.alt + " " + "color=" + this.color + " " + "markerType=" + this.markerType + " " + "uid=" + this.uid + " ";
        }
    }

    public /* synthetic */ void lambda$update$0$ArOverlayView() {
        invalidate();
    }

    public void update() {
        ((Activity) getContext()).runOnUiThread(new Runnable() {
            public final void run() {
                ArOverlayView.this.lambda$update$0$ArOverlayView();
            }
        });
    }

    public void setFieldOfView(FieldOfView fieldOfView) {
        super.setFieldOfView(fieldOfView);
        this.fovUpdateTime = System.currentTimeMillis();
        List<GeoPoint> fieldOfViewList = getFieldOfViewList();
        Collection collection = null;
        if (fieldOfViewList == null || ((double) Math.abs(this.scale - 1.0f)) > 0.05d) {
            if (fieldOfViewList != null && !this.fovWasHidden && this.arEnabled.get()) {
                UASToolDropDownReceiver.toast("AR disabled, zoom in to enable");
                this.fovWasHidden = true;
            }
            this.zeroAltFov.set((Object) null);
            this.mKmlOverlayItems.clear();
        } else {
            this.fovWasHidden = false;
            GeoBounds createFromPoints = GeoBounds.createFromPoints((GeoPoint[]) fieldOfViewList.toArray(new GeoPoint[4]));
            collection = MapView.getMapView().getRootGroup().deepFindItems(createFromPoints, (Map) null);
            FieldOfView fieldOfView2 = new FieldOfView();
            fieldOfView2.f8422tl = FieldOfView.geoPointToPointD(toAltZeroPoint(FieldOfView.pointDToGeoPoint(fieldOfView.f8422tl)));
            fieldOfView2.f8423tr = FieldOfView.geoPointToPointD(toAltZeroPoint(FieldOfView.pointDToGeoPoint(fieldOfView.f8423tr)));
            fieldOfView2.f8421br = FieldOfView.geoPointToPointD(toAltZeroPoint(FieldOfView.pointDToGeoPoint(fieldOfView.f8421br)));
            fieldOfView2.f8420bl = FieldOfView.geoPointToPointD(toAltZeroPoint(FieldOfView.pointDToGeoPoint(fieldOfView.f8420bl)));
            this.zeroAltFov.set(fieldOfView2);
            find_kmz(createFromPoints);
        }
        updateOverlayItems(collection);
        buildPolyline();
    }

    private static <T extends Layer> void findLayers(Class<T> cls, Layer layer, List<T> list) {
        if (cls.isAssignableFrom(layer.getClass())) {
            list.add(cls.cast(layer));
        } else if (layer instanceof g) {
            for (Layer findLayers : ((g) layer).f()) {
                findLayers(cls, findLayers, list);
            }
        } else if (layer instanceof h) {
            findLayers(cls, ((h) layer).f(), list);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0102, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0103, code lost:
        if (r7 != null) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0105, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0108, code lost:
        throw r15;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void find_kmz(com.atakmap.coremap.maps.coords.GeoBounds r15) {
        /*
            r14 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r14.mKmzLastUpdateTime
            long r2 = r0 - r2
            r4 = 2000(0x7d0, double:9.88E-321)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x000f
            return
        L_0x000f:
            java.util.Set<com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem> r2 = r14.mKmlOverlayItems
            monitor-enter(r2)
            java.util.Set<com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem> r3 = r14.mKmlOverlayItems     // Catch:{ all -> 0x010f }
            r3.clear()     // Catch:{ all -> 0x010f }
            r14.mKmzLastUpdateTime = r0     // Catch:{ all -> 0x010f }
            com.atakmap.android.maps.MapView r0 = com.atakmap.android.maps.MapView.getMapView()     // Catch:{ all -> 0x010f }
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ all -> 0x010f }
            r1.<init>()     // Catch:{ all -> 0x010f }
            com.atakmap.android.maps.MapView$a r3 = com.atakmap.android.maps.MapView.a.e     // Catch:{ all -> 0x010f }
            java.util.List r0 = r0.c(r3)     // Catch:{ all -> 0x010f }
            r3 = 0
            r4 = 0
        L_0x002a:
            int r5 = r0.size()     // Catch:{ all -> 0x010f }
            if (r4 >= r5) goto L_0x010d
            java.lang.Class<com.atakmap.map.layer.feature.p> r5 = com.atakmap.map.layer.feature.p.class
            java.lang.Object r6 = r0.get(r3)     // Catch:{ all -> 0x010f }
            com.atakmap.map.layer.Layer r6 = (com.atakmap.map.layer.Layer) r6     // Catch:{ all -> 0x010f }
            findLayers(r5, r6, r1)     // Catch:{ all -> 0x010f }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ all -> 0x010f }
        L_0x003f:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x010f }
            r7 = 0
            if (r6 == 0) goto L_0x005b
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x010f }
            com.atakmap.map.layer.feature.p r6 = (com.atakmap.map.layer.feature.p) r6     // Catch:{ all -> 0x010f }
            com.atakmap.map.layer.feature.j r8 = r6.a()     // Catch:{ all -> 0x010f }
            boolean r8 = r8 instanceof com.atakmap.map.layer.feature.PersistentDataSourceFeatureDataStore2     // Catch:{ all -> 0x010f }
            if (r8 == 0) goto L_0x003f
            com.atakmap.map.layer.feature.j r5 = r6.a()     // Catch:{ all -> 0x010f }
            com.atakmap.map.layer.feature.PersistentDataSourceFeatureDataStore2 r5 = (com.atakmap.map.layer.feature.PersistentDataSourceFeatureDataStore2) r5     // Catch:{ all -> 0x010f }
            goto L_0x005c
        L_0x005b:
            r5 = r7
        L_0x005c:
            if (r5 == 0) goto L_0x0109
            com.atakmap.map.layer.feature.j$a r6 = new com.atakmap.map.layer.feature.j$a     // Catch:{ all -> 0x010f }
            r6.<init>()     // Catch:{ all -> 0x010f }
            if (r15 == 0) goto L_0x0086
            com.atakmap.coremap.maps.coords.GeoPoint r8 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x010f }
            double r9 = r15.getNorth()     // Catch:{ all -> 0x010f }
            double r11 = r15.getWest()     // Catch:{ all -> 0x010f }
            r8.<init>(r9, r11)     // Catch:{ all -> 0x010f }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x010f }
            double r10 = r15.getSouth()     // Catch:{ all -> 0x010f }
            double r12 = r15.getEast()     // Catch:{ all -> 0x010f }
            r9.<init>(r10, r12)     // Catch:{ all -> 0x010f }
            com.atakmap.map.layer.feature.j$a$i r10 = new com.atakmap.map.layer.feature.j$a$i     // Catch:{ all -> 0x010f }
            r10.<init>(r8, r9)     // Catch:{ all -> 0x010f }
            r6.k = r10     // Catch:{ all -> 0x010f }
        L_0x0086:
            com.atakmap.map.layer.feature.h r6 = r5.a(r6)     // Catch:{ all -> 0x0102 }
        L_0x008a:
            boolean r8 = r6.moveToNext()     // Catch:{ all -> 0x00ff }
            if (r8 == 0) goto L_0x00f9
            long r8 = r6.b()     // Catch:{ all -> 0x00ff }
            boolean r8 = isFeatureVisible(r5, r8)     // Catch:{ all -> 0x00ff }
            if (r8 != 0) goto L_0x009b
            goto L_0x008a
        L_0x009b:
            com.atakmap.map.layer.feature.Feature r8 = r6.get()     // Catch:{ all -> 0x00ff }
            com.atakmap.map.layer.feature.geometry.Geometry r8 = r8.e()     // Catch:{ all -> 0x00ff }
            boolean r9 = r8 instanceof com.atakmap.map.layer.feature.geometry.c     // Catch:{ all -> 0x00ff }
            if (r9 == 0) goto L_0x008a
            com.atakmap.map.layer.feature.geometry.c r8 = (com.atakmap.map.layer.feature.geometry.c) r8     // Catch:{ all -> 0x00ff }
            com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem r9 = new com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem     // Catch:{ all -> 0x00ff }
            r9.<init>()     // Catch:{ all -> 0x00ff }
            double r10 = r8.b()     // Catch:{ all -> 0x00ff }
            r9.lat = r10     // Catch:{ all -> 0x00ff }
            double r10 = r8.a()     // Catch:{ all -> 0x00ff }
            r9.lon = r10     // Catch:{ all -> 0x00ff }
            com.atakmap.map.layer.feature.Feature$a r10 = com.atakmap.map.layer.feature.Feature.a.b     // Catch:{ all -> 0x00ff }
            double r10 = getAltitude(r8, r10)     // Catch:{ all -> 0x00ff }
            r9.alt = r10     // Catch:{ all -> 0x00ff }
            com.atakmap.map.layer.feature.Feature r8 = r6.get()     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = r8.d()     // Catch:{ all -> 0x00ff }
            r9.text = r8     // Catch:{ all -> 0x00ff }
            r8 = -1
            r9.color = r8     // Catch:{ all -> 0x00ff }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ff }
            r8.<init>()     // Catch:{ all -> 0x00ff }
            long r10 = r6.b()     // Catch:{ all -> 0x00ff }
            r8.append(r10)     // Catch:{ all -> 0x00ff }
            java.lang.String r10 = ""
            r8.append(r10)     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ff }
            r9.uid = r8     // Catch:{ all -> 0x00ff }
            r9.bitmap = r7     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = "b-m-p-s-m"
            r9.markerType = r8     // Catch:{ all -> 0x00ff }
            java.util.Set<com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem> r8 = r14.mKmlOverlayItems     // Catch:{ all -> 0x00ff }
            monitor-enter(r8)     // Catch:{ all -> 0x00ff }
            java.util.Set<com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem> r10 = r14.mKmlOverlayItems     // Catch:{ all -> 0x00f6 }
            r10.add(r9)     // Catch:{ all -> 0x00f6 }
            monitor-exit(r8)     // Catch:{ all -> 0x00f6 }
            goto L_0x008a
        L_0x00f6:
            r15 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00f6 }
            throw r15     // Catch:{ all -> 0x00ff }
        L_0x00f9:
            if (r6 == 0) goto L_0x0109
            r6.close()     // Catch:{ all -> 0x010f }
            goto L_0x0109
        L_0x00ff:
            r15 = move-exception
            r7 = r6
            goto L_0x0103
        L_0x0102:
            r15 = move-exception
        L_0x0103:
            if (r7 == 0) goto L_0x0108
            r7.close()     // Catch:{ all -> 0x010f }
        L_0x0108:
            throw r15     // Catch:{ all -> 0x010f }
        L_0x0109:
            int r4 = r4 + 1
            goto L_0x002a
        L_0x010d:
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            return
        L_0x010f:
            r15 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.ArOverlayView.find_kmz(com.atakmap.coremap.maps.coords.GeoBounds):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isFeatureVisible(com.atakmap.map.layer.feature.PersistentDataSourceFeatureDataStore2 r1, long r2) {
        /*
            com.atakmap.map.layer.feature.j$a r0 = new com.atakmap.map.layer.feature.j$a
            r0.<init>()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.util.Set r2 = java.util.Collections.singleton(r2)
            r0.j = r2
            r2 = 1
            r0.n = r2
            r0.s = r2
            com.atakmap.map.layer.feature.h r1 = r1.a(r0)     // Catch:{ all -> 0x002d }
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0025
            r2 = 0
            if (r1 == 0) goto L_0x0024
            r1.close()
        L_0x0024:
            return r2
        L_0x0025:
            if (r1 == 0) goto L_0x002a
            r1.close()
        L_0x002a:
            return r2
        L_0x002b:
            r2 = move-exception
            goto L_0x002f
        L_0x002d:
            r2 = move-exception
            r1 = 0
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.ArOverlayView.isFeatureVisible(com.atakmap.map.layer.feature.PersistentDataSourceFeatureDataStore2, long):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:28|(3:30|31|(1:33))|(3:36|37|38)|(1:40)|41|(4:43|44|(1:48)|49)|50|51|65) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x011a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateOverlayItems(java.util.Collection<com.atakmap.android.maps.ai> r14) {
        /*
            r13 = this;
            java.util.Set<com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem> r0 = r13.mOverlayItems
            monitor-enter(r0)
            java.util.Set<com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem> r1 = r13.mOverlayItems     // Catch:{ all -> 0x0127 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0127 }
            r2 = 1
            r1 = r1 ^ r2
            java.util.Set<com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem> r3 = r13.mOverlayItems     // Catch:{ all -> 0x0127 }
            r3.clear()     // Catch:{ all -> 0x0127 }
            if (r14 == 0) goto L_0x0120
            com.atakmap.android.uastool.UASItem r3 = r13.selectedUASItem     // Catch:{ all -> 0x0127 }
            com.atakmap.android.maps.ao r3 = r3.getMarker()     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0035
            java.lang.String r4 = "callsign"
            java.lang.String r5 = ""
            java.lang.String r4 = r3.getMetaString(r4, r5)     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r5.<init>()     // Catch:{ all -> 0x0127 }
            r5.append(r4)     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = ".SPI1"
            r5.append(r4)     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0127 }
        L_0x0035:
            java.util.Iterator r14 = r14.iterator()     // Catch:{ all -> 0x0127 }
        L_0x0039:
            boolean r5 = r14.hasNext()     // Catch:{ all -> 0x0127 }
            if (r5 == 0) goto L_0x0120
            java.lang.Object r5 = r14.next()     // Catch:{ all -> 0x0127 }
            com.atakmap.android.maps.ai r5 = (com.atakmap.android.maps.ai) r5     // Catch:{ all -> 0x0127 }
            boolean r6 = r5 instanceof com.atakmap.android.maps.ao     // Catch:{ all -> 0x0127 }
            if (r6 == 0) goto L_0x0039
            if (r5 == r3) goto L_0x0039
            boolean r6 = r5.getVisible()     // Catch:{ all -> 0x0127 }
            if (r6 == 0) goto L_0x0039
            r6 = r5
            com.atakmap.android.maps.av r6 = (com.atakmap.android.maps.av) r6     // Catch:{ all -> 0x0127 }
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r6.C()     // Catch:{ all -> 0x0127 }
            int r7 = com.atakmap.android.util.b.e(r5)     // Catch:{ all -> 0x0127 }
            com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem r8 = new com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$OverlayItem     // Catch:{ all -> 0x0127 }
            r8.<init>()     // Catch:{ all -> 0x0127 }
            double r9 = r6.getLatitude()     // Catch:{ all -> 0x0127 }
            r8.lat = r9     // Catch:{ all -> 0x0127 }
            double r9 = r6.getLongitude()     // Catch:{ all -> 0x0127 }
            r8.lon = r9     // Catch:{ all -> 0x0127 }
            boolean r9 = r6.isAltitudeValid()     // Catch:{ all -> 0x0127 }
            if (r9 == 0) goto L_0x007a
            double r9 = r6.getAltitude()     // Catch:{ all -> 0x0127 }
            r8.alt = r9     // Catch:{ all -> 0x0127 }
            goto L_0x0091
        L_0x007a:
            double r9 = r8.lat     // Catch:{ all -> 0x0127 }
            double r11 = r8.lon     // Catch:{ all -> 0x0127 }
            com.atakmap.map.elevation.ElevationManager$b r6 = r13.elevationParams     // Catch:{ all -> 0x0127 }
            double r9 = com.atakmap.map.elevation.ElevationManager.a(r9, r11, r6)     // Catch:{ all -> 0x0127 }
            boolean r6 = com.atakmap.coremap.maps.coords.GeoPoint.isAltitudeValid(r9)     // Catch:{ all -> 0x0127 }
            if (r6 == 0) goto L_0x008d
            r8.alt = r9     // Catch:{ all -> 0x0127 }
            goto L_0x0091
        L_0x008d:
            r9 = 0
            r8.alt = r9     // Catch:{ all -> 0x0127 }
        L_0x0091:
            java.lang.String r6 = r5.getUID()     // Catch:{ all -> 0x0127 }
            r8.uid = r6     // Catch:{ all -> 0x0127 }
            java.lang.String r6 = "callsign"
            java.lang.String r9 = ""
            java.lang.String r6 = r5.getMetaString(r6, r9)     // Catch:{ all -> 0x0127 }
            r8.text = r6     // Catch:{ all -> 0x0127 }
            java.lang.String r6 = r8.text     // Catch:{ all -> 0x0127 }
            boolean r6 = com.atakmap.coremap.filesystem.FileSystemUtils.isEmpty(r6)     // Catch:{ all -> 0x0127 }
            if (r6 == 0) goto L_0x00af
            java.lang.String r6 = r5.getTitle()     // Catch:{ all -> 0x0127 }
            r8.text = r6     // Catch:{ all -> 0x0127 }
        L_0x00af:
            r8.color = r7     // Catch:{ all -> 0x0127 }
            java.lang.String r6 = r5.getType()     // Catch:{ all -> 0x0127 }
            r8.markerType = r6     // Catch:{ all -> 0x0127 }
            java.lang.String r6 = r8.text     // Catch:{ all -> 0x0127 }
            int r6 = r6.compareToIgnoreCase(r4)     // Catch:{ all -> 0x0127 }
            if (r6 == 0) goto L_0x0039
            com.atakmap.android.maps.ao r5 = (com.atakmap.android.maps.ao) r5     // Catch:{ all -> 0x0127 }
            com.atakmap.coremap.maps.assets.Icon r1 = r5.a()     // Catch:{ all -> 0x0127 }
            r6 = 0
            java.lang.String r7 = "team"
            boolean r5 = r5.hasMetaValue(r7)     // Catch:{ all -> 0x0127 }
            r8.bTeamMember = r5     // Catch:{ all -> 0x0127 }
            boolean r5 = r8.bTeamMember     // Catch:{ all -> 0x0127 }
            if (r5 == 0) goto L_0x00f2
            com.atakmap.android.contact.n r5 = com.atakmap.android.contact.n.a()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = r8.uid     // Catch:{ Exception -> 0x00f1 }
            com.atakmap.android.contact.c r5 = r5.b(r7)     // Catch:{ Exception -> 0x00f1 }
            if (r5 == 0) goto L_0x00f2
            android.os.Bundle r5 = r5.b()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = "team"
            java.lang.String r9 = "cyan"
            java.lang.String r5 = r5.getString(r7, r9)     // Catch:{ Exception -> 0x00f1 }
            int r5 = com.atakmap.android.icons.b.a(r5)     // Catch:{ Exception -> 0x00f1 }
            r8.color = r5     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f2
        L_0x00f1:
        L_0x00f2:
            if (r1 == 0) goto L_0x00f9
            r5 = 0
            java.lang.String r6 = r1.getImageUri(r5)     // Catch:{ all -> 0x0127 }
        L_0x00f9:
            if (r6 != 0) goto L_0x00fd
            java.lang.String r6 = ""
        L_0x00fd:
            int r1 = r6.length()     // Catch:{ all -> 0x0127 }
            if (r1 <= 0) goto L_0x011a
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r1 = r13.bitmapCache     // Catch:{ Exception -> 0x011a }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ Exception -> 0x011a }
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch:{ Exception -> 0x011a }
            if (r1 != 0) goto L_0x0118
            android.graphics.Bitmap r1 = com.atakmap.android.util.b.d(r6)     // Catch:{ Exception -> 0x011a }
            if (r1 == 0) goto L_0x0118
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r5 = r13.bitmapCache     // Catch:{ Exception -> 0x011a }
            r5.put(r6, r1)     // Catch:{ Exception -> 0x011a }
        L_0x0118:
            r8.bitmap = r1     // Catch:{ Exception -> 0x011a }
        L_0x011a:
            r13.addOverlayItem(r8)     // Catch:{ all -> 0x0127 }
            r1 = 1
            goto L_0x0039
        L_0x0120:
            monitor-exit(r0)     // Catch:{ all -> 0x0127 }
            if (r1 == 0) goto L_0x0126
            r13.postInvalidate()
        L_0x0126:
            return
        L_0x0127:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0127 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.ArOverlayView.updateOverlayItems(java.util.Collection):void");
    }

    private void addOverlayItem(OverlayItem overlayItem) {
        synchronized (this.mOverlayItems) {
            this.mOverlayItems.add(overlayItem);
        }
    }

    static double getAltitude(c cVar, Feature.a aVar) {
        double a = ElevationManager.a(cVar.b(), cVar.a(), (ElevationManager.b) null);
        double c = cVar.c();
        int i = C17534.$SwitchMap$com$atakmap$map$layer$feature$Feature$AltitudeMode[aVar.ordinal()];
        if (i != 1) {
            return i != 2 ? a : c;
        }
        return a + c;
    }

    /* renamed from: com.atakmap.android.uastool.pagers.video_ui.ArOverlayView$4 */
    /* synthetic */ class C17534 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$map$layer$feature$Feature$AltitudeMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.map.layer.feature.Feature$a[] r0 = com.atakmap.map.layer.feature.Feature.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$map$layer$feature$Feature$AltitudeMode = r0
                com.atakmap.map.layer.feature.Feature$a r1 = com.atakmap.map.layer.feature.Feature.a.b     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$map$layer$feature$Feature$AltitudeMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.map.layer.feature.Feature$a r1 = com.atakmap.map.layer.feature.Feature.a.c     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.ArOverlayView.C17534.<clinit>():void");
        }
    }

    private int getSize(OverlayItem overlayItem) {
        try {
            GeoPoint dronePosition = getDronePosition();
            if (dronePosition == null) {
                return 50;
            }
            double distanceTo = dronePosition.distanceTo(new GeoPoint(overlayItem.lat, overlayItem.lon, overlayItem.alt));
            if (distanceTo > AR_CUTOFF_RANGE) {
                return -1;
            }
            int i = (int) (((AR_CUTOFF_RANGE - distanceTo) / AR_CUTOFF_RANGE) * 80.0d);
            if (i < 20) {
                return 20;
            }
            return i;
        } catch (Exception unused) {
            return 50;
        }
    }

    public void setIconAlphaPercent(double d) {
        this.paintLock.writeLock().lock();
        int i = (int) (d * 255.0d);
        try {
            this.DEFAULT_PAINT.setAlpha(i);
            this.BITMAP_PAINT.setAlpha(i);
        } finally {
            this.paintLock.writeLock().unlock();
        }
    }

    public Paint getTeamPaint(Integer num) {
        Paint paint = this.teamPaintMap.get(num);
        if (paint != null) {
            return paint;
        }
        float[] fArr = {((float) ((num.intValue() >> 16) & 255)) / 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ((float) ((num.intValue() >> 8) & 255)) / 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ((float) (num.intValue() & 255)) / 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        colorMatrix.set(fArr);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        Paint paint2 = new Paint();
        paint2.setColorFilter(colorMatrixColorFilter);
        this.teamPaintMap.put(num, paint2);
        return paint2;
    }

    private void drawOverlayItems(Canvas canvas) {
        OverlayItem next;
        Canvas canvas2 = canvas;
        if (canvas2 != null) {
            synchronized (this.mOverlayItems) {
                synchronized (this.mKmlOverlayItems) {
                    this.mOverlayItems.addAll(this.mKmlOverlayItems);
                }
                this.paintLock.readLock().lock();
                try {
                    Matrix3D transformDroneToCamera = FieldOfView.transformDroneToCamera(this.selectedUASItem.getGimbalPitch(), this.selectedUASItem.getGimbalAngle());
                    Iterator<OverlayItem> it = this.mOverlayItems.iterator();
                    while (it.hasNext()) {
                        next = it.next();
                        int size = getSize(next);
                        if (size > 0) {
                            Iterator<OverlayItem> it2 = it;
                            int i = size;
                            PointD translateToOverlayCoordsByFourCorners = translateToOverlayCoordsByFourCorners(next.lat, next.lon, next.alt, next.text, transformDroneToCamera);
                            if (translateToOverlayCoordsByFourCorners != null) {
                                if (next.markerType.equals("b-m-p-s-m")) {
                                    this.SPOT_PAINT.setStyle(Paint.Style.FILL);
                                    this.SPOT_PAINT.setColor(next.color);
                                    this.SPOT_PAINT.setAlpha(127);
                                    canvas2.drawCircle((float) translateToOverlayCoordsByFourCorners.x, (float) translateToOverlayCoordsByFourCorners.y, (float) (i / 5), this.SPOT_PAINT);
                                    this.SPOT_PAINT.setStyle(Paint.Style.STROKE);
                                    this.SPOT_PAINT.setColor(-16777216);
                                    canvas2.drawCircle((float) translateToOverlayCoordsByFourCorners.x, (float) translateToOverlayCoordsByFourCorners.y, (float) (i / 5), this.SPOT_PAINT);
                                } else if (next.bitmap != null) {
                                    double d = (double) (((float) i) / 2.0f);
                                    Rect rect = new Rect((int) (translateToOverlayCoordsByFourCorners.x - d), (int) (translateToOverlayCoordsByFourCorners.y - d), (int) (translateToOverlayCoordsByFourCorners.x + d), (int) (translateToOverlayCoordsByFourCorners.y + d));
                                    if (next.bTeamMember) {
                                        canvas2.drawBitmap(next.bitmap, (Rect) null, rect, getTeamPaint(Integer.valueOf(next.color)));
                                    } else {
                                        canvas2.drawBitmap(next.bitmap, (Rect) null, rect, this.BITMAP_PAINT);
                                    }
                                } else {
                                    canvas2.drawCircle((float) translateToOverlayCoordsByFourCorners.x, (float) translateToOverlayCoordsByFourCorners.y, (float) i, this.DEFAULT_PAINT);
                                }
                                if (next.text != null && !next.text.isEmpty()) {
                                    canvas2.drawText(next.text, (float) translateToOverlayCoordsByFourCorners.x, ((float) translateToOverlayCoordsByFourCorners.y) + ((float) i) + (this.DEFAULT_PAINT.getStrokeWidth() * 2.0f) + this.TEXT_PAINT.ascent(), this.TEXT_PAINT);
                                }
                            }
                            it = it2;
                        }
                    }
                    this.paintLock.readLock().unlock();
                } catch (Exception e) {
                    String str = TAG;
                    Log.d(str, "Failed to draw bitmap" + next.text + "-" + next.uid + ": ", e);
                } catch (Throwable th) {
                    this.paintLock.readLock().unlock();
                    throw th;
                }
            }
        }
    }

    private PointD translateToOverlayCoordsByFourCorners(double d, double d2, double d3, String str, Matrix3D matrix3D) {
        PointD pointD;
        FieldOfView fieldOfView = this.zeroAltFov.get();
        int width = getWidth();
        int height = getHeight();
        GeoPoint altZeroPoint = toAltZeroPoint(new GeoPoint(d, d2, d3));
        if (this.selectedUASItem.supportsMatrixAr() && this.selectedUASItem.getVFOV() > 0.0d && this.selectedUASItem.getVFOV() < 360.0d && this.selectedUASItem.getGimbalPitch() < 0.0d && this.selectedUASItem.getGimbalPitch() > -90.0d && this.selectedUASItem.getHFOV() > 0.0d && this.selectedUASItem.getHFOV() < 360.0d) {
            GeoPoint geoPoint = new GeoPoint(d, d2, d3);
            GeoPoint geoPoint2 = this.selectedUASItem.getGeoPoint();
            if (geoPoint2 == null) {
                return null;
            }
            double distanceTo = geoPoint2.distanceTo(geoPoint);
            double bearingTo = geoPoint2.bearingTo(geoPoint);
            Point3D transform = matrix3D.transform(new Point3D(distanceTo * Math.sin(Math.toRadians(bearingTo)), Math.cos(Math.toRadians(bearingTo)) * distanceTo, d3 - geoPoint2.getAltitude()));
            double d4 = (double) (width / 2);
            double d5 = (double) (height / 2);
            return new PointD(((Math.toDegrees(Math.atan(transform.x / transform.z)) / (this.selectedUASItem.getHFOV() / 2.0d)) * d4) + d4, ((Math.toDegrees(Math.atan(transform.y / transform.z)) / (this.selectedUASItem.getVFOV() / 2.0d)) * d5) + d5);
        } else if (fieldOfView == null) {
            Log.d(TAG, "fov reference is null");
            return null;
        } else {
            try {
                double d6 = (double) width;
                double d7 = (double) height;
                try {
                    pointD = null;
                    try {
                        return Matrix.mapQuads(fieldOfView.f8422tl, fieldOfView.f8423tr, fieldOfView.f8421br, fieldOfView.f8420bl, new PointD(0.0d, 0.0d), new PointD(d6, 0.0d), new PointD(d6, d7), new PointD(0.0d, d7)).transform(new PointD(altZeroPoint.getLatitude(), altZeroPoint.getLongitude()), (PointD) null);
                    } catch (Exception e) {
                        e = e;
                        Log.d(TAG, "Matrix transformation failed: ", e);
                        return pointD;
                    }
                } catch (Exception e2) {
                    e = e2;
                    pointD = null;
                    Log.d(TAG, "Matrix transformation failed: ", e);
                    return pointD;
                }
            } catch (Exception e3) {
                e = e3;
                pointD = null;
                Log.d(TAG, "Matrix transformation failed: ", e);
                return pointD;
            }
        }
    }

    private GeoPoint toAltZeroPoint(GeoPoint geoPoint) {
        GeoPoint dronePosition = getDronePosition();
        if (dronePosition == null) {
            Log.d(TAG, "Do not have drone position, can't account for altitude differences.");
            return geoPoint;
        }
        double atan2 = Math.atan2(new GeoPoint(dronePosition.getLatitude(), dronePosition.getLongitude(), geoPoint.getAltitude(), geoPoint.getAltitudeReference()).distanceTo(geoPoint), dronePosition.getAltitude() - geoPoint.getAltitude());
        GeoPoint geoPoint2 = new GeoPoint(dronePosition.getLatitude(), dronePosition.getLongitude(), 0.0d);
        return DistanceCalculations.computeDestinationPoint(geoPoint2, geoPoint2.bearingTo(geoPoint), dronePosition.getAltitude() * Math.tan(atan2));
    }

    private PointD translateToOverlayCoordsByFov(double d, double d2, double d3) {
        double[] frameAngleCoordinates = getFrameAngleCoordinates(d, d2, d3);
        if (frameAngleCoordinates == null) {
            return null;
        }
        double d4 = frameAngleCoordinates[0];
        double d5 = frameAngleCoordinates[1];
        double horizontalFov = getHorizontalFov();
        double verticalFov = getVerticalFov();
        return new PointD(((d4 + (horizontalFov / 2.0d)) / horizontalFov) * ((double) getWidth()), (((d5 * -1.0d) + (verticalFov / 2.0d)) / verticalFov) * ((double) getHeight()));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.arEnabled.get() && !isInEditMode()) {
            drawOverlayItems(canvas);
        }
        super.onDraw(canvas);
    }

    public boolean setArEnabled(boolean z) {
        if (this.selectedUASItem == null || !this.selectedUASItem.supportsAR()) {
            UASToolDropDownReceiver.toast("UAS doesn't support AR");
            return false;
        }
        this.arEnabled.set(z);
        return z;
    }

    public void setUASItem(UASItem uASItem) {
        if (this.selectedUASItem == null || !this.selectedUASItem.equals(uASItem)) {
            if (this.selectedUASItem != null) {
                this.selectedUASItem.removeUasItemUpdateListener(this);
            }
            this.selectedUASItem = uASItem;
            if (this.selectedUASItem != null) {
                this.selectedUASItem.addUasItemUpdateListener(this);
            }
        }
    }

    public void onUasGeoreferenceUpdate(boolean z) {
        GeoPoint geoPoint;
        if (this.selectedUASItem != null && (geoPoint = this.selectedUASItem.getGeoPoint()) != null) {
            updateGeoreference(geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude(), this.selectedUASItem.getGimbalPitch(), this.selectedUASItem.getGimbalAngle(), this.selectedUASItem.getHFOV(), this.selectedUASItem.getVFOV(), z);
        }
    }

    public void onUasFovUpdate() {
        if (this.selectedUASItem != null) {
            GeoPoint geoPoint = this.selectedUASItem.getGeoPoint();
            FieldOfView fov = this.selectedUASItem.getFov();
            if (geoPoint != null && fov != null) {
                setFieldOfView(fov);
                setDronePosition(geoPoint);
            }
        }
    }

    private void addListeners(ao aoVar, final ag agVar, final bb bbVar) {
        aoVar.addOnGroupChangedListener(new ai.c() {
            public void onItemAdded(ai aiVar, ag agVar) {
            }

            public void onItemRemoved(ai aiVar, ag agVar) {
                if (bbVar != null) {
                    String access$300 = ArOverlayView.TAG;
                    Log.d(access$300, "Item " + aiVar.getUID() + " was removed, removing associated " + bbVar.getClass().getSimpleName());
                    ag agVar2 = agVar;
                    if (agVar2 != null) {
                        agVar2.g(bbVar);
                    } else {
                        String access$3002 = ArOverlayView.TAG;
                        Log.w(access$3002, "Problem removing shape associated with item " + aiVar.getUID());
                    }
                }
                aiVar.removeOnGroupChangedListener(this);
            }
        });
    }

    private void add4CornersToAR() {
        try {
            Bitmap bitmap = this.bitmapCache.get("asset:/icons/genericpoint.png");
            if (bitmap == null && (bitmap = b.d("asset:/icons/genericpoint.png")) != null) {
                this.bitmapCache.put("asset:/icons/genericpoint.png", bitmap);
            }
            FieldOfView computeFov = FieldOfView.computeFov(this.selectedUASItem.getGeoPoint(), this.selectedUASItem.getGimbalPitch(), this.selectedUASItem.getGimbalAngle(), this.selectedUASItem.getVFOV(), this.selectedUASItem.getHFOV(), true);
            OverlayItem overlayItem = new OverlayItem();
            overlayItem.lat = computeFov.f8423tr.x;
            overlayItem.lon = computeFov.f8423tr.y;
            overlayItem.alt = computeFov.center.get().getAltitude();
            overlayItem.text = "tr";
            overlayItem.uid = this.selectedUASItem.getUid() + ".tr";
            overlayItem.bitmap = bitmap;
            addOverlayItem(overlayItem);
            OverlayItem overlayItem2 = new OverlayItem();
            overlayItem2.lat = computeFov.f8422tl.x;
            overlayItem2.lon = computeFov.f8422tl.y;
            overlayItem2.alt = computeFov.center.get().getAltitude();
            overlayItem2.text = "tl";
            overlayItem2.uid = this.selectedUASItem.getUid() + ".tl";
            overlayItem2.bitmap = bitmap;
            addOverlayItem(overlayItem2);
            OverlayItem overlayItem3 = new OverlayItem();
            overlayItem3.lat = computeFov.f8421br.x;
            overlayItem3.lon = computeFov.f8421br.y;
            overlayItem3.alt = computeFov.center.get().getAltitude();
            overlayItem3.text = "br";
            overlayItem3.uid = this.selectedUASItem.getUid() + ".br";
            overlayItem3.bitmap = bitmap;
            addOverlayItem(overlayItem3);
            OverlayItem overlayItem4 = new OverlayItem();
            overlayItem4.lat = computeFov.f8420bl.x;
            overlayItem4.lon = computeFov.f8420bl.y;
            overlayItem4.alt = computeFov.center.get().getAltitude();
            overlayItem4.text = "bl";
            overlayItem4.uid = this.selectedUASItem.getUid() + ".bl";
            overlayItem4.bitmap = bitmap;
            addOverlayItem(overlayItem4);
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }
}
