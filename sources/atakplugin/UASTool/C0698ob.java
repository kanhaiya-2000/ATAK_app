package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.ob */
public class C0698ob extends C1004wp {

    /* renamed from: a */
    public static final String f5412a = "url ";

    /* renamed from: b */
    private static final /* synthetic */ can.C0296b f5413b = null;

    static {
        m12616c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m12616c() {
        cdj cdj = new cdj("DataEntryUrlBox.java", C0698ob.class);
        f5413b = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 4;
    }

    public C0698ob() {
        super(f5412a);
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
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5413b, (Object) this, (Object) this));
        return "DataEntryUrlBox[]";
    }
}
