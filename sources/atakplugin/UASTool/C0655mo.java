package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mo */
public class C0655mo<T> extends C0560jd.C0562b {

    /* renamed from: a */
    private final Iterator<? extends T> f5289a;

    /* renamed from: b */
    private final C0528ij<? super T> f5290b;

    public C0655mo(Iterator<? extends T> it, C0528ij<? super T> ijVar) {
        this.f5289a = it;
        this.f5290b = ijVar;
    }

    public boolean hasNext() {
        return this.f5289a.hasNext();
    }

    /* renamed from: a */
    public int mo2940a() {
        return this.f5290b.mo3457a(this.f5289a.next());
    }
}
