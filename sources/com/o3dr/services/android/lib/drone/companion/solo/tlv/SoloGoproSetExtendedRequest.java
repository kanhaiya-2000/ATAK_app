package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class SoloGoproSetExtendedRequest extends TLVPacket {
    public static final Parcelable.Creator<SoloGoproSetExtendedRequest> CREATOR = new Parcelable.Creator<SoloGoproSetExtendedRequest>() {
        public SoloGoproSetExtendedRequest createFromParcel(Parcel parcel) {
            return new SoloGoproSetExtendedRequest(parcel);
        }

        public SoloGoproSetExtendedRequest[] newArray(int i) {
            return new SoloGoproSetExtendedRequest[i];
        }
    };
    public static final int MESSAGE_LENGTH = 6;
    private short command;
    byte[] values;

    public SoloGoproSetExtendedRequest(short s, byte[] bArr) {
        super(TLVMessageTypes.TYPE_SOLO_GOPRO_SET_EXTENDED_REQUEST, 6);
        this.command = s;
        this.values = bArr;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putShort(this.command);
        byteBuffer.put(this.values);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.command);
        parcel.writeByteArray(this.values);
    }

    protected SoloGoproSetExtendedRequest(Parcel parcel) {
        super(parcel);
        this.command = (short) parcel.readInt();
        byte[] bArr = new byte[4];
        this.values = bArr;
        parcel.readByteArray(bArr);
    }

    public String toString() {
        return "SoloGoproSetExtendedRequest{command=" + this.command + ", values=" + Arrays.toString(this.values) + '}';
    }
}
