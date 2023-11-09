package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.nio.ByteBuffer;

public class aap extends C1002wn {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f70A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f71B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f72C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f73D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f74E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f75F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f76G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f77H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f78I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f79J = null;

    /* renamed from: K */
    private static final /* synthetic */ can.C0296b f80K = null;

    /* renamed from: L */
    private static final /* synthetic */ can.C0296b f81L = null;

    /* renamed from: M */
    private static final /* synthetic */ can.C0296b f82M = null;

    /* renamed from: N */
    private static final /* synthetic */ can.C0296b f83N = null;

    /* renamed from: O */
    private static final /* synthetic */ can.C0296b f84O = null;

    /* renamed from: P */
    private static final /* synthetic */ can.C0296b f85P = null;

    /* renamed from: Q */
    private static final /* synthetic */ can.C0296b f86Q = null;

    /* renamed from: R */
    private static final /* synthetic */ can.C0296b f87R = null;

    /* renamed from: S */
    private static final /* synthetic */ can.C0296b f88S = null;

    /* renamed from: T */
    private static final /* synthetic */ can.C0296b f89T = null;

    /* renamed from: U */
    private static final /* synthetic */ can.C0296b f90U = null;

    /* renamed from: V */
    private static final /* synthetic */ can.C0296b f91V = null;

    /* renamed from: W */
    private static final /* synthetic */ can.C0296b f92W = null;

    /* renamed from: X */
    private static final /* synthetic */ can.C0296b f93X = null;

    /* renamed from: Y */
    private static final /* synthetic */ can.C0296b f94Y = null;

    /* renamed from: Z */
    private static final /* synthetic */ can.C0296b f95Z = null;

    /* renamed from: a */
    public static final String f96a = "ddts";

    /* renamed from: aa */
    private static final /* synthetic */ can.C0296b f97aa = null;

    /* renamed from: ab */
    private static final /* synthetic */ can.C0296b f98ab = null;

    /* renamed from: ac */
    private static final /* synthetic */ can.C0296b f99ac = null;

    /* renamed from: ad */
    private static final /* synthetic */ can.C0296b f100ad = null;

    /* renamed from: ae */
    private static final /* synthetic */ can.C0296b f101ae = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f102z = null;

    /* renamed from: b */
    long f103b;

    /* renamed from: c */
    long f104c;

    /* renamed from: d */
    long f105d;

    /* renamed from: e */
    int f106e;

    /* renamed from: f */
    int f107f;

    /* renamed from: o */
    int f108o;

    /* renamed from: p */
    int f109p;

    /* renamed from: q */
    int f110q;

    /* renamed from: r */
    int f111r;

    /* renamed from: s */
    int f112s;

    /* renamed from: t */
    int f113t;

    /* renamed from: u */
    int f114u;

    /* renamed from: v */
    int f115v;

    /* renamed from: w */
    int f116w;

    /* renamed from: x */
    int f117x;

    /* renamed from: y */
    int f118y;

    static {
        m79A();
    }

