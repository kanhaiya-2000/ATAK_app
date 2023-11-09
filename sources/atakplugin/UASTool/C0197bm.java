package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.bm */
public class C0197bm<T> {

    /* renamed from: a */
    private final T f2881a;

    /* renamed from: b */
    private final Throwable f2882b;

    /* renamed from: a */
    public static <T> C0197bm<T> m7636a(C0525ig<T, Throwable> igVar) {
        try {
            return new C0197bm<>(igVar.mo4952a(), (Throwable) null);
        } catch (Throwable th) {
            return m7637a(th);
        }
    }

    /* renamed from: a */
    public static <T> C0197bm<T> m7637a(Throwable th) {
        return new C0197bm<>((Object) null, th);
    }

    private C0197bm(T t, Throwable th) {
        this.f2881a = t;
        this.f2882b = th;
    }

    /* renamed from: a */
    public T mo2752a() {
        return this.f2881a;
    }

    /* renamed from: b */
    public boolean mo2761b() {
        return this.f2882b == null;
    }

    /* renamed from: a */
    public T mo2755a(T t) {
        return this.f2882b == null ? this.f2881a : t;
    }

    /* renamed from: a */
    public T mo2754a(C0506hp<? extends T> hpVar) {
        return this.f2882b == null ? this.f2881a : hpVar.mo107b();
    }

    /* renamed from: c */
    public C0297cb<T> mo2762c() {
        return C0297cb.m11068b(this.f2881a);
    }

    /* renamed from: d */
    public Throwable mo2763d() {
        return this.f2882b;
    }

    /* renamed from: e */
    public T mo2764e() {
        Throwable th = this.f2882b;
        if (th == null) {
            return this.f2881a;
        }
        throw th;
    }

    /* renamed from: f */
    public T mo2766f() {
        if (this.f2882b == null) {
            return this.f2881a;
        }
        throw new RuntimeException(this.f2882b);
    }

    /* renamed from: b */
    public <E extends Throwable> T mo2760b(E e) {
        Throwable th = this.f2882b;
        if (th == null) {
            return this.f2881a;
        }
        e.initCause(th);
        throw e;
    }

    /* renamed from: b */
    public C0197bm<T> mo2758b(C0506hp<C0197bm<T>> hpVar) {
        if (this.f2882b == null) {
            return this;
        }
        C0293ca.m10962b(hpVar);
        return (C0197bm) C0293ca.m10962b(hpVar.mo107b());
    }

    /* renamed from: a */
    public <R> R mo2753a(C0391ei<C0197bm<T>, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: a */
    public <U> C0197bm<U> mo2750a(C0514hw<? super T, ? extends U, Throwable> hwVar) {
        Throwable th = this.f2882b;
        if (th != null) {
            return m7637a(th);
        }
        C0293ca.m10962b(hwVar);
        try {
            return new C0197bm<>(hwVar.mo4942a(this.f2881a), (Throwable) null);
        } catch (Throwable th2) {
            return m7637a(th2);
        }
    }

    /* renamed from: a */
    public C0197bm<T> mo2749a(C0363dn<? super T> dnVar) {
        if (this.f2882b == null) {
            dnVar.mo838a(this.f2881a);
        }
        return this;
    }

    /* renamed from: b */
    public C0197bm<T> mo2756b(C0363dn<Throwable> dnVar) {
        Throwable th = this.f2882b;
        if (th != null) {
            dnVar.mo838a(th);
        }
        return this;
    }

    /* renamed from: a */
    public <E extends Throwable> C0197bm<T> mo2751a(Class<E> cls, C0363dn<? super E> dnVar) {
        Throwable th = this.f2882b;
        if (th != null && cls.isAssignableFrom(th.getClass())) {
            dnVar.mo838a(this.f2882b);
        }
        return this;
    }

    /* renamed from: b */
    public C0197bm<T> mo2759b(C0514hw<Throwable, ? extends T, Throwable> hwVar) {
        if (this.f2882b == null) {
            return this;
        }
        C0293ca.m10962b(hwVar);
        try {
            return new C0197bm<>(hwVar.mo4942a(this.f2882b), (Throwable) null);
        } catch (Throwable th) {
            return m7637a(th);
        }
    }

    /* renamed from: b */
    public C0197bm<T> mo2757b(C0391ei<Throwable, ? extends C0197bm<T>> eiVar) {
        if (this.f2882b == null) {
            return this;
        }
        C0293ca.m10962b(eiVar);
        return (C0197bm) C0293ca.m10962b(eiVar.apply(this.f2882b));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0197bm)) {
            return false;
        }
        C0197bm bmVar = (C0197bm) obj;
        if (!C0293ca.m10961a((Object) this.f2881a, (Object) bmVar.f2881a) || !C0293ca.m10961a((Object) this.f2882b, (Object) bmVar.f2882b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C0293ca.m10957a(this.f2881a, this.f2882b);
    }

    public String toString() {
        Throwable th = this.f2882b;
        if (th == null) {
            return String.format("Exceptional value %s", new Object[]{this.f2881a});
        }
        return String.format("Exceptional throwable %s", new Object[]{th});
    }
}
