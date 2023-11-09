package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo1538e = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"})
public final class bmm<T> implements bkg<T>, bku<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final bku<T> f2905a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f2906b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f2907c;

    public bmm(bku<? extends T> bku, int i, int i2) {
        bfq.m6567f(bku, "sequence");
        this.f2905a = bku;
        this.f2906b = i;
        this.f2907c = i2;
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (!(i2 < i ? false : z)) {
                    throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
                }
                return;
            }
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
    }

    /* renamed from: b */
    private final int m7670b() {
        return this.f2907c - this.f2906b;
    }

    /* renamed from: a */
    public bku<T> mo2676a(int i) {
        return i >= m7670b() ? bkx.m7468b() : new bmm<>(this.f2905a, this.f2906b + i, this.f2907c);
    }

    /* renamed from: b */
    public bku<T> mo2677b(int i) {
        if (i >= m7670b()) {
            return this;
        }
        bku<T> bku = this.f2905a;
        int i2 = this.f2906b;
        return new bmm<>(bku, i2, i + i2);
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        return new bmn(this);
    }
}
