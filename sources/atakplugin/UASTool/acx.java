package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.common.msg_set_actuator_control_target;
import java.nio.ByteBuffer;

public class acx extends C1004wp {

    /* renamed from: a */
    public static final String f372a = "ainf";

    /* renamed from: d */
    static final /* synthetic */ boolean f373d = true;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f374e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f375f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f376o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f377p = null;

    /* renamed from: b */
    String f378b = "";

    /* renamed from: c */
    String f379c = "0000";

    /* renamed from: k */
    private static /* synthetic */ void m375k() {
        cdj cdj = new cdj("AssetInformationBox.java", acx.class);
        f374e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 131);
        f375f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "apid", "", "void"), 135);
        f376o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), (int) msg_set_actuator_control_target.MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET);
        f377p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "profileVersion", "", "void"), 143);
    }

    static {
        m375k();
    }

    /* renamed from: atakplugin.UASTool.acx$a */
    public static class C0007a {

        /* renamed from: a */
        public String f380a;

        /* renamed from: b */
        public String f381b;

        /* renamed from: c */
        public String f382c;

        public C0007a(String str, String str2, String str3) {
            this.f380a = str;
            this.f381b = str2;
            this.f382c = str3;
        }

        public String toString() {
            return "{namespace='" + this.f380a + '\'' + ", profileLevelIdc='" + this.f381b + '\'' + ", assetId='" + this.f382c + '\'' + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0007a aVar = (C0007a) obj;
            return this.f382c.equals(aVar.f382c) && this.f380a.equals(aVar.f380a) && this.f381b.equals(aVar.f381b);
        }

        public int hashCode() {
            return (((this.f380a.hashCode() * 31) + this.f381b.hashCode()) * 31) + this.f382c.hashCode();
        }

        /* renamed from: a */
        public int mo249a() {
            return C0684np.m12529b(this.f380a) + 3 + C0684np.m12529b(this.f381b) + C0684np.m12529b(this.f382c);
        }
    }

    public acx() {
        super(f372a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (C0684np.m12529b(this.f378b) + 9);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (mo5157a_() == 0) {
            byteBuffer.put(C0684np.m12528a(this.f379c), 0, 4);
            byteBuffer.put(C0684np.m12528a(this.f378b));
            byteBuffer.put((byte) 0);
            return;
        }
        throw new RuntimeException("Unknown ainf version " + mo5157a_());
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f379c = C0679nk.m12494a(byteBuffer, 4);
        this.f378b = C0679nk.m12500g(byteBuffer);
    }

    /* renamed from: c */
    public String mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f374e, (Object) this, (Object) this));
        return this.f378b;
    }

    /* renamed from: a */
    public void mo245a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f375f, (Object) this, (Object) this, (Object) str));
        this.f378b = str;
    }

    /* renamed from: i */
    public String mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f376o, (Object) this, (Object) this));
        return this.f379c;
    }

    /* renamed from: b */
    public void mo247b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f377p, (Object) this, (Object) this, (Object) str));
        if (f373d || (str != null && str.length() == 4)) {
            this.f379c = str;
            return;
        }
        throw new AssertionError();
    }

    @C1016xa
    /* renamed from: j */
    public boolean mo248j() {
        return (mo456b_() & 1) == 1;
    }

    @C1016xa
    /* renamed from: a */
    public void mo246a(boolean z) {
        int b_ = mo456b_();
        if (!(mo248j() ^ z)) {
            return;
        }
        if (z) {
            mo5159b(b_ | 1);
        } else {
            mo5159b(16777214 & b_);
        }
    }
}
