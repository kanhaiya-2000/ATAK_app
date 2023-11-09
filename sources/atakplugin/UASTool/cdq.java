package atakplugin.UASTool;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;

abstract class cdq implements caq {

    /* renamed from: a */
    private static boolean f4551a = true;

    /* renamed from: k */
    static final char f4552k = '-';

    /* renamed from: l */
    static String[] f4553l = new String[0];

    /* renamed from: m */
    static Class[] f4554m = new Class[0];

    /* renamed from: n */
    static final String f4555n = ":";

    /* renamed from: b */
    private String f4556b;

    /* renamed from: e */
    int f4557e = -1;

    /* renamed from: f */
    String f4558f;

    /* renamed from: g */
    String f4559g;

    /* renamed from: h */
    Class f4560h;

    /* renamed from: i */
    C0308a f4561i;

    /* renamed from: j */
    ClassLoader f4562j = null;

    /* renamed from: atakplugin.UASTool.cdq$a */
    private interface C0308a {
        /* renamed from: a */
        String mo4553a(int i);

        /* renamed from: a */
        void mo4554a(int i, String str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo4505a(cds cds);

    cdq(int i, String str, Class cls) {
        this.f4557e = i;
        this.f4558f = str;
        this.f4560h = cls;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo4546b(atakplugin.UASTool.cds r3) {
        /*
            r2 = this;
            boolean r0 = f4551a
            if (r0 == 0) goto L_0x001b
            atakplugin.UASTool.cdq$a r0 = r2.f4561i
            if (r0 != 0) goto L_0x0014
            atakplugin.UASTool.cdq$b r0 = new atakplugin.UASTool.cdq$b     // Catch:{ all -> 0x0010 }
            r0.<init>()     // Catch:{ all -> 0x0010 }
            r2.f4561i = r0     // Catch:{ all -> 0x0010 }
            goto L_0x001b
        L_0x0010:
            r0 = 0
            f4551a = r0
            goto L_0x001b
        L_0x0014:
            int r1 = r3.f4578i
            java.lang.String r0 = r0.mo4553a(r1)
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = r2.mo4505a((atakplugin.UASTool.cds) r3)
        L_0x0022:
            boolean r1 = f4551a
            if (r1 == 0) goto L_0x002d
            atakplugin.UASTool.cdq$a r1 = r2.f4561i
            int r3 = r3.f4578i
            r1.mo4554a(r3, r0)
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.cdq.mo4546b(atakplugin.UASTool.cds):java.lang.String");
    }

    public final String toString() {
        return mo4546b(cds.f4568k);
    }

    /* renamed from: a */
    public final String mo4344a() {
        return mo4546b(cds.f4567j);
    }

    /* renamed from: b */
    public final String mo4345b() {
        return mo4546b(cds.f4569l);
    }

    /* renamed from: d */
    public int mo4347d() {
        if (this.f4557e == -1) {
            this.f4557e = mo4545b(0);
        }
        return this.f4557e;
    }

    /* renamed from: c */
    public String mo4346c() {
        if (this.f4558f == null) {
            this.f4558f = mo4540a(1);
        }
        return this.f4558f;
    }

    /* renamed from: e */
    public Class mo4348e() {
        if (this.f4560h == null) {
            this.f4560h = mo4549c(2);
        }
        return this.f4560h;
    }

    /* renamed from: f */
    public String mo4349f() {
        if (this.f4559g == null) {
            this.f4559g = mo4348e().getName();
        }
        return this.f4559g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4541a(Class cls) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            return cls.getName().replace(bpg.f3094b, '.');
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo4541a((Class) cls.getComponentType()));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4542a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo4547b(Class cls) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            return mo4542a(cls.getName()).replace(bpg.f3094b, '.');
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo4547b((Class) cls.getComponentType()));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4544a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(mo4541a(clsArr[i]));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4548b(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(mo4547b(clsArr[i]));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4550c(StringBuffer stringBuffer, Class[] clsArr) {
        mo4544a(stringBuffer, clsArr);
    }

    /* renamed from: a */
    public void mo4543a(ClassLoader classLoader) {
        this.f4562j = classLoader;
    }

    /* renamed from: g */
    private ClassLoader mo4410g() {
        if (this.f4562j == null) {
            this.f4562j = getClass().getClassLoader();
        }
        return this.f4562j;
    }

    public cdq(String str) {
        this.f4556b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4540a(int i) {
        int indexOf = this.f4556b.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.f4556b.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.f4556b.length();
        }
        return this.f4556b.substring(i2, indexOf);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo4545b(int i) {
        return Integer.parseInt(mo4540a(i), 16);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Class mo4549c(int i) {
        return cdj.m11380a(mo4540a(i), mo4410g());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String[] mo4551d(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(mo4540a(i), f4555n);
        int countTokens = stringTokenizer.countTokens();
        String[] strArr = new String[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            strArr[i2] = stringTokenizer.nextToken();
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Class[] mo4552e(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(mo4540a(i), f4555n);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = cdj.m11380a(stringTokenizer.nextToken(), mo4410g());
        }
        return clsArr;
    }

    /* renamed from: a */
    static void m11446a(boolean z) {
        f4551a = z;
    }

    /* renamed from: l */
    static boolean m11448l() {
        return f4551a;
    }

    /* renamed from: atakplugin.UASTool.cdq$b */
    private static final class C0309b implements C0308a {

        /* renamed from: a */
        private SoftReference f4563a;

        public C0309b() {
            m11472b();
        }

        /* renamed from: a */
        public String mo4553a(int i) {
            String[] a = m11471a();
            if (a == null) {
                return null;
            }
            return a[i];
        }

        /* renamed from: a */
        public void mo4554a(int i, String str) {
            String[] a = m11471a();
            if (a == null) {
                a = m11472b();
            }
            a[i] = str;
        }

        /* renamed from: a */
        private String[] m11471a() {
            return (String[]) this.f4563a.get();
        }

        /* renamed from: b */
        private String[] m11472b() {
            String[] strArr = new String[3];
            this.f4563a = new SoftReference(strArr);
            return strArr;
        }
    }
}
