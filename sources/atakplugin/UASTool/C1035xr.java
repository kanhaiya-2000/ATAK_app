package atakplugin.UASTool;

import java.util.Comparator;
import java.util.Map;

/* renamed from: atakplugin.UASTool.xr */
class C1035xr implements Comparator<C1026xj> {

    /* renamed from: a */
    final /* synthetic */ C1034xq f7604a;

    /* renamed from: b */
    private final /* synthetic */ Map f7605b;

    /* renamed from: c */
    private final /* synthetic */ int f7606c;

    C1035xr(C1034xq xqVar, Map map, int i) {
        this.f7604a = xqVar;
        this.f7605b = map;
        this.f7606c = i;
    }

    /* renamed from: a */
    public int compare(C1026xj xjVar, C1026xj xjVar2) {
        long j = ((long[]) this.f7605b.get(xjVar))[this.f7606c];
        long j2 = ((long[]) this.f7605b.get(xjVar2))[this.f7606c];
        long[] m = xjVar.mo12m();
        long[] m2 = xjVar2.mo12m();
        long j3 = 0;
        for (int i = 1; ((long) i) < j; i++) {
            j3 += m[i - 1];
        }
        long j4 = 0;
        for (int i2 = 1; ((long) i2) < j2; i2++) {
            j4 += m2[i2 - 1];
        }
        return (int) (((((double) j3) / ((double) xjVar.mo14o().mo6178b())) - (((double) j4) / ((double) xjVar2.mo14o().mo6178b()))) * 100.0d);
    }
}
