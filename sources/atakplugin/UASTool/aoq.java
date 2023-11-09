package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, mo1538e = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, mo1539f = "kotlin/LazyKt", mo1541h = 1)
class aoq {
    /* renamed from: a */
    public static final <T> aon<T> m2492a(bdk<? extends T> bdk) {
        bfq.m6567f(bdk, "initializer");
        return new apt<>(bdk, (Object) null, 2, (bfd) null);
    }

    /* renamed from: a */
    public static final <T> aon<T> m2491a(aos aos, bdk<? extends T> bdk) {
        bfq.m6567f(aos, "mode");
        bfq.m6567f(bdk, "initializer");
        int i = aop.f2119a[aos.ordinal()];
        if (i == 1) {
            return new apt<>(bdk, (Object) null, 2, (bfd) null);
        }
        if (i == 2) {
            return new apl<>(bdk);
        }
        if (i == 3) {
            return new aqs<>(bdk);
        }
        throw new aou();
    }

    /* renamed from: a */
    public static final <T> aon<T> m2493a(Object obj, bdk<? extends T> bdk) {
        bfq.m6567f(bdk, "initializer");
        return new apt<>(bdk, obj);
    }
}
