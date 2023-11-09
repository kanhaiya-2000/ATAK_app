package atakplugin.UASTool;

import atakplugin.UASTool.C0391ei;
import atakplugin.UASTool.C0530il;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: atakplugin.UASTool.b */
public final class C0130b {

    /* renamed from: a */
    private static final C0506hp<long[]> f2460a = new C0292c();

    /* renamed from: b */
    private static final C0506hp<double[]> f2461b = new C0668n();

    private C0130b() {
    }

    /* renamed from: a */
    public static <T, R extends Collection<T>> C0000a<T, ?, R> m6070a(C0506hp<R> hpVar) {
        return new C0131a(hpVar, new C1044y());
    }

    /* renamed from: a */
    public static <T> C0000a<T, ?, List<T>> m6058a() {
        return new C0131a(new C0053ak(), new C0095ar());
    }

    /* renamed from: b */
    public static <T> C0000a<T, ?, List<T>> m6081b() {
        return m6059a(m6058a(), new C0102as());
    }

    /* renamed from: c */
    public static <T> C0000a<T, ?, Set<T>> m6092c() {
        return new C0131a(new C0103at(), new C0104au());
    }

    /* renamed from: d */
    public static <T> C0000a<T, ?, Set<T>> m6095d() {
        return m6059a(m6092c(), new C0105av());
    }

    /* renamed from: a */
    public static <T, K> C0000a<T, ?, Map<K, T>> m6061a(C0391ei<? super T, ? extends K> eiVar) {
        return m6063a(eiVar, C0530il.C0531a.m12275a());
    }

    /* renamed from: a */
    public static <T, K, V> C0000a<T, ?, Map<K, V>> m6063a(C0391ei<? super T, ? extends K> eiVar, C0391ei<? super T, ? extends V> eiVar2) {
        return m6066a(eiVar, eiVar2, m6099h());
    }

    /* renamed from: a */
    public static <T, K, V, M extends Map<K, V>> C0000a<T, ?, M> m6066a(C0391ei<? super T, ? extends K> eiVar, C0391ei<? super T, ? extends V> eiVar2, C0506hp<M> hpVar) {
        return new C0131a(hpVar, new C0346d(eiVar, eiVar2));
    }

    /* renamed from: b */
    public static <T, K, V> C0000a<T, ?, Map<K, V>> m6084b(C0391ei<? super T, ? extends K> eiVar, C0391ei<? super T, ? extends V> eiVar2) {
        return m6059a(m6063a(eiVar, eiVar2), m6100i());
    }

    /* renamed from: a */
    public static <T, K, V> C0000a<T, ?, Map<K, V>> m6064a(C0391ei<? super T, ? extends K> eiVar, C0391ei<? super T, ? extends V> eiVar2, C0347da<V> daVar) {
        return m6065a(eiVar, eiVar2, daVar, m6099h());
    }

    /* renamed from: a */
    public static <T, K, V, M extends Map<K, V>> C0000a<T, ?, M> m6065a(C0391ei<? super T, ? extends K> eiVar, C0391ei<? super T, ? extends V> eiVar2, C0347da<V> daVar, C0506hp<M> hpVar) {
        return new C0131a(hpVar, new C0380e(eiVar, eiVar2, daVar));
    }

    /* renamed from: b */
    public static <T, K, V> C0000a<T, ?, Map<K, V>> m6085b(C0391ei<? super T, ? extends K> eiVar, C0391ei<? super T, ? extends V> eiVar2, C0347da<V> daVar) {
        return m6059a(m6065a(eiVar, eiVar2, daVar, m6099h()), m6100i());
    }

    /* renamed from: e */
    public static C0000a<CharSequence, ?, String> m6096e() {
        return m6074a((CharSequence) "");
    }

    /* renamed from: a */
    public static C0000a<CharSequence, ?, String> m6074a(CharSequence charSequence) {
        return m6075a(charSequence, (CharSequence) "", (CharSequence) "");
    }

