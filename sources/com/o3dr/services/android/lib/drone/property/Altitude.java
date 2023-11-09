package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

public class Altitude implements DroneAttribute {
    public static final Parcelable.Creator<Altitude> CREATOR = new Parcelable.Creator<Altitude>() {
        public Altitude createFromParcel(Parcel parcel) {
            return new Altitude(parcel);
        }

        public Altitude[] newArray(int i) {
            return new Altitude[i];
        }
    };
    private double altitude;
    private double targetAltitude;

    public int describeContents() {
        return 0;
    }

    public Altitude() {
    }

    public Altitude(double d, double d2) {
        this.altitude = d;
        this.targetAltitude = d2;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public double getTargetAltitude() {
        return this.targetAltitude;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public void setTargetAltitude(double d) {
        this.targetAltitude = d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Altitude)) {
            return false;
        }
        Altitude altitude2 = (Altitude) obj;
        return Double.compare(altitude2.altitude, this.altitude) == 0 && Double.compare(altitude2.targetAltitude, this.targetAltitude) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.altitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.targetAltitude);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "Altitude{altitude=" + this.altitude + ", targetAltitude=" + this.targetAltitude + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.altitude);
        parcel.writeDouble(this.targetAltitude);
    }

    private Altitude(Parcel parcel) {
        this.altitude = parcel.readDouble();
        this.targetAltitude = parcel.readDouble();
    }
}
