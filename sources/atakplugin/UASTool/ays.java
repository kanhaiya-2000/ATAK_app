package atakplugin.UASTool;

import atakplugin.UASTool.ayr;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "Lkotlin/coroutines/experimental/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "invoke"})
final class ays extends bfr implements bdw<ayr, ayr.C0122b, ayr> {

    /* renamed from: a */
    public static final ays f2398a = new ays();

    ays() {
        super(2);
    }

    /* renamed from: a */
    public final ayr mo2065a(ayr ayr, ayr.C0122b bVar) {
        ayn ayn;
        bfq.m6567f(ayr, "acc");
        bfq.m6567f(bVar, "element");
        ayr b = ayr.mo2168b(bVar.mo2165a());
        if (b == ayu.f2399a) {
            return bVar;
        }
        ayq ayq = (ayq) b.mo2164a(ayq.f2396a);
        if (ayq == null) {
            ayn = new ayn(b, bVar);
        } else {
            ayr b2 = b.mo2168b(ayq.f2396a);
            if (b2 == ayu.f2399a) {
                ayn = new ayn(bVar, ayq);
            } else {
                ayn = new ayn(new ayn(b2, bVar), ayq);
            }
        }
        return ayn;
    }
}
