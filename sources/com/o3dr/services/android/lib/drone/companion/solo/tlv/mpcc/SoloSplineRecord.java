package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplineRecord extends TLVPacket {
    public static final Parcelable.Creator<SoloSplineRecord> CREATOR = new Parcelable.Creator<SoloSplineRecord>() {
        public SoloSplineRecord createFromParcel(Parcel parcel) {
            return new SoloSplineRecord(parcel);
        }

        public SoloSplineRecord[] newArray(int i) {
            return new SoloSplineRecord[i];
        }
    };
    public static final int MESSAGE_LENGTH = 0;

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public SoloSplineRecord() {
        super(50, 0);
    }

    protected SoloSplineRecord(Parcel parcel) {
        super(parcel);
    }
}
