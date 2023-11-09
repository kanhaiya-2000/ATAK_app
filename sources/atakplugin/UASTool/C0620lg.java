package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lg */
public class C0620lg extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0560jd.C0563c f5200a;

    /* renamed from: b */
    private final long f5201b;

    /* renamed from: c */
    private long f5202c = 0;

    public C0620lg(C0560jd.C0563c cVar, long j) {
        this.f5200a = cVar;
        this.f5201b = j;
    }

    public boolean hasNext() {
        return this.f5202c < this.f5201b && this.f5200a.hasNext();
    }

    /* renamed from: a */
    public long mo3698a() {
        this.f5202c++;
        return this.f5200a.mo3698a();
    }
}
