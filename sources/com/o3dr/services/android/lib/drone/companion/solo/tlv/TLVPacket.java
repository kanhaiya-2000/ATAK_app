package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class TLVPacket implements Parcelable {
    public static final int MIN_TLV_PACKET_SIZE = 8;
    public static final ByteOrder TLV_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    private final ByteBuffer byteBuffer;
    private final int messageLength;
    private final int messageType;

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void getMessageValue(ByteBuffer byteBuffer2);

    public TLVPacket(int i, int i2) {
        this.messageType = i;
        this.messageLength = i2;
        ByteBuffer allocate = ByteBuffer.allocate(i2 + 8);
        this.byteBuffer = allocate;
        allocate.order(TLV_BYTE_ORDER);
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final int getMessageLength() {
        return this.messageLength;
    }

    public final byte[] toBytes() {
        this.byteBuffer.clear();
        this.byteBuffer.putInt(this.messageType);
        this.byteBuffer.putInt(this.messageLength);
        getMessageValue(this.byteBuffer);
        byte[] bArr = new byte[this.byteBuffer.position()];
        this.byteBuffer.rewind();
        this.byteBuffer.get(bArr);
        return bArr;
    }

    public String toString() {
        return "TLVPacket{messageLength=" + this.messageLength + ", messageType=" + this.messageType + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TLVPacket)) {
            return false;
        }
        TLVPacket tLVPacket = (TLVPacket) obj;
        if (this.messageType == tLVPacket.messageType && this.messageLength == tLVPacket.messageLength) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.messageType * 31) + this.messageLength;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.messageType);
        parcel.writeInt(this.messageLength);
    }

    protected TLVPacket(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt());
    }
}
