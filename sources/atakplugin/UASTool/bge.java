package atakplugin.UASTool;

public class bge extends bgd {

    /* renamed from: a */
    private final bjk f2644a;

    /* renamed from: b */
    private final String f2645b;

    /* renamed from: c */
    private final String f2646c;

    public bge(bjk bjk, String str, String str2) {
        this.f2644a = bjk;
        this.f2645b = str;
        this.f2646c = str2;
    }

    public bjk getOwner() {
        return this.f2644a;
    }

    public String getName() {
        return this.f2645b;
    }

    public String getSignature() {
        return this.f2646c;
    }

    /* renamed from: c */
    public Object mo2463c(Object obj, Object obj2) {
        return mo2406f().call(obj, obj2);
    }

    /* renamed from: a */
    public void mo2462a(Object obj, Object obj2, Object obj3) {
        mo2405e().call(obj, obj2, obj3);
    }
}
