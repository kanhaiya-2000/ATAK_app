package atakplugin.UASTool;

import com.autel.util.log.LogTask;
import java.util.concurrent.TimeUnit;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0001¨\u0006\u0004"}, mo1538e = {"shortName", "", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "kotlin-stdlib"}, mo1539f = "kotlin/time/DurationUnitKt", mo1541h = 1)
class bpt extends bps {
    /* renamed from: a */
    public static final String m8535a(TimeUnit timeUnit) {
        bfq.m6567f(timeUnit, "$this$shortName");
        switch (bpr.f3133a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return LogTask.LOG_TYPE_DEBUG;
            default:
                throw new aou();
        }
    }
}
