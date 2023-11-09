package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import atakplugin.UASTool.C1053yh;
import atakplugin.UASTool.C1092zk;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.zi */
public class C1088zi extends C1053yh {
    /* access modifiers changed from: private */

    /* renamed from: z */
    public static final Logger f7899z = Logger.getLogger(C1088zi.class.getName());

    /* renamed from: A */
    private List<C1024xh> f7900A;

    /* renamed from: B */
    private int f7901B;

    /* renamed from: C */
    private int f7902C;

    /* renamed from: D */
    private long f7903D;

    /* renamed from: E */
    private int f7904E;

    /* renamed from: F */
    private C1090b f7905F;

    /* renamed from: G */
    private boolean f7906G;

    /* renamed from: H */
    private String f7907H;

    /* renamed from: k */
    Map<Integer, byte[]> f7908k;

    /* renamed from: l */
    Map<Integer, aez> f7909l;

    /* renamed from: m */
    Map<Integer, byte[]> f7910m;

    /* renamed from: n */
    Map<Integer, aew> f7911n;

    /* renamed from: o */
    C0737pi f7912o;

    /* renamed from: p */
    aez f7913p;

    /* renamed from: q */
    aew f7914q;

    /* renamed from: r */
    aez f7915r;

    /* renamed from: s */
    aew f7916s;

    /* renamed from: t */
    afu<Integer, byte[]> f7917t;

    /* renamed from: u */
    afu<Integer, byte[]> f7918u;

    /* renamed from: v */
    int f7919v;

    /* renamed from: w */
    int[] f7920w;

    /* renamed from: x */
    int f7921x;

    /* renamed from: y */
    int f7922y;

    /* renamed from: p */
    public String mo15p() {
        return "vide";
    }

    public C1088zi(C1007ws wsVar, String str, long j, int i) {
        super(wsVar);
        this.f7908k = new HashMap();
        this.f7909l = new HashMap();
        this.f7910m = new HashMap();
        this.f7911n = new HashMap();
        this.f7913p = null;
        this.f7914q = null;
        this.f7915r = null;
        this.f7916s = null;
        this.f7917t = new afu<>();
        this.f7918u = new afu<>();
        this.f7919v = 0;
        this.f7906G = true;
        this.f7907H = "eng";
        this.f7920w = new int[0];
        this.f7921x = 0;
        this.f7922y = 0;
        this.f7907H = str;
        this.f7903D = j;
        this.f7904E = i;
        if (j > 0 && i > 0) {
            this.f7906G = false;
        }
        m14951b(new C1053yh.C1054a(wsVar));
    }

    public C1088zi(C1007ws wsVar, String str) {
        this(wsVar, str, -1, -1);
    }

    public C1088zi(C1007ws wsVar) {
        this(wsVar, "eng");
    }

    /* renamed from: b */
    private void m14951b(C1053yh.C1054a aVar) {
        this.f7900A = new ArrayList();
        if (!m14955c(aVar)) {
            throw new IOException();
        } else if (m14958k()) {
            this.f7912o = new C0737pi();
            C0801rj rjVar = new C0801rj(C0801rj.f6084d);
            rjVar.mo204a(1);
            rjVar.mo5644e(24);
            rjVar.mo5643d(1);
            rjVar.mo5635a(72.0d);
            rjVar.mo5638b(72.0d);
            rjVar.mo5639b(this.f7901B);
            rjVar.mo5641c(this.f7902C);
            rjVar.mo5640b("AVC Coding");
            akz akz = new akz();
            akz.mo1211a((List<byte[]>) new ArrayList(this.f7908k.values()));
            akz.mo1215b((List<byte[]>) new ArrayList(this.f7910m.values()));
            akz.mo1218d(this.f7913p.f807y);
            akz.mo1214b(this.f7913p.f799q);
            akz.mo1221g(this.f7913p.f796n);
            akz.mo1222h(this.f7913p.f797o);
            akz.mo1220f(this.f7913p.f791i.mo521a());
            akz.mo1210a(1);
            akz.mo1219e(3);
            int i = 0;
            int i2 = (this.f7913p.f801s ? 128 : 0) + (this.f7913p.f802t ? 64 : 0) + (this.f7913p.f803u ? 32 : 0) + (this.f7913p.f804v ? 16 : 0);
            if (this.f7913p.f805w) {
                i = 8;
            }
            akz.mo1216c(i2 + i + ((int) (this.f7913p.f800r & 3)));
            rjVar.mo170a((C0688nt) akz);
            this.f7912o.mo170a((C0688nt) rjVar);
            this.f7692e_.mo6182b(new Date());
            this.f7692e_.mo6177a(new Date());
            this.f7692e_.mo6176a(this.f7907H);
            this.f7692e_.mo6174a(this.f7903D);
            this.f7692e_.mo6171a((double) this.f7901B);
            this.f7692e_.mo6179b((double) this.f7902C);
        } else {
            throw new IOException();
        }
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7912o;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7900A;
    }

