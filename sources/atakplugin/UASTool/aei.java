package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class aei extends C1004wp {

    /* renamed from: b */
    private static final /* synthetic */ can.C0296b f650b = null;

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f651c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f652d = null;

    /* renamed from: a */
    public List<C0017a> f653a = new ArrayList();

    static {
        m681j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m681j() {
        cdj cdj = new cdj("TfrfBox.java", aei.class);
        f650b = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFragmentCount", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "long"), 91);
        f651c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.util.List"), 95);
        f652d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.lang.String"), 100);
    }

    public aei() {
        super(C0758pz.f5795b);
    }

    /* renamed from: w */
    public byte[] mo455w() {
        return new byte[]{-44, Byte.MIN_VALUE, 126, -14, -54, 57, 70, -107, -114, 84, 38, -53, -98, 70, -89, -97};
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f653a.size() * (mo5157a_() == 1 ? 16 : 8)) + 5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12521d(byteBuffer, this.f653a.size());
        for (C0017a next : this.f653a) {
            if (mo5157a_() == 1) {
                C0681nm.m12511a(byteBuffer, next.f654a);
                C0681nm.m12511a(byteBuffer, next.f655b);
            } else {
                C0681nm.m12515b(byteBuffer, next.f654a);
                C0681nm.m12515b(byteBuffer, next.f655b);
            }
        }
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        for (int i = 0; i < f; i++) {
            C0017a aVar = new C0017a();
            if (mo5157a_() == 1) {
                aVar.f654a = C0679nk.m12501h(byteBuffer);
                aVar.f655b = C0679nk.m12501h(byteBuffer);
            } else {
                aVar.f654a = C0679nk.m12495b(byteBuffer);
                aVar.f655b = C0679nk.m12495b(byteBuffer);
            }
            this.f653a.add(aVar);
        }
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f650b, (Object) this, (Object) this));
        return (long) this.f653a.size();
    }

    /* renamed from: i */
    public List<C0017a> mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f651c, (Object) this, (Object) this));
        return this.f653a;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f652d, (Object) this, (Object) this));
        return "TfrfBox" + "{entries=" + this.f653a + '}';
    }

    /* renamed from: atakplugin.UASTool.aei$a */
    public class C0017a {

        /* renamed from: a */
        long f654a;

        /* renamed from: b */
        long f655b;

        public C0017a() {
        }

        /* renamed from: a */
        public long mo463a() {
            return this.f654a;
        }

        /* renamed from: b */
        public long mo464b() {
            return this.f655b;
        }

        public String toString() {
            return "Entry" + "{fragmentAbsoluteTime=" + this.f654a + ", fragmentAbsoluteDuration=" + this.f655b + '}';
        }
    }
}
