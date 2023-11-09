package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kj */
public class C0596kj extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0560jd.C0562b f5141a;

    /* renamed from: b */
    private final long f5142b;

    /* renamed from: c */
    private long f5143c = 0;

    public C0596kj(C0560jd.C0562b bVar, long j) {
        this.f5141a = bVar;
        this.f5142b = j;
    }

    public boolean hasNext() {
        return this.f5143c < this.f5142b && this.f5141a.hasNext();
    }

    /* renamed from: a */
    public int mo2940a() {
        this.f5143c++;
        return this.f5141a.mo2940a();
    }
}
