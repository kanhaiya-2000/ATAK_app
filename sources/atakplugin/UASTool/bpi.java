package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH$R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo1538e = {"Lkotlin/time/AbstractDoubleClock;", "Lkotlin/time/Clock;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/ClockMark;", "read", "", "DoubleClockMark", "kotlin-stdlib"})
public abstract class bpi implements bpl {

    /* renamed from: a */
    private final TimeUnit f3119a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract double mo2946a();

    public bpi(TimeUnit timeUnit) {
        bfq.m6567f(timeUnit, "unit");
        this.f3119a = timeUnit;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final TimeUnit mo2948c() {
        return this.f3119a;
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo1538e = {"Lkotlin/time/AbstractDoubleClock$DoubleClockMark;", "Lkotlin/time/ClockMark;", "startedAt", "", "clock", "Lkotlin/time/AbstractDoubleClock;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleClock;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "D", "elapsedNow", "()D", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bpi$a */
    private static final class C0208a extends bpn {

        /* renamed from: a */
        private final double f3120a;

        /* renamed from: b */
        private final bpi f3121b;

        /* renamed from: c */
        private final double f3122c;

        private C0208a(double d, bpi bpi, double d2) {
            this.f3120a = d;
            this.f3121b = bpi;
            this.f3122c = d2;
        }

        public /* synthetic */ C0208a(double d, bpi bpi, double d2, bfd bfd) {
            this(d, bpi, d2);
        }

        /* renamed from: a */
        public double mo2949a() {
            return bpo.m8440b(bpp.m8484a(this.f3121b.mo2946a() - this.f3120a, this.f3121b.mo2948c()), this.f3122c);
        }

        /* renamed from: a */
        public bpn mo2950a(double d) {
            return new C0208a(this.f3120a, this.f3121b, bpo.m8428a(this.f3122c, d), (bfd) null);
        }
    }

    /* renamed from: b */
    public bpn mo2947b() {
        return new C0208a(mo2946a(), this, bpo.f3129a.mo2964a(), (bfd) null);
    }
}
