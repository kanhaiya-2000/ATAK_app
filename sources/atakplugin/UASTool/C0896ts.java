package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.ts */
class C0896ts extends C0905ua {

    /* renamed from: A */
    private static final int f6938A = 2048;

    /* renamed from: B */
    private static final int f6939B = 4096;

    /* renamed from: C */
    private static final int f6940C = 8192;

    /* renamed from: D */
    private static final int f6941D = 16384;

    /* renamed from: E */
    private static final int f6942E = 32768;

    /* renamed from: d */
    private static final byte f6943d = 12;

    /* renamed from: e */
    private static final String f6944e = "6010";

    /* renamed from: f */
    private static final int f6945f = 3;

    /* renamed from: g */
    private static final int f6946g = 48;

    /* renamed from: h */
    private static final int f6947h = 768;

    /* renamed from: i */
    private static final int f6948i = 12288;

    /* renamed from: j */
    private static final int f6949j = 4;

    /* renamed from: k */
    private static final int f6950k = 8;

    /* renamed from: l */
    private static final int f6951l = 64;

    /* renamed from: m */
    private static final int f6952m = 128;

    /* renamed from: n */
    private static final int f6953n = 1024;

    /* renamed from: o */
    private static final int f6954o = 2048;

    /* renamed from: p */
    private static final int f6955p = 16384;

    /* renamed from: q */
    private static final int f6956q = 32768;

    /* renamed from: r */
    private static final int f6957r = 24;

    /* renamed from: s */
    private static final int f6958s = 0;

    /* renamed from: t */
    private static final int f6959t = 1;

    /* renamed from: u */
    private static final int f6960u = 2;

    /* renamed from: v */
    private static final int f6961v = 4;

    /* renamed from: w */
    private static final int f6962w = 8;

    /* renamed from: x */
    private static final int f6963x = 256;

    /* renamed from: y */
    private static final int f6964y = 512;

    /* renamed from: z */
    private static final int f6965z = 1024;

