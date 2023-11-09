package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ku */
public class C0607ku extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0560jd.C0562b f5166a;

    /* renamed from: b */
    private final long f5167b;

    /* renamed from: c */
    private long f5168c = 0;

    public C0607ku(C0560jd.C0562b bVar, long j) {
        this.f5166a = bVar;
        this.f5167b = j;
    }

    public boolean hasNext() {
        while (this.f5166a.hasNext() && this.f5168c != this.f5167b) {
            this.f5166a.mo2940a();
            this.f5168c++;
        }
        return this.f5166a.hasNext();
    }

    /* renamed from: a */
    public int mo2940a() {
        return this.f5166a.mo2940a();
    }
}
