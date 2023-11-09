package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\t\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, mo1538e = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()J", "J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/ULongIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class bjb implements bgz, Iterable<aqg> {

    /* renamed from: a */
    public static final C0176a f2765a = new C0176a((bfd) null);

    /* renamed from: b */
    private final long f2766b;

    /* renamed from: c */
    private final long f2767c;

    /* renamed from: d */
    private final long f2768d;

    public /* synthetic */ bjb(long j, long j2, long j3, bfd bfd) {
        this(j, j2, j3);
    }

    private bjb(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j3 != Long.MIN_VALUE) {
            this.f2766b = j;
            this.f2767c = bbl.m6184a(j, j2, j3);
            this.f2768d = j3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final long mo2638a() {
        return this.f2766b;
    }

    /* renamed from: b */
    public final long mo2639b() {
        return this.f2767c;
    }

    /* renamed from: c */
    public final long mo2640c() {
        return this.f2768d;
    }

    /* renamed from: d */
    public awa iterator() {
        return new bjc(this.f2766b, this.f2767c, this.f2768d, (bfd) null);
    }

    /* renamed from: e */
    public boolean mo2642e() {
        int i = (this.f2768d > 0 ? 1 : (this.f2768d == 0 ? 0 : -1));
        int a = aqu.m3028a(this.f2766b, this.f2767c);
        if (i > 0) {
            if (a > 0) {
                return true;
            }
        } else if (a < 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bjb) {
            if (!mo2642e() || !((bjb) obj).mo2642e()) {
                bjb bjb = (bjb) obj;
                if (!(this.f2766b == bjb.f2766b && this.f2767c == bjb.f2767c && this.f2768d == bjb.f2768d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2642e()) {
            return -1;
        }
        long j = this.f2766b;
        long j2 = this.f2767c;
        long j3 = this.f2768d;
        return ((int) (j3 ^ (j3 >>> 32))) + (((((int) aqg.m2843b(j ^ aqg.m2843b(j >>> 32))) * 31) + ((int) aqg.m2843b(j2 ^ aqg.m2843b(j2 >>> 32)))) * 31);
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.f2768d > 0) {
            sb.append(aqg.m2838a(this.f2766b));
            sb.append("..");
            sb.append(aqg.m2838a(this.f2767c));
            sb.append(" step ");
            j = this.f2768d;
        } else {
            sb = new StringBuilder();
            sb.append(aqg.m2838a(this.f2766b));
            sb.append(" downTo ");
            sb.append(aqg.m2838a(this.f2767c));
            sb.append(" step ");
            j = -this.f2768d;
        }
        sb.append(j);
        return sb.toString();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bjb$a */
    public static final class C0176a {
        private C0176a() {
        }

        public /* synthetic */ C0176a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bjb mo2647a(long j, long j2, long j3) {
            return new bjb(j, j2, j3, (bfd) null);
        }
    }
}
