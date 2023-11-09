package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: atakplugin.UASTool.lw */
public class C0636lw<T, K> extends C0551ja<List<T>> {

    /* renamed from: a */
    private final Iterator<? extends T> f5237a;

    /* renamed from: b */
    private final C0391ei<? super T, ? extends K> f5238b;

    /* renamed from: c */
    private T f5239c;

    /* renamed from: d */
    private boolean f5240d;

    public C0636lw(Iterator<? extends T> it, C0391ei<? super T, ? extends K> eiVar) {
        this.f5237a = it;
        this.f5238b = eiVar;
    }

    public boolean hasNext() {
        return this.f5240d || this.f5237a.hasNext();
    }

    /* renamed from: b */
    public List<T> mo4999a() {
        Object apply = this.f5238b.apply(m12437d());
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(m12436c());
            if (!this.f5237a.hasNext() || !apply.equals(this.f5238b.apply(m12437d()))) {
                return arrayList;
            }
            arrayList.add(m12436c());
            break;
        } while (!apply.equals(this.f5238b.apply(m12437d())));
        return arrayList;
    }

    /* renamed from: c */
    private T m12436c() {
        T d = m12437d();
        this.f5240d = false;
        return d;
    }

    /* renamed from: d */
    private T m12437d() {
        if (!this.f5240d) {
            this.f5239c = this.f5237a.next();
            this.f5240d = true;
        }
        return this.f5239c;
    }
}
