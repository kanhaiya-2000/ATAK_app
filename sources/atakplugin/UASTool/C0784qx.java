package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: atakplugin.UASTool.qx */
public class C0784qx extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f5957A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f5958B = null;

    /* renamed from: a */
    public static final String f5959a = "tfra";

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5960p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5961q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5962r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5963s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5964t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5965u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5966v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5967w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5968x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5969y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f5970z = null;

    /* renamed from: b */
    private long f5971b;

    /* renamed from: c */
    private int f5972c;

    /* renamed from: d */
    private int f5973d = 2;

    /* renamed from: e */
    private int f5974e = 2;

    /* renamed from: f */
    private int f5975f = 2;

    /* renamed from: o */
    private List<C0785a> f5976o = Collections.emptyList();

    static {
        m13209o();
    }

    /* renamed from: o */
    private static /* synthetic */ void m13209o() {
        cdj cdj = new cdj("TrackFragmentRandomAccessBox.java", C0784qx.class);
        f5960p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "long", "trackId", "", "void"), 145);
        f5961q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), 149);
        f5970z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 185);
        f5957A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "java.util.List", "entries", "", "void"), 189);
        f5958B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.lang.String"), 290);
        f5962r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), 153);
        f5963s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 157);
        f5964t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 161);
        f5965u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 165);
        f5966v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 169);
        f5967w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 173);
        f5968x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 177);
        f5969y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getNumberOfEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 181);
    }

    public C0784qx() {
        super(f5959a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int i;
        if (mo5157a_() == 1) {
            i = this.f5976o.size() * 16;
        } else {
            i = this.f5976o.size() * 8;
        }
        return 16 + ((long) i) + ((long) (this.f5973d * this.f5976o.size())) + ((long) (this.f5974e * this.f5976o.size())) + ((long) (this.f5975f * this.f5976o.size()));
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5971b = C0679nk.m12495b(byteBuffer);
        long b = C0679nk.m12495b(byteBuffer);
        this.f5972c = (int) (b >> 6);
        this.f5973d = (((int) (63 & b)) >> 4) + 1;
        this.f5974e = (((int) (12 & b)) >> 2) + 1;
        this.f5975f = ((int) (b & 3)) + 1;
        long b2 = C0679nk.m12495b(byteBuffer);
        this.f5976o = new ArrayList();
        for (int i = 0; ((long) i) < b2; i++) {
            C0785a aVar = new C0785a();
            if (mo5157a_() == 1) {
                aVar.f5977a = C0679nk.m12501h(byteBuffer);
                aVar.f5978b = C0679nk.m12501h(byteBuffer);
            } else {
                aVar.f5977a = C0679nk.m12495b(byteBuffer);
                aVar.f5978b = C0679nk.m12495b(byteBuffer);
            }
            aVar.f5979c = C0680nl.m12508a(byteBuffer, this.f5973d);
            aVar.f5980d = C0680nl.m12508a(byteBuffer, this.f5974e);
            aVar.f5981e = C0680nl.m12508a(byteBuffer, this.f5975f);
            this.f5976o.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5971b);
        C0681nm.m12515b(byteBuffer, ((long) (this.f5972c << 6)) | ((long) (((this.f5973d - 1) & 3) << 4)) | ((long) (((this.f5974e - 1) & 3) << 2)) | ((long) ((this.f5975f - 1) & 3)));
        C0681nm.m12515b(byteBuffer, (long) this.f5976o.size());
        for (C0785a next : this.f5976o) {
            if (mo5157a_() == 1) {
                C0681nm.m12511a(byteBuffer, next.f5977a);
                C0681nm.m12511a(byteBuffer, next.f5978b);
            } else {
                C0681nm.m12515b(byteBuffer, next.f5977a);
                C0681nm.m12515b(byteBuffer, next.f5978b);
            }
            C0682nn.m12524a(next.f5979c, byteBuffer, this.f5973d);
            C0682nn.m12524a(next.f5980d, byteBuffer, this.f5974e);
            C0682nn.m12524a(next.f5981e, byteBuffer, this.f5975f);
        }
    }

    /* renamed from: a */
    public void mo5513a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5960p, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5971b = j;
    }

    /* renamed from: c */
    public void mo5515c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5961q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5973d = i;
    }

    /* renamed from: d */
    public void mo5516d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5962r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5974e = i;
    }

    /* renamed from: e */
    public void mo5517e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5963s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5975f = i;
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5964t, (Object) this, (Object) this));
        return this.f5971b;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5965u, (Object) this, (Object) this));
        return this.f5972c;
    }

    /* renamed from: j */
    public int mo5518j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5966v, (Object) this, (Object) this));
        return this.f5973d;
    }

    /* renamed from: k */
    public int mo5519k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5967w, (Object) this, (Object) this));
        return this.f5974e;
    }

    /* renamed from: l */
    public int mo5520l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5968x, (Object) this, (Object) this));
        return this.f5975f;
    }

    /* renamed from: m */
    public long mo5521m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5969y, (Object) this, (Object) this));
        return (long) this.f5976o.size();
    }

    /* renamed from: n */
    public List<C0785a> mo5522n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5970z, (Object) this, (Object) this));
        return Collections.unmodifiableList(this.f5976o);
    }

    /* renamed from: a */
    public void mo5514a(List<C0785a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5957A, (Object) this, (Object) this, (Object) list));
        this.f5976o = list;
    }

    /* renamed from: atakplugin.UASTool.qx$a */
    public static class C0785a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public long f5977a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long f5978b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public long f5979c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public long f5980d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f5981e;

        public C0785a() {
        }

        public C0785a(long j, long j2, long j3, long j4, long j5) {
            this.f5978b = j2;
            this.f5981e = j5;
            this.f5977a = j;
            this.f5979c = j3;
            this.f5980d = j4;
        }

        /* renamed from: a */
        public long mo5524a() {
            return this.f5977a;
        }

        /* renamed from: b */
        public long mo5526b() {
            return this.f5978b;
        }

        /* renamed from: c */
        public long mo5528c() {
            return this.f5979c;
        }

        /* renamed from: d */
        public long mo5530d() {
            return this.f5980d;
        }

        /* renamed from: e */
        public long mo5532e() {
            return this.f5981e;
        }

        /* renamed from: a */
        public void mo5525a(long j) {
            this.f5977a = j;
        }

        /* renamed from: b */
        public void mo5527b(long j) {
            this.f5978b = j;
        }

        /* renamed from: c */
        public void mo5529c(long j) {
            this.f5979c = j;
        }

        /* renamed from: d */
        public void mo5531d(long j) {
            this.f5980d = j;
        }

        /* renamed from: e */
        public void mo5533e(long j) {
            this.f5981e = j;
        }

        public String toString() {
            return "Entry{time=" + this.f5977a + ", moofOffset=" + this.f5978b + ", trafNumber=" + this.f5979c + ", trunNumber=" + this.f5980d + ", sampleNumber=" + this.f5981e + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0785a aVar = (C0785a) obj;
            return this.f5978b == aVar.f5978b && this.f5981e == aVar.f5981e && this.f5977a == aVar.f5977a && this.f5979c == aVar.f5979c && this.f5980d == aVar.f5980d;
        }

        public int hashCode() {
            long j = this.f5977a;
            long j2 = this.f5978b;
            long j3 = this.f5979c;
            long j4 = this.f5980d;
            long j5 = this.f5981e;
            return (((((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)));
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5958B, (Object) this, (Object) this));
        return "TrackFragmentRandomAccessBox{trackId=" + this.f5971b + ", entries=" + this.f5976o + '}';
    }
}
