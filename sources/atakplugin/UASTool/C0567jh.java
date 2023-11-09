package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.jh */
public class C0567jh extends C0560jd.C0561a {

    /* renamed from: a */
    private final C0560jd.C0561a f5063a;

    /* renamed from: b */
    private final C0375dw f5064b;

    /* renamed from: c */
    private boolean f5065c;

    /* renamed from: d */
    private boolean f5066d;

    /* renamed from: e */
    private double f5067e;

    public C0567jh(C0560jd.C0561a aVar, C0375dw dwVar) {
        this.f5063a = aVar;
        this.f5064b = dwVar;
    }

    public boolean hasNext() {
        if (!this.f5066d) {
            m12359b();
            this.f5066d = true;
        }
        return this.f5065c;
    }

    /* renamed from: a */
    public double mo2515a() {
        if (!this.f5066d) {
            this.f5065c = hasNext();
        }
        if (this.f5065c) {
            this.f5066d = false;
            return this.f5067e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private void m12359b() {
        while (this.f5063a.hasNext()) {
            double a = this.f5063a.mo2515a();
            this.f5067e = a;
            if (this.f5064b.mo4901a(a)) {
                this.f5065c = true;
                return;
            }
        }
        this.f5065c = false;
    }
}
