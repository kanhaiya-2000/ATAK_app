package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qc */
public class C0762qc extends C1004wp {

    /* renamed from: b */
    public static final String f5810b = "xml ";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5811c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5812d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5813e = null;

    /* renamed from: a */
    String f5814a = "";

    static {
        m13056i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13056i() {
        cdj cdj = new cdj("XmlBox.java", C0762qc.class);
        f5811c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getXml", "com.coremedia.iso.boxes.XmlBox", "", "", "", "java.lang.String"), 20);
        f5812d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setXml", "com.coremedia.iso.boxes.XmlBox", "java.lang.String", "xml", "", "void"), 24);
        f5813e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.XmlBox", "", "", "", "java.lang.String"), 46);
    }

    public C0762qc() {
        super(f5810b);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5811c, (Object) this, (Object) this));
        return this.f5814a;
    }

    /* renamed from: a */
    public void mo5415a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5812d, (Object) this, (Object) this, (Object) str));
        this.f5814a = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5814a) + 4);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5814a = C0679nk.m12494a(byteBuffer, byteBuffer.remaining());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0684np.m12528a(this.f5814a));
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5813e, (Object) this, (Object) this));
        return "XmlBox{xml='" + this.f5814a + '\'' + '}';
    }
}
