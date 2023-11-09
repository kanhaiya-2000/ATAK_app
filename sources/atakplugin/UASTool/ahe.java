package atakplugin.UASTool;

class ahe implements ahd {

    /* renamed from: a */
    private ahg f1240a;

    /* renamed from: b */
    private ahm f1241b;

    /* renamed from: c */
    private String f1242c;

    /* renamed from: a */
    static ahe m1322a(String str, String str2, ahg ahg) {
        return new ahe(ahg, str, ahm.m1394a(ahg, str, str2));
    }

    /* renamed from: a */
    static ahe m1323a(String str, byte[] bArr, byte[] bArr2, ahg ahg) {
        return new ahe(ahg, str, ahm.m1396a(ahg, bArr, bArr2));
    }

    private ahe(ahg ahg, String str, ahm ahm) {
        this.f1240a = ahg;
        this.f1242c = str;
        this.f1241b = ahm;
    }

    /* renamed from: a */
    public boolean mo867a(byte[] bArr) {
        return this.f1241b.mo943d(bArr);
    }

    /* renamed from: a */
    public byte[] mo868a() {
        return this.f1241b.mo950j();
    }

    /* renamed from: b */
    public byte[] mo870b(byte[] bArr) {
        return this.f1241b.mo929a(bArr);
    }

    /* renamed from: b */
    public boolean mo869b() {
        throw new RuntimeException("not implemented");
    }

    /* renamed from: c */
    public String mo871c() {
        return new String(this.f1241b.mo948h());
    }

    /* renamed from: d */
    public String mo872d() {
        return this.f1242c;
    }

    /* renamed from: e */
    public boolean mo873e() {
        return this.f1241b.mo952l();
    }

    /* renamed from: f */
    public void mo874f() {
        this.f1241b.mo953m();
        this.f1241b = null;
    }

    /* renamed from: g */
    public ahm mo875g() {
        return this.f1241b;
    }
}
