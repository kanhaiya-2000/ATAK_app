package atakplugin.UASTool;

import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class caf implements ccj {

    /* renamed from: a */
    private final String f4424a;

    /* renamed from: b */
    private final ccl f4425b;

    /* renamed from: c */
    private final Method f4426c;

    /* renamed from: d */
    private final cbm f4427d;

    /* renamed from: e */
    private String[] f4428e = new String[0];

    protected caf(String str, String str2, Method method, cbm cbm, String str3) {
        this.f4424a = str;
        this.f4425b = new cae(str2);
        this.f4426c = method;
        this.f4427d = cbm;
        this.f4428e = m10982a(str3);
    }

    /* renamed from: a */
    public ccl mo4308a() {
        return this.f4425b;
    }

    /* renamed from: b */
    public String mo4309b() {
        return this.f4424a;
    }

    /* renamed from: c */
    public int mo4310c() {
        return this.f4426c.getModifiers();
    }

    /* renamed from: d */
    public cbm<?>[] mo4311d() {
        Class[] parameterTypes = this.f4426c.getParameterTypes();
        int length = parameterTypes.length;
        cbm<?>[] cbmArr = new cbm[length];
        for (int i = 0; i < length; i++) {
            cbmArr[i] = cbn.m11175a(parameterTypes[i]);
        }
        return cbmArr;
    }

    /* renamed from: e */
    public cbm mo4312e() {
        return this.f4427d;
    }

    /* renamed from: f */
    public String[] mo4313f() {
        return this.f4428e;
    }

    /* renamed from: a */
    private String[] m10982a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int countTokens = stringTokenizer.countTokens();
        String[] strArr = new String[countTokens];
        for (int i = 0; i < countTokens; i++) {
            strArr[i] = stringTokenizer.nextToken().trim();
        }
        return strArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo4309b());
        stringBuffer.append("(");
        cbm[] d = mo4311d();
        int i = 0;
        while (i < d.length) {
            stringBuffer.append(d[i].mo4209a());
            String[] strArr = this.f4428e;
            if (!(strArr == null || strArr[i] == null)) {
                stringBuffer.append(" ");
                stringBuffer.append(this.f4428e[i]);
            }
            i++;
            if (i < d.length) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(") : ");
        stringBuffer.append(mo4308a().mo4306a());
        return stringBuffer.toString();
    }
}
