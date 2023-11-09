package atakplugin.UASTool;

import atakplugin.UASTool.ayh;
import atakplugin.UASTool.bgo;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo1538e = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"})
final class ayc extends bfr implements bdw<aqr, ayh.C0115b, aqr> {

    /* renamed from: a */
    final /* synthetic */ ayh[] f2379a;

    /* renamed from: b */
    final /* synthetic */ bgo.C0156f f2380b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ayc(ayh[] ayhArr, bgo.C0156f fVar) {
        super(2);
        this.f2379a = ayhArr;
        this.f2380b = fVar;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo2065a(Object obj, Object obj2) {
        mo2152a((aqr) obj, (ayh.C0115b) obj2);
        return aqr.f2177a;
    }

    /* renamed from: a */
    public final void mo2152a(aqr aqr, ayh.C0115b bVar) {
        bfq.m6567f(aqr, "<anonymous parameter 0>");
        bfq.m6567f(bVar, "element");
        ayh[] ayhArr = this.f2379a;
        bgo.C0156f fVar = this.f2380b;
        int i = fVar.f2666a;
        fVar.f2666a = i + 1;
        ayhArr[i] = bVar;
    }
}
