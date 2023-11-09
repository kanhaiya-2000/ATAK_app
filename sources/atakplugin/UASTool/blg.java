package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo1538e = {"<anonymous>", "", "T", "it", "", "invoke"})
final class blg extends bfr implements bdl<Iterable<? extends T>, Iterator<? extends T>> {

    /* renamed from: a */
    public static final blg f2854a = new blg();

    blg() {
        super(1);
    }

    /* renamed from: a */
    public final Iterator<T> invoke(Iterable<? extends T> iterable) {
        bfq.m6567f(iterable, "it");
        return iterable.iterator();
    }
}
