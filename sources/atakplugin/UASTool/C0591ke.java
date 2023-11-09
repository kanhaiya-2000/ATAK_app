package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.ke */
public class C0591ke extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0560jd.C0562b f5124a;

    /* renamed from: b */
    private final C0453fz f5125b;

    /* renamed from: c */
    private boolean f5126c;

    /* renamed from: d */
    private boolean f5127d;

    /* renamed from: e */
    private int f5128e;

    public C0591ke(C0560jd.C0562b bVar, C0453fz fzVar) {
        this.f5124a = bVar;
        this.f5125b = fzVar;
    }

    public boolean hasNext() {
        if (!this.f5127d) {
            m12387b();
            this.f5127d = true;
        }
        return this.f5126c;
    }

    /* renamed from: a */
    public int mo2940a() {
        if (!this.f5127d) {
            this.f5126c = hasNext();
        }
        if (this.f5126c) {
            this.f5127d = false;
            return this.f5128e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private void m12387b() {
        while (this.f5124a.hasNext()) {
            int a = this.f5124a.mo2940a();
            this.f5128e = a;
            if (this.f5125b.mo4922a(a)) {
                this.f5126c = true;
                return;
            }
        }
        this.f5126c = false;
    }
}
