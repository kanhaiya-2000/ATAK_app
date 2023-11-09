package atakplugin.UASTool;

import java.lang.Comparable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, mo1538e = {"Lkotlin/ranges/ClosedFloatingPointRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"})
public interface bil<T extends Comparable<? super T>> extends bim<T> {
    /* renamed from: a */
    boolean mo2567a(T t);

    /* renamed from: a */
    boolean mo2576a(T t, T t2);

    /* renamed from: e */
    boolean mo2558e();

    @aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3})
    /* renamed from: atakplugin.UASTool.bil$a */
    public static final class C0167a {
        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m7040a(bil<T> bil, T t) {
            bfq.m6567f(t, "value");
            return bil.mo2576a(bil.mo2569g(), t) && bil.mo2576a(t, bil.mo2571i());
        }

        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m7039a(bil<T> bil) {
            return !bil.mo2576a(bil.mo2569g(), bil.mo2571i());
        }
    }
}
