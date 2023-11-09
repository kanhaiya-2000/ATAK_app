package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\b\u001a\u0017\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\b¨\u0006\u0006"}, mo1538e = {"measureNanoTime", "", "block", "Lkotlin/Function0;", "", "measureTimeMillis", "kotlin-stdlib"})
public final class bmz {
    /* renamed from: a */
    public static final long m7713a(bdk<aqr> bdk) {
        bfq.m6567f(bdk, "block");
        long currentTimeMillis = System.currentTimeMillis();
        bdk.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }

    /* renamed from: b */
    public static final long m7714b(bdk<aqr> bdk) {
        bfq.m6567f(bdk, "block");
        long nanoTime = System.nanoTime();
        bdk.invoke();
        return System.nanoTime() - nanoTime;
    }
}
