package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.oo */
public class C0712oo extends C0685nq {

    /* renamed from: a */
    public static final String f5486a = "hmhd";

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5487f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5488o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5489p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5490q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5491r = null;

    /* renamed from: b */
    private int f5492b;

    /* renamed from: c */
    private int f5493c;

    /* renamed from: d */
    private long f5494d;

    /* renamed from: e */
    private long f5495e;

    static {
        m12701l();
    }

    /* renamed from: l */
    private static /* synthetic */ void m12701l() {
        cdj cdj = new cdj("HintMediaHeaderBox.java", C0712oo.class);
        f5487f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMaxPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 42);
        f5488o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvgPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 46);
        f5489p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMaxBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 50);
        f5490q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvgBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 54);
        f5491r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "java.lang.String"), 84);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 20;
    }

    public C0712oo() {
        super(f5486a);
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5487f, (Object) this, (Object) this));
        return this.f5492b;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5488o, (Object) this, (Object) this));
        return this.f5493c;
    }

    /* renamed from: j */
    public long mo5196j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5489p, (Object) this, (Object) this));
        return this.f5494d;
    }

    /* renamed from: k */
    public long mo5197k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5490q, (Object) this, (Object) this));
        return this.f5495e;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5492b = C0679nk.m12497d(byteBuffer);
        this.f5493c = C0679nk.m12497d(byteBuffer);
        this.f5494d = C0679nk.m12495b(byteBuffer);
        this.f5495e = C0679nk.m12495b(byteBuffer);
        C0679nk.m12495b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12514b(byteBuffer, this.f5492b);
        C0681nm.m12514b(byteBuffer, this.f5493c);
        C0681nm.m12515b(byteBuffer, this.f5494d);
        C0681nm.m12515b(byteBuffer, this.f5495e);
        C0681nm.m12515b(byteBuffer, 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5491r, (Object) this, (Object) this));
        return "HintMediaHeaderBox{maxPduSize=" + this.f5492b + ", avgPduSize=" + this.f5493c + ", maxBitrate=" + this.f5494d + ", avgBitrate=" + this.f5495e + '}';
    }
}
