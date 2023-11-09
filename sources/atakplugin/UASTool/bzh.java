package atakplugin.UASTool;

abstract class bzh {

    /* renamed from: a */
    protected static final char f4351a = '?';

    /* renamed from: b */
    protected static final String f4352b = "?=";

    /* renamed from: c */
    protected static final String f4353c = "=?";

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo4147a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract byte[] mo4149a(byte[] bArr);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract byte[] mo4151b(byte[] bArr);

    bzh() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4159b(String str, String str2) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f4353c);
        stringBuffer.append(str2);
        stringBuffer.append(f4351a);
        stringBuffer.append(mo4147a());
        stringBuffer.append(f4351a);
        stringBuffer.append(bys.m10622b(mo4149a(str.getBytes(str2))));
        stringBuffer.append(f4352b);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4160c(String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(f4353c) || !str.endsWith(f4352b)) {
            throw new byb("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int indexOf = str.indexOf(63, 2);
        if (indexOf != length) {
            String substring = str.substring(2, indexOf);
            if (!substring.equals("")) {
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(63, i);
                if (indexOf2 != length) {
                    String substring2 = str.substring(i, indexOf2);
                    if (mo4147a().equalsIgnoreCase(substring2)) {
                        int i2 = indexOf2 + 1;
                        return new String(mo4151b(bys.m10623b(str.substring(i2, str.indexOf(63, i2)))), substring);
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("This codec cannot decode ");
                    stringBuffer.append(substring2);
                    stringBuffer.append(" encoded content");
                    throw new byb(stringBuffer.toString());
                }
                throw new byb("RFC 1522 violation: encoding token not found");
            }
            throw new byb("RFC 1522 violation: charset not specified");
        }
        throw new byb("RFC 1522 violation: charset token not found");
    }
}
