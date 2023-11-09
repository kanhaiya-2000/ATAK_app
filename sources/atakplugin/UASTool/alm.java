package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class alm extends C1002wn {

    /* renamed from: a */
    public static final String f1964a = "vlab";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f1965c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f1966d = null;

    /* renamed from: b */
    String f1967b = "";

    static {
        m2264b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m2264b() {
        cdj cdj = new cdj("WebVTTSourceLabelBox.java", alm.class);
        f1965c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSourceLabel", "com.mp4parser.iso14496.part30.WebVTTSourceLabelBox", "", "", "", "java.lang.String"), 37);
        f1966d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSourceLabel", "com.mp4parser.iso14496.part30.WebVTTSourceLabelBox", "java.lang.String", "sourceLabel", "", "void"), 41);
    }

    public alm() {
        super(f1964a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) C0684np.m12529b(this.f1967b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(C0684np.m12528a(this.f1967b));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f1967b = C0679nk.m12494a(byteBuffer, byteBuffer.remaining());
    }

    /* renamed from: a */
    public String mo1393a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1965c, (Object) this, (Object) this));
        return this.f1967b;
    }

    /* renamed from: a */
    public void mo1394a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1966d, (Object) this, (Object) this, (Object) str));
        this.f1967b = str;
    }
}
