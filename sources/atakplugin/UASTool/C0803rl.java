package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.rl */
public class C0803rl extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f6102A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f6103B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f6104C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f6105D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f6106E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f6107F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f6108G = null;

    /* renamed from: a */
    public static final String f6109a = "loci";

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f6110r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f6111s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f6112t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f6113u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f6114v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f6115w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f6116x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f6117y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f6118z = null;

    /* renamed from: b */
    private String f6119b;

    /* renamed from: c */
    private String f6120c = "";

    /* renamed from: d */
    private int f6121d;

    /* renamed from: e */
    private double f6122e;

    /* renamed from: f */
    private double f6123f;

    /* renamed from: o */
    private double f6124o;

    /* renamed from: p */
    private String f6125p = "";

    /* renamed from: q */
    private String f6126q = "";

    static {
        m13410p();
    }

    /* renamed from: p */
    private static /* synthetic */ void m13410p() {
        cdj cdj = new cdj("LocationInformationBox.java", C0803rl.class);
        f6110r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 30);
        f6111s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", "language", "", "void"), 34);
        f6103B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAltitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "double"), 70);
        f6104C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAltitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "double", UASPoint.COTDETAIL_ALT, "", "void"), 74);
        f6105D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAstronomicalBody", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 78);
        f6106E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAstronomicalBody", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", "astronomicalBody", "", "void"), 82);
        f6107F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAdditionalNotes", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 86);
        f6108G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAdditionalNotes", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", "additionalNotes", "", "void"), 90);
        f6112t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getName", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 38);
        f6113u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setName", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", UASTask.COTDETAIL_NAME, "", "void"), 42);
        f6114v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRole", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "int"), 46);
        f6115w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRole", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "int", "role", "", "void"), 50);
        f6116x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLongitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "double"), 54);
        f6117y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLongitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "double", UASPoint.COTDETAIL_LON, "", "void"), 58);
        f6118z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLatitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "double"), 62);
        f6102A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLatitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "double", UASPoint.COTDETAIL_LAT, "", "void"), 66);
    }

    public C0803rl() {
        super(f6109a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6110r, (Object) this, (Object) this));
        return this.f6119b;
    }

    /* renamed from: a */
    public void mo5658a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6111s, (Object) this, (Object) this, (Object) str));
        this.f6119b = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6112t, (Object) this, (Object) this));
        return this.f6120c;
    }

    /* renamed from: b */
    public void mo5660b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6113u, (Object) this, (Object) this, (Object) str));
        this.f6120c = str;
    }

    /* renamed from: j */
    public int mo5665j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6114v, (Object) this, (Object) this));
        return this.f6121d;
    }

    /* renamed from: c */
    public void mo5662c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6115w, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f6121d = i;
    }

    /* renamed from: k */
    public double mo5666k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6116x, (Object) this, (Object) this));
        return this.f6122e;
    }

    /* renamed from: a */
    public void mo5657a(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6117y, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f6122e = d;
    }

    /* renamed from: l */
    public double mo5667l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6118z, (Object) this, (Object) this));
        return this.f6123f;
    }

    /* renamed from: b */
    public void mo5659b(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6102A, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f6123f = d;
    }

    /* renamed from: m */
    public double mo5668m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6103B, (Object) this, (Object) this));
        return this.f6124o;
    }

    /* renamed from: c */
    public void mo5661c(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6104C, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f6124o = d;
    }

    /* renamed from: n */
    public String mo5669n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6105D, (Object) this, (Object) this));
        return this.f6125p;
    }

    /* renamed from: c */
    public void mo5663c(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6106E, (Object) this, (Object) this, (Object) str));
        this.f6125p = str;
    }

    /* renamed from: o */
    public String mo5670o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6107F, (Object) this, (Object) this));
        return this.f6126q;
    }

    /* renamed from: d */
    public void mo5664d(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6108G, (Object) this, (Object) this, (Object) str));
        this.f6126q = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12528a(this.f6120c).length + 22 + C0684np.m12528a(this.f6125p).length + C0684np.m12528a(this.f6126q).length);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f6119b = C0679nk.m12505l(byteBuffer);
        this.f6120c = C0679nk.m12500g(byteBuffer);
        this.f6121d = C0679nk.m12499f(byteBuffer);
        this.f6122e = C0679nk.m12502i(byteBuffer);
        this.f6123f = C0679nk.m12502i(byteBuffer);
        this.f6124o = C0679nk.m12502i(byteBuffer);
        this.f6125p = C0679nk.m12500g(byteBuffer);
        this.f6126q = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f6119b);
        byteBuffer.put(C0684np.m12528a(this.f6120c));
        byteBuffer.put((byte) 0);
        C0681nm.m12521d(byteBuffer, this.f6121d);
        C0681nm.m12509a(byteBuffer, this.f6122e);
        C0681nm.m12509a(byteBuffer, this.f6123f);
        C0681nm.m12509a(byteBuffer, this.f6124o);
        byteBuffer.put(C0684np.m12528a(this.f6125p));
        byteBuffer.put((byte) 0);
        byteBuffer.put(C0684np.m12528a(this.f6126q));
        byteBuffer.put((byte) 0);
    }
}
