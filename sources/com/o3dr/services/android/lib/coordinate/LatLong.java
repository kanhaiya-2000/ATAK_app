package com.o3dr.services.android.lib.coordinate;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class LatLong implements Parcelable, Serializable {
    public static final Parcelable.Creator<LatLong> CREATOR = new Parcelable.Creator<LatLong>() {
        public LatLong createFromParcel(Parcel parcel) {
            return (LatLong) parcel.readSerializable();
        }

        public LatLong[] newArray(int i) {
            return new LatLong[i];
        }
    };
    private static final long serialVersionUID = -5809863197722412339L;
    private double latitude;
    private double longitude;

    public int describeContents() {
        return 0;
    }

    public LatLong(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public LatLong(LatLong latLong) {
        this(latLong.getLatitude(), latLong.getLongitude());
    }

    public void set(LatLong latLong) {
        this.latitude = latLong.latitude;
        this.longitude = latLong.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public LatLong dot(double d) {
        return new LatLong(this.latitude * d, this.longitude * d);
    }

    public LatLong negate() {
        return new LatLong(this.latitude * -1.0d, this.longitude * -1.0d);
    }

    public LatLong subtract(LatLong latLong) {
        return new LatLong(this.latitude - latLong.latitude, this.longitude - latLong.longitude);
    }

    public LatLong sum(LatLong latLong) {
        return new LatLong(this.latitude + latLong.latitude, this.longitude + latLong.longitude);
    }

    public static LatLong sum(LatLong... latLongArr) {
        double d = 0.0d;
        double d2 = 0.0d;
        for (LatLong latLong : latLongArr) {
            d += latLong.latitude;
            d2 += latLong.longitude;
        }
        return new LatLong(d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLong)) {
            return false;
        }
        LatLong latLong = (LatLong) obj;
        return Double.compare(latLong.latitude, this.latitude) == 0 && Double.compare(latLong.longitude, this.longitude) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "LatLong{latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this);
    }
}
