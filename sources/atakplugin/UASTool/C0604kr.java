package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kr */
public class C0604kr extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0560jd.C0562b f5159a;

    /* renamed from: b */
    private final int f5160b;

    public C0604kr(C0560jd.C0562b bVar, int i) {
        this.f5159a = bVar;
        this.f5160b = i;
    }

    public boolean hasNext() {
        return this.f5159a.hasNext();
    }

    /* renamed from: a */
    public int mo2940a() {
        int a = this.f5159a.mo2940a();
        for (int i = 1; i < this.f5160b && this.f5159a.hasNext(); i++) {
            this.f5159a.mo2940a();
        }
        return a;
    }
}
