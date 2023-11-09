package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lu */
public class C0634lu extends C0552jb.C0555c {

    /* renamed from: d */
    private final C0560jd.C0563c f5233d;

    /* renamed from: e */
    private final C0477gr f5234e;

    public C0634lu(C0560jd.C0563c cVar, C0477gr grVar) {
        this.f5233d = cVar;
        this.f5234e = grVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5006b() {
        boolean z;
        if (this.f5233d.hasNext()) {
            C0477gr grVar = this.f5234e;
            long longValue = this.f5233d.next().longValue();
            this.f5044a = longValue;
            if (grVar.mo4929a(longValue)) {
                z = true;
                this.f5045b = z;
            }
        }
        z = false;
        this.f5045b = z;
    }
}
