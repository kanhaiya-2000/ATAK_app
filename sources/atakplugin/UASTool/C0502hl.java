package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.hl */
final class C0502hl implements C0496hg<T> {

    /* renamed from: a */
    final /* synthetic */ C0496hg f4998a;

    /* renamed from: b */
    final /* synthetic */ C0496hg f4999b;

    C0502hl(C0496hg hgVar, C0496hg hgVar2) {
        this.f4998a = hgVar;
        this.f4999b = hgVar2;
    }

    public boolean test(T t) {
        return this.f4999b.test(t) ^ this.f4998a.test(t);
    }
}
