package com.o3dr.services.android.lib.coordinate;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLongAlt extends LatLong {
    public static final Parcelable.Creator<LatLongAlt> CREATOR = new Parcelable.Creator<LatLongAlt>() {
        public LatLongAlt createFromParcel(Parcel parcel) {
            return (LatLongAlt) parcel.readSerializable();
        }

        public LatLongAlt[] newArray(int i) {
            return new LatLongAlt[i];
        }
    };
    private static final long serialVersionUID = -4771550293045623743L;
    private double mAltitude;

    public LatLongAlt(double d, double d2, double d3) {
        super(d, d2);
        this.mAltitude = d3;
    }

    public LatLongAlt(LatLong latLong, double d) {
        super(latLong);
        this.mAltitude = d;
    }

    public LatLongAlt(LatLongAlt latLongAlt) {
        this(latLongAlt.getLatitude(), latLongAlt.getLongitude(), latLongAlt.getAltitude());
    }

    public void set(LatLongAlt latLongAlt) {
        super.set(latLongAlt);
        this.mAltitude = latLongAlt.mAltitude;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LatLongAlt) && super.equals(obj) && Double.compare(((LatLongAlt) obj).mAltitude, this.mAltitude) == 0;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.mAltitude);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        String latLong = super.toString();
        return "LatLongAlt{" + latLong + ", mAltitude=" + this.mAltitude + '}';
    }
}
