package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.common.msg_set_actuator_control_target;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.oq */
public class C0714oq extends C1004wp {

    /* renamed from: f */
    public static final String f5500f = "iloc";

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5501o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5502p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5503q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5504r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5505s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5506t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5507u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5508v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5509w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5510x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5511y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f5512z = null;

    /* renamed from: a */
    public int f5513a = 8;

    /* renamed from: b */
    public int f5514b = 8;

    /* renamed from: c */
    public int f5515c = 8;

    /* renamed from: d */
    public int f5516d = 0;

    /* renamed from: e */
    public List<C0716b> f5517e = new LinkedList();

    static {
        m12715m();
    }

    /* renamed from: m */
    private static /* synthetic */ void m12715m() {
        cdj cdj = new cdj("ItemLocationBox.java", C0714oq.class);
        f5501o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        f5502p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        f5511y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        f5512z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), 285);
        f5503q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        f5504r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        f5505s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        f5506t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), (int) msg_set_actuator_control_target.MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET);
        f5507u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 143);
        f5508v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        f5509w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), 151);
        f5510x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", "items", "", "void"), 155);
    }

    public C0714oq() {
        super(f5500f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        long j = 8;
        for (C0716b a : this.f5517e) {
            j += (long) a.mo5215a();
        }
        return j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12521d(byteBuffer, (this.f5513a << 4) | this.f5514b);
        if (mo5157a_() == 1) {
            C0681nm.m12521d(byteBuffer, (this.f5515c << 4) | this.f5516d);
        } else {
            C0681nm.m12521d(byteBuffer, this.f5515c << 4);
        }
        C0681nm.m12514b(byteBuffer, this.f5517e.size());
        for (C0716b a : this.f5517e) {
            a.mo5217a(byteBuffer);
        }
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        this.f5513a = f >>> 4;
        this.f5514b = f & 15;
        int f2 = C0679nk.m12499f(byteBuffer);
        this.f5515c = f2 >>> 4;
        if (mo5157a_() == 1) {
            this.f5516d = f2 & 15;
        }
        int d = C0679nk.m12497d(byteBuffer);
        for (int i = 0; i < d; i++) {
            this.f5517e.add(new C0716b(byteBuffer));
        }
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5501o, (Object) this, (Object) this));
        return this.f5513a;
    }

    /* renamed from: c */
    public void mo5203c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5502p, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5513a = i;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5503q, (Object) this, (Object) this));
        return this.f5514b;
    }

    /* renamed from: d */
    public void mo5204d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5504r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5514b = i;
    }

    /* renamed from: j */
    public int mo5207j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5505s, (Object) this, (Object) this));
        return this.f5515c;
    }

    /* renamed from: e */
    public void mo5205e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5506t, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5515c = i;
    }

    /* renamed from: k */
    public int mo5208k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5507u, (Object) this, (Object) this));
        return this.f5516d;
    }

    /* renamed from: f */
    public void mo5206f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5508v, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5516d = i;
    }

    /* renamed from: l */
    public List<C0716b> mo5209l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5509w, (Object) this, (Object) this));
        return this.f5517e;
    }

    /* renamed from: a */
    public void mo5202a(List<C0716b> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5510x, (Object) this, (Object) this, (Object) list));
        this.f5517e = list;
    }

    /* renamed from: a */
    public C0716b mo5201a(int i, int i2, int i3, long j, List<C0715a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11379a(f5511y, (Object) this, (Object) this, new Object[]{ccw.m11301a(i), ccw.m11301a(i2), ccw.m11301a(i3), ccw.m11302a(j), list}));
        return new C0716b(i, i2, i3, j, list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0716b mo112c(ByteBuffer byteBuffer) {
        return new C0716b(byteBuffer);
    }

    /* renamed from: atakplugin.UASTool.oq$b */
    public class C0716b {

        /* renamed from: a */
        public int f5522a;

        /* renamed from: b */
        public int f5523b;

        /* renamed from: c */
        public int f5524c;

        /* renamed from: d */
        public long f5525d;

        /* renamed from: e */
        public List<C0715a> f5526e = new LinkedList();

        public C0716b(ByteBuffer byteBuffer) {
            this.f5522a = C0679nk.m12497d(byteBuffer);
            if (C0714oq.this.mo5157a_() == 1) {
                this.f5523b = C0679nk.m12497d(byteBuffer) & 15;
            }
            this.f5524c = C0679nk.m12497d(byteBuffer);
            if (C0714oq.this.f5515c > 0) {
                this.f5525d = C0680nl.m12508a(byteBuffer, C0714oq.this.f5515c);
            } else {
                this.f5525d = 0;
            }
            int d = C0679nk.m12497d(byteBuffer);
            for (int i = 0; i < d; i++) {
                this.f5526e.add(new C0715a(byteBuffer));
            }
        }

        public C0716b(int i, int i2, int i3, long j, List<C0715a> list) {
            this.f5522a = i;
            this.f5523b = i2;
            this.f5524c = i3;
            this.f5525d = j;
            this.f5526e = list;
        }

        /* renamed from: a */
        public int mo5215a() {
            int i = (C0714oq.this.mo5157a_() == 1 ? 4 : 2) + 2 + C0714oq.this.f5515c + 2;
            for (C0715a a : this.f5526e) {
                i += a.mo5210a();
            }
            return i;
        }

        /* renamed from: a */
        public void mo5216a(long j) {
            this.f5525d = j;
        }

        /* renamed from: a */
        public void mo5217a(ByteBuffer byteBuffer) {
            C0681nm.m12514b(byteBuffer, this.f5522a);
            if (C0714oq.this.mo5157a_() == 1) {
                C0681nm.m12514b(byteBuffer, this.f5523b);
            }
            C0681nm.m12514b(byteBuffer, this.f5524c);
            if (C0714oq.this.f5515c > 0) {
                C0682nn.m12524a(this.f5525d, byteBuffer, C0714oq.this.f5515c);
            }
            C0681nm.m12514b(byteBuffer, this.f5526e.size());
            for (C0715a a : this.f5526e) {
                a.mo5211a(byteBuffer);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0716b bVar = (C0716b) obj;
            if (this.f5525d != bVar.f5525d || this.f5523b != bVar.f5523b || this.f5524c != bVar.f5524c || this.f5522a != bVar.f5522a) {
                return false;
            }
            List<C0715a> list = this.f5526e;
            List<C0715a> list2 = bVar.f5526e;
            return list == null ? list2 == null : list.equals(list2);
        }

        public int hashCode() {
            long j = this.f5525d;
            int i = ((((((this.f5522a * 31) + this.f5523b) * 31) + this.f5524c) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            List<C0715a> list = this.f5526e;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Item{baseOffset=" + this.f5525d + ", itemId=" + this.f5522a + ", constructionMethod=" + this.f5523b + ", dataReferenceIndex=" + this.f5524c + ", extents=" + this.f5526e + '}';
        }
    }

    /* renamed from: a */
    public C0715a mo5200a(long j, long j2, long j3) {
        C1013wy.m14474a().mo6137a(cdj.m11379a(f5512z, (Object) this, (Object) this, new Object[]{ccw.m11302a(j), ccw.m11302a(j2), ccw.m11302a(j3)}));
        return new C0715a(j, j2, j3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0715a mo115d(ByteBuffer byteBuffer) {
        return new C0715a(byteBuffer);
    }

    /* renamed from: atakplugin.UASTool.oq$a */
    public class C0715a {

        /* renamed from: a */
        public long f5518a;

        /* renamed from: b */
        public long f5519b;

        /* renamed from: c */
        public long f5520c;

        public C0715a(long j, long j2, long j3) {
            this.f5518a = j;
            this.f5519b = j2;
            this.f5520c = j3;
        }

        public C0715a(ByteBuffer byteBuffer) {
            if (C0714oq.this.mo5157a_() == 1 && C0714oq.this.f5516d > 0) {
                this.f5520c = C0680nl.m12508a(byteBuffer, C0714oq.this.f5516d);
            }
            this.f5518a = C0680nl.m12508a(byteBuffer, C0714oq.this.f5513a);
            this.f5519b = C0680nl.m12508a(byteBuffer, C0714oq.this.f5514b);
        }

        /* renamed from: a */
        public void mo5211a(ByteBuffer byteBuffer) {
            if (C0714oq.this.mo5157a_() == 1 && C0714oq.this.f5516d > 0) {
                C0682nn.m12524a(this.f5520c, byteBuffer, C0714oq.this.f5516d);
            }
            C0682nn.m12524a(this.f5518a, byteBuffer, C0714oq.this.f5513a);
            C0682nn.m12524a(this.f5519b, byteBuffer, C0714oq.this.f5514b);
        }

        /* renamed from: a */
        public int mo5210a() {
            return (C0714oq.this.f5516d > 0 ? C0714oq.this.f5516d : 0) + C0714oq.this.f5513a + C0714oq.this.f5514b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0715a aVar = (C0715a) obj;
            return this.f5520c == aVar.f5520c && this.f5519b == aVar.f5519b && this.f5518a == aVar.f5518a;
        }

        public int hashCode() {
            long j = this.f5518a;
            long j2 = this.f5519b;
            long j3 = this.f5520c;
            return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public String toString() {
            return "Extent" + "{extentOffset=" + this.f5518a + ", extentLength=" + this.f5519b + ", extentIndex=" + this.f5520c + '}';
        }
    }
}
