package atakplugin.UASTool;

public class bzb implements byf {

    /* renamed from: a */
    public static final String f4331a = "01360240043788015936020505";

    /* renamed from: b */
    public static final bzb f4332b = new bzb();

    /* renamed from: c */
    private static final char[] f4333c = f4331a.toCharArray();

    /* renamed from: d */
    private final char[] f4334d;

    public bzb() {
        this.f4334d = f4333c;
    }

    public bzb(char[] cArr) {
        char[] cArr2 = new char[cArr.length];
        this.f4334d = cArr2;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public bzb(String str) {
        this.f4334d = str.toCharArray();
    }

    /* renamed from: a */
    public int mo4141a(String str, String str2) {
        return bzd.m10775a(this, str, str2);
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof String) {
            return mo4142a((String) obj);
        }
        throw new byd("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        return mo4142a(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public char mo4140a(char c) {
        if (!Character.isLetter(c)) {
            return 0;
        }
        return this.f4334d[Character.toUpperCase(c) - 'A'];
    }

    /* renamed from: a */
    public String mo4142a(String str) {
        if (str == null) {
            return null;
        }
        String a = bzd.m10777a(str);
        if (a.length() == 0) {
            return a;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a.charAt(0));
        char c = '*';
        for (int i = 0; i < a.length(); i++) {
            char a2 = mo4140a(a.charAt(i));
            if (a2 != c) {
                if (a2 != 0) {
                    stringBuffer.append(a2);
                }
                c = a2;
            }
        }
        return stringBuffer.toString();
    }
}
