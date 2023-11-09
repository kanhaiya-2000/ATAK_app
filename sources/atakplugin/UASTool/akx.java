package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import java.nio.ByteBuffer;

public class akx extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f1748A = null;

    /* renamed from: a */
    public static final String f1749a = "saiz";

    /* renamed from: b */
    static final /* synthetic */ boolean f1750b = true;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f1751p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f1752q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f1753r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f1754s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f1755t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f1756u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f1757v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f1758w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f1759x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f1760y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f1761z = null;

    /* renamed from: c */
    private short f1762c;

    /* renamed from: d */
    private short[] f1763d = new short[0];

    /* renamed from: e */
    private int f1764e;

    /* renamed from: f */
    private String f1765f;

    /* renamed from: o */
    private String f1766o;

    /* renamed from: m */
    private static /* synthetic */ void m2029m() {
        cdj cdj = new cdj("SampleAuxiliaryInformationSizesBox.java", akx.class);
        f1751p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", UASPoint.COTDETAIL_INDEX, "", "short"), 57);
        f1752q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 106);
        f1761z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 146);
        f1748A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 151);
        f1753r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 110);
        f1754s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 114);
        f1755t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 118);
        f1756u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 122);
        f1757v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 126);
        f1758w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "[S"), 131);
        f1759x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "[S", "sampleInfoSizes", "", "void"), 137);
        f1760y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 142);
    }

    static {
        m2029m();
    }

    public akx() {
        super(f1749a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (((mo456b_() & 1) == 1 ? 12 : 4) + 5 + (this.f1762c == 0 ? this.f1763d.length : 0));
    }

    /* renamed from: c */
    public short mo1200c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1751p, (Object) this, (Object) this, ccw.m11301a(i)));
        if (mo1203j() == 0) {
            return this.f1763d[i];
        }
        return this.f1762c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if ((mo456b_() & 1) == 1) {
            byteBuffer.put(C0678nj.m12488a(this.f1765f));
            byteBuffer.put(C0678nj.m12488a(this.f1766o));
        }
        C0681nm.m12521d(byteBuffer, (int) this.f1762c);
        if (this.f1762c == 0) {
            C0681nm.m12515b(byteBuffer, (long) this.f1763d.length);
            for (short d : this.f1763d) {
                C0681nm.m12521d(byteBuffer, (int) d);
            }
            return;
        }
        C0681nm.m12515b(byteBuffer, (long) this.f1764e);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if ((mo456b_() & 1) == 1) {
            this.f1765f = C0679nk.m12506m(byteBuffer);
            this.f1766o = C0679nk.m12506m(byteBuffer);
        }
        this.f1762c = (short) C0679nk.m12499f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f1764e = a;
        if (this.f1762c == 0) {
            this.f1763d = new short[a];
            for (int i = 0; i < this.f1764e; i++) {
                this.f1763d[i] = (short) C0679nk.m12499f(byteBuffer);
            }
        }
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1752q, (Object) this, (Object) this));
        return this.f1765f;
    }

    /* renamed from: a */
    public void mo1197a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1753r, (Object) this, (Object) this, (Object) str));
        this.f1765f = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1754s, (Object) this, (Object) this));
        return this.f1766o;
    }

    /* renamed from: b */
    public void mo1199b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1755t, (Object) this, (Object) this, (Object) str));
        this.f1766o = str;
    }

    /* renamed from: j */
    public int mo1203j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1756u, (Object) this, (Object) this));
        return this.f1762c;
    }

    /* renamed from: d */
    public void mo1201d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1757v, (Object) this, (Object) this, ccw.m11301a(i)));
        if (f1750b || i <= 255) {
            this.f1762c = (short) i;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: k */
    public short[] mo1204k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1758w, (Object) this, (Object) this));
        short[] sArr = this.f1763d;
        short[] sArr2 = new short[sArr.length];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        return sArr2;
    }

    /* renamed from: a */
    public void mo1198a(short[] sArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1759x, (Object) this, (Object) this, (Object) sArr));
        short[] sArr2 = new short[sArr.length];
        this.f1763d = sArr2;
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
    }

    /* renamed from: l */
    public int mo1205l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1760y, (Object) this, (Object) this));
        return this.f1764e;
    }

    /* renamed from: e */
    public void mo1202e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1761z, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f1764e = i;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1748A, (Object) this, (Object) this));
        return "SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=" + this.f1762c + ", sampleCount=" + this.f1764e + ", auxInfoType='" + this.f1765f + '\'' + ", auxInfoTypeParameter='" + this.f1766o + '\'' + '}';
    }
}
