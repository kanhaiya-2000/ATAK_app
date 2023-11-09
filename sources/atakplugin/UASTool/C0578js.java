package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.js */
public class C0578js extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0560jd.C0561a f5093a;

    /* renamed from: b */
    private final C0368dr f5094b;

    public C0578js(C0560jd.C0561a aVar, C0368dr drVar) {
        this.f5093a = aVar;
        this.f5094b = drVar;
    }

    public boolean hasNext() {
        return this.f5093a.hasNext();
    }

    /* renamed from: a */
    public double mo2515a() {
        double a = this.f5093a.mo2515a();
        this.f5094b.mo4899a(a);
        return a;
    }
}
