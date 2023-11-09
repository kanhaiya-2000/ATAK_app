package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.pd */
public class C0730pd extends C1004wp {

    /* renamed from: a */
    public static final String f5634a = "pdin";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f5635c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5636d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5637e = null;

    /* renamed from: b */
    List<C0731a> f5638b = Collections.emptyList();

    static {
        m12846i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m12846i() {
        cdj cdj = new cdj("ProgressiveDownloadInformationBox.java", C0730pd.class);
        f5635c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.util.List"), 38);
        f5636d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "java.util.List", "entries", "", "void"), 42);
        f5637e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.lang.String"), 112);
    }

    public C0730pd() {
        super(f5634a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5638b.size() * 8) + 4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        for (C0731a next : this.f5638b) {
            C0681nm.m12515b(byteBuffer, next.mo5288a());
            C0681nm.m12515b(byteBuffer, next.mo5290b());
        }
    }

    /* renamed from: c */
    public List<C0731a> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5635c, (Object) this, (Object) this));
        return this.f5638b;
    }

    /* renamed from: a */
    public void mo5286a(List<C0731a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5636d, (Object) this, (Object) this, (Object) list));
        this.f5638b = list;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f5638b = new LinkedList();
        while (byteBuffer.remaining() >= 8) {
            this.f5638b.add(new C0731a(C0679nk.m12495b(byteBuffer), C0679nk.m12495b(byteBuffer)));
        }
    }

    /* renamed from: atakplugin.UASTool.pd$a */
    public static class C0731a {

        /* renamed from: a */
        long f5639a;

        /* renamed from: b */
        long f5640b;

        public C0731a(long j, long j2) {
            this.f5639a = j;
            this.f5640b = j2;
        }

        /* renamed from: a */
        public long mo5288a() {
            return this.f5639a;
        }

        /* renamed from: a */
        public void mo5289a(long j) {
            this.f5639a = j;
        }

        /* renamed from: b */
        public long mo5290b() {
            return this.f5640b;
        }

        /* renamed from: b */
        public void mo5291b(long j) {
            this.f5640b = j;
        }

        public String toString() {
            return "Entry{rate=" + this.f5639a + ", initialDelay=" + this.f5640b + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0731a aVar = (C0731a) obj;
            return this.f5640b == aVar.f5640b && this.f5639a == aVar.f5639a;
        }

        public int hashCode() {
            long j = this.f5639a;
            long j2 = this.f5640b;
            return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5637e, (Object) this, (Object) this));
        return "ProgressiveDownloadInfoBox{entries=" + this.f5638b + '}';
    }
}
