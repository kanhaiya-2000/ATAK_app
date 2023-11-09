package atakplugin.UASTool;

import atakplugin.UASTool.ahm;
import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.util.Vector;

public class ahq extends ahm {

    /* renamed from: o */
    private static final byte[] f1325o = {42, -122, 72, -122, -9, Ascii.f8514CR, 1, 1, 1};

    /* renamed from: p */
    private static final byte[] f1326p = {42, -122, 72, -50, 56, 4, 1};

    /* renamed from: q */
    private static final byte[] f1327q = {42, -122, 72, -122, -9, Ascii.f8514CR, 1, 5, Ascii.f8514CR};

    /* renamed from: r */
    private static final byte[] f1328r = {42, -122, 72, -122, -9, Ascii.f8514CR, 1, 5, Ascii.f8516FF};

    /* renamed from: s */
    private static final byte[] f1329s = {96, -122, 72, 1, 101, 3, 4, 1, 2};

    /* renamed from: t */
    private static final byte[] f1330t = {96, -122, 72, 1, 101, 3, 4, 1, Ascii.SYN};

    /* renamed from: u */
    private static final byte[] f1331u = {96, -122, 72, 1, 101, 3, 4, 1, 42};

    /* renamed from: v */
    private static final byte[] f1332v = {42, -122, 72, -122, -9, Ascii.f8514CR, 1, 5, 3};

    /* renamed from: x */
    private static final byte[] f1333x = aji.m1820c("-----BEGIN DSA PRIVATE KEY-----");

    /* renamed from: y */
    private static final byte[] f1334y = aji.m1820c("-----END DSA PRIVATE KEY-----");

    /* renamed from: w */
    private ahm f1335w = null;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo920a(int i) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public byte[] mo947g() {
        return null;
    }

