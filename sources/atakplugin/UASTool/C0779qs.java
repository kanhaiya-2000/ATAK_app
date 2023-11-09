package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.qs */
public class C0779qs extends C1002wn {

    /* renamed from: a */
    public static final String f5893a = "styp";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5894e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5895f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5896o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5897p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5898q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5899r = null;

    /* renamed from: b */
    private String f5900b;

    /* renamed from: c */
    private long f5901c;

    /* renamed from: d */
    private List<String> f5902d = Collections.emptyList();

    static {
        m13152i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13152i() {
        cdj cdj = new cdj("SegmentTypeBox.java", C0779qs.class);
        f5894e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.lang.String"), 85);
        f5895f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        f5896o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "long", "minorVersion", "", "void"), 103);
        f5897p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "long"), 113);
        f5898q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.util.List"), 122);
        f5899r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    public C0779qs() {
        super(f5893a);
    }

    public C0779qs(String str, long j, List<String> list) {
        super(f5893a);
        this.f5900b = str;
        this.f5901c = j;
        this.f5902d = list;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5902d.size() * 4) + 8);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f5900b = C0679nk.m12506m(byteBuffer);
        this.f5901c = C0679nk.m12495b(byteBuffer);
        int remaining = byteBuffer.remaining() / 4;
        this.f5902d = new LinkedList();
        for (int i = 0; i < remaining; i++) {
            this.f5902d.add(C0679nk.m12506m(byteBuffer));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(C0678nj.m12488a(this.f5900b));
        C0681nm.m12515b(byteBuffer, this.f5901c);
        for (String a : this.f5902d) {
            byteBuffer.put(C0678nj.m12488a(a));
        }
    }

    /* renamed from: a */
    public String mo5475a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5894e, (Object) this, (Object) this));
        return this.f5900b;
    }

    /* renamed from: a */
    public void mo5477a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5895f, (Object) this, (Object) this, (Object) str));
        this.f5900b = str;
    }

    /* renamed from: a */
    public void mo5476a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5896o, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5901c = j;
    }

    /* renamed from: b */
    public long mo5479b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5897p, (Object) this, (Object) this));
        return this.f5901c;
    }

    /* renamed from: c */
    public List<String> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5898q, (Object) this, (Object) this));
        return this.f5902d;
    }

    /* renamed from: a */
    public void mo5478a(List<String> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5899r, (Object) this, (Object) this, (Object) list));
        this.f5902d = list;
    }

    @C1016xa
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentTypeBox[");
        sb.append("majorBrand=");
        sb.append(mo5475a());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(mo5479b());
        for (String append : this.f5902d) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(append);
        }
        sb.append("]");
        return sb.toString();
    }
}
