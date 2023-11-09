package atakplugin.UASTool;

import com.autel.util.log.LogTask;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Vector;

class aji {

    /* renamed from: a */
    static final byte[] f1621a = m1820c("");

    /* renamed from: b */
    private static final byte[] f1622b = m1820c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=");

    /* renamed from: c */
    private static String[] f1623c = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", LogTask.LOG_TYPE_DEBUG, LogTask.LOG_TYPE_ERROR, "f"};

    /* renamed from: b */
    private static int m1811b(byte b) {
        if (((byte) (b & 128)) == 0) {
            return 1;
        }
        if (((byte) (b & 224)) == -64) {
            return 2;
        }
        return ((byte) (b & 240)) == -32 ? 3 : 1;
    }

    aji() {
    }

    /* renamed from: a */
    private static byte m1799a(byte b) {
        if (b == 61) {
            return 0;
        }
        int i = 0;
        while (true) {
            byte[] bArr = f1622b;
            if (i >= bArr.length) {
                return 0;
            }
            if (b == bArr[i]) {
                return (byte) i;
            }
            i++;
        }
    }

    /* renamed from: a */
    static byte[] m1809a(byte[] bArr, int i, int i2) {
        try {
            byte[] bArr2 = new byte[i2];
            int i3 = i;
            int i4 = 0;
            while (true) {
                if (i3 >= i + i2) {
                    break;
                }
                int i5 = i3 + 1;
                bArr2[i4] = (byte) ((m1799a(bArr[i3]) << 2) | ((m1799a(bArr[i5]) & 48) >>> 4));
                int i6 = i3 + 2;
                if (bArr[i6] == 61) {
                    i4++;
                    break;
                }
                bArr2[i4 + 1] = (byte) (((m1799a(bArr[i5]) & Ascii.f8523SI) << 4) | ((m1799a(bArr[i6]) & 60) >>> 2));
                int i7 = i3 + 3;
                if (bArr[i7] == 61) {
                    i4 += 2;
                    break;
                }
                bArr2[i4 + 2] = (byte) (((m1799a(bArr[i6]) & 3) << 6) | (m1799a(bArr[i7]) & bxu.f4219a));
                i4 += 3;
                i3 += 4;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ahj("fromBase64: invalid base64 data", e);
        }
    }

    /* renamed from: b */
    static byte[] m1817b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 * 2)];
        int i3 = ((i2 / 3) * 3) + i;
        int i4 = i;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 1;
            byte[] bArr3 = f1622b;
            bArr2[i5] = bArr3[(bArr[i4] >>> 2) & 63];
            int i7 = i4 + 1;
            int i8 = i6 + 1;
            bArr2[i6] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] >>> 4) & 15)];
            int i9 = i4 + 2;
            int i10 = ((bArr[i7] & Ascii.f8523SI) << 2) | ((bArr[i9] >>> 6) & 3);
            int i11 = i8 + 1;
            bArr2[i8] = bArr3[i10];
            bArr2[i11] = bArr3[bArr[i9] & bxu.f4219a];
            i4 += 3;
            i5 = i11 + 1;
        }
        int i12 = (i + i2) - i3;
        if (i12 == 1) {
            int i13 = i5 + 1;
            byte[] bArr4 = f1622b;
            bArr2[i5] = bArr4[(bArr[i4] >>> 2) & 63];
            int i14 = i13 + 1;
            bArr2[i13] = bArr4[((bArr[i4] & 3) << 4) & 63];
            int i15 = i14 + 1;
            bArr2[i14] = 61;
            i5 = i15 + 1;
            bArr2[i15] = 61;
        } else if (i12 == 2) {
            int i16 = i5 + 1;
            byte[] bArr5 = f1622b;
            bArr2[i5] = bArr5[(bArr[i4] >>> 2) & 63];
            int i17 = i4 + 1;
            int i18 = i16 + 1;
            bArr2[i16] = bArr5[((bArr[i4] & 3) << 4) | ((bArr[i17] >>> 4) & 15)];
            int i19 = i18 + 1;
            bArr2[i18] = bArr5[((bArr[i17] & Ascii.f8523SI) << 2) & 63];
            i5 = i19 + 1;
            bArr2[i19] = 61;
        }
        byte[] bArr6 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr6, 0, i5);
        return bArr6;
    }

    /* renamed from: a */
    static String[] m1810a(String str, String str2) {
        if (str == null) {
            return null;
        }
        byte[] c = m1820c(str);
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf < 0) {
                break;
            }
            vector.addElement(m1819c(c, i, indexOf - i));
            i = indexOf + 1;
        }
        vector.addElement(m1819c(c, i, c.length - i));
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    /* renamed from: a */
    static boolean m1807a(byte[] bArr, byte[] bArr2) {
        return m1806a(bArr, 0, bArr2, 0);
    }

    /* renamed from: a */
    private static boolean m1806a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length <= 0 || bArr2[0] != 46) {
            return m1814b(bArr, i, bArr2, i2);
        }
        if (bArr.length <= 0 || bArr[0] != 46) {
            return false;
        }
        if (bArr.length == 2 && bArr[1] == 42) {
            return true;
        }
        return m1814b(bArr, i + 1, bArr2, i2 + 1);
    }

    /* renamed from: b */
    private static boolean m1814b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int length = bArr.length;
        if (length == 0) {
            return false;
        }
        int length2 = bArr2.length;
        while (i < length && i2 < length2) {
            if (bArr[i] == 92) {
                int i4 = i + 1;
                if (i4 == length || bArr[i4] != bArr2[i2]) {
                    return false;
                }
                i = i4 + m1811b(bArr[i4]);
                i3 = m1811b(bArr2[i2]);
            } else if (bArr[i] == 42) {
                while (i < length && bArr[i] == 42) {
                    i++;
                }
                if (length == i) {
                    return true;
                }
                byte b = bArr[i];
                if (b == 63) {
                    while (i2 < length2) {
                        if (m1814b(bArr, i, bArr2, i2)) {
                            return true;
                        }
                        i2 += m1811b(bArr2[i2]);
                    }
                    return false;
                } else if (b == 92) {
                    int i5 = i + 1;
                    if (i5 == length) {
                        return false;
                    }
                    byte b2 = bArr[i5];
                    while (i2 < length2) {
                        if (b2 == bArr2[i2] && m1814b(bArr, m1811b(b2) + i5, bArr2, m1811b(bArr2[i2]) + i2)) {
                            return true;
                        }
                        i2 += m1811b(bArr2[i2]);
                    }
                    return false;
                } else {
                    while (i2 < length2) {
                        if (b == bArr2[i2] && m1814b(bArr, i, bArr2, i2)) {
                            return true;
                        }
                        i2 += m1811b(bArr2[i2]);
                    }
                    return false;
                }
            } else if (bArr[i] == 63) {
                i++;
                i3 = m1811b(bArr2[i2]);
            } else if (bArr[i] != bArr2[i2]) {
                return false;
            } else {
                i += m1811b(bArr[i]);
                i2 += m1811b(bArr2[i2]);
                if (i2 < length2) {
                    continue;
                } else if (i >= length) {
                    return true;
                } else {
                    if (bArr[i] == 42) {
                        break;
                    }
                }
            }
            i2 += i3;
        }
        if (i == length && i2 == length2) {
            return true;
        }
        if (i2 < length2 || bArr[i] != 42) {
            return false;
        }
        while (i < length) {
            int i6 = i + 1;
            if (bArr[i] != 42) {
                return false;
            }
            i = i6;
        }
        return true;
    }

    /* renamed from: a */
    static String m1801a(String str) {
        byte[] c = m1820c(str);
        int i = 0;
        int i2 = 0;
        for (byte b : c) {
            if (b == 92 || b == 63 || b == 42) {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        byte[] bArr = new byte[(c.length + i2)];
        int i3 = 0;
        while (i < c.length) {
            byte b2 = c[i];
            if (b2 == 92 || b2 == 63 || b2 == 42) {
                bArr[i3] = 92;
                i3++;
            }
            bArr[i3] = b2;
            i++;
            i3++;
        }
        return m1813b(bArr);
    }

    /* renamed from: b */
    static String m1812b(String str) {
        byte[] c = m1820c(str);
        byte[] a = m1808a(c);
        if (c.length == a.length) {
            return str;
        }
        return m1813b(a);
    }

    /* renamed from: a */
    static byte[] m1808a(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            if (bArr[i] == 92) {
                int i2 = i + 1;
                if (i2 == length) {
                    break;
                }
                System.arraycopy(bArr, i2, bArr, i, bArr.length - i2);
                length--;
                i = i2;
            } else {
                i++;
            }
        }
        if (length == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    /* renamed from: a */
    static String m1800a(agz agz, byte[] bArr) {
        try {
            agz.mo834a();
            int i = 0;
            agz.mo835a(bArr, 0, bArr.length);
            byte[] c = agz.mo837c();
            StringBuffer stringBuffer = new StringBuffer();
            while (i < c.length) {
                byte b = c[i] & 255;
                stringBuffer.append(f1623c[(b >>> 4) & 15]);
                stringBuffer.append(f1623c[b & Ascii.f8523SI]);
                i++;
                if (i < c.length) {
                    stringBuffer.append(":");
                }
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "???";
        }
    }

    /* renamed from: b */
    static boolean m1815b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static Socket m1805a(String str, int i, int i2) {
        String str2;
        if (i2 == 0) {
            try {
                return new Socket(str, i);
            } catch (Exception e) {
                String exc = e.toString();
                if (e instanceof Throwable) {
                    throw new ahj(exc, e);
                }
                throw new ahj(exc);
            }
        } else {
            Socket[] socketArr = new Socket[1];
            Exception[] excArr = new Exception[1];
            Thread thread = new Thread(new ajj(socketArr, str, i, excArr));
            thread.setName("Opening Socket " + str);
            thread.start();
            try {
                thread.join((long) i2);
                str2 = "timeout: ";
            } catch (InterruptedException unused) {
                str2 = "";
            }
            if (socketArr[0] != null && socketArr[0].isConnected()) {
                return socketArr[0];
            }
            String str3 = str2 + "socket is not established";
            if (excArr[0] != null) {
                str3 = excArr[0].toString();
            }
            thread.interrupt();
            throw new ahj(str3, excArr[0]);
        }
    }

    /* renamed from: b */
    static byte[] m1816b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* renamed from: c */
    static byte[] m1820c(String str) {
        return m1816b(str, "UTF-8");
    }

    /* renamed from: a */
    static String m1804a(byte[] bArr, String str) {
        return m1803a(bArr, 0, bArr.length, str);
    }

    /* renamed from: a */
    static String m1803a(byte[] bArr, int i, int i2, String str) {
        try {
            return new String(bArr, i, i2, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr, i, i2);
        }
    }

    /* renamed from: b */
    static String m1813b(byte[] bArr) {
        return m1803a(bArr, 0, bArr.length, "UTF-8");
    }

    /* renamed from: c */
    static String m1819c(byte[] bArr, int i, int i2) {
        return m1803a(bArr, i, i2, "UTF-8");
    }

    /* renamed from: c */
    static String m1818c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < bArr.length) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            StringBuilder sb = new StringBuilder();
            sb.append("0x");
            sb.append(hexString.length() == 1 ? "0" : "");
            sb.append(hexString);
            stringBuffer.append(sb.toString());
            i++;
            if (i < bArr.length) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: d */
    static void m1822d(byte[] bArr) {
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = 0;
            }
        }
    }

    /* renamed from: a */
    static String m1802a(String str, String[] strArr) {
        String[] a = m1810a(str, ",");
        String str2 = null;
        for (int i = 0; i < a.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 < strArr.length) {
                    if (a[i].equals(strArr[i2])) {
                        break;
                    }
                    i2++;
                } else if (str2 == null) {
                    str2 = a[i];
                } else {
                    str2 = str2 + "," + a[i];
                }
            }
        }
        return str2;
    }

    /* renamed from: d */
    static String m1821d(String str) {
        try {
            return str.startsWith("~") ? str.replace("~", System.getProperty("user.home")) : str;
        } catch (SecurityException unused) {
            return str;
        }
    }

    /* renamed from: e */
    static byte[] m1823e(String str) {
        String d = m1821d(str);
        File file = new File(d);
        FileInputStream fileInputStream = new FileInputStream(d);
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr, i, length - i);
                if (read <= 0) {
                    fileInputStream.close();
                    return bArr;
                }
                i += read;
            }
        } finally {
            fileInputStream.close();
        }
    }
}
