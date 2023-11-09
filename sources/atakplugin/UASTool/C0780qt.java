package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qt */
public class C0780qt extends C1004wp {

    /* renamed from: a */
    public static final String f5903a = "trex";

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5904o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5905p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5906q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5907r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5908s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5909t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5910u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5911v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5912w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5913x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5914y = null;

    /* renamed from: b */
    private long f5915b;

    /* renamed from: c */
    private long f5916c;

    /* renamed from: d */
    private long f5917d;

    /* renamed from: e */
    private long f5918e;

    /* renamed from: f */
    private C0778qr f5919f;

    static {
        m13162n();
    }

    /* renamed from: n */
    private static /* synthetic */ void m13162n() {
        cdj cdj = new cdj("TrackExtendsBox.java", C0780qt.class);
        f5904o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 72);
        f5905p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 76);
        f5914y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 112);
        f5906q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 80);
        f5907r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 84);
        f5908s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 88);
        f5909t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleFlagsStr", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "java.lang.String"), 92);
        f5910u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "trackId", "", "void"), 96);
        f5911v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleDescriptionIndex", "", "void"), 100);
        f5912w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleDuration", "", "void"), 104);
        f5913x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleSize", "", "void"), 108);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 24;
    }

    public C0780qt() {
        super(f5903a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5915b);
        C0681nm.m12515b(byteBuffer, this.f5916c);
        C0681nm.m12515b(byteBuffer, this.f5917d);
        C0681nm.m12515b(byteBuffer, this.f5918e);
        this.f5919f.mo5458a(byteBuffer);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5915b = C0679nk.m12495b(byteBuffer);
        this.f5916c = C0679nk.m12495b(byteBuffer);
        this.f5917d = C0679nk.m12495b(byteBuffer);
        this.f5918e = C0679nk.m12495b(byteBuffer);
        this.f5919f = new C0778qr(byteBuffer);
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5904o, (Object) this, (Object) this));
        return this.f5915b;
    }

    /* renamed from: i */
    public long mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5905p, (Object) this, (Object) this));
        return this.f5916c;
    }

    /* renamed from: j */
    public long mo5486j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5906q, (Object) this, (Object) this));
        return this.f5917d;
    }

    /* renamed from: k */
    public long mo5487k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5907r, (Object) this, (Object) this));
        return this.f5918e;
    }

    /* renamed from: l */
    public C0778qr mo5488l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5908s, (Object) this, (Object) this));
        return this.f5919f;
    }

    /* renamed from: m */
    public String mo5489m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5909t, (Object) this, (Object) this));
        return this.f5919f.toString();
    }

    /* renamed from: a */
    public void mo5481a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5910u, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5915b = j;
    }

    /* renamed from: b */
    public void mo5483b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5911v, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5916c = j;
    }

    /* renamed from: c */
    public void mo5484c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5912w, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5917d = j;
    }

    /* renamed from: d */
    public void mo5485d(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5913x, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5918e = j;
    }

    /* renamed from: a */
    public void mo5482a(C0778qr qrVar) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5914y, (Object) this, (Object) this, (Object) qrVar));
        this.f5919f = qrVar;
    }
}
