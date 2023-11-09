package atakplugin.UASTool;

import atakplugin.UASTool.C0477gr;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.cf */
public final class C0314cf {

    /* renamed from: a */
    private static final C0314cf f4605a = new C0314cf();

    /* renamed from: b */
    private final boolean f4606b;

    /* renamed from: c */
    private final long f4607c;

    /* renamed from: a */
    public static C0314cf m11534a() {
        return f4605a;
    }

    /* renamed from: a */
    public static C0314cf m11535a(long j) {
        return new C0314cf(j);
    }

    /* renamed from: a */
    public static C0314cf m11536a(Long l) {
        return l == null ? f4605a : new C0314cf(l.longValue());
    }

    private C0314cf() {
        this.f4606b = false;
        this.f4607c = 0;
    }

    private C0314cf(long j) {
        this.f4606b = true;
        this.f4607c = j;
    }

    /* renamed from: b */
    public long mo4610b() {
        return mo4619f();
    }

    /* renamed from: c */
    public boolean mo4615c() {
        return this.f4606b;
    }

    /* renamed from: d */
    public boolean mo4616d() {
        return !this.f4606b;
    }

    /* renamed from: a */
    public void mo4608a(C0470gm gmVar) {
        if (this.f4606b) {
            gmVar.mo4927a(this.f4607c);
        }
    }

    /* renamed from: a */
    public void mo4609a(C0470gm gmVar, Runnable runnable) {
        if (this.f4606b) {
            gmVar.mo4927a(this.f4607c);
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    public C0314cf mo4613b(C0470gm gmVar) {
        mo4608a(gmVar);
        return this;
    }

    /* renamed from: a */
    public C0314cf mo4606a(Runnable runnable) {
        if (!mo4615c()) {
            runnable.run();
        }
        return this;
    }

    /* renamed from: a */
    public <R> R mo4607a(C0391ei<C0314cf, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: a */
    public C0314cf mo4603a(C0477gr grVar) {
        if (!mo4615c()) {
            return this;
        }
        return grVar.mo4929a(this.f4607c) ? this : m11534a();
    }

    /* renamed from: b */
    public C0314cf mo4614b(C0477gr grVar) {
        return mo4603a(C0477gr.C0478a.m12217a(grVar));
    }

    /* renamed from: a */
    public C0314cf mo4604a(C0490hb hbVar) {
        if (!mo4615c()) {
            return m11534a();
        }
        C0293ca.m10962b(hbVar);
        return m11535a(hbVar.mo4933a(this.f4607c));
    }

    /* renamed from: a */
    public <U> C0297cb<U> mo4601a(C0474gp<U> gpVar) {
        if (!mo4615c()) {
            return C0297cb.m11066a();
        }
        C0293ca.m10962b(gpVar);
        return C0297cb.m11068b(gpVar.mo4928a(this.f4607c));
    }

    /* renamed from: a */
    public C0310ce mo4602a(C0489ha haVar) {
        if (!mo4615c()) {
            return C0310ce.m11490a();
        }
        C0293ca.m10962b(haVar);
        return C0310ce.m11491a(haVar.mo4932a(this.f4607c));
    }

    /* renamed from: e */
    public C0245bu mo4617e() {
        if (!mo4615c()) {
            return C0245bu.m9453a();
        }
        return C0245bu.m9454a(this.f4607c);
    }

    /* renamed from: a */
    public C0314cf mo4605a(C0506hp<C0314cf> hpVar) {
        if (mo4615c()) {
            return this;
        }
        C0293ca.m10962b(hpVar);
        return (C0314cf) C0293ca.m10962b(hpVar.mo107b());
    }

    /* renamed from: b */
    public long mo4611b(long j) {
        return this.f4606b ? this.f4607c : j;
    }

    /* renamed from: a */
    public long mo4600a(C0484gx gxVar) {
        return this.f4606b ? this.f4607c : gxVar.mo4673a();
    }

    /* renamed from: f */
    public long mo4619f() {
        if (this.f4606b) {
            return this.f4607c;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: b */
    public <X extends Throwable> long mo4612b(C0506hp<X> hpVar) {
        if (this.f4606b) {
            return this.f4607c;
        }
        throw ((Throwable) hpVar.mo107b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0314cf)) {
            return false;
        }
        C0314cf cfVar = (C0314cf) obj;
        boolean z = this.f4606b;
        if (!z || !cfVar.f4606b) {
            if (z == cfVar.f4606b) {
                return true;
            }
        } else if (this.f4607c == cfVar.f4607c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f4606b) {
            return C0293ca.m10955a((Object) Long.valueOf(this.f4607c));
        }
        return 0;
    }

    public String toString() {
        if (!this.f4606b) {
            return "OptionalLong.empty";
        }
        return String.format("OptionalLong[%s]", new Object[]{Long.valueOf(this.f4607c)});
    }
}
