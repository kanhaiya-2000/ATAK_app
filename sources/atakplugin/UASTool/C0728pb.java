package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pb */
public class C0728pb extends C1002wn {

    /* renamed from: a */
    public static final String f5620a = "frma";

    /* renamed from: b */
    static final /* synthetic */ boolean f5621b = true;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5622d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5623e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5624f = null;

    /* renamed from: c */
    private String f5625c = "    ";

    /* renamed from: b */
    private static /* synthetic */ void m12832b() {
        cdj cdj = new cdj("OriginalFormatBox.java", C0728pb.class);
        f5622d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", "java.lang.String"), 42);
        f5623e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", "java.lang.String", "dataFormat", "", "void"), 47);
        f5624f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", "java.lang.String"), 67);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 4;
    }

    static {
        m12832b();
    }

    public C0728pb() {
        super(f5620a);
    }

    /* renamed from: a */
    public String mo5280a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5622d, (Object) this, (Object) this));
        return this.f5625c;
    }

    /* renamed from: a */
    public void mo5281a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5623e, (Object) this, (Object) this, (Object) str));
        if (f5621b || str.length() == 4) {
            this.f5625c = str;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f5625c = C0679nk.m12506m(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(C0678nj.m12488a(this.f5625c));
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5624f, (Object) this, (Object) this));
        return "OriginalFormatBox[dataFormat=" + mo5280a() + "]";
    }
}
