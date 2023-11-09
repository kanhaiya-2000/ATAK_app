package atakplugin.UASTool;

import atakplugin.UASTool.C0375dw;
import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;
import java.io.Closeable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.bg */
public final class C0150bg implements Closeable {

    /* renamed from: a */
    private static final C0150bg f2634a = new C0150bg(new C0160bh());

    /* renamed from: d */
    private static final C0527ii<Double> f2635d = new C0196bl();

    /* renamed from: b */
    private final C0560jd.C0561a f2636b;

    /* renamed from: c */
    private final C0538is f2637c;

    /* renamed from: a */
    public static C0150bg m6604a() {
        return f2634a;
    }

    /* renamed from: a */
    public static C0150bg m6610a(C0560jd.C0561a aVar) {
        C0293ca.m10962b(aVar);
        return new C0150bg(aVar);
    }

    /* renamed from: a */
    public static C0150bg m6611a(double... dArr) {
        C0293ca.m10962b(dArr);
        if (dArr.length == 0) {
            return m6604a();
        }
        return new C0150bg(new C0564je(dArr));
    }

    /* renamed from: a */
    public static C0150bg m6605a(double d) {
        return new C0150bg(new C0564je(new double[]{d}));
    }

    /* renamed from: a */
    public static C0150bg m6609a(C0383ec ecVar) {
        C0293ca.m10962b(ecVar);
        return new C0150bg(new C0570jk(ecVar));
    }

    /* renamed from: a */
    public static C0150bg m6607a(double d, C0388eg egVar) {
        C0293ca.m10962b(egVar);
        return new C0150bg(new C0571jl(d, egVar));
    }

    /* renamed from: a */
    public static C0150bg m6606a(double d, C0375dw dwVar, C0388eg egVar) {
        C0293ca.m10962b(dwVar);
        return m6607a(d, egVar).mo2434c(dwVar);
    }

    /* renamed from: a */
    public static C0150bg m6608a(C0150bg bgVar, C0150bg bgVar2) {
        C0293ca.m10962b(bgVar);
        C0293ca.m10962b(bgVar2);
        return new C0150bg(new C0565jf(bgVar.f2636b, bgVar2.f2636b)).mo2418a(C0534io.m12280a((Closeable) bgVar, (Closeable) bgVar2));
    }

    private C0150bg(C0560jd.C0561a aVar) {
        this((C0538is) null, aVar);
    }

    C0150bg(C0538is isVar, C0560jd.C0561a aVar) {
        this.f2637c = isVar;
        this.f2636b = aVar;
    }

    /* renamed from: b */
    public C0560jd.C0561a mo2432b() {
        return this.f2636b;
    }

