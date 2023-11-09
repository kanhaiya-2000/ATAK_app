package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.tasks.UASTask;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: atakplugin.UASTool.on */
public class C0711on extends C1004wp {

    /* renamed from: a */
    public static final String f5471a = "hdlr";

    /* renamed from: b */
    public static final Map<String, String> f5472b;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f5473r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f5474s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f5475t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f5476u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f5477v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f5478w = null;

    /* renamed from: c */
    private String f5479c;

    /* renamed from: d */
    private String f5480d = null;

    /* renamed from: e */
    private long f5481e;

    /* renamed from: f */
    private long f5482f;

    /* renamed from: o */
    private long f5483o;

    /* renamed from: p */
    private boolean f5484p = true;

    /* renamed from: q */
    private long f5485q;

    /* renamed from: k */
    private static /* synthetic */ void m12692k() {
        cdj cdj = new cdj("HandlerBox.java", C0711on.class);
        f5473r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        f5474s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", UASTask.COTDETAIL_NAME, "", "void"), 87);
        f5475t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        f5476u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        f5477v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        f5478w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    static {
        m12692k();
        HashMap hashMap = new HashMap();
        hashMap.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mdir", "Apple Meta Data iTunes Reader");
        hashMap.put("mp7b", "MPEG-7 binary XML");
        hashMap.put("mp7t", "MPEG-7 XML");
        hashMap.put("vide", "Video Track");
        hashMap.put("soun", "Sound Track");
        hashMap.put("hint", "Hint Track");
        hashMap.put("appl", "Apple specific");
        hashMap.put(C0722ow.f5559a, "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        f5472b = Collections.unmodifiableMap(hashMap);
    }

    public C0711on() {
        super(f5471a);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5473r, (Object) this, (Object) this));
        return this.f5479c;
    }

    /* renamed from: a */
    public void mo5192a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5474s, (Object) this, (Object) this, (Object) str));
        this.f5480d = str;
    }

    /* renamed from: b */
    public void mo5193b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5475t, (Object) this, (Object) this, (Object) str));
        this.f5479c = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5476u, (Object) this, (Object) this));
        return this.f5480d;
    }

    /* renamed from: j */
    public String mo5194j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5477v, (Object) this, (Object) this));
        Map<String, String> map = f5472b;
        return map.get(this.f5479c) != null ? map.get(this.f5479c) : "Unknown Handler Type";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int b;
        if (this.f5484p) {
            b = C0684np.m12529b(this.f5480d) + 25;
        } else {
            b = C0684np.m12529b(this.f5480d) + 24;
        }
        return (long) b;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5485q = C0679nk.m12495b(byteBuffer);
        this.f5479c = C0679nk.m12506m(byteBuffer);
        this.f5481e = C0679nk.m12495b(byteBuffer);
        this.f5482f = C0679nk.m12495b(byteBuffer);
        this.f5483o = C0679nk.m12495b(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            String a = C0679nk.m12494a(byteBuffer, byteBuffer.remaining());
            this.f5480d = a;
            if (a.endsWith("\u0000")) {
                String str = this.f5480d;
                this.f5480d = str.substring(0, str.length() - 1);
                this.f5484p = true;
                return;
            }
            this.f5484p = false;
            return;
        }
        this.f5484p = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, this.f5485q);
        byteBuffer.put(C0678nj.m12488a(this.f5479c));
        C0681nm.m12515b(byteBuffer, this.f5481e);
        C0681nm.m12515b(byteBuffer, this.f5482f);
        C0681nm.m12515b(byteBuffer, this.f5483o);
        String str = this.f5480d;
        if (str != null) {
            byteBuffer.put(C0684np.m12528a(str));
        }
        if (this.f5484p) {
            byteBuffer.put((byte) 0);
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5478w, (Object) this, (Object) this));
        return "HandlerBox[handlerType=" + mo36c() + ";name=" + mo43i() + "]";
    }
}
