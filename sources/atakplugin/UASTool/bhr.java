package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t"}, mo1538e = {"kotlin/properties/Delegates$vetoable$1", "Lkotlin/properties/ObservableProperty;", "beforeChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib"})
public final class bhr extends bht<T> {

    /* renamed from: a */
    final /* synthetic */ bea f2699a;

    /* renamed from: b */
    final /* synthetic */ Object f2700b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bhr(bea bea, Object obj, Object obj2) {
        super(obj2);
        this.f2699a = bea;
        this.f2700b = obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo2521b(bjr<?> bjr, T t, T t2) {
        bfq.m6567f(bjr, "property");
        return ((Boolean) this.f2699a.mo2214a(bjr, t, t2)).booleanValue();
    }
}
