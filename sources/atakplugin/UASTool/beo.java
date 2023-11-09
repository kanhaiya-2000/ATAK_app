package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eR\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo1538e = {"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "array", "", "([Ljava/lang/Object;)V", "getArray", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "index", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
final class beo<T> implements bgz, Iterator<T> {

    /* renamed from: a */
    private int f2572a;

    /* renamed from: b */
    private final T[] f2573b;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public beo(T[] tArr) {
        bfq.m6567f(tArr, "array");
        this.f2573b = tArr;
    }

    /* renamed from: a */
    public final T[] mo2317a() {
        return this.f2573b;
    }

    public boolean hasNext() {
        return this.f2572a < this.f2573b.length;
    }

    public T next() {
        try {
            T[] tArr = this.f2573b;
            int i = this.f2572a;
            this.f2572a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2572a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
