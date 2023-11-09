package atakplugin.UASTool;

public class bzz implements cbz {

    /* renamed from: a */
    protected String f4405a;

    /* renamed from: b */
    private cbm<?> f4406b;

    /* renamed from: c */
    private cbm<?> f4407c;

    /* renamed from: d */
    private int f4408d;

    public bzz(cbm<?> cbm, String str, int i) {
        this.f4406b = cbm;
        this.f4405a = str;
        this.f4408d = i;
        try {
            this.f4407c = (cbm) cah.m10991b(str, cbm.mo4228e());
        } catch (ClassNotFoundException unused) {
        }
    }

    public bzz(cbm<?> cbm, cbm<?> cbm2, int i) {
        this.f4406b = cbm;
        this.f4407c = cbm2;
        this.f4405a = cbm2.mo4209a();
        this.f4408d = i;
    }

    /* renamed from: d */
    public cbm<?> mo4287d() {
        return this.f4406b;
    }

    /* renamed from: e */
    public cbm<?> mo4288e() {
        cbm<?> cbm = this.f4407c;
        if (cbm != null) {
            return cbm;
        }
        throw new ClassNotFoundException(this.f4405a);
    }

    /* renamed from: f */
    public int mo4289f() {
        return this.f4408d;
    }
}
