package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public abstract class acc extends abc {

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f198f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f199o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f200p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f201q = null;

    /* renamed from: d */
    long f202d;

    /* renamed from: e */
    int f203e = 1;

    static {
        m199n();
    }

    /* renamed from: n */
    private static /* synthetic */ void m199n() {
        cdj cdj = new cdj("AppleVariableSignedIntegerBox.java", acc.class);
        f198f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "int"), 19);
        f199o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "int", "intLength", "", "void"), 23);
        f200p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "long"), 27);
        f201q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "long", "value", "", "void"), 36);
    }

    protected acc(String str) {
        super(str, 15);
    }

    /* renamed from: a */
    public int mo109a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f198f, (Object) this, (Object) this));
        return this.f203e;
    }

    /* renamed from: c */
    public void mo133c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f199o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f203e = i;
    }

    /* renamed from: m */
    public long mo134m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f200p, (Object) this, (Object) this));
        if (!mo6121x()) {
            mo6120v();
        }
        return this.f202d;
    }

    /* renamed from: a */
    public void mo132a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f201q, (Object) this, (Object) this, ccw.m11302a(j)));
        if (j <= 127 && j > -128) {
            this.f203e = 1;
        } else if (j <= 32767 && j > -32768 && this.f203e < 2) {
            this.f203e = 2;
        } else if (j > 8388607 || j <= -8388608 || this.f203e >= 3) {
            this.f203e = 4;
        } else {
            this.f203e = 3;
        }
        this.f202d = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo111b() {
        int c = mo36c();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[c]);
        C0682nn.m12524a(this.f202d, wrap, c);
        return wrap.array();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.f202d = C0680nl.m12508a(byteBuffer, remaining);
        this.f203e = remaining;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo36c() {
        return this.f203e;
    }
}
