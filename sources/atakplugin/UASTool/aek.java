package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.UUID;

public class aek extends C1004wp {

    /* renamed from: a */
    public static byte[] f661a = {-48, -118, 79, Ascii.CAN, 16, -13, 74, -126, -74, -56, 50, -40, -85, -95, -125, -45};

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f662d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f663e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f664f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f665o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f666p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f667q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f668r = null;

    /* renamed from: b */
    UUID f669b;

    /* renamed from: c */
    aeh f670c;

    /* renamed from: l */
    private static /* synthetic */ void m697l() {
        cdj cdj = new cdj("UuidBasedProtectionSystemSpecificHeaderBox.java", aek.class);
        f662d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSystemId", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.util.UUID"), 67);
        f663e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSystemId", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "java.util.UUID", "systemId", "", "void"), 71);
        f664f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSystemIdString", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 75);
        f665o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getProtectionSpecificHeader", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader"), 79);
        f666p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getProtectionSpecificHeaderString", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 83);
        f667q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setProtectionSpecificHeader", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader", "protectionSpecificHeader", "", "void"), 87);
        f668r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 92);
    }

    static {
        m697l();
    }

    public aek() {
        super(C0758pz.f5795b, f661a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (this.f670c.mo459b().limit() + 24);
    }

    /* renamed from: w */
    public byte[] mo455w() {
        return f661a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12511a(byteBuffer, this.f669b.getMostSignificantBits());
        C0681nm.m12511a(byteBuffer, this.f669b.getLeastSignificantBits());
        ByteBuffer b = this.f670c.mo459b();
        b.rewind();
        C0681nm.m12515b(byteBuffer, (long) b.limit());
        byteBuffer.put(b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.f669b = afw.m895a(bArr);
        afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f670c = aeh.m677a(this.f669b, byteBuffer);
    }

    /* renamed from: c */
    public UUID mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f662d, (Object) this, (Object) this));
        return this.f669b;
    }

    /* renamed from: a */
    public void mo467a(UUID uuid) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f663e, (Object) this, (Object) this, (Object) uuid));
        this.f669b = uuid;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f664f, (Object) this, (Object) this));
        return this.f669b.toString();
    }

    /* renamed from: j */
    public aeh mo468j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f665o, (Object) this, (Object) this));
        return this.f670c;
    }

    /* renamed from: k */
    public String mo469k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f666p, (Object) this, (Object) this));
        return this.f670c.toString();
    }

    /* renamed from: a */
    public void mo466a(aeh aeh) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f667q, (Object) this, (Object) this, (Object) aeh));
        this.f670c = aeh;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f668r, (Object) this, (Object) this));
        return "UuidBasedProtectionSystemSpecificHeaderBox" + "{systemId=" + this.f669b.toString() + ", dataSize=" + this.f670c.mo459b().limit() + '}';
    }
}
