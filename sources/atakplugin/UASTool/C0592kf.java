package atakplugin.UASTool;

import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.kf */
public class C0592kf extends C0560jd.C0562b {

    /* renamed from: a */
    private final C0556jc.C0558b f5129a;

    /* renamed from: b */
    private final C0426fg f5130b;

    /* renamed from: c */
    private boolean f5131c;

    /* renamed from: d */
    private boolean f5132d;

    /* renamed from: e */
    private int f5133e;

    public C0592kf(C0556jc.C0558b bVar, C0426fg fgVar) {
        this.f5129a = bVar;
        this.f5130b = fgVar;
    }

    public boolean hasNext() {
        if (!this.f5132d) {
            m12389b();
            this.f5132d = true;
        }
        return this.f5131c;
    }

    /* renamed from: a */
    public int mo2940a() {
        if (!this.f5132d) {
            this.f5131c = hasNext();
        }
        if (this.f5131c) {
            this.f5132d = false;
            return this.f5133e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private void m12389b() {
        while (this.f5129a.hasNext()) {
            int b = this.f5129a.mo5010b();
            int intValue = this.f5129a.next().intValue();
            this.f5133e = intValue;
            if (this.f5130b.mo4915a(b, intValue)) {
                this.f5131c = true;
                return;
            }
        }
        this.f5131c = false;
    }
}
