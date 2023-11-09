package atakplugin.UASTool;

import atakplugin.UASTool.btq;
import java.io.IOException;

class btz extends bso {

    /* renamed from: a */
    final /* synthetic */ buc f3792a;

    /* renamed from: c */
    final /* synthetic */ btq.C0244c f3793c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btz(btq.C0244c cVar, String str, Object[] objArr, buc buc) {
        super(str, objArr);
        this.f3793c = cVar;
        this.f3792a = buc;
    }

    /* renamed from: d */
    public void mo3342d() {
        try {
            btq.this.f3743m.mo3470a(this.f3792a);
        } catch (IOException e) {
            bvp b = bvp.m9870b();
            b.mo3721a(4, "FramedConnection.Listener failure for " + btq.this.f3745o, (Throwable) e);
            try {
                this.f3792a.mo3595a(btn.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
