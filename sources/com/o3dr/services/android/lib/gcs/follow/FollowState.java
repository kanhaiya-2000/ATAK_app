package com.o3dr.services.android.lib.gcs.follow;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;

public class FollowState implements DroneAttribute {
    public static final Parcelable.Creator<FollowState> CREATOR = new Parcelable.Creator<FollowState>() {
        public FollowState createFromParcel(Parcel parcel) {
            return new FollowState(parcel);
        }

        public FollowState[] newArray(int i) {
            return new FollowState[i];
        }
    };
    public static final int STATE_DRONE_DISCONNECTED = 2;
    public static final int STATE_DRONE_NOT_ARMED = 1;
    public static final int STATE_END = 5;
    public static final int STATE_INVALID = 0;
    public static final int STATE_RUNNING = 4;
    public static final int STATE_START = 3;
    private FollowType mode;
    private Bundle modeParams;
    private int state;

    public int describeContents() {
        return 0;
    }

    public FollowState() {
    }

    public FollowState(int i, FollowType followType, Bundle bundle) {
        this.state = i;
        this.modeParams = bundle;
        this.mode = followType;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setMode(FollowType followType) {
        this.mode = followType;
    }

    public Bundle getParams() {
        return this.modeParams;
    }

    public int getState() {
        return this.state;
    }

    public FollowType getMode() {
        return this.mode;
    }

    public boolean isEnabled() {
        int i = this.state;
        return i == 4 || i == 3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.state);
        parcel.writeBundle(this.modeParams);
        FollowType followType = this.mode;
        parcel.writeInt(followType == null ? -1 : followType.ordinal());
    }

    private FollowState(Parcel parcel) {
        FollowType followType;
        this.state = parcel.readInt();
        this.modeParams = parcel.readBundle();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            followType = null;
        } else {
            followType = FollowType.values()[readInt];
        }
        this.mode = followType;
    }
}
