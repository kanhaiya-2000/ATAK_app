package atakplugin.UASTool;

public final class bve extends bsj {

    /* renamed from: a */
    private final brp f4030a;

    /* renamed from: b */
    private final bwp f4031b;

    public bve(brp brp, bwp bwp) {
        this.f4030a = brp;
        this.f4031b = bwp;
    }

    /* renamed from: a */
    public bru mo3016a() {
        String a = this.f4030a.mo3170a("Content-Type");
        if (a != null) {
            return bru.m8896a(a);
        }
        return null;
    }

    /* renamed from: b */
    public long mo3017b() {
        return bva.m9774a(this.f4030a);
    }

    /* renamed from: c */
    public bwp mo3018c() {
        return this.f4031b;
    }
}
