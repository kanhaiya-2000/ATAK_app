package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.wp */
public abstract class C1004wp extends C1002wn implements C0709ol {

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f7514c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f7515d = null;

    /* renamed from: a */
    private int f7516a;

    /* renamed from: b */
    private int f7517b;

    static {
        mo36c();
    }

    /* renamed from: c */
    private static /* synthetic */ void mo36c() {
        cdj cdj = new cdj("AbstractFullBox.java", C1004wp.class);
        f7514c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", "int", "version", "", "void"), 51);
        f7515d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", "int", "flags", "", "void"), 64);
    }

    protected C1004wp(String str) {
        super(str);
    }

    protected C1004wp(String str, byte[] bArr) {
        super(str, bArr);
    }

    @C1016xa
    /* renamed from: a_ */
    public int mo5157a_() {
        if (!this.f7504h) {
            mo6120v();
        }
        return this.f7516a;
    }

    /* renamed from: a_ */
    public void mo5158a_(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f7514c, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f7516a = i;
    }

    @C1016xa
    /* renamed from: b_ */
    public int mo456b_() {
        if (!this.f7504h) {
            mo6120v();
        }
        return this.f7517b;
    }

    /* renamed from: b */
    public void mo5159b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f7515d, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f7517b = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final long mo6125f(ByteBuffer byteBuffer) {
        this.f7516a = C0679nk.m12499f(byteBuffer);
        this.f7517b = C0679nk.m12496c(byteBuffer);
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final void mo6126g(ByteBuffer byteBuffer) {
        C0681nm.m12521d(byteBuffer, this.f7516a);
        C0681nm.m12510a(byteBuffer, this.f7517b);
    }
}
