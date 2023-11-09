package atakplugin.UASTool;

import java.io.IOException;
import java.util.List;

class btu extends bso {

    /* renamed from: a */
    final /* synthetic */ int f3777a;

    /* renamed from: c */
    final /* synthetic */ List f3778c;

    /* renamed from: d */
    final /* synthetic */ btq f3779d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    btu(btq btq, String str, Object[] objArr, int i, List list) {
        super(str, objArr);
        this.f3779d = btq;
        this.f3777a = i;
        this.f3778c = list;
    }

    /* renamed from: d */
    public void mo3342d() {
        if (this.f3779d.f3751u.mo3653a(this.f3777a, (List<bue>) this.f3778c)) {
            try {
                this.f3779d.f3741i.mo3510a(this.f3777a, btn.CANCEL);
                synchronized (this.f3779d) {
                    this.f3779d.f3754y.remove(Integer.valueOf(this.f3777a));
                }
            } catch (IOException unused) {
            }
        }
    }
}
