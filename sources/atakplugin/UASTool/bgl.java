package atakplugin.UASTool;

public class bgl extends bgk {

    /* renamed from: a */
    private final bjk f2655a;

    /* renamed from: b */
    private final String f2656b;

    /* renamed from: c */
    private final String f2657c;

    public bgl(bjk bjk, String str, String str2) {
        this.f2655a = bjk;
        this.f2656b = str;
        this.f2657c = str2;
    }

    public bjk getOwner() {
        return this.f2655a;
    }

    public String getName() {
        return this.f2656b;
    }

    public String getSignature() {
        return this.f2657c;
    }

    /* renamed from: b */
    public Object mo2458b(Object obj) {
        return mo2406f().call(obj);
    }
}
