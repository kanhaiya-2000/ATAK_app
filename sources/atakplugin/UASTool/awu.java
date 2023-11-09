package atakplugin.UASTool;

import java.util.Comparator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, mo1538e = {"<anonymous>", "", "T", "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"})
final class awu<T> implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f2342a;

    awu(Comparator comparator) {
        this.f2342a = comparator;
    }

    public final int compare(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return this.f2342a.compare(t, t2);
    }
}
