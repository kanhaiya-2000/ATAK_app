package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atakplugin.UASTool.qy */
public class C0786qy extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f5982A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f5983B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f5984C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f5985D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f5986E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f5987F = null;

    /* renamed from: a */
    public static final String f5988a = "trun";

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5989e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f5990f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f5991o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5992p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5993q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5994r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5995s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5996t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5997u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5998v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5999w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f6000x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f6001y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f6002z = null;

    /* renamed from: b */
    private int f6003b;

    /* renamed from: c */
    private C0778qr f6004c;

    /* renamed from: d */
    private List<C0787a> f6005d = new ArrayList();

    static {
        m13245s();
    }

    /* renamed from: s */
    private static /* synthetic */ void m13245s() {
        cdj cdj = new cdj("TrackRunBox.java", C0786qy.class);
        f5989e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.util.List"), 57);
        f5990f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "int", "dataOffset", "", "void"), 120);
        f5999w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 267);
        f6000x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 275);
        f6001y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 283);
        f6002z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 292);
        f5982A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "boolean", "v", "", "void"), 300);
        f5983B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "int"), 309);
        f5984C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 313);
        f5985D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "firstSampleFlags", "", "void"), 317);
        f5986E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.lang.String"), 327);
        f5987F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "java.util.List", "entries", "", "void"), 342);
        f5991o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleCompositionTimeOffsets", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "[J"), 129);
        f5992p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleCount", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "long"), 238);
        f5993q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 242);
        f5994r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isFirstSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 246);
        f5995s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 251);
        f5996t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 255);
        f5997u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 259);
        f5998v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "boolean"), 263);
    }

    /* renamed from: c */
    public List<C0787a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5989e, (Object) this, (Object) this));
        return this.f6005d;
    }

    /* renamed from: atakplugin.UASTool.qy$a */
    public static class C0787a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public long f6006a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long f6007b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C0778qr f6008c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public long f6009d;

        public C0787a() {
        }

        public C0787a(long j, long j2, C0778qr qrVar, int i) {
            this.f6006a = j;
            this.f6007b = j2;
            this.f6008c = qrVar;
            this.f6009d = (long) i;
        }

        /* renamed from: a */
        public long mo5555a() {
            return this.f6006a;
        }

        /* renamed from: b */
        public long mo5559b() {
            return this.f6007b;
        }

        /* renamed from: c */
        public C0778qr mo5561c() {
            return this.f6008c;
        }

        /* renamed from: d */
        public long mo5562d() {
            return this.f6009d;
        }

        /* renamed from: a */
        public void mo5557a(long j) {
            this.f6006a = j;
        }

        /* renamed from: b */
        public void mo5560b(long j) {
            this.f6007b = j;
        }

        /* renamed from: a */
        public void mo5558a(C0778qr qrVar) {
            this.f6008c = qrVar;
        }

        /* renamed from: a */
        public void mo5556a(int i) {
            this.f6009d = (long) i;
        }

        public String toString() {
            return "Entry{duration=" + this.f6006a + ", size=" + this.f6007b + ", dlags=" + this.f6008c + ", compTimeOffset=" + this.f6009d + '}';
        }
    }

    /* renamed from: c */
    public void mo5541c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5990f, (Object) this, (Object) this, ccw.m11301a(i)));
        if (i == -1) {
            mo5159b(mo456b_() & 16777214);
        } else {
            mo5159b(mo456b_() | 1);
        }
        this.f6003b = i;
    }

    /* renamed from: i */
    public long[] mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5991o, (Object) this, (Object) this));
        if (!mo5551p()) {
            return null;
        }
        int size = this.f6005d.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = this.f6005d.get(i).mo5562d();
        }
        return jArr;
    }

    public C0786qy() {
        super(f5988a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int b_ = mo456b_();
        long j = (b_ & 1) == 1 ? 12 : 8;
        if ((b_ & 4) == 4) {
            j += 4;
        }
        long j2 = 0;
        if ((b_ & 256) == 256) {
            j2 = 4;
        }
        if ((b_ & 512) == 512) {
            j2 += 4;
        }
        if ((b_ & 1024) == 1024) {
            j2 += 4;
        }
        if ((b_ & 2048) == 2048) {
            j2 += 4;
        }
        return j + (j2 * ((long) this.f6005d.size()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f6005d.size());
        int b_ = mo456b_();
        if ((b_ & 1) == 1) {
            C0681nm.m12515b(byteBuffer, (long) this.f6003b);
        }
        if ((b_ & 4) == 4) {
            this.f6004c.mo5458a(byteBuffer);
        }
        for (C0787a next : this.f6005d) {
            if ((b_ & 256) == 256) {
                C0681nm.m12515b(byteBuffer, next.f6006a);
            }
            if ((b_ & 512) == 512) {
                C0681nm.m12515b(byteBuffer, next.f6007b);
            }
            if ((b_ & 1024) == 1024) {
                next.f6008c.mo5458a(byteBuffer);
            }
            if ((b_ & 2048) == 2048) {
                if (mo5157a_() == 0) {
                    C0681nm.m12515b(byteBuffer, next.f6009d);
                } else {
                    byteBuffer.putInt((int) next.f6009d);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        long b = C0679nk.m12495b(byteBuffer);
        if ((mo456b_() & 1) == 1) {
            this.f6003b = afi.m847a(C0679nk.m12495b(byteBuffer));
        } else {
            this.f6003b = -1;
        }
        if ((mo456b_() & 4) == 4) {
            this.f6004c = new C0778qr(byteBuffer);
        }
        for (int i = 0; ((long) i) < b; i++) {
            C0787a aVar = new C0787a();
            if ((mo456b_() & 256) == 256) {
                aVar.f6006a = C0679nk.m12495b(byteBuffer);
            }
            if ((mo456b_() & 512) == 512) {
                aVar.f6007b = C0679nk.m12495b(byteBuffer);
            }
            if ((mo456b_() & 1024) == 1024) {
                aVar.f6008c = new C0778qr(byteBuffer);
            }
            if ((mo456b_() & 2048) == 2048) {
                aVar.f6009d = (long) byteBuffer.getInt();
            }
            this.f6005d.add(aVar);
        }
    }

    /* renamed from: j */
    public long mo5545j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5992p, (Object) this, (Object) this));
        return (long) this.f6005d.size();
    }

    /* renamed from: k */
    public boolean mo5546k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5993q, (Object) this, (Object) this));
        return (mo456b_() & 1) == 1;
    }

    /* renamed from: l */
    public boolean mo5547l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5994r, (Object) this, (Object) this));
        return (mo456b_() & 4) == 4;
    }

    /* renamed from: m */
    public boolean mo5548m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5995s, (Object) this, (Object) this));
        return (mo456b_() & 512) == 512;
    }

    /* renamed from: n */
    public boolean mo5549n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5996t, (Object) this, (Object) this));
        return (mo456b_() & 256) == 256;
    }

    /* renamed from: o */
    public boolean mo5550o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5997u, (Object) this, (Object) this));
        return (mo456b_() & 1024) == 1024;
    }

    /* renamed from: p */
    public boolean mo5551p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5998v, (Object) this, (Object) this));
        return (mo456b_() & 2048) == 2048;
    }

    /* renamed from: a */
    public void mo5539a(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5999w, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 1);
        } else {
            mo5159b(mo456b_() & 16777214);
        }
    }

    /* renamed from: b */
    public void mo5540b(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6000x, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 512);
        } else {
            mo5159b(mo456b_() & 16776703);
        }
    }

    /* renamed from: c */
    public void mo5542c(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6001y, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 256);
        } else {
            mo5159b(mo456b_() & 16776959);
        }
    }

    /* renamed from: d */
    public void mo5543d(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f6002z, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 1024);
        } else {
            mo5159b(mo456b_() & 16776191);
        }
    }

    /* renamed from: e */
    public void mo5544e(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5982A, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 2048);
        } else {
            mo5159b(mo456b_() & 16775167);
        }
    }

    /* renamed from: q */
    public int mo5552q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5983B, (Object) this, (Object) this));
        return this.f6003b;
    }

    /* renamed from: r */
    public C0778qr mo5553r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5984C, (Object) this, (Object) this));
        return this.f6004c;
    }

    /* renamed from: a */
    public void mo5537a(C0778qr qrVar) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5985D, (Object) this, (Object) this, (Object) qrVar));
        if (qrVar == null) {
            mo5159b(mo456b_() & 16777211);
        } else {
            mo5159b(mo456b_() | 4);
        }
        this.f6004c = qrVar;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5986E, (Object) this, (Object) this));
        return "TrackRunBox" + "{sampleCount=" + this.f6005d.size() + ", dataOffset=" + this.f6003b + ", dataOffsetPresent=" + mo5546k() + ", sampleSizePresent=" + mo5548m() + ", sampleDurationPresent=" + mo5549n() + ", sampleFlagsPresentPresent=" + mo5550o() + ", sampleCompositionTimeOffsetPresent=" + mo5551p() + ", firstSampleFlags=" + this.f6004c + '}';
    }

    /* renamed from: a */
    public void mo5538a(List<C0787a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5987F, (Object) this, (Object) this, (Object) list));
        this.f6005d = list;
    }
}
