package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qd */
public class C0763qd extends C1004wp {

    /* renamed from: a */
    public static final String f5815a = "rmdr";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5816c = null;

    /* renamed from: b */
    private long f5817b;

    static {
        m13062i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13062i() {
        cdj cdj = new cdj("AppleDataRateBox.java", C0763qd.class);
        f5816c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataRate", "com.coremedia.iso.boxes.apple.AppleDataRateBox", "", "", "", "long"), 53);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 8;
    }

    public C0763qd() {
        super(f5815a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5817b = C0679nk.m12495b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5817b);
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5816c, (Object) this, (Object) this));
        return this.f5817b;
    }
}
