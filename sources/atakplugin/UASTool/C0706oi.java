package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.oi */
public class C0706oi extends C1002wn {

    /* renamed from: a */
    public static final String f5442a = "ftyp";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5443e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5444f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5445o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5446p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5447q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5448r = null;

    /* renamed from: b */
    private String f5449b;

    /* renamed from: c */
    private long f5450c;

    /* renamed from: d */
    private List<String> f5451d = Collections.emptyList();

    static {
        m12654i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12654i() {
        cdj cdj = new cdj("FileTypeBox.java", C0706oi.class);
        f5443e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.lang.String"), 85);
        f5444f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        f5445o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "long", "minorVersion", "", "void"), 103);
        f5446p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "long"), 113);
        f5447q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.util.List"), 122);
        f5448r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    public C0706oi() {
        super(f5442a);
    }

    public C0706oi(String str, long j, List<String> list) {
        super(f5442a);
        this.f5449b = str;
        this.f5450c = j;
        this.f5451d = list;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5451d.size() * 4) + 8);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f5449b = C0679nk.m12506m(byteBuffer);
        this.f5450c = C0679nk.m12495b(byteBuffer);
        int remaining = byteBuffer.remaining() / 4;
        this.f5451d = new LinkedList();
        for (int i = 0; i < remaining; i++) {
            this.f5451d.add(C0679nk.m12506m(byteBuffer));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(C0678nj.m12488a(this.f5449b));
        C0681nm.m12515b(byteBuffer, this.f5450c);
        for (String a : this.f5451d) {
            byteBuffer.put(C0678nj.m12488a(a));
        }
    }

    /* renamed from: a */
    public String mo5175a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5443e, (Object) this, (Object) this));
        return this.f5449b;
    }

    /* renamed from: a */
    public void mo5177a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5444f, (Object) this, (Object) this, (Object) str));
        this.f5449b = str;
    }

    /* renamed from: a */
    public void mo5176a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5445o, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5450c = j;
    }

    /* renamed from: b */
    public long mo5179b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5446p, (Object) this, (Object) this));
        return this.f5450c;
    }

    /* renamed from: c */
    public List<String> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5447q, (Object) this, (Object) this));
        return this.f5451d;
    }

    /* renamed from: a */
    public void mo5178a(List<String> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5448r, (Object) this, (Object) this, (Object) list));
        this.f5451d = list;
    }

    @C1016xa
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileTypeBox[");
        sb.append("majorBrand=");
        sb.append(mo5175a());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(mo5179b());
        for (String append : this.f5451d) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(append);
        }
        sb.append("]");
        return sb.toString();
    }
}
