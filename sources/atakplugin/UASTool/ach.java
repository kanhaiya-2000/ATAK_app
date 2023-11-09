package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class ach extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f204A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f205B = null;

    /* renamed from: a */
    public static final String f206a = "gmin";

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f207p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f208q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f209r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f210s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f211t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f212u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f213v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f214w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f215x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f216y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f217z = null;

    /* renamed from: b */
    short f218b = 64;

    /* renamed from: c */
    int f219c = 32768;

    /* renamed from: d */
    int f220d = 32768;

    /* renamed from: e */
    int f221e = 32768;

    /* renamed from: f */
    short f222f;

    /* renamed from: o */
    short f223o;

    static {
        m207n();
    }

    /* renamed from: n */
    private static /* synthetic */ void m207n() {
        cdj cdj = new cdj("BaseMediaInfoAtom.java", ach.class);
        f207p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGraphicsMode", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 54);
        f208q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setGraphicsMode", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "graphicsMode", "", "void"), 58);
        f217z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 94);
        f204A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "reserved", "", "void"), 98);
        f205B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "java.lang.String"), 103);
        f209r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getOpColorR", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 62);
        f210s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setOpColorR", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorR", "", "void"), 66);
        f211t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getOpColorG", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 70);
        f212u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setOpColorG", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorG", "", "void"), 74);
        f213v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getOpColorB", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "int"), 78);
        f214w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setOpColorB", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "int", "opColorB", "", "void"), 82);
        f215x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBalance", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "", "", "", "short"), 86);
        f216y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBalance", "com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom", "short", "balance", "", "void"), 90);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 16;
    }

    public ach() {
        super(f206a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.putShort(this.f218b);
        C0681nm.m12514b(byteBuffer, this.f219c);
        C0681nm.m12514b(byteBuffer, this.f220d);
        C0681nm.m12514b(byteBuffer, this.f221e);
        byteBuffer.putShort(this.f222f);
        byteBuffer.putShort(this.f223o);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f218b = byteBuffer.getShort();
        this.f219c = C0679nk.m12497d(byteBuffer);
        this.f220d = C0679nk.m12497d(byteBuffer);
        this.f221e = C0679nk.m12497d(byteBuffer);
        this.f222f = byteBuffer.getShort();
        this.f223o = byteBuffer.getShort();
    }

    /* renamed from: c */
    public short mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f207p, (Object) this, (Object) this));
        return this.f218b;
    }

    /* renamed from: a */
    public void mo135a(short s) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f208q, (Object) this, (Object) this, ccw.m11303a(s)));
        this.f218b = s;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f209r, (Object) this, (Object) this));
        return this.f219c;
    }

    /* renamed from: c */
    public void mo137c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f210s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f219c = i;
    }

    /* renamed from: j */
    public int mo141j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f211t, (Object) this, (Object) this));
        return this.f220d;
    }

    /* renamed from: d */
    public void mo139d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f212u, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f220d = i;
    }

    /* renamed from: k */
    public int mo142k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f213v, (Object) this, (Object) this));
        return this.f221e;
    }

    /* renamed from: e */
    public void mo140e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f214w, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f221e = i;
    }

    /* renamed from: l */
    public short mo143l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f215x, (Object) this, (Object) this));
        return this.f222f;
    }

    /* renamed from: b */
    public void mo136b(short s) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f216y, (Object) this, (Object) this, ccw.m11303a(s)));
        this.f222f = s;
    }

    /* renamed from: m */
    public short mo144m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f217z, (Object) this, (Object) this));
        return this.f223o;
    }

    /* renamed from: c */
    public void mo138c(short s) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f204A, (Object) this, (Object) this, ccw.m11303a(s)));
        this.f223o = s;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f205B, (Object) this, (Object) this));
        return "BaseMediaInfoAtom{graphicsMode=" + this.f218b + ", opColorR=" + this.f219c + ", opColorG=" + this.f220d + ", opColorB=" + this.f221e + ", balance=" + this.f222f + ", reserved=" + this.f223o + '}';
    }
}
