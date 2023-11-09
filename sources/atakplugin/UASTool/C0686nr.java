package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nr */
public class C0686nr extends C1004wp {

    /* renamed from: a */
    public static final String f5343a = "albm";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5344e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5345f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5346o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5347p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5348q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5349r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5350s = null;

    /* renamed from: b */
    private String f5351b;

    /* renamed from: c */
    private String f5352c;

    /* renamed from: d */
    private int f5353d;

    static {
        m12530i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12530i() {
        cdj cdj = new cdj("AlbumBox.java", C0686nr.class);
        f5344e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 51);
        f5345f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAlbumTitle", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 55);
        f5346o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTrackNumber", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "int"), 59);
        f5347p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.AlbumBox", "java.lang.String", "language", "", "void"), 63);
        f5348q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAlbumTitle", "com.coremedia.iso.boxes.AlbumBox", "java.lang.String", "albumTitle", "", "void"), 67);
        f5349r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTrackNumber", "com.coremedia.iso.boxes.AlbumBox", "int", "trackNumber", "", "void"), 71);
        f5350s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.AlbumBox", "", "", "", "java.lang.String"), 103);
    }

    public C0686nr() {
        super(f5343a);
    }

    /* renamed from: a */
    public String mo5111a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5344e, (Object) this, (Object) this));
        return this.f5351b;
    }

    /* renamed from: b */
    public String mo5114b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5345f, (Object) this, (Object) this));
        return this.f5352c;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5346o, (Object) this, (Object) this));
        return this.f5353d;
    }

    /* renamed from: a */
    public void mo5113a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5347p, (Object) this, (Object) this, (Object) str));
        this.f5351b = str;
    }

    /* renamed from: b */
    public void mo5115b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5348q, (Object) this, (Object) this, (Object) str));
        this.f5352c = str;
    }

    /* renamed from: a */
    public void mo5112a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5349r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5353d = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int i = 1;
        int b = C0684np.m12529b(this.f5352c) + 6 + 1;
        if (this.f5353d == -1) {
            i = 0;
        }
        return (long) (b + i);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5351b = C0679nk.m12505l(byteBuffer);
        this.f5352c = C0679nk.m12500g(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.f5353d = C0679nk.m12499f(byteBuffer);
        } else {
            this.f5353d = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f5351b);
        byteBuffer.put(C0684np.m12528a(this.f5352c));
        byteBuffer.put((byte) 0);
        int i = this.f5353d;
        if (i != -1) {
            C0681nm.m12521d(byteBuffer, i);
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5350s, (Object) this, (Object) this));
        StringBuilder sb = new StringBuilder();
        sb.append("AlbumBox[language=");
        sb.append(mo5111a());
        sb.append(";");
        sb.append("albumTitle=");
        sb.append(mo5114b());
        if (this.f5353d >= 0) {
            sb.append(";trackNumber=");
            sb.append(mo36c());
        }
        sb.append("]");
        return sb.toString();
    }
}
