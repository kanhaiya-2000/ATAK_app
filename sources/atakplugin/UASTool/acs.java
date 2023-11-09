package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class acs extends abc {

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f344d = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f345f = null;

    /* renamed from: e */
    String f346e;

    static {
        m350m();
    }

    /* renamed from: m */
    private static /* synthetic */ void m350m() {
        cdj cdj = new cdj("Utf8AppleDataBox.java", acs.class);
        f344d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "", "", "", "java.lang.String"), 21);
        f345f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "java.lang.String", "value", "", "void"), 30);
    }

    protected acs(String str) {
        super(str, 1);
    }

    /* renamed from: a */
    public String mo109a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f344d, (Object) this, (Object) this));
        if (!mo6121x()) {
            mo6120v();
        }
        return this.f346e;
    }

    /* renamed from: a */
    public void mo230a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f345f, (Object) this, (Object) this, (Object) str));
        this.f346e = str;
    }

    @C1016xa
    /* renamed from: b */
    public byte[] mo111b() {
        return C0684np.m12528a(this.f346e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo36c() {
        return this.f346e.getBytes(Charset.forName("UTF-8")).length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        this.f346e = C0679nk.m12494a(byteBuffer, byteBuffer.remaining());
    }
}
