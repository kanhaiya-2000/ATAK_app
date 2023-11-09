package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atakplugin.UASTool.qk */
public class C0770qk extends C1004wp {

    /* renamed from: a */
    public static final String f5863a = "trik";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5864c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5865d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5866e = null;

    /* renamed from: b */
    private List<C0771a> f5867b = new ArrayList();

    static {
        m13100i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m13100i() {
        cdj cdj = new cdj("TrickPlayBox.java", C0770qk.class);
        f5864c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "java.util.List", "entries", "", "void"), 32);
        f5865d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.util.List"), 36);
        f5866e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.lang.String"), 103);
    }

    public C0770qk() {
        super(f5863a);
    }

    /* renamed from: a */
    public void mo5438a(List<C0771a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5864c, (Object) this, (Object) this, (Object) list));
        this.f5867b = list;
    }

    /* renamed from: c */
    public List<C0771a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5865d, (Object) this, (Object) this));
        return this.f5867b;
    }

    /* renamed from: atakplugin.UASTool.qk$a */
    public static class C0771a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f5868a;

        public C0771a() {
        }

        public C0771a(int i) {
            this.f5868a = i;
        }

        /* renamed from: a */
        public int mo5440a() {
            return (this.f5868a >> 6) & 3;
        }

        /* renamed from: a */
        public void mo5441a(int i) {
            int i2 = this.f5868a & 31;
            this.f5868a = i2;
            this.f5868a = ((i & 3) << 6) | i2;
        }

        /* renamed from: b */
        public int mo5442b() {
            return this.f5868a & 63;
        }

        /* renamed from: b */
        public void mo5443b(int i) {
            this.f5868a = (i & 63) | this.f5868a;
        }

        public String toString() {
            return "Entry" + "{picType=" + mo5440a() + ",dependencyLevel=" + mo5442b() + '}';
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (this.f5867b.size() + 4);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.f5867b.add(new C0771a(C0679nk.m12499f(byteBuffer)));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        for (C0771a a : this.f5867b) {
            C0681nm.m12521d(byteBuffer, a.f5868a);
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5866e, (Object) this, (Object) this));
        return "TrickPlayBox" + "{entries=" + this.f5867b + '}';
    }
}
