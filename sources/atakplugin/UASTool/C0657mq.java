package atakplugin.UASTool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: atakplugin.UASTool.mq */
public class C0657mq<T> extends C0551ja<T> {

    /* renamed from: a */
    private final Iterator<? extends T> f5293a;

    /* renamed from: b */
    private final Iterator<? extends T> f5294b;

    /* renamed from: c */
    private final C0342cx<? super T, ? super T, C0658a> f5295c;

    /* renamed from: d */
    private final Queue<T> f5296d = new LinkedList();

    /* renamed from: e */
    private final Queue<T> f5297e = new LinkedList();

    /* renamed from: atakplugin.UASTool.mq$a */
    public enum C0658a {
        TAKE_FIRST,
        TAKE_SECOND
    }

    public C0657mq(Iterator<? extends T> it, Iterator<? extends T> it2, C0342cx<? super T, ? super T, C0658a> cxVar) {
        this.f5293a = it;
        this.f5294b = it2;
        this.f5295c = cxVar;
    }

    public boolean hasNext() {
        return !this.f5296d.isEmpty() || !this.f5297e.isEmpty() || this.f5293a.hasNext() || this.f5294b.hasNext();
    }

    /* renamed from: a */
    public T mo4999a() {
        if (!this.f5296d.isEmpty()) {
            T poll = this.f5296d.poll();
            return this.f5294b.hasNext() ? m12461a(poll, this.f5294b.next()) : poll;
        } else if (!this.f5297e.isEmpty()) {
            T poll2 = this.f5297e.poll();
            return this.f5293a.hasNext() ? m12461a(this.f5293a.next(), poll2) : poll2;
        } else if (!this.f5293a.hasNext()) {
            return this.f5294b.next();
        } else {
            if (!this.f5294b.hasNext()) {
                return this.f5293a.next();
            }
            return m12461a(this.f5293a.next(), this.f5294b.next());
        }
    }

    /* renamed from: a */
    private T m12461a(T t, T t2) {
        if (C0659mr.f5301a[this.f5295c.mo4893a(t, t2).ordinal()] != 1) {
            this.f5296d.add(t);
            return t2;
        }
        this.f5297e.add(t2);
        return t;
    }
}
