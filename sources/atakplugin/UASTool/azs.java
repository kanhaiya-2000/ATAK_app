package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001c\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003B'\u0012 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0002¢\u0006\u0002\u0010\u000eR+\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, mo1538e = {"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction1Migration;", "T1", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "function", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;)V", "getFunction", "()Lkotlin/jvm/functions/Function2;", "invoke", "t1", "continuation", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"})
final class azs<T1, R> implements bdw<T1, ayp<? super R>, Object> {

    /* renamed from: a */
    private final bdw<T1, ayd<? super R>, Object> f2444a;

    public azs(bdw<? super T1, ? super ayd<? super R>, ? extends Object> bdw) {
        bfq.m6567f(bdw, "function");
        this.f2444a = bdw;
    }

    /* renamed from: a */
    public final bdw<T1, ayd<? super R>, Object> mo2210a() {
        return this.f2444a;
    }

    /* renamed from: a */
    public Object mo2065a(T1 t1, ayp<? super R> ayp) {
        bfq.m6567f(ayp, "continuation");
        return this.f2444a.mo2065a(t1, azn.m6020a(ayp));
    }
}
