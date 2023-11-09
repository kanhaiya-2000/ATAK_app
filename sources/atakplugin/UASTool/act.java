package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.List;

public class act extends C1002wn {

    /* renamed from: a */
    public static final String f347a = "avcn";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f348c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f349d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f350e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f351f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f352o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f353p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f354q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f355r = null;

    /* renamed from: b */
    ala f356b;

    static {
        m356m();
    }

    /* renamed from: m */
    private static /* synthetic */ void m356m() {
        cdj cdj = new cdj("AvcNalUnitStorageBox.java", act.class);
        f348c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvcDecoderConfigurationRecord", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 44);
        f349d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLengthSizeMinusOne", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "int"), 49);
        f350e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 53);
        f351f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 57);
        f352o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSequenceParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 61);
        f353p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSequenceParameterSetExtsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 65);
        f354q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPictureParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 69);
        f355r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.lang.String"), 89);
    }

    public act() {
        super(f347a);
    }

    public act(akz akz) {
        super(f347a);
        this.f356b = akz.mo1233t();
    }

    /* renamed from: a */
    public ala mo231a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f348c, (Object) this, (Object) this));
        return this.f356b;
    }

    /* renamed from: b */
    public int mo232b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f349d, (Object) this, (Object) this));
        return this.f356b.f1807e;
    }

    /* renamed from: c */
    public String[] mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f350e, (Object) this, (Object) this));
        return this.f356b.mo1239c();
    }

    /* renamed from: i */
    public String[] mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f351f, (Object) this, (Object) this));
        return this.f356b.mo1238b();
    }

    /* renamed from: j */
    public List<String> mo233j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f352o, (Object) this, (Object) this));
        return this.f356b.mo1240d();
    }

    /* renamed from: k */
    public List<String> mo234k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f353p, (Object) this, (Object) this));
        return this.f356b.mo1241e();
    }

    /* renamed from: l */
    public List<String> mo235l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f354q, (Object) this, (Object) this));
        return this.f356b.mo1242f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return this.f356b.mo1236a();
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f356b = new ala(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        this.f356b.mo1237a(byteBuffer);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f355r, (Object) this, (Object) this));
        return "AvcNalUnitStorageBox{SPS=" + this.f356b.mo1240d() + ",PPS=" + this.f356b.mo1242f() + ",lengthSize=" + (this.f356b.f1807e + 1) + '}';
    }
}
