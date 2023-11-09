package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jm */
public class C0572jm extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0560jd.C0561a f5080a;

    /* renamed from: b */
    private final long f5081b;

    /* renamed from: c */
    private long f5082c = 0;

    public C0572jm(C0560jd.C0561a aVar, long j) {
        this.f5080a = aVar;
        this.f5081b = j;
    }

    public boolean hasNext() {
        return this.f5082c < this.f5081b && this.f5080a.hasNext();
    }

    /* renamed from: a */
    public double mo2515a() {
        this.f5082c++;
        return this.f5080a.mo2515a();
    }
}
