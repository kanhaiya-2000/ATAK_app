package com.autel.internal.sdk.flycontroller;

import com.autel.common.flycontroller.AltitudeAndSpeedInfo;

public class AutelAltitudeAndSpeedInfoInternal implements AltitudeAndSpeedInfo {
    private float altitude = 0.0f;
    private float xSpeed;
    private float ySpeed;
    private float zSpeed;

    /* access modifiers changed from: protected */
    public void setAltitude(float f) {
        this.altitude = f;
    }

    /* access modifiers changed from: protected */
    public void setXSpeed(float f) {
        this.xSpeed = f;
    }

    /* access modifiers changed from: protected */
    public void setYSpeed(float f) {
        this.ySpeed = f;
    }

    /* access modifiers changed from: protected */
    public void setZSpeed(float f) {
        this.zSpeed = f;
    }

    public float getAltitude() {
        return this.altitude;
    }

    public float getXSpeed() {
        return this.xSpeed;
    }

    public float getYSpeed() {
        return this.ySpeed;
    }

    public float getZSpeed() {
        return this.zSpeed;
    }

    public float getSpeed() {
        float f = this.xSpeed;
        float f2 = this.ySpeed;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.zSpeed;
        return (float) Math.sqrt((double) (f3 + (f4 * f4)));
    }

    public String toString() {
        return "altitude : " + this.altitude + ",　xSpeed : " + this.xSpeed + ",　ySpeed : " + this.ySpeed + ",　zSpeed : " + this.zSpeed + ",　Speed : " + getSpeed();
    }
}
