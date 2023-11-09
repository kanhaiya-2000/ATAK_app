package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class aea extends C1004wp {

    /* renamed from: a */
    public static final String f612a = "sgpd";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f613d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f614e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f615f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f616o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f617p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f618q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f619r = null;

    /* renamed from: b */
    private int f620b;

    /* renamed from: c */
    private List<adx> f621c = new LinkedList();

    static {
        m625j();
    }

    /* renamed from: j */
    private static /* synthetic */ void m625j() {
        cdj cdj = new cdj("SampleGroupDescriptionBox.java", aea.class);
        f613d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 145);
        f614e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 149);
        f615f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 153);
        f616o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 157);
        f617p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", "boolean"), 162);
        f618q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 183);
        f619r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 191);
    }

    public aea() {
        super(f612a);
        mo5158a_(1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        long j = (mo5157a_() == 1 ? 12 : 8) + 4;
        for (adx next : this.f621c) {
            if (mo5157a_() == 1 && this.f620b == 0) {
                j += 4;
            }
            j += (long) next.mo389f();
        }
        return j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put(C0678nj.m12488a(this.f621c.get(0).mo377a()));
        if (mo5157a_() == 1) {
            C0681nm.m12515b(byteBuffer, (long) this.f620b);
        }
        C0681nm.m12515b(byteBuffer, (long) this.f621c.size());
        for (adx next : this.f621c) {
            if (mo5157a_() == 1 && this.f620b == 0) {
                C0681nm.m12515b(byteBuffer, (long) next.mo382b().limit());
            }
            byteBuffer.put(next.mo382b());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if (mo5157a_() == 1) {
            String m = C0679nk.m12506m(byteBuffer);
            if (mo5157a_() == 1) {
                this.f620b = afi.m847a(C0679nk.m12495b(byteBuffer));
            }
            long b = C0679nk.m12495b(byteBuffer);
            while (true) {
                long j = b - 1;
                if (b > 0) {
                    int i = this.f620b;
                    if (mo5157a_() == 1) {
                        if (this.f620b == 0) {
                            i = afi.m847a(C0679nk.m12495b(byteBuffer));
                        }
                        int position = byteBuffer.position() + i;
                        ByteBuffer slice = byteBuffer.slice();
                        slice.limit(i);
                        this.f621c.add(m624a(slice, m));
                        byteBuffer.position(position);
                        b = j;
                    } else {
                        throw new RuntimeException("This should be implemented");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
    }

    /* renamed from: a */
    private adx m624a(ByteBuffer byteBuffer, String str) {
        adx adx;
        if (adz.f608a.equals(str)) {
            adx = new adz();
        } else if (ady.f599a.equals(str)) {
            adx = new ady();
        } else if (adw.f595a.equals(str)) {
            adx = new adw();
        } else if (aee.f639a.equals(str)) {
            adx = new aee();
        } else if (aec.f634a.equals(str)) {
            adx = new aec();
        } else if (alf.f1889a.equals(str)) {
            adx = new alf();
        } else if (alg.f1892a.equals(str)) {
            adx = new alg();
        } else if (alh.f1904a.equals(str)) {
            adx = new alh();
        } else if (ale.f1888a.equals(str)) {
            adx = new ale();
        } else {
            adx = new aed(str);
        }
        adx.mo379a(byteBuffer);
        return adx;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f613d, (Object) this, (Object) this));
        return this.f620b;
    }

    /* renamed from: c */
    public void mo416c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f614e, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f620b = i;
    }

    /* renamed from: i */
    public List<adx> mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f615f, (Object) this, (Object) this));
        return this.f621c;
    }

    /* renamed from: a */
    public void mo415a(List<adx> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f616o, (Object) this, (Object) this, (Object) list));
        this.f621c = list;
    }

    public boolean equals(Object obj) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f617p, (Object) this, (Object) this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aea aea = (aea) obj;
        if (this.f620b != aea.f620b) {
            return false;
        }
        List<adx> list = this.f621c;
        List<adx> list2 = aea.f621c;
        return list == null ? list2 == null : list.equals(list2);
    }

    public int hashCode() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f618q, (Object) this, (Object) this));
        int i = 0;
        int i2 = (this.f620b + 0) * 31;
        List<adx> list = this.f621c;
        if (list != null) {
            i = list.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f619r, (Object) this, (Object) this));
        StringBuilder sb = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        sb.append(this.f621c.size() > 0 ? this.f621c.get(0).mo377a() : "????");
        sb.append('\'');
        sb.append(", defaultLength=");
        sb.append(this.f620b);
        sb.append(", groupEntries=");
        sb.append(this.f621c);
        sb.append('}');
        return sb.toString();
    }
}
