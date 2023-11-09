package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qb */
public class C0761qb extends C0685nq {

    /* renamed from: a */
    public static final String f5802a = "vmhd";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5803d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5804e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5805f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5806o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5807p = null;

    /* renamed from: b */
    private int f5808b = 0;

    /* renamed from: c */
    private int[] f5809c = new int[3];

    static {
        m13048j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m13048j() {
        cdj cdj = new cdj("VideoMediaHeaderBox.java", C0761qb.class);
        f5803d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        f5804e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        f5805f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 71);
        f5806o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        f5807p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 12;
    }

    public C0761qb() {
        super(f5802a);
        mo5159b(1);
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5803d, (Object) this, (Object) this));
        return this.f5808b;
    }

    /* renamed from: i */
    public int[] mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5804e, (Object) this, (Object) this));
        return this.f5809c;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5808b = C0679nk.m12497d(byteBuffer);
        this.f5809c = new int[3];
        for (int i = 0; i < 3; i++) {
            this.f5809c[i] = C0679nk.m12497d(byteBuffer);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12514b(byteBuffer, this.f5808b);
        for (int b : this.f5809c) {
            C0681nm.m12514b(byteBuffer, b);
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5805f, (Object) this, (Object) this));
        return "VideoMediaHeaderBox[graphicsmode=" + mo36c() + ";opcolor0=" + mo43i()[0] + ";opcolor1=" + mo43i()[1] + ";opcolor2=" + mo43i()[2] + "]";
    }

    /* renamed from: a */
    public void mo5412a(int[] iArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5806o, (Object) this, (Object) this, (Object) iArr));
        this.f5809c = iArr;
    }

    /* renamed from: c */
    public void mo5413c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5807p, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5808b = i;
    }
}
