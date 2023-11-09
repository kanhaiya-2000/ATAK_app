package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;

public class SoloMessageShotSetter extends SoloMessageShot {
    public static final Parcelable.Creator<SoloMessageShotSetter> CREATOR = new Parcelable.Creator<SoloMessageShotSetter>() {
        public SoloMessageShotSetter createFromParcel(Parcel parcel) {
            return new SoloMessageShotSetter(parcel);
        }

        public SoloMessageShotSetter[] newArray(int i) {
            return new SoloMessageShotSetter[i];
        }
    };

    public SoloMessageShotSetter(int i) {
        super(1, i);
    }

    protected SoloMessageShotSetter(Parcel parcel) {
        super(parcel);
    }
}
