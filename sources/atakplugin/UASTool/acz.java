package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ap_adc;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

public class acz extends C1004wp {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f393A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f394B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f395C = null;

    /* renamed from: D */
    private static final /* synthetic */ can.C0296b f396D = null;

    /* renamed from: a */
    public static final String f397a = "cinf";

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f398q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f399r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f400s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f401t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f402u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f403v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f404w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f405x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f406y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f407z = null;

    /* renamed from: b */
    String f408b;

    /* renamed from: c */
    String f409c;

    /* renamed from: d */
    String f410d;

    /* renamed from: e */
    String f411e;

    /* renamed from: f */
    String f412f;

    /* renamed from: o */
    Map<String, String> f413o = new LinkedHashMap();

    /* renamed from: p */
    Map<String, String> f414p = new LinkedHashMap();

    static {
        m394o();
    }

    /* renamed from: o */
    private static /* synthetic */ void m394o() {
        cdj cdj = new cdj("ContentInformationBox.java", acz.class);
        f398q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 144);
        f399r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "mimeSubtypeName", "", "void"), 148);
        f393A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 184);
        f394B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "brandEntries", "", "void"), (int) msg_ap_adc.MAVLINK_MSG_ID_AP_ADC_CRC);
        f395C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 192);
        f396D = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "idEntries", "", "void"), 196);
        f400s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 152);
        f401t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "profileLevelIdc", "", "void"), 156);
        f402u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 160);
        f403v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "codecs", "", "void"), 164);
        f404w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 168);
        f405x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "protection", "", "void"), 172);
        f406y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 176);
        f407z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "languages", "", "void"), 180);
    }

    public acz() {
        super(f397a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        long b = ((long) (C0684np.m12529b(this.f408b) + 1)) + 4 + ((long) (C0684np.m12529b(this.f409c) + 1)) + ((long) (C0684np.m12529b(this.f410d) + 1)) + ((long) (C0684np.m12529b(this.f411e) + 1)) + ((long) (C0684np.m12529b(this.f412f) + 1)) + 1;
        for (Map.Entry next : this.f413o.entrySet()) {
            b = b + ((long) (C0684np.m12529b((String) next.getKey()) + 1)) + ((long) (C0684np.m12529b((String) next.getValue()) + 1));
        }
        long j = b + 1;
        for (Map.Entry next2 : this.f414p.entrySet()) {
            j = j + ((long) (C0684np.m12529b((String) next2.getKey()) + 1)) + ((long) (C0684np.m12529b((String) next2.getValue()) + 1));
        }
        return j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12520c(byteBuffer, this.f408b);
        C0681nm.m12520c(byteBuffer, this.f409c);
        C0681nm.m12520c(byteBuffer, this.f410d);
        C0681nm.m12520c(byteBuffer, this.f411e);
        C0681nm.m12520c(byteBuffer, this.f412f);
        C0681nm.m12521d(byteBuffer, this.f413o.size());
        for (Map.Entry next : this.f413o.entrySet()) {
            C0681nm.m12520c(byteBuffer, (String) next.getKey());
            C0681nm.m12520c(byteBuffer, (String) next.getValue());
        }
        C0681nm.m12521d(byteBuffer, this.f414p.size());
        for (Map.Entry next2 : this.f414p.entrySet()) {
            C0681nm.m12520c(byteBuffer, (String) next2.getKey());
            C0681nm.m12520c(byteBuffer, (String) next2.getValue());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f408b = C0679nk.m12500g(byteBuffer);
        this.f409c = C0679nk.m12500g(byteBuffer);
        this.f410d = C0679nk.m12500g(byteBuffer);
        this.f411e = C0679nk.m12500g(byteBuffer);
        this.f412f = C0679nk.m12500g(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        while (true) {
            int i = f - 1;
            if (f <= 0) {
                break;
            }
            this.f413o.put(C0679nk.m12500g(byteBuffer), C0679nk.m12500g(byteBuffer));
            f = i;
        }
        int f2 = C0679nk.m12499f(byteBuffer);
        while (true) {
            int i2 = f2 - 1;
            if (f2 > 0) {
                this.f414p.put(C0679nk.m12500g(byteBuffer), C0679nk.m12500g(byteBuffer));
                f2 = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: atakplugin.UASTool.acz$a */
    public static class C0008a {

        /* renamed from: a */
        String f415a;

        /* renamed from: b */
        String f416b;

        public C0008a(String str, String str2) {
            this.f415a = str;
            this.f416b = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0008a aVar = (C0008a) obj;
            String str = this.f415a;
            if (str == null ? aVar.f415a != null : !str.equals(aVar.f415a)) {
                return false;
            }
            String str2 = this.f416b;
            String str3 = aVar.f416b;
            return str2 == null ? str3 == null : str2.equals(str3);
        }

        public int hashCode() {
            String str = this.f415a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f416b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f398q, (Object) this, (Object) this));
        return this.f408b;
    }

    /* renamed from: a */
    public void mo258a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f399r, (Object) this, (Object) this, (Object) str));
        this.f408b = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f400s, (Object) this, (Object) this));
        return this.f409c;
    }

    /* renamed from: b */
    public void mo260b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f401t, (Object) this, (Object) this, (Object) str));
        this.f409c = str;
    }

    /* renamed from: j */
    public String mo265j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f402u, (Object) this, (Object) this));
        return this.f410d;
    }

    /* renamed from: c */
    public void mo262c(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f403v, (Object) this, (Object) this, (Object) str));
        this.f410d = str;
    }

    /* renamed from: k */
    public String mo266k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f404w, (Object) this, (Object) this));
        return this.f411e;
    }

    /* renamed from: d */
    public void mo263d(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f405x, (Object) this, (Object) this, (Object) str));
        this.f411e = str;
    }

    /* renamed from: l */
    public String mo267l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f406y, (Object) this, (Object) this));
        return this.f412f;
    }

    /* renamed from: e */
    public void mo264e(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f407z, (Object) this, (Object) this, (Object) str));
        this.f412f = str;
    }

    /* renamed from: m */
    public Map<String, String> mo268m() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f393A, (Object) this, (Object) this));
        return this.f413o;
    }

    /* renamed from: a */
    public void mo259a(Map<String, String> map) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f394B, (Object) this, (Object) this, (Object) map));
        this.f413o = map;
    }

    /* renamed from: n */
    public Map<String, String> mo269n() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f395C, (Object) this, (Object) this));
        return this.f414p;
    }

    /* renamed from: b */
    public void mo261b(Map<String, String> map) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f396D, (Object) this, (Object) this, (Object) map));
        this.f414p = map;
    }
}
