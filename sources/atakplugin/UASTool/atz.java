package atakplugin.UASTool;

import java.util.List;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, mo1538e = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class atz extends aty {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final int m4678c(List<?> list, int i) {
        int a = ato.m4592a(list);
        if (i >= 0 && a >= i) {
            return ato.m4592a(list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new biq(0, ato.m4592a(list)) + "].");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final int m4679d(List<?> list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new biq(0, list.size()) + "].");
    }

    /* renamed from: d */
    public static final <T> List<T> m4680d(List<? extends T> list) {
        bfq.m6567f(list, "$this$asReversed");
        return new avh<>(list);
    }

    /* renamed from: e */
    public static final <T> List<T> m4681e(List<T> list) {
        bfq.m6567f(list, "$this$asReversed");
        return new avg<>(list);
    }
}