    /* renamed from: a */
    public <R> R mo2423a(C0391ei<C0150bg, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: c */
    public C0325cn<Double> mo2435c() {
        return new C0325cn<>(this.f2637c, this.f2636b);
    }

    /* renamed from: a */
    public C0150bg mo2414a(C0375dw dwVar) {
        return new C0150bg(this.f2637c, new C0567jh(this.f2636b, dwVar));
    }

    /* renamed from: a */
    public C0150bg mo2416a(C0409ev evVar) {
        return mo2409a(0, 1, evVar);
    }

    /* renamed from: a */
    public C0150bg mo2409a(int i, int i2, C0409ev evVar) {
        return new C0150bg(this.f2637c, new C0568ji(new C0556jc.C0557a(i, i2, this.f2636b), evVar));
    }

    /* renamed from: b */
    public C0150bg mo2430b(C0375dw dwVar) {
        return mo2414a(C0375dw.C0376a.m12090a(dwVar));
    }

    /* renamed from: a */
    public C0150bg mo2415a(C0388eg egVar) {
        return new C0150bg(this.f2637c, new C0573jn(this.f2636b, egVar));
    }

    /* renamed from: a */
    public C0150bg mo2417a(C0412ex exVar) {
        return mo2410a(0, 1, exVar);
    }

    /* renamed from: a */
    public C0150bg mo2410a(int i, int i2, C0412ex exVar) {
        return new C0150bg(this.f2637c, new C0574jo(new C0556jc.C0557a(i, i2, this.f2636b), exVar));
    }

    /* renamed from: a */
    public <R> C0325cn<R> mo2422a(C0372du<? extends R> duVar) {
        return new C0325cn<>(this.f2637c, new C0577jr(this.f2636b, duVar));
    }

    /* renamed from: a */
    public C0206bo mo2420a(C0386ee eeVar) {
        return new C0206bo(this.f2637c, new C0575jp(this.f2636b, eeVar));
    }

    /* renamed from: a */
    public C0245bu mo2421a(C0387ef efVar) {
        return new C0245bu(this.f2637c, new C0576jq(this.f2636b, efVar));
    }

    /* renamed from: b */
    public C0150bg mo2429b(C0372du<? extends C0150bg> duVar) {
        return new C0150bg(this.f2637c, new C0569jj(this.f2636b, duVar));
    }

    /* renamed from: d */
    public C0150bg mo2437d() {
        return mo2435c().mo4770f().mo4714a(f2635d);
    }

    /* renamed from: e */
    public C0150bg mo2439e() {
        return new C0150bg(this.f2637c, new C0583jx(this.f2636b));
    }

    /* renamed from: a */
    public C0150bg mo2419a(Comparator<Double> comparator) {
        return mo2435c().mo4729a(comparator).mo4714a(f2635d);
    }

    /* renamed from: a */
    public C0150bg mo2408a(int i) {
        if (i > 0) {
            return i == 1 ? this : new C0150bg(this.f2637c, new C0579jt(this.f2636b, i));
        }
        throw new IllegalArgumentException("stepWidth cannot be zero or negative");
    }

    /* renamed from: a */
    public C0150bg mo2413a(C0368dr drVar) {
        return new C0150bg(this.f2637c, new C0578js(this.f2636b, drVar));
    }

    /* renamed from: a */
    public C0150bg mo2412a(C0367dq dqVar) {
        C0293ca.m10962b(dqVar);
        return new C0150bg(this.f2637c, new C0580ju(this.f2636b, dqVar));
    }

    /* renamed from: a */
    public C0150bg mo2407a(double d, C0367dq dqVar) {
        C0293ca.m10962b(dqVar);
        return new C0150bg(this.f2637c, new C0581jv(this.f2636b, d, dqVar));
    }

    /* renamed from: c */
    public C0150bg mo2434c(C0375dw dwVar) {
        return new C0150bg(this.f2637c, new C0585jz(this.f2636b, dwVar));
    }

    /* renamed from: d */
    public C0150bg mo2438d(C0375dw dwVar) {
        return new C0150bg(this.f2637c, new C0584jy(this.f2636b, dwVar));
    }

    /* renamed from: e */
    public C0150bg mo2440e(C0375dw dwVar) {
        return new C0150bg(this.f2637c, new C0566jg(this.f2636b, dwVar));
    }

    /* renamed from: a */
    public C0150bg mo2411a(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (i == 0) {
            return m6604a();
        } else {
            return new C0150bg(this.f2637c, new C0572jm(this.f2636b, j));
        }
    }

    /* renamed from: b */
    public C0150bg mo2428b(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : new C0150bg(this.f2637c, new C0582jw(this.f2636b, j));
        }
        throw new IllegalArgumentException("n cannot be negative");
    }

    /* renamed from: b */
    public void mo2433b(C0368dr drVar) {
        while (this.f2636b.hasNext()) {
            drVar.mo4899a(this.f2636b.mo2515a());
        }
    }

    /* renamed from: a */
    public void mo2426a(C0402eq eqVar) {
        mo2425a(0, 1, eqVar);
    }

    /* renamed from: a */
    public void mo2425a(int i, int i2, C0402eq eqVar) {
        while (this.f2636b.hasNext()) {
            eqVar.mo4908a(i, this.f2636b.mo2515a());
            i += i2;
        }
    }

    /* renamed from: b */
    public double mo2427b(double d, C0367dq dqVar) {
        while (this.f2636b.hasNext()) {
            d = dqVar.mo2546a(d, this.f2636b.mo2515a());
        }
        return d;
    }

