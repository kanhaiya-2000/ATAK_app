package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo1538e = {"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"})
final class arf extends bfr implements bdl<E, CharSequence> {

    /* renamed from: a */
    final /* synthetic */ are f2202a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    arf(are are) {
        super(1);
        this.f2202a = are;
    }

    /* renamed from: a */
    public final CharSequence invoke(E e) {
        return e == this.f2202a ? "(this Collection)" : String.valueOf(e);
    }
}
