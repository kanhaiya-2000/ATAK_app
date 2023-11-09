package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u00020\u0003X\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo1538e = {"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "first", "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "nextUInt", "()I", "kotlin-stdlib"})
final class biz extends avz {

    /* renamed from: a */
    private final int f2758a;

    /* renamed from: b */
    private boolean f2759b;

    /* renamed from: c */
    private final int f2760c;

    /* renamed from: d */
    private int f2761d;

    private biz(int i, int i2, int i3) {
        this.f2758a = i2;
        boolean z = true;
        int a = aqu.m3027a(i, i2);
        if (i3 <= 0 ? a < 0 : a > 0) {
            z = false;
        }
        this.f2759b = z;
        this.f2760c = aqc.m2761b(i3);
        this.f2761d = !this.f2759b ? i2 : i;
    }

    public /* synthetic */ biz(int i, int i2, int i3, bfd bfd) {
        this(i, i2, i3);
    }

    public boolean hasNext() {
        return this.f2759b;
    }

    /* renamed from: a */
    public int mo1629a() {
        int i = this.f2761d;
        if (i != this.f2758a) {
            this.f2761d = aqc.m2761b(this.f2760c + i);
        } else if (this.f2759b) {
            this.f2759b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
