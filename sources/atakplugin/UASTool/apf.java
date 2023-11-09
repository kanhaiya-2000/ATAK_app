package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b¨\u0006\u0007"}, mo1538e = {"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, mo1539f = "kotlin/PreconditionsKt", mo1541h = 1)
class apf {
    /* renamed from: a */
    private static final void m2588a(boolean z) {
        if (aqx.f2180a && !z) {
            throw new AssertionError("Assertion failed");
        }
    }

    /* renamed from: a */
    private static final void m2589a(boolean z, bdk<? extends Object> bdk) {
        if (aqx.f2180a && !z) {
            throw new AssertionError(bdk.invoke());
        }
    }
}
