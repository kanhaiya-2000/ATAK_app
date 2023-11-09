package atakplugin.UASTool;

import com.google.common.base.Ascii;

/* renamed from: atakplugin.UASTool.tw */
class C0900tw extends C0905ua {

    /* renamed from: d */
    private static final byte f6974d = 15;

    /* renamed from: e */
    private static final String f6975e = "6014";

    /* renamed from: f */
    private static final int f6976f = 3;

    /* renamed from: g */
    private static final int f6977g = 768;

    /* renamed from: h */
    private static final int f6978h = 4;

    /* renamed from: i */
    private static final int f6979i = 8;

    /* renamed from: j */
    private static final int f6980j = 1024;

    /* renamed from: k */
    private static final int f6981k = 2048;

    /* renamed from: l */
    private static C0879tj f6982l;

    C0900tw(C0879tj tjVar) {
        super(tjVar);
        mo5892a((byte) 15);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        int[] iArr = new int[this.f7040b];
        if (tkVar.getClass() != C0884tn.class) {
            return 1;
        }
        C0884tn tnVar = (C0884tn) tkVar;
        try {
            if (tnVar.f6744C) {
                iArr[0] = iArr[0] | 1;
            } else if (tnVar.f6745D) {
                iArr[0] = iArr[0] | 2;
            } else if (tnVar.f6746E) {
                iArr[0] = iArr[0] | 4;
            }
            if (tnVar.f6747F) {
                iArr[0] = iArr[0] | 8;
            }
            if (tnVar.f6752K) {
                iArr[0] = iArr[0] | 16;
            }
            if (tnVar.f6748G) {
                iArr[0] = iArr[0] | 256;
            }
            if (tnVar.f6749H) {
                iArr[0] = iArr[0] | 512;
            }
            if (tnVar.f6750I) {
                iArr[0] = iArr[0] | 1024;
            }
            if (tnVar.f6751J) {
                iArr[0] = iArr[0] | 32768;
            }
            iArr[1] = tnVar.f6691e;
            iArr[2] = tnVar.f6692f;
            iArr[3] = 2304;
            iArr[4] = mo5893a((Object) tkVar);
            iArr[5] = mo5901b(tkVar);
            byte b = tnVar.f6756n;
            if (b == -1) {
                b = 0;
            }
            iArr[6] = b | iArr[6];
            if (tnVar.f6754l) {
                iArr[6] = iArr[6] | 4;
            }
            if (tnVar.f6755m) {
                iArr[6] = iArr[6] | 8;
            }
            byte b2 = tnVar.f6759q;
            if (b2 == -1) {
                b2 = 0;
            }
            iArr[6] = ((short) (b2 << 8)) | iArr[6];
            if (tnVar.f6757o) {
                iArr[6] = iArr[6] | 1024;
            }
            if (tnVar.f6758p) {
                iArr[6] = iArr[6] | 2048;
            }
            int a = mo5894a(tnVar.f6688b, iArr, 80, 7, false);
            int a2 = mo5894a(tnVar.f6689c, iArr, a, 8, false);
            if (tnVar.f6693g) {
                mo5894a(tnVar.f6690d, iArr, a2, 9, false);
            }
            iArr[10] = 0;
            iArr[11] = 0;
            iArr[12] = 0;
            iArr[12] = tnVar.f6760r | (tnVar.f6761s << 4) | (tnVar.f6762t << 8) | (tnVar.f6763u << Ascii.f8516FF);
            iArr[13] = 0;
            iArr[13] = (tnVar.f6767y << Ascii.f8516FF) | tnVar.f6764v | (tnVar.f6765w << 4) | (tnVar.f6766x << 8);
            iArr[14] = 0;
            iArr[14] = tnVar.f6768z | (tnVar.f6742A << 4);
            iArr[15] = this.f7039a;
            iArr[69] = 72;
            if (this.f7039a == 70) {
                return 1;
            }
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
        C0884tn tnVar = new C0884tn();
        int[] iArr = new int[this.f7040b];
        if (this.f7041c) {
            return tnVar;
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
        tnVar.f6743B = false;
        int i = iArr[0] & 15;
        if (i == 0) {
            tnVar.f6743B = true;
        } else if (i == 1) {
            tnVar.f6744C = true;
        } else if (i == 2) {
            tnVar.f6745D = true;
        } else if (i == 4) {
            tnVar.f6746E = true;
        } else if (i != 8) {
            tnVar.f6743B = true;
        } else {
            tnVar.f6747F = true;
        }
        if ((iArr[0] & 16) > 0) {
            tnVar.f6752K = true;
            tnVar.f6753L = false;
        } else {
            tnVar.f6752K = false;
            tnVar.f6753L = true;
        }
        if ((iArr[0] & 256) > 0) {
            tnVar.f6748G = true;
        } else {
            tnVar.f6748G = false;
        }
        if ((iArr[0] & 512) > 0) {
            tnVar.f6749H = true;
        } else {
            tnVar.f6749H = false;
        }
        if ((iArr[0] & 1024) > 0) {
            tnVar.f6750I = true;
        } else {
            tnVar.f6750I = false;
        }
        if ((iArr[0] & 32768) > 0) {
            tnVar.f6751J = true;
        }
        tnVar.f6691e = (short) iArr[1];
        tnVar.f6692f = (short) iArr[2];
        mo5898a((C0880tk) tnVar, iArr[4]);
        mo5899a((Object) tnVar, iArr[5]);
        int i2 = iArr[6] & 3;
        if (i2 == 0) {
            tnVar.f6756n = 0;
        } else if (i2 == 1) {
            tnVar.f6756n = 1;
        } else if (i2 == 2) {
            tnVar.f6756n = 2;
        } else if (i2 == 3) {
            tnVar.f6756n = 3;
        }
        if ((iArr[6] & 4) > 0) {
            tnVar.f6754l = true;
        } else {
            tnVar.f6754l = false;
        }
        if ((iArr[6] & 8) > 0) {
            tnVar.f6755m = true;
        } else {
            tnVar.f6755m = false;
        }
        short s2 = (short) ((iArr[6] & f6977g) >> 8);
        if (s2 == 0) {
            tnVar.f6759q = 0;
        } else if (s2 == 1) {
            tnVar.f6759q = 1;
        } else if (s2 == 2) {
            tnVar.f6759q = 2;
        } else if (s2 == 3) {
            tnVar.f6759q = 3;
        }
        if ((iArr[6] & 1024) > 0) {
            tnVar.f6757o = true;
        } else {
            tnVar.f6757o = false;
        }
        if ((iArr[6] & 2048) > 0) {
            tnVar.f6758p = true;
        } else {
            tnVar.f6758p = false;
        }
        tnVar.f6760r = (byte) ((short) ((iArr[12] >> 0) & 15));
        tnVar.f6761s = (byte) ((short) ((iArr[12] >> 4) & 15));
        tnVar.f6762t = (byte) ((short) ((iArr[12] >> 8) & 15));
        tnVar.f6763u = (byte) ((short) ((iArr[12] >> 12) & 15));
        tnVar.f6764v = (byte) ((short) ((iArr[13] >> 0) & 15));
        tnVar.f6765w = (byte) ((short) ((iArr[13] >> 4) & 15));
        tnVar.f6766x = (byte) ((short) ((iArr[13] >> 8) & 15));
        tnVar.f6767y = (byte) ((short) ((iArr[13] >> 12) & 15));
        tnVar.f6768z = (byte) ((short) ((iArr[14] >> 0) & 15));
        tnVar.f6742A = (byte) ((short) ((iArr[14] >> 4) & 15));
        tnVar.f6688b = mo5896a((iArr[7] & 255) / 2, iArr);
        tnVar.f6689c = mo5896a((iArr[8] & 255) / 2, iArr);
        tnVar.f6690d = mo5896a((iArr[9] & 255) / 2, iArr);
        return tnVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5889b() {
        int a = mo5895a(9);
        return (((this.f7040b - (((a & 255) / 2) + 1)) - 1) - ((((a & 65280) >> 8) / 2) + 1)) * 2;
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
