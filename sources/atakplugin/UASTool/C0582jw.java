package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jw */
public class C0582jw extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0560jd.C0561a f5102a;

    /* renamed from: b */
    private final long f5103b;

    /* renamed from: c */
    private long f5104c = 0;

    public C0582jw(C0560jd.C0561a aVar, long j) {
        this.f5102a = aVar;
        this.f5103b = j;
    }

    public boolean hasNext() {
        while (this.f5102a.hasNext() && this.f5104c != this.f5103b) {
            this.f5102a.mo2515a();
            this.f5104c++;
        }
        return this.f5102a.hasNext();
    }

    /* renamed from: a */
    public double mo2515a() {
        return this.f5102a.mo2515a();
    }
}
