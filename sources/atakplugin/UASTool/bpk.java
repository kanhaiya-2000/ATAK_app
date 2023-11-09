package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo1538e = {"Lkotlin/time/AdjustedClockMark;", "Lkotlin/time/ClockMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/ClockMark;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment", "()D", "D", "getMark", "()Lkotlin/time/ClockMark;", "elapsedNow", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "kotlin-stdlib"})
final class bpk extends bpn {

    /* renamed from: a */
    private final bpn f3127a;

    /* renamed from: b */
    private final double f3128b;

    private bpk(bpn bpn, double d) {
        this.f3127a = bpn;
        this.f3128b = d;
    }

    public /* synthetic */ bpk(bpn bpn, double d, bfd bfd) {
        this(bpn, d);
    }

    /* renamed from: b */
    public final bpn mo2953b() {
        return this.f3127a;
    }

    /* renamed from: c */
    public final double mo2954c() {
        return this.f3128b;
    }

    /* renamed from: a */
    public double mo2949a() {
        return bpo.m8440b(this.f3127a.mo2949a(), this.f3128b);
    }

    /* renamed from: a */
    public bpn mo2950a(double d) {
        return new bpk(this.f3127a, bpo.m8428a(this.f3128b, d), (bfd) null);
    }
}
