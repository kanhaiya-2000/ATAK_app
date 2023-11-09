package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class acy extends C1004wp {

    /* renamed from: a */
    public static final String f383a = "bloc";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f384d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f385e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f386f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f387o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f388p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f389q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f390r = null;

    /* renamed from: b */
    String f391b = "";

    /* renamed from: c */
    String f392c = "";

    static {
        m386j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m386j() {
        cdj cdj = new cdj("BaseLocationBox.java", acy.class);
        f384d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 44);
        f385e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "baseLocation", "", "void"), 48);
        f386f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 52);
        f387o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "purchaseLocation", "", "void"), 56);
        f388p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "equals", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.Object", "o", "", "boolean"), 86);
        f389q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hashCode", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "int"), 100);
        f390r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 107);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 1028;
    }

    public acy() {
        super(f383a);
    }

    public acy(String str, String str2) {
        super(f383a);
        this.f391b = str;
        this.f392c = str2;
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f384d, (Object) this, (Object) this));
        return this.f391b;
    }

    /* renamed from: a */
    public void mo253a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f385e, (Object) this, (Object) this, (Object) str));
        this.f391b = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f386f, (Object) this, (Object) this));
        return this.f392c;
    }

    /* renamed from: b */
    public void mo254b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f387o, (Object) this, (Object) this, (Object) str));
        this.f392c = str;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        String g = C0679nk.m12500g(byteBuffer);
        this.f391b = g;
        byteBuffer.get(new byte[((256 - C0684np.m12529b(g)) - 1)]);
        String g2 = C0679nk.m12500g(byteBuffer);
        this.f392c = g2;
        byteBuffer.get(new byte[((256 - C0684np.m12529b(g2)) - 1)]);
        byteBuffer.get(new byte[512]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0684np.m12528a(this.f391b));
        byteBuffer.put(new byte[(256 - C0684np.m12529b(this.f391b))]);
        byteBuffer.put(C0684np.m12528a(this.f392c));
        byteBuffer.put(new byte[(256 - C0684np.m12529b(this.f392c))]);
        byteBuffer.put(new byte[512]);
    }

    public boolean equals(Object obj) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f388p, (Object) this, (Object) this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        acy acy = (acy) obj;
        String str = this.f391b;
        if (str == null ? acy.f391b != null : !str.equals(acy.f391b)) {
            return false;
        }
        String str2 = this.f392c;
        String str3 = acy.f392c;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f389q, (Object) this, (Object) this));
        String str = this.f391b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f392c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f390r, (Object) this, (Object) this));
        return "BaseLocationBox{baseLocation='" + this.f391b + '\'' + ", purchaseLocation='" + this.f392c + '\'' + '}';
    }
}
