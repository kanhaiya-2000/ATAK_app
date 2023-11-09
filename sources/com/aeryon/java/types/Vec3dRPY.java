package com.aeryon.java.types;

public class Vec3dRPY {
    private final double pitch;
    private final double roll;
    private final double yaw;

    public Vec3dRPY(double d, double d2, double d3) {
        this.roll = d;
        this.pitch = d2;
        this.yaw = d3;
    }

    public static Vec3dRPY fromRadians(double d, double d2, double d3) {
        return new Vec3dRPY(Math.toDegrees(d), Math.toDegrees(d2), Math.toDegrees(d3));
    }

    public String toString() {
        return String.format("(%f, %f, %f)", new Object[]{Double.valueOf(this.roll), Double.valueOf(this.pitch), Double.valueOf(this.yaw)});
    }

    public double getRoll() {
        return this.roll;
    }

    public double getPitch() {
        return this.pitch;
    }

    public double getYaw() {
        return this.yaw;
    }
}
