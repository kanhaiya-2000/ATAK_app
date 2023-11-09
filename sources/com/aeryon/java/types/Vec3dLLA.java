package com.aeryon.java.types;

public class Vec3dLLA {
    private final double height;
    private final double lat;
    private final double lon;

    public Vec3dLLA(double d, double d2, double d3) {
        this.lat = d;
        this.lon = d2;
        this.height = d3;
    }

    public static Vec3dLLA fromRadians(double d, double d2, double d3) {
        return new Vec3dLLA(Math.toDegrees(d), Math.toDegrees(d2), d3);
    }

    public String toString() {
        return String.format("(%f, %f, %f)", new Object[]{Double.valueOf(this.lat), Double.valueOf(this.lon), Double.valueOf(this.height)});
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public double getAltitude() {
        return this.height;
    }
}
