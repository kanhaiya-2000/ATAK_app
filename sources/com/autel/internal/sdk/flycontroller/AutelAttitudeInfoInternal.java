package com.autel.internal.sdk.flycontroller;

import com.autel.common.flycontroller.AttitudeInfo;

public class AutelAttitudeInfoInternal implements AttitudeInfo {
    private double pitch = 0.0d;
    private double roll = 0.0d;
    private double yaw = 0.0d;

    public enum DataUnit {
        RADIAN,
        ANGLE
    }

    /* access modifiers changed from: protected */
    public void setRoll(double d) {
        this.roll = d;
    }

    /* access modifiers changed from: protected */
    public void setPitch(double d) {
        this.pitch = d;
    }

    /* access modifiers changed from: protected */
    public void setYaw(double d) {
        this.yaw = d;
    }

    public double getRoll(DataUnit dataUnit) {
        return dataUnit == DataUnit.RADIAN ? this.roll : Math.toDegrees(this.roll);
    }

    public double getPitch(DataUnit dataUnit) {
        return dataUnit == DataUnit.RADIAN ? this.pitch : Math.toDegrees(this.pitch);
    }

    public double getYaw(DataUnit dataUnit) {
        return dataUnit == DataUnit.RADIAN ? this.yaw : Math.toDegrees(this.yaw);
    }

    public double getRoll() {
        return getRoll(DataUnit.ANGLE);
    }

    public double getPitch() {
        return getPitch(DataUnit.ANGLE);
    }

    public double getYaw() {
        return getYaw(DataUnit.ANGLE);
    }

    public String toString() {
        return "Attitude:　roll＝" + this.roll + "　pitch＝" + this.pitch + "　yaw＝" + this.yaw;
    }
}
