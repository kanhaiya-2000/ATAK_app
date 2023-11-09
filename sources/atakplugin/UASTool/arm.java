package atakplugin.UASTool;

import java.util.Map;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, mo1538e = {"<anonymous>", "", "K", "V", "it", "", "invoke"})
final class arm extends bfr implements bdl<Map.Entry<? extends K, ? extends V>, String> {

    /* renamed from: a */
    final /* synthetic */ arj f2218a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    arm(arj arj) {
        super(1);
        this.f2218a = arj;
    }

    /* renamed from: a */
    public final String invoke(Map.Entry<? extends K, ? extends V> entry) {
        bfq.m6567f(entry, "it");
        return this.f2218a.m3061b(entry);
    }
}
