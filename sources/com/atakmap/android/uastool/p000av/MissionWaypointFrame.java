package com.atakmap.android.uastool.p000av;

import com.atakmap.android.uastool.p000av.AvParser;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.atakmap.android.uastool.av.MissionWaypointFrame */
public class MissionWaypointFrame extends GCSUplinkMessage {
    private static final int FRAMEID = 58;
    private static final double toRadians = 0.017453292519943295d;
    private double alt;
    private double dtedAlt;
    private double lat;
    private double lon;
    private int waypointIndex;

    public /* bridge */ /* synthetic */ int getXid() {
        return super.getXid();
    }

    public /* bridge */ /* synthetic */ byte[] renderNativeFrame() {
        return super.renderNativeFrame();
    }

    public MissionWaypointFrame() {
        setFrameID(58);
    }

    public MissionWaypointFrame(MissionWaypoint missionWaypoint) {
        setFrameID(58);
        setWaypointIndex(missionWaypoint.getWaypointType());
        setLatRadians(missionWaypoint.getLatitudeRadians() * 1.0E8d);
        setLonRadians(missionWaypoint.getLongitudeRadians() * 1.0E8d);
        setAlt(missionWaypoint.getAltitude());
        setDtedAlt(missionWaypoint.getDted());
    }

    public MissionWaypointFrame(AvParser.Waypoint waypoint, GeoPoint geoPoint) {
        setFrameID(58);
        setWaypointIndex(waypoint.ordinal());
        setLatDegrees(geoPoint.getLatitude() * toRadians * 1.0E8d);
        setLonDegrees(geoPoint.getLongitude() * toRadians * 1.0E8d);
        setAlt(geoPoint.getAltitude());
        setDtedAlt(geoPoint.getAltitude());
    }

    public byte[] renderNativeCommand() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(((byte) getWaypointIndex()) & 255);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt((int) getLat());
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
            allocate.putInt((int) getLon());
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
            allocate.putShort((short) ((int) getAlt()));
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
            allocate.putShort((short) ((int) getDtedAlt()));
            byteArrayOutputStream.write(allocate.array());
            allocate.clear();
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    private int getWaypointIndex() {
        return this.waypointIndex;
    }

    public void setWaypointIndex(int i) {
        this.waypointIndex = i;
    }

    private double getLat() {
        return this.lat;
    }

    private void setLatRadians(double d) {
        this.lat = d * 1.0E8d;
    }

    public void setLatDegrees(double d) {
        this.lat = d * toRadians * 1.0E8d;
    }

    private double getLon() {
        return this.lon;
    }

    private void setLonRadians(double d) {
        this.lon = d * 1.0E8d;
    }

    public void setLonDegrees(double d) {
        this.lon = d * toRadians * 1.0E8d;
    }

    private double getAlt() {
        return this.alt;
    }

    public void setAlt(double d) {
        this.alt = d;
    }

    private double getDtedAlt() {
        return this.dtedAlt;
    }

    public void setDtedAlt(double d) {
        this.dtedAlt = d;
    }
}
