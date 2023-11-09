package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qo */
public class C0775qo extends C1004wp {

    /* renamed from: a */
    public static final String f5875a = "mfhd";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5876c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5877d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5878e = null;

    /* renamed from: b */
    private long f5879b;

    static {
        m13123i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13123i() {
        cdj cdj = new cdj("MovieFragmentHeaderBox.java", C0775qo.class);
        f5876c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSequenceNumber", "com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox", "", "", "", "long"), 59);
        f5877d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSequenceNumber", "com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox", "long", "sequenceNumber", "", "void"), 63);
        f5878e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox", "", "", "", "java.lang.String"), 68);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 8;
    }

    public C0775qo() {
        super(f5875a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5879b);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5879b = C0679nk.m12495b(byteBuffer);
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5876c, (Object) this, (Object) this));
        return this.f5879b;
    }

    /* renamed from: a */
    public void mo5452a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5877d, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5879b = j;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5878e, (Object) this, (Object) this));
        return "MovieFragmentHeaderBox{sequenceNumber=" + this.f5879b + '}';
    }
}
