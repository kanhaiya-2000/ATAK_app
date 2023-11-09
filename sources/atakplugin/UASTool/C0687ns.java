package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.ns */
public class C0687ns extends C1004wp {

    /* renamed from: a */
    public static final String f5354a = "auth";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5355d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5356e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5357f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5358o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5359p = null;

    /* renamed from: b */
    private String f5360b;

    /* renamed from: c */
    private String f5361c;

    static {
        m12540c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12540c() {
        cdj cdj = new cdj("AuthorBox.java", C0687ns.class);
        f5355d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 51);
        f5356e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAuthor", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 60);
        f5357f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.AuthorBox", "java.lang.String", "language", "", "void"), 64);
        f5358o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAuthor", "com.coremedia.iso.boxes.AuthorBox", "java.lang.String", "author", "", "void"), 68);
        f5359p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.AuthorBox", "", "", "", "java.lang.String"), 92);
    }

    public C0687ns() {
        super(f5354a);
    }

    /* renamed from: a */
    public String mo5117a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5355d, (Object) this, (Object) this));
        return this.f5360b;
    }

    /* renamed from: b */
    public String mo5119b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5356e, (Object) this, (Object) this));
        return this.f5361c;
    }

    /* renamed from: a */
    public void mo5118a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5357f, (Object) this, (Object) this, (Object) str));
        this.f5360b = str;
    }

    /* renamed from: b */
    public void mo5120b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5358o, (Object) this, (Object) this, (Object) str));
        this.f5361c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5361c) + 7);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5360b = C0679nk.m12505l(byteBuffer);
        this.f5361c = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5360b);
        byteBuffer.put(C0684np.m12528a(this.f5361c));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5359p, (Object) this, (Object) this));
        return "AuthorBox[language=" + mo5117a() + ";author=" + mo5119b() + "]";
    }
}
