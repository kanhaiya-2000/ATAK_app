package atakplugin.UASTool;

import java.util.Comparator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, mo1538e = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"})
public final class awt<T> implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f2340a;

    /* renamed from: b */
    final /* synthetic */ bdl f2341b;

    public awt(Comparator comparator, bdl bdl) {
        this.f2340a = comparator;
        this.f2341b = bdl;
    }

    public final int compare(T t, T t2) {
        return this.f2340a.compare(this.f2341b.invoke(t2), this.f2341b.invoke(t));
    }
}
