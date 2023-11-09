package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lp */
public class C0629lp extends C0552jb.C0555c {

    /* renamed from: d */
    private final C0560jd.C0563c f5220d;

    /* renamed from: e */
    private final C0469gl f5221e;

    public C0629lp(C0560jd.C0563c cVar, C0469gl glVar) {
        this.f5220d = cVar;
        this.f5221e = glVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5006b() {
        this.f5045b = this.f5220d.hasNext();
        if (this.f5045b) {
            long a = this.f5220d.mo3698a();
            if (this.f5046c) {
                this.f5044a = this.f5221e.mo3753a(this.f5044a, a);
            } else {
                this.f5044a = a;
            }
        }
    }
}
