package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.rn */
public class C0805rn extends C1004wp {

    /* renamed from: a */
    public static final String f6135a = "cdis";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f6136d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f6137e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f6138f = null;

    /* renamed from: b */
    private String f6139b;

    /* renamed from: c */
    private String f6140c;

    static {
        m13438j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m13438j() {
        cdj cdj = new cdj("ContentDistributorIdBox.java", C0805rn.class);
        f6136d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 40);
        f6137e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContentDistributorId", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 44);
        f6138f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 68);
    }

    public C0805rn() {
        super(f6135a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6136d, (Object) this, (Object) this));
        return this.f6139b;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6137e, (Object) this, (Object) this));
        return this.f6140c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f6140c) + 2 + 5);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f6139b = C0679nk.m12505l(byteBuffer);
        this.f6140c = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f6139b);
        byteBuffer.put(C0684np.m12528a(this.f6140c));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6138f, (Object) this, (Object) this));
        return "ContentDistributorIdBox[language=" + mo36c() + ";contentDistributorId=" + mo43i() + "]";
    }
}
