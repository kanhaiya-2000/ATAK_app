package atakplugin.UASTool;

import java.math.BigInteger;

public class ahn extends ahm {

    /* renamed from: u */
    private static final byte[] f1316u = aji.m1820c("-----BEGIN DSA PRIVATE KEY-----");

    /* renamed from: v */
    private static final byte[] f1317v = aji.m1820c("-----END DSA PRIVATE KEY-----");

    /* renamed from: w */
    private static final byte[] f1318w = aji.m1820c("ssh-dss");

    /* renamed from: o */
    private byte[] f1319o;

    /* renamed from: p */
    private byte[] f1320p;

    /* renamed from: q */
    private byte[] f1321q;

    /* renamed from: r */
    private byte[] f1322r;

    /* renamed from: s */
    private byte[] f1323s;

    /* renamed from: t */
    private int f1324t;

    /* renamed from: i */
    public int mo949i() {
        return 1;
    }

    public ahn(ahg ahg) {
        this(ahg, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
    }

    public ahn(ahg ahg, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        super(ahg);
        this.f1324t = 1024;
        this.f1319o = bArr;
        this.f1320p = bArr2;
        this.f1321q = bArr3;
        this.f1322r = bArr4;
        this.f1323s = bArr5;
        if (bArr != null) {
            this.f1324t = new BigInteger(bArr).bitLength();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo920a(int i) {
        this.f1324t = i;
        try {
            ahg ahg = this.f1302k;
            aho aho = (aho) Class.forName(ahg.m1350e("keypairgen.dsa")).newInstance();
            aho.mo961a(i);
            this.f1319o = aho.mo964c();
            this.f1320p = aho.mo965d();
            this.f1321q = aho.mo966e();
            this.f1322r = aho.mo963b();
            this.f1323s = aho.mo962a();
        } catch (Exception e) {
            if (e instanceof Throwable) {
                throw new ahj(e.toString(), e);
            }
            throw new ahj(e.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo928a() {
        return f1316u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo937b() {
        return f1317v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public byte[] mo947g() {
        int b = mo931b(1) + 1 + 1 + 1 + mo931b(this.f1319o.length) + this.f1319o.length + 1 + mo931b(this.f1320p.length) + this.f1320p.length + 1 + mo931b(this.f1321q.length) + this.f1321q.length + 1 + mo931b(this.f1322r.length) + this.f1322r.length + 1 + mo931b(this.f1323s.length) + this.f1323s.length;
        byte[] bArr = new byte[(mo931b(b) + 1 + b)];
        mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo918a(bArr, 0, b), new byte[1]), this.f1319o), this.f1320p), this.f1321q), this.f1322r), this.f1323s);
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: byte} */
    /* JADX WARNING: type inference failed for: r5v6, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo936b(byte[] r8) {
        /*
            r7 = this;
            r0 = 0
            int r1 = r7.f1300i     // Catch:{ Exception -> 0x0183 }
            r2 = 48
            r3 = 1
            if (r1 != r3) goto L_0x0045
            byte r1 = r8[r0]     // Catch:{ Exception -> 0x0183 }
            if (r1 == r2) goto L_0x0044
            atakplugin.UASTool.afx r1 = new atakplugin.UASTool.afx     // Catch:{ Exception -> 0x0183 }
            r1.<init>((byte[]) r8)     // Catch:{ Exception -> 0x0183 }
            r1.mo633d()     // Catch:{ Exception -> 0x0183 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0183 }
            r7.f1319o = r8     // Catch:{ Exception -> 0x0183 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0183 }
            r7.f1321q = r8     // Catch:{ Exception -> 0x0183 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0183 }
            r7.f1320p = r8     // Catch:{ Exception -> 0x0183 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0183 }
            r7.f1322r = r8     // Catch:{ Exception -> 0x0183 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0183 }
            r7.f1323s = r8     // Catch:{ Exception -> 0x0183 }
            byte[] r8 = r7.f1319o     // Catch:{ Exception -> 0x0183 }
            if (r8 == 0) goto L_0x0043
            java.math.BigInteger r8 = new java.math.BigInteger     // Catch:{ Exception -> 0x0183 }
            byte[] r1 = r7.f1319o     // Catch:{ Exception -> 0x0183 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0183 }
            int r8 = r8.bitLength()     // Catch:{ Exception -> 0x0183 }
            r7.f1324t = r8     // Catch:{ Exception -> 0x0183 }
        L_0x0043:
            return r3
        L_0x0044:
            return r0
        L_0x0045:
            int r1 = r7.f1300i     // Catch:{ Exception -> 0x0183 }
            r4 = 2
            if (r1 != r4) goto L_0x005f
            atakplugin.UASTool.afx r1 = new atakplugin.UASTool.afx     // Catch:{ Exception -> 0x0183 }
            r1.<init>((byte[]) r8)     // Catch:{ Exception -> 0x0183 }
            int r8 = r8.length     // Catch:{ Exception -> 0x0183 }
            r1.mo626b((int) r8)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r8 = ""
            byte[][] r8 = r1.mo624a((int) r3, (java.lang.String) r8)     // Catch:{ ahj -> 0x005e }
            r8 = r8[r0]     // Catch:{ ahj -> 0x005e }
            r7.f1323s = r8     // Catch:{ ahj -> 0x005e }
            return r3
        L_0x005e:
            return r0
        L_0x005f:
            byte r1 = r8[r0]     // Catch:{ Exception -> 0x0183 }
            if (r1 == r2) goto L_0x0064
            return r0
        L_0x0064:
            byte r1 = r8[r3]     // Catch:{ Exception -> 0x0183 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = r1 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x007a
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r2 = 2
        L_0x006f:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x007b
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0183 }
            r2 = r1
            r1 = r5
            goto L_0x006f
        L_0x007a:
            r2 = 2
        L_0x007b:
            byte r1 = r8[r2]     // Catch:{ Exception -> 0x0183 }
            if (r1 == r4) goto L_0x0080
            return r0
        L_0x0080:
            int r2 = r2 + r3
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0183 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00a1
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x008e:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x00a0
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0183 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x008e
        L_0x00a0:
            r2 = r4
        L_0x00a1:
            int r1 = r1 + r2
            int r1 = r1 + r3
            int r2 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0183 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00c4
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = r2
            r2 = 0
        L_0x00b1:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x00c2
            int r1 = r2 << 8
            int r2 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0183 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r4
            r4 = r2
            r2 = r1
            r1 = r5
            goto L_0x00b1
        L_0x00c2:
            r1 = r2
            r2 = r4
        L_0x00c4:
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x0183 }
            r7.f1319o = r4     // Catch:{ Exception -> 0x0183 }
            java.lang.System.arraycopy(r8, r2, r4, r0, r1)     // Catch:{ Exception -> 0x0183 }
            int r2 = r2 + r1
            int r2 = r2 + r3
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0183 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00ed
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x00da:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x00ec
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0183 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x00da
        L_0x00ec:
            r2 = r4
        L_0x00ed:
            byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x0183 }
            r7.f1320p = r4     // Catch:{ Exception -> 0x0183 }
            java.lang.System.arraycopy(r8, r1, r4, r0, r2)     // Catch:{ Exception -> 0x0183 }
            int r1 = r1 + r2
            int r1 = r1 + r3
            int r2 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0183 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0117
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = r2
            r2 = 0
        L_0x0104:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x0115
            int r1 = r2 << 8
            int r2 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0183 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r4
            r4 = r2
            r2 = r1
            r1 = r5
            goto L_0x0104
        L_0x0115:
            r1 = r2
            r2 = r4
        L_0x0117:
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x0183 }
            r7.f1321q = r4     // Catch:{ Exception -> 0x0183 }
            java.lang.System.arraycopy(r8, r2, r4, r0, r1)     // Catch:{ Exception -> 0x0183 }
            int r2 = r2 + r1
            int r2 = r2 + r3
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0183 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0140
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x012d:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x013f
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0183 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x012d
        L_0x013f:
            r2 = r4
        L_0x0140:
            byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x0183 }
            r7.f1322r = r4     // Catch:{ Exception -> 0x0183 }
            java.lang.System.arraycopy(r8, r1, r4, r0, r2)     // Catch:{ Exception -> 0x0183 }
            int r1 = r1 + r2
            int r1 = r1 + r3
            int r2 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0183 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x016a
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = r2
            r2 = 0
        L_0x0157:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x0168
            int r1 = r2 << 8
            int r2 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0183 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r4
            r4 = r2
            r2 = r1
            r1 = r5
            goto L_0x0157
        L_0x0168:
            r1 = r2
            r2 = r4
        L_0x016a:
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x0183 }
            r7.f1323s = r4     // Catch:{ Exception -> 0x0183 }
            java.lang.System.arraycopy(r8, r2, r4, r0, r1)     // Catch:{ Exception -> 0x0183 }
            byte[] r8 = r7.f1319o     // Catch:{ Exception -> 0x0183 }
            if (r8 == 0) goto L_0x0182
            java.math.BigInteger r8 = new java.math.BigInteger     // Catch:{ Exception -> 0x0183 }
            byte[] r1 = r7.f1319o     // Catch:{ Exception -> 0x0183 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0183 }
            int r8 = r8.bitLength()     // Catch:{ Exception -> 0x0183 }
            r7.f1324t = r8     // Catch:{ Exception -> 0x0183 }
        L_0x0182:
            return r3
        L_0x0183:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahn.mo936b(byte[]):boolean");
    }

    /* renamed from: j */
    public byte[] mo950j() {
        byte[] j = super.mo950j();
        if (j != null) {
            return j;
        }
        byte[] bArr = this.f1319o;
        if (bArr == null) {
            return null;
        }
        return afx.m897a(new byte[][]{f1318w, bArr, this.f1320p, this.f1321q, this.f1322r}).f888b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public byte[] mo948h() {
        return f1318w;
    }

    /* renamed from: c */
    public int mo938c() {
        return this.f1324t;
    }

    /* renamed from: a */
    public byte[] mo929a(byte[] bArr) {
        try {
            ahg ahg = this.f1302k;
            aix aix = (aix) Class.forName(ahg.m1350e("signature.dss")).newInstance();
            aix.mo1154a();
            aix.mo1159b(this.f1323s, this.f1319o, this.f1320p, this.f1321q);
            aix.mo1155a(bArr);
            return afx.m897a(new byte[][]{f1318w, aix.mo1157b()}).f888b;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public aiw mo941d() {
        try {
            ahg ahg = this.f1302k;
            aix aix = (aix) Class.forName(ahg.m1350e("signature.dss")).newInstance();
            aix.mo1154a();
            if (this.f1322r == null && this.f1319o == null && mo950j() != null) {
                afx afx = new afx(mo950j());
                afx.mo643j();
                this.f1319o = afx.mo643j();
                this.f1320p = afx.mo643j();
                this.f1321q = afx.mo643j();
                this.f1322r = afx.mo643j();
            }
            aix.mo1158a(this.f1322r, this.f1319o, this.f1320p, this.f1321q);
            return aix;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    static ahm m1448a(ahg ahg, afx afx) {
        byte[][] a = afx.mo624a(7, "invalid key format");
        ahn ahn = new ahn(ahg, a[1], a[2], a[3], a[4], a[5]);
        ahn.f1301j = new String(a[6]);
        ahn.f1300i = 0;
        return ahn;
    }

    /* renamed from: e */
    public byte[] mo944e() {
        if (!mo952l()) {
            afx afx = new afx();
            afx.mo627b(f1318w);
            afx.mo627b(this.f1319o);
            afx.mo627b(this.f1320p);
            afx.mo627b(this.f1321q);
            afx.mo627b(this.f1322r);
            afx.mo627b(this.f1323s);
            afx.mo627b(aji.m1820c(this.f1301j));
            int a = afx.mo617a();
            byte[] bArr = new byte[a];
            afx.mo632c(bArr, 0, a);
            return bArr;
        }
        throw new ahj("key is encrypted.");
    }

    /* renamed from: m */
    public void mo953m() {
        super.mo953m();
        aji.m1822d(this.f1323s);
    }
}
