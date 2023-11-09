package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.os */
public class C0718os extends C1004wp {

    /* renamed from: a */
    public static final String f5531a = "kywd";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5532d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5533e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5534f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5535o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5536p = null;

    /* renamed from: b */
    private String f5537b;

    /* renamed from: c */
    private String[] f5538c;

    static {
        m12746j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m12746j() {
        cdj cdj = new cdj("KeywordsBox.java", C0718os.class);
        f5532d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 40);
        f5533e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getKeywords", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "[Ljava.lang.String;"), 44);
        f5534f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.KeywordsBox", "java.lang.String", "language", "", "void"), 48);
        f5535o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setKeywords", "com.coremedia.iso.boxes.KeywordsBox", "[Ljava.lang.String;", "keywords", "", "void"), 52);
        f5536p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 87);
    }

    public C0718os() {
        super(f5531a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5532d, (Object) this, (Object) this));
        return this.f5537b;
    }

    /* renamed from: i */
    public String[] mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5533e, (Object) this, (Object) this));
        return this.f5538c;
    }

    /* renamed from: a */
    public void mo5222a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5534f, (Object) this, (Object) this, (Object) str));
        this.f5537b = str;
    }

    /* renamed from: a */
    public void mo5223a(String[] strArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5535o, (Object) this, (Object) this, (Object) strArr));
        this.f5538c = strArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        long j = 7;
        for (String b : this.f5538c) {
            j += (long) (C0684np.m12529b(b) + 1 + 1);
        }
        return j;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5537b = C0679nk.m12505l(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        this.f5538c = new String[f];
        for (int i = 0; i < f; i++) {
            C0679nk.m12499f(byteBuffer);
            this.f5538c[i] = C0679nk.m12500g(byteBuffer);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5537b);
        C0681nm.m12521d(byteBuffer, this.f5538c.length);
        for (String str : this.f5538c) {
            C0681nm.m12521d(byteBuffer, C0684np.m12529b(str) + 1);
            byteBuffer.put(C0684np.m12528a(str));
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5536p, (Object) this, (Object) this));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("KeywordsBox[language=");
        stringBuffer.append(mo36c());
        for (int i = 0; i < this.f5538c.length; i++) {
            stringBuffer.append(";keyword");
            stringBuffer.append(i);
            stringBuffer.append("=");
            stringBuffer.append(this.f5538c[i]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
