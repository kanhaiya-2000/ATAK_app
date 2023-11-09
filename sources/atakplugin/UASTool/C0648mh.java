package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mh */
public class C0648mh<T> extends C0552jb.C0555c {

    /* renamed from: d */
    private final Iterator<? extends T> f5274d;

    /* renamed from: e */
    private final C0391ei<? super T, ? extends C0245bu> f5275e;

    /* renamed from: f */
    private C0560jd.C0563c f5276f;

    public C0648mh(Iterator<? extends T> it, C0391ei<? super T, ? extends C0245bu> eiVar) {
        this.f5274d = it;
        this.f5275e = eiVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5006b() {
        C0560jd.C0563c cVar = this.f5276f;
        if (cVar == null || !cVar.hasNext()) {
            while (this.f5274d.hasNext()) {
                C0560jd.C0563c cVar2 = this.f5276f;
                if (cVar2 == null || !cVar2.hasNext()) {
                    C0245bu buVar = (C0245bu) this.f5275e.apply(this.f5274d.next());
                    if (buVar != null) {
                        this.f5276f = buVar.mo3571b();
                    }
                }
                C0560jd.C0563c cVar3 = this.f5276f;
                if (cVar3 != null && cVar3.hasNext()) {
                    this.f5044a = this.f5276f.next().longValue();
                    this.f5045b = true;
                    return;
                }
            }
            this.f5045b = false;
            return;
        }
        this.f5044a = this.f5276f.next().longValue();
        this.f5045b = true;
    }
}
