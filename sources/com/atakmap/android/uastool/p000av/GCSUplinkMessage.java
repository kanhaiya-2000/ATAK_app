package com.atakmap.android.uastool.p000av;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.atakmap.android.uastool.av.GCSUplinkMessage */
abstract class GCSUplinkMessage {
    private static final short HEADER = 8995;
    private int frameID;
    private int frameLength;
    private int xid;

    /* access modifiers changed from: protected */
    public abstract byte[] renderNativeCommand();

    GCSUplinkMessage() {
    }

    /* access modifiers changed from: package-private */
    public void setFrameID(int i) {
        this.frameID = i;
    }

    /* access modifiers changed from: package-private */
    public void setXid(int i) {
        this.xid = i;
    }

    public int getXid() {
        return this.xid;
    }

    public byte[] renderNativeFrame() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort(HEADER);
        byteArrayOutputStream.write(allocate.get(0));
        byteArrayOutputStream.write(allocate.get(1));
        byteArrayOutputStream.write((byte) this.frameID);
        byteArrayOutputStream.write((byte) this.frameLength);
        if (GCSMessage.hasXid((byte) this.frameID)) {
            byteArrayOutputStream.write((byte) this.xid);
        }
        byte[] renderNativeCommand = renderNativeCommand();
        byteArrayOutputStream.write(renderNativeCommand, 0, renderNativeCommand.length);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int size = byteArrayOutputStream.size();
        this.frameLength = size;
        byteArray[3] = (byte) size;
        short calculateCRC = AvParser.calculateCRC(Arrays.copyOfRange(byteArray, 2, byteArray.length - 2));
        byteArray[byteArray.length - 2] = (byte) ((calculateCRC >> 8) & 255);
        byteArray[byteArray.length - 1] = (byte) (calculateCRC & 255);
        return byteArray;
    }
}
