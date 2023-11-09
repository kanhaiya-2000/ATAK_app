package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, mo1538e = {"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"})
public interface axr {
    /* renamed from: a */
    <R> axp mo2136a(aoh<? extends R> aoh, axv axv);

    /* renamed from: a */
    axw mo2137a();

    /* renamed from: a */
    axw mo2138a(Object obj);

    /* renamed from: b */
    axx mo2139b();

    @aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3})
    /* renamed from: atakplugin.UASTool.axr$a */
    public static final class C0108a {
        /* renamed from: a */
        public static /* synthetic */ axp m5831a(axr axr, aoh aoh, axv axv, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    axv = axv.UNKNOWN;
                }
                return axr.mo2136a(aoh, axv);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }
}
