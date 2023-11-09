package com.autel.AutelNet2.aircraft.gimbal.engine;

import com.autel.common.gimbal.evo.GimbalAngleRange;

public class GimbalAngleRangeImpl implements GimbalAngleRange {
    private int PitchMax;
    private int PitchMin;
    private int RollMax;
    private int RollMin;
    private int YawMax;
    private int YawMin;

    public int getPitchMinimum() {
        return (-this.PitchMin) / 100;
    }

    public void setPitchMin(int i) {
        this.PitchMin = i;
    }

    public int getPitchMax() {
        return (-this.PitchMax) / 100;
    }

    public void setPitchMax(int i) {
        this.PitchMax = i;
    }

    public int getYawMin() {
        return this.YawMin / 100;
    }

    public void setYawMin(int i) {
        this.YawMin = i;
    }

    public int getYawMax() {
        return this.YawMax / 100;
    }

    public void setYawMax(int i) {
        this.YawMax = i;
    }

    public int getRollMin() {
        return this.RollMin / 100;
    }

    public void setRollMin(int i) {
        this.RollMin = i;
    }

    public int getRollMax() {
        return this.RollMax / 100;
    }

    public void setRollMax(int i) {
        this.RollMax = i;
    }

    public String toString() {
        return "PitchMin = " + this.PitchMin + " PitchMax = " + this.PitchMax + "  YawMin = " + this.YawMin + " YawMax = " + this.YawMax + " RollMin = " + this.RollMin + " RollMax = " + this.RollMax;
    }
}
