package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/jvm/internal/ArrayCharIterator;", "Lkotlin/collections/CharIterator;", "array", "", "([C)V", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"})
final class bek extends atn {

    /* renamed from: a */
    private int f2564a;

    /* renamed from: b */
    private final char[] f2565b;

    public bek(char[] cArr) {
        bfq.m6567f(cArr, "array");
        this.f2565b = cArr;
    }

    public boolean hasNext() {
        return this.f2564a < this.f2565b.length;
    }

    /* renamed from: b */
    public char mo1882b() {
        try {
            char[] cArr = this.f2565b;
            int i = this.f2564a;
            this.f2564a = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2564a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
