package atakplugin.UASTool;

import java.io.Serializable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, mo1538e = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
public final class aqs<T> implements aon<T>, Serializable {

    /* renamed from: a */
    private bdk<? extends T> f2178a;

    /* renamed from: b */
    private Object f2179b = aqk.f2167a;

    public aqs(bdk<? extends T> bdk) {
        bfq.m6567f(bdk, "initializer");
        this.f2178a = bdk;
    }

    /* renamed from: b */
    public T mo1522b() {
        if (this.f2179b == aqk.f2167a) {
            bdk<? extends T> bdk = this.f2178a;
            if (bdk == null) {
                bfq.m6538a();
            }
            this.f2179b = bdk.invoke();
            this.f2178a = null;
        }
        return this.f2179b;
    }

    /* renamed from: a */
    public boolean mo1521a() {
        return this.f2179b != aqk.f2167a;
    }

    public String toString() {
        return mo1521a() ? String.valueOf(mo1522b()) : "Lazy value not initialized yet.";
    }

    /* renamed from: c */
    private final Object m3021c() {
        return new aoj(mo1522b());
    }
}
