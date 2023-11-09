package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class aci extends C1004wp {

    /* renamed from: a */
    public static final String f224a = "clef";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f225d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f226e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f227f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f228o = null;

    /* renamed from: b */
    double f229b;

    /* renamed from: c */
    double f230c;

    static {
        m223j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m223j() {
        cdj cdj = new cdj("CleanApertureAtom.java", aci.class);
        f225d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getWidth", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "", "", "", "double"), 45);
        f226e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setWidth", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "double", "width", "", "void"), 49);
        f227f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHeight", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "", "", "", "double"), 53);
        f228o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHeight", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "double", "height", "", "void"), 57);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 12;
    }

    public aci() {
        super(f224a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12509a(byteBuffer, this.f229b);
        C0681nm.m12509a(byteBuffer, this.f230c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f229b = C0679nk.m12502i(byteBuffer);
        this.f230c = C0679nk.m12502i(byteBuffer);
    }

    /* renamed from: c */
    public double mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f225d, (Object) this, (Object) this));
        return this.f229b;
    }

    /* renamed from: a */
    public void mo146a(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f226e, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f229b = d;
    }

    /* renamed from: i */
    public double mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f227f, (Object) this, (Object) this));
        return this.f230c;
    }

    /* renamed from: b */
    public void mo147b(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f228o, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f230c = d;
    }
}
