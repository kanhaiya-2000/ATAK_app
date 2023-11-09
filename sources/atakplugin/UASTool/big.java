package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo1538e = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class big implements bgz, Iterable<Character> {

    /* renamed from: a */
    public static final C0165a f2718a = new C0165a((bfd) null);

    /* renamed from: b */
    private final char f2719b;

    /* renamed from: c */
    private final char f2720c;

    /* renamed from: d */
    private final int f2721d;

    public big(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i != Integer.MIN_VALUE) {
            this.f2719b = c;
            this.f2720c = (char) bbh.m6173a((int) c, (int) c2, i);
            this.f2721d = i;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final char mo2554a() {
        return this.f2719b;
    }

    /* renamed from: b */
    public final char mo2555b() {
        return this.f2720c;
    }

    /* renamed from: c */
    public final int mo2556c() {
        return this.f2721d;
    }

    /* renamed from: d */
    public atn iterator() {
        return new bih(this.f2719b, this.f2720c, this.f2721d);
    }

    /* renamed from: e */
    public boolean mo2558e() {
        if (this.f2721d > 0) {
            if (this.f2719b > this.f2720c) {
                return true;
            }
        } else if (this.f2719b < this.f2720c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof big) {
            if (!mo2558e() || !((big) obj).mo2558e()) {
                big big = (big) obj;
                if (!(this.f2719b == big.f2719b && this.f2720c == big.f2720c && this.f2721d == big.f2721d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2558e()) {
            return -1;
        }
        return (((this.f2719b * 31) + this.f2720c) * 31) + this.f2721d;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        if (this.f2721d > 0) {
            sb = new StringBuilder();
            sb.append(this.f2719b);
            sb.append("..");
            sb.append(this.f2720c);
            sb.append(" step ");
            i = this.f2721d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f2719b);
            sb.append(" downTo ");
            sb.append(this.f2720c);
            sb.append(" step ");
            i = -this.f2721d;
        }
        sb.append(i);
        return sb.toString();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, mo1538e = {"Lkotlin/ranges/CharProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", "", "rangeEnd", "step", "", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.big$a */
    public static final class C0165a {
        private C0165a() {
        }

        public /* synthetic */ C0165a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final big mo2563a(char c, char c2, int i) {
            return new big(c, c2, i);
        }
    }
}
