package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\b\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000b\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\b\u0010\f\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0010\"\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00050\u000bH\u0002¢\u0006\u0002\b\u0016\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0007¢\u0006\u0002\b\u0018\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\b\u001a@\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001e0\u001d\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00150\u001d0\u0001¨\u0006\u001f"}, mo1538e = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, mo1539f = "kotlin/sequences/SequencesKt", mo1541h = 1)
class blc extends blb {
    /* renamed from: b */
    private static final <T> bku<T> m7469b(bdk<? extends Iterator<? extends T>> bdk) {
        return new bld(bdk);
    }

    /* renamed from: a */
    public static final <T> bku<T> m7466a(Iterator<? extends T> it) {
        bfq.m6567f(it, "$this$asSequence");
        return bkx.m7472d(new ble(it));
    }

    /* renamed from: a */
    public static final <T> bku<T> m7467a(T... tArr) {
        bfq.m6567f(tArr, "elements");
        return tArr.length == 0 ? bkx.m7468b() : arv.m3417D(tArr);
    }

    /* renamed from: b */
    public static final <T> bku<T> m7468b() {
        return bkj.f2810a;
    }

    /* renamed from: e */
    private static final <T> bku<T> m7473e(bku<? extends T> bku) {
        return bku != null ? bku : bkx.m7468b();
    }

    /* renamed from: a */
    public static final <T> bku<T> m7463a(bku<? extends T> bku, bdk<? extends bku<? extends T>> bdk) {
        bfq.m6567f(bku, "$this$ifEmpty");
        bfq.m6567f(bdk, "defaultValue");
        return bkx.m7450a(new blk(bku, bdk, (ayd) null));
    }

    /* renamed from: a */
    public static final <T> bku<T> m7462a(bku<? extends bku<? extends T>> bku) {
        bfq.m6567f(bku, "$this$flatten");
        return m7464a(bku, blf.f2853a);
    }

    /* renamed from: b */
    public static final <T> bku<T> m7470b(bku<? extends Iterable<? extends T>> bku) {
        bfq.m6567f(bku, "$this$flatten");
        return m7464a(bku, blg.f2854a);
    }

    /* renamed from: a */
    private static final <T, R> bku<R> m7464a(bku<? extends T> bku, bdl<? super T, ? extends Iterator<? extends R>> bdl) {
        if (bku instanceof bmu) {
            return ((bmu) bku).mo2800a(bdl);
        }
        return new bkm<>(bku, blh.f2855a, bdl);
    }

    /* renamed from: c */
    public static final <T, R> apc<List<T>, List<R>> m7471c(bku<? extends apc<? extends T, ? extends R>> bku) {
        bfq.m6567f(bku, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends apc<? extends T, ? extends R>> a = bku.mo1859a();
        while (a.hasNext()) {
            apc apc = (apc) a.next();
            arrayList.add(apc.mo1544a());
            arrayList2.add(apc.mo1545b());
        }
        return apv.m2659a(arrayList, arrayList2);
    }

    /* renamed from: d */
    public static final <T> bku<T> m7472d(bku<? extends T> bku) {
        bfq.m6567f(bku, "$this$constrainOnce");
        return bku instanceof bkb ? bku : new bkb<>(bku);
    }

    /* renamed from: a */
    public static final <T> bku<T> m7460a(bdk<? extends T> bdk) {
        bfq.m6567f(bdk, "nextFunction");
        return bkx.m7472d(new bko(bdk, new bli(bdk)));
    }

    /* renamed from: a */
    public static final <T> bku<T> m7465a(T t, bdl<? super T, ? extends T> bdl) {
        bfq.m6567f(bdl, "nextFunction");
        if (t == null) {
            return bkj.f2810a;
        }
        return new bko<>(new blj(t), bdl);
    }

    /* renamed from: a */
    public static final <T> bku<T> m7461a(bdk<? extends T> bdk, bdl<? super T, ? extends T> bdl) {
        bfq.m6567f(bdk, "seedFunction");
        bfq.m6567f(bdl, "nextFunction");
        return new bko<>(bdk, bdl);
    }
}
