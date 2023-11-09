package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, mo1538e = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"})
public final class bid {
    /* renamed from: a */
    public static final int m6975a(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    /* renamed from: a */
    public static final bic m6978a(int i) {
        return new bif(i, i >> 31);
    }

    /* renamed from: a */
    public static final bic m6979a(long j) {
        return new bif((int) j, (int) (j >> 32));
    }

    /* renamed from: a */
    public static final int m6976a(bic bic, biq biq) {
        bfq.m6567f(bic, "$this$nextInt");
        bfq.m6567f(biq, "range");
        if (biq.mo2595e()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + biq);
        } else if (biq.mo2592b() < Integer.MAX_VALUE) {
            return bic.mo2549a(biq.mo2591a(), biq.mo2592b() + 1);
        } else {
            if (biq.mo2591a() > Integer.MIN_VALUE) {
                return bic.mo2549a(biq.mo2591a() - 1, biq.mo2592b()) + 1;
            }
            return bic.mo2528b();
        }
    }

    /* renamed from: a */
    public static final long m6977a(bic bic, bit bit) {
        bfq.m6567f(bic, "$this$nextLong");
        bfq.m6567f(bit, "range");
        if (bit.mo2611e()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + bit);
        } else if (bit.mo2608b() < bfu.f2629b) {
            return bic.mo2551a(bit.mo2607a(), bit.mo2608b() + 1);
        } else {
            if (bit.mo2607a() > Long.MIN_VALUE) {
                return bic.mo2551a(bit.mo2607a() - 1, bit.mo2608b()) + 1;
            }
            return bic.mo2530c();
        }
    }

    /* renamed from: b */
    public static final int m6983b(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: b */
    public static final void m6984b(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(m6980a((Object) Integer.valueOf(i), (Object) Integer.valueOf(i2)).toString());
        }
    }

    /* renamed from: a */
    public static final void m6982a(long j, long j2) {
        if (!(j2 > j)) {
            throw new IllegalArgumentException(m6980a((Object) Long.valueOf(j), (Object) Long.valueOf(j2)).toString());
        }
    }

    /* renamed from: a */
    public static final void m6981a(double d, double d2) {
        if (!(d2 > d)) {
            throw new IllegalArgumentException(m6980a((Object) Double.valueOf(d), (Object) Double.valueOf(d2)).toString());
        }
    }

    /* renamed from: a */
    public static final String m6980a(Object obj, Object obj2) {
        bfq.m6567f(obj, "from");
        bfq.m6567f(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }
}
