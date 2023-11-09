package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class aaq extends C1002wn {

    /* renamed from: a */
    public static final String f119a = "dec3";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f120e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f121f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f122o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f123p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f124q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f125r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f126s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f127t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f128u = null;

    /* renamed from: b */
    List<C0003a> f129b = new LinkedList();

    /* renamed from: c */
    int f130c;

    /* renamed from: d */
    int f131d;

    static {
        m116i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m116i() {
        cdj cdj = new cdj("EC3SpecificBox.java", aaq.class);
        f120e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContentSize", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "long"), 25);
        f121f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContent", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 65);
        f122o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "java.util.List"), 86);
        f123p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.util.List", "entries", "", "void"), 90);
        f124q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "addEntry", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "com.googlecode.mp4parser.boxes.EC3SpecificBox$Entry", "entry", "", "void"), 94);
        f125r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 98);
        f126s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "dataRate", "", "void"), 102);
        f127t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 106);
        f128u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "numIndSub", "", "void"), 110);
    }

    public aaq() {
        super(f119a);
    }

    /* renamed from: d */
    public long mo38d() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f120e, (Object) this, (Object) this));
        long j = 2;
        for (C0003a aVar : this.f129b) {
            j += aVar.f138m > 0 ? 4 : 3;
        }
        return j;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        adi adi = new adi(byteBuffer);
        this.f130c = adi.mo315a(13);
        this.f131d = adi.mo315a(3) + 1;
        for (int i = 0; i < this.f131d; i++) {
            C0003a aVar = new C0003a();
            aVar.f132g = adi.mo315a(2);
            aVar.f133h = adi.mo315a(5);
            aVar.f134i = adi.mo315a(5);
            aVar.f135j = adi.mo315a(3);
            aVar.f136k = adi.mo315a(1);
            aVar.f137l = adi.mo315a(3);
            aVar.f138m = adi.mo315a(4);
            if (aVar.f138m > 0) {
                aVar.f139n = adi.mo315a(9);
            } else {
                aVar.f140o = adi.mo315a(1);
            }
            this.f129b.add(aVar);
        }
    }

    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f121f, (Object) this, (Object) this, (Object) byteBuffer));
        adj adj = new adj(byteBuffer);
        adj.mo320a(this.f130c, 13);
        adj.mo320a(this.f129b.size() - 1, 3);
        for (C0003a next : this.f129b) {
            adj.mo320a(next.f132g, 2);
            adj.mo320a(next.f133h, 5);
            adj.mo320a(next.f134i, 5);
            adj.mo320a(next.f135j, 3);
            adj.mo320a(next.f136k, 1);
            adj.mo320a(next.f137l, 3);
            adj.mo320a(next.f138m, 4);
            if (next.f138m > 0) {
                adj.mo320a(next.f139n, 9);
            } else {
                adj.mo320a(next.f140o, 1);
            }
        }
    }

    /* renamed from: a */
    public List<C0003a> mo92a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f122o, (Object) this, (Object) this));
        return this.f129b;
    }

    /* renamed from: a */
    public void mo95a(List<C0003a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f123p, (Object) this, (Object) this, (Object) list));
        this.f129b = list;
    }

    /* renamed from: a */
    public void mo94a(C0003a aVar) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f124q, (Object) this, (Object) this, (Object) aVar));
        this.f129b.add(aVar);
    }

    /* renamed from: b */
    public int mo96b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f125r, (Object) this, (Object) this));
        return this.f130c;
    }

    /* renamed from: a */
    public void mo93a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f126s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f130c = i;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f127t, (Object) this, (Object) this));
        return this.f131d;
    }

    /* renamed from: b */
    public void mo97b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f128u, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f131d = i;
    }

    /* renamed from: atakplugin.UASTool.aaq$a */
    public static class C0003a {

        /* renamed from: g */
        public int f132g;

        /* renamed from: h */
        public int f133h;

        /* renamed from: i */
        public int f134i;

        /* renamed from: j */
        public int f135j;

        /* renamed from: k */
        public int f136k;

        /* renamed from: l */
        public int f137l;

        /* renamed from: m */
        public int f138m;

        /* renamed from: n */
        public int f139n;

        /* renamed from: o */
        public int f140o;

        public String toString() {
            return "Entry{fscod=" + this.f132g + ", bsid=" + this.f133h + ", bsmod=" + this.f134i + ", acmod=" + this.f135j + ", lfeon=" + this.f136k + ", reserved=" + this.f137l + ", num_dep_sub=" + this.f138m + ", chan_loc=" + this.f139n + ", reserved2=" + this.f140o + '}';
        }
    }
}
