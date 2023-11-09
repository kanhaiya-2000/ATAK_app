package atakplugin.UASTool;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class bzg implements bxx, bxy, bye, byf {

    /* renamed from: b */
    private static final BitSet f4346b = new BitSet(256);

    /* renamed from: c */
    private static final byte f4347c = 61;

    /* renamed from: d */
    private static final byte f4348d = 9;

    /* renamed from: e */
    private static final byte f4349e = 32;

    /* renamed from: a */
    private final String f4350a;

    static {
        for (int i = 33; i <= 60; i++) {
            f4346b.set(i);
        }
        for (int i2 = 62; i2 <= 126; i2++) {
            f4346b.set(i2);
        }
        BitSet bitSet = f4346b;
        bitSet.set(9);
        bitSet.set(32);
    }

    public bzg() {
        this("UTF-8");
    }

    public bzg(String str) {
        this.f4350a = str;
    }

    /* renamed from: a */
    private static final void m10798a(int i, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char upperCase = Character.toUpperCase(Character.forDigit((i >> 4) & 15, 16));
        char upperCase2 = Character.toUpperCase(Character.forDigit(i & 15, 16));
        byteArrayOutputStream.write(upperCase);
        byteArrayOutputStream.write(upperCase2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] m10799a(java.util.BitSet r4, byte[] r5) {
        /*
            if (r5 != 0) goto L_0x0004
            r4 = 0
            return r4
        L_0x0004:
            if (r4 != 0) goto L_0x0008
            java.util.BitSet r4 = f4346b
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x000e:
            int r2 = r5.length
            if (r1 >= r2) goto L_0x0027
            byte r2 = r5[r1]
            if (r2 >= 0) goto L_0x0017
            int r2 = r2 + 256
        L_0x0017:
            boolean r3 = r4.get(r2)
            if (r3 == 0) goto L_0x0021
            r0.write(r2)
            goto L_0x0024
        L_0x0021:
            m10798a((int) r2, (java.io.ByteArrayOutputStream) r0)
        L_0x0024:
            int r1 = r1 + 1
            goto L_0x000e
        L_0x0027:
            byte[] r4 = r0.toByteArray()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bzg.m10799a(java.util.BitSet, byte[]):byte[]");
    }

    /* renamed from: c */
    public static final byte[] m10800c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 61) {
                int i2 = i + 1;
                try {
                    int a = bzj.m10827a(bArr[i2]);
                    i = i2 + 1;
                    byteArrayOutputStream.write((char) ((a << 4) + bzj.m10827a(bArr[i])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new byb("Invalid quoted-printable encoding", e);
                }
            } else {
                byteArrayOutputStream.write(b);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public byte[] mo4071b(byte[] bArr) {
        return m10799a(f4346b, bArr);
    }

    /* renamed from: a */
    public byte[] mo4070a(byte[] bArr) {
        return m10800c(bArr);
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return mo4158b(str, mo4156a());
        } catch (UnsupportedEncodingException e) {
            throw new byd(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public String mo4157a(String str, String str2) {
        if (str == null) {
            return null;
        }
        return new String(mo4070a(bys.m10623b(str)), str2);
    }

    /* renamed from: a */
    public String mo4074a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return mo4157a(str, mo4156a());
        } catch (UnsupportedEncodingException e) {
            throw new byb(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return mo4071b((byte[]) obj);
        }
        if (obj instanceof String) {
            return mo4075b((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be quoted-printable encoded");
        throw new byd(stringBuffer.toString());
    }

    /* renamed from: a */
    public Object mo4072a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return mo4070a((byte[]) obj);
        }
        if (obj instanceof String) {
            return mo4074a((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be quoted-printable decoded");
        throw new byb(stringBuffer.toString());
    }

    /* renamed from: a */
    public String mo4156a() {
        return this.f4350a;
    }

    /* renamed from: b */
    public String mo4158b(String str, String str2) {
        if (str == null) {
            return null;
        }
        return bys.m10622b(mo4071b(str.getBytes(str2)));
    }
}
