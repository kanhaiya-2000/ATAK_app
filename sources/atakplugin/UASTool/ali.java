package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class ali extends C1002wn {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f1906A = null;

    /* renamed from: a */
    public static final String f1907a = "tibr";

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f1908p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f1909q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f1910r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f1911s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f1912t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f1913u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f1914v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f1915w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f1916x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f1917y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f1918z = null;

    /* renamed from: b */
    long f1919b;

    /* renamed from: c */
    long f1920c;

    /* renamed from: d */
    long f1921d;

    /* renamed from: e */
    long f1922e;

    /* renamed from: f */
    long f1923f;

    /* renamed from: o */
    long f1924o;

    static {
        m2212l();
    }

    /* renamed from: l */
    private static /* synthetic */ void m2212l() {
        cdj cdj = new cdj("TierBitRateBox.java", ali.class);
        f1908p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 52);
        f1909q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "baseBitRate", "", "void"), 56);
        f1918z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTierAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 92);
        f1906A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTierAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "tierAvgBitRate", "", "void"), 96);
        f1910r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 60);
        f1911s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "maxBitRate", "", "void"), 64);
        f1912t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 68);
        f1913u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "avgBitRate", "", "void"), 72);
        f1914v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTierBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 76);
        f1915w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTierBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "tierBaseBitRate", "", "void"), 80);
        f1916x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTierMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 84);
        f1917y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTierMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "tierMaxBitRate", "", "void"), 88);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 24;
    }

    public ali() {
        super(f1907a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C0681nm.m12515b(byteBuffer, this.f1919b);
        C0681nm.m12515b(byteBuffer, this.f1920c);
        C0681nm.m12515b(byteBuffer, this.f1921d);
        C0681nm.m12515b(byteBuffer, this.f1922e);
        C0681nm.m12515b(byteBuffer, this.f1923f);
        C0681nm.m12515b(byteBuffer, this.f1924o);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f1919b = C0679nk.m12495b(byteBuffer);
        this.f1920c = C0679nk.m12495b(byteBuffer);
        this.f1921d = C0679nk.m12495b(byteBuffer);
        this.f1922e = C0679nk.m12495b(byteBuffer);
        this.f1923f = C0679nk.m12495b(byteBuffer);
        this.f1924o = C0679nk.m12495b(byteBuffer);
    }

    /* renamed from: a */
    public long mo1359a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1908p, (Object) this, (Object) this));
        return this.f1919b;
    }

    /* renamed from: a */
    public void mo1360a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1909q, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1919b = j;
    }

    /* renamed from: b */
    public long mo1361b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1910r, (Object) this, (Object) this));
        return this.f1920c;
    }

    /* renamed from: b */
    public void mo1362b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1911s, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1920c = j;
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1912t, (Object) this, (Object) this));
        return this.f1921d;
    }

    /* renamed from: c */
    public void mo1363c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1913u, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1921d = j;
    }

    /* renamed from: i */
    public long mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1914v, (Object) this, (Object) this));
        return this.f1922e;
    }

    /* renamed from: d */
    public void mo1364d(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1915w, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1922e = j;
    }

    /* renamed from: j */
    public long mo1367j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1916x, (Object) this, (Object) this));
        return this.f1923f;
    }

    /* renamed from: e */
    public void mo1365e(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1917y, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1923f = j;
    }

    /* renamed from: k */
    public long mo1368k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1918z, (Object) this, (Object) this));
        return this.f1924o;
    }

    /* renamed from: f */
    public void mo1366f(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1906A, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f1924o = j;
    }
}
