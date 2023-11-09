package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u001a4\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo1538e = {"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)D", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "Lkotlin/time/Clock;", "(Lkotlin/time/Clock;Lkotlin/jvm/functions/Function0;)D", "kotlin-stdlib"})
public final class bpw {
    /* renamed from: a */
    public static final double m8540a(bdk<aqr> bdk) {
        bfq.m6567f(bdk, "block");
        bpn b = bpx.f3138a.mo2947b();
        bdk.invoke();
        return b.mo2949a();
    }

    /* renamed from: a */
    public static final double m8541a(bpl bpl, bdk<aqr> bdk) {
        bfq.m6567f(bpl, "$this$measureTime");
        bfq.m6567f(bdk, "block");
        bpn b = bpl.mo2947b();
        bdk.invoke();
        return b.mo2949a();
    }

    /* renamed from: b */
    public static final <T> bpz<T> m8542b(bdk<? extends T> bdk) {
        bfq.m6567f(bdk, "block");
        return new bpz<>(bdk.invoke(), bpx.f3138a.mo2947b().mo2949a(), (bfd) null);
    }

    /* renamed from: b */
    public static final <T> bpz<T> m8543b(bpl bpl, bdk<? extends T> bdk) {
        bfq.m6567f(bpl, "$this$measureTimedValue");
        bfq.m6567f(bdk, "block");
        return new bpz<>(bdk.invoke(), bpl.mo2947b().mo2949a(), (bfd) null);
    }
}
