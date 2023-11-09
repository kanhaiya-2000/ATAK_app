package atakplugin.UASTool;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class bzi implements bxx, bxy, bye, byf {

    /* renamed from: a */
    static final int f4354a = 16;

    /* renamed from: c */
    protected static final byte f4355c = 37;

    /* renamed from: d */
    protected static final BitSet f4356d = new BitSet(256);

    /* renamed from: b */
    protected String f4357b;

    static {
        for (int i = 97; i <= 122; i++) {
            f4356d.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f4356d.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            f4356d.set(i3);
        }
        BitSet bitSet = f4356d;
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        bitSet.set(42);
        bitSet.set(32);
    }

    public bzi() {
        this("UTF-8");
    }

    public bzi(String str) {
        this.f4357b = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] m10815a(java.util.BitSet r5, byte[] r6) {
        /*
            if (r6 != 0) goto L_0x0004
            r5 = 0
            return r5
        L_0x0004:
            if (r5 != 0) goto L_0x0008
            java.util.BitSet r5 = f4356d
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x000e:
            int r2 = r6.length
            if (r1 >= r2) goto L_0x004d
            byte r2 = r6[r1]
            if (r2 >= 0) goto L_0x0017
            int r2 = r2 + 256
        L_0x0017:
            boolean r3 = r5.get(r2)
            if (r3 == 0) goto L_0x0027
            r3 = 32
            if (r2 != r3) goto L_0x0023
            r2 = 43
        L_0x0023:
            r0.write(r2)
            goto L_0x004a
        L_0x0027:
            r3 = 37
            r0.write(r3)
            int r3 = r2 >> 4
            r3 = r3 & 15
            r4 = 16
            char r3 = java.lang.Character.forDigit(r3, r4)
            char r3 = java.lang.Character.toUpperCase(r3)
            r2 = r2 & 15
            char r2 = java.lang.Character.forDigit(r2, r4)
            char r2 = java.lang.Character.toUpperCase(r2)
            r0.write(r3)
            r0.write(r2)
        L_0x004a:
            int r1 = r1 + 1
            goto L_0x000e
        L_0x004d:
            byte[] r5 = r0.toByteArray()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bzi.m10815a(java.util.BitSet, byte[]):byte[]");
    }

    /* renamed from: c */
    public static final byte[] m10816c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 43) {
                byteArrayOutputStream.write(32);
            } else if (b == 37) {
                int i2 = i + 1;
                try {
                    int a = bzj.m10827a(bArr[i2]);
                    i = i2 + 1;
                    byteArrayOutputStream.write((char) ((a << 4) + bzj.m10827a(bArr[i])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new byb("Invalid URL encoding: ", e);
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
        return m10815a(f4356d, bArr);
    }

    /* renamed from: a */
    public byte[] mo4070a(byte[] bArr) {
        return m10816c(bArr);
    }

    /* renamed from: a */
    public String mo4162a(String str, String str2) {
        if (str == null) {
            return null;
        }
        return bys.m10622b(mo4071b(str.getBytes(str2)));
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return mo4162a(str, mo4163b());
        } catch (UnsupportedEncodingException e) {
            throw new byd(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public String mo4164b(String str, String str2) {
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
            return mo4164b(str, mo4163b());
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
        stringBuffer.append(" cannot be URL encoded");
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
        stringBuffer.append(" cannot be URL decoded");
        throw new byb(stringBuffer.toString());
    }

    /* renamed from: a */
    public String mo4161a() {
        return this.f4357b;
    }

    /* renamed from: b */
    public String mo4163b() {
        return this.f4357b;
    }
}
