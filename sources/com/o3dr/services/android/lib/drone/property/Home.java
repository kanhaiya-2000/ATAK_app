package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;

public class Home implements DroneAttribute {
    public static final Parcelable.Creator<Home> CREATOR = new Parcelable.Creator<Home>() {
        public Home createFromParcel(Parcel parcel) {
            return new Home(parcel);
        }

        public Home[] newArray(int i) {
            return new Home[i];
        }
    };
    private LatLongAlt mCoordinate;

    public int describeContents() {
        return 0;
    }

    public Home() {
    }

    public Home(double d, double d2, double d3) {
        this.mCoordinate = new LatLongAlt(d, d2, d3);
    }

    public Home(LatLongAlt latLongAlt) {
        this.mCoordinate = latLongAlt;
    }

    public LatLongAlt getCoordinate() {
        return this.mCoordinate;
    }

    public void setCoordinate(LatLongAlt latLongAlt) {
        this.mCoordinate = latLongAlt;
    }

    public boolean isValid() {
        return this.mCoordinate != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Home)) {
            return false;
        }
        LatLongAlt latLongAlt = this.mCoordinate;
        LatLongAlt latLongAlt2 = ((Home) obj).mCoordinate;
        if (latLongAlt != null) {
            if (!latLongAlt.equals(latLongAlt2)) {
                return false;
            }
            return true;
        } else if (latLongAlt2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        LatLongAlt latLongAlt = this.mCoordinate;
        if (latLongAlt != null) {
            return latLongAlt.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "LaunchPad{mCoordinate=" + this.mCoordinate + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mCoordinate, 0);
    }

    private Home(Parcel parcel) {
        this.mCoordinate = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
    }
}
