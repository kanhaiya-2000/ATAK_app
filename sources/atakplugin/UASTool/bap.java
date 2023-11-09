package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R%\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo1538e = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/Result;", "getResult", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "await", "resumeWith", "(Ljava/lang/Object;)V", "kotlin-stdlib"})
final class bap implements ayd<aqr> {

    /* renamed from: a */
    private apj<aqr> f2494a;

    /* renamed from: a */
    public ayh mo2153a() {
        return ayj.f2386a;
    }

    /* renamed from: a */
    public final void mo2232a(apj<aqr> apj) {
        this.f2494a = apj;
    }

    /* renamed from: b */
    public final apj<aqr> mo2233b() {
        return this.f2494a;
    }

    /* renamed from: b */
    public void mo2154b(Object obj) {
        synchronized (this) {
            this.f2494a = apj.m2609f(obj);
            notifyAll();
            aqr aqr = aqr.f2177a;
        }
    }

    /* renamed from: c */
    public final void mo2234c() {
        synchronized (this) {
            while (true) {
                apj<aqr> apj = this.f2494a;
                if (apj == null) {
                    wait();
                } else {
                    apk.m2620a(apj.mo1554b());
                }
            }
        }
    }
}
