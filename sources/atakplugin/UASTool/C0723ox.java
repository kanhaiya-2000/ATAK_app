package atakplugin.UASTool;

import java.util.List;

/* renamed from: atakplugin.UASTool.ox */
public class C0723ox extends C1003wo {

    /* renamed from: a */
    public static final String f5562a = "moov";

    public C0723ox() {
        super(f5562a);
    }

    /* renamed from: a */
    public int mo5245a() {
        return mo202a(C0754pv.class).size();
    }

    /* renamed from: b */
    public long[] mo5246b() {
        List<C0754pv> a = mo202a(C0754pv.class);
        long[] jArr = new long[a.size()];
        for (int i = 0; i < a.size(); i++) {
            jArr[i] = a.get(i).mo5377a().mo5394j();
        }
        return jArr;
    }

    /* renamed from: d */
    public C0724oy mo5247d() {
        for (C0688nt next : mo36c()) {
            if (next instanceof C0724oy) {
                return (C0724oy) next;
            }
        }
        return null;
    }
}
