package atakplugin.UASTool;

public class bga extends bfz {

    /* renamed from: a */
    private final bjk f2638a;

    /* renamed from: b */
    private final String f2639b;

    /* renamed from: c */
    private final String f2640c;

    public bga(bjk bjk, String str, String str2) {
        this.f2638a = bjk;
        this.f2639b = str;
        this.f2640c = str2;
    }

    public bjk getOwner() {
        return this.f2638a;
    }

    public String getName() {
        return this.f2639b;
    }

    public String getSignature() {
        return this.f2640c;
    }

    /* renamed from: a */
    public Object mo2398a() {
        return mo2406f().call(new Object[0]);
    }

    /* renamed from: a */
    public void mo2401a(Object obj) {
        mo2405e().call(obj);
    }
}
