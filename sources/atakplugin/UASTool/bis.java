package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, mo1538e = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class bis extends auu {

    /* renamed from: a */
    private final long f2748a;

    /* renamed from: b */
    private boolean f2749b;

    /* renamed from: c */
    private long f2750c;

    /* renamed from: d */
    private final long f2751d;

    public bis(long j, long j2, long j3) {
        this.f2751d = j3;
        this.f2748a = j2;
        boolean z = true;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i <= 0 ? i2 < 0 : i2 > 0) {
            z = false;
        }
        this.f2749b = z;
        this.f2750c = !z ? j2 : j;
    }

    /* renamed from: c */
    public final long mo2617c() {
        return this.f2751d;
    }

    public boolean hasNext() {
        return this.f2749b;
    }

    /* renamed from: b */
    public long mo2008b() {
        long j = this.f2750c;
        if (j != this.f2748a) {
            this.f2750c = this.f2751d + j;
        } else if (this.f2749b) {
            this.f2749b = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
