package atakplugin.UASTool;

import atakplugin.UASTool.C0552jb;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lq */
public class C0630lq extends C0552jb.C0555c {

    /* renamed from: d */
    private final C0560jd.C0563c f5222d;

    /* renamed from: e */
    private final long f5223e;

    /* renamed from: f */
    private final C0469gl f5224f;

    public C0630lq(C0560jd.C0563c cVar, long j, C0469gl glVar) {
        this.f5222d = cVar;
        this.f5223e = j;
        this.f5224f = glVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5006b() {
        if (!this.f5046c) {
            this.f5045b = true;
            this.f5044a = this.f5223e;
            return;
        }
        this.f5045b = this.f5222d.hasNext();
        if (this.f5045b) {
            this.f5044a = this.f5224f.mo3753a(this.f5044a, this.f5222d.next().longValue());
        }
    }
}
