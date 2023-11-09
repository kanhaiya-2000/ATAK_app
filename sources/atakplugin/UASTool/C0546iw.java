package atakplugin.UASTool;

import atakplugin.UASTool.C0539it;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.iw */
class C0546iw extends C0560jd.C0563c {

    /* renamed from: a */
    long f5027a = 0;

    /* renamed from: b */
    final /* synthetic */ C0539it.C0542c f5028b;

    C0546iw(C0539it.C0542c cVar) {
        this.f5028b = cVar;
    }

    /* renamed from: a */
    public long mo3698a() {
        C0539it.C0542c cVar = this.f5028b;
        long j = this.f5027a;
        this.f5027a = 1 + j;
        return cVar.mo4971b(j);
    }

    public boolean hasNext() {
        return this.f5027a < this.f5028b.mo4975c();
    }
}
