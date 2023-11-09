package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mf */
public class C0646mf<T> extends C0552jb.C0553a {

    /* renamed from: d */
    private final Iterator<? extends T> f5268d;

    /* renamed from: e */
    private final C0391ei<? super T, ? extends C0150bg> f5269e;

    /* renamed from: f */
    private C0560jd.C0561a f5270f;

    public C0646mf(Iterator<? extends T> it, C0391ei<? super T, ? extends C0150bg> eiVar) {
        this.f5268d = it;
        this.f5269e = eiVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5002b() {
        C0560jd.C0561a aVar = this.f5270f;
        if (aVar == null || !aVar.hasNext()) {
            while (this.f5268d.hasNext()) {
                C0560jd.C0561a aVar2 = this.f5270f;
                if (aVar2 == null || !aVar2.hasNext()) {
                    C0150bg bgVar = (C0150bg) this.f5269e.apply(this.f5268d.next());
                    if (bgVar != null) {
                        this.f5270f = bgVar.mo2432b();
                    }
                }
                C0560jd.C0561a aVar3 = this.f5270f;
                if (aVar3 != null && aVar3.hasNext()) {
                    this.f5038a = this.f5270f.next().doubleValue();
                    this.f5039b = true;
                    return;
                }
            }
            this.f5039b = false;
            return;
        }
        this.f5038a = this.f5270f.next().doubleValue();
        this.f5039b = true;
    }
}
