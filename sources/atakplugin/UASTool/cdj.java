package atakplugin.UASTool;

import atakplugin.UASTool.can;
import atakplugin.UASTool.cdm;
import java.util.Hashtable;
import java.util.StringTokenizer;

public final class cdj {

    /* renamed from: e */
    static Hashtable f4529e;

    /* renamed from: f */
    static Class f4530f;

    /* renamed from: g */
    private static Object[] f4531g = new Object[0];

    /* renamed from: a */
    Class f4532a;

    /* renamed from: b */
    ClassLoader f4533b;

    /* renamed from: c */
    String f4534c;

    /* renamed from: d */
    int f4535d = 0;

    static {
        Hashtable hashtable = new Hashtable();
        f4529e = hashtable;
        hashtable.put("void", Void.TYPE);
        f4529e.put("boolean", Boolean.TYPE);
        f4529e.put("byte", Byte.TYPE);
        f4529e.put("char", Character.TYPE);
        f4529e.put("short", Short.TYPE);
        f4529e.put("int", Integer.TYPE);
        f4529e.put("long", Long.TYPE);
        f4529e.put("float", Float.TYPE);
        f4529e.put("double", Double.TYPE);
    }

    /* renamed from: a */
    static Class m11380a(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class cls = (Class) f4529e.get(str);
        if (cls != null) {
            return cls;
        }
        if (classLoader != null) {
            return Class.forName(str, false, classLoader);
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            Class cls2 = f4530f;
            if (cls2 != null) {
                return cls2;
            }
            Class i = m11381i("java.lang.ClassNotFoundException");
            f4530f = i;
            return i;
        }
    }

    /* renamed from: i */
    static Class m11381i(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public cdj(String str, Class cls) {
        this.f4534c = str;
        this.f4532a = cls;
        this.f4533b = cls.getClassLoader();
    }

    /* renamed from: a */
    public can.C0296b mo4510a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        cce a = mo4523a(str2, str3, str4, str5, str6, str7, str8);
        int i2 = this.f4535d;
        this.f4535d = i2 + 1;
        String str9 = str;
        return new cdm.C0307b(i2, str, a, mo4524a(i, -1));
    }

