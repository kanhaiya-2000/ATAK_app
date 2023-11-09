package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.google.common.base.Ascii;

public class aef extends aan {

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f642e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f643f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f644o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f645p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f646q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f647r = null;

    static {
        m664p();
    }

    /* renamed from: p */
    private static /* synthetic */ void m664p() {
        cdj cdj = new cdj("PiffSampleEncryptionBox.java", aef.class);
        f642e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 46);
        f643f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "algorithmId", "", "void"), 50);
        f644o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 54);
        f645p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "ivSize", "", "void"), 58);
        f646q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "[B"), 62);
        f647r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "[B", "kid", "", "void"), 66);
    }

    public aef() {
        super(C0758pz.f5795b);
    }

    /* renamed from: w */
    public byte[] mo455w() {
        return new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    }

    /* renamed from: m */
    public int mo452m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f642e, (Object) this, (Object) this));
        return this.f55a;
    }

    /* renamed from: c */
    public void mo450c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f643f, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f55a = i;
    }

    /* renamed from: n */
    public int mo453n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f644o, (Object) this, (Object) this));
        return this.f56b;
    }

    /* renamed from: d */
    public void mo451d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f645p, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f56b = i;
    }

    /* renamed from: o */
    public byte[] mo454o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f646q, (Object) this, (Object) this));
        return this.f57c;
    }

    /* renamed from: a */
    public void mo448a(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f647r, (Object) this, (Object) this, (Object) bArr));
        this.f57c = bArr;
    }

    @C1016xa
    /* renamed from: k */
    public boolean mo53k() {
        return (mo456b_() & 1) > 0;
    }

    @C1016xa
    /* renamed from: b */
    public void mo449b(boolean z) {
        if (z) {
            mo5159b(mo456b_() | 1);
        } else {
            mo5159b(mo456b_() & 16777214);
        }
    }
}
