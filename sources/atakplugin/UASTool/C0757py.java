package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.py */
public class C0757py extends C1002wn {

    /* renamed from: b */
    private static final /* synthetic */ can.C0296b f5792b = null;

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5793c = null;

    /* renamed from: a */
    ByteBuffer f5794a;

    static {
        m13032b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m13032b() {
        cdj cdj = new cdj("UnknownBox.java", C0757py.class);
        f5792b = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getData", "com.coremedia.iso.boxes.UnknownBox", "", "", "", "java.nio.ByteBuffer"), 52);
        f5793c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setData", "com.coremedia.iso.boxes.UnknownBox", "java.nio.ByteBuffer", "data", "", "void"), 56);
    }

    public C0757py(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) this.f5794a.limit();
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f5794a = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        this.f5794a.rewind();
        byteBuffer.put(this.f5794a);
    }

    /* renamed from: a */
    public ByteBuffer mo5407a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5792b, (Object) this, (Object) this));
        return this.f5794a;
    }

    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5793c, (Object) this, (Object) this, (Object) byteBuffer));
        this.f5794a = byteBuffer;
    }
}
