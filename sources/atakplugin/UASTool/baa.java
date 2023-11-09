package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo1538e = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class baa extends bah {

    /* renamed from: a */
    final /* synthetic */ ayd f2469a;

    /* renamed from: b */
    final /* synthetic */ ayh f2470b;

    /* renamed from: c */
    final /* synthetic */ bdl f2471c;

    /* renamed from: d */
    private int f2472d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public baa(ayd ayd, ayh ayh, ayd ayd2, ayh ayh2, bdl bdl) {
        super(ayd2, ayh2);
        this.f2469a = ayd;
        this.f2470b = ayh;
        this.f2471c = bdl;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo2064a(Object obj) {
        int i = this.f2472d;
        if (i == 0) {
            this.f2472d = 1;
            apk.m2620a(obj);
            ayd ayd = this;
            bdl bdl = this.f2471c;
            if (bdl != null) {
                return ((bdl) bgv.m6753b((Object) bdl, 1)).invoke(ayd);
            }
            throw new apx("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } else if (i == 1) {
            this.f2472d = 2;
            apk.m2620a(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