    /* renamed from: k */
    private boolean m14958k() {
        int i;
        this.f7901B = (this.f7913p.f795m + 1) * 16;
        int i2 = this.f7913p.f773F ? 1 : 2;
        this.f7902C = (this.f7913p.f794l + 1) * 16 * i2;
        if (this.f7913p.f774G) {
            int i3 = 0;
            if (!this.f7913p.f768A) {
                i3 = this.f7913p.f791i.mo521a();
            }
            if (i3 != 0) {
                i = this.f7913p.f791i.mo522b();
                i2 *= this.f7913p.f791i.mo523c();
            } else {
                i = 1;
            }
            this.f7901B -= i * (this.f7913p.f775H + this.f7913p.f776I);
            this.f7902C -= i2 * (this.f7913p.f777J + this.f7913p.f778K);
        }
        return true;
    }

    /* renamed from: c */
    private boolean m14955c(C1053yh.C1054a aVar) {
        ArrayList arrayList = new ArrayList();
        C1091zj zjVar = null;
        while (true) {
            ByteBuffer a = mo6273a(aVar);
            if (a != null) {
                C1086zg b = m14949b(a);
                switch (b.f7866b) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        C1091zj zjVar2 = new C1091zj(this, a, b.f7865a, b.f7866b);
                        if (zjVar != null && zjVar.mo6324a(zjVar2)) {
                            f7899z.finer("Wrapping up cause of first vcl nal is found");
                            m14952b((List<ByteBuffer>) arrayList);
                        }
                        arrayList.add((ByteBuffer) a.rewind());
                        zjVar = zjVar2;
                        continue;
                    case 6:
                        if (zjVar != null) {
                            f7899z.finer("Wrapping up cause of SEI after vcl marks new sample");
                            m14952b((List<ByteBuffer>) arrayList);
                            zjVar = null;
                        }
                        this.f7905F = new C1090b(this, m14713a((InputStream) new C1089a(a)), this.f7915r);
                        arrayList.add(a);
                        continue;
                    case 7:
                        if (zjVar != null) {
                            f7899z.finer("Wrapping up cause of SPS after vcl marks new sample");
                            m14952b((List<ByteBuffer>) arrayList);
                            zjVar = null;
                        }
                        m14956d((ByteBuffer) a.rewind());
                        continue;
                    case 8:
                        if (zjVar != null) {
                            f7899z.finer("Wrapping up cause of PPS after vcl marks new sample");
                            m14952b((List<ByteBuffer>) arrayList);
                            zjVar = null;
                        }
                        m14954c((ByteBuffer) a.rewind());
                        continue;
                    case 9:
                        if (zjVar != null) {
                            f7899z.finer("Wrapping up cause of AU after vcl marks new sample");
                            m14952b((List<ByteBuffer>) arrayList);
                            zjVar = null;
                        }
                        arrayList.add(a);
                        continue;
                    case 10:
                    case 11:
                        break;
                    case 13:
                        throw new RuntimeException("Sequence parameter set extension is not yet handled. Needs TLC.");
                    default:
                        f7899z.warning("Unknown NAL unit type: " + b.f7866b);
                        continue;
                }
            }
        }
        if (arrayList.size() > 0) {
            m14952b((List<ByteBuffer>) arrayList);
        }
        mo6320i();
        this.f7688a_ = new long[this.f7900A.size()];
        Arrays.fill(this.f7688a_, (long) this.f7904E);
        return true;
    }

    /* renamed from: i */
    public void mo6320i() {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f7920w.length) {
            int i4 = Integer.MAX_VALUE;
            int i5 = 0;
            for (int max = Math.max(0, i2 - 128); max < Math.min(this.f7920w.length, i2 + 128); max++) {
                int[] iArr = this.f7920w;
                if (iArr[max] > i && iArr[max] < i4) {
                    i4 = iArr[max];
                    i5 = max;
                }
            }
            int[] iArr2 = this.f7920w;
            int i6 = iArr2[i5];
            iArr2[i5] = i3;
            i2++;
            i = i6;
            i3++;
        }
        for (int i7 = 0; i7 < this.f7920w.length; i7++) {
            this.f7689b_.add(new C0693ny.C0694a(1, this.f7920w[i7] - i7));
        }
        this.f7920w = new int[0];
    }

    /* renamed from: b */
    private void m14952b(List<ByteBuffer> list) {
        int i;
        C0735ph.C0736a aVar = new C0735ph.C0736a(0);
        C1086zg zgVar = null;
        boolean z = false;
        for (ByteBuffer b : list) {
            C1086zg b2 = m14949b(b);
            int i2 = b2.f7866b;
            if (!(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4)) {
                if (i2 == 5) {
                    z = true;
                }
            }
            zgVar = b2;
        }
        if (zgVar == null) {
            f7899z.warning("Sample without Slice");
            return;
        }
        if (z) {
            mo6320i();
        }
        C1092zk zkVar = new C1092zk(m14713a((InputStream) new C1089a(list.get(list.size() - 1))), this.f7909l, this.f7911n, z);
        if (zgVar.f7865a == 0) {
            aVar.mo5310c(2);
        } else {
            aVar.mo5310c(1);
        }
        if (zkVar.f7960b == C1092zk.C1093a.I || zkVar.f7960b == C1092zk.C1093a.SI) {
            aVar.mo5308b(2);
        } else {
            aVar.mo5308b(1);
        }
        C1024xh a = mo6272a((List<? extends ByteBuffer>) list);
        list.clear();
        C1090b bVar = this.f7905F;
        if (bVar == null || bVar.f7938n == 0) {
            this.f7919v = 0;
        }
        if (zkVar.f7972n.f783a == 0) {
            int i3 = 1 << (zkVar.f7972n.f793k + 4);
            int i4 = zkVar.f7967i;
            int i5 = this.f7921x;
            if (i4 < i5 && i5 - i4 >= i3 / 2) {
                i = this.f7922y + i3;
            } else if (i4 <= i5 || i4 - i5 <= i3 / 2) {
                i = this.f7922y;
            } else {
                i = this.f7922y - i3;
            }
            this.f7920w = afs.m879a(this.f7920w, i + i4);
            this.f7921x = i4;
            this.f7922y = i;
        } else if (zkVar.f7972n.f783a == 1) {
            throw new RuntimeException("pic_order_cnt_type == 1 needs to be implemented");
        } else if (zkVar.f7972n.f783a == 2) {
            this.f7920w = afs.m879a(this.f7920w, this.f7900A.size());
        }
        this.f7690c_.add(aVar);
        this.f7919v++;
        this.f7900A.add(a);
        if (z) {
            this.f7691d_.add(Integer.valueOf(this.f7900A.size()));
        }
    }

    /* renamed from: a */
    private int m14946a(int i, C1086zg zgVar, C1092zk zkVar) {
        if (zkVar.f7972n.f783a == 0) {
            return m14947a(zgVar, zkVar);
        }
        if (zkVar.f7972n.f783a == 1) {
            return m14953c(i, zgVar, zkVar);
        }
        return m14948b(i, zgVar, zkVar);
    }

    /* renamed from: b */
    private int m14948b(int i, C1086zg zgVar, C1092zk zkVar) {
        return zgVar.f7865a == 0 ? (i * 2) - 1 : i * 2;
    }

    /* renamed from: c */
    private int m14953c(int i, C1086zg zgVar, C1092zk zkVar) {
        int i2 = 0;
        if (zkVar.f7972n.f782O == 0) {
            i = 0;
        }
        if (zgVar.f7865a == 0 && i > 0) {
            i--;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < zkVar.f7972n.f782O; i4++) {
            i3 += zkVar.f7972n.f779L[i4];
        }
        if (i > 0) {
            int i5 = i - 1;
            int i6 = i5 / zkVar.f7972n.f782O;
            int i7 = i5 % zkVar.f7972n.f782O;
            int i8 = i6 * i3;
            while (i2 <= i7) {
                i8 += zkVar.f7972n.f779L[i2];
                i2++;
            }
            i2 = i8;
        }
        if (zgVar.f7865a == 0) {
            i2 += zkVar.f7972n.f769B;
        }
        return i2 + zkVar.f7969k;
    }

    /* renamed from: a */
    private int m14947a(C1086zg zgVar, C1092zk zkVar) {
        int i;
        int i2 = zkVar.f7967i;
        int i3 = 1 << (zkVar.f7972n.f793k + 4);
        int i4 = this.f7921x;
        if (i2 < i4 && i4 - i2 >= i3 / 2) {
            i = this.f7922y + i3;
        } else if (i2 <= i4 || i2 - i4 <= i3 / 2) {
            i = this.f7922y;
        } else {
            i = this.f7922y - i3;
        }
        if (zgVar.f7865a != 0) {
            this.f7922y = i;
            this.f7921x = i2;
        }
        return i + i2;
    }

    /* renamed from: c */
    private void m14954c(ByteBuffer byteBuffer) {
        C1089a aVar = new C1089a(byteBuffer);
        aVar.read();
        aew a = aew.m786a((InputStream) aVar);
        if (this.f7914q == null) {
            this.f7914q = a;
        }
        this.f7916s = a;
        byte[] a2 = m14714a((ByteBuffer) byteBuffer.rewind());
        byte[] bArr = this.f7910m.get(Integer.valueOf(a.f741e));
        if (bArr == null || Arrays.equals(bArr, a2)) {
            if (bArr == null) {
                this.f7918u.put(Integer.valueOf(this.f7900A.size()), a2);
            }
            this.f7910m.put(Integer.valueOf(a.f741e), a2);
            this.f7911n.put(Integer.valueOf(a.f741e), a);
            return;
        }
        throw new RuntimeException("OMG - I got two SPS with same ID but different settings! (AVC3 is the solution)");
    }

    /* renamed from: d */
    private void m14956d(ByteBuffer byteBuffer) {
        InputStream a = m14713a((InputStream) new C1089a(byteBuffer));
        a.read();
        aez a2 = aez.m791a(a);
        if (this.f7913p == null) {
            this.f7913p = a2;
            m14959q();
        }
        this.f7915r = a2;
        byte[] a3 = m14714a((ByteBuffer) byteBuffer.rewind());
        byte[] bArr = this.f7908k.get(Integer.valueOf(a2.f808z));
        if (bArr == null || Arrays.equals(bArr, a3)) {
            if (bArr != null) {
                this.f7917t.put(Integer.valueOf(this.f7900A.size()), a3);
            }
            this.f7908k.put(Integer.valueOf(a2.f808z), a3);
            this.f7909l.put(Integer.valueOf(a2.f808z), a2);
            return;
        }
        throw new RuntimeException("OMG - I got two SPS with same ID but different settings!");
    }

    /* renamed from: q */
    private void m14959q() {
        if (!this.f7906G) {
            return;
        }
        if (this.f7913p.f780M != null) {
            this.f7903D = (long) (this.f7913p.f780M.f828r >> 1);
            int i = this.f7913p.f780M.f827q;
            this.f7904E = i;
            if (this.f7903D == 0 || i == 0) {
                Logger logger = f7899z;
                logger.warning("vuiParams contain invalid values: time_scale: " + this.f7903D + " and frame_tick: " + this.f7904E + ". Setting frame rate to 25fps");
                this.f7903D = 90000;
                this.f7904E = 3600;
            }
            if (this.f7903D / ((long) this.f7904E) > 100) {
                Logger logger2 = f7899z;
                logger2.warning("Framerate is " + (this.f7903D / ((long) this.f7904E)) + ". That is suspicious.");
                return;
            }
            return;
        }
        f7899z.warning("Can't determine frame rate. Guessing 25 fps");
        this.f7903D = 90000;
        this.f7904E = 3600;
    }

    /* renamed from: atakplugin.UASTool.zi$a */
    public class C1089a extends InputStream {

        /* renamed from: b */
        private final ByteBuffer f7924b;

        public C1089a(ByteBuffer byteBuffer) {
            this.f7924b = byteBuffer.duplicate();
        }

        public int read() {
            if (!this.f7924b.hasRemaining()) {
                return -1;
            }
            return this.f7924b.get() & 255;
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!this.f7924b.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, this.f7924b.remaining());
            this.f7924b.get(bArr, i, min);
            return min;
        }
    }

    /* renamed from: atakplugin.UASTool.zi$b */
    public class C1090b {

        /* renamed from: a */
        int f7925a = 0;

        /* renamed from: b */
        int f7926b = 0;

        /* renamed from: c */
        boolean f7927c;

        /* renamed from: d */
        int f7928d;

        /* renamed from: e */
        int f7929e;

        /* renamed from: f */
        boolean f7930f;

        /* renamed from: g */
        int f7931g;

        /* renamed from: h */
        int f7932h;

        /* renamed from: i */
        int f7933i;

        /* renamed from: j */
        int f7934j;

        /* renamed from: k */
        int f7935k;

        /* renamed from: l */
        int f7936l;

        /* renamed from: m */
        int f7937m;

        /* renamed from: n */
        int f7938n;

        /* renamed from: o */
        int f7939o;

        /* renamed from: p */
        int f7940p;

        /* renamed from: q */
        int f7941q;

        /* renamed from: r */
        int f7942r;

        /* renamed from: s */
        int f7943s;

        /* renamed from: t */
        aez f7944t;

        /* renamed from: u */
        final /* synthetic */ C1088zi f7945u;

        public C1090b(C1088zi ziVar, InputStream inputStream, aez aez) {
            int i;
            aez aez2 = aez;
            this.f7945u = ziVar;
            boolean z = false;
            this.f7944t = aez2;
            inputStream.read();
            int available = inputStream.available();
            int i2 = 0;
            while (i2 < available) {
                this.f7925a = z ? 1 : 0;
                this.f7926b = z;
                int read = inputStream.read();
                int i3 = i2 + 1;
                while (read == 255) {
                    InputStream inputStream2 = inputStream;
                    this.f7925a += read;
                    read = inputStream.read();
                    i3++;
                    z = false;
                }
                this.f7925a += read;
                int read2 = inputStream.read();
                i2 = i3 + 1;
                while (read2 == 255) {
                    InputStream inputStream3 = inputStream;
                    this.f7926b += read2;
                    read2 = inputStream.read();
                    i2++;
                    z = false;
                }
                int i4 = this.f7926b + read2;
                this.f7926b = i4;
                if (available - i2 < i4) {
                    InputStream inputStream4 = inputStream;
                    i2 = available;
                } else if (this.f7925a != 1) {
                    InputStream inputStream5 = inputStream;
                    for (int i5 = 0; i5 < this.f7926b; i5++) {
                        inputStream.read();
                        i2++;
                    }
                } else if (aez2.f780M == null || (aez2.f780M.f832v == null && aez2.f780M.f833w == null && !aez2.f780M.f831u)) {
                    InputStream inputStream6 = inputStream;
                    for (int i6 = 0; i6 < this.f7926b; i6++) {
                        inputStream.read();
                        i2++;
                    }
                } else {
                    byte[] bArr = new byte[this.f7926b];
                    inputStream.read(bArr);
                    i2 += this.f7926b;
                    afc afc = new afc(new ByteArrayInputStream(bArr));
                    if (aez2.f780M.f832v == null && aez2.f780M.f833w == null) {
                        this.f7927c = z;
                    } else {
                        this.f7927c = true;
                        this.f7928d = afc.mo550b(aez2.f780M.f832v.f734h + 1, "SEI: cpb_removal_delay");
                        this.f7929e = afc.mo550b(aez2.f780M.f832v.f735i + 1, "SEI: dpb_removal_delay");
                    }
                    if (aez2.f780M.f831u) {
                        int b = afc.mo550b(4, "SEI: pic_struct");
                        this.f7931g = b;
                        switch (b) {
                            case 3:
                            case 4:
                            case 7:
                                i = 2;
                                break;
                            case 5:
                            case 6:
                            case 8:
                                i = 3;
                                break;
                            default:
                                i = 1;
                                break;
                        }
                        for (int i7 = 0; i7 < i; i7++) {
                            boolean c = afc.mo552c("pic_timing SEI: clock_timestamp_flag[" + i7 + "]");
                            this.f7930f = c;
                            if (c) {
                                this.f7932h = afc.mo550b(2, "pic_timing SEI: ct_type");
                                this.f7933i = afc.mo550b(1, "pic_timing SEI: nuit_field_based_flag");
                                this.f7934j = afc.mo550b(5, "pic_timing SEI: counting_type");
                                this.f7935k = afc.mo550b(1, "pic_timing SEI: full_timestamp_flag");
                                this.f7936l = afc.mo550b(1, "pic_timing SEI: discontinuity_flag");
                                this.f7937m = afc.mo550b(1, "pic_timing SEI: cnt_dropped_flag");
                                this.f7938n = afc.mo550b(8, "pic_timing SEI: n_frames");
                                if (this.f7935k == 1) {
                                    this.f7939o = afc.mo550b(6, "pic_timing SEI: seconds_value");
                                    this.f7940p = afc.mo550b(6, "pic_timing SEI: minutes_value");
                                    this.f7941q = afc.mo550b(5, "pic_timing SEI: hours_value");
                                } else if (afc.mo552c("pic_timing SEI: seconds_flag")) {
                                    this.f7939o = afc.mo550b(6, "pic_timing SEI: seconds_value");
                                    if (afc.mo552c("pic_timing SEI: minutes_flag")) {
                                        this.f7940p = afc.mo550b(6, "pic_timing SEI: minutes_value");
                                        if (afc.mo552c("pic_timing SEI: hours_flag")) {
                                            this.f7941q = afc.mo550b(5, "pic_timing SEI: hours_value");
                                        }
                                    }
                                }
                                if (aez2.f780M.f832v != null) {
                                    this.f7942r = aez2.f780M.f832v.f736j;
                                } else if (aez2.f780M.f833w != null) {
                                    this.f7942r = aez2.f780M.f833w.f736j;
                                } else {
                                    this.f7942r = 24;
                                }
                                this.f7943s = afc.mo550b(24, "pic_timing SEI: time_offset");
                            }
                        }
                    }
                }
                C1088zi.f7899z.fine(toString());
                z = false;
            }
        }

        public String toString() {
            String str = "SEIMessage{payloadType=" + this.f7925a + ", payloadSize=" + this.f7926b;
            if (this.f7925a == 1) {
                if (!(this.f7944t.f780M.f832v == null && this.f7944t.f780M.f833w == null)) {
                    str = String.valueOf(str) + ", cpb_removal_delay=" + this.f7928d + ", dpb_removal_delay=" + this.f7929e;
                }
                if (this.f7944t.f780M.f831u) {
                    str = String.valueOf(str) + ", pic_struct=" + this.f7931g;
                    if (this.f7930f) {
                        str = String.valueOf(str) + ", ct_type=" + this.f7932h + ", nuit_field_based_flag=" + this.f7933i + ", counting_type=" + this.f7934j + ", full_timestamp_flag=" + this.f7935k + ", discontinuity_flag=" + this.f7936l + ", cnt_dropped_flag=" + this.f7937m + ", n_frames=" + this.f7938n + ", seconds_value=" + this.f7939o + ", minutes_value=" + this.f7940p + ", hours_value=" + this.f7941q + ", time_offset_length=" + this.f7942r + ", time_offset=" + this.f7943s;
                    }
                }
            }
            return String.valueOf(str) + '}';
        }
    }

    /* renamed from: b */
    public static C1086zg m14949b(ByteBuffer byteBuffer) {
        C1086zg zgVar = new C1086zg();
        byte b = byteBuffer.get(0);
        zgVar.f7865a = (b >> 5) & 3;
        zgVar.f7866b = b & Ascii.f8526US;
        return zgVar;
    }
}
