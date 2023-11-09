package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lm */
public class C0626lm extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0560jd.C0563c f5213a;

    /* renamed from: b */
    private final C0470gm f5214b;

    public C0626lm(C0560jd.C0563c cVar, C0470gm gmVar) {
        this.f5213a = cVar;
        this.f5214b = gmVar;
    }

    public boolean hasNext() {
        return this.f5213a.hasNext();
    }

    /* renamed from: a */
    public long mo3698a() {
        long a = this.f5213a.mo3698a();
        this.f5214b.mo4927a(a);
        return a;
    }
}
