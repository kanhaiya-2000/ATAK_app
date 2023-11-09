package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.tv */
class C0899tv extends C0905ua {

    /* renamed from: d */
    private static final short f6971d = 63;

    /* renamed from: e */
    private static final short f6972e = 64;

    /* renamed from: f */
    private static C0879tj f6973f;

    C0899tv(C0879tj tjVar) {
        super(tjVar);
        f6973f = tjVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public short mo5887a(C0880tk tkVar) {
        int[] iArr = new int[64];
        if (tkVar.getClass() != C0880tk.class) {
            return 1;
        }
        for (short s = 0; s < 64; s = (short) (s + 1)) {
            iArr[s] = mo5895a(s);
        }
        try {
            iArr[1] = tkVar.f6691e;
            iArr[2] = tkVar.f6692f;
            iArr[3] = f6973f.f6672g.f6629b;
            iArr[4] = mo5893a((Object) tkVar);
            int a = mo5894a(tkVar.f6689c, iArr, mo5894a(tkVar.f6688b, iArr, 10, 7, true), 8, true);
            if (tkVar.f6693g) {
                mo5894a(tkVar.f6690d, iArr, a, 9, true);
            }
            if (iArr[1] == 0 || iArr[2] == 0) {
                return 2;
            }
            return mo5900a(iArr, 63) ? (short) 0 : 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0880tk mo5886a() {
        C0880tk tkVar = new C0880tk();
        int[] iArr = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr[i] = mo5895a((short) i);
        }
        try {
            tkVar.f6691e = (short) iArr[1];
            tkVar.f6692f = (short) iArr[2];
            mo5898a(tkVar, iArr[4]);
            tkVar.f6688b = mo5896a(10, iArr);
            int length = tkVar.f6688b.length() + 1 + 10;
            tkVar.f6689c = mo5896a(length, iArr);
            tkVar.f6690d = mo5896a(length + tkVar.f6689c.length() + 1, iArr);
            return tkVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5889b() {
        return (((63 - ((((((mo5895a(7) & 65280) >> 8) / 2) + 10) + (((mo5895a(8) & 65280) >> 8) / 2)) + 1)) - 1) - (((65280 & mo5895a(9)) >> 8) / 2)) * 2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5885a(byte[] bArr) {
        if (bArr.length > mo5889b()) {
            return 0;
        }
        int[] iArr = new int[64];
        for (short s = 0; s < 64; s = (short) (s + 1)) {
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
        if (iArr[1] == 0 || iArr[2] == 0 || !mo5900a(iArr, 63)) {
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
