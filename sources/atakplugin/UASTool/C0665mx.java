package atakplugin.UASTool;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: atakplugin.UASTool.mx */
public class C0665mx<T> extends C0549iz<T> {

    /* renamed from: d */
    private final Iterator<? extends T> f5316d;

    /* renamed from: e */
    private final Comparator<? super T> f5317e;

    /* renamed from: f */
    private Iterator<T> f5318f;

    public C0665mx(Iterator<? extends T> it, Comparator<? super T> comparator) {
        this.f5316d = it;
        this.f5317e = comparator;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4994a() {
        if (!this.f5036c) {
            List<T> a = C0537ir.m12282a(this.f5316d);
            Collections.sort(a, this.f5317e);
            this.f5318f = a.iterator();
        }
        this.f5035b = this.f5318f.hasNext();
        if (this.f5035b) {
            this.f5034a = this.f5318f.next();
        }
    }
}
