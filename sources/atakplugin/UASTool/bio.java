package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo1538e = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class bio implements bgz, Iterable<Integer> {

    /* renamed from: a */
    public static final C0169a f2734a = new C0169a((bfd) null);

    /* renamed from: b */
    private final int f2735b;

    /* renamed from: c */
    private final int f2736c;

    /* renamed from: d */
    private final int f2737d;

    public bio(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f2735b = i;
            this.f2736c = bbh.m6173a(i, i2, i3);
            this.f2737d = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final int mo2591a() {
        return this.f2735b;
    }

    /* renamed from: b */
    public final int mo2592b() {
        return this.f2736c;
    }

    /* renamed from: c */
    public final int mo2593c() {
        return this.f2737d;
    }

    /* renamed from: d */
    public aut iterator() {
        return new bip(this.f2735b, this.f2736c, this.f2737d);
    }

    /* renamed from: e */
    public boolean mo2595e() {
        if (this.f2737d > 0) {
            if (this.f2735b > this.f2736c) {
                return true;
            }
        } else if (this.f2735b < this.f2736c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bio) {
            if (!mo2595e() || !((bio) obj).mo2595e()) {
                bio bio = (bio) obj;
                if (!(this.f2735b == bio.f2735b && this.f2736c == bio.f2736c && this.f2737d == bio.f2737d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2595e()) {
            return -1;
        }
        return (((this.f2735b * 31) + this.f2736c) * 31) + this.f2737d;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        if (this.f2737d > 0) {
            sb = new StringBuilder();
            sb.append(this.f2735b);
            sb.append("..");
            sb.append(this.f2736c);
            sb.append(" step ");
            i = this.f2737d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f2735b);
            sb.append(" downTo ");
            sb.append(this.f2736c);
            sb.append(" step ");
            i = -this.f2737d;
        }
        sb.append(i);
        return sb.toString();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo1538e = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bio$a */
    public static final class C0169a {
        private C0169a() {
        }

        public /* synthetic */ C0169a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bio mo2600a(int i, int i2, int i3) {
            return new bio(i, i2, i3);
        }
    }
}
