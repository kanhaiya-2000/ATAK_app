package atakplugin.UASTool;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, mo1538e = {"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class apl<T> implements aon<T>, Serializable {

    /* renamed from: a */
    public static final C0084a f2129a = new C0084a((bfd) null);

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater<apl<?>, Object> f2130e = AtomicReferenceFieldUpdater.newUpdater(apl.class, Object.class, "c");

    /* renamed from: b */
    private volatile bdk<? extends T> f2131b;

    /* renamed from: c */
    private volatile Object f2132c = aqk.f2167a;

    /* renamed from: d */
    private final Object f2133d = aqk.f2167a;

    public apl(bdk<? extends T> bdk) {
        bfq.m6567f(bdk, "initializer");
        this.f2131b = bdk;
    }

    /* renamed from: b */
    public T mo1522b() {
        T t = this.f2132c;
        if (t != aqk.f2167a) {
            return t;
        }
        bdk<? extends T> bdk = this.f2131b;
        if (bdk != null) {
            T invoke = bdk.invoke();
            if (f2130e.compareAndSet(this, aqk.f2167a, invoke)) {
                this.f2131b = null;
                return invoke;
            }
        }
        return this.f2132c;
    }

    /* renamed from: a */
    public boolean mo1521a() {
        return this.f2132c != aqk.f2167a;
    }

    public String toString() {
        return mo1521a() ? String.valueOf(mo1522b()) : "Lazy value not initialized yet.";
    }

    /* renamed from: c */
    private final Object m2629c() {
        return new aoj(mo1522b());
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R^\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo1538e = {"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.apl$a */
    public static final class C0084a {
        private C0084a() {
        }

        public /* synthetic */ C0084a(bfd bfd) {
            this();
        }
    }
}
