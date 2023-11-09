package atakplugin.UASTool;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0001\u0018\u0000 \u0015*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0015\u0016B\u0015\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004B\u001f\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0001J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo1538e = {"Lkotlin/coroutines/experimental/SafeContinuation;", "T", "Lkotlin/coroutines/experimental/Continuation;", "delegate", "(Lkotlin/coroutines/experimental/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/experimental/Continuation;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "result", "getResult", "resume", "", "value", "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "Companion", "Fail", "kotlin-stdlib-coroutines"})
public final class ayw<T> implements ayp<T> {

    /* renamed from: a */
    public static final C0125a f2400a = new C0125a((bfd) null);

    /* renamed from: d */
    private static final Object f2401d = new Object();

    /* renamed from: e */
    private static final Object f2402e = new Object();

    /* renamed from: f */
    private static final AtomicReferenceFieldUpdater<ayw<?>, Object> f2403f = AtomicReferenceFieldUpdater.newUpdater(ayw.class, Object.class, "b");

    /* renamed from: b */
    private volatile Object f2404b;

    /* renamed from: c */
    private final ayp<T> f2405c;

    public ayw(ayp<? super T> ayp, Object obj) {
        bfq.m6567f(ayp, "delegate");
        this.f2405c = ayp;
        this.f2404b = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ayw(ayp<? super T> ayp) {
        this(ayp, f2401d);
        bfq.m6567f(ayp, "delegate");
    }

    /* renamed from: a */
    public ayr mo2175a() {
        return this.f2405c.mo2175a();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002RZ\u0010\u0003\u001aF\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \u0006*\"\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo1538e = {"Lkotlin/coroutines/experimental/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/experimental/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT$annotations", "RESUMED", "UNDECIDED", "kotlin-stdlib-coroutines"})
    /* renamed from: atakplugin.UASTool.ayw$a */
    public static final class C0125a {
        @bcz
        /* renamed from: a */
        private static /* synthetic */ void m5958a() {
        }

        private C0125a() {
        }

        public /* synthetic */ C0125a(bfd bfd) {
            this();
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/coroutines/experimental/SafeContinuation$Fail;", "", "exception", "", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "kotlin-stdlib-coroutines"})
    /* renamed from: atakplugin.UASTool.ayw$b */
    private static final class C0126b {

        /* renamed from: a */
        private final Throwable f2406a;

        public C0126b(Throwable th) {
            bfq.m6567f(th, "exception");
            this.f2406a = th;
        }

        /* renamed from: a */
        public final Throwable mo2183a() {
            return this.f2406a;
        }
    }

    /* renamed from: a */
    public void mo2176a(T t) {
        while (true) {
            Object obj = this.f2404b;
            Object obj2 = f2401d;
            if (obj == obj2) {
                if (f2403f.compareAndSet(this, obj2, t)) {
                    return;
                }
            } else if (obj != azc.m5981b()) {
                throw new IllegalStateException("Already resumed");
            } else if (f2403f.compareAndSet(this, azc.m5981b(), f2402e)) {
                this.f2405c.mo2176a(t);
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo2177a(Throwable th) {
        bfq.m6567f(th, "exception");
        while (true) {
            Object obj = this.f2404b;
            Object obj2 = f2401d;
            if (obj == obj2) {
                if (f2403f.compareAndSet(this, obj2, new C0126b(th))) {
                    return;
                }
            } else if (obj != azc.m5981b()) {
                throw new IllegalStateException("Already resumed");
            } else if (f2403f.compareAndSet(this, azc.m5981b(), f2402e)) {
                this.f2405c.mo2177a(th);
                return;
            }
        }
    }

    /* renamed from: b */
    public final Object mo2182b() {
        Object obj = this.f2404b;
        Object obj2 = f2401d;
        if (obj == obj2) {
            if (f2403f.compareAndSet(this, obj2, azc.m5981b())) {
                return azc.m5981b();
            }
            obj = this.f2404b;
        }
        if (obj == f2402e) {
            return azc.m5981b();
        }
        if (!(obj instanceof C0126b)) {
            return obj;
        }
        throw ((C0126b) obj).mo2183a();
    }
}
