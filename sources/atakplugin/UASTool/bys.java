package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;

public class bys {
    /* renamed from: a */
    public static byte[] m10620a(String str) {
        return m10621a(str, bxz.f4229a);
    }

    /* renamed from: b */
    public static byte[] m10623b(String str) {
        return m10621a(str, bxz.f4230b);
    }

    /* renamed from: c */
    public static byte[] m10625c(String str) {
        return m10621a(str, bxz.f4231c);
    }

    /* renamed from: d */
    public static byte[] m10627d(String str) {
        return m10621a(str, bxz.f4232d);
    }

    /* renamed from: e */
    public static byte[] m10629e(String str) {
        return m10621a(str, bxz.f4233e);
    }

    /* renamed from: f */
    public static byte[] m10631f(String str) {
        return m10621a(str, "UTF-8");
    }

    /* renamed from: a */
    public static byte[] m10621a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            throw m10617a(str2, e);
        }
    }

    /* renamed from: a */
    private static IllegalStateException m10617a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(": ");
        stringBuffer.append(unsupportedEncodingException);
        return new IllegalStateException(stringBuffer.toString());
    }

    /* renamed from: a */
    public static String m10619a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw m10617a(str, e);
        }
    }

    /* renamed from: a */
    public static String m10618a(byte[] bArr) {
        return m10619a(bArr, bxz.f4229a);
    }

    /* renamed from: b */
    public static String m10622b(byte[] bArr) {
        return m10619a(bArr, bxz.f4230b);
    }

    /* renamed from: c */
    public static String m10624c(byte[] bArr) {
        return m10619a(bArr, bxz.f4231c);
    }

    /* renamed from: d */
    public static String m10626d(byte[] bArr) {
        return m10619a(bArr, bxz.f4232d);
    }

    /* renamed from: e */
    public static String m10628e(byte[] bArr) {
        return m10619a(bArr, bxz.f4233e);
    }

    /* renamed from: f */
    public static String m10630f(byte[] bArr) {
        return m10619a(bArr, "UTF-8");
    }
}