    public ahq(ahg ahg) {
        super(ahg);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo928a() {
        return f1333x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo937b() {
        return f1334y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo936b(byte[] bArr) {
        try {
            Vector vector = new Vector();
            ahm.C0044a[] g = new ahm.C0044a(this, bArr).mo960g();
            ahm.C0044a aVar = g[1];
            ahm.C0044a aVar2 = g[2];
            ahm.C0044a[] g2 = aVar.mo960g();
            byte[] f = g2[0].mo959f();
            ahm.C0044a[] g3 = g2[1].mo960g();
            if (g3.length > 0) {
                for (ahm.C0044a f2 : g3) {
                    vector.addElement(f2.mo959f());
                }
            }
            byte[] f3 = aVar2.mo959f();
            if (aji.m1815b(f, f1325o)) {
                ahr ahr = new ahr(this.f1302k);
                ahr.mo921a((ahm) this);
                if (ahr.mo936b(f3)) {
                    this.f1335w = ahr;
                }
            } else if (aji.m1815b(f, f1326p)) {
                ahm.C0044a aVar3 = new ahm.C0044a(this, f3);
                if (vector.size() == 0) {
                    ahm.C0044a[] g4 = aVar3.mo960g();
                    byte[] f4 = g4[1].mo959f();
                    ahm.C0044a[] g5 = g4[0].mo960g();
                    for (ahm.C0044a f5 : g5) {
                        vector.addElement(f5.mo959f());
                    }
                    vector.addElement(f4);
                } else {
                    vector.addElement(aVar3.mo959f());
                }
                byte[] bArr2 = (byte[]) vector.elementAt(0);
                byte[] bArr3 = (byte[]) vector.elementAt(2);
                byte[] bArr4 = (byte[]) vector.elementAt(3);
                byte[] g6 = new ahn(this.f1302k, bArr2, (byte[]) vector.elementAt(1), bArr3, new BigInteger(bArr3).modPow(new BigInteger(bArr4), new BigInteger(bArr2)).toByteArray(), bArr4).mo947g();
                ahn ahn = new ahn(this.f1302k);
                ahn.mo921a((ahm) this);
                if (ahn.mo936b(g6)) {
                    this.f1335w = ahn;
                }
            }
            if (this.f1335w != null) {
                return true;
            }
            return false;
        } catch (ahm.C0045b | Exception unused) {
            return false;
        }
    }

    /* renamed from: j */
    public byte[] mo950j() {
        return this.f1335w.mo950j();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public byte[] mo948h() {
        return this.f1335w.mo948h();
    }

    /* renamed from: i */
    public int mo949i() {
        return this.f1335w.mo949i();
    }

    /* renamed from: c */
    public int mo938c() {
        return this.f1335w.mo938c();
    }

    /* renamed from: a */
    public byte[] mo929a(byte[] bArr) {
        return this.f1335w.mo929a(bArr);
    }

    /* renamed from: d */
    public aiw mo941d() {
        return this.f1335w.mo941d();
    }

    /* renamed from: e */
    public byte[] mo944e() {
        return this.f1335w.mo944e();
    }

    /* renamed from: d */
    public boolean mo943d(byte[] bArr) {
        if (!mo952l()) {
            return true;
        }
        if (bArr == null) {
            return !mo952l();
        }
        try {
            ahm.C0044a[] g = new ahm.C0044a(this, this.f1304n).mo960g();
            byte[] f = g[1].mo959f();
            ahm.C0044a[] g2 = g[0].mo960g();
            byte[] f2 = g2[0].mo959f();
            ahm.C0044a aVar = g2[1];
            if (aji.m1815b(f2, f1327q)) {
                ahm.C0044a[] g3 = aVar.mo960g();
                ahm.C0044a aVar2 = g3[0];
                ahm.C0044a aVar3 = g3[1];
                ahm.C0044a[] g4 = aVar2.mo960g();
                g4[0].mo959f();
                ahm.C0044a[] g5 = g4[1].mo960g();
                byte[] f3 = g5[0].mo959f();
                int parseInt = Integer.parseInt(new BigInteger(g5[1].mo959f()).toString());
                ahm.C0044a[] g6 = aVar3.mo960g();
                byte[] f4 = g6[0].mo959f();
                byte[] f5 = g6[1].mo959f();
                agm e = mo976e(f4);
                if (e == null) {
                    return false;
                }
                byte[] bArr2 = null;
                try {
                    ahg ahg = this.f1302k;
                    bArr2 = ((ahx) Class.forName(ahg.m1350e("pbkdf")).newInstance()).mo994a(bArr, f3, parseInt, e.mo806b());
                } catch (Exception unused) {
                }
                if (bArr2 == null) {
                    return false;
                }
                e.mo804a(1, bArr2, f5);
                aji.m1822d(bArr2);
                byte[] bArr3 = new byte[f.length];
                e.mo805a(f, 0, f.length, bArr3, 0);
                if (mo936b(bArr3)) {
                    this.f1303m = false;
                    return true;
                }
            } else if (aji.m1815b(f2, f1332v)) {
            }
        } catch (ahm.C0045b | Exception unused2) {
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public atakplugin.UASTool.agm mo976e(byte[] r6) {
        /*
            r5 = this;
            r0 = 0
            byte[] r1 = f1329s     // Catch:{ Exception -> 0x0039 }
            boolean r1 = atakplugin.UASTool.aji.m1815b((byte[]) r6, (byte[]) r1)     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x000c
            java.lang.String r1 = "aes128-cbc"
            goto L_0x0023
        L_0x000c:
            byte[] r1 = f1330t     // Catch:{ Exception -> 0x0039 }
            boolean r1 = atakplugin.UASTool.aji.m1815b((byte[]) r6, (byte[]) r1)     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = "aes192-cbc"
            goto L_0x0023
        L_0x0017:
            byte[] r1 = f1331u     // Catch:{ Exception -> 0x0039 }
            boolean r1 = atakplugin.UASTool.aji.m1815b((byte[]) r6, (byte[]) r1)     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = "aes256-cbc"
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            atakplugin.UASTool.ahg r2 = r5.f1302k     // Catch:{ Exception -> 0x0037 }
            java.lang.String r2 = atakplugin.UASTool.ahg.m1350e(r1)     // Catch:{ Exception -> 0x0037 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x0037 }
            java.lang.Object r2 = r2.newInstance()     // Catch:{ Exception -> 0x0037 }
            atakplugin.UASTool.agm r2 = (atakplugin.UASTool.agm) r2     // Catch:{ Exception -> 0x0037 }
            atakplugin.UASTool.agm r2 = (atakplugin.UASTool.agm) r2     // Catch:{ Exception -> 0x0037 }
            r0 = r2
            goto L_0x008b
        L_0x0037:
            goto L_0x003a
        L_0x0039:
            r1 = r0
        L_0x003a:
            atakplugin.UASTool.ahu r2 = atakplugin.UASTool.ahg.m1351f()
            r3 = 4
            boolean r2 = r2.mo908a(r3)
            if (r2 == 0) goto L_0x008b
            if (r1 != 0) goto L_0x005d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unknown oid: "
            r1.append(r2)
            java.lang.String r6 = atakplugin.UASTool.aji.m1818c((byte[]) r6)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            goto L_0x0073
        L_0x005d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "function "
            r6.append(r2)
            r6.append(r1)
            java.lang.String r1 = " is not supported"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
        L_0x0073:
            atakplugin.UASTool.ahu r1 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "PKCS8: "
            r2.append(r4)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r1.mo907a(r3, r6)
        L_0x008b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ahq.mo976e(byte[]):atakplugin.UASTool.agm");
    }
}
