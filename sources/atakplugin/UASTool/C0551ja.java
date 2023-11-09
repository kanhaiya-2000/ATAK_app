package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.ja */
public abstract class C0551ja<T> implements Iterator<T> {
    /* renamed from: a */
    public abstract T mo4999a();

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }

    public final T next() {
        if (hasNext()) {
            return mo4999a();
        }
        throw new NoSuchElementException();
    }
}
