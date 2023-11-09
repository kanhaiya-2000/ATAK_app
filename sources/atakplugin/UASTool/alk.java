package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class alk extends C1002wn {

    /* renamed from: a */
    public static final String f1959a = "vttC";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f1960c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f1961d = null;

    /* renamed from: b */
    String f1962b = "";

    static {
        m2254b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m2254b() {
        cdj cdj = new cdj("WebVTTConfigurationBox.java", alk.class);
        f1960c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getConfig", "com.mp4parser.iso14496.part30.WebVTTConfigurationBox", "", "", "", "java.lang.String"), 36);
        f1961d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setConfig", "com.mp4parser.iso14496.part30.WebVTTConfigurationBox", "java.lang.String", "config", "", "void"), 40);
    }

    public alk() {
        super(f1959a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) C0684np.m12529b(this.f1962b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(C0684np.m12528a(this.f1962b));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f1962b = C0679nk.m12494a(byteBuffer, byteBuffer.remaining());
    }

    /* renamed from: a */
    public String mo1389a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1960c, (Object) this, (Object) this));
        return this.f1962b;
    }

    /* renamed from: a */
    public void mo1390a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1961d, (Object) this, (Object) this, (Object) str));
        this.f1962b = str;
    }
}
