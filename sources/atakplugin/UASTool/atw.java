package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\b\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n\u001a\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b0\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\t"}, mo1538e = {"forEach", "", "T", "", "operation", "Lkotlin/Function1;", "iterator", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class atw extends atu {
    /* renamed from: b */
    private static final <T> Iterator<T> m4636b(Iterator<? extends T> it) {
        bfq.m6567f(it, "$this$iterator");
        return it;
    }

    /* renamed from: a */
    public static final <T> Iterator<auq<T>> m4634a(Iterator<? extends T> it) {
        bfq.m6567f(it, "$this$withIndex");
        return new aus<>(it);
    }

    /* renamed from: a */
    public static final <T> void m4635a(Iterator<? extends T> it, bdl<? super T, aqr> bdl) {
        bfq.m6567f(it, "$this$forEach");
        bfq.m6567f(bdl, "operation");
        while (it.hasNext()) {
            bdl.invoke(it.next());
        }
    }
}
