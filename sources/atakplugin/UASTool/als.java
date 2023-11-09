package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class als extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f2026A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f2027B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f2028C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f2029D = null;

    /* renamed from: a */
    public static final String f2030a = "emsg";

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f2031q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f2032r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f2033s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f2034t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f2035u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f2036v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f2037w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f2038x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f2039y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f2040z = null;

    /* renamed from: b */
    String f2041b;

    /* renamed from: c */
    String f2042c;

    /* renamed from: d */
    long f2043d;

    /* renamed from: e */
    long f2044e;

    /* renamed from: f */
    long f2045f;

    /* renamed from: o */
    long f2046o;

    /* renamed from: p */
    byte[] f2047p;

    static {
        m2317o();
    }

    /* renamed from: o */
    private static /* synthetic */ void m2317o() {
        cdj cdj = new cdj("EventMessageBox.java", als.class);
        f2031q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 59);
        f2032r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", "schemeIdUri", "", "void"), 63);
        f2026A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getId", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 99);
        f2027B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setId", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "id", "", "void"), 103);
        f2028C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "[B"), 107);
        f2029D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "[B", "messageData", "", "void"), 111);
        f2033s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getValue", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 67);
        f2034t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setValue", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", "value", "", "void"), 71);
        f2035u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 75);
        f2036v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "timescale", "", "void"), 79);
        f2037w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 83);
        f2038x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "presentationTimeDelta", "", "void"), 87);
        f2039y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 91);
        f2040z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "eventDuration", "", "void"), 95);
    }

    public als() {
        super(f2030a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f2041b = C0679nk.m12500g(byteBuffer);
        this.f2042c = C0679nk.m12500g(byteBuffer);
        this.f2043d = C0679nk.m12495b(byteBuffer);
        this.f2044e = C0679nk.m12495b(byteBuffer);
        this.f2045f = C0679nk.m12495b(byteBuffer);
        this.f2046o = C0679nk.m12495b(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.f2047p = bArr;
        byteBuffer.get(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12523d(byteBuffer, this.f2041b);
        C0681nm.m12523d(byteBuffer, this.f2042c);
        C0681nm.m12515b(byteBuffer, this.f2043d);
        C0681nm.m12515b(byteBuffer, this.f2044e);
        C0681nm.m12515b(byteBuffer, this.f2045f);
        C0681nm.m12515b(byteBuffer, this.f2046o);
        byteBuffer.put(this.f2047p);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f2041b) + 22 + C0684np.m12529b(this.f2042c) + this.f2047p.length);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2031q, (Object) this, (Object) this));
        return this.f2041b;
    }

    /* renamed from: a */
    public void mo1415a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2032r, (Object) this, (Object) this, (Object) str));
        this.f2041b = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2033s, (Object) this, (Object) this));
        return this.f2042c;
    }

    /* renamed from: b */
    public void mo1418b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2034t, (Object) this, (Object) this, (Object) str));
        this.f2042c = str;
    }

    /* renamed from: j */
    public long mo1421j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2035u, (Object) this, (Object) this));
        return this.f2043d;
    }

    /* renamed from: a */
    public void mo1414a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2036v, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f2043d = j;
    }

    /* renamed from: k */
    public long mo1422k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2037w, (Object) this, (Object) this));
        return this.f2044e;
    }

    /* renamed from: b */
    public void mo1417b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2038x, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f2044e = j;
    }

    /* renamed from: l */
    public long mo1423l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2039y, (Object) this, (Object) this));
        return this.f2045f;
    }

    /* renamed from: c */
    public void mo1419c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2040z, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f2045f = j;
    }

    /* renamed from: m */
    public long mo1424m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2026A, (Object) this, (Object) this));
        return this.f2046o;
    }

    /* renamed from: d */
    public void mo1420d(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2027B, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f2046o = j;
    }

    /* renamed from: n */
    public byte[] mo1425n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2028C, (Object) this, (Object) this));
        return this.f2047p;
    }

    /* renamed from: a */
    public void mo1416a(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2029D, (Object) this, (Object) this, (Object) bArr));
        this.f2047p = bArr;
    }
}
