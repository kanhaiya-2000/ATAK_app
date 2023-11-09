package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jv */
public class C0581jv extends C0552jb.C0553a {

    /* renamed from: d */
    private final C0560jd.C0561a f5099d;

    /* renamed from: e */
    private final double f5100e;

    /* renamed from: f */
    private final C0367dq f5101f;

    public C0581jv(C0560jd.C0561a aVar, double d, C0367dq dqVar) {
        this.f5099d = aVar;
        this.f5100e = d;
        this.f5101f = dqVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5002b() {
        if (!this.f5040c) {
            this.f5039b = true;
            this.f5038a = this.f5100e;
            return;
        }
        this.f5039b = this.f5099d.hasNext();
        if (this.f5039b) {
            this.f5038a = this.f5101f.mo2546a(this.f5038a, this.f5099d.next().doubleValue());
        }
    }
}
