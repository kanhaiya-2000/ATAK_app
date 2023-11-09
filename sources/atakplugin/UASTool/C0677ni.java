package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;

/* renamed from: atakplugin.UASTool.ni */
public class C0677ni {

    /* renamed from: a */
    private static final char[] f5334a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m12484a(byte[] bArr) {
        return m12485a(bArr, 0);
    }

    /* renamed from: a */
    public static String m12485a(byte[] bArr, int i) {
        int length = bArr.length;
        char[] cArr = new char[((length << 1) + (i > 0 ? length / i : 0))];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i > 0 && i3 % i == 0 && i2 > 0) {
                cArr[i2] = '-';
                i2++;
            }
            int i4 = i2 + 1;
            char[] cArr2 = f5334a;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & Ascii.f8523SI];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static byte[] m12486a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
