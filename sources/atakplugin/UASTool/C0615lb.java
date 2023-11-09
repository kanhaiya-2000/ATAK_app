package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.lb */
public class C0615lb extends C0560jd.C0563c {

    /* renamed from: a */
    private final C0560jd.C0563c f5183a;

    /* renamed from: b */
    private final C0477gr f5184b;

    /* renamed from: c */
    private boolean f5185c;

    /* renamed from: d */
    private boolean f5186d;

    /* renamed from: e */
    private long f5187e;

    public C0615lb(C0560jd.C0563c cVar, C0477gr grVar) {
        this.f5183a = cVar;
        this.f5184b = grVar;
    }

    public boolean hasNext() {
        if (!this.f5186d) {
            m12413b();
            this.f5186d = true;
        }
        return this.f5185c;
    }

    /* renamed from: a */
    public long mo3698a() {
        if (!this.f5186d) {
            this.f5185c = hasNext();
        }
        if (this.f5185c) {
            this.f5186d = false;
            return this.f5187e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private void m12413b() {
        while (this.f5183a.hasNext()) {
            long a = this.f5183a.mo3698a();
            this.f5187e = a;
            if (this.f5184b.mo4929a(a)) {
                this.f5185c = true;
                return;
            }
        }
        this.f5185c = false;
    }
}
