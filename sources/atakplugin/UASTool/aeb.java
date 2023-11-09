package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class aeb extends C1004wp {

    /* renamed from: a */
    public static final String f622a = "sbgp";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f623e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f624f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f625o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f626p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f627q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f628r = null;

    /* renamed from: b */
    List<C0016a> f629b = new LinkedList();

    /* renamed from: c */
    private String f630c;

    /* renamed from: d */
    private String f631d;

    static {
        m633k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m633k() {
        cdj cdj = new cdj("SampleToGroupBox.java", aeb.class);
        f623e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 150);
        f624f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingType", "", "void"), 154);
        f625o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 158);
        f626p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingTypeParameter", "", "void"), 162);
        f627q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.util.List"), 166);
        f628r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.util.List", "entries", "", "void"), 170);
    }

    public aeb() {
        super(f622a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (mo5157a_() == 1 ? (this.f629b.size() * 8) + 16 : (this.f629b.size() * 8) + 12);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(this.f630c.getBytes());
        if (mo5157a_() == 1) {
            byteBuffer.put(this.f631d.getBytes());
        }
        C0681nm.m12515b(byteBuffer, (long) this.f629b.size());
        for (C0016a next : this.f629b) {
            C0681nm.m12515b(byteBuffer, next.mo424a());
            C0681nm.m12515b(byteBuffer, (long) next.mo427b());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f630c = C0679nk.m12506m(byteBuffer);
        if (mo5157a_() == 1) {
            this.f631d = C0679nk.m12506m(byteBuffer);
        }
        long b = C0679nk.m12495b(byteBuffer);
        while (true) {
            long j = b - 1;
            if (b > 0) {
                this.f629b.add(new C0016a((long) afi.m847a(C0679nk.m12495b(byteBuffer)), afi.m847a(C0679nk.m12495b(byteBuffer))));
                b = j;
            } else {
                return;
            }
        }
    }

    /* renamed from: atakplugin.UASTool.aeb$a */
    public static class C0016a {

        /* renamed from: a */
        private long f632a;

        /* renamed from: b */
        private int f633b;

        public C0016a(long j, int i) {
            this.f632a = j;
            this.f633b = i;
        }

        /* renamed from: a */
        public long mo424a() {
            return this.f632a;
        }

        /* renamed from: a */
        public void mo426a(long j) {
            this.f632a = j;
        }

        /* renamed from: b */
        public int mo427b() {
            return this.f633b;
        }

        /* renamed from: a */
        public void mo425a(int i) {
            this.f633b = i;
        }

        public String toString() {
            return "Entry{sampleCount=" + this.f632a + ", groupDescriptionIndex=" + this.f633b + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0016a aVar = (C0016a) obj;
            return this.f633b == aVar.f633b && this.f632a == aVar.f632a;
        }

        public int hashCode() {
            long j = this.f632a;
            return (((int) (j ^ (j >>> 32))) * 31) + this.f633b;
        }
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f623e, (Object) this, (Object) this));
        return this.f630c;
    }

    /* renamed from: a */
    public void mo420a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f624f, (Object) this, (Object) this, (Object) str));
        this.f630c = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f625o, (Object) this, (Object) this));
        return this.f631d;
    }

    /* renamed from: b */
    public void mo422b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f626p, (Object) this, (Object) this, (Object) str));
        this.f631d = str;
    }

    /* renamed from: j */
    public List<C0016a> mo423j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f627q, (Object) this, (Object) this));
        return this.f629b;
    }

    /* renamed from: a */
    public void mo421a(List<C0016a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f628r, (Object) this, (Object) this, (Object) list));
        this.f629b = list;
    }
}
