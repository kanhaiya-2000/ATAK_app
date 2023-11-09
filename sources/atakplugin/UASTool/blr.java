package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "", "T", "it", "Lkotlin/collections/IndexedValue;", "invoke"})
final class blr extends bfr implements bdl<auq<? extends T>, Boolean> {

    /* renamed from: a */
    final /* synthetic */ bdw f2868a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    blr(bdw bdw) {
        super(1);
        this.f2868a = bdw;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(mo2743a((auq) obj));
    }

    /* renamed from: a */
    public final boolean mo2743a(auq<? extends T> auq) {
        bfq.m6567f(auq, "it");
        return ((Boolean) this.f2868a.mo2065a(Integer.valueOf(auq.mo1990a()), auq.mo1992b())).booleanValue();
    }
}
