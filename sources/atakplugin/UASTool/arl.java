package atakplugin.UASTool;

import java.util.Iterator;
import java.util.Map;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo1538e = {"kotlin/collections/AbstractMap$keys$1$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class arl implements bgz, Iterator<K> {

    /* renamed from: a */
    final /* synthetic */ Iterator f2217a;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    arl(Iterator it) {
        this.f2217a = it;
    }

    public boolean hasNext() {
        return this.f2217a.hasNext();
    }

    public K next() {
        return ((Map.Entry) this.f2217a.next()).getKey();
    }
}
