package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloZiplineLock extends TLVPacket {
    public static final Parcelable.Creator<SoloZiplineLock> CREATOR = new Parcelable.Creator<SoloZiplineLock>() {
        public SoloZiplineLock createFromParcel(Parcel parcel) {
            return new SoloZiplineLock(parcel);
        }

        public SoloZiplineLock[] newArray(int i) {
            return new SoloZiplineLock[i];
        }
    };

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public String toString() {
        return "SoloZiplineLock{}";
    }

    public SoloZiplineLock() {
        super(28, 0);
    }

    protected SoloZiplineLock(Parcel parcel) {
        super(parcel);
    }
}
