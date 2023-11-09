package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.lr */
public class C0631lr extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0560jd.C0563c f5225a;

    /* renamed from: b */
    private final long f5226b;

    /* renamed from: c */
    private long f5227c = 0;

    public C0631lr(C0560jd.C0563c cVar, long j) {
        this.f5225a = cVar;
        this.f5226b = j;
    }

    public boolean hasNext() {
        while (this.f5225a.hasNext() && this.f5227c != this.f5226b) {
            this.f5225a.mo3698a();
            this.f5227c++;
        }
        return this.f5225a.hasNext();
    }

    /* renamed from: a */
    public long mo3698a() {
        return this.f5225a.mo3698a();
    }
}
