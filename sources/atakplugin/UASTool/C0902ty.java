package atakplugin.UASTool;

import com.google.common.base.Ascii;

/* renamed from: atakplugin.UASTool.ty */
class C0902ty extends C0905ua {

    /* renamed from: d */
    private static final short f6998d = 80;

    /* renamed from: e */
    private static final short f6999e = 63;

    /* renamed from: f */
    private static final short f7000f = 1024;

    /* renamed from: g */
    private static final int f7001g = 2;

    /* renamed from: h */
    private static final int f7002h = 4;

    /* renamed from: i */
    private static final int f7003i = 8;

    /* renamed from: j */
    private static final int f7004j = 256;

    /* renamed from: k */
    private static final int f7005k = 512;

    /* renamed from: l */
    private static final int f7006l = 1024;

    /* renamed from: m */
    private static final int f7007m = 2048;

    /* renamed from: n */
    private static final int f7008n = 4096;

    /* renamed from: o */
    private static final int f7009o = 8192;

    /* renamed from: p */
    private static final int f7010p = 16384;

    /* renamed from: q */
    private static final int f7011q = 32768;

    /* renamed from: r */
    private static C0879tj f7012r;

    C0902ty(C0879tj tjVar) {
        super(tjVar);
        f7012r = tjVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5890a(short s, short s2) {
        short s3 = s2 & 65535;
        short s4 = s & 65535;
        boolean z = false;
        if (s >= 1024) {
            return false;
        }
        byte z2 = f7012r.mo5884z();
        f7012r.mo5858b((byte) 119);
        if (f7012r.mo5861c().controlTransfer(64, 145, s3, s4, (byte[]) null, 0, 0) == 0) {
            z = true;
        }
        f7012r.mo5858b(z2);
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        int[] iArr = new int[80];
        if (tkVar.getClass() != C0889tp.class) {
            return 1;
        }
        C0889tp tpVar = (C0889tp) tkVar;
        for (short s = 0; s < 80; s = (short) (s + 1)) {
            iArr[s] = mo5895a(s);
        }
        try {
            int i = (iArr[0] & 65280) | 0;
            if (tpVar.f6816l) {
                i |= 4;
            }
            if (tpVar.f6815A) {
                i |= 8;
            }
            iArr[0] = tpVar.f6817m ? i | 2 : i & bxu.f4221c;
            iArr[1] = tpVar.f6691e;
            iArr[2] = tpVar.f6692f;
            iArr[3] = 1536;
            iArr[4] = mo5893a((Object) tkVar);
            int b = mo5901b(tkVar);
            if (tpVar.f6818n) {
                b |= 256;
            }
            if (tpVar.f6819o) {
                b |= 512;
            }
            if (tpVar.f6820p) {
                b |= 1024;
            }
            if (tpVar.f6821q) {
                b |= 2048;
            }
            if (tpVar.f6822r) {
                b |= 4096;
            }
            if (tpVar.f6823s) {
                b |= 8192;
            }
            if (tpVar.f6824t) {
                b |= 16384;
            }
            if (tpVar.f6825u) {
                b |= 32768;
            }
            iArr[5] = b;
            iArr[10] = tpVar.f6826v | (tpVar.f6827w << 4) | (tpVar.f6828x << 8) | (tpVar.f6829y << Ascii.f8516FF);
            iArr[11] = tpVar.f6830z;
            int a = mo5894a(tpVar.f6689c, iArr, mo5894a(tpVar.f6688b, iArr, 12, 7, true), 8, true);
            if (tpVar.f6693g) {
                mo5894a(tpVar.f6690d, iArr, a, 9, true);
            }
            if (iArr[1] == 0 || iArr[2] == 0) {
                return 2;
            }
            byte z = f7012r.mo5884z();
            f7012r.mo5858b((byte) 119);
            boolean a2 = mo5900a(iArr, 80);
            f7012r.mo5858b(z);
            if (a2) {
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
        C0889tp tpVar = new C0889tp();
        int[] iArr = new int[80];
        for (int i = 0; i < 80; i++) {
            iArr[i] = mo5895a((short) i);
        }
        try {
            if ((iArr[0] & 4) == 4) {
                tpVar.f6816l = true;
            } else {
                tpVar.f6816l = false;
            }
            if ((iArr[0] & 8) == 8) {
                tpVar.f6815A = true;
            } else {
                tpVar.f6815A = false;
            }
            if ((iArr[0] & 2) == 2) {
                tpVar.f6817m = true;
            } else {
                tpVar.f6817m = false;
            }
            tpVar.f6691e = (short) iArr[1];
            tpVar.f6692f = (short) iArr[2];
            mo5898a((C0880tk) tpVar, iArr[4]);
            mo5899a((Object) tpVar, iArr[5]);
            if ((iArr[5] & 256) == 256) {
                tpVar.f6818n = true;
            } else {
                tpVar.f6818n = false;
            }
            if ((iArr[5] & 512) == 512) {
                tpVar.f6819o = true;
            } else {
                tpVar.f6819o = false;
            }
            if ((iArr[5] & 1024) == 1024) {
                tpVar.f6820p = true;
            } else {
                tpVar.f6820p = false;
            }
            if ((iArr[5] & 2048) == 2048) {
                tpVar.f6821q = true;
            } else {
                tpVar.f6821q = false;
            }
            if ((iArr[5] & 4096) == 4096) {
                tpVar.f6822r = true;
            } else {
                tpVar.f6822r = false;
            }
            if ((iArr[5] & 8192) == 8192) {
                tpVar.f6823s = true;
            } else {
                tpVar.f6823s = false;
            }
            if ((iArr[5] & 16384) == 16384) {
                tpVar.f6824t = true;
            } else {
                tpVar.f6824t = false;
            }
            if ((iArr[5] & 32768) == 32768) {
                tpVar.f6825u = true;
            } else {
                tpVar.f6825u = false;
            }
            int i2 = iArr[10];
            tpVar.f6826v = (byte) (i2 & 15);
            tpVar.f6827w = (byte) ((i2 & 240) >> 4);
            tpVar.f6828x = (byte) ((i2 & 3840) >> 8);
            tpVar.f6829y = (byte) ((i2 & 61440) >> 12);
            tpVar.f6830z = (byte) (iArr[11] & 255);
            tpVar.f6688b = mo5896a(((iArr[7] & 255) - 128) / 2, iArr);
            tpVar.f6689c = mo5896a(((iArr[8] & 255) - 128) / 2, iArr);
            tpVar.f6690d = mo5896a(((iArr[9] & 255) - 128) / 2, iArr);
            return tpVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5889b() {
        return (((63 - ((((((mo5895a(7) & 65280) >> 8) / 2) + 12) + (((mo5895a(8) & 65280) >> 8) / 2)) + 1)) - (((65280 & mo5895a(9)) >> 8) / 2)) - 1) * 2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5885a(byte[] bArr) {
        if (bArr.length > mo5889b()) {
            return 0;
        }
        int[] iArr = new int[80];
        for (short s = 0; s < 80; s = (short) (s + 1)) {
            iArr[s] = mo5895a(s);
        }
        short b = (short) (((short) ((63 - (mo5889b() / 2)) - 1)) & 65535);
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            iArr[b] = ((i2 < bArr.length ? bArr[i2] & 255 : 0) << 8) | (bArr[i] & 255);
            i += 2;
            b = (short) (b + 1);
        }
        if (iArr[1] == 0 || iArr[2] == 0) {
            return 0;
        }
        byte z = f7012r.mo5884z();
        f7012r.mo5858b((byte) 119);
        boolean a = mo5900a(iArr, 63);
        f7012r.mo5858b(z);
        if (!a) {
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
        short b = (short) ((63 - (mo5889b() / 2)) - 1);
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
