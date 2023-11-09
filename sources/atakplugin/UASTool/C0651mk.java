package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mk */
public class C0651mk<T> extends C0551ja<T> {

    /* renamed from: a */
    private final Iterator<? extends T> f5280a;

    /* renamed from: b */
    private final long f5281b;

    /* renamed from: c */
    private long f5282c = 0;

    public C0651mk(Iterator<? extends T> it, long j) {
        this.f5280a = it;
        this.f5281b = j;
    }

    public boolean hasNext() {
        return this.f5282c < this.f5281b && this.f5280a.hasNext();
    }

    /* renamed from: a */
    public T mo4999a() {
        this.f5282c++;
        return this.f5280a.next();
    }
}
