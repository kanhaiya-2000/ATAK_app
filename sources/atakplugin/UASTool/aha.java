package atakplugin.UASTool;

import java.io.PrintStream;

public class aha {

    /* renamed from: a */
    protected static final int f1220a = 0;

    /* renamed from: b */
    public static final int f1221b = 1;

    /* renamed from: c */
    public static final int f1222c = 2;

    /* renamed from: d */
    static final int f1223d = 3;

    /* renamed from: j */
    private static final byte[] f1224j = aji.m1820c("ssh-dss");

    /* renamed from: k */
    private static final byte[] f1225k = aji.m1820c("ssh-rsa");

    /* renamed from: e */
    protected String f1226e;

    /* renamed from: f */
    protected String f1227f;

    /* renamed from: g */
    protected int f1228g;

    /* renamed from: h */
    protected byte[] f1229h;

    /* renamed from: i */
    protected String f1230i;

    public aha(String str, byte[] bArr) {
        this(str, 0, bArr);
    }

    public aha(String str, int i, byte[] bArr) {
        this(str, i, bArr, (String) null);
    }

    public aha(String str, int i, byte[] bArr, String str2) {
        this("", str, i, bArr, str2);
    }

    public aha(String str, String str2, int i, byte[] bArr, String str3) {
        this.f1226e = str;
        this.f1227f = str2;
        if (i != 0) {
            this.f1228g = i;
        } else if (bArr[8] == 100) {
            this.f1228g = 1;
        } else if (bArr[8] == 114) {
            this.f1228g = 2;
        } else {
            throw new ahj("invalid key type");
        }
        this.f1229h = bArr;
        this.f1230i = str3;
    }

    /* renamed from: a */
    public String mo839a() {
        return this.f1227f;
    }

    /* renamed from: b */
    public String mo842b() {
        int i = this.f1228g;
        if (i == 1) {
            return aji.m1813b(f1224j);
        }
        return i == 2 ? aji.m1813b(f1225k) : "UNKNOWN";
    }

    /* renamed from: c */
    public String mo843c() {
        byte[] bArr = this.f1229h;
        return aji.m1813b(aji.m1817b(bArr, 0, bArr.length));
    }

    /* renamed from: a */
    public String mo840a(ahg ahg) {
        agz agz;
        try {
            agz = (agz) Class.forName(ahg.m1350e("md5")).newInstance();
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("getFingerPrint: " + e);
            agz = null;
        }
        return aji.m1800a(agz, this.f1229h);
    }

    /* renamed from: d */
    public String mo844d() {
        return this.f1230i;
    }

    /* renamed from: e */
    public String mo845e() {
        return this.f1226e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo841a(String str) {
        return m1285b(str);
    }

    /* renamed from: b */
    private boolean m1285b(String str) {
        String str2 = this.f1227f;
        int length = str2.length();
        int length2 = str.length();
        int i = 0;
        while (i < length) {
            int indexOf = str2.indexOf(44, i);
            if (indexOf == -1) {
                if (length2 != length - i) {
                    return false;
                }
                return str2.regionMatches(true, i, str, 0, length2);
            } else if (length2 == indexOf - i && str2.regionMatches(true, i, str, 0, length2)) {
                return true;
            } else {
                i = indexOf + 1;
            }
        }
        return false;
    }
}
