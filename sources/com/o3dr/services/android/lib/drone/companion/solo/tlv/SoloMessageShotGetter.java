package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;

public class SoloMessageShotGetter extends SoloMessageShot {
    public static final Parcelable.Creator<SoloMessageShotGetter> CREATOR = new Parcelable.Creator<SoloMessageShotGetter>() {
        public SoloMessageShotGetter createFromParcel(Parcel parcel) {
            return new SoloMessageShotGetter(parcel);
        }

        public SoloMessageShotGetter[] newArray(int i) {
            return new SoloMessageShotGetter[i];
        }
    };

    public SoloMessageShotGetter(int i) {
        super(0, i);
    }

    protected SoloMessageShotGetter(Parcel parcel) {
        super(parcel);
    }
}
