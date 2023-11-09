package atakplugin.UASTool;

import java.nio.ByteBuffer;

public class afr {

    /* renamed from: j */
    public static final afr f870j = new afr(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: k */
    public static final afr f871k = new afr(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: l */
    public static final afr f872l = new afr(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: m */
    public static final afr f873m = new afr(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a */
    double f874a;

    /* renamed from: b */
    double f875b;

    /* renamed from: c */
    double f876c;

    /* renamed from: d */
    double f877d;

    /* renamed from: e */
    double f878e;

    /* renamed from: f */
    double f879f;

    /* renamed from: g */
    double f880g;

    /* renamed from: h */
    double f881h;

    /* renamed from: i */
    double f882i;

    public afr(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f874a = d5;
        this.f875b = d6;
        this.f876c = d7;
        this.f877d = d;
        this.f878e = d2;
        this.f879f = d3;
        this.f880g = d4;
        this.f881h = d8;
        this.f882i = d9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        afr afr = (afr) obj;
        return Double.compare(afr.f877d, this.f877d) == 0 && Double.compare(afr.f878e, this.f878e) == 0 && Double.compare(afr.f879f, this.f879f) == 0 && Double.compare(afr.f880g, this.f880g) == 0 && Double.compare(afr.f881h, this.f881h) == 0 && Double.compare(afr.f882i, this.f882i) == 0 && Double.compare(afr.f874a, this.f874a) == 0 && Double.compare(afr.f875b, this.f875b) == 0 && Double.compare(afr.f876c, this.f876c) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f874a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f875b);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f876c);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f877d);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f878e);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f879f);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f880g);
        long doubleToLongBits8 = Double.doubleToLongBits(this.f881h);
        long doubleToLongBits9 = Double.doubleToLongBits(this.f882i);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public String toString() {
        if (equals(f870j)) {
            return "Rotate 0°";
        }
        if (equals(f871k)) {
            return "Rotate 90°";
        }
        if (equals(f872l)) {
            return "Rotate 180°";
        }
        if (equals(f873m)) {
            return "Rotate 270°";
        }
        return "Matrix{u=" + this.f874a + ", v=" + this.f875b + ", w=" + this.f876c + ", a=" + this.f877d + ", b=" + this.f878e + ", c=" + this.f879f + ", d=" + this.f880g + ", tx=" + this.f881h + ", ty=" + this.f882i + '}';
    }

    /* renamed from: a */
    public static afr m876a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return new afr(d, d2, d4, d5, d3, d6, d9, d7, d8);
    }

    /* renamed from: a */
    public static afr m877a(ByteBuffer byteBuffer) {
        return m876a(C0679nk.m12502i(byteBuffer), C0679nk.m12502i(byteBuffer), C0679nk.m12503j(byteBuffer), C0679nk.m12502i(byteBuffer), C0679nk.m12502i(byteBuffer), C0679nk.m12503j(byteBuffer), C0679nk.m12502i(byteBuffer), C0679nk.m12502i(byteBuffer), C0679nk.m12503j(byteBuffer));
    }

    /* renamed from: b */
    public void mo598b(ByteBuffer byteBuffer) {
        C0681nm.m12509a(byteBuffer, this.f877d);
        C0681nm.m12509a(byteBuffer, this.f878e);
        C0681nm.m12513b(byteBuffer, this.f874a);
        C0681nm.m12509a(byteBuffer, this.f879f);
        C0681nm.m12509a(byteBuffer, this.f880g);
        C0681nm.m12513b(byteBuffer, this.f875b);
        C0681nm.m12509a(byteBuffer, this.f881h);
        C0681nm.m12509a(byteBuffer, this.f882i);
        C0681nm.m12513b(byteBuffer, this.f876c);
    }
}
