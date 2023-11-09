package com.o3dr.android.client.utils.video;

import android.util.Log;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Locale;

class NaluChunkAssembler {
    private static final long DELTA_PRESENTATION_TIME = 42000;
    private static final int PPS_BUFFER_INDEX = 1;
    private static final int SPS_BUFFER_INDEX = 0;
    private static final String TAG = "NaluChunkAssembler";
    private final NaluChunk assembledNaluChunk = new NaluChunk(1, 1048576, NaluChunk.START_CODE);
    private final NaluChunk eosNaluChunk;
    private boolean isPpsSet = false;
    private boolean isSpsSet = false;
    private int naluCounter = 0;
    private final NaluChunk paramsNaluChunk;
    private int prevSeq = -1;

    NaluChunkAssembler() {
        NaluChunk naluChunk = new NaluChunk(2, 256, NaluChunk.START_CODE);
        this.paramsNaluChunk = naluChunk;
        naluChunk.type = 78;
        naluChunk.flags = 2;
        NaluChunk naluChunk2 = new NaluChunk(1, 0, (byte[]) null);
        this.eosNaluChunk = naluChunk2;
        naluChunk2.flags = 4;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.isSpsSet = false;
        this.isPpsSet = false;
        this.assembledNaluChunk.payloads[0].reset();
        this.paramsNaluChunk.payloads[0].reset();
        this.paramsNaluChunk.payloads[1].reset();
    }

    private boolean areParametersSet() {
        return this.isSpsSet && this.isPpsSet;
    }

    /* access modifiers changed from: package-private */
    public NaluChunk getEndOfStream() {
        return this.eosNaluChunk;
    }

    /* access modifiers changed from: package-private */
    public NaluChunk getParametersSet() {
        if (areParametersSet()) {
            return this.paramsNaluChunk;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public NaluChunk assembleNALUChunk(byte[] bArr, int i) {
        ByteBuffer byteBuffer;
        int i2;
        byte[] bArr2 = bArr;
        byte b = bArr2[12];
        if (((b & 128) >> 7) != 0) {
            Log.w(TAG, "Forbidden bit is set, indicating possible errors.");
            return null;
        }
        byte b2 = bArr2[4];
        byte b3 = bArr2[5];
        byte b4 = bArr2[6];
        byte b5 = bArr2[7];
        byte b6 = ((bArr2[2] & 255) << 8) | (bArr2[3] & 255);
        byte b7 = b & Ascii.f8526US;
        if (b7 <= 0) {
            Log.d(TAG, "Undefined nal type: " + b7);
            return null;
        }
        int i3 = this.prevSeq;
        boolean z = true;
        if (!(i3 == -1 || b6 == (i2 = i3 + 1))) {
            Log.v(TAG, String.format(Locale.US, "Sequence number is out of order: %d != %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(b6)}));
        }
        this.prevSeq = b6;
        if (b7 <= 23) {
            int i4 = i - 12;
            if (b7 == 7 || b7 == 8) {
                if (b7 == 7) {
                    byteBuffer = this.paramsNaluChunk.payloads[0];
                    this.isSpsSet = true;
                } else {
                    byteBuffer = this.paramsNaluChunk.payloads[1];
                    this.isPpsSet = true;
                }
                byteBuffer.reset();
                byteBuffer.put(bArr2, 12, i4);
                if (!areParametersSet()) {
                    return null;
                }
                this.paramsNaluChunk.sequenceNumber = b6;
                this.paramsNaluChunk.presentationTime = 0;
                return this.paramsNaluChunk;
            } else if (!areParametersSet()) {
                return null;
            } else {
                ByteBuffer byteBuffer2 = this.assembledNaluChunk.payloads[0];
                byteBuffer2.reset();
                byteBuffer2.put(bArr2, 12, i4);
                this.assembledNaluChunk.type = b7;
                this.assembledNaluChunk.sequenceNumber = b6;
                this.assembledNaluChunk.flags = 0;
                NaluChunk naluChunk = this.assembledNaluChunk;
                int i5 = this.naluCounter;
                this.naluCounter = i5 + 1;
                naluChunk.presentationTime = ((long) i5) * DELTA_PRESENTATION_TIME;
                return this.assembledNaluChunk;
            }
        } else if (b7 != 28 || !areParametersSet()) {
            return null;
        } else {
            int i6 = i - 14;
            byte b8 = bArr2[13];
            byte b9 = b8 & Ascii.f8526US;
            int i7 = (b8 & 128) >> 7;
            int i8 = (b8 & 64) >> 6;
            if (i7 == 1) {
                ByteBuffer byteBuffer3 = this.assembledNaluChunk.payloads[0];
                byteBuffer3.reset();
                byteBuffer3.put((byte) ((b & 224) | b9));
                byteBuffer3.put(bArr2, 14, i6);
                if (!(b9 == 7 || b9 == 8)) {
                    z = false;
                }
                this.assembledNaluChunk.sequenceNumber = b6;
                this.assembledNaluChunk.type = b9;
                this.assembledNaluChunk.flags = z ? 2 : 0;
                return null;
            } else if (b6 - 1 != this.assembledNaluChunk.sequenceNumber) {
                return null;
            } else {
                this.assembledNaluChunk.payloads[0].put(bArr2, 14, i6);
                this.assembledNaluChunk.sequenceNumber = b6;
                if (i8 == 1) {
                    NaluChunk naluChunk2 = this.assembledNaluChunk;
                    int i9 = this.naluCounter;
                    this.naluCounter = i9 + 1;
                    naluChunk2.presentationTime = ((long) i9) * DELTA_PRESENTATION_TIME;
                    return this.assembledNaluChunk;
                }
                return null;
            }
        }
    }
}
