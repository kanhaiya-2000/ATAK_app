package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo1538e = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"})
public final class bnr extends ari<String> {

    /* renamed from: b */
    final /* synthetic */ bnq f3023b;

    bnr(bnq bnq) {
        this.f3023b = bnq;
    }

    /* renamed from: a */
    public int mo2855a(String str) {
        return super.indexOf(str);
    }

    /* renamed from: b */
    public int mo2857b(String str) {
        return super.lastIndexOf(str);
    }

    /* renamed from: c */
    public boolean mo2858c(String str) {
        return super.contains(str);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof String) {
            return mo2858c((String) obj);
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof String) {
            return mo2855a((String) obj);
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return mo2857b((String) obj);
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1694a() {
        return this.f3023b.m7805g().groupCount() + 1;
    }

    /* renamed from: a */
    public String get(int i) {
        String group = this.f3023b.m7805g().group(i);
        return group != null ? group : "";
    }
}
