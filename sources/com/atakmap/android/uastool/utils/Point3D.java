package com.atakmap.android.uastool.utils;

import com.atakmap.math.PointD;

public class Point3D extends PointD {
    public Point3D(double d, double d2, double d3) {
        super(d, d2, d3);
    }

    public Point3D(PointD pointD) {
        super(pointD.x, pointD.y, pointD.z);
    }

    public Point3D toUnitVector() {
        double sqrt = Math.sqrt(Math.pow(this.x, 2.0d) + Math.pow(this.y, 2.0d) + Math.pow(this.z, 2.0d));
        return new Point3D(this.x / sqrt, this.y / sqrt, this.z / sqrt);
    }

    public Point3D scale(double d) {
        return new Point3D(this.x * d, this.y * d, this.z * d);
    }

    public double dot(Point3D point3D) {
        return (this.x * point3D.x) + (this.y * point3D.y) + (this.z * point3D.z);
    }

    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    public double XYMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2.0d) + Math.pow(this.y, 2.0d));
    }

    public double XYZMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2.0d) + Math.pow(this.y, 2.0d) + Math.pow(this.z, 2.0d));
    }
}
