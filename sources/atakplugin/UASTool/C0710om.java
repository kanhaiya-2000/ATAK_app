package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.om */
public class C0710om extends C1004wp {

    /* renamed from: a */
    public static final String f5463a = "gnre";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5464d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5465e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5466f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5467o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5468p = null;

    /* renamed from: b */
    private String f5469b;

    /* renamed from: c */
    private String f5470c;

    static {
        m12684j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m12684j() {
        cdj cdj = new cdj("GenreBox.java", C0710om.class);
        f5464d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.GenreBox", "", "", "", "java.lang.String"), 42);
        f5465e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGenre", "com.coremedia.iso.boxes.GenreBox", "", "", "", "java.lang.String"), 46);
        f5466f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.GenreBox", "java.lang.String", "language", "", "void"), 50);
        f5467o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setGenre", "com.coremedia.iso.boxes.GenreBox", "java.lang.String", "genre", "", "void"), 54);
        f5468p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.GenreBox", "", "", "", "java.lang.String"), 77);
    }

    public C0710om() {
        super(f5463a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5464d, (Object) this, (Object) this));
        return this.f5469b;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5465e, (Object) this, (Object) this));
        return this.f5470c;
    }

    /* renamed from: a */
    public void mo5189a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5466f, (Object) this, (Object) this, (Object) str));
        this.f5469b = str;
    }

    /* renamed from: b */
    public void mo5190b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5467o, (Object) this, (Object) this, (Object) str));
        this.f5470c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5470c) + 7);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5469b = C0679nk.m12505l(byteBuffer);
        this.f5470c = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5469b);
        byteBuffer.put(C0684np.m12528a(this.f5470c));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5468p, (Object) this, (Object) this));
        return "GenreBox[language=" + mo36c() + ";genre=" + mo43i() + "]";
    }
}
