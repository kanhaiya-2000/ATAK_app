package atakplugin.UASTool;

public class aeu {

    /* renamed from: a */
    public static aeu f720a = new aeu(0, 0, 0);

    /* renamed from: b */
    public static aeu f721b = new aeu(1, 2, 2);

    /* renamed from: c */
    public static aeu f722c = new aeu(2, 2, 1);

    /* renamed from: d */
    public static aeu f723d = new aeu(3, 1, 1);

    /* renamed from: e */
    private int f724e;

    /* renamed from: f */
    private int f725f;

    /* renamed from: g */
    private int f726g;

    public aeu(int i, int i2, int i3) {
        this.f724e = i;
        this.f725f = i2;
        this.f726g = i3;
    }

    /* renamed from: a */
    public static aeu m782a(int i) {
        aeu aeu = f720a;
        if (i == aeu.f724e) {
            return aeu;
        }
        aeu aeu2 = f721b;
        if (i == aeu2.f724e) {
            return aeu2;
        }
        aeu aeu3 = f722c;
        if (i == aeu3.f724e) {
            return aeu3;
        }
        aeu aeu4 = f723d;
        if (i == aeu4.f724e) {
            return aeu4;
        }
        return null;
    }

    /* renamed from: a */
    public int mo521a() {
        return this.f724e;
    }

    /* renamed from: b */
    public int mo522b() {
        return this.f725f;
    }

    /* renamed from: c */
    public int mo523c() {
        return this.f726g;
    }

    public String toString() {
        return "ChromaFormat{\nid=" + this.f724e + ",\n" + " subWidth=" + this.f725f + ",\n" + " subHeight=" + this.f726g + '}';
    }
}
