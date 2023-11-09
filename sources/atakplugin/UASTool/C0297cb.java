package atakplugin.UASTool;

import atakplugin.UASTool.C0496hg;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.cb */
public class C0297cb<T> {

    /* renamed from: a */
    private static final C0297cb<?> f4464a = new C0297cb<>();

    /* renamed from: b */
    private final T f4465b;

    /* renamed from: a */
    public static <T> C0297cb<T> m11067a(T t) {
        return new C0297cb<>(t);
    }

    /* renamed from: b */
    public static <T> C0297cb<T> m11068b(T t) {
        return t == null ? m11066a() : m11067a(t);
    }

    /* renamed from: a */
    public static <T> C0297cb<T> m11066a() {
        return f4464a;
    }

    private C0297cb() {
        this.f4465b = null;
    }

    private C0297cb(T t) {
        this.f4465b = C0293ca.m10962b(t);
    }

    /* renamed from: b */
    public T mo4387b() {
        return mo4396f();
    }

    /* renamed from: c */
    public boolean mo4392c() {
        return this.f4465b != null;
    }

    /* renamed from: d */
    public boolean mo4393d() {
        return this.f4465b == null;
    }

    /* renamed from: a */
    public void mo4382a(C0363dn<? super T> dnVar) {
        T t = this.f4465b;
        if (t != null) {
            dnVar.mo838a(t);
        }
    }

    /* renamed from: a */
    public void mo4383a(C0363dn<? super T> dnVar, Runnable runnable) {
        T t = this.f4465b;
        if (t != null) {
            dnVar.mo838a(t);
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    public C0297cb<T> mo4384b(C0363dn<? super T> dnVar) {
        mo4382a(dnVar);
        return this;
    }

    /* renamed from: a */
    public C0297cb<T> mo4376a(Runnable runnable) {
        if (this.f4465b == null) {
            runnable.run();
        }
        return this;
    }

    /* renamed from: a */
    public <R> R mo4381a(C0391ei<C0297cb<T>, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: a */
    public C0297cb<T> mo4373a(C0496hg<? super T> hgVar) {
        if (!mo4392c()) {
            return this;
        }
        return hgVar.test(this.f4465b) ? this : m11066a();
    }

    /* renamed from: b */
    public C0297cb<T> mo4386b(C0496hg<? super T> hgVar) {
        return mo4373a(C0496hg.C0497a.m12242a(hgVar));
    }

    /* renamed from: b */
    public <U> C0297cb<U> mo4385b(C0391ei<? super T, ? extends U> eiVar) {
        if (!mo4392c()) {
            return m11066a();
        }
        return m11068b(eiVar.apply(this.f4465b));
    }

    /* renamed from: a */
    public C0310ce mo4379a(C0528ij<? super T> ijVar) {
        if (!mo4392c()) {
            return C0310ce.m11490a();
        }
        return C0310ce.m11491a(ijVar.mo3457a(this.f4465b));
    }

    /* renamed from: a */
    public C0314cf mo4380a(C0529ik<? super T> ikVar) {
        if (!mo4392c()) {
            return C0314cf.m11534a();
        }
        return C0314cf.m11535a(ikVar.mo4135a(this.f4465b));
    }

    /* renamed from: a */
    public C0301cd mo4378a(C0527ii<? super T> iiVar) {
        if (!mo4392c()) {
            return C0301cd.m11322a();
        }
        return C0301cd.m11323a(iiVar.mo2737a(this.f4465b));
    }

    /* renamed from: a */
    public C0299cc mo4377a(C0526ih<? super T> ihVar) {
        if (!mo4392c()) {
            return C0299cc.m11211a();
        }
        return C0299cc.m11213a(ihVar.mo4953a(this.f4465b));
    }

    /* renamed from: c */
    public <U> C0297cb<U> mo4389c(C0391ei<? super T, C0297cb<U>> eiVar) {
        if (!mo4392c()) {
            return m11066a();
        }
        return (C0297cb) C0293ca.m10962b(eiVar.apply(this.f4465b));
    }

    /* renamed from: e */
    public C0325cn<T> mo4394e() {
        if (!mo4392c()) {
            return C0325cn.m11776a();
        }
        return C0325cn.m11790a((T[]) new Object[]{this.f4465b});
    }

    /* renamed from: a */
    public <R> C0297cb<R> mo4375a(Class<R> cls) {
        C0293ca.m10962b(cls);
        if (!mo4392c()) {
            return m11066a();
        }
        return m11068b(cls.isInstance(this.f4465b) ? this.f4465b : null);
    }

    /* renamed from: a */
    public C0297cb<T> mo4374a(C0506hp<C0297cb<T>> hpVar) {
        if (mo4392c()) {
            return this;
        }
        C0293ca.m10962b(hpVar);
        return (C0297cb) C0293ca.m10962b(hpVar.mo107b());
    }

    /* renamed from: c */
    public T mo4391c(T t) {
        T t2 = this.f4465b;
        return t2 != null ? t2 : t;
    }

    /* renamed from: b */
    public T mo4388b(C0506hp<? extends T> hpVar) {
        T t = this.f4465b;
        return t != null ? t : hpVar.mo107b();
    }

    /* renamed from: f */
    public T mo4396f() {
        T t = this.f4465b;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: c */
    public <X extends Throwable> T mo4390c(C0506hp<? extends X> hpVar) {
        T t = this.f4465b;
        if (t != null) {
            return t;
        }
        throw ((Throwable) hpVar.mo107b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0297cb)) {
            return false;
        }
        return C0293ca.m10961a((Object) this.f4465b, (Object) ((C0297cb) obj).f4465b);
    }

    public int hashCode() {
        return C0293ca.m10955a((Object) this.f4465b);
    }

    public String toString() {
        T t = this.f4465b;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
