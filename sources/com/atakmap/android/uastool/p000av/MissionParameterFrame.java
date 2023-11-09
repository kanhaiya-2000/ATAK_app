package com.atakmap.android.uastool.p000av;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.atakmap.android.uastool.av.MissionParameterFrame */
public class MissionParameterFrame extends GCSUplinkMessage {
    private static final int FRAMEID = 57;
    private double dtedAltOrigin;
    private boolean excludeTimeouts;
    private short flightCycleTime;
    private short gpsTimeout;
    private double rallyAltitude;
    private int rallyMode;
    private double safeAltOffset;
    private double safeAltitude;
    private short uplinkTimeout;

    public /* bridge */ /* synthetic */ int getXid() {
        return super.getXid();
    }

    public /* bridge */ /* synthetic */ byte[] renderNativeFrame() {
        return super.renderNativeFrame();
    }

    public MissionParameterFrame() {
        setFrameID(57);
    }

    public MissionParameterFrame(MissionParameter missionParameter) {
        setFrameID(57);
        setRallyMode(missionParameter.getRallyMode());
        setRallyAltitude(missionParameter.getRallyAltitude());
        setFlightCycleTime(missionParameter.getFlightCycleTime());
        setDtedAltOrigin(missionParameter.getDtedAltOrigin());
        setSafeAltitude(missionParameter.getSafeAltitude());
        setSafeAltOffset(missionParameter.getSafeAltOffset());
        setExcludeTimeouts(missionParameter.isExcludeTimeouts());
        setUplinkTimeout(missionParameter.getUplinkTimeout());
        setGpsTimeout(missionParameter.getGpsTimeout());
    }

    public byte[] renderNativeCommand() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(((byte) getRallyMode()) & 255);
            ByteBuffer allocate = ByteBuffer.allocate(2);
            allocate.putShort((short) ((int) getRallyAltitude()));
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
            allocate.putShort(getFlightCycleTime());
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
            allocate.putShort((short) ((int) getDtedAltOrigin()));
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
            allocate.putShort((short) ((int) getSafeAltitude()));
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
            allocate.putShort((short) ((int) getSafeAltOffset()));
            byteArrayOutputStream.write(allocate.array());
            if (!isExcludeTimeouts()) {
                allocate.clear();
                allocate.putShort(getUplinkTimeout());
                byteArrayOutputStream.write(allocate.array());
                allocate.clear();
                allocate.putShort(getGpsTimeout());
                byteArrayOutputStream.write(allocate.array());
            }
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    private int getRallyMode() {
        return this.rallyMode;
    }

    private void setRallyMode(int i) {
        this.rallyMode = i;
    }

    private double getRallyAltitude() {
        return this.rallyAltitude;
    }

    private void setRallyAltitude(double d) {
        this.rallyAltitude = d;
    }

    private short getFlightCycleTime() {
        return this.flightCycleTime;
    }

    private void setFlightCycleTime(short s) {
        this.flightCycleTime = s;
    }

    private double getDtedAltOrigin() {
        return this.dtedAltOrigin;
    }

    private void setDtedAltOrigin(double d) {
        this.dtedAltOrigin = d;
    }

    private double getSafeAltitude() {
        return this.safeAltitude;
    }

    private void setSafeAltitude(double d) {
        this.safeAltitude = d;
    }

    private double getSafeAltOffset() {
        return this.safeAltOffset;
    }

    private void setSafeAltOffset(double d) {
        this.safeAltOffset = d;
    }

    private short getUplinkTimeout() {
        return this.uplinkTimeout;
    }

    private void setUplinkTimeout(short s) {
        this.uplinkTimeout = s;
    }

    private short getGpsTimeout() {
        return this.gpsTimeout;
    }

    private void setGpsTimeout(short s) {
        this.gpsTimeout = s;
    }

    private boolean isExcludeTimeouts() {
        return this.excludeTimeouts;
    }

    private void setExcludeTimeouts(boolean z) {
        this.excludeTimeouts = z;
    }
}
