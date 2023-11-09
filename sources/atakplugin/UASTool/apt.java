package atakplugin.UASTool;

import java.io.Serializable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, mo1538e = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class apt<T> implements aon<T>, Serializable {

    /* renamed from: a */
    private bdk<? extends T> f2134a;

    /* renamed from: b */
    private volatile Object f2135b;

    /* renamed from: c */
    private final Object f2136c;

    public apt(bdk<? extends T> bdk, Object obj) {
        bfq.m6567f(bdk, "initializer");
        this.f2134a = bdk;
        this.f2135b = aqk.f2167a;
        this.f2136c = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ apt(bdk bdk, Object obj, int i, bfd bfd) {
        this(bdk, (i & 2) != 0 ? null : obj);
    }

    /* renamed from: b */
    public T mo1522b() {
        T t;
        T t2 = this.f2135b;
        if (t2 != aqk.f2167a) {
            return t2;
        }
        synchronized (this.f2136c) {
            t = this.f2135b;
            if (t == aqk.f2167a) {
                bdk bdk = this.f2134a;
                if (bdk == null) {
                    bfq.m6538a();
                }
                t = bdk.invoke();
                this.f2135b = t;
                this.f2134a = null;
            }
        }
        return t;
    }

    /* renamed from: a */
    public boolean mo1521a() {
        return this.f2135b != aqk.f2167a;
    }

    public String toString() {
        return mo1521a() ? String.valueOf(mo1522b()) : "Lazy value not initialized yet.";
    }

    /* renamed from: c */
    private final Object m2648c() {
        return new aoj(mo1522b());
    }
}
