package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0005H\u0007\u001a\f\u0010\f\u001a\u00020\t*\u00020\bH\u0007\u001a^\u0010\r\u001a\"\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011*\"\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eH\u0000\u001aL\u0010\r\u001a\u001c\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0013\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0011*\u001c\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0013H\u0000\u001a:\u0010\r\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014\"\u0004\b\u0000\u0010\u0011*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014H\u0000¨\u0006\u0015"}, mo1538e = {"toContinuation", "Lkotlin/coroutines/Continuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "toContinuationInterceptor", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/experimental/ContinuationInterceptor;", "toCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "toExperimentalContinuation", "toExperimentalContinuationInterceptor", "toExperimentalCoroutineContext", "toExperimentalSuspendFunction", "Lkotlin/Function3;", "T1", "T2", "R", "", "Lkotlin/Function2;", "Lkotlin/Function1;", "kotlin-stdlib-coroutines"})
public final class azn {
    /* renamed from: a */
    public static final <T> ayp<T> m6023a(ayd<? super T> ayd) {
        ayp<T> b;
        bfq.m6567f(ayd, "$this$toExperimentalContinuation");
        azm azm = (azm) (!(ayd instanceof azm) ? null : ayd);
        return (azm == null || (b = azm.mo2204b()) == null) ? new azq<>(ayd) : b;
    }

    /* renamed from: a */
    public static final <T> ayd<T> m6020a(ayp<? super T> ayp) {
        ayd<T> b;
        bfq.m6567f(ayp, "$this$toContinuation");
        azq azq = (azq) (!(ayp instanceof azq) ? null : ayp);
        return (azq == null || (b = azq.mo2207b()) == null) ? new azm<>(ayp) : b;
    }

    /* renamed from: a */
    public static final ayr m6025a(ayh ayh) {
        ayr ayr;
        bfq.m6567f(ayh, "$this$toExperimentalCoroutineContext");
        aye aye = (aye) ayh.mo2141a(aye.f2381a);
        azk azk = (azk) ayh.mo2141a(azk.f2433a);
        ayh b = ayh.mo2145b(aye.f2381a).mo2145b(azk.f2433a);
        if (azk == null || (ayr = azk.mo2202b()) == null) {
            ayr = ayu.f2399a;
        }
        if (b != ayj.f2386a) {
            ayr = ayr.mo2166a((ayr) new azo(b));
        }
        return aye == null ? ayr : ayr.mo2166a((ayr) m6024a(aye));
    }

    /* renamed from: a */
    public static final ayh m6022a(ayr ayr) {
        ayh ayh;
        bfq.m6567f(ayr, "$this$toCoroutineContext");
        ayq ayq = (ayq) ayr.mo2164a(ayq.f2396a);
        azo azo = (azo) ayr.mo2164a(azo.f2438a);
        ayr b = ayr.mo2168b(ayq.f2396a).mo2168b(azo.f2438a);
        if (azo == null || (ayh = azo.mo2205b()) == null) {
            ayh = ayj.f2386a;
        }
        if (b != ayu.f2399a) {
            ayh = ayh.mo2143a((ayh) new azk(b));
        }
        return ayq == null ? ayh : ayh.mo2143a((ayh) m6021a(ayq));
    }

    /* renamed from: a */
    public static final ayq m6024a(aye aye) {
        ayq b;
        bfq.m6567f(aye, "$this$toExperimentalContinuationInterceptor");
        azl azl = (azl) (!(aye instanceof azl) ? null : aye);
        return (azl == null || (b = azl.mo2203b()) == null) ? new azp(aye) : b;
    }

    /* renamed from: a */
    public static final aye m6021a(ayq ayq) {
        aye b;
        bfq.m6567f(ayq, "$this$toContinuationInterceptor");
        azp azp = (azp) (!(ayq instanceof azp) ? null : ayq);
        return (azp == null || (b = azp.mo2206b()) == null) ? new azl(ayq) : b;
    }

    /* renamed from: a */
    public static final <R> bdl<ayp<? super R>, Object> m6026a(bdl<? super ayd<? super R>, ? extends Object> bdl) {
        bfq.m6567f(bdl, "$this$toExperimentalSuspendFunction");
        return new azr<>(bdl);
    }

    /* renamed from: a */
    public static final <T1, R> bdw<T1, ayp<? super R>, Object> m6027a(bdw<? super T1, ? super ayd<? super R>, ? extends Object> bdw) {
        bfq.m6567f(bdw, "$this$toExperimentalSuspendFunction");
        return new azs<>(bdw);
    }

    /* renamed from: a */
    public static final <T1, T2, R> bea<T1, T2, ayp<? super R>, Object> m6028a(bea<? super T1, ? super T2, ? super ayd<? super R>, ? extends Object> bea) {
        bfq.m6567f(bea, "$this$toExperimentalSuspendFunction");
        return new azt<>(bea);
    }
}
