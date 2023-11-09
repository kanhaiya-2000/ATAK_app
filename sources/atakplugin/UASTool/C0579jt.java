package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jt */
public class C0579jt extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0560jd.C0561a f5095a;

    /* renamed from: b */
    private final int f5096b;

    public C0579jt(C0560jd.C0561a aVar, int i) {
        this.f5095a = aVar;
        this.f5096b = i;
    }

    public boolean hasNext() {
        return this.f5095a.hasNext();
    }

    /* renamed from: a */
    public double mo2515a() {
        double a = this.f5095a.mo2515a();
        for (int i = 1; i < this.f5096b && this.f5095a.hasNext(); i++) {
            this.f5095a.mo2515a();
        }
        return a;
    }
}
