package atakplugin.UASTool;

import atakplugin.UASTool.aye;
import atakplugin.UASTool.ayh;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, mo1538e = {"Lkotlin/coroutines/experimental/migration/ContinuationInterceptorMigration;", "Lkotlin/coroutines/ContinuationInterceptor;", "interceptor", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "(Lkotlin/coroutines/experimental/ContinuationInterceptor;)V", "getInterceptor", "()Lkotlin/coroutines/experimental/ContinuationInterceptor;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "kotlin-stdlib-coroutines"})
final class azl implements aye {

    /* renamed from: b */
    private final ayq f2435b;

    public azl(ayq ayq) {
        bfq.m6567f(ayq, "interceptor");
        this.f2435b = ayq;
    }

    /* renamed from: a */
    public <E extends ayh.C0115b> E mo2141a(ayh.C0117c<E> cVar) {
        bfq.m6567f(cVar, "key");
        return aye.C0112a.m5859a((aye) this, cVar);
    }

    /* renamed from: a */
    public ayh mo2143a(ayh ayh) {
        bfq.m6567f(ayh, "context");
        return aye.C0112a.m5860a((aye) this, ayh);
    }

    /* renamed from: a */
    public <R> R mo2144a(R r, bdw<? super R, ? super ayh.C0115b, ? extends R> bdw) {
        bfq.m6567f(bdw, "operation");
        return aye.C0112a.m5861a(this, r, bdw);
    }

    /* renamed from: b */
    public ayh mo2145b(ayh.C0117c<?> cVar) {
        bfq.m6567f(cVar, "key");
        return aye.C0112a.m5863b(this, cVar);
    }

    /* renamed from: b */
    public final ayq mo2203b() {
        return this.f2435b;
    }

    /* renamed from: b */
    public void mo2156b(ayd<?> ayd) {
        bfq.m6567f(ayd, "continuation");
        aye.C0112a.m5862a((aye) this, ayd);
    }

    /* renamed from: a */
    public ayh.C0117c<?> mo2142a() {
        return aye.f2381a;
    }

    /* renamed from: a */
    public <T> ayd<T> mo2155a(ayd<? super T> ayd) {
        bfq.m6567f(ayd, "continuation");
        return azn.m6020a(this.f2435b.mo2178a(azn.m6023a(ayd)));
    }
}