    C0896ts(C0879tj tjVar) {
        super(tjVar);
        mo5892a((byte) 12);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        boolean z;
        int i;
        int[] iArr = new int[this.f7040b];
        if (tkVar.getClass() != C0882tm.class) {
            return 1;
        }
        C0882tm tmVar = (C0882tm) tkVar;
        try {
            if (!tmVar.f6735x) {
                if (tmVar.f6737z) {
                    iArr[0] = iArr[0] | 1;
                } else if (tmVar.f6713B) {
                    iArr[0] = iArr[0] | 2;
                } else {
                    iArr[0] = iArr[0] | 4;
                }
            }
            if (tmVar.f6718G) {
                iArr[0] = iArr[0] | 8;
            }
            if (!tmVar.f6736y) {
                if (tmVar.f6712A) {
                    iArr[0] = iArr[0] | 256;
                } else if (tmVar.f6714C) {
                    iArr[0] = iArr[0] | 512;
                } else {
                    iArr[0] = iArr[0] | 1024;
                }
            }
            if (tmVar.f6719H) {
                iArr[0] = iArr[0] | 2048;
            }
            if (tmVar.f6717F) {
                iArr[0] = iArr[0] | 32768;
            }
            iArr[1] = tmVar.f6691e;
            iArr[2] = tmVar.f6692f;
            iArr[3] = 1792;
            iArr[4] = mo5893a((Object) tkVar);
            iArr[5] = mo5901b(tkVar);
            iArr[6] = 0;
            byte b = tmVar.f6725n;
            if (b == -1) {
                b = 0;
            }
            iArr[6] = b | iArr[6];
            if (tmVar.f6723l) {
                iArr[6] = iArr[6] | 4;
            }
            if (tmVar.f6724m) {
                iArr[6] = iArr[6] | 8;
            }
            byte b2 = tmVar.f6728q;
            if (b2 == -1) {
                b2 = 0;
            }
            iArr[6] = ((short) (b2 << 4)) | iArr[6];
            if (tmVar.f6726o) {
                iArr[6] = iArr[6] | 64;
            }
            if (tmVar.f6727p) {
                iArr[6] = iArr[6] | 128;
            }
            byte b3 = tmVar.f6731t;
            if (b3 == -1) {
                b3 = 0;
            }
            iArr[6] = ((short) (b3 << 8)) | iArr[6];
            if (tmVar.f6729r) {
                iArr[6] = iArr[6] | 1024;
            }
            if (tmVar.f6730s) {
                iArr[6] = iArr[6] | 2048;
            }
            iArr[6] = ((short) (tmVar.f6734w << 12)) | iArr[6];
            if (tmVar.f6732u) {
                iArr[6] = iArr[6] | 16384;
            }
            if (tmVar.f6733v) {
                iArr[6] = iArr[6] | 32768;
            }
            if (this.f7039a == 70) {
                z = true;
                i = 13;
            } else {
                z = false;
                i = 77;
            }
            int a = mo5894a(tmVar.f6688b, iArr, i, 7, z);
            int a2 = mo5894a(tmVar.f6689c, iArr, a, 8, z);
            if (tmVar.f6693g) {
                mo5894a(tmVar.f6690d, iArr, a2, 9, z);
            }
            int i2 = tmVar.f6722K;
            if (i2 == 0) {
                iArr[11] = 0;
            } else if (i2 == 1) {
                iArr[11] = 8;
            } else if (i2 == 2) {
                iArr[11] = 16;
            } else if (i2 != 3) {
                iArr[11] = 0;
            } else {
                iArr[11] = 24;
            }
            iArr[12] = this.f7039a;
            if (iArr[1] == 0 || iArr[2] == 0) {
                return 2;
            }
            if (mo5900a(iArr, this.f7040b - 1)) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0880tk mo5886a() {
        C0882tm tmVar = new C0882tm();
        int[] iArr = new int[this.f7040b];
        if (this.f7041c) {
            return tmVar;
        }
        short s = 0;
        while (s < this.f7040b) {
            try {
                iArr[s] = mo5895a(s);
                s = (short) (s + 1);
            } catch (Exception unused) {
                return null;
            }
        }
        int i = iArr[0];
        short s2 = (short) (i & 7);
        if (s2 == 0) {
            tmVar.f6735x = true;
        } else if (s2 == 1) {
            tmVar.f6737z = true;
        } else if (s2 == 2) {
            tmVar.f6713B = true;
        } else if (s2 != 4) {
            tmVar.f6735x = true;
        } else {
            tmVar.f6715D = true;
        }
        if (((short) ((i & 8) >> 3)) == 1) {
            tmVar.f6718G = true;
            tmVar.f6720I = false;
        } else {
            tmVar.f6718G = false;
            tmVar.f6720I = true;
        }
        short s3 = (short) ((i & 1792) >> 8);
        if (s3 == 0) {
            tmVar.f6736y = true;
        } else if (s3 == 1) {
            tmVar.f6712A = true;
        } else if (s3 == 2) {
            tmVar.f6714C = true;
        } else if (s3 != 4) {
            tmVar.f6736y = true;
        } else {
            tmVar.f6716E = true;
        }
        if (((short) ((i & 2048) >> 11)) == 1) {
            tmVar.f6719H = true;
            tmVar.f6721J = false;
        } else {
            tmVar.f6719H = false;
            tmVar.f6721J = true;
        }
        if (((short) ((i & 32768) >> 15)) == 1) {
            tmVar.f6717F = true;
        } else {
            tmVar.f6717F = false;
        }
        tmVar.f6691e = (short) iArr[1];
        tmVar.f6692f = (short) iArr[2];
        mo5898a((C0880tk) tmVar, iArr[4]);
        mo5899a((Object) tmVar, iArr[5]);
        short s4 = (short) (iArr[6] & 3);
        if (s4 == 0) {
            tmVar.f6725n = 0;
        } else if (s4 == 1) {
            tmVar.f6725n = 1;
        } else if (s4 == 2) {
            tmVar.f6725n = 2;
        } else if (s4 == 3) {
            tmVar.f6725n = 3;
        }
        if (((short) (iArr[6] & 4)) == 4) {
            tmVar.f6723l = true;
        } else {
            tmVar.f6723l = false;
        }
        if (((short) (iArr[6] & 8)) == 8) {
            tmVar.f6724m = true;
        } else {
            tmVar.f6724m = false;
        }
        short s5 = (short) ((iArr[6] & 48) >> 4);
        if (s5 == 0) {
            tmVar.f6728q = 0;
        } else if (s5 == 1) {
            tmVar.f6728q = 1;
        } else if (s5 == 2) {
            tmVar.f6728q = 2;
        } else if (s5 == 3) {
            tmVar.f6728q = 3;
        }
        if (((short) (iArr[6] & 64)) == 64) {
            tmVar.f6726o = true;
        } else {
            tmVar.f6726o = false;
        }
        short s6 = (short) (iArr[6] & 128);
        if (s6 == 128) {
            tmVar.f6727p = true;
        } else {
            tmVar.f6727p = false;
        }
        short s7 = (short) ((iArr[6] & f6947h) >> 8);
        if (s7 == 0) {
            tmVar.f6731t = 0;
        } else if (s7 == 1) {
            tmVar.f6731t = 1;
        } else if (s7 == 2) {
            tmVar.f6731t = 2;
        } else if (s7 == 3) {
            tmVar.f6731t = 3;
        }
        if (((short) (iArr[6] & 1024)) == 1024) {
            tmVar.f6729r = true;
        } else {
            tmVar.f6729r = false;
        }
        int i2 = iArr[6];
        if (s6 == 2048) {
            tmVar.f6730s = true;
        } else {
            tmVar.f6730s = false;
        }
        short s8 = (short) ((iArr[6] & f6948i) >> 12);
        if (s8 == 0) {
            tmVar.f6734w = 0;
        } else if (s8 == 1) {
            tmVar.f6734w = 1;
        } else if (s8 == 2) {
            tmVar.f6734w = 2;
        } else if (s8 == 3) {
            tmVar.f6734w = 3;
        }
        if (((short) (iArr[6] & 16384)) == 16384) {
            tmVar.f6732u = true;
        } else {
            tmVar.f6732u = false;
        }
        if (((short) (iArr[6] & 32768)) == 32768) {
            tmVar.f6733v = true;
        } else {
            tmVar.f6733v = false;
        }
        short s9 = (short) ((iArr[11] & 24) >> 3);
        if (s9 < 4) {
            tmVar.f6722K = s9;
        } else {
            tmVar.f6722K = 0;
        }
        int i3 = iArr[7] & 255;
        if (this.f7039a == 70) {
            tmVar.f6688b = mo5896a((i3 - 128) / 2, iArr);
            tmVar.f6689c = mo5896a(((iArr[8] & 255) - 128) / 2, iArr);
            tmVar.f6690d = mo5896a(((iArr[9] & 255) - 128) / 2, iArr);
        } else {
            tmVar.f6688b = mo5896a(i3 / 2, iArr);
            tmVar.f6689c = mo5896a((iArr[8] & 255) / 2, iArr);
            tmVar.f6690d = mo5896a((iArr[9] & 255) / 2, iArr);
        }
        return tmVar;
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
        if (iArr[1] == 0 || iArr[2] == 0 || !mo5900a(iArr, this.f7040b - 1)) {
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
