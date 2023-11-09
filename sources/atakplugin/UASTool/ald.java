package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class ald extends C1002wn {

    /* renamed from: a */
    public static final String f1875a = "svpr";

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f1876f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f1877o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f1878p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f1879q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f1880r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f1881s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f1882t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f1883u = null;

    /* renamed from: b */
    int f1884b = 0;

    /* renamed from: c */
    int f1885c;

    /* renamed from: d */
    int f1886d = 0;

    /* renamed from: e */
    int f1887e;

    static {
        m2161j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m2161j() {
        cdj cdj = new cdj("PriotityRangeBox.java", ald.class);
        f1876f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved1", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 45);
        f1877o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved1", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "reserved1", "", "void"), 49);
        f1878p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMin_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 53);
        f1879q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMin_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "min_priorityId", "", "void"), 57);
        f1880r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved2", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 61);
        f1881s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved2", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "reserved2", "", "void"), 65);
        f1882t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMax_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 69);
        f1883u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMax_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "max_priorityId", "", "void"), 73);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 2;
    }

    public ald() {
        super(f1875a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C0681nm.m12521d(byteBuffer, (this.f1884b << 6) + this.f1885c);
        C0681nm.m12521d(byteBuffer, (this.f1886d << 6) + this.f1887e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        int f = C0679nk.m12499f(byteBuffer);
        this.f1885c = f;
        this.f1884b = (f & 192) >> 6;
        this.f1885c = f & 63;
        int f2 = C0679nk.m12499f(byteBuffer);
        this.f1887e = f2;
        this.f1886d = (f2 & 192) >> 6;
        this.f1887e = f2 & 63;
    }

    /* renamed from: a */
    public int mo1317a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1876f, (Object) this, (Object) this));
        return this.f1884b;
    }

    /* renamed from: a */
    public void mo1318a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1877o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1884b = i;
    }

    /* renamed from: b */
    public int mo1319b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1878p, (Object) this, (Object) this));
        return this.f1885c;
    }

    /* renamed from: b */
    public void mo1320b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1879q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1885c = i;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1880r, (Object) this, (Object) this));
        return this.f1886d;
    }

    /* renamed from: c */
    public void mo1321c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1881s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1886d = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1882t, (Object) this, (Object) this));
        return this.f1887e;
    }

    /* renamed from: d */
    public void mo1322d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1883u, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1887e = i;
    }
}
