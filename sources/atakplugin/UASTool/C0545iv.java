package atakplugin.UASTool;

import atakplugin.UASTool.C0539it;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.iv */
class C0545iv extends C0560jd.C0562b {

    /* renamed from: a */
    long f5025a = 0;

    /* renamed from: b */
    final /* synthetic */ C0539it.C0541b f5026b;

    C0545iv(C0539it.C0541b bVar) {
        this.f5026b = bVar;
    }

    /* renamed from: a */
    public int mo2940a() {
        C0539it.C0541b bVar = this.f5026b;
        long j = this.f5025a;
        this.f5025a = 1 + j;
        return bVar.mo4965a(j);
    }

    public boolean hasNext() {
        return this.f5025a < this.f5026b.mo4975c();
    }
}
