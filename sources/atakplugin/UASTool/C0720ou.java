package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.Date;

/* renamed from: atakplugin.UASTool.ou */
public class C0720ou extends C1004wp {

    /* renamed from: a */
    public static final String f5540a = "mdhd";

    /* renamed from: b */
    private static afp f5541b = afp.m867a(C0720ou.class);

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f5542p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f5543q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5544r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5545s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5546t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5547u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5548v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5549w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f5550x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f5551y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f5552z = null;

    /* renamed from: c */
    private Date f5553c = new Date();

    /* renamed from: d */
    private Date f5554d = new Date();

    /* renamed from: e */
    private long f5555e;

    /* renamed from: f */
    private long f5556f;

    /* renamed from: o */
    private String f5557o = "eng";

    /* renamed from: m */
    private static /* synthetic */ void m12757m() {
        cdj cdj = new cdj("MediaHeaderBox.java", C0720ou.class);
        f5542p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 48);
        f5543q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 52);
        f5552z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 125);
        f5544r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 56);
        f5545s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 60);
        f5546t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 64);
        f5547u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 81);
        f5548v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 85);
        f5549w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 89);
        f5550x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "duration", "", "void"), 93);
        f5551y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", "language", "", "void"), 97);
    }

    static {
        m12757m();
    }

    public C0720ou() {
        super(f5540a);
    }

    /* renamed from: c */
    public Date mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5542p, (Object) this, (Object) this));
        return this.f5553c;
    }

    /* renamed from: i */
    public Date mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5543q, (Object) this, (Object) this));
        return this.f5554d;
    }

    /* renamed from: j */
    public long mo5233j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5544r, (Object) this, (Object) this));
        return this.f5555e;
    }

    /* renamed from: k */
    public long mo5234k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5545s, (Object) this, (Object) this));
        return this.f5556f;
    }

    /* renamed from: l */
    public String mo5235l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5546t, (Object) this, (Object) this));
        return this.f5557o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (mo5157a_() == 1 ? 32 : 20) + 2 + 2;
    }

    /* renamed from: a */
    public void mo5230a(Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5547u, (Object) this, (Object) this, (Object) date));
        this.f5553c = date;
    }

    /* renamed from: b */
    public void mo5232b(Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5548v, (Object) this, (Object) this, (Object) date));
        this.f5554d = date;
    }

    /* renamed from: a */
    public void mo5228a(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5549w, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5555e = j;
    }

    /* renamed from: b */
    public void mo5231b(long j) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5550x, (Object) this, (Object) this, ccw.m11302a(j)));
        this.f5556f = j;
    }

    /* renamed from: a */
    public void mo5229a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5551y, (Object) this, (Object) this, (Object) str));
        this.f5557o = str;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if (mo5157a_() == 1) {
            this.f5553c = afk.m851a(C0679nk.m12501h(byteBuffer));
            this.f5554d = afk.m851a(C0679nk.m12501h(byteBuffer));
            this.f5555e = C0679nk.m12495b(byteBuffer);
            this.f5556f = byteBuffer.getLong();
        } else {
            this.f5553c = afk.m851a(C0679nk.m12495b(byteBuffer));
            this.f5554d = afk.m851a(C0679nk.m12495b(byteBuffer));
            this.f5555e = C0679nk.m12495b(byteBuffer);
            this.f5556f = (long) byteBuffer.getInt();
        }
        if (this.f5556f < -1) {
            f5541b.mo575b("mdhd duration is not in expected range");
        }
        this.f5557o = C0679nk.m12505l(byteBuffer);
        C0679nk.m12497d(byteBuffer);
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5552z, (Object) this, (Object) this));
        return "MediaHeaderBox[" + "creationTime=" + mo36c() + ";" + "modificationTime=" + mo43i() + ";" + "timescale=" + mo5233j() + ";" + "duration=" + mo5234k() + ";" + "language=" + mo5235l() + "]";
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (mo5157a_() == 1) {
            C0681nm.m12511a(byteBuffer, afk.m850a(this.f5553c));
            C0681nm.m12511a(byteBuffer, afk.m850a(this.f5554d));
            C0681nm.m12515b(byteBuffer, this.f5555e);
            byteBuffer.putLong(this.f5556f);
        } else {
            C0681nm.m12515b(byteBuffer, afk.m850a(this.f5553c));
            C0681nm.m12515b(byteBuffer, afk.m850a(this.f5554d));
            C0681nm.m12515b(byteBuffer, this.f5555e);
            byteBuffer.putInt((int) this.f5556f);
        }
        C0681nm.m12512a(byteBuffer, this.f5557o);
        C0681nm.m12514b(byteBuffer, 0);
    }
}
