package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo1538e = {"Lkotlin/jvm/internal/ArrayIntIterator;", "Lkotlin/collections/IntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextInt", "kotlin-stdlib"})
final class ben extends aut {

    /* renamed from: a */
    private int f2570a;

    /* renamed from: b */
    private final int[] f2571b;

    public ben(int[] iArr) {
        bfq.m6567f(iArr, "array");
        this.f2571b = iArr;
    }

    public boolean hasNext() {
        return this.f2570a < this.f2571b.length;
    }

    /* renamed from: b */
    public int mo2004b() {
        try {
            int[] iArr = this.f2571b;
            int i = this.f2570a;
            this.f2570a = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2570a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
