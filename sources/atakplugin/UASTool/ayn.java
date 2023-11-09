package atakplugin.UASTool;

import atakplugin.UASTool.ayr;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0000H\u0002J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J5\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00120\u0015H\u0016¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0014\u0010\u001e\u001a\u00020\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\""}, mo1538e = {"Lkotlin/coroutines/experimental/CombinedContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "left", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/CoroutineContext$Element;)V", "getElement", "()Lkotlin/coroutines/experimental/CoroutineContext$Element;", "getLeft", "()Lkotlin/coroutines/experimental/CoroutineContext;", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "kotlin-stdlib-coroutines"})
public final class ayn implements ayr {

    /* renamed from: a */
    private final ayr f2393a;

    /* renamed from: b */
    private final ayr.C0122b f2394b;

    public ayn(ayr ayr, ayr.C0122b bVar) {
        bfq.m6567f(ayr, "left");
        bfq.m6567f(bVar, "element");
        this.f2393a = ayr;
        this.f2394b = bVar;
    }

    /* renamed from: a */
    public final ayr mo2169a() {
        return this.f2393a;
    }

    /* renamed from: a */
    public ayr mo2166a(ayr ayr) {
        bfq.m6567f(ayr, "context");
        return ayr.C0121a.m5930a(this, ayr);
    }

    /* renamed from: b */
    public final ayr.C0122b mo2170b() {
        return this.f2394b;
    }

    /* renamed from: a */
    public <E extends ayr.C0122b> E mo2164a(ayr.C0124c<E> cVar) {
        bfq.m6567f(cVar, "key");
        ayr ayr = this;
        while (true) {
            ayn ayn = (ayn) ayr;
            E a = ayn.f2394b.mo2164a(cVar);
            if (a != null) {
                return a;
            }
            ayr = ayn.f2393a;
            if (!(ayr instanceof ayn)) {
                return ayr.mo2164a(cVar);
            }
        }
    }

    /* renamed from: a */
    public <R> R mo2167a(R r, bdw<? super R, ? super ayr.C0122b, ? extends R> bdw) {
        bfq.m6567f(bdw, "operation");
        return bdw.mo2065a(this.f2393a.mo2167a(r, bdw), this.f2394b);
    }

    /* renamed from: b */
    public ayr mo2168b(ayr.C0124c<?> cVar) {
        bfq.m6567f(cVar, "key");
        if (this.f2394b.mo2164a(cVar) != null) {
            return this.f2393a;
        }
        ayr b = this.f2393a.mo2168b(cVar);
        if (b == this.f2393a) {
            return this;
        }
        if (b == ayu.f2399a) {
            return this.f2394b;
        }
        return new ayn(b, this.f2394b);
    }

    /* renamed from: c */
    private final int m5909c() {
        ayr ayr = this.f2393a;
        if (ayr instanceof ayn) {
            return ((ayn) ayr).m5909c() + 1;
        }
        return 2;
    }

    /* renamed from: a */
    private final boolean m5908a(ayr.C0122b bVar) {
        return bfq.m6552a((Object) mo2164a(bVar.mo2165a()), (Object) bVar);
    }

    /* renamed from: a */
    private final boolean m5907a(ayn ayn) {
        while (m5908a(ayn.f2394b)) {
            ayr ayr = ayn.f2393a;
            if (ayr instanceof ayn) {
                ayn = (ayn) ayr;
            } else if (ayr != null) {
                return m5908a((ayr.C0122b) ayr);
            } else {
                throw new apx("null cannot be cast to non-null type kotlin.coroutines.experimental.CoroutineContext.Element");
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ayn) {
                ayn ayn = (ayn) obj;
                if (ayn.m5909c() != m5909c() || !ayn.m5907a(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f2393a.hashCode() + this.f2394b.hashCode();
    }

    public String toString() {
        return "[" + ((String) mo2167a("", ayo.f2395a)) + "]";
    }
}
