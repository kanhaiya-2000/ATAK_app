package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.op */
public class C0713op extends C1002wn {

    /* renamed from: b */
    public static final String f5496b = "idat";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5497c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5498d = null;

    /* renamed from: a */
    ByteBuffer f5499a = ByteBuffer.allocate(0);

    static {
        m12709b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m12709b() {
        cdj cdj = new cdj("ItemDataBox.java", C0713op.class);
        f5497c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getData", "com.coremedia.iso.boxes.ItemDataBox", "", "", "", "java.nio.ByteBuffer"), 19);
        f5498d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setData", "com.coremedia.iso.boxes.ItemDataBox", "java.nio.ByteBuffer", "data", "", "void"), 23);
    }

    public C0713op() {
        super(f5496b);
    }

    /* renamed from: a */
    public ByteBuffer mo5199a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5497c, (Object) this, (Object) this));
        return this.f5499a;
    }

    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5498d, (Object) this, (Object) this, (Object) byteBuffer));
        this.f5499a = byteBuffer;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) this.f5499a.limit();
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f5499a = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f5499a);
    }
}
