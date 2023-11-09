package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloGoproSetRequest extends TLVPacket {
    public static final Parcelable.Creator<SoloGoproSetRequest> CREATOR = new Parcelable.Creator<SoloGoproSetRequest>() {
        public SoloGoproSetRequest createFromParcel(Parcel parcel) {
            return new SoloGoproSetRequest(parcel);
        }

        public SoloGoproSetRequest[] newArray(int i) {
            return new SoloGoproSetRequest[i];
        }
    };
    public static final int MESSAGE_LENGTH = 4;
    private short command;
    private short value;

    public SoloGoproSetRequest(short s, short s2) {
        super(5001, 4);
        this.command = s;
        this.value = s2;
    }

    public short getCommand() {
        return this.command;
    }

    public void setCommand(short s) {
        this.command = s;
    }

    public short getValue() {
        return this.value;
    }

    public void setValue(short s) {
        this.value = s;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putShort(this.command);
        byteBuffer.putShort(this.value);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.command);
        parcel.writeInt(this.value);
    }

    protected SoloGoproSetRequest(Parcel parcel) {
        super(parcel);
        this.command = (short) parcel.readInt();
        this.value = (short) parcel.readInt();
    }

    public String toString() {
        return "SoloGoproSetRequest{command=" + this.command + ", value=" + this.value + '}';
    }
}
