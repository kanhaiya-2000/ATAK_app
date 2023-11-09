package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mn */
public class C0654mn<T> extends C0560jd.C0561a {

    /* renamed from: a */
    private final Iterator<? extends T> f5287a;

    /* renamed from: b */
    private final C0527ii<? super T> f5288b;

    public C0654mn(Iterator<? extends T> it, C0527ii<? super T> iiVar) {
        this.f5287a = it;
        this.f5288b = iiVar;
    }

    public boolean hasNext() {
        return this.f5287a.hasNext();
    }

    /* renamed from: a */
    public double mo2515a() {
        return this.f5288b.mo2737a(this.f5287a.next());
    }
}
