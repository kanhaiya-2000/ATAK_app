package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;

public class byr implements bxx, bxy {

    /* renamed from: a */
    public static final String f4302a = "UTF-8";

    /* renamed from: b */
    private static final char[] f4303b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    private static final char[] f4304c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d */
    private final String f4305d;

    /* renamed from: a */
    public static byte[] m10607a(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[(length >> 1)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i + 1;
                i = i3 + 1;
                bArr[i2] = (byte) (((m10606a(cArr[i], i) << 4) | m10606a(cArr[i3], i3)) & 255);
                i2++;
            }
            return bArr;
        }
        throw new byb("Odd number of characters.");
    }

    /* renamed from: c */
    public static char[] m10610c(byte[] bArr) {
        return m10608a(bArr, true);
    }

    /* renamed from: a */
    public static char[] m10608a(byte[] bArr, boolean z) {
        return m10609a(bArr, z ? f4303b : f4304c);
    }

    /* renamed from: a */
    protected static char[] m10609a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & Ascii.f8523SI];
        }
        return cArr2;
    }

    /* renamed from: d */
    public static String m10611d(byte[] bArr) {
        return new String(m10610c(bArr));
    }

    /* renamed from: a */
    protected static int m10606a(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Illegal hexadecimal character ");
        stringBuffer.append(c);
        stringBuffer.append(" at index ");
        stringBuffer.append(i);
        throw new byb(stringBuffer.toString());
    }

    public byr() {
        this.f4305d = "UTF-8";
    }

    public byr(String str) {
        this.f4305d = str;
    }

    /* renamed from: a */
    public byte[] mo4070a(byte[] bArr) {
        try {
            return m10607a(new String(bArr, mo4101a()).toCharArray());
        } catch (UnsupportedEncodingException e) {
            throw new byb(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public Object mo4072a(Object obj) {
        try {
            return m10607a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e) {
            throw new byb(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public byte[] mo4071b(byte[] bArr) {
        return bys.m10621a(m10611d(bArr), mo4101a());
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        try {
            return m10610c(obj instanceof String ? ((String) obj).getBytes(mo4101a()) : (byte[]) obj);
        } catch (ClassCastException e) {
            throw new byd(e.getMessage(), e);
        } catch (UnsupportedEncodingException e2) {
            throw new byd(e2.getMessage(), e2);
        }
    }

    /* renamed from: a */
    public String mo4101a() {
        return this.f4305d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append("[charsetName=");
        stringBuffer.append(this.f4305d);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
