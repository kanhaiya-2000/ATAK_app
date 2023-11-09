package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qm */
public class C0773qm extends C1004wp {

    /* renamed from: a */
    public static final String f5870a = "mehd";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5871c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5872d = null;

    /* renamed from: b */
    private long f5873b;

    static {
        m13111i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13111i() {
        cdj cdj = new cdj("MovieExtendsHeaderBox.java", C0773qm.class);
        f5871c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFragmentDuration", "com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox", "", "", "", "long"), 65);
        f5872d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFragmentDuration", "com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox", "long", "fragmentDuration", "", "void"), 69);
    }

    public C0773qm() {
        super(f5870a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (mo5157a_() == 1 ? 12 : 8);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5873b = mo5157a_() == 1 ? C0679nk.m12501h(byteBuffer) : C0679nk.m12495b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (mo5157a_() == 1) {
            C0681nm.m12511a(byteBuffer, this.f5873b);
        } else {
            C0681nm.m12515b(byteBuffer, this.f5873b);
        }
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5871c, (Object) this, (Object) this));
        return this.f5873b;
    }

    /* renamed from: a */
    public void mo5445a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5872d, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5873b = j;
    }
}
