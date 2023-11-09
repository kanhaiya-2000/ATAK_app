package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, mo1538e = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class azy extends bah {

    /* renamed from: a */
    final /* synthetic */ bdl f2453a;

    /* renamed from: b */
    final /* synthetic */ ayd f2454b;

    /* renamed from: c */
    final /* synthetic */ ayh f2455c;

    /* renamed from: d */
    private int f2456d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public azy(bdl bdl, ayd ayd, ayh ayh, ayd ayd2, ayh ayh2) {
        super(ayd2, ayh2);
        this.f2453a = bdl;
        this.f2454b = ayd;
        this.f2455c = ayh;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo2064a(Object obj) {
        int i = this.f2456d;
        if (i == 0) {
            this.f2456d = 1;
            apk.m2620a(obj);
            return this.f2453a.invoke(this);
        } else if (i == 1) {
            this.f2456d = 2;
            apk.m2620a(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
