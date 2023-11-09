package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ju */
public class C0580ju extends C0552jb.C0553a {

    /* renamed from: d */
    private final C0560jd.C0561a f5097d;

    /* renamed from: e */
    private final C0367dq f5098e;

    public C0580ju(C0560jd.C0561a aVar, C0367dq dqVar) {
        this.f5097d = aVar;
        this.f5098e = dqVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5002b() {
        this.f5039b = this.f5097d.hasNext();
        if (this.f5039b) {
            double a = this.f5097d.mo2515a();
            if (this.f5040c) {
                this.f5038a = this.f5098e.mo2546a(this.f5038a, a);
            } else {
                this.f5038a = a;
            }
        }
    }
}
