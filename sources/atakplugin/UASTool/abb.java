package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class abb extends abc {

    /* renamed from: d */
    private static final int f156d = 13;

    /* renamed from: e */
    private static final int f157e = 14;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f158o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f159p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f160q = null;

    /* renamed from: f */
    private byte[] f161f;

    static {
        m145m();
    }

    /* renamed from: m */
    private static /* synthetic */ void m145m() {
        cdj cdj = new cdj("AppleCoverBox.java", abb.class);
        f158o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCoverData", "com.googlecode.mp4parser.boxes.apple.AppleCoverBox", "", "", "", "[B"), 21);
        f159p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setJpg", "com.googlecode.mp4parser.boxes.apple.AppleCoverBox", "[B", "data", "", "void"), 25);
        f160q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPng", "com.googlecode.mp4parser.boxes.apple.AppleCoverBox", "[B", "data", "", "void"), 29);
    }

    public abb() {
        super("covr", 1);
    }

    /* renamed from: a */
    public byte[] mo109a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f158o, (Object) this, (Object) this));
        return this.f161f;
    }

    /* renamed from: a */
    public void mo108a(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f159p, (Object) this, (Object) this, (Object) bArr));
        m144a(bArr, 13);
    }

    /* renamed from: b */
    public void mo110b(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f160q, (Object) this, (Object) this, (Object) bArr));
        m144a(bArr, 14);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo111b() {
        return this.f161f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.limit()];
        this.f161f = bArr;
        byteBuffer.get(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo36c() {
        return this.f161f.length;
    }

    /* renamed from: a */
    private void m144a(byte[] bArr, int i) {
        this.f161f = bArr;
        this.f169a = i;
    }
}
