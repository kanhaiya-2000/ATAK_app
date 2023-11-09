package atakplugin.UASTool;

import java.util.Locale;

final class bzd {
    bzd() {
    }

    /* renamed from: a */
    static String m10777a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isLetter(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        if (i == length) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        return new String(cArr, 0, i).toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: a */
    static int m10775a(byf byf, String str, String str2) {
        return m10776a(byf.mo4075b(str), byf.mo4075b(str2));
    }

    /* renamed from: a */
    static int m10776a(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int min = Math.min(str.length(), str2.length());
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            if (str.charAt(i2) == str2.charAt(i2)) {
                i++;
            }
        }
        return i;
    }
}
