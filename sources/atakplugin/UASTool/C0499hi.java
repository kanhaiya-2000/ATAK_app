package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.hi */
final class C0499hi implements C0496hg<T> {

    /* renamed from: a */
    final /* synthetic */ C0496hg f4990a;

    /* renamed from: b */
    final /* synthetic */ C0496hg f4991b;

    /* renamed from: c */
    final /* synthetic */ C0496hg[] f4992c;

    C0499hi(C0496hg hgVar, C0496hg hgVar2, C0496hg[] hgVarArr) {
        this.f4990a = hgVar;
        this.f4991b = hgVar2;
        this.f4992c = hgVarArr;
    }

    public boolean test(T t) {
        if (!(this.f4990a.test(t) && this.f4991b.test(t))) {
            return false;
        }
        for (C0496hg test : this.f4992c) {
            if (!test.test(t)) {
                return false;
            }
        }
        return true;
    }
}
