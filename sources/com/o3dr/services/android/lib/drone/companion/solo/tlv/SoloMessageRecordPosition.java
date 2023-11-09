package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloMessageRecordPosition extends TLVPacket {
    public static final Parcelable.Creator<SoloMessageRecordPosition> CREATOR = new Parcelable.Creator<SoloMessageRecordPosition>() {
        public SoloMessageRecordPosition createFromParcel(Parcel parcel) {
            return new SoloMessageRecordPosition(parcel);
        }

        public SoloMessageRecordPosition[] newArray(int i) {
            return new SoloMessageRecordPosition[i];
        }
    };

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public SoloMessageRecordPosition() {
        super(3, 0);
    }

    protected SoloMessageRecordPosition(Parcel parcel) {
        super(parcel);
    }
}
