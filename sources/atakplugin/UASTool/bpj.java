package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH$R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo1538e = {"Lkotlin/time/AbstractLongClock;", "Lkotlin/time/Clock;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/ClockMark;", "read", "", "LongClockMark", "kotlin-stdlib"})
public abstract class bpj implements bpl {

    /* renamed from: a */
    private final TimeUnit f3123a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract long mo2951a();

    public bpj(TimeUnit timeUnit) {
        bfq.m6567f(timeUnit, "unit");
        this.f3123a = timeUnit;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final TimeUnit mo2952c() {
        return this.f3123a;
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo1538e = {"Lkotlin/time/AbstractLongClock$LongClockMark;", "Lkotlin/time/ClockMark;", "startedAt", "", "clock", "Lkotlin/time/AbstractLongClock;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongClock;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "D", "elapsedNow", "()D", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bpj$a */
    private static final class C0209a extends bpn {

        /* renamed from: a */
        private final long f3124a;

        /* renamed from: b */
        private final bpj f3125b;

        /* renamed from: c */
        private final double f3126c;

        private C0209a(long j, bpj bpj, double d) {
            this.f3124a = j;
            this.f3125b = bpj;
            this.f3126c = d;
        }

        public /* synthetic */ C0209a(long j, bpj bpj, double d, bfd bfd) {
            this(j, bpj, d);
        }

        /* renamed from: a */
        public double mo2949a() {
            return bpo.m8440b(bpp.m8487a(this.f3125b.mo2951a() - this.f3124a, this.f3125b.mo2952c()), this.f3126c);
        }

        /* renamed from: a */
        public bpn mo2950a(double d) {
            return new C0209a(this.f3124a, this.f3125b, bpo.m8428a(this.f3126c, d), (bfd) null);
        }
    }

    /* renamed from: b */
    public bpn mo2947b() {
        return new C0209a(mo2951a(), this, bpo.f3129a.mo2964a(), (bfd) null);
    }
}
