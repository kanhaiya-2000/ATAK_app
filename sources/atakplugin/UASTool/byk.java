package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.util.Objects;

public class byk extends byn {

    /* renamed from: a */
    static final byte[] f4254a = {Ascii.f8514CR, 10};

    /* renamed from: m */
    private static final int f4255m = 6;

    /* renamed from: n */
    private static final int f4256n = 3;

    /* renamed from: o */
    private static final int f4257o = 4;

    /* renamed from: p */
    private static final byte[] f4258p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: q */
    private static final byte[] f4259q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: r */
    private static final byte[] f4260r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, bxu.f4219a, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.f8527VT, Ascii.f8516FF, Ascii.f8514CR, Ascii.f8524SO, Ascii.f8523SI, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.f8515EM, -1, -1, -1, -1, bxu.f4219a, -1, Ascii.SUB, Ascii.ESC, Ascii.f8517FS, Ascii.f8518GS, Ascii.f8522RS, Ascii.f8526US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: s */
    private static final int f4261s = 63;

    /* renamed from: t */
    private final byte[] f4262t;

    /* renamed from: u */
    private final byte[] f4263u;

    /* renamed from: v */
    private final byte[] f4264v;

    /* renamed from: w */
    private final int f4265w;

    /* renamed from: x */
    private final int f4266x;

    /* renamed from: y */
    private int f4267y;

    public byk() {
        this(0);
    }

    public byk(boolean z) {
        this(76, f4254a, z);
    }

    public byk(int i) {
        this(i, f4254a);
    }

