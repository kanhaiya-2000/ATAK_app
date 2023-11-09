package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloPanoStatus extends TLVPacket {
    public static final Parcelable.Creator<SoloPanoStatus> CREATOR = new Parcelable.Creator<SoloPanoStatus>() {
        public SoloPanoStatus createFromParcel(Parcel parcel) {
            return new SoloPanoStatus(parcel);
        }

        public SoloPanoStatus[] newArray(int i) {
            return new SoloPanoStatus[i];
        }
    };
    public static final int MESSAGE_LENGTH = 2;
    private byte currentStep;
    private byte totalSteps;

    public SoloPanoStatus(byte b, byte b2) {
        super(25, 2);
        this.currentStep = b;
        this.totalSteps = b2;
    }

    SoloPanoStatus(ByteBuffer byteBuffer) {
        this(byteBuffer.get(), byteBuffer.get());
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.put(this.currentStep);
        byteBuffer.put(this.totalSteps);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.currentStep);
        parcel.writeByte(this.totalSteps);
    }

    protected SoloPanoStatus(Parcel parcel) {
        super(parcel);
        this.currentStep = parcel.readByte();
        this.totalSteps = parcel.readByte();
    }

    public String toString() {
        return "SoloPanoStatus{currentStep=" + this.currentStep + "totalSteps=" + this.totalSteps + '}';
    }

    public int getCurrentStep() {
        return this.currentStep;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }
}
