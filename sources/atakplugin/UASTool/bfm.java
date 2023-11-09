package atakplugin.UASTool;

public class bfm extends bfl {

    /* renamed from: a */
    private final bjk f2619a;

    /* renamed from: b */
    private final String f2620b;

    /* renamed from: c */
    private final String f2621c;

    public bfm(int i, bjk bjk, String str, String str2) {
        super(i);
        this.f2619a = bjk;
        this.f2620b = str;
        this.f2621c = str2;
    }

    public bjk getOwner() {
        return this.f2619a;
    }

    public String getName() {
        return this.f2620b;
    }

    public String getSignature() {
        return this.f2621c;
    }
}
