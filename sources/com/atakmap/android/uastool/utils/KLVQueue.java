package com.atakmap.android.uastool.utils;

import java.util.LinkedList;

public class KLVQueue {
    private final LinkedList<TimedKLV> freeList;
    private final LinkedList<TimedKLV> theQueue;
    private final long timeLimitMillis;

    public static class TimedKLV {
        private static final int DEFAULT_SIZE = 64;
        private static final int MAX_LEN = 5;
        public byte[] buffer = new byte[64];
        public int length;
        public long tsMillis;

        TimedKLV() {
        }

        /* access modifiers changed from: package-private */
        public void set(long j, byte[] bArr, byte[] bArr2) {
            this.tsMillis = j;
            checkBufLen(bArr.length + bArr2.length + 5);
            System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
            int fillLength = fillLength(bArr.length, bArr2.length);
            System.arraycopy(bArr2, 0, this.buffer, bArr.length + fillLength, bArr2.length);
            this.length = bArr.length + bArr2.length + fillLength;
        }

        private void checkBufLen(int i) {
            if (this.buffer.length < i) {
                this.buffer = new byte[i];
            }
        }

        private int fillLength(int i, int i2) {
            if (i2 <= 127) {
                this.buffer[i] = (byte) i2;
                return 1;
            } else if (i2 <= 255) {
                byte[] bArr = this.buffer;
                bArr[i] = -127;
                bArr[i + 1] = (byte) i2;
                return 2;
            } else if (i2 <= 65535) {
                byte[] bArr2 = this.buffer;
                bArr2[i] = -126;
                bArr2[i + 1] = (byte) (i2 >> 8);
                bArr2[i + 2] = (byte) i2;
                return 3;
            } else if (i2 <= 16777215) {
                byte[] bArr3 = this.buffer;
                bArr3[i] = -125;
                bArr3[i + 1] = (byte) (i2 >> 16);
                bArr3[i + 2] = (byte) (i2 >> 8);
                bArr3[i + 3] = (byte) i2;
                return 4;
            } else {
                byte[] bArr4 = this.buffer;
                bArr4[i] = -124;
                bArr4[i + 1] = (byte) (i2 >> 24);
                bArr4[i + 2] = (byte) (i2 >> 16);
                bArr4[i + 3] = (byte) (i2 >> 8);
                bArr4[i + 4] = (byte) i2;
                return 5;
            }
        }
    }

    public KLVQueue() {
        this(2000);
    }

    public KLVQueue(long j) {
        this.theQueue = new LinkedList<>();
        this.freeList = new LinkedList<>();
        this.timeLimitMillis = j;
    }

    public void releaseKLV(TimedKLV timedKLV) {
        synchronized (this) {
            this.freeList.add(timedKLV);
        }
    }

    public TimedKLV popKLV(long j) {
        synchronized (this) {
            if (this.theQueue.isEmpty()) {
                return null;
            }
            TimedKLV first = this.theQueue.getFirst();
            if (first.tsMillis >= j) {
                return null;
            }
            this.theQueue.removeFirst();
            return first;
        }
    }

    public void pushKLV(byte[] bArr, byte[] bArr2) {
        TimedKLV timedKLV;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            while (!this.theQueue.isEmpty()) {
                TimedKLV first = this.theQueue.getFirst();
                if (first.tsMillis + this.timeLimitMillis < currentTimeMillis) {
                    break;
                }
                this.theQueue.removeFirst();
                this.freeList.add(first);
            }
            if (!this.freeList.isEmpty()) {
                timedKLV = this.freeList.removeFirst();
            } else {
                timedKLV = new TimedKLV();
            }
            timedKLV.set(currentTimeMillis, bArr, bArr2);
            this.theQueue.addLast(timedKLV);
        }
    }
}
