package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qq */
public class C0777qq extends C1004wp {

    /* renamed from: a */
    public static final String f5881a = "mfro";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5882c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5883d = null;

    /* renamed from: b */
    private long f5884b;

    static {
        m13129i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13129i() {
        cdj cdj = new cdj("MovieFragmentRandomAccessOffsetBox.java", C0777qq.class);
        f5882c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMfraSize", "com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox", "", "", "", "long"), 56);
        f5883d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMfraSize", "com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox", "long", "mfraSize", "", "void"), 60);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 8;
    }

    public C0777qq() {
        super(f5881a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5884b = C0679nk.m12495b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5884b);
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5882c, (Object) this, (Object) this));
        return this.f5884b;
    }

    /* renamed from: a */
    public void mo5454a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5883d, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5884b = j;
    }
}
