package atakplugin.UASTool;

import atakplugin.UASTool.ayr;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "kotlin-stdlib-coroutines"})
public abstract class aym implements ayr.C0122b {

    /* renamed from: a */
    private final ayr.C0124c<?> f2392a;

    public aym(ayr.C0124c<?> cVar) {
        bfq.m6567f(cVar, "key");
        this.f2392a = cVar;
    }

    /* renamed from: a */
    public <E extends ayr.C0122b> E mo2164a(ayr.C0124c<E> cVar) {
        bfq.m6567f(cVar, "key");
        return ayr.C0122b.C0123a.m5935a((ayr.C0122b) this, cVar);
    }

    /* renamed from: a */
    public ayr.C0124c<?> mo2165a() {
        return this.f2392a;
    }

    /* renamed from: a */
    public ayr mo2166a(ayr ayr) {
        bfq.m6567f(ayr, "context");
        return ayr.C0122b.C0123a.m5936a((ayr.C0122b) this, ayr);
    }

    /* renamed from: a */
    public <R> R mo2167a(R r, bdw<? super R, ? super ayr.C0122b, ? extends R> bdw) {
        bfq.m6567f(bdw, "operation");
        return ayr.C0122b.C0123a.m5937a(this, r, bdw);
    }

    /* renamed from: b */
    public ayr mo2168b(ayr.C0124c<?> cVar) {
        bfq.m6567f(cVar, "key");
        return ayr.C0122b.C0123a.m5938b(this, cVar);
    }
}
