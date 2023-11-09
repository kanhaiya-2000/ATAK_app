package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/jvm/internal/ArrayDoubleIterator;", "Lkotlin/collections/DoubleIterator;", "array", "", "([D)V", "index", "", "hasNext", "", "nextDouble", "", "kotlin-stdlib"})
final class bel extends aug {

    /* renamed from: a */
    private int f2566a;

    /* renamed from: b */
    private final double[] f2567b;

    public bel(double[] dArr) {
        bfq.m6567f(dArr, "array");
        this.f2567b = dArr;
    }

    public boolean hasNext() {
        return this.f2566a < this.f2567b.length;
    }

    /* renamed from: b */
    public double mo1894b() {
        try {
            double[] dArr = this.f2567b;
            int i = this.f2566a;
            this.f2566a = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2566a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
