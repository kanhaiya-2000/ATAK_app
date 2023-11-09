package atakplugin.UASTool;

import atakplugin.UASTool.can;

/* renamed from: atakplugin.UASTool.nv */
public abstract class C0690nv extends C1004wp {

    /* renamed from: a */
    private static final /* synthetic */ can.C0296b f5366a = null;

    static {
        m12561c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12561c() {
        cdj cdj = new cdj("ChunkOffsetBox.java", C0690nv.class);
        f5366a = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    /* renamed from: a */
    public abstract void mo5122a(long[] jArr);

    /* renamed from: a */
    public abstract long[] mo5123a();

    public C0690nv(String str) {
        super(str);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5366a, (Object) this, (Object) this));
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + mo5123a().length + "]";
    }
}
