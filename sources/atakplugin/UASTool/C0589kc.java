package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kc */
public class C0589kc extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0560jd.C0562b f5119a;

    /* renamed from: b */
    private final C0560jd.C0562b f5120b;

    /* renamed from: c */
    private boolean f5121c = true;

    public C0589kc(C0560jd.C0562b bVar, C0560jd.C0562b bVar2) {
        this.f5119a = bVar;
        this.f5120b = bVar2;
    }

    public boolean hasNext() {
        if (this.f5121c) {
            if (this.f5119a.hasNext()) {
                return true;
            }
            this.f5121c = false;
        }
        return this.f5120b.hasNext();
    }

    /* renamed from: a */
    public int mo2940a() {
        return (this.f5121c ? this.f5119a : this.f5120b).mo2940a();
    }
}
