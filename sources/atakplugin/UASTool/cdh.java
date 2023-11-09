package atakplugin.UASTool;

abstract class cdh extends cdo implements cbp {

    /* renamed from: b */
    Class[] f4525b;

    /* renamed from: c */
    String[] f4526c;

    /* renamed from: d */
    Class[] f4527d;

    cdh(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.f4525b = clsArr;
        this.f4526c = strArr;
        this.f4527d = clsArr2;
    }

    cdh(String str) {
        super(str);
    }

    /* renamed from: i */
    public Class[] mo4414i() {
        if (this.f4525b == null) {
            this.f4525b = mo4552e(3);
        }
        return this.f4525b;
    }

    /* renamed from: j */
    public String[] mo4415j() {
        if (this.f4526c == null) {
            this.f4526c = mo4551d(4);
        }
        return this.f4526c;
    }

    /* renamed from: k */
    public Class[] mo4416k() {
        if (this.f4527d == null) {
            this.f4527d = mo4552e(5);
        }
        return this.f4527d;
    }
}
