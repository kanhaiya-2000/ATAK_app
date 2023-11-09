package com.autel.internal.video.core.decoder2.common;

import com.autel.internal.video.core.decoder2.utils.ByteUtils;
import com.autel.video.NetWorkProxyJni;

public class StreamData {
    private byte[] framedata;
    private int height;
    public long incomingTimeMs;
    private int keyframe;
    byte[] mWord = new byte[8];
    byte[] pps = new byte[1024];
    private int pps_len;
    private long pts;
    private int size;
    byte[] sps = new byte[1024];
    private int sps_len;
    private int width;

    public void parseData(byte[] bArr) {
        this.incomingTimeMs = System.currentTimeMillis();
        System.arraycopy(bArr, 0, this.mWord, 0, 4);
        this.width = ByteUtils.getInt(this.mWord);
        System.arraycopy(bArr, 4, this.mWord, 0, 4);
        this.height = ByteUtils.getInt(this.mWord);
        System.arraycopy(bArr, 8, this.mWord, 0, 4);
        this.keyframe = ByteUtils.getInt(this.mWord);
        System.arraycopy(bArr, 12, this.mWord, 0, 4);
        this.size = ByteUtils.getInt(this.mWord);
        System.arraycopy(bArr, 16, this.mWord, 0, 8);
        this.pts = ByteUtils.getLong(this.mWord);
        int i = this.size;
        byte[] bArr2 = this.sps;
        this.sps_len = NetWorkProxyJni.ParseSps(bArr, 24, i, bArr2, bArr2.length);
        int i2 = this.size;
        byte[] bArr3 = this.pps;
        this.pps_len = NetWorkProxyJni.ParsePps(bArr, 24, i2, bArr3, bArr3.length);
        int i3 = this.size;
        byte[] bArr4 = new byte[i3];
        this.framedata = bArr4;
        System.arraycopy(bArr, 24, bArr4, 0, i3);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isIframe() {
        return this.keyframe == 1;
    }

    public int getSize() {
        return this.size;
    }

    public long getPts() {
        return this.pts;
    }

    public int getSps_len() {
        return this.sps_len;
    }

    public int getPps_len() {
        return this.pps_len;
    }

    public byte[] getSps() {
        return this.sps;
    }

    public byte[] getPps() {
        return this.pps;
    }

    public long getQueueDelay() {
        return System.currentTimeMillis() - this.incomingTimeMs;
    }

    public byte[] getFrameData() {
        return this.framedata;
    }

    public int getKeyframe() {
        return this.keyframe;
    }

    public String toString() {
        return "StreamData info : width == " + this.width + ",height == " + this.height + ",keyframe == " + isIframe() + ",size == " + this.size + ",pts == " + this.pts;
    }
}
