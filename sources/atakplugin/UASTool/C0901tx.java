package atakplugin.UASTool;

import com.google.common.base.Ascii;

/* renamed from: atakplugin.UASTool.tx */
class C0901tx extends C0905ua {

    /* renamed from: d */
    private static final short f6983d = 80;

    /* renamed from: e */
    private static final short f6984e = 63;

    /* renamed from: f */
    private static final short f6985f = 1024;

    /* renamed from: g */
    private static final int f6986g = 2;

    /* renamed from: h */
    private static final int f6987h = 4;

    /* renamed from: i */
    private static final int f6988i = 8;

    /* renamed from: j */
    private static final int f6989j = 256;

    /* renamed from: k */
    private static final int f6990k = 512;

    /* renamed from: l */
    private static final int f6991l = 1024;

    /* renamed from: m */
    private static final int f6992m = 2048;

    /* renamed from: n */
    private static final int f6993n = 4096;

    /* renamed from: o */
    private static final int f6994o = 8192;

    /* renamed from: p */
    private static final int f6995p = 16384;

    /* renamed from: q */
    private static final int f6996q = 32768;

    /* renamed from: r */
    private static C0879tj f6997r;

    C0901tx(C0879tj tjVar) {
        super(tjVar);
        f6997r = tjVar;
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
        byte z2 = f6997r.mo5884z();
        f6997r.mo5858b((byte) 119);
        if (f6997r.mo5861c().controlTransfer(64, 145, s3, s4, (byte[]) null, 0, 0) == 0) {
            z = true;
        }
        f6997r.mo5858b(z2);
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        if (tkVar.getClass() != C0887to.class) {
            return 1;
        }
        int[] iArr = new int[80];
        C0887to toVar = (C0887to) tkVar;
        for (short s = 0; s < 80; s = (short) (s + 1)) {
            iArr[s] = mo5895a(s);
        }
        try {
            int i = (iArr[0] & 65280) | 0;
            if (toVar.f6787l) {
                i |= 4;
            }
            if (toVar.f6786A) {
                i |= 8;
            }
            iArr[0] = toVar.f6788m ? i | 2 : i & bxu.f4221c;
            iArr[1] = toVar.f6691e;
            iArr[2] = toVar.f6692f;
            iArr[3] = 1536;
            iArr[4] = mo5893a((Object) tkVar);
            int b = mo5901b(tkVar);
            if (toVar.f6789n) {
                b |= 256;
            }
            if (toVar.f6790o) {
                b |= 512;
            }
            if (toVar.f6791p) {
                b |= 1024;
            }
            if (toVar.f6792q) {
                b |= 2048;
            }
            if (toVar.f6793r) {
                b |= 4096;
            }
            if (toVar.f6794s) {
                b |= 8192;
            }
            if (toVar.f6795t) {
                b |= 16384;
            }
            if (toVar.f6796u) {
                b |= 32768;
            }
            iArr[5] = b;
            iArr[10] = toVar.f6797v | (toVar.f6798w << 4) | (toVar.f6799x << 8) | (toVar.f6800y << Ascii.f8516FF);
            iArr[11] = toVar.f6801z;
            int a = mo5894a(toVar.f6689c, iArr, mo5894a(toVar.f6688b, iArr, 12, 7, true), 8, true);
            if (toVar.f6693g) {
                mo5894a(toVar.f6690d, iArr, a, 9, true);
            }
            if (iArr[1] == 0 || iArr[2] == 0) {
                return 2;
            }
            byte z = f6997r.mo5884z();
            f6997r.mo5858b((byte) 119);
            boolean a2 = mo5900a(iArr, 63);
            f6997r.mo5858b(z);
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
        C0887to toVar = new C0887to();
        int[] iArr = new int[80];
        for (int i = 0; i < 80; i++) {
            iArr[i] = mo5895a((short) i);
        }
        try {
            if ((iArr[0] & 4) == 4) {
                toVar.f6787l = true;
            } else {
                toVar.f6787l = false;
            }
            if ((iArr[0] & 8) == 8) {
                toVar.f6786A = true;
            } else {
                toVar.f6786A = false;
            }
            if ((iArr[0] & 2) == 2) {
                toVar.f6788m = true;
            } else {
                toVar.f6788m = false;
            }
            toVar.f6691e = (short) iArr[1];
            toVar.f6692f = (short) iArr[2];
            mo5898a((C0880tk) toVar, iArr[4]);
            mo5899a((Object) toVar, iArr[5]);
            if ((iArr[5] & 256) == 256) {
                toVar.f6789n = true;
            } else {
                toVar.f6789n = false;
            }
            if ((iArr[5] & 512) == 512) {
                toVar.f6790o = true;
            } else {
                toVar.f6790o = false;
            }
            if ((iArr[5] & 1024) == 1024) {
                toVar.f6791p = true;
            } else {
                toVar.f6791p = false;
            }
            if ((iArr[5] & 2048) == 2048) {
                toVar.f6792q = true;
            } else {
                toVar.f6792q = false;
            }
            if ((iArr[5] & 4096) == 4096) {
                toVar.f6793r = true;
            } else {
                toVar.f6793r = false;
            }
            if ((iArr[5] & 8192) == 8192) {
                toVar.f6794s = true;
            } else {
                toVar.f6794s = false;
            }
            if ((iArr[5] & 16384) == 16384) {
                toVar.f6795t = true;
            } else {
                toVar.f6795t = false;
            }
            if ((iArr[5] & 32768) == 32768) {
                toVar.f6796u = true;
            } else {
                toVar.f6796u = false;
            }
            int i2 = iArr[10];
            toVar.f6797v = (byte) (i2 & 15);
            toVar.f6798w = (byte) ((i2 & 240) >> 4);
            toVar.f6799x = (byte) ((i2 & 3840) >> 8);
            toVar.f6800y = (byte) ((i2 & 61440) >> 12);
            toVar.f6801z = (byte) (iArr[11] & 255);
            toVar.f6688b = mo5896a(((iArr[7] & 255) - 128) / 2, iArr);
            toVar.f6689c = mo5896a(((iArr[8] & 255) - 128) / 2, iArr);
            toVar.f6690d = mo5896a(((iArr[9] & 255) - 128) / 2, iArr);
            return toVar;
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
        byte z = f6997r.mo5884z();
        f6997r.mo5858b((byte) 119);
        boolean a = mo5900a(iArr, 63);
        f6997r.mo5858b(z);
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
        short b = (short) (((short) ((63 - (mo5889b() / 2)) - 1)) & 65535);
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
