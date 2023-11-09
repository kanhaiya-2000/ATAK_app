package atakplugin.UASTool;

import java.util.Date;

public class ais {

    /* renamed from: A */
    static final int f1536A = 40960;

    /* renamed from: B */
    static final int f1537B = 49152;

    /* renamed from: K */
    private static final int f1538K = 4095;

    /* renamed from: a */
    static final int f1539a = 2048;

    /* renamed from: b */
    static final int f1540b = 1024;

    /* renamed from: c */
    static final int f1541c = 512;

    /* renamed from: d */
    static final int f1542d = 256;

    /* renamed from: e */
    static final int f1543e = 128;

    /* renamed from: f */
    static final int f1544f = 64;

    /* renamed from: g */
    static final int f1545g = 256;

    /* renamed from: h */
    static final int f1546h = 128;

    /* renamed from: i */
    static final int f1547i = 64;

    /* renamed from: j */
    static final int f1548j = 32;

    /* renamed from: k */
    static final int f1549k = 16;

    /* renamed from: l */
    static final int f1550l = 8;

    /* renamed from: m */
    static final int f1551m = 4;

    /* renamed from: n */
    static final int f1552n = 2;

    /* renamed from: o */
    static final int f1553o = 1;

    /* renamed from: p */
    public static final int f1554p = 1;

    /* renamed from: q */
    public static final int f1555q = 2;

    /* renamed from: r */
    public static final int f1556r = 4;

    /* renamed from: s */
    public static final int f1557s = 8;

    /* renamed from: t */
    public static final int f1558t = Integer.MIN_VALUE;

    /* renamed from: u */
    static final int f1559u = 61440;

    /* renamed from: v */
    static final int f1560v = 4096;

    /* renamed from: w */
    static final int f1561w = 8192;

    /* renamed from: x */
    static final int f1562x = 16384;

    /* renamed from: y */
    static final int f1563y = 24576;

    /* renamed from: z */
    static final int f1564z = 32768;

    /* renamed from: C */
    int f1565C = 0;

    /* renamed from: D */
    long f1566D;

    /* renamed from: E */
    int f1567E;

    /* renamed from: F */
    int f1568F;

    /* renamed from: G */
    int f1569G;

    /* renamed from: H */
    int f1570H;

    /* renamed from: I */
    int f1571I;

    /* renamed from: J */
    String[] f1572J = null;

