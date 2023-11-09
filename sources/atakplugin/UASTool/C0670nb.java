package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.nb */
public class C0670nb<T> extends C0549iz<T> {

    /* renamed from: d */
    private final C0547ix<? extends T> f5325d;

    /* renamed from: e */
    private final C0442fr<? super T> f5326e;

    public C0670nb(C0547ix<? extends T> ixVar, C0442fr<? super T> frVar) {
        this.f5325d = ixVar;
        this.f5326e = frVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        boolean z;
        if (this.f5325d.hasNext()) {
            C0442fr<? super T> frVar = this.f5326e;
            int a = this.f5325d.mo4987a();
            Object next = this.f5325d.next();
            this.f5034a = next;
            if (frVar.mo4920a(a, next)) {
                z = true;
                this.f5035b = z;
            }
        }
        z = false;
        this.f5035b = z;
    }
}
