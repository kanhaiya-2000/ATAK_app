package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloGoproRecord extends TLVPacket {
    public static final Parcelable.Creator<SoloGoproRecord> CREATOR = new Parcelable.Creator<SoloGoproRecord>() {
        public SoloGoproRecord createFromParcel(Parcel parcel) {
            return new SoloGoproRecord(parcel);
        }

        public SoloGoproRecord[] newArray(int i) {
            return new SoloGoproRecord[i];
        }
    };
    public static final int MESSAGE_LENGTH = 4;
    private int recordCommand;

    public SoloGoproRecord(int i) {
        super(5003, 4);
        this.recordCommand = i;
    }

    public int getRecordCommand() {
        return this.recordCommand;
    }

    public void setRecordCommand(int i) {
        this.recordCommand = i;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.recordCommand);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.recordCommand);
    }

    protected SoloGoproRecord(Parcel parcel) {
        super(parcel);
        this.recordCommand = parcel.readInt();
    }
}
