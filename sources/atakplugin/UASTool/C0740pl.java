package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.pl */
public class C0740pl extends C1004wp {

    /* renamed from: b */
    public static final String f5682b = "stsc";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5683c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5684d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5685e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5686f = null;

    /* renamed from: a */
    List<C0741a> f5687a = Collections.emptyList();

    static {
        m12915i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12915i() {
        cdj cdj = new cdj("SampleToChunkBox.java", C0740pl.class);
        f5683c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        f5684d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
        f5685e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        f5686f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    public C0740pl() {
        super(f5682b);
    }

    /* renamed from: c */
    public List<C0741a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5683c, (Object) this, (Object) this));
        return this.f5687a;
    }

    /* renamed from: a */
    public void mo5330a(List<C0741a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5684d, (Object) this, (Object) this, (Object) list));
        this.f5687a = list;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5687a.size() * 12) + 8);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5687a = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            this.f5687a.add(new C0741a(C0679nk.m12495b(byteBuffer), C0679nk.m12495b(byteBuffer), C0679nk.m12495b(byteBuffer)));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5687a.size());
        for (C0741a next : this.f5687a) {
            C0681nm.m12515b(byteBuffer, next.mo5333a());
            C0681nm.m12515b(byteBuffer, next.mo5335b());
            C0681nm.m12515b(byteBuffer, next.mo5337c());
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5685e, (Object) this, (Object) this));
        return "SampleToChunkBox[entryCount=" + this.f5687a.size() + "]";
    }

    /* renamed from: c */
    public long[] mo5331c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5686f, (Object) this, (Object) this, ccw.m11301a(i)));
        long[] jArr = new long[i];
        LinkedList linkedList = new LinkedList(this.f5687a);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        C0741a aVar = (C0741a) it.next();
        while (i > 1) {
            jArr[i - 1] = aVar.mo5335b();
            if (((long) i) == aVar.mo5333a()) {
                aVar = (C0741a) it.next();
            }
            i--;
        }
        jArr[0] = aVar.mo5335b();
        return jArr;
    }

    /* renamed from: atakplugin.UASTool.pl$a */
    public static class C0741a {

        /* renamed from: a */
        long f5688a;

        /* renamed from: b */
        long f5689b;

        /* renamed from: c */
        long f5690c;

        public C0741a(long j, long j2, long j3) {
            this.f5688a = j;
            this.f5689b = j2;
            this.f5690c = j3;
        }

        /* renamed from: a */
        public long mo5333a() {
            return this.f5688a;
        }

        /* renamed from: a */
        public void mo5334a(long j) {
            this.f5688a = j;
        }

        /* renamed from: b */
        public long mo5335b() {
            return this.f5689b;
        }

        /* renamed from: b */
        public void mo5336b(long j) {
            this.f5689b = j;
        }

        /* renamed from: c */
        public long mo5337c() {
            return this.f5690c;
        }

        /* renamed from: c */
        public void mo5338c(long j) {
            this.f5690c = j;
        }

        public String toString() {
            return "Entry{firstChunk=" + this.f5688a + ", samplesPerChunk=" + this.f5689b + ", sampleDescriptionIndex=" + this.f5690c + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0741a aVar = (C0741a) obj;
            return this.f5688a == aVar.f5688a && this.f5690c == aVar.f5690c && this.f5689b == aVar.f5689b;
        }

        public int hashCode() {
            long j = this.f5688a;
            long j2 = this.f5689b;
            long j3 = this.f5690c;
            return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }
}
