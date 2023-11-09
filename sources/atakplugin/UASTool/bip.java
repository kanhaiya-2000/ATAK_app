package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, mo1538e = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class bip extends aut {

    /* renamed from: a */
    private final int f2738a;

    /* renamed from: b */
    private boolean f2739b;

    /* renamed from: c */
    private int f2740c;

    /* renamed from: d */
    private final int f2741d;

    public bip(int i, int i2, int i3) {
        this.f2741d = i3;
        this.f2738a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f2739b = z;
        this.f2740c = !z ? i2 : i;
    }

    /* renamed from: c */
    public final int mo2601c() {
        return this.f2741d;
    }

    public boolean hasNext() {
        return this.f2739b;
    }

    /* renamed from: b */
    public int mo2004b() {
        int i = this.f2740c;
        if (i != this.f2738a) {
            this.f2740c = this.f2741d + i;
        } else if (this.f2739b) {
            this.f2739b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
