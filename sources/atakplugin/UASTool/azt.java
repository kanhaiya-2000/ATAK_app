package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\"\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004B-\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\tJ.\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0010R1\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, mo1538e = {"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction2Migration;", "T1", "T2", "R", "Lkotlin/Function3;", "Lkotlin/coroutines/experimental/Continuation;", "", "function", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function3;)V", "getFunction", "()Lkotlin/jvm/functions/Function3;", "invoke", "t1", "t2", "continuation", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"})
final class azt<T1, T2, R> implements bea<T1, T2, ayp<? super R>, Object> {

    /* renamed from: a */
    private final bea<T1, T2, ayd<? super R>, Object> f2445a;

    public azt(bea<? super T1, ? super T2, ? super ayd<? super R>, ? extends Object> bea) {
        bfq.m6567f(bea, "function");
        this.f2445a = bea;
    }

    /* renamed from: a */
    public final bea<T1, T2, ayd<? super R>, Object> mo2212a() {
        return this.f2445a;
    }

    /* renamed from: a */
    public Object mo2214a(T1 t1, T2 t2, ayp<? super R> ayp) {
        bfq.m6567f(ayp, "continuation");
        return this.f2445a.mo2214a(t1, t2, azn.m6020a(ayp));
    }
}
