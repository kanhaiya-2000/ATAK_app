package atakplugin.UASTool;

import atakplugin.UASTool.C0453fz;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.ce */
public final class C0310ce {

    /* renamed from: a */
    private static final C0310ce f4580a = new C0310ce();

    /* renamed from: b */
    private final boolean f4581b;

    /* renamed from: c */
    private final int f4582c;

    private C0310ce() {
        this.f4581b = false;
        this.f4582c = 0;
    }

    /* renamed from: a */
    public static C0310ce m11490a() {
        return f4580a;
    }

    private C0310ce(int i) {
        this.f4581b = true;
        this.f4582c = i;
    }

    /* renamed from: a */
    public static C0310ce m11491a(int i) {
        return new C0310ce(i);
    }

    /* renamed from: a */
    public static C0310ce m11492a(Integer num) {
        return num == null ? f4580a : new C0310ce(num.intValue());
    }

    /* renamed from: b */
    public int mo4576b() {
        return mo4585f();
    }

    /* renamed from: c */
    public boolean mo4581c() {
        return this.f4581b;
    }

    /* renamed from: d */
    public boolean mo4582d() {
        return !this.f4581b;
    }

    /* renamed from: a */
    public void mo4574a(C0446fu fuVar) {
        if (this.f4581b) {
            fuVar.mo4921a(this.f4582c);
        }
    }

    /* renamed from: a */
    public void mo4575a(C0446fu fuVar, Runnable runnable) {
        if (this.f4581b) {
            fuVar.mo4921a(this.f4582c);
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    public C0310ce mo4579b(C0446fu fuVar) {
        mo4574a(fuVar);
        return this;
    }

    /* renamed from: a */
    public C0310ce mo4571a(Runnable runnable) {
        if (!mo4581c()) {
            runnable.run();
        }
        return this;
    }

    /* renamed from: a */
    public <R> R mo4573a(C0391ei<C0310ce, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: a */
    public C0310ce mo4568a(C0453fz fzVar) {
        if (!mo4581c()) {
            return this;
        }
        return fzVar.mo4922a(this.f4582c) ? this : m11490a();
    }

    /* renamed from: b */
    public C0310ce mo4580b(C0453fz fzVar) {
        return mo4568a(C0453fz.C0454a.m12183a(fzVar));
    }

    /* renamed from: a */
    public C0310ce mo4569a(C0466gj gjVar) {
        if (!mo4581c()) {
            return m11490a();
        }
        return m11491a(gjVar.mo4926a(this.f4582c));
    }

    /* renamed from: a */
    public <U> C0297cb<U> mo4566a(C0450fx<U> fxVar) {
        if (!mo4581c()) {
            return C0297cb.m11066a();
        }
        return C0297cb.m11068b(fxVar.mo4892b(this.f4582c));
    }

    /* renamed from: a */
    public C0314cf mo4572a(C0465gi giVar) {
        if (!mo4581c()) {
            return C0314cf.m11534a();
        }
        return C0314cf.m11535a(giVar.mo4925a(this.f4582c));
    }

    /* renamed from: a */
    public C0301cd mo4567a(C0464gh ghVar) {
        if (!mo4581c()) {
            return C0301cd.m11322a();
        }
        return C0301cd.m11323a(ghVar.mo4924a(this.f4582c));
    }

    /* renamed from: e */
    public C0206bo mo4583e() {
        if (!mo4581c()) {
            return C0206bo.m7862a();
        }
        return C0206bo.m7863a(this.f4582c);
    }

    /* renamed from: a */
    public C0310ce mo4570a(C0506hp<C0310ce> hpVar) {
        if (mo4581c()) {
            return this;
        }
        C0293ca.m10962b(hpVar);
        return (C0310ce) C0293ca.m10962b(hpVar.mo107b());
    }

    /* renamed from: b */
    public int mo4577b(int i) {
        return this.f4581b ? this.f4582c : i;
    }

    /* renamed from: a */
    public int mo4565a(C0461gf gfVar) {
        return this.f4581b ? this.f4582c : gfVar.mo4662a();
    }

    /* renamed from: f */
    public int mo4585f() {
        if (this.f4581b) {
            return this.f4582c;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: b */
    public <X extends Throwable> int mo4578b(C0506hp<X> hpVar) {
        if (this.f4581b) {
            return this.f4582c;
        }
        throw ((Throwable) hpVar.mo107b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0310ce)) {
            return false;
        }
        C0310ce ceVar = (C0310ce) obj;
        boolean z = this.f4581b;
        if (!z || !ceVar.f4581b) {
            if (z == ceVar.f4581b) {
                return true;
            }
        } else if (this.f4582c == ceVar.f4582c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f4581b) {
            return this.f4582c;
        }
        return 0;
    }

    public String toString() {
        if (!this.f4581b) {
            return "OptionalInt.empty";
        }
        return String.format("OptionalInt[%s]", new Object[]{Integer.valueOf(this.f4582c)});
    }
}
