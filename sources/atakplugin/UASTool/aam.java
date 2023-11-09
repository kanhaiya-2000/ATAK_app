package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class aam extends C1002wn {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f26A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f27B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f28C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f29D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f30E = null;

    /* renamed from: a */
    public static final String f31a = "dac3";

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f32q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f33r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f34s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f35t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f36u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f37v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f38w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f39x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f40y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f41z = null;

    /* renamed from: b */
    int f42b;

    /* renamed from: c */
    int f43c;

    /* renamed from: d */
    int f44d;

    /* renamed from: e */
    int f45e;

    /* renamed from: f */
    int f46f;

    /* renamed from: o */
    int f47o;

    /* renamed from: p */
    int f48p;

    static {
        m37m();
    }

    /* renamed from: m */
    private static /* synthetic */ void m37m() {
        cdj cdj = new cdj("AC3SpecificBox.java", aam.class);
        f32q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 55);
        f33r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "fscod", "", "void"), 59);
        f26A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 95);
        f27B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bitRateCode", "", "void"), 99);
        f28C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 103);
        f29D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "reserved", "", "void"), 107);
        f30E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "java.lang.String"), 112);
        f34s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 63);
        f35t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsid", "", "void"), 67);
        f36u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 71);
        f37v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsmod", "", "void"), 75);
        f38w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 79);
        f39x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "acmod", "", "void"), 83);
        f40y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 87);
        f41z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "lfeon", "", "void"), 91);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 3;
    }

    public aam() {
        super(f31a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        adi adi = new adi(byteBuffer);
        this.f42b = adi.mo315a(2);
        this.f43c = adi.mo315a(5);
        this.f44d = adi.mo315a(3);
        this.f45e = adi.mo315a(3);
        this.f46f = adi.mo315a(1);
        this.f47o = adi.mo315a(5);
        this.f48p = adi.mo315a(5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        adj adj = new adj(byteBuffer);
        adj.mo320a(this.f42b, 2);
        adj.mo320a(this.f43c, 5);
        adj.mo320a(this.f44d, 3);
        adj.mo320a(this.f45e, 3);
        adj.mo320a(this.f46f, 1);
        adj.mo320a(this.f47o, 5);
        adj.mo320a(this.f48p, 5);
    }

    /* renamed from: a */
    public int mo30a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f32q, (Object) this, (Object) this));
        return this.f42b;
    }

    /* renamed from: a */
    public void mo31a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f33r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f42b = i;
    }

    /* renamed from: b */
    public int mo33b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f34s, (Object) this, (Object) this));
        return this.f43c;
    }

    /* renamed from: b */
    public void mo34b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f35t, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f43c = i;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f36u, (Object) this, (Object) this));
        return this.f44d;
    }

    /* renamed from: c */
    public void mo37c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f37v, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f44d = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f38w, (Object) this, (Object) this));
        return this.f45e;
    }

    /* renamed from: d */
    public void mo39d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f39x, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f45e = i;
    }

    /* renamed from: j */
    public int mo44j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f40y, (Object) this, (Object) this));
        return this.f46f;
    }

    /* renamed from: e */
    public void mo40e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f41z, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f46f = i;
    }

    /* renamed from: k */
    public int mo45k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f26A, (Object) this, (Object) this));
        return this.f47o;
    }

    /* renamed from: f */
    public void mo41f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f27B, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f47o = i;
    }

    /* renamed from: l */
    public int mo46l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f28C, (Object) this, (Object) this));
        return this.f48p;
    }

    /* renamed from: g */
    public void mo42g(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f29D, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f48p = i;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f30E, (Object) this, (Object) this));
        return "AC3SpecificBox{fscod=" + this.f42b + ", bsid=" + this.f43c + ", bsmod=" + this.f44d + ", acmod=" + this.f45e + ", lfeon=" + this.f46f + ", bitRateCode=" + this.f47o + ", reserved=" + this.f48p + '}';
    }
}
