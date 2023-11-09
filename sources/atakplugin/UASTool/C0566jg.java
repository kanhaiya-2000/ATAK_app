package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jg */
public class C0566jg extends C0552jb.C0553a {

    /* renamed from: d */
    private final C0560jd.C0561a f5061d;

    /* renamed from: e */
    private final C0375dw f5062e;

    public C0566jg(C0560jd.C0561a aVar, C0375dw dwVar) {
        this.f5061d = aVar;
        this.f5062e = dwVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5002b() {
        if (!this.f5040c) {
            do {
                boolean hasNext = this.f5061d.hasNext();
                this.f5039b = hasNext;
                if (hasNext) {
                    this.f5038a = this.f5061d.next().doubleValue();
                }
            } while (this.f5062e.mo4901a(this.f5038a));
            return;
        }
        this.f5039b = this.f5039b && this.f5061d.hasNext();
        if (this.f5039b) {
            this.f5038a = this.f5061d.next().doubleValue();
        }
    }
}
