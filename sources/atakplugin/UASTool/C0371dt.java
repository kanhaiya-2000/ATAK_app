package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.dt */
final class C0371dt implements C0368dr {

    /* renamed from: a */
    final /* synthetic */ C0510hs f4902a;

    /* renamed from: b */
    final /* synthetic */ C0368dr f4903b;

    C0371dt(C0510hs hsVar, C0368dr drVar) {
        this.f4902a = hsVar;
        this.f4903b = drVar;
    }

    /* renamed from: a */
    public void mo4899a(double d) {
        try {
            this.f4902a.mo4938a(d);
        } catch (Throwable unused) {
            C0368dr drVar = this.f4903b;
            if (drVar != null) {
                drVar.mo4899a(d);
            }
        }
    }
}
