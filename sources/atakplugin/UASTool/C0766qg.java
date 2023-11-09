package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qg */
public final class C0766qg extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f5826A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f5827B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f5828C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f5829D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f5830E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f5831F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f5832G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f5833H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f5834I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f5835J = null;

    /* renamed from: K */
    private static final /* synthetic */ can.C0296b f5836K = null;

    /* renamed from: L */
    private static final /* synthetic */ can.C0296b f5837L = null;

    /* renamed from: M */
    private static final /* synthetic */ can.C0296b f5838M = null;

    /* renamed from: N */
    private static final /* synthetic */ can.C0296b f5839N = null;

    /* renamed from: O */
    private static final /* synthetic */ can.C0296b f5840O = null;

    /* renamed from: P */
    private static final /* synthetic */ can.C0296b f5841P = null;

    /* renamed from: a */
    public static final String f5842a = "alac";

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5843u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5844v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5845w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5846x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5847y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f5848z = null;

    /* renamed from: b */
    private long f5849b;

    /* renamed from: c */
    private int f5850c;

    /* renamed from: d */
    private int f5851d;

    /* renamed from: e */
    private int f5852e;

    /* renamed from: f */
    private int f5853f;

    /* renamed from: o */
    private int f5854o;

    /* renamed from: p */
    private int f5855p;

    /* renamed from: q */
    private int f5856q;

    /* renamed from: r */
    private long f5857r;

    /* renamed from: s */
    private long f5858s;

    /* renamed from: t */
    private long f5859t;

    static {
        m13074s();
    }

    /* renamed from: s */
    private static /* synthetic */ void m13074s() {
        cdj cdj = new cdj("AppleLosslessSpecificBox.java", C0766qg.class);
        f5843u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 34);
        f5844v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMaxSamplePerFrame", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxSamplePerFrame", "", "void"), 38);
        f5830E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 74);
        f5831F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setKModifier", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "kModifier", "", "void"), 78);
        f5832G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 82);
        f5833H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setChannels", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "channels", "", "void"), 86);
        f5834I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 90);
        f5835J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown2", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown2", "", "void"), 94);
        f5836K = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 98);
        f5837L = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMaxCodedFrameSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "maxCodedFrameSize", "", "void"), 102);
        f5838M = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 106);
        f5839N = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBitRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "bitRate", "", "void"), 110);
        f5845w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 42);
        f5840O = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "long"), 114);
        f5841P = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleRate", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleRate", "", "void"), 118);
        f5846x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setUnknown1", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "unknown1", "", "void"), 46);
        f5847y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 50);
        f5848z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleSize", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "sampleSize", "", "void"), 54);
        f5826A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 58);
        f5827B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHistoryMult", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "historyMult", "", "void"), 62);
        f5828C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "", "", "", "int"), 66);
        f5829D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setInitialHistory", "com.coremedia.iso.boxes.apple.AppleLosslessSpecificBox", "int", "initialHistory", "", "void"), 70);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 28;
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5843u, (Object) this, (Object) this));
        return this.f5849b;
    }

    /* renamed from: c */
    public void mo5418c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5844v, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5849b = (long) i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5845w, (Object) this, (Object) this));
        return this.f5850c;
    }

    /* renamed from: d */
    public void mo5419d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5846x, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5850c = i;
    }

    /* renamed from: j */
    public int mo5425j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5847y, (Object) this, (Object) this));
        return this.f5851d;
    }

    /* renamed from: e */
    public void mo5420e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5848z, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5851d = i;
    }

    /* renamed from: k */
    public int mo5427k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5826A, (Object) this, (Object) this));
        return this.f5852e;
    }

    /* renamed from: f */
    public void mo5421f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5827B, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5852e = i;
    }

    /* renamed from: l */
    public int mo5429l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5828C, (Object) this, (Object) this));
        return this.f5853f;
    }

    /* renamed from: g */
    public void mo5422g(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5829D, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5853f = i;
    }

    /* renamed from: m */
    public int mo5431m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5830E, (Object) this, (Object) this));
        return this.f5854o;
    }

    /* renamed from: h */
    public void mo5423h(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5831F, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5854o = i;
    }

    /* renamed from: n */
    public int mo5433n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5832G, (Object) this, (Object) this));
        return this.f5855p;
    }

    /* renamed from: i */
    public void mo5424i(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5833H, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5855p = i;
    }

    /* renamed from: o */
    public int mo5434o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5834I, (Object) this, (Object) this));
        return this.f5856q;
    }

    /* renamed from: j */
    public void mo5426j(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5835J, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5856q = i;
    }

    /* renamed from: p */
    public long mo5435p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5836K, (Object) this, (Object) this));
        return this.f5857r;
    }

    /* renamed from: k */
    public void mo5428k(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5837L, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5857r = (long) i;
    }

    /* renamed from: q */
    public long mo5436q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5838M, (Object) this, (Object) this));
        return this.f5858s;
    }

    /* renamed from: l */
    public void mo5430l(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5839N, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5858s = (long) i;
    }

    /* renamed from: r */
    public long mo5437r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5840O, (Object) this, (Object) this));
        return this.f5859t;
    }

    /* renamed from: m */
    public void mo5432m(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5841P, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5859t = (long) i;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5849b = C0679nk.m12495b(byteBuffer);
        this.f5850c = C0679nk.m12499f(byteBuffer);
        this.f5851d = C0679nk.m12499f(byteBuffer);
        this.f5852e = C0679nk.m12499f(byteBuffer);
        this.f5853f = C0679nk.m12499f(byteBuffer);
        this.f5854o = C0679nk.m12499f(byteBuffer);
        this.f5855p = C0679nk.m12499f(byteBuffer);
        this.f5856q = C0679nk.m12497d(byteBuffer);
        this.f5857r = C0679nk.m12495b(byteBuffer);
        this.f5858s = C0679nk.m12495b(byteBuffer);
        this.f5859t = C0679nk.m12495b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5849b);
        C0681nm.m12521d(byteBuffer, this.f5850c);
        C0681nm.m12521d(byteBuffer, this.f5851d);
        C0681nm.m12521d(byteBuffer, this.f5852e);
        C0681nm.m12521d(byteBuffer, this.f5853f);
        C0681nm.m12521d(byteBuffer, this.f5854o);
        C0681nm.m12521d(byteBuffer, this.f5855p);
        C0681nm.m12514b(byteBuffer, this.f5856q);
        C0681nm.m12515b(byteBuffer, this.f5857r);
        C0681nm.m12515b(byteBuffer, this.f5858s);
        C0681nm.m12515b(byteBuffer, this.f5859t);
    }

    public C0766qg() {
        super("alac");
    }
}
