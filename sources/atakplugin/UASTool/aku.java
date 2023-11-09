package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public final class aku extends C1002wn {

    /* renamed from: a */
    public static final String f1727a = "btrt";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f1728e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f1729f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f1730o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f1731p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f1732q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f1733r = null;

    /* renamed from: b */
    private long f1734b;

    /* renamed from: c */
    private long f1735c;

    /* renamed from: d */
    private long f1736d;

    static {
        m2004i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m2004i() {
        cdj cdj = new cdj("BitRateBox.java", aku.class);
        f1728e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 74);
        f1729f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", "long", "bufferSizeDb", "", "void"), 82);
        f1730o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 90);
        f1731p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "long", "maxBitrate", "", "void"), 98);
        f1732q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 106);
        f1733r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "long", "avgBitrate", "", "void"), 114);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 12;
    }

    public aku() {
        super(f1727a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f1734b = C0679nk.m12495b(byteBuffer);
        this.f1735c = C0679nk.m12495b(byteBuffer);
        this.f1736d = C0679nk.m12495b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C0681nm.m12515b(byteBuffer, this.f1734b);
        C0681nm.m12515b(byteBuffer, this.f1735c);
        C0681nm.m12515b(byteBuffer, this.f1736d);
    }

    /* renamed from: a */
    public long mo1186a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1728e, (Object) this, (Object) this));
        return this.f1734b;
    }

    /* renamed from: a */
    public void mo1187a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1729f, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1734b = j;
    }

    /* renamed from: b */
    public long mo1188b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1730o, (Object) this, (Object) this));
        return this.f1735c;
    }

    /* renamed from: b */
    public void mo1189b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1731p, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1735c = j;
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1732q, (Object) this, (Object) this));
        return this.f1736d;
    }

    /* renamed from: c */
    public void mo1190c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1733r, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1736d = j;
    }
}
