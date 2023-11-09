package atakplugin.UASTool;

import atakplugin.UASTool.ayh;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo1538e = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class bah extends bae {

    /* renamed from: a */
    private transient ayd<Object> f2484a;

    /* renamed from: b */
    private final ayh f2485b;

    public bah(ayd<Object> ayd, ayh ayh) {
        super(ayd);
        this.f2485b = ayh;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public bah(ayd<Object> ayd) {
        this(ayd, ayd != null ? ayd.mo2153a() : null);
    }

    /* renamed from: a */
    public ayh mo2153a() {
        ayh ayh = this.f2485b;
        if (ayh == null) {
            bfq.m6538a();
        }
        return ayh;
    }

    /* renamed from: f */
    public final ayd<Object> mo2221f() {
        ayd<Object> ayd = this.f2484a;
        if (ayd == null) {
            aye aye = (aye) mo2153a().mo2141a(aye.f2381a);
            if (aye == null || (ayd = aye.mo2155a(this)) == null) {
                ayd = this;
            }
            this.f2484a = ayd;
        }
        return ayd;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo2217b() {
        ayd<Object> ayd = this.f2484a;
        if (!(ayd == null || ayd == this)) {
            ayh.C0115b a = mo2153a().mo2141a(aye.f2381a);
            if (a == null) {
                bfq.m6538a();
            }
            ((aye) a).mo2156b((ayd<?>) ayd);
        }
        this.f2484a = bag.f2483a;
    }
}
