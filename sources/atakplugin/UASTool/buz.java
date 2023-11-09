package atakplugin.UASTool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class buz extends ThreadLocal<DateFormat> {
    buz() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public DateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(bsp.f3585d);
        return simpleDateFormat;
    }
}
