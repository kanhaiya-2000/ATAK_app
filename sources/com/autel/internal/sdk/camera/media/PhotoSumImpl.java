package com.autel.internal.sdk.camera.media;

import com.autel.common.camera.media.PhotoSum;

public class PhotoSumImpl implements PhotoSum {
    public int leftSum;
    public int sum;

    public String toString() {
        return "sum " + this.sum + " leftSum  " + this.leftSum;
    }

    public int getCount() {
        return this.sum;
    }

    public int getRemainderCount() {
        return this.leftSum;
    }
}
