package com.atakmap.android.uastool.generic;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Surface;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.utils.Utils;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GenericReflector extends Reflector {
    private final boolean sendVideo = true;
    private Timer timer;

    public String takePicture(String str, String str2, String str3) {
        return "Generic takePicture not yet implemented.";
    }

    public GenericReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        TAG = GenericReflector.class.getSimpleName();
        GenericPrefHandler.checkUpdatePref(this.sharedPrefs);
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
        evalLocalUri(this.sharedPrefs.getString(GenericPrefHandler.PREF_SRC_ADAPTER, (String) null), getRxUri());
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(this.sharedPrefs, str);
        if (!str.startsWith("uastool.generic.")) {
            return;
        }
        if (str.equals(GenericPrefHandler.PREF_SRC_ADAPTER) || str.equals(GenericPrefHandler.PREF_SRC_IP) || str.equals(GenericPrefHandler.PREF_SRC_PORT) || str.equals(GenericPrefHandler.PREF_VIDEO_SRC_URI)) {
            videoSourceAttributeChanged();
        }
    }

    private void videoSourceAttributeChanged() {
        if (this.previewActive) {
            stopPreview();
            startPreview(this.previewSurface);
        }
    }

    private String getRxIP() {
        return this.sharedPrefs.getString(GenericPrefHandler.PREF_SRC_IP, "");
    }

    private int getRxPort() {
        return Utils.parseInt(this.sharedPrefs.getString(GenericPrefHandler.PREF_SRC_PORT, "0"), 0);
    }

    private String getRxUri() {
        return this.sharedPrefs.getString(GenericPrefHandler.PREF_VIDEO_SRC_URI, "");
    }

    public void startPreview(Surface surface) {
        startPreview(surface, getRxUri(), this.sharedPrefs.getString(GenericPrefHandler.PREF_SRC_ADAPTER, (String) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b7 A[Catch:{ Exception -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00cf A[Catch:{ Exception -> 0x0150 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendCoT() {
        /*
            r12 = this;
            com.atakmap.android.uastool.generic.IAircraftItem r0 = new com.atakmap.android.uastool.generic.IAircraftItem
            r0.<init>()
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r12.lastSensorUpdate
            long r3 = r1 - r3
            java.lang.String r5 = "GenericDebug"
            r6 = 5000(0x1388, double:2.4703E-320)
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x002d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Too much time since last update "
            r0.append(r3)
            long r3 = r12.lastSensorUpdate
            long r1 = r1 - r3
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.atakmap.coremap.log.Log.d(r5, r0)
            return
        L_0x002d:
            com.atakmap.android.uastool.UASItem r3 = r12.uasItem     // Catch:{ Exception -> 0x0150 }
            java.lang.String r3 = r3.getUid()     // Catch:{ Exception -> 0x0150 }
            r0.UID = r3     // Catch:{ Exception -> 0x0150 }
            java.lang.String r3 = r12.tailNumber     // Catch:{ Exception -> 0x0150 }
            if (r3 == 0) goto L_0x004b
            java.lang.String r3 = r12.tailNumber     // Catch:{ Exception -> 0x0150 }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x0150 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x0150 }
            if (r3 == 0) goto L_0x0046
            goto L_0x004b
        L_0x0046:
            java.lang.String r3 = r12.tailNumber     // Catch:{ Exception -> 0x0150 }
            r0.callsign = r3     // Catch:{ Exception -> 0x0150 }
            goto L_0x0053
        L_0x004b:
            com.atakmap.android.uastool.UASItem r3 = r12.uasItem     // Catch:{ Exception -> 0x0150 }
            java.lang.String r3 = r3.getCallsign()     // Catch:{ Exception -> 0x0150 }
            r0.callsign = r3     // Catch:{ Exception -> 0x0150 }
        L_0x0053:
            com.atakmap.coremap.maps.coords.GeoPoint r3 = r12.aircraftLocation     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.getLatitude()     // Catch:{ Exception -> 0x0150 }
            r0.aclat = r3     // Catch:{ Exception -> 0x0150 }
            com.atakmap.coremap.maps.coords.GeoPoint r3 = r12.aircraftLocation     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.getLongitude()     // Catch:{ Exception -> 0x0150 }
            r0.aclon = r3     // Catch:{ Exception -> 0x0150 }
            com.atakmap.coremap.maps.coords.GeoPoint r3 = r12.aircraftLocation     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.getAltitude()     // Catch:{ Exception -> 0x0150 }
            r0.acalt = r3     // Catch:{ Exception -> 0x0150 }
            r3 = 0
            r0.acce = r3     // Catch:{ Exception -> 0x0150 }
            r0.acle = r3     // Catch:{ Exception -> 0x0150 }
            double[] r3 = r12.aircraft_RPY     // Catch:{ Exception -> 0x0150 }
            r4 = 2
            r8 = r3[r4]     // Catch:{ Exception -> 0x0150 }
            r0.acheading = r8     // Catch:{ Exception -> 0x0150 }
            r3 = 1
            r0.hasGPS = r3     // Catch:{ Exception -> 0x0150 }
            double[] r8 = r12.aircraft_RPY     // Catch:{ Exception -> 0x0150 }
            r9 = 0
            r10 = r8[r9]     // Catch:{ Exception -> 0x0150 }
            r0.attitudeRoll = r10     // Catch:{ Exception -> 0x0150 }
            double[] r8 = r12.aircraft_RPY     // Catch:{ Exception -> 0x0150 }
            r10 = r8[r3]     // Catch:{ Exception -> 0x0150 }
            r0.attitudePitch = r10     // Catch:{ Exception -> 0x0150 }
            double[] r8 = r12.aircraft_RPY     // Catch:{ Exception -> 0x0150 }
            r10 = r8[r4]     // Catch:{ Exception -> 0x0150 }
            r0.attitudeYaw = r10     // Catch:{ Exception -> 0x0150 }
            double[] r8 = r12.sensor_RPY     // Catch:{ Exception -> 0x0150 }
            r10 = r8[r9]     // Catch:{ Exception -> 0x0150 }
            r0.sensorRoll = r10     // Catch:{ Exception -> 0x0150 }
            double[] r8 = r12.sensor_RPY     // Catch:{ Exception -> 0x0150 }
            r10 = r8[r3]     // Catch:{ Exception -> 0x0150 }
            r0.sensorElevation = r10     // Catch:{ Exception -> 0x0150 }
            double[] r8 = r12.sensor_RPY     // Catch:{ Exception -> 0x0150 }
            r10 = r8[r4]     // Catch:{ Exception -> 0x0150 }
            r0.sensorAzimuth = r10     // Catch:{ Exception -> 0x0150 }
            double r10 = r12.hfov     // Catch:{ Exception -> 0x0150 }
            r0.sensorHFOV = r10     // Catch:{ Exception -> 0x0150 }
            double r10 = r12.vfov     // Catch:{ Exception -> 0x0150 }
            r0.sensorVFOV = r10     // Catch:{ Exception -> 0x0150 }
            com.atakmap.coremap.cot.event.CotEvent r8 = makeUasPPLI(r0)     // Catch:{ Exception -> 0x0150 }
            sendCotEvent(r8)     // Catch:{ Exception -> 0x0150 }
            long r10 = r12.lastSpoiUpdate     // Catch:{ Exception -> 0x0150 }
            long r10 = r1 - r10
            int r8 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00cf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0150 }
            r0.<init>()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r3 = "Too much time since last spoi update "
            r0.append(r3)     // Catch:{ Exception -> 0x0150 }
            long r3 = r12.lastSpoiUpdate     // Catch:{ Exception -> 0x0150 }
            long r1 = r1 - r3
            r0.append(r1)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0150 }
            com.atakmap.coremap.log.Log.d(r5, r0)     // Catch:{ Exception -> 0x0150 }
            return
        L_0x00cf:
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r12.spoiLocation     // Catch:{ Exception -> 0x0150 }
            if (r5 == 0) goto L_0x0158
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r12.spoiLocation     // Catch:{ Exception -> 0x0150 }
            double r10 = r5.getLatitude()     // Catch:{ Exception -> 0x0150 }
            r0.spoilat = r10     // Catch:{ Exception -> 0x0150 }
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r12.spoiLocation     // Catch:{ Exception -> 0x0150 }
            double r10 = r5.getLongitude()     // Catch:{ Exception -> 0x0150 }
            r0.spoilon = r10     // Catch:{ Exception -> 0x0150 }
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r12.spoiLocation     // Catch:{ Exception -> 0x0150 }
            double r10 = r5.getAltitude()     // Catch:{ Exception -> 0x0150 }
            r0.spoialt = r10     // Catch:{ Exception -> 0x0150 }
            com.atakmap.android.uastool.UASItem r5 = r12.uasItem     // Catch:{ Exception -> 0x0150 }
            com.atakmap.android.uastool.utils.FieldOfView r5 = r5.getFov()     // Catch:{ Exception -> 0x0150 }
            if (r5 == 0) goto L_0x0148
            boolean r8 = r5.isValid()     // Catch:{ Exception -> 0x0150 }
            if (r8 == 0) goto L_0x0148
            long r10 = r5.lastUpdateTime     // Catch:{ Exception -> 0x0150 }
            long r1 = r1 - r10
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0148
            r0.initSpoiViewBounds()     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            com.atakmap.math.PointD r2 = r5.f8422tl     // Catch:{ Exception -> 0x0150 }
            double r6 = r2.x     // Catch:{ Exception -> 0x0150 }
            r1[r9] = r6     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            com.atakmap.math.PointD r2 = r5.f8422tl     // Catch:{ Exception -> 0x0150 }
            double r6 = r2.y     // Catch:{ Exception -> 0x0150 }
            r1[r3] = r6     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            com.atakmap.math.PointD r2 = r5.f8423tr     // Catch:{ Exception -> 0x0150 }
            double r2 = r2.x     // Catch:{ Exception -> 0x0150 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            r2 = 3
            com.atakmap.math.PointD r3 = r5.f8423tr     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.y     // Catch:{ Exception -> 0x0150 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            r2 = 4
            com.atakmap.math.PointD r3 = r5.f8421br     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.x     // Catch:{ Exception -> 0x0150 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            r2 = 5
            com.atakmap.math.PointD r3 = r5.f8421br     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.y     // Catch:{ Exception -> 0x0150 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            r2 = 6
            com.atakmap.math.PointD r3 = r5.f8420bl     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.x     // Catch:{ Exception -> 0x0150 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0150 }
            double[] r1 = r0.spoiBounds     // Catch:{ Exception -> 0x0150 }
            r2 = 7
            com.atakmap.math.PointD r3 = r5.f8420bl     // Catch:{ Exception -> 0x0150 }
            double r3 = r3.y     // Catch:{ Exception -> 0x0150 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0150 }
        L_0x0148:
            com.atakmap.coremap.cot.event.CotEvent r0 = makeUasSPOI(r0)     // Catch:{ Exception -> 0x0150 }
            sendCotEvent(r0)     // Catch:{ Exception -> 0x0150 }
            goto L_0x0158
        L_0x0150:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "Exception encountered"
            com.atakmap.coremap.log.Log.e(r1, r2, r0)
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.generic.GenericReflector.sendCoT():void");
    }

    public String startLocalCOT() {
        synchronized (this) {
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            Timer timer3 = new Timer();
            this.timer = timer3;
            timer3.schedule(new TimerTask() {
                public void run() {
                    GenericReflector.this.sendCoT();
                }
            }, new Date(), 1000);
        }
        return null;
    }

    public void stopLocalCOT() {
        synchronized (this) {
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            this.timer = null;
        }
    }
}
