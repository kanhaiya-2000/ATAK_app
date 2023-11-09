package atakplugin.UASTool;

import atakplugin.UASTool.C0539it;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.iu */
class C0544iu extends C0560jd.C0561a {

    /* renamed from: a */
    long f5023a = 0;

    /* renamed from: b */
    final /* synthetic */ C0539it.C0540a f5024b;

    C0544iu(C0539it.C0540a aVar) {
        this.f5024b = aVar;
    }

    /* renamed from: a */
    public double mo2515a() {
        C0539it.C0540a aVar = this.f5024b;
        long j = this.f5023a;
        this.f5023a = 1 + j;
        return aVar.mo4956a(j);
    }

    public boolean hasNext() {
        return this.f5023a < this.f5024b.mo4975c();
    }
}
