package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;

public class SoloButtonSettingSetter extends SoloButtonSetting {
    public static final Parcelable.Creator<SoloButtonSettingSetter> CREATOR = new Parcelable.Creator<SoloButtonSettingSetter>() {
        public SoloButtonSettingSetter createFromParcel(Parcel parcel) {
            return new SoloButtonSettingSetter(parcel);
        }

        public SoloButtonSettingSetter[] newArray(int i) {
            return new SoloButtonSettingSetter[i];
        }
    };

    public SoloButtonSettingSetter(int i, int i2, int i3, int i4) {
        super(6, i, i2, i3, i4);
    }

    public SoloButtonSettingSetter(int i, int i2) {
        this(i, i2, -1, -1);
    }

    protected SoloButtonSettingSetter(Parcel parcel) {
        super(parcel);
    }
}
