package com.atakmap.android.uastool.p000av;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.ay;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.user.g;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.GeoPointMetaData;
import java.util.HashMap;

/* renamed from: com.atakmap.android.uastool.av.AvUASItem */
public class AvUASItem extends UASItem {
    public static final String DETAIL_TAG = "_AVInc";
    public static final String DISPLAY_NAME = "AV - Puma/Raven/Wasp";
    public static final String DISPLAY_NAME_SHORT = "AV";

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public static HashMap<String, String> getDetailAttrs() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Flight_Mode", "String");
        hashMap.put("Target_Waypoint", "String");
        hashMap.put("Range_To_Target", "int");
        return hashMap;
    }

    public AvUASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public AvUASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME_SHORT, z);
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SIGNAL_STRENGTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_VOLTAGE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TEMPERATURE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_WIND_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW, true);
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (AVSettingsScreen) layoutInflater.inflate(C1877R.layout.av_settings_layout, (ViewGroup) null);
    }

    public void updateStatusData() {
        super.updateStatusData();
    }

    public void showRoute() {
        char c;
        char c2;
        char c3;
        String[] strArr;
        ag c4 = MapView.getMapView().getRootGroup().c("Route");
        String str = "";
        if (this.uasMarker != null) {
            str = this.uasMarker.getMetaString("waypoints", str);
        }
        String str2 = this.uid;
        e eVar = new e(MapView.getMapView(), this.uid + " Route", TaskEdit.viewColor, str2, this.uid + "Route");
        if (!str.isEmpty()) {
            String[] split = str.split("\n");
            int i = 1;
            while (true) {
                c = 3;
                c2 = 2;
                c3 = 4;
                if (i >= 5) {
                    break;
                }
                String[] split2 = split[i].split("\\s*,\\s*");
                GeoPoint geoPoint = new GeoPoint(Double.parseDouble(split2[2]), Double.parseDouble(split2[3]), Double.parseDouble(split2[4]));
                String replace = split2[0].replace("Waypoint", str2);
                ao a = e.a(GeoPointMetaData.wrap(geoPoint), replace);
                a.setVisible(false);
                a.setMetaString(FlightLogger.LOG_CALLSIGN, replace);
                a.setMetaBoolean("movable", false);
                a.setMetaBoolean("removable", false);
                eVar.addMarker(a);
                eVar.setVisible(false);
                a.setTitle(replace);
                i++;
            }
            eVar.addStyleBits(4);
            eVar.setEditable(false);
            eVar.setMetaBoolean("editable", false);
            Log.d(TAG, "uavRoute set editable = false");
            int i2 = 5;
            while (i2 <= split.length) {
                if (i2 == split.length) {
                    strArr = split[0].split("\\s*,\\s*");
                } else {
                    strArr = split[i2].split("\\s*,\\s*");
                }
                GeoPoint geoPoint2 = new GeoPoint(Double.parseDouble(strArr[c2]), Double.parseDouble(strArr[c]), Double.parseDouble(strArr[c3]));
                String replace2 = strArr[0].replace("Waypoint", str2);
                g.a aVar = new g.a(geoPoint2);
                aVar.f(false);
                aVar.d(true);
                aVar.a(UASRoute.WAYPOINT_TYPE);
                aVar.e(replace2);
                aVar.b(replace2);
                ao a2 = aVar.a();
                Log.d(TAG, "creating a new unit marker for: " + a2.getUID());
                a2.setTitle(replace2);
                a2.setMetaString("how", "h-g-i-g-o");
                a2.setEditable(false);
                a2.setMovable(false);
                a2.setMetaBoolean("removable", false);
                Log.d(TAG, "Editable = " + a2.getEditable());
                Log.d(TAG, "Movable = " + a2.getMetaBoolean("movable", true));
                i2++;
                c = 3;
                c2 = 2;
                c3 = 4;
            }
            Log.d(TAG, "Showing waypoints");
            eVar.setVisible(true);
            c4.d(eVar);
            this.uasMarker.setMetaBoolean("cRouteVisible", true);
            setRouteShowing(true);
            return;
        }
        Log.d(TAG, "No waypoints associated with this uav");
        throw new RuntimeException("No waypoints for UAS " + getCallsign());
    }

    public boolean hasRouteToShow() {
        String metaString;
        if (this.uasMarker == null || (metaString = this.uasMarker.getMetaString("waypoints", "")) == null || metaString.length() <= 0) {
            return false;
        }
        return true;
    }

    public void hideRoute() {
        String[] strArr;
        ag group;
        try {
            MapView mapView = MapView.getMapView();
            String str = "";
            if (this.uasMarker != null) {
                str = this.uasMarker.getMetaString("waypoints", str);
            }
            String str2 = this.uid;
            Log.d(TAG, "Hiding waypoints");
            ay rootGroup = mapView.getRootGroup();
            e b = rootGroup.b(this.uid + "Route");
            if (b != null) {
                b.setVisible(false);
                b.getGroup().g(b);
                String[] split = str.split("\n");
                for (int i = 5; i <= split.length; i++) {
                    if (i == split.length) {
                        strArr = split[0].split("\\s*,\\s*");
                    } else {
                        strArr = split[i].split("\\s*,\\s*");
                    }
                    ao b2 = mapView.getRootGroup().b(strArr[0].replace("Waypoint", str2));
                    if (!(b2 == null || (group = b2.getGroup()) == null)) {
                        group.g(b2);
                    }
                }
            }
            setRouteShowing(false);
            if (this.uasMarker != null) {
                this.uasMarker.setMetaBoolean("cRouteVisible", false);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception encountered - ", e);
        }
    }

    /* renamed from: a */
    public void mo7557a(ai aiVar, String str) {
        if ((aiVar instanceof ao) && str.equals("waypoints")) {
            try {
                if (this.isRouteShowing) {
                    onWaypointsChanged();
                }
            } catch (Exception e) {
                Log.e(TAG, "Exception encountered", e);
            }
        }
        super.mo7557a(aiVar, str);
    }

    private void onWaypointsChanged() {
        hideRoute();
        showRoute();
    }

    public UASItem.SIGNAL_STRENGTH getSignalStrength() {
        if (getMarker() != null) {
            int metaInteger = getMarker().getMetaInteger("_radio:rssi", 0);
            if (metaInteger > -80) {
                return UASItem.SIGNAL_STRENGTH.GOOD;
            }
            if (metaInteger > -90) {
                return UASItem.SIGNAL_STRENGTH.OK;
            }
        }
        return UASItem.SIGNAL_STRENGTH.BAD;
    }

    public double getBatteryPercent() {
        if (this.uasMarker != null) {
            double metaDouble = this.uasMarker.getMetaDouble("vehicle:batteryMaxCapacity", 0.0d);
            double metaDouble2 = this.uasMarker.getMetaDouble("vehicle:batteryRemainingCapacity", 0.0d);
            if (metaDouble != 0.0d && metaDouble2 != 0.0d) {
                return metaDouble2 / metaDouble;
            }
            double metaDouble3 = this.uasMarker.getMetaDouble("vehicle:voltage", 0.0d);
            double d = 25.0d;
            if (getModelName().equals("Wasp")) {
                d = 16.5d;
            }
            if (metaDouble3 >= d) {
                return 1.0d;
            }
            if (metaDouble3 >= d - 0.5d) {
                return 0.9d;
            }
            if (metaDouble3 >= d - 1.0d) {
                return 0.8d;
            }
            if (metaDouble3 >= d - 1.5d) {
                return 0.7d;
            }
            if (metaDouble3 >= d - 2.0d) {
                return 0.6d;
            }
            if (metaDouble3 >= d - 2.5d) {
                return 0.5d;
            }
            if (metaDouble3 >= d - 3.0d) {
                return 0.4d;
            }
            if (metaDouble3 >= d - 3.5d) {
                return 0.3d;
            }
            if (metaDouble3 >= d - 4.0d) {
                return 0.2d;
            }
            if (metaDouble3 >= d - 5.0d) {
                return 0.1d;
            }
        }
        return 0.0d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0024, code lost:
        if (java.lang.Double.isNaN(com.atakmap.map.elevation.ElevationManager.a(r0.getLatitude(), r0.getLongitude(), r2)) == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateGeoreference() {
        /*
            r7 = this;
            com.atakmap.android.maps.ao r0 = r7.uasMarker
            r1 = 1
            if (r0 == 0) goto L_0x0027
            com.atakmap.android.maps.ao r0 = r7.uasMarker
            com.atakmap.coremap.maps.coords.GeoPoint r0 = r0.C()
            com.atakmap.map.elevation.ElevationManager$b r2 = new com.atakmap.map.elevation.ElevationManager$b
            r2.<init>()
            r2.e = r1
            r2.g = r1
            double r3 = r0.getLatitude()
            double r5 = r0.getLongitude()
            double r2 = com.atakmap.map.elevation.ElevationManager.a(r3, r5, r2)
            boolean r0 = java.lang.Double.isNaN(r2)
            if (r0 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            super.onUasGeoreferenceUpdate(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.AvUASItem.updateGeoreference():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = (com.atakmap.android.uastool.p000av.AvMonitor) com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance().getPlatformMonitor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVideoUrl() {
        /*
            r3 = this;
            com.atakmap.android.uastool.UASToolDropDownReceiver r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
            com.atakmap.android.uastool.plugin.PlatformMonitor r0 = r0.getPlatformMonitor()
            if (r0 == 0) goto L_0x002b
            com.atakmap.android.uastool.UASToolDropDownReceiver r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
            com.atakmap.android.uastool.plugin.PlatformMonitor r0 = r0.getPlatformMonitor()
            boolean r0 = r0 instanceof com.atakmap.android.uastool.p000av.AvMonitor
            if (r0 == 0) goto L_0x002b
            com.atakmap.android.uastool.UASToolDropDownReceiver r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
            com.atakmap.android.uastool.plugin.PlatformMonitor r0 = r0.getPlatformMonitor()
            com.atakmap.android.uastool.av.AvMonitor r0 = (com.atakmap.android.uastool.p000av.AvMonitor) r0
            if (r0 == 0) goto L_0x002b
            java.lang.String r1 = r3.getUid()
            int r0 = r0.getVideoPort(r1)
            goto L_0x002e
        L_0x002b:
            r0 = 49410(0xc102, float:6.9238E-41)
        L_0x002e:
            boolean r1 = r3.isConnected()
            if (r1 == 0) goto L_0x0050
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "udp://"
            r1.append(r2)
            java.lang.String r2 = "192.168.0.255"
            r1.append(r2)
            java.lang.String r2 = ":"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        L_0x0050:
            java.lang.String r0 = super.getVideoUrl()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.AvUASItem.getVideoUrl():java.lang.String");
    }
}
