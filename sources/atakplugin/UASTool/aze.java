package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo1538e = {"kotlin/coroutines/experimental/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$buildContinuationByInvokeCall$continuation$1", "Lkotlin/coroutines/experimental/Continuation;", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "", "kotlin-stdlib-coroutines"})
public final class aze implements ayp<aqr> {

    /* renamed from: a */
    final /* synthetic */ ayp f2420a;

    /* renamed from: b */
    final /* synthetic */ bdk f2421b;

    public aze(ayp ayp, bdk bdk) {
        this.f2420a = ayp;
        this.f2421b = bdk;
    }

    /* renamed from: a */
    public ayr mo2175a() {
        return this.f2420a.mo2175a();
    }

    /* renamed from: a */
    public void mo2176a(aqr aqr) {
        bfq.m6567f(aqr, "value");
        ayp ayp = this.f2420a;
        try {
            Object invoke = this.f2421b.invoke();
            if (invoke == azc.m5981b()) {
                return;
            }
            if (ayp != null) {
                ayp.mo2176a(invoke);
                return;
            }
            throw new apx("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
        } catch (Throwable th) {
            ayp.mo2177a(th);
        }
    }

    /* renamed from: a */
    public void mo2177a(Throwable th) {
        bfq.m6567f(th, "exception");
        this.f2420a.mo2177a(th);
    }
}
