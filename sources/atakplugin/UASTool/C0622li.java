package atakplugin.UASTool;

import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.li */
public class C0622li extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0556jc.C0559c f5205a;

    /* renamed from: b */
    private final C0439fp f5206b;

    public C0622li(C0556jc.C0559c cVar, C0439fp fpVar) {
        this.f5205a = cVar;
        this.f5206b = fpVar;
    }

    public boolean hasNext() {
        return this.f5205a.hasNext();
    }

    /* renamed from: a */
    public long mo3698a() {
        return this.f5206b.mo4919a(this.f5205a.mo5012b(), this.f5205a.next().longValue());
    }
}
