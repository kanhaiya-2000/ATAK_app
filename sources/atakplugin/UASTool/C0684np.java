package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;

/* renamed from: atakplugin.UASTool.np */
public final class C0684np {
    /* renamed from: a */
    public static byte[] m12528a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /* renamed from: a */
    public static String m12527a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /* renamed from: b */
    public static int m12529b(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException();
        }
    }
}
