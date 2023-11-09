package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jl */
public class C0571jl extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0388eg f5078a;

    /* renamed from: b */
    private double f5079b;

    public boolean hasNext() {
        return true;
    }

    public C0571jl(double d, C0388eg egVar) {
        this.f5078a = egVar;
        this.f5079b = d;
    }

    /* renamed from: a */
    public double mo2515a() {
        double d = this.f5079b;
        this.f5079b = this.f5078a.mo4905a(d);
        return d;
    }
}
