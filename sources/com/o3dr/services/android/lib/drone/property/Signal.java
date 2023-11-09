package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

public class Signal implements DroneAttribute {
    public static final Parcelable.Creator<Signal> CREATOR = new Parcelable.Creator<Signal>() {
        public Signal createFromParcel(Parcel parcel) {
            return new Signal(parcel);
        }

        public Signal[] newArray(int i) {
            return new Signal[i];
        }
    };
    public static final int MAX_FADE_MARGIN = 50;
    public static final int MIN_FADE_MARGIN = 6;
    private int fixed;
    private boolean isValid;
    private double noise;
    private double remnoise;
    private double remrssi;
    private double rssi;
    private int rxerrors;
    private double signalStrength;
    private int txbuf;

    public int describeContents() {
        return 0;
    }

    public Signal() {
    }

    public Signal(boolean z, int i, int i2, int i3, double d, double d2, double d3, double d4, double d5) {
        this.isValid = z;
        this.rxerrors = i;
        this.fixed = i2;
        this.txbuf = i3;
        this.rssi = d;
        this.remrssi = d2;
        this.noise = d3;
        this.remnoise = d4;
        this.signalStrength = d5;
    }

    public double getSignalStrength() {
        return this.signalStrength;
    }

    public void setSignalStrength(double d) {
        this.signalStrength = d;
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    public void setRxerrors(int i) {
        this.rxerrors = i;
    }

    public void setFixed(int i) {
        this.fixed = i;
    }

    public void setTxbuf(int i) {
        this.txbuf = i;
    }

    public void setRssi(double d) {
        this.rssi = d;
    }

    public void setRemrssi(double d) {
        this.remrssi = d;
    }

    public void setNoise(double d) {
        this.noise = d;
    }

    public void setRemnoise(double d) {
        this.remnoise = d;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public int getRxerrors() {
        return this.rxerrors;
    }

    public int getFixed() {
        return this.fixed;
    }

    public int getTxbuf() {
        return this.txbuf;
    }

    public double getRssi() {
        return this.rssi;
    }

    public double getRemrssi() {
        return this.remrssi;
    }

    public double getNoise() {
        return this.noise;
    }

    public double getRemnoise() {
        return this.remnoise;
    }

    public double getFadeMargin() {
        return this.rssi - this.noise;
    }

    public double getRemFadeMargin() {
        return this.remrssi - this.remnoise;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isValid ? (byte) 1 : 0);
        parcel.writeInt(this.rxerrors);
        parcel.writeInt(this.fixed);
        parcel.writeInt(this.txbuf);
        parcel.writeDouble(this.rssi);
        parcel.writeDouble(this.remrssi);
        parcel.writeDouble(this.noise);
        parcel.writeDouble(this.remnoise);
        parcel.writeDouble(this.signalStrength);
    }

    private Signal(Parcel parcel) {
        this.isValid = parcel.readByte() != 0;
        this.rxerrors = parcel.readInt();
        this.fixed = parcel.readInt();
        this.txbuf = parcel.readInt();
        this.rssi = parcel.readDouble();
        this.remrssi = parcel.readDouble();
        this.noise = parcel.readDouble();
        this.remnoise = parcel.readDouble();
        this.signalStrength = parcel.readDouble();
    }
}
