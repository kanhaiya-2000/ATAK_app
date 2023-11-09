package com.atakmap.android.uastool.p000av;

import com.atakmap.coremap.log.Log;

/* renamed from: com.atakmap.android.uastool.av.MissionParameter */
public class MissionParameter extends GCSMessage {
    private static final String TAG = "MissionParameter";
    private double dtedAltOrigin;
    private boolean excludeTimeouts = false;
    private short flightCycleTime;
    private short gpsTimeout;
    private boolean initialized = false;
    private double rallyAltitude;
    private int rallyMode;
    private double safeAltOffset;
    private double safeAltitude;
    private short uplinkTimeout;

    public MissionParameter(byte[] bArr) {
        try {
            if (bArr.length == 11) {
                this.excludeTimeouts = true;
            } else if (bArr.length != 15) {
                return;
            }
            this.rallyMode = bArr[0];
            this.rallyAltitude = getDouble(bArr[1], bArr[2], 1.0d);
            this.flightCycleTime = getShort(bArr[3], bArr[4]);
            this.dtedAltOrigin = getDouble(bArr[5], bArr[6], 1.0d);
            this.safeAltitude = getDouble(bArr[7], bArr[8], 1.0d);
            this.safeAltOffset = getDouble(bArr[9], bArr[10], 1.0d);
            if (!this.excludeTimeouts) {
                this.uplinkTimeout = getShort(bArr[11], bArr[12]);
                this.gpsTimeout = getShort(bArr[13], bArr[14]);
            }
            this.initialized = true;
        } catch (Exception e) {
            Log.e(TAG, "Parsing exception", e);
        }
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public int getRallyMode() {
        return this.rallyMode;
    }

    public double getRallyAltitude() {
        return this.rallyAltitude;
    }

    public short getFlightCycleTime() {
        return this.flightCycleTime;
    }

    public double getDtedAltOrigin() {
        return this.dtedAltOrigin;
    }

    public double getSafeAltitude() {
        return this.safeAltitude;
    }

    public double getSafeAltOffset() {
        return this.safeAltOffset;
    }

    public short getUplinkTimeout() {
        return this.uplinkTimeout;
    }

    public short getGpsTimeout() {
        return this.gpsTimeout;
    }

    public boolean isExcludeTimeouts() {
        return this.excludeTimeouts;
    }
}
