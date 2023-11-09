package com.aeryon.java.types;

public class Position {
    private Vec3dLLA commanded;
    private Vec3dLLA estimated;

    public Position(Vec3dLLA vec3dLLA, Vec3dLLA vec3dLLA2) {
        this.estimated = vec3dLLA;
        this.commanded = vec3dLLA2;
    }

    public Vec3dLLA getEstimatedPosition() {
        return this.estimated;
    }

    public String toString() {
        return "Estimated: " + this.estimated.toString() + ", Commanded: " + this.commanded.toString();
    }
}
