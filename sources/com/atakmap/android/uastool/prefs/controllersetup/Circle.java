package com.atakmap.android.uastool.prefs.controllersetup;

public class Circle {
    public float centerX = 0.0f;
    public float centerY = 0.0f;
    public float radius = 0.0f;

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setCircle(float f, float f2, float f3) {
        this.centerX = f;
        this.centerY = f2;
        this.radius = f3;
    }
}
