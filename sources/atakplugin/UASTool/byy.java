package atakplugin.UASTool;

import java.util.Locale;

public class byy implements byf {

    /* renamed from: a */
    static Class f4310a;

    /* renamed from: b */
    private static final char[][] f4311b = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};

    /* renamed from: atakplugin.UASTool.byy$a */
    private abstract class C0285a {

        /* renamed from: a */
        protected final char[] f4312a;

        /* renamed from: b */
        protected int f4313b = 0;

        /* renamed from: c */
        private final byy f4314c;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract char[] mo4109a(int i, int i2);

        public C0285a(byy byy, char[] cArr) {
            this.f4314c = byy;
            this.f4312a = cArr;
            this.f4313b = cArr.length;
        }

        public C0285a(byy byy, int i) {
            this.f4314c = byy;
            this.f4312a = new char[i];
            this.f4313b = 0;
        }

        /* renamed from: a */
        public int mo4108a() {
            return this.f4313b;
        }

        public String toString() {
            return new String(mo4109a(0, this.f4313b));
        }
    }

    /* renamed from: atakplugin.UASTool.byy$c */
    private class C0287c extends C0285a {

        /* renamed from: c */
        private final byy f4316c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0287c(byy byy, int i) {
            super(byy, i);
            this.f4316c = byy;
        }

        /* renamed from: a */
        public void mo4115a(char c) {
            this.f4312a[this.f4313b] = c;
            this.f4313b++;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public char[] mo4109a(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.f4312a, i, cArr, 0, i2);
            return cArr;
        }
    }

    /* renamed from: atakplugin.UASTool.byy$b */
    private class C0286b extends C0285a {

        /* renamed from: c */
        private final byy f4315c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0286b(byy byy, char[] cArr) {
            super(byy, cArr);
            this.f4315c = byy;
        }

        /* renamed from: a */
        public void mo4111a(char c) {
            this.f4313b++;
            this.f4312a[mo4113c()] = c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public char[] mo4109a(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.f4312a, (this.f4312a.length - this.f4313b) + i, cArr, 0, i2);
            return cArr;
        }

        /* renamed from: b */
        public char mo4112b() {
            return this.f4312a[mo4113c()];
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int mo4113c() {
            return this.f4312a.length - this.f4313b;
        }

        /* renamed from: d */
        public char mo4114d() {
            this.f4313b--;
            return mo4112b();
        }
    }

    /* renamed from: a */
    private static boolean m10678a(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public String mo4106a(String str) {
        char c;
        if (str == null) {
            return null;
        }
        String d = m10680d(str);
        C0287c cVar = new C0287c(this, d.length() * 2);
        C0286b bVar = new C0286b(this, d.toCharArray());
        int a = bVar.mo4108a();
        char c2 = '/';
        char c3 = '-';
        while (a > 0) {
            char d2 = bVar.mo4114d();
            int a2 = bVar.mo4108a();
            char b = a2 > 0 ? bVar.mo4112b() : '-';
            if (m10678a(new char[]{'A', 'E', 'I', 'J', 'O', 'U', 'Y'}, d2)) {
                c = '0';
            } else if (d2 == 'H' || d2 < 'A' || d2 > 'Z') {
                if (c2 == '/') {
                    a = a2;
                } else {
                    c = '-';
                }
            } else if (d2 == 'B' || (d2 == 'P' && b != 'H')) {
                c = '1';
            } else if ((d2 == 'D' || d2 == 'T') && !m10678a(new char[]{'S', 'C', 'Z'}, b)) {
                c = '2';
            } else if (m10678a(new char[]{'W', 'F', 'P', 'V'}, d2)) {
                c = '3';
            } else {
                if (!m10678a(new char[]{'G', 'K', 'Q'}, d2)) {
                    if (d2 != 'X' || m10678a(new char[]{'C', 'K', 'Q'}, c3)) {
                        if (!(d2 == 'S' || d2 == 'Z')) {
                            if (d2 == 'C') {
                                if (c2 != '/') {
                                }
                            } else if (!m10678a(new char[]{'T', 'D', 'X'}, d2)) {
                                c = d2 == 'R' ? '7' : d2 == 'L' ? '5' : (d2 == 'M' || d2 == 'N') ? '6' : d2;
                            }
                        }
                        c = '8';
                    } else {
                        bVar.mo4111a('S');
                        a2++;
                    }
                }
                c = '4';
            }
            if (c != '-' && ((c2 != c && (c != '0' || c2 == '/')) || c < '0' || c > '8')) {
                cVar.mo4115a(c);
            }
            c3 = d2;
            a = a2;
            c2 = c;
        }
        return cVar.toString();
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof String) {
            return mo4075b((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("This method’s parameter was expected to be of the type ");
        Class cls = f4310a;
        if (cls == null) {
            cls = m10679c("java.lang.String");
            f4310a = cls;
        }
        stringBuffer.append(cls.getName());
        stringBuffer.append(". But actually it was of the type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(".");
        throw new byd(stringBuffer.toString());
    }

    /* renamed from: c */
    static Class m10679c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        return mo4106a(str);
    }

    /* renamed from: a */
    public boolean mo4107a(String str, String str2) {
        return mo4106a(str).equals(mo4106a(str2));
    }

    /* renamed from: d */
    private String m10680d(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 'Z') {
                int i2 = 0;
                while (true) {
                    char[][] cArr = f4311b;
                    if (i2 >= cArr.length) {
                        break;
                    } else if (charArray[i] == cArr[i2][0]) {
                        charArray[i] = cArr[i2][1];
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return new String(charArray);
    }
}
