package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.oa */
public class C0697oa extends C1004wp {

    /* renamed from: a */
    public static final String f5404a = "cprt";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5405d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5406e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5407f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5408o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5409p = null;

    /* renamed from: b */
    private String f5410b;

    /* renamed from: c */
    private String f5411c;

    static {
        m12608c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12608c() {
        cdj cdj = new cdj("CopyrightBox.java", C0697oa.class);
        f5405d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.CopyrightBox", "", "", "", "java.lang.String"), 46);
        f5406e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCopyright", "com.coremedia.iso.boxes.CopyrightBox", "", "", "", "java.lang.String"), 50);
        f5407f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.CopyrightBox", "java.lang.String", "language", "", "void"), 54);
        f5408o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCopyright", "com.coremedia.iso.boxes.CopyrightBox", "java.lang.String", "copyright", "", "void"), 58);
        f5409p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.CopyrightBox", "", "", "", "java.lang.String"), 81);
    }

    public C0697oa() {
        super(f5404a);
    }

    /* renamed from: a */
    public String mo5148a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5405d, (Object) this, (Object) this));
        return this.f5410b;
    }

    /* renamed from: b */
    public String mo5150b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5406e, (Object) this, (Object) this));
        return this.f5411c;
    }

    /* renamed from: a */
    public void mo5149a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5407f, (Object) this, (Object) this, (Object) str));
        this.f5410b = str;
    }

    /* renamed from: b */
    public void mo5151b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5408o, (Object) this, (Object) this, (Object) str));
        this.f5411c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5411c) + 7);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5410b = C0679nk.m12505l(byteBuffer);
        this.f5411c = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5410b);
        byteBuffer.put(C0684np.m12528a(this.f5411c));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5409p, (Object) this, (Object) this));
        return "CopyrightBox[language=" + mo5148a() + ";copyright=" + mo5150b() + "]";
    }
}
