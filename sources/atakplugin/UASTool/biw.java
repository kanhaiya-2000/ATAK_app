package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\n*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\n¢\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u000f*\u0002H\u00072\u0006\u0010\u0010\u001a\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, mo1538e = {"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "kotlin-stdlib"}, mo1539f = "kotlin/ranges/RangesKt", mo1541h = 1)
class biw extends biv {
    /* renamed from: a */
    public static final <T extends Comparable<? super T>> bim<T> m7087a(T t, T t2) {
        bfq.m6567f(t, "$this$rangeTo");
        bfq.m6567f(t2, "that");
        return new bin<>(t, t2);
    }

    /* renamed from: a */
    public static final bil<Double> m7086a(double d, double d2) {
        return new bij(d, d2);
    }

    /* renamed from: a */
    private static final <T, R extends Iterable<? extends T> & bim<T>> boolean m7089a(R r, T t) {
        bfq.m6567f(r, "$this$contains");
        return t != null && ((bim) r).mo2567a((Comparable) t);
    }

    /* renamed from: a */
    public static final void m7088a(boolean z, Number number) {
        bfq.m6567f(number, "step");
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
        }
    }
}
