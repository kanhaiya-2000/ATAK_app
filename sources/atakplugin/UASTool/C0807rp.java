package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.rp */
public class C0807rp extends C1004wp {

    /* renamed from: a */
    public static final String f6146a = "lrcu";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f6147c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f6148d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f6149e = null;

    /* renamed from: b */
    private String f6150b;

    static {
        m13450i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13450i() {
        cdj cdj = new cdj("LyricsUriBox.java", C0807rp.class);
        f6147c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 39);
        f6148d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "java.lang.String", "lyricsUri", "", "void"), 43);
        f6149e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 64);
    }

    public C0807rp() {
        super(f6146a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6147c, (Object) this, (Object) this));
        return this.f6150b;
    }

    /* renamed from: a */
    public void mo5677a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6148d, (Object) this, (Object) this, (Object) str));
        this.f6150b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f6150b) + 5);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f6150b = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0684np.m12528a(this.f6150b));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6149e, (Object) this, (Object) this));
        return "LyricsUriBox[lyricsUri=" + mo36c() + "]";
    }
}
