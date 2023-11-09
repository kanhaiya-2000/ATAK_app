package atakplugin.UASTool;

import atakplugin.UASTool.C0915uj;

/* renamed from: atakplugin.UASTool.um */
public class C0935um implements C0946ux {

    /* renamed from: a */
    C0933uk f7325a;

    /* renamed from: b */
    C0879tj f7326b;

    /* renamed from: c */
    int f7327c;

    /* renamed from: b */
    private int m14128b(int i, int i2) {
        double d = i != 1 ? i != 2 ? i != 3 ? 16.666666666666668d : 12.5d : 20.833333333333332d : 41.666666666666664d;
        if (60 <= i2 && i2 <= 100) {
            int i3 = (int) ((((1000000.0d / ((double) i2)) / (d * 8.0d)) - 1.0d) + 0.5d);
            if (i3 > 127) {
                return 127;
            }
            return i3;
        } else if ((100 < i2 && i2 <= 400) || (400 < i2 && i2 <= 1000)) {
            return ((int) ((((1000000.0d / ((double) i2)) / (d * 6.0d)) - 1.0d) + 0.5d)) | 192;
        } else {
            if (1000 >= i2 || i2 > 3400) {
                return 74;
            }
            return (((int) ((((1000000.0d / ((double) i2)) / (d * 6.0d)) - 1.0d) + 0.5d)) | 128) & -65;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5970b(int i) {
        if ((i & 64512) > 0) {
            return C0915uj.C0923h.f7211B;
        }
        return 0;
    }

    public C0935um(C0933uk ukVar) {
        this.f7325a = ukVar;
        this.f7326b = ukVar.f7308b;
    }

    /* renamed from: a */
    public int mo5965a(int i, int i2) {
        return this.f7326b.mo5833a(33, i | (i2 << 8));
    }

    /* renamed from: a */
    public int mo5966a(int i, int i2, byte[] bArr, int i3) {
        return this.f7326b.mo5834a(33, i | (i2 << 8), bArr, i3);
    }

    /* renamed from: b */
    public int mo5971b(int i, int i2, byte[] bArr, int i3) {
        return this.f7326b.mo5854b(32, i | (i2 << 8), bArr, i3);
    }

    /* renamed from: a */
    public int mo5964a(int i) {
        byte[] bArr = new byte[1];
        int a = this.f7325a.mo5936a();
        if (a != 0) {
            return a;
        }
        if (!mo5973b()) {
            return C0915uj.C0923h.f7216G;
        }
        mo5965a(81, 0);
        int a2 = this.f7325a.mo5938a(bArr);
        if (a2 != 0) {
            return a2;
        }
        int b = m14128b(bArr[0], i);
        int a3 = mo5965a(5, 1);
        if (a3 < 0) {
            return a3;
        }
        this.f7325a.f7309c.f7348g = 1;
        int a4 = mo5965a(82, b);
        if (a4 < 0) {
            return a4;
        }
        this.f7327c = i;
        return 0;
    }

    /* renamed from: a */
    public int mo5963a() {
        int a = mo5968a(true);
        if (a != 0) {
            return a;
        }
        return mo5965a(81, 1);
    }

    /* renamed from: a */
    public int mo5967a(int i, byte[] bArr, int i2, int[] iArr) {
        short s = (short) (65535 & i);
        short s2 = (short) ((i & 896) >> 7);
        short s3 = (short) i2;
        int[] iArr2 = new int[1];
        byte[] bArr2 = new byte[4];
        long currentTimeMillis = System.currentTimeMillis();
        int e = this.f7326b.mo5863e();
        int b = mo5970b(i);
        if (b != 0) {
            return b;
        }
        if (i2 < 1) {
            return 6;
        }
        int a = mo5968a(true);
        if (a != 0) {
            return a;
        }
        int a2 = mo5969a(iArr2);
        if (a2 != 0) {
            return a2;
        }
        if (i2 > iArr2[0]) {
            return C0915uj.C0923h.f7214E;
        }
        iArr[0] = 0;
        bArr2[0] = (byte) ((short) ((s << 1) + 1));
        bArr2[1] = (byte) s2;
        bArr2[2] = (byte) ((s3 >> 8) & 255);
        bArr2[3] = (byte) (s3 & 255);
        if (4 != this.f7326b.mo5856b(bArr2, 4)) {
            return C0915uj.C0923h.f7215F;
        }
        int l = this.f7326b.mo5870l();
        while (l < i2 && System.currentTimeMillis() - currentTimeMillis < ((long) e)) {
            l = this.f7326b.mo5870l();
        }
        if (l <= i2) {
            i2 = l;
        }
        int a3 = this.f7326b.mo5837a(bArr, i2);
        iArr[0] = a3;
        if (a3 >= 0) {
            return 0;
        }
        return C0915uj.C0923h.f7215F;
    }

    /* renamed from: b */
    public int mo5972b(int i, byte[] bArr, int i2, int[] iArr) {
        short s = (short) i;
        short s2 = (short) ((i & 896) >> 7);
        short s3 = (short) i2;
        int i3 = i2 + 4;
        byte[] bArr2 = new byte[i3];
        int[] iArr2 = new int[1];
        int b = mo5970b(i);
        if (b != 0) {
            return b;
        }
        if (i2 < 1) {
            return 6;
        }
        int a = mo5968a(true);
        if (a != 0) {
            return a;
        }
        int a2 = mo5969a(iArr2);
        if (a2 != 0) {
            return a2;
        }
        if (i2 > iArr2[0]) {
            return C0915uj.C0923h.f7214E;
        }
        iArr[0] = 0;
        bArr2[0] = (byte) ((short) (s << 1));
        bArr2[1] = (byte) s2;
        bArr2[2] = (byte) ((s3 >> 8) & 255);
        bArr2[3] = (byte) (s3 & 255);
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4 + 4] = bArr[i4];
        }
        iArr[0] = this.f7326b.mo5856b(bArr2, i3) - 4;
        if (i2 == iArr[0]) {
            return 0;
        }
        return 10;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5973b() {
        return this.f7325a.f7309c.f7342a == 0 || this.f7325a.f7309c.f7342a == 3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5968a(boolean z) {
        if (z) {
            if (this.f7325a.f7309c.f7348g != 1) {
                return C0915uj.C0923h.f7250y;
            }
            return 0;
        } else if (this.f7325a.f7309c.f7348g != 2) {
            return C0915uj.C0923h.f7250y;
        } else {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5969a(int[] iArr) {
        iArr[0] = 0;
        int c = this.f7325a.mo5940c();
        if (this.f7325a.f7309c.f7348g != 1) {
            return 17;
        }
        iArr[0] = c - 4;
        return 0;
    }
}
