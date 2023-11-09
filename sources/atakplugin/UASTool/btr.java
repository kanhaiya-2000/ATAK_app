package atakplugin.UASTool;

import java.io.IOException;

class btr extends bso {

    /* renamed from: a */
    final /* synthetic */ int f3766a;

    /* renamed from: c */
    final /* synthetic */ btn f3767c;

    /* renamed from: d */
    final /* synthetic */ btq f3768d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btr(btq btq, String str, Object[] objArr, int i, btn btn) {
        super(str, objArr);
        this.f3768d = btq;
        this.f3766a = i;
        this.f3767c = btn;
    }

    /* renamed from: d */
    public void mo3342d() {
        try {
            this.f3768d.mo3535b(this.f3766a, this.f3767c);
        } catch (IOException unused) {
        }
    }
}
