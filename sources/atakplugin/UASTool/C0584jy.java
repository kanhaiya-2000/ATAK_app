package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jy */
public class C0584jy extends C0552jb.C0553a {

    /* renamed from: d */
    private final C0560jd.C0561a f5108d;

    /* renamed from: e */
    private final C0375dw f5109e;

    public C0584jy(C0560jd.C0561a aVar, C0375dw dwVar) {
        this.f5108d = aVar;
        this.f5109e = dwVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5002b() {
        this.f5039b = this.f5108d.hasNext() && (!this.f5040c || !this.f5109e.mo4901a(this.f5038a));
        if (this.f5039b) {
            this.f5038a = this.f5108d.next().doubleValue();
        }
    }
}
