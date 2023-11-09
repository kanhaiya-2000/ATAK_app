package atakplugin.UASTool;

import java.util.Comparator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, mo1538e = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"})
public final class awy<T> implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f2348a;

    /* renamed from: b */
    final /* synthetic */ Comparator f2349b;

    /* renamed from: c */
    final /* synthetic */ bdl f2350c;

    public awy(Comparator comparator, Comparator comparator2, bdl bdl) {
        this.f2348a = comparator;
        this.f2349b = comparator2;
        this.f2350c = bdl;
    }

    public final int compare(T t, T t2) {
        int compare = this.f2348a.compare(t, t2);
        return compare != 0 ? compare : this.f2349b.compare(this.f2350c.invoke(t), this.f2350c.invoke(t2));
    }
}
