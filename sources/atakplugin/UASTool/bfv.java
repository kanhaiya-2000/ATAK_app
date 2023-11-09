package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo1538e = {"Lkotlin/jvm/internal/LongSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"})
public final class bfv extends bgg<long[]> {

    /* renamed from: a */
    private final long[] f2633a;

    public bfv(int i) {
        super(i);
        this.f2633a = new long[i];
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2323a(long[] jArr) {
        bfq.m6567f(jArr, "$this$getSize");
        return jArr.length;
    }

    /* renamed from: a */
    public final void mo2400a(long j) {
        long[] jArr = this.f2633a;
        int b = mo2468b();
        mo2469b(b + 1);
        jArr[b] = j;
    }

    /* renamed from: a */
    public final long[] mo2326a() {
        return (long[]) mo2467a(this.f2633a, new long[mo2471c()]);
    }
}
