package atakplugin.UASTool;

public abstract class ccs {

    /* renamed from: a */
    protected Object[] f4496a;

    /* renamed from: b */
    protected int f4497b = 1048576;

    /* renamed from: c */
    protected Object[] f4498c;

    /* renamed from: a */
    public abstract Object mo4454a(Object[] objArr);

    public ccs() {
    }

    public ccs(Object[] objArr) {
        this.f4496a = objArr;
    }

    /* renamed from: a */
    public int mo4452a() {
        return this.f4497b;
    }

    /* renamed from: b */
    public Object[] mo4455b() {
        return this.f4496a;
    }

    /* renamed from: c */
    public Object[] mo4456c() {
        return this.f4498c;
    }

    /* renamed from: d */
    public cap mo4457d() {
        Object[] objArr = this.f4496a;
        cap cap = (cap) objArr[objArr.length - 1];
        cap.mo4342a(this);
        return cap;
    }

    /* renamed from: a */
    public cap mo4453a(int i) {
        Object[] objArr = this.f4496a;
        cap cap = (cap) objArr[objArr.length - 1];
        cap.mo4342a(this);
        this.f4497b = i;
        return cap;
    }
}
