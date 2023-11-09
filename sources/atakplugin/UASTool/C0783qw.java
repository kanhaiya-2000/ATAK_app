package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_gopro_heartbeat;
import com.atakmap.android.uastool.MAVLink.enums.MAV_REMOTE_LOG_DATA_BLOCK_COMMANDS;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qw */
public class C0783qw extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f5926A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f5927B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f5928C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f5929D = null;

    /* renamed from: E */
    private static final /* synthetic */ can.C0296b f5930E = null;

    /* renamed from: F */
    private static final /* synthetic */ can.C0296b f5931F = null;

    /* renamed from: G */
    private static final /* synthetic */ can.C0296b f5932G = null;

    /* renamed from: H */
    private static final /* synthetic */ can.C0296b f5933H = null;

    /* renamed from: I */
    private static final /* synthetic */ can.C0296b f5934I = null;

    /* renamed from: J */
    private static final /* synthetic */ can.C0296b f5935J = null;

    /* renamed from: K */
    private static final /* synthetic */ can.C0296b f5936K = null;

    /* renamed from: L */
    private static final /* synthetic */ can.C0296b f5937L = null;

    /* renamed from: M */
    private static final /* synthetic */ can.C0296b f5938M = null;

    /* renamed from: a */
    public static final String f5939a = "tfhd";

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5940r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5941s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5942t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5943u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5944v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5945w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5946x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5947y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f5948z = null;

    /* renamed from: b */
    private long f5949b;

    /* renamed from: c */
    private long f5950c = -1;

    /* renamed from: d */
    private long f5951d;

    /* renamed from: e */
    private long f5952e = -1;

    /* renamed from: f */
    private long f5953f = -1;

    /* renamed from: o */
    private C0778qr f5954o;

    /* renamed from: p */
    private boolean f5955p;

    /* renamed from: q */
    private boolean f5956q;

    static {
        m13184u();
    }

    /* renamed from: u */
    private static /* synthetic */ void m13184u() {
        cdj cdj = new cdj("TrackFragmentHeaderBox.java", C0783qw.class);
        f5940r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hasBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 126);
        f5941s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hasSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 130);
        f5927B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 166);
        f5928C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 170);
        f5929D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "isDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 174);
        f5930E = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "trackId", "", "void"), 178);
        f5931F = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), 182);
        f5932G = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 191);
        f5933H = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), 200);
        f5934I = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), 205);
        f5935J = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 210);
        f5936K = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), (int) msg_gopro_heartbeat.MAVLINK_MSG_ID_GOPRO_HEARTBEAT);
        f5942t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hasDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 134);
        f5937L = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), 220);
        f5938M = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 226);
        f5943u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hasDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 138);
        f5944v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hasDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 142);
        f5945w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 146);
        f5946x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 150);
        f5947y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 154);
        f5948z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 158);
        f5926A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 162);
    }

    public C0783qw() {
        super(f5939a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int b_ = mo456b_();
        long j = (b_ & 1) == 1 ? 16 : 8;
        if ((b_ & 2) == 2) {
            j += 4;
        }
        if ((b_ & 8) == 8) {
            j += 4;
        }
        if ((b_ & 16) == 16) {
            j += 4;
        }
        return (b_ & 32) == 32 ? j + 4 : j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5949b);
        if ((mo456b_() & 1) == 1) {
            C0681nm.m12511a(byteBuffer, mo5505n());
        }
        if ((mo456b_() & 2) == 2) {
            C0681nm.m12515b(byteBuffer, mo5506o());
        }
        if ((mo456b_() & 8) == 8) {
            C0681nm.m12515b(byteBuffer, mo5507p());
        }
        if ((mo456b_() & 16) == 16) {
            C0681nm.m12515b(byteBuffer, mo5508q());
        }
        if ((mo456b_() & 32) == 32) {
            this.f5954o.mo5458a(byteBuffer);
        }
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5949b = C0679nk.m12495b(byteBuffer);
        if ((mo456b_() & 1) == 1) {
            this.f5950c = C0679nk.m12501h(byteBuffer);
        }
        if ((mo456b_() & 2) == 2) {
            this.f5951d = C0679nk.m12495b(byteBuffer);
        }
        if ((mo456b_() & 8) == 8) {
            this.f5952e = C0679nk.m12495b(byteBuffer);
        }
        if ((mo456b_() & 16) == 16) {
            this.f5953f = C0679nk.m12495b(byteBuffer);
        }
        if ((mo456b_() & 32) == 32) {
            this.f5954o = new C0778qr(byteBuffer);
        }
        if ((mo456b_() & 65536) == 65536) {
            this.f5955p = true;
        }
        if ((mo456b_() & 131072) == 131072) {
            this.f5956q = true;
        }
    }

    /* renamed from: c */
    public boolean mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5940r, (Object) this, (Object) this));
        return (mo456b_() & 1) != 0;
    }

    /* renamed from: i */
    public boolean mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5941s, (Object) this, (Object) this));
        return (mo456b_() & 2) != 0;
    }

    /* renamed from: j */
    public boolean mo5501j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5942t, (Object) this, (Object) this));
        return (mo456b_() & 8) != 0;
    }

    /* renamed from: k */
    public boolean mo5502k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5943u, (Object) this, (Object) this));
        return (mo456b_() & 16) != 0;
    }

    /* renamed from: l */
    public boolean mo5503l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5944v, (Object) this, (Object) this));
        return (mo456b_() & 32) != 0;
    }

    /* renamed from: m */
    public long mo5504m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5945w, (Object) this, (Object) this));
        return this.f5949b;
    }

    /* renamed from: n */
    public long mo5505n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5946x, (Object) this, (Object) this));
        return this.f5950c;
    }

    /* renamed from: o */
    public long mo5506o() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5947y, (Object) this, (Object) this));
        return this.f5951d;
    }

    /* renamed from: p */
    public long mo5507p() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5948z, (Object) this, (Object) this));
        return this.f5952e;
    }

    /* renamed from: q */
    public long mo5508q() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5926A, (Object) this, (Object) this));
        return this.f5953f;
    }

    /* renamed from: r */
    public C0778qr mo5509r() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5927B, (Object) this, (Object) this));
        return this.f5954o;
    }

    /* renamed from: s */
    public boolean mo5510s() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5928C, (Object) this, (Object) this));
        return this.f5955p;
    }

    /* renamed from: t */
    public boolean mo5511t() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5929D, (Object) this, (Object) this));
        return this.f5956q;
    }

    /* renamed from: a */
    public void mo5493a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5930E, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5949b = j;
    }

    /* renamed from: b */
    public void mo5496b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5931F, (Object) this, (Object) this, ccw.m11302a(j)));
        if (j == -1) {
            mo5159b(mo456b_() & MAV_REMOTE_LOG_DATA_BLOCK_COMMANDS.MAV_REMOTE_LOG_DATA_BLOCK_START);
        } else {
            mo5159b(mo456b_() | 1);
        }
        this.f5950c = j;
    }

    /* renamed from: c */
    public void mo5498c(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5932G, (Object) this, (Object) this, ccw.m11302a(j)));
        if (j == -1) {
            mo5159b(mo456b_() & MAV_REMOTE_LOG_DATA_BLOCK_COMMANDS.MAV_REMOTE_LOG_DATA_BLOCK_STOP);
        } else {
            mo5159b(mo456b_() | 2);
        }
        this.f5951d = j;
    }

    /* renamed from: d */
    public void mo5499d(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5933H, (Object) this, (Object) this, ccw.m11302a(j)));
        mo5159b(mo456b_() | 8);
        this.f5952e = j;
    }

    /* renamed from: e */
    public void mo5500e(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5934I, (Object) this, (Object) this, ccw.m11302a(j)));
        mo5159b(mo456b_() | 16);
        this.f5953f = j;
    }

    /* renamed from: a */
    public void mo5494a(C0778qr qrVar) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5935J, (Object) this, (Object) this, (Object) qrVar));
        mo5159b(mo456b_() | 32);
        this.f5954o = qrVar;
    }

    /* renamed from: a */
    public void mo5495a(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5936K, (Object) this, (Object) this, ccw.m11304a(z)));
        mo5159b(mo456b_() | 65536);
        this.f5955p = z;
    }

    /* renamed from: b */
    public void mo5497b(boolean z) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5937L, (Object) this, (Object) this, ccw.m11304a(z)));
        mo5159b(mo456b_() | 131072);
        this.f5956q = z;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5938M, (Object) this, (Object) this));
        return "TrackFragmentHeaderBox" + "{trackId=" + this.f5949b + ", baseDataOffset=" + this.f5950c + ", sampleDescriptionIndex=" + this.f5951d + ", defaultSampleDuration=" + this.f5952e + ", defaultSampleSize=" + this.f5953f + ", defaultSampleFlags=" + this.f5954o + ", durationIsEmpty=" + this.f5955p + ", defaultBaseIsMoof=" + this.f5956q + '}';
    }
}
