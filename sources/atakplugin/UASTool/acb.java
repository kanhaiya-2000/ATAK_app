package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class acb extends abc {

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f192f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f193o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f194p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f195q = null;

    /* renamed from: d */
    int f196d;

    /* renamed from: e */
    int f197e;

    static {
        m191n();
    }

    /* renamed from: n */
    private static /* synthetic */ void m191n() {
        cdj cdj = new cdj("AppleTrackNumberBox.java", acb.class);
        f192f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 16);
        f193o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "a", "", "void"), 20);
        f194p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 24);
        f195q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "b", "", "void"), 28);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo36c() {
        return 8;
    }

    public acb() {
        super("trkn", 0);
    }

    /* renamed from: a */
    public int mo109a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f192f, (Object) this, (Object) this));
        return this.f196d;
    }

    /* renamed from: c */
    public void mo129c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f193o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f196d = i;
    }

    /* renamed from: m */
    public int mo131m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f194p, (Object) this, (Object) this));
        return this.f197e;
    }

    /* renamed from: d */
    public void mo130d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f195q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f197e = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo111b() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(this.f196d);
        allocate.putInt(this.f197e);
        return allocate.array();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        this.f196d = byteBuffer.getInt();
        this.f197e = byteBuffer.getInt();
    }
}
