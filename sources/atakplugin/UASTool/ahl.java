package atakplugin.UASTool;

import java.io.PrintStream;

public abstract class ahl {

    /* renamed from: A */
    static String f1261A = "hmac-md5";

    /* renamed from: B */
    static String f1262B = "";

    /* renamed from: C */
    static String f1263C = "";

    /* renamed from: D */
    public static final int f1264D = 0;

    /* renamed from: k */
    static final int f1265k = 0;

    /* renamed from: l */
    static final int f1266l = 1;

    /* renamed from: m */
    static final int f1267m = 2;

    /* renamed from: n */
    static final int f1268n = 3;

    /* renamed from: o */
    static final int f1269o = 4;

    /* renamed from: p */
    static final int f1270p = 5;

    /* renamed from: q */
    static final int f1271q = 6;

    /* renamed from: r */
    static final int f1272r = 7;

    /* renamed from: s */
    static final int f1273s = 8;

    /* renamed from: t */
    static final int f1274t = 9;

    /* renamed from: u */
    static final int f1275u = 10;

    /* renamed from: v */
    static String f1276v = "diffie-hellman-group1-sha1";

    /* renamed from: w */
    static String f1277w = "ssh-rsa,ssh-dss";

    /* renamed from: x */
    static String f1278x = "blowfish-cbc";

    /* renamed from: y */
    static String f1279y = "blowfish-cbc";

    /* renamed from: z */
    static String f1280z = "hmac-md5";

    /* renamed from: E */
    protected air f1281E = null;

    /* renamed from: F */
    protected agz f1282F = null;

    /* renamed from: G */
    protected byte[] f1283G = null;

    /* renamed from: H */
    protected byte[] f1284H = null;

    /* renamed from: I */
    protected byte[] f1285I = null;

    /* renamed from: a */
    public abstract String mo823a();

    /* renamed from: a */
    public abstract void mo824a(air air, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    /* renamed from: a */
    public abstract boolean mo825a(afx afx);

    /* renamed from: b */
    public abstract int mo826b();

    /* renamed from: a */
    protected static String[] m1379a(byte[] bArr, byte[] bArr2) {
        String[] strArr = new String[10];
        afx afx = new afx(bArr);
        afx.mo634d(17);
        afx afx2 = new afx(bArr2);
        afx2.mo634d(17);
        if (ahg.m1351f().mo908a(1)) {
            for (int i = 0; i < 10; i++) {
                ahu f = ahg.m1351f();
                f.mo907a(1, "kex: server: " + aji.m1813b(afx.mo643j()));
            }
            for (int i2 = 0; i2 < 10; i2++) {
                ahu f2 = ahg.m1351f();
                f2.mo907a(1, "kex: client: " + aji.m1813b(afx2.mo643j()));
            }
            afx.mo634d(17);
            afx2.mo634d(17);
        }
        for (int i3 = 0; i3 < 10; i3++) {
            byte[] j = afx.mo643j();
            byte[] j2 = afx2.mo643j();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= j2.length) {
                    break;
                }
                while (i4 < j2.length && j2[i4] != 44) {
                    i4++;
                }
                if (i5 == i4) {
                    return null;
                }
                String c = aji.m1819c(j2, i5, i4 - i5);
                int i6 = 0;
                int i7 = 0;
                while (i6 < j.length) {
                    while (i6 < j.length && j[i6] != 44) {
                        i6++;
                    }
                    if (i7 == i6) {
                        return null;
                    }
                    if (c.equals(aji.m1819c(j, i7, i6 - i7))) {
                        strArr[i3] = c;
                        break;
                    }
                    i7 = i6 + 1;
                    i6 = i7;
                }
                i5 = i4 + 1;
                i4 = i5;
            }
            if (i4 == 0) {
                strArr[i3] = "";
            } else if (strArr[i3] == null) {
                return null;
            }
        }
        if (ahg.m1351f().mo908a(1)) {
            ahu f3 = ahg.m1351f();
            f3.mo907a(1, "kex: server->client " + strArr[3] + " " + strArr[5] + " " + strArr[7]);
            ahu f4 = ahg.m1351f();
            f4.mo907a(1, "kex: client->server " + strArr[2] + " " + strArr[4] + " " + strArr[6]);
        }
        return strArr;
    }

    /* renamed from: c */
    public String mo913c() {
        agz agz;
        try {
            agz = (agz) Class.forName(this.f1281E.mo1083i("md5")).newInstance();
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("getFingerPrint: " + e);
            agz = null;
        }
        return aji.m1800a(agz, mo917g());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public byte[] mo914d() {
        return this.f1283G;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public byte[] mo915e() {
        return this.f1284H;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public agz mo916f() {
        return this.f1282F;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public byte[] mo917g() {
        return this.f1285I;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public byte[] mo912a(byte[] bArr) {
        if (bArr.length <= 1 || bArr[0] != 0 || (bArr[1] & 128) != 0) {
            return bArr;
        }
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        return mo912a(bArr2);
    }
}
