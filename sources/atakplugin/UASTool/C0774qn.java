package atakplugin.UASTool;

import atakplugin.UASTool.C0735ph;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atakplugin.UASTool.qn */
public class C0774qn extends C1003wo {

    /* renamed from: a */
    public static final String f5874a = "moof";

    public C0774qn() {
        super(f5874a);
    }

    /* renamed from: a */
    public List<Long> mo5447a(C0735ph phVar) {
        ArrayList arrayList = new ArrayList();
        long j = 1;
        for (C0735ph.C0736a b : phVar.mo36c()) {
            if (b.mo5307b() == 2) {
                arrayList.add(Long.valueOf(j));
            }
            j++;
        }
        return arrayList;
    }

    /* renamed from: a */
    public int mo5446a() {
        return mo203a(C0782qv.class, false).size();
    }

    /* renamed from: b */
    public long[] mo5448b() {
        List<C0782qv> a = mo203a(C0782qv.class, false);
        long[] jArr = new long[a.size()];
        for (int i = 0; i < a.size(); i++) {
            jArr[i] = a.get(i).mo5492a().mo5504m();
        }
        return jArr;
    }

    /* renamed from: d */
    public List<C0783qw> mo5449d() {
        return mo203a(C0783qw.class, true);
    }

    /* renamed from: i */
    public List<C0786qy> mo5450i() {
        return mo203a(C0786qy.class, true);
    }

    /* renamed from: j */
    public C1007ws mo5451j() {
        return this.f7522t;
    }
}
