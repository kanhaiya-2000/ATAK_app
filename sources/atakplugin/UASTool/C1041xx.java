package atakplugin.UASTool;

import java.util.Arrays;

/* renamed from: atakplugin.UASTool.xx */
public class C1041xx implements C1037xt {

    /* renamed from: a */
    private int f7618a = 2;

    /* renamed from: b */
    private C1022xf f7619b;

    public C1041xx(C1022xf xfVar, int i) {
        this.f7619b = xfVar;
        this.f7618a = i;
    }

    /* renamed from: a */
    public long[] mo6257a(C1026xj xjVar) {
        long[] jArr = {1};
        long[] m = xjVar.mo12m();
        long[] b = xjVar.mo6140b();
        long b2 = xjVar.mo14o().mo6178b();
        double d = 0.0d;
        for (int i = 0; i < m.length; i++) {
            d += ((double) m[i]) / ((double) b2);
            if (d >= ((double) this.f7618a) && (b == null || Arrays.binarySearch(b, (long) (i + 1)) >= 0)) {
                if (i > 0) {
                    jArr = afs.m880a(jArr, (long) (i + 1));
                }
                d = 0.0d;
            }
        }
        return jArr;
    }
}
