package com.atakmap.android.uastool;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Surface;
import atakplugin.UASTool.adz;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.MpegStreamHandler;
import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.CameraPreferenceFragment;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.uastool.utils.KLVMuxCallback;
import com.atakmap.android.uastool.utils.KLVQueue;
import com.atakmap.android.uastool.utils.UASItemUtils;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.x;
import com.atakmap.comms.CommsMapComponent;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.atakmap.map.elevation.ElevationManager;
import com.atakmap.math.PointD;
import com.autel.downloader.bean.DownloadTask;
import com.partech.mobilevid.g;
import com.partech.pgscmedia.consumers.StatusUpdateConsumer;
import indago.serialization.JsonValueConstants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public abstract class Reflector implements SharedPreferences.OnSharedPreferenceChangeListener, MpegStreamHandler.MpegStreamKLVListener, StatusUpdateConsumer, Runnable {
    private static final String HOME_COT_TYPE = "a-f-G";
    protected static final int ICON_GREEN = x.a.n.a();
    protected static final int ICON_RED = x.a.o.a();
    public static final int ICON_YELLOW = x.a.p.a();
    protected static final String SDP_DIR = "atak/uas/sdp";
    protected static final String SDP_FORMAT_STRING = "c=IN IP4 %s\nm=video %d RTP/AVP 96 \na=rtpmap:96 H%s/90000\n";
    private static final String SPOI_COT_TYPE = "b-m-p-s-p-i";
    protected static String TAG = "Reflector";
    private static final String UAV_COT_TYPE = "a-f-A-M-H-Q";
    private static final String UNKNOWN_COT_TYPE = "a-u-G";
    protected static String deviceUID = null;
    protected static double homeDTEDElevation = 0.0d;
    protected final int NOTIFICATION_ID;
    protected GeoPoint aircraftLocation;
    protected double[] aircraft_RPY;
    protected StatusUpdateListener currentStatusListener = null;
    protected PointD customFov;
    protected double hfov;
    protected boolean isBroadcasting = false;
    protected boolean isSendingCOTLocal = false;
    protected KLVQueue klvQueue;
    protected long lastSensorUpdate;
    protected long lastSpoiUpdate;
    protected String localUri;
    protected MpegStreamHandler mpegStreamPreview;
    protected final DecimalFormat noDecimalFormat = new DecimalFormat("#");
    protected final Context pluginContext;
    protected boolean previewActive = false;
    protected Surface previewSurface;
    protected double[] sensor_RPY;
    protected final SharedPreferences sharedPrefs;
    protected GeoPoint spoiLocation;
    protected String tailNumber;
    protected final UASItem uasItem;
    protected double vfov;

    public interface StatusUpdateListener {
        void onStartupFailed();

        void onStreamStarted();

        void onStreamStopped();
    }

    /* access modifiers changed from: protected */
    public void callsignChanged(String str) {
    }

    /* access modifiers changed from: protected */
    public void destinationAdapterChanged(String str) {
    }

    public void mediaStreamExtentsUpdate(long j, long j2) {
    }

    public String readyToBroadcast() {
        return null;
    }

    public abstract void startPreview(Surface surface);

    public String takePicture(String str, String str2, String str3) {
        return "takePicture not yet implemented.";
    }

    public boolean usesYUVTexture() {
        return true;
    }

    public boolean isBroadcasting() {
        return this.isBroadcasting;
    }

    public void run() {
        this.isBroadcasting = true;
    }

    public void stop() {
        this.isBroadcasting = false;
    }

    public void startPreview(Surface surface, String str, String str2) {
        startPreview(surface, str, str2, -1);
    }

    public void startPreview(Surface surface, String str, String str2, int i) {
        if (!this.previewActive) {
            this.previewSurface = surface;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            int port = parse.getPort();
            if (scheme == null || scheme.equals("") || scheme.equalsIgnoreCase("rtp")) {
                File createSDPFile = createSDPFile(host, port);
                if (createSDPFile != null) {
                    this.mpegStreamPreview = new MpegStreamHandler(createSDPFile, this.previewSurface);
                }
            } else if (scheme.equalsIgnoreCase("rtsp")) {
                this.mpegStreamPreview = new MpegStreamHandler(str, this.previewSurface);
            } else if (!scheme.equalsIgnoreCase("udp")) {
                this.mpegStreamPreview = null;
                UASToolDropDownReceiver.toast("Invalid URI: " + str, 1);
                StatusUpdateListener statusUpdateListener = this.currentStatusListener;
                if (statusUpdateListener != null) {
                    statusUpdateListener.onStartupFailed();
                }
                stopPreview();
                return;
            } else if (str2 == null || "System Default".equals(str2) || str2.isEmpty()) {
                this.mpegStreamPreview = new MpegStreamHandler(host, port, this.previewSurface);
            } else {
                this.mpegStreamPreview = new MpegStreamHandler(host, port, this.previewSurface, str2);
            }
            this.previewActive = true;
            this.mpegStreamPreview.setNetworkBufferMs(i);
            this.mpegStreamPreview.setMpegStreamKLVListener(this);
            this.mpegStreamPreview.setStatusUpdateConsumer(this);
            this.mpegStreamPreview.start();
            evalLocalUri(str2, str);
        }
    }

    /* access modifiers changed from: protected */
    public void setMpegStreamPreview(MpegStreamHandler mpegStreamHandler) {
        this.previewActive = true;
        this.mpegStreamPreview = mpegStreamHandler;
        mpegStreamHandler.setStatusUpdateConsumer(this);
        this.mpegStreamPreview.setMpegStreamKLVListener(this);
        this.mpegStreamPreview.start();
    }

    public void stopPreview() {
        MpegStreamHandler mpegStreamHandler = this.mpegStreamPreview;
        if (mpegStreamHandler != null && this.previewActive) {
            mpegStreamHandler.stop();
            this.mpegStreamPreview.setMpegStreamKLVListener((MpegStreamHandler.MpegStreamKLVListener) null);
            this.previewActive = false;
            StatusUpdateListener statusUpdateListener = this.currentStatusListener;
            if (statusUpdateListener != null) {
                statusUpdateListener.onStreamStopped();
            }
        }
    }

    protected Reflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem, int i) {
        int i2 = 0;
        this.pluginContext = context;
        this.sharedPrefs = sharedPreferences;
        this.uasItem = uASItem;
        this.NOTIFICATION_ID = i;
        this.lastSensorUpdate = 0;
        this.lastSpoiUpdate = 0;
        this.klvQueue = new KLVQueue();
        this.sensor_RPY = new double[3];
        this.aircraft_RPY = new double[3];
        while (true) {
            double[] dArr = this.sensor_RPY;
            if (i2 < dArr.length) {
                dArr[i2] = Double.NaN;
                this.aircraft_RPY[i2] = Double.NaN;
                i2++;
            } else {
                this.vfov = Double.NaN;
                this.hfov = Double.NaN;
                updateFov();
                return;
            }
        }
    }

    public String startLocalCOT() {
        this.isSendingCOTLocal = true;
        return null;
    }

    public boolean isSendingCOTLocal() {
        return this.isSendingCOTLocal;
    }

    public void stopLocalCOT() {
        this.isSendingCOTLocal = false;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith(UASToolPreferenceFragment.PREF_PREFIX)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1729298358:
                    if (str.equals(CameraPreferenceFragment.PREF_CAMERA_FOV_OVERIDE_VERTICAL)) {
                        c = 0;
                        break;
                    }
                    break;
                case -895553501:
                    if (str.equals(NetworkPreferenceFragment.PREF_VIDEO_DEST_ADAPTER)) {
                        c = 1;
                        break;
                    }
                    break;
                case 390435208:
                    if (str.equals(UASToolPreferenceFragment.PREF_CALLSIGN)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1478705144:
                    if (str.equals(CameraPreferenceFragment.PREF_CAMERA_FOV_OVERIDE_HORIZONTAL)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 3:
                    updateFov();
                    return;
                case 1:
                    destinationAdapterChanged(sharedPreferences.getString(NetworkPreferenceFragment.PREF_VIDEO_DEST_ADAPTER, (String) null));
                    return;
                case 2:
                    callsignChanged(sharedPreferences.getString(UASToolPreferenceFragment.PREF_CALLSIGN, (String) null));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sendNotification(String str, String str2, int i) {
        x.a().a(this.NOTIFICATION_ID, i, str, str2, (Intent) null, false);
    }

    public g getMuxCallback() {
        return new KLVMuxCallback(this.klvQueue);
    }

    public void destroy() {
        stopPreview();
        stopLocalCOT();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mpegStreamPreview;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isPreviewActive() {
        /*
            r1 = this;
            boolean r0 = r1.previewActive
            if (r0 == 0) goto L_0x0010
            com.atakmap.android.uastool.MpegStreamHandler r0 = r1.mpegStreamPreview
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.Reflector.isPreviewActive():boolean");
    }

    public UASItem getUasItem() {
        return this.uasItem;
    }

    public void cornersUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        UASItem uASItem = this.uasItem;
        if (uASItem != null) {
            uASItem.updateFOV(d, d2, d3, d4, d5, d6, d7, d8);
        }
    }

    public void sensorLocationUpdate(double d, double d2, double d3, String str) {
        double d4;
        this.lastSensorUpdate = System.currentTimeMillis();
        if (Double.isNaN(d3)) {
            ElevationManager.b bVar = new ElevationManager.b();
            bVar.e = 1;
            bVar.g = true;
            double d5 = d;
            double d6 = d2;
            double a = ElevationManager.a(d, d2, bVar);
            if (GeoPoint.isAltitudeValid(a)) {
                d4 = a;
                this.aircraftLocation = new GeoPoint(d, d2, d4);
                this.tailNumber = str;
            }
        } else {
            double d7 = d;
            double d8 = d2;
        }
        d4 = d3;
        this.aircraftLocation = new GeoPoint(d, d2, d4);
        this.tailNumber = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sensorSpoiUpdate(double r11, double r13, double r15, double r17) {
        /*
            r10 = this;
            r0 = r10
            long r1 = java.lang.System.currentTimeMillis()
            r0.lastSpoiUpdate = r1
            boolean r1 = java.lang.Double.isNaN(r15)
            if (r1 == 0) goto L_0x0025
            com.atakmap.map.elevation.ElevationManager$b r1 = new com.atakmap.map.elevation.ElevationManager$b
            r1.<init>()
            r2 = 1
            r1.e = r2
            r1.g = r2
            r4 = r11
            r6 = r13
            double r1 = com.atakmap.map.elevation.ElevationManager.a(r11, r13, r1)
            boolean r3 = com.atakmap.coremap.maps.coords.GeoPoint.isAltitudeValid(r1)
            if (r3 == 0) goto L_0x0027
            r8 = r1
            goto L_0x0028
        L_0x0025:
            r4 = r11
            r6 = r13
        L_0x0027:
            r8 = r15
        L_0x0028:
            boolean r1 = java.lang.Double.isNaN(r11)
            if (r1 != 0) goto L_0x003f
            boolean r1 = java.lang.Double.isNaN(r13)
            if (r1 != 0) goto L_0x003f
            com.atakmap.coremap.maps.coords.GeoPoint r1 = new com.atakmap.coremap.maps.coords.GeoPoint
            r3 = r1
            r4 = r11
            r6 = r13
            r3.<init>(r4, r6, r8)
            r0.spoiLocation = r1
            goto L_0x0042
        L_0x003f:
            r1 = 0
            r0.spoiLocation = r1
        L_0x0042:
            com.atakmap.android.uastool.UASItem r1 = r0.uasItem
            if (r1 == 0) goto L_0x004b
            com.atakmap.coremap.maps.coords.GeoPoint r2 = r0.spoiLocation
            r1.setSPoIPoint(r2)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.Reflector.sensorSpoiUpdate(double, double, double, double):void");
    }

    public void rawKLVUpdate(byte[] bArr, byte[] bArr2) {
        KLVQueue kLVQueue = this.klvQueue;
        if (kLVQueue != null) {
            kLVQueue.pushKLV(bArr, bArr2);
        }
    }

    public void streamStartupFailed() {
        this.previewActive = false;
        StatusUpdateListener statusUpdateListener = this.currentStatusListener;
        if (statusUpdateListener != null) {
            statusUpdateListener.onStartupFailed();
        }
    }

    public void streamStarted() {
        StatusUpdateListener statusUpdateListener = this.currentStatusListener;
        if (statusUpdateListener != null) {
            statusUpdateListener.onStreamStarted();
        }
    }

    public void mediaEOF() {
        boolean z;
        Log.d(TAG, "End of media");
        if (this.previewActive) {
            try {
                z = UASToolDropDownReceiver.getInstance().getOperatorPager().getOperatorControlFragment().isBroadcasting();
            } catch (Exception unused) {
                z = false;
            }
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(true);
            if (z) {
                try {
                    UASToolDropDownReceiver.getInstance().getOperatorPager().getOperatorControlFragment().startBroadcast();
                } catch (Exception unused2) {
                }
            }
        } else {
            stopPreview();
        }
    }

    public void mediaFatalError(String str) {
        String str2 = TAG;
        Log.e(str2, "Error decoding media: " + str);
        if (this.previewActive) {
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(true);
            return;
        }
        stopPreview();
    }

    protected static CotEvent updateCotWithDTED(CotEvent cotEvent) {
        return SPOI_COT_TYPE.equals(cotEvent.getType()) ? updateCotSPIWithDTED(cotEvent) : cotEvent;
    }

    protected static CotEvent updateCotSPIWithDTED(CotEvent cotEvent) {
        CotDetail firstChildByName;
        CotEvent cotEvent2 = cotEvent;
        CotPoint cotPoint = cotEvent.getCotPoint();
        if (cotPoint == null) {
            return cotEvent2;
        }
        GeoPoint dTEDElevation = getDTEDElevation(cotPoint.toGeoPoint());
        cotEvent2.setPoint(new CotPoint(dTEDElevation));
        CotDetail detail = cotEvent.getDetail();
        if (!(detail == null || detail.getFirstChildByName(0, "shape") == null || (firstChildByName = detail.getFirstChildByName(0, "polyline")) == null)) {
            int childCount = firstChildByName.childCount();
            for (int i = 0; i < childCount; i++) {
                CotDetail child = firstChildByName.getChild(i);
                if (child != null && Objects.equals(child.getElementName(), "vertex")) {
                    double altitude = getDTEDElevation(Double.parseDouble(child.getAttribute(FlightLogger.LOCS_LATITUDE)), Double.parseDouble(child.getAttribute(FlightLogger.LOCS_LONGITUDE)), dTEDElevation.getAltitude(), Double.NaN, Double.NaN).getAltitude();
                    if (GeoPoint.isAltitudeValid(altitude)) {
                        child.setAttribute("hae", String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(altitude)}));
                    }
                }
            }
        }
        return cotEvent2;
    }

    protected static GeoPoint getDTEDElevation(double d, double d2, double d3, double d4, double d5) {
        double d6;
        double d7 = d;
        double d8 = d2;
        try {
            double a = ElevationManager.a(d, d2, (ElevationManager.b) null);
            if (!GeoPoint.isAltitudeValid(a)) {
                a = d3;
            }
            d6 = a;
        } catch (Exception e) {
            Log.e("PD100Reflector", e.getMessage());
            d6 = d3;
        }
        return new GeoPoint(d, d2, d6, d4, d5);
    }

    public static GeoPoint getDTEDElevation(GeoPoint geoPoint) {
        return getDTEDElevation(geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude(), geoPoint.getCE(), geoPoint.getLE());
    }

    protected static class CotProducer implements Runnable {
        private final UASItem item;

        public CotProducer(UASItem uASItem) {
            this.item = uASItem;
        }

        public void run() {
            Log.d(Reflector.TAG, "Starting the Cot producer");
            while (!Thread.interrupted()) {
                try {
                    try {
                        IAircraftItem aircraftItem = this.item.getAircraftItem();
                        if (aircraftItem != null) {
                            aircraftItem.activeRoute = this.item.getRouteActive();
                            Reflector.sendCotEvent(Reflector.makeUasPPLI(aircraftItem));
                            Reflector.sendCotEvent(Reflector.makeHomePos(aircraftItem));
                            Reflector.sendCotEvent(Reflector.makeUasSPOI(aircraftItem));
                        } else if (this.item.isAircraftItemCapable() || this.item.getGeoPoint() == null) {
                            Log.v(Reflector.TAG, "Can't send COT Update until a position has been reported");
                        } else {
                            UASToolDropDownReceiver.getInstance();
                            Reflector reflector = UASToolDropDownReceiver.getReflector();
                            Reflector.sendCotEvent(UASItemUtils.buildCotEventFromUasItem(this.item, true, reflector.isBroadcasting(), reflector.getLocalUri()));
                            Reflector.sendCotEvent(UASItemUtils.buildSPICotEvent(this.item, this.item.getFov()));
                        }
                    } catch (Exception e) {
                        UASToolDropDownReceiver.toast("Cot Producer Encountered an Error");
                        Log.e(Reflector.TAG, "Cot Producer Encountered an Error", e);
                    }
                    Thread.sleep(1000);
                } catch (Exception e2) {
                    Log.v(Reflector.TAG, "Exception  Stopping Cot Producer", e2);
                }
            }
            Log.d(Reflector.TAG, "Cot Producer Exited");
        }
    }

    public void setStatusUpdateListener(StatusUpdateListener statusUpdateListener) {
        this.currentStatusListener = statusUpdateListener;
    }

    public static void sendCotEvent(CotEvent cotEvent) {
        if (cotEvent != null && cotEvent.isValid()) {
            CommsMapComponent.c().a(cotEvent, (Bundle) null);
            if (UASToolDropDownReceiver.getInstance().broadcastCot()) {
                CotMapComponent.h().b(cotEvent);
            }
        }
    }

    private void updateFov() {
        try {
            this.customFov = new PointD(Double.parseDouble(this.sharedPrefs.getString(CameraPreferenceFragment.PREF_CAMERA_FOV_OVERIDE_HORIZONTAL, "0")), Double.parseDouble(this.sharedPrefs.getString(CameraPreferenceFragment.PREF_CAMERA_FOV_OVERIDE_VERTICAL, "0")), 0.0d);
        } catch (Exception unused) {
            this.customFov = null;
        }
    }

    public PointD getCustomFov() {
        return this.customFov;
    }

    public void evalLocalUri(String str, String str2) {
        String string = this.sharedPrefs.getString(NetworkPreferenceFragment.PREF_VIDEO_DEST_ADAPTER, (String) null);
        Uri parse = Uri.parse(str2);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        this.localUri = null;
        if (str != null && str.equals(string) && Utils.isMulticast(host)) {
            if ((scheme.equalsIgnoreCase("rtp") || scheme.equalsIgnoreCase("udp")) && isVideoDestLocal()) {
                this.localUri = str2;
            }
        }
    }

    public String getLocalUri() {
        return this.localUri;
    }

    public static File createSDPFile(String str, int i) {
        return createSDPFile(str, i, SDP_DIR, "264");
    }

    public static File createSDPFile(String str, int i, String str2) {
        return createSDPFile(str, i, SDP_DIR, str2);
    }

    public static File createSDPFile(String str, int i, String str2, String str3) {
        String format = String.format(Locale.US, SDP_FORMAT_STRING, new Object[]{str, Integer.valueOf(i), str3});
        File file = new File(Environment.getExternalStorageDirectory(), str2);
        if (!file.exists() && !file.mkdirs()) {
            String str4 = TAG;
            Log.w(str4, "could not create: " + file);
        }
        File file2 = new File(file, i + ".sdp");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
            bufferedWriter.write(format);
            bufferedWriter.close();
            return file2;
        } catch (IOException unused) {
            String str5 = TAG;
            Log.w(str5, "Failed to open " + file2 + " for writing.");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isVideoDestLocal() {
        String string = this.sharedPrefs.getString(NetworkPreferenceFragment.PREF_BROADCAST_DESTINATION, (String) null);
        if (string == null) {
            return true;
        }
        return string.equals(this.pluginContext.getResources().getStringArray(C1877R.array.video_destination)[0]);
    }

    public static Double getDTEDElevation(double d, double d2) {
        Double valueOf = Double.valueOf(ElevationManager.a(d, d2, (ElevationManager.b) null));
        return Double.isNaN(valueOf.doubleValue()) ? Double.valueOf(0.0d) : valueOf;
    }

    public static void updateAircraftItemWithDTED(IAircraftItem iAircraftItem) {
        if (!Double.isNaN(iAircraftItem.homelat) && !Double.isNaN(iAircraftItem.homelon)) {
            double doubleValue = getDTEDElevation(iAircraftItem.homelat, iAircraftItem.homelon).doubleValue();
            if (doubleValue != 0.0d) {
                iAircraftItem.acalt += doubleValue;
                iAircraftItem.homealt = doubleValue;
                homeDTEDElevation = doubleValue;
            }
        }
        if (!Double.isNaN(iAircraftItem.spoilat) && !Double.isNaN(iAircraftItem.spoilon)) {
            double doubleValue2 = getDTEDElevation(iAircraftItem.spoilat, iAircraftItem.spoilon).doubleValue();
            if (doubleValue2 != 0.0d) {
                iAircraftItem.spoialt = doubleValue2;
            }
        }
    }

    public static void updateAircraftItemWithSelfMarker(IAircraftItem iAircraftItem) {
        ao selfMarker;
        if ((Double.isNaN(iAircraftItem.aclat) || Double.isNaN(iAircraftItem.aclon) || Double.isNaN(iAircraftItem.acalt)) && (selfMarker = MapView.getMapView().getSelfMarker()) != null && selfMarker.C() != null) {
            GeoPoint C = selfMarker.C();
            if (C == null || !C.isValid()) {
                iAircraftItem.aclat = 0.0d;
                iAircraftItem.aclon = 0.0d;
                iAircraftItem.acalt = 0.0d;
                iAircraftItem.achal = 0.0d;
                iAircraftItem.acce = Double.NaN;
                iAircraftItem.acle = Double.NaN;
                return;
            }
            iAircraftItem.aclat = C.getLatitude();
            iAircraftItem.aclon = C.getLongitude();
            iAircraftItem.acalt = C.getAltitude();
            iAircraftItem.achal = 0.0d;
            iAircraftItem.acce = Double.NaN;
            iAircraftItem.acle = Double.NaN;
        }
    }

    public static void updateAircraftItemWithZeroZero(IAircraftItem iAircraftItem) {
        if (Double.isNaN(iAircraftItem.aclat) || Double.isNaN(iAircraftItem.aclon)) {
            iAircraftItem.aclat = 0.0d;
            iAircraftItem.aclon = 0.0d;
            iAircraftItem.acce = Double.NaN;
            iAircraftItem.acle = Double.NaN;
        } else if (iAircraftItem.aclat == 214.7483647d || iAircraftItem.aclon == 214.7483647d) {
            iAircraftItem.aclat = 0.0d;
            iAircraftItem.aclon = 0.0d;
            iAircraftItem.acce = Double.NaN;
            iAircraftItem.acle = Double.NaN;
        }
        if (Double.isNaN(iAircraftItem.acalt)) {
            iAircraftItem.acalt = 0.0d;
        }
        if (Double.isNaN(iAircraftItem.achal)) {
            iAircraftItem.achal = 0.0d;
        }
        if (Double.isNaN(iAircraftItem.homelat) || Double.isNaN(iAircraftItem.homelon)) {
            iAircraftItem.homelat = 0.0d;
            iAircraftItem.homelon = 0.0d;
        }
        if (Double.isNaN(iAircraftItem.homealt)) {
            iAircraftItem.homealt = 0.0d;
        }
    }

    public static void updateAircraftItemFOV(IAircraftItem iAircraftItem) {
        FieldOfView computeFov = FieldOfView.computeFov(new GeoPoint(iAircraftItem.aclat, iAircraftItem.aclon, iAircraftItem.acalt), iAircraftItem.sensorElevation, iAircraftItem.sensorAzimuth, iAircraftItem.sensorVFOV, iAircraftItem.sensorHFOV, true);
        if (computeFov == null || computeFov.center == null || computeFov.center.get() == null || !computeFov.center.get().isValid()) {
            iAircraftItem.spoilat = Double.NaN;
            iAircraftItem.spoilon = Double.NaN;
            iAircraftItem.spoialt = Double.NaN;
        } else {
            iAircraftItem.spoilat = computeFov.center.get().getLatitude();
            iAircraftItem.spoilon = computeFov.center.get().getLongitude();
            iAircraftItem.spoialt = computeFov.center.get().getAltitude();
        }
        if (computeFov == null || !computeFov.isValid()) {
            iAircraftItem.initSpoiViewBounds();
        } else {
            iAircraftItem.initSpoiViewBounds();
            iAircraftItem.spoiBounds[0] = computeFov.f8422tl.x;
            iAircraftItem.spoiBounds[1] = computeFov.f8422tl.y;
            iAircraftItem.spoiBounds[2] = computeFov.f8423tr.x;
            iAircraftItem.spoiBounds[3] = computeFov.f8423tr.y;
            iAircraftItem.spoiBounds[4] = computeFov.f8421br.x;
            iAircraftItem.spoiBounds[5] = computeFov.f8421br.y;
            iAircraftItem.spoiBounds[6] = computeFov.f8420bl.x;
            iAircraftItem.spoiBounds[7] = computeFov.f8420bl.y;
        }
        if (iAircraftItem.sensorElevation != 0.0d && !Double.isNaN(iAircraftItem.achal)) {
            if (Double.isNaN(iAircraftItem.acalt) || Double.isNaN(iAircraftItem.spoialt)) {
                iAircraftItem.sensorRange = iAircraftItem.achal / Math.sin(Math.toRadians(Math.abs(iAircraftItem.sensorElevation)));
            } else {
                iAircraftItem.sensorRange = (iAircraftItem.acalt - iAircraftItem.spoialt) / Math.sin(Math.toRadians(Math.abs(iAircraftItem.sensorElevation)));
            }
        }
        if (Double.isNaN(iAircraftItem.sensorRange) || iAircraftItem.sensorRange > 10000.0d) {
            iAircraftItem.sensorRange = 300.0d;
        }
    }

    public static CotEvent makeUasSPOI(IAircraftItem iAircraftItem) {
        IAircraftItem iAircraftItem2 = iAircraftItem;
        if (deviceUID == null) {
            deviceUID = MapView.getDeviceUid();
        }
        if (iAircraftItem2 == null || deviceUID == null || iAircraftItem2.callsign == null || Double.isNaN(iAircraftItem2.spoilat) || Double.isNaN(iAircraftItem2.spoilon)) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(iAircraftItem2.spoilat, iAircraftItem2.spoilon, iAircraftItem2.spoialt);
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CotEvent cotEvent = new CotEvent();
        cotEvent.setVersion("2.0");
        cotEvent.setUID(iAircraftItem2.callsign + "." + iAircraftItem2.UID + ".SPI1");
        cotEvent.setType(SPOI_COT_TYPE);
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addMilliseconds(3500));
        cotEvent.setHow("m-g");
        cotEvent.setPoint(new CotPoint(geoPoint));
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail("_" + iAircraftItem2.platformId + "SPI_");
        cotDetail2.setAttribute("homelat", UASItemUtils.getString(Double.valueOf(iAircraftItem2.spoilat)));
        cotDetail2.setAttribute("homelon", UASItemUtils.getString(Double.valueOf(iAircraftItem2.spoilon)));
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail(UasC2Event.ContactDetail.detailName);
        cotDetail3.setAttribute(FlightLogger.LOG_CALLSIGN, iAircraftItem2.callsign + ".SPI1");
        cotDetail.addChild(cotDetail3);
        CotDetail cotDetail4 = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail4.setAttribute("relation", "p-p");
        cotDetail4.setAttribute(UASTask.COTDETAIL_UID, iAircraftItem2.UID);
        cotDetail4.setAttribute("type", "a-f-A-M-H-Q");
        cotDetail.addChild(cotDetail4);
        CotDetail cotDetail5 = new CotDetail(UasC2Event.PrecisionLocationDetail.detailName);
        cotDetail5.setAttribute("altsrc", "GPS");
        cotDetail.addChild(cotDetail5);
        CotDetail cotDetail6 = new CotDetail("shape");
        CotDetail cotDetail7 = new CotDetail("polyline");
        boolean z = iAircraftItem2.spoiBounds != null && iAircraftItem2.spoiBounds.length >= 8;
        if (z) {
            int i = 0;
            while (true) {
                if (i < 8) {
                    if (Double.isNaN(iAircraftItem2.spoiBounds[i])) {
                        break;
                    }
                    int i2 = i + 1;
                    if (Double.isNaN(iAircraftItem2.spoiBounds[i2])) {
                        break;
                    }
                    CotDetail cotDetail8 = new CotDetail("vertex");
                    cotDetail8.setAttribute("hae", JsonValueConstants.VERSION);
                    cotDetail8.setAttribute(FlightLogger.LOCS_LATITUDE, UASItemUtils.getString(Double.valueOf(iAircraftItem2.spoiBounds[i])));
                    cotDetail8.setAttribute(FlightLogger.LOCS_LONGITUDE, UASItemUtils.getString(Double.valueOf(iAircraftItem2.spoiBounds[i2])));
                    cotDetail7.addChild(cotDetail8);
                    i += 2;
                } else {
                    break;
                }
            }
            z = false;
            if (!z) {
                cotDetail7 = new CotDetail("polyline");
                for (int i3 = 0; i3 < 4; i3++) {
                    CotDetail cotDetail9 = new CotDetail("vertex");
                    cotDetail9.setAttribute("hae", JsonValueConstants.VERSION);
                    cotDetail9.setAttribute(FlightLogger.LOCS_LATITUDE, UASItemUtils.getString(Double.valueOf(iAircraftItem2.spoilat)));
                    cotDetail9.setAttribute(FlightLogger.LOCS_LONGITUDE, UASItemUtils.getString(Double.valueOf(iAircraftItem2.spoilon)));
                    cotDetail7.addChild(cotDetail9);
                }
                Log.d(TAG, "SKIPPING FourCorners invalid data");
            }
        } else {
            Log.d(TAG, "SKIPPING FourCorners no data");
        }
        cotDetail7.setAttribute("closed", "true");
        cotDetail6.addChild(cotDetail7);
        cotDetail.addChild(cotDetail6);
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    public static CotEvent makeHomePos(IAircraftItem iAircraftItem) {
        IAircraftItem iAircraftItem2 = iAircraftItem;
        if (deviceUID == null) {
            deviceUID = MapView.getDeviceUid();
        }
        if (iAircraftItem2 == null || deviceUID == null || iAircraftItem2.callsign == null || Double.isNaN(iAircraftItem2.homelat) || Double.isNaN(iAircraftItem2.homelon)) {
            return null;
        }
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CotEvent cotEvent = new CotEvent();
        cotEvent.setVersion("2.0");
        cotEvent.setUID("HOME." + iAircraftItem2.UID);
        cotEvent.setType("a-f-G");
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addMilliseconds(3500));
        cotEvent.setHow("m-g");
        cotEvent.setQos("1-r-c");
        cotEvent.setPoint(new CotPoint(new GeoPoint(iAircraftItem2.homelat, iAircraftItem2.homelon, iAircraftItem2.homealt, GeoPoint.AltitudeReference.HAE, 100.0d, 100.0d)));
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail(UasC2Event.ContactDetail.detailName);
        cotDetail2.setAttribute(FlightLogger.LOG_CALLSIGN, iAircraftItem2.callsign + ".HOME");
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail("usericon");
        cotDetail3.setAttribute("iconsetpath", "f7f71666-8b28-4b57-9fbb-e38e61d33b79/Google/homegardenbusiness.png");
        cotDetail.addChild(cotDetail3);
        CotDetail cotDetail4 = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail4.setAttribute("relation", "p-p");
        cotDetail4.setAttribute(UASTask.COTDETAIL_UID, iAircraftItem2.UID);
        cotDetail4.setAttribute("type", "a-f-A-M-H-Q");
        cotDetail.addChild(cotDetail4);
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    public static CotEvent makeUasPPLI(IAircraftItem iAircraftItem) {
        String str;
        String str2;
        IAircraftItem iAircraftItem2 = iAircraftItem;
        if (deviceUID == null) {
            deviceUID = MapView.getDeviceUid();
        }
        String str3 = iAircraftItem2.callsign;
        if (iAircraftItem2 == null || deviceUID == null || str3 == null) {
            return null;
        }
        String videoBroadcastDestinationUrl = UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl();
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CotEvent cotEvent = new CotEvent();
        cotEvent.setVersion("2.0");
        cotEvent.setUID(iAircraftItem2.UID);
        cotEvent.setType("a-f-A-M-H-Q");
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addMilliseconds(3500));
        cotEvent.setHow("m-g");
        double d = iAircraftItem2.aclat;
        double d2 = iAircraftItem2.aclon;
        double d3 = iAircraftItem2.acalt;
        GeoPoint.AltitudeReference altitudeReference = GeoPoint.AltitudeReference.HAE;
        String str4 = str3;
        String str5 = videoBroadcastDestinationUrl;
        double d4 = iAircraftItem2.acce;
        CoordinatedTime coordinatedTime2 = coordinatedTime;
        double d5 = iAircraftItem2.acle;
        GeoPoint geoPoint = r6;
        GeoPoint geoPoint2 = new GeoPoint(d, d2, d3, altitudeReference, d4, d5);
        CotPoint cotPoint = new CotPoint(geoPoint);
        CotEvent cotEvent2 = cotEvent;
        cotEvent2.setPoint(cotPoint);
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail("_flow-tags_");
        cotDetail2.setAttribute("GCS", coordinatedTime2.toString());
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail(UasC2Event.UASToolDetail.detailName);
        String str6 = "true";
        cotDetail3.setAttribute("extendedCot", str6);
        IAircraftItem iAircraftItem3 = iAircraftItem;
        cotDetail3.setAttribute("activeRoute", iAircraftItem3.activeRoute ? str6 : "false");
        cotDetail.addChild(cotDetail3);
        CotDetail cotDetail4 = new CotDetail("_" + iAircraftItem3.platformId + "_");
        cotDetail4.setAttribute("homelat", UASItemUtils.getString(Double.valueOf(iAircraftItem3.aclat)));
        cotDetail4.setAttribute("homelon", UASItemUtils.getString(Double.valueOf(iAircraftItem3.aclon)));
        if (!Double.isNaN(iAircraftItem3.sensorAzimuth)) {
            cotDetail4.setAttribute("gimbalyaw", Double.toString(iAircraftItem3.sensorAzimuth));
        }
        if (!Double.isNaN(iAircraftItem3.sensorRoll)) {
            cotDetail4.setAttribute("gimbalroll", Double.toString(iAircraftItem3.sensorRoll));
        }
        if (!Double.isNaN(iAircraftItem3.sensorElevation)) {
            cotDetail4.setAttribute(UASPoint.COTDETAIL_GIMBALPITCH, Double.toString(iAircraftItem3.sensorElevation));
        }
        cotDetail4.setAttribute("spoiuid", iAircraftItem3.callsign + "." + iAircraftItem3.UID + ".SPI1");
        cotDetail.addChild(cotDetail4);
        CotDetail cotDetail5 = new CotDetail(UasC2Event.TrackDetail.detailName);
        cotDetail5.setAttribute("course", String.format("%.2f", new Object[]{Double.valueOf(iAircraftItem3.acheading)}));
        cotDetail5.setAttribute(UASPoint.COTDETAIL_SPEED, String.format("%.2f", new Object[]{Double.valueOf(iAircraftItem3.speed)}));
        cotDetail5.setAttribute("slope", String.format("%.2f", new Object[]{Double.valueOf(iAircraftItem3.slope)}));
        cotDetail.addChild(cotDetail5);
        CotDetail cotDetail6 = new CotDetail(UasC2Event.SensorDetail.detailName);
        cotDetail6.setAttribute("azimuth", Double.toString(iAircraftItem3.sensorAzimuth));
        cotDetail6.setAttribute("elevation", Double.toString(iAircraftItem3.sensorElevation));
        cotDetail6.setAttribute(adz.f608a, Double.toString(iAircraftItem3.sensorRoll));
        cotDetail6.setAttribute("fov", Double.toString(iAircraftItem3.sensorHFOV));
        cotDetail6.setAttribute("vfov", Double.toString(iAircraftItem3.sensorVFOV));
        cotDetail6.setAttribute("north", Double.toString(iAircraftItem3.sensorNorth));
        cotDetail6.setAttribute("version", "0.6");
        cotDetail6.setAttribute("model", iAircraftItem3.sensorModel);
        cotDetail6.setAttribute("range", Integer.toString((int) iAircraftItem3.sensorRange));
        cotDetail6.setAttribute("type", "r-e");
        cotDetail.addChild(cotDetail6);
        CotDetail cotDetail7 = new CotDetail(UasC2Event.SpatialDetail.detailName);
        CotDetail cotDetail8 = new CotDetail(UasC2Event.SpatialDetail.AttitudeDetail.detailName);
        String str7 = "type";
        cotDetail8.setAttribute("pitch", Double.toString(iAircraftItem3.attitudePitch));
        String str8 = "false";
        cotDetail8.setAttribute(adz.f608a, Double.toString(iAircraftItem3.attitudeRoll));
        cotDetail8.setAttribute("yaw", Double.toString(iAircraftItem3.attitudeYaw));
        cotDetail7.addChild(cotDetail8);
        CotDetail cotDetail9 = new CotDetail(UasC2Event.SpatialDetail.SpinDetail.detailName);
        if (Double.isNaN(iAircraftItem3.spinPitch)) {
            str2 = JsonValueConstants.VERSION;
            str = str2;
        } else {
            str = JsonValueConstants.VERSION;
            str2 = Double.toString(iAircraftItem3.spinPitch);
        }
        cotDetail9.setAttribute("pitch", str2);
        cotDetail9.setAttribute(adz.f608a, Double.isNaN(iAircraftItem3.spinRoll) ? str : Double.toString(iAircraftItem3.spinRoll));
        cotDetail9.setAttribute("yaw", Double.isNaN(iAircraftItem3.spinYaw) ? str : Double.toString(iAircraftItem3.spinYaw));
        cotDetail7.addChild(cotDetail9);
        cotDetail.addChild(cotDetail7);
        CotDetail cotDetail10 = new CotDetail(UasC2Event.VehicleDetail.detailName);
        cotDetail10.setAttribute("batteryMaxCapacity", Integer.toString(iAircraftItem3.battMax));
        cotDetail10.setAttribute("batteryRemainingCapacity", Integer.toString(iAircraftItem3.battRem));
        cotDetail10.setAttribute("goHomeBatteryPercent", Integer.toString(iAircraftItem3.goHomeBatteryPercent));
        cotDetail10.setAttribute("isFlying", Boolean.toString(iAircraftItem3.isFlying));
        cotDetail10.setAttribute("flightTime", Integer.toString(iAircraftItem3.flightTime));
        cotDetail10.setAttribute("flightTimeRemaining", Integer.toString(iAircraftItem3.flightTimeRemaining));
        cotDetail10.setAttribute("hal", String.format("%.2f", new Object[]{Double.valueOf(iAircraftItem3.achal)}));
        if (!Double.isNaN(iAircraftItem3.battVolt)) {
            cotDetail10.setAttribute("voltage", String.format("%.2f", new Object[]{Double.valueOf(iAircraftItem3.battVolt)}));
        }
        String str9 = str7;
        cotDetail10.setAttribute(str9, iAircraftItem3.platformId);
        cotDetail10.setAttribute("typeTag", "_" + iAircraftItem3.platformId + "_");
        cotDetail.addChild(cotDetail10);
        CotDetail cotDetail11 = new CotDetail(UasC2Event.RadioDetail.detailName);
        cotDetail11.setAttribute("rssi", Integer.toString(iAircraftItem3.signalQuality));
        if (!iAircraftItem3.hasGPS) {
            str6 = str8;
        }
        cotDetail11.setAttribute("gps", str6);
        cotDetail.addChild(cotDetail11);
        CotDetail cotDetail12 = new CotDetail(UasC2Event.ContactDetail.detailName);
        String str10 = str4;
        cotDetail12.setAttribute(FlightLogger.LOG_CALLSIGN, str10);
        cotDetail.addChild(cotDetail12);
        CotDetail cotDetail13 = new CotDetail(UasC2Event.WaypointCollectionDetail.detailName);
        if (iAircraftItem3.routePoints != null) {
            int i = 0;
            while (i < iAircraftItem3.routePoints.size()) {
                int i2 = i + 1;
                UASPoint pointWithIndex = UASRoute.getPointWithIndex(iAircraftItem3.routePoints, i2);
                CotDetail cotDetail14 = new CotDetail(UasC2Event.WaypointDetail.detailName);
                cotDetail14.setAttribute(UASTask.COTDETAIL_NAME, pointWithIndex.getName());
                cotDetail14.setAttribute("description", iAircraftItem3.callsign + " waypoint-" + pointWithIndex.getIndex());
                CotDetail cotDetail15 = new CotDetail("point");
                cotDetail15.setAttribute(FlightLogger.LOCS_LATITUDE, UASItemUtils.getString(Double.valueOf(pointWithIndex.C().getLatitude())));
                cotDetail15.setAttribute(FlightLogger.LOCS_LONGITUDE, UASItemUtils.getString(Double.valueOf(pointWithIndex.C().getLongitude())));
                cotDetail15.setAttribute(UASPoint.COTDETAIL_CE, "9999");
                cotDetail15.setAttribute(UASPoint.COTDETAIL_LE, "9999");
                int i3 = i2;
                String str11 = str10;
                cotDetail15.setAttribute("hae", UASItemUtils.getString(Double.valueOf(pointWithIndex.C().getAltitude() + ((double) pointWithIndex.getAGL()))));
                cotDetail14.addChild(cotDetail15);
                if (pointWithIndex instanceof OrbitPoint) {
                    CotDetail cotDetail16 = new CotDetail("orbit");
                    cotDetail16.setAttribute(OrbitPoint.COTDETAIL_ORBITRADIUS, String.valueOf(((OrbitPoint) pointWithIndex).getOrbitRadius()));
                    cotDetail14.addChild(cotDetail16);
                }
                cotDetail13.addChild(cotDetail14);
                i = i3;
                str10 = str11;
            }
        }
        String str12 = str10;
        cotDetail.addChild(cotDetail13);
        CotDetail cotDetail17 = new CotDetail("_route");
        cotDetail17.setAttribute("sender", MapView.getMapView().getSelfMarker().getUID());
        if (iAircraftItem3.routePoints != null && iAircraftItem3.activeRoute) {
            cotDetail17 = getUASRouteCoT(iAircraftItem3, cotDetail17);
        }
        cotDetail.addChild(cotDetail17);
        CotDetail cotDetail18 = new CotDetail(UasC2Event.CommandedDataDetail.detailName);
        cotDetail18.setAttribute("climbRate", String.format("%.2f", new Object[]{Double.valueOf(iAircraftItem3.climbRate)}));
        cotDetail.addChild(cotDetail18);
        UASToolDropDownReceiver.getInstance();
        Reflector reflector = UASToolDropDownReceiver.getReflector();
        CotDetail cotDetail19 = new CotDetail(UasC2Event.VideoDetail.detailName);
        if (reflector.isBroadcasting() || reflector.getLocalUri() != null) {
            if (reflector.isBroadcasting()) {
                cotDetail19.setAttribute(DownloadTask.URL, str5);
            } else {
                cotDetail19.setAttribute(DownloadTask.URL, reflector.getLocalUri());
            }
            String str13 = str12;
            cotDetail19.setAttribute(UasC2Event.SensorDetail.detailName, str13);
            cotDetail19.setAttribute("spi", str13 + ".SPI1");
        }
        cotDetail.addChild(cotDetail19);
        CotDetail cotDetail20 = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail20.setAttribute("relation", "p-p");
        cotDetail20.setAttribute(UASTask.COTDETAIL_UID, MapView.getDeviceUid());
        cotDetail20.setAttribute(str9, "a-f-G-U-C");
        cotDetail.addChild(cotDetail20);
        cotEvent2.setDetail(cotDetail);
        return cotEvent2;
    }

    public static CotDetail getUASRouteCoT(IAircraftItem iAircraftItem, CotDetail cotDetail) {
        if (iAircraftItem.routePoints.size() == 1) {
            CotDetail cotDetail2 = new CotDetail(UasC2Event.LinkDetail.detailName);
            cotDetail2.setAttribute(UASTask.COTDETAIL_UID, UUID.randomUUID().toString());
            cotDetail2.setAttribute(FlightLogger.LOG_CALLSIGN, "");
            cotDetail2.setAttribute("type", UASRoute.WAYPOINT_TYPE);
            cotDetail2.setAttribute("point", new GeoPoint(iAircraftItem.aclat, iAircraftItem.aclon).toString());
            cotDetail.addChild(cotDetail2);
        }
        int i = 0;
        while (i < iAircraftItem.routePoints.size()) {
            i++;
            UASPoint pointWithIndex = UASRoute.getPointWithIndex(iAircraftItem.routePoints, i);
            CotDetail cotDetail3 = new CotDetail(UasC2Event.LinkDetail.detailName);
            cotDetail3.setAttribute(UASTask.COTDETAIL_UID, pointWithIndex.getUID() + "rte");
            cotDetail3.setAttribute(FlightLogger.LOG_CALLSIGN, pointWithIndex.getName());
            if (pointWithIndex instanceof OrbitPoint) {
                if (pointWithIndex.getName() == null || !pointWithIndex.getName().endsWith("Orbit")) {
                    cotDetail3.setAttribute(FlightLogger.LOG_CALLSIGN, pointWithIndex.getName() + " Orbit");
                } else {
                    cotDetail3.setAttribute(FlightLogger.LOG_CALLSIGN, pointWithIndex.getName());
                }
            }
            cotDetail3.setAttribute("type", UASRoute.WAYPOINT_TYPE);
            cotDetail3.setAttribute("point", pointWithIndex.C().toString());
            cotDetail.addChild(cotDetail3);
        }
        CotDetail cotDetail4 = new CotDetail("link_attr");
        cotDetail4.setAttribute(UASTask.COTDETAIL_COLOR, "-1");
        cotDetail4.setAttribute("type", "Vehicle");
        cotDetail.addChild(cotDetail4);
        CotDetail cotDetail5 = new CotDetail(UasC2Event.ContactDetail.detailName);
        if (iAircraftItem.routePoints.size() == 1) {
            cotDetail5.setAttribute(FlightLogger.LOG_CALLSIGN, iAircraftItem.callsign + " Quick FlyTo");
        } else {
            cotDetail5.setAttribute(FlightLogger.LOG_CALLSIGN, iAircraftItem.callsign + " route");
        }
        cotDetail.addChild(cotDetail5);
        return cotDetail;
    }

    public void aircraftAttitudeUpdate(double d, double d2, double d3) {
        this.uasItem.setAttitude(d, d2, d3);
        double[] dArr = this.aircraft_RPY;
        dArr[0] = d;
        dArr[1] = d2;
        dArr[2] = d3;
    }

    public void sensorAttitudeUpdate(double d, double d2, double d3) {
        this.uasItem.setGimbalAngle(d3);
        this.uasItem.setGimbalPitch(d2);
        double[] dArr = this.sensor_RPY;
        dArr[0] = d;
        dArr[1] = d2;
        dArr[2] = d3;
    }

    public void sensorFovUpdate(double d, double d2) {
        UASItem uASItem = this.uasItem;
        this.hfov = d;
        uASItem.setHFOV(d);
        UASItem uASItem2 = this.uasItem;
        this.vfov = d2;
        uASItem2.setVFOV(d2);
    }

    public void record(boolean z) {
        MpegStreamHandler mpegStreamHandler = this.mpegStreamPreview;
        if (mpegStreamHandler != null) {
            mpegStreamHandler.record(z);
        }
    }

    public boolean isRecording() {
        MpegStreamHandler mpegStreamHandler = this.mpegStreamPreview;
        return mpegStreamHandler != null && mpegStreamHandler.isRecording();
    }

    public boolean canRecord() {
        MpegStreamHandler mpegStreamHandler = this.mpegStreamPreview;
        return mpegStreamHandler != null && mpegStreamHandler.isRecordingSupported();
    }
}
