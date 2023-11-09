package atakplugin.UASTool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: atakplugin.UASTool.lz */
public class C0639lz<T, K> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5246d;

    /* renamed from: e */
    private final C0391ei<? super T, ? extends K> f5247e;

    /* renamed from: f */
    private final Set<K> f5248f = new HashSet();

    public C0639lz(Iterator<? extends T> it, C0391ei<? super T, ? extends K> eiVar) {
        this.f5246d = it;
        this.f5247e = eiVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        do {
            boolean hasNext = this.f5246d.hasNext();
            this.f5035b = hasNext;
            if (hasNext) {
                this.f5034a = this.f5246d.next();
            } else {
                return;
            }
        } while (!this.f5248f.add(this.f5247e.apply(this.f5034a)));
    }
}
