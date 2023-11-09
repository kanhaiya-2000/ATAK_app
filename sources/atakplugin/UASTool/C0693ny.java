package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: atakplugin.UASTool.ny */
public class C0693ny extends C1004wp {

    /* renamed from: a */
    public static final String f5397a = "ctts";

    /* renamed from: c */
    static final /* synthetic */ boolean f5398c = true;

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f5399d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f5400e = null;

    /* renamed from: b */
    List<C0694a> f5401b = Collections.emptyList();

    /* renamed from: c */
    private static /* synthetic */ void m12591c() {
        cdj cdj = new cdj("CompositionTimeToSample.java", C0693ny.class);
        f5399d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "", "", "", "java.util.List"), 57);
        f5400e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 61);
    }

    static {
        m12591c();
    }

    public C0693ny() {
        super(f5397a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) ((this.f5401b.size() * 8) + 8);
    }

    /* renamed from: a */
    public List<C0694a> mo5140a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f5399d, (Object) this, (Object) this));
        return this.f5401b;
    }

    /* renamed from: a */
    public void mo5141a(List<C0694a> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f5400e, (Object) this, (Object) this, (Object) list));
        this.f5401b = list;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        int a = afi.m847a(C0679nk.m12495b(byteBuffer));
        this.f5401b = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            this.f5401b.add(new C0694a(afi.m847a(C0679nk.m12495b(byteBuffer)), byteBuffer.getInt()));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        C0681nm.m12515b(byteBuffer, (long) this.f5401b.size());
        for (C0694a next : this.f5401b) {
            C0681nm.m12515b(byteBuffer, (long) next.mo5142a());
            byteBuffer.putInt(next.mo5144b());
        }
    }

    /* renamed from: atakplugin.UASTool.ny$a */
    public static class C0694a {

        /* renamed from: a */
        int f5402a;

        /* renamed from: b */
        int f5403b;

        public C0694a(int i, int i2) {
            this.f5402a = i;
            this.f5403b = i2;
        }

        /* renamed from: a */
        public int mo5142a() {
            return this.f5402a;
        }

        /* renamed from: b */
        public int mo5144b() {
            return this.f5403b;
        }

        /* renamed from: a */
        public void mo5143a(int i) {
            this.f5402a = i;
        }

        /* renamed from: b */
        public void mo5145b(int i) {
            this.f5403b = i;
        }

        public String toString() {
            return "Entry{count=" + this.f5402a + ", offset=" + this.f5403b + '}';
        }
    }

    /* renamed from: b */
    public static int[] m12590b(List<C0694a> list) {
        long j = 0;
        for (C0694a a : list) {
            j += (long) a.mo5142a();
        }
        if (f5398c || j <= 2147483647L) {
            int[] iArr = new int[((int) j)];
            int i = 0;
            for (C0694a next : list) {
                int i2 = 0;
                while (i2 < next.mo5142a()) {
                    iArr[i] = next.mo5144b();
                    i2++;
                    i++;
                }
            }
            return iArr;
        }
        throw new AssertionError();
    }
}
