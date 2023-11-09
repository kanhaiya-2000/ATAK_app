package atakplugin.UASTool;

import atakplugin.UASTool.ayh;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"})
public abstract class axz implements ayh.C0115b {

    /* renamed from: a */
    private final ayh.C0117c<?> f2370a;

    public axz(ayh.C0117c<?> cVar) {
        bfq.m6567f(cVar, "key");
        this.f2370a = cVar;
    }

    /* renamed from: a */
    public <E extends ayh.C0115b> E mo2141a(ayh.C0117c<E> cVar) {
        bfq.m6567f(cVar, "key");
        return ayh.C0115b.C0116a.m5885a((ayh.C0115b) this, cVar);
    }

    /* renamed from: a */
    public ayh.C0117c<?> mo2142a() {
        return this.f2370a;
    }

    /* renamed from: a */
    public ayh mo2143a(ayh ayh) {
        bfq.m6567f(ayh, "context");
        return ayh.C0115b.C0116a.m5886a((ayh.C0115b) this, ayh);
    }

    /* renamed from: a */
    public <R> R mo2144a(R r, bdw<? super R, ? super ayh.C0115b, ? extends R> bdw) {
        bfq.m6567f(bdw, "operation");
        return ayh.C0115b.C0116a.m5887a(this, r, bdw);
    }

    /* renamed from: b */
    public ayh mo2145b(ayh.C0117c<?> cVar) {
        bfq.m6567f(cVar, "key");
        return ayh.C0115b.C0116a.m5888b(this, cVar);
    }
}
