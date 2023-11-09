package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.mj */
public class C0650mj<T> extends C0551ja<T> {

    /* renamed from: a */
    private final C0530il<T> f5278a;

    /* renamed from: b */
    private T f5279b;

    public boolean hasNext() {
        return true;
    }

    public C0650mj(T t, C0530il<T> ilVar) {
        this.f5278a = ilVar;
        this.f5279b = t;
    }

    /* renamed from: a */
    public T mo4999a() {
        T t = this.f5279b;
        this.f5279b = this.f5278a.apply(t);
        return t;
    }
}
