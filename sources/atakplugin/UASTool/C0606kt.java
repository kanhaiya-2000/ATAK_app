package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kt */
public class C0606kt extends C0552jb.C0554b {

    /* renamed from: d */
    private final C0560jd.C0562b f5163d;

    /* renamed from: e */
    private final int f5164e;

    /* renamed from: f */
    private final C0445ft f5165f;

    public C0606kt(C0560jd.C0562b bVar, int i, C0445ft ftVar) {
        this.f5163d = bVar;
        this.f5164e = i;
        this.f5165f = ftVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5004b() {
        if (!this.f5043c) {
            this.f5042b = true;
            this.f5041a = this.f5164e;
            return;
        }
        this.f5042b = this.f5163d.hasNext();
        if (this.f5042b) {
            this.f5041a = this.f5165f.mo2977a(this.f5041a, this.f5163d.next().intValue());
        }
    }
}
