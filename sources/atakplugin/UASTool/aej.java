package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

public class aej extends C1004wp {

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f657c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f658d = null;

    /* renamed from: a */
    public long f659a;

    /* renamed from: b */
    public long f660b;

    static {
        m690j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m690j() {
        cdj cdj = new cdj("TfxdBox.java", aej.class);
        f657c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFragmentAbsoluteTime", "com.googlecode.mp4parser.boxes.piff.TfxdBox", "", "", "", "long"), 79);
        f658d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFragmentAbsoluteDuration", "com.googlecode.mp4parser.boxes.piff.TfxdBox", "", "", "", "long"), 83);
    }

    public aej() {
        super(C0758pz.f5795b);
    }

    /* renamed from: w */
    public byte[] mo455w() {
        return new byte[]{109, Ascii.f8518GS, -101, 5, 66, -43, 68, -26, Byte.MIN_VALUE, -30, Ascii.DC4, Ascii.f8518GS, -81, -9, 87, -78};
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (mo5157a_() == 1 ? 20 : 12);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if (mo5157a_() == 1) {
            this.f659a = C0679nk.m12501h(byteBuffer);
            this.f660b = C0679nk.m12501h(byteBuffer);
            return;
        }
        this.f659a = C0679nk.m12495b(byteBuffer);
        this.f660b = C0679nk.m12495b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (mo5157a_() == 1) {
            C0681nm.m12511a(byteBuffer, this.f659a);
            C0681nm.m12511a(byteBuffer, this.f660b);
            return;
        }
        C0681nm.m12515b(byteBuffer, this.f659a);
        C0681nm.m12515b(byteBuffer, this.f660b);
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f657c, (Object) this, (Object) this));
        return this.f659a;
    }

    /* renamed from: i */
    public long mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f658d, (Object) this, (Object) this));
        return this.f660b;
    }
}