    /* renamed from: a */
    public static C0000a<CharSequence, ?, String> m6075a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return m6076a(charSequence, charSequence2, charSequence3, charSequence2.toString() + charSequence3.toString());
    }

    /* renamed from: a */
    public static C0000a<CharSequence, ?, String> m6076a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, String str) {
        return new C0131a(new C0417f(), new C0455g(charSequence, charSequence2), new C0488h(str, charSequence3));
    }

    @Deprecated
    /* renamed from: b */
    public static <T> C0000a<T, ?, Double> m6082b(C0391ei<? super T, Double> eiVar) {
        return m6071a(new C0518i(eiVar));
    }

    /* renamed from: a */
    public static <T> C0000a<T, ?, Double> m6072a(C0528ij<? super T> ijVar) {
        return m6060a(new C0550j(ijVar));
    }

    /* renamed from: a */
    public static <T> C0000a<T, ?, Double> m6073a(C0529ik<? super T> ikVar) {
        return m6060a(new C0586k(ikVar));
    }

    /* renamed from: a */
    private static <T> C0000a<T, ?, Double> m6060a(C0339cv<long[], T> cvVar) {
        return new C0131a(f2460a, cvVar, new C0613l());
    }

    /* renamed from: a */
    public static <T> C0000a<T, ?, Double> m6071a(C0527ii<? super T> iiVar) {
        return new C0131a(f2461b, new C0640m(iiVar), new C0696o());
    }

    /* renamed from: b */
    public static <T> C0000a<T, ?, Integer> m6088b(C0528ij<? super T> ijVar) {
        return new C0131a(new C0726p(), new C0759q(ijVar), new C0789r());
    }

    /* renamed from: b */
    public static <T> C0000a<T, ?, Long> m6089b(C0529ik<? super T> ikVar) {
        return new C0131a(f2460a, new C0818s(ikVar), new C0866t());
    }

    /* renamed from: b */
    public static <T> C0000a<T, ?, Double> m6087b(C0527ii<? super T> iiVar) {
        return new C0131a(f2461b, new C0904u(iiVar), new C0949v());
    }

    /* renamed from: f */
    public static <T> C0000a<T, ?, Long> m6097f() {
        return m6089b(new C0985w());
    }

    /* renamed from: a */
    public static <T> C0000a<T, ?, T> m6077a(T t, C0347da<T> daVar) {
        return new C0131a(new C1015x(t), new C1076z(daVar), new C0001aa());
    }

    /* renamed from: a */
    public static <T, R> C0000a<T, ?, R> m6078a(R r, C0391ei<? super T, ? extends R> eiVar, C0347da<R> daVar) {
        return new C0131a(new C0004ab(r), new C0005ac(daVar, eiVar), new C0009ad());
    }

    /* renamed from: a */
    public static <T, A, R> C0000a<T, ?, R> m6069a(C0496hg<? super T> hgVar, C0000a<? super T, A, R> aVar) {
        return new C0131a(aVar.mo3a(), new C0015ae(hgVar, aVar.mo4b()), aVar.mo5c());
    }

    /* renamed from: a */
    public static <T, U, A, R> C0000a<T, ?, R> m6062a(C0391ei<? super T, ? extends U> eiVar, C0000a<? super U, A, R> aVar) {
        return new C0131a(aVar.mo3a(), new C0025af(aVar.mo4b(), eiVar), aVar.mo5c());
    }

    /* renamed from: b */
    public static <T, U, A, R> C0000a<T, ?, R> m6083b(C0391ei<? super T, ? extends C0325cn<? extends U>> eiVar, C0000a<? super U, A, R> aVar) {
        return new C0131a(aVar.mo3a(), new C0031ag(eiVar, aVar.mo4b()), aVar.mo5c());
    }

    /* renamed from: a */
    public static <T, A, IR, OR> C0000a<T, A, OR> m6059a(C0000a<T, A, IR> aVar, C0391ei<IR, OR> eiVar) {
        C0391ei<A, IR> c = aVar.mo5c();
        if (c == null) {
            c = m6098g();
        }
        return new C0131a(aVar.mo3a(), aVar.mo4b(), C0391ei.C0392a.m12115b(c, eiVar));
    }

    /* renamed from: c */
    public static <T, K> C0000a<T, ?, Map<K, List<T>>> m6093c(C0391ei<? super T, ? extends K> eiVar) {
        return m6094c(eiVar, m6058a());
    }

    /* renamed from: c */
    public static <T, K, A, D> C0000a<T, ?, Map<K, D>> m6094c(C0391ei<? super T, ? extends K> eiVar, C0000a<? super T, A, D> aVar) {
        return m6067a(eiVar, m6099h(), aVar);
    }

    /* renamed from: a */
    public static <T, K, D, A, M extends Map<K, D>> C0000a<T, ?, M> m6067a(C0391ei<? super T, ? extends K> eiVar, C0506hp<M> hpVar, C0000a<? super T, A, D> aVar) {
        C0391ei<A, D> c = aVar.mo5c();
        return new C0131a(hpVar, new C0052aj(eiVar, aVar), c != null ? new C0048ai(c) : null);
    }

    /* renamed from: a */
    public static <T> C0000a<T, ?, Map<Boolean, List<T>>> m6068a(C0496hg<? super T> hgVar) {
        return m6086b(hgVar, m6058a());
    }

    /* renamed from: b */
    public static <T, D, A> C0000a<T, ?, Map<Boolean, D>> m6086b(C0496hg<? super T> hgVar, C0000a<? super T, A, D> aVar) {
        return new C0131a(new C0054al(aVar), new C0071am(aVar.mo4b(), hgVar), new C0075an(aVar));
    }

    /* renamed from: h */
    private static <K, V> C0506hp<Map<K, V>> m6099h() {
        return new C0077ao();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static IllegalStateException m6090b(Object obj, Object obj2, Object obj3) {
        return new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", new Object[]{obj, obj2, obj3}));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <K, V> void m6091b(Map<K, V> map, K k, V v, C0347da<V> daVar) {
        V v2 = map.get(k);
        if (v2 != null) {
            v = daVar.mo4893a(v2, v);
        }
        if (v == null) {
            map.remove(k);
        } else {
            map.put(k, v);
        }
    }

    /* renamed from: i */
    private static <K, V> C0530il<Map<K, V>> m6100i() {
        return new C0080ap();
    }

    /* renamed from: g */
    static <A, R> C0391ei<A, R> m6098g() {
        return new C0088aq();
    }

    /* renamed from: atakplugin.UASTool.b$b */
    private static final class C0132b<A> {

        /* renamed from: a */
        A f2465a;

        C0132b(A a) {
            this.f2465a = a;
        }
    }

    /* renamed from: atakplugin.UASTool.b$c */
    private static final class C0133c<A> {

        /* renamed from: a */
        final A f2466a;

        /* renamed from: b */
        final A f2467b;

        C0133c(A a, A a2) {
            this.f2466a = a;
            this.f2467b = a2;
        }
    }

    /* renamed from: atakplugin.UASTool.b$a */
    private static final class C0131a<T, A, R> implements C0000a<T, A, R> {

        /* renamed from: a */
        private final C0506hp<A> f2462a;

        /* renamed from: b */
        private final C0339cv<A, T> f2463b;

        /* renamed from: c */
        private final C0391ei<A, R> f2464c;

        public C0131a(C0506hp<A> hpVar, C0339cv<A, T> cvVar) {
            this(hpVar, cvVar, (C0391ei) null);
        }

        public C0131a(C0506hp<A> hpVar, C0339cv<A, T> cvVar, C0391ei<A, R> eiVar) {
            this.f2462a = hpVar;
            this.f2463b = cvVar;
            this.f2464c = eiVar;
        }

        /* renamed from: a */
        public C0506hp<A> mo3a() {
            return this.f2462a;
        }

        /* renamed from: b */
        public C0339cv<A, T> mo4b() {
            return this.f2463b;
        }

        /* renamed from: c */
        public C0391ei<A, R> mo5c() {
            return this.f2464c;
        }
    }
}
