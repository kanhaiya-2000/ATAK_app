package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jr */
public class C0577jr<R> extends C0551ja<R> {

    /* renamed from: a */
    private final C0560jd.C0561a f5091a;

    /* renamed from: b */
    private final C0372du<? extends R> f5092b;

    public C0577jr(C0560jd.C0561a aVar, C0372du<? extends R> duVar) {
        this.f5091a = aVar;
        this.f5092b = duVar;
    }

    public boolean hasNext() {
        return this.f5091a.hasNext();
    }

    /* renamed from: a */
    public R mo4999a() {
        return this.f5092b.mo4900a(this.f5091a.mo2515a());
    }
}
