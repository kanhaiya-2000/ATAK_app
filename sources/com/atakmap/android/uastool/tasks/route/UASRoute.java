package com.atakmap.android.uastool.tasks.route;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.at;
import com.atakmap.android.maps.av;
import com.atakmap.android.maps.o;
import com.atakmap.android.menu.k;
import com.atakmap.android.overlay.b;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.utils.UasMapItemIconUtil;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.ae;
import com.atakmap.android.util.j;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.coords.GeoCalculations;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.GeoPointMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UASRoute implements Parcelable {
    public static final String CHECKPOINT_TYPE = "b-m-p-c";
    public static final String COT_TAG = "UASRoute";
    public static final Parcelable.Creator<UASRoute> CREATOR = new Parcelable.Creator<UASRoute>() {
        public UASRoute createFromParcel(Parcel parcel) {
            return new UASRoute(parcel);
        }

        public UASRoute[] newArray(int i) {
            return new UASRoute[i];
        }
    };
    private static final String TAG = "UASRoute";
    public static final String WAYPOINT_TYPE = "b-m-p-w";
    private String name;
    private ArrayList<UASPoint> points;
    private String uid;

    public int describeContents() {
        return 0;
    }

    public UASRoute(String str, String str2, ArrayList<UASPoint> arrayList) {
        this.name = str;
        this.uid = str2;
        this.points = arrayList;
    }

    public UASRoute(e eVar, UASItem uASItem, String str) {
        WayPoint fromScratch;
        this.points = new ArrayList<>();
        if (eVar != null) {
            int i = 1;
            for (av avVar : eVar.getPointMapItemArray()) {
                if ((avVar.getType().equals(WAYPOINT_TYPE) || avVar.getType().equals(CHECKPOINT_TYPE)) && (fromScratch = WayPoint.fromScratch(uASItem, i, avVar.C(), str)) != null) {
                    this.points.add(fromScratch);
                    i++;
                }
            }
            this.name = eVar.getTitle();
            this.uid = UUID.randomUUID().toString();
            return;
        }
        UASToolDropDownReceiver.toast("Unable to import null ATAK route", 0);
    }

    public UASRoute(CotDetail cotDetail, String str) {
        this.name = cotDetail.getAttribute(UASTask.COTDETAIL_NAME);
        this.uid = cotDetail.getAttribute(UASTask.COTDETAIL_UID);
        this.points = new ArrayList<>();
        for (CotDetail fromCot : cotDetail.getChildrenByName(WayPoint.COT_TAG)) {
            this.points.add(WayPoint.fromCot(fromCot, str));
        }
        for (CotDetail fromCot2 : cotDetail.getChildrenByName(OrbitPoint.COT_TAG)) {
            this.points.add(OrbitPoint.fromCot(fromCot2, str));
        }
    }

    protected UASRoute(Parcel parcel) {
        this.name = parcel.readString();
        this.uid = parcel.readString();
        this.points = parcel.createTypedArrayList(UASPoint.CREATOR);
    }

    public ArrayList<UASPoint> getPoints() {
        return this.points;
    }

    public void switchPlatform(UASItem uASItem, String str) {
        Object obj;
        boolean booleanValue = UASItem.checkCapability((UASItem) null, str, UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT).booleanValue();
        ArrayList arrayList = new ArrayList();
        Iterator<UASPoint> it = this.points.iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            int i = C21582.f8415x5ed4c682[next.getPointType().ordinal()];
            if (i == 1) {
                obj = new WayPoint(next, str);
            } else if (i != 2) {
                UASToolDropDownReceiver.toast("Unknown point type " + next.getPointType().name() + " in switchPlatform", 0);
                obj = null;
            } else {
                obj = booleanValue ? new OrbitPoint(next, str) : new WayPoint(next, str);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        this.points.clear();
        this.points.addAll(arrayList);
    }

    /* renamed from: com.atakmap.android.uastool.tasks.route.UASRoute$2 */
    /* synthetic */ class C21582 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tasks$route$UASPoint$POINTTYPE */
        static final /* synthetic */ int[] f8415x5ed4c682;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE[] r0 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8415x5ed4c682 = r0
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8415x5ed4c682     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.ORBITPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8415x5ed4c682     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.SENTINELPOINT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.route.UASRoute.C21582.<clinit>():void");
        }
    }

    public UASPoint getPointWithIndex(int i) {
        return getPointWithIndex(this.points, i);
    }

    public static UASPoint getPointWithIndex(ArrayList<UASPoint> arrayList, int i) {
        Iterator<UASPoint> it = arrayList.iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            if (next.getIndex() == i) {
                return next;
            }
        }
        return null;
    }

    public void setPoints(ArrayList<UASPoint> arrayList) {
        this.points = arrayList;
    }

    public void exchangePoints(ArrayList<UASPoint> arrayList) {
        Iterator<UASPoint> it = arrayList.iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            UASPoint pointWithIndex = getPointWithIndex(next.getIndex());
            if (pointWithIndex != null) {
                removePoint(pointWithIndex, true);
            }
            addPoint(next);
        }
    }

    public void addPoint(UASPoint uASPoint) {
        this.points.add(uASPoint);
    }

    public void removePoint(UASPoint uASPoint, boolean z) {
        if (z) {
            for (int indexOf = this.points.indexOf(uASPoint); indexOf < this.points.size(); indexOf++) {
                UASPoint uASPoint2 = this.points.get(indexOf);
                uASPoint2.setIndex(uASPoint2.getIndex() - 1);
                String name2 = uASPoint2.getName();
                if (name2.equals(OrbitPoint.PREFIX + (uASPoint2.getIndex() + 1))) {
                    uASPoint2.setName(OrbitPoint.PREFIX + uASPoint2.getIndex());
                } else {
                    String name3 = uASPoint2.getName();
                    if (name3.equals(WayPoint.PREFIX + (uASPoint2.getIndex() + 1))) {
                        uASPoint2.setName(WayPoint.PREFIX + uASPoint2.getIndex());
                    } else {
                        String name4 = uASPoint2.getName();
                        if (name4.equals(SentinelPoint.PREFIX + (uASPoint2.getIndex() + 1))) {
                            uASPoint2.setName(SentinelPoint.PREFIX + uASPoint2.getIndex());
                        }
                    }
                }
            }
        }
        this.points.remove(uASPoint);
    }

    public int getPointCnt() {
        return this.points.size();
    }

    public String getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public double getDistance() {
        Iterator<UASPoint> it = this.points.iterator();
        double d = 0.0d;
        UASPoint uASPoint = null;
        while (it.hasNext()) {
            UASPoint next = it.next();
            if (uASPoint != null) {
                d += next.C().distanceTo(uASPoint.C());
            }
            uASPoint = next;
        }
        return d;
    }

    public CotDetail toCot() {
        CotDetail cotDetail = new CotDetail("UASRoute");
        cotDetail.setAttribute(UASTask.COTDETAIL_NAME, this.name);
        cotDetail.setAttribute(UASTask.COTDETAIL_UID, this.uid);
        Iterator<UASPoint> it = this.points.iterator();
        while (it.hasNext()) {
            cotDetail.addChild(it.next().toCot());
        }
        return cotDetail;
    }

    public static UASRoute fromCot(Element element, String str) {
        OrbitPoint fromCot;
        WayPoint fromCot2;
        NodeList elementsByTagName = element.getElementsByTagName("UASRoute");
        if (elementsByTagName.getLength() != 0) {
            Node item = elementsByTagName.item(0);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                String attribute = element2.getAttribute(UASTask.COTDETAIL_NAME);
                String attribute2 = element2.getAttribute(UASTask.COTDETAIL_UID);
                ArrayList arrayList = new ArrayList();
                NodeList elementsByTagName2 = element2.getElementsByTagName(WayPoint.COT_TAG);
                for (int i = 0; i < elementsByTagName2.getLength(); i++) {
                    Node item2 = elementsByTagName2.item(i);
                    if (item2.getNodeType() == 1 && (fromCot2 = WayPoint.fromCot((Element) item2, str)) != null) {
                        arrayList.add(fromCot2);
                    }
                }
                NodeList elementsByTagName3 = element2.getElementsByTagName(OrbitPoint.COT_TAG);
                for (int i2 = 0; i2 < elementsByTagName3.getLength(); i2++) {
                    Node item3 = elementsByTagName3.item(i2);
                    if (item3.getNodeType() == 1 && (fromCot = OrbitPoint.fromCot((Element) item3, str)) != null) {
                        arrayList.add(fromCot);
                    }
                }
                return new UASRoute(attribute, attribute2, (ArrayList<UASPoint>) arrayList);
            }
        }
        return null;
    }

    public UASRoute copy(String str, boolean z) {
        String str2 = this.uid;
        if (z) {
            str2 = UUID.randomUUID().toString();
        }
        return new UASRoute(str, str2, copyPoints(z));
    }

    public ArrayList<UASPoint> copyPoints(boolean z) {
        ArrayList<UASPoint> arrayList = new ArrayList<>(this.points.size());
        Iterator<UASPoint> it = this.points.iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            arrayList.add(next.copy(next.getName(), next.getIndex(), z));
        }
        return arrayList;
    }

    public ag showOverlay(String str, String str2, int i, av.a aVar, ai.c cVar) {
        int i2;
        String str3 = str;
        int i3 = i;
        o d = MapView.getMapView().getRootGroup().d("UAS Routes");
        boolean z = true;
        if (d == null) {
            d = new o("UAS Routes", "uas_routes", true);
            MapView.getMapView().getMapOverlayManager().g(new b(MapView.getMapView(), d, "android.resource://" + UASToolDropDownReceiver.getInstance().getPluginContext().getPackageName() + "/" + C1877R.drawable.uas_route));
        }
        ag d2 = d.d(str3);
        if (d2 == null) {
            d2 = d.a(str3);
        }
        String[] strArr = new String[getPointCnt()];
        String[] strArr2 = new String[(getPointCnt() > 0 ? getPointCnt() - 1 : 0)];
        int i4 = 0;
        while (i4 < getPointCnt()) {
            int i5 = i4 + 1;
            UASPoint pointWithIndex = getPointWithIndex(i5);
            if (pointWithIndex == null) {
                String str4 = str2;
                ai.c cVar2 = cVar;
            } else {
                ao asATAKMarker = pointWithIndex.getAsATAKMarker(z, z);
                asATAKMarker.a(pointWithIndex.getIcon(UasMapItemIconUtil.ICON_SIZE.SMALL, i3));
                asATAKMarker.setClickable(z);
                asATAKMarker.setMovable(z);
                asATAKMarker.setTouchable(z);
                asATAKMarker.removeMetaData("menu");
                asATAKMarker.setMetaString("menu", k.a(UASToolDropDownReceiver.getInstance().getPluginContext(), "menus/route_waypoint_menu.xml"));
                asATAKMarker.a(aVar);
                asATAKMarker.addOnGroupChangedListener(cVar);
                asATAKMarker.setMetaInteger("uas_route_id", pointWithIndex.getIndex());
                asATAKMarker.setMetaString("route_uid", str2);
                strArr[i4] = asATAKMarker.getUID();
                d2.d(asATAKMarker);
                if (i4 < getPointCnt() - (z ? 1 : 0)) {
                    UASPoint pointWithIndex2 = getPointWithIndex(i4 + 2);
                    if (pointWithIndex2 != null) {
                        double distanceTo = pointWithIndex.C().distanceTo(pointWithIndex2.C());
                        double speed = (double) pointWithIndex2.getSpeed();
                        UASItem defaultUasItem = UASToolDropDownReceiver.getInstance().getDefaultUasItem();
                        double d3 = -1.0d;
                        i2 = i5;
                        if (defaultUasItem != null) {
                            d3 = UASItem.getCapabilityValueDouble(defaultUasItem, defaultUasItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, -1.0d);
                        }
                        if (speed > 0.0d || d3 > 0.0d) {
                            if (speed == 0.0d) {
                                speed = d3;
                            }
                            int i6 = (int) (distanceTo / speed);
                            strArr2[i4] = String.format("%s %d:%ds", new Object[]{ae.a().a(speed), Integer.valueOf(i6 / 60), Integer.valueOf(i6 % 60)});
                        } else {
                            strArr2[i4] = Utils.formatRange(distanceTo);
                        }
                    } else {
                        i2 = i5;
                        strArr2[i4] = "";
                    }
                    i4 = i2;
                    z = true;
                }
            }
            i2 = i5;
            i4 = i2;
            z = true;
        }
        Intent intent = new Intent();
        intent.putExtra("uidArray", strArr);
        intent.putExtra("titleArray", strArr2);
        intent.putExtra(UASTask.COTDETAIL_COLOR, i3);
        at.a().a(MapView.getMapView().getContext(), intent);
        Iterator<j> it = getATAKOrbitCircles(i3).iterator();
        while (it.hasNext()) {
            d2.d(it.next());
        }
        return d2;
    }

    public void hideOverlay(String str, ai.c cVar) {
        ag d;
        ag d2 = MapView.getMapView().getRootGroup().d("UAS Routes");
        if (d2 != null && (d = d2.d(str)) != null) {
            for (ai aiVar : d.j()) {
                aiVar.removeOnGroupChangedListener(cVar);
                d.g(aiVar);
            }
            d2.b(d);
        }
    }

    public void highlightPoint(UASPoint uASPoint, int i) {
        uASPoint.getAsATAKMarker(false, true).a(uASPoint.getIcon(UasMapItemIconUtil.ICON_SIZE.SMALL, i));
    }

    public ArrayList<j> getATAKOrbitCircles(int i) {
        ArrayList<j> arrayList = new ArrayList<>();
        int i2 = 0;
        while (i2 < getPointCnt()) {
            i2++;
            UASPoint pointWithIndex = getPointWithIndex(i2);
            if (pointWithIndex instanceof OrbitPoint) {
                OrbitPoint orbitPoint = (OrbitPoint) pointWithIndex;
                j circle = getCircle(orbitPoint.C(), (double) orbitPoint.getOrbitRadius(), i);
                circle.setTitle(pointWithIndex.getName() + " circle");
                arrayList.add(circle);
            }
        }
        return arrayList;
    }

    public static j getCircle(GeoPoint geoPoint, double d, int i) {
        j jVar = new j(new GeoPointMetaData(geoPoint), d);
        jVar.setStrokeColor(i);
        jVar.setStrokeWeight(2.0d);
        jVar.setBasicLineStyle(1);
        jVar.setVisible(true);
        jVar.setTouchable(false);
        jVar.setClickable(false);
        jVar.setEditable(false);
        jVar.setMovable(false);
        return jVar;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.uid);
        parcel.writeTypedList(this.points);
    }

    public static UASRoute makeQuickOrbit(UASItem uASItem, GeoPoint geoPoint, double d, double d2, boolean z) {
        OrbitPoint fromScratch = OrbitPoint.fromScratch(uASItem, 1, geoPoint, uASItem.getPlatformType());
        fromScratch.setName("Quick Orbit");
        fromScratch.setOrbitClockwise(z);
        fromScratch.setOrbitRadius((float) d);
        fromScratch.setAGL((float) d2);
        fromScratch.setOrbitSpeed((float) UASItem.getCapabilityValueDouble(uASItem, uASItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_DEFAULT, 8.0d));
        fromScratch.setSpeed((float) UASItem.getCapabilityValueDouble(uASItem, uASItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, 8.0d));
        fromScratch.setOrbitCount(UASItem.getCapabilityValueInt(uASItem, uASItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MAX, 1000));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(fromScratch);
        return new UASRoute("Quick Orbit", UUID.randomUUID().toString(), (ArrayList<UASPoint>) arrayList);
    }

    public static UASRoute makeQuickFlyTo(UASItem uASItem, GeoPoint geoPoint, double d) {
        WayPoint fromScratch = WayPoint.fromScratch(uASItem, 1, geoPoint, uASItem.getPlatformType());
        fromScratch.setName("Quick FlyTo");
        fromScratch.setAGL((float) d);
        fromScratch.setSpeed((float) UASItem.getCapabilityValueDouble(uASItem, uASItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, 8.0d));
        fromScratch.setVisible(false);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(fromScratch);
        return new UASRoute("Quick WayPoint", UUID.randomUUID().toString(), (ArrayList<UASPoint>) arrayList);
    }

    public void recomputeHAL(double d) {
        Iterator<UASPoint> it = this.points.iterator();
        while (it.hasNext()) {
            it.next().getHAL(d);
        }
    }

    public void recomputeHAL(UASItem uASItem) {
        double d;
        if (uASItem == null) {
            UASToolDropDownReceiver.toast("Can not recompute HAL with no UAS Item", 0);
        } else {
            GeoPoint homePosition = uASItem.getHomePosition();
            if (homePosition == null || Double.isNaN(homePosition.getAltitude())) {
                UASToolDropDownReceiver.toast("Can not recompute HAL with no home position", 0);
            } else {
                d = homePosition.getAltitude();
                recomputeHAL(d);
            }
        }
        d = Double.NaN;
        recomputeHAL(d);
    }

    public String toString(GeoPoint geoPoint) {
        StringBuilder sb = new StringBuilder();
        Iterator<UASPoint> it = this.points.iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            GeoPoint C = next.C();
            if (geoPoint == null) {
                geoPoint = C;
            }
            sb.append(String.format("%d: %s: %s agl:%f, slant: %f dist:%f speed: %f\n", new Object[]{Integer.valueOf(next.getIndex()), next.getName(), C.toString(), Double.valueOf((double) next.getAGL()), Double.valueOf(GeoCalculations.slantDistanceTo(C, geoPoint)), Double.valueOf(C.distanceTo(geoPoint)), Float.valueOf(next.speed)}));
            geoPoint = C;
        }
        return sb.toString();
    }
}
