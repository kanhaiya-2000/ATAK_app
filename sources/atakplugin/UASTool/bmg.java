package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo1538e = {"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
final class bmg extends bfr implements bdl<T, T> {

    /* renamed from: a */
    final /* synthetic */ bku f2891a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bmg(bku bku) {
        super(1);
        this.f2891a = bku;
    }

    public final T invoke(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("null element found in " + this.f2891a + '.');
    }
}
