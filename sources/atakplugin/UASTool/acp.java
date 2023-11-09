package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class acp extends C1004wp {

    /* renamed from: a */
    public static final String f317a = "enof";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f318d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f319e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f320f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f321o = null;

    /* renamed from: b */
    double f322b;

    /* renamed from: c */
    double f323c;

    static {
        m322j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m322j() {
        cdj cdj = new cdj("TrackEncodedPixelsDimensionsAtom.java", acp.class);
        f318d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getWidth", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "", "", "", "double"), 44);
        f319e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setWidth", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "double", "width", "", "void"), 48);
        f320f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHeight", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "", "", "", "double"), 52);
        f321o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHeight", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "double", "height", "", "void"), 56);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 12;
    }

    public acp() {
        super(f317a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12509a(byteBuffer, this.f322b);
        C0681nm.m12509a(byteBuffer, this.f323c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f322b = C0679nk.m12502i(byteBuffer);
        this.f323c = C0679nk.m12502i(byteBuffer);
    }

    /* renamed from: c */
    public double mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f318d, (Object) this, (Object) this));
        return this.f322b;
    }

    /* renamed from: a */
    public void mo220a(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f319e, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f322b = d;
    }

    /* renamed from: i */
    public double mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f320f, (Object) this, (Object) this));
        return this.f323c;
    }

    /* renamed from: b */
    public void mo221b(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f321o, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f323c = d;
    }
}
