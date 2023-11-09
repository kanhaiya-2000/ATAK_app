package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jf */
public class C0565jf extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0560jd.C0561a f5058a;

    /* renamed from: b */
    private final C0560jd.C0561a f5059b;

    /* renamed from: c */
    private boolean f5060c = true;

    public C0565jf(C0560jd.C0561a aVar, C0560jd.C0561a aVar2) {
        this.f5058a = aVar;
        this.f5059b = aVar2;
    }

    public boolean hasNext() {
        if (this.f5060c) {
            if (this.f5058a.hasNext()) {
                return true;
            }
            this.f5060c = false;
        }
        return this.f5059b.hasNext();
    }

    /* renamed from: a */
    public double mo2515a() {
        return (this.f5060c ? this.f5058a : this.f5059b).mo2515a();
    }
}
