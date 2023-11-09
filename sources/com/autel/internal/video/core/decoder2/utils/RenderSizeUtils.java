package com.autel.internal.video.core.decoder2.utils;

public class RenderSizeUtils {
    public static int[] getRenderSize(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int max = Math.max(i3, i4);
        int min = Math.min(i3, i4);
        int i9 = max * i2;
        int i10 = i * min;
        if (i9 > i10) {
            i7 = i10 / i2;
            i8 = (max - i7) / 2;
            i5 = min;
            i6 = 0;
        } else {
            if (i9 < i10) {
                i5 = i9 / i;
                i6 = (min - i5) / 2;
                i7 = max;
            } else {
                i5 = min;
                i7 = max;
                i6 = 0;
            }
            i8 = 0;
        }
        return new int[]{i8, i6, i7, i5};
    }
}
