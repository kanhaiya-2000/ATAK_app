package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class akw extends C1004wp {

    /* renamed from: a */
    public static final String f1738a = "saio";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f1739e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f1740f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f1741o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f1742p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f1743q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f1744r = null;

    /* renamed from: b */
    private long[] f1745b = new long[0];

    /* renamed from: c */
    private String f1746c;

    /* renamed from: d */
    private String f1747d;

    static {
        m2019k();
    }

    /* renamed from: k */
    private static /* synthetic */ void m2019k() {
        cdj cdj = new cdj("SampleAuxiliaryInformationOffsetsBox.java", akw.class);
        f1739e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 107);
        f1740f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 111);
        f1741o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 115);
        f1742p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 119);
        f1743q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "[J"), 123);
        f1744r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "[J", "offsets", "", "void"), 127);
    }

    public akw() {
        super(f1738a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int i = 8;
        int length = (mo5157a_() == 0 ? this.f1745b.length * 4 : this.f1745b.length * 8) + 8;
        if ((mo456b_() & 1) != 1) {
            i = 0;
        }
        return (long) (length + i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if ((mo456b_() & 1) == 1) {
            byteBuffer.put(C0678nj.m12488a(this.f1746c));
            byteBuffer.put(C0678nj.m12488a(this.f1747d));
        }
        C0681nm.m12515b(byteBuffer, (long) this.f1745b.length);
        for (long valueOf : this.f1745b) {
            Long valueOf2 = Long.valueOf(valueOf);
            if (mo5157a_() == 0) {
                C0681nm.m12515b(byteBuffer, valueOf2.longValue());
            } else {
                C0681nm.m12511a(byteBuffer, valueOf2.longValue());
            }
        }
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if ((mo456b_() & 1) == 1) {
            this.f1746c = C0679nk.m12506m(byteBuffer);
            this.f1747d = C0679nk.m12506m(byteBuffer);
        }
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f1745b = new long[a];
        for (int i = 0; i < a; i++) {
            if (mo5157a_() == 0) {
                this.f1745b[i] = C0679nk.m12495b(byteBuffer);
            } else {
                this.f1745b[i] = C0679nk.m12501h(byteBuffer);
            }
        }
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1739e, (Object) this, (Object) this));
        return this.f1746c;
    }

    /* renamed from: a */
    public void mo1193a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1740f, (Object) this, (Object) this, (Object) str));
        this.f1746c = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1741o, (Object) this, (Object) this));
        return this.f1747d;
    }

    /* renamed from: b */
    public void mo1195b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1742p, (Object) this, (Object) this, (Object) str));
        this.f1747d = str;
    }

    /* renamed from: j */
    public long[] mo1196j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1743q, (Object) this, (Object) this));
        return this.f1745b;
    }

    /* renamed from: a */
    public void mo1194a(long[] jArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1744r, (Object) this, (Object) this, (Object) jArr));
        this.f1745b = jArr;
    }
}
