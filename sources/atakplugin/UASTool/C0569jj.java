package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.jj */
public class C0569jj extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0560jd.C0561a f5073a;

    /* renamed from: b */
    private final C0372du<? extends C0150bg> f5074b;

    /* renamed from: c */
    private C0560jd.C0561a f5075c;

    /* renamed from: d */
    private C0150bg f5076d;

    public C0569jj(C0560jd.C0561a aVar, C0372du<? extends C0150bg> duVar) {
        this.f5073a = aVar;
        this.f5074b = duVar;
    }

    public boolean hasNext() {
        C0560jd.C0561a aVar = this.f5075c;
        if (aVar != null && aVar.hasNext()) {
            return true;
        }
        while (this.f5073a.hasNext()) {
            C0150bg bgVar = this.f5076d;
            if (bgVar != null) {
                bgVar.close();
                this.f5076d = null;
            }
            C0150bg bgVar2 = (C0150bg) this.f5074b.mo4900a(this.f5073a.mo2515a());
            if (bgVar2 != null) {
                this.f5076d = bgVar2;
                if (bgVar2.mo2432b().hasNext()) {
                    this.f5075c = bgVar2.mo2432b();
                    return true;
                }
            }
        }
        C0150bg bgVar3 = this.f5076d;
        if (bgVar3 == null) {
            return false;
        }
        bgVar3.close();
        this.f5076d = null;
        return false;
    }

    /* renamed from: a */
    public double mo2515a() {
        C0560jd.C0561a aVar = this.f5075c;
        if (aVar != null) {
            return aVar.mo2515a();
        }
        throw new NoSuchElementException();
    }
}
