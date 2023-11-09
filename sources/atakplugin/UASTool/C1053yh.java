package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atakplugin.UASTool.yh */
public abstract class C1053yh extends C1018xc {

    /* renamed from: d */
    public static int f7687d = 67107840;

    /* renamed from: a_ */
    protected long[] f7688a_;

    /* renamed from: b_ */
    protected List<C0693ny.C0694a> f7689b_;

    /* renamed from: c_ */
    protected List<C0735ph.C0736a> f7690c_;

    /* renamed from: d_ */
    protected List<Integer> f7691d_;

    /* renamed from: e_ */
    protected C1027xk f7692e_;

    /* renamed from: f_ */
    boolean f7693f_;

    /* renamed from: k */
    private C1007ws f7694k;

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7692e_;
    }

    public C1053yh(C1007ws wsVar, boolean z) {
        super(wsVar.toString());
        this.f7689b_ = new ArrayList();
        this.f7690c_ = new ArrayList();
        this.f7691d_ = new ArrayList();
        this.f7692e_ = new C1027xk();
        this.f7693f_ = true;
        this.f7694k = wsVar;
        this.f7693f_ = z;
    }

    public C1053yh(C1007ws wsVar) {
        this(wsVar, true);
    }

    /* renamed from: atakplugin.UASTool.yh$a */
    public static class C1054a {

        /* renamed from: a */
        long f7695a = 0;

        /* renamed from: b */
        int f7696b = 0;

        /* renamed from: c */
        C1007ws f7697c;

        /* renamed from: d */
        ByteBuffer f7698d;

        /* renamed from: e */
        long f7699e;

        /* renamed from: a */
        public void mo6275a() {
            C1007ws wsVar = this.f7697c;
            this.f7698d = wsVar.mo5653a(this.f7695a, Math.min(wsVar.mo5651a() - this.f7695a, (long) C1053yh.f7687d));
        }

        public C1054a(C1007ws wsVar) {
            this.f7697c = wsVar;
            mo6275a();
        }

        /* renamed from: b */
        public boolean mo6277b() {
            int limit = this.f7698d.limit();
            int i = this.f7696b;
            if (limit - i >= 3) {
                if (this.f7698d.get(i) == 0 && this.f7698d.get(this.f7696b + 1) == 0 && this.f7698d.get(this.f7696b + 2) == 1) {
                    return true;
                }
                return false;
            } else if (this.f7695a + ((long) i) + 3 < this.f7697c.mo5651a()) {
                return false;
            } else {
                throw new EOFException();
            }
        }

        /* renamed from: a */
        public boolean mo6276a(boolean z) {
            int limit = this.f7698d.limit();
            int i = this.f7696b;
            if (limit - i >= 3) {
                return this.f7698d.get(i) == 0 && this.f7698d.get(this.f7696b + 1) == 0 && ((this.f7698d.get(this.f7696b + 2) == 0 && z) || this.f7698d.get(this.f7696b + 2) == 1);
            }
            if (this.f7695a + ((long) i) + 3 > this.f7697c.mo5651a()) {
                return this.f7695a + ((long) this.f7696b) == this.f7697c.mo5651a();
            }
            this.f7695a = this.f7699e;
            this.f7696b = 0;
            mo6275a();
            return mo6276a(z);
        }

        /* renamed from: c */
        public void mo6278c() {
            this.f7696b++;
        }

        /* renamed from: d */
        public void mo6279d() {
            int i = this.f7696b + 3;
            this.f7696b = i;
            this.f7699e = this.f7695a + ((long) i);
        }

        /* renamed from: e */
        public ByteBuffer mo6280e() {
            long j = this.f7699e;
            long j2 = this.f7695a;
            if (j >= j2) {
                this.f7698d.position((int) (j - j2));
                ByteBuffer slice = this.f7698d.slice();
                slice.limit((int) (((long) this.f7696b) - (this.f7699e - this.f7695a)));
                return slice;
            }
            throw new RuntimeException("damn! NAL exceeds buffer");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ByteBuffer mo6273a(C1054a aVar) {
        while (!aVar.mo6277b()) {
            try {
                aVar.mo6278c();
            } catch (EOFException unused) {
                return null;
            }
        }
        aVar.mo6279d();
        while (!aVar.mo6276a(this.f7693f_)) {
            aVar.mo6278c();
        }
        return aVar.mo6280e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1024xh mo6272a(List<? extends ByteBuffer> list) {
        byte[] bArr = new byte[(list.size() * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (ByteBuffer remaining : list) {
            wrap.putInt(remaining.remaining());
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[(list.size() * 2)];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = ByteBuffer.wrap(bArr, i * 4, 4);
            byteBufferArr[i2 + 1] = (ByteBuffer) list.get(i);
        }
        return new C1025xi(byteBufferArr);
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7688a_;
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return this.f7689b_;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        long[] jArr = new long[this.f7691d_.size()];
        for (int i = 0; i < this.f7691d_.size(); i++) {
            jArr[i] = (long) this.f7691d_.get(i).intValue();
        }
        return jArr;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return this.f7690c_;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public static InputStream m14713a(InputStream inputStream) {
        return new C1066ys(inputStream);
    }

    /* renamed from: a */
    protected static byte[] m14714a(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        int remaining = duplicate.remaining();
        byte[] bArr = new byte[remaining];
        duplicate.get(bArr, 0, remaining);
        return bArr;
    }

    public void close() {
        this.f7694k.close();
    }
}
