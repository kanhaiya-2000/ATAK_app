package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kx */
public class C0610kx extends C0552jb.C0554b {

    /* renamed from: d */
    private final C0560jd.C0562b f5174d;

    /* renamed from: e */
    private final C0453fz f5175e;

    public C0610kx(C0560jd.C0562b bVar, C0453fz fzVar) {
        this.f5174d = bVar;
        this.f5175e = fzVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5004b() {
        boolean z;
        if (this.f5174d.hasNext()) {
            C0453fz fzVar = this.f5175e;
            int intValue = this.f5174d.next().intValue();
            this.f5041a = intValue;
            if (fzVar.mo4922a(intValue)) {
                z = true;
                this.f5042b = z;
            }
        }
        z = false;
        this.f5042b = z;
    }
}
