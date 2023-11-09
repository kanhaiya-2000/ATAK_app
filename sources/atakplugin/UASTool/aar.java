package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class aar extends C1002wn {

    /* renamed from: a */
    public static final String f141a = "dmlp";

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f142f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f143o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f144p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f145q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f146r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f147s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f148t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f149u = null;

    /* renamed from: b */
    int f150b;

    /* renamed from: c */
    int f151c;

    /* renamed from: d */
    int f152d;

    /* renamed from: e */
    int f153e;

    static {
        m127j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m127j() {
        cdj cdj = new cdj("MLPSpecificBox.java", aar.class);
        f142f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFormat_info", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 49);
        f143o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFormat_info", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "format_info", "", "void"), 53);
        f144p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPeak_data_rate", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 57);
        f145q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPeak_data_rate", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "peak_data_rate", "", "void"), 61);
        f146r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 65);
        f147s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "reserved", "", "void"), 69);
        f148t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved2", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 73);
        f149u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved2", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "reserved2", "", "void"), 77);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 10;
    }

    public aar() {
        super(f141a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        adi adi = new adi(byteBuffer);
        this.f150b = adi.mo315a(32);
        this.f151c = adi.mo315a(15);
        this.f152d = adi.mo315a(1);
        this.f153e = adi.mo315a(32);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        adj adj = new adj(byteBuffer);
        adj.mo320a(this.f150b, 32);
        adj.mo320a(this.f151c, 15);
        adj.mo320a(this.f152d, 1);
        adj.mo320a(this.f153e, 32);
    }

    /* renamed from: a */
    public int mo99a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f142f, (Object) this, (Object) this));
        return this.f150b;
    }

    /* renamed from: a */
    public void mo100a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f143o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f150b = i;
    }

    /* renamed from: b */
    public int mo101b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f144p, (Object) this, (Object) this));
        return this.f151c;
    }

    /* renamed from: b */
    public void mo102b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f145q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f151c = i;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f146r, (Object) this, (Object) this));
        return this.f152d;
    }

    /* renamed from: c */
    public void mo103c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f147s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f152d = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f148t, (Object) this, (Object) this));
        return this.f153e;
    }

    /* renamed from: d */
    public void mo104d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f149u, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f153e = i;
    }
}
