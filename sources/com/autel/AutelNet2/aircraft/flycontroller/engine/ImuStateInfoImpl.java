package com.autel.AutelNet2.aircraft.flycontroller.engine;

import com.autel.common.flycontroller.evo.ImuStateInfo;

public class ImuStateInfoImpl implements ImuStateInfo {
    private float AbsolutePressure;
    private int FieldsUpdated;
    private float Temperature;
    private long TimeUsec;
    private float XAccelerometer;
    private float XAccelerometer1;
    private float XGyroscope;
    private float XGyroscope1;
    private float XMagnetometer;
    private float YAccelerometer;
    private float YAccelerometer1;
    private float YGyroscope;
    private float YGyroscope1;
    private float YMagnetometer;
    private float ZAccelerometer;
    private float ZAccelerometer1;
    private float ZGyroscope;
    private float ZGyroscope1;
    private float ZMagnetometer;

    public long getTimeUsec() {
        return this.TimeUsec;
    }

    public void setTimeUsec(long j) {
        this.TimeUsec = j;
    }

    public float getXAccelerometer() {
        return this.XAccelerometer;
    }

    public void setXAccelerometer(float f) {
        this.XAccelerometer = f;
    }

    public float getYAccelerometer() {
        return this.YAccelerometer;
    }

    public void setYAccelerometer(float f) {
        this.YAccelerometer = f;
    }

    public float getZAccelerometer() {
        return this.ZAccelerometer;
    }

    public void setZAccelerometer(float f) {
        this.ZAccelerometer = f;
    }

    public float getXGyroscope() {
        return this.XGyroscope;
    }

    public void setXGyroscope(float f) {
        this.XGyroscope = f;
    }

    public float getYGyroscope() {
        return this.YGyroscope;
    }

    public void setYGyroscope(float f) {
        this.YGyroscope = f;
    }

    public float getZGyroscope() {
        return this.ZGyroscope;
    }

    public void setZGyroscope(float f) {
        this.ZGyroscope = f;
    }

    public float getXAccelerometer1() {
        return this.XAccelerometer1;
    }

    public void setXAccelerometer1(float f) {
        this.XAccelerometer1 = f;
    }

    public float getYAccelerometer1() {
        return this.YAccelerometer1;
    }

    public void setYAccelerometer1(float f) {
        this.YAccelerometer1 = f;
    }

    public float getZAccelerometer1() {
        return this.ZAccelerometer1;
    }

    public void setZAccelerometer1(float f) {
        this.ZAccelerometer1 = f;
    }

    public float getXGyroscope1() {
        return this.XGyroscope1;
    }

    public void setXGyroscope1(float f) {
        this.XGyroscope1 = f;
    }

    public float getYGyroscope1() {
        return this.YGyroscope1;
    }

    public void setYGyroscope1(float f) {
        this.YGyroscope1 = f;
    }

    public float getZGyroscope1() {
        return this.ZGyroscope1;
    }

    public void setZGyroscope1(float f) {
        this.ZGyroscope1 = f;
    }

    public float getXMagnetometer() {
        return this.XMagnetometer;
    }

    public void setXMagnetometer(float f) {
        this.XMagnetometer = f;
    }

    public float getYMagnetometer() {
        return this.YMagnetometer;
    }

    public void setYMagnetometer(float f) {
        this.YMagnetometer = f;
    }

    public float getZMagnetometer() {
        return this.ZMagnetometer;
    }

    public void setZMagnetometer(float f) {
        this.ZMagnetometer = f;
    }

    public float getAbsolutePressure() {
        return this.AbsolutePressure;
    }

    public void setAbsolutePressure(float f) {
        this.AbsolutePressure = f;
    }

    public float getTemperature() {
        return this.Temperature;
    }

    public void setTemperature(float f) {
        this.Temperature = f;
    }

    public int getFieldsUpdated() {
        return this.FieldsUpdated;
    }

    public void setFieldsUpdated(int i) {
        this.FieldsUpdated = i;
    }

    public String toString() {
        return "TimeUsec:" + this.TimeUsec + " XAccelerometer:" + this.XAccelerometer + " YAccelerometer:" + this.YAccelerometer + " ZAccelerometer:" + this.ZAccelerometer + " XGyroscope:" + this.XGyroscope + " ZGyroscope:" + this.ZGyroscope + " XAccelerometer1:" + this.XAccelerometer1 + " XGyroscope1:" + this.XGyroscope1 + " YAccelerometer1:" + this.YAccelerometer1 + " ZGyroscope1:" + this.ZGyroscope1 + " XMagnetometer:" + this.XMagnetometer + " YMagnetometer:" + this.YMagnetometer + " ZMagnetometer:" + this.ZMagnetometer + " AbsolutePressure:" + this.AbsolutePressure + " Temperature:" + this.Temperature + " FieldsUpdated:" + this.FieldsUpdated + " \n\n";
    }
}
