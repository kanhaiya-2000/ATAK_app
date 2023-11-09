package atakplugin.UASTool;

import atakplugin.UASTool.C0477gr;
import atakplugin.UASTool.C0556jc;
import atakplugin.UASTool.C0560jd;
import java.io.Closeable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.bu */
public final class C0245bu implements Closeable {

    /* renamed from: a */
    private static final C0245bu f3794a = new C0245bu(new C0265bv());

    /* renamed from: d */
    private static final C0529ik<Long> f3795d = new C0289bz();

    /* renamed from: b */
    private final C0560jd.C0563c f3796b;

    /* renamed from: c */
    private final C0538is f3797c;

    /* renamed from: a */
    public static C0245bu m9453a() {
        return f3794a;
    }

    /* renamed from: a */
    public static C0245bu m9460a(C0560jd.C0563c cVar) {
        C0293ca.m10962b(cVar);
        return new C0245bu(cVar);
    }

    /* renamed from: a */
    public static C0245bu m9461a(long... jArr) {
        C0293ca.m10962b(jArr);
        if (jArr.length == 0) {
            return m9453a();
        }
        return new C0245bu(new C0611ky(jArr));
    }

    /* renamed from: a */
    public static C0245bu m9454a(long j) {
        return new C0245bu(new C0611ky(new long[]{j}));
    }

    /* renamed from: a */
    public static C0245bu m9455a(long j, long j2) {
        if (j >= j2) {
            return m9453a();
        }
        return m9462b(j, j2 - 1);
    }

