package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jz */
public class C0585jz extends C0552jb.C0553a {

    /* renamed from: d */
    private final C0560jd.C0561a f5110d;

    /* renamed from: e */
    private final C0375dw f5111e;

    public C0585jz(C0560jd.C0561a aVar, C0375dw dwVar) {
        this.f5110d = aVar;
        this.f5111e = dwVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5002b() {
        boolean z;
        if (this.f5110d.hasNext()) {
            C0375dw dwVar = this.f5111e;
            double doubleValue = this.f5110d.next().doubleValue();
            this.f5038a = doubleValue;
            if (dwVar.mo4901a(doubleValue)) {
                z = true;
                this.f5039b = z;
            }
        }
        z = false;
        this.f5039b = z;
    }
}
