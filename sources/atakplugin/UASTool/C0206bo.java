package atakplugin.UASTool;

import atakplugin.UASTool.C0453fz;
import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;
import java.io.Closeable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.bo */
public final class C0206bo implements Closeable {

    /* renamed from: a */
    private static final C0206bo f3039a = new C0206bo(new C0207bp());

    /* renamed from: d */
    private static final C0528ij<Integer> f3040d = new C0240bt();

    /* renamed from: b */
    private final C0560jd.C0562b f3041b;

    /* renamed from: c */
    private final C0538is f3042c;

    /* renamed from: a */
    public static C0206bo m7862a() {
        return f3039a;
    }

    /* renamed from: a */
    public static C0206bo m7869a(C0560jd.C0562b bVar) {
        C0293ca.m10962b(bVar);
        return new C0206bo(bVar);
    }

    /* renamed from: a */
    public static C0206bo m7871a(int... iArr) {
        C0293ca.m10962b(iArr);
        if (iArr.length == 0) {
            return m7862a();
        }
        return new C0206bo(new C0587ka(iArr));
    }

    /* renamed from: a */
    public static C0206bo m7863a(int i) {
        return new C0206bo(new C0587ka(new int[]{i}));
    }

    /* renamed from: a */
    public static C0206bo m7870a(CharSequence charSequence) {
        return new C0206bo(new C0588kb(charSequence));
    }

    /* renamed from: a */
    public static C0206bo m7864a(int i, int i2) {
        if (i >= i2) {
            return m7862a();
        }
        return m7872b(i, i2 - 1);
    }

    /* renamed from: b */
    public static C0206bo m7872b(int i, int i2) {
        if (i > i2) {
            return m7862a();
        }
        if (i == i2) {
            return m7863a(i);
        }
        return new C0206bo(new C0603kq(i, i2));
    }

    /* renamed from: a */
    public static C0206bo m7868a(C0461gf gfVar) {
        C0293ca.m10962b(gfVar);
        return new C0206bo(new C0594kh(gfVar));
    }

    /* renamed from: a */
    public static C0206bo m7866a(int i, C0466gj gjVar) {
        C0293ca.m10962b(gjVar);
        return new C0206bo(new C0595ki(i, gjVar));
    }

    /* renamed from: a */
    public static C0206bo m7865a(int i, C0453fz fzVar, C0466gj gjVar) {
        C0293ca.m10962b(fzVar);
        return m7866a(i, gjVar).mo2909c(fzVar);
    }

    /* renamed from: a */
    public static C0206bo m7867a(C0206bo boVar, C0206bo boVar2) {
        C0293ca.m10962b(boVar);
        C0293ca.m10962b(boVar2);
        return new C0206bo(new C0589kc(boVar.f3041b, boVar2.f3041b)).mo2893a(C0534io.m12280a((Closeable) boVar, (Closeable) boVar2));
    }

    private C0206bo(C0560jd.C0562b bVar) {
        this((C0538is) null, bVar);
    }

    C0206bo(C0538is isVar, C0560jd.C0562b bVar) {
        this.f3042c = isVar;
        this.f3041b = bVar;
    }

    /* renamed from: b */
    public C0560jd.C0562b mo2907b() {
        return this.f3041b;
    }

