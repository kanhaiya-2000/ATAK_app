package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.tt */
class C0897tt extends C0905ua {

    /* renamed from: d */
    private static final byte f6966d = 10;

    /* renamed from: e */
    private static final short f6967e = 63;

    /* renamed from: f */
    private static final String f6968f = "6010";

    C0897tt(C0879tj tjVar) {
        super(tjVar);
        mo5892a((byte) 10);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        boolean z;
        int i;
        int[] iArr = new int[this.f7040b];
        if (tkVar.getClass() != C0881tl.class) {
            return 1;
        }
        C0881tl tlVar = (C0881tl) tkVar;
        try {
            iArr[0] = 0;
            if (tlVar.f6702p) {
                iArr[0] = iArr[0] | 1;
            } else if (tlVar.f6704r) {
                iArr[0] = iArr[0] | 2;
            } else {
                iArr[0] = iArr[0] | 4;
            }
            if (tlVar.f6700n) {
                iArr[0] = iArr[0] | 16;
            }
            if (tlVar.f6708v) {
                iArr[0] = iArr[0] | 8;
            } else if (tlVar.f6703q) {
                iArr[0] = iArr[0] | 256;
            } else if (tlVar.f6705s) {
                iArr[0] = iArr[0] | 512;
            } else {
                iArr[0] = iArr[0] | 1024;
            }
            if (tlVar.f6701o) {
                iArr[0] = iArr[0] | 4096;
            }
            if (tlVar.f6709w) {
                iArr[0] = iArr[0] | 2048;
            }
            iArr[1] = tlVar.f6691e;
            iArr[2] = tlVar.f6692f;
            iArr[3] = 1280;
            iArr[4] = mo5893a((Object) tkVar);
            iArr[4] = mo5901b(tkVar);
            if (this.f7039a == 70) {
                z = true;
                i = 11;
            } else {
                z = false;
                i = 75;
            }
            int a = mo5894a(tlVar.f6688b, iArr, i, 7, z);
            int a2 = mo5894a(tlVar.f6689c, iArr, a, 8, z);
            if (tlVar.f6693g) {
                mo5894a(tlVar.f6690d, iArr, a2, 9, z);
            }
            iArr[10] = this.f7039a;
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
        C0881tl tlVar = new C0881tl();
        int[] iArr = new int[this.f7040b];
        int i = 0;
        while (i < this.f7040b) {
            try {
                iArr[i] = mo5895a((short) i);
                i++;
            } catch (Exception unused) {
                return null;
            }
        }
        short s = (short) (iArr[0] & 7);
        if (s == 0) {
            tlVar.f6698l = true;
        } else if (s == 1) {
            tlVar.f6702p = true;
        } else if (s == 2) {
            tlVar.f6704r = true;
        } else if (s == 4) {
            tlVar.f6706t = true;
        }
        if (((short) ((iArr[0] & 8) >> 3)) == 1) {
            tlVar.f6708v = true;
        } else {
            tlVar.f6700n = true;
        }
        if (((short) ((iArr[0] & 16) >> 4)) == 1) {
            tlVar.f6700n = true;
        }
        short s2 = (short) ((iArr[0] & 1792) >> 8);
        if (s2 == 0) {
            tlVar.f6699m = true;
        } else if (s2 == 1) {
            tlVar.f6703q = true;
        } else if (s2 == 2) {
            tlVar.f6705s = true;
        } else if (s2 == 4) {
            tlVar.f6707u = true;
        }
        if (((short) ((iArr[0] & 2048) >> 11)) == 1) {
            tlVar.f6709w = true;
        } else {
            tlVar.f6711y = true;
        }
        if (((short) ((iArr[0] & 4096) >> 12)) == 1) {
            tlVar.f6701o = true;
        }
        tlVar.f6691e = (short) iArr[1];
        tlVar.f6692f = (short) iArr[2];
        mo5898a((C0880tk) tlVar, iArr[4]);
        int i2 = iArr[7] & 255;
        if (this.f7039a == 70) {
            tlVar.f6688b = mo5896a((i2 - 128) / 2, iArr);
            tlVar.f6689c = mo5896a(((iArr[8] & 255) - 128) / 2, iArr);
            tlVar.f6690d = mo5896a(((iArr[9] & 255) - 128) / 2, iArr);
        } else {
            tlVar.f6688b = mo5896a(i2 / 2, iArr);
            tlVar.f6689c = mo5896a((iArr[8] & 255) / 2, iArr);
            tlVar.f6690d = mo5896a((iArr[9] & 255) / 2, iArr);
        }
        return tlVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5889b() {
        int a = mo5895a(9);
        return (((this.f7040b - 1) - 1) - ((a & 255) + (((a & 65280) >> 8) / 2))) * 2;
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
