package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pc */
public class C0729pc extends C1004wp {

    /* renamed from: a */
    public static final String f5626a = "perf";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5627d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5628e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5629f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5630o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5631p = null;

    /* renamed from: b */
    private String f5632b;

    /* renamed from: c */
    private String f5633c;

    static {
        m12838j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m12838j() {
        cdj cdj = new cdj("PerformerBox.java", C0729pc.class);
        f5627d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 41);
        f5628e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPerformer", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 45);
        f5629f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.PerformerBox", "java.lang.String", "language", "", "void"), 49);
        f5630o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPerformer", "com.coremedia.iso.boxes.PerformerBox", "java.lang.String", "performer", "", "void"), 53);
        f5631p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 76);
    }

    public C0729pc() {
        super(f5626a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5627d, (Object) this, (Object) this));
        return this.f5632b;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5628e, (Object) this, (Object) this));
        return this.f5633c;
    }

    /* renamed from: a */
    public void mo5283a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5629f, (Object) this, (Object) this, (Object) str));
        this.f5632b = str;
    }

    /* renamed from: b */
    public void mo5284b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5630o, (Object) this, (Object) this, (Object) str));
        this.f5633c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5633c) + 6 + 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5632b);
        byteBuffer.put(C0684np.m12528a(this.f5633c));
        byteBuffer.put((byte) 0);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5632b = C0679nk.m12505l(byteBuffer);
        this.f5633c = C0679nk.m12500g(byteBuffer);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5631p, (Object) this, (Object) this));
        return "PerformerBox[language=" + mo36c() + ";performer=" + mo43i() + "]";
    }
}
