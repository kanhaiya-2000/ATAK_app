package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplinePlay extends TLVPacket {
    public static final Parcelable.Creator<SoloSplinePlay> CREATOR = new Parcelable.Creator<SoloSplinePlay>() {
        public SoloSplinePlay createFromParcel(Parcel parcel) {
            return new SoloSplinePlay(parcel);
        }

        public SoloSplinePlay[] newArray(int i) {
            return new SoloSplinePlay[i];
        }
    };
    public static final int MESSAGE_LENGTH = 0;

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public SoloSplinePlay() {
        super(51, 0);
    }

    protected SoloSplinePlay(Parcel parcel) {
        super(parcel);
    }
}
