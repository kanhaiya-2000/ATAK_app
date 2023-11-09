package atakplugin.UASTool;

import java.util.LinkedHashMap;
import java.util.Map;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, mo1538e = {"<anonymous>", "", "", "Lkotlin/text/CharCategory;", "invoke"})
final class bnb extends bfr implements bdk<Map<Integer, ? extends bna>> {

    /* renamed from: a */
    public static final bnb f2969a = new bnb();

    bnb() {
        super(0);
    }

    /* renamed from: a */
    public final Map<Integer, bna> invoke() {
        bna[] values = bna.values();
        Map<Integer, bna> linkedHashMap = new LinkedHashMap<>(biu.m7177c(auy.m4971a(values.length), 16));
        for (bna bna : values) {
            linkedHashMap.put(Integer.valueOf(bna.mo2810a()), bna);
        }
        return linkedHashMap;
    }
}
