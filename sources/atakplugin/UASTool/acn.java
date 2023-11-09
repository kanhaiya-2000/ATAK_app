package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.List;

public class acn extends C1002wn implements C0695nz, C0797rh {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f284A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f285B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f286C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f287D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f288E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f289F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f290G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f291H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f292I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f293J = null;

    /* renamed from: K */
    private static final /* synthetic */ can.C0296b f294K = null;

    /* renamed from: L */
    private static final /* synthetic */ can.C0296b f295L = null;

    /* renamed from: M */
    private static final /* synthetic */ can.C0296b f296M = null;

    /* renamed from: N */
    private static final /* synthetic */ can.C0296b f297N = null;

    /* renamed from: a */
    public static final String f298a = "tmcd";

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f299r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f300s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f301t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f302u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f303v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f304w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f305x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f306y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f307z = null;

    /* renamed from: b */
    int f308b;

    /* renamed from: c */
    int f309c;

    /* renamed from: d */
    int f310d;

    /* renamed from: e */
    int f311e;

    /* renamed from: f */
    int f312f;

    /* renamed from: o */
    long f313o;

    /* renamed from: p */
    int f314p;

    /* renamed from: q */
    byte[] f315q = new byte[0];

    static {
        m296o();
    }

    /* renamed from: o */
    private static /* synthetic */ void m296o() {
        cdj cdj = new cdj("TimeCodeBox.java", acn.class);
        f299r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 88);
        f300s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "dataReferenceIndex", "", "void"), 92);
        f285B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved1", "", "void"), 137);
        f286C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 141);
        f287D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved2", "", "void"), 145);
        f288E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "long"), 149);
        f289F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long", "flags", "", "void"), 153);
        f290G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "[B"), 157);
        f291H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "[B", "rest", "", "void"), 161);
        f292I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.util.List"), 166);
        f293J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.util.List", "boxes", "", "void"), 170);
        f294K = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class", "clazz", "", "java.util.List"), 174);
        f301t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.lang.String"), 98);
        f295L = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class:boolean", "clazz:recursive", "", "java.util.List"), 178);
        f296M = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getByteBuffer", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long:long", "start:size", "java.io.IOException", "java.nio.ByteBuffer"), 182);
        f297N = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "writeContainer", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.nio.channels.WritableByteChannel", "bb", "java.io.IOException", "void"), 186);
        f302u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 109);
        f303v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "timeScale", "", "void"), 113);
        f304w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 117);
        f305x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "frameDuration", "", "void"), 121);
        f306y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 125);
        f307z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "numberOfFrames", "", "void"), 129);
        f284A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 133);
    }

    public acn() {
        super(f298a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (this.f315q.length + 28);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[6]);
        C0681nm.m12514b(byteBuffer, this.f314p);
        byteBuffer.putInt(this.f311e);
        C0681nm.m12515b(byteBuffer, this.f313o);
        byteBuffer.putInt(this.f308b);
        byteBuffer.putInt(this.f309c);
        C0681nm.m12521d(byteBuffer, this.f310d);
        C0681nm.m12510a(byteBuffer, this.f312f);
        byteBuffer.put(this.f315q);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        byteBuffer.position(6);
        this.f314p = C0679nk.m12497d(byteBuffer);
        this.f311e = byteBuffer.getInt();
        this.f313o = C0679nk.m12495b(byteBuffer);
        this.f308b = byteBuffer.getInt();
        this.f309c = byteBuffer.getInt();
        this.f310d = C0679nk.m12499f(byteBuffer);
        this.f312f = C0679nk.m12496c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.f315q = bArr;
        byteBuffer.get(bArr);
    }

    /* renamed from: a */
    public int mo200a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f299r, (Object) this, (Object) this));
        return this.f314p;
    }

    /* renamed from: a */
    public void mo204a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f300s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f314p = i;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f301t, (Object) this, (Object) this));
        return "TimeCodeBox{timeScale=" + this.f308b + ", frameDuration=" + this.f309c + ", numberOfFrames=" + this.f310d + ", reserved1=" + this.f311e + ", reserved2=" + this.f312f + ", flags=" + this.f313o + '}';
    }

    /* renamed from: b */
    public int mo207b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f302u, (Object) this, (Object) this));
        return this.f308b;
    }

    /* renamed from: b */
    public void mo208b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f303v, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f308b = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f304w, (Object) this, (Object) this));
        return this.f309c;
    }

    /* renamed from: c */
    public void mo210c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f305x, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f309c = i;
    }

    /* renamed from: j */
    public int mo214j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f306y, (Object) this, (Object) this));
        return this.f310d;
    }

    /* renamed from: d */
    public void mo211d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f307z, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f310d = i;
    }

    /* renamed from: k */
    public int mo215k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f284A, (Object) this, (Object) this));
        return this.f311e;
    }

    /* renamed from: e */
    public void mo212e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f285B, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f311e = i;
    }

    /* renamed from: l */
    public int mo216l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f286C, (Object) this, (Object) this));
        return this.f312f;
    }

    /* renamed from: f */
    public void mo213f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f287D, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f312f = i;
    }

    /* renamed from: m */
    public long mo217m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f288E, (Object) this, (Object) this));
        return this.f313o;
    }

    /* renamed from: a */
    public void mo205a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f289F, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f313o = j;
    }

    /* renamed from: n */
    public byte[] mo218n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f290G, (Object) this, (Object) this));
        return this.f315q;
    }

    /* renamed from: a */
    public void mo206a(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f291H, (Object) this, (Object) this, (Object) bArr));
        this.f315q = bArr;
    }

    /* renamed from: c */
    public List<C0688nt> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f292I, (Object) this, (Object) this));
        return Collections.emptyList();
    }

    /* renamed from: a */
    public void mo172a(List<C0688nt> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f293J, (Object) this, (Object) this, (Object) list));
        throw new RuntimeException("Time Code Box doesn't accept any children");
    }

    /* renamed from: a */
    public <T extends C0688nt> List<T> mo202a(Class<T> cls) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f294K, (Object) this, (Object) this, (Object) cls));
        return Collections.emptyList();
    }

    /* renamed from: a */
    public <T extends C0688nt> List<T> mo203a(Class<T> cls, boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11378a(f295L, (Object) this, (Object) this, (Object) cls, ccw.m11304a(z)));
        return Collections.emptyList();
    }

    /* renamed from: a */
    public ByteBuffer mo201a(long j, long j2) {
        C1013wy.m14474a().mo6137a(cdj.m11378a(f296M, (Object) this, (Object) this, ccw.m11302a(j), ccw.m11302a(j2)));
        return null;
    }

    /* renamed from: b */
    public void mo209b(WritableByteChannel writableByteChannel) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f297N, (Object) this, (Object) this, (Object) writableByteChannel));
    }
}
