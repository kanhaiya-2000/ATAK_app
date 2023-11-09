package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class bzf extends bzh implements bye, byf {

    /* renamed from: e */
    private static final BitSet f4341e;

    /* renamed from: f */
    private static final byte f4342f = 32;

    /* renamed from: g */
    private static final byte f4343g = 95;

    /* renamed from: d */
    private final String f4344d;

    /* renamed from: h */
    private boolean f4345h;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4147a() {
        return "Q";
    }

    static {
        BitSet bitSet = new BitSet(256);
        f4341e = bitSet;
        bitSet.set(32);
        bitSet.set(33);
        bitSet.set(34);
        bitSet.set(35);
        bitSet.set(36);
        bitSet.set(37);
        bitSet.set(38);
        bitSet.set(39);
        bitSet.set(40);
        bitSet.set(41);
        bitSet.set(42);
        bitSet.set(43);
        bitSet.set(44);
        bitSet.set(45);
        bitSet.set(46);
        bitSet.set(47);
        for (int i = 48; i <= 57; i++) {
            f4341e.set(i);
        }
        BitSet bitSet2 = f4341e;
        bitSet2.set(58);
        bitSet2.set(59);
        bitSet2.set(60);
        bitSet2.set(62);
        bitSet2.set(64);
        for (int i2 = 65; i2 <= 90; i2++) {
            f4341e.set(i2);
        }
        BitSet bitSet3 = f4341e;
        bitSet3.set(91);
        bitSet3.set(92);
        bitSet3.set(93);
        bitSet3.set(94);
        bitSet3.set(96);
        for (int i3 = 97; i3 <= 122; i3++) {
            f4341e.set(i3);
        }
        BitSet bitSet4 = f4341e;
        bitSet4.set(123);
        bitSet4.set(124);
        bitSet4.set(125);
        bitSet4.set(126);
    }

    public bzf() {
        this("UTF-8");
    }

    public bzf(String str) {
        this.f4345h = false;
        this.f4344d = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public byte[] mo4149a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] a = bzg.m10799a(f4341e, bArr);
        if (this.f4345h) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 32) {
                    a[i] = f4343g;
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo4151b(byte[] bArr) {
        boolean z;
        if (bArr == null) {
            return null;
        }
        int i = 0;
        while (true) {
            if (i >= bArr.length) {
                z = false;
                break;
            } else if (bArr[i] == 95) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return bzg.m10800c(bArr);
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            if (b != 95) {
                bArr2[i2] = b;
            } else {
                bArr2[i2] = 32;
            }
        }
        return bzg.m10800c(bArr2);
    }

    /* renamed from: a */
    public String mo4152a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return mo4159b(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new byd(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        if (str == null) {
            return null;
        }
        return mo4152a(str, mo4154b());
    }

    /* renamed from: a */
    public String mo4074a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return mo4160c(str);
        } catch (UnsupportedEncodingException e) {
            throw new byb(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return mo4075b((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be encoded using Q codec");
        throw new byd(stringBuffer.toString());
    }

    /* renamed from: a */
    public Object mo4072a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return mo4074a((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be decoded using Q codec");
        throw new byb(stringBuffer.toString());
    }

    /* renamed from: b */
    public String mo4154b() {
        return this.f4344d;
    }

    /* renamed from: c */
    public boolean mo4155c() {
        return this.f4345h;
    }

    /* renamed from: a */
    public void mo4153a(boolean z) {
        this.f4345h = z;
    }
}
