package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nx */
public class C0692nx extends C1004wp {

    /* renamed from: a */
    public static final String f5381a = "cslg";

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5382o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5383p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5384q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5385r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5386s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5387t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5388u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5389v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5390w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5391x = null;

    /* renamed from: b */
    int f5392b;

    /* renamed from: c */
    int f5393c;

    /* renamed from: d */
    int f5394d;

    /* renamed from: e */
    int f5395e;

    /* renamed from: f */
    int f5396f;

    static {
        m12576k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m12576k() {
        cdj cdj = new cdj("CompositionShiftLeastGreatestAtom.java", C0692nx.class);
        f5382o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCompositionOffsetToDisplayOffsetShift", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 66);
        f5383p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCompositionOffsetToDisplayOffsetShift", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "compositionOffsetToDisplayOffsetShift", "", "void"), 70);
        f5384q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLeastDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 74);
        f5385r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLeastDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "leastDisplayOffset", "", "void"), 78);
        f5386s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGreatestDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 82);
        f5387t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setGreatestDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "greatestDisplayOffset", "", "void"), 86);
        f5388u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDisplayStartTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 90);
        f5389v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDisplayStartTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "displayStartTime", "", "void"), 94);
        f5390w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDisplayEndTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 98);
        f5391x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDisplayEndTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "displayEndTime", "", "void"), 102);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 24;
    }

    public C0692nx() {
        super(f5381a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5392b = byteBuffer.getInt();
        this.f5393c = byteBuffer.getInt();
        this.f5394d = byteBuffer.getInt();
        this.f5395e = byteBuffer.getInt();
        this.f5396f = byteBuffer.getInt();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.putInt(this.f5392b);
        byteBuffer.putInt(this.f5393c);
        byteBuffer.putInt(this.f5394d);
        byteBuffer.putInt(this.f5395e);
        byteBuffer.putInt(this.f5396f);
    }

    /* renamed from: a */
    public int mo5132a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5382o, (Object) this, (Object) this));
        return this.f5392b;
    }

    /* renamed from: a */
    public void mo5133a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5383p, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5392b = i;
    }

    /* renamed from: b */
    public int mo5134b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5384q, (Object) this, (Object) this));
        return this.f5393c;
    }

    /* renamed from: b_ */
    public void mo5135b_(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5385r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5393c = i;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5386s, (Object) this, (Object) this));
        return this.f5394d;
    }

    /* renamed from: c */
    public void mo5136c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5387t, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5394d = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5388u, (Object) this, (Object) this));
        return this.f5395e;
    }

    /* renamed from: d */
    public void mo5137d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5389v, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5395e = i;
    }

    /* renamed from: j */
    public int mo5139j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5390w, (Object) this, (Object) this));
        return this.f5396f;
    }

    /* renamed from: e */
    public void mo5138e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5391x, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5396f = i;
    }
}
