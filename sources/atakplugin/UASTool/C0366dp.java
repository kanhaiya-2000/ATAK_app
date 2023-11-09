package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.dp */
final class C0366dp implements C0363dn<T> {

    /* renamed from: a */
    final /* synthetic */ C0509hr f4898a;

    /* renamed from: b */
    final /* synthetic */ C0363dn f4899b;

    C0366dp(C0509hr hrVar, C0363dn dnVar) {
        this.f4898a = hrVar;
        this.f4899b = dnVar;
    }

    /* renamed from: a */
    public void mo838a(T t) {
        C0293ca.m10962b(this.f4898a);
        try {
            this.f4898a.mo4937a(t);
        } catch (Throwable unused) {
            C0363dn dnVar = this.f4899b;
            if (dnVar != null) {
                dnVar.mo838a(t);
            }
        }
    }
}
