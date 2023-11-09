package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kp */
public class C0602kp extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0560jd.C0562b f5154a;

    /* renamed from: b */
    private final C0446fu f5155b;

    public C0602kp(C0560jd.C0562b bVar, C0446fu fuVar) {
        this.f5154a = bVar;
        this.f5155b = fuVar;
    }

    public boolean hasNext() {
        return this.f5154a.hasNext();
    }

    /* renamed from: a */
    public int mo2940a() {
        int a = this.f5154a.mo2940a();
        this.f5155b.mo4921a(a);
        return a;
    }
}
