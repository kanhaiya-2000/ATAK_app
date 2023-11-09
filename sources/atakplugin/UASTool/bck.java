package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0017\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0006\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo1538e = {"kotlin/io/LinesSequence$iterator$1", "", "", "done", "", "nextValue", "hasNext", "next", "kotlin-stdlib"})
public final class bck implements bgz, Iterator<String> {

    /* renamed from: a */
    final /* synthetic */ bcj f2550a;

    /* renamed from: b */
    private String f2551b;

    /* renamed from: c */
    private boolean f2552c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bck(bcj bcj) {
        this.f2550a = bcj;
    }

    public boolean hasNext() {
        if (this.f2551b == null && !this.f2552c) {
            String readLine = this.f2550a.f2549a.readLine();
            this.f2551b = readLine;
            if (readLine == null) {
                this.f2552c = true;
            }
        }
        if (this.f2551b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public String next() {
        if (hasNext()) {
            String str = this.f2551b;
            this.f2551b = null;
            if (str == null) {
                bfq.m6538a();
            }
            return str;
        }
        throw new NoSuchElementException();
    }
}
