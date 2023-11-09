package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.kz */
public class C0612kz extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0560jd.C0563c f5178a;

    /* renamed from: b */
    private final C0560jd.C0563c f5179b;

    /* renamed from: c */
    private boolean f5180c = true;

    public C0612kz(C0560jd.C0563c cVar, C0560jd.C0563c cVar2) {
        this.f5178a = cVar;
        this.f5179b = cVar2;
    }

    public boolean hasNext() {
        if (this.f5180c) {
            if (this.f5178a.hasNext()) {
                return true;
            }
            this.f5180c = false;
        }
        return this.f5179b.hasNext();
    }

    /* renamed from: a */
    public long mo3698a() {
        return (this.f5180c ? this.f5178a : this.f5179b).mo3698a();
    }
}
