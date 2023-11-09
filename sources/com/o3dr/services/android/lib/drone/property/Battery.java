package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

public class Battery implements DroneAttribute {
    public static final Parcelable.Creator<Battery> CREATOR = new Parcelable.Creator<Battery>() {
        public Battery createFromParcel(Parcel parcel) {
            return new Battery(parcel);
        }

        public Battery[] newArray(int i) {
            return new Battery[i];
        }
    };
    private double batteryCurrent;
    private Double batteryDischarge;
    private double batteryRemain;
    private double batteryVoltage;

    public int describeContents() {
        return 0;
    }

    public Battery() {
    }

    public Battery(double d, double d2, double d3, Double d4) {
        this.batteryVoltage = d;
        this.batteryRemain = d2;
        this.batteryCurrent = d3;
        this.batteryDischarge = d4;
    }

    public void setBatteryVoltage(double d) {
        this.batteryVoltage = d;
    }

    public void setBatteryRemain(double d) {
        this.batteryRemain = d;
    }

    public void setBatteryCurrent(double d) {
        this.batteryCurrent = d;
    }

    public void setBatteryDischarge(Double d) {
        this.batteryDischarge = d;
    }

    public double getBatteryVoltage() {
        return this.batteryVoltage;
    }

    public double getBatteryRemain() {
        return this.batteryRemain;
    }

    public double getBatteryCurrent() {
        return this.batteryCurrent;
    }

    public Double getBatteryDischarge() {
        return this.batteryDischarge;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.batteryVoltage);
        parcel.writeDouble(this.batteryRemain);
        parcel.writeDouble(this.batteryCurrent);
        parcel.writeValue(this.batteryDischarge);
    }

    private Battery(Parcel parcel) {
        this.batteryVoltage = parcel.readDouble();
        this.batteryRemain = parcel.readDouble();
        this.batteryCurrent = parcel.readDouble();
        this.batteryDischarge = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
