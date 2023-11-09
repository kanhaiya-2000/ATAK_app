package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.lx */
public class C0637lx<T> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5241d;

    /* renamed from: e */
    private final Iterator<? extends T> f5242e;

    /* renamed from: f */
    private boolean f5243f = true;

    public C0637lx(Iterator<? extends T> it, Iterator<? extends T> it2) {
        this.f5241d = it;
        this.f5242e = it2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        if (this.f5243f) {
            if (this.f5241d.hasNext()) {
                this.f5034a = this.f5241d.next();
                this.f5035b = true;
                return;
            }
            this.f5243f = false;
        }
        if (this.f5242e.hasNext()) {
            this.f5034a = this.f5242e.next();
            this.f5035b = true;
            return;
        }
        this.f5035b = false;
    }
}
