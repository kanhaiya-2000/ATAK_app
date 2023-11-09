package atakplugin.UASTool;

import atakplugin.UASTool.C0355dg;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.cc */
public final class C0299cc {

    /* renamed from: a */
    private static final C0299cc f4479a = new C0299cc();

    /* renamed from: b */
    private static final C0299cc f4480b = new C0299cc(true);

    /* renamed from: c */
    private static final C0299cc f4481c = new C0299cc(false);

    /* renamed from: d */
    private final boolean f4482d;

    /* renamed from: e */
    private final boolean f4483e;

    /* renamed from: a */
    public static C0299cc m11211a() {
        return f4479a;
    }

    /* renamed from: a */
    public static C0299cc m11213a(boolean z) {
        return z ? f4480b : f4481c;
    }

    /* renamed from: a */
    public static C0299cc m11212a(Boolean bool) {
        return bool == null ? f4479a : m11213a(bool.booleanValue());
    }

    private C0299cc() {
        this.f4482d = false;
        this.f4483e = false;
    }

    private C0299cc(boolean z) {
        this.f4482d = true;
        this.f4483e = z;
    }

    /* renamed from: b */
    public boolean mo4431b() {
        return mo4437e();
    }

    /* renamed from: c */
    public boolean mo4435c() {
        return this.f4482d;
    }

    /* renamed from: d */
    public boolean mo4436d() {
        return !this.f4482d;
    }

    /* renamed from: a */
    public void mo4426a(C0351dd ddVar) {
        if (this.f4482d) {
            ddVar.mo4895a(this.f4483e);
        }
    }

    /* renamed from: a */
    public void mo4427a(C0351dd ddVar, Runnable runnable) {
        if (this.f4482d) {
            ddVar.mo4895a(this.f4483e);
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    public C0299cc mo4429b(C0351dd ddVar) {
        mo4426a(ddVar);
        return this;
    }

    /* renamed from: a */
    public C0299cc mo4424a(Runnable runnable) {
        if (!mo4435c()) {
            runnable.run();
        }
        return this;
    }

    /* renamed from: a */
    public <R> R mo4425a(C0391ei<C0299cc, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: a */
    public C0299cc mo4422a(C0355dg dgVar) {
        if (!mo4435c()) {
            return this;
        }
        return dgVar.mo4897a(this.f4483e) ? this : m11211a();
    }

    /* renamed from: b */
    public C0299cc mo4430b(C0355dg dgVar) {
        return mo4422a(C0355dg.C0356a.m12062a(dgVar));
    }

    /* renamed from: c */
    public C0299cc mo4434c(C0355dg dgVar) {
        if (!mo4435c()) {
            return m11211a();
        }
        C0293ca.m10962b(dgVar);
        return m11213a(dgVar.mo4897a(this.f4483e));
    }

    /* renamed from: a */
    public <U> C0297cb<U> mo4421a(C0354df<U> dfVar) {
        if (!mo4435c()) {
            return C0297cb.m11066a();
        }
        C0293ca.m10962b(dfVar);
        return C0297cb.m11068b(dfVar.mo4896a(this.f4483e));
    }

    /* renamed from: a */
    public C0299cc mo4423a(C0506hp<C0299cc> hpVar) {
        if (mo4435c()) {
            return this;
        }
        C0293ca.m10962b(hpVar);
        return (C0299cc) C0293ca.m10962b(hpVar.mo107b());
    }

    /* renamed from: b */
    public boolean mo4433b(boolean z) {
        return this.f4482d ? this.f4483e : z;
    }

    /* renamed from: a */
    public boolean mo4428a(C0362dm dmVar) {
        return this.f4482d ? this.f4483e : dmVar.mo4898a();
    }

    /* renamed from: e */
    public boolean mo4437e() {
        if (this.f4482d) {
            return this.f4483e;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: b */
    public <X extends Throwable> boolean mo4432b(C0506hp<X> hpVar) {
        if (this.f4482d) {
            return this.f4483e;
        }
        throw ((Throwable) hpVar.mo107b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0299cc)) {
            return false;
        }
        C0299cc ccVar = (C0299cc) obj;
        boolean z = this.f4482d;
        if (!z || !ccVar.f4482d) {
            if (z == ccVar.f4482d) {
                return true;
            }
        } else if (this.f4483e == ccVar.f4483e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f4482d) {
            return this.f4483e ? 1231 : 1237;
        }
        return 0;
    }

    public String toString() {
        if (this.f4482d) {
            return this.f4483e ? "OptionalBoolean[true]" : "OptionalBoolean[false]";
        }
        return "OptionalBoolean.empty";
    }
}
