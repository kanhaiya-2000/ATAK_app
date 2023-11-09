package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.pj */
public class C0738pj extends C1004wp {

    /* renamed from: a */
    public static final String f5669a = "stsz";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5670e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5671f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5672o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5673p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5674q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5675r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5676s = null;

    /* renamed from: b */
    int f5677b;

    /* renamed from: c */
    private long f5678c;

    /* renamed from: d */
    private long[] f5679d = new long[0];

    static {
        m12897k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m12897k() {
        cdj cdj = new cdj("SampleSizeBox.java", C0738pj.class);
        f5670e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        f5671f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        f5672o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", UASPoint.COTDETAIL_INDEX, "", "long"), 59);
        f5673p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        f5674q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        f5675r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        f5676s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    public C0738pj() {
        super(f5669a);
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5670e, (Object) this, (Object) this));
        return this.f5678c;
    }

    /* renamed from: a */
    public void mo5317a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5671f, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5678c = j;
    }

    /* renamed from: c */
    public long mo5319c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5672o, (Object) this, (Object) this, ccw.m11301a(i)));
        long j = this.f5678c;
        if (j > 0) {
            return j;
        }
        return this.f5679d[i];
    }

    /* renamed from: i */
    public long mo43i() {
        int length;
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5673p, (Object) this, (Object) this));
        if (this.f5678c > 0) {
            length = this.f5677b;
        } else {
            length = this.f5679d.length;
        }
        return (long) length;
    }

    /* renamed from: j */
    public long[] mo5320j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5674q, (Object) this, (Object) this));
        return this.f5679d;
    }

    /* renamed from: a */
    public void mo5318a(long[] jArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5675r, (Object) this, (Object) this, (Object) jArr));
        this.f5679d = jArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5678c == 0 ? this.f5679d.length * 4 : 0) + 12);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5678c = C0679nk.m12495b(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5677b = a;
        if (this.f5678c == 0) {
            this.f5679d = new long[a];
            for (int i = 0; i < this.f5677b; i++) {
                this.f5679d[i] = C0679nk.m12495b(byteBuffer);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5678c);
        if (this.f5678c == 0) {
            C0681nm.m12515b(byteBuffer, (long) this.f5679d.length);
            for (long b : this.f5679d) {
                C0681nm.m12515b(byteBuffer, b);
            }
            return;
        }
        C0681nm.m12515b(byteBuffer, (long) this.f5677b);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5676s, (Object) this, (Object) this));
        return "SampleSizeBox[sampleSize=" + mo36c() + ";sampleCount=" + mo43i() + "]";
    }
}
