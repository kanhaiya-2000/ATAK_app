package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.ub */
class C0907ub extends C0905ua {

    /* renamed from: A */
    private static final int f7049A = 32768;

    /* renamed from: B */
    private static final int f7050B = 3;

    /* renamed from: C */
    private static final int f7051C = 48;

    /* renamed from: D */
    private static final int f7052D = 4;

    /* renamed from: E */
    private static final int f7053E = 8;

    /* renamed from: F */
    private static final int f7054F = 64;

    /* renamed from: G */
    private static final int f7055G = 128;

    /* renamed from: H */
    private static C0879tj f7056H = null;

    /* renamed from: I */
    private static final short f7057I = 1024;

    /* renamed from: d */
    private static final String f7058d = "6015";

    /* renamed from: e */
    private static final byte f7059e = 0;

    /* renamed from: f */
    private static final byte f7060f = 1;

    /* renamed from: g */
    private static final byte f7061g = 2;

    /* renamed from: h */
    private static final byte f7062h = 3;

    /* renamed from: i */
    private static final int f7063i = 73;

    /* renamed from: j */
    private static final int f7064j = 1;

    /* renamed from: k */
    private static final int f7065k = 2;

    /* renamed from: l */
    private static final int f7066l = 4;

    /* renamed from: m */
    private static final int f7067m = 8;

    /* renamed from: n */
    private static final int f7068n = 64;

    /* renamed from: o */
    private static final int f7069o = 128;

    /* renamed from: p */
    private static final int f7070p = 16;

    /* renamed from: q */
    private static final int f7071q = 32;

    /* renamed from: r */
    private static final int f7072r = 64;

    /* renamed from: s */
    private static final int f7073s = 128;

    /* renamed from: t */
    private static final int f7074t = 256;

    /* renamed from: u */
    private static final int f7075u = 512;

    /* renamed from: v */
    private static final int f7076v = 1024;

    /* renamed from: w */
    private static final int f7077w = 2048;

    /* renamed from: x */
    private static final int f7078x = 4096;

    /* renamed from: y */
    private static final int f7079y = 8192;

    /* renamed from: z */
    private static final int f7080z = 16384;

