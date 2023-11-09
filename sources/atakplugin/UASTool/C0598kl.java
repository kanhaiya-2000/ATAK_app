package atakplugin.UASTool;

import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kl */
public class C0598kl extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0556jc.C0558b f5146a;

    /* renamed from: b */
    private final C0445ft f5147b;

    public C0598kl(C0556jc.C0558b bVar, C0445ft ftVar) {
        this.f5146a = bVar;
        this.f5147b = ftVar;
    }

    public boolean hasNext() {
        return this.f5146a.hasNext();
    }

    /* renamed from: a */
    public int mo2940a() {
        return this.f5147b.mo2977a(this.f5146a.mo5010b(), this.f5146a.next().intValue());
    }
}
