package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, mo1538e = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class bir implements bgz, Iterable<Long> {

    /* renamed from: a */
    public static final C0171a f2744a = new C0171a((bfd) null);

    /* renamed from: b */
    private final long f2745b;

    /* renamed from: c */
    private final long f2746c;

    /* renamed from: d */
    private final long f2747d;

    public bir(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j3 != Long.MIN_VALUE) {
            this.f2745b = j;
            this.f2746c = bbh.m6175a(j, j2, j3);
            this.f2747d = j3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final long mo2607a() {
        return this.f2745b;
    }

    /* renamed from: b */
    public final long mo2608b() {
        return this.f2746c;
    }

    /* renamed from: c */
    public final long mo2609c() {
        return this.f2747d;
    }

    /* renamed from: d */
    public auu iterator() {
        return new bis(this.f2745b, this.f2746c, this.f2747d);
    }

    /* renamed from: e */
    public boolean mo2611e() {
        int i = (this.f2747d > 0 ? 1 : (this.f2747d == 0 ? 0 : -1));
        long j = this.f2745b;
        long j2 = this.f2746c;
        if (i > 0) {
            if (j > j2) {
                return true;
            }
        } else if (j < j2) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bir) {
            if (!mo2611e() || !((bir) obj).mo2611e()) {
                bir bir = (bir) obj;
                if (!(this.f2745b == bir.f2745b && this.f2746c == bir.f2746c && this.f2747d == bir.f2747d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2611e()) {
            return -1;
        }
        long j = (long) 31;
        long j2 = this.f2745b;
        long j3 = this.f2746c;
        long j4 = j * (((j2 ^ (j2 >>> 32)) * j) + (j3 ^ (j3 >>> 32)));
        long j5 = this.f2747d;
        return (int) (j4 + (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.f2747d > 0) {
            sb.append(this.f2745b);
            sb.append("..");
            sb.append(this.f2746c);
            sb.append(" step ");
            j = this.f2747d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f2745b);
            sb.append(" downTo ");
            sb.append(this.f2746c);
            sb.append(" step ");
            j = -this.f2747d;
        }
        sb.append(j);
        return sb.toString();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo1538e = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bir$a */
    public static final class C0171a {
        private C0171a() {
        }

        public /* synthetic */ C0171a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bir mo2616a(long j, long j2, long j3) {
            return new bir(j, j2, j3);
        }
    }
}
