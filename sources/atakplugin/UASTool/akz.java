package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class akz extends C1002wn {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f1770A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f1771B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f1772C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f1773D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f1774E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f1775F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f1776G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f1777H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f1778I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f1779J = null;

    /* renamed from: K */
    private static final /* synthetic */ can.C0296b f1780K = null;

    /* renamed from: L */
    private static final /* synthetic */ can.C0296b f1781L = null;

    /* renamed from: M */
    private static final /* synthetic */ can.C0296b f1782M = null;

    /* renamed from: N */
    private static final /* synthetic */ can.C0296b f1783N = null;

    /* renamed from: a */
    public static final String f1784a = "avcC";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f1785c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f1786d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f1787e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f1788f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f1789o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f1790p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f1791q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f1792r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f1793s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f1794t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f1795u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f1796v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f1797w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f1798x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f1799y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f1800z = null;

    /* renamed from: b */
    public ala f1801b = new ala();

    static {
        m2050u();
    }

    /* renamed from: u */
    private static /* synthetic */ void m2050u() {
        cdj cdj = new cdj("AvcConfigurationBox.java", akz.class);
        f1785c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        f1786d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        f1795u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        f1796v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        f1797w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        f1798x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        f1799y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        f1800z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        f1770A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        f1771B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        f1772C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        f1773D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        f1787e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        f1774E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        f1775F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        f1776G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), 132);
        f1777H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 136);
        f1778I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 147);
        f1779J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        f1780K = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        f1781L = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 162);
        f1782M = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        f1783N = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        f1788f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        f1789o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        f1790p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        f1791q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        f1792r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        f1793s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        f1794t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    public akz() {
        super(f1784a);
    }

    /* renamed from: a */
    public int mo1209a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1785c, (Object) this, (Object) this));
        return this.f1801b.f1803a;
    }

    /* renamed from: b */
    public int mo1213b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1786d, (Object) this, (Object) this));
        return this.f1801b.f1804b;
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1787e, (Object) this, (Object) this));
        return this.f1801b.f1805c;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1788f, (Object) this, (Object) this));
        return this.f1801b.f1806d;
    }

    /* renamed from: j */
    public int mo1223j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1789o, (Object) this, (Object) this));
        return this.f1801b.f1807e;
    }

    /* renamed from: k */
    public List<byte[]> mo1224k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1790p, (Object) this, (Object) this));
        return Collections.unmodifiableList(this.f1801b.f1808f);
    }

    /* renamed from: l */
    public List<byte[]> mo1225l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1791q, (Object) this, (Object) this));
        return Collections.unmodifiableList(this.f1801b.f1809g);
    }

    /* renamed from: a */
    public void mo1210a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1792r, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1803a = i;
    }

    /* renamed from: b */
    public void mo1214b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1793s, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1804b = i;
    }

    /* renamed from: c */
    public void mo1216c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1794t, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1805c = i;
    }

    /* renamed from: d */
    public void mo1218d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1795u, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1806d = i;
    }

    /* renamed from: e */
    public void mo1219e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1796v, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1807e = i;
    }

    /* renamed from: a */
    public void mo1211a(List<byte[]> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1797w, (Object) this, (Object) this, (Object) list));
        this.f1801b.f1808f = list;
    }

    /* renamed from: b */
    public void mo1215b(List<byte[]> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1798x, (Object) this, (Object) this, (Object) list));
        this.f1801b.f1809g = list;
    }

    /* renamed from: m */
    public int mo1226m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1799y, (Object) this, (Object) this));
        return this.f1801b.f1811i;
    }

    /* renamed from: f */
    public void mo1220f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1800z, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1811i = i;
    }

    /* renamed from: n */
    public int mo1227n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1770A, (Object) this, (Object) this));
        return this.f1801b.f1812j;
    }

    /* renamed from: g */
    public void mo1221g(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1771B, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1812j = i;
    }

    /* renamed from: o */
    public int mo1228o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1772C, (Object) this, (Object) this));
        return this.f1801b.f1813k;
    }

    /* renamed from: h */
    public void mo1222h(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1773D, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1801b.f1813k = i;
    }

    /* renamed from: p */
    public List<byte[]> mo1229p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1774E, (Object) this, (Object) this));
        return this.f1801b.f1814l;
    }

    /* renamed from: c */
    public void mo1217c(List<byte[]> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1775F, (Object) this, (Object) this, (Object) list));
        this.f1801b.f1814l = list;
    }

    /* renamed from: q */
    public boolean mo1230q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1776G, (Object) this, (Object) this));
        return this.f1801b.f1810h;
    }

    /* renamed from: a */
    public void mo1212a(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1777H, (Object) this, (Object) this, ccw.m11304a(z)));
        this.f1801b.f1810h = z;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f1801b = new ala(byteBuffer);
    }

    /* renamed from: d */
    public long mo38d() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1778I, (Object) this, (Object) this));
        return this.f1801b.mo1236a();
    }

    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1779J, (Object) this, (Object) this, (Object) byteBuffer));
        this.f1801b.mo1237a(byteBuffer);
    }

    /* renamed from: r */
    public String[] mo1231r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1780K, (Object) this, (Object) this));
        return this.f1801b.mo1239c();
    }

    /* renamed from: s */
    public String[] mo1232s() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1781L, (Object) this, (Object) this));
        return this.f1801b.mo1238b();
    }

    /* renamed from: t */
    public ala mo1233t() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1782M, (Object) this, (Object) this));
        return this.f1801b;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1783N, (Object) this, (Object) this));
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.f1801b + '}';
    }
}
