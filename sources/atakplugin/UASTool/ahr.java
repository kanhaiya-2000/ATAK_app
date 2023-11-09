package atakplugin.UASTool;

import java.math.BigInteger;

public class ahr extends ahm {

    /* renamed from: x */
    private static final byte[] f1336x = aji.m1820c("-----BEGIN RSA PRIVATE KEY-----");

    /* renamed from: y */
    private static final byte[] f1337y = aji.m1820c("-----END RSA PRIVATE KEY-----");

    /* renamed from: z */
    private static final byte[] f1338z = aji.m1820c("ssh-rsa");

    /* renamed from: o */
    private byte[] f1339o;

    /* renamed from: p */
    private byte[] f1340p;

    /* renamed from: q */
    private byte[] f1341q;

    /* renamed from: r */
    private byte[] f1342r;

    /* renamed from: s */
    private byte[] f1343s;

    /* renamed from: t */
    private byte[] f1344t;

    /* renamed from: u */
    private byte[] f1345u;

    /* renamed from: v */
    private byte[] f1346v;

    /* renamed from: w */
    private int f1347w;

    /* renamed from: i */
    public int mo949i() {
        return 2;
    }

    public ahr(ahg ahg) {
        this(ahg, (byte[]) null, (byte[]) null, (byte[]) null);
    }

