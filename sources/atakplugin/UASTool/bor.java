package atakplugin.UASTool;

import java.util.Collection;
import java.util.List;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
final class bor extends bfr implements bdw<CharSequence, Integer, apc<? extends Integer, ? extends Integer>> {

    /* renamed from: a */
    final /* synthetic */ List f3062a;

    /* renamed from: b */
    final /* synthetic */ boolean f3063b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bor(List list, boolean z) {
        super(2);
        this.f3062a = list;
        this.f3063b = z;
    }

    /* renamed from: a */
    public /* synthetic */ Object mo2065a(Object obj, Object obj2) {
        return mo2934a((CharSequence) obj, ((Number) obj2).intValue());
    }

    /* renamed from: a */
    public final apc<Integer, Integer> mo2934a(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$receiver");
        apc a = boo.m8145b(charSequence, (Collection<String>) this.f3062a, i, this.f3063b, false);
        if (a != null) {
            return apv.m2659a(a.mo1544a(), Integer.valueOf(((String) a.mo1545b()).length()));
        }
        return null;
    }
}
