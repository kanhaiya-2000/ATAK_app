package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.tz */
class C0903tz extends C0905ua {

    /* renamed from: d */
    private static final byte f7013d = 12;

    /* renamed from: e */
    private static final String f7014e = "6011";

    /* renamed from: f */
    private static final int f7015f = 3;

    /* renamed from: g */
    private static final int f7016g = 48;

    /* renamed from: h */
    private static final int f7017h = 768;

    /* renamed from: i */
    private static final int f7018i = 12288;

    /* renamed from: j */
    private static final int f7019j = 4;

    /* renamed from: k */
    private static final int f7020k = 8;

    /* renamed from: l */
    private static final int f7021l = 64;

    /* renamed from: m */
    private static final int f7022m = 128;

    /* renamed from: n */
    private static final int f7023n = 1024;

    /* renamed from: o */
    private static final int f7024o = 2048;

    /* renamed from: p */
    private static final int f7025p = 16384;

    /* renamed from: q */
    private static final int f7026q = 32768;

    /* renamed from: r */
    private static final int f7027r = 24;

    /* renamed from: s */
    private static final int f7028s = 4096;

    /* renamed from: t */
    private static final int f7029t = 8192;

    /* renamed from: u */
    private static final int f7030u = 16384;

    /* renamed from: v */
    private static final int f7031v = 32768;

