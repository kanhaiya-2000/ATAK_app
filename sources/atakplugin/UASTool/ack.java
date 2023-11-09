package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;

public class ack extends C1002wn {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f232A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f233B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f234C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f235D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f236E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f237F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f238G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f239H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f240I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f241J = null;

    /* renamed from: a */
    public static final String f242a = "text";

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f243s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f244t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f245u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f246v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f247w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f248x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f249y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f250z = null;

    /* renamed from: b */
    int f251b = 65536;

    /* renamed from: c */
    int f252c;

    /* renamed from: d */
    int f253d;

    /* renamed from: e */
    int f254e;

    /* renamed from: f */
    int f255f = 65536;

    /* renamed from: o */
    int f256o;

    /* renamed from: p */
    int f257p;

    /* renamed from: q */
    int f258q;

    /* renamed from: r */
    int f259r = Ints.MAX_POWER_OF_TWO;

    static {
        m231o();
    }

    /* renamed from: o */
    private static /* synthetic */ void m231o() {
        cdj cdj = new cdj("GenericMediaHeaderTextAtom.java", ack.class);
        f243s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_1", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 60);
        f244t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_1", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_1", "", "void"), 64);
        f234C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_6", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 100);
        f235D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_6", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_6", "", "void"), 104);
        f236E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_7", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 108);
        f237F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_7", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_7", "", "void"), 112);
        f238G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_8", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 116);
        f239H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_8", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_8", "", "void"), 120);
        f240I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_9", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 124);
        f241J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_9", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_9", "", "void"), 128);
        f245u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_2", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 68);
        f246v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_2", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_2", "", "void"), 72);
        f247w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_3", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 76);
        f248x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_3", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_3", "", "void"), 80);
        f249y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_4", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 84);
        f250z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_4", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_4", "", "void"), 88);
        f232A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown_5", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "", "", "", "int"), 92);
        f233B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown_5", "com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom", "int", "unknown_5", "", "void"), 96);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 36;
    }

    public ack() {
        super("text");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f251b);
        byteBuffer.putInt(this.f252c);
        byteBuffer.putInt(this.f253d);
        byteBuffer.putInt(this.f254e);
        byteBuffer.putInt(this.f255f);
        byteBuffer.putInt(this.f256o);
        byteBuffer.putInt(this.f257p);
        byteBuffer.putInt(this.f258q);
        byteBuffer.putInt(this.f259r);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f251b = byteBuffer.getInt();
        this.f252c = byteBuffer.getInt();
        this.f253d = byteBuffer.getInt();
        this.f254e = byteBuffer.getInt();
        this.f255f = byteBuffer.getInt();
        this.f256o = byteBuffer.getInt();
        this.f257p = byteBuffer.getInt();
        this.f258q = byteBuffer.getInt();
        this.f259r = byteBuffer.getInt();
    }

    /* renamed from: a */
    public int mo148a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f243s, (Object) this, (Object) this));
        return this.f251b;
    }

    /* renamed from: a */
    public void mo149a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f244t, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f251b = i;
    }

    /* renamed from: b */
    public int mo150b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f245u, (Object) this, (Object) this));
        return this.f252c;
    }

    /* renamed from: b */
    public void mo151b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f246v, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f252c = i;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f247w, (Object) this, (Object) this));
        return this.f253d;
    }

    /* renamed from: c */
    public void mo152c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f248x, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f253d = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f249y, (Object) this, (Object) this));
        return this.f254e;
    }

    /* renamed from: d */
    public void mo153d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f250z, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f254e = i;
    }

    /* renamed from: j */
    public int mo159j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f232A, (Object) this, (Object) this));
        return this.f255f;
    }

    /* renamed from: e */
    public void mo154e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f233B, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f255f = i;
    }

    /* renamed from: k */
    public int mo160k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f234C, (Object) this, (Object) this));
        return this.f256o;
    }

    /* renamed from: f */
    public void mo155f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f235D, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f256o = i;
    }

    /* renamed from: l */
    public int mo161l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f236E, (Object) this, (Object) this));
        return this.f257p;
    }

    /* renamed from: g */
    public void mo156g(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f237F, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f257p = i;
    }

    /* renamed from: m */
    public int mo162m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f238G, (Object) this, (Object) this));
        return this.f258q;
    }

    /* renamed from: h */
    public void mo157h(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f239H, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f258q = i;
    }

    /* renamed from: n */
    public int mo163n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f240I, (Object) this, (Object) this));
        return this.f259r;
    }

    /* renamed from: i */
    public void mo158i(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f241J, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f259r = i;
    }
}
