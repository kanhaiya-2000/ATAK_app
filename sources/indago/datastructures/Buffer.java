package indago.datastructures;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aov;
import atakplugin.UASTool.apx;
import atakplugin.UASTool.bfc;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bhd;
import atakplugin.UASTool.bhe;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001c\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0016\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\rH\u0016J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0002J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0015\u0010'\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u0016\u0010(\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0015\u0010)\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010*\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u001e\u0010+\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016J\r\u00100\u001a\u00020\u0005*\u00020\u0005H\bR\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b¨\u00062"}, mo1538e = {"Lindago/datastructures/Buffer;", "T", "", "", "bufferSize", "", "(I)V", "array", "", "[Ljava/lang/Object;", "getBufferSize", "()I", "hasFilled", "", "head", "size", "getSize", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "circular", "LocalListIterator", "indago"})
public final class Buffer<T> implements bhd, List<T> {
    private final Object[] array;
    private final int bufferSize;
    private boolean hasFilled;
    private int head;

    public Object[] toArray() {
        return bfc.m6477a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return bfc.m6479a(this, tArr);
    }

    public Buffer(int i) {
        this.bufferSize = i;
        if (i >= 2) {
            this.array = new Object[i];
            return;
        }
        throw new IllegalArgumentException("Buffer size (" + i + ") must be >= 2");
    }

    public final int getBufferSize() {
        return this.bufferSize;
    }

    public final T remove(int i) {
        return removeAt(i);
    }

    public final int size() {
        return getSize();
    }

    public int getSize() {
        return this.hasFilled ? this.bufferSize : this.head;
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        bfq.m6567f(obj, "element");
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        bfq.m6567f(collection, "elements");
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public T get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Requested index (" + i + ") must be greater than one and less than " + size());
        }
        T t = this.array[(this.head + i) % getBufferSize()];
        if (t != null) {
            return t;
        }
        throw new apx("null cannot be cast to non-null type T");
    }

    public int indexOf(Object obj) {
        if (obj != null) {
            bfq.m6567f(obj, "element");
            int size = size();
            for (int i = 0; i < size; i++) {
                if (bfq.m6552a(get(i), obj)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.hasFilled || this.head > 0;
    }

    public int lastIndexOf(Object obj) {
        if (obj != null) {
            bfq.m6567f(obj, "element");
            for (int size = size() - 1; size <= 0; size++) {
                if (bfq.m6552a(get(size), obj)) {
                    return size;
                }
            }
        }
        return -1;
    }

    public boolean add(T t) {
        bfq.m6567f(t, "element");
        int i = this.head;
        int bufferSize2 = (i + 1) % getBufferSize();
        this.head = bufferSize2;
        if (!this.hasFilled && bufferSize2 < i) {
            this.hasFilled = true;
        }
        this.array[i % getBufferSize()] = t;
        return true;
    }

    public void add(int i, T t) {
        bfq.m6567f(t, "element");
        throw new aov("An operation is not implemented: " + "Inserting at specific index not implemented");
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        bfq.m6567f(collection, "elements");
        throw new aov("An operation is not implemented: " + "Inserting at specific index not implemented");
    }

    public boolean addAll(Collection<? extends T> collection) {
        bfq.m6567f(collection, "elements");
        for (Object add : collection) {
            add(add);
        }
        return true;
    }

    public void clear() {
        this.hasFilled = false;
        this.head = 0;
        int i = this.bufferSize;
        for (int i2 = 0; i2 < i; i2++) {
            this.array[i2] = null;
        }
    }

    public Iterator<T> iterator() {
        return new LocalListIterator(0);
    }

    public ListIterator<T> listIterator() {
        return new LocalListIterator(0);
    }

    public ListIterator<T> listIterator(int i) {
        return new LocalListIterator(i);
    }

    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        bfq.m6567f(obj, "element");
        throw new aov("An operation is not implemented: " + "Removing elements not implemented");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        bfq.m6567f(collection, "elements");
        throw new aov("An operation is not implemented: " + "Removing elements not implemented");
    }

    public T removeAt(int i) {
        throw new aov("An operation is not implemented: " + "Removing elements not implemented");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        bfq.m6567f(collection, "elements");
        clear();
        return addAll(collection);
    }

    public T set(int i, T t) {
        bfq.m6567f(t, "element");
        throw new aov("An operation is not implemented: " + "Setting at specific index not implemented");
    }

    public List<T> subList(int i, int i2) {
        throw new aov("An operation is not implemented: " + "not implemented");
    }

    private final int circular(int i) {
        return i % getBufferSize();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010+\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\r\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0018"}, mo1538e = {"Lindago/datastructures/Buffer$LocalListIterator;", "", "startIndex", "", "(Lindago/datastructures/Buffer;I)V", "cursor", "getCursor", "()I", "setCursor", "(I)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "indago"})
    private final class LocalListIterator implements bhe, ListIterator<T> {
        private int cursor;

        public LocalListIterator(int i) {
            this.cursor = i;
        }

        public final int getCursor() {
            return this.cursor;
        }

        public final void setCursor(int i) {
            this.cursor = i;
        }

        public boolean hasNext() {
            return this.cursor < Buffer.this.size();
        }

        public boolean hasPrevious() {
            return this.cursor - 1 >= 0;
        }

        public T next() {
            T t = Buffer.this.get(this.cursor);
            this.cursor++;
            return t;
        }

        public int nextIndex() {
            return this.cursor;
        }

        public T previous() {
            int i = this.cursor - 1;
            this.cursor = i;
            return Buffer.this.get(i);
        }

        public int previousIndex() {
            return this.cursor - 1;
        }

        public void add(T t) {
            bfq.m6567f(t, "element");
            throw new aov("An operation is not implemented: " + "not implemented");
        }

        public void remove() {
            throw new aov("An operation is not implemented: " + "not implemented");
        }

        public void set(T t) {
            bfq.m6567f(t, "element");
            throw new aov("An operation is not implemented: " + "not implemented");
        }
    }
}
