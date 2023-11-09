package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.ma */
public class C0641ma<T> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5250d;

    /* renamed from: e */
    private final C0496hg<? super T> f5251e;

    public C0641ma(Iterator<? extends T> it, C0496hg<? super T> hgVar) {
        this.f5250d = it;
        this.f5251e = hgVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        if (!this.f5036c) {
            do {
                boolean hasNext = this.f5250d.hasNext();
                this.f5035b = hasNext;
                if (hasNext) {
                    this.f5034a = this.f5250d.next();
                }
            } while (this.f5251e.test(this.f5034a));
            return;
        }
        this.f5035b = this.f5035b && this.f5250d.hasNext();
        if (this.f5035b) {
            this.f5034a = this.f5250d.next();
        }
    }
}
