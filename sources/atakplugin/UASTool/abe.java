package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class abe extends abc {

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f172f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f173o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f174p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f175q = null;

    /* renamed from: d */
    int f176d;

    /* renamed from: e */
    short f177e;

    static {
        m167n();
    }

    /* renamed from: n */
    private static /* synthetic */ void m167n() {
        cdj cdj = new cdj("AppleDiskNumberBox.java", abe.class);
        f172f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getA", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "", "", "", "int"), 16);
        f173o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setA", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "int", "a", "", "void"), 20);
        f174p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getB", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "", "", "", "short"), 24);
        f175q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setB", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "short", "b", "", "void"), 28);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo36c() {
        return 6;
    }

    public abe() {
        super("disk", 0);
    }

    /* renamed from: a */
    public int mo109a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f172f, (Object) this, (Object) this));
        return this.f176d;
    }

    /* renamed from: c */
    public void mo121c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f173o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f176d = i;
    }

    /* renamed from: m */
    public short mo122m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f174p, (Object) this, (Object) this));
        return this.f177e;
    }

    /* renamed from: a */
    public void mo120a(short s) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f175q, (Object) this, (Object) this, ccw.m11303a(s)));
        this.f177e = s;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo111b() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.putInt(this.f176d);
        allocate.putShort(this.f177e);
        return allocate.array();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        this.f176d = byteBuffer.getInt();
        this.f177e = byteBuffer.getShort();
    }
}