    C0903tz(C0879tj tjVar) {
        super(tjVar);
        mo5892a((byte) 12);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        boolean z;
        int i;
        int[] iArr = new int[this.f7040b];
        if (tkVar.getClass() != C0891tq.class) {
            return 1;
        }
        C0891tq tqVar = (C0891tq) tkVar;
        try {
            iArr[0] = 0;
            if (tqVar.f6845B) {
                iArr[0] = iArr[0] | 8;
            }
            if (tqVar.f6851H) {
                iArr[0] = iArr[0] | 128;
            }
            if (tqVar.f6848E) {
                iArr[0] = iArr[0] | 2048;
            }
            if (tqVar.f6854K) {
                iArr[0] = iArr[0] | 32768;
            }
            iArr[1] = tqVar.f6691e;
            iArr[2] = tqVar.f6692f;
            iArr[3] = 2048;
            iArr[4] = mo5893a((Object) tkVar);
            iArr[5] = mo5901b(tkVar);
            if (tqVar.f6847D) {
                iArr[5] = (short) (iArr[5] | 4096);
            }
            if (tqVar.f6850G) {
                iArr[5] = (short) (iArr[5] | 8192);
            }
            if (tqVar.f6853J) {
                iArr[5] = (short) (iArr[5] | 16384);
            }
            if (tqVar.f6856M) {
                iArr[5] = (short) (iArr[5] | 32768);
            }
            iArr[6] = 0;
            byte b = tqVar.f6860n;
            if (b == -1) {
                b = 0;
            }
            iArr[6] = b | iArr[6];
            if (tqVar.f6858l) {
                iArr[6] = iArr[6] | 4;
            }
            if (tqVar.f6859m) {
                iArr[6] = iArr[6] | 8;
            }
            byte b2 = tqVar.f6863q;
            if (b2 == -1) {
                b2 = 0;
            }
            iArr[6] = ((short) (b2 << 4)) | iArr[6];
            if (tqVar.f6861o) {
                iArr[6] = iArr[6] | 64;
            }
            if (tqVar.f6862p) {
                iArr[6] = iArr[6] | 128;
            }
            byte b3 = tqVar.f6866t;
            if (b3 == -1) {
                b3 = 0;
            }
            iArr[6] = ((short) (b3 << 8)) | iArr[6];
            if (tqVar.f6864r) {
                iArr[6] = iArr[6] | 1024;
            }
            if (tqVar.f6865s) {
                iArr[6] = iArr[6] | 2048;
            }
            iArr[6] = ((short) (tqVar.f6869w << 12)) | iArr[6];
            if (tqVar.f6867u) {
                iArr[6] = iArr[6] | 16384;
            }
            if (tqVar.f6868v) {
                iArr[6] = iArr[6] | 32768;
            }
            if (this.f7039a == 70) {
                z = true;
                i = 13;
            } else {
                z = false;
                i = 77;
            }
            int a = mo5894a(tqVar.f6688b, iArr, i, 7, z);
            int a2 = mo5894a(tqVar.f6689c, iArr, a, 8, z);
            if (tqVar.f6693g) {
                mo5894a(tqVar.f6690d, iArr, a2, 9, z);
            }
            int i2 = tqVar.f6857N;
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
        C0891tq tqVar = new C0891tq();
        int[] iArr = new int[this.f7040b];
        if (this.f7041c) {
            return tqVar;
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
        if (((short) ((iArr[0] & 8) >> 3)) == 1) {
            tqVar.f6845B = true;
            tqVar.f6846C = false;
        } else {
            tqVar.f6845B = false;
            tqVar.f6846C = true;
        }
        if (((short) ((iArr[0] & 128) >> 7)) == 1) {
            tqVar.f6851H = true;
            tqVar.f6852I = false;
        } else {
            tqVar.f6851H = false;
            tqVar.f6852I = true;
        }
        if (((short) ((iArr[0] & 2048) >> 11)) == 1) {
            tqVar.f6848E = true;
            tqVar.f6849F = false;
        } else {
            tqVar.f6848E = false;
            tqVar.f6849F = true;
        }
        if (((short) ((iArr[0] & 32768) >> 15)) == 1) {
            tqVar.f6854K = true;
            tqVar.f6855L = false;
        } else {
            tqVar.f6854K = false;
            tqVar.f6855L = true;
        }
        tqVar.f6691e = (short) iArr[1];
        tqVar.f6692f = (short) iArr[2];
        mo5898a((C0880tk) tqVar, iArr[4]);
        mo5899a((Object) tqVar, iArr[5]);
        if ((iArr[5] & 4096) == 4096) {
            tqVar.f6847D = true;
        }
        if ((iArr[5] & 8192) == 8192) {
            tqVar.f6850G = true;
        }
        if ((iArr[5] & 16384) == 16384) {
            tqVar.f6850G = true;
        }
        if ((iArr[5] & 32768) == 32768) {
            tqVar.f6850G = true;
        }
        short s2 = (short) (iArr[6] & 3);
        if (s2 == 0) {
            tqVar.f6860n = 0;
        } else if (s2 == 1) {
            tqVar.f6860n = 1;
        } else if (s2 == 2) {
            tqVar.f6860n = 2;
        } else if (s2 == 3) {
            tqVar.f6860n = 3;
        }
        if (((short) (iArr[6] & 4)) == 4) {
            tqVar.f6858l = true;
        } else {
            tqVar.f6858l = false;
        }
        if (((short) (iArr[6] & 8)) == 8) {
            tqVar.f6859m = true;
        } else {
            tqVar.f6859m = false;
        }
        short s3 = (short) ((iArr[6] & 48) >> 4);
        if (s3 == 0) {
            tqVar.f6863q = 0;
        } else if (s3 == 1) {
            tqVar.f6863q = 1;
        } else if (s3 == 2) {
            tqVar.f6863q = 2;
        } else if (s3 == 3) {
            tqVar.f6863q = 3;
        }
        if (((short) (iArr[6] & 64)) == 64) {
            tqVar.f6861o = true;
        } else {
            tqVar.f6861o = false;
        }
        if (((short) (iArr[6] & 128)) == 128) {
            tqVar.f6862p = true;
        } else {
            tqVar.f6862p = false;
        }
        short s4 = (short) ((iArr[6] & f7017h) >> 8);
        if (s4 == 0) {
            tqVar.f6866t = 0;
        } else if (s4 == 1) {
            tqVar.f6866t = 1;
        } else if (s4 == 2) {
            tqVar.f6866t = 2;
        } else if (s4 == 3) {
            tqVar.f6866t = 3;
        }
        if (((short) (iArr[6] & 1024)) == 1024) {
            tqVar.f6864r = true;
        } else {
            tqVar.f6864r = false;
        }
        if (((short) (iArr[6] & 2048)) == 2048) {
            tqVar.f6865s = true;
        } else {
            tqVar.f6865s = false;
        }
        short s5 = (short) ((iArr[6] & f7018i) >> 12);
        if (s5 == 0) {
            tqVar.f6869w = 0;
        } else if (s5 == 1) {
            tqVar.f6869w = 1;
        } else if (s5 == 2) {
            tqVar.f6869w = 2;
        } else if (s5 == 3) {
            tqVar.f6869w = 3;
        }
        if (((short) (iArr[6] & 16384)) == 16384) {
            tqVar.f6867u = true;
        } else {
            tqVar.f6867u = false;
        }
        if (((short) (iArr[6] & 32768)) == 32768) {
            tqVar.f6868v = true;
        } else {
            tqVar.f6868v = false;
        }
        short s6 = (short) ((iArr[11] & 24) >> 3);
        if (s6 < 4) {
            tqVar.f6857N = s6;
        } else {
            tqVar.f6857N = 0;
        }
        int i = iArr[7] & 255;
        if (this.f7039a == 70) {
            tqVar.f6688b = mo5896a((i - 128) / 2, iArr);
            tqVar.f6689c = mo5896a(((iArr[8] & 255) - 128) / 2, iArr);
            tqVar.f6690d = mo5896a(((iArr[9] & 255) - 128) / 2, iArr);
        } else {
            tqVar.f6688b = mo5896a(i / 2, iArr);
            tqVar.f6689c = mo5896a((iArr[8] & 255) / 2, iArr);
            tqVar.f6690d = mo5896a((iArr[9] & 255) / 2, iArr);
        }
        return tqVar;
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