    /* renamed from: b */
    public static C0245bu m9462b(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i > 0) {
            return m9453a();
        }
        if (i == 0) {
            return m9454a(j);
        }
        return new C0245bu(new C0627ln(j, j2));
    }

    /* renamed from: a */
    public static C0245bu m9459a(C0484gx gxVar) {
        C0293ca.m10962b(gxVar);
        return new C0245bu(new C0618le(gxVar));
    }

    /* renamed from: a */
    public static C0245bu m9457a(long j, C0490hb hbVar) {
        C0293ca.m10962b(hbVar);
        return new C0245bu(new C0619lf(j, hbVar));
    }

    /* renamed from: a */
    public static C0245bu m9456a(long j, C0477gr grVar, C0490hb hbVar) {
        C0293ca.m10962b(grVar);
        return m9457a(j, hbVar).mo3574c(grVar);
    }

    /* renamed from: a */
    public static C0245bu m9458a(C0245bu buVar, C0245bu buVar2) {
        C0293ca.m10962b(buVar);
        C0293ca.m10962b(buVar2);
        return new C0245bu(new C0612kz(buVar.f3796b, buVar2.f3796b)).mo3559a(C0534io.m12280a((Closeable) buVar, (Closeable) buVar2));
    }

    private C0245bu(C0560jd.C0563c cVar) {
        this((C0538is) null, cVar);
    }

    C0245bu(C0538is isVar, C0560jd.C0563c cVar) {
        this.f3797c = isVar;
        this.f3796b = cVar;
    }

    /* renamed from: b */
    public C0560jd.C0563c mo3571b() {
        return this.f3796b;
    }

    /* renamed from: a */
    public <R> R mo3562a(C0391ei<C0245bu, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: c */
    public C0325cn<Long> mo3575c() {
        return new C0325cn<>(this.f3797c, this.f3796b);
    }

    /* renamed from: a */
    public C0245bu mo3557a(C0477gr grVar) {
        return new C0245bu(this.f3797c, new C0615lb(this.f3796b, grVar));
    }

    /* renamed from: a */
    public C0245bu mo3553a(C0436fn fnVar) {
        return mo3550a(0, 1, fnVar);
    }

    /* renamed from: a */
    public C0245bu mo3550a(int i, int i2, C0436fn fnVar) {
        return new C0245bu(this.f3797c, new C0616lc(new C0556jc.C0559c(i, i2, this.f3796b), fnVar));
    }

    /* renamed from: b */
    public C0245bu mo3569b(C0477gr grVar) {
        return mo3557a(C0477gr.C0478a.m12217a(grVar));
    }

    /* renamed from: a */
    public C0245bu mo3558a(C0490hb hbVar) {
        return new C0245bu(this.f3797c, new C0621lh(this.f3796b, hbVar));
    }

    /* renamed from: a */
    public C0245bu mo3554a(C0439fp fpVar) {
        return mo3551a(0, 1, fpVar);
    }

    /* renamed from: a */
    public C0245bu mo3551a(int i, int i2, C0439fp fpVar) {
        return new C0245bu(this.f3797c, new C0622li(new C0556jc.C0559c(i, i2, this.f3796b), fpVar));
    }

    /* renamed from: a */
    public <R> C0325cn<R> mo3561a(C0474gp<? extends R> gpVar) {
        return new C0325cn<>(this.f3797c, new C0625ll(this.f3796b, gpVar));
    }

    /* renamed from: a */
    public C0206bo mo3548a(C0489ha haVar) {
        return new C0206bo(this.f3797c, new C0624lk(this.f3796b, haVar));
    }

    /* renamed from: a */
    public C0150bg mo3547a(C0487gz gzVar) {
        return new C0150bg(this.f3797c, new C0623lj(this.f3796b, gzVar));
    }

    /* renamed from: b */
    public C0245bu mo3568b(C0474gp<? extends C0245bu> gpVar) {
        return new C0245bu(this.f3797c, new C0617ld(this.f3796b, gpVar));
    }

    /* renamed from: d */
    public C0245bu mo3577d() {
        return mo3575c().mo4770f().mo4716a(f3795d);
    }

    /* renamed from: e */
    public C0245bu mo3579e() {
        return new C0245bu(this.f3797c, new C0632ls(this.f3796b));
    }

    /* renamed from: a */
    public C0245bu mo3560a(Comparator<Long> comparator) {
        return mo3575c().mo4729a(comparator).mo4716a(f3795d);
    }

    /* renamed from: a */
    public C0245bu mo3549a(int i) {
        if (i > 0) {
            return i == 1 ? this : new C0245bu(this.f3797c, new C0628lo(this.f3796b, i));
        }
        throw new IllegalArgumentException("stepWidth cannot be zero or negative");
    }

    /* renamed from: a */
    public C0245bu mo3556a(C0470gm gmVar) {
        return new C0245bu(this.f3797c, new C0626lm(this.f3796b, gmVar));
    }

    /* renamed from: a */
    public C0245bu mo3555a(C0469gl glVar) {
        C0293ca.m10962b(glVar);
        return new C0245bu(this.f3797c, new C0629lp(this.f3796b, glVar));
    }

    /* renamed from: a */
    public C0245bu mo3552a(long j, C0469gl glVar) {
        C0293ca.m10962b(glVar);
        return new C0245bu(this.f3797c, new C0630lq(this.f3796b, j, glVar));
    }

    /* renamed from: c */
    public C0245bu mo3574c(C0477gr grVar) {
        return new C0245bu(this.f3797c, new C0634lu(this.f3796b, grVar));
    }

    /* renamed from: d */
    public C0245bu mo3578d(C0477gr grVar) {
        return new C0245bu(this.f3797c, new C0633lt(this.f3796b, grVar));
    }

    /* renamed from: e */
    public C0245bu mo3580e(C0477gr grVar) {
        return new C0245bu(this.f3797c, new C0614la(this.f3796b, grVar));
    }

    /* renamed from: b */
    public C0245bu mo3567b(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (i == 0) {
            return m9453a();
        } else {
            return new C0245bu(this.f3797c, new C0620lg(this.f3796b, j));
        }
    }

    /* renamed from: c */
    public C0245bu mo3573c(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : new C0245bu(this.f3797c, new C0631lr(this.f3796b, j));
        }
        throw new IllegalArgumentException("n cannot be negative");
    }

    /* renamed from: b */
    public void mo3572b(C0470gm gmVar) {
        while (this.f3796b.hasNext()) {
            gmVar.mo4927a(this.f3796b.mo3698a());
        }
    }

    /* renamed from: a */
    public void mo3565a(C0429fi fiVar) {
        mo3564a(0, 1, fiVar);
    }

    /* renamed from: a */
    public void mo3564a(int i, int i2, C0429fi fiVar) {
        while (this.f3796b.hasNext()) {
            fiVar.mo4916a(i, this.f3796b.mo3698a());
            i += i2;
        }
    }

    /* renamed from: b */
    public long mo3566b(long j, C0469gl glVar) {
        while (this.f3796b.hasNext()) {
            j = glVar.mo3753a(j, this.f3796b.mo3698a());
        }
        return j;
    }

    /* renamed from: b */
    public C0314cf mo3570b(C0469gl glVar) {
        boolean z = false;
        long j = 0;
        while (this.f3796b.hasNext()) {
            long a = this.f3796b.mo3698a();
            if (!z) {
                z = true;
                j = a;
            } else {
                j = glVar.mo3753a(j, a);
            }
        }
        return z ? C0314cf.m11535a(j) : C0314cf.m11534a();
    }

    /* renamed from: f */
    public long[] mo3582f() {
        return C0537ir.m12285a(this.f3796b);
    }

    /* renamed from: a */
    public <R> R mo3563a(C0506hp<R> hpVar, C0495hf<R> hfVar) {
        R b = hpVar.mo107b();
        while (this.f3796b.hasNext()) {
            hfVar.mo4936a(b, this.f3796b.mo3698a());
        }
        return b;
    }

    /* renamed from: g */
    public long mo3583g() {
        long j = 0;
        while (this.f3796b.hasNext()) {
            j += this.f3796b.mo3698a();
        }
        return j;
    }

    /* renamed from: h */
    public C0314cf mo3585h() {
        return mo3570b((C0469gl) new C0272bw(this));
    }

    /* renamed from: i */
    public C0314cf mo3587i() {
        return mo3570b((C0469gl) new C0280bx(this));
    }

    /* renamed from: j */
    public long mo3588j() {
        long j = 0;
        while (this.f3796b.hasNext()) {
            this.f3796b.mo3698a();
            j++;
        }
        return j;
    }

    /* renamed from: f */
    public boolean mo3581f(C0477gr grVar) {
        while (this.f3796b.hasNext()) {
            if (grVar.mo4929a(this.f3796b.mo3698a())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo3584g(C0477gr grVar) {
        while (this.f3796b.hasNext()) {
            if (!grVar.mo4929a(this.f3796b.mo3698a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public boolean mo3586h(C0477gr grVar) {
        while (this.f3796b.hasNext()) {
            if (grVar.mo4929a(this.f3796b.mo3698a())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public C0314cf mo3589k() {
        if (this.f3796b.hasNext()) {
            return C0314cf.m11535a(this.f3796b.mo3698a());
        }
        return C0314cf.m11534a();
    }

    /* renamed from: l */
    public C0314cf mo3590l() {
        return mo3570b((C0469gl) new C0284by(this));
    }

    /* renamed from: m */
    public long mo3591m() {
        if (this.f3796b.hasNext()) {
            long a = this.f3796b.mo3698a();
            if (!this.f3796b.hasNext()) {
                return a;
            }
            throw new IllegalStateException("LongStream contains more than one element");
        }
        throw new NoSuchElementException("LongStream contains no element");
    }

    /* renamed from: n */
    public C0314cf mo3592n() {
        if (!this.f3796b.hasNext()) {
            return C0314cf.m11534a();
        }
        long a = this.f3796b.mo3698a();
        if (!this.f3796b.hasNext()) {
            return C0314cf.m11535a(a);
        }
        throw new IllegalStateException("LongStream contains more than one element");
    }

    /* renamed from: a */
    public C0245bu mo3559a(Runnable runnable) {
        C0293ca.m10962b(runnable);
        C0538is isVar = this.f3797c;
        if (isVar == null) {
            isVar = new C0538is();
            isVar.f5012a = runnable;
        } else {
            isVar.f5012a = C0534io.m12281a(isVar.f5012a, runnable);
        }
        return new C0245bu(isVar, this.f3796b);
    }

    public void close() {
        C0538is isVar = this.f3797c;
        if (isVar != null && isVar.f5012a != null) {
            this.f3797c.f5012a.run();
            this.f3797c.f5012a = null;
        }
    }
}
