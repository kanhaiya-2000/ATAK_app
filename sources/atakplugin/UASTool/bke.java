package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo1538e = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"})
public final class bke<T> implements bkg<T>, bku<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final bku<T> f2799a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f2800b;

    public bke(bku<? extends T> bku, int i) {
        bfq.m6567f(bku, "sequence");
        this.f2799a = bku;
        this.f2800b = i;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
        }
    }

    /* renamed from: a */
    public bku<T> mo2676a(int i) {
        int i2 = this.f2800b + i;
        return i2 < 0 ? new bke<>(this, i) : new bke<>(this.f2799a, i2);
    }

    /* renamed from: b */
    public bku<T> mo2677b(int i) {
        int i2 = this.f2800b;
        int i3 = i2 + i;
        return i3 < 0 ? new bmo<>(this, i) : new bmm<>(this.f2799a, i2, i3);
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        return new bkf(this);
    }
}
