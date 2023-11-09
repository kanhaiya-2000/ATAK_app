package atakplugin.UASTool;

import com.autel.util.log.LogTask;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u001c\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo1538e = {"precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "rootNegativeExpFormatSymbols", "Ljava/text/DecimalFormatSymbols;", "rootPositiveExpFormatSymbols", "scientificFormat", "createFormatForDecimals", "decimals", "", "formatScientific", "", "value", "", "formatToExactDecimals", "formatUpToDecimals", "kotlin-stdlib"})
public final class bpv {

    /* renamed from: a */
    private static final DecimalFormatSymbols f3134a;

    /* renamed from: b */
    private static final DecimalFormatSymbols f3135b;

    /* renamed from: c */
    private static final ThreadLocal<DecimalFormat>[] f3136c;

    /* renamed from: d */
    private static final ThreadLocal<DecimalFormat> f3137d = new ThreadLocal<>();

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols.setExponentSeparator(LogTask.LOG_TYPE_ERROR);
        f3134a = decimalFormatSymbols;
        DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(Locale.ROOT);
        decimalFormatSymbols2.setExponentSeparator("e+");
        f3135b = decimalFormatSymbols2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal<>();
        }
        f3136c = threadLocalArr;
    }

    /* renamed from: a */
    private static final DecimalFormat m8538a(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0", f3134a);
        if (i > 0) {
            decimalFormat.setMinimumFractionDigits(i);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    /* renamed from: a */
    public static final String m8537a(double d, int i) {
        DecimalFormat decimalFormat;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f3136c;
        if (i < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i];
            DecimalFormat decimalFormat2 = threadLocal.get();
            if (decimalFormat2 == null) {
                decimalFormat2 = m8538a(i);
                threadLocal.set(decimalFormat2);
            }
            decimalFormat = decimalFormat2;
        } else {
            decimalFormat = m8538a(i);
        }
        String format = decimalFormat.format(d);
        bfq.m6554b(format, "format.format(value)");
        return format;
    }

    /* renamed from: b */
    public static final String m8539b(double d, int i) {
        DecimalFormat a = m8538a(0);
        a.setMaximumFractionDigits(i);
        String format = a.format(d);
        bfq.m6554b(format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }

    /* renamed from: a */
    public static final String m8536a(double d) {
        ThreadLocal<DecimalFormat> threadLocal = f3137d;
        DecimalFormat decimalFormat = threadLocal.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0E0", f3134a);
            decimalFormat.setMinimumFractionDigits(2);
            threadLocal.set(decimalFormat);
        }
        DecimalFormat decimalFormat2 = decimalFormat;
        decimalFormat2.setDecimalFormatSymbols((d >= ((double) 1) || d <= ((double) -1)) ? f3135b : f3134a);
        String format = decimalFormat2.format(d);
        bfq.m6554b(format, "scientificFormat.getOrSe… }\n        .format(value)");
        return format;
    }
}
