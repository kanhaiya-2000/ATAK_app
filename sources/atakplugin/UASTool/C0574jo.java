package atakplugin.UASTool;

import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jo */
public class C0574jo extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0556jc.C0557a f5085a;

    /* renamed from: b */
    private final C0412ex f5086b;

    public C0574jo(C0556jc.C0557a aVar, C0412ex exVar) {
        this.f5085a = aVar;
        this.f5086b = exVar;
    }

    public boolean hasNext() {
        return this.f5085a.hasNext();
    }

    /* renamed from: a */
    public double mo2515a() {
        return this.f5086b.mo4911a(this.f5085a.mo5008b(), this.f5085a.next().doubleValue());
    }
}
