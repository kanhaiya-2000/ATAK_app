package atakplugin.UASTool;

import atakplugin.UASTool.C0347da;
import atakplugin.UASTool.C0496hg;
import atakplugin.UASTool.C0657mq;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.cn */
public class C0325cn<T> implements Closeable {

    /* renamed from: c */
    private static final int f4702c = 0;

    /* renamed from: d */
    private static final int f4703d = 1;

    /* renamed from: e */
    private static final int f4704e = 2;

    /* renamed from: a */
    private final Iterator<? extends T> f4705a;

    /* renamed from: b */
    private final C0538is f4706b;

    /* renamed from: a */
    public static <T> C0325cn<T> m11776a() {
        return m11782a(Collections.emptyList());
    }

    /* renamed from: a */
    public static <K, V> C0325cn<Map.Entry<K, V>> m11789a(Map<K, V> map) {
        C0293ca.m10962b(map);
        return new C0325cn<>(map.entrySet());
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11786a(Iterator<? extends T> it) {
        C0293ca.m10962b(it);
        return new C0325cn<>(it);
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11782a(Iterable<? extends T> iterable) {
        C0293ca.m10962b(iterable);
        return new C0325cn<>(iterable);
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11790a(T... tArr) {
        C0293ca.m10962b(tArr);
        if (tArr.length == 0) {
            return m11776a();
        }
        return new C0325cn<>(new C0635lv(tArr));
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11783a(T t) {
        if (t == null) {
            return m11776a();
        }
        return m11790a((T[]) new Object[]{t});
    }

    /* renamed from: b */
    public static <T> C0325cn<T> m11799b(T[] tArr) {
        return tArr == null ? m11776a() : m11790a(tArr);
    }

    /* renamed from: b */
    public static <K, V> C0325cn<Map.Entry<K, V>> m11798b(Map<K, V> map) {
        return map == null ? m11776a() : m11789a(map);
    }

    /* renamed from: b */
    public static <T> C0325cn<T> m11796b(Iterator<? extends T> it) {
        return it == null ? m11776a() : m11786a(it);
    }

    /* renamed from: b */
    public static <T> C0325cn<T> m11795b(Iterable<? extends T> iterable) {
        return iterable == null ? m11776a() : m11782a(iterable);
    }

    /* renamed from: a */
    public static C0325cn<Integer> m11777a(int i, int i2) {
        return C0206bo.m7864a(i, i2).mo2911c();
    }

    /* renamed from: a */
    public static C0325cn<Long> m11778a(long j, long j2) {
        return C0245bu.m9455a(j, j2).mo3575c();
    }

    /* renamed from: b */
    public static C0325cn<Integer> m11792b(int i, int i2) {
        return C0206bo.m7872b(i, i2).mo2911c();
    }

    /* renamed from: b */
    public static C0325cn<Long> m11793b(long j, long j2) {
        return C0245bu.m9462b(j, j2).mo3575c();
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11781a(C0506hp<T> hpVar) {
        C0293ca.m10962b(hpVar);
        return new C0325cn<>(new C0649mi(hpVar));
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11785a(T t, C0530il<T> ilVar) {
        C0293ca.m10962b(ilVar);
        return new C0325cn<>(new C0650mj(t, ilVar));
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11784a(T t, C0496hg<? super T> hgVar, C0530il<T> ilVar) {
        C0293ca.m10962b(hgVar);
        return m11785a(t, ilVar).mo4756c(hgVar);
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11779a(C0325cn<? extends T> cnVar, C0325cn<? extends T> cnVar2) {
        C0293ca.m10962b(cnVar);
        C0293ca.m10962b(cnVar2);
        return new C0325cn(new C0637lx(cnVar.f4705a, cnVar2.f4705a)).mo4728a(C0534io.m12280a((Closeable) cnVar, (Closeable) cnVar2));
    }

    /* renamed from: a */
    public static <T> C0325cn<T> m11787a(Iterator<? extends T> it, Iterator<? extends T> it2) {
        C0293ca.m10962b(it);
        C0293ca.m10962b(it2);
        return new C0325cn<>(new C0637lx(it, it2));
    }

    /* renamed from: a */
    public static <F, S, R> C0325cn<R> m11780a(C0325cn<? extends F> cnVar, C0325cn<? extends S> cnVar2, C0342cx<? super F, ? super S, ? extends R> cxVar) {
        C0293ca.m10962b(cnVar);
        C0293ca.m10962b(cnVar2);
        return m11788a(cnVar.f4705a, cnVar2.f4705a, cxVar);
    }

    /* renamed from: a */
    public static <F, S, R> C0325cn<R> m11788a(Iterator<? extends F> it, Iterator<? extends S> it2, C0342cx<? super F, ? super S, ? extends R> cxVar) {
        C0293ca.m10962b(it);
        C0293ca.m10962b(it2);
        return new C0325cn<>(new C0671nc(it, it2, cxVar));
    }

    /* renamed from: b */
    public static <T> C0325cn<T> m11794b(C0325cn<? extends T> cnVar, C0325cn<? extends T> cnVar2, C0342cx<? super T, ? super T, C0657mq.C0658a> cxVar) {
        C0293ca.m10962b(cnVar);
        C0293ca.m10962b(cnVar2);
        return m11797b(cnVar.f4705a, cnVar2.f4705a, cxVar);
    }

    /* renamed from: b */
    public static <T> C0325cn<T> m11797b(Iterator<? extends T> it, Iterator<? extends T> it2, C0342cx<? super T, ? super T, C0657mq.C0658a> cxVar) {
        C0293ca.m10962b(it);
        C0293ca.m10962b(it2);
        return new C0325cn<>(new C0657mq(it, it2, cxVar));
    }

    private C0325cn(Iterator<? extends T> it) {
        this((C0538is) null, it);
    }

    private C0325cn(Iterable<? extends T> iterable) {
        this((C0538is) null, new C0548iy(iterable));
    }

    private C0325cn(C0538is isVar, Iterable<? extends T> iterable) {
        this(isVar, new C0548iy(iterable));
    }

    C0325cn(C0538is isVar, Iterator<? extends T> it) {
        this.f4706b = isVar;
        this.f4705a = it;
    }

    /* renamed from: b */
    public Iterator<? extends T> mo4748b() {
        return this.f4705a;
    }

    /* renamed from: a */
    public <R> R mo4732a(C0391ei<C0325cn<T>, R> eiVar) {
        C0293ca.m10962b(eiVar);
        return eiVar.apply(this);
    }

    /* renamed from: a */
    public C0325cn<T> mo4725a(C0496hg<? super T> hgVar) {
        return new C0325cn<>(this.f4706b, new C0643mc(this.f4705a, hgVar));
    }

    /* renamed from: a */
    public C0325cn<T> mo4724a(C0442fr<? super T> frVar) {
        return mo4719a(0, 1, frVar);
    }

    /* renamed from: a */
    public C0325cn<T> mo4719a(int i, int i2, C0442fr<? super T> frVar) {
        return new C0325cn<>(this.f4706b, new C0644md(new C0547ix(i, i2, this.f4705a), frVar));
    }

    /* renamed from: b */
    public C0325cn<T> mo4745b(C0496hg<? super T> hgVar) {
        return mo4725a(C0496hg.C0497a.m12242a(hgVar));
    }

    /* renamed from: a */
    public <TT> C0325cn<TT> mo4726a(Class<TT> cls) {
        return mo4725a(new C0327co(this, cls));
    }

    /* renamed from: c */
    public C0325cn<T> mo4751c() {
        return mo4725a(C0496hg.C0497a.m12241a());
    }

    /* renamed from: d */
    public C0325cn<T> mo4759d() {
        return mo4745b(C0496hg.C0497a.m12241a());
    }

    /* renamed from: b */
    public C0325cn<T> mo4746b(T t) {
        return mo4725a(new C0329cp(this, t));
    }

    /* renamed from: b */
    public <R> C0325cn<R> mo4743b(C0391ei<? super T, ? extends R> eiVar) {
        return new C0325cn<>(this.f4706b, new C0652ml(this.f4705a, eiVar));
    }

    /* renamed from: a */
    public <R> C0325cn<R> mo4723a(C0415ez<? super T, ? extends R> ezVar) {
        return mo4718a(0, 1, ezVar);
    }

    /* renamed from: a */
    public <R> C0325cn<R> mo4718a(int i, int i2, C0415ez<? super T, ? extends R> ezVar) {
        return new C0325cn<>(this.f4706b, new C0653mm(new C0547ix(i, i2, this.f4705a), ezVar));
    }

    /* renamed from: a */
    public C0206bo mo4715a(C0528ij<? super T> ijVar) {
        return new C0206bo(this.f4706b, new C0655mo(this.f4705a, ijVar));
    }

    /* renamed from: a */
    public C0245bu mo4716a(C0529ik<? super T> ikVar) {
        return new C0245bu(this.f4706b, new C0656mp(this.f4705a, ikVar));
    }

    /* renamed from: a */
    public C0150bg mo4714a(C0527ii<? super T> iiVar) {
        return new C0150bg(this.f4706b, new C0654mn(this.f4705a, iiVar));
    }

    /* renamed from: c */
    public <R> C0325cn<R> mo4754c(C0391ei<? super T, ? extends C0325cn<? extends R>> eiVar) {
        return new C0325cn<>(this.f4706b, new C0645me(this.f4705a, eiVar));
    }

    /* renamed from: d */
    public C0206bo mo4758d(C0391ei<? super T, ? extends C0206bo> eiVar) {
        return new C0206bo(this.f4706b, new C0647mg(this.f4705a, eiVar));
    }

    /* renamed from: e */
    public C0245bu mo4764e(C0391ei<? super T, ? extends C0245bu> eiVar) {
        return new C0245bu(this.f4706b, new C0648mh(this.f4705a, eiVar));
    }

    /* renamed from: f */
    public C0150bg mo4769f(C0391ei<? super T, ? extends C0150bg> eiVar) {
        return new C0150bg(this.f4706b, new C0646mf(this.f4705a, eiVar));
    }

    /* renamed from: e */
    public C0325cn<C0198bn<T>> mo4767e() {
        return mo4752c(0, 1);
    }

    /* renamed from: c */
    public C0325cn<C0198bn<T>> mo4752c(int i, int i2) {
        return mo4718a(i, i2, new C0332cq(this));
    }

    /* renamed from: f */
    public C0325cn<T> mo4770f() {
        return new C0325cn<>(this.f4706b, new C0638ly(this.f4705a));
    }

    /* renamed from: g */
    public <K> C0325cn<T> mo4773g(C0391ei<? super T, ? extends K> eiVar) {
        return new C0325cn<>(this.f4706b, new C0639lz(this.f4705a, eiVar));
    }

    /* renamed from: g */
    public C0325cn<T> mo4772g() {
        return mo4729a(new C0335cr(this));
    }

    /* renamed from: a */
    public C0325cn<T> mo4729a(Comparator<? super T> comparator) {
        return new C0325cn<>(this.f4706b, new C0665mx(this.f4705a, comparator));
    }

    /* renamed from: h */
    public <R extends Comparable<? super R>> C0325cn<T> mo4775h(C0391ei<? super T, ? extends R> eiVar) {
        return mo4729a(C0106aw.m5173a(eiVar));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [atakplugin.UASTool.ei, atakplugin.UASTool.ei<? super T, ? extends K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K> atakplugin.UASTool.C0325cn<java.util.Map.Entry<K, java.util.List<T>>> mo4778i(atakplugin.UASTool.C0391ei<? super T, ? extends K> r3) {
        /*
            r2 = this;
            atakplugin.UASTool.a r3 = atakplugin.UASTool.C0130b.m6093c(r3)
            java.lang.Object r3 = r2.mo4731a(r3)
            java.util.Map r3 = (java.util.Map) r3
            atakplugin.UASTool.cn r0 = new atakplugin.UASTool.cn
            atakplugin.UASTool.is r1 = r2.f4706b
            java.util.Set r3 = r3.entrySet()
            r0.<init>((atakplugin.UASTool.C0538is) r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0325cn.mo4778i(atakplugin.UASTool.ei):atakplugin.UASTool.cn");
    }

    /* renamed from: j */
    public <K> C0325cn<List<T>> mo4781j(C0391ei<? super T, ? extends K> eiVar) {
        return new C0325cn<>(this.f4706b, new C0636lw(this.f4705a, eiVar));
    }

    /* renamed from: a */
    public C0325cn<T> mo4717a(int i) {
        if (i > 0) {
            return i == 1 ? this : mo4760d(1, i).mo4743b(new C0336cs(this));
        }
        throw new IllegalArgumentException("stepWidth cannot be zero or negative");
    }

    /* renamed from: b */
    public C0325cn<List<T>> mo4740b(int i) {
        return mo4760d(i, 1);
    }

    /* renamed from: d */
    public C0325cn<List<T>> mo4760d(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("windowSize cannot be zero or negative");
        } else if (i2 > 0) {
            return new C0325cn<>(this.f4706b, new C0664mw(this.f4705a, i, i2));
        } else {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        }
    }

    /* renamed from: a */
    public C0325cn<T> mo4722a(C0363dn<? super T> dnVar) {
        return new C0325cn<>(this.f4706b, new C0660ms(this.f4705a, dnVar));
    }

    /* renamed from: a */
    public C0325cn<T> mo4721a(C0342cx<T, T, T> cxVar) {
        C0293ca.m10962b(cxVar);
        return new C0325cn<>(this.f4706b, new C0661mt(this.f4705a, cxVar));
    }

    /* renamed from: a */
    public <R> C0325cn<R> mo4727a(R r, C0342cx<? super R, ? super T, ? extends R> cxVar) {
        C0293ca.m10962b(cxVar);
        return new C0325cn<>(this.f4706b, new C0662mu(this.f4705a, r, cxVar));
    }

    /* renamed from: c */
    public C0325cn<T> mo4756c(C0496hg<? super T> hgVar) {
        return new C0325cn<>(this.f4706b, new C0669na(this.f4705a, hgVar));
    }

    /* renamed from: b */
    public C0325cn<T> mo4744b(C0442fr<? super T> frVar) {
        return mo4741b(0, 1, frVar);
    }

    /* renamed from: b */
    public C0325cn<T> mo4741b(int i, int i2, C0442fr<? super T> frVar) {
        return new C0325cn<>(this.f4706b, new C0670nb(new C0547ix(i, i2, this.f4705a), frVar));
    }

    /* renamed from: d */
    public C0325cn<T> mo4763d(C0496hg<? super T> hgVar) {
        return new C0325cn<>(this.f4706b, new C0666my(this.f4705a, hgVar));
    }

    /* renamed from: c */
    public C0325cn<T> mo4755c(C0442fr<? super T> frVar) {
        return mo4753c(0, 1, frVar);
    }

    /* renamed from: c */
    public C0325cn<T> mo4753c(int i, int i2, C0442fr<? super T> frVar) {
        return new C0325cn<>(this.f4706b, new C0667mz(new C0547ix(i, i2, this.f4705a), frVar));
    }

    /* renamed from: e */
    public C0325cn<T> mo4768e(C0496hg<? super T> hgVar) {
        return new C0325cn<>(this.f4706b, new C0641ma(this.f4705a, hgVar));
    }

    /* renamed from: d */
    public C0325cn<T> mo4762d(C0442fr<? super T> frVar) {
        return mo4761d(0, 1, frVar);
    }

    /* renamed from: d */
    public C0325cn<T> mo4761d(int i, int i2, C0442fr<? super T> frVar) {
        return new C0325cn<>(this.f4706b, new C0642mb(new C0547ix(i, i2, this.f4705a), frVar));
    }

    /* renamed from: a */
    public C0325cn<T> mo4720a(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (i == 0) {
            return m11776a();
        } else {
            return new C0325cn<>(this.f4706b, new C0651mk(this.f4705a, j));
        }
    }

    /* renamed from: b */
    public C0325cn<T> mo4742b(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : new C0325cn<>(this.f4706b, new C0663mv(this.f4705a, j));
        }
        throw new IllegalArgumentException("n cannot be negative");
    }

    /* renamed from: b */
    public void mo4749b(C0363dn<? super T> dnVar) {
        while (this.f4705a.hasNext()) {
            dnVar.mo838a(this.f4705a.next());
        }
    }

    /* renamed from: a */
    public void mo4736a(C0398en<? super T> enVar) {
        mo4735a(0, 1, enVar);
    }

    /* renamed from: a */
    public void mo4735a(int i, int i2, C0398en<? super T> enVar) {
        while (this.f4705a.hasNext()) {
            enVar.mo4907a(i, this.f4705a.next());
            i += i2;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [atakplugin.UASTool.cx, atakplugin.UASTool.cx<? super R, ? super T, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> R mo4747b(R r2, atakplugin.UASTool.C0342cx<? super R, ? super T, ? extends R> r3) {
        /*
            r1 = this;
        L_0x0000:
            java.util.Iterator<? extends T> r0 = r1.f4705a
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0013
            java.util.Iterator<? extends T> r0 = r1.f4705a
            java.lang.Object r0 = r0.next()
            java.lang.Object r2 = r3.mo4893a(r2, r0)
            goto L_0x0000
        L_0x0013:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0325cn.mo4747b(java.lang.Object, atakplugin.UASTool.cx):java.lang.Object");
    }

    /* renamed from: a */
    public <R> R mo4734a(R r, C0395el<? super R, ? super T, ? extends R> elVar) {
        return mo4730a(0, 1, r, elVar);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [atakplugin.UASTool.el<? super R, ? super T, ? extends R>, atakplugin.UASTool.el] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> R mo4730a(int r2, int r3, R r4, atakplugin.UASTool.C0395el<? super R, ? super T, ? extends R> r5) {
        /*
            r1 = this;
        L_0x0000:
            java.util.Iterator<? extends T> r0 = r1.f4705a
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0014
            java.util.Iterator<? extends T> r0 = r1.f4705a
            java.lang.Object r0 = r0.next()
            java.lang.Object r4 = r5.mo4906a(r2, r4, r0)
            int r2 = r2 + r3
            goto L_0x0000
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C0325cn.mo4730a(int, int, java.lang.Object, atakplugin.UASTool.el):java.lang.Object");
    }

    /* renamed from: b */
    public C0297cb<T> mo4738b(C0342cx<T, T, T> cxVar) {
        boolean z = false;
        T t = null;
        while (this.f4705a.hasNext()) {
            T next = this.f4705a.next();
            if (!z) {
                z = true;
                t = next;
            } else {
                t = cxVar.mo4893a(t, next);
            }
        }
        return z ? C0297cb.m11067a(t) : C0297cb.m11066a();
    }

    /* renamed from: h */
    public Object[] mo4777h() {
        return mo4737a((C0450fx<R[]>) new C0337ct(this));
    }

    /* renamed from: a */
    public <R> R[] mo4737a(C0450fx<R[]> fxVar) {
        return C0537ir.m12286a(this.f4705a, fxVar);
    }

    /* renamed from: i */
    public List<T> mo4779i() {
        ArrayList arrayList = new ArrayList();
        while (this.f4705a.hasNext()) {
            arrayList.add(this.f4705a.next());
        }
        return arrayList;
    }

    /* renamed from: a */
    public <R> R mo4733a(C0506hp<R> hpVar, C0339cv<R, ? super T> cvVar) {
        R b = hpVar.mo107b();
        while (this.f4705a.hasNext()) {
            cvVar.mo128a(b, this.f4705a.next());
        }
        return b;
    }

    /* renamed from: a */
    public <R, A> R mo4731a(C0000a<? super T, A, R> aVar) {
        A b = aVar.mo3a().mo107b();
        while (this.f4705a.hasNext()) {
            aVar.mo4b().mo128a(b, this.f4705a.next());
        }
        if (aVar.mo5c() != null) {
            return aVar.mo5c().apply(b);
        }
        return C0130b.m6098g().apply(b);
    }

    /* renamed from: b */
    public C0297cb<T> mo4739b(Comparator<? super T> comparator) {
        return mo4738b(C0347da.C0348a.m12052a(comparator));
    }

    /* renamed from: c */
    public C0297cb<T> mo4750c(Comparator<? super T> comparator) {
        return mo4738b(C0347da.C0348a.m12053b(comparator));
    }

    /* renamed from: j */
    public long mo4780j() {
        long j = 0;
        while (this.f4705a.hasNext()) {
            this.f4705a.next();
            j++;
        }
        return j;
    }

    /* renamed from: f */
    public boolean mo4771f(C0496hg<? super T> hgVar) {
        return m11791a(hgVar, 0);
    }

    /* renamed from: g */
    public boolean mo4774g(C0496hg<? super T> hgVar) {
        return m11791a(hgVar, 1);
    }

    /* renamed from: h */
    public boolean mo4776h(C0496hg<? super T> hgVar) {
        return m11791a(hgVar, 2);
    }

    /* renamed from: e */
    public C0297cb<C0198bn<T>> mo4766e(C0442fr<? super T> frVar) {
        return mo4765e(0, 1, frVar);
    }

    /* renamed from: e */
    public C0297cb<C0198bn<T>> mo4765e(int i, int i2, C0442fr<? super T> frVar) {
        while (this.f4705a.hasNext()) {
            Object next = this.f4705a.next();
            if (frVar.mo4920a(i, next)) {
                return C0297cb.m11067a(new C0198bn(i, next));
            }
            i += i2;
        }
        return C0297cb.m11066a();
    }

    /* renamed from: k */
    public C0297cb<T> mo4782k() {
        if (this.f4705a.hasNext()) {
            return C0297cb.m11067a(this.f4705a.next());
        }
        return C0297cb.m11066a();
    }

    /* renamed from: l */
    public C0297cb<T> mo4783l() {
        return mo4738b(new C0338cu(this));
    }

    /* renamed from: m */
    public T mo4784m() {
        if (this.f4705a.hasNext()) {
            T next = this.f4705a.next();
            if (!this.f4705a.hasNext()) {
                return next;
            }
            throw new IllegalStateException("Stream contains more than one element");
        }
        throw new NoSuchElementException("Stream contains no element");
    }

    /* renamed from: n */
    public C0297cb<T> mo4785n() {
        if (!this.f4705a.hasNext()) {
            return C0297cb.m11066a();
        }
        Object next = this.f4705a.next();
        if (!this.f4705a.hasNext()) {
            return C0297cb.m11067a(next);
        }
        throw new IllegalStateException("Stream contains more than one element");
    }

    /* renamed from: a */
    public C0325cn<T> mo4728a(Runnable runnable) {
        C0293ca.m10962b(runnable);
        C0538is isVar = this.f4706b;
        if (isVar == null) {
            isVar = new C0538is();
            isVar.f5012a = runnable;
        } else {
            isVar.f5012a = C0534io.m12281a(isVar.f5012a, runnable);
        }
        return new C0325cn<>(isVar, this.f4705a);
    }

    public void close() {
        C0538is isVar = this.f4706b;
        if (isVar != null && isVar.f5012a != null) {
            this.f4706b.f5012a.run();
            this.f4706b.f5012a = null;
        }
    }

    /* renamed from: a */
    private boolean m11791a(C0496hg<? super T> hgVar, int i) {
        boolean z = i == 0;
        boolean z2 = i == 1;
        while (this.f4705a.hasNext()) {
            boolean test = hgVar.test(this.f4705a.next());
            if (test ^ z2) {
                if (!z || !test) {
                    return false;
                }
                return true;
            }
        }
        return !z;
    }
}
