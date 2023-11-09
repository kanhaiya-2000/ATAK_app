package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "", "T", "invoke"})
final class auf extends bfr implements bdk<Iterator<? extends T>> {

    /* renamed from: a */
    final /* synthetic */ Iterable f2269a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    auf(Iterable iterable) {
        super(0);
        this.f2269a = iterable;
    }

    /* renamed from: a */
    public final Iterator<T> invoke() {
        return this.f2269a.iterator();
    }
}
