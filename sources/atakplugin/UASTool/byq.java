package atakplugin.UASTool;

public class byq implements bxx, bxy {

    /* renamed from: a */
    private static final char[] f4291a = new char[0];

    /* renamed from: b */
    private static final byte[] f4292b = new byte[0];

    /* renamed from: c */
    private static final int f4293c = 1;

    /* renamed from: d */
    private static final int f4294d = 2;

    /* renamed from: e */
    private static final int f4295e = 4;

    /* renamed from: f */
    private static final int f4296f = 8;

    /* renamed from: g */
    private static final int f4297g = 16;

    /* renamed from: h */
    private static final int f4298h = 32;

    /* renamed from: i */
    private static final int f4299i = 64;

    /* renamed from: j */
    private static final int f4300j = 128;

    /* renamed from: k */
    private static final int[] f4301k = {1, 2, 4, 8, 16, 32, 64, 128};

    /* renamed from: b */
    public byte[] mo4071b(byte[] bArr) {
        return m10597d(bArr);
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof byte[]) {
            return m10598e((byte[]) obj);
        }
        throw new byd("argument not a byte array");
    }

    /* renamed from: a */
    public Object mo4072a(Object obj) {
        if (obj == null) {
            return f4292b;
        }
        if (obj instanceof byte[]) {
            return m10596c((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return m10595a((char[]) obj);
        }
        if (obj instanceof String) {
            return m10595a(((String) obj).toCharArray());
        }
        throw new byb("argument not a byte array");
    }

    /* renamed from: a */
    public byte[] mo4070a(byte[] bArr) {
        return m10596c(bArr);
    }

    /* renamed from: a */
    public byte[] mo4100a(String str) {
        if (str == null) {
            return f4292b;
        }
        return m10595a(str.toCharArray());
    }

    /* renamed from: a */
    public static byte[] m10595a(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return f4292b;
        }
        int length = cArr.length >> 3;
        byte[] bArr = new byte[length];
        int length2 = cArr.length - 1;
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (true) {
                int[] iArr = f4301k;
                if (i2 >= iArr.length) {
                    break;
                }
                if (cArr[length2 - i2] == '1') {
                    bArr[i] = (byte) (iArr[i2] | bArr[i]);
                }
                i2++;
            }
            i++;
            length2 -= 8;
        }
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m10596c(byte[] bArr) {
        if (m10600g(bArr)) {
            return f4292b;
        }
        int length = bArr.length >> 3;
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length - 1;
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (true) {
                int[] iArr = f4301k;
                if (i2 >= iArr.length) {
                    break;
                }
                if (bArr[length2 - i2] == 49) {
                    bArr2[i] = (byte) (iArr[i2] | bArr2[i]);
                }
                i2++;
            }
            i++;
            length2 -= 8;
        }
        return bArr2;
    }

    /* renamed from: g */
    private static boolean m10600g(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    /* renamed from: d */
    public static byte[] m10597d(byte[] bArr) {
        if (m10600g(bArr)) {
            return f4292b;
        }
        int length = bArr.length << 3;
        byte[] bArr2 = new byte[length];
        int i = length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f4301k;
                if (i3 >= iArr.length) {
                    break;
                }
                if ((iArr[i3] & bArr[i2]) == 0) {
                    bArr2[i - i3] = 48;
                } else {
                    bArr2[i - i3] = 49;
                }
                i3++;
            }
            i2++;
            i -= 8;
        }
        return bArr2;
    }

    /* renamed from: e */
    public static char[] m10598e(byte[] bArr) {
        if (m10600g(bArr)) {
            return f4291a;
        }
        int length = bArr.length << 3;
        char[] cArr = new char[length];
        int i = length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f4301k;
                if (i3 >= iArr.length) {
                    break;
                }
                if ((iArr[i3] & bArr[i2]) == 0) {
                    cArr[i - i3] = '0';
                } else {
                    cArr[i - i3] = '1';
                }
                i3++;
            }
            i2++;
            i -= 8;
        }
        return cArr;
    }

    /* renamed from: f */
    public static String m10599f(byte[] bArr) {
        return new String(m10598e(bArr));
    }
}
