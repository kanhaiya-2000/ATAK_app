package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.je */
public class C0564je extends C0560jd.C0561a {

    /* renamed from: a */
    private final double[] f5056a;

    /* renamed from: b */
    private int f5057b = 0;

    public C0564je(double[] dArr) {
        this.f5056a = dArr;
    }

    /* renamed from: a */
    public double mo2515a() {
        double[] dArr = this.f5056a;
        int i = this.f5057b;
        this.f5057b = i + 1;
        return dArr[i];
    }

    public boolean hasNext() {
        return this.f5057b < this.f5056a.length;
    }
}
