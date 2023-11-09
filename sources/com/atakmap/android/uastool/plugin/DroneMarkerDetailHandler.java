package com.atakmap.android.uastool.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import atakplugin.UASTool.adz;
import com.atakmap.android.cot.h;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.PD100.PD100UASItem;
import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.DJIUASItem;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.overlays.OverlayScreen;
import com.atakmap.android.uastool.p000av.AvUASItem;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.ae;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;
import indago.serialization.JsonValueConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DroneMarkerDetailHandler implements h {
    private static final String DEGREES = Character.toString(186);
    private static final String METATAG = "_uastool";
    public static final double METERS_TO_FEET = 3.28084d;
    private static final double MPS_TO_KNOTS = 1.94384d;
    private static final String TAG = "DroneDetailHandler";
    private static final HashMap<String, HashMap<String, String>> detailStructure;
    private static SharedPreferences prefs;
    private final String[] BOOL_ATTRS = {"nofly", "flying", "motor", "navigating"};
    private final String[] NUMBER_ATTRS = {FlightLogger.LOCS_LATITUDE, FlightLogger.LOCS_LONGITUDE, UASPoint.COTDETAIL_CE, UASPoint.COTDETAIL_LE, "hae", "course", UASPoint.COTDETAIL_SPEED, "slope", "Range_To_Target", "temperature", "climbRate", "north", "pitch", adz.f608a, "yaw"};
    private final String[] STRING_ATTRS = {"Flight_Mode", "Target_Waypoint", UASTask.COTDETAIL_NAME, "description"};
    private final Set<MarkerMetadataListener> listeners = new HashSet();
    private boolean wasFlying = false;

    public interface MarkerMetadataListener {
        void onMarkerMetadataUpdate(ao aoVar);
    }

    /* renamed from: a */
    public void mo9867a(ao aoVar, CotDetail cotDetail) {
    }

    public String getMetaName() {
        return "_uastool";
    }

    static {
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();
        detailStructure = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("extendedCot", "boolean");
        hashMap2.put("activeRoute", "boolean");
        hashMap.put("_uastool", hashMap2);
        hashMap.put(AvUASItem.DETAIL_TAG, AvUASItem.getDetailAttrs());
        hashMap.put("_DJI_", DJIUASItem.getDetailAttrs());
        HashMap hashMap3 = new HashMap();
        hashMap3.put("course", "double");
        hashMap3.put(UASPoint.COTDETAIL_SPEED, "double");
        hashMap3.put("slope", "double");
        hashMap.put(UasC2Event.TrackDetail.detailName, hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("azimuth", "double");
        hashMap4.put("elevation", "double");
        hashMap4.put(adz.f608a, "double");
        hashMap4.put("fov", "double");
        hashMap4.put("vfov", "double");
        hashMap4.put("north", "double");
        hashMap4.put("version", "double");
        hashMap4.put("type", "String");
        hashMap4.put("range", "int");
        hashMap.put(UasC2Event.SensorDetail.detailName, hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("pitch", "double");
        hashMap5.put(adz.f608a, "double");
        hashMap5.put("yaw", "double");
        hashMap.put(UasC2Event.SpatialDetail.AttitudeDetail.detailName, hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put("pitch", "double");
        hashMap6.put(adz.f608a, "double");
        hashMap6.put("yaw", "double");
        hashMap.put(UasC2Event.SpatialDetail.SpinDetail.detailName, hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put("batteryMaxCapacity", "double");
        hashMap7.put("batteryRemainingCapacity", "double");
        hashMap7.put("flightTime", "int");
        hashMap7.put("type", "String");
        hashMap7.put("voltage", "double");
        hashMap7.put("typeTag", "String");
        hashMap7.put("flightTimeRemaining", "int");
        hashMap7.put("isFlying", "boolean");
        hashMap7.put("goHomeBatteryPercent", "int");
        hashMap7.put("hal", "double");
        hashMap.put(UasC2Event.VehicleDetail.detailName, hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put("windSpeed", "double");
        hashMap8.put("windDirection", "double");
        hashMap8.put("temperature", "double");
        hashMap.put(UasC2Event.EnvironmentDetail.detailName, hashMap8);
        HashMap hashMap9 = new HashMap();
        hashMap9.put("rssi", "int");
        hashMap9.put("gps", "boolean");
        hashMap.put(UasC2Event.RadioDetail.detailName, hashMap9);
        HashMap hashMap10 = new HashMap();
        hashMap10.put("climbRate", "double");
        hashMap.put(UasC2Event.CommandedDataDetail.detailName, hashMap10);
    }

    public DroneMarkerDetailHandler(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
    }

    public static String format(ao aoVar, String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1750418312:
                if (str.equals("environment:windSpeed")) {
                    c = 0;
                    break;
                }
                break;
            case -953458390:
                if (str.equals("track:course")) {
                    c = 1;
                    break;
                }
                break;
            case -842274163:
                if (str.equals("environment:temperature")) {
                    c = 2;
                    break;
                }
                break;
            case 30639532:
                if (str.equals("event:hae")) {
                    c = 3;
                    break;
                }
                break;
            case 210504005:
                if (str.equals("vehicle:hal")) {
                    c = 4;
                    break;
                }
                break;
            case 538222936:
                if (str.equals("track:speed")) {
                    c = 5;
                    break;
                }
                break;
            case 745372607:
                if (str.equals("vehicle:battery")) {
                    c = 6;
                    break;
                }
                break;
            case 993411888:
                if (str.equals("environment:windDirection")) {
                    c = 7;
                    break;
                }
                break;
            case 1708992784:
                if (str.equals("vehicle:voltage")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return String.format("%01.2f", new Object[]{Double.valueOf(aoVar.getMetaDouble("environment:windSpeed", 0.0d) * MPS_TO_KNOTS)}) + "kts";
            case 1:
                return Utils.formatHeading(aoVar.C(), aoVar.getMetaDouble("track:course", 0.0d));
            case 2:
                return String.format("%01.2f", new Object[]{Double.valueOf(aoVar.getMetaDouble("environment:temperature", 0.0d))}) + DEGREES + "C";
            case 3:
                return UASToolDropDownReceiver.formatAltitude(aoVar.C());
            case 4:
                return Utils.formatAlt(aoVar.getMetaDouble("vehicle:hal", 0.0d));
            case 5:
                return ae.a().a(aoVar.getMetaDouble("track:speed", 0.0d));
            case 6:
                String string = prefs.getString(UIPreferenceFragment.PREF_BATTERY_LEVEL_UNITS, UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getStringArray(C1877R.array.battery_level_units)[0]);
                if (string != null && !string.equals("Voltage")) {
                    return getBatteryPercent(aoVar);
                }
            case 7:
                return String.format("%01.0f", new Object[]{Double.valueOf(aoVar.getMetaDouble("environment:windDirection", 0.0d))}) + DEGREES;
            case 8:
                break;
            default:
                Log.e(TAG, "Unable to format " + str);
                return "";
        }
        return getBatteryVoltage(aoVar);
    }

    private static String getBatteryVoltage(ao aoVar) {
        if (aoVar.getMetaString("vehicle:type", SoloControllerUnits.UNKNOWN).startsWith(PD100UASItem.DISPLAY_NAME)) {
            return String.format("%02.1f%%", new Object[]{Double.valueOf(aoVar.getMetaDouble("vehicle:batteryRemainingCapacity", 0.0d))});
        }
        return String.format("%01.2fV", new Object[]{Double.valueOf(aoVar.getMetaDouble("vehicle:voltage", 0.0d))});
    }

    private static String getBatteryPercent(ao aoVar) {
        if (aoVar.getMetaString("vehicle:type", SoloControllerUnits.UNKNOWN).startsWith(PD100UASItem.DISPLAY_NAME)) {
            return String.format("%02.1f%%", new Object[]{Double.valueOf(aoVar.getMetaDouble("vehicle:batteryRemainingCapacity", 0.0d))});
        }
        return String.format("%02.1f%%", new Object[]{Double.valueOf((aoVar.getMetaDouble("vehicle:batteryRemainingCapacity", 0.0d) / aoVar.getMetaDouble("vehicle:batteryMaxCapacity", 0.0d)) * 100.0d)});
    }

    /* renamed from: a */
    public void mo9868a(ao aoVar, CotEvent cotEvent, CotDetail cotDetail) {
        GeoPoint geoPoint;
        String type = cotEvent.getType();
        if (type != null && !type.isEmpty()) {
            if ((type.equals(UASToolConstants.UAS_FIXED_TYPE) || type.equals(UASToolConstants.UAS_ROTARY_TYPE) || cotEvent.getDetail().getFirstChildByName(0, "_uastool") != null) && cotEvent.getDetail().getFirstChildByName(0, "_uastool") != null) {
                for (CotDetail cotDetail2 : cotEvent.getDetail().getChildren()) {
                    String elementName = cotDetail2.getElementName();
                    elementName.hashCode();
                    if (elementName.equals(UasC2Event.SpatialDetail.detailName)) {
                        for (int i = 0; i < cotDetail2.childCount(); i++) {
                            injectMetadata(aoVar, cotDetail2.getChild(i));
                        }
                    } else if (!elementName.equals(UasC2Event.WaypointCollectionDetail.detailName)) {
                        injectMetadata(aoVar, cotDetail2);
                    } else {
                        try {
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < cotDetail2.childCount(); i2++) {
                                CotDetail child = cotDetail2.getChild(i2);
                                CotDetail child2 = child.getChild(0);
                                CotDetail firstChildByName = child.getFirstChildByName(1, "orbit");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(child.getAttribute(UASTask.COTDETAIL_NAME));
                                sb2.append(",");
                                sb2.append(child.getAttribute("description"));
                                sb2.append(",");
                                sb2.append(child2.getAttribute(FlightLogger.LOCS_LATITUDE));
                                sb2.append(",");
                                sb2.append(child2.getAttribute(FlightLogger.LOCS_LONGITUDE));
                                sb2.append(",");
                                sb2.append(child2.getAttribute("hae"));
                                if (firstChildByName != null) {
                                    sb2.append(",");
                                    sb2.append(firstChildByName.getAttribute(OrbitPoint.COTDETAIL_ORBITRADIUS));
                                    sb2.append("\n");
                                } else {
                                    sb2.append(",");
                                    sb2.append(JsonValueConstants.VERSION);
                                    sb2.append("\n");
                                }
                                sb.append(sb2);
                            }
                            synchronized (this) {
                                String sb3 = sb.toString();
                                if (!sb3.equals(aoVar.getMetaString("waypoints", ""))) {
                                    aoVar.setMetaString("waypoints", sb3);
                                    aoVar.notifyMetadataChanged("waypoints");
                                }
                            }
                        } catch (Exception e) {
                            Log.e(TAG, "Exception encountered - " + e.getMessage(), e);
                        }
                    }
                }
                UASItem findUASItem = StatusArrayList.getInstance().findUASItem(aoVar.getUID());
                if (findUASItem != null) {
                    if (findUASItem.isFlying() != this.wasFlying) {
                        UASToolDropDownReceiver.getInstance().onFlyingStatusChanged(findUASItem);
                    }
                    this.wasFlying = findUASItem.isFlying();
                }
                if (FileSystemUtils.isEmpty(aoVar.getMetaString(FlightLogger.LOG_CALLSIGN, (String) null))) {
                    aoVar.setMetaString(FlightLogger.LOG_CALLSIGN, aoVar.getTitle());
                }
                StringBuilder sb4 = new StringBuilder();
                CotPoint cotPoint = cotEvent.getCotPoint();
                if (!(cotPoint == null || (geoPoint = cotPoint.toGeoPoint()) == null || (!Double.isNaN(geoPoint.getCE()) && geoPoint.getCE() < 9999.0d))) {
                    sb4.append("NO GPS\n");
                }
                for (Map.Entry next : prefs.getAll().entrySet()) {
                    if (((String) next.getKey()).contains(".overlay.") && prefs.getBoolean((String) next.getKey(), false)) {
                        String replaceFirst = ((String) next.getKey()).replaceFirst(OverlayScreen.PREF_OVERLAY, "");
                        if (uasTypeHasOverlayItem(replaceFirst, aoVar)) {
                            replaceFirst.hashCode();
                            char c = 65535;
                            switch (replaceFirst.hashCode()) {
                                case -2023598992:
                                    if (replaceFirst.equals("attitude:pitch")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case -2004874931:
                                    if (replaceFirst.equals("attitude:roll")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case -1750418312:
                                    if (replaceFirst.equals("environment:windSpeed")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case -953458390:
                                    if (replaceFirst.equals("track:course")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case -842274163:
                                    if (replaceFirst.equals("environment:temperature")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case -757403745:
                                    if (replaceFirst.equals("attitude:yaw")) {
                                        c = 5;
                                        break;
                                    }
                                    break;
                                case 30639532:
                                    if (replaceFirst.equals("event:hae")) {
                                        c = 6;
                                        break;
                                    }
                                    break;
                                case 210504005:
                                    if (replaceFirst.equals("vehicle:hal")) {
                                        c = 7;
                                        break;
                                    }
                                    break;
                                case 538222936:
                                    if (replaceFirst.equals("track:speed")) {
                                        c = 8;
                                        break;
                                    }
                                    break;
                                case 745372607:
                                    if (replaceFirst.equals("vehicle:battery")) {
                                        c = 9;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    sb4.append("Pitch: ");
                                    sb4.append(String.format("%.0f", new Object[]{Double.valueOf(aoVar.getMetaDouble("attitude:pitch", 0.0d))}));
                                    sb4.append("\n");
                                    break;
                                case 1:
                                    sb4.append("Roll: ");
                                    sb4.append(String.format("%.0f", new Object[]{Double.valueOf(aoVar.getMetaDouble("attitude:roll", 0.0d))}));
                                    sb4.append("\n");
                                    break;
                                case 2:
                                    sb4.append("WS: ");
                                    sb4.append(format(aoVar, "environment:windDirection"));
                                    sb4.append("/");
                                    sb4.append(format(aoVar, "environment:windSpeed"));
                                    sb4.append("\n");
                                    break;
                                case 3:
                                    sb4.append(format(aoVar, "track:course"));
                                    sb4.append("\n");
                                    break;
                                case 4:
                                    sb4.append("T: ");
                                    sb4.append(format(aoVar, "environment:temperature"));
                                    sb4.append("\n");
                                    break;
                                case 5:
                                    sb4.append("Yaw: ");
                                    sb4.append(String.format("%.0f", new Object[]{Double.valueOf(aoVar.getMetaDouble("attitude:yaw", 0.0d))}));
                                    sb4.append("\n");
                                    break;
                                case 6:
                                    sb4.append(format(aoVar, "event:hae"));
                                    sb4.append("\n");
                                    break;
                                case 7:
                                    sb4.append(Utils.formatAlt(aoVar.getMetaDouble("vehicle:hal", 0.0d)));
                                    sb4.append(" HAL");
                                    sb4.append("\n");
                                    break;
                                case 8:
                                    sb4.append(ae.a().a(aoVar.getMetaDouble("track:speed", 0.0d)));
                                    sb4.append("\n");
                                    break;
                                case 9:
                                    sb4.append(format(aoVar, "vehicle:battery"));
                                    sb4.append("\n");
                                    break;
                            }
                        }
                    }
                }
                aoVar.a(sb4.toString().trim());
                updateMarkerLocationForOperator(aoVar);
                for (MarkerMetadataListener onMarkerMetadataUpdate : this.listeners) {
                    onMarkerMetadataUpdate.onMarkerMetadataUpdate(aoVar);
                }
            }
        }
    }

    private void updateMarkerLocationForOperator(ao aoVar) {
        GeoPoint geoPoint;
        UASItem findUASItem = UASToolDropDownReceiver.getInstance().findUASItem(aoVar.getUID());
        if (findUASItem != null && findUASItem.isDefault() && findUASItem.isConnected() && (geoPoint = findUASItem.getGeoPoint()) != null) {
            aoVar.a(geoPoint);
        }
    }

    private boolean uasTypeHasOverlayItem(String str, ao aoVar) {
        UASItem buildItem = UASItem.buildItem(aoVar, false);
        if (buildItem == null) {
            return false;
        }
        return buildItem.hasOverlayMetaValue(str);
    }

    private void injectMetadata(ao aoVar, CotDetail cotDetail) {
        String elementName = cotDetail.getElementName();
        HashMap hashMap = detailStructure.get(elementName);
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                String attribute = cotDetail.getAttribute(str);
                String str3 = elementName + ":" + str;
                if (attribute != null && !attribute.isEmpty()) {
                    str2.hashCode();
                    char c = 65535;
                    switch (str2.hashCode()) {
                        case -1808118735:
                            if (str2.equals("String")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1325958191:
                            if (str2.equals("double")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 104431:
                            if (str2.equals("int")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 64711720:
                            if (str2.equals("boolean")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            aoVar.setMetaString(str3, cotDetail.getAttribute(str));
                            break;
                        case 1:
                            aoVar.setMetaDouble(str3, Double.parseDouble(cotDetail.getAttribute(str)));
                            break;
                        case 2:
                            aoVar.setMetaInteger(str3, Integer.parseInt(cotDetail.getAttribute(str)));
                            break;
                        case 3:
                            try {
                                aoVar.setMetaBoolean(str3, Boolean.parseBoolean(cotDetail.getAttribute(str)));
                                break;
                            } catch (Exception unused) {
                                break;
                            }
                    }
                }
            }
        }
    }

    public void addMarkerMetadataListener(MarkerMetadataListener markerMetadataListener) {
        this.listeners.add(markerMetadataListener);
    }

    public void removeMarkerMetadataListener(MarkerMetadataListener markerMetadataListener) {
        this.listeners.remove(markerMetadataListener);
    }
}
