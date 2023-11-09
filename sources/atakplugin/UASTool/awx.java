package atakplugin.UASTool;

import java.util.Comparator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, mo1538e = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"})
public final class awx<T> implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f2346a;

    /* renamed from: b */
    final /* synthetic */ bdl f2347b;

    public awx(Comparator comparator, bdl bdl) {
        this.f2346a = comparator;
        this.f2347b = bdl;
    }

    public final int compare(T t, T t2) {
        int compare = this.f2346a.compare(t, t2);
        return compare != 0 ? compare : awn.m5728a((Comparable) this.f2347b.invoke(t), (Comparable) this.f2347b.invoke(t2));
    }
}
