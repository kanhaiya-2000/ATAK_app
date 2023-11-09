package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3})
public final /* synthetic */ class bpr {

    /* renamed from: a */
    public static final /* synthetic */ int[] f3133a;

    static {
        int[] iArr = new int[TimeUnit.values().length];
        f3133a = iArr;
        iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
        iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
        iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
        iArr[TimeUnit.SECONDS.ordinal()] = 4;
        iArr[TimeUnit.MINUTES.ordinal()] = 5;
        iArr[TimeUnit.HOURS.ordinal()] = 6;
        iArr[TimeUnit.DAYS.ordinal()] = 7;
    }
}
