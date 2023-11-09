package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r¸\u0006\u0000"}, mo1538e = {"kotlin/coroutines/experimental/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$buildContinuationByInvokeCall$continuation$1", "Lkotlin/coroutines/experimental/Continuation;", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "", "kotlin-stdlib-coroutines"})
public final class azg implements ayp<aqr> {

    /* renamed from: a */
    final /* synthetic */ ayp f2425a;

    /* renamed from: b */
    final /* synthetic */ bdw f2426b;

    /* renamed from: c */
    final /* synthetic */ Object f2427c;

    /* renamed from: d */
    final /* synthetic */ ayp f2428d;

    public azg(ayp ayp, bdw bdw, Object obj, ayp ayp2) {
        this.f2425a = ayp;
        this.f2426b = bdw;
        this.f2427c = obj;
        this.f2428d = ayp2;
    }

    /* renamed from: a */
    public ayr mo2175a() {
        return this.f2425a.mo2175a();
    }

    /* renamed from: a */
    public void mo2176a(aqr aqr) {
        bfq.m6567f(aqr, "value");
        ayp ayp = this.f2425a;
        try {
            bdw bdw = this.f2426b;
            if (bdw != null) {
                Object a = ((bdw) bgv.m6753b((Object) bdw, 2)).mo2065a(this.f2427c, this.f2428d);
                if (a == azc.m5981b()) {
                    return;
                }
                if (ayp != null) {
                    ayp.mo2176a(a);
                    return;
                }
                throw new apx("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
            }
            throw new apx("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            ayp.mo2177a(th);
        }
    }

    /* renamed from: a */
    public void mo2177a(Throwable th) {
        bfq.m6567f(th, "exception");
        this.f2425a.mo2177a(th);
    }
}
