package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lo */
public class C0628lo extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0560jd.C0563c f5218a;

    /* renamed from: b */
    private final int f5219b;

    public C0628lo(C0560jd.C0563c cVar, int i) {
        this.f5218a = cVar;
        this.f5219b = i;
    }

    public boolean hasNext() {
        return this.f5218a.hasNext();
    }

    /* renamed from: a */
    public long mo3698a() {
        long a = this.f5218a.mo3698a();
        for (int i = 1; i < this.f5219b && this.f5218a.hasNext(); i++) {
            this.f5218a.mo3698a();
        }
        return a;
    }
}
