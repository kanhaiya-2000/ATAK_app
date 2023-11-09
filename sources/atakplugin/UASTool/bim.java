package atakplugin.UASTool;

import java.lang.Comparable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, mo1538e = {"Lkotlin/ranges/ClosedRange;", "T", "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"})
public interface bim<T extends Comparable<? super T>> {
    /* renamed from: a */
    boolean mo2567a(T t);

    /* renamed from: e */
    boolean mo2558e();

    /* renamed from: g */
    T mo2569g();

    /* renamed from: i */
    T mo2571i();

    @aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3})
    /* renamed from: atakplugin.UASTool.bim$a */
    public static final class C0168a {
        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m7046a(bim<T> bim, T t) {
            bfq.m6567f(t, "value");
            return t.compareTo(bim.mo2569g()) >= 0 && t.compareTo(bim.mo2571i()) <= 0;
        }

        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m7045a(bim<T> bim) {
            return bim.mo2569g().compareTo(bim.mo2571i()) > 0;
        }
    }
}
