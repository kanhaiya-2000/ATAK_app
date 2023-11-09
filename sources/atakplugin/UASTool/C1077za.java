package atakplugin.UASTool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.za */
public class C1077za extends C1018xc {

    /* renamed from: i */
    private static final int f7822i = 3;

    /* renamed from: j */
    private static final int f7823j = 1;

    /* renamed from: k */
    private static final int[] f7824k;

    /* renamed from: l */
    private static final int[] f7825l;

    /* renamed from: m */
    private static final int f7826m = 1152;

    /* renamed from: n */
    private static final int f7827n = 107;

    /* renamed from: o */
    private static final int f7828o = 5;

    /* renamed from: d */
    C1027xk f7829d;

    /* renamed from: e */
    C0737pi f7830e;

    /* renamed from: f */
    C1078a f7831f;

    /* renamed from: g */
    long f7832g;

    /* renamed from: h */
    long f7833h;

    /* renamed from: p */
    private final C1007ws f7834p;

    /* renamed from: q */
    private List<C1024xh> f7835q;

    /* renamed from: r */
    private long[] f7836r;

    /* renamed from: p */
    public String mo15p() {
        return "soun";
    }

    public String toString() {
        return "MP3TrackImpl";
    }

    static {
        int[] iArr = new int[4];
        iArr[0] = 44100;
        iArr[1] = 48000;
        iArr[2] = 32000;
        f7824k = iArr;
        int[] iArr2 = new int[16];
        iArr2[1] = 32000;
        iArr2[2] = 40000;
        iArr2[3] = 48000;
        iArr2[4] = 56000;
        iArr2[5] = 64000;
        iArr2[6] = 80000;
        iArr2[7] = 96000;
        iArr2[8] = 112000;
        iArr2[9] = 128000;
        iArr2[10] = 160000;
        iArr2[11] = 192000;
        iArr2[12] = 224000;
        iArr2[13] = 256000;
        iArr2[14] = 320000;
        f7825l = iArr2;
    }

    public C1077za(C1007ws wsVar) {
        this(wsVar, "eng");
    }

    public void close() {
        this.f7834p.close();
    }

    public C1077za(C1007ws wsVar, String str) {
        super(wsVar.toString());
        this.f7829d = new C1027xk();
        this.f7834p = wsVar;
        this.f7835q = new LinkedList();
        C1078a a = m14886a(wsVar);
        this.f7831f = a;
        double d = ((double) a.f7843g) / 1152.0d;
        double size = ((double) this.f7835q.size()) / d;
        LinkedList linkedList = new LinkedList();
        Iterator<C1024xh> it = this.f7835q.iterator();
        long j = 0;
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                this.f7833h = (long) ((int) (((double) (j * 8)) / size));
                this.f7830e = new C0737pi();
                C0793rd rdVar = new C0793rd(C0793rd.f6034d);
                rdVar.mo5577b(this.f7831f.f7846j);
                rdVar.mo5573a((long) this.f7831f.f7843g);
                rdVar.mo204a(1);
                rdVar.mo5579c(16);
                ade ade = new ade();
                adn adn = new adn();
                adn.mo348b(0);
                adu adu = new adu();
                adu.mo373a(2);
                adn.mo346a(adu);
                adk adk = new adk();
                adk.mo322a(107);
                adk.mo326b(5);
                adk.mo323a(this.f7832g);
                adk.mo327b(this.f7833h);
                adn.mo345a(adk);
                ade.mo112c(adn.mo295b());
                rdVar.mo170a((C0688nt) ade);
                this.f7830e.mo170a((C0688nt) rdVar);
                this.f7829d.mo6182b(new Date());
                this.f7829d.mo6177a(new Date());
                this.f7829d.mo6176a(str);
                this.f7829d.mo6172a(1.0f);
                this.f7829d.mo6174a((long) this.f7831f.f7843g);
                long[] jArr = new long[this.f7835q.size()];
                this.f7836r = jArr;
                Arrays.fill(jArr, 1152);
                return;
            }
            int a2 = (int) it.next().mo7a();
            j += (long) a2;
            linkedList.add(Integer.valueOf(a2));
            while (((double) linkedList.size()) > d) {
                linkedList.pop();
            }
            if (linkedList.size() == ((int) d)) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    i += ((Integer) it2.next()).intValue();
                }
                double size2 = ((((double) i) * 8.0d) / ((double) linkedList.size())) * d;
                if (size2 > ((double) this.f7832g)) {
                    this.f7832g = (long) ((int) size2);
                }
            }
        }
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7830e;
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7836r;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7829d;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7835q;
    }

    /* renamed from: atakplugin.UASTool.za$a */
    class C1078a {

        /* renamed from: a */
        int f7837a;

        /* renamed from: b */
        int f7838b;

        /* renamed from: c */
        int f7839c;

        /* renamed from: d */
        int f7840d;

        /* renamed from: e */
        int f7841e;

        /* renamed from: f */
        int f7842f;

        /* renamed from: g */
        int f7843g;

        /* renamed from: h */
        int f7844h;

        /* renamed from: i */
        int f7845i;

        /* renamed from: j */
        int f7846j;

        C1078a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo6307a() {
            return ((this.f7841e * 144) / this.f7843g) + this.f7844h;
        }
    }

    /* renamed from: a */
    private C1078a m14886a(C1007ws wsVar) {
        C1078a aVar = null;
        while (true) {
            long b = wsVar.mo5655b();
            C1078a b2 = m14887b(wsVar);
            if (b2 == null) {
                return aVar;
            }
            if (aVar == null) {
                aVar = b2;
            }
            wsVar.mo5654a(b);
            ByteBuffer allocate = ByteBuffer.allocate(b2.mo6307a());
            wsVar.mo5650a(allocate);
            allocate.rewind();
            this.f7835q.add(new C1025xi(allocate));
        }
    }

    /* renamed from: b */
    private C1078a m14887b(C1007ws wsVar) {
        C1078a aVar = new C1078a();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        while (allocate.position() < 4) {
            if (wsVar.mo5650a(allocate) == -1) {
                return null;
            }
        }
        adi adi = new adi((ByteBuffer) allocate.rewind());
        if (adi.mo315a(11) == 2047) {
            int i = 2;
            aVar.f7837a = adi.mo315a(2);
            if (aVar.f7837a == 3) {
                aVar.f7838b = adi.mo315a(2);
                if (aVar.f7838b == 1) {
                    aVar.f7839c = adi.mo315a(1);
                    aVar.f7840d = adi.mo315a(4);
                    aVar.f7841e = f7825l[aVar.f7840d];
                    if (aVar.f7841e != 0) {
                        aVar.f7842f = adi.mo315a(2);
                        aVar.f7843g = f7824k[aVar.f7842f];
                        if (aVar.f7843g != 0) {
                            aVar.f7844h = adi.mo315a(1);
                            adi.mo315a(1);
                            aVar.f7845i = adi.mo315a(2);
                            if (aVar.f7845i == 3) {
                                i = 1;
                            }
                            aVar.f7846j = i;
                            return aVar;
                        }
                        throw new IOException("Unexpected (reserved) sample rate frequency");
                    }
                    throw new IOException("Unexpected (free/bad) bit rate");
                }
                throw new IOException("Expected Layer III");
            }
            throw new IOException("Expected MPEG Version 1 (ISO/IEC 11172-3)");
        }
        throw new IOException("Expected Start Word 0x7ff");
    }
}
