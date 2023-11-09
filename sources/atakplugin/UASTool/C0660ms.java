package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.ms */
public class C0660ms<T> extends C0551ja<T> {

    /* renamed from: a */
    private final Iterator<? extends T> f5302a;

    /* renamed from: b */
    private final C0363dn<? super T> f5303b;

    public C0660ms(Iterator<? extends T> it, C0363dn<? super T> dnVar) {
        this.f5302a = it;
        this.f5303b = dnVar;
    }

    public boolean hasNext() {
        return this.f5302a.hasNext();
    }

    /* renamed from: a */
    public T mo4999a() {
        T next = this.f5302a.next();
        this.f5303b.mo838a(next);
        return next;
    }
}
