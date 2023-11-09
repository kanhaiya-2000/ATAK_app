package atakplugin.UASTool;

import atakplugin.UASTool.alc;
import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.List;

public class alb extends C1002wn {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f1820A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f1821B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f1822C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f1823D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f1824E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f1825F = null;

    /* renamed from: a */
    public static final String f1826a = "hvcC";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f1827c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f1828d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f1829e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f1830f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f1831o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f1832p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f1833q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f1834r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f1835s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f1836t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f1837u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f1838v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f1839w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f1840x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f1841y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f1842z = null;

    /* renamed from: b */
    private alc f1843b = new alc();

    static {
        m2090C();
    }

    /* renamed from: C */
    private static /* synthetic */ void m2090C() {
        cdj cdj = new cdj("HevcConfigurationBox.java", alb.class);
        f1827c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHevcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord"), 38);
        f1828d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHevcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord", "hevcDecoderConfigurationRecord", "", "void"), 42);
        f1837u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGeneral_level_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 90);
        f1838v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMin_spatial_segmentation_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 94);
        f1839w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getParallelismType", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 98);
        f1840x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getChromaFormat", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 102);
        f1841y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 106);
        f1842z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 110);
        f1820A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvgFrameRate", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 114);
        f1821B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getNumTemporalLayers", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 118);
        f1822C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 122);
        f1823D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isTemporalIdNested", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 126);
        f1829e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "equals", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "java.lang.Object", "o", "", "boolean"), 47);
        f1824E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getConstantFrameRate", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 130);
        f1825F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getArrays", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "java.util.List"), 134);
        f1830f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hashCode", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 60);
        f1831o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 65);
        f1832p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGeneral_profile_space", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 69);
        f1833q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isGeneral_tier_flag", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 73);
        f1834r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGeneral_profile_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 78);
        f1835s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGeneral_profile_compatibility_flags", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 82);
        f1836t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getGeneral_constraint_indicator_flags", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 86);
    }

    public alb() {
        super(f1826a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) this.f1843b.mo1264a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        this.f1843b.mo1273b(byteBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f1843b.mo1267a(byteBuffer);
    }

    /* renamed from: a */
    public alc mo1246a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1827c, (Object) this, (Object) this));
        return this.f1843b;
    }

    /* renamed from: a */
    public void mo1247a(alc alc) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1828d, (Object) this, (Object) this, (Object) alc));
        this.f1843b = alc;
    }

    public boolean equals(Object obj) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1829e, (Object) this, (Object) this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        alc alc = this.f1843b;
        alc alc2 = ((alb) obj).f1843b;
        return alc == null ? alc2 == null : alc.equals(alc2);
    }

    public int hashCode() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1830f, (Object) this, (Object) this));
        alc alc = this.f1843b;
        if (alc != null) {
            return alc.hashCode();
        }
        return 0;
    }

    /* renamed from: b */
    public int mo1248b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1831o, (Object) this, (Object) this));
        return this.f1843b.f1845a;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1832p, (Object) this, (Object) this));
        return this.f1843b.f1846b;
    }

    /* renamed from: i */
    public boolean mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1833q, (Object) this, (Object) this));
        return this.f1843b.f1847c;
    }

    /* renamed from: j */
    public int mo1251j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1834r, (Object) this, (Object) this));
        return this.f1843b.f1848d;
    }

    /* renamed from: k */
    public long mo1252k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1835s, (Object) this, (Object) this));
        return this.f1843b.f1849e;
    }

    /* renamed from: l */
    public long mo1253l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1836t, (Object) this, (Object) this));
        return this.f1843b.f1850f;
    }

    /* renamed from: m */
    public int mo1254m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1837u, (Object) this, (Object) this));
        return this.f1843b.f1851g;
    }

    /* renamed from: n */
    public int mo1255n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1838v, (Object) this, (Object) this));
        return this.f1843b.f1853i;
    }

    /* renamed from: o */
    public int mo1256o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1839w, (Object) this, (Object) this));
        return this.f1843b.f1855k;
    }

    /* renamed from: p */
    public int mo1257p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1840x, (Object) this, (Object) this));
        return this.f1843b.f1857m;
    }

    /* renamed from: q */
    public int mo1258q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1841y, (Object) this, (Object) this));
        return this.f1843b.f1859o;
    }

    /* renamed from: r */
    public int mo1259r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1842z, (Object) this, (Object) this));
        return this.f1843b.f1861q;
    }

    /* renamed from: s */
    public int mo1260s() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1820A, (Object) this, (Object) this));
        return this.f1843b.f1862r;
    }

    /* renamed from: t */
    public int mo1261t() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1821B, (Object) this, (Object) this));
        return this.f1843b.f1864t;
    }

    /* renamed from: u */
    public int mo1262u() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1822C, (Object) this, (Object) this));
        return this.f1843b.f1866v;
    }

    /* renamed from: z */
    public boolean mo1263z() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1823D, (Object) this, (Object) this));
        return this.f1843b.f1865u;
    }

    /* renamed from: A */
    public int mo1244A() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1824E, (Object) this, (Object) this));
        return this.f1843b.f1863s;
    }

    /* renamed from: B */
    public List<alc.C0055a> mo1245B() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1825F, (Object) this, (Object) this));
        return this.f1843b.f1867w;
    }
}
