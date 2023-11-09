package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.UUID;

public abstract class aao extends C1004wp {

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f59d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f60e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f61f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f62o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f63p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f64q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f65r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f66s = null;

    /* renamed from: a */
    int f67a;

    /* renamed from: b */
    int f68b;

    /* renamed from: c */
    byte[] f69c;

    static {
        m69k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m69k() {
        cdj cdj = new cdj("AbstractTrackEncryptionBox.java", aao.class);
        f59d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultAlgorithmId", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 24);
        f60e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultAlgorithmId", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "int", "defaultAlgorithmId", "", "void"), 28);
        f61f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultIvSize", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 32);
        f62o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultIvSize", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "int", "defaultIvSize", "", "void"), 36);
        f63p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefault_KID", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "java.util.UUID"), 40);
        f64q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefault_KID", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "java.util.UUID", C0758pz.f5795b, "", "void"), 46);
        f65r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "equals", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "java.lang.Object", "o", "", "boolean"), 76);
        f66s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 90);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 24;
    }

    protected aao(String str) {
        super(str);
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f59d, (Object) this, (Object) this));
        return this.f67a;
    }

    /* renamed from: c */
    public void mo56c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f60e, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f67a = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f61f, (Object) this, (Object) this));
        return this.f68b;
    }

    /* renamed from: d */
    public void mo57d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f62o, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f68b = i;
    }

    /* renamed from: j */
    public UUID mo60j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f63p, (Object) this, (Object) this));
        ByteBuffer wrap = ByteBuffer.wrap(this.f69c);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    /* renamed from: a */
    public void mo55a(UUID uuid) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f64q, (Object) this, (Object) this, (Object) uuid));
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        this.f69c = wrap.array();
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f67a = C0679nk.m12496c(byteBuffer);
        this.f68b = C0679nk.m12499f(byteBuffer);
        byte[] bArr = new byte[16];
        this.f69c = bArr;
        byteBuffer.get(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12510a(byteBuffer, this.f67a);
        C0681nm.m12521d(byteBuffer, this.f68b);
        byteBuffer.put(this.f69c);
    }

    public boolean equals(Object obj) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f65r, (Object) this, (Object) this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aao aao = (aao) obj;
        return this.f67a == aao.f67a && this.f68b == aao.f68b && Arrays.equals(this.f69c, aao.f69c);
    }

    public int hashCode() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f66s, (Object) this, (Object) this));
        int i = ((this.f67a * 31) + this.f68b) * 31;
        byte[] bArr = this.f69c;
        return i + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }
}
