package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo1538e = {"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration", "()D", "D", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;D)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class bpz<T> {

    /* renamed from: a */
    private final T f3140a;

    /* renamed from: b */
    private final double f3141b;

    /* renamed from: a */
    public static /* synthetic */ bpz m8548a(bpz bpz, T t, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            t = bpz.f3140a;
        }
        if ((i & 2) != 0) {
            d = bpz.f3141b;
        }
        return bpz.mo2969a(t, d);
    }

    /* renamed from: a */
    public final bpz<T> mo2969a(T t, double d) {
        return new bpz<>(t, d);
    }

    /* renamed from: c */
    public final T mo2972c() {
        return this.f3140a;
    }

    /* renamed from: d */
    public final double mo2973d() {
        return this.f3141b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bpz)) {
            return false;
        }
        bpz bpz = (bpz) obj;
        return bfq.m6552a((Object) this.f3140a, (Object) bpz.f3140a) && Double.compare(this.f3141b, bpz.f3141b) == 0;
    }

    public int hashCode() {
        T t = this.f3140a;
        int hashCode = t != null ? t.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.f3141b);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        return "TimedValue(value=" + this.f3140a + ", duration=" + bpo.m8473u(this.f3141b) + ")";
    }

    private bpz(T t, double d) {
        this.f3140a = t;
        this.f3141b = d;
    }

    public /* synthetic */ bpz(Object obj, double d, bfd bfd) {
        this(obj, d);
    }

    /* renamed from: a */
    public final T mo2970a() {
        return this.f3140a;
    }

    /* renamed from: b */
    public final double mo2971b() {
        return this.f3141b;
    }
}
