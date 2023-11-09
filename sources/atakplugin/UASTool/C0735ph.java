package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.common.msg_set_actuator_control_target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atakplugin.UASTool.ph */
public class C0735ph extends C1004wp {

    /* renamed from: a */
    public static final String f5660a = "sdtp";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5661c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5662d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5663e = null;

    /* renamed from: b */
    private List<C0736a> f5664b = new ArrayList();

    static {
        m12874i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12874i() {
        cdj cdj = new cdj("SampleDependencyTypeBox.java", C0735ph.class);
        f5661c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.util.List"), (int) msg_set_actuator_control_target.MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET);
        f5662d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "java.util.List", "entries", "", "void"), 143);
        f5663e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.lang.String"), 148);
    }

    /* renamed from: atakplugin.UASTool.ph$a */
    public static class C0736a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f5665a;

        public C0736a(int i) {
            this.f5665a = i;
        }

        /* renamed from: a */
        public int mo5305a() {
            return (this.f5665a >> 6) & 3;
        }

        /* renamed from: a */
        public void mo5306a(int i) {
            this.f5665a = ((i & 3) << 6) | (this.f5665a & 63);
        }

        /* renamed from: b */
        public int mo5307b() {
            return (this.f5665a >> 4) & 3;
        }

        /* renamed from: b */
        public void mo5308b(int i) {
            this.f5665a = ((i & 3) << 4) | (this.f5665a & 207);
        }

        /* renamed from: c */
        public int mo5309c() {
            return (this.f5665a >> 2) & 3;
        }

        /* renamed from: c */
        public void mo5310c(int i) {
            this.f5665a = ((i & 3) << 2) | (this.f5665a & 243);
        }

        /* renamed from: d */
        public int mo5311d() {
            return this.f5665a & 3;
        }

        /* renamed from: d */
        public void mo5312d(int i) {
            this.f5665a = (i & 3) | (this.f5665a & 252);
        }

        public String toString() {
            return "Entry{isLeading=" + mo5305a() + ", sampleDependsOn=" + mo5307b() + ", sampleIsDependentOn=" + mo5309c() + ", sampleHasRedundancy=" + mo5311d() + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f5665a == ((C0736a) obj).f5665a;
        }

        public int hashCode() {
            return this.f5665a;
        }
    }

    public C0735ph() {
        super(f5660a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (this.f5664b.size() + 4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        for (C0736a a : this.f5664b) {
            C0681nm.m12521d(byteBuffer, a.f5665a);
        }
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.f5664b.add(new C0736a(C0679nk.m12499f(byteBuffer)));
        }
    }

    /* renamed from: c */
    public List<C0736a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5661c, (Object) this, (Object) this));
        return this.f5664b;
    }

    /* renamed from: a */
    public void mo5303a(List<C0736a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5662d, (Object) this, (Object) this, (Object) list));
        this.f5664b = list;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5663e, (Object) this, (Object) this));
        return "SampleDependencyTypeBox" + "{entries=" + this.f5664b + '}';
    }
}
