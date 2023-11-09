package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mu */
public class C0662mu<T, R> extends C0549iz<R> {

    /* renamed from: d */
    private final Iterator<? extends T> f5306d;

    /* renamed from: e */
    private final R f5307e;

    /* renamed from: f */
    private final C0342cx<? super R, ? super T, ? extends R> f5308f;

    public C0662mu(Iterator<? extends T> it, R r, C0342cx<? super R, ? super T, ? extends R> cxVar) {
        this.f5306d = it;
        this.f5307e = r;
        this.f5308f = cxVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        if (!this.f5036c) {
            this.f5035b = true;
            this.f5034a = this.f5307e;
            return;
        }
        this.f5035b = this.f5306d.hasNext();
        if (this.f5035b) {
            this.f5034a = this.f5308f.mo4893a(this.f5034a, this.f5306d.next());
        }
    }
}
