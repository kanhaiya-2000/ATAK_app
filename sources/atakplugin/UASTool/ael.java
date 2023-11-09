package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ael extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f671A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f672B = null;

    /* renamed from: a */
    public static final String f673a = "sidx";

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f674p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f675q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f676r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f677s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f678t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f679u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f680v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f681w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f682x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f683y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f684z = null;

    /* renamed from: b */
    List<C0018a> f685b = new ArrayList();

    /* renamed from: c */
    long f686c;

    /* renamed from: d */
    long f687d;

    /* renamed from: e */
    long f688e;

    /* renamed from: f */
    long f689f;

    /* renamed from: o */
    int f690o;

    static {
        m708n();
    }

    /* renamed from: n */
    private static /* synthetic */ void m708n() {
        cdj cdj = new cdj("SegmentIndexBox.java", ael.class);
        f674p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.util.List"), 128);
        f675q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "java.util.List", "entries", "", "void"), 132);
        f684z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "int"), 168);
        f671A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "int", "reserved", "", "void"), 172);
        f672B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.lang.String"), 298);
        f676r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 136);
        f677s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "referenceId", "", "void"), 140);
        f678t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 144);
        f679u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "timeScale", "", "void"), 148);
        f680v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 152);
        f681w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "earliestPresentationTime", "", "void"), 156);
        f682x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 160);
        f683y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "firstOffset", "", "void"), 164);
    }

    public ael() {
        super(f673a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 12 + ((long) (mo5157a_() == 0 ? 8 : 16)) + 2 + 2 + ((long) (this.f685b.size() * 12));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f686c);
        C0681nm.m12515b(byteBuffer, this.f687d);
        if (mo5157a_() == 0) {
            C0681nm.m12515b(byteBuffer, this.f688e);
            C0681nm.m12515b(byteBuffer, this.f689f);
        } else {
            C0681nm.m12511a(byteBuffer, this.f688e);
            C0681nm.m12511a(byteBuffer, this.f689f);
        }
        C0681nm.m12514b(byteBuffer, this.f690o);
        C0681nm.m12514b(byteBuffer, this.f685b.size());
        for (C0018a next : this.f685b) {
            adj adj = new adj(byteBuffer);
            adj.mo320a(next.mo482a(), 1);
            adj.mo320a(next.mo486b(), 31);
            C0681nm.m12515b(byteBuffer, next.mo489c());
            adj adj2 = new adj(byteBuffer);
            adj2.mo320a(next.mo491d(), 1);
            adj2.mo320a(next.mo492e(), 3);
            adj2.mo320a(next.mo494f(), 28);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f686c = C0679nk.m12495b(byteBuffer);
        this.f687d = C0679nk.m12495b(byteBuffer);
        if (mo5157a_() == 0) {
            this.f688e = C0679nk.m12495b(byteBuffer);
            this.f689f = C0679nk.m12495b(byteBuffer);
        } else {
            this.f688e = C0679nk.m12501h(byteBuffer);
            this.f689f = C0679nk.m12501h(byteBuffer);
        }
        this.f690o = C0679nk.m12497d(byteBuffer);
        int d = C0679nk.m12497d(byteBuffer);
        for (int i = 0; i < d; i++) {
            adi adi = new adi(byteBuffer);
            C0018a aVar = new C0018a();
            aVar.mo483a((byte) adi.mo315a(1));
            aVar.mo484a(adi.mo315a(31));
            aVar.mo485a(C0679nk.m12495b(byteBuffer));
            adi adi2 = new adi(byteBuffer);
            aVar.mo487b((byte) adi2.mo315a(1));
            aVar.mo490c((byte) adi2.mo315a(3));
            aVar.mo488b(adi2.mo315a(28));
            this.f685b.add(aVar);
        }
    }

    /* renamed from: c */
    public List<C0018a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f674p, (Object) this, (Object) this));
        return this.f685b;
    }

    /* renamed from: a */
    public void mo472a(List<C0018a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f675q, (Object) this, (Object) this, (Object) list));
        this.f685b = list;
    }

    /* renamed from: i */
    public long mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f676r, (Object) this, (Object) this));
        return this.f686c;
    }

    /* renamed from: a */
    public void mo471a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f677s, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f686c = j;
    }

    /* renamed from: j */
    public long mo477j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f678t, (Object) this, (Object) this));
        return this.f687d;
    }

    /* renamed from: b */
    public void mo473b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f679u, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f687d = j;
    }

    /* renamed from: k */
    public long mo478k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f680v, (Object) this, (Object) this));
        return this.f688e;
    }

    /* renamed from: c */
    public void mo475c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f681w, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f688e = j;
    }

    /* renamed from: l */
    public long mo479l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f682x, (Object) this, (Object) this));
        return this.f689f;
    }

    /* renamed from: d */
    public void mo476d(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f683y, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f689f = j;
    }

    /* renamed from: m */
    public int mo480m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f684z, (Object) this, (Object) this));
        return this.f690o;
    }

    /* renamed from: c */
    public void mo474c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f671A, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f690o = i;
    }

    /* renamed from: atakplugin.UASTool.ael$a */
    public static class C0018a {

        /* renamed from: a */
        byte f691a;

        /* renamed from: b */
        int f692b;

        /* renamed from: c */
        long f693c;

        /* renamed from: d */
        byte f694d;

        /* renamed from: e */
        byte f695e;

        /* renamed from: f */
        int f696f;

        public C0018a() {
        }

        public C0018a(int i, int i2, long j, boolean z, int i3, int i4) {
            this.f691a = (byte) i;
            this.f692b = i2;
            this.f693c = j;
            this.f694d = z ? (byte) 1 : 0;
            this.f695e = (byte) i3;
            this.f696f = i4;
        }

        /* renamed from: a */
        public byte mo482a() {
            return this.f691a;
        }

        /* renamed from: a */
        public void mo483a(byte b) {
            this.f691a = b;
        }

        /* renamed from: b */
        public int mo486b() {
            return this.f692b;
        }

        /* renamed from: a */
        public void mo484a(int i) {
            this.f692b = i;
        }

        /* renamed from: c */
        public long mo489c() {
            return this.f693c;
        }

        /* renamed from: a */
        public void mo485a(long j) {
            this.f693c = j;
        }

        /* renamed from: d */
        public byte mo491d() {
            return this.f694d;
        }

        /* renamed from: b */
        public void mo487b(byte b) {
            this.f694d = b;
        }

        /* renamed from: e */
        public byte mo492e() {
            return this.f695e;
        }

        /* renamed from: c */
        public void mo490c(byte b) {
            this.f695e = b;
        }

        /* renamed from: f */
        public int mo494f() {
            return this.f696f;
        }

        /* renamed from: b */
        public void mo488b(int i) {
            this.f696f = i;
        }

        public String toString() {
            return "Entry{referenceType=" + this.f691a + ", referencedSize=" + this.f692b + ", subsegmentDuration=" + this.f693c + ", startsWithSap=" + this.f694d + ", sapType=" + this.f695e + ", sapDeltaTime=" + this.f696f + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0018a aVar = (C0018a) obj;
            return this.f691a == aVar.f691a && this.f692b == aVar.f692b && this.f696f == aVar.f696f && this.f695e == aVar.f695e && this.f694d == aVar.f694d && this.f693c == aVar.f693c;
        }

        public int hashCode() {
            long j = this.f693c;
            return (((((((((this.f691a * Ascii.f8526US) + this.f692b) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f694d) * 31) + this.f695e) * 31) + this.f696f;
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f672B, (Object) this, (Object) this));
        return "SegmentIndexBox{entries=" + this.f685b + ", referenceId=" + this.f686c + ", timeScale=" + this.f687d + ", earliestPresentationTime=" + this.f688e + ", firstOffset=" + this.f689f + ", reserved=" + this.f690o + '}';
    }
}