    /* renamed from: a */
    public <R> R mo2897a(C0391ei<C0206bo, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: c */
    public C0325cn<Integer> mo2911c() {
        return new C0325cn<>(this.f3042c, this.f3041b);
    }

    /* renamed from: a */
    public C0206bo mo2891a(C0453fz fzVar) {
        return new C0206bo(this.f3042c, new C0591ke(this.f3041b, fzVar));
    }

    /* renamed from: a */
    public C0206bo mo2888a(C0426fg fgVar) {
        return mo2884a(0, 1, fgVar);
    }

    /* renamed from: a */
    public C0206bo mo2884a(int i, int i2, C0426fg fgVar) {
        return new C0206bo(this.f3042c, new C0592kf(new C0556jc.C0558b(i, i2, this.f3041b), fgVar));
    }

    /* renamed from: b */
    public C0206bo mo2906b(C0453fz fzVar) {
        return mo2891a(C0453fz.C0454a.m12183a(fzVar));
    }

    /* renamed from: a */
    public C0206bo mo2892a(C0466gj gjVar) {
        return new C0206bo(this.f3042c, new C0597kk(this.f3041b, gjVar));
    }

    /* renamed from: a */
    public C0206bo mo2889a(C0445ft ftVar) {
        return mo2885a(0, 1, ftVar);
    }

    /* renamed from: a */
    public C0206bo mo2885a(int i, int i2, C0445ft ftVar) {
        return new C0206bo(this.f3042c, new C0598kl(new C0556jc.C0558b(i, i2, this.f3041b), ftVar));
    }

    /* renamed from: a */
    public <R> C0325cn<R> mo2896a(C0450fx<? extends R> fxVar) {
        return new C0325cn<>(this.f3042c, new C0601ko(this.f3041b, fxVar));
    }

    /* renamed from: a */
    public C0245bu mo2895a(C0465gi giVar) {
        return new C0245bu(this.f3042c, new C0600kn(this.f3041b, giVar));
    }

    /* renamed from: a */
    public C0150bg mo2883a(C0464gh ghVar) {
        return new C0150bg(this.f3042c, new C0599km(this.f3041b, ghVar));
    }

    /* renamed from: b */
    public C0206bo mo2905b(C0450fx<? extends C0206bo> fxVar) {
        return new C0206bo(this.f3042c, new C0593kg(this.f3041b, fxVar));
    }

    /* renamed from: d */
    public C0206bo mo2913d() {
        return mo2911c().mo4770f().mo4715a(f3040d);
    }

    /* renamed from: e */
    public C0206bo mo2915e() {
        return new C0206bo(this.f3042c, new C0608kv(this.f3041b));
    }

    /* renamed from: a */
    public C0206bo mo2894a(Comparator<Integer> comparator) {
        return mo2911c().mo4729a(comparator).mo4715a(f3040d);
    }

    /* renamed from: b */
    public C0206bo mo2902b(int i) {
        if (i > 0) {
            return i == 1 ? this : new C0206bo(this.f3042c, new C0604kr(this.f3041b, i));
        }
        throw new IllegalArgumentException("stepWidth cannot be zero or negative");
    }

    /* renamed from: a */
    public C0206bo mo2890a(C0446fu fuVar) {
        return new C0206bo(this.f3042c, new C0602kp(this.f3041b, fuVar));
    }

    /* renamed from: b */
    public C0206bo mo2904b(C0445ft ftVar) {
        C0293ca.m10962b(ftVar);
        return new C0206bo(this.f3042c, new C0605ks(this.f3041b, ftVar));
    }

    /* renamed from: a */
    public C0206bo mo2886a(int i, C0445ft ftVar) {
        C0293ca.m10962b(ftVar);
        return new C0206bo(this.f3042c, new C0606kt(this.f3041b, i, ftVar));
    }

    /* renamed from: c */
    public C0206bo mo2909c(C0453fz fzVar) {
        return new C0206bo(this.f3042c, new C0610kx(this.f3041b, fzVar));
    }

    /* renamed from: d */
    public C0206bo mo2914d(C0453fz fzVar) {
        return new C0206bo(this.f3042c, new C0609kw(this.f3041b, fzVar));
    }

    /* renamed from: e */
    public C0206bo mo2916e(C0453fz fzVar) {
        return new C0206bo(this.f3042c, new C0590kd(this.f3041b, fzVar));
    }

    /* renamed from: a */
    public C0206bo mo2887a(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (i == 0) {
            return m7862a();
        } else {
            return new C0206bo(this.f3042c, new C0596kj(this.f3041b, j));
        }
    }

    /* renamed from: b */
    public C0206bo mo2903b(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : new C0206bo(this.f3042c, new C0607ku(this.f3041b, j));
        }
        throw new IllegalArgumentException("n cannot be negative");
    }

    /* renamed from: b */
    public void mo2908b(C0446fu fuVar) {
        while (this.f3041b.hasNext()) {
            fuVar.mo4921a(this.f3041b.mo2940a());
        }
    }

    /* renamed from: a */
    public void mo2900a(C0419fb fbVar) {
        mo2899a(0, 1, fbVar);
    }

