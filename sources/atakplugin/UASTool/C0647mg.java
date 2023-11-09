package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mg */
public class C0647mg<T> extends C0552jb.C0554b {

    /* renamed from: d */
    private final Iterator<? extends T> f5271d;

    /* renamed from: e */
    private final C0391ei<? super T, ? extends C0206bo> f5272e;

    /* renamed from: f */
    private C0560jd.C0562b f5273f;

    public C0647mg(Iterator<? extends T> it, C0391ei<? super T, ? extends C0206bo> eiVar) {
        this.f5271d = it;
        this.f5272e = eiVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5004b() {
        C0560jd.C0562b bVar = this.f5273f;
        if (bVar == null || !bVar.hasNext()) {
            while (this.f5271d.hasNext()) {
                C0560jd.C0562b bVar2 = this.f5273f;
                if (bVar2 == null || !bVar2.hasNext()) {
                    C0206bo boVar = (C0206bo) this.f5272e.apply(this.f5271d.next());
                    if (boVar != null) {
                        this.f5273f = boVar.mo2907b();
                    }
                }
                C0560jd.C0562b bVar3 = this.f5273f;
                if (bVar3 != null && bVar3.hasNext()) {
                    this.f5041a = this.f5273f.next().intValue();
                    this.f5042b = true;
                    return;
                }
            }
            this.f5042b = false;
            return;
        }
        this.f5041a = this.f5273f.next().intValue();
        this.f5042b = true;
    }
}
