package atakplugin.UASTool;

public class bgc extends bgb {

    /* renamed from: a */
    private final bjk f2641a;

    /* renamed from: b */
    private final String f2642b;

    /* renamed from: c */
    private final String f2643c;

    public bgc(bjk bjk, String str, String str2) {
        this.f2641a = bjk;
        this.f2642b = str;
        this.f2643c = str2;
    }

    public bjk getOwner() {
        return this.f2641a;
    }

    public String getName() {
        return this.f2642b;
    }

    public String getSignature() {
        return this.f2643c;
    }

    /* renamed from: b */
    public Object mo2458b(Object obj) {
        return mo2406f().call(obj);
    }

    /* renamed from: a */
    public void mo2457a(Object obj, Object obj2) {
        mo2405e().call(obj, obj2);
    }
}
