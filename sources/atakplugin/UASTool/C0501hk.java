package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.hk */
final class C0501hk implements C0496hg<T> {

    /* renamed from: a */
    final /* synthetic */ C0496hg f4995a;

    /* renamed from: b */
    final /* synthetic */ C0496hg f4996b;

    /* renamed from: c */
    final /* synthetic */ C0496hg[] f4997c;

    C0501hk(C0496hg hgVar, C0496hg hgVar2, C0496hg[] hgVarArr) {
        this.f4995a = hgVar;
        this.f4996b = hgVar2;
        this.f4997c = hgVarArr;
    }

    public boolean test(T t) {
        if (this.f4995a.test(t) || this.f4996b.test(t)) {
            return true;
        }
        for (C0496hg test : this.f4997c) {
            if (test.test(t)) {
                return true;
            }
        }
        return false;
    }
}
