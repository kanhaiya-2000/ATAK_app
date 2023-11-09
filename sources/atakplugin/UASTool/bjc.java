package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u00020\u0003X\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo1538e = {"Lkotlin/ranges/ULongProgressionIterator;", "Lkotlin/collections/ULongIterator;", "first", "Lkotlin/ULong;", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "nextULong", "()J", "kotlin-stdlib"})
final class bjc extends awa {

    /* renamed from: a */
    private final long f2769a;

    /* renamed from: b */
    private boolean f2770b;

    /* renamed from: c */
    private final long f2771c;

    /* renamed from: d */
    private long f2772d;

    private bjc(long j, long j2, long j3) {
        this.f2769a = j2;
        boolean z = true;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        int a = aqu.m3028a(j, j2);
        if (i <= 0 ? a < 0 : a > 0) {
            z = false;
        }
        this.f2770b = z;
        this.f2771c = aqg.m2843b(j3);
        this.f2772d = !this.f2770b ? j2 : j;
    }

    public /* synthetic */ bjc(long j, long j2, long j3, bfd bfd) {
        this(j, j2, j3);
    }

    public boolean hasNext() {
        return this.f2770b;
    }

    /* renamed from: a */
    public long mo1657a() {
        long j = this.f2772d;
        if (j != this.f2769a) {
            this.f2772d = aqg.m2843b(this.f2771c + j);
        } else if (this.f2770b) {
            this.f2770b = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
