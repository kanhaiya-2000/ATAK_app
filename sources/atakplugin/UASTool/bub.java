package atakplugin.UASTool;

import atakplugin.UASTool.btq;
import java.io.IOException;

class bub extends bso {

    /* renamed from: a */
    final /* synthetic */ bup f3799a;

    /* renamed from: c */
    final /* synthetic */ btq.C0244c f3800c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bub(btq.C0244c cVar, String str, Object[] objArr, bup bup) {
        super(str, objArr);
        this.f3800c = cVar;
        this.f3799a = bup;
    }

    /* renamed from: d */
    public void mo3342d() {
        try {
            btq.this.f3741i.mo3513a(this.f3799a);
        } catch (IOException unused) {
        }
    }
}
