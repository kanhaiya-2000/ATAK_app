package com.aeryon.java.types;

public class Vec3dNED {
    private final double down;
    private final double east;
    private final double north;

    public Vec3dNED(double d, double d2, double d3) {
        this.north = d;
        this.east = d2;
        this.down = d3;
    }

    public String toString() {
        return String.format("(%f, %f, %f)", new Object[]{Double.valueOf(this.north), Double.valueOf(this.east), Double.valueOf(this.down)});
    }

    public double getNorth() {
        return this.north;
    }

    public double getEast() {
        return this.east;
    }

    public double getDown() {
        return this.down;
    }

    public double getNESpeed() {
        double d = this.north;
        double d2 = this.east;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    public double getVerticalSpeed() {
        return this.down;
    }
}
