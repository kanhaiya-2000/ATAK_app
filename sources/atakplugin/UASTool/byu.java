package atakplugin.UASTool;

public abstract class byu implements byf {
    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof String) {
            return mo4075b((String) obj);
        }
        throw new byd("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    /* renamed from: a */
    public boolean mo4103a(String str, String str2) {
        return mo4075b(str).equals(mo4075b(str2));
    }
}
