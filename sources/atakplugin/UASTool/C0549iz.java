package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.iz */
public abstract class C0549iz<T> implements Iterator<T> {

    /* renamed from: a */
    protected T f5034a;

    /* renamed from: b */
    protected boolean f5035b;

    /* renamed from: c */
    protected boolean f5036c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4994a();

    public boolean hasNext() {
        if (!this.f5036c) {
            mo4994a();
            this.f5036c = true;
        }
        return this.f5035b;
    }

    public T next() {
        if (!this.f5036c) {
            hasNext();
        }
        if (this.f5035b) {
            T t = this.f5034a;
            mo4994a();
            if (!this.f5035b) {
                this.f5034a = null;
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
