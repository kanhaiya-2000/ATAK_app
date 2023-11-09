package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.oh */
public class C0704oh extends C1004wp {

    /* renamed from: a */
    public static final String f5433a = "elst";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5434c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5435d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5436e = null;

    /* renamed from: b */
    private List<C0705a> f5437b = new LinkedList();

    static {
        m12641i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12641i() {
        cdj cdj = new cdj("EditListBox.java", C0704oh.class);
        f5434c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.util.List"), 68);
        f5435d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.EditListBox", "java.util.List", "entries", "", "void"), 72);
        f5436e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.lang.String"), 108);
    }

    public C0704oh() {
        super(f5433a);
    }

    /* renamed from: c */
    public List<C0705a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5434c, (Object) this, (Object) this));
        return this.f5437b;
    }

    /* renamed from: a */
    public void mo5163a(List<C0705a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5435d, (Object) this, (Object) this, (Object) list));
        this.f5437b = list;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int i;
        if (mo5157a_() == 1) {
            i = this.f5437b.size() * 20;
        } else {
            i = this.f5437b.size() * 12;
        }
        return ((long) i) + 8;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5437b = new LinkedList();
        for (int i = 0; i < a; i++) {
            this.f5437b.add(new C0705a(this, byteBuffer));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5437b.size());
        for (C0705a a : this.f5437b) {
            a.mo5168a(byteBuffer);
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5436e, (Object) this, (Object) this));
        return "EditListBox{entries=" + this.f5437b + '}';
    }

    /* renamed from: atakplugin.UASTool.oh$a */
    public static class C0705a {

        /* renamed from: a */
        C0704oh f5438a;

        /* renamed from: b */
        private long f5439b;

        /* renamed from: c */
        private long f5440c;

        /* renamed from: d */
        private double f5441d;

        public C0705a(C0704oh ohVar, long j, long j2, double d) {
            this.f5439b = j;
            this.f5440c = j2;
            this.f5441d = d;
            this.f5438a = ohVar;
        }

        public C0705a(C0704oh ohVar, ByteBuffer byteBuffer) {
            if (ohVar.mo5157a_() == 1) {
                this.f5439b = C0679nk.m12501h(byteBuffer);
                this.f5440c = byteBuffer.getLong();
                this.f5441d = C0679nk.m12502i(byteBuffer);
            } else {
                this.f5439b = C0679nk.m12495b(byteBuffer);
                this.f5440c = (long) byteBuffer.getInt();
                this.f5441d = C0679nk.m12502i(byteBuffer);
            }
            this.f5438a = ohVar;
        }

        /* renamed from: a */
        public long mo5165a() {
            return this.f5439b;
        }

        /* renamed from: a */
        public void mo5167a(long j) {
            this.f5439b = j;
        }

        /* renamed from: b */
        public long mo5169b() {
            return this.f5440c;
        }

        /* renamed from: b */
        public void mo5170b(long j) {
            this.f5440c = j;
        }

        /* renamed from: c */
        public double mo5171c() {
            return this.f5441d;
        }

        /* renamed from: a */
        public void mo5166a(double d) {
            this.f5441d = d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0705a aVar = (C0705a) obj;
            return this.f5440c == aVar.f5440c && this.f5439b == aVar.f5439b;
        }

        public int hashCode() {
            long j = this.f5439b;
            long j2 = this.f5440c;
            return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        /* renamed from: a */
        public void mo5168a(ByteBuffer byteBuffer) {
            if (this.f5438a.mo5157a_() == 1) {
                C0681nm.m12511a(byteBuffer, this.f5439b);
                byteBuffer.putLong(this.f5440c);
            } else {
                C0681nm.m12515b(byteBuffer, (long) afi.m847a(this.f5439b));
                byteBuffer.putInt(afi.m847a(this.f5440c));
            }
            C0681nm.m12509a(byteBuffer, this.f5441d);
        }

        public String toString() {
            return "Entry{segmentDuration=" + this.f5439b + ", mediaTime=" + this.f5440c + ", mediaRate=" + this.f5441d + '}';
        }
    }
}
