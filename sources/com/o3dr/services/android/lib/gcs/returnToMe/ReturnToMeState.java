package com.o3dr.services.android.lib.gcs.returnToMe;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ReturnToMeState implements DroneAttribute {
    public static final Parcelable.Creator<ReturnToMeState> CREATOR = new Parcelable.Creator<ReturnToMeState>() {
        public ReturnToMeState createFromParcel(Parcel parcel) {
            return new ReturnToMeState(parcel);
        }

        public ReturnToMeState[] newArray(int i) {
            return new ReturnToMeState[i];
        }
    };
    public static final int STATE_ERROR_UPDATING_HOME = 5;
    public static final int STATE_IDLE = 0;
    public static final int STATE_UPDATING_HOME = 4;
    public static final int STATE_USER_LOCATION_INACCURATE = 2;
    public static final int STATE_USER_LOCATION_UNAVAILABLE = 1;
    public static final int STATE_WAITING_FOR_VEHICLE_GPS = 3;
    private LatLongAlt currentHomeLocation;
    private LatLongAlt originalHomeLocation;
    private int state = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReturnToMeStates {
    }

    public int describeContents() {
        return 0;
    }

    public ReturnToMeState() {
    }

    public ReturnToMeState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public LatLongAlt getCurrentHomeLocation() {
        return this.currentHomeLocation;
    }

    public void setCurrentHomeLocation(LatLongAlt latLongAlt) {
        this.currentHomeLocation = latLongAlt == null ? null : new LatLongAlt(latLongAlt);
    }

    public LatLongAlt getOriginalHomeLocation() {
        return this.originalHomeLocation;
    }

    public void setOriginalHomeLocation(LatLongAlt latLongAlt) {
        this.originalHomeLocation = latLongAlt == null ? null : new LatLongAlt(latLongAlt);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.state);
        parcel.writeParcelable(this.originalHomeLocation, 0);
        parcel.writeParcelable(this.currentHomeLocation, 0);
    }

    protected ReturnToMeState(Parcel parcel) {
        this.state = parcel.readInt();
        this.originalHomeLocation = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
        this.currentHomeLocation = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
    }
}
