package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qe */
public class C0764qe extends C1004wp {

    /* renamed from: a */
    public static final String f5818a = "rdrf";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5819e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5820f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5821o = null;

    /* renamed from: b */
    private int f5822b;

    /* renamed from: c */
    private String f5823c;

    /* renamed from: d */
    private String f5824d;

    static {
        m13067k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m13067k() {
        cdj cdj = new cdj("AppleDataReferenceBox.java", C0764qe.class);
        f5819e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataReferenceSize", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "long"), 63);
        f5820f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataReferenceType", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 67);
        f5821o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataReference", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 71);
    }

    public C0764qe() {
        super(f5818a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (this.f5822b + 12);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5823c = C0679nk.m12506m(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5822b = a;
        this.f5824d = C0679nk.m12494a(byteBuffer, a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0678nj.m12488a(this.f5823c));
        C0681nm.m12515b(byteBuffer, (long) this.f5822b);
        byteBuffer.put(C0684np.m12528a(this.f5824d));
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5819e, (Object) this, (Object) this));
        return (long) this.f5822b;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5820f, (Object) this, (Object) this));
        return this.f5823c;
    }

    /* renamed from: j */
    public String mo5417j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5821o, (Object) this, (Object) this));
        return this.f5824d;
    }
}