    C0907ub(C0879tj tjVar) {
        super(tjVar);
        f7056H = tjVar;
        this.f7040b = 128;
        this.f7039a = 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        int[] iArr = new int[this.f7040b];
        if (tkVar.getClass() != C0893tr.class) {
            return 1;
        }
        C0893tr trVar = (C0893tr) tkVar;
        short s = 0;
        do {
            iArr[s] = mo5895a(s);
            s = (short) (s + 1);
        } while (s < this.f7040b);
        try {
            iArr[0] = 0;
            if (trVar.f6900o) {
                iArr[0] = iArr[0] | 1;
            }
            if (trVar.f6901p) {
                iArr[0] = iArr[0] | 2;
            }
            if (trVar.f6902q) {
                iArr[0] = iArr[0] | 4;
            }
            if (trVar.f6895S) {
                iArr[0] = iArr[0] | 8;
            }
            if (trVar.f6898m) {
                iArr[0] = iArr[0] | 128;
            }
            if (trVar.f6896T) {
                boolean z = trVar.f6903r == 17;
                if (trVar.f6904s == 17) {
                    z = true;
                }
                if (trVar.f6905t == 17) {
                    z = true;
                }
                if (trVar.f6906u == 17) {
                    z = true;
                }
                if (trVar.f6907v == 17) {
                    z = true;
                }
                if (trVar.f6908w == 17) {
                    z = true;
                }
                if (trVar.f6909x == 17) {
                    z = true;
                }
                if (!z) {
                    return 1;
                }
                iArr[0] = iArr[0] | 64;
            }
            iArr[1] = trVar.f6691e;
            iArr[2] = trVar.f6692f;
            iArr[3] = 4096;
            iArr[4] = mo5893a((Object) tkVar);
            iArr[5] = mo5901b(tkVar);
            if (trVar.f6910y) {
                iArr[5] = iArr[5] | 16;
            }
            if (trVar.f6911z) {
                iArr[5] = iArr[5] | 32;
            }
            if (trVar.f6877A) {
                iArr[5] = iArr[5] | 64;
            }
            if (trVar.f6888L) {
                iArr[5] = iArr[5] | 128;
            }
            if (trVar.f6878B) {
                iArr[5] = iArr[5] | 256;
            }
            if (trVar.f6879C) {
                iArr[5] = iArr[5] | 512;
            }
            if (trVar.f6880D) {
                iArr[5] = iArr[5] | 1024;
            }
            if (trVar.f6881E) {
                iArr[5] = iArr[5] | 2048;
            }
            if (trVar.f6882F) {
                iArr[5] = iArr[5] | 4096;
            }
            if (trVar.f6883G) {
                iArr[5] = iArr[5] | 8192;
            }
            if (trVar.f6884H) {
                iArr[5] = iArr[5] | 16384;
            }
            if (trVar.f6885I) {
                iArr[5] = iArr[5] | 32768;
            }
            iArr[6] = 0;
            byte b = trVar.f6891O;
            if (b == -1) {
                b = 0;
            }
            iArr[6] = b | iArr[6];
            if (trVar.f6889M) {
                iArr[6] = iArr[6] | 4;
            }
            if (trVar.f6890N) {
                iArr[6] = iArr[6] | 8;
            }
            byte b2 = trVar.f6894R;
            if (b2 == -1) {
                b2 = 0;
            }
            iArr[6] = ((short) (b2 << 4)) | iArr[6];
            if (trVar.f6892P) {
                iArr[6] = iArr[6] | 64;
            }
            if (trVar.f6893Q) {
                iArr[6] = iArr[6] | 128;
            }
            int a = mo5894a(trVar.f6689c, iArr, mo5894a(trVar.f6688b, iArr, 80, 7, false), 8, false);
            if (trVar.f6693g) {
                mo5894a(trVar.f6690d, iArr, a, 9, false);
            }
            iArr[10] = trVar.f6886J;
            iArr[11] = trVar.f6887K & 65535;
            iArr[12] = trVar.f6887K >> 16;
            byte b3 = trVar.f6903r;
            if (b3 == -1) {
                b3 = 0;
            }
            byte b4 = trVar.f6904s;
            if (b4 == -1) {
                b4 = 0;
            }
            iArr[13] = (short) (b3 | (b4 << 8));
            byte b5 = trVar.f6905t;
            if (b5 == -1) {
                b5 = 0;
            }
            byte b6 = trVar.f6906u;
            if (b6 == -1) {
                b6 = 0;
            }
            iArr[14] = (short) (b5 | (b6 << 8));
            byte b7 = trVar.f6907v;
            if (b7 == -1) {
                b7 = 0;
            }
            byte b8 = trVar.f6908w;
            if (b8 == -1) {
                b8 = 0;
            }
            iArr[15] = (short) (b7 | (b8 << 8));
            byte b9 = trVar.f6909x;
            if (b9 == -1) {
                b9 = 0;
            }
            iArr[16] = (short) b9;
            if (iArr[1] == 0 || iArr[2] == 0) {
                return 2;
            }
            if (mo5903b(iArr, this.f7040b - 1)) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5903b(int[] iArr, int i) {
        int i2 = 43690;
        int i3 = 0;
        do {
            int i4 = iArr[i3] & 65535;
            mo5890a((short) i3, (short) i4);
            int i5 = (i2 ^ i4) & 65535;
            i2 = (((i5 & 32768) > 0 ? 1 : 0) | ((i5 << 1) & 65535)) & 65535;
            i3++;
            if (i3 == 18) {
                i3 = 64;
                continue;
            }
        } while (i3 != i);
        mo5890a((short) i, (short) i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0880tk mo5886a() {
        C0893tr trVar = new C0893tr();
        int[] iArr = new int[this.f7040b];
        short s = 0;
        while (s < this.f7040b) {
            try {
                iArr[s] = mo5895a(s);
                s = (short) (s + 1);
            } catch (Exception unused) {
                return null;
            }
        }
        if ((iArr[0] & 1) > 0) {
            trVar.f6900o = true;
        } else {
            trVar.f6900o = false;
        }
        if ((iArr[0] & 2) > 0) {
            trVar.f6901p = true;
        } else {
            trVar.f6901p = false;
        }
        if ((iArr[0] & 4) > 0) {
            trVar.f6902q = true;
        } else {
            trVar.f6902q = false;
        }
        if ((iArr[0] & 8) > 0) {
            trVar.f6895S = true;
        } else {
            trVar.f6895S = false;
        }
        if ((iArr[0] & 64) > 0) {
            trVar.f6896T = true;
        } else {
            trVar.f6896T = false;
        }
        if ((iArr[0] & 128) > 0) {
            trVar.f6898m = true;
            trVar.f6899n = false;
        } else {
            trVar.f6898m = false;
            trVar.f6899n = true;
        }
        trVar.f6691e = (short) iArr[1];
        trVar.f6692f = (short) iArr[2];
        mo5898a((C0880tk) trVar, iArr[4]);
        mo5899a((Object) trVar, iArr[5]);
        if ((iArr[5] & 16) > 0) {
            trVar.f6910y = true;
        } else {
            trVar.f6910y = false;
        }
        if ((iArr[5] & 32) > 0) {
            trVar.f6911z = true;
        } else {
            trVar.f6911z = false;
        }
        if ((iArr[5] & 64) > 0) {
            trVar.f6877A = true;
        } else {
            trVar.f6877A = false;
        }
        if ((iArr[5] & 128) > 0) {
            trVar.f6888L = true;
        } else {
            trVar.f6888L = false;
        }
        if ((iArr[5] & 256) == 256) {
            trVar.f6878B = true;
        } else {
            trVar.f6878B = false;
        }
        if ((iArr[5] & 512) == 512) {
            trVar.f6879C = true;
        } else {
            trVar.f6879C = false;
        }
        if ((iArr[5] & 1024) == 1024) {
            trVar.f6880D = true;
        } else {
            trVar.f6880D = false;
        }
        if ((iArr[5] & 2048) == 2048) {
            trVar.f6881E = true;
        } else {
            trVar.f6881E = false;
        }
        if ((iArr[5] & 4096) == 4096) {
            trVar.f6882F = true;
        } else {
            trVar.f6882F = false;
        }
        if ((iArr[5] & 8192) == 8192) {
            trVar.f6883G = true;
        } else {
            trVar.f6883G = false;
        }
        if ((iArr[5] & 16384) == 16384) {
            trVar.f6884H = true;
        } else {
            trVar.f6884H = false;
        }
        if ((iArr[5] & 32768) == 32768) {
            trVar.f6885I = true;
        } else {
            trVar.f6885I = false;
        }
        short s2 = (short) (iArr[6] & 3);
        if (s2 == 0) {
            trVar.f6891O = 0;
        } else if (s2 == 1) {
            trVar.f6891O = 1;
        } else if (s2 == 2) {
            trVar.f6891O = 2;
        } else if (s2 == 3) {
            trVar.f6891O = 3;
        }
        if (((short) (iArr[6] & 4)) == 4) {
            trVar.f6889M = true;
        } else {
            trVar.f6889M = false;
        }
        if (((short) (iArr[6] & 8)) == 8) {
            trVar.f6890N = true;
        } else {
            trVar.f6890N = false;
        }
        short s3 = (short) ((iArr[6] & 48) >> 4);
        if (s3 == 0) {
            trVar.f6894R = 0;
        } else if (s3 == 1) {
            trVar.f6894R = 1;
        } else if (s3 == 2) {
            trVar.f6894R = 2;
        } else if (s3 == 3) {
            trVar.f6894R = 3;
        }
        if (((short) (iArr[6] & 64)) == 64) {
            trVar.f6892P = true;
        } else {
            trVar.f6892P = false;
        }
        if (((short) (iArr[6] & 128)) == 128) {
            trVar.f6893Q = true;
        } else {
            trVar.f6893Q = false;
        }
        trVar.f6886J = iArr[10];
        trVar.f6887K = iArr[11];
        trVar.f6887K |= (iArr[12] & 255) << 16;
        trVar.f6903r = (byte) (iArr[13] & 255);
        trVar.f6904s = (byte) ((iArr[13] >> 8) & 255);
        trVar.f6905t = (byte) (iArr[14] & 255);
        trVar.f6906u = (byte) ((iArr[14] >> 8) & 255);
        trVar.f6907v = (byte) (iArr[15] & 255);
        trVar.f6908w = (byte) ((iArr[15] >> 8) & 255);
        trVar.f6909x = (byte) (iArr[16] & 255);
        this.f7039a = (short) (iArr[73] >> 8);
        trVar.f6688b = mo5896a((iArr[7] & 255) / 2, iArr);
        trVar.f6689c = mo5896a((iArr[8] & 255) / 2, iArr);
        trVar.f6690d = mo5896a((iArr[9] & 255) / 2, iArr);
        return trVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5889b() {
        int a = mo5895a(9);
        return (((this.f7040b - 1) - 1) - ((((a & 255) / 2) + (((a & 65280) >> 8) / 2)) + 1)) * 2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5885a(byte[] bArr) {
        if (bArr.length > mo5889b()) {
            return 0;
        }
        int[] iArr = new int[this.f7040b];
        for (short s = 0; s < this.f7040b; s = (short) (s + 1)) {
            iArr[s] = mo5895a(s);
        }
        short b = (short) (((this.f7040b - (mo5889b() / 2)) - 1) - 1);
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            iArr[b] = ((i2 < bArr.length ? bArr[i2] & 255 : 0) << 8) | (bArr[i] & 255);
            i += 2;
            b = (short) (b + 1);
        }
        if (iArr[1] == 0 || iArr[2] == 0 || !mo5903b(iArr, this.f7040b - 1)) {
            return 0;
        }
        return bArr.length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo5888a(int i) {
        byte[] bArr = new byte[i];
        if (i == 0 || i > mo5889b()) {
            return null;
        }
        short b = (short) (((this.f7040b - (mo5889b() / 2)) - 1) - 1);
        int i2 = 0;
        while (i2 < i) {
            short s = (short) (b + 1);
            int a = mo5895a(b);
            int i3 = i2 + 1;
            if (i3 < i) {
                bArr[i3] = (byte) (a & 255);
            }
            bArr[i2] = (byte) ((a & 65280) >> 8);
            i2 += 2;
            b = s;
        }
        return bArr;
    }
}
