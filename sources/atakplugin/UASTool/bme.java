package atakplugin.UASTool;

import java.util.HashSet;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo1538e = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Z"})
final class bme extends bfr implements bdl<T, Boolean> {

    /* renamed from: a */
    final /* synthetic */ HashSet f2889a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bme(HashSet hashSet) {
        super(1);
        this.f2889a = hashSet;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(mo2771a(obj));
    }

    /* renamed from: a */
    public final boolean mo2771a(T t) {
        return this.f2889a.contains(t);
    }
}
