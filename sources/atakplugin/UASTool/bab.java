package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo1538e = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class bab extends ban {

    /* renamed from: a */
    final /* synthetic */ ayd f2473a;

    /* renamed from: b */
    final /* synthetic */ bdw f2474b;

    /* renamed from: c */
    final /* synthetic */ Object f2475c;

    /* renamed from: d */
    private int f2476d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bab(ayd ayd, ayd ayd2, bdw bdw, Object obj) {
        super(ayd2);
        this.f2473a = ayd;
        this.f2474b = bdw;
        this.f2475c = obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo2064a(Object obj) {
        int i = this.f2476d;
        if (i == 0) {
            this.f2476d = 1;
            apk.m2620a(obj);
            ayd ayd = this;
            bdw bdw = this.f2474b;
            if (bdw != null) {
                return ((bdw) bgv.m6753b((Object) bdw, 2)).mo2065a(this.f2475c, ayd);
            }
            throw new apx("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } else if (i == 1) {
            this.f2476d = 2;
            apk.m2620a(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
