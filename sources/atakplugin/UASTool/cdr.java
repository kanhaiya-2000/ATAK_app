package atakplugin.UASTool;

class cdr implements ccn {

    /* renamed from: a */
    Class f4564a;

    /* renamed from: b */
    String f4565b;

    /* renamed from: c */
    int f4566c;

    /* renamed from: d */
    public int mo4448d() {
        return -1;
    }

    cdr(Class cls, String str, int i) {
        this.f4564a = cls;
        this.f4565b = str;
        this.f4566c = i;
    }

    /* renamed from: a */
    public Class mo4445a() {
        return this.f4564a;
    }

    /* renamed from: b */
    public String mo4446b() {
        return this.f4565b;
    }

    /* renamed from: c */
    public int mo4447c() {
        return this.f4566c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo4446b());
        stringBuffer.append(":");
        stringBuffer.append(mo4447c());
        return stringBuffer.toString();
    }
}
