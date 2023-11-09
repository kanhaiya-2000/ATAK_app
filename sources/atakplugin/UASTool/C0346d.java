package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.d */
final class C0346d implements C0339cv<M, T> {

    /* renamed from: a */
    final /* synthetic */ C0391ei f4883a;

    /* renamed from: b */
    final /* synthetic */ C0391ei f4884b;

    C0346d(C0391ei eiVar, C0391ei eiVar2) {
        this.f4883a = eiVar;
        this.f4884b = eiVar2;
    }

    /* renamed from: a */
    public void mo128a(M m, T t) {
        Object apply = this.f4883a.apply(t);
        Object b = C0293ca.m10962b(this.f4884b.apply(t));
        Object put = m.put(apply, b);
        if (put != null) {
            m.put(apply, put);
            throw C0130b.m6090b(apply, put, b);
        }
    }
}
