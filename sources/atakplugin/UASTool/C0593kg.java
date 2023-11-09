package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.kg */
public class C0593kg extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0560jd.C0562b f5134a;

    /* renamed from: b */
    private final C0450fx<? extends C0206bo> f5135b;

    /* renamed from: c */
    private C0560jd.C0562b f5136c;

    /* renamed from: d */
    private C0206bo f5137d;

    public C0593kg(C0560jd.C0562b bVar, C0450fx<? extends C0206bo> fxVar) {
        this.f5134a = bVar;
        this.f5135b = fxVar;
    }

    public boolean hasNext() {
        C0560jd.C0562b bVar = this.f5136c;
        if (bVar != null && bVar.hasNext()) {
            return true;
        }
        while (this.f5134a.hasNext()) {
            C0206bo boVar = this.f5137d;
            if (boVar != null) {
                boVar.close();
                this.f5137d = null;
            }
            C0206bo boVar2 = (C0206bo) this.f5135b.mo4892b(this.f5134a.mo2940a());
            if (boVar2 != null) {
                this.f5137d = boVar2;
                if (boVar2.mo2907b().hasNext()) {
                    this.f5136c = boVar2.mo2907b();
                    return true;
                }
            }
        }
        C0206bo boVar3 = this.f5137d;
        if (boVar3 == null) {
            return false;
        }
        boVar3.close();
        this.f5137d = null;
        return false;
    }

    /* renamed from: a */
    public int mo2940a() {
        C0560jd.C0562b bVar = this.f5136c;
        if (bVar != null) {
            return bVar.mo2940a();
        }
        throw new NoSuchElementException();
    }
}
