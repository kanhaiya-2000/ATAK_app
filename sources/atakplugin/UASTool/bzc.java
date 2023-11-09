package atakplugin.UASTool;

public class bzc implements byf {

    /* renamed from: a */
    public static final String f4335a = "01230120022455012623010202";

    /* renamed from: b */
    public static final bzc f4336b = new bzc();

    /* renamed from: c */
    private static final char[] f4337c = f4335a.toCharArray();

    /* renamed from: d */
    private int f4338d;

    /* renamed from: e */
    private final char[] f4339e;

    /* renamed from: a */
    public int mo4144a(String str, String str2) {
        return bzd.m10775a(this, str, str2);
    }

    public bzc() {
        this.f4338d = 4;
        this.f4339e = f4337c;
    }

    public bzc(char[] cArr) {
        this.f4338d = 4;
        char[] cArr2 = new char[cArr.length];
        this.f4339e = cArr2;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public bzc(String str) {
        this.f4338d = 4;
        this.f4339e = str.toCharArray();
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof String) {
            return mo4145a((String) obj);
        }
        throw new byd("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        return mo4145a(str);
    }

    /* renamed from: a */
    private char m10767a(String str, int i) {
        char charAt;
        char a = m10766a(str.charAt(i));
        if (i > 1 && a != '0' && ('H' == (charAt = str.charAt(i - 1)) || 'W' == charAt)) {
            char charAt2 = str.charAt(i - 2);
            if (m10766a(charAt2) == a || 'H' == charAt2 || 'W' == charAt2) {
                return 0;
            }
        }
        return a;
    }

    /* renamed from: a */
    public int mo4143a() {
        return this.f4338d;
    }

    /* renamed from: b */
    private char[] m10768b() {
        return this.f4339e;
    }

    /* renamed from: a */
    private char m10766a(char c) {
        int i = c - 'A';
        if (i >= 0 && i < m10768b().length) {
            return m10768b()[i];
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The character is not mapped: ");
        stringBuffer.append(c);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* renamed from: a */
    public void mo4146a(int i) {
        this.f4338d = i;
    }

    /* renamed from: a */
    public String mo4145a(String str) {
        if (str == null) {
            return null;
        }
        String a = bzd.m10777a(str);
        if (a.length() == 0) {
            return a;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = a.charAt(0);
        char a2 = m10767a(a, 0);
        int i = 1;
        int i2 = 1;
        while (i < a.length() && i2 < 4) {
            int i3 = i + 1;
            char a3 = m10767a(a, i);
            if (a3 != 0) {
                if (!(a3 == '0' || a3 == a2)) {
                    cArr[i2] = a3;
                    i2++;
                }
                a2 = a3;
            }
            i = i3;
        }
        return new String(cArr);
    }
}
