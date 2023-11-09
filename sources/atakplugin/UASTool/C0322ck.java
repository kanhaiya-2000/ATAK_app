package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.ck */
class C0322ck implements C0461gf {

    /* renamed from: a */
    final /* synthetic */ int f4645a;

    /* renamed from: b */
    final /* synthetic */ int f4646b;

    /* renamed from: c */
    final /* synthetic */ C0317cg f4647c;

    /* renamed from: d */
    private final int f4648d;

    C0322ck(C0317cg cgVar, int i, int i2) {
        this.f4647c = cgVar;
        this.f4645a = i;
        this.f4646b = i2;
        this.f4648d = i - i2;
    }

    /* renamed from: a */
    public int mo4662a() {
        if (this.f4648d >= 0) {
            return this.f4646b + this.f4647c.f4638a.nextInt(this.f4648d);
        }
        while (true) {
            int nextInt = this.f4647c.f4638a.nextInt();
            if (this.f4646b < nextInt && nextInt < this.f4645a) {
                return nextInt;
            }
        }
    }
}
