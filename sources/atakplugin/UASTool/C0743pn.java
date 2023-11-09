package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pn */
public class C0743pn extends C1004wp {

    /* renamed from: a */
    public static final String f5692a = "schm";

    /* renamed from: e */
    static final /* synthetic */ boolean f5693e = true;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5694f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5695o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5696p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5697q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5698r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5699s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5700t = null;

    /* renamed from: b */
    String f5701b = "    ";

    /* renamed from: c */
    long f5702c;

    /* renamed from: d */
    String f5703d = null;

    /* renamed from: k */
    private static /* synthetic */ void m12928k() {
        cdj cdj = new cdj("SchemeTypeBox.java", C0743pn.class);
        f5694f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSchemeType", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "java.lang.String"), 44);
        f5695o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSchemeVersion", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "long"), 48);
        f5696p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSchemeUri", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "java.lang.String"), 52);
        f5697q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSchemeType", "com.coremedia.iso.boxes.SchemeTypeBox", "java.lang.String", "schemeType", "", "void"), 56);
        f5698r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSchemeVersion", "com.coremedia.iso.boxes.SchemeTypeBox", "int", "schemeVersion", "", "void"), 61);
        f5699s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSchemeUri", "com.coremedia.iso.boxes.SchemeTypeBox", "java.lang.String", "schemeUri", "", "void"), 65);
        f5700t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "java.lang.String"), 93);
    }

    static {
        m12928k();
    }

    public C0743pn() {
        super(f5692a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5694f, (Object) this, (Object) this));
        return this.f5701b;
    }

    /* renamed from: i */
    public long mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5695o, (Object) this, (Object) this));
        return this.f5702c;
    }

    /* renamed from: j */
    public String mo5345j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5696p, (Object) this, (Object) this));
        return this.f5703d;
    }

    /* renamed from: a */
    public void mo5342a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5697q, (Object) this, (Object) this, (Object) str));
        if (f5693e || (str != null && str.length() == 4)) {
            this.f5701b = str;
            return;
        }
        throw new AssertionError("SchemeType may not be null or not 4 bytes long");
    }

    /* renamed from: c */
    public void mo5344c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5698r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5702c = (long) i;
    }

    /* renamed from: b */
    public void mo5343b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5699s, (Object) this, (Object) this, (Object) str));
        this.f5703d = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (((mo456b_() & 1) == 1 ? C0684np.m12529b(this.f5703d) + 1 : 0) + 12);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5701b = C0679nk.m12506m(byteBuffer);
        this.f5702c = C0679nk.m12495b(byteBuffer);
        if ((mo456b_() & 1) == 1) {
            this.f5703d = C0679nk.m12500g(byteBuffer);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0678nj.m12488a(this.f5701b));
        C0681nm.m12515b(byteBuffer, this.f5702c);
        if ((mo456b_() & 1) == 1) {
            byteBuffer.put(C0684np.m12528a(this.f5703d));
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5700t, (Object) this, (Object) this));
        return "Schema Type Box[" + "schemeUri=" + this.f5703d + "; " + "schemeType=" + this.f5701b + "; " + "schemeVersion=" + this.f5702c + "; " + "]";
    }
}
