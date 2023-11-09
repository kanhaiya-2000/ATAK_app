package atakplugin.UASTool;

import java.util.HashMap;
import java.util.Map;

/* renamed from: atakplugin.UASTool.yq */
class C1064yq extends HashMap<adx, long[]> {

    /* renamed from: a */
    final /* synthetic */ C1063yp f7730a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1064yq(C1063yp ypVar, Map map) {
        super(map);
        this.f7730a = ypVar;
    }

    /* renamed from: a */
    public long[] put(adx adx, long[] jArr) {
        if (!(adx instanceof adw)) {
            return (long[]) super.put(adx, jArr);
        }
        throw new RuntimeException("Please supply CencSampleEncryptionInformationGroupEntries in the constructor");
    }
}
