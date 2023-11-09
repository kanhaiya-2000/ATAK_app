package atakplugin.UASTool;

import java.util.ListIterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, mo1538e = {"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"})
public final class auh implements bgz, ListIterator {

    /* renamed from: a */
    public static final auh f2270a = new auh();

    /* renamed from: a */
    public void mo1898a(Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public void mo1901b(Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private auh() {
    }

    /* renamed from: a */
    public Void next() {
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    public Void previous() {
        throw new NoSuchElementException();
    }
}
