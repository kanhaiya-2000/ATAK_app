package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ko */
public class C0601ko<R> extends C0551ja<R> {

    /* renamed from: a */
    private final C0560jd.C0562b f5152a;

    /* renamed from: b */
    private final C0450fx<? extends R> f5153b;

    public C0601ko(C0560jd.C0562b bVar, C0450fx<? extends R> fxVar) {
        this.f5152a = bVar;
        this.f5153b = fxVar;
    }

    public boolean hasNext() {
        return this.f5152a.hasNext();
    }

    /* renamed from: a */
    public R mo4999a() {
        return this.f5153b.mo4892b(this.f5152a.mo2940a());
    }
}
