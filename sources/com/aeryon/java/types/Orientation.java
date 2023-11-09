package com.aeryon.java.types;

public class Orientation {
    private Vec3dRPY commanded;
    private Vec3dRPY estimated;

    public Orientation(Vec3dRPY vec3dRPY, Vec3dRPY vec3dRPY2) {
        this.estimated = vec3dRPY;
        this.commanded = vec3dRPY2;
    }

    public Vec3dRPY getEstimatedOrientation() {
        return this.estimated;
    }

    public String toString() {
        return "Estimated: " + this.estimated.toString() + ", Commanded: " + this.commanded.toString();
    }
}
