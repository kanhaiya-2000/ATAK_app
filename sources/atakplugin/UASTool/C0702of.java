package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.of */
public class C0702of extends C1004wp {

    /* renamed from: a */
    public static final String f5424a = "dscp";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5425d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5426e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5427f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5428o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5429p = null;

    /* renamed from: b */
    private String f5430b;

    /* renamed from: c */
    private String f5431c;

    static {
        m12633j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m12633j() {
        cdj cdj = new cdj("DescriptionBox.java", C0702of.class);
        f5425d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 40);
        f5426e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDescription", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 44);
        f5427f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 67);
        f5428o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.DescriptionBox", "java.lang.String", "language", "", "void"), 71);
        f5429p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDescription", "com.coremedia.iso.boxes.DescriptionBox", "java.lang.String", "description", "", "void"), 75);
    }

    public C0702of() {
        super(f5424a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5425d, (Object) this, (Object) this));
        return this.f5430b;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5426e, (Object) this, (Object) this));
        return this.f5431c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5431c) + 7);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5430b = C0679nk.m12505l(byteBuffer);
        this.f5431c = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5430b);
        byteBuffer.put(C0684np.m12528a(this.f5431c));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5427f, (Object) this, (Object) this));
        return "DescriptionBox[language=" + mo36c() + ";description=" + mo43i() + "]";
    }

    /* renamed from: a */
    public void mo5160a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5428o, (Object) this, (Object) this, (Object) str));
        this.f5430b = str;
    }

    /* renamed from: b */
    public void mo5161b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5429p, (Object) this, (Object) this, (Object) str));
        this.f5431c = str;
    }
}
