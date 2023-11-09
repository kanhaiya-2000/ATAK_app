package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.common.msg_collision;
import java.nio.ByteBuffer;
import java.util.Date;

/* renamed from: atakplugin.UASTool.oy */
public class C0724oy extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f5563A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f5564B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f5565C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f5566D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f5567E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f5568F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f5569G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f5570H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f5571I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f5572J = null;

    /* renamed from: K */
    private static final /* synthetic */ can.C0296b f5573K = null;

    /* renamed from: L */
    private static final /* synthetic */ can.C0296b f5574L = null;

    /* renamed from: M */
    private static final /* synthetic */ can.C0296b f5575M = null;

    /* renamed from: N */
    private static final /* synthetic */ can.C0296b f5576N = null;

    /* renamed from: O */
    private static final /* synthetic */ can.C0296b f5577O = null;

    /* renamed from: P */
    private static final /* synthetic */ can.C0296b f5578P = null;

    /* renamed from: Q */
    private static final /* synthetic */ can.C0296b f5579Q = null;

    /* renamed from: R */
    private static final /* synthetic */ can.C0296b f5580R = null;

    /* renamed from: S */
    private static final /* synthetic */ can.C0296b f5581S = null;

    /* renamed from: T */
    private static final /* synthetic */ can.C0296b f5582T = null;

    /* renamed from: U */
    private static final /* synthetic */ can.C0296b f5583U = null;

    /* renamed from: V */
    private static final /* synthetic */ can.C0296b f5584V = null;

    /* renamed from: W */
    private static final /* synthetic */ can.C0296b f5585W = null;

    /* renamed from: X */
    private static final /* synthetic */ can.C0296b f5586X = null;

    /* renamed from: Y */
    private static final /* synthetic */ can.C0296b f5587Y = null;

    /* renamed from: Z */
    private static final /* synthetic */ can.C0296b f5588Z = null;

    /* renamed from: a */
    public static final String f5589a = "mvhd";

    /* renamed from: aa */
    private static final /* synthetic */ can.C0296b f5590aa = null;

    /* renamed from: b */
    private static afp f5591b = afp.m867a(C0724oy.class);

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5592y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f5593z = null;

    /* renamed from: c */
    private Date f5594c;

    /* renamed from: d */
    private Date f5595d;

    /* renamed from: e */
    private long f5596e;

    /* renamed from: f */
    private long f5597f;

    /* renamed from: o */
    private double f5598o = 1.0d;

    /* renamed from: p */
    private float f5599p = 1.0f;

    /* renamed from: q */
    private afr f5600q = afr.f870j;

    /* renamed from: r */
    private long f5601r;

    /* renamed from: s */
    private int f5602s;

    /* renamed from: t */
    private int f5603t;

    /* renamed from: u */
    private int f5604u;

    /* renamed from: v */
    private int f5605v;

    /* renamed from: w */
    private int f5606w;

    /* renamed from: x */
    private int f5607x;

    /* renamed from: z */
    private static /* synthetic */ void m12785z() {
        cdj cdj = new cdj("MovieHeaderBox.java", C0724oy.class);
        f5592y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 66);
        f5593z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 70);
        f5571I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 212);
        f5572J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 220);
        f5573K = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 224);
        f5574L = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 231);
        f5575M = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), 235);
        f5576N = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 239);
        f5577O = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 243);
        f5578P = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), (int) msg_collision.MAVLINK_MSG_ID_COLLISION);
        f5579Q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 251);
        f5580R = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 255);
        f5563A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 74);
        f5581S = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 259);
        f5582T = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 263);
        f5583U = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 267);
        f5584V = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 271);
        f5585W = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 275);
        f5586X = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 279);
        f5587Y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 283);
        f5588Z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 287);
        f5590aa = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 291);
        f5564B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 78);
        f5565C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 82);
        f5566D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 86);
        f5567E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 90);
        f5568F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 94);
        f5569G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 148);
        f5570H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 204);
    }

    static {
        m12785z();
    }

    public C0724oy() {
        super(f5589a);
    }

    /* renamed from: c */
    public Date mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5592y, (Object) this, (Object) this));
        return this.f5594c;
    }

    /* renamed from: i */
    public Date mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5593z, (Object) this, (Object) this));
        return this.f5595d;
    }

    /* renamed from: j */
    public long mo5262j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5563A, (Object) this, (Object) this));
        return this.f5596e;
    }

    /* renamed from: k */
    public long mo5263k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5564B, (Object) this, (Object) this));
        return this.f5597f;
    }

    /* renamed from: l */
    public double mo5264l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5565C, (Object) this, (Object) this));
        return this.f5598o;
    }

    /* renamed from: m */
    public float mo5265m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5566D, (Object) this, (Object) this));
        return this.f5599p;
    }

    /* renamed from: n */
    public afr mo5266n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5567E, (Object) this, (Object) this));
        return this.f5600q;
    }

    /* renamed from: o */
    public long mo5267o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5568F, (Object) this, (Object) this));
        return this.f5601r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (mo5157a_() == 1 ? 32 : 20) + 80;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if (mo5157a_() == 1) {
            this.f5594c = afk.m851a(C0679nk.m12501h(byteBuffer));
            this.f5595d = afk.m851a(C0679nk.m12501h(byteBuffer));
            this.f5596e = C0679nk.m12495b(byteBuffer);
            this.f5597f = byteBuffer.getLong();
        } else {
            this.f5594c = afk.m851a(C0679nk.m12495b(byteBuffer));
            this.f5595d = afk.m851a(C0679nk.m12495b(byteBuffer));
            this.f5596e = C0679nk.m12495b(byteBuffer);
            this.f5597f = (long) byteBuffer.getInt();
        }
        if (this.f5597f < -1) {
            f5591b.mo575b("mvhd duration is not in expected range");
        }
        this.f5598o = C0679nk.m12502i(byteBuffer);
        this.f5599p = C0679nk.m12504k(byteBuffer);
        C0679nk.m12497d(byteBuffer);
        C0679nk.m12495b(byteBuffer);
        C0679nk.m12495b(byteBuffer);
        this.f5600q = afr.m877a(byteBuffer);
        this.f5602s = byteBuffer.getInt();
        this.f5603t = byteBuffer.getInt();
        this.f5604u = byteBuffer.getInt();
        this.f5605v = byteBuffer.getInt();
        this.f5606w = byteBuffer.getInt();
        this.f5607x = byteBuffer.getInt();
        this.f5601r = C0679nk.m12495b(byteBuffer);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5569G, (Object) this, (Object) this));
        return "MovieHeaderBox[" + "creationTime=" + mo36c() + ";" + "modificationTime=" + mo43i() + ";" + "timescale=" + mo5262j() + ";" + "duration=" + mo5263k() + ";" + "rate=" + mo5264l() + ";" + "volume=" + mo5265m() + ";" + "matrix=" + this.f5600q + ";" + "nextTrackId=" + mo5267o() + "]";
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (mo5157a_() == 1) {
            C0681nm.m12511a(byteBuffer, afk.m850a(this.f5594c));
            C0681nm.m12511a(byteBuffer, afk.m850a(this.f5595d));
            C0681nm.m12515b(byteBuffer, this.f5596e);
            byteBuffer.putLong(this.f5597f);
        } else {
            C0681nm.m12515b(byteBuffer, afk.m850a(this.f5594c));
            C0681nm.m12515b(byteBuffer, afk.m850a(this.f5595d));
            C0681nm.m12515b(byteBuffer, this.f5596e);
            byteBuffer.putInt((int) this.f5597f);
        }
        C0681nm.m12509a(byteBuffer, this.f5598o);
        C0681nm.m12517c(byteBuffer, (double) this.f5599p);
        C0681nm.m12514b(byteBuffer, 0);
        C0681nm.m12515b(byteBuffer, 0);
        C0681nm.m12515b(byteBuffer, 0);
        this.f5600q.mo598b(byteBuffer);
        byteBuffer.putInt(this.f5602s);
        byteBuffer.putInt(this.f5603t);
        byteBuffer.putInt(this.f5604u);
        byteBuffer.putInt(this.f5605v);
        byteBuffer.putInt(this.f5606w);
        byteBuffer.putInt(this.f5607x);
        C0681nm.m12515b(byteBuffer, this.f5601r);
    }

    /* renamed from: a */
    public void mo5252a(Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5570H, (Object) this, (Object) this, (Object) date));
        this.f5594c = date;
        if (afk.m850a(date) >= 4294967296L) {
            mo5158a_(1);
        }
    }

    /* renamed from: b */
    public void mo5254b(Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5571I, (Object) this, (Object) this, (Object) date));
        this.f5595d = date;
        if (afk.m850a(date) >= 4294967296L) {
            mo5158a_(1);
        }
    }

    /* renamed from: a */
    public void mo5250a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5572J, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5596e = j;
    }

    /* renamed from: b */
    public void mo5253b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5573K, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5597f = j;
        if (j >= 4294967296L) {
            mo5158a_(1);
        }
    }

    /* renamed from: a */
    public void mo5248a(double d) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5574L, (Object) this, (Object) this, ccw.m11299a(d)));
        this.f5598o = d;
    }

    /* renamed from: a */
    public void mo5249a(float f) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5575M, (Object) this, (Object) this, ccw.m11300a(f)));
        this.f5599p = f;
    }

    /* renamed from: a */
    public void mo5251a(afr afr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5576N, (Object) this, (Object) this, (Object) afr));
        this.f5600q = afr;
    }

    /* renamed from: c */
    public void mo5256c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5577O, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5601r = j;
    }

    /* renamed from: p */
    public int mo5268p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5578P, (Object) this, (Object) this));
        return this.f5602s;
    }

    /* renamed from: c */
    public void mo5255c(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5579Q, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5602s = i;
    }

    /* renamed from: q */
    public int mo5269q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5580R, (Object) this, (Object) this));
        return this.f5603t;
    }

    /* renamed from: d */
    public void mo5257d(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5581S, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5603t = i;
    }

    /* renamed from: r */
    public int mo5270r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5582T, (Object) this, (Object) this));
        return this.f5604u;
    }

    /* renamed from: e */
    public void mo5258e(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5583U, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5604u = i;
    }

    /* renamed from: s */
    public int mo5271s() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5584V, (Object) this, (Object) this));
        return this.f5605v;
    }

    /* renamed from: f */
    public void mo5259f(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5585W, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5605v = i;
    }

    /* renamed from: t */
    public int mo5272t() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5586X, (Object) this, (Object) this));
        return this.f5606w;
    }

    /* renamed from: g */
    public void mo5260g(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5587Y, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5606w = i;
    }

    /* renamed from: u */
    public int mo5274u() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5588Z, (Object) this, (Object) this));
        return this.f5607x;
    }

    /* renamed from: h */
    public void mo5261h(int i) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5590aa, (Object) this, (Object) this, ccw.m11301a(i)));
        this.f5607x = i;
    }
}
