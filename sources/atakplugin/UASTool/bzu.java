package atakplugin.UASTool;

public class bzu implements cbs {

    /* renamed from: a */
    private ccl f4386a;

    /* renamed from: b */
    private String f4387b;

    /* renamed from: c */
    private boolean f4388c;

    /* renamed from: d */
    private cbm f4389d;

    public bzu(String str, String str2, boolean z, cbm cbm) {
        this.f4386a = new cae(str);
        this.f4387b = str2;
        this.f4388c = z;
        this.f4389d = cbm;
    }

    /* renamed from: a */
    public cbm mo4265a() {
        return this.f4389d;
    }

    /* renamed from: b */
    public ccl mo4266b() {
        return this.f4386a;
    }

    /* renamed from: c */
    public String mo4267c() {
        return this.f4387b;
    }

    /* renamed from: d */
    public boolean mo4268d() {
        return this.f4388c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare ");
        stringBuffer.append(mo4268d() ? "error : " : "warning : ");
        stringBuffer.append(mo4266b().mo4306a());
        stringBuffer.append(" : ");
        stringBuffer.append("\"");
        stringBuffer.append(mo4267c());
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
