package atakplugin.UASTool;

import atakplugin.UASTool.ayq;
import atakplugin.UASTool.ayr;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, mo1538e = {"Lkotlin/coroutines/experimental/migration/ExperimentalContinuationInterceptorMigration;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "interceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "(Lkotlin/coroutines/ContinuationInterceptor;)V", "getInterceptor", "()Lkotlin/coroutines/ContinuationInterceptor;", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/experimental/CoroutineContext$Key;", "interceptContinuation", "Lkotlin/coroutines/experimental/Continuation;", "T", "continuation", "kotlin-stdlib-coroutines"})
final class azp implements ayq {

    /* renamed from: b */
    private final aye f2440b;

    public azp(aye aye) {
        bfq.m6567f(aye, "interceptor");
        this.f2440b = aye;
    }

    /* renamed from: a */
    public <E extends ayr.C0122b> E mo2164a(ayr.C0124c<E> cVar) {
        bfq.m6567f(cVar, "key");
        return ayq.C0119a.m5922a((ayq) this, cVar);
    }

    /* renamed from: a */
    public ayr mo2166a(ayr ayr) {
        bfq.m6567f(ayr, "context");
        return ayq.C0119a.m5923a((ayq) this, ayr);
    }

    /* renamed from: a */
    public <R> R mo2167a(R r, bdw<? super R, ? super ayr.C0122b, ? extends R> bdw) {
        bfq.m6567f(bdw, "operation");
        return ayq.C0119a.m5924a(this, r, bdw);
    }

    /* renamed from: b */
    public final aye mo2206b() {
        return this.f2440b;
    }

    /* renamed from: b */
    public ayr mo2168b(ayr.C0124c<?> cVar) {
        bfq.m6567f(cVar, "key");
        return ayq.C0119a.m5925b(this, cVar);
    }

    /* renamed from: a */
    public ayr.C0124c<?> mo2165a() {
        return ayq.f2396a;
    }

    /* renamed from: a */
    public <T> ayp<T> mo2178a(ayp<? super T> ayp) {
        bfq.m6567f(ayp, "continuation");
        return azn.m6023a(this.f2440b.mo2155a(azn.m6020a(ayp)));
    }
}
