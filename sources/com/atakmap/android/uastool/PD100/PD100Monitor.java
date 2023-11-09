package com.atakmap.android.uastool.PD100;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.PD100.PD100Monitor;
import com.atakmap.android.uastool.PD100.PD100Parser;
import com.atakmap.android.uastool.RouteDrawPoint;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.prefs.UtilitiesPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.utils.AvahiService;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.comms.j;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.log.Log;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class PD100Monitor extends PlatformMonitor implements SharedPreferences.OnSharedPreferenceChangeListener, AvahiService.AvahiListListener {
    private static final String TAG = "PD100Monitor";
    private static Thread platformSwitchThread;
    private BH3CameraType activeCameraType = BH3CameraType.EO;
    private boolean avahiListenersStarted;
    /* access modifiers changed from: private */
    public String avahiNetwork;
    private AvahiService avahiService;
    private String cotTcpAddress;
    private final int cotTcpPort = 0;
    private String cotUdpAddress;
    private int cotUdpPort = 0;
    private boolean eoStreamAvailable = false;
    private String eoStreamIP;
    private int eoStreamPort = 0;
    private boolean gcsStreamAvailable = false;
    private String gcsStreamIP;
    private int gcsStreamPort = 0;
    private boolean irStreamAvailable = false;
    private String irStreamIP;
    private int irStreamPort = 0;
    /* access modifiers changed from: private */
    public PD100Parser pd100Parser;
    private CotEvent receivedRoute;
    private PD100Reflector reflector;
    private final ArrayList<String> requestQueue;
    private String serviceDeviceName;
    /* access modifiers changed from: private */
    public String stanag4586Address;
    /* access modifiers changed from: private */
    public int stanag4586Port = 0;
    /* access modifiers changed from: private */
    public String stanag4586UpAddress;
    /* access modifiers changed from: private */
    public int stanag4586UpPort = 0;
    private final Map<String, Long> uasLastUpdate;
    private final Map<String, PD100UASItem> uasList;

    public enum BH3CameraType {
        EO,
        IR,
        GCS
    }

    public enum ProtocolSelection {
        STANAG4586,
        COT
    }

    private void setTaskResponse(CotEvent cotEvent, String str, String str2, Boolean bool) {
    }

    private void startTask(RouteTask routeTask) {
    }

    public void taskCancel() {
    }

    public void taskSet() {
    }

    public static void waitForPlatformSwitch(String str, String str2, int i, String str3, int i2, InetAddress inetAddress, ProtocolSelection protocolSelection) {
        if (platformSwitchThread == null) {
            Thread thread = new Thread(new Runnable(str3, i2, inetAddress, str2, i, str) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ int f$2;
                public final /* synthetic */ InetAddress f$3;
                public final /* synthetic */ String f$4;
                public final /* synthetic */ int f$5;
                public final /* synthetic */ String f$6;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                }

                public final void run() {
                    PD100Monitor.lambda$waitForPlatformSwitch$0(PD100Monitor.ProtocolSelection.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
                }
            });
            platformSwitchThread = thread;
            thread.start();
        }
    }

    static /* synthetic */ void lambda$waitForPlatformSwitch$0(ProtocolSelection protocolSelection, String str, int i, InetAddress inetAddress, String str2, int i2, String str3) {
        while (!platformSwitchThread.isInterrupted()) {
            PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
            if (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Log.e(TAG, "error", e);
                }
            } else {
                PD100Monitor pD100Monitor = (PD100Monitor) platformMonitor;
                if (protocolSelection == ProtocolSelection.STANAG4586) {
                    pD100Monitor.set4586Service(str, i, inetAddress, str2, i2, str3);
                } else if (protocolSelection == ProtocolSelection.COT) {
                    pD100Monitor.setCotUdpService(str, i, inetAddress, str2, i2, str3);
                }
                platformSwitchThread = null;
                return;
            }
        }
    }

    public PD100Monitor(Context context, SharedPreferences sharedPreferences) {
        super(context, PD100UASItem.DISPLAY_NAME);
        UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        this.uasList = new HashMap();
        this.uasLastUpdate = new HashMap();
        this.requestQueue = new ArrayList<>();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.pd100.")) {
            str.hashCode();
            if (str.equals(PD100PrefHandler.PREF_COT_UDP_PORT) || str.equals(PD100PrefHandler.PREF_COT_TCP_PORT)) {
                endMonitoring();
                beginMonitoring(UASToolDropDownReceiver.getSharedPrefs().getBoolean(UtilitiesPreferenceFragment.PREF_CAPTURE_TO_STORAGE, false));
            }
        }
    }

    public boolean monitors(String str) {
        return str.equals(PD100UASItem.DISPLAY_NAME);
    }

    public void setCaptureToStorage(boolean z) {
        PD100Parser pD100Parser = this.pd100Parser;
        if (pD100Parser != null) {
            pD100Parser.setCaptureToStorage(z);
        }
    }

    public List<UASItem> getDetectedUasList() {
        ArrayList arrayList;
        synchronized (this.uasList) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Map.Entry<String, Long>> it = this.uasLastUpdate.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (currentTimeMillis - ((Long) next.getValue()).longValue() > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
                    this.uasList.remove(next.getKey());
                    it.remove();
                }
            }
            arrayList = new ArrayList(this.uasList.values());
        }
        return arrayList;
    }

    public void beginMonitoring(boolean z) {
        super.beginMonitoring(z);
        int i = this.cotUdpPort;
        if (i == 0) {
            i = Utils.parseInt(UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_COT_UDP_PORT, ""), 0);
        }
        PD100Parser pD100Parser = new PD100Parser(false, this, this.reflector, (String) null, i, (String) null, Utils.parseInt(UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_COT_TCP_PORT, ""), 0));
        this.pd100Parser = pD100Parser;
        pD100Parser.start();
    }

    public void endMonitoring() {
        super.endMonitoring();
        PD100Parser pD100Parser = this.pd100Parser;
        if (pD100Parser != null) {
            pD100Parser.interrupt();
            this.pd100Parser = null;
        }
        AvahiService avahiService2 = this.avahiService;
        if (avahiService2 != null) {
            avahiService2.dispose();
            this.avahiService = null;
        }
    }

    public void setReflector(PD100Reflector pD100Reflector) {
        this.reflector = pD100Reflector;
        PD100Parser pD100Parser = this.pd100Parser;
        if (pD100Parser != null) {
            pD100Parser.setReflector(pD100Reflector);
        }
    }

    private PD100Parser getParser() {
        return this.pd100Parser;
    }

    public void onIncomingCot(CotEvent cotEvent) {
        if (cotEvent.getType().startsWith(PD100Parser.PD100EventType.TASK_CONFIGURE.toString())) {
            updateRouteFromCot(cotEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnectionActivity(String str, String str2, String str3) {
        synchronized (this.uasList) {
            if (!this.uasLastUpdate.containsKey(str)) {
                PD100UASItem pD100UASItem = new PD100UASItem(str, str2, true);
                if (str3 != null && !str3.isEmpty()) {
                    pD100UASItem.setModelName(str3);
                }
                this.uasList.put(str, pD100UASItem);
            }
            this.uasLastUpdate.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public String getServiceDeviceName() {
        return this.serviceDeviceName;
    }

    public void onStanagConnectionActivity() {
        PD100Parser pD100Parser = this.pd100Parser;
        if (pD100Parser != null) {
            onConnectionActivity(this.serviceDeviceName, pD100Parser.getCallsign(), (String) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateRouteFromCot(com.atakmap.coremap.cot.event.CotEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "PD100Monitor"
            java.lang.String r1 = "Route update received"
            com.atakmap.coremap.log.Log.d(r0, r1)
            r5.receivedRoute = r6
            com.atakmap.android.uastool.PD100.PD100Parser r0 = r5.pd100Parser
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            java.util.ArrayList<java.lang.String> r0 = r5.requestQueue
            monitor-enter(r0)
            java.lang.String r6 = r6.getUID()     // Catch:{ all -> 0x0079 }
            java.util.ArrayList<java.lang.String> r1 = r5.requestQueue     // Catch:{ all -> 0x0079 }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x0035
            java.lang.String r1 = "PD100Monitor"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r2.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = "Duplicate request: "
            r2.append(r3)     // Catch:{ all -> 0x0079 }
            r2.append(r6)     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0079 }
            com.atakmap.coremap.log.Log.d(r1, r6)     // Catch:{ all -> 0x0079 }
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return
        L_0x0035:
            java.util.ArrayList<java.lang.String> r1 = r5.requestQueue     // Catch:{ all -> 0x0079 }
            r1.add(r6)     // Catch:{ all -> 0x0079 }
            com.atakmap.android.uastool.PD100.PD100Parser r1 = r5.pd100Parser     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = r1.getCallsign()     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x0077
            int r2 = r6.length()     // Catch:{ all -> 0x0079 }
            r3 = 6
            if (r2 <= r3) goto L_0x0077
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0050
            goto L_0x0077
        L_0x0050:
            r2 = 0
            int r4 = r6.length()     // Catch:{ all -> 0x0079 }
            int r4 = r4 - r3
            java.lang.String r6 = r6.substring(r2, r4)     // Catch:{ all -> 0x0079 }
            boolean r6 = r6.contains(r1)     // Catch:{ all -> 0x0079 }
            if (r6 != 0) goto L_0x0069
            java.lang.String r6 = "PD100Monitor"
            java.lang.String r1 = "Discarding a message that doesn't pertain to us"
            com.atakmap.coremap.log.Log.d(r6, r1)     // Catch:{ all -> 0x0079 }
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return
        L_0x0069:
            android.content.Context r6 = r5.pluginContext     // Catch:{ all -> 0x0079 }
            android.app.Activity r6 = (android.app.Activity) r6     // Catch:{ all -> 0x0079 }
            com.atakmap.android.uastool.PD100.PD100Monitor$1 r1 = new com.atakmap.android.uastool.PD100.PD100Monitor$1     // Catch:{ all -> 0x0079 }
            r1.<init>()     // Catch:{ all -> 0x0079 }
            r6.runOnUiThread(r1)     // Catch:{ all -> 0x0079 }
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return
        L_0x0077:
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return
        L_0x0079:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.PD100.PD100Monitor.updateRouteFromCot(com.atakmap.coremap.cot.event.CotEvent):void");
    }

    /* access modifiers changed from: private */
    public void loadProposedRoute() {
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

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = (com.atakmap.android.uastool.PD100.PD100UASItem) r8.uasList.entrySet().iterator().next().getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSendRouteReceived(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "PD100Monitor"
            java.lang.String r1 = "onSendRouteReceived"
            com.atakmap.coremap.log.Log.d(r0, r1)
            java.util.Map<java.lang.String, com.atakmap.android.uastool.PD100.PD100UASItem> r0 = r8.uasList
            if (r0 == 0) goto L_0x00bb
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0013
            goto L_0x00bb
        L_0x0013:
            java.util.Map<java.lang.String, com.atakmap.android.uastool.PD100.PD100UASItem> r0 = r8.uasList
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getValue()
            com.atakmap.android.uastool.PD100.PD100UASItem r0 = (com.atakmap.android.uastool.PD100.PD100UASItem) r0
            if (r0 != 0) goto L_0x002c
            return
        L_0x002c:
            java.lang.String r1 = r0.getUid()
            boolean r9 = r9.contains(r1)
            r1 = 0
            java.lang.String r2 = "No"
            java.lang.String r3 = "Yes"
            r4 = 17301543(0x1080027, float:2.4979364E-38)
            java.lang.String r5 = "?"
            if (r9 == 0) goto L_0x007e
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
            android.content.Context r6 = r8.pluginContext
            r9.<init>(r6)
            java.lang.String r6 = "Send Route Local"
            android.app.AlertDialog$Builder r9 = r9.setTitle(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Send new route to "
            r6.append(r7)
            java.lang.String r7 = r0.getCallsign()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.app.AlertDialog$Builder r9 = r9.setMessage(r5)
            android.app.AlertDialog$Builder r9 = r9.setIcon(r4)
            com.atakmap.android.uastool.PD100.PD100Monitor$2 r4 = new com.atakmap.android.uastool.PD100.PD100Monitor$2
            r4.<init>(r0)
            android.app.AlertDialog$Builder r9 = r9.setPositiveButton(r3, r4)
            android.app.AlertDialog$Builder r9 = r9.setNegativeButton(r2, r1)
            r9.show()
            goto L_0x00bb
        L_0x007e:
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
            android.content.Context r6 = r8.pluginContext
            r9.<init>(r6)
            java.lang.String r6 = "Send Route Remote"
            android.app.AlertDialog$Builder r9 = r9.setTitle(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Send new route request to "
            r6.append(r7)
            java.lang.String r0 = r0.getCallsign()
            r6.append(r0)
            r6.append(r5)
            java.lang.String r0 = r6.toString()
            android.app.AlertDialog$Builder r9 = r9.setMessage(r0)
            android.app.AlertDialog$Builder r9 = r9.setIcon(r4)
            com.atakmap.android.uastool.PD100.PD100Monitor$3 r0 = new com.atakmap.android.uastool.PD100.PD100Monitor$3
            r0.<init>()
            android.app.AlertDialog$Builder r9 = r9.setPositiveButton(r3, r0)
            android.app.AlertDialog$Builder r9 = r9.setNegativeButton(r2, r1)
            r9.show()
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.PD100.PD100Monitor.onSendRouteReceived(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void sendRouteLocal(PD100UASItem pD100UASItem) {
        ArrayList<RouteDrawPoint> routeDrawPoints;
        PD100Parser pD100Parser = this.pd100Parser;
        if (pD100Parser != null && pD100UASItem != null && (routeDrawPoints = pD100UASItem.getRouteDrawPoints()) != null && !routeDrawPoints.isEmpty()) {
            pD100Parser.uplinkRoute("Route", (Collection<RouteDrawPoint>) routeDrawPoints, 20.0d, 40.0d, 300);
        }
    }

    public void onWaypointSetReceived() {
        Map<String, PD100UASItem> map;
        PD100UASItem pD100UASItem;
        ArrayList<RouteDrawPoint> routeDrawPoints;
        Log.d(TAG, "onWaypointSetReceived");
        PD100Parser pD100Parser = this.pd100Parser;
        if (pD100Parser != null && (map = this.uasList) != null && !map.isEmpty() && (pD100UASItem = (PD100UASItem) this.uasList.entrySet().iterator().next().getValue()) != null && this.pd100Parser != null && (routeDrawPoints = pD100UASItem.getRouteDrawPoints()) != null && !routeDrawPoints.isEmpty()) {
            pD100Parser.uplinkWaypoints(routeDrawPoints, 20.0d, 40.0d, 300, (String) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = (com.atakmap.android.uastool.PD100.PD100UASItem) r8.uasList.entrySet().iterator().next().getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSendTaskReceived(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "PD100Monitor"
            java.lang.String r1 = "onSendTaskReceived"
            com.atakmap.coremap.log.Log.d(r0, r1)
            java.util.Map<java.lang.String, com.atakmap.android.uastool.PD100.PD100UASItem> r0 = r8.uasList
            if (r0 == 0) goto L_0x00bb
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0013
            goto L_0x00bb
        L_0x0013:
            java.util.Map<java.lang.String, com.atakmap.android.uastool.PD100.PD100UASItem> r0 = r8.uasList
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getValue()
            com.atakmap.android.uastool.PD100.PD100UASItem r0 = (com.atakmap.android.uastool.PD100.PD100UASItem) r0
            if (r0 != 0) goto L_0x002c
            return
        L_0x002c:
            java.lang.String r1 = r0.getUid()
            boolean r9 = r9.contains(r1)
            r1 = 0
            java.lang.String r2 = "No"
            java.lang.String r3 = "Yes"
            r4 = 17301543(0x1080027, float:2.4979364E-38)
            java.lang.String r5 = "?"
            if (r9 == 0) goto L_0x007e
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
            android.content.Context r6 = r8.pluginContext
            r9.<init>(r6)
            java.lang.String r6 = "Send Task Local"
            android.app.AlertDialog$Builder r9 = r9.setTitle(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Send new task to "
            r6.append(r7)
            java.lang.String r7 = r0.getCallsign()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.app.AlertDialog$Builder r9 = r9.setMessage(r5)
            android.app.AlertDialog$Builder r9 = r9.setIcon(r4)
            com.atakmap.android.uastool.PD100.PD100Monitor$4 r4 = new com.atakmap.android.uastool.PD100.PD100Monitor$4
            r4.<init>(r0)
            android.app.AlertDialog$Builder r9 = r9.setPositiveButton(r3, r4)
            android.app.AlertDialog$Builder r9 = r9.setNegativeButton(r2, r1)
            r9.show()
            goto L_0x00bb
        L_0x007e:
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
            android.content.Context r6 = r8.pluginContext
            r9.<init>(r6)
            java.lang.String r6 = "Send Task Remote"
            android.app.AlertDialog$Builder r9 = r9.setTitle(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Send new task request to "
            r6.append(r7)
            java.lang.String r0 = r0.getCallsign()
            r6.append(r0)
            r6.append(r5)
            java.lang.String r0 = r6.toString()
            android.app.AlertDialog$Builder r9 = r9.setMessage(r0)
            android.app.AlertDialog$Builder r9 = r9.setIcon(r4)
            com.atakmap.android.uastool.PD100.PD100Monitor$5 r0 = new com.atakmap.android.uastool.PD100.PD100Monitor$5
            r0.<init>()
            android.app.AlertDialog$Builder r9 = r9.setPositiveButton(r3, r0)
            android.app.AlertDialog$Builder r9 = r9.setNegativeButton(r2, r1)
            r9.show()
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.PD100.PD100Monitor.onSendTaskReceived(java.lang.String):void");
    }

    public void onTaskResponse(CotEvent cotEvent) {
        switch (PD100Parser.PD100EventType.fromString(cotEvent.getType())) {
            case TASK_CANCEL:
                setTaskResponse(cotEvent, "CANCEL", (String) null, true);
                return;
            case TASK_ACKNOWLEDGE_RECEIPT:
                setTaskResponse(cotEvent, "ACK", (String) null, false);
                return;
            case TASK_WILCO:
                setTaskResponse(cotEvent, "WILCO", (String) null, false);
                return;
            case TASK_CANT_COMPLY:
            case TASK_CANT_COMPLY_NO_AVAILABLE_ASSET:
            case TASK_CANT_COMPLY_INSUFFICIENT_INFO:
            case TASK_CANT_COMPLY_BAD_REQUEST:
            case TASK_CANT_COMPLY_BAD_REQUEST_VIOLATES_RULES:
            case TASK_CANT_COMPLY_BAD_REQUEST_NO_AUTHORIZATION:
            case TASK_CANT_COMPLY_BAD_REQUEST_PHYSICALLY_IMPOSSIBLE:
            case TASK_CANT_COMPLY_STALE:
            case TASK_CANT_COMPLY_REJECTED:
            case TASK_CANT_COMPLY_REJECTED_C2:
            case TASK_CANT_COMPLY_REJECTED_PILOT:
            case TASK_CANT_COMPLY_CANCELLED:
                setTaskResponse(cotEvent, "WONTGO", (String) null, true);
                return;
            case TASK_COMPLETE:
                cotEvent.getUID();
                return;
            case TASK_EXECUTING:
                setTaskResponse(cotEvent, (String) null, "Executing", false);
                return;
            case TASK_APPROVED:
                setTaskResponse(cotEvent, (String) null, "Approved", false);
                return;
            case TASK_IMAGERY_AVAILABLE:
                setTaskResponse(cotEvent, (String) null, "Imagery Available", false);
                return;
            case TASK_REVIEWING:
                setTaskResponse(cotEvent, (String) null, "Reviewing", false);
                return;
            case TASK_PLANNING:
                setTaskResponse(cotEvent, (String) null, "Planning", false);
                return;
            default:
                return;
        }
    }

    public void uplinkRouteAndTask(PD100Parser.PD100EventType pD100EventType, String str, String str2, Collection<RouteDrawPoint> collection, double d, double d2, int i) {
        this.pd100Parser.uplinkRouteAndTask(pD100EventType, str, str2, collection, d, d2, i);
    }

    public void setCotUdpService(String str, int i, InetAddress inetAddress, String str2, int i2, String str3) {
        if (this.pd100Parser != null) {
            this.serviceDeviceName = str3.substring(str3.indexOf("(prs") + 1, str3.length() - 1);
            if (this.cotUdpPort != i2) {
                this.cotUdpAddress = str2;
                this.cotUdpPort = i2;
                lookupNetworkInterface(inetAddress);
                endMonitoring();
                beginMonitoring(false);
            }
            startAvahiListeners();
        }
    }

    public void set4586Service(String str, int i, InetAddress inetAddress, String str2, int i2, String str3) {
        startAvahiListeners();
        if (this.pd100Parser != null) {
            this.serviceDeviceName = str3.substring(str3.indexOf("(prs") + 1, str3.length() - 1);
            this.stanag4586UpAddress = str;
            this.stanag4586UpPort = i;
            this.stanag4586Address = str2;
            this.stanag4586Port = i2;
            lookupNetworkInterface(inetAddress);
            onStanagConnectionActivity();
        }
    }

    private void lookupNetworkInterface(final InetAddress inetAddress) {
        new Thread(new Runnable() {
            public void run() {
                j.a a;
                try {
                    DatagramSocket datagramSocket = new DatagramSocket();
                    datagramSocket.connect(inetAddress, 0);
                    NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(datagramSocket.getLocalAddress());
                    if (byInetAddress != null && (a = j.a(j.a(byInetAddress))) != null) {
                        String unused = PD100Monitor.this.avahiNetwork = a.b;
                        if (PD100Monitor.this.stanag4586Address != null && !PD100Monitor.this.stanag4586Address.isEmpty() && PD100Monitor.this.stanag4586Port != 0) {
                            PD100Monitor.this.pd100Parser.start4586Listener(PD100Monitor.this.stanag4586Address, PD100Monitor.this.stanag4586Port, PD100Monitor.this.avahiNetwork, PD100Monitor.this.stanag4586UpAddress, PD100Monitor.this.stanag4586UpPort);
                        }
                    }
                } catch (SocketException e) {
                    Log.e(PD100Monitor.TAG, "error", e);
                }
            }
        }).start();
    }

    private void startAvahiListeners() {
        if (!this.avahiListenersStarted) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(AvahiService.SERVICE_TYPE_BH3_GUI);
            arrayList.add(AvahiService.SERVICE_TYPE_BH3_4586);
            arrayList.add(AvahiService.SERVICE_TYPE_COT_UDP);
            AvahiService avahiService2 = new AvahiService(MapView.getMapView().getContext(), arrayList);
            this.avahiService = avahiService2;
            avahiService2.listChangeListeners.add(this);
        }
    }

    public void onListChanged() {
        int i;
        Log.d(TAG, "onListChanged AvahiVideoListener");
        if (this.avahiService != null) {
            Log.d(TAG, "onListChanged - " + this.avahiService.getList().size());
            Iterator<AvahiServiceInfo> it = this.avahiService.getList().iterator();
            boolean z = false;
            while (it.hasNext()) {
                AvahiServiceInfo next = it.next();
                String serviceName = next.getServiceName();
                if (serviceName.contains(this.serviceDeviceName)) {
                    String serviceType = next.getServiceType();
                    String ipAddress = next.getIpAddress();
                    int port = next.getPort();
                    String str = next.getAttributes().get("tx_address");
                    int parseInt = Utils.parseInt(next.getAttributes().get("tx_port"), 0);
                    Log.d(TAG, "onListChanged - " + serviceName);
                    if (serviceType.contains(AvahiService.SERVICE_TYPE_BH3_GUI) && serviceName.contains("UAV-1-EO")) {
                        this.eoStreamAvailable = true;
                        this.eoStreamIP = str;
                        this.eoStreamPort = parseInt;
                        Log.d(TAG, "onListChanged - EO -" + this.eoStreamIP + ":" + this.eoStreamPort);
                    } else if (serviceType.contains(AvahiService.SERVICE_TYPE_BH3_GUI) && serviceName.contains("UAV-1-TI")) {
                        this.irStreamAvailable = true;
                        this.irStreamIP = str;
                        this.irStreamPort = parseInt;
                        Log.d(TAG, "onListChanged - IR -" + this.irStreamIP + ":" + this.irStreamPort);
                    } else if (serviceType.contains(AvahiService.SERVICE_TYPE_BH3_GUI) && serviceName.contains("GUI")) {
                        this.gcsStreamAvailable = true;
                        this.gcsStreamIP = str;
                        this.gcsStreamPort = parseInt;
                        Log.d(TAG, "onListChanged - GCS -" + this.gcsStreamIP + ":" + this.gcsStreamPort);
                    } else if (serviceType.contains(AvahiService.SERVICE_TYPE_COT_UDP)) {
                        Log.d(TAG, "onListChanged - CoT -" + str + ":" + parseInt);
                        if (this.cotUdpPort != parseInt) {
                            this.cotUdpAddress = str;
                            this.cotUdpPort = parseInt;
                            z = true;
                        }
                    } else if (serviceType.contains(AvahiService.SERVICE_TYPE_BH3_4586)) {
                        Log.d(TAG, "onListChanged - 4586 -" + str + ":" + parseInt);
                        if (this.stanag4586Port != parseInt) {
                            this.stanag4586UpAddress = ipAddress;
                            this.stanag4586UpPort = port;
                            this.stanag4586Address = str;
                            this.stanag4586Port = parseInt;
                            this.pd100Parser.start4586Listener(str, parseInt, this.avahiNetwork, ipAddress, port);
                        }
                    }
                }
            }
            if (z) {
                endMonitoring();
                beginMonitoring(false);
                String str2 = this.stanag4586Address;
                if (str2 != null && !str2.isEmpty() && (i = this.stanag4586Port) != 0) {
                    this.pd100Parser.start4586Listener(this.stanag4586Address, i, this.avahiNetwork, this.stanag4586UpAddress, this.stanag4586UpPort);
                }
            }
        }
    }

    public boolean isEOStreamAvailable() {
        if (this.eoStreamAvailable) {
            return true;
        }
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_SRC_IP, "");
        String string2 = UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_SRC_PORT, "");
        if (string == null || string.isEmpty() || string2 == null || string2.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isIRStreamAvailable() {
        return this.irStreamAvailable;
    }

    public boolean isGCSStreamAvailable() {
        return this.gcsStreamAvailable;
    }

    public void setActiveCamera(BH3CameraType bH3CameraType) {
        if (this.activeCameraType != bH3CameraType) {
            this.activeCameraType = bH3CameraType;
            this.reflector.updateVideoStream();
        }
    }

    public BH3CameraType getActiveCamera() {
        return this.activeCameraType;
    }

    public String getActiveVideoIP() {
        if (this.activeCameraType == BH3CameraType.EO) {
            String str = this.eoStreamIP;
            if (str != null) {
                return str;
            }
            return UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_SRC_IP, "");
        } else if (this.activeCameraType == BH3CameraType.IR) {
            return this.irStreamIP;
        } else {
            if (this.activeCameraType == BH3CameraType.GCS) {
                return this.gcsStreamIP;
            }
            return null;
        }
    }

    public int getActiveVideoPort() {
        if (this.activeCameraType == BH3CameraType.EO) {
            int i = this.eoStreamPort;
            if (i != 0) {
                return i;
            }
            return Utils.parseInt(UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_SRC_PORT, ""), 0);
        } else if (this.activeCameraType == BH3CameraType.IR) {
            return this.irStreamPort;
        } else {
            if (this.activeCameraType == BH3CameraType.GCS) {
                return this.gcsStreamPort;
            }
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r1 = r3.avahiNetwork;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getActiveVideoNetwork() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getSharedPrefs()
            java.lang.String r1 = "uastool.pd100.pref_src_adapter"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto L_0x0016
            java.lang.String r1 = "System Default"
            int r1 = r0.compareToIgnoreCase(r1)
            if (r1 != 0) goto L_0x0022
        L_0x0016:
            java.lang.String r1 = r3.avahiNetwork
            if (r1 == 0) goto L_0x0022
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0022
            java.lang.String r0 = r3.avahiNetwork
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.PD100.PD100Monitor.getActiveVideoNetwork():java.lang.String");
    }
}