    /* renamed from: a */
    public can.C0296b mo4509a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        cce a = mo4523a(str2, str3, str4, str5, str6, "", str7);
        int i2 = this.f4535d;
        this.f4535d = i2 + 1;
        String str8 = str;
        return new cdm.C0307b(i2, str, a, mo4524a(i, -1));
    }

    /* renamed from: a */
    public can.C0296b mo4508a(String str, caq caq, ccn ccn) {
        int i = this.f4535d;
        this.f4535d = i + 1;
        return new cdm.C0307b(i, str, caq, ccn);
    }

    /* renamed from: a */
    public can.C0296b mo4507a(String str, caq caq, int i, int i2) {
        int i3 = this.f4535d;
        this.f4535d = i3 + 1;
        return new cdm.C0307b(i3, str, caq, mo4524a(i, i2));
    }

    /* renamed from: a */
    public can.C0296b mo4506a(String str, caq caq, int i) {
        int i2 = this.f4535d;
        this.f4535d = i2 + 1;
        return new cdm.C0307b(i2, str, caq, mo4524a(i, -1));
    }

    /* renamed from: b */
    public can.C0295a mo4527b(String str, caq caq, ccn ccn) {
        int i = this.f4535d;
        this.f4535d = i + 1;
        return new cdm.C0306a(i, str, caq, ccn);
    }

    /* renamed from: b */
    public can.C0295a mo4526b(String str, caq caq, int i, int i2) {
        int i3 = this.f4535d;
        this.f4535d = i3 + 1;
        return new cdm.C0306a(i3, str, caq, mo4524a(i, i2));
    }

    /* renamed from: b */
    public can.C0295a mo4525b(String str, caq caq, int i) {
        int i2 = this.f4535d;
        this.f4535d = i2 + 1;
        return new cdm.C0306a(i2, str, caq, mo4524a(i, -1));
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [atakplugin.UASTool.caq] */
    /* JADX WARNING: type inference failed for: r0v10, types: [atakplugin.UASTool.cdi] */
    /* JADX WARNING: type inference failed for: r0v11, types: [atakplugin.UASTool.cdp] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static atakplugin.UASTool.can.C0296b m11375a(java.lang.reflect.Member r9) {
        /*
            boolean r0 = r9 instanceof java.lang.reflect.Method
            if (r0 == 0) goto L_0x002e
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            atakplugin.UASTool.cdp r8 = new atakplugin.UASTool.cdp
            int r1 = r9.getModifiers()
            java.lang.String r2 = r9.getName()
            java.lang.Class r3 = r9.getDeclaringClass()
            java.lang.Class[] r4 = r9.getParameterTypes()
            java.lang.Class[] r0 = r9.getParameterTypes()
            int r0 = r0.length
            java.lang.String[] r5 = new java.lang.String[r0]
            java.lang.Class[] r6 = r9.getExceptionTypes()
            java.lang.Class r7 = r9.getReturnType()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            java.lang.String r9 = "method-execution"
            goto L_0x0053
        L_0x002e:
            boolean r0 = r9 instanceof java.lang.reflect.Constructor
            if (r0 == 0) goto L_0x005b
            java.lang.reflect.Constructor r9 = (java.lang.reflect.Constructor) r9
            atakplugin.UASTool.cdi r8 = new atakplugin.UASTool.cdi
            int r1 = r9.getModifiers()
            java.lang.Class r2 = r9.getDeclaringClass()
            java.lang.Class[] r3 = r9.getParameterTypes()
            java.lang.Class[] r0 = r9.getParameterTypes()
            int r0 = r0.length
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.Class[] r5 = r9.getExceptionTypes()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.String r9 = "constructor-execution"
        L_0x0053:
            atakplugin.UASTool.cdm$a r0 = new atakplugin.UASTool.cdm$a
            r1 = -1
            r2 = 0
            r0.<init>(r1, r9, r8, r2)
            return r0
        L_0x005b:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "member must be either a method or constructor"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.cdj.m11375a(java.lang.reflect.Member):atakplugin.UASTool.can$b");
    }

    /* renamed from: a */
    public static can m11376a(can.C0296b bVar, Object obj, Object obj2) {
        return new cdm(bVar, obj, obj2, f4531g);
    }

    /* renamed from: a */
    public static can m11377a(can.C0296b bVar, Object obj, Object obj2, Object obj3) {
        return new cdm(bVar, obj, obj2, new Object[]{obj3});
    }

    /* renamed from: a */
    public static can m11378a(can.C0296b bVar, Object obj, Object obj2, Object obj3, Object obj4) {
        return new cdm(bVar, obj, obj2, new Object[]{obj3, obj4});
    }

    /* renamed from: a */
    public static can m11379a(can.C0296b bVar, Object obj, Object obj2, Object[] objArr) {
        return new cdm(bVar, obj, obj2, objArr);
    }

    /* renamed from: a */
    public cce mo4522a(String str) {
        cdp cdp = new cdp(str);
        cdp.mo4543a(this.f4533b);
        return cdp;
    }

    /* renamed from: a */
    public cce mo4523a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str;
        int parseInt = Integer.parseInt(str, 16);
        String str9 = str3;
        Class a = m11380a(str3, this.f4533b);
        String str10 = str4;
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = m11380a(stringTokenizer.nextToken(), this.f4533b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = m11380a(stringTokenizer3.nextToken(), this.f4533b);
        }
        return new cdp(parseInt, str2, a, clsArr, strArr, clsArr2, m11380a(str7, this.f4533b));
    }

    /* renamed from: a */
    public cce mo4521a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        cdp cdp = new cdp(i, str, cls, clsArr, strArr, clsArr2, cls2);
        cdp.mo4543a(this.f4533b);
        return cdp;
    }

    /* renamed from: b */
    public cbq mo4530b(String str) {
        cdi cdi = new cdi(str);
        cdi.mo4543a(this.f4533b);
        return cdi;
    }

    /* renamed from: a */
    public cbq mo4514a(String str, String str2, String str3, String str4, String str5) {
        int parseInt = Integer.parseInt(str, 16);
        Class a = m11380a(str2, this.f4533b);
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = m11380a(stringTokenizer.nextToken(), this.f4533b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = m11380a(stringTokenizer3.nextToken(), this.f4533b);
        }
        cdi cdi = new cdi(parseInt, a, clsArr, strArr, clsArr2);
        cdi.mo4543a(this.f4533b);
        return cdi;
    }

    /* renamed from: a */
    public cbq mo4513a(int i, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        cdi cdi = new cdi(i, cls, clsArr, strArr, clsArr2);
        cdi.mo4543a(this.f4533b);
        return cdi;
    }

    /* renamed from: c */
    public cbw mo4533c(String str) {
        cdk cdk = new cdk(str);
        cdk.mo4543a(this.f4533b);
        return cdk;
    }

    /* renamed from: a */
    public cbw mo4516a(String str, String str2, String str3, String str4) {
        cdk cdk = new cdk(Integer.parseInt(str, 16), str2, m11380a(str3, this.f4533b), m11380a(str4, this.f4533b));
        cdk.mo4543a(this.f4533b);
        return cdk;
    }

    /* renamed from: a */
    public cbw mo4515a(int i, String str, Class cls, Class cls2) {
        cdk cdk = new cdk(i, str, cls, cls2);
        cdk.mo4543a(this.f4533b);
        return cdk;
    }

    /* renamed from: d */
    public cbl mo4534d(String str) {
        cdf cdf = new cdf(str);
        cdf.mo4543a(this.f4533b);
        return cdf;
    }

    /* renamed from: b */
    public cbl mo4529b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str;
        int parseInt = Integer.parseInt(str, 16);
        String str9 = str3;
        Class a = m11380a(str3, this.f4533b);
        String str10 = str4;
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = m11380a(stringTokenizer.nextToken(), this.f4533b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = m11380a(stringTokenizer3.nextToken(), this.f4533b);
        }
        cdf cdf = new cdf(parseInt, str2, a, clsArr, strArr, clsArr2, m11380a(str7, this.f4533b));
        cdf.mo4543a(this.f4533b);
        return cdf;
    }

    /* renamed from: b */
    public cbl mo4528b(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        cdf cdf = new cdf(i, str, cls, clsArr, strArr, clsArr2, cls2);
        cdf.mo4543a(this.f4533b);
        return cdf;
    }

    /* renamed from: e */
    public cbx mo4535e(String str) {
        cdl cdl = new cdl(str);
        cdl.mo4543a(this.f4533b);
        return cdl;
    }

    /* renamed from: a */
    public cbx mo4518a(String str, String str2) {
        cdl cdl = new cdl(Integer.parseInt(str, 16), m11380a(str2, this.f4533b));
        cdl.mo4543a(this.f4533b);
        return cdl;
    }

    /* renamed from: a */
    public cbx mo4517a(int i, Class cls) {
        cdl cdl = new cdl(i, cls);
        cdl.mo4543a(this.f4533b);
        return cdl;
    }

    /* renamed from: f */
    public cbo mo4536f(String str) {
        cdg cdg = new cdg(str);
        cdg.mo4543a(this.f4533b);
        return cdg;
    }

    /* renamed from: a */
    public cbo mo4512a(String str, String str2, String str3) {
        cdg cdg = new cdg(m11380a(str, this.f4533b), m11380a(new StringTokenizer(str2, ":").nextToken(), this.f4533b), new StringTokenizer(str3, ":").nextToken());
        cdg.mo4543a(this.f4533b);
        return cdg;
    }

    /* renamed from: a */
    public cbo mo4511a(Class cls, Class cls2, String str) {
        cdg cdg = new cdg(cls, cls2, str);
        cdg.mo4543a(this.f4533b);
        return cdg;
    }

    /* renamed from: g */
    public ccc mo4537g(String str) {
        cdn cdn = new cdn(str);
        cdn.mo4543a(this.f4533b);
        return cdn;
    }

    /* renamed from: a */
    public ccc mo4519a() {
        cdn cdn = new cdn(m11380a("Ljava/lang/Object;", this.f4533b));
        cdn.mo4543a(this.f4533b);
        return cdn;
    }

    /* renamed from: a */
    public ccc mo4520a(Class cls) {
        cdn cdn = new cdn(cls);
        cdn.mo4543a(this.f4533b);
        return cdn;
    }

    /* renamed from: h */
    public ccq mo4538h(String str) {
        cdt cdt = new cdt(str);
        cdt.mo4543a(this.f4533b);
        return cdt;
    }

    /* renamed from: b */
    public ccq mo4531b() {
        cdt cdt = new cdt(m11380a("Ljava/lang/Object;", this.f4533b));
        cdt.mo4543a(this.f4533b);
        return cdt;
    }

    /* renamed from: b */
    public ccq mo4532b(Class cls) {
        cdt cdt = new cdt(cls);
        cdt.mo4543a(this.f4533b);
        return cdt;
    }

    /* renamed from: a */
    public ccn mo4524a(int i, int i2) {
        return new cdr(this.f4532a, this.f4534c, i);
    }
}
