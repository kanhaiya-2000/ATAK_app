package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pu */
public class C0753pu extends C1004wp {

    /* renamed from: a */
    public static final String f5739a = "titl";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5740d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5741e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5742f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5743o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5744p = null;

    /* renamed from: b */
    private String f5745b;

    /* renamed from: c */
    private String f5746c;

    static {
        m12988j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m12988j() {
        cdj cdj = new cdj("TitleBox.java", C0753pu.class);
        f5740d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.TitleBox", "", "", "", "java.lang.String"), 46);
        f5741e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTitle", "com.coremedia.iso.boxes.TitleBox", "", "", "", "java.lang.String"), 50);
        f5742f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.TitleBox", "java.lang.String", "language", "", "void"), 59);
        f5743o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTitle", "com.coremedia.iso.boxes.TitleBox", "java.lang.String", "title", "", "void"), 63);
        f5744p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.TitleBox", "", "", "", "java.lang.String"), 86);
    }

    public C0753pu() {
        super(f5739a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5740d, (Object) this, (Object) this));
        return this.f5745b;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5741e, (Object) this, (Object) this));
        return this.f5746c;
    }

    /* renamed from: a */
    public void mo5374a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5742f, (Object) this, (Object) this, (Object) str));
        this.f5745b = str;
    }

    /* renamed from: b */
    public void mo5375b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5743o, (Object) this, (Object) this, (Object) str));
        this.f5746c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5746c) + 7);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5745b);
        byteBuffer.put(C0684np.m12528a(this.f5746c));
        byteBuffer.put((byte) 0);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5745b = C0679nk.m12505l(byteBuffer);
        this.f5746c = C0679nk.m12500g(byteBuffer);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5744p, (Object) this, (Object) this));
        return "TitleBox[language=" + mo36c() + ";title=" + mo43i() + "]";
    }
}
