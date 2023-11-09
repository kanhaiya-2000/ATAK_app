package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;

public class SoloButtonSettingGetter extends SoloButtonSetting {
    public static final Parcelable.Creator<SoloButtonSettingGetter> CREATOR = new Parcelable.Creator<SoloButtonSettingGetter>() {
        public SoloButtonSettingGetter createFromParcel(Parcel parcel) {
            return new SoloButtonSettingGetter(parcel);
        }

        public SoloButtonSettingGetter[] newArray(int i) {
            return new SoloButtonSettingGetter[i];
        }
    };

    public SoloButtonSettingGetter(int i, int i2, int i3, int i4) {
        super(5, i, i2, i3, i4);
    }

    public SoloButtonSettingGetter(int i, int i2) {
        this(i, i2, -1, -1);
    }

    protected SoloButtonSettingGetter(Parcel parcel) {
        super(parcel);
    }
}
