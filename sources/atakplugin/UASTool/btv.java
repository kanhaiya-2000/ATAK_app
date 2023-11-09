package atakplugin.UASTool;

import java.io.IOException;
import java.util.List;

class btv extends bso {

    /* renamed from: a */
    final /* synthetic */ int f3780a;

    /* renamed from: c */
    final /* synthetic */ List f3781c;

    /* renamed from: d */
    final /* synthetic */ boolean f3782d;

    /* renamed from: e */
    final /* synthetic */ btq f3783e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btv(btq btq, String str, Object[] objArr, int i, List list, boolean z) {
        super(str, objArr);
        this.f3783e = btq;
        this.f3780a = i;
        this.f3781c = list;
        this.f3782d = z;
    }

    /* renamed from: d */
    public void mo3342d() {
        boolean a = this.f3783e.f3751u.mo3654a(this.f3780a, this.f3781c, this.f3782d);
        if (a) {
            try {
                this.f3783e.f3741i.mo3510a(this.f3780a, btn.CANCEL);
            } catch (IOException unused) {
                return;
            }
        }
        if (a || this.f3782d) {
            synchronized (this.f3783e) {
                this.f3783e.f3754y.remove(Integer.valueOf(this.f3780a));
            }
        }
    }
}
