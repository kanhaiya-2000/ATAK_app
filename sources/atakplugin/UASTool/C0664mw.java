package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* renamed from: atakplugin.UASTool.mw */
public class C0664mw<T> extends C0551ja<List<T>> {

    /* renamed from: a */
    private final Queue<T> f5312a = C0533in.m12276a();

    /* renamed from: b */
    private final Iterator<? extends T> f5313b;

    /* renamed from: c */
    private final int f5314c;

    /* renamed from: d */
    private final int f5315d;

    public C0664mw(Iterator<? extends T> it, int i, int i2) {
        this.f5313b = it;
        this.f5314c = i;
        this.f5315d = i2;
    }

    public boolean hasNext() {
        return this.f5313b.hasNext();
    }

    /* renamed from: b */
    public List<T> mo4999a() {
        for (int size = this.f5312a.size(); size < this.f5314c && this.f5313b.hasNext(); size++) {
            this.f5312a.offer(this.f5313b.next());
        }
        ArrayList arrayList = new ArrayList(this.f5312a);
        int min = Math.min(this.f5312a.size(), this.f5315d);
        for (int i = 0; i < min; i++) {
            this.f5312a.poll();
        }
        for (int i2 = this.f5314c; i2 < this.f5315d && this.f5313b.hasNext(); i2++) {
            this.f5313b.next();
        }
        return arrayList;
    }
}
