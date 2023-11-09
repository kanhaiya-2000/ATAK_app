package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.na */
public class C0669na<T> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5323d;

    /* renamed from: e */
    private final C0496hg<? super T> f5324e;

    public C0669na(Iterator<? extends T> it, C0496hg<? super T> hgVar) {
        this.f5323d = it;
        this.f5324e = hgVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        boolean z;
        if (this.f5323d.hasNext()) {
            C0496hg<? super T> hgVar = this.f5324e;
            Object next = this.f5323d.next();
            this.f5034a = next;
            if (hgVar.test(next)) {
                z = true;
                this.f5035b = z;
            }
        }
        z = false;
        this.f5035b = z;
    }
}
