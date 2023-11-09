package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo1538e = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, mo1539f = "kotlin/sequences/USequencesKt", mo1541h = 1)
class bmx {
    /* renamed from: a */
    public static final int m7708a(bku<aqc> bku) {
        bfq.m6567f(bku, "$this$sum");
        Iterator<aqc> a = bku.mo1859a();
        int i = 0;
        while (a.hasNext()) {
            i = aqc.m2761b(i + a.next().mo1603b());
        }
        return i;
    }

    /* renamed from: b */
    public static final long m7709b(bku<aqg> bku) {
        bfq.m6567f(bku, "$this$sum");
        Iterator<aqg> a = bku.mo1859a();
        long j = 0;
        while (a.hasNext()) {
            j = aqg.m2843b(j + a.next().mo1631b());
        }
        return j;
    }

    /* renamed from: c */
    public static final int m7710c(bku<apy> bku) {
        bfq.m6567f(bku, "$this$sum");
        Iterator<apy> a = bku.mo1859a();
        int i = 0;
        while (a.hasNext()) {
            i = aqc.m2761b(i + aqc.m2761b(a.next().mo1575b() & 255));
        }
        return i;
    }

    /* renamed from: d */
    public static final int m7711d(bku<aqm> bku) {
        bfq.m6567f(bku, "$this$sum");
        Iterator<aqm> a = bku.mo1859a();
        int i = 0;
        while (a.hasNext()) {
            i = aqc.m2761b(i + aqc.m2761b(a.next().mo1659b() & 65535));
        }
        return i;
    }
}
