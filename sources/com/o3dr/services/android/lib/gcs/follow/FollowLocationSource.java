package com.o3dr.services.android.lib.gcs.follow;

import android.os.Parcel;
import android.os.Parcelable;

public enum FollowLocationSource implements Parcelable {
    NONE("None"),
    INTERNAL("Device GPS"),
    CLIENT_SPECIFIED("Client Specified");
    
    public static final Parcelable.Creator<FollowLocationSource> CREATOR = null;
    private final String mLabel;

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Parcelable.Creator<FollowLocationSource>() {
            public FollowLocationSource createFromParcel(Parcel parcel) {
                return FollowLocationSource.valueOf(parcel.readString());
            }

            public FollowLocationSource[] newArray(int i) {
                return new FollowLocationSource[i];
            }
        };
    }

    private FollowLocationSource(String str) {
        this.mLabel = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String toString() {
        return getLabel();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
