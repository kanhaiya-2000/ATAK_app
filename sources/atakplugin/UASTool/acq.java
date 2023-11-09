package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class acq extends C1002wn {

    /* renamed from: a */
    public static final String f324a = "load";

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f325f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f326o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f327p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f328q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f329r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f330s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f331t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f332u = null;

    /* renamed from: b */
    int f333b;

    /* renamed from: c */
    int f334c;

    /* renamed from: d */
    int f335d;

    /* renamed from: e */
    int f336e;

    static {
        m330j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m330j() {
        cdj cdj = new cdj("TrackLoadSettingsAtom.java", acq.class);
        f325f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPreloadStartTime", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 49);
        f326o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPreloadStartTime", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadStartTime", "", "void"), 53);
        f327p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPreloadDuration", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 57);
        f328q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPreloadDuration", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadDuration", "", "void"), 61);
        f329r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPreloadFlags", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 65);
        f330s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPreloadFlags", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadFlags", "", "void"), 69);
        f331t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultHints", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 73);
        f332u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultHints", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "defaultHints", "", "void"), 77);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 16;
    }

    public acq() {
        super(f324a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f333b);
        byteBuffer.putInt(this.f334c);
        byteBuffer.putInt(this.f335d);
        byteBuffer.putInt(this.f336e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f333b = byteBuffer.getInt();
        this.f334c = byteBuffer.getInt();
        this.f335d = byteBuffer.getInt();
        this.f336e = byteBuffer.getInt();
    }

    /* renamed from: a */
    public int mo222a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f325f, (Object) this, (Object) this));
        return this.f333b;
    }

    /* renamed from: a */
    public void mo223a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f326o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f333b = i;
    }

    /* renamed from: b */
    public int mo224b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f327p, (Object) this, (Object) this));
        return this.f334c;
    }

    /* renamed from: b */
    public void mo225b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f328q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f334c = i;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f329r, (Object) this, (Object) this));
        return this.f335d;
    }

    /* renamed from: c */
    public void mo226c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f330s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f335d = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f331t, (Object) this, (Object) this));
        return this.f336e;
    }

    /* renamed from: d */
    public void mo227d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f332u, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f336e = i;
    }
}
