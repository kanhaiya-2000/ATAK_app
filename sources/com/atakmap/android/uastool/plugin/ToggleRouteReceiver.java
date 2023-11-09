package com.atakmap.android.uastool.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.ay;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.p000av.AvParser;
import com.atakmap.android.uastool.p000av.AvUASItem;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.user.g;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.GeoPointMetaData;

public class ToggleRouteReceiver extends BroadcastReceiver {
    private static final String TAG = "ToggleRouteReceiver";
    private final Context pluginContext;

    public ToggleRouteReceiver(Context context) {
        this.pluginContext = context;
    }

    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "handle waypoints");
        if (intent.getAction().equals("com.atakmap.android.uastool.TOGGLE_ROUTE")) {
            String stringExtra = intent.getStringExtra(UASTask.COTDETAIL_UID);
            Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("edit", false));
            Boolean valueOf2 = Boolean.valueOf(intent.getBooleanExtra("clear", false));
            Log.d(TAG, "UID = " + stringExtra);
            Log.d(TAG, "Editable = " + valueOf);
            Log.d(TAG, "Clear = " + valueOf2);
            ao b = MapView.getMapView().getRootGroup().b(stringExtra);
            String metaString = b.getMetaString("vehicle:typeTag", "");
            if (b == null || metaString.isEmpty()) {
                Log.d(TAG, "Unable to find marker for uid = " + stringExtra);
            } else if (metaString.compareTo(AvUASItem.DETAIL_TAG) == 0) {
                handleAvToggle(b, valueOf, stringExtra, valueOf2);
            } else {
                handleGenericToggle(b, valueOf, stringExtra, valueOf2);
            }
        }
    }

    private void saveProposedRoute(ao aoVar, String str) {
        MapView mapView = MapView.getMapView();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            String name = AvParser.Waypoint.fromInteger(i).name();
            ay rootGroup = mapView.getRootGroup();
            GeoPoint C = rootGroup.b(str + "-" + name).C();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Waypoint-");
            sb2.append(name);
            sb2.append(",");
            sb2.append("NO_DESCRIPTION,");
            sb2.append(C.getLatitude());
            sb2.append(",");
            sb2.append(C.getLongitude());
            sb2.append(",");
            sb2.append(C.getAltitude());
            sb2.append("\n");
            sb.append(sb2);
        }
        aoVar.setMetaString("p_waypoints", sb.toString());
    }

    private void handleAvToggle(ao aoVar, Boolean bool, String str, Boolean bool2) {
        String str2;
        String str3;
        boolean z;
        String str4;
        e eVar;
        String[] strArr;
        ag group;
        CharSequence charSequence;
        e eVar2;
        String[] strArr2;
        ao aoVar2 = aoVar;
        String str5 = str;
        MapView mapView = MapView.getMapView();
        ag c = mapView.getRootGroup().c("Route");
        if (bool.booleanValue()) {
            z = !aoVar2.getMetaBoolean("pRouteVisible", false);
            str2 = aoVar2.getMetaString("p_waypoints", "");
            String str6 = "P_" + str5;
            if (str2.isEmpty()) {
                str2 = aoVar2.getMetaString("waypoints", "");
            }
            if (bool2.booleanValue()) {
                aoVar2.setMetaString("p_waypoints", aoVar2.getMetaString("r_waypoints", ""));
                aoVar2.setMetaString("r_waypoints", "");
                if (z) {
                    return;
                }
            }
            str3 = str6;
        } else {
            z = !aoVar2.getMetaBoolean("cRouteVisible", false);
            str2 = aoVar2.getMetaString("waypoints", "");
            str3 = str5;
        }
        Log.d(TAG, "Show waypoints = " + z);
        if (z) {
            if (bool.booleanValue()) {
                eVar2 = new e(MapView.getMapView(), str5 + " Proposed Route", -65281, str3, str5 + "ProposedRoute");
                charSequence = "Waypoint";
                str4 = "cRouteVisible";
            } else {
                charSequence = "Waypoint";
                MapView mapView2 = MapView.getMapView();
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                str4 = "cRouteVisible";
                sb.append(" Route");
                eVar2 = new e(mapView2, sb.toString(), TaskEdit.viewColor, str3, str5 + "Route");
            }
            if (!str2.isEmpty()) {
                String[] split = str2.split("\n");
                for (int i = 1; i < 5; i++) {
                    String[] split2 = split[i].split("\\s*,\\s*");
                    GeoPoint geoPoint = new GeoPoint(Double.parseDouble(split2[2]), Double.parseDouble(split2[3]), Double.parseDouble(split2[4]), 0.0d, 0.0d);
                    String replace = split2[0].replace(charSequence, str3);
                    ao a = e.a(GeoPointMetaData.wrap(geoPoint), replace);
                    a.setVisible(false);
                    a.setMetaString(FlightLogger.LOG_CALLSIGN, replace);
                    a.setMetaBoolean("movable", bool.booleanValue());
                    a.setMetaBoolean("removable", false);
                    eVar2.addMarker(a);
                    eVar2.setVisible(false);
                    a.setTitle(replace);
                }
                eVar2.addStyleBits(4);
                eVar2.setEditable(bool.booleanValue());
                eVar2.setMetaBoolean("editable", bool.booleanValue());
                Log.d(TAG, "uavRoute set editable = " + bool);
                int i2 = 5;
                while (i2 <= split.length) {
                    if (i2 == split.length) {
                        strArr2 = split[0].split("\\s*,\\s*");
                    } else {
                        strArr2 = split[i2].split("\\s*,\\s*");
                    }
                    GeoPoint geoPoint2 = new GeoPoint(Double.parseDouble(strArr2[2]), Double.parseDouble(strArr2[3]), Double.parseDouble(strArr2[4]), 0.0d, 0.0d);
                    String[] strArr3 = split;
                    String replace2 = strArr2[0].replace(charSequence, str3);
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
                    a2.setEditable(bool.booleanValue());
                    a2.setMovable(bool.booleanValue());
                    a2.setMetaBoolean("removable", false);
                    Log.d(TAG, "Editable = " + a2.getEditable());
                    Log.d(TAG, "Movable = " + a2.getMetaBoolean("movable", true));
                    i2++;
                    Boolean bool3 = bool;
                    split = strArr3;
                }
                Log.d(TAG, "Showing waypoints");
                eVar2.setVisible(true);
                c.d(eVar2);
            } else {
                Log.d(TAG, "No waypoints associated with this uav");
            }
        } else {
            str4 = "cRouteVisible";
            CharSequence charSequence2 = "Waypoint";
            Log.d(TAG, "Hiding waypoints");
            if (bool.booleanValue()) {
                eVar = (e) mapView.getRootGroup().b(str5 + "ProposedRoute");
                if (!bool2.booleanValue()) {
                    saveProposedRoute(aoVar2, str3);
                }
            } else {
                eVar = (e) mapView.getRootGroup().b(str5 + "Route");
            }
            if (eVar != null) {
                eVar.setVisible(false);
                eVar.getGroup().g(eVar);
                String[] split3 = str2.split("\n");
                for (int i3 = 5; i3 <= split3.length; i3++) {
                    if (i3 == split3.length) {
                        strArr = split3[0].split("\\s*,\\s*");
                    } else {
                        strArr = split3[i3].split("\\s*,\\s*");
                    }
                    ao b = mapView.getRootGroup().b(strArr[0].replace(charSequence2, str3));
                    if (!(b == null || (group = b.getGroup()) == null)) {
                        group.g(b);
                    }
                }
            }
        }
        if (bool.booleanValue()) {
            aoVar2.setMetaBoolean("pRouteVisible", z);
        } else {
            aoVar2.setMetaBoolean(str4, z);
        }
    }

    private void handleGenericToggle(ao aoVar, Boolean bool, String str, Boolean bool2) {
        String str2;
        String str3;
        boolean z;
        String str4;
        e eVar;
        String[] strArr;
        ag group;
        String str5;
        e eVar2;
        String[] strArr2;
        ao aoVar2 = aoVar;
        String str6 = str;
        MapView mapView = MapView.getMapView();
        ag c = mapView.getRootGroup().c("Route");
        if (bool.booleanValue()) {
            z = !aoVar2.getMetaBoolean("pRouteVisible", false);
            str2 = aoVar2.getMetaString("p_waypoints", "");
            String str7 = "P_" + str6;
            if (str2.isEmpty()) {
                str2 = aoVar2.getMetaString("waypoints", "");
            }
            if (bool2.booleanValue()) {
                aoVar2.setMetaString("p_waypoints", aoVar2.getMetaString("r_waypoints", ""));
                aoVar2.setMetaString("r_waypoints", "");
                if (z) {
                    return;
                }
            }
            str3 = str7;
        } else {
            z = !aoVar2.getMetaBoolean("cRouteVisible", false);
            str2 = aoVar2.getMetaString("waypoints", "");
            str3 = str6;
        }
        Log.d(TAG, "Show waypoints = " + z);
        if (z) {
            if (bool.booleanValue()) {
                eVar2 = new e(MapView.getMapView(), str6 + " Proposed Route", -65281, str3, str6 + "ProposedRoute");
                str5 = "\n";
                str4 = "cRouteVisible";
            } else {
                str5 = "\n";
                MapView mapView2 = MapView.getMapView();
                StringBuilder sb = new StringBuilder();
                sb.append(str6);
                str4 = "cRouteVisible";
                sb.append(" Route");
                eVar2 = new e(mapView2, sb.toString(), TaskEdit.viewColor, str3, str6 + "Route");
            }
            if (!str2.isEmpty()) {
                String[] split = str2.split(str5);
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].split("\\s*,\\s*");
                    GeoPoint geoPoint = new GeoPoint(Double.parseDouble(split2[2]), Double.parseDouble(split2[3]), Double.parseDouble(split2[4]), 0.0d, 0.0d);
                    String replace = split2[0].replace("Waypoint", str3);
                    ao a = e.a(GeoPointMetaData.wrap(geoPoint), replace);
                    a.setVisible(false);
                    a.setMetaString(FlightLogger.LOG_CALLSIGN, replace);
                    a.setMetaBoolean("movable", bool.booleanValue());
                    a.setMetaBoolean("removable", false);
                    eVar2.addMarker(a);
                    eVar2.setVisible(false);
                    a.setTitle(replace);
                }
                eVar2.addStyleBits(4);
                eVar2.setEditable(bool.booleanValue());
                eVar2.setMetaBoolean("editable", bool.booleanValue());
                Log.d(TAG, "uavRoute set editable = " + bool);
                int i2 = 5;
                while (i2 <= split.length) {
                    if (i2 == split.length) {
                        strArr2 = split[0].split("\\s*,\\s*");
                    } else {
                        strArr2 = split[i2].split("\\s*,\\s*");
                    }
                    GeoPoint geoPoint2 = new GeoPoint(Double.parseDouble(strArr2[2]), Double.parseDouble(strArr2[3]), Double.parseDouble(strArr2[4]), 0.0d, 0.0d);
                    String[] strArr3 = split;
                    String replace2 = strArr2[0].replace("Waypoint", str3);
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
                    a2.setEditable(bool.booleanValue());
                    a2.setMovable(bool.booleanValue());
                    a2.setMetaBoolean("removable", false);
                    Log.d(TAG, "Editable = " + a2.getEditable());
                    Log.d(TAG, "Movable = " + a2.getMetaBoolean("movable", true));
                    i2++;
                    Boolean bool3 = bool;
                    split = strArr3;
                }
                Log.d(TAG, "Showing waypoints");
                eVar2.setVisible(true);
                c.d(eVar2);
            } else {
                Log.d(TAG, "No waypoints associated with this uav");
            }
        } else {
            str4 = "cRouteVisible";
            String str8 = "\n";
            Log.d(TAG, "Hiding waypoints");
            if (bool.booleanValue()) {
                eVar = (e) mapView.getRootGroup().b(str6 + "ProposedRoute");
                if (!bool2.booleanValue()) {
                    saveProposedRoute(aoVar2, str3);
                }
            } else {
                eVar = (e) mapView.getRootGroup().b(str6 + "Route");
            }
            if (eVar != null) {
                eVar.setVisible(false);
                eVar.getGroup().g(eVar);
                String[] split3 = str2.split(str8);
                for (int i3 = 5; i3 <= split3.length; i3++) {
                    if (i3 == split3.length) {
                        strArr = split3[0].split("\\s*,\\s*");
                    } else {
                        strArr = split3[i3].split("\\s*,\\s*");
                    }
                    ao b = mapView.getRootGroup().b(strArr[0].replace("Waypoint", str3));
                    if (!(b == null || (group = b.getGroup()) == null)) {
                        group.g(b);
                    }
                }
            }
        }
        if (bool.booleanValue()) {
            aoVar2.setMetaBoolean("pRouteVisible", z);
        } else {
            aoVar2.setMetaBoolean(str4, z);
        }
    }
}
