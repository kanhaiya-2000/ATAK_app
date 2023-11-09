package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class aem extends C1002wn {

    /* renamed from: a */
    public static final String f697a = "ftab";

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f698c = null;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f699d = null;

    /* renamed from: b */
    List<C0019a> f700b = new LinkedList();

    static {
        m736b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m736b() {
        cdj cdj = new cdj("FontTableBox.java", aem.class);
        f698c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "", "", "", "java.util.List"), 52);
        f699d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "java.util.List", "entries", "", "void"), 56);
    }

    public aem() {
        super(f697a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int i = 2;
        for (C0019a a : this.f700b) {
            i += a.mo499a();
        }
        return (long) i;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        int d = C0679nk.m12497d(byteBuffer);
        for (int i = 0; i < d; i++) {
            C0019a aVar = new C0019a();
            aVar.mo500a(byteBuffer);
            this.f700b.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        C0681nm.m12514b(byteBuffer, this.f700b.size());
        for (C0019a b : this.f700b) {
            b.mo501b(byteBuffer);
        }
    }

    /* renamed from: a */
    public List<C0019a> mo497a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f698c, (Object) this, (Object) this));
        return this.f700b;
    }

    /* renamed from: a */
    public void mo498a(List<C0019a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f699d, (Object) this, (Object) this, (Object) list));
        this.f700b = list;
    }

    /* renamed from: atakplugin.UASTool.aem$a */
    public static class C0019a {

        /* renamed from: a */
        int f701a;

        /* renamed from: b */
        String f702b;

        public C0019a() {
        }

        public C0019a(int i, String str) {
            this.f701a = i;
            this.f702b = str;
        }

        /* renamed from: a */
        public void mo500a(ByteBuffer byteBuffer) {
            this.f701a = C0679nk.m12497d(byteBuffer);
            this.f702b = C0679nk.m12494a(byteBuffer, C0679nk.m12499f(byteBuffer));
        }

        /* renamed from: b */
        public void mo501b(ByteBuffer byteBuffer) {
            C0681nm.m12514b(byteBuffer, this.f701a);
            C0681nm.m12521d(byteBuffer, this.f702b.length());
            byteBuffer.put(C0684np.m12528a(this.f702b));
        }

        /* renamed from: a */
        public int mo499a() {
            return C0684np.m12529b(this.f702b) + 3;
        }

        public String toString() {
            return "FontRecord{fontId=" + this.f701a + ", fontname='" + this.f702b + '\'' + '}';
        }
    }
}