    /* renamed from: a */
    public void mo2899a(int i, int i2, C0419fb fbVar) {
        while (this.f3041b.hasNext()) {
            fbVar.mo4913a(i, this.f3041b.mo2940a());
            i += i2;
        }
    }

    /* renamed from: b */
    public int mo2901b(int i, C0445ft ftVar) {
        while (this.f3041b.hasNext()) {
            i = ftVar.mo2977a(i, this.f3041b.mo2940a());
        }
        return i;
    }

    /* renamed from: c */
    public C0310ce mo2910c(C0445ft ftVar) {
        boolean z = false;
        int i = 0;
        while (this.f3041b.hasNext()) {
            int a = this.f3041b.mo2940a();
            if (!z) {
                z = true;
                i = a;
            } else {
                i = ftVar.mo2977a(i, a);
            }
        }
        return z ? C0310ce.m11491a(i) : C0310ce.m11490a();
    }

    /* renamed from: f */
    public int[] mo2918f() {
        return C0537ir.m12284a(this.f3041b);
    }

    /* renamed from: a */
    public <R> R mo2898a(C0506hp<R> hpVar, C0494he<R> heVar) {
        R b = hpVar.mo107b();
        while (this.f3041b.hasNext()) {
            heVar.mo4935a(b, this.f3041b.mo2940a());
        }
        return b;
    }

    /* renamed from: g */
    public int mo2919g() {
        int i = 0;
        while (this.f3041b.hasNext()) {
            i += this.f3041b.mo2940a();
        }
        return i;
    }

    /* renamed from: h */
    public C0310ce mo2921h() {
        return mo2910c((C0445ft) new C0211bq(this));
    }

    /* renamed from: i */
    public C0310ce mo2923i() {
        return mo2910c((C0445ft) new C0221br(this));
    }

    /* renamed from: j */
    public long mo2924j() {
        long j = 0;
        while (this.f3041b.hasNext()) {
            this.f3041b.mo2940a();
            j++;
        }
        return j;
    }

    /* renamed from: f */
    public boolean mo2917f(C0453fz fzVar) {
        while (this.f3041b.hasNext()) {
            if (fzVar.mo4922a(this.f3041b.mo2940a())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo2920g(C0453fz fzVar) {
        while (this.f3041b.hasNext()) {
            if (!fzVar.mo4922a(this.f3041b.mo2940a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public boolean mo2922h(C0453fz fzVar) {
        while (this.f3041b.hasNext()) {
            if (fzVar.mo4922a(this.f3041b.mo2940a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public C0310ce mo2925k() {
        if (this.f3041b.hasNext()) {
            return C0310ce.m11491a(this.f3041b.mo2940a());
        }
        return C0310ce.m11490a();
    }

    /* renamed from: l */
    public C0310ce mo2926l() {
        return mo2910c((C0445ft) new C0233bs(this));
    }

    /* renamed from: m */
    public int mo2927m() {
        if (this.f3041b.hasNext()) {
            int a = this.f3041b.mo2940a();
            if (!this.f3041b.hasNext()) {
                return a;
            }
            throw new IllegalStateException("IntStream contains more than one element");
        }
        throw new NoSuchElementException("IntStream contains no element");
    }

    /* renamed from: n */
    public C0310ce mo2928n() {
        if (!this.f3041b.hasNext()) {
            return C0310ce.m11490a();
        }
        int a = this.f3041b.mo2940a();
        if (!this.f3041b.hasNext()) {
            return C0310ce.m11491a(a);
        }
        throw new IllegalStateException("IntStream contains more than one element");
    }

    /* renamed from: a */
    public C0206bo mo2893a(Runnable runnable) {
        C0293ca.m10962b(runnable);
        C0538is isVar = this.f3042c;
        if (isVar == null) {
            isVar = new C0538is();
            isVar.f5012a = runnable;
        } else {
            isVar.f5012a = C0534io.m12281a(isVar.f5012a, runnable);
        }
        return new C0206bo(isVar, this.f3041b);
    }

    public void close() {
        C0538is isVar = this.f3042c;
        if (isVar != null && isVar.f5012a != null) {
            this.f3042c.f5012a.run();
            this.f3042c.f5012a = null;
        }
    }
}
