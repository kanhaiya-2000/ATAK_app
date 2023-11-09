package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class acl extends C1002wn {

    /* renamed from: a */
    public static final String f260a = "pasp";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f261d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f262e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f263f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f264o = null;

    /* renamed from: b */
    private int f265b;

    /* renamed from: c */
    private int f266c;

    static {
        m253c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m253c() {
        cdj cdj = new cdj("PixelAspectRationAtom.java", acl.class);
        f261d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "gethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 35);
        f262e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "sethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "hSpacing", "", "void"), 39);
        f263f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 43);
        f264o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "vSpacing", "", "void"), 47);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 8;
    }

    public acl() {
        super(f260a);
    }

    /* renamed from: a */
    public int mo164a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f261d, (Object) this, (Object) this));
        return this.f265b;
    }

    /* renamed from: a */
    public void mo165a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f262e, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f265b = i;
    }

    /* renamed from: b */
    public int mo166b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f263f, (Object) this, (Object) this));
        return this.f266c;
    }

    /* renamed from: b */
    public void mo167b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f264o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f266c = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f265b);
        byteBuffer.putInt(this.f266c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f265b = byteBuffer.getInt();
        this.f266c = byteBuffer.getInt();
    }
}
