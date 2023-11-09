package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.mz */
public class C0667mz<T> extends C0549iz<T> {

    /* renamed from: d */
    private final C0547ix<? extends T> f5321d;

    /* renamed from: e */
    private final C0442fr<? super T> f5322e;

    public C0667mz(C0547ix<? extends T> ixVar, C0442fr<? super T> frVar) {
        this.f5321d = ixVar;
        this.f5322e = frVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        this.f5035b = this.f5321d.hasNext() && (!this.f5036c || !this.f5322e.mo4920a(this.f5321d.mo4987a(), this.f5034a));
        if (this.f5035b) {
            this.f5034a = this.f5321d.next();
        }
    }
}
