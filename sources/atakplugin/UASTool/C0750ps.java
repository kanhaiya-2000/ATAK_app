package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.ps */
public class C0750ps extends C1004wp {

    /* renamed from: a */
    public static final String f5725a = "stss";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5726c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5727d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5728e = null;

    /* renamed from: b */
    private long[] f5729b;

    static {
        m12971i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12971i() {
        cdj cdj = new cdj("SyncSampleBox.java", C0750ps.class);
        f5726c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        f5727d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        f5728e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    public C0750ps() {
        super(f5725a);
    }

    /* renamed from: c */
    public long[] mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5726c, (Object) this, (Object) this));
        return this.f5729b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5729b.length * 4) + 8);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5729b = new long[a];
        for (int i = 0; i < a; i++) {
            this.f5729b[i] = C0679nk.m12495b(byteBuffer);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5729b.length);
        for (long b : this.f5729b) {
            C0681nm.m12515b(byteBuffer, b);
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5727d, (Object) this, (Object) this));
        return "SyncSampleBox[entryCount=" + this.f5729b.length + "]";
    }

    /* renamed from: a */
    public void mo5365a(long[] jArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5728e, (Object) this, (Object) this, (Object) jArr));
        this.f5729b = jArr;
    }
}
