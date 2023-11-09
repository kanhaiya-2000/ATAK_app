package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

public class Speed implements DroneAttribute {
    public static final Parcelable.Creator<Speed> CREATOR = new Parcelable.Creator<Speed>() {
        public Speed createFromParcel(Parcel parcel) {
            return new Speed(parcel);
        }

        public Speed[] newArray(int i) {
            return new Speed[i];
        }
    };
    private double airSpeed;
    private double groundSpeed;
    private double verticalSpeed;

    public int describeContents() {
        return 0;
    }

    public Speed() {
    }

    public Speed(double d, double d2, double d3) {
        this.verticalSpeed = d;
        this.groundSpeed = d2;
        this.airSpeed = d3;
    }

    public void setVerticalSpeed(double d) {
        this.verticalSpeed = d;
    }

    public void setGroundSpeed(double d) {
        this.groundSpeed = d;
    }

    public void setAirSpeed(double d) {
        this.airSpeed = d;
    }

    public double getVerticalSpeed() {
        return this.verticalSpeed;
    }

    public double getGroundSpeed() {
        return this.groundSpeed;
    }

    public double getAirSpeed() {
        return this.airSpeed;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Speed)) {
            return false;
        }
        Speed speed = (Speed) obj;
        return Double.compare(speed.airSpeed, this.airSpeed) == 0 && Double.compare(speed.groundSpeed, this.groundSpeed) == 0 && Double.compare(speed.verticalSpeed, this.verticalSpeed) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.verticalSpeed);
        long doubleToLongBits2 = Double.doubleToLongBits(this.groundSpeed);
        long doubleToLongBits3 = Double.doubleToLongBits(this.airSpeed);
        return (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public String toString() {
        return "Speed{verticalSpeed=" + this.verticalSpeed + ", groundSpeed=" + this.groundSpeed + ", airSpeed=" + this.airSpeed + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.verticalSpeed);
        parcel.writeDouble(this.groundSpeed);
        parcel.writeDouble(this.airSpeed);
    }

    private Speed(Parcel parcel) {
        this.verticalSpeed = parcel.readDouble();
        this.groundSpeed = parcel.readDouble();
        this.airSpeed = parcel.readDouble();
    }
}
