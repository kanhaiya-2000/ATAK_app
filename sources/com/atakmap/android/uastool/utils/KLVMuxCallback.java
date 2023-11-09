package com.atakmap.android.uastool.utils;

import com.atakmap.android.uastool.utils.KLVQueue;
import com.partech.mobilevid.f;
import com.partech.mobilevid.g;

public class KLVMuxCallback implements g {
    private final KLVQueue klvQueue;
    private long lastTime = 0;

    public KLVMuxCallback(KLVQueue kLVQueue) {
        this.klvQueue = kLVQueue;
    }

    /* renamed from: a */
    public long mo10912a(long j, f fVar) {
        KLVQueue.TimedKLV popKLV;
        long j2;
        while (true) {
            popKLV = this.klvQueue.popKLV(j);
            if (popKLV == null) {
                j2 = -1;
                break;
            } else if (j > this.lastTime && popKLV.tsMillis < this.lastTime) {
                this.klvQueue.releaseKLV(popKLV);
            }
        }
        if (fVar.a == null || fVar.a.length < popKLV.length) {
            fVar.a = new byte[popKLV.length];
        }
        System.arraycopy(popKLV.buffer, 0, fVar.a, 0, popKLV.length);
        fVar.b = popKLV.length;
        long j3 = popKLV.tsMillis;
        this.klvQueue.releaseKLV(popKLV);
        j2 = j3;
        this.lastTime = j;
        return j2;
    }
}
