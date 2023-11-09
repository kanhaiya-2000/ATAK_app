package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: atakplugin.UASTool.pt */
public class C0751pt extends C1004wp {

    /* renamed from: a */
    public static final String f5730a = "stts";

    /* renamed from: c */
    static Map<List<C0752a>, SoftReference<long[]>> f5731c = new WeakHashMap();

    /* renamed from: d */
    static final /* synthetic */ boolean f5732d = true;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5733e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5734f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5735o = null;

    /* renamed from: b */
    List<C0752a> f5736b = Collections.emptyList();

    /* renamed from: i */
    private static /* synthetic */ void m12978i() {
        cdj cdj = new cdj("TimeToSampleBox.java", C0751pt.class);
        f5733e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        f5734f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        f5735o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    static {
        m12978i();
    }

    public C0751pt() {
        super(f5730a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5736b.size() * 8) + 8);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5736b = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            this.f5736b.add(new C0752a(C0679nk.m12495b(byteBuffer), C0679nk.m12495b(byteBuffer)));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5736b.size());
        for (C0752a next : this.f5736b) {
            C0681nm.m12515b(byteBuffer, next.mo5369a());
            C0681nm.m12515b(byteBuffer, next.mo5371b());
        }
    }

    /* renamed from: c */
    public List<C0752a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5733e, (Object) this, (Object) this));
        return this.f5736b;
    }

    /* renamed from: a */
    public void mo5367a(List<C0752a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5734f, (Object) this, (Object) this, (Object) list));
        this.f5736b = list;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5735o, (Object) this, (Object) this));
        return "TimeToSampleBox[entryCount=" + this.f5736b.size() + "]";
    }

    /* renamed from: atakplugin.UASTool.pt$a */
    public static class C0752a {

        /* renamed from: a */
        long f5737a;

        /* renamed from: b */
        long f5738b;

        public C0752a(long j, long j2) {
            this.f5737a = j;
            this.f5738b = j2;
        }

        /* renamed from: a */
        public long mo5369a() {
            return this.f5737a;
        }

        /* renamed from: b */
        public long mo5371b() {
            return this.f5738b;
        }

        /* renamed from: a */
        public void mo5370a(long j) {
            this.f5737a = j;
        }

        /* renamed from: b */
        public void mo5372b(long j) {
            this.f5738b = j;
        }

        public String toString() {
            return "Entry{count=" + this.f5737a + ", delta=" + this.f5738b + '}';
        }
    }

    /* renamed from: b */
    public static synchronized long[] m12977b(List<C0752a> list) {
        long[] jArr;
        synchronized (C0751pt.class) {
            SoftReference softReference = f5731c.get(list);
            if (softReference != null && (jArr = (long[]) softReference.get()) != null) {
                return jArr;
            }
            long j = 0;
            for (C0752a a : list) {
                j += a.mo5369a();
            }
            if (!f5732d) {
                if (j > 2147483647L) {
                    throw new AssertionError();
                }
            }
            long[] jArr2 = new long[((int) j)];
            int i = 0;
            for (C0752a next : list) {
                int i2 = 0;
                while (((long) i2) < next.mo5369a()) {
                    jArr2[i] = next.mo5371b();
                    i2++;
                    i++;
                }
            }
            f5731c.put(list, new SoftReference(jArr2));
            return jArr2;
        }
    }
}
