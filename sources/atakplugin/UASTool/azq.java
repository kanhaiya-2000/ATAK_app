package atakplugin.UASTool;

import atakplugin.UASTool.apj;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, mo1538e = {"Lkotlin/coroutines/experimental/migration/ExperimentalContinuationMigration;", "T", "Lkotlin/coroutines/experimental/Continuation;", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "resume", "", "value", "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "kotlin-stdlib-coroutines"})
final class azq<T> implements ayp<T> {

    /* renamed from: a */
    private final ayr f2441a;

    /* renamed from: b */
    private final ayd<T> f2442b;

    public azq(ayd<? super T> ayd) {
        bfq.m6567f(ayd, "continuation");
        this.f2442b = ayd;
        this.f2441a = azn.m6025a(ayd.mo2153a());
    }

    /* renamed from: b */
    public final ayd<T> mo2207b() {
        return this.f2442b;
    }

    /* renamed from: a */
    public ayr mo2175a() {
        return this.f2441a;
    }

    /* renamed from: a */
    public void mo2176a(T t) {
        ayd<T> ayd = this.f2442b;
        apj.C0082a aVar = apj.f2126a;
        ayd.mo2154b(apj.m2608e(t));
    }

    /* renamed from: a */
    public void mo2177a(Throwable th) {
        bfq.m6567f(th, "exception");
        ayd<T> ayd = this.f2442b;
        apj.C0082a aVar = apj.f2126a;
        ayd.mo2154b(apj.m2608e(apk.m2619a(th)));
    }
}
