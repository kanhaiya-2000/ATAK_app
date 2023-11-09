package atakplugin.UASTool;

import atakplugin.UASTool.bqm;
import atakplugin.UASTool.bsy;

class bqq extends bwt {

    /* renamed from: a */
    final /* synthetic */ bsy.C0239c f3201a;

    /* renamed from: b */
    final /* synthetic */ bqm.C0215b f3202b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bqq(bqm.C0215b bVar, bxr bxr, bsy.C0239c cVar) {
        super(bxr);
        this.f3202b = bVar;
        this.f3201a = cVar;
    }

    public void close() {
        this.f3201a.close();
        super.close();
    }
}
