package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pa */
public final class C0727pa extends C1004wp {

    /* renamed from: a */
    public static final String f5609a = "odaf";

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5610f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5611o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5612p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5613q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5614r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5615s = null;

    /* renamed from: b */
    private boolean f5616b;

    /* renamed from: c */
    private byte f5617c;

    /* renamed from: d */
    private int f5618d;

    /* renamed from: e */
    private int f5619e;

    static {
        m12822k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m12822k() {
        cdj cdj = new cdj("OmaDrmAccessUnitFormatBox.java", C0727pa.class);
        f5610f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isSelectiveEncryption", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "boolean"), 46);
        f5611o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 50);
        f5612p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 54);
        f5613q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "initVectorLength", "", "void"), 58);
        f5614r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "keyIndicatorLength", "", "void"), 62);
        f5615s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAllBits", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "byte", "allBits", "", "void"), 66);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 7;
    }

    public C0727pa() {
        super(f5609a);
    }

    /* renamed from: c */
    public boolean mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5610f, (Object) this, (Object) this));
        return this.f5616b;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5611o, (Object) this, (Object) this));
        return this.f5618d;
    }

    /* renamed from: j */
    public int mo5279j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5612p, (Object) this, (Object) this));
        return this.f5619e;
    }

    /* renamed from: c */
    public void mo5277c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5613q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5619e = i;
    }

    /* renamed from: d */
    public void mo5278d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5614r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5618d = i;
    }

    /* renamed from: a */
    public void mo5276a(byte b) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5615s, (Object) this, (Object) this, ccw.m11297a(b)));
        this.f5617c = b;
        this.f5616b = (b & 128) == 128;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        byte f = (byte) C0679nk.m12499f(byteBuffer);
        this.f5617c = f;
        this.f5616b = (f & 128) == 128;
        this.f5618d = C0679nk.m12499f(byteBuffer);
        this.f5619e = C0679nk.m12499f(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12521d(byteBuffer, (int) this.f5617c);
        C0681nm.m12521d(byteBuffer, this.f5618d);
        C0681nm.m12521d(byteBuffer, this.f5619e);
    }
}
