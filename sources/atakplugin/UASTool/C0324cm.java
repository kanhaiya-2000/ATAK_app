package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.cm */
class C0324cm implements C0383ec {

    /* renamed from: a */
    final /* synthetic */ double f4698a;

    /* renamed from: b */
    final /* synthetic */ double f4699b;

    /* renamed from: c */
    final /* synthetic */ C0317cg f4700c;

    /* renamed from: d */
    private final double f4701d;

    C0324cm(C0317cg cgVar, double d, double d2) {
        this.f4700c = cgVar;
        this.f4698a = d;
        this.f4699b = d2;
        this.f4701d = d - d2;
    }

    /* renamed from: a */
    public double mo4686a() {
        double nextDouble = (this.f4700c.f4638a.nextDouble() * this.f4701d) + this.f4699b;
        double d = this.f4698a;
        return nextDouble >= d ? Double.longBitsToDouble(Double.doubleToLongBits(d) - 1) : nextDouble;
    }
}
