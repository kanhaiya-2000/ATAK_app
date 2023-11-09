package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H$J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00038\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00058\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo1538e = {"Lkotlin/coroutines/experimental/jvm/internal/CoroutineImpl;", "Lkotlin/jvm/internal/Lambda;", "", "Lkotlin/coroutines/experimental/Continuation;", "arity", "", "completion", "(ILkotlin/coroutines/experimental/Continuation;)V", "_context", "Lkotlin/coroutines/experimental/CoroutineContext;", "_facade", "context", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "facade", "getFacade", "()Lkotlin/coroutines/experimental/Continuation;", "label", "create", "", "value", "doResume", "data", "exception", "", "resume", "resumeWithException", "kotlin-stdlib-coroutines"})
public abstract class azi extends bfr<Object> implements ayp<Object> {

    /* renamed from: a */
    protected int f2429a;

    /* renamed from: b */
    protected ayp<Object> f2430b;

    /* renamed from: c */
    private final ayr f2431c;

    /* renamed from: d */
    private ayp<Object> f2432d;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo2200a(Object obj, Throwable th);

    public azi(int i, ayp<Object> ayp) {
        super(i);
        this.f2430b = ayp;
        this.f2429a = ayp != null ? 0 : -1;
        this.f2431c = ayp != null ? ayp.mo2175a() : null;
    }

    /* renamed from: a */
    public ayr mo2175a() {
        ayr ayr = this.f2431c;
        if (ayr == null) {
            bfq.m6538a();
        }
        return ayr;
    }

    /* renamed from: b */
    public final ayp<Object> mo2201b() {
        if (this.f2432d == null) {
            ayr ayr = this.f2431c;
            if (ayr == null) {
                bfq.m6538a();
            }
            this.f2432d = azj.m6007a(ayr, this);
        }
        ayp<Object> ayp = this.f2432d;
        if (ayp == null) {
            bfq.m6538a();
        }
        return ayp;
    }

    /* renamed from: a */
    public void mo2176a(Object obj) {
        ayp<Object> ayp = this.f2430b;
        if (ayp == null) {
            bfq.m6538a();
        }
        try {
            Object a = mo2200a(obj, (Throwable) null);
            if (a == azc.m5981b()) {
                return;
            }
            if (ayp != null) {
                ayp.mo2176a(a);
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
        ayp<Object> ayp = this.f2430b;
        if (ayp == null) {
            bfq.m6538a();
        }
        try {
            Object a = mo2200a((Object) null, th);
            if (a == azc.m5981b()) {
                return;
            }
            if (ayp != null) {
                ayp.mo2176a(a);
                return;
            }
            throw new apx("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
        } catch (Throwable th2) {
            ayp.mo2177a(th2);
        }
    }

    /* renamed from: a */
    public ayp<aqr> mo2198a(ayp<?> ayp) {
        bfq.m6567f(ayp, "completion");
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    /* renamed from: a */
    public ayp<aqr> mo2199a(Object obj, ayp<?> ayp) {
        bfq.m6567f(ayp, "completion");
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}
