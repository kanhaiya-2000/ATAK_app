package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.rc */
public class C0792rc extends C1002wn {

    /* renamed from: a */
    public static final String f6019a = "damr";

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f6020o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f6021p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f6022q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f6023r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f6024s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f6025t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f6026u = null;

    /* renamed from: b */
    private String f6027b;

    /* renamed from: c */
    private int f6028c;

    /* renamed from: d */
    private int f6029d;

    /* renamed from: e */
    private int f6030e;

    /* renamed from: f */
    private int f6031f;

    static {
        m13298k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m13298k() {
        cdj cdj = new cdj("AmrSpecificBox.java", C0792rc.class);
        f6020o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getVendor", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 46);
        f6021p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDecoderVersion", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 50);
        f6022q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getModeSet", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 54);
        f6023r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getModeChangePeriod", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 58);
        f6024s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFramesPerSample", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 62);
        f6025t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContent", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 84);
        f6026u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 92);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 9;
    }

    public C0792rc() {
        super(f6019a);
    }

    /* renamed from: a */
    public String mo5569a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6020o, (Object) this, (Object) this));
        return this.f6027b;
    }

    /* renamed from: b */
    public int mo5570b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6021p, (Object) this, (Object) this));
        return this.f6028c;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6022q, (Object) this, (Object) this));
        return this.f6029d;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6023r, (Object) this, (Object) this));
        return this.f6030e;
    }

    /* renamed from: j */
    public int mo5571j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6024s, (Object) this, (Object) this));
        return this.f6031f;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.f6027b = C0678nj.m12487a(bArr);
        this.f6028c = C0679nk.m12499f(byteBuffer);
        this.f6029d = C0679nk.m12497d(byteBuffer);
        this.f6030e = C0679nk.m12499f(byteBuffer);
        this.f6031f = C0679nk.m12499f(byteBuffer);
    }

    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6025t, (Object) this, (Object) this, (Object) byteBuffer));
        byteBuffer.put(C0678nj.m12488a(this.f6027b));
        C0681nm.m12521d(byteBuffer, this.f6028c);
        C0681nm.m12514b(byteBuffer, this.f6029d);
        C0681nm.m12521d(byteBuffer, this.f6030e);
        C0681nm.m12521d(byteBuffer, this.f6031f);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6026u, (Object) this, (Object) this));
        return "AmrSpecificBox[vendor=" + mo5569a() + ";decoderVersion=" + mo5570b() + ";modeSet=" + mo36c() + ";modeChangePeriod=" + mo43i() + ";framesPerSample=" + mo5571j() + "]";
    }
}
