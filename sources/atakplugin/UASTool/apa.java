package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\b¨\u0006\u000b"}, mo1538e = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, mo1539f = "kotlin/NumbersKt", mo1541h = 1)
class apa extends aoz {
    /* renamed from: a */
    public static final byte m2567a(byte b, int i) {
        byte b2 = i & 7;
        return (byte) (((b & 255) >>> (8 - b2)) | (b << b2));
    }

    /* renamed from: a */
    public static final short m2570a(short s, int i) {
        short s2 = i & 15;
        return (short) (((s & 65535) >>> (16 - s2)) | (s << s2));
    }

    /* renamed from: b */
    public static final byte m2571b(byte b, int i) {
        byte b2 = i & 7;
        return (byte) (((b & 255) >>> b2) | (b << (8 - b2)));
    }

    /* renamed from: b */
    public static final short m2574b(short s, int i) {
        short s2 = i & 15;
        return (short) (((s & 65535) >>> s2) | (s << (16 - s2)));
    }

    /* renamed from: a */
    private static final int m2568a(byte b) {
        return Integer.bitCount(b & 255);
    }

    /* renamed from: b */
    private static final int m2572b(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    /* renamed from: c */
    private static final int m2575c(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    /* renamed from: d */
    private static final byte m2577d(byte b) {
        return (byte) Integer.highestOneBit(b & 255);
    }

    /* renamed from: e */
    private static final byte m2579e(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    /* renamed from: a */
    private static final int m2569a(short s) {
        return Integer.bitCount(s & 65535);
    }

    /* renamed from: b */
    private static final int m2573b(short s) {
        return Integer.numberOfLeadingZeros(s & 65535) - 16;
    }

    /* renamed from: c */
    private static final int m2576c(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    /* renamed from: d */
    private static final short m2578d(short s) {
        return (short) Integer.highestOneBit(s & 65535);
    }

    /* renamed from: e */
    private static final short m2580e(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
