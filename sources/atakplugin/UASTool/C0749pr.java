package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pr */
public class C0749pr extends C0685nq {

    /* renamed from: a */
    public static final String f5723a = "sthd";

    /* renamed from: b */
    private static final /* synthetic */ can.C0296b f5724b = null;

    static {
        m12967c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12967c() {
        cdj cdj = new cdj("SubtitleMediaHeaderBox.java", C0749pr.class);
        f5724b = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SubtitleMediaHeaderBox", "", "", "", "java.lang.String"), 30);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 4;
    }

    public C0749pr() {
        super(f5723a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5724b, (Object) this, (Object) this));
        return "SubtitleMediaHeaderBox";
    }
}
