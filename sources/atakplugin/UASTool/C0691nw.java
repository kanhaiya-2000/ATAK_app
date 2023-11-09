package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nw */
public class C0691nw extends C1004wp {

    /* renamed from: a */
    public static final String f5367a = "clsf";

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5368f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5369o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5370p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5371q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5372r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5373s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5374t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5375u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5376v = null;

    /* renamed from: b */
    private String f5377b;

    /* renamed from: c */
    private int f5378c;

    /* renamed from: d */
    private String f5379d;

    /* renamed from: e */
    private String f5380e;

    static {
        m12564j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m12564j() {
        cdj cdj = new cdj("ClassificationBox.java", C0691nw.class);
        f5368f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 44);
        f5369o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 48);
        f5370p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "int"), 52);
        f5371q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 56);
        f5372r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationEntity", "", "void"), 60);
        f5373s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "int", "classificationTableIndex", "", "void"), 64);
        f5374t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "language", "", "void"), 68);
        f5375u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationInfo", "", "void"), 72);
        f5376v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 101);
    }

    public C0691nw() {
        super(f5367a);
    }

    /* renamed from: a */
    public String mo5125a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5368f, (Object) this, (Object) this));
        return this.f5379d;
    }

    /* renamed from: b */
    public String mo5128b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5369o, (Object) this, (Object) this));
        return this.f5377b;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5370p, (Object) this, (Object) this));
        return this.f5378c;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5371q, (Object) this, (Object) this));
        return this.f5380e;
    }

    /* renamed from: a */
    public void mo5127a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5372r, (Object) this, (Object) this, (Object) str));
        this.f5377b = str;
    }

    /* renamed from: a */
    public void mo5126a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5373s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5378c = i;
    }

    /* renamed from: b */
    public void mo5129b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5374t, (Object) this, (Object) this, (Object) str));
        this.f5379d = str;
    }

    /* renamed from: c */
    public void mo5130c(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5375u, (Object) this, (Object) this, (Object) str));
        this.f5380e = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f5380e) + 8 + 1);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.f5377b = C0678nj.m12487a(bArr);
        this.f5378c = C0679nk.m12497d(byteBuffer);
        this.f5379d = C0679nk.m12505l(byteBuffer);
        this.f5380e = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(C0678nj.m12488a(this.f5377b));
        C0681nm.m12514b(byteBuffer, this.f5378c);
        C0681nm.m12512a(byteBuffer, this.f5379d);
        byteBuffer.put(C0684np.m12528a(this.f5380e));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5376v, (Object) this, (Object) this));
        return "ClassificationBox[language=" + mo5125a() + "classificationEntity=" + mo5128b() + ";classificationTableIndex=" + mo36c() + ";language=" + mo5125a() + ";classificationInfo=" + mo43i() + "]";
    }
}
