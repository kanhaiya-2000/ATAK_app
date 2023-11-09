package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloPause extends TLVPacket {
    public static final Parcelable.Creator<SoloPause> CREATOR = new Parcelable.Creator<SoloPause>() {
        public SoloPause createFromParcel(Parcel parcel) {
            return new SoloPause(parcel);
        }

        public SoloPause[] newArray(int i) {
            return new SoloPause[i];
        }
    };

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public String toString() {
        return "SoloPause{}";
    }

    public SoloPause() {
        super(7, 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected SoloPause(Parcel parcel) {
        super(parcel);
    }
}
