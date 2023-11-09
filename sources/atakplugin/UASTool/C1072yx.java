package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import atakplugin.UASTool.aaq;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.yx */
public class C1072yx extends C1018xc {

    /* renamed from: f */
    private static final long f7793f = 20;

    /* renamed from: d */
    C1027xk f7794d = new C1027xk();

    /* renamed from: e */
    C0737pi f7795e;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C1007ws f7796g;

    /* renamed from: h */
    private int f7797h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f7798i;

    /* renamed from: j */
    private List<C1073a> f7799j = new LinkedList();

    /* renamed from: k */
    private List<C1024xh> f7800k;

    /* renamed from: l */
    private long[] f7801l;

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return null;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return null;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return null;
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return null;
    }

    /* renamed from: p */
    public String mo15p() {
        return "soun";
    }

    public C1072yx(C1007ws wsVar) {
        super(wsVar.toString());
        this.f7796g = wsVar;
        boolean z = false;
        while (!z) {
            C1073a i = m14861i();
            if (i != null) {
                for (C1073a next : this.f7799j) {
                    if (i.f7806e != 1 && next.f7803b == i.f7803b) {
                        z = true;
                    }
                }
                if (!z) {
                    this.f7799j.add(i);
                }
            } else {
                throw new IOException();
            }
        }
        if (this.f7799j.size() != 0) {
            int i2 = this.f7799j.get(0).f7805d;
            this.f7795e = new C0737pi();
            C0793rd rdVar = new C0793rd(C0793rd.f6039i);
            rdVar.mo5577b(2);
            long j = (long) i2;
            rdVar.mo5573a(j);
            rdVar.mo204a(1);
            rdVar.mo5579c(16);
            aaq aaq = new aaq();
            int[] iArr = new int[this.f7799j.size()];
            int[] iArr2 = new int[this.f7799j.size()];
            for (C1073a next2 : this.f7799j) {
                if (next2.f7806e == 1) {
                    int i3 = next2.f7803b;
                    iArr[i3] = iArr[i3] + 1;
                    iArr2[next2.f7803b] = ((next2.f7807f >> 5) & 255) | ((next2.f7807f >> 6) & 256);
                }
            }
            for (C1073a next3 : this.f7799j) {
                if (next3.f7806e != 1) {
                    aaq.C0003a aVar = new aaq.C0003a();
                    aVar.f132g = next3.f132g;
                    aVar.f133h = next3.f133h;
                    aVar.f134i = next3.f134i;
                    aVar.f135j = next3.f135j;
                    aVar.f136k = next3.f136k;
                    aVar.f137l = 0;
                    aVar.f138m = iArr[next3.f7803b];
                    aVar.f139n = iArr2[next3.f7803b];
                    aVar.f140o = 0;
                    aaq.mo94a(aVar);
                }
                this.f7797h += next3.f7804c;
                this.f7798i += next3.f7802a;
            }
            aaq.mo93a(this.f7797h / 1000);
            rdVar.mo170a((C0688nt) aaq);
            this.f7795e.mo170a((C0688nt) rdVar);
            this.f7794d.mo6182b(new Date());
            this.f7794d.mo6177a(new Date());
            this.f7794d.mo6174a(j);
            this.f7794d.mo6172a(1.0f);
            wsVar.mo5654a(0);
            List<C1024xh> j2 = m14862j();
            this.f7800k = j2;
            long[] jArr = new long[j2.size()];
            this.f7801l = jArr;
            Arrays.fill(jArr, 1536);
            return;
        }
        throw new IOException();
    }

    public void close() {
        this.f7796g.close();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7800k;
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7795e;
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7801l;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7794d;
    }

    /* renamed from: i */
    private C1073a m14861i() {
        int i;
        long b = this.f7796g.mo5655b();
        ByteBuffer allocate = ByteBuffer.allocate(200);
        this.f7796g.mo5650a(allocate);
        allocate.rewind();
        adi adi = new adi(allocate);
        if (adi.mo315a(16) != 2935) {
            return null;
        }
        C1073a aVar = new C1073a();
        aVar.f7806e = adi.mo315a(2);
        aVar.f7803b = adi.mo315a(3);
        aVar.f7802a = (adi.mo315a(11) + 1) * 2;
        aVar.f132g = adi.mo315a(2);
        int i2 = -1;
        if (aVar.f132g == 3) {
            i2 = adi.mo315a(2);
            i = 3;
        } else {
            i = adi.mo315a(2);
        }
        int i3 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : 6 : 3 : 2 : 1;
        aVar.f7802a *= 6 / i3;
        aVar.f135j = adi.mo315a(3);
        aVar.f136k = adi.mo315a(1);
        aVar.f133h = adi.mo315a(5);
        adi.mo315a(5);
        if (1 == adi.mo315a(1)) {
            adi.mo315a(8);
        }
        if (aVar.f135j == 0) {
            adi.mo315a(5);
            if (1 == adi.mo315a(1)) {
                adi.mo315a(8);
            }
        }
        if (1 == aVar.f7806e && 1 == adi.mo315a(1)) {
            aVar.f7807f = adi.mo315a(16);
        }
        if (1 == adi.mo315a(1)) {
            if (aVar.f135j > 2) {
                adi.mo315a(2);
            }
            if (1 == (aVar.f135j & 1) && aVar.f135j > 2) {
                adi.mo315a(3);
                adi.mo315a(3);
            }
            if ((aVar.f135j & 4) > 0) {
                adi.mo315a(3);
                adi.mo315a(3);
            }
            if (1 == aVar.f136k && 1 == adi.mo315a(1)) {
                adi.mo315a(5);
            }
            if (aVar.f7806e == 0) {
                if (1 == adi.mo315a(1)) {
                    adi.mo315a(6);
                }
                if (aVar.f135j == 0 && 1 == adi.mo315a(1)) {
                    adi.mo315a(6);
                }
                if (1 == adi.mo315a(1)) {
                    adi.mo315a(6);
                }
                int a = adi.mo315a(2);
                if (1 == a) {
                    adi.mo315a(5);
                } else if (2 == a) {
                    adi.mo315a(12);
                } else if (3 == a) {
                    int a2 = adi.mo315a(5);
                    if (1 == adi.mo315a(1)) {
                        adi.mo315a(5);
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(4);
                        }
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(4);
                        }
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(4);
                        }
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(4);
                        }
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(4);
                        }
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(4);
                        }
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(4);
                        }
                        if (1 == adi.mo315a(1)) {
                            if (1 == adi.mo315a(1)) {
                                adi.mo315a(4);
                            }
                            if (1 == adi.mo315a(1)) {
                                adi.mo315a(4);
                            }
                        }
                    }
                    if (1 == adi.mo315a(1)) {
                        adi.mo315a(5);
                        if (1 == adi.mo315a(1)) {
                            adi.mo315a(7);
                            if (1 == adi.mo315a(1)) {
                                adi.mo315a(8);
                            }
                        }
                    }
                    for (int i4 = 0; i4 < a2 + 2; i4++) {
                        adi.mo315a(8);
                    }
                    adi.mo318c();
                }
                if (aVar.f135j < 2) {
                    if (1 == adi.mo315a(1)) {
                        adi.mo315a(14);
                    }
                    if (aVar.f135j == 0 && 1 == adi.mo315a(1)) {
                        adi.mo315a(14);
                    }
                    if (1 == adi.mo315a(1)) {
                        if (i == 0) {
                            adi.mo315a(5);
                        } else {
                            for (int i5 = 0; i5 < i3; i5++) {
                                if (1 == adi.mo315a(1)) {
                                    adi.mo315a(5);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (1 == adi.mo315a(1)) {
            aVar.f134i = adi.mo315a(3);
        }
        int i6 = aVar.f132g;
        if (i6 == 0) {
            aVar.f7805d = 48000;
        } else if (i6 == 1) {
            aVar.f7805d = 44100;
        } else if (i6 == 2) {
            aVar.f7805d = 32000;
        } else if (i6 == 3) {
            if (i2 == 0) {
                aVar.f7805d = 24000;
            } else if (i2 == 1) {
                aVar.f7805d = 22050;
            } else if (i2 == 2) {
                aVar.f7805d = 16000;
            } else if (i2 == 3) {
                aVar.f7805d = 0;
            }
        }
        if (aVar.f7805d == 0) {
            return null;
        }
        aVar.f7804c = (int) ((((double) aVar.f7805d) / 1536.0d) * ((double) aVar.f7802a) * 8.0d);
        this.f7796g.mo5654a(b + ((long) aVar.f7802a));
        return aVar;
    }

    /* renamed from: j */
    private List<C1024xh> m14862j() {
        int a = afi.m847a((this.f7796g.mo5651a() - this.f7796g.mo5655b()) / ((long) this.f7798i));
        ArrayList arrayList = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            arrayList.add(new C1074yy(this, this.f7798i * i));
        }
        return arrayList;
    }

    /* renamed from: atakplugin.UASTool.yx$a */
    public static class C1073a extends aaq.C0003a {

        /* renamed from: a */
        public int f7802a;

        /* renamed from: b */
        public int f7803b;

        /* renamed from: c */
        public int f7804c;

        /* renamed from: d */
        public int f7805d;

        /* renamed from: e */
        public int f7806e;

        /* renamed from: f */
        public int f7807f;

        public String toString() {
            return "BitStreamInfo{frameSize=" + this.f7802a + ", substreamid=" + this.f7803b + ", bitrate=" + this.f7804c + ", samplerate=" + this.f7805d + ", strmtyp=" + this.f7806e + ", chanmap=" + this.f7807f + '}';
        }
    }

    public String toString() {
        return "EC3TrackImpl{bitrate=" + this.f7797h + ", bitStreamInfos=" + this.f7799j + '}';
    }
}
