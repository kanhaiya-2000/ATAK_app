package atakplugin.UASTool;

import atakplugin.UASTool.ayh;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
final class ayi extends bfr implements bdw<ayh, ayh.C0115b, ayh> {

    /* renamed from: a */
    public static final ayi f2385a = new ayi();

    ayi() {
        super(2);
    }

    /* renamed from: a */
    public final ayh mo2065a(ayh ayh, ayh.C0115b bVar) {
        aya aya;
        bfq.m6567f(ayh, "acc");
        bfq.m6567f(bVar, "element");
        ayh b = ayh.mo2145b(bVar.mo2142a());
        if (b == ayj.f2386a) {
            return bVar;
        }
        aye aye = (aye) b.mo2141a(aye.f2381a);
        if (aye == null) {
            aya = new aya(b, bVar);
        } else {
            ayh b2 = b.mo2145b(aye.f2381a);
            if (b2 == ayj.f2386a) {
                aya = new aya(bVar, aye);
            } else {
                aya = new aya(new aya(b2, bVar), aye);
            }
        }
        return aya;
    }
}
