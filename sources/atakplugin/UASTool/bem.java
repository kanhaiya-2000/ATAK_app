package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/jvm/internal/ArrayFloatIterator;", "Lkotlin/collections/FloatIterator;", "array", "", "([F)V", "index", "", "hasNext", "", "nextFloat", "", "kotlin-stdlib"})
final class bem extends aul {

    /* renamed from: a */
    private int f2568a;

    /* renamed from: b */
    private final float[] f2569b;

    public bem(float[] fArr) {
        bfq.m6567f(fArr, "array");
        this.f2569b = fArr;
    }

    public boolean hasNext() {
        return this.f2568a < this.f2569b.length;
    }

    /* renamed from: b */
    public float mo1987b() {
        try {
            float[] fArr = this.f2569b;
            int i = this.f2568a;
            this.f2568a = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2568a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
