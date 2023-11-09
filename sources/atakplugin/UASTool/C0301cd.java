package atakplugin.UASTool;

import atakplugin.UASTool.C0375dw;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.cd */
public final class C0301cd {

    /* renamed from: a */
    private static final C0301cd f4511a = new C0301cd();

    /* renamed from: b */
    private final boolean f4512b;

    /* renamed from: c */
    private final double f4513c;

    /* renamed from: a */
    public static C0301cd m11322a() {
        return f4511a;
    }

    /* renamed from: a */
    public static C0301cd m11323a(double d) {
        return new C0301cd(d);
    }

    /* renamed from: a */
    public static C0301cd m11324a(Double d) {
        return d == null ? f4511a : new C0301cd(d.doubleValue());
    }

    private C0301cd() {
        this.f4512b = false;
        this.f4513c = 0.0d;
    }

    private C0301cd(double d) {
        this.f4512b = true;
        this.f4513c = d;
    }

    /* renamed from: b */
    public double mo4486b() {
        return mo4495f();
    }

    /* renamed from: c */
    public boolean mo4491c() {
        return this.f4512b;
    }

    /* renamed from: d */
    public boolean mo4492d() {
        return !this.f4512b;
    }

    /* renamed from: a */
    public void mo4484a(C0368dr drVar) {
        if (this.f4512b) {
            drVar.mo4899a(this.f4513c);
        }
    }

    /* renamed from: a */
    public void mo4485a(C0368dr drVar, Runnable runnable) {
        if (this.f4512b) {
            drVar.mo4899a(this.f4513c);
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    public C0301cd mo4489b(C0368dr drVar) {
        mo4484a(drVar);
        return this;
    }

    /* renamed from: a */
    public C0301cd mo4480a(Runnable runnable) {
        if (!mo4491c()) {
            runnable.run();
        }
        return this;
    }

    /* renamed from: a */
    public <R> R mo4483a(C0391ei<C0301cd, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: a */
    public C0301cd mo4477a(C0375dw dwVar) {
        if (!mo4491c()) {
            return this;
        }
        return dwVar.mo4901a(this.f4513c) ? this : m11322a();
    }

    /* renamed from: b */
    public C0301cd mo4490b(C0375dw dwVar) {
        return mo4477a(C0375dw.C0376a.m12090a(dwVar));
    }

    /* renamed from: a */
    public C0301cd mo4478a(C0388eg egVar) {
        if (!mo4491c()) {
            return m11322a();
        }
        C0293ca.m10962b(egVar);
        return m11323a(egVar.mo4905a(this.f4513c));
    }

    /* renamed from: a */
    public <U> C0297cb<U> mo4476a(C0372du<U> duVar) {
        if (!mo4491c()) {
            return C0297cb.m11066a();
        }
        C0293ca.m10962b(duVar);
        return C0297cb.m11068b(duVar.mo4900a(this.f4513c));
    }

    /* renamed from: a */
    public C0310ce mo4481a(C0386ee eeVar) {
        if (!mo4491c()) {
            return C0310ce.m11490a();
        }
        C0293ca.m10962b(eeVar);
        return C0310ce.m11491a(eeVar.mo4903a(this.f4513c));
    }

    /* renamed from: a */
    public C0314cf mo4482a(C0387ef efVar) {
        if (!mo4491c()) {
            return C0314cf.m11534a();
        }
        C0293ca.m10962b(efVar);
        return C0314cf.m11535a(efVar.mo4904a(this.f4513c));
    }

    /* renamed from: e */
    public C0150bg mo4493e() {
        if (!mo4491c()) {
            return C0150bg.m6604a();
        }
        return C0150bg.m6605a(this.f4513c);
    }

    /* renamed from: a */
    public C0301cd mo4479a(C0506hp<C0301cd> hpVar) {
        if (mo4491c()) {
            return this;
        }
        C0293ca.m10962b(hpVar);
        return (C0301cd) C0293ca.m10962b(hpVar.mo107b());
    }

    /* renamed from: b */
    public double mo4487b(double d) {
        return this.f4512b ? this.f4513c : d;
    }

    /* renamed from: a */
    public double mo4475a(C0383ec ecVar) {
        return this.f4512b ? this.f4513c : ecVar.mo4686a();
    }

    /* renamed from: f */
    public double mo4495f() {
        if (this.f4512b) {
            return this.f4513c;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: b */
    public <X extends Throwable> double mo4488b(C0506hp<X> hpVar) {
        if (this.f4512b) {
            return this.f4513c;
        }
        throw ((Throwable) hpVar.mo107b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0301cd)) {
            return false;
        }
        C0301cd cdVar = (C0301cd) obj;
        boolean z = this.f4512b;
        if (!z || !cdVar.f4512b) {
            if (z == cdVar.f4512b) {
                return true;
            }
        } else if (Double.compare(this.f4513c, cdVar.f4513c) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f4512b) {
            return C0293ca.m10955a((Object) Double.valueOf(this.f4513c));
        }
        return 0;
    }

    public String toString() {
        if (!this.f4512b) {
            return "OptionalDouble.empty";
        }
        return String.format("OptionalDouble[%s]", new Object[]{Double.valueOf(this.f4513c)});
    }
}
