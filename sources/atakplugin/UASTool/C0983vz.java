package atakplugin.UASTool;

import atakplugin.UASTool.C0979vw;
import atakplugin.UASTool.C0990we;
import atakplugin.UASTool.C0998wk;
import java.util.EnumSet;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.vz */
public class C0983vz implements C0962vk<C0982vy> {

    /* renamed from: a */
    private final C0990we f7452a;

    /* renamed from: b */
    private C0998wk<C0990we.C0991a> f7453b;

    C0983vz(C0990we weVar) {
        this.f7452a = weVar;
    }

    /* renamed from: a */
    public static C0962vk<C0982vy> m14334a() {
        return new C0983vz(new C0990we());
    }

    /* renamed from: b */
    public C0982vy mo6041a(String str) {
        this.f7453b = this.f7452a.mo6093a(str);
        C0979vw b = m14341b();
        m14339a(C0990we.C0991a.C0992a.EOI);
        return b;
    }

    /* renamed from: b */
    private C0979vw m14341b() {
        C0979vw vwVar;
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.NOT})) {
            this.f7453b.mo6101a();
            m14339a(C0990we.C0991a.C0992a.LEFT_PAREN);
            vwVar = C0979vw.C0980a.m14320a((C0982vy) m14341b());
            m14339a(C0990we.C0991a.C0992a.RIGHT_PAREN);
        } else {
            if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.LEFT_PAREN})) {
                m14339a(C0990we.C0991a.C0992a.LEFT_PAREN);
                vwVar = m14341b();
                m14339a(C0990we.C0991a.C0992a.RIGHT_PAREN);
            } else {
                vwVar = m14343c();
            }
        }
        return m14338a(vwVar);
    }

    /* renamed from: a */
    private C0979vw m14338a(C0979vw vwVar) {
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.AND})) {
            this.f7453b.mo6101a();
            return vwVar.mo6089a((C0982vy) m14341b());
        }
        if (!this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.OR})) {
            return vwVar;
        }
        this.f7453b.mo6101a();
        return vwVar.mo6091b(m14341b());
    }

    /* renamed from: c */
    private C0979vw m14343c() {
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.TILDE})) {
            return m14345e();
        }
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.CARET})) {
            return m14346f();
        }
        if (m14347g()) {
            return m14348h();
        }
        if (m14349i()) {
            return m14350j();
        }
        if (m14351k()) {
            return m14352l();
        }
        return m14344d();
    }

    /* renamed from: d */
    private C0979vw m14344d() {
        switch (C09841.f7454a[this.f7453b.mo6108c().f7459a.ordinal()]) {
            case 1:
                this.f7453b.mo6101a();
                return C0979vw.C0980a.m14319a(m14353m());
            case 2:
                this.f7453b.mo6101a();
                return C0979vw.C0980a.m14322b(m14353m());
            case 3:
                this.f7453b.mo6101a();
                return C0979vw.C0980a.m14324c(m14353m());
            case 4:
                this.f7453b.mo6101a();
                return C0979vw.C0980a.m14326d(m14353m());
            case 5:
                this.f7453b.mo6101a();
                return C0979vw.C0980a.m14328e(m14353m());
            case 6:
                this.f7453b.mo6101a();
                return C0979vw.C0980a.m14330f(m14353m());
            default:
                return C0979vw.C0980a.m14319a(m14353m());
        }
    }

    /* renamed from: atakplugin.UASTool.vz$1 */
    /* synthetic */ class C09841 {

        /* renamed from: a */
        static final /* synthetic */ int[] f7454a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                atakplugin.UASTool.we$a$a[] r0 = atakplugin.UASTool.C0990we.C0991a.C0992a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7454a = r0
                atakplugin.UASTool.we$a$a r1 = atakplugin.UASTool.C0990we.C0991a.C0992a.EQUAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7454a     // Catch:{ NoSuchFieldError -> 0x001d }
                atakplugin.UASTool.we$a$a r1 = atakplugin.UASTool.C0990we.C0991a.C0992a.NOT_EQUAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7454a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atakplugin.UASTool.we$a$a r1 = atakplugin.UASTool.C0990we.C0991a.C0992a.GREATER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7454a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atakplugin.UASTool.we$a$a r1 = atakplugin.UASTool.C0990we.C0991a.C0992a.GREATER_EQUAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7454a     // Catch:{ NoSuchFieldError -> 0x003e }
                atakplugin.UASTool.we$a$a r1 = atakplugin.UASTool.C0990we.C0991a.C0992a.LESS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7454a     // Catch:{ NoSuchFieldError -> 0x0049 }
                atakplugin.UASTool.we$a$a r1 = atakplugin.UASTool.C0990we.C0991a.C0992a.LESS_EQUAL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0983vz.C09841.<clinit>():void");
        }
    }

    /* renamed from: e */
    private C0979vw m14345e() {
        m14339a(C0990we.C0991a.C0992a.TILDE);
        int c = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        if (!this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.DOT})) {
            return C0979vw.C0980a.m14326d(m14335a(c)).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14335a(c + 1)));
        }
        m14339a(C0990we.C0991a.C0992a.DOT);
        int c2 = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        if (!this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.DOT})) {
            return C0979vw.C0980a.m14326d(m14336a(c, c2)).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14336a(c, c2 + 1)));
        }
        m14339a(C0990we.C0991a.C0992a.DOT);
        return C0979vw.C0980a.m14326d(m14337a(c, c2, m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b))).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14336a(c, c2 + 1)));
    }

    /* renamed from: f */
    private C0979vw m14346f() {
        m14339a(C0990we.C0991a.C0992a.CARET);
        int c = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        if (!this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.DOT})) {
            return C0979vw.C0980a.m14326d(m14335a(c)).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14335a(c + 1)));
        }
        m14339a(C0990we.C0991a.C0992a.DOT);
        int c2 = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        if (!this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.DOT})) {
            C0964vm a = m14336a(c, c2);
            return C0979vw.C0980a.m14326d(a).mo6089a((C0982vy) C0979vw.C0980a.m14328e(c > 0 ? a.mo6045a() : a.mo6048b()));
        }
        m14339a(C0990we.C0991a.C0992a.DOT);
        int c3 = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        C0964vm a2 = m14337a(c, c2, c3);
        C0979vw d = C0979vw.C0980a.m14326d(a2);
        if (c > 0) {
            return d.mo6089a((C0982vy) C0979vw.C0980a.m14328e(a2.mo6045a()));
        }
        if (c2 > 0) {
            return d.mo6089a((C0982vy) C0979vw.C0980a.m14328e(a2.mo6048b()));
        }
        if (c3 > 0) {
            return d.mo6089a((C0982vy) C0979vw.C0980a.m14328e(a2.mo6051c()));
        }
        return C0979vw.C0980a.m14319a(a2);
    }

    /* renamed from: g */
    private boolean m14347g() {
        return m14340a((C0998wk.C0999a<C0990we.C0991a>) C0990we.C0991a.C0992a.WILDCARD);
    }

    /* renamed from: h */
    private C0979vw m14348h() {
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.WILDCARD})) {
            this.f7453b.mo6101a();
            return C0979vw.C0980a.m14326d(m14337a(0, 0, 0));
        }
        int c = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        m14339a(C0990we.C0991a.C0992a.DOT);
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.WILDCARD})) {
            this.f7453b.mo6101a();
            return C0979vw.C0980a.m14326d(m14335a(c)).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14335a(c + 1)));
        }
        int c2 = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        m14339a(C0990we.C0991a.C0992a.DOT);
        m14339a(C0990we.C0991a.C0992a.WILDCARD);
        return C0979vw.C0980a.m14326d(m14336a(c, c2)).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14336a(c, c2 + 1)));
    }

    /* renamed from: i */
    private boolean m14349i() {
        return m14340a((C0998wk.C0999a<C0990we.C0991a>) C0990we.C0991a.C0992a.HYPHEN);
    }

    /* renamed from: j */
    private C0979vw m14350j() {
        C0979vw d = C0979vw.C0980a.m14326d(m14353m());
        m14339a(C0990we.C0991a.C0992a.HYPHEN);
        return d.mo6089a((C0982vy) C0979vw.C0980a.m14330f(m14353m()));
    }

    /* renamed from: k */
    private boolean m14351k() {
        if (!this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.NUMERIC})) {
            return false;
        }
        EnumSet complementOf = EnumSet.complementOf(EnumSet.of(C0990we.C0991a.C0992a.NUMERIC, C0990we.C0991a.C0992a.DOT));
        return this.f7453b.mo6104a(5, (T[]) (C0998wk.C0999a[]) complementOf.toArray(new C0990we.C0991a.C0992a[complementOf.size()]));
    }

    /* renamed from: l */
    private C0979vw m14352l() {
        int c = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        if (!this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.DOT})) {
            return C0979vw.C0980a.m14326d(m14335a(c)).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14335a(c + 1)));
        }
        m14339a(C0990we.C0991a.C0992a.DOT);
        int c2 = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        return C0979vw.C0980a.m14326d(m14336a(c, c2)).mo6089a((C0982vy) C0979vw.C0980a.m14328e(m14336a(c, c2 + 1)));
    }

    /* renamed from: m */
    private C0964vm m14353m() {
        int i;
        int i2 = 0;
        int c = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.DOT})) {
            this.f7453b.mo6101a();
            i = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        } else {
            i = 0;
        }
        if (this.f7453b.mo6107b((T[]) new C0990we.C0991a.C0992a[]{C0990we.C0991a.C0992a.DOT})) {
            this.f7453b.mo6101a();
            i2 = m14342c(m14339a(C0990we.C0991a.C0992a.NUMERIC).f7460b);
        }
        return m14337a(c, i, i2);
    }

    /* renamed from: a */
    private boolean m14340a(C0998wk.C0999a<C0990we.C0991a> aVar) {
        EnumSet of = EnumSet.of(C0990we.C0991a.C0992a.NUMERIC, C0990we.C0991a.C0992a.DOT);
        Iterator<C0990we.C0991a> it = this.f7453b.iterator();
        C0990we.C0991a aVar2 = null;
        while (it.hasNext()) {
            aVar2 = it.next();
            if (!of.contains(aVar2.f7459a)) {
                break;
            }
        }
        return aVar.mo6080a(aVar2);
    }

    /* renamed from: a */
    private C0964vm m14335a(int i) {
        return m14337a(i, 0, 0);
    }

    /* renamed from: a */
    private C0964vm m14336a(int i, int i2) {
        return m14337a(i, i2, 0);
    }

    /* renamed from: a */
    private C0964vm m14337a(int i, int i2, int i3) {
        return C0964vm.m14246a(i, i2, i3);
    }

    /* renamed from: c */
    private int m14342c(String str) {
        return Integer.parseInt(str);
    }

    /* renamed from: a */
    private C0990we.C0991a m14339a(C0990we.C0991a.C0992a... aVarArr) {
        try {
            return this.f7453b.mo6103a((T[]) aVarArr);
        } catch (C1001wm e) {
            throw new C0997wj(e);
        }
    }
}
