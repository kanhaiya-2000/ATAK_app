package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.hj */
final class C0500hj implements C0496hg<T> {

    /* renamed from: a */
    final /* synthetic */ C0496hg f4993a;

    /* renamed from: b */
    final /* synthetic */ C0496hg f4994b;

    C0500hj(C0496hg hgVar, C0496hg hgVar2) {
        this.f4993a = hgVar;
        this.f4994b = hgVar2;
    }

    public boolean test(T t) {
        return this.f4993a.test(t) || this.f4994b.test(t);
    }
}
