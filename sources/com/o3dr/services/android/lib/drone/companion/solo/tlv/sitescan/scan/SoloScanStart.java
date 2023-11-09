package com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.scan;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageTypes;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloScanStart extends TLVPacket {
    public static final Parcelable.Creator<SoloScanStart> CREATOR = new Parcelable.Creator<SoloScanStart>() {
        public SoloScanStart createFromParcel(Parcel parcel) {
            return new SoloScanStart(parcel);
        }

        public SoloScanStart[] newArray(int i) {
            return new SoloScanStart[i];
        }
    };

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public SoloScanStart() {
        super(TLVMessageTypes.TYPE_SOLO_SCAN_START, 0);
    }

    protected SoloScanStart(Parcel parcel) {
        super(parcel);
    }
}
