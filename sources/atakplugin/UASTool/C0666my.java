package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.my */
public class C0666my<T> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5319d;

    /* renamed from: e */
    private final C0496hg<? super T> f5320e;

    public C0666my(Iterator<? extends T> it, C0496hg<? super T> hgVar) {
        this.f5319d = it;
        this.f5320e = hgVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        this.f5035b = this.f5319d.hasNext() && (!this.f5036c || !this.f5320e.test(this.f5034a));
        if (this.f5035b) {
            this.f5034a = this.f5319d.next();
        }
    }
}
