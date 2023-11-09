package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo1538e = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "count", "", "index", "computeNext", "", "kotlin-stdlib"})
public final class avj extends arg<T> {

    /* renamed from: a */
    final /* synthetic */ avi f2296a;

    /* renamed from: b */
    private int f2297b;

    /* renamed from: c */
    private int f2298c;

    avj(avi avi) {
        this.f2296a = avi;
        this.f2297b = avi.size();
        this.f2298c = avi.f2293c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1711a() {
        if (this.f2297b == 0) {
            mo1713b();
            return;
        }
        mo1712a(this.f2296a.f2295e[this.f2298c]);
        this.f2298c = (this.f2298c + 1) % this.f2296a.f2292b;
        this.f2297b--;
    }
}