    /* renamed from: A */
    private static /* synthetic */ void m79A() {
        cdj cdj = new cdj("DTSSpecificBox.java", aap.class);
        f102z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 89);
        f70A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "avgBitRate", "", "void"), 93);
        f79J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 129);
        f80K = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 133);
        f81L = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 137);
        f82M = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 141);
        f83N = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 145);
        f84O = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), 149);
        f85P = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 153);
        f86Q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 157);
        f87R = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 161);
        f88S = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), 165);
        f71B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 97);
        f89T = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 169);
        f90U = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 173);
        f91V = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 177);
        f92W = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), 181);
        f93X = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 185);
        f94Y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), 189);
        f95Z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 193);
        f97aa = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), (int) MAV_CMD.MAV_CMD_DO_SET_ROI_NONE);
        f98ab = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 201);
        f99ac = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reserved", "", "void"), 205);
        f72C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 101);
        f100ad = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 209);
        f101ae = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), (int) MAV_CMD.MAV_CMD_NAV_SET_YAW_SPEED);
        f73D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 105);
        f74E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "maxBitRate", "", "void"), 109);
        f75F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 113);
        f76G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 117);
        f77H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 121);
        f78I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 125);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return 20;
    }

    public aap() {
        super(f96a);
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        this.f103b = C0679nk.m12495b(byteBuffer);
        this.f104c = C0679nk.m12495b(byteBuffer);
        this.f105d = C0679nk.m12495b(byteBuffer);
        this.f106e = C0679nk.m12499f(byteBuffer);
        adi adi = new adi(byteBuffer);
        this.f107f = adi.mo315a(2);
        this.f108o = adi.mo315a(5);
        this.f109p = adi.mo315a(1);
        this.f110q = adi.mo315a(6);
        this.f111r = adi.mo315a(14);
        this.f112s = adi.mo315a(1);
        this.f113t = adi.mo315a(3);
        this.f114u = adi.mo315a(16);
        this.f115v = adi.mo315a(1);
        this.f116w = adi.mo315a(1);
        this.f117x = adi.mo315a(1);
        this.f118y = adi.mo315a(5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C0681nm.m12515b(byteBuffer, this.f103b);
        C0681nm.m12515b(byteBuffer, this.f104c);
        C0681nm.m12515b(byteBuffer, this.f105d);
        C0681nm.m12521d(byteBuffer, this.f106e);
        adj adj = new adj(byteBuffer);
        adj.mo320a(this.f107f, 2);
        adj.mo320a(this.f108o, 5);
        adj.mo320a(this.f109p, 1);
        adj.mo320a(this.f110q, 6);
        adj.mo320a(this.f111r, 14);
        adj.mo320a(this.f112s, 1);
        adj.mo320a(this.f113t, 3);
        adj.mo320a(this.f114u, 16);
        adj.mo320a(this.f115v, 1);
        adj.mo320a(this.f116w, 1);
        adj.mo320a(this.f117x, 1);
        adj.mo320a(this.f118y, 5);
    }

    /* renamed from: a */
    public long mo61a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f102z, (Object) this, (Object) this));
        return this.f105d;
    }

    /* renamed from: a */
    public void mo63a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f70A, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f105d = j;
    }

    /* renamed from: b */
    public long mo64b() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f71B, (Object) this, (Object) this));
        return this.f103b;
    }

    /* renamed from: b */
    public void mo66b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f72C, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f103b = j;
    }

    /* renamed from: c */
    public long mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f73D, (Object) this, (Object) this));
        return this.f104c;
    }

    /* renamed from: c */
    public void mo68c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f74E, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f104c = j;
    }

    /* renamed from: i */
    public int mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f75F, (Object) this, (Object) this));
        return this.f106e;
    }

    /* renamed from: a */
    public void mo62a(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f76G, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f106e = i;
    }

    /* renamed from: j */
    public int mo75j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f77H, (Object) this, (Object) this));
        return this.f107f;
    }

    /* renamed from: b */
    public void mo65b(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f78I, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f107f = i;
    }

    /* renamed from: k */
    public int mo77k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f79J, (Object) this, (Object) this));
        return this.f108o;
    }

    /* renamed from: c */
    public void mo67c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f80K, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f108o = i;
    }

    /* renamed from: l */
    public int mo79l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f81L, (Object) this, (Object) this));
        return this.f109p;
    }

    /* renamed from: d */
    public void mo69d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f82M, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f109p = i;
    }

    /* renamed from: m */
    public int mo81m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f83N, (Object) this, (Object) this));
        return this.f110q;
    }

    /* renamed from: e */
    public void mo70e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f84O, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f110q = i;
    }

    /* renamed from: n */
    public int mo83n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f85P, (Object) this, (Object) this));
        return this.f111r;
    }

    /* renamed from: f */
    public void mo71f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f86Q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f111r = i;
    }

    /* renamed from: o */
    public int mo84o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f87R, (Object) this, (Object) this));
        return this.f112s;
    }

    /* renamed from: g */
    public void mo72g(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f88S, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f112s = i;
    }

    /* renamed from: p */
    public int mo85p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f89T, (Object) this, (Object) this));
        return this.f113t;
    }

    /* renamed from: h */
    public void mo73h(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f90U, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f113t = i;
    }

    /* renamed from: q */
    public int mo86q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f91V, (Object) this, (Object) this));
        return this.f114u;
    }

    /* renamed from: i */
    public void mo74i(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f92W, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f114u = i;
    }

    /* renamed from: r */
    public int mo87r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f93X, (Object) this, (Object) this));
        return this.f115v;
    }

    /* renamed from: j */
    public void mo76j(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f94Y, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f115v = i;
    }

    /* renamed from: s */
    public int mo88s() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f95Z, (Object) this, (Object) this));
        return this.f116w;
    }

    /* renamed from: k */
    public void mo78k(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f97aa, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f116w = i;
    }

    /* renamed from: t */
    public int mo89t() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f98ab, (Object) this, (Object) this));
        return this.f118y;
    }

    /* renamed from: l */
    public void mo80l(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f99ac, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f118y = i;
    }

    /* renamed from: u */
    public int mo90u() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f100ad, (Object) this, (Object) this));
        return this.f117x;
    }

    /* renamed from: m */
    public void mo82m(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f101ae, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f117x = i;
    }

    @C1016xa
    /* renamed from: z */
    public int[] mo91z() {
        int i;
        int i2;
        int q = mo86q();
        if ((q & 1) == 1) {
            i2 = 1;
            i = 4;
        } else {
            i2 = 0;
            i = 0;
        }
        if ((q & 2) == 2) {
            i2 += 2;
            i = i | 1 | 2;
        }
        if ((q & 4) == 4) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((q & 8) == 8) {
            i2++;
            i |= 8;
        }
        if ((q & 16) == 16) {
            i2++;
            i |= 256;
        }
        if ((q & 32) == 32) {
            i2 += 2;
            i = i | 4096 | 16384;
        }
        if ((q & 64) == 64) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((q & 128) == 128) {
            i2++;
            i |= 8192;
        }
        if ((q & 256) == 256) {
            i2++;
            i |= 2048;
        }
        if ((q & 512) == 512) {
            i2 += 2;
            i = i | 64 | 128;
        }
        if ((q & 1024) == 1024) {
            i2 += 2;
            i = i | 512 | 1024;
        }
        if ((q & 2048) == 2048) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((q & 4096) == 4096) {
            i2++;
            i |= 8;
        }
        if ((q & 8192) == 8192) {
            i2 += 2;
            i = i | 16 | 32;
        }
        if ((q & 16384) == 16384) {
            i2++;
            i |= 65536;
        }
        if ((q & 32768) == 32768) {
            i2 += 2;
            i = 32768 | i | 131072;
        }
        if ((q & 65536) == 65536) {
            i2++;
        }
        if ((q & 131072) == 131072) {
            i2 += 2;
        }
        return new int[]{i2, i};
    }
}
