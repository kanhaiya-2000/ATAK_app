package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.ml */
public class C0652ml<T, R> extends C0551ja<R> {

    /* renamed from: a */
    private final Iterator<? extends T> f5283a;

    /* renamed from: b */
    private final C0391ei<? super T, ? extends R> f5284b;

    public C0652ml(Iterator<? extends T> it, C0391ei<? super T, ? extends R> eiVar) {
        this.f5283a = it;
        this.f5284b = eiVar;
    }

    public boolean hasNext() {
        return this.f5283a.hasNext();
    }

    /* renamed from: a */
    public R mo4999a() {
        return this.f5284b.apply(this.f5283a.next());
    }
}
