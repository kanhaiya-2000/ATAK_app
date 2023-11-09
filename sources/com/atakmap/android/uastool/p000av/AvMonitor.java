package com.atakmap.android.uastool.p000av;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.p000av.AvParser;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: com.atakmap.android.uastool.av.AvMonitor */
public class AvMonitor extends PlatformMonitor {
    private static final double OFFSET = 9.000009000009E-4d;
    private static final double OFFSET_2 = 0.0018000018000018d;
    private static final String TAG = "AvMonitor";
    public static final int TELEMETRY_PORT_DEFAULT = 49411;
    public static final int VIDEO_PORT_DEFAULT = 49410;
    private static final LinkedHashMap<String, String> wpMap = new LinkedHashMap<String, String>() {
        {
            put("HOME", "home");
            put("A", "route point 1");
            put("B", "route point 2");
            put("C", "route point 3");
            put("D", "route point 4");
            put("E", "entry to landing");
            put("LAND", "landing");
            put("O1", "orbit point 1");
            put("O2", "orbit point 2");
            put("O3", "orbit point 3");
        }
    };
    private Thread UplinkCommThread;
    private AvParser avParser;
    private UplinkComm avUplinkComm;
    private DDLHandler ddlHandler;
    private Thread ddlHandlerThread;
    private CotEvent receivedRoute;
    private AvReflector reflector;
    private final ArrayList<String> requestQueue = new ArrayList<>();
    private ao uav;

    public AvMonitor(Context context, String str) {
        super(context, str);
    }

    public synchronized void beginMonitoring(boolean z) {
        super.beginMonitoring(z);
        this.ddlHandler = new DDLHandler(z);
        Thread thread = new Thread(this.ddlHandler);
        this.ddlHandlerThread = thread;
        thread.start();
    }

    public synchronized void endMonitoring() {
        super.endMonitoring();
        AvParser avParser2 = this.avParser;
        if (avParser2 != null) {
            avParser2.cancel();
            this.avParser = null;
        }
        UplinkComm uplinkComm = this.avUplinkComm;
        if (uplinkComm != null) {
            uplinkComm.cancel();
            this.avUplinkComm = null;
        }
        DDLHandler dDLHandler = this.ddlHandler;
        if (dDLHandler != null) {
            dDLHandler.cancel();
            this.ddlHandler = null;
        }
    }

    public boolean monitors(String str) {
        return str.startsWith(AvUASItem.DISPLAY_NAME_SHORT);
    }

    public void setCaptureToStorage(boolean z) {
        DDLHandler dDLHandler = this.ddlHandler;
        if (dDLHandler != null) {
            dDLHandler.setCaptureToStorage(z);
        }
        AvReflector avReflector = this.reflector;
        if (avReflector != null) {
            avReflector.setCaptureToStorage(z);
        }
        AvParser avParser2 = this.avParser;
        if (avParser2 != null) {
            avParser2.setCaptureToStorage(z);
        }
    }