    public ahr(ahg ahg, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(ahg);
        this.f1347w = 1024;
        this.f1339o = bArr;
        this.f1340p = bArr2;
        this.f1341q = bArr3;
        if (bArr != null) {
            this.f1347w = new BigInteger(bArr).bitLength();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo920a(int i) {
        this.f1347w = i;
        try {
            ahg ahg = this.f1302k;
            ahp ahp = (ahp) Class.forName(ahg.m1350e("keypairgen.rsa")).newInstance();
            ahp.mo967a(i);
            this.f1340p = ahp.mo969b();
            this.f1341q = ahp.mo968a();
            this.f1339o = ahp.mo970c();
            this.f1342r = ahp.mo974g();
            this.f1343s = ahp.mo975h();
            this.f1344t = ahp.mo972e();
            this.f1345u = ahp.mo973f();
            this.f1346v = ahp.mo971d();
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
        return f1336x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo937b() {
        return f1337y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public byte[] mo947g() {
        int b = mo931b(1) + 1 + 1 + 1 + mo931b(this.f1339o.length) + this.f1339o.length + 1 + mo931b(this.f1340p.length) + this.f1340p.length + 1 + mo931b(this.f1341q.length) + this.f1341q.length + 1 + mo931b(this.f1342r.length) + this.f1342r.length + 1 + mo931b(this.f1343s.length) + this.f1343s.length + 1 + mo931b(this.f1344t.length) + this.f1344t.length + 1 + mo931b(this.f1345u.length) + this.f1345u.length + 1 + mo931b(this.f1346v.length) + this.f1346v.length;
        byte[] bArr = new byte[(mo931b(b) + 1 + b)];
        mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo919a(bArr, mo918a(bArr, 0, b), new byte[1]), this.f1339o), this.f1340p), this.f1341q), this.f1342r), this.f1343s), this.f1344t), this.f1345u), this.f1346v);
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v72, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: byte} */
    /* JADX WARNING: type inference failed for: r5v9, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo936b(byte[] r8) {
        /*
            r7 = this;
            r0 = 0
            int r1 = r7.f1300i     // Catch:{ Exception -> 0x0217 }
            r2 = 2
            r3 = 1
            if (r1 != r2) goto L_0x0030
            atakplugin.UASTool.afx r1 = new atakplugin.UASTool.afx     // Catch:{ Exception -> 0x0217 }
            r1.<init>((byte[]) r8)     // Catch:{ Exception -> 0x0217 }
            int r8 = r8.length     // Catch:{ Exception -> 0x0217 }
            r1.mo626b((int) r8)     // Catch:{ Exception -> 0x0217 }
            r8 = 4
            java.lang.String r4 = ""
            byte[][] r8 = r1.mo624a((int) r8, (java.lang.String) r4)     // Catch:{ ahj -> 0x002f }
            r1 = r8[r0]     // Catch:{ ahj -> 0x002f }
            r7.f1341q = r1     // Catch:{ ahj -> 0x002f }
            r1 = r8[r3]     // Catch:{ ahj -> 0x002f }
            r7.f1342r = r1     // Catch:{ ahj -> 0x002f }
            r1 = r8[r2]     // Catch:{ ahj -> 0x002f }
            r7.f1343s = r1     // Catch:{ ahj -> 0x002f }
            r1 = 3
            r8 = r8[r1]     // Catch:{ ahj -> 0x002f }
            r7.f1346v = r8     // Catch:{ ahj -> 0x002f }
            r7.m1492n()     // Catch:{ Exception -> 0x0217 }
            r7.m1493o()     // Catch:{ Exception -> 0x0217 }
            return r3
        L_0x002f:
            return r0
        L_0x0030:
            int r1 = r7.f1300i     // Catch:{ Exception -> 0x0217 }
            if (r1 != r3) goto L_0x007c
            byte r1 = r8[r0]     // Catch:{ Exception -> 0x0217 }
            r2 = 48
            if (r1 == r2) goto L_0x007b
            atakplugin.UASTool.afx r1 = new atakplugin.UASTool.afx     // Catch:{ Exception -> 0x0217 }
            r1.<init>((byte[]) r8)     // Catch:{ Exception -> 0x0217 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0217 }
            r7.f1340p = r8     // Catch:{ Exception -> 0x0217 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0217 }
            r7.f1341q = r8     // Catch:{ Exception -> 0x0217 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0217 }
            r7.f1339o = r8     // Catch:{ Exception -> 0x0217 }
            r1.mo642i()     // Catch:{ Exception -> 0x0217 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0217 }
            r7.f1342r = r8     // Catch:{ Exception -> 0x0217 }
            byte[] r8 = r1.mo642i()     // Catch:{ Exception -> 0x0217 }
            r7.f1343s = r8     // Catch:{ Exception -> 0x0217 }
            byte[] r8 = r7.f1339o     // Catch:{ Exception -> 0x0217 }
            if (r8 == 0) goto L_0x0071
            java.math.BigInteger r8 = new java.math.BigInteger     // Catch:{ Exception -> 0x0217 }
            byte[] r1 = r7.f1339o     // Catch:{ Exception -> 0x0217 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0217 }
            int r8 = r8.bitLength()     // Catch:{ Exception -> 0x0217 }
            r7.f1347w = r8     // Catch:{ Exception -> 0x0217 }
        L_0x0071:
            r7.m1492n()     // Catch:{ Exception -> 0x0217 }
            r7.m1493o()     // Catch:{ Exception -> 0x0217 }
            r7.m1494p()     // Catch:{ Exception -> 0x0217 }
            return r3
        L_0x007b:
            return r0
        L_0x007c:
            byte r1 = r8[r3]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0092
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = 2
        L_0x0087:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x0093
            int r1 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0217 }
            r4 = r1
            r1 = r5
            goto L_0x0087
        L_0x0092:
            r4 = 2
        L_0x0093:
            byte r1 = r8[r4]     // Catch:{ Exception -> 0x0217 }
            if (r1 == r2) goto L_0x0098
            return r0
        L_0x0098:
            int r4 = r4 + r3
            int r1 = r4 + 1
            byte r2 = r8[r4]     // Catch:{ Exception -> 0x0217 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00b9
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x00a6:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x00b8
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x00a6
        L_0x00b8:
            r2 = r4
        L_0x00b9:
            int r1 = r1 + r2
            int r1 = r1 + r3
            int r2 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00dc
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = r2
            r2 = 0
        L_0x00c9:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x00da
            int r1 = r2 << 8
            int r2 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0217 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r4
            r4 = r2
            r2 = r1
            r1 = r5
            goto L_0x00c9
        L_0x00da:
            r1 = r2
            r2 = r4
        L_0x00dc:
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x0217 }
            r7.f1339o = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r2, r4, r0, r1)     // Catch:{ Exception -> 0x0217 }
            int r2 = r2 + r1
            int r2 = r2 + r3
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0217 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0105
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x00f2:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x0104
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x00f2
        L_0x0104:
            r2 = r4
        L_0x0105:
            byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x0217 }
            r7.f1340p = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r1, r4, r0, r2)     // Catch:{ Exception -> 0x0217 }
            int r1 = r1 + r2
            int r1 = r1 + r3
            int r2 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x012f
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = r2
            r2 = 0
        L_0x011c:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x012d
            int r1 = r2 << 8
            int r2 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0217 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r4
            r4 = r2
            r2 = r1
            r1 = r5
            goto L_0x011c
        L_0x012d:
            r1 = r2
            r2 = r4
        L_0x012f:
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x0217 }
            r7.f1341q = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r2, r4, r0, r1)     // Catch:{ Exception -> 0x0217 }
            int r2 = r2 + r1
            int r2 = r2 + r3
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0217 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0158
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x0145:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x0157
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x0145
        L_0x0157:
            r2 = r4
        L_0x0158:
            byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x0217 }
            r7.f1342r = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r1, r4, r0, r2)     // Catch:{ Exception -> 0x0217 }
            int r1 = r1 + r2
            int r1 = r1 + r3
            int r2 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0182
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = r2
            r2 = 0
        L_0x016f:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x0180
            int r1 = r2 << 8
            int r2 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0217 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r4
            r4 = r2
            r2 = r1
            r1 = r5
            goto L_0x016f
        L_0x0180:
            r1 = r2
            r2 = r4
        L_0x0182:
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x0217 }
            r7.f1343s = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r2, r4, r0, r1)     // Catch:{ Exception -> 0x0217 }
            int r2 = r2 + r1
            int r2 = r2 + r3
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0217 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01ab
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x0198:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x01aa
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x0198
        L_0x01aa:
            r2 = r4
        L_0x01ab:
            byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x0217 }
            r7.f1344t = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r1, r4, r0, r2)     // Catch:{ Exception -> 0x0217 }
            int r1 = r1 + r2
            int r1 = r1 + r3
            int r2 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01d5
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r4 = r2
            r2 = 0
        L_0x01c2:
            int r5 = r1 + -1
            if (r1 <= 0) goto L_0x01d3
            int r1 = r2 << 8
            int r2 = r4 + 1
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x0217 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r4
            r4 = r2
            r2 = r1
            r1 = r5
            goto L_0x01c2
        L_0x01d3:
            r1 = r2
            r2 = r4
        L_0x01d5:
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x0217 }
            r7.f1345u = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r2, r4, r0, r1)     // Catch:{ Exception -> 0x0217 }
            int r2 = r2 + r1
            int r2 = r2 + r3
            int r1 = r2 + 1
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x0217 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = r2 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01fe
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r4 = 0
        L_0x01eb:
            int r5 = r2 + -1
            if (r2 <= 0) goto L_0x01fd
            int r2 = r4 << 8
            int r4 = r1 + 1
            byte r1 = r8[r1]     // Catch:{ Exception -> 0x0217 }
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 + r2
            r2 = r5
            r6 = r4
            r4 = r1
            r1 = r6
            goto L_0x01eb
        L_0x01fd:
            r2 = r4
        L_0x01fe:
            byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x0217 }
            r7.f1346v = r4     // Catch:{ Exception -> 0x0217 }
            java.lang.System.arraycopy(r8, r1, r4, r0, r2)     // Catch:{ Exception -> 0x0217 }
            byte[] r8 = r7.f1339o     // Catch:{ Exception -> 0x0217 }
            if (r8 == 0) goto L_0x0216
            java.math.BigInteger r8 = new java.math.BigInteger     // Catch:{ Exception -> 0x0217 }
            byte[] r1 = r7.f1339o     // Catch:{ Exception -> 0x0217 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0217 }
            int r8 = r8.bitLength()     // Catch:{ Exception -> 0x0217 }
            r7.f1347w = r8     // Catch:{ Exception -> 0x0217 }
        L_0x0216:
            return r3
        L_0x0217:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahr.mo936b(byte[]):boolean");
    }

    /* renamed from: j */
    public byte[] mo950j() {
        byte[] j = super.mo950j();
        if (j != null) {
            return j;
        }
        byte[] bArr = this.f1340p;
        if (bArr == null) {
            return null;
        }
        return afx.m897a(new byte[][]{f1338z, bArr, this.f1339o}).f888b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public byte[] mo948h() {
        return f1338z;
    }

    /* renamed from: c */
    public int mo938c() {
        return this.f1347w;
    }

    /* renamed from: a */
    public byte[] mo929a(byte[] bArr) {
        try {
            ahg ahg = this.f1302k;
            aiy aiy = (aiy) Class.forName(ahg.m1350e("signature.rsa")).newInstance();
            aiy.mo1154a();
            aiy.mo1161b(this.f1341q, this.f1339o);
            aiy.mo1155a(bArr);
            return afx.m897a(new byte[][]{f1338z, aiy.mo1157b()}).f888b;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public aiw mo941d() {
        try {
            ahg ahg = this.f1302k;
            aiy aiy = (aiy) Class.forName(ahg.m1350e("signature.rsa")).newInstance();
            aiy.mo1154a();
            if (this.f1340p == null && this.f1339o == null && mo950j() != null) {
                afx afx = new afx(mo950j());
                afx.mo643j();
                this.f1340p = afx.mo643j();
                this.f1339o = afx.mo643j();
            }
            aiy.mo1160a(this.f1340p, this.f1339o);
            return aiy;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    static ahm m1491a(ahg ahg, afx afx) {
        byte[][] a = afx.mo624a(8, "invalid key format");
        ahr ahr = new ahr(ahg, a[1], a[2], a[3]);
        ahr.f1346v = a[4];
        ahr.f1342r = a[5];
        ahr.f1343s = a[6];
        ahr.f1301j = new String(a[7]);
        ahr.f1300i = 0;
        return ahr;
    }

    /* renamed from: e */
    public byte[] mo944e() {
        if (!mo952l()) {
            afx afx = new afx();
            afx.mo627b(f1338z);
            afx.mo627b(this.f1339o);
            afx.mo627b(this.f1340p);
            afx.mo627b(this.f1341q);
            afx.mo627b(m1494p());
            afx.mo627b(this.f1342r);
            afx.mo627b(this.f1343s);
            afx.mo627b(aji.m1820c(this.f1301j));
            int a = afx.mo617a();
            byte[] bArr = new byte[a];
            afx.mo632c(bArr, 0, a);
            return bArr;
        }
        throw new ahj("key is encrypted.");
    }

    /* renamed from: n */
    private byte[] m1492n() {
        if (this.f1344t == null) {
            this.f1344t = new BigInteger(this.f1341q).mod(new BigInteger(this.f1342r).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.f1344t;
    }

    /* renamed from: o */
    private byte[] m1493o() {
        if (this.f1345u == null) {
            this.f1345u = new BigInteger(this.f1341q).mod(new BigInteger(this.f1343s).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.f1345u;
    }

    /* renamed from: p */
    private byte[] m1494p() {
        if (this.f1346v == null) {
            this.f1346v = new BigInteger(this.f1343s).modInverse(new BigInteger(this.f1342r)).toByteArray();
        }
        return this.f1346v;
    }

    /* renamed from: m */
    public void mo953m() {
        super.mo953m();
        aji.m1822d(this.f1341q);
    }
}
