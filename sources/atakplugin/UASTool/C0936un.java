package atakplugin.UASTool;

import atakplugin.UASTool.C0915uj;

/* renamed from: atakplugin.UASTool.un */
public class C0936un implements C0947uy {

    /* renamed from: a */
    C0933uk f7328a;

    /* renamed from: b */
    C0879tj f7329b;

    public C0936un(C0933uk ukVar) {
        this.f7328a = ukVar;
        this.f7329b = ukVar.f7308b;
    }

    /* renamed from: a */
    public int mo5976a(int i, int i2) {
        return this.f7329b.mo5833a(33, i | (i2 << 8));
    }

    /* renamed from: a */
    public int mo5977a(int i, int i2, byte[] bArr, int i3) {
        return this.f7329b.mo5834a(33, i | (i2 << 8), bArr, i3);
    }

    /* renamed from: b */
    public int mo5982b(int i, int i2, byte[] bArr, int i3) {
        return this.f7329b.mo5854b(32, i | (i2 << 8), bArr, i3);
    }

    /* renamed from: a */
    public int mo5974a() {
        int a = this.f7328a.mo5936a();
        if (a != 0) {
            return a;
        }
        if (!mo5985c()) {
            return C0915uj.C0923h.f7216G;
        }
        int a2 = mo5976a(5, 2);
        if (a2 < 0) {
            return a2;
        }
        this.f7328a.f7309c.f7348g = 2;
        return 0;
    }

    /* renamed from: b */
    public int mo5981b() {
        int a = mo5978a(false);
        if (a != 0) {
            return a;
        }
        return mo5976a(91, 1);
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [int[]] */
    /* JADX WARNING: type inference failed for: r1v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v2, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo5980a(int[] r7) {
        /*
            r6 = this;
            r0 = 1
            byte[] r1 = new byte[r0]
            r2 = 0
            int r3 = r6.mo5978a((boolean) r2)
            if (r3 == 0) goto L_0x000b
            return r3
        L_0x000b:
            atakplugin.UASTool.tj r3 = r6.f7329b
            r4 = 33
            r5 = 92
            int r0 = r3.mo5854b(r4, r5, r1, r0)
            if (r0 >= 0) goto L_0x001a
            r7 = 18
            return r7
        L_0x001a:
            byte r0 = r1[r2]
            r7[r2] = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0936un.mo5980a(int[]):int");
    }

    /* renamed from: a */
    public int mo5975a(int i) {
        byte[] bArr = {(byte) (i & 255)};
        int a = mo5978a(false);
        if (a != 0) {
            return a;
        }
        if (mo5976a(92, bArr[0]) < 0) {
            return 18;
        }
        return 0;
    }

    /* renamed from: a */
    public int mo5979a(byte[] bArr, int i, int[] iArr) {
        int[] iArr2 = new int[1];
        long currentTimeMillis = System.currentTimeMillis();
        int e = this.f7329b.mo5863e();
        if (i < 1) {
            return 6;
        }
        int a = mo5978a(false);
        if (a != 0) {
            return a;
        }
        int b = mo5984b(iArr2);
        if (b != 0) {
            return b;
        }
        if (i > iArr2[0]) {
            return C0915uj.C0923h.f7214E;
        }
        iArr[0] = 0;
        int l = this.f7329b.mo5870l();
        while (l < i && System.currentTimeMillis() - currentTimeMillis < ((long) e)) {
            l = this.f7329b.mo5870l();
        }
        if (l <= i) {
            i = l;
        }
        int a2 = this.f7329b.mo5837a(bArr, i);
        if (a2 < 0) {
            return C0915uj.C0923h.f7215F;
        }
        iArr[0] = a2;
        return 0;
    }

    /* renamed from: b */
    public int mo5983b(byte[] bArr, int i, int[] iArr) {
        int[] iArr2 = new int[1];
        if (i < 1) {
            return 6;
        }
        int a = mo5978a(false);
        if (a != 0) {
            return a;
        }
        int b = mo5984b(iArr2);
        if (b != 0) {
            return b;
        }
        if (i > iArr2[0]) {
            return C0915uj.C0923h.f7214E;
        }
        iArr[0] = 0;
        int b2 = this.f7329b.mo5856b(bArr, i);
        iArr[0] = b2;
        if (i == b2) {
            return 0;
        }
        return 10;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5985c() {
        return this.f7328a.f7309c.f7342a == 0 || this.f7328a.f7309c.f7342a == 3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5978a(boolean z) {
        if (z) {
            if (this.f7328a.f7309c.f7348g != 1) {
                return C0915uj.C0923h.f7250y;
            }
            return 0;
        } else if (this.f7328a.f7309c.f7348g != 2) {
            return C0915uj.C0923h.f7250y;
        } else {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5984b(int[] iArr) {
        iArr[0] = 0;
        int c = this.f7328a.mo5940c();
        if (this.f7328a.f7309c.f7348g != 2) {
            return 17;
        }
        iArr[0] = c - 4;
        return 0;
    }
}