    public List<UASItem> getDetectedUasList() {
        List<DDLNodeDirectoryItem> nodes;
        ArrayList arrayList = new ArrayList();
        DDLHandler dDLHandler = this.ddlHandler;
        if (!(dDLHandler == null || (nodes = dDLHandler.getNodes()) == null)) {
            String callsignOverride = getCallsignOverride();
            for (DDLNodeDirectoryItem next : nodes) {
                if (next.getType() == 1 && next.getSuid() >= 16) {
                    String name = next.getName();
                    if (callsignOverride != null) {
                        name = callsignOverride;
                    }
                    AvUASItem avUASItem = new AvUASItem(next.getName(), name, true);
                    avUASItem.setModelName(getPlatform(next.getName()));
                    if (!arrayList.contains(avUASItem)) {
                        arrayList.add(avUASItem);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            endParser();
        }
        return arrayList;
    }

    private String getCallsignOverride() {
        String callsign = UASToolDropDownReceiver.getInstance().getCallsign();
        if (callsign == null || callsign.isEmpty()) {
            return null;
        }
        return callsign;
    }

    public DDLHandler getDdlHandler() {
        return this.ddlHandler;
    }

    public int getVideoPort(String str) {
        List<DDLNodeDirectoryItem> nodes = this.ddlHandler.getNodes();
        int i = VIDEO_PORT_DEFAULT;
        if (nodes != null) {
            for (DDLNodeDirectoryItem next : nodes) {
                if (next.getName().compareTo(str) == 0 && next.getSuid() >= 16) {
                    i = (next.getSuid() * 16) + 49152 + 2;
                }
            }
        }
        return i;
    }

    public int getTelemetryPort(String str) {
        List<DDLNodeDirectoryItem> nodes = this.ddlHandler.getNodes();
        int i = TELEMETRY_PORT_DEFAULT;
        if (nodes != null) {
            for (DDLNodeDirectoryItem next : nodes) {
                if (next.getName().compareTo(str) == 0 && next.getSuid() >= 16) {
                    i = (next.getSuid() * 16) + 49152 + 3;
                }
            }
        }
        return i;
    }

    public void setReflector(AvReflector avReflector) {
        this.reflector = avReflector;
        AvParser avParser2 = this.avParser;
        if (avParser2 != null) {
            avParser2.setReflector(avReflector);
        }
    }

    public synchronized void beginParser() {
        if (this.avParser == null) {
            AvParser avParser2 = new AvParser(false, this.reflector);
            this.avParser = avParser2;
            avParser2.start();
        }
        if (this.avUplinkComm == null) {
            this.avUplinkComm = new UplinkComm();
            Thread thread = new Thread(this.avUplinkComm);
            this.UplinkCommThread = thread;
            thread.start();
        }
    }

    public synchronized void endParser() {
        AvParser avParser2 = this.avParser;
        if (avParser2 != null) {
            avParser2.cancel();
            this.avParser = null;
        }
        UplinkComm uplinkComm = this.avUplinkComm;
        if (uplinkComm != null) {
            uplinkComm.cancel();
            this.avUplinkComm = null;
        }
    }

    public AvParser getAvParser() {
        return this.avParser;
    }

    public UplinkComm getAvUplinkComm() {
        return this.avUplinkComm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onIncomingCot(com.atakmap.coremap.cot.event.CotEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getType()
            java.lang.String r1 = "t-c"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0087
            java.lang.String r0 = "AvMonitor"
            java.lang.String r1 = "Route update received"
            com.atakmap.coremap.log.Log.d(r0, r1)
            r5.receivedRoute = r6
            com.atakmap.android.uastool.av.AvParser r0 = r5.getAvParser()
            if (r0 == 0) goto L_0x0087
            java.util.ArrayList<java.lang.String> r1 = r5.requestQueue
            monitor-enter(r1)
            java.lang.String r6 = r6.getUID()     // Catch:{ all -> 0x0084 }
            java.util.ArrayList<java.lang.String> r2 = r5.requestQueue     // Catch:{ all -> 0x0084 }
            boolean r2 = r2.contains(r6)     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x0042
            java.lang.String r0 = "AvMonitor"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r2.<init>()     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = "Duplicate request: "
            r2.append(r3)     // Catch:{ all -> 0x0084 }
            r2.append(r6)     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0084 }
            com.atakmap.coremap.log.Log.d(r0, r6)     // Catch:{ all -> 0x0084 }
            monitor-exit(r1)     // Catch:{ all -> 0x0084 }
            return
        L_0x0042:
            java.util.ArrayList<java.lang.String> r2 = r5.requestQueue     // Catch:{ all -> 0x0084 }
            r2.add(r6)     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = r0.getTailNumber()     // Catch:{ all -> 0x0084 }
            if (r6 == 0) goto L_0x0082
            int r2 = r6.length()     // Catch:{ all -> 0x0084 }
            r3 = 6
            if (r2 <= r3) goto L_0x0082
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x005b
            goto L_0x0082
        L_0x005b:
            r2 = 0
            int r4 = r6.length()     // Catch:{ all -> 0x0084 }
            int r4 = r4 - r3
            java.lang.String r6 = r6.substring(r2, r4)     // Catch:{ all -> 0x0084 }
            boolean r6 = r6.contains(r0)     // Catch:{ all -> 0x0084 }
            if (r6 != 0) goto L_0x0074
            java.lang.String r6 = "AvMonitor"
            java.lang.String r0 = "Discarding a message that doesn't pertain to us"
            com.atakmap.coremap.log.Log.d(r6, r0)     // Catch:{ all -> 0x0084 }
            monitor-exit(r1)     // Catch:{ all -> 0x0084 }
            return
        L_0x0074:
            android.content.Context r6 = r5.pluginContext     // Catch:{ all -> 0x0084 }
            android.app.Activity r6 = (android.app.Activity) r6     // Catch:{ all -> 0x0084 }
            com.atakmap.android.uastool.av.-$$Lambda$AvMonitor$O17xcqy2VvOVBjDTpME17Hbb534 r0 = new com.atakmap.android.uastool.av.-$$Lambda$AvMonitor$O17xcqy2VvOVBjDTpME17Hbb534     // Catch:{ all -> 0x0084 }
            r0.<init>()     // Catch:{ all -> 0x0084 }
            r6.runOnUiThread(r0)     // Catch:{ all -> 0x0084 }
            monitor-exit(r1)     // Catch:{ all -> 0x0084 }
            goto L_0x0087
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x0084 }
            return
        L_0x0084:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0084 }
            throw r6
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.AvMonitor.onIncomingCot(com.atakmap.coremap.cot.event.CotEvent):void");
    }

    public /* synthetic */ void lambda$onIncomingCot$1$AvMonitor() {
        new AlertDialog.Builder(this.pluginContext).setTitle("Route Update Request Received").setMessage("Load proposed route?").setIcon(17301543).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AvMonitor.this.lambda$null$0$AvMonitor(dialogInterface, i);
            }
        }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
    }

    public /* synthetic */ void lambda$null$0$AvMonitor(DialogInterface dialogInterface, int i) {
        loadProposedRoute();
    }

    private void loadProposedRoute() {
        CotDetail detail = this.receivedRoute.getDetail();
        StringBuilder sb = new StringBuilder();
        ao aoVar = null;
        int i = 0;
        while (i < detail.childCount()) {
            CotDetail child = detail.getChild(i);
            if (child.getElementName().equals("request")) {
                String attribute = child.getAttribute("to");
                String substring = attribute.substring(attribute.indexOf(".") + 1);
                boolean z = false;
                for (String d : UASItem.UAS_TYPES) {
                    Iterator it = UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().d("type", d).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ai aiVar = (ai) it.next();
                        if (aiVar.getMetaString(FlightLogger.LOG_CALLSIGN, "").contains(substring)) {
                            aoVar = (ao) aiVar;
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        break;
                    }
                }
            }
            ao aoVar2 = aoVar;
            if (child.getElementName().equals("_waypoint")) {
                String attribute2 = child.getAttribute(UASTask.COTDETAIL_NAME);
                if (attribute2.equals("L")) {
                    attribute2 = "LAND";
                } else if (attribute2.equals("H")) {
                    attribute2 = "HOME";
                }
                if (child.childCount() == 1) {
                    CotDetail child2 = child.getChild(0);
                    try {
                        double parseDouble = Double.parseDouble(child2.getAttribute(FlightLogger.LOCS_LATITUDE));
                        double parseDouble2 = Double.parseDouble(child2.getAttribute(FlightLogger.LOCS_LONGITUDE));
                        double parseDouble3 = Double.parseDouble(child2.getAttribute("hae"));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Waypoint-");
                        sb2.append(attribute2);
                        sb2.append(",");
                        sb2.append("NO_DESCRIPTION,");
                        sb2.append(parseDouble);
                        sb2.append(",");
                        sb2.append(parseDouble2);
                        sb2.append(",");
                        sb2.append(parseDouble3);
                        sb2.append("\n");
                        sb.append(sb2);
                    } catch (Exception e) {
                        Log.e(TAG, "Exception encountered while parsing point");
                        Log.e(TAG, e.getMessage());
                        Log.e(TAG, "Point = " + child2.toString());
                    }
                } else {
                    Log.e(TAG, "Unexpected contents for waypoint " + attribute2);
                }
            }
            i++;
            aoVar = aoVar2;
        }
        if (aoVar != null) {
            String metaString = aoVar.getMetaString(FlightLogger.LOG_CALLSIGN, "");
            if (!metaString.isEmpty()) {
                if (aoVar.getMetaBoolean("pRouteVisible", false)) {
                    Intent intent = new Intent("com.atakmap.android.uastool.TOGGLE_ROUTE");
                    intent.putExtra(UASTask.COTDETAIL_UID, metaString);
                    intent.putExtra("edit", true);
                    intent.putExtra("clear", true);
                    aoVar.setMetaString("r_waypoints", sb.toString());
                    AtakBroadcast.a().a(intent);
                } else {
                    aoVar.setMetaString("p_waypoints", sb.toString());
                }
                Intent intent2 = new Intent("com.atakmap.android.uastool.TOGGLE_ROUTE");
                intent2.putExtra(UASTask.COTDETAIL_UID, metaString);
                intent2.putExtra("edit", true);
                AtakBroadcast.a().a(intent2);
                Log.d(TAG, "Sending show route intent");
                return;
            }
            return;
        }
        Log.e(TAG, "No associated uav marker could be found to attached proposed route data to");
    }

    public void onSendRouteReceived(String str) {
        AvParser avParser2 = getAvParser();
        this.avParser = avParser2;
        String tailNumber = avParser2 != null ? avParser2.getTailNumber() : null;
        if (tailNumber == null || !str.contains(tailNumber)) {
            new AlertDialog.Builder(this.pluginContext).setTitle("Send Route Remote").setMessage("Send new route request?").setIcon(17301543).setPositiveButton("Yes", new DialogInterface.OnClickListener(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AvMonitor.this.lambda$onSendRouteReceived$3$AvMonitor(this.f$1, dialogInterface, i);
                }
            }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
        } else {
            new AlertDialog.Builder(this.pluginContext).setTitle("Send Route Local").setMessage("Send new route to GCS?").setIcon(17301543).setPositiveButton("Yes", new DialogInterface.OnClickListener(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AvMonitor.this.lambda$onSendRouteReceived$2$AvMonitor(this.f$1, dialogInterface, i);
                }
            }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
        }
    }

    public /* synthetic */ void lambda$onSendRouteReceived$2$AvMonitor(String str, DialogInterface dialogInterface, int i) {
        sendRouteLocal(str);
    }

    public /* synthetic */ void lambda$onSendRouteReceived$3$AvMonitor(String str, DialogInterface dialogInterface, int i) {
        sendRouteRemote(str);
    }

    private void sendRouteLocal(String str) {
        UplinkComm avUplinkComm2;
        if (this.avParser != null) {
            ao b = UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().b(str);
            this.uav = b;
            if (b != null) {
                MissionSetFrames missionSetFrames = new MissionSetFrames();
                int i = 0;
                for (Map.Entry<String, String> key : wpMap.entrySet()) {
                    String str2 = (String) key.getKey();
                    ao b2 = UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().b("P_" + str + "-" + str2);
                    MissionWaypoint missionWaypoint = new MissionWaypoint();
                    if (b2 != null) {
                        GeoPoint C = b2.C();
                        Log.d(TAG, str2 + ": " + C.getLatitude() + ", " + C.getLongitude());
                        Log.d(TAG, str2 + ": " + C.getAltitude() + "(" + C.getCE() + ", " + C.getLE() + ")");
                        missionWaypoint.setWaypointType(i);
                        missionWaypoint.setLatitude(C.getLatitude());
                        missionWaypoint.setLongitude(C.getLongitude());
                        missionWaypoint.setAltitude(C.getAltitude());
                        missionSetFrames.addMissionWaypoint(new MissionWaypointFrame(missionWaypoint));
                        i++;
                    }
                }
                MissionParameter missionParameter = this.avParser.getMissionParameter();
                if (missionParameter != null) {
                    missionSetFrames.addMissionParameter(new MissionParameterFrame(missionParameter));
                }
                if (missionParameter != null && missionSetFrames.getSet().size() == 11 && (avUplinkComm2 = getAvUplinkComm()) != null) {
                    Log.d(TAG, "Sending updated route");
                    avUplinkComm2.AddToSend((GCSUplinkMessageSet) missionSetFrames);
                }
            }
        }
    }

    private void sendRouteRemote(String str) {
        String uAVName = getUAVName(str);
        CotPoint cotPoint = new CotPoint(this.uav.C());
        CotEvent cotEvent = new CotEvent();
        cotEvent.setPoint(cotPoint);
        cotEvent.setType("t-c");
        cotEvent.setUID("Req-" + str + getUniqueRequestNumber());
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CoordinatedTime addSeconds = coordinatedTime.addSeconds(30);
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(addSeconds);
        cotEvent.setHow("h-e");
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail("_flow-tags_");
        cotDetail2.setAttribute("uastasker", formatTime(new Date()));
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail("request");
        cotDetail3.setAttribute("notify", "192.168.0.1:18510:udp");
        cotDetail3.setAttribute("to", uAVName);
        cotDetail.addChild(cotDetail3);
        for (Map.Entry next : wpMap.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            ao b = UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().b("P_" + str + "-" + str2);
            if (b != null) {
                GeoPoint C = b.C();
                Log.d(TAG, str2 + ": " + C.getLatitude() + ", " + C.getLongitude());
                Log.d(TAG, str2 + ": " + C.getAltitude() + "(" + C.getCE() + ", " + C.getLE());
                CotDetail cotDetail4 = new CotDetail("_waypoint");
                cotDetail4.setAttribute("type", UASRoute.WAYPOINT_TYPE);
                if (str2.length() == 4) {
                    str2 = str2.substring(0, 1);
                }
                cotDetail4.setAttribute(UASTask.COTDETAIL_NAME, str2);
                cotDetail4.setAttribute("description", str3);
                cotDetail4.setAttribute(UASTask.COTDETAIL_UID, uAVName + ".wp." + str2);
                CotPoint cotPoint2 = new CotPoint(C);
                CotDetail cotDetail5 = new CotDetail();
                cotDetail5.setElementName("point");
                cotDetail5.setAttribute(FlightLogger.LOCS_LATITUDE, String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(cotPoint2.getLat())}));
                cotDetail5.setAttribute(FlightLogger.LOCS_LONGITUDE, String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(cotPoint2.getLon())}));
                cotDetail5.setAttribute("hae", String.format(LocaleUtil.US, "%1.1f", new Object[]{Double.valueOf(cotPoint2.getHae())}));
                cotDetail5.setAttribute(UASPoint.COTDETAIL_CE, String.format(LocaleUtil.US, "%1.1f", new Object[]{Double.valueOf(cotPoint2.getCe())}));
                cotDetail5.setAttribute(UASPoint.COTDETAIL_LE, String.format(LocaleUtil.US, "%1.1f", new Object[]{Double.valueOf(cotPoint2.getLe())}));
                cotDetail4.addChild(cotDetail5);
                cotDetail.addChild(cotDetail4);
            }
        }
        cotEvent.setDetail(cotDetail);
        Log.d(TAG, "Sending route update request...");
        CotMapComponent.h().b(cotEvent);
        Log.d(TAG, cotEvent.toString());
    }

    private String getUAVName(String str) {
        String str2;
        String substring = str.substring(0, 2);
        String substring2 = str.substring(2);
        if (substring.startsWith("R")) {
            str2 = "Raven";
        } else if (substring.startsWith("P")) {
            str2 = "Puma";
        } else {
            str2 = substring.startsWith("W") ? "Wasp" : "Unknown";
        }
        return str2 + "." + substring2;
    }

    private String getPlatform(String str) {
        if (str.startsWith("R")) {
            return "Raven";
        }
        if (str.startsWith("P")) {
            return "Puma";
        }
        return str.startsWith("W") ? "Wasp" : "Unknown";
    }

    private static String formatTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date);
    }

    private String getUniqueRequestNumber() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static int getWaypointIndex(String str) {
        int i = 0;
        for (Map.Entry<String, String> key : wpMap.entrySet()) {
            if (((String) key.getKey()).equals(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void onWaypointSetReceived() {
        UplinkComm avUplinkComm2;
        MissionWaypoint missionWaypoint;
        AvParser avParser2 = getAvParser();
        if (avParser2 != null) {
            MissionSetFrames missionSetFrames = new MissionSetFrames();
            for (AvParser.Waypoint waypoint : AvParser.Waypoint.values()) {
                if (waypoint == AvParser.Waypoint.O1) {
                    missionWaypoint = avParser2.getMissionWaypoint(AvParser.Waypoint.O2.ordinal());
                } else if (waypoint == AvParser.Waypoint.O2) {
                    missionWaypoint = avParser2.getMissionWaypoint(AvParser.Waypoint.O1.ordinal());
                } else {
                    missionWaypoint = avParser2.getMissionWaypoint(waypoint.ordinal());
                }
                if (missionWaypoint != null) {
                    missionSetFrames.addMissionWaypoint(new MissionWaypointFrame(missionWaypoint));
                }
            }
            MissionParameter missionParameter = avParser2.getMissionParameter();
            if (missionParameter != null) {
                missionSetFrames.addMissionParameter(new MissionParameterFrame(missionParameter));
            }
            if (missionParameter != null && missionSetFrames.getSet().size() == 11 && (avUplinkComm2 = getAvUplinkComm()) != null) {
                avUplinkComm2.AddToSend((GCSUplinkMessageSet) missionSetFrames);
            }
        }
    }

    public void test(GeoPoint geoPoint) {
        UplinkComm avUplinkComm2;
        boolean z;
        AvParser avParser2 = ((AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor()).getAvParser();
        if (avParser2 != null) {
            MissionSetFrames missionSetFrames = new MissionSetFrames();
            for (AvParser.Waypoint waypoint : AvParser.Waypoint.values()) {
                MissionWaypointFrame missionWaypointFrame = new MissionWaypointFrame();
                missionWaypointFrame.setWaypointIndex(waypoint.ordinal());
                missionWaypointFrame.setAlt(geoPoint.getAltitude() + 50.0d);
                missionWaypointFrame.setDtedAlt(geoPoint.getAltitude() + 50.0d);
                switch (C11952.$SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint[waypoint.ordinal()]) {
                    case 1:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() + OFFSET);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude() + OFFSET);
                        break;
                    case 2:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() - OFFSET);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude() + OFFSET);
                        break;
                    case 3:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() - OFFSET);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude() - OFFSET);
                        break;
                    case 4:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() + OFFSET);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude() - OFFSET);
                        break;
                    case 5:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() + OFFSET_2);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude());
                        break;
                    case 6:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() + OFFSET_2);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude() - OFFSET_2);
                        break;
                    case 7:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude());
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude() - OFFSET_2);
                        break;
                    case 8:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() - OFFSET_2);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude() - OFFSET_2);
                        break;
                    case 9:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude());
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude());
                        break;
                    case 10:
                        missionWaypointFrame.setLatDegrees(geoPoint.getLatitude() - OFFSET_2);
                        missionWaypointFrame.setLonDegrees(geoPoint.getLongitude());
                        break;
                    case 11:
                        z = false;
                        break;
                }
                z = true;
                if (z) {
                    missionSetFrames.addMissionWaypoint(missionWaypointFrame);
                }
            }
            MissionParameter missionParameter = avParser2.getMissionParameter();
            if (missionParameter != null) {
                missionSetFrames.addMissionParameter(new MissionParameterFrame(missionParameter));
            }
            if (missionParameter != null && missionSetFrames.getSet().size() == 11 && (avUplinkComm2 = ((AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor()).getAvUplinkComm()) != null) {
                avUplinkComm2.AddToSend((GCSUplinkMessageSet) missionSetFrames);
            }
        }
    }

    /* renamed from: com.atakmap.android.uastool.av.AvMonitor$2 */
    /* synthetic */ class C11952 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.av.AvParser$Waypoint[] r0 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint = r0
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.B     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.C     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.D     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.E     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.O1     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.O2     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.O3     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x006c }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.HOME     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.LAND     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$Waypoint     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.atakmap.android.uastool.av.AvParser$Waypoint r1 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.INVALID     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.AvMonitor.C11952.<clinit>():void");
        }
    }
}
