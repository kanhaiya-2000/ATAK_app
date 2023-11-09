package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kw */
public class C0609kw extends C0552jb.C0554b {

    /* renamed from: d */
    private final C0560jd.C0562b f5172d;

    /* renamed from: e */
    private final C0453fz f5173e;

    public C0609kw(C0560jd.C0562b bVar, C0453fz fzVar) {
        this.f5172d = bVar;
        this.f5173e = fzVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5004b() {
        this.f5042b = this.f5172d.hasNext() && (!this.f5043c || !this.f5173e.mo4922a(this.f5041a));
        if (this.f5042b) {
            this.f5041a = this.f5172d.next().intValue();
        }
    }
}
