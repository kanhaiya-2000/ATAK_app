package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class abg extends C1002wn {

    /* renamed from: a */
    public static final String f178a = "©xyz";

    /* renamed from: d */
    private static final int f179d = 5575;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f180e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f181f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f182o = null;

    /* renamed from: b */
    String f183b;

    /* renamed from: c */
    int f184c = f179d;

    static {
        m175b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m175b() {
        cdj cdj = new cdj("AppleGPSCoordinatesBox.java", abg.class);
        f180e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getValue", "com.googlecode.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "", "", "", "java.lang.String"), 22);
        f181f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setValue", "com.googlecode.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "java.lang.String", "iso6709String", "", "void"), 26);
        f182o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "", "", "", "java.lang.String"), 52);
    }

    public abg() {
        super(f178a);
    }

    /* renamed from: a */
    public String mo123a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f180e, (Object) this, (Object) this));
        return this.f183b;
    }

    /* renamed from: a */
    public void mo124a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f181f, (Object) this, (Object) this, (Object) str));
        this.f184c = f179d;
        this.f183b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f183b) + 4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) this.f183b.length());
        byteBuffer.putShort((short) this.f184c);
        byteBuffer.put(C0684np.m12528a(this.f183b));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        int i = byteBuffer.getShort();
        this.f184c = byteBuffer.getShort();
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        this.f183b = C0684np.m12527a(bArr);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f182o, (Object) this, (Object) this));
        return "AppleGPSCoordinatesBox[" + this.f183b + "]";
    }
}
