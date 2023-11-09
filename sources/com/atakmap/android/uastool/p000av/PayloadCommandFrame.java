package com.atakmap.android.uastool.p000av;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.atakmap.android.uastool.av.PayloadCommandFrame */
public class PayloadCommandFrame extends GCSUplinkMessage {
    private static final int FRAMEID = 255;
    private static final int XID = 1;
    private final List<PayloadControlBlock> payloadControlBlocks = new ArrayList();

    public /* bridge */ /* synthetic */ int getXid() {
        return super.getXid();
    }

    public /* bridge */ /* synthetic */ byte[] renderNativeFrame() {
        return super.renderNativeFrame();
    }

    public PayloadCommandFrame() {
        setFrameID(255);
        setXid(1);
    }

    public void addPayloadControlBlock(PayloadControlBlock payloadControlBlock) {
        this.payloadControlBlocks.add(payloadControlBlock);
    }

    public byte[] renderNativeCommand() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write((byte) getNumberOfPayloadsToControl());
        for (int i = 0; i < this.payloadControlBlocks.size(); i++) {
            byte[] renderNativeCommand = this.payloadControlBlocks.get(i).renderNativeCommand();
            byteArrayOutputStream.write(renderNativeCommand, 0, renderNativeCommand.length);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private int getNumberOfPayloadsToControl() {
        return this.payloadControlBlocks.size();
    }
}
