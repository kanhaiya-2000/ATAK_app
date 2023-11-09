package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo1538e = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()I", "I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/UIntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class biy implements bgz, Iterable<aqc> {

    /* renamed from: a */
    public static final C0173a f2754a = new C0173a((bfd) null);

    /* renamed from: b */
    private final int f2755b;

    /* renamed from: c */
    private final int f2756c;

    /* renamed from: d */
    private final int f2757d;

    public /* synthetic */ biy(int i, int i2, int i3, bfd bfd) {
        this(i, i2, i3);
    }

    private biy(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f2755b = i;
            this.f2756c = bbl.m6183a(i, i2, i3);
            this.f2757d = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final int mo2623a() {
        return this.f2755b;
    }

    /* renamed from: b */
    public final int mo2624b() {
        return this.f2756c;
    }

    /* renamed from: c */
    public final int mo2625c() {
        return this.f2757d;
    }

    /* renamed from: d */
    public avz iterator() {
        return new biz(this.f2755b, this.f2756c, this.f2757d, (bfd) null);
    }

    /* renamed from: e */
    public boolean mo2627e() {
        if (this.f2757d > 0) {
            if (aqu.m3027a(this.f2755b, this.f2756c) > 0) {
                return true;
            }
        } else if (aqu.m3027a(this.f2755b, this.f2756c) < 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof biy) {
            if (!mo2627e() || !((biy) obj).mo2627e()) {
                biy biy = (biy) obj;
                if (!(this.f2755b == biy.f2755b && this.f2756c == biy.f2756c && this.f2757d == biy.f2757d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2627e()) {
            return -1;
        }
        return (((this.f2755b * 31) + this.f2756c) * 31) + this.f2757d;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        if (this.f2757d > 0) {
            sb = new StringBuilder();
            sb.append(aqc.m2757a(this.f2755b));
            sb.append("..");
            sb.append(aqc.m2757a(this.f2756c));
            sb.append(" step ");
            i = this.f2757d;
        } else {
            sb = new StringBuilder();
            sb.append(aqc.m2757a(this.f2755b));
            sb.append(" downTo ");
            sb.append(aqc.m2757a(this.f2756c));
            sb.append(" step ");
            i = -this.f2757d;
        }
        sb.append(i);
        return sb.toString();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"Lkotlin/ranges/UIntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.biy$a */
    public static final class C0173a {
        private C0173a() {
        }

        public /* synthetic */ C0173a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final biy mo2632a(int i, int i2, int i3) {
            return new biy(i, i2, i3, (bfd) null);
        }
    }
}
