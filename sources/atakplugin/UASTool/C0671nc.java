package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.nc */
public class C0671nc<F, S, R> extends C0551ja<R> {

    /* renamed from: a */
    private final Iterator<? extends F> f5327a;

    /* renamed from: b */
    private final Iterator<? extends S> f5328b;

    /* renamed from: c */
    private final C0342cx<? super F, ? super S, ? extends R> f5329c;

    public C0671nc(Iterator<? extends F> it, Iterator<? extends S> it2, C0342cx<? super F, ? super S, ? extends R> cxVar) {
        this.f5327a = it;
        this.f5328b = it2;
        this.f5329c = cxVar;
    }

    public boolean hasNext() {
        return this.f5327a.hasNext() && this.f5328b.hasNext();
    }

    /* renamed from: a */
    public R mo4999a() {
        return this.f5329c.mo4893a(this.f5327a.next(), this.f5328b.next());
    }
}
