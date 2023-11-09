package atakplugin.UASTool;

import java.util.Collections;
import java.util.Comparator;

/* renamed from: atakplugin.UASTool.aw */
public final class C0106aw<T> implements Comparator<T> {

    /* renamed from: a */
    private static final C0106aw<Comparable<Object>> f2324a = new C0106aw<>(new C0107ax());

    /* renamed from: b */
    private static final C0106aw<Comparable<Object>> f2325b = new C0106aw<>(Collections.reverseOrder());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Comparator<? super T> f2326c;

    /* renamed from: a */
    public static <T extends Comparable<? super T>> C0106aw<T> m5172a() {
        return f2324a;
    }

    /* renamed from: b */
    public static <T extends Comparable<? super T>> C0106aw<T> m5182b() {
        return f2325b;
    }

    /* renamed from: a */
    public static <T> Comparator<T> m5180a(Comparator<T> comparator) {
        return Collections.reverseOrder(comparator);
    }

    /* renamed from: a */
    public static <T> Comparator<T> m5181a(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        C0293ca.m10962b(comparator);
        C0293ca.m10962b(comparator2);
        return new C0109ay(comparator, comparator2);
    }

    /* renamed from: a */
    public static <T, U> C0106aw<T> m5174a(C0391ei<? super T, ? extends U> eiVar, Comparator<? super U> comparator) {
        C0293ca.m10962b(eiVar);
        C0293ca.m10962b(comparator);
        return new C0106aw<>(new C0127az(eiVar, comparator));
    }

    /* renamed from: a */
    public static <T, U extends Comparable<? super U>> C0106aw<T> m5173a(C0391ei<? super T, ? extends U> eiVar) {
        C0293ca.m10962b(eiVar);
        return new C0106aw<>(new C0134ba(eiVar));
    }

    /* renamed from: a */
    public static <T> C0106aw<T> m5176a(C0528ij<? super T> ijVar) {
        C0293ca.m10962b(ijVar);
        return new C0106aw<>(new C0136bb(ijVar));
    }

    /* renamed from: a */
    public static <T> C0106aw<T> m5177a(C0529ik<? super T> ikVar) {
        C0293ca.m10962b(ikVar);
        return new C0106aw<>(new C0145bc(ikVar));
    }

    /* renamed from: a */
    public static <T> C0106aw<T> m5175a(C0527ii<? super T> iiVar) {
        C0293ca.m10962b(iiVar);
        return new C0106aw<>(new C0146bd(iiVar));
    }

    /* renamed from: c */
    public static <T> C0106aw<T> m5184c() {
        return m5178a(true, (Comparator) null);
    }

    /* renamed from: b */
    public static <T> C0106aw<T> m5183b(Comparator<? super T> comparator) {
        return m5178a(true, comparator);
    }

    /* renamed from: d */
    public static <T> C0106aw<T> m5186d() {
        return m5178a(false, (Comparator) null);
    }

    /* renamed from: c */
    public static <T> C0106aw<T> m5185c(Comparator<? super T> comparator) {
        return m5178a(false, comparator);
    }

    /* renamed from: a */
    private static <T> C0106aw<T> m5178a(boolean z, Comparator<? super T> comparator) {
        return new C0106aw<>(new C0147be(z, comparator));
    }

    /* renamed from: d */
    public static <T> C0106aw<T> m5187d(Comparator<T> comparator) {
        return new C0106aw<>(comparator);
    }

    public C0106aw(Comparator<? super T> comparator) {
        this.f2326c = comparator;
    }

    /* renamed from: e */
    public C0106aw<T> reversed() {
        return new C0106aw<>(Collections.reverseOrder(this.f2326c));
    }

    /* renamed from: e */
    public C0106aw<T> thenComparing(Comparator<? super T> comparator) {
        C0293ca.m10962b(comparator);
        return new C0106aw<>(new C0149bf(this, comparator));
    }

    /* renamed from: b */
    public <U> C0106aw<T> mo2073b(C0391ei<? super T, ? extends U> eiVar, Comparator<? super U> comparator) {
        return thenComparing(m5174a(eiVar, comparator));
    }

    /* renamed from: b */
    public <U extends Comparable<? super U>> C0106aw<T> mo2072b(C0391ei<? super T, ? extends U> eiVar) {
        return thenComparing(m5173a(eiVar));
    }

    /* renamed from: b */
    public C0106aw<T> mo2075b(C0528ij<? super T> ijVar) {
        return thenComparing(m5176a(ijVar));
    }

    /* renamed from: b */
    public C0106aw<T> mo2076b(C0529ik<? super T> ikVar) {
        return thenComparing(m5177a(ikVar));
    }

    /* renamed from: b */
    public C0106aw<T> mo2074b(C0527ii<? super T> iiVar) {
        return thenComparing(m5175a(iiVar));
    }

    /* renamed from: f */
    public Comparator<T> mo2080f() {
        return this.f2326c;
    }

    public int compare(T t, T t2) {
        return this.f2326c.compare(t, t2);
    }
}
