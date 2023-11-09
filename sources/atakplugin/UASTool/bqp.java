package atakplugin.UASTool;

import atakplugin.UASTool.bqm;
import atakplugin.UASTool.bsy;

class bqp extends bws {

    /* renamed from: a */
    final /* synthetic */ bqm f3198a;

    /* renamed from: b */
    final /* synthetic */ bsy.C0237a f3199b;

    /* renamed from: c */
    final /* synthetic */ bqm.C0214a f3200c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bqp(bqm.C0214a aVar, bxp bxp, bqm bqm, bsy.C0237a aVar2) {
        super(bxp);
        this.f3200c = aVar;
        this.f3198a = bqm;
        this.f3199b = aVar2;
    }

    public void close() {
        synchronized (bqm.this) {
            if (!this.f3200c.f3175d) {
                boolean unused = this.f3200c.f3175d = true;
                bqm.m8589c(bqm.this);
                super.close();
                this.f3199b.mo3445b();
            }
        }
    }
}
