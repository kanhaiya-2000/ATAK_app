package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.po */
public class C0744po extends C0685nq {

    /* renamed from: a */
    public static final String f5704a = "smhd";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5705c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5706d = null;

    /* renamed from: b */
    private float f5707b;

    static {
        m12938i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12938i() {
        cdj cdj = new cdj("SoundMediaHeaderBox.java", C0744po.class);
        f5705c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBalance", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "float"), 36);
        f5706d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 8;
    }

    public C0744po() {
        super(f5704a);
    }

    /* renamed from: c */
    public float mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5705c, (Object) this, (Object) this));
        return this.f5707b;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5707b = C0679nk.m12504k(byteBuffer);
        C0679nk.m12497d(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12517c(byteBuffer, (double) this.f5707b);
        C0681nm.m12514b(byteBuffer, 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5706d, (Object) this, (Object) this));
        return "SoundMediaHeaderBox[balance=" + mo36c() + "]";
    }
}
