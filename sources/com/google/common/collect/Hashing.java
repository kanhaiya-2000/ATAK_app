package com.google.common.collect;

import atakplugin.UASTool.cij;

final class Hashing {

    /* renamed from: C1 */
    private static final long f8551C1 = -862048943;

    /* renamed from: C2 */
    private static final long f8552C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    static boolean needsResizing(int i, int i2, double d) {
        return ((double) i) > d * ((double) i2) && i2 < 1073741824;
    }

    private Hashing() {
    }

    static int smear(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * f8551C1), 15)) * f8552C2);
    }

    static int smearedHash(@cij Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }

    static int closedTableSize(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        int i2 = highestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }
}
