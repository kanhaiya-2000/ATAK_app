package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "", "T", "it", "", "invoke"})
final class blq extends bfr implements bdl {

    /* renamed from: a */
    final /* synthetic */ int f2867a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    blq(int i) {
        super(1);
        this.f2867a = i;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return mo2742a(((Number) obj).intValue());
    }

    /* renamed from: a */
    public final Void mo2742a(int i) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.f2867a + '.');
    }
}
