package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.mp */
public class C0656mp<T> extends C0560jd.C0563c {

    /* renamed from: a */
    private final Iterator<? extends T> f5291a;

    /* renamed from: b */
    private final C0529ik<? super T> f5292b;

    public C0656mp(Iterator<? extends T> it, C0529ik<? super T> ikVar) {
        this.f5291a = it;
        this.f5292b = ikVar;
    }

    public boolean hasNext() {
        return this.f5291a.hasNext();
    }

    /* renamed from: a */
    public long mo3698a() {
        return this.f5292b.mo4135a(this.f5291a.next());
    }
}
