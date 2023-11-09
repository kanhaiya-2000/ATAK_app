package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ks */
public class C0605ks extends C0552jb.C0554b {

    /* renamed from: d */
    private final C0560jd.C0562b f5161d;

    /* renamed from: e */
    private final C0445ft f5162e;

    public C0605ks(C0560jd.C0562b bVar, C0445ft ftVar) {
        this.f5161d = bVar;
        this.f5162e = ftVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5004b() {
        this.f5042b = this.f5161d.hasNext();
        if (this.f5042b) {
            int intValue = this.f5161d.next().intValue();
            if (this.f5043c) {
                this.f5041a = this.f5162e.mo2977a(this.f5041a, intValue);
            } else {
                this.f5041a = intValue;
            }
        }
    }
}
