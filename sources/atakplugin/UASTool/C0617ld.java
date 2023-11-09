package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.ld */
public class C0617ld extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0560jd.C0563c f5193a;

    /* renamed from: b */
    private final C0474gp<? extends C0245bu> f5194b;

    /* renamed from: c */
    private C0560jd.C0563c f5195c;

    /* renamed from: d */
    private C0245bu f5196d;

    public C0617ld(C0560jd.C0563c cVar, C0474gp<? extends C0245bu> gpVar) {
        this.f5193a = cVar;
        this.f5194b = gpVar;
    }

    public boolean hasNext() {
        C0560jd.C0563c cVar = this.f5195c;
        if (cVar != null && cVar.hasNext()) {
            return true;
        }
        while (this.f5193a.hasNext()) {
            C0245bu buVar = this.f5196d;
            if (buVar != null) {
                buVar.close();
                this.f5196d = null;
            }
            C0245bu buVar2 = (C0245bu) this.f5194b.mo4928a(this.f5193a.mo3698a());
            if (buVar2 != null) {
                this.f5196d = buVar2;
                if (buVar2.mo3571b().hasNext()) {
                    this.f5195c = buVar2.mo3571b();
                    return true;
                }
            }
        }
        C0245bu buVar3 = this.f5196d;
        if (buVar3 == null) {
            return false;
        }
        buVar3.close();
        this.f5196d = null;
        return false;
    }

    /* renamed from: a */
    public long mo3698a() {
        C0560jd.C0563c cVar = this.f5195c;
        if (cVar != null) {
            return cVar.mo3698a();
        }
        throw new NoSuchElementException();
    }
}
