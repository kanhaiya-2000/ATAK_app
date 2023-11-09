package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.la */
public class C0614la extends C0552jb.C0555c {

    /* renamed from: d */
    private final C0560jd.C0563c f5181d;

    /* renamed from: e */
    private final C0477gr f5182e;

    public C0614la(C0560jd.C0563c cVar, C0477gr grVar) {
        this.f5181d = cVar;
        this.f5182e = grVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5006b() {
        if (!this.f5046c) {
            do {
                boolean hasNext = this.f5181d.hasNext();
                this.f5045b = hasNext;
                if (hasNext) {
                    this.f5044a = this.f5181d.next().longValue();
                }
            } while (this.f5182e.mo4929a(this.f5044a));
            return;
        }
        this.f5045b = this.f5045b && this.f5181d.hasNext();
        if (this.f5045b) {
            this.f5044a = this.f5181d.next().longValue();
        }
    }
}
