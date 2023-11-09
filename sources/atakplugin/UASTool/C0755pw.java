package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gopro_set_request;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_rtcm_data;
import com.atakmap.android.uastool.MAVLink.common.msg_local_position_ned_cov;
import java.nio.ByteBuffer;
import java.util.Date;

/* renamed from: atakplugin.UASTool.pw */
public class C0755pw extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f5749A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f5750B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f5751C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f5752D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f5753E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f5754F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f5755G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f5756H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f5757I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f5758J = null;

    /* renamed from: K */
    private static final /* synthetic */ can.C0296b f5759K = null;

    /* renamed from: L */
    private static final /* synthetic */ can.C0296b f5760L = null;

    /* renamed from: M */
    private static final /* synthetic */ can.C0296b f5761M = null;

    /* renamed from: N */
    private static final /* synthetic */ can.C0296b f5762N = null;

    /* renamed from: O */
    private static final /* synthetic */ can.C0296b f5763O = null;

    /* renamed from: P */
    private static final /* synthetic */ can.C0296b f5764P = null;

    /* renamed from: Q */
    private static final /* synthetic */ can.C0296b f5765Q = null;

    /* renamed from: R */
    private static final /* synthetic */ can.C0296b f5766R = null;

    /* renamed from: S */
    private static final /* synthetic */ can.C0296b f5767S = null;

    /* renamed from: T */
    private static final /* synthetic */ can.C0296b f5768T = null;

    /* renamed from: U */
    private static final /* synthetic */ can.C0296b f5769U = null;

    /* renamed from: V */
    private static final /* synthetic */ can.C0296b f5770V = null;

    /* renamed from: W */
    private static final /* synthetic */ can.C0296b f5771W = null;

    /* renamed from: X */
    private static final /* synthetic */ can.C0296b f5772X = null;

    /* renamed from: a */
    public static final String f5773a = "tkhd";

    /* renamed from: b */
    private static afp f5774b = afp.m867a(C0755pw.class);

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5775u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5776v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5777w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5778x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5779y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f5780z = null;

    /* renamed from: c */
    private Date f5781c = new Date(0);

    /* renamed from: d */
    private Date f5782d = new Date(0);

    /* renamed from: e */
    private long f5783e;

    /* renamed from: f */
    private long f5784f;

    /* renamed from: o */
    private int f5785o;

    /* renamed from: p */
    private int f5786p;

    /* renamed from: q */
    private float f5787q;

    /* renamed from: r */
    private afr f5788r = afr.f870j;

    /* renamed from: s */
    private double f5789s;

    /* renamed from: t */
    private double f5790t;

    /* renamed from: z */
    private static /* synthetic */ void m13000z() {
        cdj cdj = new cdj("TrackHeaderBox.java", C0755pw.class);
        f5775u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 62);
        f5776v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 66);
        f5753E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 145);
        f5754F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 173);
        f5755G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 199);
        f5756H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 206);
        f5757I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 214);
        f5758J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), (int) msg_gopro_set_request.MAVLINK_MSG_ID_GOPRO_SET_REQUEST);
        f5759K = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), (int) msg_local_position_ned_cov.MAVLINK_MSG_LENGTH);
        f5760L = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 229);
        f5761M = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), (int) msg_gps_rtcm_data.MAVLINK_MSG_ID_GPS_RTCM_DATA);
        f5762N = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 237);
        f5777w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 70);
        f5763O = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 241);
        f5764P = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 245);
        f5765Q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 250);
        f5766R = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 254);
        f5767S = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 258);
        f5768T = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 262);
        f5769U = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 266);
        f5770V = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 274);
        f5771W = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 282);
        f5772X = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 290);
        f5778x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 74);
        f5779y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 78);
        f5780z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 82);
        f5749A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 86);
        f5750B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 90);
        f5751C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 94);
        f5752D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 98);
    }

    static {
        m13000z();
    }

    public C0755pw() {
        super(f5773a);
    }

    /* renamed from: c */
    public Date mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5775u, (Object) this, (Object) this));
        return this.f5781c;
    }

    /* renamed from: i */
    public Date mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5776v, (Object) this, (Object) this));
        return this.f5782d;
    }

    /* renamed from: j */
    public long mo5394j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5777w, (Object) this, (Object) this));
        return this.f5783e;
    }

    /* renamed from: k */
    public long mo5395k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5778x, (Object) this, (Object) this));
        return this.f5784f;
    }

    /* renamed from: l */
    public int mo5396l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5779y, (Object) this, (Object) this));
        return this.f5785o;
    }

    /* renamed from: m */
    public int mo5397m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5780z, (Object) this, (Object) this));
        return this.f5786p;
    }

    /* renamed from: n */
    public float mo5398n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5749A, (Object) this, (Object) this));
        return this.f5787q;
    }

    /* renamed from: o */
    public afr mo5399o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5750B, (Object) this, (Object) this));
        return this.f5788r;
    }

    /* renamed from: p */
    public double mo5400p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5751C, (Object) this, (Object) this));
        return this.f5789s;
    }

    /* renamed from: q */
    public double mo5401q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5752D, (Object) this, (Object) this));
        return this.f5790t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (mo5157a_() == 1 ? 36 : 24) + 60;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if (mo5157a_() == 1) {
            this.f5781c = afk.m851a(C0679nk.m12501h(byteBuffer));
            this.f5782d = afk.m851a(C0679nk.m12501h(byteBuffer));
            this.f5783e = C0679nk.m12495b(byteBuffer);
            C0679nk.m12495b(byteBuffer);
            this.f5784f = byteBuffer.getLong();
        } else {
            this.f5781c = afk.m851a(C0679nk.m12495b(byteBuffer));
            this.f5782d = afk.m851a(C0679nk.m12495b(byteBuffer));
            this.f5783e = C0679nk.m12495b(byteBuffer);
            C0679nk.m12495b(byteBuffer);
            this.f5784f = (long) byteBuffer.getInt();
        }
        if (this.f5784f < -1) {
            f5774b.mo575b("tkhd duration is not in expected range");
        }
        C0679nk.m12495b(byteBuffer);
        C0679nk.m12495b(byteBuffer);
        this.f5785o = C0679nk.m12497d(byteBuffer);
        this.f5786p = C0679nk.m12497d(byteBuffer);
        this.f5787q = C0679nk.m12504k(byteBuffer);
        C0679nk.m12497d(byteBuffer);
        this.f5788r = afr.m877a(byteBuffer);
        this.f5789s = C0679nk.m12502i(byteBuffer);
        this.f5790t = C0679nk.m12502i(byteBuffer);
    }

    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5753E, (Object) this, (Object) this, (Object) byteBuffer));
        mo6126g(byteBuffer);
        if (mo5157a_() == 1) {
            C0681nm.m12511a(byteBuffer, afk.m850a(this.f5781c));
            C0681nm.m12511a(byteBuffer, afk.m850a(this.f5782d));
            C0681nm.m12515b(byteBuffer, this.f5783e);
            C0681nm.m12515b(byteBuffer, 0);
            byteBuffer.putLong(this.f5784f);
        } else {
            C0681nm.m12515b(byteBuffer, afk.m850a(this.f5781c));
            C0681nm.m12515b(byteBuffer, afk.m850a(this.f5782d));
            C0681nm.m12515b(byteBuffer, this.f5783e);
            C0681nm.m12515b(byteBuffer, 0);
            byteBuffer.putInt((int) this.f5784f);
        }
        C0681nm.m12515b(byteBuffer, 0);
        C0681nm.m12515b(byteBuffer, 0);
        C0681nm.m12514b(byteBuffer, this.f5785o);
        C0681nm.m12514b(byteBuffer, this.f5786p);
        C0681nm.m12517c(byteBuffer, (double) this.f5787q);
        C0681nm.m12514b(byteBuffer, 0);
        this.f5788r.mo598b(byteBuffer);
        C0681nm.m12509a(byteBuffer, this.f5789s);
        C0681nm.m12509a(byteBuffer, this.f5790t);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5754F, (Object) this, (Object) this));
        return "TrackHeaderBox[" + "creationTime=" + mo36c() + ";" + "modificationTime=" + mo43i() + ";" + "trackId=" + mo5394j() + ";" + "duration=" + mo5395k() + ";" + "layer=" + mo5396l() + ";" + "alternateGroup=" + mo5397m() + ";" + "volume=" + mo5398n() + ";" + "matrix=" + this.f5788r + ";" + "width=" + mo5400p() + ";" + "height=" + mo5401q() + "]";
    }

    /* renamed from: a */
    public void mo5384a(Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5755G, (Object) this, (Object) this, (Object) date));
        this.f5781c = date;
        if (afk.m850a(date) >= 4294967296L) {
            mo5158a_(1);
        }
    }

    /* renamed from: b */
    public void mo5388b(Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5756H, (Object) this, (Object) this, (Object) date));
        this.f5782d = date;
        if (afk.m850a(date) >= 4294967296L) {
            mo5158a_(1);
        }
    }

    /* renamed from: a */
    public void mo5382a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5757I, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5783e = j;
    }

    /* renamed from: b */
    public void mo5387b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5758J, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5784f = j;
        if (j >= 4294967296L) {
            mo5159b(1);
        }
    }

    /* renamed from: c */
    public void mo5390c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5759K, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5785o = i;
    }

    /* renamed from: d */
    public void mo5392d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5760L, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5786p = i;
    }

    /* renamed from: a */
    public void mo5381a(float f) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5761M, (Object) this, (Object) this, ccw.m11300a(f)));
        this.f5787q = f;
    }

    /* renamed from: a */
    public void mo5383a(afr afr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5762N, (Object) this, (Object) this, (Object) afr));
        this.f5788r = afr;
    }

    /* renamed from: a */
    public void mo5380a(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5763O, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f5789s = d;
    }

    /* renamed from: b */
    public void mo5386b(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5764P, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f5790t = d;
    }

    /* renamed from: r */
    public boolean mo5402r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5765Q, (Object) this, (Object) this));
        return (mo456b_() & 1) > 0;
    }

    /* renamed from: s */
    public boolean mo5403s() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5766R, (Object) this, (Object) this));
        return (mo456b_() & 2) > 0;
    }

    /* renamed from: t */
    public boolean mo5404t() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5767S, (Object) this, (Object) this));
        return (mo456b_() & 4) > 0;
    }

    /* renamed from: u */
    public boolean mo5406u() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5768T, (Object) this, (Object) this));
        return (mo456b_() & 8) > 0;
    }

    /* renamed from: a */
    public void mo5385a(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5769U, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 1);
        } else {
            mo5159b(mo456b_() & -2);
        }
    }

    /* renamed from: b */
    public void mo5389b(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5770V, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 2);
        } else {
            mo5159b(mo456b_() & -3);
        }
    }

    /* renamed from: c */
    public void mo5391c(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5771W, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 4);
        } else {
            mo5159b(mo456b_() & -5);
        }
    }

    /* renamed from: d */
    public void mo5393d(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5772X, (Object) this, (Object) this, ccw.m11304a(z)));
        if (z) {
            mo5159b(mo456b_() | 8);
        } else {
            mo5159b(mo456b_() & -9);
        }
    }
}
