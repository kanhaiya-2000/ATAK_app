package atakplugin.UASTool;

import com.google.common.base.Ascii;

/* renamed from: atakplugin.UASTool.sw */
public class C0861sw {

    /* renamed from: a */
    private static final String f6524a = "0123456789ABCDEF";

    /* renamed from: b */
    private static final String f6525b = "0x";

    /* renamed from: c */
    private static final String f6526c = " ";

    private C0861sw() {
    }

    /* renamed from: a */
    public static String m13871a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i <= bArr.length - 1; i++) {
            byte b = bArr[i];
            sb.append(f6525b);
            sb.append(f6524a.charAt((b & 240) >> 4));
            sb.append(f6524a.charAt(b & Ascii.f8523SI));
            sb.append(f6526c);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m13872a(String str) {
        String replaceAll = str.trim().replaceAll(f6525b, "").replaceAll("\\s+", "");
        byte[] bArr = new byte[(replaceAll.length() / 2)];
        int i = 0;
        int i2 = 0;
        while (i <= replaceAll.length() - 1) {
            int i3 = i + 2;
            bArr[i2] = (byte) Integer.parseInt(replaceAll.substring(i, i3), 16);
            i2++;
            i = i3;
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m13873b(String str) {
        if (str.length() == 1) {
            return "000" + str;
        } else if (str.length() == 2) {
            return "00" + str;
        } else if (str.length() != 3) {
            return str;
        } else {
            return "0" + str;
        }
    }
}
