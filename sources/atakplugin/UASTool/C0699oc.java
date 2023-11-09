package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.oc */
public class C0699oc extends C1004wp {

    /* renamed from: a */
    public static final String f5414a = "urn ";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5415d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5416e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5417f = null;

    /* renamed from: b */
    private String f5418b;

    /* renamed from: c */
    private String f5419c;

    static {
        m12620c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12620c() {
        cdj cdj = new cdj("DataEntryUrnBox.java", C0699oc.class);
        f5415d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getName", "com.coremedia.iso.boxes.DataEntryUrnBox", "", "", "", "java.lang.String"), 40);
        f5416e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLocation", "com.coremedia.iso.boxes.DataEntryUrnBox", "", "", "", "java.lang.String"), 44);
        f5417f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.DataEntryUrnBox", "", "", "", "java.lang.String"), 67);
    }

    public C0699oc() {
        super(f5414a);
    }

    /* renamed from: a */
    public String mo5154a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5415d, (Object) this, (Object) this));
        return this.f5418b;
    }

    /* renamed from: b */
    public String mo5155b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5416e, (Object) this, (Object) this));
        return this.f5419c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5418b) + 1 + C0684np.m12529b(this.f5419c) + 1);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f5418b = C0679nk.m12500g(byteBuffer);
        this.f5419c = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(C0684np.m12528a(this.f5418b));
        byteBuffer.put((byte) 0);
        byteBuffer.put(C0684np.m12528a(this.f5419c));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5417f, (Object) this, (Object) this));
        return "DataEntryUrlBox[name=" + mo5154a() + ";location=" + mo5155b() + "]";
    }
}
