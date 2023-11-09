package atakplugin.UASTool;

public class bzx implements cbv {

    /* renamed from: a */
    private cbm<?> f4400a;

    /* renamed from: b */
    private ccl f4401b;

    /* renamed from: c */
    private cbm<?> f4402c;

    /* renamed from: d */
    private String f4403d;

    public bzx(cbm<?> cbm, String str, String str2) {
        this.f4400a = cbm;
        this.f4401b = new cae(str);
        try {
            this.f4402c = cbn.m11175a(Class.forName(str2, false, cbm.mo4228e().getClassLoader()));
        } catch (ClassNotFoundException unused) {
            this.f4403d = str2;
        }
    }

    /* renamed from: a */
    public cbm mo4279a() {
        return this.f4400a;
    }

    /* renamed from: b */
    public cbm mo4280b() {
        if (this.f4403d == null) {
            return this.f4402c;
        }
        throw new ClassNotFoundException(this.f4403d);
    }

    /* renamed from: c */
    public ccl mo4281c() {
        return this.f4401b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare soft : ");
        String str = this.f4403d;
        if (str != null) {
            stringBuffer.append(this.f4402c.mo4209a());
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append(" : ");
        stringBuffer.append(mo4281c().mo4306a());
        return stringBuffer.toString();
    }
}
