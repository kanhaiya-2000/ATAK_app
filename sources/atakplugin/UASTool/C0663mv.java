package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mv */
public class C0663mv<T> extends C0551ja<T> {

    /* renamed from: a */
    private final Iterator<? extends T> f5309a;

    /* renamed from: b */
    private final long f5310b;

    /* renamed from: c */
    private long f5311c = 0;

    public C0663mv(Iterator<? extends T> it, long j) {
        this.f5309a = it;
        this.f5310b = j;
    }

    public boolean hasNext() {
        while (this.f5311c < this.f5310b) {
            if (!this.f5309a.hasNext()) {
                return false;
            }
            this.f5309a.next();
            this.f5311c++;
        }
        return this.f5309a.hasNext();
    }

    /* renamed from: a */
    public T mo4999a() {
        return this.f5309a.next();
    }
}
