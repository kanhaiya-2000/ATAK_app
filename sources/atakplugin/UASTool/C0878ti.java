package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.ti */
final class C0878ti {

    /* renamed from: a */
    private static final int f6654a = 3000000;

    /* renamed from: b */
    private static final int f6655b = 12000000;

    /* renamed from: c */
    private static final int f6656c = 0;

    /* renamed from: d */
    private static final int f6657d = 49152;

    /* renamed from: e */
    private static final int f6658e = 32768;

    /* renamed from: f */
    private static final int f6659f = 16384;

    /* renamed from: g */
    private static final int f6660g = 49152;

    /* renamed from: h */
    private static final int f6661h = 0;

    /* renamed from: i */
    private static final int f6662i = 16384;

    /* renamed from: j */
    private static final int f6663j = 32768;

    /* renamed from: k */
    private static final int f6664k = 49152;

    private C0878ti() {
    }

    /* renamed from: a */
    static byte m13925a(int i, int[] iArr, boolean z) {
        int i2;
        int i3;
        byte b = m13929b(i, iArr, z);
        if (b == -1) {
            return -1;
        }
        if (b == 0) {
            iArr[0] = (iArr[0] & -49153) + 1;
        }
        int a = m13927a(iArr[0], iArr[1], z);
        if (i > a) {
            i2 = ((i * 100) / a) - 100;
            i3 = ((i % a) * 100) % a;
        } else {
            i2 = ((a * 100) / i) - 100;
            i3 = ((a % i) * 100) % i;
        }
        if (i2 < 3) {
            return 1;
        }
        if (i2 == 3 && i3 == 0) {
            return 1;
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r1 <= 75) goto L_0x007d;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte m13929b(int r7, int[] r8, boolean r9) {
        /*
            r0 = -1
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 3000000(0x2dc6c0, float:4.203895E-39)
            int r2 = r1 / r7
            r3 = r2 & -16384(0xffffffffffffc000, float:NaN)
            if (r3 <= 0) goto L_0x000e
            return r0
        L_0x000e:
            r0 = 0
            r8[r0] = r2
            r2 = 1
            r8[r2] = r0
            r3 = r8[r0]
            if (r3 != r2) goto L_0x0022
            int r3 = r1 % r7
            int r3 = r3 * 100
            int r3 = r3 / r7
            r4 = 3
            if (r3 > r4) goto L_0x0022
            r8[r0] = r0
        L_0x0022:
            r3 = r8[r0]
            if (r3 != 0) goto L_0x0027
            return r2
        L_0x0027:
            int r1 = r1 % r7
            int r1 = r1 * 100
            int r1 = r1 / r7
            r7 = 18
            r3 = 6
            r4 = 16384(0x4000, float:2.2959E-41)
            r5 = 32768(0x8000, float:4.5918E-41)
            r6 = 49152(0xc000, float:6.8877E-41)
            if (r9 != 0) goto L_0x004a
            if (r1 > r3) goto L_0x003b
            goto L_0x004c
        L_0x003b:
            if (r1 > r7) goto L_0x003e
            goto L_0x0050
        L_0x003e:
            r7 = 37
            if (r1 > r7) goto L_0x0043
            goto L_0x0058
        L_0x0043:
            r7 = 75
            if (r1 > r7) goto L_0x0048
            goto L_0x007d
        L_0x0048:
            r2 = 0
            goto L_0x004c
        L_0x004a:
            if (r1 > r3) goto L_0x004e
        L_0x004c:
            r4 = 0
            goto L_0x007d
        L_0x004e:
            if (r1 > r7) goto L_0x0054
        L_0x0050:
            r4 = 49152(0xc000, float:6.8877E-41)
            goto L_0x007d
        L_0x0054:
            r7 = 31
            if (r1 > r7) goto L_0x005c
        L_0x0058:
            r4 = 32768(0x8000, float:4.5918E-41)
            goto L_0x007d
        L_0x005c:
            r7 = 43
            if (r1 > r7) goto L_0x0063
            r8[r2] = r2
            goto L_0x004c
        L_0x0063:
            r7 = 56
            if (r1 > r7) goto L_0x0068
            goto L_0x007d
        L_0x0068:
            r7 = 68
            if (r1 > r7) goto L_0x006f
            r8[r2] = r2
            goto L_0x007d
        L_0x006f:
            r7 = 81
            if (r1 > r7) goto L_0x0076
            r8[r2] = r2
            goto L_0x0058
        L_0x0076:
            r7 = 93
            if (r1 > r7) goto L_0x0048
            r8[r2] = r2
            goto L_0x0050
        L_0x007d:
            r7 = r8[r0]
            r7 = r7 | r4
            r8[r0] = r7
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0878ti.m13929b(int, int[], boolean):byte");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r4 != 49152) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r4 != 49152) goto L_0x0046;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m13927a(int r4, int r5, boolean r6) {
        /*
            if (r4 != 0) goto L_0x0006
            r4 = 3000000(0x2dc6c0, float:4.203895E-39)
            return r4
        L_0x0006:
            r0 = -49153(0xffffffffffff3fff, float:NaN)
            r0 = r0 & r4
            int r0 = r0 * 100
            r1 = 32768(0x8000, float:4.5918E-41)
            r2 = 16384(0x4000, float:2.2959E-41)
            r3 = 49152(0xc000, float:6.8877E-41)
            if (r6 != 0) goto L_0x0027
            r4 = r4 & r3
            if (r4 == r2) goto L_0x0024
            if (r4 == r1) goto L_0x0021
            if (r4 == r3) goto L_0x001e
            goto L_0x0046
        L_0x001e:
            int r0 = r0 + 12
            goto L_0x0046
        L_0x0021:
            int r0 = r0 + 25
            goto L_0x0046
        L_0x0024:
            int r0 = r0 + 50
            goto L_0x0046
        L_0x0027:
            if (r5 != 0) goto L_0x0031
            r4 = r4 & r3
            if (r4 == r2) goto L_0x0024
            if (r4 == r1) goto L_0x0021
            if (r4 == r3) goto L_0x001e
            goto L_0x0046
        L_0x0031:
            r4 = r4 & r3
            if (r4 == 0) goto L_0x0044
            if (r4 == r2) goto L_0x0041
            if (r4 == r1) goto L_0x003e
            if (r4 == r3) goto L_0x003b
            goto L_0x0046
        L_0x003b:
            int r0 = r0 + 87
            goto L_0x0046
        L_0x003e:
            int r0 = r0 + 75
            goto L_0x0046
        L_0x0041:
            int r0 = r0 + 62
            goto L_0x0046
        L_0x0044:
            int r0 = r0 + 37
        L_0x0046:
            r4 = 300000000(0x11e1a300, float:3.5599197E-28)
            int r4 = r4 / r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0878ti.m13927a(int, int, boolean):int");
    }

    /* renamed from: a */
    static final byte m13924a(int i, int[] iArr) {
        int i2;
        int i3;
        byte b = m13928b(i, iArr);
        if (b == -1) {
            return -1;
        }
        if (b == 0) {
            iArr[0] = (iArr[0] & -49153) + 1;
        }
        int a = m13926a(iArr[0], iArr[1]);
        if (i > a) {
            i3 = ((i * 100) / a) - 100;
            i2 = ((i % a) * 100) % a;
        } else {
            i3 = ((a * 100) / i) - 100;
            i2 = ((a % i) * 100) % i;
        }
        if (i3 < 3) {
            return 1;
        }
        if (i3 == 3 && i2 == 0) {
            return 1;
        }
        return 0;
    }

    /* renamed from: b */
    private static byte m13928b(int i, int[] iArr) {
        if (i == 0) {
            return -1;
        }
        int i2 = f6655b / i;
        if ((i2 & -16384) > 0) {
            return -1;
        }
        byte b = 1;
        iArr[1] = 2;
        if (i >= 11640000 && i <= 12360000) {
            iArr[0] = 0;
            return 1;
        } else if (i < 7760000 || i > 8240000) {
            iArr[0] = i2;
            iArr[1] = 2;
            if (iArr[0] == 1 && ((f6655b % i) * 100) / i <= 3) {
                iArr[0] = 0;
            }
            if (iArr[0] == 0) {
                return 1;
            }
            int i3 = ((f6655b % i) * 100) / i;
            int i4 = 16384;
            if (i3 > 6) {
                if (i3 > 18) {
                    if (i3 > 31) {
                        if (i3 <= 43) {
                            iArr[1] = iArr[1] | 1;
                        } else {
                            if (i3 > 56) {
                                if (i3 <= 68) {
                                    iArr[1] = iArr[1] | 1;
                                } else if (i3 <= 81) {
                                    iArr[1] = iArr[1] | 1;
                                } else if (i3 <= 93) {
                                    iArr[1] = iArr[1] | 1;
                                } else {
                                    b = 0;
                                }
                            }
                            iArr[0] = iArr[0] | i4;
                            return b;
                        }
                    }
                    i4 = 32768;
                    iArr[0] = iArr[0] | i4;
                    return b;
                }
                i4 = 49152;
                iArr[0] = iArr[0] | i4;
                return b;
            }
            i4 = 0;
            iArr[0] = iArr[0] | i4;
            return b;
        } else {
            iArr[0] = 1;
            return 1;
        }
    }

    /* renamed from: a */
    private static int m13926a(int i, int i2) {
        if (i == 0) {
            return f6655b;
        }
        if (i == 1) {
            return 8000000;
        }
        int i3 = (-49153 & i) * 100;
        if ((i2 & bxu.f4221c) == 0) {
            int i4 = i & 49152;
            if (i4 == 16384) {
                i3 += 50;
            } else if (i4 == 32768) {
                i3 += 25;
            } else if (i4 == 49152) {
                i3 += 12;
            }
        } else {
            int i5 = i & 49152;
            if (i5 == 0) {
                i3 += 37;
            } else if (i5 == 16384) {
                i3 += 62;
            } else if (i5 == 32768) {
                i3 += 75;
            } else if (i5 == 49152) {
                i3 += 87;
            }
        }
        return 1200000000 / i3;
    }
}
