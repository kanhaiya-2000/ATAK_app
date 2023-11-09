package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.ek */
final class C0394ek implements C0391ei<T, R> {

    /* renamed from: a */
    final /* synthetic */ C0514hw f4922a;

    /* renamed from: b */
    final /* synthetic */ Object f4923b;

    C0394ek(C0514hw hwVar, Object obj) {
        this.f4922a = hwVar;
        this.f4923b = obj;
    }

    public R apply(T t) {
        try {
            return this.f4922a.mo4942a(t);
        } catch (Throwable unused) {
            return this.f4923b;
        }
    }
}
