package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
final class boq extends bfr implements bdw<CharSequence, Integer, apc<? extends Integer, ? extends Integer>> {

    /* renamed from: a */
    final /* synthetic */ char[] f3060a;

    /* renamed from: b */
    final /* synthetic */ boolean f3061b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    boq(char[] cArr, boolean z) {
        super(2);
        this.f3060a = cArr;
        this.f3061b = z;
    }

    /* renamed from: a */
    public /* synthetic */ Object mo2065a(Object obj, Object obj2) {
        return mo2933a((CharSequence) obj, ((Number) obj2).intValue());
    }

    /* renamed from: a */
    public final apc<Integer, Integer> mo2933a(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$receiver");
        int a = boc.m8085a(charSequence, this.f3060a, i, this.f3061b);
        if (a < 0) {
            return null;
        }
        return apv.m2659a(Integer.valueOf(a), 1);
    }
}
