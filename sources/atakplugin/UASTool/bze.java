package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;

public class bze extends bzh implements bye, byf {

    /* renamed from: d */
    private final String f4340d;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4147a() {
        return "B";
    }

    public bze() {
        this("UTF-8");
    }

    public bze(String str) {
        this.f4340d = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public byte[] mo4149a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return byk.m10561e(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo4151b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return byk.m10566j(bArr);
    }

    /* renamed from: a */
    public String mo4148a(String str, String str2) {
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
        return mo4148a(str, mo4150b());
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
        stringBuffer.append(" cannot be encoded using BCodec");
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
        stringBuffer.append(" cannot be decoded using BCodec");
        throw new byb(stringBuffer.toString());
    }

    /* renamed from: b */
    public String mo4150b() {
        return this.f4340d;
    }
}
