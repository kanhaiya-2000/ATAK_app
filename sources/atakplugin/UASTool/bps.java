package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001*\u001e\b\u0007\u0010\u0007\"\u00020\u00042\u00020\u0004B\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nB\u0002\b\u000b¨\u0006\f"}, mo1538e = {"convertDurationUnit", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "DurationUnit", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "kotlin-stdlib"}, mo1539f = "kotlin/time/DurationUnitKt", mo1541h = 1)
class bps {
    /* renamed from: a */
    public static /* synthetic */ void m8534a() {
    }

    /* renamed from: a */
    public static final double m8533a(double d, TimeUnit timeUnit, TimeUnit timeUnit2) {
        bfq.m6567f(timeUnit, "sourceUnit");
        bfq.m6567f(timeUnit2, "targetUnit");
        long convert = timeUnit2.convert(1, timeUnit);
        if (convert > 0) {
            return d * ((double) convert);
        }
        return d / ((double) timeUnit.convert(1, timeUnit2));
    }
}
