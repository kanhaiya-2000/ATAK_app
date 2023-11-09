package atakplugin.UASTool;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class buy {

    /* renamed from: a */
    public static final long f4018a = 253402300799999L;

    /* renamed from: b */
    private static final ThreadLocal<DateFormat> f4019b = new buz();

    /* renamed from: c */
    private static final String[] f4020c;

    /* renamed from: d */
    private static final DateFormat[] f4021d;

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f4020c = strArr;
        f4021d = new DateFormat[strArr.length];
    }

    /* renamed from: a */
    public static Date m9769a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f4019b.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = f4020c;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                DateFormat[] dateFormatArr = f4021d;
                DateFormat dateFormat = dateFormatArr[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f4020c[i], Locale.US);
                    dateFormat.setTimeZone(bsp.f3585d);
                    dateFormatArr[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m9768a(Date date) {
        return f4019b.get().format(date);
    }

    private buy() {
    }
}
