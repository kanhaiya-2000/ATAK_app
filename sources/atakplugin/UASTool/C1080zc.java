package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.List;

/* renamed from: atakplugin.UASTool.zc */
public class C1080zc extends C1018xc {

    /* renamed from: d */
    C1026xj f7850d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f7851e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1024xh f7852f;

    /* renamed from: g */
    private List<C1024xh> f7853g = new C1081a(this, (C1081a) null);

    public C1080zc(C1026xj xjVar, long j, ByteBuffer byteBuffer) {
        super("replace(" + xjVar.mo6144f() + ")");
        this.f7850d = xjVar;
        this.f7851e = j;
        this.f7852f = new C1025xi(byteBuffer);
    }

    public void close() {
        this.f7850d.close();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7853g;
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7850d.mo13n();
    }

    /* renamed from: m */
    public synchronized long[] mo12m() {
        return this.f7850d.mo12m();
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return this.f7850d.mo6139a();
    }

    /* renamed from: b */
    public synchronized long[] mo6140b() {
        return this.f7850d.mo6140b();
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return this.f7850d.mo6141c();
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7850d.mo14o();
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7850d.mo15p();
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7850d.mo6142d();
    }

    /* renamed from: atakplugin.UASTool.zc$a */
    private class C1081a extends AbstractList<C1024xh> {
        private C1081a() {
        }

        /* synthetic */ C1081a(C1080zc zcVar, C1081a aVar) {
            this();
        }

        /* renamed from: a */
        public C1024xh get(int i) {
            if (C1080zc.this.f7851e == ((long) i)) {
                return C1080zc.this.f7852f;
            }
            return C1080zc.this.f7850d.mo11l().get(i);
        }

        public int size() {
            return C1080zc.this.f7850d.mo11l().size();
        }
    }
}
