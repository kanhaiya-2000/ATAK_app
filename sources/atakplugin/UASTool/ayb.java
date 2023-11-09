package atakplugin.UASTool;

import atakplugin.UASTool.ayh;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
final class ayb extends bfr implements bdw<String, ayh.C0115b, String> {

    /* renamed from: a */
    public static final ayb f2378a = new ayb();

    ayb() {
        super(2);
    }

    /* renamed from: a */
    public final String mo2065a(String str, ayh.C0115b bVar) {
        bfq.m6567f(str, "acc");
        bfq.m6567f(bVar, "element");
        if (str.length() == 0) {
            return bVar.toString();
        }
        return str + ", " + bVar;
    }
}
