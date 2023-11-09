package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qu */
public class C0781qu extends C1004wp {

    /* renamed from: a */
    public static final String f5920a = "tfdt";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5921c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5922d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5923e = null;

    /* renamed from: b */
    private long f5924b;

    static {
        m13177i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13177i() {
        cdj cdj = new cdj("TrackFragmentBaseMediaDecodeTimeBox.java", C0781qu.class);
        f5921c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "long"), 65);
        f5922d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "long", "baseMediaDecodeTime", "", "void"), 69);
        f5923e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "java.lang.String"), 74);
    }

    public C0781qu() {
        super(f5920a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (mo5157a_() == 0 ? 8 : 12);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (mo5157a_() == 1) {
            C0681nm.m12511a(byteBuffer, this.f5924b);
        } else {
            C0681nm.m12515b(byteBuffer, this.f5924b);
        }
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if (mo5157a_() == 1) {
            this.f5924b = C0679nk.m12501h(byteBuffer);
        } else {
            this.f5924b = C0679nk.m12495b(byteBuffer);
        }
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5921c, (Object) this, (Object) this));
        return this.f5924b;
    }

    /* renamed from: a */
    public void mo5490a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5922d, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5924b = j;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5923e, (Object) this, (Object) this));
        return "TrackFragmentBaseMediaDecodeTimeBox{baseMediaDecodeTime=" + this.f5924b + '}';
    }
}
