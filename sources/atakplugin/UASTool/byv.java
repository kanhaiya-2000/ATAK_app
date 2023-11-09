package atakplugin.UASTool;

public class byv implements byf {

    /* renamed from: a */
    private final byx f4307a = new byx();

    /* renamed from: a */
    public String mo4104a(String str) {
        return this.f4307a.mo4075b(str);
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof String) {
            return mo4104a((String) obj);
        }
        throw new byd("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    /* renamed from: b */
    public String mo4075b(String str) {
        return mo4104a(str);
    }

    /* renamed from: a */
    public boolean mo4105a(String str, String str2) {
        return mo4104a(str).equals(mo4104a(str2));
    }
}
