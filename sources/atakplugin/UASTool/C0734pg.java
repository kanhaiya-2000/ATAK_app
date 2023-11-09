package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pg */
public class C0734pg extends C1004wp {

    /* renamed from: a */
    public static final String f5656a = "yrrc";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5657c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5658d = null;

    /* renamed from: b */
    int f5659b;

    static {
        m12868i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12868i() {
        cdj cdj = new cdj("RecordingYearBox.java", C0734pg.class);
        f5657c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRecordingYear", "com.coremedia.iso.boxes.RecordingYearBox", "", "", "", "int"), 42);
        f5658d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRecordingYear", "com.coremedia.iso.boxes.RecordingYearBox", "int", "recordingYear", "", "void"), 46);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 6;
    }

    public C0734pg() {
        super(f5656a);
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5657c, (Object) this, (Object) this));
        return this.f5659b;
    }

    /* renamed from: c */
    public void mo5302c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5658d, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5659b = i;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5659b = C0679nk.m12497d(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12514b(byteBuffer, this.f5659b);
    }
}
