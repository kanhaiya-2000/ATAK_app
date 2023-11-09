package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;

public class GuidedState implements DroneAttribute {
    public static final Parcelable.Creator<GuidedState> CREATOR = new Parcelable.Creator<GuidedState>() {
        public GuidedState createFromParcel(Parcel parcel) {
            return new GuidedState(parcel);
        }

        public GuidedState[] newArray(int i) {
            return new GuidedState[i];
        }
    };
    public static final int STATE_ACTIVE = 2;
    public static final int STATE_IDLE = 1;
    public static final int STATE_UNINITIALIZED = 0;
    private LatLongAlt coordinate;
    private int state;

    public int describeContents() {
        return 0;
    }

    public GuidedState() {
    }

    public GuidedState(int i, LatLongAlt latLongAlt) {
        this.state = i;
        this.coordinate = latLongAlt;
    }

    public boolean isActive() {
        return this.state == 2;
    }

    public boolean isIdle() {
        return this.state == 1;
    }

    public boolean isInitialized() {
        return this.state != 0;
    }

    public LatLongAlt getCoordinate() {
        return this.coordinate;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setCoordinate(LatLongAlt latLongAlt) {
        this.coordinate = latLongAlt;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.state);
        parcel.writeParcelable(this.coordinate, i);
    }

    private GuidedState(Parcel parcel) {
        this.state = parcel.readInt();
        this.coordinate = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
    }
}
