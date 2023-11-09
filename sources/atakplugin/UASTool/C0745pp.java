package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pp */
public class C0745pp extends C0690nv {

    /* renamed from: a */
    public static final String f5708a = "stco";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5709c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5710d = null;

    /* renamed from: b */
    private long[] f5711b = new long[0];

    static {
        m12943c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12943c() {
        cdj cdj = new cdj("StaticChunkOffsetBox.java", C0745pp.class);
        f5709c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        f5710d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
    }

    public C0745pp() {
        super(f5708a);
    }

    /* renamed from: a */
    public long[] mo5123a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5709c, (Object) this, (Object) this));
        return this.f5711b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5711b.length * 4) + 8);
    }

    /* renamed from: a */
    public void mo5122a(long[] jArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5710d, (Object) this, (Object) this, (Object) jArr));
        this.f5711b = jArr;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5711b = new long[a];
        for (int i = 0; i < a; i++) {
            this.f5711b[i] = C0679nk.m12495b(byteBuffer);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5711b.length);
        for (long b : this.f5711b) {
            C0681nm.m12515b(byteBuffer, b);
        }
    }
}
