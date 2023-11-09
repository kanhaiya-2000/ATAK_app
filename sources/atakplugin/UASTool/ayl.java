package atakplugin.UASTool;

import atakplugin.UASTool.apj;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, mo1538e = {"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"})
public final class ayl<T> implements ayd<T>, bai {
    @Deprecated

    /* renamed from: a */
    public static final C0118a f2388a = new C0118a((bfd) null);

    /* renamed from: d */
    private static final AtomicReferenceFieldUpdater<ayl<?>, Object> f2389d = AtomicReferenceFieldUpdater.newUpdater(ayl.class, Object.class, "b");

    /* renamed from: b */
    private volatile Object f2390b;

    /* renamed from: c */
    private final ayd<T> f2391c;

    /* renamed from: d */
    public StackTraceElement mo2162d() {
        return null;
    }

    public ayl(ayd<? super T> ayd, Object obj) {
        bfq.m6567f(ayd, "delegate");
        this.f2391c = ayd;
        this.f2390b = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ayl(ayd<? super T> ayd) {
        this(ayd, azu.UNDECIDED);
        bfq.m6567f(ayd, "delegate");
    }

    /* renamed from: a */
    public ayh mo2153a() {
        return this.f2391c.mo2153a();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002RZ\u0010\u0003\u001aF\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \u0006*\"\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, mo1538e = {"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT$annotations", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.ayl$a */
    private static final class C0118a {
        @bcz
        /* renamed from: a */
        private static /* synthetic */ void m5901a() {
        }

        private C0118a() {
        }

        public /* synthetic */ C0118a(bfd bfd) {
            this();
        }
    }

    /* renamed from: b */
    public void mo2154b(Object obj) {
        while (true) {
            Object obj2 = this.f2390b;
            if (obj2 == azu.UNDECIDED) {
                if (f2389d.compareAndSet(this, azu.UNDECIDED, obj)) {
                    return;
                }
            } else if (obj2 != azv.m6108b()) {
                throw new IllegalStateException("Already resumed");
            } else if (f2389d.compareAndSet(this, azv.m6108b(), azu.RESUMED)) {
                this.f2391c.mo2154b(obj);
                return;
            }
        }
    }

    /* renamed from: b */
    public final Object mo2160b() {
        Object obj = this.f2390b;
        if (obj == azu.UNDECIDED) {
            if (f2389d.compareAndSet(this, azu.UNDECIDED, azv.m6108b())) {
                return azv.m6108b();
            }
            obj = this.f2390b;
        }
        if (obj == azu.RESUMED) {
            return azv.m6108b();
        }
        if (!(obj instanceof apj.C0083b)) {
            return obj;
        }
        throw ((apj.C0083b) obj).f2128a;
    }

    /* renamed from: c */
    public bai mo2161c() {
        ayd<T> ayd = this.f2391c;
        if (!(ayd instanceof bai)) {
            ayd = null;
        }
        return (bai) ayd;
    }

    public String toString() {
        return "SafeContinuation for " + this.f2391c;
    }
}
