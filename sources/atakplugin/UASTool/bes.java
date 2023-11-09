package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/jvm/internal/ArrayShortIterator;", "Lkotlin/collections/ShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextShort", "", "kotlin-stdlib"})
final class bes extends avo {

    /* renamed from: a */
    private int f2576a;

    /* renamed from: b */
    private final short[] f2577b;

    public bes(short[] sArr) {
        bfq.m6567f(sArr, "array");
        this.f2577b = sArr;
    }

    public boolean hasNext() {
        return this.f2576a < this.f2577b.length;
    }

    /* renamed from: b */
    public short mo2060b() {
        try {
            short[] sArr = this.f2577b;
            int i = this.f2576a;
            this.f2576a = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2576a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
