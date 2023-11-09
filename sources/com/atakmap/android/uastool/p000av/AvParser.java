package com.atakmap.android.uastool.p000av;

import android.os.Bundle;
import android.os.Handler;
import atakplugin.UASTool.adz;
import atakplugin.UASTool.bgr;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ao;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.p000av.PayloadBlock;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.utils.CaptureToStorage;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.comms.CommsMapComponent;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.GeoPointMetaData;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.autel.downloader.bean.DownloadTask;
import indago.serialization.JsonValueConstants;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

/* renamed from: com.atakmap.android.uastool.av.AvParser */
public class AvParser extends Thread {
    private static final short CRC_CCITT = 4129;
    private static final short PING_DATA = 8258;
    private static final byte START_FLAG = 35;
    private static final String TAG = "AvParser";
    private GeoPoint airframeLocation;
    private boolean cancelled = true;
    private final CaptureToStorage captureToStorage;
    private double climbRate;
    private long cornerUpdateTime;
    private double course;
    private double currentAlt;
    private FlightMode flightMode;
    private double flightTime;
    private final e gcsRoute;
    private boolean havePosition;
    private long lastUpdate;
    private double latCorner1;
    private double latCorner2;
    private double latCorner3;
    private double latCorner4;
    private final Object lockAirframeAndSensorLocation;
    private final Object lockMissionWaypoints;
    private final Object lockWaypoints;
    private double lonCorner1;
    private double lonCorner2;
    private double lonCorner3;
    private double lonCorner4;
    private double magneticDeviationRaw;
    private double magneticHeadingRaw;
    private final ByteBuffer messageBuffer;
    private MissionParameter missionParameter;
    private final HashMap<Integer, MissionWaypoint> missionWaypoints;
    private PayloadStatusFrame payloadStatusFrame;
    private double pitch;
    private double pitchRate;
    private MilitaryDesignation platformType;
    private final byte[] receiveData;
    private final DatagramPacket receivePacket;
    private AvReflector reflector;
    private double remainingCapacity;
    private double roll;
    private double rollRate;
    private Runnable routeSettled;

    /* renamed from: s */
    private DatagramSocket f8376s;
    private double sensorAzimuth;
    private double sensorElevation;
    private double sensorHFOV;
    private GeoPoint sensorLocation;
    private String sensorModel;
    private double sensorNorth;
    private double sensorRange;
    private double sensorRoll;
    private double sensorVFOV;
    private final double slope;
    private double speed;
    private String tailNumber;
    private GeoPoint targetLocation;
    private Waypoint targetWaypoint;
    private double temperature;
    private Timer timer;
    private double totalCapacity;
    private final e uavRoute;
    private String uid;
    private Handler updateSettled;
    private double voltage;
    private final HashMap<Waypoint, GeoPoint> waypoints;
    private boolean waypointsUpdated;
    private double windDirection;
    private double windSpeed;
    private double yaw;
    private double yawRate;

    /* renamed from: com.atakmap.android.uastool.av.AvParser$MessagePart */
    private enum MessagePart {
        FLAG1,
        FLAG2,
        ID,
        COUNT,
        DATA,
        CRC,
        PING,
        OTHER
    }

    /* renamed from: com.atakmap.android.uastool.av.AvParser$MilitaryDesignation */
    private enum MilitaryDesignation {
        FQM191,
        RQ11A,
        GU11,
        Puma,
        Wasp,
        AV_GENERIC;

        public static MilitaryDesignation fromInteger(int i) {
            if (i == 0) {
                return FQM191;
            }
            if (i == 1) {
                return RQ11A;
            }
            if (i == 2) {
                return GU11;
            }
            if (i == 3) {
                return Puma;
            }
            if (i != 4) {
                return AV_GENERIC;
            }
            return Wasp;
        }

        static MilitaryDesignation fromPlaneType(int i) {
            switch (i) {
                case 1:
                    return FQM191;
                case 2:
                case 5:
                    return RQ11A;
                case 3:
                    return GU11;
                case 4:
                case 8:
                    return Puma;
                case 6:
                    return Wasp;
                default:
                    return AV_GENERIC;
            }
        }
    }

    /* renamed from: com.atakmap.android.uastool.av.AvParser$FlightMode */
    private enum FlightMode {
        MAN,
        RATE,
        SPEED,
        ALT,
        NAV,
        HOME,
        LOITER,
        FOLLOW_ME,
        RESERVED;

        static FlightMode fromInteger(int i) {
            switch (i) {
                case 0:
                    return MAN;
                case 1:
                    return RATE;
                case 2:
                    return SPEED;
                case 3:
                    return ALT;
                case 4:
                    return NAV;
                case 5:
                    return HOME;
                case 6:
                    return LOITER;
                case 7:
                    return FOLLOW_ME;
                default:
                    return RESERVED;
            }
        }
    }

    /* renamed from: com.atakmap.android.uastool.av.AvParser$Waypoint */
    public enum Waypoint {
        HOME,
        A,
        B,
        C,
        D,
        E,
        LAND,
        O1,
        O2,
        O3,
        INVALID;

        static String getDescription(int i) {
            switch (i) {
                case 0:
                    return "Home";
                case 1:
                    return "Alpha";
                case 2:
                    return "Bravo";
                case 3:
                    return "Charlie";
                case 4:
                    return "Delta";
                case 5:
                    return "Echo";
                case 6:
                    return "Land";
                case 7:
                    return "Orbit 1";
                case 8:
                    return "Orbit 2";
                case 9:
                    return "Orbit 3";
                default:
                    return "Invalid";
            }
        }

        public static Waypoint fromInteger(int i) {
            switch (i) {
                case 0:
                    return HOME;
                case 1:
                    return A;
                case 2:
                    return B;
                case 3:
                    return C;
                case 4:
                    return D;
                case 5:
                    return E;
                case 6:
                    return LAND;
                case 7:
                    return O1;
                case 8:
                    return O2;
                case 9:
                    return O3;
                default:
                    return INVALID;
            }
        }
    }

    public String getTailNumber() {
        return this.tailNumber;
    }

    public AvParser(boolean z, AvReflector avReflector) {
        byte[] bArr = new byte[65536];
        this.receiveData = bArr;
        this.receivePacket = new DatagramPacket(bArr, bArr.length);
        this.lockAirframeAndSensorLocation = new Object();
        this.payloadStatusFrame = null;
        this.lockWaypoints = new Object();
        this.lockMissionWaypoints = new Object();
        this.latCorner1 = Double.NaN;
        this.lonCorner1 = Double.NaN;
        this.latCorner2 = Double.NaN;
        this.lonCorner2 = Double.NaN;
        this.latCorner3 = Double.NaN;
        this.lonCorner3 = Double.NaN;
        this.latCorner4 = Double.NaN;
        this.lonCorner4 = Double.NaN;
        this.cornerUpdateTime = 0;
        this.reflector = avReflector;
        CaptureToStorage captureToStorage2 = new CaptureToStorage("telemetry");
        this.captureToStorage = captureToStorage2;
        captureToStorage2.setCaptureToStorage(z);
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").setTimeZone(TimeZone.getTimeZone("GMT"));
        this.messageBuffer = ByteBuffer.allocate(bArr.length * 2);
        String str = "UAS-" + UASToolDropDownReceiver.getInstance().getCallsign();
        this.tailNumber = str;
        this.uid = str;
        this.havePosition = false;
        this.platformType = MilitaryDesignation.AV_GENERIC;
        this.airframeLocation = new GeoPoint(0.0d, 0.0d, Double.NaN, 0.0d, 0.0d);
        this.currentAlt = Double.NaN;
        this.flightMode = FlightMode.NAV;
        this.magneticHeadingRaw = 0.0d;
        this.magneticDeviationRaw = 0.0d;
        this.course = 0.0d;
        this.speed = 0.0d;
        this.slope = 0.0d;
        this.flightTime = 0.0d;
        this.windDirection = 0.0d;
        this.windSpeed = 0.0d;
        this.temperature = 0.0d;
        this.climbRate = 0.0d;
        this.targetWaypoint = Waypoint.HOME;
        this.targetLocation = new GeoPoint(0.0d, 0.0d, Double.NaN);
        this.sensorLocation = new GeoPoint(0.0d, 0.0d, Double.NaN);
        this.waypoints = new HashMap<>();
        this.missionWaypoints = new HashMap<>();
        this.waypointsUpdated = false;
        this.uavRoute = new e(MapView.getMapView(), "UAV Route", -65281, "uav", "uavRoute");
        this.gcsRoute = new e(MapView.getMapView(), "GCS Route", -16776961, "gcs", "gcsRoute");
        this.lastUpdate = 0;
    }

    public void debugMessage(byte[] bArr) {
        Log.d(TAG, "Initializating debug message.");
        this.messageBuffer.put(bArr);
        extractMessage();
    }

    public void cancel() {
        this.cancelled = true;
        synchronized (this) {
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            this.timer = null;
        }
        interrupt();
    }

