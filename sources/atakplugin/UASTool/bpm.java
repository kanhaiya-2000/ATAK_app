package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\nø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, mo1538e = {"compareTo", "", "Lkotlin/time/ClockMark;", "other", "minus", "Lkotlin/time/Duration;", "(Lkotlin/time/ClockMark;Lkotlin/time/ClockMark;)D", "kotlin-stdlib"})
public final class bpm {
    @anx(mo1516a = "Subtracting one ClockMark from another is not a well defined operation because these clock marks could have been obtained from the different clocks.", mo1518c = any.ERROR)
    /* renamed from: a */
    private static final double m8421a(bpn bpn, bpn bpn2) {
        bfq.m6567f(bpn, "$this$minus");
        throw new Error("Operation is disallowed.");
    }

    @anx(mo1516a = "Comparing one ClockMark to another is not a well defined operation because these clock marks could have been obtained from the different clocks.", mo1518c = any.ERROR)
    /* renamed from: b */
    private static final int m8422b(bpn bpn, bpn bpn2) {
        bfq.m6567f(bpn, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }
}
