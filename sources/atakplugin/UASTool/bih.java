package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, mo1538e = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", "", "last", "step", "", "(CCI)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextChar", "kotlin-stdlib"})
public final class bih extends atn {

    /* renamed from: a */
    private final int f2722a;

    /* renamed from: b */
    private boolean f2723b;

    /* renamed from: c */
    private int f2724c;

    /* renamed from: d */
    private final int f2725d;

    public bih(char c, char c2, int i) {
        this.f2725d = i;
        this.f2722a = c2;
        boolean z = true;
        if (i <= 0 ? c < c2 : c > c2) {
            z = false;
        }
        this.f2723b = z;
        this.f2724c = !z ? c2 : c;
    }

    /* renamed from: c */
    public final int mo2564c() {
        return this.f2725d;
    }

    public boolean hasNext() {
        return this.f2723b;
    }

    /* renamed from: b */
    public char mo1882b() {
        int i = this.f2724c;
        if (i != this.f2722a) {
            this.f2724c = this.f2725d + i;
        } else if (this.f2723b) {
            this.f2723b = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i;
    }
}
