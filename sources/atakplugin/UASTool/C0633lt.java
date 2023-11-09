package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lt */
public class C0633lt extends C0552jb.C0555c {

    /* renamed from: d */
    private final C0560jd.C0563c f5231d;

    /* renamed from: e */
    private final C0477gr f5232e;

    public C0633lt(C0560jd.C0563c cVar, C0477gr grVar) {
        this.f5231d = cVar;
        this.f5232e = grVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5006b() {
        this.f5045b = this.f5231d.hasNext() && (!this.f5046c || !this.f5232e.mo4929a(this.f5044a));
        if (this.f5045b) {
            this.f5044a = this.f5231d.next().longValue();
        }
    }
}
