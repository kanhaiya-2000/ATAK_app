package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pf */
public class C0733pf extends C1004wp {

    /* renamed from: a */
    public static final String f5642a = "rtng";

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5643f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5644o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5645p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5646q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5647r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5648s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5649t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5650u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5651v = null;

    /* renamed from: b */
    private String f5652b;

    /* renamed from: c */
    private String f5653c;

    /* renamed from: d */
    private String f5654d;

    /* renamed from: e */
    private String f5655e;

    static {
        m12856l();
    }

    /* renamed from: l */
    private static /* synthetic */ void m12856l() {
        cdj cdj = new cdj("RatingBox.java", C0733pf.class);
        f5643f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRatingEntity", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingEntity", "", "void"), 46);
        f5644o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRatingCriteria", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingCriteria", "", "void"), 50);
        f5645p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "language", "", "void"), 54);
        f5646q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRatingInfo", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingInfo", "", "void"), 58);
        f5647r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 62);
        f5648s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRatingEntity", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 73);
        f5649t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRatingCriteria", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 83);
        f5650u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRatingInfo", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 87);
        f5651v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 115);
    }

    public C0733pf() {
        super(f5642a);
    }

    /* renamed from: a */
    public void mo5295a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5643f, (Object) this, (Object) this, (Object) str));
        this.f5652b = str;
    }

    /* renamed from: b */
    public void mo5296b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5644o, (Object) this, (Object) this, (Object) str));
        this.f5653c = str;
    }

    /* renamed from: c */
    public void mo5297c(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5645p, (Object) this, (Object) this, (Object) str));
        this.f5654d = str;
    }

    /* renamed from: d */
    public void mo5298d(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5646q, (Object) this, (Object) this, (Object) str));
        this.f5655e = str;
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5647r, (Object) this, (Object) this));
        return this.f5654d;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5648s, (Object) this, (Object) this));
        return this.f5652b;
    }

    /* renamed from: j */
    public String mo5299j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5649t, (Object) this, (Object) this));
        return this.f5653c;
    }

    /* renamed from: k */
    public String mo5300k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5650u, (Object) this, (Object) this));
        return this.f5655e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5655e) + 15);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5652b = C0679nk.m12506m(byteBuffer);
        this.f5653c = C0679nk.m12506m(byteBuffer);
        this.f5654d = C0679nk.m12505l(byteBuffer);
        this.f5655e = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0678nj.m12488a(this.f5652b));
        byteBuffer.put(C0678nj.m12488a(this.f5653c));
        C0681nm.m12512a(byteBuffer, this.f5654d);
        byteBuffer.put(C0684np.m12528a(this.f5655e));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5651v, (Object) this, (Object) this));
        return "RatingBox[language=" + mo36c() + "ratingEntity=" + mo43i() + ";ratingCriteria=" + mo5299j() + ";language=" + mo36c() + ";ratingInfo=" + mo5300k() + "]";
    }
}
