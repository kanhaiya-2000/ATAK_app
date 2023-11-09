package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nu */
public class C0689nu extends C0690nv {

    /* renamed from: a */
    public static final String f5362a = "co64";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5363c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5364d = null;

    /* renamed from: b */
    private long[] f5365b;

    static {
        m12555c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12555c() {
        cdj cdj = new cdj("ChunkOffset64BitBox.java", C0689nu.class);
        f5363c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getChunkOffsets", "com.coremedia.iso.boxes.ChunkOffset64BitBox", "", "", "", "[J"), 23);
        f5364d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setChunkOffsets", "com.coremedia.iso.boxes.ChunkOffset64BitBox", "[J", "chunkOffsets", "", "void"), 28);
    }

    public C0689nu() {
        super(f5362a);
    }

    /* renamed from: a */
    public long[] mo5123a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5363c, (Object) this, (Object) this));
        return this.f5365b;
    }

    /* renamed from: a */
    public void mo5122a(long[] jArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5364d, (Object) this, (Object) this, (Object) jArr));
        this.f5365b = jArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5365b.length * 8) + 8);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5365b = new long[a];
        for (int i = 0; i < a; i++) {
            this.f5365b[i] = C0679nk.m12501h(byteBuffer);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5365b.length);
        for (long a : this.f5365b) {
            C0681nm.m12511a(byteBuffer, a);
        }
    }
}
