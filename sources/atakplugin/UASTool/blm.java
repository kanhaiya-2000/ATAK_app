package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "", "R", "it", "", "invoke"})
final class blm extends bfr implements bdl<Object, Boolean> {

    /* renamed from: a */
    final /* synthetic */ Class f2864a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    blm(Class cls) {
        super(1);
        this.f2864a = cls;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(mo2740a(obj));
    }

    /* renamed from: a */
    public final boolean mo2740a(Object obj) {
        return this.f2864a.isInstance(obj);
    }
}
