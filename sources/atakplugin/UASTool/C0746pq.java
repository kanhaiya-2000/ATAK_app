package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atakplugin.UASTool.pq */
public class C0746pq extends C1004wp {

    /* renamed from: a */
    public static final String f5712a = "subs";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5713c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5714d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5715e = null;

    /* renamed from: b */
    private List<C0747a> f5716b = new ArrayList();

    static {
        m12949i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12949i() {
        cdj cdj = new cdj("SubSampleInformationBox.java", C0746pq.class);
        f5713c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.util.List"), 50);
        f5714d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "java.util.List", "entries", "", "void"), 54);
        f5715e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.lang.String"), 124);
    }

    public C0746pq() {
        super(f5712a);
    }

    /* renamed from: c */
    public List<C0747a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5713c, (Object) this, (Object) this));
        return this.f5716b;
    }

    /* renamed from: a */
    public void mo5348a(List<C0747a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5714d, (Object) this, (Object) this, (Object) list));
        this.f5716b = list;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        long j = 8;
        for (C0747a next : this.f5716b) {
            j = j + 4 + 2;
            for (int i = 0; i < next.mo5353c().size(); i++) {
                j = (mo5157a_() == 1 ? j + 4 : j + 2) + 2 + 4;
            }
        }
        return j;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        long b = C0679nk.m12495b(byteBuffer);
        for (int i = 0; ((long) i) < b; i++) {
            C0747a aVar = new C0747a();
            aVar.mo5351a(C0679nk.m12495b(byteBuffer));
            int d = C0679nk.m12497d(byteBuffer);
            for (int i2 = 0; i2 < d; i2++) {
                C0747a.C0748a aVar2 = new C0747a.C0748a();
                aVar2.mo5357a(mo5157a_() == 1 ? C0679nk.m12495b(byteBuffer) : (long) C0679nk.m12497d(byteBuffer));
                aVar2.mo5356a(C0679nk.m12499f(byteBuffer));
                aVar2.mo5359b(C0679nk.m12499f(byteBuffer));
                aVar2.mo5360b(C0679nk.m12495b(byteBuffer));
                aVar.mo5353c().add(aVar2);
            }
            this.f5716b.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5716b.size());
        for (C0747a next : this.f5716b) {
            C0681nm.m12515b(byteBuffer, next.mo5350a());
            C0681nm.m12514b(byteBuffer, next.mo5352b());
            for (C0747a.C0748a next2 : next.mo5353c()) {
                if (mo5157a_() == 1) {
                    C0681nm.m12515b(byteBuffer, next2.mo5355a());
                } else {
                    C0681nm.m12514b(byteBuffer, afi.m847a(next2.mo5355a()));
                }
                C0681nm.m12521d(byteBuffer, next2.mo5358b());
                C0681nm.m12521d(byteBuffer, next2.mo5361c());
                C0681nm.m12515b(byteBuffer, next2.mo5362d());
            }
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5715e, (Object) this, (Object) this));
        return "SubSampleInformationBox{entryCount=" + this.f5716b.size() + ", entries=" + this.f5716b + '}';
    }

    /* renamed from: atakplugin.UASTool.pq$a */
    public static class C0747a {

        /* renamed from: a */
        private long f5717a;

        /* renamed from: b */
        private List<C0748a> f5718b = new ArrayList();

        /* renamed from: a */
        public long mo5350a() {
            return this.f5717a;
        }

        /* renamed from: a */
        public void mo5351a(long j) {
            this.f5717a = j;
        }

        /* renamed from: b */
        public int mo5352b() {
            return this.f5718b.size();
        }

        /* renamed from: c */
        public List<C0748a> mo5353c() {
            return this.f5718b;
        }

        /* renamed from: atakplugin.UASTool.pq$a$a */
        public static class C0748a {

            /* renamed from: a */
            private long f5719a;

            /* renamed from: b */
            private int f5720b;

            /* renamed from: c */
            private int f5721c;

            /* renamed from: d */
            private long f5722d;

            /* renamed from: a */
            public long mo5355a() {
                return this.f5719a;
            }

            /* renamed from: a */
            public void mo5357a(long j) {
                this.f5719a = j;
            }

            /* renamed from: b */
            public int mo5358b() {
                return this.f5720b;
            }

            /* renamed from: a */
            public void mo5356a(int i) {
                this.f5720b = i;
            }

            /* renamed from: c */
            public int mo5361c() {
                return this.f5721c;
            }

            /* renamed from: b */
            public void mo5359b(int i) {
                this.f5721c = i;
            }

            /* renamed from: d */
            public long mo5362d() {
                return this.f5722d;
            }

            /* renamed from: b */
            public void mo5360b(long j) {
                this.f5722d = j;
            }

            public String toString() {
                return "SubsampleEntry{subsampleSize=" + this.f5719a + ", subsamplePriority=" + this.f5720b + ", discardable=" + this.f5721c + ", reserved=" + this.f5722d + '}';
            }
        }

        public String toString() {
            return "SampleEntry{sampleDelta=" + this.f5717a + ", subsampleCount=" + this.f5718b.size() + ", subsampleEntries=" + this.f5718b + '}';
        }
    }
}
