package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.me */
public class C0645me<T, R> extends C0549iz<R> {

    /* renamed from: d */
    private final Iterator<? extends T> f5264d;

    /* renamed from: e */
    private final C0391ei<? super T, ? extends C0325cn<? extends R>> f5265e;

    /* renamed from: f */
    private Iterator<? extends R> f5266f;

    /* renamed from: g */
    private C0325cn<? extends R> f5267g;

    public C0645me(Iterator<? extends T> it, C0391ei<? super T, ? extends C0325cn<? extends R>> eiVar) {
        this.f5264d = it;
        this.f5265e = eiVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        Iterator<? extends R> it = this.f5266f;
        if (it == null || !it.hasNext()) {
            while (this.f5264d.hasNext()) {
                Iterator<? extends R> it2 = this.f5266f;
                if (it2 == null || !it2.hasNext()) {
                    C0325cn<? extends R> cnVar = this.f5267g;
                    if (cnVar != null) {
                        cnVar.close();
                        this.f5267g = null;
                    }
                    C0325cn<? extends R> cnVar2 = (C0325cn) this.f5265e.apply(this.f5264d.next());
                    if (cnVar2 != null) {
                        this.f5266f = cnVar2.mo4748b();
                        this.f5267g = cnVar2;
                    }
                }
                Iterator<? extends R> it3 = this.f5266f;
                if (it3 != null && it3.hasNext()) {
                    this.f5034a = this.f5266f.next();
                    this.f5035b = true;
                    return;
                }
            }
            this.f5035b = false;
            C0325cn<? extends R> cnVar3 = this.f5267g;
            if (cnVar3 != null) {
                cnVar3.close();
                this.f5267g = null;
                return;
            }
            return;
        }
        this.f5034a = this.f5266f.next();
        this.f5035b = true;
    }
}
