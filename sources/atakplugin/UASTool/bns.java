package atakplugin.UASTool;

import com.atakmap.android.uastool.tasks.UASTask;
import java.util.Collection;
import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, mo1538e = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
public final class bns extends are<bnm> implements bno {

    /* renamed from: a */
    final /* synthetic */ bnq f3024a;

    public boolean isEmpty() {
        return false;
    }

    bns(bnq bnq) {
        this.f3024a = bnq;
    }

    /* renamed from: a */
    public boolean mo2859a(bnm bnm) {
        return super.contains(bnm);
    }

    public final boolean contains(Object obj) {
        if (obj != null ? obj instanceof bnm : true) {
            return mo2859a((bnm) obj);
        }
        return false;
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f3024a.m7805g().groupCount() + 1;
    }

    public Iterator<bnm> iterator() {
        return bkx.m7614u(ato.m4708J(ato.m4601a((Collection<?>) this)), new bnt(this)).mo1859a();
    }

    /* renamed from: a */
    public bnm mo2845a(int i) {
        biq a = bny.m7857b(this.f3024a.m7805g(), i);
        if (a.mo2569g().intValue() < 0) {
            return null;
        }
        String group = this.f3024a.m7805g().group(i);
        bfq.m6554b(group, "matchResult.group(index)");
        return new bnm(group, a);
    }

    /* renamed from: a */
    public bnm mo2846a(String str) {
        bfq.m6567f(str, UASTask.COTDETAIL_NAME);
        return bbg.f2499a.mo2237a(this.f3024a.m7805g(), str);
    }
}
