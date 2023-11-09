package atakplugin.UASTool;

import java.util.Collection;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u001a\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo1538e = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, mo1539f = "kotlin/collections/UCollectionsKt", mo1541h = 1)
class avy {
    /* renamed from: a */
    public static final byte[] m5163a(Collection<apy> collection) {
        bfq.m6567f(collection, "$this$toUByteArray");
        byte[] a = apz.m2734a(collection.size());
        int i = 0;
        for (apy b : collection) {
            apz.m2729a(a, i, b.mo1575b());
            i++;
        }
        return a;
    }

    /* renamed from: b */
    public static final int[] m5165b(Collection<aqc> collection) {
        bfq.m6567f(collection, "$this$toUIntArray");
        int[] b = aqd.m2814b(collection.size());
        int i = 0;
        for (aqc b2 : collection) {
            aqd.m2808a(b, i, b2.mo1603b());
            i++;
        }
        return b;
    }

    /* renamed from: c */
    public static final long[] m5167c(Collection<aqg> collection) {
        bfq.m6567f(collection, "$this$toULongArray");
        long[] a = aqh.m2894a(collection.size());
        int i = 0;
        for (aqg b : collection) {
            aqh.m2889a(a, i, b.mo1631b());
            i++;
        }
        return a;
    }

    /* renamed from: d */
    public static final short[] m5169d(Collection<aqm> collection) {
        bfq.m6567f(collection, "$this$toUShortArray");
        short[] a = aqn.m3001a(collection.size());
        int i = 0;
        for (aqm b : collection) {
            aqn.m2996a(a, i, b.mo1659b());
            i++;
        }
        return a;
    }

    /* renamed from: a */
    public static final int m5162a(Iterable<aqc> iterable) {
        bfq.m6567f(iterable, "$this$sum");
        int i = 0;
        for (aqc b : iterable) {
            i = aqc.m2761b(i + b.mo1603b());
        }
        return i;
    }

    /* renamed from: b */
    public static final long m5164b(Iterable<aqg> iterable) {
        bfq.m6567f(iterable, "$this$sum");
        long j = 0;
        for (aqg b : iterable) {
            j = aqg.m2843b(j + b.mo1631b());
        }
        return j;
    }

    /* renamed from: c */
    public static final int m5166c(Iterable<apy> iterable) {
        bfq.m6567f(iterable, "$this$sum");
        int i = 0;
        for (apy b : iterable) {
            i = aqc.m2761b(i + aqc.m2761b(b.mo1575b() & 255));
        }
        return i;
    }

    /* renamed from: d */
    public static final int m5168d(Iterable<aqm> iterable) {
        bfq.m6567f(iterable, "$this$sum");
        int i = 0;
        for (aqm b : iterable) {
            i = aqc.m2761b(i + aqc.m2761b(b.mo1659b() & 65535));
        }
        return i;
    }
}