    /* renamed from: a */
    public String mo1107a() {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (mo1118f()) {
            stringBuffer.append('d');
        } else if (mo1122j()) {
            stringBuffer.append('l');
        } else {
            stringBuffer.append('-');
        }
        if ((this.f1569G & 256) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.f1569G & 128) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        int i = this.f1569G;
        if ((i & 2048) != 0) {
            stringBuffer.append('s');
        } else if ((i & 64) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        if ((this.f1569G & 32) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.f1569G & 16) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        int i2 = this.f1569G;
        if ((i2 & 1024) != 0) {
            stringBuffer.append('s');
        } else if ((i2 & 8) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        if ((this.f1569G & 4) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.f1569G & 2) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        if ((this.f1569G & 1) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public String mo1111b() {
        return new Date(((long) this.f1570H) * 1000).toString();
    }

    /* renamed from: c */
    public String mo1115c() {
        return new Date(((long) this.f1571I) * 1000).toString();
    }

    private ais() {
    }

    /* renamed from: a */
    static ais m1728a(afx afx) {
        int d;
        ais ais = new ais();
        int d2 = afx.mo633d();
        ais.f1565C = d2;
        if ((d2 & 1) != 0) {
            ais.f1566D = afx.mo629c();
        }
        if ((ais.f1565C & 2) != 0) {
            ais.f1567E = afx.mo633d();
            ais.f1568F = afx.mo633d();
        }
        if ((ais.f1565C & 4) != 0) {
            ais.f1569G = afx.mo633d();
        }
        if ((ais.f1565C & 8) != 0) {
            ais.f1570H = afx.mo633d();
        }
        if ((ais.f1565C & 8) != 0) {
            ais.f1571I = afx.mo633d();
        }
        if ((ais.f1565C & Integer.MIN_VALUE) != 0 && (d = afx.mo633d()) > 0) {
            ais.f1572J = new String[(d * 2)];
            for (int i = 0; i < d; i++) {
                int i2 = i * 2;
                ais.f1572J[i2] = aji.m1813b(afx.mo643j());
                ais.f1572J[i2 + 1] = aji.m1813b(afx.mo643j());
            }
        }
        return ais;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo1116d() {
        int i = this.f1565C;
        int i2 = (i & 1) != 0 ? 12 : 4;
        if ((i & 2) != 0) {
            i2 += 8;
        }
        if ((i & 4) != 0) {
            i2 += 4;
        }
        if ((i & 8) != 0) {
            i2 += 8;
        }
        if ((i & Integer.MIN_VALUE) != 0) {
            i2 += 4;
            int length = this.f1572J.length / 2;
            if (length > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = i3 * 2;
                    i2 = i2 + 4 + this.f1572J[i4].length() + 4 + this.f1572J[i4 + 1].length();
                }
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1114b(afx afx) {
        int length;
        afx.mo619a(this.f1565C);
        if ((this.f1565C & 1) != 0) {
            afx.mo620a(this.f1566D);
        }
        if ((this.f1565C & 2) != 0) {
            afx.mo619a(this.f1567E);
            afx.mo619a(this.f1568F);
        }
        if ((this.f1565C & 4) != 0) {
            afx.mo619a(this.f1569G);
        }
        if ((this.f1565C & 8) != 0) {
            afx.mo619a(this.f1570H);
        }
        if ((this.f1565C & 8) != 0) {
            afx.mo619a(this.f1571I);
        }
        if ((this.f1565C & Integer.MIN_VALUE) != 0 && (length = this.f1572J.length / 2) > 0) {
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                afx.mo627b(aji.m1820c(this.f1572J[i2]));
                afx.mo627b(aji.m1820c(this.f1572J[i2 + 1]));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1108a(int i) {
        this.f1565C = i;
    }

    /* renamed from: a */
    public void mo1110a(long j) {
        this.f1565C |= 1;
        this.f1566D = j;
    }

    /* renamed from: a */
    public void mo1109a(int i, int i2) {
        this.f1565C |= 2;
        this.f1567E = i;
        this.f1568F = i2;
    }

    /* renamed from: b */
    public void mo1113b(int i, int i2) {
        this.f1565C |= 8;
        this.f1570H = i;
        this.f1571I = i2;
    }

    /* renamed from: b */
    public void mo1112b(int i) {
        this.f1565C |= 4;
        this.f1569G = (i & f1538K) | (this.f1569G & -4096);
    }

    /* renamed from: c */
    private boolean m1729c(int i) {
        return (this.f1565C & 4) != 0 && (this.f1569G & f1559u) == i;
    }

    /* renamed from: e */
    public boolean mo1117e() {
        return m1729c(32768);
    }

    /* renamed from: f */
    public boolean mo1118f() {
        return m1729c(16384);
    }

    /* renamed from: g */
    public boolean mo1119g() {
        return m1729c(8192);
    }

    /* renamed from: h */
    public boolean mo1120h() {
        return m1729c(f1563y);
    }

    /* renamed from: i */
    public boolean mo1121i() {
        return m1729c(4096);
    }

    /* renamed from: j */
    public boolean mo1122j() {
        return m1729c(f1536A);
    }

    /* renamed from: k */
    public boolean mo1123k() {
        return m1729c(f1537B);
    }

    /* renamed from: l */
    public int mo1124l() {
        return this.f1565C;
    }

    /* renamed from: m */
    public long mo1125m() {
        return this.f1566D;
    }

    /* renamed from: n */
    public int mo1126n() {
        return this.f1567E;
    }

    /* renamed from: o */
    public int mo1127o() {
        return this.f1568F;
    }

    /* renamed from: p */
    public int mo1128p() {
        return this.f1569G;
    }

    /* renamed from: q */
    public int mo1129q() {
        return this.f1570H;
    }

    /* renamed from: r */
    public int mo1130r() {
        return this.f1571I;
    }

    /* renamed from: s */
    public String[] mo1131s() {
        return this.f1572J;
    }

    public String toString() {
        return mo1107a() + " " + mo1126n() + " " + mo1127o() + " " + mo1125m() + " " + mo1115c();
    }
}
