package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;

public final class bri {
    private bri() {
    }

    /* renamed from: a */
    public static String m8741a(String str, String str2) {
        try {
            String d = bwq.m10200e((str + ":" + str2).getBytes(bxz.f4229a)).mo3933d();
            return "Basic " + d;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
