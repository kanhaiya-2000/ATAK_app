package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ll */
public class C0625ll<R> extends C0551ja<R> {

    /* renamed from: a */
    private final C0560jd.C0563c f5211a;

    /* renamed from: b */
    private final C0474gp<? extends R> f5212b;

    public C0625ll(C0560jd.C0563c cVar, C0474gp<? extends R> gpVar) {
        this.f5211a = cVar;
        this.f5212b = gpVar;
    }

    public boolean hasNext() {
        return this.f5211a.hasNext();
    }

    /* renamed from: a */
    public R mo4999a() {
        return this.f5212b.mo4928a(this.f5211a.mo3698a());
    }
}
