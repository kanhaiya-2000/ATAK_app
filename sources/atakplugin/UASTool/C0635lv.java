package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.lv */
public class C0635lv<T> extends C0551ja<T> {

    /* renamed from: a */
    private final T[] f5235a;

    /* renamed from: b */
    private int f5236b = 0;

    public C0635lv(T[] tArr) {
        this.f5235a = tArr;
    }

    public boolean hasNext() {
        return this.f5236b < this.f5235a.length;
    }

    /* renamed from: a */
    public T mo4999a() {
        T[] tArr = this.f5235a;
        int i = this.f5236b;
        this.f5236b = i + 1;
        return tArr[i];
    }
}
