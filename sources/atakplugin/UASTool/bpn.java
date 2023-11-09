package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo1538e = {"Lkotlin/time/ClockMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "()D", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"})
public abstract class bpn {
    /* renamed from: a */
    public abstract double mo2949a();

    /* renamed from: a */
    public bpn mo2950a(double d) {
        return new bpk(this, d, (bfd) null);
    }

    /* renamed from: b */
    public bpn mo2955b(double d) {
        return mo2950a(bpo.m8439b(d));
    }

    /* renamed from: d */
    public final boolean mo2956d() {
        return !bpo.m8447c(mo2949a());
    }

    /* renamed from: e */
    public final boolean mo2957e() {
        return bpo.m8447c(mo2949a());
    }
}
