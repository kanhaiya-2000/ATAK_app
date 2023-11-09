package atakplugin.UASTool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: atakplugin.UASTool.ly */
public class C0638ly<T> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5244d;

    /* renamed from: e */
    private final Set<T> f5245e = new HashSet();

    public C0638ly(Iterator<? extends T> it) {
        this.f5244d = it;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        do {
            boolean hasNext = this.f5244d.hasNext();
            this.f5035b = hasNext;
            if (hasNext) {
                this.f5034a = this.f5244d.next();
            } else {
                return;
            }
        } while (!this.f5245e.add(this.f5034a));
    }
}
