package atakplugin.UASTool;

public class aiv {

    /* renamed from: a */
    int f1578a = 0;

    /* renamed from: b */
    long f1579b;

    /* renamed from: c */
    int f1580c;

    /* renamed from: d */
    int f1581d;

    /* renamed from: e */
    int f1582e;

    /* renamed from: f */
    int f1583f;

    /* renamed from: g */
    int f1584g;

    /* renamed from: h */
    String[] f1585h = null;

    /* renamed from: i */
    private long f1586i;

    /* renamed from: j */
    private long f1587j;

    /* renamed from: k */
    private long f1588k;

    /* renamed from: l */
    private long f1589l;

    /* renamed from: m */
    private long f1590m;

    /* renamed from: n */
    private long f1591n;

    /* renamed from: o */
    private long f1592o;

    /* renamed from: p */
    private long f1593p;

    /* renamed from: q */
    private long f1594q;

    /* renamed from: r */
    private long f1595r;

    /* renamed from: s */
    private long f1596s;

    private aiv() {
    }

    /* renamed from: a */
    static aiv m1758a(afx afx) {
        aiv aiv = new aiv();
        aiv.f1586i = afx.mo629c();
        aiv.f1587j = afx.mo629c();
        aiv.f1588k = afx.mo629c();
        aiv.f1589l = afx.mo629c();
        aiv.f1590m = afx.mo629c();
        aiv.f1591n = afx.mo629c();
        aiv.f1592o = afx.mo629c();
        aiv.f1593p = afx.mo629c();
        aiv.f1594q = afx.mo629c();
        int c = (int) afx.mo629c();
        aiv.f1596s = afx.mo629c();
        long j = 0;
        long j2 = (c & 1) != 0 ? 1 : 0;
        aiv.f1595r = j2;
        if ((c & 2) != 0) {
            j = 2;
        }
        aiv.f1595r = j2 | j;
        return aiv;
    }

    /* renamed from: a */
    public long mo1138a() {
        return this.f1586i;
    }

    /* renamed from: b */
    public long mo1139b() {
        return this.f1587j;
    }

    /* renamed from: c */
    public long mo1140c() {
        return this.f1588k;
    }

    /* renamed from: d */
    public long mo1141d() {
        return this.f1589l;
    }

    /* renamed from: e */
    public long mo1142e() {
        return this.f1590m;
    }

    /* renamed from: f */
    public long mo1143f() {
        return this.f1591n;
    }

    /* renamed from: g */
    public long mo1144g() {
        return this.f1592o;
    }

    /* renamed from: h */
    public long mo1145h() {
        return this.f1593p;
    }

    /* renamed from: i */
    public long mo1146i() {
        return this.f1594q;
    }

    /* renamed from: j */
    public long mo1147j() {
        return this.f1595r;
    }

    /* renamed from: k */
    public long mo1148k() {
        return this.f1596s;
    }

    /* renamed from: l */
    public long mo1149l() {
        return (mo1139b() * mo1140c()) / 1024;
    }

    /* renamed from: m */
    public long mo1150m() {
        return (mo1139b() * (mo1140c() - mo1141d())) / 1024;
    }

    /* renamed from: n */
    public long mo1151n() {
        return (mo1139b() * mo1142e()) / 1024;
    }

    /* renamed from: o */
    public long mo1152o() {
        return (mo1139b() * mo1141d()) / 1024;
    }

    /* renamed from: p */
    public int mo1153p() {
        return (int) (((mo1140c() - mo1141d()) * 100) / mo1140c());
    }
}
