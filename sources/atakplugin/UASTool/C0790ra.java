package atakplugin.UASTool;

import java.util.AbstractList;
import java.util.List;

/* renamed from: atakplugin.UASTool.ra */
public class C0790ra extends AbstractList<C1024xh> {

    /* renamed from: a */
    List<C1024xh> f6017a;

    public C0790ra(C0754pv pvVar, C0678nj... njVarArr) {
        C0695nz e = ((C0688nt) pvVar.mo1474e()).mo1474e();
        if (!pvVar.mo1474e().mo202a(C0772ql.class).isEmpty()) {
            this.f6017a = new C1046yb(pvVar.mo5377a().mo5394j(), e, njVarArr);
        } else if (njVarArr.length <= 0) {
            this.f6017a = new C1043xz(pvVar.mo5377a().mo5394j(), e);
        } else {
            throw new RuntimeException("The TrackBox comes from a standard MP4 file. Only use the additionalFragments param if you are dealing with ( fragmented MP4 files AND additional fragments in standalone files )");
        }
    }

    /* renamed from: a */
    public C1024xh get(int i) {
        return this.f6017a.get(i);
    }

    public int size() {
        return this.f6017a.size();
    }
}
