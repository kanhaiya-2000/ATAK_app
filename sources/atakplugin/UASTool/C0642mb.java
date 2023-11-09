package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.mb */
public class C0642mb<T> extends C0549iz<T> {

    /* renamed from: d */
    private final C0547ix<? extends T> f5252d;

    /* renamed from: e */
    private final C0442fr<? super T> f5253e;

    public C0642mb(C0547ix<? extends T> ixVar, C0442fr<? super T> frVar) {
        this.f5252d = ixVar;
        this.f5253e = frVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        int a;
        if (!this.f5036c) {
            do {
                boolean hasNext = this.f5252d.hasNext();
                this.f5035b = hasNext;
                if (hasNext) {
                    a = this.f5252d.mo4987a();
                    this.f5034a = this.f5252d.next();
                }
            } while (this.f5253e.mo4920a(a, this.f5034a));
            return;
        }
        this.f5035b = this.f5035b && this.f5252d.hasNext();
        if (this.f5035b) {
            this.f5034a = this.f5252d.next();
        }
    }
}