    /* renamed from: b */
    public C0301cd mo2431b(C0367dq dqVar) {
        boolean z = false;
        double d = 0.0d;
        while (this.f2636b.hasNext()) {
            double a = this.f2636b.mo2515a();
            if (!z) {
                z = true;
                d = a;
            } else {
                d = dqVar.mo2546a(d, a);
            }
        }
        return z ? C0301cd.m11323a(d) : C0301cd.m11322a();
    }

    /* renamed from: f */
    public double[] mo2442f() {
        return C0537ir.m12283a(this.f2636b);
    }

    /* renamed from: a */
    public <R> R mo2424a(C0506hp<R> hpVar, C0493hd<R> hdVar) {
        R b = hpVar.mo107b();
        while (this.f2636b.hasNext()) {
            hdVar.mo4934a(b, this.f2636b.mo2515a());
        }
        return b;
    }

    /* renamed from: g */
    public double mo2443g() {
        double d = 0.0d;
        while (this.f2636b.hasNext()) {
            d += this.f2636b.mo2515a();
        }
        return d;
    }

    /* renamed from: h */
    public C0301cd mo2445h() {
        return mo2431b((C0367dq) new C0162bi(this));
    }

    /* renamed from: i */
    public C0301cd mo2447i() {
        return mo2431b((C0367dq) new C0174bj(this));
    }

    /* renamed from: j */
    public long mo2448j() {
        long j = 0;
        while (this.f2636b.hasNext()) {
            this.f2636b.mo2515a();
            j++;
        }
        return j;
    }

    /* renamed from: k */
    public C0301cd mo2449k() {
        double d = 0.0d;
        long j = 0;
        while (this.f2636b.hasNext()) {
            d += this.f2636b.mo2515a();
            j++;
        }
        if (j == 0) {
            return C0301cd.m11322a();
        }
        return C0301cd.m11323a(d / ((double) j));
    }

    /* renamed from: f */
    public boolean mo2441f(C0375dw dwVar) {
        while (this.f2636b.hasNext()) {
            if (dwVar.mo4901a(this.f2636b.mo2515a())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo2444g(C0375dw dwVar) {
        while (this.f2636b.hasNext()) {
            if (!dwVar.mo4901a(this.f2636b.mo2515a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public boolean mo2446h(C0375dw dwVar) {
        while (this.f2636b.hasNext()) {
            if (dwVar.mo4901a(this.f2636b.mo2515a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: l */
    public C0301cd mo2450l() {
        if (this.f2636b.hasNext()) {
            return C0301cd.m11323a(this.f2636b.mo2515a());
        }
        return C0301cd.m11322a();
    }

    /* renamed from: m */
    public C0301cd mo2451m() {
        return mo2431b((C0367dq) new C0195bk(this));
    }

    /* renamed from: n */
    public double mo2452n() {
        if (this.f2636b.hasNext()) {
            double a = this.f2636b.mo2515a();
            if (!this.f2636b.hasNext()) {
                return a;
            }
            throw new IllegalStateException("DoubleStream contains more than one element");
        }
        throw new NoSuchElementException("DoubleStream contains no element");
    }

    /* renamed from: o */
    public C0301cd mo2453o() {
        if (!this.f2636b.hasNext()) {
            return C0301cd.m11322a();
        }
        double a = this.f2636b.mo2515a();
        if (!this.f2636b.hasNext()) {
            return C0301cd.m11323a(a);
        }
        throw new IllegalStateException("DoubleStream contains more than one element");
    }

    /* renamed from: a */
    public C0150bg mo2418a(Runnable runnable) {
        C0293ca.m10962b(runnable);
        C0538is isVar = this.f2637c;
        if (isVar == null) {
            isVar = new C0538is();
            isVar.f5012a = runnable;
        } else {
            isVar.f5012a = C0534io.m12281a(isVar.f5012a, runnable);
        }
        return new C0150bg(isVar, this.f2636b);
    }

    public void close() {
        C0538is isVar = this.f2637c;
        if (isVar != null && isVar.f5012a != null) {
            this.f2637c.f5012a.run();
            this.f2637c.f5012a = null;
        }
    }
}
