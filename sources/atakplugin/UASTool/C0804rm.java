package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.rm */
public class C0804rm extends C1004wp {

    /* renamed from: a */
    public static final String f6127a = "albr";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f6128d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f6129e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f6130f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f6131o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f6132p = null;

    /* renamed from: b */
    private String f6133b;

    /* renamed from: c */
    private String f6134c;

    static {
        m13430j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m13430j() {
        cdj cdj = new cdj("AlbumArtistBox.java", C0804rm.class);
        f6128d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 42);
        f6129e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 46);
        f6130f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "java.lang.String", "language", "", "void"), 50);
        f6131o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAlbumArtist", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "java.lang.String", "albumArtist", "", "void"), 54);
        f6132p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.vodafone.AlbumArtistBox", "", "", "", "java.lang.String"), 76);
    }

    public C0804rm() {
        super(f6127a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6128d, (Object) this, (Object) this));
        return this.f6133b;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6129e, (Object) this, (Object) this));
        return this.f6134c;
    }

    /* renamed from: a */
    public void mo5671a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6130f, (Object) this, (Object) this, (Object) str));
        this.f6133b = str;
    }

    /* renamed from: b */
    public void mo5672b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6131o, (Object) this, (Object) this, (Object) str));
        this.f6134c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f6134c) + 6 + 1);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f6133b = C0679nk.m12505l(byteBuffer);
        this.f6134c = C0679nk.m12500g(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12512a(byteBuffer, this.f6133b);
        byteBuffer.put(C0684np.m12528a(this.f6134c));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f6132p, (Object) this, (Object) this));
        return "AlbumArtistBox[language=" + mo36c() + ";albumArtist=" + mo43i() + "]";
    }
}
