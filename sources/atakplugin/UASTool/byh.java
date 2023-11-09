package atakplugin.UASTool;

import com.google.common.base.Ascii;

public class byh extends byn {

    /* renamed from: a */
    private static final int f4239a = 5;

    /* renamed from: m */
    private static final int f4240m = 8;

    /* renamed from: n */
    private static final int f4241n = 5;

    /* renamed from: o */
    private static final byte[] f4242o = {Ascii.f8514CR, 10};

    /* renamed from: p */
    private static final byte[] f4243p = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, bxu.f4219a, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.f8517FS, Ascii.f8518GS, Ascii.f8522RS, Ascii.f8526US, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.f8527VT, Ascii.f8516FF, Ascii.f8514CR, Ascii.f8524SO, Ascii.f8523SI, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.f8515EM};

    /* renamed from: q */
    private static final byte[] f4244q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};

    /* renamed from: r */
    private static final byte[] f4245r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, bxu.f4219a, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, Ascii.f8527VT, Ascii.f8516FF, Ascii.f8514CR, Ascii.f8524SO, Ascii.f8523SI, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.f8515EM, Ascii.SUB, Ascii.ESC, Ascii.f8517FS, Ascii.f8518GS, Ascii.f8522RS, Ascii.f8526US, 32};

    /* renamed from: s */
    private static final byte[] f4246s = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};

    /* renamed from: t */
    private static final int f4247t = 31;

    /* renamed from: u */
    private long f4248u;

    /* renamed from: v */
    private final int f4249v;

    /* renamed from: w */
    private final byte[] f4250w;

    /* renamed from: x */
    private final int f4251x;

    /* renamed from: y */
    private final byte[] f4252y;

    /* renamed from: z */
    private final byte[] f4253z;

    public byh() {
        this(false);
    }

    public byh(boolean z) {
        this(0, (byte[]) null, z);
    }

    public byh(int i) {
        this(i, f4242o);
    }

    public byh(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public byh(int i, byte[] bArr, boolean z) {
        super(5, 8, i, bArr == null ? 0 : bArr.length);
        if (z) {
            this.f4252y = f4246s;
            this.f4250w = f4245r;
        } else {
            this.f4252y = f4244q;
            this.f4250w = f4243p;
        }
        if (i <= 0) {
            this.f4251x = 8;
            this.f4253z = null;
        } else if (bArr == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lineLength ");
            stringBuffer.append(i);
            stringBuffer.append(" > 0, but lineSeparator is null");
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (!mo4091n(bArr)) {
            this.f4251x = bArr.length + 8;
            byte[] bArr2 = new byte[bArr.length];
            this.f4253z = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            String f = bys.m10630f(bArr);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("lineSeparator must not contain Base32 characters: [");
            stringBuffer2.append(f);
            stringBuffer2.append("]");
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        this.f4249v = this.f4251x - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4077a(byte[] bArr, int i, int i2) {
        byte b;
        if (!this.f4278j) {
            if (i2 < 0) {
                this.f4278j = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    this.f4278j = true;
                    break;
                }
                mo4081a(this.f4249v);
                if (b2 >= 0) {
                    byte[] bArr2 = this.f4250w;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        this.f4280l = (this.f4280l + 1) % 8;
                        this.f4248u = (this.f4248u << 5) + ((long) b);
                        if (this.f4280l == 0) {
                            byte[] bArr3 = this.f4276h;
                            int i5 = this.f4277i;
                            this.f4277i = i5 + 1;
                            bArr3[i5] = (byte) ((int) ((this.f4248u >> 32) & 255));
                            byte[] bArr4 = this.f4276h;
                            int i6 = this.f4277i;
                            this.f4277i = i6 + 1;
                            bArr4[i6] = (byte) ((int) ((this.f4248u >> 24) & 255));
                            byte[] bArr5 = this.f4276h;
                            int i7 = this.f4277i;
                            this.f4277i = i7 + 1;
                            bArr5[i7] = (byte) ((int) ((this.f4248u >> 16) & 255));
                            byte[] bArr6 = this.f4276h;
                            int i8 = this.f4277i;
                            this.f4277i = i8 + 1;
                            bArr6[i8] = (byte) ((int) ((this.f4248u >> 8) & 255));
                            byte[] bArr7 = this.f4276h;
                            int i9 = this.f4277i;
                            this.f4277i = i9 + 1;
                            bArr7[i9] = (byte) ((int) (this.f4248u & 255));
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (this.f4278j && this.f4280l >= 2) {
                mo4081a(this.f4249v);
                switch (this.f4280l) {
                    case 2:
                        byte[] bArr8 = this.f4276h;
                        int i10 = this.f4277i;
                        this.f4277i = i10 + 1;
                        bArr8[i10] = (byte) ((int) ((this.f4248u >> 2) & 255));
                        return;
                    case 3:
                        byte[] bArr9 = this.f4276h;
                        int i11 = this.f4277i;
                        this.f4277i = i11 + 1;
                        bArr9[i11] = (byte) ((int) ((this.f4248u >> 7) & 255));
                        return;
                    case 4:
                        this.f4248u >>= 4;
                        byte[] bArr10 = this.f4276h;
                        int i12 = this.f4277i;
                        this.f4277i = i12 + 1;
                        bArr10[i12] = (byte) ((int) ((this.f4248u >> 8) & 255));
                        byte[] bArr11 = this.f4276h;
                        int i13 = this.f4277i;
                        this.f4277i = i13 + 1;
                        bArr11[i13] = (byte) ((int) (this.f4248u & 255));
                        return;
                    case 5:
                        this.f4248u >>= 1;
                        byte[] bArr12 = this.f4276h;
                        int i14 = this.f4277i;
                        this.f4277i = i14 + 1;
                        bArr12[i14] = (byte) ((int) ((this.f4248u >> 16) & 255));
                        byte[] bArr13 = this.f4276h;
                        int i15 = this.f4277i;
                        this.f4277i = i15 + 1;
                        bArr13[i15] = (byte) ((int) ((this.f4248u >> 8) & 255));
                        byte[] bArr14 = this.f4276h;
                        int i16 = this.f4277i;
                        this.f4277i = i16 + 1;
                        bArr14[i16] = (byte) ((int) (this.f4248u & 255));
                        return;
                    case 6:
                        this.f4248u >>= 6;
                        byte[] bArr15 = this.f4276h;
                        int i17 = this.f4277i;
                        this.f4277i = i17 + 1;
                        bArr15[i17] = (byte) ((int) ((this.f4248u >> 16) & 255));
                        byte[] bArr16 = this.f4276h;
                        int i18 = this.f4277i;
                        this.f4277i = i18 + 1;
                        bArr16[i18] = (byte) ((int) ((this.f4248u >> 8) & 255));
                        byte[] bArr17 = this.f4276h;
                        int i19 = this.f4277i;
                        this.f4277i = i19 + 1;
                        bArr17[i19] = (byte) ((int) (this.f4248u & 255));
                        return;
                    case 7:
                        this.f4248u >>= 3;
                        byte[] bArr18 = this.f4276h;
                        int i20 = this.f4277i;
                        this.f4277i = i20 + 1;
                        bArr18[i20] = (byte) ((int) ((this.f4248u >> 24) & 255));
                        byte[] bArr19 = this.f4276h;
                        int i21 = this.f4277i;
                        this.f4277i = i21 + 1;
                        bArr19[i21] = (byte) ((int) ((this.f4248u >> 16) & 255));
                        byte[] bArr20 = this.f4276h;
                        int i22 = this.f4277i;
                        this.f4277i = i22 + 1;
                        bArr20[i22] = (byte) ((int) ((this.f4248u >> 8) & 255));
                        byte[] bArr21 = this.f4276h;
                        int i23 = this.f4277i;
                        this.f4277i = i23 + 1;
                        bArr21[i23] = (byte) ((int) (this.f4248u & 255));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v61, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4079b(byte[] r12, int r13, int r14) {
        /*
            r11 = this;
            boolean r0 = r11.f4278j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r14 >= 0) goto L_0x025f
            r11.f4278j = r1
            int r12 = r11.f4280l
            if (r12 != 0) goto L_0x0014
            int r12 = r11.f4275g
            if (r12 != 0) goto L_0x0014
            return
        L_0x0014:
            int r12 = r11.f4251x
            r11.mo4081a((int) r12)
            int r12 = r11.f4277i
            int r13 = r11.f4280l
            r14 = 3
            r2 = 2
            r3 = 61
            if (r13 == r1) goto L_0x01d5
            r4 = 4
            if (r13 == r2) goto L_0x0158
            if (r13 == r14) goto L_0x00cd
            if (r13 == r4) goto L_0x002c
            goto L_0x0239
        L_0x002c:
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r4 = r1 + 1
            r11.f4277i = r4
            byte[] r4 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 27
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r4 = r1 + 1
            r11.f4277i = r4
            byte[] r4 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 22
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r4 = r1 + 1
            r11.f4277i = r4
            byte[] r4 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 17
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r4 = r1 + 1
            r11.f4277i = r4
            byte[] r4 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 12
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r4 = r1 + 1
            r11.f4277i = r4
            byte[] r4 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 7
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r4 = r1 + 1
            r11.f4277i = r4
            byte[] r4 = r11.f4252y
            long r5 = r11.f4248u
            long r5 = r5 >> r2
            int r2 = (int) r5
            r2 = r2 & 31
            byte r2 = r4[r2]
            r13[r1] = r2
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r2 = r1 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r4 = r11.f4248u
            long r4 = r4 << r14
            int r14 = (int) r4
            r14 = r14 & 31
            byte r14 = r2[r14]
            r13[r1] = r14
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            goto L_0x0239
        L_0x00cd:
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 19
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 14
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 9
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r5 = r11.f4248u
            long r4 = r5 >> r4
            int r5 = (int) r4
            r4 = r5 & 31
            byte r2 = r2[r4]
            r13[r14] = r2
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r4 = r11.f4248u
            long r4 = r4 << r1
            int r1 = (int) r4
            r1 = r1 & 31
            byte r1 = r2[r1]
            r13[r14] = r1
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            goto L_0x0239
        L_0x0158:
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 11
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r5 = r11.f4248u
            r7 = 6
            long r5 = r5 >> r7
            int r6 = (int) r5
            r5 = r6 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r2 = r14 + 1
            r11.f4277i = r2
            byte[] r2 = r11.f4252y
            long r5 = r11.f4248u
            long r5 = r5 >> r1
            int r1 = (int) r5
            r1 = r1 & 31
            byte r1 = r2[r1]
            r13[r14] = r1
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            byte[] r1 = r11.f4252y
            long r5 = r11.f4248u
            long r4 = r5 << r4
            int r2 = (int) r4
            r2 = r2 & 31
            byte r1 = r1[r2]
            r13[r14] = r1
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            goto L_0x0239
        L_0x01d5:
            byte[] r13 = r11.f4276h
            int r1 = r11.f4277i
            int r4 = r1 + 1
            r11.f4277i = r4
            byte[] r4 = r11.f4252y
            long r5 = r11.f4248u
            long r5 = r5 >> r14
            int r14 = (int) r5
            r14 = r14 & 31
            byte r14 = r4[r14]
            r13[r1] = r14
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            byte[] r1 = r11.f4252y
            long r4 = r11.f4248u
            long r4 = r4 << r2
            int r2 = (int) r4
            r2 = r2 & 31
            byte r1 = r1[r2]
            r13[r14] = r1
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            int r1 = r14 + 1
            r11.f4277i = r1
            r13[r14] = r3
        L_0x0239:
            int r13 = r11.f4279k
            int r14 = r11.f4277i
            int r14 = r14 - r12
            int r13 = r13 + r14
            r11.f4279k = r13
            int r12 = r11.f4275g
            if (r12 <= 0) goto L_0x0358
            int r12 = r11.f4279k
            if (r12 <= 0) goto L_0x0358
            byte[] r12 = r11.f4253z
            byte[] r13 = r11.f4276h
            int r14 = r11.f4277i
            byte[] r1 = r11.f4253z
            int r1 = r1.length
            java.lang.System.arraycopy(r12, r0, r13, r14, r1)
            int r12 = r11.f4277i
            byte[] r13 = r11.f4253z
            int r13 = r13.length
            int r12 = r12 + r13
            r11.f4277i = r12
            goto L_0x0358
        L_0x025f:
            r2 = 0
        L_0x0260:
            if (r2 >= r14) goto L_0x0358
            int r3 = r11.f4251x
            r11.mo4081a((int) r3)
            int r3 = r11.f4280l
            int r3 = r3 + r1
            r4 = 5
            int r3 = r3 % r4
            r11.f4280l = r3
            int r3 = r13 + 1
            byte r13 = r12[r13]
            if (r13 >= 0) goto L_0x0276
            int r13 = r13 + 256
        L_0x0276:
            long r5 = r11.f4248u
            r7 = 8
            long r5 = r5 << r7
            long r8 = (long) r13
            long r5 = r5 + r8
            r11.f4248u = r5
            int r13 = r11.f4280l
            if (r13 != 0) goto L_0x0353
            byte[] r13 = r11.f4276h
            int r5 = r11.f4277i
            int r6 = r5 + 1
            r11.f4277i = r6
            byte[] r6 = r11.f4252y
            long r8 = r11.f4248u
            r10 = 35
            long r8 = r8 >> r10
            int r9 = (int) r8
            r8 = r9 & 31
            byte r6 = r6[r8]
            r13[r5] = r6
            byte[] r13 = r11.f4276h
            int r5 = r11.f4277i
            int r6 = r5 + 1
            r11.f4277i = r6
            byte[] r6 = r11.f4252y
            long r8 = r11.f4248u
            r10 = 30
            long r8 = r8 >> r10
            int r9 = (int) r8
            r8 = r9 & 31
            byte r6 = r6[r8]
            r13[r5] = r6
            byte[] r13 = r11.f4276h
            int r5 = r11.f4277i
            int r6 = r5 + 1
            r11.f4277i = r6
            byte[] r6 = r11.f4252y
            long r8 = r11.f4248u
            r10 = 25
            long r8 = r8 >> r10
            int r9 = (int) r8
            r8 = r9 & 31
            byte r6 = r6[r8]
            r13[r5] = r6
            byte[] r13 = r11.f4276h
            int r5 = r11.f4277i
            int r6 = r5 + 1
            r11.f4277i = r6
            byte[] r6 = r11.f4252y
            long r8 = r11.f4248u
            r10 = 20
            long r8 = r8 >> r10
            int r9 = (int) r8
            r8 = r9 & 31
            byte r6 = r6[r8]
            r13[r5] = r6
            byte[] r13 = r11.f4276h
            int r5 = r11.f4277i
            int r6 = r5 + 1
            r11.f4277i = r6
            byte[] r6 = r11.f4252y
            long r8 = r11.f4248u
            r10 = 15
            long r8 = r8 >> r10
            int r9 = (int) r8
            r8 = r9 & 31
            byte r6 = r6[r8]
            r13[r5] = r6
            byte[] r13 = r11.f4276h
            int r5 = r11.f4277i
            int r6 = r5 + 1
            r11.f4277i = r6
            byte[] r6 = r11.f4252y
            long r8 = r11.f4248u
            r10 = 10
            long r8 = r8 >> r10
            int r9 = (int) r8
            r8 = r9 & 31
            byte r6 = r6[r8]
            r13[r5] = r6
            byte[] r13 = r11.f4276h
            int r5 = r11.f4277i
            int r6 = r5 + 1
            r11.f4277i = r6
            byte[] r6 = r11.f4252y
            long r8 = r11.f4248u
            long r8 = r8 >> r4
            int r4 = (int) r8
            r4 = r4 & 31
            byte r4 = r6[r4]
            r13[r5] = r4
            byte[] r13 = r11.f4276h
            int r4 = r11.f4277i
            int r5 = r4 + 1
            r11.f4277i = r5
            byte[] r5 = r11.f4252y
            long r8 = r11.f4248u
            int r6 = (int) r8
            r6 = r6 & 31
            byte r5 = r5[r6]
            r13[r4] = r5
            int r13 = r11.f4279k
            int r13 = r13 + r7
            r11.f4279k = r13
            int r13 = r11.f4275g
            if (r13 <= 0) goto L_0x0353
            int r13 = r11.f4275g
            int r4 = r11.f4279k
            if (r13 > r4) goto L_0x0353
            byte[] r13 = r11.f4253z
            byte[] r4 = r11.f4276h
            int r5 = r11.f4277i
            byte[] r6 = r11.f4253z
            int r6 = r6.length
            java.lang.System.arraycopy(r13, r0, r4, r5, r6)
            int r13 = r11.f4277i
            byte[] r4 = r11.f4253z
            int r4 = r4.length
            int r13 = r13 + r4
            r11.f4277i = r13
            r11.f4279k = r0
        L_0x0353:
            int r2 = r2 + 1
            r13 = r3
            goto L_0x0260
        L_0x0358:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.byh.mo4079b(byte[], int, int):void");
    }

    /* renamed from: a */
    public boolean mo4078a(byte b) {
        if (b >= 0) {
            byte[] bArr = this.f4250w;
            return b < bArr.length && bArr[b] != -1;
        }
    }
}
