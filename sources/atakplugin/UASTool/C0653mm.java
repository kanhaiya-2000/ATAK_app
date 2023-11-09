package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.mm */
public class C0653mm<T, R> extends C0551ja<R> {

    /* renamed from: a */
    private final C0547ix<? extends T> f5285a;

    /* renamed from: b */
    private final C0415ez<? super T, ? extends R> f5286b;

    public C0653mm(C0547ix<? extends T> ixVar, C0415ez<? super T, ? extends R> ezVar) {
        this.f5285a = ixVar;
        this.f5286b = ezVar;
    }

    public boolean hasNext() {
        return this.f5285a.hasNext();
    }

    /* renamed from: a */
    public R mo4999a() {
        return this.f5286b.mo4872b(this.f5285a.mo4987a(), this.f5285a.next());
    }
}
