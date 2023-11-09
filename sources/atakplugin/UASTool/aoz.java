package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\b¨\u0006\u0016"}, mo1538e = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, mo1539f = "kotlin/NumbersKt", mo1541h = 1)
class aoz extends aoy {
    /* renamed from: a */
    private static final boolean m2546a(double d) {
        return Double.isNaN(d);
    }

    /* renamed from: a */
    private static final boolean m2547a(float f) {
        return Float.isNaN(f);
    }

    /* renamed from: b */
    private static final boolean m2552b(double d) {
        return Double.isInfinite(d);
    }

    /* renamed from: b */
    private static final boolean m2553b(float f) {
        return Float.isInfinite(f);
    }

    /* renamed from: c */
    private static final boolean m2556c(double d) {
        return !Double.isInfinite(d) && !Double.isNaN(d);
    }

    /* renamed from: c */
    private static final boolean m2557c(float f) {
        return !Float.isInfinite(f) && !Float.isNaN(f);
    }

    /* renamed from: d */
    private static final long m2560d(double d) {
        return Double.doubleToLongBits(d);
    }

    /* renamed from: e */
    private static final long m2564e(double d) {
        return Double.doubleToRawLongBits(d);
    }

    /* renamed from: a */
    private static final double m2540a(bfe bfe, long j) {
        return Double.longBitsToDouble(j);
    }

    /* renamed from: d */
    private static final int m2558d(float f) {
        return Float.floatToIntBits(f);
    }

    /* renamed from: e */
    private static final int m2562e(float f) {
        return Float.floatToRawIntBits(f);
    }

    /* renamed from: a */
    private static final float m2541a(bfh bfh, int i) {
        return Float.intBitsToFloat(i);
    }

    /* renamed from: a */
    private static final int m2542a(int i) {
        return Integer.bitCount(i);
    }

    /* renamed from: b */
    private static final int m2548b(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: c */
    private static final int m2554c(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* renamed from: d */
    private static final int m2559d(int i) {
        return Integer.highestOneBit(i);
    }

    /* renamed from: e */
    private static final int m2563e(int i) {
        return Integer.lowestOneBit(i);
    }

    /* renamed from: a */
    private static final int m2543a(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    /* renamed from: b */
    private static final int m2549b(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    /* renamed from: a */
    private static final int m2544a(long j) {
        return Long.bitCount(j);
    }

    /* renamed from: b */
    private static final int m2550b(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    /* renamed from: c */
    private static final int m2555c(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* renamed from: d */
    private static final long m2561d(long j) {
        return Long.highestOneBit(j);
    }

    /* renamed from: e */
    private static final long m2565e(long j) {
        return Long.lowestOneBit(j);
    }

    /* renamed from: a */
    private static final long m2545a(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    /* renamed from: b */
    private static final long m2551b(long j, int i) {
        return Long.rotateRight(j, i);
    }
}
