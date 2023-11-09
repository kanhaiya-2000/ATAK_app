package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class acr extends C1004wp {

    /* renamed from: a */
    public static final String f337a = "prof";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f338d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f339e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f340f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f341o = null;

    /* renamed from: b */
    double f342b;

    /* renamed from: c */
    double f343c;

    static {
        m342j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m342j() {
        cdj cdj = new cdj("TrackProductionApertureDimensionsAtom.java", acr.class);
        f338d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getWidth", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "", "", "", "double"), 44);
        f339e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setWidth", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "double", "width", "", "void"), 48);
        f340f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHeight", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "", "", "", "double"), 52);
        f341o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHeight", "com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom", "double", "height", "", "void"), 56);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 12;
    }

    public acr() {
        super(f337a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12509a(byteBuffer, this.f342b);
        C0681nm.m12509a(byteBuffer, this.f343c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f342b = C0679nk.m12502i(byteBuffer);
        this.f343c = C0679nk.m12502i(byteBuffer);
    }

    /* renamed from: c */
    public double mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f338d, (Object) this, (Object) this));
        return this.f342b;
    }

    /* renamed from: a */
    public void mo228a(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f339e, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f342b = d;
    }

    /* renamed from: i */
    public double mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f340f, (Object) this, (Object) this));
        return this.f343c;
    }

    /* renamed from: b */
    public void mo229b(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f341o, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f343c = d;
    }
}
