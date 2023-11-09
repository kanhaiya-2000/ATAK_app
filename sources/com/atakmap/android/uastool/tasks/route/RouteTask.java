package com.atakmap.android.uastool.tasks.route;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.av;
import com.atakmap.android.maps.o;
import com.atakmap.android.overlay.b;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.util.j;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RouteTask extends UASTask implements ai.c, av.a {
    private static final String COT_ATTRIB_IMAGE_INTERVAL = "image_interval";
    public static final String COT_TAG = "routetask";
    public static final String MAPGROUP_NAME = "UASRouteTask";
    private static final String TAG = "RouteTask";
    private static final int TASKTYPEICON = 2130968711;
    private ArrayList<j> atakDrawingCircles;
    private e atakDrawingRoute = null;
    private final ArrayList<RouteTaskChangedListener> changeListeners = new ArrayList<>();
    private Float imageryInterval;
    private boolean isQuickTask = false;
    private UASRoute route;

    public interface RouteTaskChangedListener {
        void onRouteTaskChanged(RouteTask routeTask);
    }

    public void onItemAdded(ai aiVar, ag agVar) {
    }

    public boolean showsProgress() {
        return true;
    }

    public void setGimbalPitch(int i) {
        UASRoute uASRoute = this.route;
        if (uASRoute != null && uASRoute.getPointCnt() != 0) {
            this.route.getPoints().get(0).setGimbalPitch(i);
        }
    }

    public void setImageryInterval(Float f) {
        this.imageryInterval = f;
    }

    public Float getImageryInterval() {
        return this.imageryInterval;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouteTask(UASRoute uASRoute, String str, String str2, String str3, String str4, UASTask.PRIORITY priority, UASTask.STATE state, String str5, boolean z) {
        super(str, str2, str3, str4, priority, UASTask.TASKTYPE.ROUTE, state, C1877R.drawable.task_route, str5, String.valueOf(System.currentTimeMillis()));
        this.route = uASRoute;
        this.isQuickTask = z;
    }

    public RouteTask(Element element) {
        super(UASTask.TASKTYPE.ROUTE, (int) C1877R.drawable.task_route, element);
    }

    public RouteTask(CotDetail cotDetail) {
        super(UASTask.TASKTYPE.ROUTE, (int) C1877R.drawable.task_route, cotDetail);
        CotDetail firstChildByName = cotDetail.getFirstChildByName(0, COT_TAG);
        String attribute = firstChildByName.getAttribute(COT_ATTRIB_IMAGE_INTERVAL);
        if (attribute != null) {
            try {
                this.imageryInterval = Float.valueOf(Float.parseFloat(attribute));
            } catch (NumberFormatException unused) {
            }
        }
        this.route = new UASRoute(firstChildByName.getFirstChildByName(0, UASRoute.COT_TAG), this.platform);
    }

    public String getDescription() {
        if (this.route != null) {
            return getPlatformShort() + " / " + this.route.getPointCnt() + " pts / " + TasksFragment.convertRangeToDisplay(this.route.getDistance()) + " " + TasksFragment.getRangeUnitsToDisplay();
        }
        return getPlatformShort() + " / no route";
    }

    public UASRoute getRoute() {
        return this.route;
    }

    public CotDetail toCot() {
        CotDetail cotDetail = new CotDetail(COT_TAG);
        Float f = this.imageryInterval;
        if (!(f == null || f.floatValue() == 0.0f)) {
            cotDetail.setAttribute(COT_ATTRIB_IMAGE_INTERVAL, this.imageryInterval.toString());
        }
        UASRoute uASRoute = this.route;
        if (uASRoute != null) {
            cotDetail.addChild(uASRoute.toCot());
        }
        return super.toCot(cotDetail);
    }

    public GeoPoint getFocusPoint() {
        UASPoint pointWithIndex;
        UASRoute uASRoute = this.route;
        if (uASRoute == null || (pointWithIndex = uASRoute.getPointWithIndex(1)) == null || pointWithIndex.F() == null) {
            return GeoPoint.ZERO_POINT;
        }
        return pointWithIndex.F().get();
    }

    public static RouteTask fromCot(Element element) {
        RouteTask routeTask = new RouteTask(element);
        NodeList elementsByTagName = element.getElementsByTagName(COT_TAG);
        if (elementsByTagName.getLength() != 0) {
            Node item = elementsByTagName.item(0);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.hasAttribute(COT_ATTRIB_IMAGE_INTERVAL)) {
                    try {
                        routeTask.setImageryInterval(Float.valueOf(Float.parseFloat(element2.getAttribute(COT_ATTRIB_IMAGE_INTERVAL))));
                    } catch (NumberFormatException unused) {
                    }
                }
                routeTask.setRoute(UASRoute.fromCot(element2, routeTask.platform));
            }
        }
        return routeTask;
    }

    public void removeRoutePoint(UASPoint uASPoint) {
        UASRoute uASRoute = this.route;
        if (uASRoute != null && uASPoint != null) {
            uASRoute.removePoint(uASPoint, true);
            notifyRouteTaskChangedListener();
        }
    }

    private void setRoute(UASRoute uASRoute) {
        this.route = uASRoute;
        notifyRouteTaskChangedListener();
    }

    public void addOnRouteTaskChangedListener(RouteTaskChangedListener routeTaskChangedListener) {
        this.changeListeners.add(routeTaskChangedListener);
    }

    public void removeOnRouteTaskChangedListener(RouteTaskChangedListener routeTaskChangedListener) {
        this.changeListeners.add(routeTaskChangedListener);
    }

    private void notifyRouteTaskChangedListener() {
        Iterator<RouteTaskChangedListener> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onRouteTaskChanged(this);
        }
    }

    public RouteTask copy(String str, boolean z) {
        String uid = getUID();
        if (z) {
            uid = UUID.randomUUID().toString();
        }
        RouteTask routeTask = new RouteTask(this.route.copy(str, z), uid, this.user, str, this.platform, this.priority, getState(), String.valueOf(this.color), this.isQuickTask);
        routeTask.setImageryInterval(getImageryInterval());
        return routeTask;
    }

    public RouteTask copySimple(String str, GeoPoint geoPoint, GeoPoint geoPoint2, boolean z) {
        RouteTask routeTask = new RouteTask(getSimpleRoute(geoPoint, geoPoint2, z), UUID.randomUUID().toString(), this.user, str, this.platform, this.priority, getState(), String.valueOf(this.color), this.isQuickTask);
        routeTask.setImageryInterval(getImageryInterval());
        return routeTask;
    }

    public void view(UASPoint uASPoint, boolean z) {
        if (this.isViewing) {
            hide();
        }
        super.view(uASPoint, z);
        MapView mapView = MapView.getMapView();
        o c = mapView.getRootGroup().c(MAPGROUP_NAME);
        if (c == null) {
            c = new o(MAPGROUP_NAME);
            mapView.getMapOverlayManager().f(new b(mapView, c));
        }
        e eVar = this.atakDrawingRoute;
        if (eVar != null) {
            eVar.setVisible(false);
            c.g(this.atakDrawingRoute);
            this.atakDrawingRoute = null;
        }
        this.route.showOverlay(this.name, getUID(), this.color, this, this);
        if (uASPoint != null && z) {
            this.route.highlightPoint(uASPoint, TaskEdit.viewColor);
        }
    }

    public void panTo() {
        UASPoint pointWithIndex;
        UASRoute uASRoute = this.route;
        if (uASRoute != null && (pointWithIndex = uASRoute.getPointWithIndex(1)) != null) {
            pointWithIndex.panTo();
        }
    }

    public void hide() {
        super.hide();
        this.route.hideOverlay(this.name, this);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0337: MOVE  (r7v0 com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION) = 
          (r22v0 com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x038a  */
    public com.atakmap.android.uastool.tasks.route.UASRoute getSimpleRoute(@atakplugin.UASTool.amx com.atakmap.coremap.maps.coords.GeoPoint r31, @atakplugin.UASTool.amx com.atakmap.coremap.maps.coords.GeoPoint r32, boolean r33) {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.atakmap.android.uastool.tasks.route.UASRoute r4 = new com.atakmap.android.uastool.tasks.route.UASRoute
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.atakmap.android.uastool.tasks.route.UASRoute r5 = r1.route
            java.lang.String r5 = r5.getName()
            r0.append(r5)
            java.lang.String r5 = ".simple"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.util.UUID r5 = java.util.UUID.randomUUID()
            java.lang.String r5 = r5.toString()
            com.atakmap.android.uastool.tasks.route.UASRoute r6 = r1.route
            java.util.ArrayList r6 = r6.getPoints()
            r4.<init>((java.lang.String) r0, (java.lang.String) r5, (java.util.ArrayList<com.atakmap.android.uastool.tasks.route.UASPoint>) r6)
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r5 = com.atakmap.android.uastool.tasks.route.UASPoint.FINISH_ACTION.NO_ACTION
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r8 = 1
            if (r2 == 0) goto L_0x00a0
            boolean r0 = r31.isValid()
            if (r0 == 0) goto L_0x00a0
            com.atakmap.android.uastool.tasks.route.UASRoute r0 = r1.route     // Catch:{ Exception -> 0x0096 }
            com.atakmap.android.uastool.tasks.route.UASPoint r0 = r0.getPointWithIndex(r8)     // Catch:{ Exception -> 0x0096 }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = r0.C()     // Catch:{ Exception -> 0x0096 }
            double r9 = r9.getAltitude()     // Catch:{ Exception -> 0x0096 }
            double r11 = r31.getAltitude()     // Catch:{ Exception -> 0x0096 }
            double r11 = r11 - r9
            double r9 = java.lang.Math.abs(r11)     // Catch:{ Exception -> 0x0096 }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x00a0
            com.atakmap.coremap.maps.coords.GeoPoint r9 = r0.C()     // Catch:{ Exception -> 0x0096 }
            double r9 = r2.distanceTo(r9)     // Catch:{ Exception -> 0x0096 }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x00a0
            com.atakmap.coremap.maps.coords.GeoPoint r9 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ Exception -> 0x0096 }
            double r13 = r31.getLatitude()     // Catch:{ Exception -> 0x0096 }
            double r15 = r31.getLongitude()     // Catch:{ Exception -> 0x0096 }
            float r10 = r0.getAGL()     // Catch:{ Exception -> 0x0096 }
            double r10 = (double) r10     // Catch:{ Exception -> 0x0096 }
            com.atakmap.coremap.maps.coords.GeoPoint r12 = r0.C()     // Catch:{ Exception -> 0x0096 }
            com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r19 = r12.getAltitudeReference()     // Catch:{ Exception -> 0x0096 }
            r12 = r9
            r17 = r10
            r12.<init>(r13, r15, r17, r19)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r10 = r0.getName()     // Catch:{ Exception -> 0x0096 }
            r11 = 2
            com.atakmap.android.uastool.tasks.route.WayPoint r0 = r0.copyAsWayPoint(r10, r8, r8)     // Catch:{ Exception -> 0x0094 }
            r0.a(r9)     // Catch:{ Exception -> 0x0094 }
            r3.add(r0)     // Catch:{ Exception -> 0x0094 }
            goto L_0x00a1
        L_0x0094:
            r0 = move-exception
            goto L_0x0098
        L_0x0096:
            r0 = move-exception
            r11 = 1
        L_0x0098:
            java.lang.String r9 = TAG
            java.lang.String r10 = "error"
            com.atakmap.coremap.log.Log.e(r9, r10, r0)
            goto L_0x00a1
        L_0x00a0:
            r11 = 1
        L_0x00a1:
            r9 = 0
        L_0x00a2:
            com.atakmap.android.uastool.tasks.route.UASRoute r10 = r1.route
            int r10 = r10.getPointCnt()
            r12 = 1065353216(0x3f800000, float:1.0)
            if (r9 >= r10) goto L_0x0314
            com.atakmap.android.uastool.tasks.route.UASRoute r10 = r1.route
            int r13 = r9 + 1
            com.atakmap.android.uastool.tasks.route.UASPoint r10 = r10.getPointWithIndex(r13)
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r14 = r10.getPointType()
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r15 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.WAYPOINT
            boolean r14 = r14.equals(r15)
            java.lang.String r15 = "-safe"
            if (r14 == 0) goto L_0x0158
            r14 = r10
            com.atakmap.android.uastool.tasks.route.WayPoint r14 = (com.atakmap.android.uastool.tasks.route.WayPoint) r14
            java.lang.String r0 = r14.getGotoMode()
            java.lang.String r6 = "Safely"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0131
            com.atakmap.android.uastool.tasks.route.UASRoute r0 = r1.route
            com.atakmap.android.uastool.tasks.route.UASPoint r0 = r0.getPointWithIndex(r9)
            if (r0 == 0) goto L_0x0131
            float r6 = r0.getAGL()
            float r7 = r10.getAGL()
            float r6 = r6 - r7
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 <= 0) goto L_0x0131
            com.atakmap.coremap.maps.coords.GeoPoint r6 = new com.atakmap.coremap.maps.coords.GeoPoint
            com.atakmap.coremap.maps.coords.GeoPoint r7 = r0.C()
            double r20 = r7.getLatitude()
            com.atakmap.coremap.maps.coords.GeoPoint r0 = r0.C()
            double r22 = r0.getLongitude()
            com.atakmap.coremap.maps.coords.GeoPoint r0 = r10.C()
            double r24 = r0.getAltitude()
            com.atakmap.coremap.maps.coords.GeoPoint r0 = r10.C()
            com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r26 = r0.getAltitudeReference()
            r19 = r6
            r19.<init>(r20, r22, r24, r26)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = r14.getName()
            r0.append(r7)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            int r7 = r11 + 1
            com.atakmap.android.uastool.tasks.route.WayPoint r0 = r14.copy((java.lang.String) r0, (int) r11, (boolean) r8)
            r0.a(r6)
            r3.add(r0)
            r11 = r7
        L_0x0131:
            java.lang.String r0 = r14.getName()
            int r6 = r11 + 1
            com.atakmap.android.uastool.tasks.route.WayPoint r0 = r14.copy((java.lang.String) r0, (int) r11, (boolean) r8)
            r3.add(r0)
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r0 = r14.getFinishAction()
            if (r0 == 0) goto L_0x0151
            com.atakmap.android.uastool.tasks.route.UASRoute r0 = r1.route
            int r0 = r0.getPointCnt()
            int r0 = r0 - r8
            if (r9 != r0) goto L_0x0151
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r5 = r14.getFinishAction()
        L_0x0151:
            r21 = r4
            r22 = r5
            r11 = r6
            goto L_0x0309
        L_0x0158:
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r0 = r10.getPointType()
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r6 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.ORBITPOINT
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0305
            r0 = r10
            com.atakmap.android.uastool.tasks.route.OrbitPoint r0 = (com.atakmap.android.uastool.tasks.route.OrbitPoint) r0
            com.atakmap.android.uastool.tasks.route.UASRoute r6 = r1.route
            com.atakmap.android.uastool.tasks.route.UASPoint r6 = r6.getPointWithIndex(r9)
            if (r6 == 0) goto L_0x01c7
            float r7 = r6.getAGL()
            float r14 = r10.getAGL()
            float r7 = r7 - r14
            float r7 = java.lang.Math.abs(r7)
            int r7 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x01c7
            com.atakmap.coremap.maps.coords.GeoPoint r7 = new com.atakmap.coremap.maps.coords.GeoPoint
            com.atakmap.coremap.maps.coords.GeoPoint r12 = r6.C()
            double r20 = r12.getLatitude()
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r6.C()
            double r22 = r6.getLongitude()
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r10.C()
            double r24 = r6.getAltitude()
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r10.C()
            com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r26 = r6.getAltitudeReference()
            r19 = r7
            r19.<init>(r20, r22, r24, r26)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = r0.getName()
            r6.append(r10)
            r6.append(r15)
            java.lang.String r6 = r6.toString()
            int r10 = r11 + 1
            com.atakmap.android.uastool.tasks.route.WayPoint r6 = r0.copyAsWayPoint(r6, r11, r8)
            r6.a(r7)
            r3.add(r6)
            r11 = r10
        L_0x01c7:
            com.atakmap.android.uastool.tasks.route.UASRoute r6 = r1.route
            com.atakmap.android.uastool.tasks.route.UASPoint r6 = r6.getPointWithIndex(r9)
            if (r6 == 0) goto L_0x01e1
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r6.C()
            com.atakmap.coremap.maps.coords.GeoPoint r7 = r0.C()
            float r10 = r0.getOrbitRadius()
            double r14 = (double) r10
            int r6 = com.atakmap.android.uastool.tasks.route.OrbitPoint.closestOrbitPoint(r6, r7, r14)
            goto L_0x01f2
        L_0x01e1:
            if (r2 == 0) goto L_0x01f1
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r0.C()
            float r7 = r0.getOrbitRadius()
            double r14 = (double) r7
            int r6 = com.atakmap.android.uastool.tasks.route.OrbitPoint.closestOrbitPoint(r2, r6, r14)
            goto L_0x01f2
        L_0x01f1:
            r6 = 0
        L_0x01f2:
            boolean r7 = r0.getOrbitClockwise()
            java.lang.String r10 = "-"
            if (r7 == 0) goto L_0x0263
            r7 = r6
            r12 = 0
        L_0x01fc:
            int r14 = r0.getOrbitCount()
            int r14 = r14 * 360
            int r14 = r14 + r6
            if (r7 > r14) goto L_0x025c
            com.atakmap.coremap.maps.coords.GeoPoint r14 = r0.C()
            int r15 = r7 % 360
            r20 = r9
            double r8 = (double) r15
            float r15 = r0.getOrbitRadius()
            r21 = r4
            r22 = r5
            double r4 = (double) r15
            com.atakmap.coremap.maps.coords.GeoPoint r4 = com.atakmap.coremap.maps.coords.GeoCalculations.pointAtDistance(r14, r8, r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = r0.getName()
            r5.append(r8)
            r5.append(r10)
            int r12 = r12 + 1
            r5.append(r12)
            java.lang.String r5 = r5.toString()
            int r8 = r11 + 1
            r9 = 1
            com.atakmap.android.uastool.tasks.route.WayPoint r5 = r0.copyAsWayPoint(r5, r11, r9)
            r5.a(r4)
            if (r7 != r6) goto L_0x0247
            float r4 = r0.getSpeed()
            r5.setSpeed(r4)
            goto L_0x024e
        L_0x0247:
            float r4 = r0.getOrbitSpeed()
            r5.setSpeed(r4)
        L_0x024e:
            r3.add(r5)
            int r7 = r7 + 30
            r11 = r8
            r9 = r20
            r4 = r21
            r5 = r22
            r8 = 1
            goto L_0x01fc
        L_0x025c:
            r21 = r4
            r22 = r5
            r20 = r9
            goto L_0x02cb
        L_0x0263:
            r21 = r4
            r22 = r5
            r20 = r9
            int r4 = r0.getOrbitCount()
            int r4 = r4 * 360
            int r4 = r4 + r6
            r12 = 0
        L_0x0271:
            if (r4 < r6) goto L_0x02cb
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r0.C()
            int r7 = r4 % 360
            double r7 = (double) r7
            float r9 = r0.getOrbitRadius()
            double r14 = (double) r9
            com.atakmap.coremap.maps.coords.GeoPoint r5 = com.atakmap.coremap.maps.coords.GeoCalculations.pointAtDistance(r5, r7, r14)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r0.getName()
            r7.append(r8)
            r7.append(r10)
            int r12 = r12 + 1
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            int r8 = r11 + 1
            r9 = 1
            com.atakmap.android.uastool.tasks.route.WayPoint r7 = r0.copyAsWayPoint(r7, r11, r9)
            r7.a(r5)
            float r5 = r0.getOrbitSpeed()
            r7.setSpeed(r5)
            int r5 = r0.getOrbitCount()
            int r5 = r5 * 360
            int r5 = r5 + r6
            if (r4 != r5) goto L_0x02bd
            float r5 = r0.getSpeed()
            r7.setSpeed(r5)
            goto L_0x02c4
        L_0x02bd:
            float r5 = r0.getOrbitSpeed()
            r7.setSpeed(r5)
        L_0x02c4:
            r3.add(r7)
            int r4 = r4 + -30
            r11 = r8
            goto L_0x0271
        L_0x02cb:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r0.getName()
            r4.append(r5)
            r4.append(r10)
            r5 = 1
            int r12 = r12 + r5
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            int r6 = r11 + 1
            com.atakmap.android.uastool.tasks.route.WayPoint r4 = r0.copyAsWayPoint(r4, r11, r5)
            r3.add(r4)
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r4 = r0.getFinishAction()
            if (r4 == 0) goto L_0x0303
            com.atakmap.android.uastool.tasks.route.UASRoute r4 = r1.route
            int r4 = r4.getPointCnt()
            int r4 = r4 - r5
            r7 = r20
            if (r7 != r4) goto L_0x0303
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r0 = r0.getFinishAction()
            r22 = r0
        L_0x0303:
            r11 = r6
            goto L_0x030a
        L_0x0305:
            r21 = r4
            r22 = r5
        L_0x0309:
            r5 = 1
        L_0x030a:
            r9 = r13
            r4 = r21
            r5 = r22
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r8 = 1
            goto L_0x00a2
        L_0x0314:
            r21 = r4
            r22 = r5
            r5 = 1
            com.atakmap.android.uastool.tasks.route.UASRoute r0 = r1.route
            com.atakmap.android.uastool.tasks.route.UASPoint r0 = r0.getPointWithIndex(r5)
            com.atakmap.coremap.maps.coords.GeoPoint r2 = r0.C()
            com.atakmap.android.uastool.tasks.route.UASRoute r4 = r1.route
            int r5 = r4.getPointCnt()
            com.atakmap.android.uastool.tasks.route.UASPoint r4 = r4.getPointWithIndex(r5)
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r4.C()
            if (r33 == 0) goto L_0x0415
            if (r22 == 0) goto L_0x0415
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r6 = com.atakmap.android.uastool.tasks.route.UASPoint.FINISH_ACTION.NO_ACTION
            r7 = r22
            if (r6 != r7) goto L_0x033d
            goto L_0x0415
        L_0x033d:
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r6 = com.atakmap.android.uastool.tasks.route.UASPoint.FINISH_ACTION.GO_HOME_LAND
            r8 = 0
            r9 = 0
            if (r6 != r7) goto L_0x038a
            if (r32 == 0) goto L_0x0415
            double r5 = r32.getLatitude()
            double r12 = r32.getLongitude()
            double r5 = com.atakmap.map.elevation.ElevationManager.a(r5, r12, r9)
            com.atakmap.coremap.maps.coords.GeoPoint r0 = new com.atakmap.coremap.maps.coords.GeoPoint
            double r23 = r32.getLatitude()
            double r25 = r32.getLongitude()
            float r2 = r4.getAGL()
            double r9 = (double) r2
            double r27 = r5 + r9
            com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r29 = r32.getAltitudeReference()
            r22 = r0
            r22.<init>(r23, r25, r27, r29)
            int r2 = r11 + 1
            java.lang.String r5 = "Go Home and Land"
            r6 = 1
            com.atakmap.android.uastool.tasks.route.WayPoint r5 = r4.copyAsWayPoint(r5, r11, r6)
            r5.a(r0)
            r3.add(r5)
            java.lang.String r0 = r7.getCotValue()
            com.atakmap.android.uastool.tasks.route.WayPoint r0 = r4.copyAsWayPoint(r0, r2, r6)
            r0.setAGL(r8)
            r3.add(r0)
            goto L_0x0415
        L_0x038a:
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r6 = com.atakmap.android.uastool.tasks.route.UASPoint.FINISH_ACTION.HOVER_AT_FIRST_WAYPOINT
            if (r6 != r7) goto L_0x03e0
            float r6 = r0.getAGL()
            float r4 = r4.getAGL()
            float r6 = r6 - r4
            float r4 = java.lang.Math.abs(r6)
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x03d3
            double r8 = r5.distanceTo(r2)
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r4 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x03d3
            com.atakmap.coremap.maps.coords.GeoPoint r4 = new com.atakmap.coremap.maps.coords.GeoPoint
            double r23 = r5.getLatitude()
            double r25 = r5.getLongitude()
            double r27 = r2.getAltitude()
            com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r29 = r2.getAltitudeReference()
            r22 = r4
            r22.<init>(r23, r25, r27, r29)
            java.lang.String r2 = r7.getCotValue()
            int r5 = r11 + 1
            r6 = 1
            com.atakmap.android.uastool.tasks.route.WayPoint r2 = r0.copyAsWayPoint(r2, r11, r6)
            r2.a(r4)
            r3.add(r2)
            r11 = r5
            goto L_0x03d4
        L_0x03d3:
            r6 = 1
        L_0x03d4:
            java.lang.String r2 = r7.getCotValue()
            com.atakmap.android.uastool.tasks.route.WayPoint r0 = r0.copyAsWayPoint(r2, r11, r6)
            r3.add(r0)
            goto L_0x0415
        L_0x03e0:
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r0 = com.atakmap.android.uastool.tasks.route.UASPoint.FINISH_ACTION.LAND_AT_LAST
            if (r0 != r7) goto L_0x0415
            double r12 = r5.getLatitude()
            double r14 = r5.getLongitude()
            double r27 = com.atakmap.map.elevation.ElevationManager.a(r12, r14, r9)
            com.atakmap.coremap.maps.coords.GeoPoint r0 = new com.atakmap.coremap.maps.coords.GeoPoint
            double r23 = r5.getLatitude()
            double r25 = r5.getLongitude()
            com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r29 = r2.getAltitudeReference()
            r22 = r0
            r22.<init>(r23, r25, r27, r29)
            java.lang.String r2 = r7.getCotValue()
            r5 = 1
            com.atakmap.android.uastool.tasks.route.WayPoint r2 = r4.copyAsWayPoint(r2, r11, r5)
            r2.a(r0)
            r2.setAGL(r8)
            r3.add(r2)
        L_0x0415:
            r2 = r21
            r2.setPoints(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.route.RouteTask.getSimpleRoute(com.atakmap.coremap.maps.coords.GeoPoint, com.atakmap.coremap.maps.coords.GeoPoint, boolean):com.atakmap.android.uastool.tasks.route.UASRoute");
    }

    public void onPointChanged(av avVar) {
        int indexOf;
        if (avVar.hasMetaValue("uas_route_id")) {
            int metaInteger = avVar.getMetaInteger("uas_route_id", 1);
            ArrayList<UASPoint> points = this.route.getPoints();
            UASPoint pointWithIndex = this.route.getPointWithIndex(metaInteger);
            if (points != null && pointWithIndex != null && (indexOf = points.indexOf(pointWithIndex)) >= 0 && indexOf < points.size()) {
                pointWithIndex.a(avVar.C());
                points.set(indexOf, pointWithIndex);
                this.route.setPoints(points);
                UASTaskStore.getInstance().saveTask(this);
                this.route.hideOverlay(this.name, this);
                this.route.showOverlay(this.name, getUID(), this.color, this, this);
            }
        }
    }

    public void onItemRemoved(ai aiVar, ag agVar) {
        int indexOf;
        if (aiVar.hasMetaValue("uas_route_id")) {
            int metaInteger = aiVar.getMetaInteger("uas_route_id", 1);
            ArrayList<UASPoint> points = this.route.getPoints();
            UASPoint pointWithIndex = this.route.getPointWithIndex(metaInteger);
            if (points != null && pointWithIndex != null && (indexOf = points.indexOf(pointWithIndex)) >= 0 && indexOf < points.size()) {
                points.remove(indexOf);
                int size = points.size();
                for (int i = 0; i < size; i++) {
                    UASPoint uASPoint = points.get(i);
                    if (uASPoint.getIndex() > metaInteger) {
                        uASPoint.setIndex(uASPoint.getIndex() - 1);
                    }
                }
                this.route.setPoints(points);
                UASTaskStore.getInstance().saveTask(this);
                this.route.hideOverlay(this.name, this);
                this.route.showOverlay(this.name, getUID(), this.color, this, this);
            }
        }
    }

    public boolean getIsQuickTask() {
        return this.isQuickTask;
    }
}
