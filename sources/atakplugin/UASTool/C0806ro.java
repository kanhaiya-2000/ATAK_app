package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.ro */
public class C0806ro extends C1004wp {

    /* renamed from: a */
    public static final String f6141a = "cvru";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f6142c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f6143d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f6144e = null;

    /* renamed from: b */
    private String f6145b;

    static {
        m13444i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13444i() {
        cdj cdj = new cdj("CoverUriBox.java", C0806ro.class);
        f6142c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCoverUri", "com.coremedia.iso.boxes.vodafone.CoverUriBox", "", "", "", "java.lang.String"), 38);
        f6143d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCoverUri", "com.coremedia.iso.boxes.vodafone.CoverUriBox", "java.lang.String", "coverUri", "", "void"), 42);
        f6144e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.vodafone.CoverUriBox", "", "", "", "java.lang.String"), 64);
    }

    public C0806ro() {
        super(f6141a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6142c, (Object) this, (Object) this));
        return this.f6145b;
    }

    /* renamed from: a */
    public void mo5675a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6143d, (Object) this, (Object) this, (Object) str));
        this.f6145b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f6145b) + 5);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f6145b = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0684np.m12528a(this.f6145b));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6144e, (Object) this, (Object) this));
        return "CoverUriBox[coverUri=" + mo36c() + "]";
    }
}
