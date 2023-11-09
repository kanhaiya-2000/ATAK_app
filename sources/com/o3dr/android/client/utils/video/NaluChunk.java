package com.o3dr.android.client.utils.video;

import java.nio.ByteBuffer;

public class NaluChunk {
    public static final int PPS_NAL_TYPE = 8;
    public static final int SPS_NAL_TYPE = 7;
    public static final byte[] START_CODE = {0, 0, 0, 1};
    public int flags;
    public final ByteBuffer[] payloads;
    public long presentationTime;
    public int sequenceNumber;
    public int type;

    public NaluChunk(int i, int i2, byte[] bArr) {
        this.payloads = new ByteBuffer[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.payloads[i3] = ByteBuffer.allocate(i2);
            if (bArr != null) {
                this.payloads[i3].put(bArr);
                this.payloads[i3].mark();
            }
        }
    }
}
