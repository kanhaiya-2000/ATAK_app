package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo1538e = {"Lkotlin/collections/AbstractIterator;", "T", "", "()V", "nextValue", "Ljava/lang/Object;", "state", "Lkotlin/collections/State;", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"})
public abstract class arg<T> implements bgz, Iterator<T> {

    /* renamed from: a */
    private avs f2203a = avs.NotReady;

    /* renamed from: b */
    private T f2204b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo1711a();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean hasNext() {
        if (this.f2203a != avs.Failed) {
            int i = arh.f2205a[this.f2203a.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i != 2) {
                return m3045c();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public T next() {
        if (hasNext()) {
            this.f2203a = avs.NotReady;
            return this.f2204b;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: c */
    private final boolean m3045c() {
        this.f2203a = avs.Failed;
        mo1711a();
        return this.f2203a == avs.Ready;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo1712a(T t) {
        this.f2204b = t;
        this.f2203a = avs.Ready;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo1713b() {
        this.f2203a = avs.Done;
    }
}
