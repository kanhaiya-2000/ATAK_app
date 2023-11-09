package atakplugin.UASTool;

import atakplugin.UASTool.ayh;
import atakplugin.UASTool.bgo;
import java.io.Serializable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo1538e = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"})
public final class aya implements ayh, Serializable {

    /* renamed from: a */
    private final ayh f2373a;

    /* renamed from: b */
    private final ayh.C0115b f2374b;

    public aya(ayh ayh, ayh.C0115b bVar) {
        bfq.m6567f(ayh, "left");
        bfq.m6567f(bVar, "element");
        this.f2373a = ayh;
        this.f2374b = bVar;
    }

    /* renamed from: a */
    public ayh mo2143a(ayh ayh) {
        bfq.m6567f(ayh, "context");
        return ayh.C0114a.m5880a(this, ayh);
    }

    /* renamed from: a */
    public <E extends ayh.C0115b> E mo2141a(ayh.C0117c<E> cVar) {
        bfq.m6567f(cVar, "key");
        ayh ayh = this;
        while (true) {
            aya aya = (aya) ayh;
            E a = aya.f2374b.mo2141a(cVar);
            if (a != null) {
                return a;
            }
            ayh = aya.f2373a;
            if (!(ayh instanceof aya)) {
                return ayh.mo2141a(cVar);
            }
        }
    }

    /* renamed from: a */
    public <R> R mo2144a(R r, bdw<? super R, ? super ayh.C0115b, ? extends R> bdw) {
        bfq.m6567f(bdw, "operation");
        return bdw.mo2065a(this.f2373a.mo2144a(r, bdw), this.f2374b);
    }

    /* renamed from: b */
    public ayh mo2145b(ayh.C0117c<?> cVar) {
        bfq.m6567f(cVar, "key");
        if (this.f2374b.mo2141a(cVar) != null) {
            return this.f2373a;
        }
        ayh b = this.f2373a.mo2145b(cVar);
        if (b == this.f2373a) {
            return this;
        }
        if (b == ayj.f2386a) {
            return this.f2374b;
        }
        return new aya(b, this.f2374b);
    }

    /* renamed from: a */
    private final int m5839a() {
        aya aya = this;
        int i = 2;
        while (true) {
            ayh ayh = aya.f2373a;
            if (!(ayh instanceof aya)) {
                ayh = null;
            }
            aya = (aya) ayh;
            if (aya == null) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: a */
    private final boolean m5841a(ayh.C0115b bVar) {
        return bfq.m6552a((Object) mo2141a(bVar.mo2142a()), (Object) bVar);
    }

    /* renamed from: a */
    private final boolean m5840a(aya aya) {
        while (m5841a(aya.f2374b)) {
            ayh ayh = aya.f2373a;
            if (ayh instanceof aya) {
                aya = (aya) ayh;
            } else if (ayh != null) {
                return m5841a((ayh.C0115b) ayh);
            } else {
                throw new apx("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof aya) {
                aya aya = (aya) obj;
                if (aya.m5839a() != m5839a() || !aya.m5840a(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f2373a.hashCode() + this.f2374b.hashCode();
    }

    public String toString() {
        return "[" + ((String) mo2144a("", ayb.f2378a)) + "]";
    }

    /* renamed from: b */
    private final Object m5842b() {
        int a = m5839a();
        ayh[] ayhArr = new ayh[a];
        bgo.C0156f fVar = new bgo.C0156f();
        boolean z = false;
        fVar.f2666a = 0;
        mo2144a(aqr.f2177a, new ayc(ayhArr, fVar));
        if (fVar.f2666a == a) {
            z = true;
        }
        if (z) {
            return new C0110a(ayhArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo1538e = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.aya$a */
    private static final class C0110a implements Serializable {

        /* renamed from: a */
        public static final C0111a f2375a = new C0111a((bfd) null);

        /* renamed from: c */
        private static final long f2376c = 0;

        /* renamed from: b */
        private final ayh[] f2377b;

        @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo1538e = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
        /* renamed from: atakplugin.UASTool.aya$a$a */
        public static final class C0111a {
            private C0111a() {
            }

            public /* synthetic */ C0111a(bfd bfd) {
                this();
            }
        }

        public C0110a(ayh[] ayhArr) {
            bfq.m6567f(ayhArr, "elements");
            this.f2377b = ayhArr;
        }

        /* renamed from: a */
        public final ayh[] mo2150a() {
            return this.f2377b;
        }

        /* renamed from: b */
        private final Object m5847b() {
            ayh[] ayhArr = this.f2377b;
            ayh ayh = ayj.f2386a;
            for (ayh a : ayhArr) {
                ayh = ayh.mo2143a(a);
            }
            return ayh;
        }
    }
}
