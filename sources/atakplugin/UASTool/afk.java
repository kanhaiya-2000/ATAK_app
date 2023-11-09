package atakplugin.UASTool;

import java.util.Date;

public class afk {
    /* renamed from: a */
    public static Date m851a(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    /* renamed from: a */
    public static long m850a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
