package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo1538e = {"Lkotlin/jvm/internal/ArrayBooleanIterator;", "Lkotlin/collections/BooleanIterator;", "array", "", "([Z)V", "index", "", "hasNext", "", "nextBoolean", "kotlin-stdlib"})
final class bei extends atl {

    /* renamed from: a */
    private int f2560a;

    /* renamed from: b */
    private final boolean[] f2561b;

    public bei(boolean[] zArr) {
        bfq.m6567f(zArr, "array");
        this.f2561b = zArr;
    }

    public boolean hasNext() {
        return this.f2560a < this.f2561b.length;
    }

    /* renamed from: b */
    public boolean mo1874b() {
        try {
            boolean[] zArr = this.f2561b;
            int i = this.f2560a;
            this.f2560a = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2560a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