    public void run() {
        synchronized (this) {
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            Timer timer3 = new Timer();
            this.timer = timer3;
            timer3.schedule(new TimerTask() {
                public void run() {
                    AvParser.this.sendCoT();
                }
            }, new Date(), 1000);
        }
        Log.d(TAG, "INFO: Listening for connection requests...");
        this.cancelled = false;
        AvMonitor avMonitor = (AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        int i = AvMonitor.TELEMETRY_PORT_DEFAULT;
        if (avMonitor != null) {
            List<UASItem> detectedUasList = avMonitor.getDetectedUasList();
            i = avMonitor.getTelemetryPort((detectedUasList == null || detectedUasList.isEmpty()) ? null : detectedUasList.get(0).getUid());
        }
        while (!this.cancelled) {
            try {
                if (this.f8376s == null) {
                    Log.d(TAG, "INFO: Establishing receive socket");
                    DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
                    this.f8376s = datagramSocket;
                    try {
                        datagramSocket.setReuseAddress(true);
                    } catch (Exception e) {
                        Log.d(TAG, "Exception: " + e.getMessage());
                    }
                    this.f8376s.bind(new InetSocketAddress(i));
                }
                this.receivePacket.setLength(this.receiveData.length);
                this.f8376s.receive(this.receivePacket);
                this.lastUpdate = System.currentTimeMillis();
                this.messageBuffer.put(Arrays.copyOfRange(this.receivePacket.getData(), 0, this.receivePacket.getLength()));
                this.captureToStorage.saveToFile(this.receivePacket);
                extractMessage();
            } catch (Exception e2) {
                Log.e(TAG, "Error: Exception encountered in receive socket", e2);
            }
        }
    }

    private boolean routesEqual(e eVar, e eVar2) {
        int numPoints = eVar.getNumPoints();
        if (numPoints != eVar2.getNumPoints()) {
            return false;
        }
        int i = 0;
        while (i < numPoints) {
            GeoPoint geoPoint = eVar.getPoint(i).get();
            GeoPoint geoPoint2 = eVar2.getPoint(i).get();
            if (geoPoint.getLatitude() == geoPoint2.getLatitude() && geoPoint.getLongitude() == geoPoint2.getLongitude() && geoPoint.getAltitude() == geoPoint2.getAltitude()) {
                Log.d("AVDebug", "Route Point [" + i + "] = (" + String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(geoPoint.getLatitude())}) + ", " + String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(geoPoint.getLongitude())}) + ")");
                Log.d("AVDebug", "Route Point [" + i + "] = (" + String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(geoPoint2.getLatitude())}) + ", " + String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(geoPoint2.getLongitude())}) + ")");
                i++;
            } else {
                Log.d("AVDebug", "Point at index " + i + " differs");
                return false;
            }
        }
        Log.d("AVDebug", "Routes appear identical");
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:871)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:128)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:858)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:128)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void extractMessage() {
        /*
            r28 = this;
            r1 = r28
            java.nio.ByteBuffer r0 = r1.messageBuffer
            r0.flip()
            com.atakmap.android.uastool.av.AvParser$MessagePart r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.OTHER
            r2 = 0
            r3 = r0
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000f:
            java.nio.ByteBuffer r7 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x053c }
            boolean r7 = r7.hasRemaining()     // Catch:{ IndexOutOfBoundsException -> 0x053c }
            if (r7 == 0) goto L_0x0530
            int r7 = r0 + 1
            com.atakmap.android.uastool.av.AvParser$MessagePart r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.PING     // Catch:{ IndexOutOfBoundsException -> 0x052c }
            if (r3 == r0) goto L_0x0024
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            byte r0 = r0.get()     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            int[] r8 = com.atakmap.android.uastool.p000av.AvParser.C11972.$SwitchMap$com$atakmap$android$uastool$av$AvParser$MessagePart     // Catch:{ IndexOutOfBoundsException -> 0x052c }
            int r9 = r3.ordinal()     // Catch:{ IndexOutOfBoundsException -> 0x052c }
            r8 = r8[r9]     // Catch:{ IndexOutOfBoundsException -> 0x052c }
            r9 = 35
            r10 = 1
            if (r8 == r10) goto L_0x051b
            r11 = 2
            if (r8 == r11) goto L_0x050c
            r12 = 3
            if (r8 == r12) goto L_0x0093
            r11 = 4
            if (r8 == r11) goto L_0x004e
            r11 = 5
            if (r8 == r11) goto L_0x003f
            goto L_0x004b
        L_0x003f:
            if (r0 != r9) goto L_0x004b
            com.atakmap.android.uastool.av.AvParser$MessagePart r3 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.FLAG1     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            int r0 = r0.position()     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            int r5 = r0 + -1
        L_0x004b:
            r12 = 0
            goto L_0x0526
        L_0x004e:
            java.lang.String r0 = "AvParser"
            java.lang.String r8 = "INFO: Ping packet"
            com.atakmap.coremap.log.Log.d(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ BufferUnderflowException -> 0x0088 }
            short r0 = r0.getShort()     // Catch:{ BufferUnderflowException -> 0x0088 }
            r8 = 8258(0x2042, float:1.1572E-41)
            if (r0 == r8) goto L_0x0085
            java.lang.String r8 = "AvParser"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ BufferUnderflowException -> 0x0088 }
            r9.<init>()     // Catch:{ BufferUnderflowException -> 0x0088 }
            java.lang.String r11 = "Received unexpected PING payload "
            r9.append(r11)     // Catch:{ BufferUnderflowException -> 0x0088 }
            java.util.Locale r11 = com.atakmap.coremap.locale.LocaleUtil.US     // Catch:{ BufferUnderflowException -> 0x0088 }
            java.lang.String r12 = "%02x"
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ BufferUnderflowException -> 0x0088 }
            java.lang.Short r0 = java.lang.Short.valueOf(r0)     // Catch:{ BufferUnderflowException -> 0x0088 }
            r10[r2] = r0     // Catch:{ BufferUnderflowException -> 0x0088 }
            java.lang.String r0 = java.lang.String.format(r11, r12, r10)     // Catch:{ BufferUnderflowException -> 0x0088 }
            r9.append(r0)     // Catch:{ BufferUnderflowException -> 0x0088 }
            java.lang.String r0 = r9.toString()     // Catch:{ BufferUnderflowException -> 0x0088 }
            com.atakmap.coremap.log.Log.w(r8, r0)     // Catch:{ BufferUnderflowException -> 0x0088 }
        L_0x0085:
            com.atakmap.android.uastool.av.AvParser$MessagePart r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.OTHER     // Catch:{ BufferUnderflowException -> 0x0088 }
            goto L_0x00a0
        L_0x0088:
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            r0.position(r5)     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            r0.compact()     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            return
        L_0x0093:
            int r6 = r0 + -6
            if (r6 >= 0) goto L_0x00a2
            java.lang.String r0 = "AvParser"
            java.lang.String r8 = "Invalid message count"
            com.atakmap.coremap.log.Log.d(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x052e }
            com.atakmap.android.uastool.av.AvParser$MessagePart r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.OTHER     // Catch:{ IndexOutOfBoundsException -> 0x052e }
        L_0x00a0:
            r3 = r0
            goto L_0x004b
        L_0x00a2:
            byte[] r8 = new byte[r6]     // Catch:{ IndexOutOfBoundsException -> 0x052c }
            java.nio.ByteBuffer r9 = r1.messageBuffer     // Catch:{ BufferUnderflowException -> 0x04ff }
            r9.get(r8)     // Catch:{ BufferUnderflowException -> 0x04ff }
            java.nio.ByteBuffer r9 = r1.messageBuffer     // Catch:{ BufferUnderflowException -> 0x04ff }
            short r9 = r9.getShort()     // Catch:{ BufferUnderflowException -> 0x04ff }
            int r12 = r6 + 2
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r12)     // Catch:{ BufferUnderflowException -> 0x04ff }
            r12.put(r4)     // Catch:{ BufferUnderflowException -> 0x04ff }
            r12.put(r0)     // Catch:{ BufferUnderflowException -> 0x04ff }
            r12.put(r8)     // Catch:{ BufferUnderflowException -> 0x04ff }
            byte[] r0 = r12.array()     // Catch:{ BufferUnderflowException -> 0x04ff }
            short r0 = calculateCRC(r0)     // Catch:{ BufferUnderflowException -> 0x04ff }
            if (r0 != r9) goto L_0x04ec
            r0 = -82
            if (r4 == r0) goto L_0x04d3
            r0 = -69
            if (r4 == r0) goto L_0x04b8
            r0 = -2
            if (r4 == r0) goto L_0x044e
            r0 = 66
            r11 = 4645040803167600640(0x4076800000000000, double:360.0)
            r13 = 0
            if (r4 == r0) goto L_0x03bf
            switch(r4) {
                case 49: goto L_0x0357;
                case 50: goto L_0x02f2;
                case 51: goto L_0x02a3;
                case 52: goto L_0x029e;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            switch(r4) {
                case 57: goto L_0x01c6;
                case 58: goto L_0x010c;
                case 59: goto L_0x029e;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            java.lang.String r0 = "AvParser"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{  }
            r8.<init>()     // Catch:{  }
            java.lang.String r9 = "Currently unsupported frameID = "
            r8.append(r9)     // Catch:{  }
            java.util.Locale r9 = com.atakmap.coremap.locale.LocaleUtil.US     // Catch:{  }
            java.lang.String r11 = "%02x"
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{  }
            java.lang.Byte r12 = java.lang.Byte.valueOf(r4)     // Catch:{  }
            r10[r2] = r12     // Catch:{  }
            java.lang.String r9 = java.lang.String.format(r9, r11, r10)     // Catch:{  }
            r8.append(r9)     // Catch:{  }
            java.lang.String r8 = r8.toString()     // Catch:{  }
            com.atakmap.coremap.log.Log.d(r0, r8)     // Catch:{  }
            goto L_0x029e
        L_0x010c:
            com.atakmap.android.uastool.av.MissionWaypoint r0 = new com.atakmap.android.uastool.av.MissionWaypoint     // Catch:{  }
            r0.<init>(r8)     // Catch:{  }
            java.lang.Object r8 = r1.lockMissionWaypoints     // Catch:{  }
            monitor-enter(r8)     // Catch:{  }
            java.util.HashMap<java.lang.Integer, com.atakmap.android.uastool.av.MissionWaypoint> r9 = r1.missionWaypoints     // Catch:{ all -> 0x01c3 }
            int r11 = r0.getWaypointType()     // Catch:{ all -> 0x01c3 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01c3 }
            r9.put(r11, r0)     // Catch:{ all -> 0x01c3 }
            monitor-exit(r8)     // Catch:{ all -> 0x01c3 }
            int r8 = r0.getWaypointType()     // Catch:{  }
            com.atakmap.android.uastool.av.AvParser$Waypoint r8 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.fromInteger(r8)     // Catch:{  }
            double r16 = r0.getAltitude()     // Catch:{  }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{  }
            double r12 = r0.getLatitudeDegrees()     // Catch:{  }
            double r14 = r0.getLongitudeDegrees()     // Catch:{  }
            r18 = 0
            r20 = 0
            r11 = r9
            r11.<init>(r12, r14, r16, r18, r20)     // Catch:{  }
            java.lang.Object r11 = r1.lockWaypoints     // Catch:{ Exception -> 0x01b9 }
            monitor-enter(r11)     // Catch:{ Exception -> 0x01b9 }
            java.util.HashMap<com.atakmap.android.uastool.av.AvParser$Waypoint, com.atakmap.coremap.maps.coords.GeoPoint> r0 = r1.waypoints     // Catch:{ all -> 0x01b6 }
            boolean r0 = r0.containsKey(r8)     // Catch:{ all -> 0x01b6 }
            if (r0 == 0) goto L_0x0159
            java.util.HashMap<com.atakmap.android.uastool.av.AvParser$Waypoint, com.atakmap.coremap.maps.coords.GeoPoint> r0 = r1.waypoints     // Catch:{ all -> 0x01b6 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x01b6 }
            com.atakmap.coremap.maps.coords.GeoPoint r0 = (com.atakmap.coremap.maps.coords.GeoPoint) r0     // Catch:{ all -> 0x01b6 }
            boolean r0 = r0.equals(r9)     // Catch:{ all -> 0x01b6 }
            if (r0 != 0) goto L_0x01b3
        L_0x0159:
            java.util.HashMap<com.atakmap.android.uastool.av.AvParser$Waypoint, com.atakmap.coremap.maps.coords.GeoPoint> r0 = r1.waypoints     // Catch:{ all -> 0x01b6 }
            boolean r0 = r0.containsKey(r8)     // Catch:{ all -> 0x01b6 }
            if (r0 != 0) goto L_0x017c
            java.lang.String r0 = "RouteDebug"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
            r12.<init>()     // Catch:{ all -> 0x01b6 }
            java.lang.String r13 = "Waypoint collection does not currently include "
            r12.append(r13)     // Catch:{ all -> 0x01b6 }
            java.lang.String r13 = r8.name()     // Catch:{ all -> 0x01b6 }
            r12.append(r13)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01b6 }
            com.atakmap.coremap.log.Log.d(r0, r12)     // Catch:{ all -> 0x01b6 }
            goto L_0x01ac
        L_0x017c:
            java.lang.String r0 = "RouteDebug"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
            r12.<init>()     // Catch:{ all -> 0x01b6 }
            java.lang.String r13 = "Current "
            r12.append(r13)     // Catch:{ all -> 0x01b6 }
            java.lang.String r13 = r8.name()     // Catch:{ all -> 0x01b6 }
            r12.append(r13)     // Catch:{ all -> 0x01b6 }
            java.lang.String r13 = " "
            r12.append(r13)     // Catch:{ all -> 0x01b6 }
            java.util.HashMap<com.atakmap.android.uastool.av.AvParser$Waypoint, com.atakmap.coremap.maps.coords.GeoPoint> r13 = r1.waypoints     // Catch:{ all -> 0x01b6 }
            java.lang.Object r13 = r13.get(r8)     // Catch:{ all -> 0x01b6 }
            r12.append(r13)     // Catch:{ all -> 0x01b6 }
            java.lang.String r13 = " => "
            r12.append(r13)     // Catch:{ all -> 0x01b6 }
            r12.append(r9)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01b6 }
            com.atakmap.coremap.log.Log.d(r0, r12)     // Catch:{ all -> 0x01b6 }
        L_0x01ac:
            java.util.HashMap<com.atakmap.android.uastool.av.AvParser$Waypoint, com.atakmap.coremap.maps.coords.GeoPoint> r0 = r1.waypoints     // Catch:{ all -> 0x01b6 }
            r0.put(r8, r9)     // Catch:{ all -> 0x01b6 }
            r1.waypointsUpdated = r10     // Catch:{ all -> 0x01b6 }
        L_0x01b3:
            monitor-exit(r11)     // Catch:{ all -> 0x01b6 }
            goto L_0x029e
        L_0x01b6:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x01b6 }
            throw r0     // Catch:{ Exception -> 0x01b9 }
        L_0x01b9:
            r0 = move-exception
            java.lang.String r8 = "AvParser"
            java.lang.String r9 = "Exception encountered"
            com.atakmap.coremap.log.Log.e(r8, r9, r0)     // Catch:{  }
            goto L_0x029e
        L_0x01c3:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x01c3 }
            throw r0     // Catch:{  }
        L_0x01c6:
            com.atakmap.android.uastool.av.MissionParameter r0 = new com.atakmap.android.uastool.av.MissionParameter     // Catch:{  }
            r0.<init>(r8)     // Catch:{  }
            r1.missionParameter = r0     // Catch:{  }
            boolean r0 = r0.isInitialized()     // Catch:{  }
            if (r0 == 0) goto L_0x029e
            java.lang.Object r8 = r1.lockWaypoints     // Catch:{  }
            monitor-enter(r8)     // Catch:{  }
            boolean r0 = r1.waypointsUpdated     // Catch:{ all -> 0x029b }
            if (r0 == 0) goto L_0x0299
            java.lang.String r0 = "RouteDebug"
            java.lang.String r9 = "GCS Route has been updated..."
            com.atakmap.coremap.log.Log.d(r0, r9)     // Catch:{ all -> 0x029b }
            com.atakmap.android.routes.e r0 = r1.gcsRoute     // Catch:{ all -> 0x029b }
            r0.clear()     // Catch:{ all -> 0x029b }
            r0 = 0
        L_0x01e7:
            r9 = 9
            if (r0 > r9) goto L_0x0299
            java.util.HashMap<com.atakmap.android.uastool.av.AvParser$Waypoint, com.atakmap.coremap.maps.coords.GeoPoint> r9 = r1.waypoints     // Catch:{ all -> 0x029b }
            com.atakmap.android.uastool.av.AvParser$Waypoint r11 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.fromInteger(r0)     // Catch:{ all -> 0x029b }
            boolean r9 = r9.containsKey(r11)     // Catch:{ all -> 0x029b }
            if (r9 == 0) goto L_0x0293
            java.util.HashMap<com.atakmap.android.uastool.av.AvParser$Waypoint, com.atakmap.coremap.maps.coords.GeoPoint> r9 = r1.waypoints     // Catch:{ all -> 0x029b }
            com.atakmap.android.uastool.av.AvParser$Waypoint r11 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.fromInteger(r0)     // Catch:{ all -> 0x029b }
            java.lang.Object r9 = r9.get(r11)     // Catch:{ all -> 0x029b }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = (com.atakmap.coremap.maps.coords.GeoPoint) r9     // Catch:{ all -> 0x029b }
            com.atakmap.coremap.maps.coords.GeoPointMetaData r11 = com.atakmap.coremap.maps.coords.GeoPointMetaData.wrap(r9)     // Catch:{ all -> 0x029b }
            com.atakmap.android.uastool.av.AvParser$Waypoint r12 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.fromInteger(r0)     // Catch:{ all -> 0x029b }
            java.lang.String r12 = r12.name()     // Catch:{ all -> 0x029b }
            com.atakmap.android.maps.ao r11 = com.atakmap.android.routes.e.a(r11, r12)     // Catch:{ all -> 0x029b }
            r11.setVisible(r2)     // Catch:{ all -> 0x029b }
            com.atakmap.android.routes.e r12 = r1.gcsRoute     // Catch:{ all -> 0x029b }
            r12.addMarker(r11)     // Catch:{ all -> 0x029b }
            com.atakmap.android.routes.e r12 = r1.gcsRoute     // Catch:{ all -> 0x029b }
            r12.setVisible(r2)     // Catch:{ all -> 0x029b }
            com.atakmap.android.uastool.av.AvParser$Waypoint r12 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.fromInteger(r0)     // Catch:{ all -> 0x029b }
            java.lang.String r12 = r12.name()     // Catch:{ all -> 0x029b }
            r11.setTitle(r12)     // Catch:{ all -> 0x029b }
            java.lang.String r12 = "callsign"
            com.atakmap.android.uastool.av.AvParser$Waypoint r13 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.fromInteger(r0)     // Catch:{ all -> 0x029b }
            java.lang.String r13 = r13.name()     // Catch:{ all -> 0x029b }
            r11.setMetaString(r12, r13)     // Catch:{ all -> 0x029b }
            java.lang.String r12 = "RouteDebug"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x029b }
            r13.<init>()     // Catch:{ all -> 0x029b }
            java.lang.String r14 = "GCS Route ["
            r13.append(r14)     // Catch:{ all -> 0x029b }
            r13.append(r0)     // Catch:{ all -> 0x029b }
            java.lang.String r14 = "] = "
            r13.append(r14)     // Catch:{ all -> 0x029b }
            java.lang.String r11 = r11.getTitle()     // Catch:{ all -> 0x029b }
            r13.append(r11)     // Catch:{ all -> 0x029b }
            java.lang.String r11 = " : ("
            r13.append(r11)     // Catch:{ all -> 0x029b }
            java.lang.String r11 = "%1.6f"
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ all -> 0x029b }
            double r15 = r9.getLatitude()     // Catch:{ all -> 0x029b }
            java.lang.Double r15 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x029b }
            r14[r2] = r15     // Catch:{ all -> 0x029b }
            java.lang.String r11 = java.lang.String.format(r11, r14)     // Catch:{ all -> 0x029b }
            r13.append(r11)     // Catch:{ all -> 0x029b }
            java.lang.String r11 = ", "
            r13.append(r11)     // Catch:{ all -> 0x029b }
            java.lang.String r11 = "%1.6f"
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ all -> 0x029b }
            double r15 = r9.getLongitude()     // Catch:{ all -> 0x029b }
            java.lang.Double r9 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x029b }
            r14[r2] = r9     // Catch:{ all -> 0x029b }
            java.lang.String r9 = java.lang.String.format(r11, r14)     // Catch:{ all -> 0x029b }
            r13.append(r9)     // Catch:{ all -> 0x029b }
            java.lang.String r9 = ")"
            r13.append(r9)     // Catch:{ all -> 0x029b }
            java.lang.String r9 = r13.toString()     // Catch:{ all -> 0x029b }
            com.atakmap.coremap.log.Log.d(r12, r9)     // Catch:{ all -> 0x029b }
        L_0x0293:
            r1.waypointsUpdated = r2     // Catch:{ all -> 0x029b }
            int r0 = r0 + 1
            goto L_0x01e7
        L_0x0299:
            monitor-exit(r8)     // Catch:{ all -> 0x029b }
            goto L_0x029e
        L_0x029b:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x029b }
            throw r0     // Catch:{  }
        L_0x029e:
            r16 = r3
            r12 = 0
            goto L_0x04e9
        L_0x02a3:
            com.atakmap.android.uastool.av.GPSFrame r0 = new com.atakmap.android.uastool.av.GPSFrame     // Catch:{  }
            r0.<init>(r8)     // Catch:{  }
            double r8 = r0.getMagneticDeviationRaw()     // Catch:{  }
            r1.magneticDeviationRaw = r8     // Catch:{  }
            double r8 = r0.getCourse()     // Catch:{  }
            r1.course = r8     // Catch:{  }
            double r8 = r0.getSpeed()     // Catch:{  }
            r1.speed = r8     // Catch:{  }
            double r8 = r0.getClimbRate()     // Catch:{  }
            r1.climbRate = r8     // Catch:{  }
            double r8 = r1.currentAlt     // Catch:{  }
            boolean r8 = com.atakmap.coremap.maps.coords.GeoPoint.isAltitudeValid(r8)     // Catch:{  }
            if (r8 == 0) goto L_0x02cb
            double r8 = r1.currentAlt     // Catch:{  }
            goto L_0x02cf
        L_0x02cb:
            double r8 = r0.getAltitude()     // Catch:{  }
        L_0x02cf:
            r16 = r8
            java.lang.Object r8 = r1.lockAirframeAndSensorLocation     // Catch:{  }
            monitor-enter(r8)     // Catch:{  }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x02ef }
            double r12 = r0.getLatitude()     // Catch:{ all -> 0x02ef }
            double r14 = r0.getLongitude()     // Catch:{ all -> 0x02ef }
            r18 = 0
            r20 = 0
            r11 = r9
            r11.<init>(r12, r14, r16, r18, r20)     // Catch:{ all -> 0x02ef }
            r1.airframeLocation = r9     // Catch:{ all -> 0x02ef }
            monitor-exit(r8)     // Catch:{ all -> 0x02ef }
            r28.calculateHeading()     // Catch:{  }
            r1.havePosition = r10     // Catch:{  }
            goto L_0x029e
        L_0x02ef:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x02ef }
            throw r0     // Catch:{  }
        L_0x02f2:
            com.atakmap.android.uastool.av.DownlinkDataLR r0 = new com.atakmap.android.uastool.av.DownlinkDataLR     // Catch:{  }
            r0.<init>(r8)     // Catch:{  }
            int r8 = r0.getPlaneType()     // Catch:{  }
            com.atakmap.android.uastool.av.AvParser$MilitaryDesignation r8 = com.atakmap.android.uastool.p000av.AvParser.MilitaryDesignation.fromPlaneType(r8)     // Catch:{  }
            r1.platformType = r8     // Catch:{  }
            int r8 = r0.getFlightMode()     // Catch:{  }
            com.atakmap.android.uastool.av.AvParser$FlightMode r8 = com.atakmap.android.uastool.p000av.AvParser.FlightMode.fromInteger(r8)     // Catch:{  }
            r1.flightMode = r8     // Catch:{  }
            byte r8 = r0.getTargetWaypoint()     // Catch:{  }
            com.atakmap.android.uastool.av.AvParser$Waypoint r8 = com.atakmap.android.uastool.p000av.AvParser.Waypoint.fromInteger(r8)     // Catch:{  }
            r1.targetWaypoint = r8     // Catch:{  }
            double r8 = r0.getFlightTime()     // Catch:{  }
            r1.flightTime = r8     // Catch:{  }
            double r8 = r0.getWindSpeed()     // Catch:{  }
            r1.windSpeed = r8     // Catch:{  }
            double r8 = r0.getWindDirection()     // Catch:{  }
            r1.windDirection = r8     // Catch:{  }
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 >= 0) goto L_0x0337
            r13 = -4582834833314545664(0xc066800000000000, double:-180.0)
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 < 0) goto L_0x0337
            double r8 = r8 + r11
            r1.windDirection = r8     // Catch:{  }
        L_0x0337:
            double r8 = r0.getTemperature()     // Catch:{  }
            r1.temperature = r8     // Catch:{  }
            double r15 = r0.getTargetAltitude()     // Catch:{  }
            com.atakmap.coremap.maps.coords.GeoPoint r8 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{  }
            double r11 = r0.getTargetLatitude()     // Catch:{  }
            double r13 = r0.getTargetLongitude()     // Catch:{  }
            r17 = 0
            r19 = 0
            r10 = r8
            r10.<init>(r11, r13, r15, r17, r19)     // Catch:{  }
            r1.targetLocation = r8     // Catch:{  }
            goto L_0x029e
        L_0x0357:
            com.atakmap.android.uastool.av.DownlinkDataHR r0 = new com.atakmap.android.uastool.av.DownlinkDataHR     // Catch:{  }
            r0.<init>(r8)     // Catch:{  }
            double r8 = r0.getAltitude()     // Catch:{  }
            r1.currentAlt = r8     // Catch:{  }
            com.atakmap.coremap.maps.coords.GeoPoint r8 = r1.airframeLocation     // Catch:{  }
            boolean r8 = r8.isValid()     // Catch:{  }
            if (r8 == 0) goto L_0x0386
            com.atakmap.coremap.maps.coords.GeoPoint r8 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{  }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = r1.airframeLocation     // Catch:{  }
            double r16 = r9.getLatitude()     // Catch:{  }
            com.atakmap.coremap.maps.coords.GeoPoint r9 = r1.airframeLocation     // Catch:{  }
            double r18 = r9.getLongitude()     // Catch:{  }
            double r9 = r1.currentAlt     // Catch:{  }
            r22 = 0
            r24 = 0
            r15 = r8
            r20 = r9
            r15.<init>(r16, r18, r20, r22, r24)     // Catch:{  }
            r1.airframeLocation = r8     // Catch:{  }
        L_0x0386:
            double r8 = r0.getPitch()     // Catch:{  }
            r1.pitch = r8     // Catch:{  }
            double r8 = r0.getRoll()     // Catch:{  }
            r1.roll = r8     // Catch:{  }
            double r8 = r0.getYaw()     // Catch:{  }
            r1.yaw = r8     // Catch:{  }
            double r8 = r0.getPitchRate()     // Catch:{  }
            r1.pitchRate = r8     // Catch:{  }
            double r8 = r0.getRollRate()     // Catch:{  }
            r1.rollRate = r8     // Catch:{  }
            double r8 = r0.getYawRate()     // Catch:{  }
            r1.yawRate = r8     // Catch:{  }
            double r8 = r0.getMagHeadingRaw()     // Catch:{  }
            int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x029e
            r10 = 4618760047542080111(0x401921cac083126f, double:6.283)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x029e
            r1.magneticHeadingRaw = r8     // Catch:{  }
            goto L_0x029e
        L_0x03bf:
            com.atakmap.android.uastool.av.CenterFOV r0 = new com.atakmap.android.uastool.av.CenterFOV     // Catch:{ BufferUnderflowException -> 0x04ff }
            r0.<init>(r8)     // Catch:{ BufferUnderflowException -> 0x04ff }
            double r8 = r0.getHeading()     // Catch:{ BufferUnderflowException -> 0x04ff }
            int r15 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x03d3
            r16 = r3
            double r2 = r8 + r11
            r1.sensorAzimuth = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
            goto L_0x03d7
        L_0x03d3:
            r16 = r3
            r1.sensorAzimuth = r8     // Catch:{ BufferUnderflowException -> 0x0501 }
        L_0x03d7:
            double r2 = r0.getDepression()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r18 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r2 = r2 * r18
            r1.sensorElevation = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
            int r20 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r20 >= 0) goto L_0x040d
            java.lang.String r2 = "AvParser"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ BufferUnderflowException -> 0x0501 }
            r3.<init>()     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.String r13 = "SENSOR is pointed below the horizon "
            r3.append(r13)     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.String r13 = "%01.4f"
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ BufferUnderflowException -> 0x0501 }
            double r11 = r1.sensorElevation     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ BufferUnderflowException -> 0x0501 }
            r12 = 0
            r10[r12] = r11     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.String r10 = java.lang.String.format(r13, r10)     // Catch:{ BufferUnderflowException -> 0x0501 }
            r3.append(r10)     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.String r3 = r3.toString()     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.coremap.log.Log.d(r2, r3)     // Catch:{ BufferUnderflowException -> 0x0501 }
            goto L_0x040e
        L_0x040d:
            r12 = 0
        L_0x040e:
            double r2 = r0.getRoll()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.sensorRoll = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
            if (r15 >= 0) goto L_0x041b
            double r8 = r8 * r18
            r1.sensorNorth = r8     // Catch:{ BufferUnderflowException -> 0x0501 }
            goto L_0x0423
        L_0x041b:
            r2 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r2 = r2 - r8
            r1.sensorNorth = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
        L_0x0423:
            double r2 = r0.getRange()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.sensorRange = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
            double r22 = r0.getDted()     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.Object r2 = r1.lockAirframeAndSensorLocation     // Catch:{ BufferUnderflowException -> 0x0501 }
            monitor-enter(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.coremap.maps.coords.GeoPoint r3 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x044b }
            double r18 = r0.getLatitude()     // Catch:{ all -> 0x044b }
            double r20 = r0.getLongitude()     // Catch:{ all -> 0x044b }
            r24 = 0
            r26 = 0
            r17 = r3
            r17.<init>(r18, r20, r22, r24, r26)     // Catch:{ all -> 0x044b }
            r1.sensorLocation = r3     // Catch:{ all -> 0x044b }
            monitor-exit(r2)     // Catch:{ all -> 0x044b }
            r28.updateConnectedUas()     // Catch:{ BufferUnderflowException -> 0x0501 }
            goto L_0x04e9
        L_0x044b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x044b }
            throw r0     // Catch:{ BufferUnderflowException -> 0x0501 }
        L_0x044e:
            r16 = r3
            r12 = 0
            boolean r0 = com.atakmap.android.uastool.p000av.GCSMessage.hasXid(r4)     // Catch:{ BufferUnderflowException -> 0x0501 }
            if (r0 == 0) goto L_0x04e9
            int r0 = com.atakmap.android.uastool.p000av.GCSMessage.parseXid(r8, r6)     // Catch:{ BufferUnderflowException -> 0x0501 }
            if (r0 != r11) goto L_0x04e9
            com.atakmap.android.uastool.av.PayloadStatusFrame r0 = new com.atakmap.android.uastool.av.PayloadStatusFrame     // Catch:{ BufferUnderflowException -> 0x0501 }
            r0.<init>()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.payloadStatusFrame = r0     // Catch:{ BufferUnderflowException -> 0x0501 }
            byte[] r2 = java.util.Arrays.copyOfRange(r8, r10, r6)     // Catch:{ BufferUnderflowException -> 0x0501 }
            int r3 = r6 + -1
            r0.parseNative(r2, r3)     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadStatusFrame r0 = r1.payloadStatusFrame     // Catch:{ BufferUnderflowException -> 0x0501 }
            int r0 = r0.getNumberOfPayloads()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r2 = 0
        L_0x0474:
            if (r2 >= r0) goto L_0x04e9
            com.atakmap.android.uastool.av.PayloadStatusFrame r3 = r1.payloadStatusFrame     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadBlock r3 = r3.getPayload(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            boolean r3 = r3.getPower()     // Catch:{ BufferUnderflowException -> 0x0501 }
            if (r3 == 0) goto L_0x04b5
            com.atakmap.android.uastool.av.PayloadStatusFrame r3 = r1.payloadStatusFrame     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadBlock r3 = r3.getPayload(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            boolean r3 = r3.getVideo()     // Catch:{ BufferUnderflowException -> 0x0501 }
            if (r3 == 0) goto L_0x04b5
            com.atakmap.android.uastool.av.PayloadStatusFrame r3 = r1.payloadStatusFrame     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadBlock r3 = r3.getPayload(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            double r8 = r3.getHfov()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.sensorHFOV = r8     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadStatusFrame r3 = r1.payloadStatusFrame     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadBlock r3 = r3.getPayload(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            double r8 = r3.getVfov()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.sensorVFOV = r8     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadStatusFrame r3 = r1.payloadStatusFrame     // Catch:{ BufferUnderflowException -> 0x0501 }
            com.atakmap.android.uastool.av.PayloadBlock r3 = r3.getPayload(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.String r3 = r3.getModel()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.sensorModel = r3     // Catch:{ BufferUnderflowException -> 0x0501 }
            r28.updateConnectedUas()     // Catch:{ BufferUnderflowException -> 0x0501 }
        L_0x04b5:
            int r2 = r2 + 1
            goto L_0x0474
        L_0x04b8:
            r16 = r3
            r12 = 0
            com.atakmap.android.uastool.av.BatteryStatus r0 = new com.atakmap.android.uastool.av.BatteryStatus     // Catch:{ BufferUnderflowException -> 0x0501 }
            r0.<init>(r8)     // Catch:{ BufferUnderflowException -> 0x0501 }
            double r2 = r0.getTotalCapacity()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.totalCapacity = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
            double r2 = r0.getRemainingCapacity()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.remainingCapacity = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
            double r2 = r0.getVoltage()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.voltage = r2     // Catch:{ BufferUnderflowException -> 0x0501 }
            goto L_0x04e9
        L_0x04d3:
            r16 = r3
            r12 = 0
            com.atakmap.android.uastool.av.ComponentID r0 = new com.atakmap.android.uastool.av.ComponentID     // Catch:{ BufferUnderflowException -> 0x0501 }
            r0.<init>(r8)     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.lang.String r0 = r0.getTailNumber()     // Catch:{ BufferUnderflowException -> 0x0501 }
            boolean r2 = r0.isEmpty()     // Catch:{ BufferUnderflowException -> 0x0501 }
            if (r2 != 0) goto L_0x04e9
            r1.tailNumber = r0     // Catch:{ BufferUnderflowException -> 0x0501 }
            r1.uid = r0     // Catch:{ BufferUnderflowException -> 0x0501 }
        L_0x04e9:
            com.atakmap.android.uastool.av.AvParser$MessagePart r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.OTHER     // Catch:{ IndexOutOfBoundsException -> 0x052a }
            goto L_0x0525
        L_0x04ec:
            r16 = r3
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ BufferUnderflowException -> 0x0501 }
            int r2 = r5 + 1
            r0.position(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ BufferUnderflowException -> 0x0501 }
            int r2 = r0.capacity()     // Catch:{ BufferUnderflowException -> 0x0501 }
            r0.limit(r2)     // Catch:{ BufferUnderflowException -> 0x0501 }
            return
        L_0x04ff:
            r16 = r3
        L_0x0501:
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x052a }
            r0.position(r5)     // Catch:{ IndexOutOfBoundsException -> 0x052a }
            java.nio.ByteBuffer r0 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x052a }
            r0.compact()     // Catch:{ IndexOutOfBoundsException -> 0x052a }
            return
        L_0x050c:
            r16 = r3
            r12 = 0
            if (r0 != r11) goto L_0x0514
            com.atakmap.android.uastool.av.AvParser$MessagePart r2 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.PING     // Catch:{ IndexOutOfBoundsException -> 0x0519 }
            goto L_0x0516
        L_0x0514:
            com.atakmap.android.uastool.av.AvParser$MessagePart r2 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.COUNT     // Catch:{ IndexOutOfBoundsException -> 0x0519 }
        L_0x0516:
            r4 = r0
            r3 = r2
            goto L_0x0526
        L_0x0519:
            r4 = r0
            goto L_0x052a
        L_0x051b:
            r16 = r3
            r12 = 0
            if (r0 != r9) goto L_0x0523
            com.atakmap.android.uastool.av.AvParser$MessagePart r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.FLAG2     // Catch:{ IndexOutOfBoundsException -> 0x052a }
            goto L_0x0525
        L_0x0523:
            com.atakmap.android.uastool.av.AvParser$MessagePart r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.OTHER     // Catch:{ IndexOutOfBoundsException -> 0x052a }
        L_0x0525:
            r3 = r0
        L_0x0526:
            r0 = r7
            r2 = 0
            goto L_0x000f
        L_0x052a:
            r0 = r7
            goto L_0x0539
        L_0x052c:
            r16 = r3
        L_0x052e:
            r0 = r7
            goto L_0x053e
        L_0x0530:
            r16 = r3
            java.nio.ByteBuffer r2 = r1.messageBuffer     // Catch:{ IndexOutOfBoundsException -> 0x0539 }
            r2.compact()     // Catch:{ IndexOutOfBoundsException -> 0x0539 }
            goto L_0x05d4
        L_0x0539:
            r3 = r16
            goto L_0x053e
        L_0x053c:
            r16 = r3
        L_0x053e:
            java.lang.String r2 = "AvParser"
            java.lang.String r7 = "Index out of bounds!"
            com.atakmap.coremap.log.Log.w(r2, r7)
            java.lang.String r2 = "AvParser"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Message Count = "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.atakmap.coremap.log.Log.w(r2, r6)
            java.lang.String r2 = "AvParser"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "FrameID = "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.atakmap.coremap.log.Log.w(r2, r4)
            java.lang.String r2 = "AvParser"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Byte Count = "
            r4.append(r6)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.atakmap.coremap.log.Log.w(r2, r0)
            java.lang.String r0 = "AvParser"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Last Message = "
            r2.append(r4)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.atakmap.coremap.log.Log.w(r0, r2)
            java.lang.String r0 = "AvParser"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Message State = "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.atakmap.coremap.log.Log.w(r0, r2)
            java.lang.String r0 = "AvParser"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Message Position = "
            r2.append(r3)
            java.nio.ByteBuffer r3 = r1.messageBuffer
            int r3 = r3.position()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.atakmap.coremap.log.Log.w(r0, r2)
            java.nio.ByteBuffer r0 = r1.messageBuffer
            r0.compact()
        L_0x05d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.AvParser.extractMessage():void");
    }

    /* renamed from: com.atakmap.android.uastool.av.AvParser$2 */
    /* synthetic */ class C11972 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$av$AvParser$MessagePart;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.av.AvParser$MessagePart[] r0 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$av$AvParser$MessagePart = r0
                com.atakmap.android.uastool.av.AvParser$MessagePart r1 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.FLAG1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$MessagePart     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.av.AvParser$MessagePart r1 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.FLAG2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$MessagePart     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.av.AvParser$MessagePart r1 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.COUNT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$MessagePart     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.av.AvParser$MessagePart r1 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.PING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$av$AvParser$MessagePart     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.av.AvParser$MessagePart r1 = com.atakmap.android.uastool.p000av.AvParser.MessagePart.OTHER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.AvParser.C11972.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void sendCoT() {
        String str;
        String str2;
        long j;
        String str3;
        CotDetail cotDetail;
        String str4;
        CoordinatedTime coordinatedTime;
        long j2;
        String str5;
        CoordinatedTime coordinatedTime2 = new CoordinatedTime();
        if (this.havePosition) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastUpdate > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
                Log.d("AVDebug", "Too much time since last update " + (currentTimeMillis - this.lastUpdate));
                return;
            }
            int i = -100;
            try {
                AvMonitor avMonitor = (AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor();
                DDLHandler ddlHandler = avMonitor != null ? avMonitor.getDdlHandler() : null;
                if (ddlHandler != null) {
                    i = ddlHandler.getRssi();
                    str = ddlHandler.getUasCallsign();
                    str2 = ddlHandler.getUasCallsign();
                } else {
                    str2 = null;
                    str = null;
                }
                if (str == null || str.isEmpty()) {
                    str = this.tailNumber;
                }
                if (str2 == null || str2.isEmpty()) {
                    str2 = this.uid;
                }
                synchronized (this.lockWaypoints) {
                    if (!this.waypoints.isEmpty()) {
                        cotDetail = new CotDetail(UasC2Event.WaypointCollectionDetail.detailName);
                        int i2 = 0;
                        while (i2 <= 9) {
                            if (this.waypoints.containsKey(Waypoint.fromInteger(i2))) {
                                CotDetail cotDetail2 = new CotDetail(UasC2Event.WaypointDetail.detailName);
                                cotDetail2.setAttribute(UASTask.COTDETAIL_NAME, "Waypoint-" + Waypoint.fromInteger(i2).name());
                                cotDetail2.setAttribute("description", "point " + Waypoint.getDescription(i2));
                                CotDetail cotDetail3 = new CotDetail("point");
                                CotPoint cotPoint = new CotPoint(this.waypoints.get(Waypoint.fromInteger(i2)));
                                str5 = str;
                                j2 = currentTimeMillis;
                                cotDetail3.setAttribute(FlightLogger.LOCS_LATITUDE, String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLat())}));
                                cotDetail3.setAttribute(FlightLogger.LOCS_LONGITUDE, String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLon())}));
                                cotDetail3.setAttribute("hae", String.format(LocaleUtil.US, "%01.1f", new Object[]{Double.valueOf(cotPoint.getHae())}));
                                cotDetail3.setAttribute(UASPoint.COTDETAIL_CE, String.format(LocaleUtil.US, "%01.1f", new Object[]{Double.valueOf(cotPoint.getCe())}));
                                cotDetail3.setAttribute(UASPoint.COTDETAIL_LE, String.format(LocaleUtil.US, "%01.1f", new Object[]{Double.valueOf(cotPoint.getLe())}));
                                cotDetail2.addChild(cotDetail3);
                                cotDetail.addChild(cotDetail2);
                            } else {
                                j2 = currentTimeMillis;
                                str5 = str;
                            }
                            i2++;
                            str = str5;
                            currentTimeMillis = j2;
                        }
                        j = currentTimeMillis;
                        str3 = str;
                    } else {
                        j = currentTimeMillis;
                        str3 = str;
                        cotDetail = null;
                    }
                }
                String callsign = UASToolDropDownReceiver.getInstance().getCallsign();
                String str6 = (callsign == null || callsign.isEmpty()) ? str3 : callsign;
                String videoBroadcastDestinationUrl = UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl();
                CotEvent cotEvent = new CotEvent();
                cotEvent.setVersion("2.0");
                cotEvent.setUID(str2);
                cotEvent.setType(UASToolConstants.UAS_FIXED_TYPE);
                cotEvent.setTime(coordinatedTime2);
                cotEvent.setStart(coordinatedTime2);
                cotEvent.setStale(coordinatedTime2.addMilliseconds(3500));
                cotEvent.setHow("m-g");
                cotEvent.setQos("1-r-c");
                synchronized (this.lockAirframeAndSensorLocation) {
                    cotEvent.setPoint(new CotPoint(this.airframeLocation));
                }
                CotDetail cotDetail4 = new CotDetail();
                CotDetail cotDetail5 = new CotDetail("_flow-tags_");
                cotDetail5.setAttribute("GCS", coordinatedTime2.toString());
                cotDetail4.addChild(cotDetail5);
                CotDetail cotDetail6 = new CotDetail(UasC2Event.UASToolDetail.detailName);
                cotDetail6.setAttribute("extendedCot", "true");
                cotDetail4.addChild(cotDetail6);
                CotDetail cotDetail7 = new CotDetail(AvUASItem.DETAIL_TAG);
                cotDetail7.setAttribute("Flight_Mode", this.flightMode.name());
                synchronized (this.lockWaypoints) {
                    if (this.waypoints.containsKey(this.targetWaypoint)) {
                        cotDetail7.setAttribute("Target_Waypoint", "Waypoint-" + this.targetWaypoint.name());
                        coordinatedTime = coordinatedTime2;
                        str4 = str2;
                        cotDetail7.setAttribute("Range_To_Target", String.format(LocaleUtil.US, "%1.0f", new Object[]{Double.valueOf(getRange(this.waypoints.get(this.targetWaypoint)))}));
                    } else {
                        coordinatedTime = coordinatedTime2;
                        str4 = str2;
                    }
                }
                PayloadStatusFrame payloadStatusFrame2 = this.payloadStatusFrame;
                if (!(payloadStatusFrame2 == null || payloadStatusFrame2.getNumberOfPayloads() == 0)) {
                    for (int i3 = 0; i3 < this.payloadStatusFrame.getNumberOfPayloads(); i3++) {
                        PayloadBlock payload = this.payloadStatusFrame.getPayload(i3);
                        CotDetail cotDetail8 = new CotDetail("payload");
                        cotDetail8.setAttribute("model", payload.getModel());
                        cotDetail8.setAttribute("hfov", String.valueOf(payload.getHfov()));
                        cotDetail8.setAttribute("vfov", String.valueOf(payload.getVfov()));
                        if (payload.getZoomCapable()) {
                            cotDetail8.setAttribute("zoomindex", String.valueOf(payload.getZoomIndex()));
                            cotDetail8.setAttribute("zoomlimit", String.valueOf(payload.getZoomLimit()));
                        }
                        if (payload.getPanCapable()) {
                            cotDetail8.setAttribute("pan", String.valueOf(payload.getPan()));
                        }
                        if (payload.getTiltCapable()) {
                            cotDetail8.setAttribute("tilt", String.valueOf(payload.getTilt()));
                        }
                        if (payload.getType() == PayloadBlock.PayloadType.GIMBAL) {
                            cotDetail8.setAttribute("stow", String.valueOf(payload.getUnstow()));
                        }
                        cotDetail7.addChild(cotDetail8);
                    }
                }
                cotDetail4.addChild(cotDetail7);
                CotDetail cotDetail9 = new CotDetail(UasC2Event.ContactDetail.detailName);
                cotDetail9.setAttribute(FlightLogger.LOG_CALLSIGN, str6);
                cotDetail4.addChild(cotDetail9);
                CotDetail cotDetail10 = new CotDetail(UasC2Event.TrackDetail.detailName);
                cotDetail10.setAttribute("course", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(calculateHeading())}));
                cotDetail10.setAttribute(UASPoint.COTDETAIL_SPEED, String.format(LocaleUtil.US, "%01.2f", new Object[]{Double.valueOf(this.speed)}));
                cotDetail10.setAttribute("slope", "0.00");
                cotDetail10.setAttribute("eCourse", "5");
                cotDetail10.setAttribute("eSpeed", "0.1");
                cotDetail10.setAttribute("eSlope", "0.1");
                cotDetail4.addChild(cotDetail10);
                CotDetail cotDetail11 = new CotDetail(UasC2Event.SensorDetail.detailName);
                cotDetail11.setAttribute("azimuth", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.sensorAzimuth)}));
                cotDetail11.setAttribute("elevation", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.sensorElevation)}));
                cotDetail11.setAttribute(adz.f608a, String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.sensorRoll)}));
                cotDetail11.setAttribute("fov", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.sensorHFOV)}));
                cotDetail11.setAttribute("vfov", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.sensorVFOV)}));
                cotDetail11.setAttribute("north", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.sensorNorth)}));
                cotDetail11.setAttribute("version", "1.9");
                cotDetail11.setAttribute("type", "r-e");
                cotDetail11.setAttribute("model", this.sensorModel);
                cotDetail11.setAttribute("range", String.format(LocaleUtil.US, "%01.0f", new Object[]{Double.valueOf(this.sensorRange)}));
                cotDetail4.addChild(cotDetail11);
                CotDetail cotDetail12 = new CotDetail(UasC2Event.SpatialDetail.detailName);
                CotDetail cotDetail13 = new CotDetail(UasC2Event.SpatialDetail.AttitudeDetail.detailName);
                String str7 = videoBroadcastDestinationUrl;
                cotDetail13.setAttribute("pitch", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.pitch)}));
                cotDetail13.setAttribute(adz.f608a, String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.roll)}));
                cotDetail13.setAttribute("yaw", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.yaw)}));
                cotDetail13.setAttribute("ePitch", "10");
                cotDetail13.setAttribute("eRoll", "10");
                cotDetail13.setAttribute("eYaw", "10");
                cotDetail12.addChild(cotDetail13);
                CotDetail cotDetail14 = new CotDetail(UasC2Event.SpatialDetail.SpinDetail.detailName);
                cotDetail14.setAttribute("pitch", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.pitchRate)}));
                cotDetail14.setAttribute(adz.f608a, String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.rollRate)}));
                CotEvent cotEvent2 = cotEvent;
                cotDetail14.setAttribute("yaw", String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(this.yawRate)}));
                cotDetail14.setAttribute("ePitch", "2");
                cotDetail14.setAttribute("eRoll", "2");
                cotDetail14.setAttribute("eYaw", "2");
                cotDetail12.addChild(cotDetail14);
                cotDetail4.addChild(cotDetail12);
                CotDetail cotDetail15 = new CotDetail(UasC2Event.VehicleDetail.detailName);
                cotDetail15.setAttribute("batteryMaxCapacity", String.format(LocaleUtil.US, "%01.2f", new Object[]{Double.valueOf(this.totalCapacity)}));
                cotDetail15.setAttribute("batteryRemainingCapacity", String.format(LocaleUtil.US, "%01.2f", new Object[]{Double.valueOf(this.remainingCapacity)}));
                cotDetail15.setAttribute("flightTime", String.format(LocaleUtil.US, "%01.0f", new Object[]{Double.valueOf(this.flightTime)}));
                cotDetail15.setAttribute("type", this.platformType.toString());
                cotDetail15.setAttribute("voltage", String.format(LocaleUtil.US, "%01.2f", new Object[]{Double.valueOf(this.voltage)}));
                cotDetail15.setAttribute("typeTag", AvUASItem.DETAIL_TAG);
                cotDetail4.addChild(cotDetail15);
                CotDetail cotDetail16 = new CotDetail(UasC2Event.EnvironmentDetail.detailName);
                cotDetail16.setAttribute("windSpeed", String.format(LocaleUtil.US, "%01.1f", new Object[]{Double.valueOf(this.windSpeed)}));
                cotDetail16.setAttribute("windDirection", String.format(LocaleUtil.US, "%01.2f", new Object[]{Double.valueOf(this.windDirection)}));
                cotDetail16.setAttribute("temperature", String.format(LocaleUtil.US, "%01.2f", new Object[]{Double.valueOf(this.temperature)}));
                cotDetail4.addChild(cotDetail16);
                CotDetail cotDetail17 = new CotDetail(UasC2Event.RadioDetail.detailName);
                cotDetail17.setAttribute("rssi", String.valueOf(i));
                cotDetail4.addChild(cotDetail17);
                cotDetail4.addChild(cotDetail);
                synchronized (this.lockWaypoints) {
                    if (this.waypoints.containsKey(this.targetWaypoint)) {
                        CotDetail cotDetail18 = new CotDetail(UasC2Event.CommandedDataDetail.detailName);
                        cotDetail18.setAttribute("climbRate", String.format(LocaleUtil.US, "%01.2f", new Object[]{Double.valueOf(this.climbRate)}));
                        CotDetail cotDetail19 = new CotDetail("point");
                        CotPoint cotPoint2 = new CotPoint(this.waypoints.get(this.targetWaypoint));
                        cotDetail19.setAttribute(FlightLogger.LOCS_LATITUDE, String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(cotPoint2.getLat())}));
                        cotDetail19.setAttribute(FlightLogger.LOCS_LONGITUDE, String.format(LocaleUtil.US, "%01.6f", new Object[]{Double.valueOf(cotPoint2.getLon())}));
                        cotDetail19.setAttribute("hae", String.format(LocaleUtil.US, "%01.1f", new Object[]{Double.valueOf(cotPoint2.getHae())}));
                        cotDetail19.setAttribute(UASPoint.COTDETAIL_CE, String.format(LocaleUtil.US, "%01.1f", new Object[]{Double.valueOf(cotPoint2.getCe())}));
                        cotDetail19.setAttribute(UASPoint.COTDETAIL_LE, String.format(LocaleUtil.US, "%01.1f", new Object[]{Double.valueOf(cotPoint2.getLe())}));
                        cotDetail18.addChild(cotDetail19);
                        cotDetail4.addChild(cotDetail18);
                    }
                }
                CotDetail cotDetail20 = new CotDetail(UasC2Event.VideoDetail.detailName);
                if (this.reflector.isBroadcasting()) {
                    cotDetail20.setAttribute(DownloadTask.URL, str7);
                    cotDetail20.setAttribute(UasC2Event.SensorDetail.detailName, str6);
                    cotDetail20.setAttribute("spi", str6 + ".SPI1");
                }
                cotDetail4.addChild(cotDetail20);
                CotDetail cotDetail21 = new CotDetail(UasC2Event.LinkDetail.detailName);
                cotDetail21.setAttribute("relation", "p-p");
                cotDetail21.setAttribute(UASTask.COTDETAIL_UID, MapView.getDeviceUid());
                cotDetail21.setAttribute("type", "a-f-G-U-C");
                cotDetail4.addChild(cotDetail21);
                CotDetail cotDetail22 = new CotDetail(UasC2Event.PrecisionLocationDetail.detailName);
                cotDetail22.setAttribute("geopointsrc", "Calc");
                cotDetail22.setAttribute("altsrc", "DTED0");
                CotEvent cotEvent3 = cotEvent2;
                cotEvent3.setDetail(cotDetail4);
                if (UASToolDropDownReceiver.getInstance().broadcastCot()) {
                    CotMapComponent.h().b(cotEvent3);
                }
                CommsMapComponent.c().a(cotEvent3, (Bundle) null);
                synchronized (this.lockAirframeAndSensorLocation) {
                    if (!Double.isNaN(this.sensorLocation.getLatitude()) && !Double.isNaN(this.sensorLocation.getLongitude())) {
                        CotEvent cotEvent4 = new CotEvent();
                        cotEvent4.setVersion("2.0");
                        StringBuilder sb = new StringBuilder();
                        String str8 = str4;
                        sb.append(str8);
                        sb.append(".SPI1");
                        cotEvent4.setUID(sb.toString());
                        cotEvent4.setType("b-m-p-s-p-i");
                        CoordinatedTime coordinatedTime3 = coordinatedTime;
                        cotEvent4.setTime(coordinatedTime3);
                        cotEvent4.setStart(coordinatedTime3);
                        cotEvent4.setStale(coordinatedTime3.addMilliseconds(3500));
                        cotEvent4.setHow("m-g");
                        cotEvent4.setPoint(new CotPoint(this.sensorLocation));
                        CotDetail cotDetail23 = new CotDetail();
                        CotDetail cotDetail24 = new CotDetail(UasC2Event.ContactDetail.detailName);
                        cotDetail24.setAttribute(FlightLogger.LOG_CALLSIGN, str6 + ".SPI1");
                        cotDetail23.addChild(cotDetail24);
                        CotDetail cotDetail25 = new CotDetail(UasC2Event.LinkDetail.detailName);
                        cotDetail25.setAttribute("relation", "p-p");
                        cotDetail25.setAttribute(UASTask.COTDETAIL_UID, str8);
                        cotDetail25.setAttribute("type", UASToolConstants.UAS_FIXED_TYPE);
                        cotDetail23.addChild(cotDetail25);
                        if (j - this.cornerUpdateTime < 3000 && !Double.isNaN(this.latCorner1) && !Double.isNaN(this.lonCorner1) && !Double.isNaN(this.latCorner2) && !Double.isNaN(this.lonCorner2) && !Double.isNaN(this.latCorner3) && !Double.isNaN(this.lonCorner3) && !Double.isNaN(this.latCorner4) && !Double.isNaN(this.lonCorner4)) {
                            CotDetail cotDetail26 = new CotDetail("shape");
                            CotDetail cotDetail27 = new CotDetail("polyline");
                            cotDetail27.setAttribute("closed", "true");
                            CotDetail cotDetail28 = new CotDetail("vertex");
                            cotDetail28.setAttribute(FlightLogger.LOCS_LONGITUDE, String.valueOf(this.lonCorner1));
                            cotDetail28.setAttribute(FlightLogger.LOCS_LATITUDE, String.valueOf(this.latCorner1));
                            cotDetail28.setAttribute("hae", JsonValueConstants.VERSION);
                            cotDetail27.addChild(cotDetail28);
                            CotDetail cotDetail29 = new CotDetail("vertex");
                            cotDetail29.setAttribute(FlightLogger.LOCS_LONGITUDE, String.valueOf(this.lonCorner2));
                            cotDetail29.setAttribute(FlightLogger.LOCS_LATITUDE, String.valueOf(this.latCorner2));
                            cotDetail29.setAttribute("hae", JsonValueConstants.VERSION);
                            cotDetail27.addChild(cotDetail29);
                            CotDetail cotDetail30 = new CotDetail("vertex");
                            cotDetail30.setAttribute(FlightLogger.LOCS_LONGITUDE, String.valueOf(this.lonCorner3));
                            cotDetail30.setAttribute(FlightLogger.LOCS_LATITUDE, String.valueOf(this.latCorner3));
                            cotDetail30.setAttribute("hae", JsonValueConstants.VERSION);
                            cotDetail27.addChild(cotDetail30);
                            CotDetail cotDetail31 = new CotDetail("vertex");
                            cotDetail31.setAttribute(FlightLogger.LOCS_LONGITUDE, String.valueOf(this.lonCorner4));
                            cotDetail31.setAttribute(FlightLogger.LOCS_LATITUDE, String.valueOf(this.latCorner4));
                            cotDetail31.setAttribute("hae", JsonValueConstants.VERSION);
                            cotDetail27.addChild(cotDetail31);
                            cotDetail26.addChild(cotDetail27);
                            cotDetail23.addChild(cotDetail26);
                        }
                        CotDetail cotDetail32 = new CotDetail(UasC2Event.PrecisionLocationDetail.detailName);
                        cotDetail32.setAttribute("geopointsrc", "Calc");
                        cotDetail32.setAttribute("altsrc", "DTED0");
                        cotEvent4.setDetail(cotDetail23);
                        if (UASToolDropDownReceiver.getInstance().broadcastCot()) {
                            CotMapComponent.h().b(cotEvent4);
                        }
                        CommsMapComponent.c().a(cotEvent4, (Bundle) null);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "Exception encountered!", e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static short calculateCRC(byte[] bArr) {
        short s = 0;
        for (byte b : bArr) {
            short s2 = (short) (b << 8);
            for (short s3 = 8; s3 > 0; s3 = (short) (s3 - 1)) {
                s = (short) (((s2 ^ s) & bgr.f2674a) == 32768 ? (s << 1) ^ 4129 : s << 1);
                s2 = (short) (s2 << 1);
            }
        }
        return s;
    }

    private double getRange(GeoPoint geoPoint) {
        double atan2;
        synchronized (this.lockAirframeAndSensorLocation) {
            double latitude = ((geoPoint.getLatitude() - this.airframeLocation.getLatitude()) * 0.017453292519943295d) / 2.0d;
            double longitude = ((geoPoint.getLongitude() - this.airframeLocation.getLongitude()) * 0.017453292519943295d) / 2.0d;
            double sin = (Math.sin(latitude) * Math.sin(latitude)) + (Math.cos(this.airframeLocation.getLatitude() * 0.017453292519943295d) * Math.cos(geoPoint.getLatitude() * 0.017453292519943295d) * Math.sin(longitude) * Math.sin(longitude));
            atan2 = Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6371000.0d;
        }
        return atan2;
    }

    private double calculateHeading() {
        return GCSMessage.radiansToDegrees((this.magneticHeadingRaw + this.magneticDeviationRaw) % 6.283185307179586d);
    }

    public int getBatteryPercent() {
        double d = this.totalCapacity;
        if (d != 0.0d) {
            double d2 = this.remainingCapacity;
            if (d2 != 0.0d) {
                return (int) ((d2 / d) * 100.0d);
            }
        }
        double voltage2 = getVoltage();
        double d3 = 25.0d;
        if (this.platformType == MilitaryDesignation.Wasp) {
            d3 = 16.5d;
        }
        if (voltage2 >= d3) {
            return 100;
        }
        if (voltage2 >= d3 - 0.5d) {
            return 90;
        }
        if (voltage2 >= d3 - 1.0d) {
            return 80;
        }
        if (voltage2 >= d3 - 1.5d) {
            return 70;
        }
        if (voltage2 >= d3 - 2.0d) {
            return 60;
        }
        if (voltage2 >= d3 - 2.5d) {
            return 50;
        }
        if (voltage2 >= d3 - 3.0d) {
            return 40;
        }
        if (voltage2 >= d3 - 3.5d) {
            return 30;
        }
        if (voltage2 >= d3 - 4.0d) {
            return 20;
        }
        return voltage2 >= d3 - 5.0d ? 10 : 0;
    }

    public void showRoute() {
        this.uavRoute.clear();
        int numPoints = this.gcsRoute.getNumPoints();
        Log.d("RouteDebug", "Number of Points = " + numPoints);
        Log.d("RouteDebug", "Number of Waypoints = " + this.gcsRoute.h());
        synchronized (this.lockWaypoints) {
            for (int i = 0; i < numPoints; i++) {
                if (this.waypoints.containsKey(Waypoint.fromInteger(i))) {
                    GeoPoint geoPoint = this.waypoints.get(Waypoint.fromInteger(i));
                    ao a = e.a(GeoPointMetaData.wrap(geoPoint), Waypoint.fromInteger(i).name());
                    a.setVisible(false);
                    this.uavRoute.addMarker(a);
                    this.uavRoute.setVisible(false);
                    a.setTitle(Waypoint.fromInteger(i).name());
                    a.setMetaString(FlightLogger.LOG_CALLSIGN, Waypoint.fromInteger(i).name());
                    Log.d("RouteDebug", "UAV Route [" + i + "] = " + a.getTitle() + " : (" + String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(geoPoint.getLatitude())}) + ", " + String.format(LocaleUtil.US, "%1.6f", new Object[]{Double.valueOf(geoPoint.getLongitude())}) + ")");
                }
            }
        }
        this.uavRoute.setVisible(true);
        MapView.getMapView().getRootGroup().c("Route").d(this.uavRoute);
    }

    public void hideRoute() {
        ag c = MapView.getMapView().getRootGroup().c("Route");
        if (c != null) {
            this.uavRoute.setVisible(false);
            c.g(this.uavRoute);
            return;
        }
        Log.d(TAG, "UAV route group does not exist");
    }

    public void setCaptureToStorage(boolean z) {
        this.captureToStorage.setCaptureToStorage(z);
    }

    public GeoPoint getWaypointLocation(Waypoint waypoint) {
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d, Double.NaN, 0.0d, 0.0d);
        synchronized (this.lockWaypoints) {
            if (this.waypoints.containsKey(waypoint)) {
                geoPoint = this.waypoints.get(waypoint);
            }
        }
        return geoPoint;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.atakmap.android.uastool.p000av.MissionWaypoint getMissionWaypoint(int r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lockMissionWaypoints
            monitor-enter(r0)
            java.util.HashMap<java.lang.Integer, com.atakmap.android.uastool.av.MissionWaypoint> r1 = r3.missionWaypoints     // Catch:{ all -> 0x0028 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0025
            java.util.HashMap<java.lang.Integer, com.atakmap.android.uastool.av.MissionWaypoint> r1 = r3.missionWaypoints     // Catch:{ all -> 0x0028 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0028 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0025
            java.util.HashMap<java.lang.Integer, com.atakmap.android.uastool.av.MissionWaypoint> r1 = r3.missionWaypoints     // Catch:{ all -> 0x0028 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0028 }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ all -> 0x0028 }
            com.atakmap.android.uastool.av.MissionWaypoint r4 = (com.atakmap.android.uastool.p000av.MissionWaypoint) r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return r4
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            r4 = 0
            return r4
        L_0x0028:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.AvParser.getMissionWaypoint(int):com.atakmap.android.uastool.av.MissionWaypoint");
    }

    public MissionParameter getMissionParameter() {
        MissionParameter missionParameter2 = this.missionParameter;
        if (missionParameter2 == null || !missionParameter2.isInitialized()) {
            return null;
        }
        return this.missionParameter;
    }

    public void setReflector(AvReflector avReflector) {
        this.reflector = avReflector;
    }

    public double getSensorAzimuth() {
        return this.sensorAzimuth;
    }

    private double getVoltage() {
        return this.voltage;
    }

    public GeoPoint getSensorLocation() {
        return this.sensorLocation;
    }

    public void cornersUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        this.cornerUpdateTime = System.currentTimeMillis();
        this.latCorner1 = d;
        this.lonCorner1 = d2;
        this.latCorner2 = d3;
        this.lonCorner2 = d4;
        this.latCorner3 = d5;
        this.lonCorner3 = d6;
        this.latCorner4 = d7;
        this.lonCorner4 = d8;
        UASItem uasItem = this.reflector.getUasItem();
        if (uasItem != null) {
            uasItem.updateFOV(d, d2, d3, d4, d5, d6, d7, d8);
        }
    }

    public double getSensorElevation() {
        return this.sensorElevation;
    }

    public double getSensorVFOV() {
        return this.sensorVFOV;
    }

    private void updateConnectedUas() {
        AvUASItem avUASItem = (AvUASItem) this.reflector.getUasItem();
        avUASItem.setLocation(this.airframeLocation);
        avUASItem.setGimbalAngle(this.sensorAzimuth);
        avUASItem.setGimbalPitch(this.sensorElevation);
        avUASItem.setHFOV(this.sensorHFOV);
        avUASItem.setVFOV(this.sensorVFOV);
    }
}
