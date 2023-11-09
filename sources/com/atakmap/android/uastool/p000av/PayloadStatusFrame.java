package com.atakmap.android.uastool.p000av;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.atakmap.android.uastool.av.PayloadStatusFrame */
class PayloadStatusFrame extends GCSMessage {
    private int numberOfPayloads = 0;
    private final List<PayloadBlock> payloadBlocks = new ArrayList();

    private void setNumberOfPayloads(int i) {
        this.numberOfPayloads = i;
    }

    public void parseNative(byte[] bArr, int i) {
        int i2;
        setNumberOfPayloads(bArr[0]);
        int i3 = this.numberOfPayloads;
        if (i3 != 0 && i3 <= 4) {
            int i4 = 1;
            for (int i5 = 0; i5 < this.numberOfPayloads && (i2 = i - i4) >= 6; i5++) {
                PayloadBlock payloadBlock = new PayloadBlock();
                int parseNative = payloadBlock.parseNative(Arrays.copyOfRange(bArr, i4, i), i2);
                this.payloadBlocks.add(payloadBlock);
                i4 += parseNative;
            }
        }
    }

    public int getNumberOfPayloads() {
        return this.numberOfPayloads;
    }

    public PayloadBlock getPayload(int i) {
        return this.payloadBlocks.get(i);
    }
}
