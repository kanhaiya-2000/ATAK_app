package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kd */
public class C0590kd extends C0552jb.C0554b {

    /* renamed from: d */
    private final C0560jd.C0562b f5122d;

    /* renamed from: e */
    private final C0453fz f5123e;

    public C0590kd(C0560jd.C0562b bVar, C0453fz fzVar) {
        this.f5122d = bVar;
        this.f5123e = fzVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5004b() {
        if (!this.f5043c) {
            do {
                boolean hasNext = this.f5122d.hasNext();
                this.f5042b = hasNext;
                if (hasNext) {
                    this.f5041a = this.f5122d.next().intValue();
                }
            } while (this.f5123e.mo4922a(this.f5041a));
            return;
        }
        this.f5042b = this.f5042b && this.f5122d.hasNext();
        if (this.f5042b) {
            this.f5041a = this.f5122d.next().intValue();
        }
    }
}
