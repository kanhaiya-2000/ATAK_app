package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, mo1538e = {"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)I"})
public final class atr extends bfr implements bdl<T, Integer> {

    /* renamed from: a */
    final /* synthetic */ bdl f2261a;

    /* renamed from: b */
    final /* synthetic */ Comparable f2262b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public atr(bdl bdl, Comparable comparable) {
        super(1);
        this.f2261a = bdl;
        this.f2262b = comparable;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(mo1885a(obj));
    }

    /* renamed from: a */
    public final int mo1885a(T t) {
        return awn.m5728a((Comparable) this.f2261a.invoke(t), this.f2262b);
    }
}
