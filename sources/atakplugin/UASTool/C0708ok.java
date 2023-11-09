package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.ok */
public class C0708ok extends C1002wn {

    /* renamed from: a */
    public static final String f5458a = "skip";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5459c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5460d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5461e = null;

    /* renamed from: b */
    byte[] f5462b;

    static {
        m12674b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m12674b() {
        cdj cdj = new cdj("FreeSpaceBox.java", C0708ok.class);
        f5459c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setData", "com.coremedia.iso.boxes.FreeSpaceBox", "[B", "data", "", "void"), 42);
        f5460d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getData", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", "[B"), 46);
        f5461e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", "java.lang.String"), 61);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) this.f5462b.length;
    }

    public C0708ok() {
        super(f5458a);
    }

    /* renamed from: a */
    public void mo5186a(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5459c, (Object) this, (Object) this, (Object) bArr));
        this.f5462b = bArr;
    }

    /* renamed from: a */
    public byte[] mo5187a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5460d, (Object) this, (Object) this));
        return this.f5462b;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.f5462b = bArr;
        byteBuffer.get(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f5462b);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5461e, (Object) this, (Object) this));
        return "FreeSpaceBox[size=" + this.f5462b.length + ";type=" + mo1476h() + "]";
    }
}
