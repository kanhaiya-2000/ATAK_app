package com.atakmap.android.uastool.PD100;

import atakplugin.UASTool.adz;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.RouteDrawPoint;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.utils.CaptureToStorage;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.DistanceCalculations;
import com.atakmap.coremap.maps.coords.GeoCalculations;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.autel.downloader.bean.DownloadTask;
import indago.serialization.JsonValueConstants;
import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class PD100Parser extends Thread {
    private static final int RX_TCP_PORT = 0;
    private static final int RX_UDP_PORT = 0;
    private static final String TAG = "PD100Parser";
    private static final String TAG_TCP = "PD100Parser_TCP";
    private static final String TAG_UDP = "PD100Parser_UDP";
    private boolean cancelled = true;
    /* access modifiers changed from: private */
    public final CaptureToStorage captureTcpToStorage;
    /* access modifiers changed from: private */
    public final CaptureToStorage captureUdpToStorage;
    private final ArrayList<CotEvent> cotEventsToPublish;
    /* access modifiers changed from: private */
    public final int cotTcpPort;
    private final String cotTcppAddress;
    private final String cotUdpAddress;
    /* access modifiers changed from: private */
    public final int cotUdpPort;
    private String defaultRequestReplyUri;
    private final boolean isFirmware4_1 = false;
    /* access modifiers changed from: private */
    public long lastUpdate;
    private String m_strCallsign;
    private final PD100Monitor monitor;
    private ScheduledExecutorService publishCoTExecutor;
    /* access modifiers changed from: private */
    public PD100Reflector reflector;
    private GeoPoint spiLocation;
    private Stanag4586Server stanagServer;
    private int testCounter;
    /* access modifiers changed from: private */
    public volatile InetAddress txAddress;
    /* access modifiers changed from: private */
    public volatile int txPort = 0;
    private final UasC2Event uasC2Event;
    private final LinkedBlockingQueue<DatagramPacket> uplinkQueue;

    public PD100Parser(boolean z, PD100Monitor pD100Monitor, PD100Reflector pD100Reflector, String str, int i, String str2, int i2) {
        UasC2Event uasC2Event2 = new UasC2Event();
        this.uasC2Event = uasC2Event2;
        this.cotEventsToPublish = new ArrayList<>();
        this.spiLocation = null;
        this.defaultRequestReplyUri = "";
        this.publishCoTExecutor = null;
        this.uplinkQueue = new LinkedBlockingQueue<>();
        this.testCounter = 0;
        this.reflector = pD100Reflector;
        this.monitor = pD100Monitor;
        this.stanagServer = new Stanag4586Server(pD100Monitor);
        CaptureToStorage captureToStorage = new CaptureToStorage("udpTelemetry");
        this.captureUdpToStorage = captureToStorage;
        captureToStorage.setCaptureToStorage(z);
        CaptureToStorage captureToStorage2 = new CaptureToStorage("tcpTelemetry");
        this.captureTcpToStorage = captureToStorage2;
        captureToStorage2.setCaptureToStorage(z);
        this.cotUdpAddress = str;
        this.cotUdpPort = i;
        this.cotTcppAddress = str2;
        this.cotTcpPort = i2;
        uasC2Event2.tailNumber = "UAS-" + UASToolDropDownReceiver.getInstance().getMapView().getDeviceCallsign();
        uasC2Event2.vehicleDetail.type = PD100UASItem.DISPLAY_NAME;
        uasC2Event2.vehicleDetail.typeTag = PD100UASItem.DETAIL_TAG;
        this.lastUpdate = 0;
    }

    public void interrupt() {
        this.cancelled = true;
        super.interrupt();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        if (r6 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r6.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005e, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0062, code lost:
        if (r5 != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006d, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0073, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0074, code lost:
        if (r4 != null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007f, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0082, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            java.lang.String r0 = "Shutting down..."
            java.lang.String r1 = "PD100Parser"
            r2 = 0
            r8.cancelled = r2
            r2 = 0
            com.atakmap.android.uastool.PD100.PD100Parser$TcpDownlinkServer r3 = new com.atakmap.android.uastool.PD100.PD100Parser$TcpDownlinkServer     // Catch:{ Exception -> 0x0085 }
            r3.<init>()     // Catch:{ Exception -> 0x0085 }
            com.atakmap.android.uastool.PD100.PD100Parser$UdpDownlinkServer r4 = new com.atakmap.android.uastool.PD100.PD100Parser$UdpDownlinkServer     // Catch:{ all -> 0x0071 }
            r4.<init>()     // Catch:{ all -> 0x0071 }
            com.atakmap.android.uastool.PD100.UdpUplinkComm r5 = new com.atakmap.android.uastool.PD100.UdpUplinkComm     // Catch:{ all -> 0x005f }
            java.util.concurrent.LinkedBlockingQueue<java.net.DatagramPacket> r6 = r8.uplinkQueue     // Catch:{ all -> 0x005f }
            r5.<init>(r6)     // Catch:{ all -> 0x005f }
            java.lang.String r6 = "Starting..."
            com.atakmap.coremap.log.Log.d(r1, r6)     // Catch:{ all -> 0x004d }
            r8.startPublishingCoT()     // Catch:{ all -> 0x004d }
            r3.start()     // Catch:{ all -> 0x004d }
            r4.start()     // Catch:{ all -> 0x004d }
            r5.start()     // Catch:{ all -> 0x004d }
            java.lang.String r6 = "Running..."
            com.atakmap.coremap.log.Log.d(r1, r6)     // Catch:{ all -> 0x004d }
        L_0x002f:
            boolean r6 = r8.cancelled     // Catch:{ all -> 0x004d }
            if (r6 != 0) goto L_0x0039
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r6)     // Catch:{ all -> 0x004d }
            goto L_0x002f
        L_0x0039:
            r5.close()     // Catch:{ all -> 0x005f }
            r4.close()     // Catch:{ all -> 0x0071 }
            r3.close()     // Catch:{ Exception -> 0x0085 }
            com.atakmap.coremap.log.Log.d(r1, r0)
            r8.stopPublishingCoT()
            com.atakmap.android.uastool.PD100.Stanag4586Server r0 = r8.stanagServer
            if (r0 == 0) goto L_0x009e
            goto L_0x0099
        L_0x004d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x004f }
        L_0x004f:
            r7 = move-exception
            if (r6 == 0) goto L_0x005b
            r5.close()     // Catch:{ all -> 0x0056 }
            goto L_0x005e
        L_0x0056:
            r5 = move-exception
            r6.addSuppressed(r5)     // Catch:{ all -> 0x005f }
            goto L_0x005e
        L_0x005b:
            r5.close()     // Catch:{ all -> 0x005f }
        L_0x005e:
            throw r7     // Catch:{ all -> 0x005f }
        L_0x005f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r6 = move-exception
            if (r5 == 0) goto L_0x006d
            r4.close()     // Catch:{ all -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch:{ all -> 0x0071 }
            goto L_0x0070
        L_0x006d:
            r4.close()     // Catch:{ all -> 0x0071 }
        L_0x0070:
            throw r6     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r5 = move-exception
            if (r4 == 0) goto L_0x007f
            r3.close()     // Catch:{ all -> 0x007a }
            goto L_0x0082
        L_0x007a:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0082
        L_0x007f:
            r3.close()     // Catch:{ Exception -> 0x0085 }
        L_0x0082:
            throw r5     // Catch:{ Exception -> 0x0085 }
        L_0x0083:
            r3 = move-exception
            goto L_0x009f
        L_0x0085:
            r3 = move-exception
            boolean r4 = r8.cancelled     // Catch:{ all -> 0x0083 }
            if (r4 != 0) goto L_0x008f
            java.lang.String r4 = "Exception in PD100Parser.run()"
            com.atakmap.coremap.log.Log.e(r1, r4, r3)     // Catch:{ all -> 0x0083 }
        L_0x008f:
            com.atakmap.coremap.log.Log.d(r1, r0)
            r8.stopPublishingCoT()
            com.atakmap.android.uastool.PD100.Stanag4586Server r0 = r8.stanagServer
            if (r0 == 0) goto L_0x009e
        L_0x0099:
            r0.cancel()
            r8.stanagServer = r2
        L_0x009e:
            return
        L_0x009f:
            com.atakmap.coremap.log.Log.d(r1, r0)
            r8.stopPublishingCoT()
            com.atakmap.android.uastool.PD100.Stanag4586Server r0 = r8.stanagServer
            if (r0 == 0) goto L_0x00ae
            r0.cancel()
            r8.stanagServer = r2
        L_0x00ae:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.PD100.PD100Parser.run():void");
    }

    public void setCaptureToStorage(boolean z) {
        this.captureUdpToStorage.setCaptureToStorage(z);
        this.captureTcpToStorage.setCaptureToStorage(z);
    }

    public void setReflector(PD100Reflector pD100Reflector) {
        this.reflector = pD100Reflector;
    }

    public String getCallsign() {
        String str = this.m_strCallsign;
        if (str == null || str.isEmpty()) {
            str = this.uasC2Event.tailNumber;
        }
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(UASToolPreferenceFragment.PREF_CALLSIGN, (String) null);
        return (string == null || string.isEmpty()) ? str : string;
    }

    public enum PD100EventType {
        UNKNOWN("UNKNOWN"),
        SPI("b-m-p-s-p-i"),
        GROUND_STATION("a-f-G-U-U-M-R-X"),
        UAV("a-f-A-M-H-Q-r"),
        BITS_IMAGE("b-i"),
        BITS_IMAGE_EO("b-i-e"),
        BITS_IMAGE_IR("b-i-i"),
        BITS_ALARM("b-a"),
        BITS_DETECTION("b-d"),
        BITS_MAP("b-m"),
        BITS_MAP_POINT("b-m-p"),
        BITS_MAP_POINT_g("b-m-p-g"),
        BITS_MAP_POINT_g_o("b-m-p-g-o"),
        BITS_MAP_POINT_m("b-m-p-m"),
        BITS_MAP_POINT_CLICK("b-m-p-m-c"),
        BITS_MAP_POINT_s("b-m-p-s"),
        BITS_MAP_POINT_s_i("b-m-p-s-i"),
        BITS_MAP_POINT_TARGETED("b-m-p-t"),
        BITS_MAP_POINT_VIDEO("b-m-p-v"),
        BITS_MAP_POINT_VIDEO_i("b-m-p-v-i"),
        BITS_MAP_POINT_WAYPOINT(UASRoute.WAYPOINT_TYPE),
        BITS_MAP_ROUTE("b-m-r"),
        TASK_CONFIGURE("t-c"),
        TASK_EXECUTE("t-e"),
        TASK_MENSURATE("t-m"),
        TASK_STRIKE("t-k"),
        TASK_RELOCATE("t-r"),
        TASK_ISR("t-s"),
        TASK_ISR_IMAGERY("t-s-i"),
        TASK_ISR_IMAGERY_EO("t-s-i-e"),
        TASK_ISR_IMAGERY_IR("t-s-i-i"),
        TASK_ISR_VIDEO("t-s-v"),
        TASK_ISR_VIDEO_EO("t-s-v-e"),
        TASK_ISR_VIDEO_IR("t-s-v-i"),
        TASK_STATUS_QUERY("t-u-q"),
        TASK_CANCEL("t-u-z"),
        TASK_ACKNOWLEDGE_RECEIPT("y-a-r"),
        TASK_WILCO("y-a-w"),
        TASK_CANT_COMPLY("y-c-f"),
        TASK_CANT_COMPLY_NO_AVAILABLE_ASSET("y-c-f-a"),
        TASK_CANT_COMPLY_INSUFFICIENT_INFO("y-c-f-i"),
        TASK_CANT_COMPLY_BAD_REQUEST("y-c-f-b"),
        TASK_CANT_COMPLY_BAD_REQUEST_VIOLATES_RULES("y-c-f-b-v"),
        TASK_CANT_COMPLY_BAD_REQUEST_NO_AUTHORIZATION("y-c-f-b-a"),
        TASK_CANT_COMPLY_BAD_REQUEST_PHYSICALLY_IMPOSSIBLE("y-c-f-b-p"),
        TASK_CANT_COMPLY_STALE("y-c-f-s"),
        TASK_CANT_COMPLY_REJECTED("y-c-f-r"),
        TASK_CANT_COMPLY_REJECTED_C2("y-c-f-r-c"),
        TASK_CANT_COMPLY_REJECTED_PILOT("y-c-f-r-p"),
        TASK_CANT_COMPLY_CANCELLED("y-c-f-x"),
        TASK_COMPLETE("y-c-s"),
        TASK_EXECUTING("y-s-e"),
        TASK_APPROVED("y-s-e-a"),
        TASK_IMAGERY_AVAILABLE("y-s-i"),
        TASK_REVIEWING("y-s-r"),
        TASK_PLANNING("y-s-p");
        
        private static final Map<String, PD100EventType> ENUM_MAP = null;
        private final String text;

        static {
            int i;
            HashMap hashMap = new HashMap();
            for (PD100EventType pD100EventType : values()) {
                hashMap.put(pD100EventType.toString(), pD100EventType);
            }
            ENUM_MAP = Collections.unmodifiableMap(hashMap);
        }

        private PD100EventType(String str) {
            this.text = str;
        }

        public String toString() {
            return this.text;
        }

        public static PD100EventType fromString(String str) {
            if (str.startsWith("b-i-i")) {
                return BITS_IMAGE_IR;
            }
            if (str.startsWith("b-i-e")) {
                return BITS_IMAGE_EO;
            }
            if (str.startsWith("b-i")) {
                return BITS_IMAGE;
            }
            PD100EventType pD100EventType = ENUM_MAP.get(str);
            return pD100EventType == null ? UNKNOWN : pD100EventType;
        }
    }

    /* access modifiers changed from: private */
    public void processPD100SPIEvent(CotEvent cotEvent) {
        String str;
        Log.d(TAG, "Processing PD100 event SPI");
        GeoPoint dTEDElevation = PD100Reflector.getDTEDElevation(cotEvent.getGeoPoint());
        synchronized (this.uasC2Event) {
            str = this.uasC2Event.contactDetail.callsign;
            this.spiLocation = dTEDElevation;
        }
        String callsign = getCallsign();
        if (this.monitor.getServiceDeviceName() != null && !this.monitor.getServiceDeviceName().isEmpty()) {
            callsign = this.monitor.getServiceDeviceName();
        }
        cotEvent.setUID(callsign + ".SPI1");
        CotDetail detail = cotEvent.getDetail();
        if (detail != null) {
            UasC2Event.addOrUpdateCotFlowtags(detail, "uastool_operator");
            UasC2Event.addOrUpdateCotContactCallsign(detail, str + ".SPI1");
            UasC2Event.addOrUpdateCotLink(detail, str, UASToolConstants.UAS_ROTARY_TYPE, (String) null);
            UasC2Event.addOrUpdateCotShapePolylineClosed(detail, true);
        }
        synchronized (this.cotEventsToPublish) {
            this.cotEventsToPublish.add(cotEvent);
        }
    }

    /* access modifiers changed from: private */
    public void processPD100GroundStationEvent(CotEvent cotEvent) {
        Log.d(TAG, "Processing PD100 event GROUND STATION");
        String callsign = getCallsign();
        if (this.monitor.getServiceDeviceName() != null && !this.monitor.getServiceDeviceName().isEmpty()) {
            callsign = this.monitor.getServiceDeviceName();
        }
        this.monitor.onConnectionActivity(callsign, getCallsign(), (String) null);
        CotDetail firstChildByName = cotEvent.getDetail().getFirstChildByName(0, UasC2Event.TrackDetail.detailName);
        if (firstChildByName != null) {
            GeoPoint dTEDElevation = PD100Reflector.getDTEDElevation(cotEvent.getGeoPoint());
            String attribute = firstChildByName.getAttribute("course");
            String attribute2 = firstChildByName.getAttribute(UASPoint.COTDETAIL_SPEED);
            synchronized (this.uasC2Event) {
                this.uasC2Event.acquirePDDetail();
                this.uasC2Event.pdDetail.groundStationLocation = dTEDElevation;
                this.uasC2Event.pdDetail.groundStationCourse = Double.parseDouble(attribute);
                this.uasC2Event.pdDetail.groundStationSpeed = Double.parseDouble(attribute2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void processPD100UAVEvent(CotEvent cotEvent) {
        CotDetail firstChildByName;
        Log.d(TAG, "Processing PD100 event UAV");
        String callsign = getCallsign();
        if (this.monitor.getServiceDeviceName() != null && !this.monitor.getServiceDeviceName().isEmpty()) {
            callsign = this.monitor.getServiceDeviceName();
        }
        this.monitor.onConnectionActivity(callsign, getCallsign(), (String) null);
        CotDetail detail = cotEvent.getDetail();
        synchronized (this.uasC2Event) {
            this.uasC2Event.airframeLocation = cotEvent.getGeoPoint();
            this.uasC2Event.tailNumber = cotEvent.getUID();
            CotDetail firstChildByName2 = detail.getFirstChildByName(0, UasC2Event.SpatialDetail.detailName);
            if (firstChildByName2 != null) {
                CotDetail firstChildByName3 = firstChildByName2.getFirstChildByName(0, UasC2Event.SpatialDetail.AttitudeDetail.detailName);
                if (firstChildByName3 != null) {
                    this.uasC2Event.spatialDetail.attitudeDetail.pitch = Double.parseDouble(firstChildByName3.getAttribute("pitch"));
                    this.uasC2Event.spatialDetail.attitudeDetail.yaw = Double.parseDouble(firstChildByName3.getAttribute("yaw"));
                    this.uasC2Event.spatialDetail.attitudeDetail.roll = Double.parseDouble(firstChildByName3.getAttribute(adz.f608a));
                }
                CotDetail firstChildByName4 = firstChildByName2.getFirstChildByName(0, UasC2Event.SpatialDetail.SpinDetail.detailName);
                if (firstChildByName4 != null) {
                    this.uasC2Event.spatialDetail.spinDetail.pitchRate = Double.parseDouble(firstChildByName4.getAttribute("pitch"));
                    this.uasC2Event.spatialDetail.spinDetail.yawRate = Double.parseDouble(firstChildByName4.getAttribute("yaw"));
                    this.uasC2Event.spatialDetail.spinDetail.rollRate = Double.parseDouble(firstChildByName4.getAttribute(adz.f608a));
                }
            }
            CotDetail firstChildByName5 = detail.getFirstChildByName(0, DownloadTask.STATUS);
            if (!(firstChildByName5 == null || (firstChildByName = firstChildByName5.getFirstChildByName(0, "fuel")) == null)) {
                double parseDouble = Double.parseDouble(firstChildByName.getAttribute("burnable"));
                this.uasC2Event.vehicleDetail.batteryRemainingCapacity = parseDouble;
                double parseDouble2 = Double.parseDouble(firstChildByName.getAttribute("burnrate"));
                if (parseDouble2 != 0.0d) {
                    this.uasC2Event.vehicleDetail.flightTime = (short) ((int) ((parseDouble / Math.abs(parseDouble2)) / 2.0d));
                }
            }
            CotDetail firstChildByName6 = detail.getFirstChildByName(0, UasC2Event.TrackDetail.detailName);
            if (firstChildByName6 != null) {
                Double valueOf = Double.valueOf(Double.parseDouble(firstChildByName6.getAttribute("course")));
                if (valueOf.doubleValue() < 0.0d) {
                    valueOf = Double.valueOf(valueOf.doubleValue() + 360.0d);
                }
                this.uasC2Event.trackDetail.course = valueOf.doubleValue();
                this.uasC2Event.trackDetail.speed = Double.parseDouble(firstChildByName6.getAttribute(UASPoint.COTDETAIL_SPEED));
            }
            CotDetail firstChildByName7 = detail.getFirstChildByName(0, "bhuav");
            if (firstChildByName7 != null) {
                this.uasC2Event.acquirePDDetail().cameraPitch = Double.valueOf(Double.parseDouble(firstChildByName7.getAttribute("camera_pitch")));
                Double valueOf2 = Double.valueOf(Double.parseDouble(firstChildByName7.getAttribute("pitch")));
                if (this.uasC2Event.pdDetail != null) {
                    valueOf2 = Double.valueOf(valueOf2.doubleValue() + this.uasC2Event.pdDetail.cameraPitch.doubleValue());
                }
                this.uasC2Event.sensorDetail.elevation = valueOf2.doubleValue();
                Double valueOf3 = Double.valueOf(Double.parseDouble(firstChildByName7.getAttribute("yaw")));
                if (valueOf3.doubleValue() < 0.0d) {
                    valueOf3 = Double.valueOf(valueOf3.doubleValue() + 360.0d);
                }
                this.uasC2Event.sensorDetail.azimuth = valueOf3.doubleValue();
                this.uasC2Event.sensorDetail.roll = Double.parseDouble(firstChildByName7.getAttribute(adz.f608a));
                this.uasC2Event.sensorDetail.vfov = Double.parseDouble(firstChildByName7.getAttribute("vfov"));
                this.uasC2Event.sensorDetail.fov = Double.parseDouble(firstChildByName7.getAttribute("hfov"));
                this.uasC2Event.sensorDetail.north = Double.valueOf(0.0d);
                this.uasC2Event.sensorDetail.model = PD100UASItem.DISPLAY_NAME;
                this.uasC2Event.sensorDetail.range = getRangeToSpi();
            }
            updateConnectedUas();
        }
    }

    private double getRangeToSpi() {
        GeoPoint geoPoint;
        GeoPoint geoPoint2 = this.uasC2Event.airframeLocation;
        if (geoPoint2 == null || (geoPoint = this.spiLocation) == null) {
            return 0.0d;
        }
        double calculateSlantRange = DistanceCalculations.calculateSlantRange(geoPoint2, geoPoint);
        if (!Double.isNaN(calculateSlantRange)) {
            return calculateSlantRange;
        }
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public void processPD100UAVImageEvent(CotEvent cotEvent) {
        GeoPoint geoPoint;
        double d;
        double d2;
        double d3;
        String str;
        Log.d(TAG, "Processing PD100 event IMAGE");
        synchronized (this.uasC2Event) {
            geoPoint = new GeoPoint(this.uasC2Event.airframeLocation);
            d = this.uasC2Event.sensorDetail.elevation;
            d2 = this.uasC2Event.sensorDetail.roll;
            d3 = this.uasC2Event.sensorDetail.azimuth;
        }
        GeoPoint geoPoint2 = cotEvent.getGeoPoint();
        if (geoPoint2.getLatitude() == 0.0d && geoPoint2.getLongitude() == 0.0d) {
            Log.d(TAG, "Replacing IMAGE GeoPoint with AirframeLocation");
        } else {
            geoPoint = geoPoint2;
        }
        cotEvent.setPoint(new CotPoint(PD100Reflector.getDTEDElevation(geoPoint)));
        synchronized (this.uasC2Event) {
            str = this.uasC2Event.contactDetail.callsign;
        }
        String uid = cotEvent.getUID();
        int indexOf = uid.indexOf("Pic.");
        String replace = uid.replace(indexOf > 0 ? uid.substring(0, indexOf - 1) : uid, str);
        cotEvent.setUID(replace);
        cotEvent.setType("b-i-x-i");
        cotEvent.setStale(new CoordinatedTime().addMinutes(30));
        CotDetail detail = cotEvent.getDetail();
        if (detail != null) {
            UasC2Event.addOrUpdateCotFlowtags(detail, "uastool_operator");
            UasC2Event.addOrUpdateCotContactCallsign(detail, replace);
            UasC2Event.addOrUpdateCotLink(detail, str, UASToolConstants.UAS_ROTARY_TYPE, (String) null);
            UasC2Event.ensureNonZeroAttitudePitchRollYaw(detail, d, d2, d3);
        }
        synchronized (this.cotEventsToPublish) {
            this.cotEventsToPublish.add(cotEvent);
        }
    }

    /* access modifiers changed from: private */
    public void processPD100WaypointEvent(CotEvent cotEvent, int i) {
        Log.d(TAG, "Processing PD100 event WAYPOINTS");
    }

    /* access modifiers changed from: package-private */
    public String getDefaultRequestReplyUrl() {
        return this.defaultRequestReplyUri;
    }

    /* access modifiers changed from: package-private */
    public void setDefaultRequestReplyUri(String str) {
        this.defaultRequestReplyUri = str;
    }

    /* access modifiers changed from: package-private */
    public boolean tryProcessTaskEvent(CotEvent cotEvent) {
        PD100EventType fromString = PD100EventType.fromString(cotEvent.getType());
        Log.d(TAG, fromString.name() + " -> '" + cotEvent.getUID() + "'");
        switch (C11472.f8368x6a2ca248[fromString.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return true;
            case 13:
                PD100Monitor pD100Monitor = this.monitor;
                if (pD100Monitor == null) {
                    return true;
                }
                pD100Monitor.onTaskResponse(cotEvent);
                return true;
            case 14:
                PD100Monitor pD100Monitor2 = this.monitor;
                if (pD100Monitor2 == null) {
                    return true;
                }
                pD100Monitor2.onTaskResponse(cotEvent);
                return true;
            case 15:
                PD100Monitor pD100Monitor3 = this.monitor;
                if (pD100Monitor3 == null) {
                    return true;
                }
                pD100Monitor3.onTaskResponse(cotEvent);
                return true;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                PD100Monitor pD100Monitor4 = this.monitor;
                if (pD100Monitor4 != null) {
                    pD100Monitor4.onTaskResponse(cotEvent);
                }
                Log.d(TAG, cotEvent.toString());
                return true;
            case 28:
                PD100Monitor pD100Monitor5 = this.monitor;
                if (pD100Monitor5 == null) {
                    return true;
                }
                pD100Monitor5.onTaskResponse(cotEvent);
                return true;
            case 29:
                PD100Monitor pD100Monitor6 = this.monitor;
                if (pD100Monitor6 == null) {
                    return true;
                }
                pD100Monitor6.onTaskResponse(cotEvent);
                return true;
            case 30:
                PD100Monitor pD100Monitor7 = this.monitor;
                if (pD100Monitor7 == null) {
                    return true;
                }
                pD100Monitor7.onTaskResponse(cotEvent);
                return true;
            case 31:
                PD100Monitor pD100Monitor8 = this.monitor;
                if (pD100Monitor8 == null) {
                    return true;
                }
                pD100Monitor8.onTaskResponse(cotEvent);
                return true;
            case 32:
                PD100Monitor pD100Monitor9 = this.monitor;
                if (pD100Monitor9 == null) {
                    return true;
                }
                pD100Monitor9.onTaskResponse(cotEvent);
                return true;
            case 33:
                PD100Monitor pD100Monitor10 = this.monitor;
                if (pD100Monitor10 == null) {
                    return true;
                }
                pD100Monitor10.onTaskResponse(cotEvent);
                return true;
            default:
                return false;
        }
    }

    private void updateConnectedUas() {
        PD100UASItem pD100UASItem = (PD100UASItem) this.reflector.getUasItem();
        pD100UASItem.setLocation(this.uasC2Event.airframeLocation);
        pD100UASItem.setGimbalAngle(this.uasC2Event.sensorDetail.azimuth);
        pD100UASItem.setGimbalPitch(this.uasC2Event.sensorDetail.elevation);
        pD100UASItem.setHFOV(this.uasC2Event.sensorDetail.fov);
        pD100UASItem.setVFOV(this.uasC2Event.sensorDetail.vfov);
        pD100UASItem.isRouteActive = this.uasC2Event.uasToolDetail.activeRoute;
    }

    private void startPublishingCoT() {
        try {
            Log.d(TAG, "Start publishing CoT...");
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.publishCoTExecutor = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    try {
                        if (System.currentTimeMillis() - PD100Parser.this.lastUpdate > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT || PD100Parser.this.reflector == null) {
                            return;
                        }
                        if (PD100Parser.this.reflector.isBroadcasting() || PD100Parser.this.reflector.isSendingCOTLocal()) {
                            PD100Parser.this.publishCoT();
                        }
                    } catch (Exception e) {
                        Log.e(PD100Parser.TAG, "Error executing PD100Parser.startPublishingCoT()", e);
                    }
                }
            }, 0, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.startPublishingCoT()", e);
        }
    }

    private void stopPublishingCoT() {
        ScheduledExecutorService scheduledExecutorService = this.publishCoTExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        this.publishCoTExecutor = null;
    }

    /* access modifiers changed from: private */
    public void publishCoT() {
        CotEvent createCotUASEvent;
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        try {
            String callsign = getCallsign();
            String deviceUid = MapView.getDeviceUid();
            String videoBroadcastDestinationIP = UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationIP();
            String videoBroadcastDestinationPort = UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationPort();
            String videoBroadcastDestinationUrl = UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl();
            synchronized (this.uasC2Event) {
                this.uasC2Event.acquireUASToolDetail().extendedCot = true;
                this.uasC2Event.contactDetail.callsign = callsign;
                this.uasC2Event.acquireLinkDetail();
                this.uasC2Event.linkDetail.uid = deviceUid;
                this.uasC2Event.acquireVideoDetail();
                this.uasC2Event.videoDetail.isBroadcasting = this.reflector.isBroadcasting();
                this.uasC2Event.videoDetail.localUri = this.reflector.getLocalUri();
                this.uasC2Event.videoDetail.scheme = "udp";
                this.uasC2Event.videoDetail.host = videoBroadcastDestinationIP;
                this.uasC2Event.videoDetail.port = Utils.parseInt(videoBroadcastDestinationPort, 0);
                this.uasC2Event.videoDetail.callsign = callsign;
                this.uasC2Event.videoDetail.url = videoBroadcastDestinationUrl;
                this.uasC2Event.radioDetail.rssi = -100;
                if ((!this.uasC2Event.airframeLocation.isValid() || this.uasC2Event.airframeLocation == GeoPoint.ZERO_POINT) && this.uasC2Event.pdDetail.groundStationLocation.isValid()) {
                    UasC2Event uasC2Event2 = this.uasC2Event;
                    uasC2Event2.airframeLocation = uasC2Event2.pdDetail.groundStationLocation;
                }
                String callsign2 = getCallsign();
                if (this.monitor.getServiceDeviceName() != null && !this.monitor.getServiceDeviceName().isEmpty()) {
                    callsign2 = this.monitor.getServiceDeviceName();
                }
                createCotUASEvent = this.uasC2Event.createCotUASEvent(coordinatedTime, UASToolConstants.UAS_ROTARY_TYPE, callsign2);
            }
            this.reflector.publishCOT(createCotUASEvent);
            synchronized (this.cotEventsToPublish) {
                Iterator<CotEvent> it = this.cotEventsToPublish.iterator();
                while (it.hasNext()) {
                    this.reflector.publishCOT(it.next());
                }
                this.cotEventsToPublish.clear();
            }
        } catch (Exception e) {
            Log.e(TAG_UDP, "publishCot() - Exception encountered!", e);
        }
    }

    private class TcpDownlinkServer extends Thread implements AutoCloseable {
        private volatile boolean cancelled;
        private Socket clientSocket;

        /* renamed from: in */
        private BufferedReader f8369in;
        private ServerSocket serverSocket;

        private TcpDownlinkServer() {
            this.cancelled = false;
            this.serverSocket = null;
            this.clientSocket = null;
            this.f8369in = null;
        }

        public void close() {
            this.cancelled = true;
            try {
                ServerSocket serverSocket2 = this.serverSocket;
                if (serverSocket2 != null) {
                    serverSocket2.close();
                }
            } catch (Exception unused) {
            }
            interrupt();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(16:32|33|(1:35)|36|37|38|39|(1:41)|42|43|44|45|(1:47)|48|49|112) */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0174, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0175, code lost:
            com.atakmap.coremap.log.Log.e(com.atakmap.android.uastool.PD100.PD100Parser.TAG_TCP, "Error: Exception encountered in tcp receive socket while reading.", r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            r4 = r12.f8369in;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x017c, code lost:
            if (r4 != null) goto L_0x017e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x017e, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0181, code lost:
            r12.f8369in = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r4 = r12.clientSocket;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0185, code lost:
            if (r4 != null) goto L_0x0187;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0187, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x018a, code lost:
            r12.clientSocket = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            r4 = r12.serverSocket;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x018e, code lost:
            if (r4 != null) goto L_0x0190;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0190, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0193, code lost:
            r12.serverSocket = null;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00c4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00d6 */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00ca A[Catch:{ Exception -> 0x00cd }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00d3 A[Catch:{ Exception -> 0x00d6 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r12 = this;
                java.lang.String r0 = "<"
                java.lang.String r1 = "</event>"
                java.lang.String r2 = "PD100Parser_TCP"
                java.lang.String r3 = "Starting TCP downlink..."
                com.atakmap.coremap.log.Log.d(r2, r3)
                r3 = 0
                r12.cancelled = r3
            L_0x000e:
                boolean r4 = r12.cancelled
                java.lang.String r5 = "PD100Parser_UDP"
                r6 = 0
                if (r4 != 0) goto L_0x01a1
                java.net.ServerSocket r4 = r12.serverSocket     // Catch:{ Exception -> 0x007a }
                if (r4 != 0) goto L_0x008f
                com.atakmap.android.uastool.PD100.PD100Parser r4 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x007a }
                int r4 = r4.cotTcpPort     // Catch:{ Exception -> 0x007a }
                if (r4 == 0) goto L_0x0028
                com.atakmap.android.uastool.PD100.PD100Parser r4 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x007a }
                int r4 = r4.cotTcpPort     // Catch:{ Exception -> 0x007a }
                goto L_0x0029
            L_0x0028:
                r4 = 0
            L_0x0029:
                java.net.ServerSocket r7 = new java.net.ServerSocket     // Catch:{ Exception -> 0x007a }
                r7.<init>(r4)     // Catch:{ Exception -> 0x007a }
                r12.serverSocket = r7     // Catch:{ Exception -> 0x007a }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
                r7.<init>()     // Catch:{ Exception -> 0x007a }
                java.lang.String r8 = "Waiting for tcp connection... (port:"
                r7.append(r8)     // Catch:{ Exception -> 0x007a }
                r7.append(r4)     // Catch:{ Exception -> 0x007a }
                java.lang.String r4 = ")"
                r7.append(r4)     // Catch:{ Exception -> 0x007a }
                java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x007a }
                com.atakmap.coremap.log.Log.d(r2, r4)     // Catch:{ Exception -> 0x007a }
                java.net.ServerSocket r4 = r12.serverSocket     // Catch:{ Exception -> 0x007a }
                java.net.Socket r4 = r4.accept()     // Catch:{ Exception -> 0x007a }
                r12.clientSocket = r4     // Catch:{ Exception -> 0x007a }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
                r4.<init>()     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = "Got connection from: "
                r4.append(r7)     // Catch:{ Exception -> 0x007a }
                java.net.Socket r7 = r12.clientSocket     // Catch:{ Exception -> 0x007a }
                java.net.InetAddress r7 = r7.getInetAddress()     // Catch:{ Exception -> 0x007a }
                r4.append(r7)     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = ":"
                r4.append(r7)     // Catch:{ Exception -> 0x007a }
                java.net.Socket r7 = r12.clientSocket     // Catch:{ Exception -> 0x007a }
                int r7 = r7.getPort()     // Catch:{ Exception -> 0x007a }
                r4.append(r7)     // Catch:{ Exception -> 0x007a }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007a }
                com.atakmap.coremap.log.Log.d(r2, r4)     // Catch:{ Exception -> 0x007a }
                goto L_0x008f
            L_0x007a:
                r4 = move-exception
                boolean r7 = r12.cancelled
                if (r7 == 0) goto L_0x0081
                goto L_0x01a1
            L_0x0081:
                java.lang.String r7 = "Error: Exception encountered in tcp receive socket while connecting"
                com.atakmap.coremap.log.Log.e(r2, r7, r4)
                java.net.ServerSocket r4 = r12.serverSocket
                if (r4 == 0) goto L_0x008d
                r4.close()     // Catch:{ Exception -> 0x008d }
            L_0x008d:
                r12.serverSocket = r6
            L_0x008f:
                java.net.ServerSocket r4 = r12.serverSocket
                if (r4 == 0) goto L_0x0197
                java.net.Socket r4 = r12.clientSocket
                if (r4 == 0) goto L_0x0197
                boolean r4 = r4.isConnected()
                if (r4 != 0) goto L_0x009f
                goto L_0x0197
            L_0x009f:
                java.io.BufferedReader r4 = r12.f8369in     // Catch:{ Exception -> 0x0174 }
                if (r4 != 0) goto L_0x00b5
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0174 }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0174 }
                java.net.Socket r8 = r12.clientSocket     // Catch:{ Exception -> 0x0174 }
                java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0174 }
                r7.<init>(r8)     // Catch:{ Exception -> 0x0174 }
                r4.<init>(r7)     // Catch:{ Exception -> 0x0174 }
                r12.f8369in = r4     // Catch:{ Exception -> 0x0174 }
            L_0x00b5:
                java.io.BufferedReader r4 = r12.f8369in     // Catch:{ Exception -> 0x0174 }
                java.lang.String r4 = r4.readLine()     // Catch:{ Exception -> 0x0174 }
                if (r4 != 0) goto L_0x00da
                java.io.BufferedReader r4 = r12.f8369in     // Catch:{ Exception -> 0x00c4 }
                if (r4 == 0) goto L_0x00c4
                r4.close()     // Catch:{ Exception -> 0x00c4 }
            L_0x00c4:
                r12.f8369in = r6     // Catch:{ Exception -> 0x0174 }
                java.net.Socket r4 = r12.clientSocket     // Catch:{ Exception -> 0x00cd }
                if (r4 == 0) goto L_0x00cd
                r4.close()     // Catch:{ Exception -> 0x00cd }
            L_0x00cd:
                r12.clientSocket = r6     // Catch:{ Exception -> 0x0174 }
                java.net.ServerSocket r4 = r12.serverSocket     // Catch:{ Exception -> 0x00d6 }
                if (r4 == 0) goto L_0x00d6
                r4.close()     // Catch:{ Exception -> 0x00d6 }
            L_0x00d6:
                r12.serverSocket = r6     // Catch:{ Exception -> 0x0174 }
                goto L_0x000e
            L_0x00da:
                com.atakmap.android.uastool.PD100.PD100Parser r7 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x0174 }
                com.atakmap.android.uastool.utils.CaptureToStorage r7 = r7.captureTcpToStorage     // Catch:{ Exception -> 0x0174 }
                r7.saveToFile((java.lang.String) r4)     // Catch:{ Exception -> 0x0174 }
                java.lang.String[] r4 = r4.split(r1)     // Catch:{ Exception -> 0x0174 }
                r7 = 0
            L_0x00e8:
                int r8 = r4.length     // Catch:{ Exception -> 0x0174 }
                if (r7 >= r8) goto L_0x000e
                r8 = r4[r7]     // Catch:{ Exception -> 0x0174 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0174 }
                r9.<init>()     // Catch:{ Exception -> 0x0174 }
                r9.append(r8)     // Catch:{ Exception -> 0x0174 }
                r9.append(r1)     // Catch:{ Exception -> 0x0174 }
                java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0174 }
                java.lang.String r9 = "stale=\"12017"
                java.lang.String r10 = "stale=\"2018"
                java.lang.String r8 = r8.replace(r9, r10)     // Catch:{ Exception -> 0x0174 }
                com.atakmap.coremap.cot.event.CotEvent r8 = com.atakmap.coremap.cot.event.CotEvent.parse(r8)     // Catch:{ Exception -> 0x0174 }
                java.lang.String r9 = r8.getType()     // Catch:{ Exception -> 0x0174 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0174 }
                r10.<init>()     // Catch:{ Exception -> 0x0174 }
                java.lang.String r11 = "Event type >"
                r10.append(r11)     // Catch:{ Exception -> 0x0174 }
                r10.append(r9)     // Catch:{ Exception -> 0x0174 }
                r10.append(r0)     // Catch:{ Exception -> 0x0174 }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0174 }
                com.atakmap.coremap.log.Log.d(r2, r10)     // Catch:{ Exception -> 0x0174 }
                int[] r10 = com.atakmap.android.uastool.PD100.PD100Parser.C11472.f8368x6a2ca248     // Catch:{ Exception -> 0x0174 }
                com.atakmap.android.uastool.PD100.PD100Parser$PD100EventType r11 = com.atakmap.android.uastool.PD100.PD100Parser.PD100EventType.fromString(r9)     // Catch:{ Exception -> 0x0174 }
                int r11 = r11.ordinal()     // Catch:{ Exception -> 0x0174 }
                r10 = r10[r11]     // Catch:{ Exception -> 0x0174 }
                switch(r10) {
                    case 34: goto L_0x014d;
                    case 35: goto L_0x0147;
                    case 36: goto L_0x0141;
                    case 37: goto L_0x013b;
                    case 38: goto L_0x013b;
                    case 39: goto L_0x013b;
                    case 40: goto L_0x013b;
                    case 41: goto L_0x013b;
                    case 42: goto L_0x013b;
                    case 43: goto L_0x013b;
                    case 44: goto L_0x013b;
                    case 45: goto L_0x013b;
                    case 46: goto L_0x013b;
                    case 47: goto L_0x013b;
                    case 48: goto L_0x013b;
                    case 49: goto L_0x013b;
                    case 50: goto L_0x013b;
                    case 51: goto L_0x013b;
                    case 52: goto L_0x0135;
                    case 53: goto L_0x0135;
                    case 54: goto L_0x0135;
                    default: goto L_0x0132;
                }     // Catch:{ Exception -> 0x0174 }
            L_0x0132:
                com.atakmap.android.uastool.PD100.PD100Parser r10 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x0174 }
                goto L_0x0153
            L_0x0135:
                com.atakmap.android.uastool.PD100.PD100Parser r9 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x0174 }
                r9.processPD100UAVImageEvent(r8)     // Catch:{ Exception -> 0x0174 }
                goto L_0x0170
            L_0x013b:
                com.atakmap.android.uastool.PD100.PD100Parser r9 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x0174 }
                r9.processPD100WaypointEvent(r8, r7)     // Catch:{ Exception -> 0x0174 }
                goto L_0x0170
            L_0x0141:
                java.lang.String r8 = "WARNING: Unexpected PD100 UAV Event received via TCP"
                com.atakmap.coremap.log.Log.w(r5, r8)     // Catch:{ Exception -> 0x0174 }
                goto L_0x0170
            L_0x0147:
                java.lang.String r8 = "WARNING: Unexpected PD100 GROUND_STATION Event received via TCP"
                com.atakmap.coremap.log.Log.w(r5, r8)     // Catch:{ Exception -> 0x0174 }
                goto L_0x0170
            L_0x014d:
                java.lang.String r8 = "WARNING: Unexpected PD100 SPI Event received via TCP"
                com.atakmap.coremap.log.Log.w(r5, r8)     // Catch:{ Exception -> 0x0174 }
                goto L_0x0170
            L_0x0153:
                boolean r8 = r10.tryProcessTaskEvent(r8)     // Catch:{ Exception -> 0x0174 }
                if (r8 != 0) goto L_0x0170
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0174 }
                r8.<init>()     // Catch:{ Exception -> 0x0174 }
                java.lang.String r10 = "WARNING: Unknown PD100 Event type >"
                r8.append(r10)     // Catch:{ Exception -> 0x0174 }
                r8.append(r9)     // Catch:{ Exception -> 0x0174 }
                r8.append(r0)     // Catch:{ Exception -> 0x0174 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0174 }
                com.atakmap.coremap.log.Log.d(r2, r8)     // Catch:{ Exception -> 0x0174 }
            L_0x0170:
                int r7 = r7 + 1
                goto L_0x00e8
            L_0x0174:
                r4 = move-exception
                java.lang.String r5 = "Error: Exception encountered in tcp receive socket while reading."
                com.atakmap.coremap.log.Log.e(r2, r5, r4)
                java.io.BufferedReader r4 = r12.f8369in     // Catch:{ Exception -> 0x0181 }
                if (r4 == 0) goto L_0x0181
                r4.close()     // Catch:{ Exception -> 0x0181 }
            L_0x0181:
                r12.f8369in = r6
                java.net.Socket r4 = r12.clientSocket     // Catch:{ Exception -> 0x018a }
                if (r4 == 0) goto L_0x018a
                r4.close()     // Catch:{ Exception -> 0x018a }
            L_0x018a:
                r12.clientSocket = r6
                java.net.ServerSocket r4 = r12.serverSocket     // Catch:{ Exception -> 0x0193 }
                if (r4 == 0) goto L_0x0193
                r4.close()     // Catch:{ Exception -> 0x0193 }
            L_0x0193:
                r12.serverSocket = r6
                goto L_0x000e
            L_0x0197:
                r4 = 1000(0x3e8, double:4.94E-321)
                java.lang.Thread.sleep(r4)     // Catch:{ Exception -> 0x019e }
                goto L_0x000e
            L_0x019e:
                goto L_0x000e
            L_0x01a1:
                java.lang.String r0 = "Stopping TCP downlink..."
                com.atakmap.coremap.log.Log.d(r5, r0)
                java.io.BufferedReader r0 = r12.f8369in     // Catch:{ Exception -> 0x01ad }
                if (r0 == 0) goto L_0x01ad
                r0.close()     // Catch:{ Exception -> 0x01ad }
            L_0x01ad:
                r12.f8369in = r6
                java.net.Socket r0 = r12.clientSocket     // Catch:{ Exception -> 0x01b6 }
                if (r0 == 0) goto L_0x01b6
                r0.close()     // Catch:{ Exception -> 0x01b6 }
            L_0x01b6:
                r12.clientSocket = r6
                java.net.ServerSocket r0 = r12.serverSocket     // Catch:{ Exception -> 0x01bf }
                if (r0 == 0) goto L_0x01bf
                r0.close()     // Catch:{ Exception -> 0x01bf }
            L_0x01bf:
                r12.serverSocket = r6
                java.lang.String r0 = "TCP downlink Stopped"
                com.atakmap.coremap.log.Log.d(r5, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.PD100.PD100Parser.TcpDownlinkServer.run():void");
        }
    }

    private class UdpDownlinkServer extends Thread implements AutoCloseable {
        private volatile boolean cancelled = false;
        private final int receiveBufferSize = 65536;

        /* renamed from: s */
        private DatagramSocket f8370s;
        private final byte[] udpReceiveData = new byte[65536];

        UdpDownlinkServer() {
        }

        public void close() {
            this.cancelled = true;
            interrupt();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d4, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d5, code lost:
            if (r5 != null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00db, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            r5.addSuppressed(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e0, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e3, code lost:
            throw r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e7, code lost:
            if (r4 != null) goto L_0x00e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f2, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f5, code lost:
            throw r5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.String r0 = "PD100Parser_UDP"
                java.lang.String r1 = "Starting UDP downlink..."
                com.atakmap.coremap.log.Log.d(r0, r1)
                r1 = 0
                r8.cancelled = r1
                java.net.DatagramPacket r2 = new java.net.DatagramPacket
                byte[] r3 = r8.udpReceiveData
                int r4 = r3.length
                r2.<init>(r3, r4)
            L_0x0012:
                boolean r3 = r8.cancelled
                r4 = 0
                if (r3 != 0) goto L_0x0128
                java.net.DatagramSocket r3 = r8.f8370s     // Catch:{ Exception -> 0x010d }
                if (r3 != 0) goto L_0x0061
                java.net.DatagramSocket r3 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x010d }
                r3.<init>(r4)     // Catch:{ Exception -> 0x010d }
                r8.f8370s = r3     // Catch:{ Exception -> 0x010d }
                r4 = 1
                r3.setReuseAddress(r4)     // Catch:{ Exception -> 0x0027 }
                goto L_0x002d
            L_0x0027:
                r3 = move-exception
                java.lang.String r4 = "Exception: "
                com.atakmap.coremap.log.Log.d(r0, r4, r3)     // Catch:{ Exception -> 0x010d }
            L_0x002d:
                com.atakmap.android.uastool.PD100.PD100Parser r3 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x010d }
                int r3 = r3.cotUdpPort     // Catch:{ Exception -> 0x010d }
                if (r3 == 0) goto L_0x003c
                com.atakmap.android.uastool.PD100.PD100Parser r3 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x010d }
                int r3 = r3.cotUdpPort     // Catch:{ Exception -> 0x010d }
                goto L_0x003d
            L_0x003c:
                r3 = 0
            L_0x003d:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
                r4.<init>()     // Catch:{ Exception -> 0x010d }
                java.lang.String r5 = "Establishing UDP receive socket (port:"
                r4.append(r5)     // Catch:{ Exception -> 0x010d }
                r4.append(r3)     // Catch:{ Exception -> 0x010d }
                java.lang.String r5 = ")"
                r4.append(r5)     // Catch:{ Exception -> 0x010d }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x010d }
                com.atakmap.coremap.log.Log.d(r0, r4)     // Catch:{ Exception -> 0x010d }
                java.net.DatagramSocket r4 = r8.f8370s     // Catch:{ Exception -> 0x010d }
                java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x010d }
                r5.<init>(r3)     // Catch:{ Exception -> 0x010d }
                r4.bind(r5)     // Catch:{ Exception -> 0x010d }
                goto L_0x0062
            L_0x0061:
                r3 = 0
            L_0x0062:
                byte[] r4 = r8.udpReceiveData     // Catch:{ Exception -> 0x010d }
                int r4 = r4.length     // Catch:{ Exception -> 0x010d }
                r2.setLength(r4)     // Catch:{ Exception -> 0x010d }
                java.net.DatagramSocket r4 = r8.f8370s     // Catch:{ Exception -> 0x010d }
                r4.receive(r2)     // Catch:{ Exception -> 0x010d }
                int r4 = r2.getLength()     // Catch:{ Exception -> 0x010d }
                if (r4 > 0) goto L_0x0074
                goto L_0x0012
            L_0x0074:
                java.net.SocketAddress r4 = r2.getSocketAddress()     // Catch:{ Exception -> 0x010d }
                r8.setRequestReplyAddress(r4, r3)     // Catch:{ Exception -> 0x010d }
                com.atakmap.android.uastool.PD100.PD100Parser r3 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x010d }
                java.net.InetAddress r4 = r2.getAddress()     // Catch:{ Exception -> 0x010d }
                java.net.InetAddress unused = r3.txAddress = r4     // Catch:{ Exception -> 0x010d }
                com.atakmap.android.uastool.PD100.PD100Parser r3 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x010d }
                int r4 = r2.getPort()     // Catch:{ Exception -> 0x010d }
                int unused = r3.txPort = r4     // Catch:{ Exception -> 0x010d }
                com.atakmap.android.uastool.PD100.PD100Parser r3 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ Exception -> 0x010d }
                com.atakmap.android.uastool.utils.CaptureToStorage r3 = r3.captureUdpToStorage     // Catch:{ Exception -> 0x010d }
                r3.saveToFile((java.net.DatagramPacket) r2)     // Catch:{ Exception -> 0x010d }
                java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00f6 }
                byte[] r4 = r2.getData()     // Catch:{ IOException -> 0x00f6 }
                int r5 = r2.getOffset()     // Catch:{ IOException -> 0x00f6 }
                int r6 = r2.getLength()     // Catch:{ IOException -> 0x00f6 }
                r3.<init>(r4, r5, r6)     // Catch:{ IOException -> 0x00f6 }
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x00e4 }
                java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x00e4 }
                r5.<init>(r3)     // Catch:{ all -> 0x00e4 }
                r4.<init>(r5)     // Catch:{ all -> 0x00e4 }
            L_0x00b1:
                java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x00d2 }
                if (r5 == 0) goto L_0x00ca
                int r6 = r5.length()     // Catch:{ all -> 0x00d2 }
                if (r6 <= 0) goto L_0x00ca
                r8.tryProcessMessage(r5)     // Catch:{ all -> 0x00d2 }
                com.atakmap.android.uastool.PD100.PD100Parser r5 = com.atakmap.android.uastool.PD100.PD100Parser.this     // Catch:{ all -> 0x00d2 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d2 }
                long unused = r5.lastUpdate = r6     // Catch:{ all -> 0x00d2 }
                goto L_0x00b1
            L_0x00ca:
                r4.close()     // Catch:{ all -> 0x00e4 }
                r3.close()     // Catch:{ IOException -> 0x00f6 }
                goto L_0x0012
            L_0x00d2:
                r5 = move-exception
                throw r5     // Catch:{ all -> 0x00d4 }
            L_0x00d4:
                r6 = move-exception
                if (r5 == 0) goto L_0x00e0
                r4.close()     // Catch:{ all -> 0x00db }
                goto L_0x00e3
            L_0x00db:
                r4 = move-exception
                r5.addSuppressed(r4)     // Catch:{ all -> 0x00e4 }
                goto L_0x00e3
            L_0x00e0:
                r4.close()     // Catch:{ all -> 0x00e4 }
            L_0x00e3:
                throw r6     // Catch:{ all -> 0x00e4 }
            L_0x00e4:
                r4 = move-exception
                throw r4     // Catch:{ all -> 0x00e6 }
            L_0x00e6:
                r5 = move-exception
                if (r4 == 0) goto L_0x00f2
                r3.close()     // Catch:{ all -> 0x00ed }
                goto L_0x00f5
            L_0x00ed:
                r3 = move-exception
                r4.addSuppressed(r3)     // Catch:{ IOException -> 0x00f6 }
                goto L_0x00f5
            L_0x00f2:
                r3.close()     // Catch:{ IOException -> 0x00f6 }
            L_0x00f5:
                throw r5     // Catch:{ IOException -> 0x00f6 }
            L_0x00f6:
                r3 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
                r4.<init>()     // Catch:{ Exception -> 0x010d }
                java.lang.String r5 = "Reading buffer"
                r4.append(r5)     // Catch:{ Exception -> 0x010d }
                r4.append(r3)     // Catch:{ Exception -> 0x010d }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x010d }
                com.atakmap.coremap.log.Log.e(r0, r3)     // Catch:{ Exception -> 0x010d }
                goto L_0x0012
            L_0x010d:
                r3 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Error: Exception encountered in UDP receive socket :"
                r4.append(r5)
                java.lang.String r5 = r3.getMessage()
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                com.atakmap.coremap.log.Log.e(r0, r4, r3)
                goto L_0x0012
            L_0x0128:
                java.lang.String r1 = "Stopping UDP downlink..."
                com.atakmap.coremap.log.Log.d(r0, r1)
                java.net.DatagramSocket r1 = r8.f8370s     // Catch:{ Exception -> 0x0134 }
                if (r1 == 0) goto L_0x0134
                r1.close()     // Catch:{ Exception -> 0x0134 }
            L_0x0134:
                r8.f8370s = r4
                java.lang.String r1 = "UDP downlink Stopped"
                com.atakmap.coremap.log.Log.d(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.PD100.PD100Parser.UdpDownlinkServer.run():void");
        }

        private boolean tryProcessMessage(String str) {
            CotEvent parse;
            if (!str.startsWith("<") || !str.endsWith(">") || (parse = CotEvent.parse(str)) == null) {
                return false;
            }
            String type = parse.getType();
            Log.d(PD100Parser.TAG_UDP, "Received event type >" + type + "<");
            switch (PD100EventType.fromString(type)) {
                case SPI:
                    PD100Parser.this.processPD100SPIEvent(parse);
                    return true;
                case GROUND_STATION:
                    PD100Parser.this.processPD100GroundStationEvent(parse);
                    return true;
                case UAV:
                    PD100Parser.this.processPD100UAVEvent(parse);
                    return true;
                case BITS_ALARM:
                case BITS_DETECTION:
                case BITS_MAP:
                case BITS_MAP_POINT:
                case BITS_MAP_POINT_g:
                case BITS_MAP_POINT_g_o:
                case BITS_MAP_POINT_m:
                case BITS_MAP_POINT_CLICK:
                case BITS_MAP_POINT_s:
                case BITS_MAP_POINT_s_i:
                case BITS_MAP_POINT_TARGETED:
                case BITS_MAP_POINT_VIDEO:
                case BITS_MAP_POINT_VIDEO_i:
                case BITS_MAP_POINT_WAYPOINT:
                case BITS_MAP_ROUTE:
                    Log.w(PD100Parser.TAG_UDP, "WARNING: Unexpected PD100 WAYPOINT Event received via UDP");
                    return true;
                case BITS_IMAGE:
                case BITS_IMAGE_EO:
                case BITS_IMAGE_IR:
                    Log.w(PD100Parser.TAG_UDP, "WARNING: Unexpected PD100 IMAGE Event received via UDP");
                    return true;
                default:
                    if (PD100Parser.this.tryProcessTaskEvent(parse)) {
                        return true;
                    }
                    Log.d(PD100Parser.TAG_UDP, "WARNING: Unknown PD100 Event type >" + type + "<");
                    return false;
            }
        }

        private void setRequestReplyAddress(SocketAddress socketAddress, int i) {
            String defaultRequestReplyUrl = PD100Parser.this.getDefaultRequestReplyUrl();
            if (defaultRequestReplyUrl == null || defaultRequestReplyUrl.isEmpty()) {
                InetAddress outboundAddress = getOutboundAddress(socketAddress);
                if (outboundAddress != null) {
                    try {
                        defaultRequestReplyUrl = new URI("udp", (String) null, outboundAddress.getHostAddress(), i, (String) null, (String) null, (String) null).toString();
                    } catch (URISyntaxException unused) {
                    }
                }
                PD100Parser.this.setDefaultRequestReplyUri(defaultRequestReplyUrl);
            }
        }

        private InetAddress getOutboundAddress(SocketAddress socketAddress) {
            DatagramSocket datagramSocket;
            try {
                datagramSocket = new DatagramSocket();
            } catch (SocketException e) {
                Log.e(PD100Parser.TAG, "error", e);
                datagramSocket = null;
            }
            if (datagramSocket != null) {
                try {
                    datagramSocket.connect(socketAddress);
                } catch (SocketException e2) {
                    Log.e(PD100Parser.TAG, "error", e2);
                }
            }
            if (datagramSocket == null) {
                return null;
            }
            InetAddress localAddress = datagramSocket.getLocalAddress();
            datagramSocket.disconnect();
            datagramSocket.close();
            return localAddress;
        }
    }

    public void start4586Listener(String str, int i, String str2, String str3, int i2) {
        if (!this.stanagServer.isAlive()) {
            this.stanagServer.setListenAddress(str, i, str2);
            this.stanagServer.setUplinkAddress(str3, i2);
            this.stanagServer.start();
        }
    }

    public boolean uplinkCotEvent(CotEvent cotEvent) {
        InetAddress inetAddress = this.txAddress;
        int i = this.txPort;
        if (inetAddress == null || i == 0) {
            return false;
        }
        tryProcessTaskEvent(cotEvent);
        Log.d(TAG, "Que Command" + cotEvent.toString());
        return uplinkBuffer(cotEvent.toString().getBytes(), inetAddress, i);
    }

    private boolean uplinkBuffer(byte[] bArr, InetAddress inetAddress, int i) {
        try {
            this.uplinkQueue.put(new DatagramPacket(bArr, bArr.length, inetAddress, i));
            return true;
        } catch (InterruptedException unused) {
            return false;
        }
    }

    public static CotEvent createWaypointCotEvent(String str, double d, double d2, double d3, double d4, double d5, int i) {
        CotEvent cotEvent = new CotEvent();
        cotEvent.setType(PD100EventType.BITS_MAP_POINT_WAYPOINT.toString());
        String str2 = str;
        cotEvent.setUID(str);
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CoordinatedTime addSeconds = coordinatedTime.addSeconds(i);
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(addSeconds);
        cotEvent.setHow("h-e");
        cotEvent.setPoint(new CotPoint(d, d2, d3, d4, d5));
        CotDetail cotDetail = new CotDetail();
        UasC2Event.addOrUpdateCotFlowtags(cotDetail, "uastool_operator");
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    public static CotEvent createWaypointCotEvent(RouteDrawPoint routeDrawPoint, double d, double d2, int i, String str, Integer num) {
        return createWaypointCotEvent(createWaypointUid(str, routeDrawPoint.getName(), num), Double.parseDouble(routeDrawPoint.getLat()), Double.parseDouble(routeDrawPoint.getLon()), Double.parseDouble(routeDrawPoint.getHae()), d, d2, i);
    }

    public static CotEvent createWaypointCotEvent(String str, GeoPoint geoPoint, int i) {
        CotEvent cotEvent = new CotEvent();
        cotEvent.setType(PD100EventType.BITS_MAP_POINT_WAYPOINT.toString());
        cotEvent.setUID(str);
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CoordinatedTime addSeconds = coordinatedTime.addSeconds(i);
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(addSeconds);
        cotEvent.setHow("h-e");
        cotEvent.setPoint(new CotPoint(geoPoint));
        CotDetail cotDetail = new CotDetail();
        UasC2Event.addOrUpdateCotFlowtags(cotDetail, "uastool_operator");
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    public static CotEvent createWaypointCotEvent(GeoPoint geoPoint, int i, String str, Integer num) {
        return createWaypointCotEvent(createWaypointUid(str, (String) null, num), geoPoint, i);
    }

    public static CotDetail createWaypointCotLink(String str) {
        CotDetail cotDetail = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail.setAttribute("relation", "t-o");
        cotDetail.setAttribute(UASTask.COTDETAIL_UID, str);
        cotDetail.setAttribute("type", PD100EventType.BITS_MAP_POINT_WAYPOINT.toString());
        return cotDetail;
    }

    public static CotDetail createWaypointCotComponentPartLink(String str) {
        CotDetail cotDetail = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail.setAttribute("relation", "c-p");
        cotDetail.setAttribute(UASTask.COTDETAIL_UID, str);
        cotDetail.setAttribute("type", PD100EventType.BITS_MAP_POINT_WAYPOINT.toString());
        return cotDetail;
    }

    public void uplinkWaypoint(RouteDrawPoint routeDrawPoint, double d, double d2, int i, String str, Integer num) {
        try {
            Log.d(TAG, "PD100Parser.uplinkWaypoint()");
            uplinkCotEvent(createWaypointCotEvent(routeDrawPoint, d, d2, i, str, num));
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkWaypoint() :", e);
        }
    }

    public void uplinkWaypoints(Collection<RouteDrawPoint> collection, double d, double d2, int i, String str) {
        int i2 = 0;
        for (RouteDrawPoint uplinkWaypoint : collection) {
            i2++;
            uplinkWaypoint(uplinkWaypoint, d, d2, i, str, Integer.valueOf(i2));
        }
    }

    public static List<CotDetail> createWaypointCotLinks(RouteDrawPoint routeDrawPoint, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (routeDrawPoint == null) {
            str2 = null;
        } else {
            str2 = routeDrawPoint.getName();
        }
        arrayList.add(createWaypointCotLink(createWaypointUid(str, str2, (Integer) null)));
        return arrayList;
    }

    public static List<CotDetail> createWaypointCotLinks(Collection<RouteDrawPoint> collection, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (RouteDrawPoint next : collection) {
            if (next == null) {
                str2 = null;
            } else {
                str2 = next.getName();
            }
            i++;
            arrayList.add(createWaypointCotLink(createWaypointUid(str, str2, Integer.valueOf(i))));
        }
        return arrayList;
    }

    public static List<CotDetail> createWaypointCotComponentPartLinks(Collection<RouteDrawPoint> collection, String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (RouteDrawPoint name : collection) {
            i++;
            arrayList.add(createWaypointCotComponentPartLink(createWaypointUid(str, name.getName(), Integer.valueOf(i))));
        }
        return arrayList;
    }

    public void uplinkWaypoint(GeoPoint geoPoint, int i, String str, Integer num) {
        try {
            Log.d(TAG, "PD100Parser.uplinkWaypoint()");
            uplinkCotEvent(createWaypointCotEvent(geoPoint, i, str, num));
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkWaypoint()", e);
        }
    }

    public void uplinkWaypoints(List<GeoPoint> list, int i, String str) {
        int i2 = 0;
        for (GeoPoint uplinkWaypoint : list) {
            i2++;
            uplinkWaypoint(uplinkWaypoint, i, str, Integer.valueOf(i2));
        }
    }

    public static List<CotDetail> createWaypointCotComponentPartLinks(List<GeoPoint> list, String str) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (GeoPoint next : list) {
            i++;
            arrayList.add(createWaypointCotComponentPartLink(createWaypointUid(str, (String) null, Integer.valueOf(i))));
        }
        return arrayList;
    }

    public static List<CotDetail> createWaypointCotLinks(GeoPoint geoPoint, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createWaypointCotLink(createWaypointUid(str, (String) null, (Integer) null)));
        return arrayList;
    }

    public static List<CotDetail> createWaypointCotLinks(List<GeoPoint> list, String str) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (GeoPoint next : list) {
            i++;
            arrayList.add(createWaypointCotLink(createWaypointUid(str, (String) null, Integer.valueOf(i))));
        }
        return arrayList;
    }

    public static List<CotDetail> createRouteCotLinks(String str) {
        CotDetail cotDetail = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail.setAttribute("relation", "t-o");
        cotDetail.setAttribute(UASTask.COTDETAIL_UID, str);
        cotDetail.setAttribute("type", PD100EventType.BITS_MAP_ROUTE.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(cotDetail);
        return arrayList;
    }

    public void uplinkRoute(String str, Collection<RouteDrawPoint> collection, double d, double d2, int i) {
        String str2 = str;
        try {
            Log.d(TAG, "PD100Parser.uplinkRoute()");
            String defaultRequestReplyUrl = getDefaultRequestReplyUrl();
            if (defaultRequestReplyUrl != null) {
                if (!defaultRequestReplyUrl.isEmpty()) {
                    uplinkWaypoints(collection, d, d2, i, str2 + ".");
                    String pD100EventType = PD100EventType.BITS_MAP_ROUTE.toString();
                    GeoPoint centerOfExtremes3D = centerOfExtremes3D(toGeoPoints(collection, d, d2), d, d2);
                    String callsign = getCallsign();
                    try {
                        uplinkCotEvent(UasC2Event.createCotEvent(pD100EventType, str, centerOfExtremes3D, callsign, defaultRequestReplyUrl, createWaypointCotComponentPartLinks(collection, str2 + "."), i));
                        return;
                    } catch (Exception e) {
                        e = e;
                        Log.e(TAG, "Exception in PD100Parser.uplinkRoute()", e);
                    }
                }
            }
            Log.w(TAG, "Task Request cannot be issued because UDP reply receiver not configured");
        } catch (Exception e2) {
            e = e2;
            Log.e(TAG, "Exception in PD100Parser.uplinkRoute()", e);
        }
    }

    public void uplinkRoute(String str, List<GeoPoint> list, double d, double d2, int i) {
        String str2 = str;
        List<GeoPoint> list2 = list;
        try {
            Log.d(TAG, "PD100Parser.uplinkRoute()");
            String defaultRequestReplyUrl = getDefaultRequestReplyUrl();
            if (defaultRequestReplyUrl != null) {
                if (!defaultRequestReplyUrl.isEmpty()) {
                    uplinkWaypoints(list2, i, str + ".");
                    String pD100EventType = PD100EventType.BITS_MAP_ROUTE.toString();
                    GeoPoint centerOfExtremes3D = centerOfExtremes3D((GeoPoint[]) list2.toArray(new GeoPoint[0]), d, d2);
                    String callsign = getCallsign();
                    uplinkCotEvent(UasC2Event.createCotEvent(pD100EventType, str, centerOfExtremes3D, callsign, defaultRequestReplyUrl, createWaypointCotComponentPartLinks(list2, str + "."), i));
                    return;
                }
            }
            Log.w(TAG, "Task Request cannot be issued because UDP reply receiver not configured");
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkRoute()", e);
        }
    }

    public void uplinkTask(PD100EventType pD100EventType, String str, GeoPoint geoPoint, List<CotDetail> list, int i) {
        try {
            Log.d(TAG, "PD100Parser.uplinkTask()");
            String defaultRequestReplyUrl = getDefaultRequestReplyUrl();
            if (defaultRequestReplyUrl != null) {
                if (!defaultRequestReplyUrl.isEmpty()) {
                    uplinkCotEvent(UasC2Event.createCotEvent(pD100EventType.toString(), str, geoPoint, getCallsign(), defaultRequestReplyUrl, list, i));
                    return;
                }
            }
            Log.w(TAG, "Task Request cannot be issued because UDP reply receiver not configured");
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkTask()", e);
        }
    }

    public void uplinkTask(PD100EventType pD100EventType, String str, GeoPoint geoPoint, int i) {
        uplinkTask(pD100EventType, str, geoPoint, (List<CotDetail>) null, i);
    }

    public void uplinkWaypointAndTask(PD100EventType pD100EventType, String str, RouteDrawPoint routeDrawPoint, double d, double d2, int i) {
        String str2 = str;
        try {
            Log.d(TAG, "PD100Parser.uplinkWaypointAndTask()");
            uplinkWaypoint(routeDrawPoint, d, d2, i, str2 + ".", (Integer) null);
            GeoPoint geoPoint = toGeoPoint(routeDrawPoint, d, d2);
            uplinkTask(pD100EventType, str, geoPoint, createWaypointCotLinks(routeDrawPoint, str2 + "."), i);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkWaypointAndTask()", e);
        }
    }

    public void uplinkWaypointAndTask(PD100EventType pD100EventType, String str, GeoPoint geoPoint, double d, double d2, int i) {
        try {
            Log.d(TAG, "PD100Parser.uplinkWaypointAndTask()");
            uplinkWaypoint(geoPoint, i, str + ".", (Integer) null);
            uplinkTask(pD100EventType, str, geoPoint, createWaypointCotLinks(geoPoint, str + "."), i);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkWaypointAndTask()", e);
        }
    }

    public void uplinkWaypointsAndTask(PD100EventType pD100EventType, String str, Collection<RouteDrawPoint> collection, double d, double d2, int i) {
        String str2 = str;
        try {
            Log.d(TAG, "PD100Parser.uplinkWaypointsAndTask()");
            uplinkWaypoints(collection, d, d2, i, str2 + ".");
            GeoPoint centerOfExtremes3D = centerOfExtremes3D(toGeoPoints(collection, d, d2), d, d2);
            uplinkTask(pD100EventType, str, centerOfExtremes3D, createWaypointCotLinks(collection, str2 + "."), i);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkWaypointsAndTask()", e);
        }
    }

    public void uplinkRouteTask(PD100EventType pD100EventType, String str, String str2, GeoPoint geoPoint, int i) {
        try {
            Log.d(TAG, "PD100Parser.uplinkRouteTask()");
            uplinkTask(pD100EventType, str, geoPoint, createRouteCotLinks(str2), i);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkRouteTask()", e);
        }
    }

    public void uplinkRouteAndTask(PD100EventType pD100EventType, String str, String str2, Collection<RouteDrawPoint> collection, double d, double d2, int i) {
        try {
            Log.d(TAG, "PD100Parser.uplinkRouteAndTask()");
            uplinkRoute(str2, collection, d, d2, i);
            uplinkRouteTask(pD100EventType, str, str2, centerOfExtremes3D(toGeoPoints(collection, d, d2), d, d2), i);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkRouteAndTask()", e);
        }
    }

    public void uplinkRouteAndTask(PD100EventType pD100EventType, String str, String str2, List<GeoPoint> list, double d, double d2, int i) {
        List<GeoPoint> list2 = list;
        try {
            Log.d(TAG, "PD100Parser.uplinkRouteAndTask()");
            if (list2 != null) {
                if (list.size() != 0) {
                    uplinkRoute(str2, list, d, d2, i);
                    uplinkRouteTask(pD100EventType, str, str2, centerOfExtremes3D((GeoPoint[]) list.toArray(new GeoPoint[0]), d, d2), i);
                    return;
                }
            }
            Log.e(TAG, "PD100Parser.uplinkRouteAndTask - No route checkpoints");
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.uplinkRouteAndTask()", e);
        }
    }

    private void toast(String str) {
        UASToolDropDownReceiver.toast(str, 0);
    }

    public static String createWaypointUid(String str, String str2, Integer num) {
        if (str2 == null || str2.isEmpty()) {
            if (num == null) {
                str2 = "WPT";
            } else {
                str2 = "WPT." + String.format(Locale.US, "%02d", new Object[]{num});
            }
        }
        if (str == null || str.isEmpty()) {
            return str2;
        }
        return str + str2;
    }

    public GeoPoint toGeoPoint(RouteDrawPoint routeDrawPoint, double d, double d2) {
        try {
            return new GeoPoint(Double.parseDouble(routeDrawPoint.getLat()), Double.parseDouble(routeDrawPoint.getLon()), Double.parseDouble(routeDrawPoint.getHae()), d, d2);
        } catch (Exception unused) {
            return null;
        }
    }

    public GeoPoint[] toGeoPoints(Collection<RouteDrawPoint> collection, double d, double d2) {
        GeoPoint[] geoPointArr = new GeoPoint[collection.size()];
        int i = 0;
        for (RouteDrawPoint geoPoint : collection) {
            int i2 = i + 1;
            try {
                geoPointArr[i] = toGeoPoint(geoPoint, d, d2);
            } catch (Exception unused) {
            }
            i = i2;
        }
        return geoPointArr;
    }

    public static GeoPoint centerOfExtremes3D(GeoPoint[] geoPointArr, double d, double d2) {
        GeoPoint[] geoPointArr2 = geoPointArr;
        int[] findExtremes = GeoCalculations.findExtremes(geoPointArr2, 0, geoPointArr2.length);
        GeoPoint geoPoint = geoPointArr2[findExtremes[3]];
        GeoPoint geoPoint2 = geoPointArr2[findExtremes[1]];
        GeoPoint geoPoint3 = geoPointArr2[findExtremes[0]];
        GeoPoint geoPoint4 = geoPointArr2[findExtremes[2]];
        GeoPoint geoPoint5 = new GeoPoint(geoPoint.getLatitude() + ((geoPoint2.getLatitude() - geoPoint.getLatitude()) / 2.0d), geoPoint3.getLongitude() + ((geoPoint4.getLongitude() - geoPoint3.getLongitude()) / 2.0d));
        double ce = geoPoint5.distanceTo(geoPoint) + geoPoint.getCE() != Double.NaN ? geoPoint.getCE() : d;
        double ce2 = geoPoint5.distanceTo(geoPoint2) + geoPoint2.getCE() != Double.NaN ? geoPoint2.getCE() : d;
        double ce3 = geoPoint5.distanceTo(geoPoint3) + geoPoint3.getCE() != Double.NaN ? geoPoint3.getCE() : d;
        double ce4 = geoPoint5.distanceTo(geoPoint4) + geoPoint4.getCE() != Double.NaN ? geoPoint4.getCE() : d;
        GeoPoint geoPoint6 = null;
        GeoPoint geoPoint7 = null;
        for (GeoPoint geoPoint8 : geoPointArr2) {
            if (geoPoint7 == null || geoPoint8.getAltitude() < geoPoint7.getAltitude()) {
                geoPoint7 = geoPoint8;
            }
            if (geoPoint6 == null || geoPoint8.getAltitude() > geoPoint6.getAltitude()) {
                geoPoint6 = geoPoint8;
            }
        }
        double altitude = geoPoint7.getAltitude() + ((geoPoint6.getAltitude() - geoPoint7.getAltitude()) / 2.0d);
        return new GeoPoint(geoPoint5.getLatitude(), geoPoint5.getLongitude(), altitude, Math.max(Math.max(Math.max(ce, ce2), ce3), ce4), Math.max((altitude - geoPoint7.getAltitude()) - geoPoint7.getLE() != Double.NaN ? geoPoint7.getLE() : d2, (altitude + geoPoint6.getAltitude()) + geoPoint6.getLE() != Double.NaN ? geoPoint6.getLE() : d2));
    }

    private void testStatusQuery(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testStatusQuery()");
            uplinkTask(PD100EventType.TASK_STATUS_QUERY, str, geoPoint, 30);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testStatusQuery()", e);
        }
    }

    private void testCancel(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testCancel()");
            uplinkTask(PD100EventType.TASK_CANCEL, str, geoPoint, 30);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testCancel()", e);
        }
    }

    private void testRoute(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testRoute()");
            uplinkRoute(str, (Collection<RouteDrawPoint>) createFakeWaypoints(str, geoPoint), 20.0d, 40.0d, 30);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testRoute()", e);
        }
    }

    private void testISR(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testSurveillance()");
            List<RouteDrawPoint> createFakeWaypoints = createFakeWaypoints(str, geoPoint);
            uplinkWaypoints(createFakeWaypoints, 20.0d, 40.0d, 30, (String) null);
            uplinkTask(PD100EventType.TASK_ISR_VIDEO_EO, str, centerOfExtremes3D(toGeoPoints(createFakeWaypoints, 20.0d, 40.0d), 20.0d, 40.0d), createWaypointCotLinks((Collection<RouteDrawPoint>) createFakeWaypoints, (String) null), 30);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testSurveillance()", e);
        }
    }

    private void testRelocateToPoint(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testRelocateToPoint()");
            createFakeWaypoint(str, geoPoint, 1);
            uplinkTask(PD100EventType.TASK_RELOCATE, str, createFakeGeoPoint(geoPoint, 0), 300);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testRelocateToPoint()", e);
        }
    }

    private void testRelocateToWaypoint(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testRelocateToWaypoint()");
            uplinkWaypointAndTask(PD100EventType.TASK_RELOCATE, str, createFakeWaypoint(str, geoPoint, 1), 20.0d, 40.0d, 30);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testRelocateToWaypoint()", e);
        }
    }

    private void testRelocateViaWaypoints(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testRelocateViaWaypoints()");
            uplinkWaypointsAndTask(PD100EventType.TASK_RELOCATE, str, createFakeWaypoints(str, geoPoint), 20.0d, 40.0d, 30);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testRelocateViaWaypoints()", e);
        }
    }

    private void testRelocateViaRoute(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testRelocateViaRoute()");
            String str2 = str + ".Route";
            uplinkRouteAndTask(PD100EventType.TASK_RELOCATE, str, str2, (Collection<RouteDrawPoint>) createFakeWaypoints(str2, geoPoint), 20.0d, 40.0d, 30);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testRelocateViaRoute()", e);
        }
    }

    private void testRelocateViaRoutePoints(String str, GeoPoint geoPoint) {
        try {
            Log.d(TAG, "PD100Parser.testRelocateViaRoutePoints()");
            String str2 = str + ".Route";
            uplinkRouteAndTask(PD100EventType.TASK_RELOCATE, str, str2, createFakeGeoPoints(str2, geoPoint), 20.0d, 40.0d, 300);
        } catch (Exception e) {
            Log.e(TAG, "Exception in PD100Parser.testRelocateViaRoute()", e);
        }
    }

    private GeoPoint createFakeGeoPoint(GeoPoint geoPoint, int i) {
        double d = (double) i;
        double d2 = 9.000009000009E-4d * d;
        return new GeoPoint(geoPoint.getLatitude() + d2, geoPoint.getLongitude() + d2, geoPoint.getAltitude() + 50.0d + d);
    }

    private List<GeoPoint> createFakeGeoPoints(String str, GeoPoint geoPoint) {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 6; i++) {
            arrayList.add(createFakeGeoPoint(geoPoint, i));
        }
        return arrayList;
    }

    private RouteDrawPoint createFakeWaypoint(String str, GeoPoint geoPoint, int i) {
        double d = (double) i;
        double d2 = 9.000009000009E-4d * d;
        String createWaypointUid = createWaypointUid(str, (String) null, Integer.valueOf(i));
        String format = String.format(Locale.US, "%01.7f", new Object[]{Double.valueOf(geoPoint.getLatitude() + d2)});
        return new RouteDrawPoint(createWaypointUid, "Test Waypoint", format, String.format(Locale.US, "%01.7f", new Object[]{Double.valueOf(geoPoint.getLongitude() + d2)}), String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(geoPoint.getAltitude() + 50.0d + d)}), JsonValueConstants.VERSION);
    }

    private List<RouteDrawPoint> createFakeWaypoints(String str, GeoPoint geoPoint) {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 6; i++) {
            arrayList.add(createFakeWaypoint(str, geoPoint, i));
        }
        return arrayList;
    }

    private void uplinkTestMessage() {
        GeoPoint geoPoint;
        this.testCounter++;
        synchronized (this.uasC2Event) {
            geoPoint = this.uasC2Event.pdDetail != null ? new GeoPoint(this.uasC2Event.pdDetail.groundStationLocation) : null;
        }
        if (geoPoint != null) {
            if (this.testCounter == 15) {
                testRelocateViaRoutePoints("RELOCATE", geoPoint);
            }
            int i = this.testCounter;
        }
    }
}
