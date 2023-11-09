package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.bn */
public final class C0198bn<T> {

    /* renamed from: a */
    private final int f2931a;

    /* renamed from: b */
    private final T f2932b;

    public C0198bn(int i, T t) {
        this.f2931a = i;
        this.f2932b = t;
    }

    /* renamed from: a */
    public int mo2805a() {
        return this.f2931a;
    }

    /* renamed from: b */
    public T mo2806b() {
        return this.f2932b;
    }

    public int hashCode() {
        int i = (679 + this.f2931a) * 97;
        T t = this.f2932b;
        return i + (t != null ? t.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0198bn bnVar = (C0198bn) obj;
        if (this.f2931a != bnVar.f2931a) {
            return false;
        }
        T t = this.f2932b;
        T t2 = bnVar.f2932b;
        if (t == t2) {
            return true;
        }
        if (t == null || !t.equals(t2)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "IntPair[" + this.f2931a + ", " + this.f2932b + ']';
    }
}
