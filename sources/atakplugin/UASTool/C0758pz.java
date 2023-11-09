package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pz */
public class C0758pz extends C1002wn {

    /* renamed from: b */
    public static final String f5795b = "uuid";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5796c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5797d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5798e = null;

    /* renamed from: a */
    byte[] f5799a;

    static {
        m13038b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m13038b() {
        cdj cdj = new cdj("UserBox.java", C0758pz.class);
        f5796c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.UserBox", "", "", "", "java.lang.String"), 40);
        f5797d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getData", "com.coremedia.iso.boxes.UserBox", "", "", "", "[B"), 47);
        f5798e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setData", "com.coremedia.iso.boxes.UserBox", "[B", "data", "", "void"), 51);
    }

    public C0758pz(byte[] bArr) {
        super(f5795b, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) this.f5799a.length;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5796c, (Object) this, (Object) this));
        return "UserBox[type=" + mo1476h() + ";userType=" + new String(mo455w()) + ";contentLength=" + this.f5799a.length + "]";
    }

    /* renamed from: a */
    public byte[] mo5409a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5797d, (Object) this, (Object) this));
        return this.f5799a;
    }

    /* renamed from: a */
    public void mo5408a(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5798e, (Object) this, (Object) this, (Object) bArr));
        this.f5799a = bArr;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.f5799a = bArr;
        byteBuffer.get(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f5799a);
    }
}
