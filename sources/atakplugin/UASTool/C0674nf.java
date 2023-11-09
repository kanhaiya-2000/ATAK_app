package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;

/* renamed from: atakplugin.UASTool.nf */
public final class C0674nf {
    /* renamed from: a */
    public static byte[] m12481a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("us-ascii");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /* renamed from: a */
    public static String m12480a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "us-ascii");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }
}
