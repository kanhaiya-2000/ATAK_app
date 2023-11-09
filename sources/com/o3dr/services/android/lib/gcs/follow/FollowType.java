package com.o3dr.services.android.lib.gcs.follow;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public enum FollowType implements Parcelable {
    LEASH("Leash"),
    LEAD("Lead"),
    RIGHT("Right"),
    LEFT("Left"),
    CIRCLE("Circle"),
    ABOVE("Above") {
        public boolean hasParam(String str) {
            return false;
        }
    },
    GUIDED_SCAN("Guided Scan") {
        public boolean hasParam(String str) {
            str.hashCode();
            return str.equals("extra_follow_roi_target");
        }
    },
    LOOK_AT_ME("Look At Me") {
        public boolean hasParam(String str) {
            return false;
        }
    },
    SOLO_SHOT("Solo Follow Shot") {
        public boolean hasParam(String str) {
            return false;
        }
    };
    
    public static final Parcelable.Creator<FollowType> CREATOR = null;
    public static final String EXTRA_FOLLOW_RADIUS = "extra_follow_radius";
    public static final String EXTRA_FOLLOW_ROI_TARGET = "extra_follow_roi_target";
    private final String typeLabel;

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Parcelable.Creator<FollowType>() {
            public FollowType createFromParcel(Parcel parcel) {
                return FollowType.valueOf(parcel.readString());
            }

            public FollowType[] newArray(int i) {
                return new FollowType[i];
            }
        };
    }

    private FollowType(String str) {
        this.typeLabel = str;
    }

    public boolean hasParam(String str) {
        str.hashCode();
        return str.equals("extra_follow_radius");
    }

    public String getTypeLabel() {
        return this.typeLabel;
    }

    public String toString() {
        return getTypeLabel();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    public static List<FollowType> getFollowTypes(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(LEASH);
        arrayList.add(LEAD);
        arrayList.add(RIGHT);
        arrayList.add(LEFT);
        arrayList.add(CIRCLE);
        arrayList.add(ABOVE);
        arrayList.add(GUIDED_SCAN);
        arrayList.add(LOOK_AT_ME);
        return arrayList;
    }
}