    public byk(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public byk(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f4263u = f4260r;
        if (bArr == null) {
            this.f4266x = 4;
            this.f4264v = null;
        } else if (mo4091n(bArr)) {
            String f = bys.m10630f(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lineSeparator must not contain base64 characters: [");
            stringBuffer.append(f);
            stringBuffer.append("]");
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (i > 0) {
            this.f4266x = bArr.length + 4;
            byte[] bArr2 = new byte[bArr.length];
            this.f4264v = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            this.f4266x = 4;
            this.f4264v = null;
        }
        this.f4265w = this.f4266x - 1;
        this.f4262t = z ? f4259q : f4258p;
    }

    /* renamed from: a */
    public boolean mo4080a() {
        return this.f4262t == f4259q;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v35, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4079b(byte[] r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f4278j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r10 >= 0) goto L_0x00d7
            r7.f4278j = r1
            int r8 = r7.f4280l
            if (r8 != 0) goto L_0x0014
            int r8 = r7.f4275g
            if (r8 != 0) goto L_0x0014
            return
        L_0x0014:
            int r8 = r7.f4266x
            r7.mo4081a((int) r8)
            int r8 = r7.f4277i
            int r9 = r7.f4280l
            r10 = 61
            r2 = 2
            if (r9 == r1) goto L_0x0071
            if (r9 == r2) goto L_0x0026
            goto L_0x00b1
        L_0x0026:
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r3 = r1 + 1
            r7.f4277i = r3
            byte[] r3 = r7.f4262t
            int r4 = r7.f4267y
            int r4 = r4 >> 10
            r4 = r4 & 63
            byte r3 = r3[r4]
            r9[r1] = r3
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r3 = r1 + 1
            r7.f4277i = r3
            byte[] r3 = r7.f4262t
            int r4 = r7.f4267y
            int r4 = r4 >> 4
            r4 = r4 & 63
            byte r3 = r3[r4]
            r9[r1] = r3
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r3 = r1 + 1
            r7.f4277i = r3
            byte[] r3 = r7.f4262t
            int r4 = r7.f4267y
            int r2 = r4 << 2
            r2 = r2 & 63
            byte r2 = r3[r2]
            r9[r1] = r2
            byte[] r9 = f4258p
            if (r3 != r9) goto L_0x00b1
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r2 = r1 + 1
            r7.f4277i = r2
            r9[r1] = r10
            goto L_0x00b1
        L_0x0071:
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r3 = r1 + 1
            r7.f4277i = r3
            byte[] r3 = r7.f4262t
            int r4 = r7.f4267y
            int r2 = r4 >> 2
            r2 = r2 & 63
            byte r2 = r3[r2]
            r9[r1] = r2
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r2 = r1 + 1
            r7.f4277i = r2
            byte[] r2 = r7.f4262t
            int r3 = r7.f4267y
            int r3 = r3 << 4
            r3 = r3 & 63
            byte r3 = r2[r3]
            r9[r1] = r3
            byte[] r9 = f4258p
            if (r2 != r9) goto L_0x00b1
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r2 = r1 + 1
            r7.f4277i = r2
            r9[r1] = r10
            byte[] r9 = r7.f4276h
            int r1 = r7.f4277i
            int r2 = r1 + 1
            r7.f4277i = r2
            r9[r1] = r10
        L_0x00b1:
            int r9 = r7.f4279k
            int r10 = r7.f4277i
            int r10 = r10 - r8
            int r9 = r9 + r10
            r7.f4279k = r9
            int r8 = r7.f4275g
            if (r8 <= 0) goto L_0x0172
            int r8 = r7.f4279k
            if (r8 <= 0) goto L_0x0172
            byte[] r8 = r7.f4264v
            byte[] r9 = r7.f4276h
            int r10 = r7.f4277i
            byte[] r1 = r7.f4264v
            int r1 = r1.length
            java.lang.System.arraycopy(r8, r0, r9, r10, r1)
            int r8 = r7.f4277i
            byte[] r9 = r7.f4264v
            int r9 = r9.length
            int r8 = r8 + r9
            r7.f4277i = r8
            goto L_0x0172
        L_0x00d7:
            r2 = 0
        L_0x00d8:
            if (r2 >= r10) goto L_0x0172
            int r3 = r7.f4266x
            r7.mo4081a((int) r3)
            int r3 = r7.f4280l
            int r3 = r3 + r1
            int r3 = r3 % 3
            r7.f4280l = r3
            int r3 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x00ee
            int r9 = r9 + 256
        L_0x00ee:
            int r4 = r7.f4267y
            int r4 = r4 << 8
            int r4 = r4 + r9
            r7.f4267y = r4
            int r9 = r7.f4280l
            if (r9 != 0) goto L_0x016d
            byte[] r9 = r7.f4276h
            int r4 = r7.f4277i
            int r5 = r4 + 1
            r7.f4277i = r5
            byte[] r5 = r7.f4262t
            int r6 = r7.f4267y
            int r6 = r6 >> 18
            r6 = r6 & 63
            byte r5 = r5[r6]
            r9[r4] = r5
            byte[] r9 = r7.f4276h
            int r4 = r7.f4277i
            int r5 = r4 + 1
            r7.f4277i = r5
            byte[] r5 = r7.f4262t
            int r6 = r7.f4267y
            int r6 = r6 >> 12
            r6 = r6 & 63
            byte r5 = r5[r6]
            r9[r4] = r5
            byte[] r9 = r7.f4276h
            int r4 = r7.f4277i
            int r5 = r4 + 1
            r7.f4277i = r5
            byte[] r5 = r7.f4262t
            int r6 = r7.f4267y
            int r6 = r6 >> 6
            r6 = r6 & 63
            byte r5 = r5[r6]
            r9[r4] = r5
            byte[] r9 = r7.f4276h
            int r4 = r7.f4277i
            int r5 = r4 + 1
            r7.f4277i = r5
            byte[] r5 = r7.f4262t
            int r6 = r7.f4267y
            r6 = r6 & 63
            byte r5 = r5[r6]
            r9[r4] = r5
            int r9 = r7.f4279k
            int r9 = r9 + 4
            r7.f4279k = r9
            int r9 = r7.f4275g
            if (r9 <= 0) goto L_0x016d
            int r9 = r7.f4275g
            int r4 = r7.f4279k
            if (r9 > r4) goto L_0x016d
            byte[] r9 = r7.f4264v
            byte[] r4 = r7.f4276h
            int r5 = r7.f4277i
            byte[] r6 = r7.f4264v
            int r6 = r6.length
            java.lang.System.arraycopy(r9, r0, r4, r5, r6)
            int r9 = r7.f4277i
            byte[] r4 = r7.f4264v
            int r4 = r4.length
            int r9 = r9 + r4
            r7.f4277i = r9
            r7.f4279k = r0
        L_0x016d:
            int r2 = r2 + 1
            r9 = r3
            goto L_0x00d8
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.byk.mo4079b(byte[], int, int):void");
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
                mo4081a(this.f4265w);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    this.f4278j = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr2 = f4260r;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        this.f4280l = (this.f4280l + 1) % 4;
                        this.f4267y = (this.f4267y << 6) + b;
                        if (this.f4280l == 0) {
                            byte[] bArr3 = this.f4276h;
                            int i5 = this.f4277i;
                            this.f4277i = i5 + 1;
                            bArr3[i5] = (byte) ((this.f4267y >> 16) & 255);
                            byte[] bArr4 = this.f4276h;
                            int i6 = this.f4277i;
                            this.f4277i = i6 + 1;
                            bArr4[i6] = (byte) ((this.f4267y >> 8) & 255);
                            byte[] bArr5 = this.f4276h;
                            int i7 = this.f4277i;
                            this.f4277i = i7 + 1;
                            bArr5[i7] = (byte) (this.f4267y & 255);
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (this.f4278j && this.f4280l != 0) {
                mo4081a(this.f4265w);
                int i8 = this.f4280l;
                if (i8 == 2) {
                    this.f4267y >>= 4;
                    byte[] bArr6 = this.f4276h;
                    int i9 = this.f4277i;
                    this.f4277i = i9 + 1;
                    bArr6[i9] = (byte) (this.f4267y & 255);
                } else if (i8 == 3) {
                    this.f4267y >>= 2;
                    byte[] bArr7 = this.f4276h;
                    int i10 = this.f4277i;
                    this.f4277i = i10 + 1;
                    bArr7[i10] = (byte) ((this.f4267y >> 8) & 255);
                    byte[] bArr8 = this.f4276h;
                    int i11 = this.f4277i;
                    this.f4277i = i11 + 1;
                    bArr8[i11] = (byte) (this.f4267y & 255);
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m10556b(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = f4260r;
                if (b >= bArr.length || bArr[b] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m10551a(String str) {
        return m10560d(bys.m10631f(str));
    }

    /* renamed from: c */
    public static boolean m10559c(byte[] bArr) {
        return m10560d(bArr);
    }

    /* renamed from: d */
    public static boolean m10560d(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!m10556b(bArr[i]) && !m10573c(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static byte[] m10561e(byte[] bArr) {
        return m10553a(bArr, false);
    }

    /* renamed from: f */
    public static String m10562f(byte[] bArr) {
        return bys.m10630f(m10553a(bArr, false));
    }

    /* renamed from: g */
    public static byte[] m10563g(byte[] bArr) {
        return m10554a(bArr, false, true);
    }

    /* renamed from: h */
    public static String m10564h(byte[] bArr) {
        return bys.m10630f(m10554a(bArr, false, true));
    }

    /* renamed from: i */
    public static byte[] m10565i(byte[] bArr) {
        return m10553a(bArr, true);
    }

    /* renamed from: a */
    public static byte[] m10553a(byte[] bArr, boolean z) {
        return m10554a(bArr, z, false);
    }

    /* renamed from: a */
    public static byte[] m10554a(byte[] bArr, boolean z, boolean z2) {
        return m10555a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static byte[] m10555a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byk byk = z ? new byk(z2) : new byk(0, f4254a, z2);
        long o = byk.mo4092o(bArr);
        if (o <= ((long) i)) {
            return byk.mo4071b(bArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Input array too big, the output array would be bigger (");
        stringBuffer.append(o);
        stringBuffer.append(") than the specified maximum size of ");
        stringBuffer.append(i);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* renamed from: b */
    public static byte[] m10557b(String str) {
        return new byk().mo4086c(str);
    }

    /* renamed from: j */
    public static byte[] m10566j(byte[] bArr) {
        return new byk().mo4070a(bArr);
    }

    /* renamed from: k */
    public static BigInteger m10567k(byte[] bArr) {
        return new BigInteger(1, m10566j(bArr));
    }

    /* renamed from: a */
    public static byte[] m10552a(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "encodeInteger called with null parameter");
        return m10553a(m10558b(bigInteger), false);
    }

    /* renamed from: b */
    static byte[] m10558b(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4078a(byte b) {
        if (b >= 0) {
            byte[] bArr = this.f4263u;
            return b < bArr.length && bArr[b] != -1;
        }
    }
}
