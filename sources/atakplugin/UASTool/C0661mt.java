package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mt */
public class C0661mt<T> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5304d;

    /* renamed from: e */
    private final C0342cx<T, T, T> f5305e;

    public C0661mt(Iterator<? extends T> it, C0342cx<T, T, T> cxVar) {
        this.f5304d = it;
        this.f5305e = cxVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        this.f5035b = this.f5304d.hasNext();
        if (this.f5035b) {
            Object next = this.f5304d.next();
            if (this.f5036c) {
                this.f5034a = this.f5305e.mo4893a(this.f5034a, next);
            } else {
                this.f5034a = next;
            }
        }
    }
}
