package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloGoproRequestState extends TLVPacket {
    public static final Parcelable.Creator<SoloGoproRequestState> CREATOR = new Parcelable.Creator<SoloGoproRequestState>() {
        public SoloGoproRequestState createFromParcel(Parcel parcel) {
            return new SoloGoproRequestState(parcel);
        }

        public SoloGoproRequestState[] newArray(int i) {
            return new SoloGoproRequestState[i];
        }
    };
    public static final int MESSAGE_LENGTH = 0;

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public SoloGoproRequestState() {
        super(TLVMessageTypes.TYPE_SOLO_GOPRO_REQUEST_STATE, 0);
    }

    protected SoloGoproRequestState(Parcel parcel) {
        super(parcel);
    }
}
