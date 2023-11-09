package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: atakplugin.UASTool.yd */
public class C1048yd extends C1018xc {

    /* renamed from: d */
    static Map<Integer, String> f7647d;

    /* renamed from: e */
    public static Map<Integer, Integer> f7648e;

    /* renamed from: f */
    C1027xk f7649f;

    /* renamed from: g */
    C0737pi f7650g;

    /* renamed from: h */
    long[] f7651h;

    /* renamed from: i */
    C1049a f7652i;

    /* renamed from: j */
    int f7653j;

    /* renamed from: k */
    long f7654k;

    /* renamed from: l */
    long f7655l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C1007ws f7656m;

    /* renamed from: n */
    private List<C1024xh> f7657n;

    /* renamed from: o */
    private String f7658o;

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

    static {
        HashMap hashMap = new HashMap();
        f7647d = hashMap;
        hashMap.put(1, "AAC Main");
        f7647d.put(2, "AAC LC (Low Complexity)");
        f7647d.put(3, "AAC SSR (Scalable Sample Rate)");
        f7647d.put(4, "AAC LTP (Long Term Prediction)");
        f7647d.put(5, "SBR (Spectral Band Replication)");
        f7647d.put(6, "AAC Scalable");
        f7647d.put(7, "TwinVQ");
        f7647d.put(8, "CELP (Code Excited Linear Prediction)");
        f7647d.put(9, "HXVC (Harmonic Vector eXcitation Coding)");
        f7647d.put(10, "Reserved");
        f7647d.put(11, "Reserved");
        f7647d.put(12, "TTSI (Text-To-Speech Interface)");
        f7647d.put(13, "Main Synthesis");
        f7647d.put(14, "Wavetable Synthesis");
        f7647d.put(15, "General MIDI");
        f7647d.put(16, "Algorithmic Synthesis and Audio Effects");
        f7647d.put(17, "ER (Error Resilient) AAC LC");
        f7647d.put(18, "Reserved");
        f7647d.put(19, "ER AAC LTP");
        f7647d.put(20, "ER AAC Scalable");
        f7647d.put(21, "ER TwinVQ");
        f7647d.put(22, "ER BSAC (Bit-Sliced Arithmetic Coding)");
        f7647d.put(23, "ER AAC LD (Low Delay)");
        f7647d.put(24, "ER CELP");
        f7647d.put(25, "ER HVXC");
        f7647d.put(26, "ER HILN (Harmonic and Individual Lines plus Noise)");
        f7647d.put(27, "ER Parametric");
        f7647d.put(28, "SSC (SinuSoidal Coding)");
        f7647d.put(29, "PS (Parametric Stereo)");
        f7647d.put(30, "MPEG Surround");
        f7647d.put(31, "(Escape value)");
        f7647d.put(32, "Layer-1");
        f7647d.put(33, "Layer-2");
        f7647d.put(34, "Layer-3");
        f7647d.put(35, "DST (Direct Stream Transfer)");
        f7647d.put(36, "ALS (Audio Lossless)");
        f7647d.put(37, "SLS (Scalable LosslesS)");
        f7647d.put(38, "SLS non-core");
        f7647d.put(39, "ER AAC ELD (Enhanced Low Delay)");
        f7647d.put(40, "SMR (Symbolic Music Representation) Simple");
        f7647d.put(41, "SMR Main");
        f7647d.put(42, "USAC (Unified Speech and Audio Coding) (no SBR)");
        f7647d.put(43, "SAOC (Spatial Audio Object Coding)");
        f7647d.put(44, "LD MPEG Surround");
        f7647d.put(45, "USAC");
        HashMap hashMap2 = new HashMap();
        f7648e = hashMap2;
        hashMap2.put(96000, 0);
        f7648e.put(88200, 1);
        f7648e.put(64000, 2);
        f7648e.put(48000, 3);
        f7648e.put(44100, 4);
        f7648e.put(32000, 5);
        f7648e.put(24000, 6);
        f7648e.put(22050, 7);
        f7648e.put(16000, 8);
        f7648e.put(12000, 9);
        f7648e.put(11025, 10);
        f7648e.put(8000, 11);
        f7648e.put(0, 96000);
        f7648e.put(1, 88200);
        f7648e.put(2, 64000);
        f7648e.put(3, 48000);
        f7648e.put(4, 44100);
        f7648e.put(5, 32000);
        f7648e.put(6, 24000);
        f7648e.put(7, 22050);
        f7648e.put(8, 16000);
        f7648e.put(9, 12000);
        f7648e.put(10, 11025);
        f7648e.put(11, 8000);
    }

    public void close() {
        this.f7656m.close();
    }

    public C1048yd(C1007ws wsVar) {
        this(wsVar, "eng");
    }

    public C1048yd(C1007ws wsVar, String str) {
        super(wsVar.toString());
        this.f7649f = new C1027xk();
        this.f7658o = "eng";
        this.f7658o = str;
        this.f7656m = wsVar;
        this.f7657n = new ArrayList();
        C1049a b = m14684b(wsVar);
        this.f7652i = b;
        double d = ((double) b.f7664f) / 1024.0d;
        double size = ((double) this.f7657n.size()) / d;
        LinkedList linkedList = new LinkedList();
        Iterator<C1024xh> it = this.f7657n.iterator();
        long j = 0;
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            int a = (int) it.next().mo7a();
            j += (long) a;
            linkedList.add(Integer.valueOf(a));
            while (((double) linkedList.size()) > d) {
                linkedList.pop();
            }
            if (linkedList.size() == ((int) d)) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    i += ((Integer) it2.next()).intValue();
                }
                double size2 = ((((double) i) * 8.0d) / ((double) linkedList.size())) * d;
                if (size2 > ((double) this.f7654k)) {
                    this.f7654k = (long) ((int) size2);
                }
            }
        }
        this.f7655l = (long) ((int) (((double) (j * 8)) / size));
        this.f7653j = 1536;
        this.f7650g = new C0737pi();
        C0793rd rdVar = new C0793rd(C0793rd.f6034d);
        if (this.f7652i.f7665g == 7) {
            rdVar.mo5577b(8);
        } else {
            rdVar.mo5577b(this.f7652i.f7665g);
        }
        rdVar.mo5573a((long) this.f7652i.f7664f);
        rdVar.mo204a(1);
        rdVar.mo5579c(16);
        ade ade = new ade();
        adn adn = new adn();
        adn.mo348b(0);
        adu adu = new adu();
        adu.mo373a(2);
        adn.mo346a(adu);
        adk adk = new adk();
        adk.mo322a(64);
        adk.mo326b(5);
        adk.mo331d(this.f7653j);
        adk.mo323a(this.f7654k);
        adk.mo327b(this.f7655l);
        adg adg = new adg();
        adg.mo296b(2);
        adg.mo297c(this.f7652i.f7659a);
        adg.mo302e(this.f7652i.f7665g);
        adk.mo324a(adg);
        adn.mo345a(adk);
        ade.mo288a(adn);
        rdVar.mo170a((C0688nt) ade);
        this.f7650g.mo170a((C0688nt) rdVar);
        this.f7649f.mo6182b(new Date());
        this.f7649f.mo6177a(new Date());
        this.f7649f.mo6176a(str);
        this.f7649f.mo6172a(1.0f);
        this.f7649f.mo6174a((long) this.f7652i.f7664f);
        long[] jArr = new long[this.f7657n.size()];
        this.f7651h = jArr;
        Arrays.fill(jArr, 1024);
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7650g;
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7651h;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7649f;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7657n;
    }

    /* renamed from: atakplugin.UASTool.yd$a */
    class C1049a {

        /* renamed from: a */
        int f7659a;

        /* renamed from: b */
        int f7660b;

        /* renamed from: c */
        int f7661c;

        /* renamed from: d */
        int f7662d;

        /* renamed from: e */
        int f7663e;

        /* renamed from: f */
        int f7664f;

        /* renamed from: g */
        int f7665g;

        /* renamed from: h */
        int f7666h;

        /* renamed from: i */
        int f7667i;

        /* renamed from: j */
        int f7668j;

        /* renamed from: k */
        int f7669k;

        /* renamed from: l */
        int f7670l;

        /* renamed from: m */
        int f7671m;

        /* renamed from: n */
        int f7672n;

        C1049a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo6270a() {
            return (this.f7662d == 0 ? 2 : 0) + 7;
        }
    }

    /* renamed from: a */
    private C1049a m14683a(C1007ws wsVar) {
        C1049a aVar = new C1049a();
        ByteBuffer allocate = ByteBuffer.allocate(7);
        while (allocate.position() < 7) {
            if (wsVar.mo5650a(allocate) == -1) {
                return null;
            }
        }
        adi adi = new adi((ByteBuffer) allocate.rewind());
        if (adi.mo315a(12) == 4095) {
            aVar.f7660b = adi.mo315a(1);
            aVar.f7661c = adi.mo315a(2);
            aVar.f7662d = adi.mo315a(1);
            aVar.f7663e = adi.mo315a(2) + 1;
            aVar.f7659a = adi.mo315a(4);
            aVar.f7664f = f7648e.get(Integer.valueOf(aVar.f7659a)).intValue();
            adi.mo315a(1);
            aVar.f7665g = adi.mo315a(3);
            aVar.f7666h = adi.mo315a(1);
            aVar.f7667i = adi.mo315a(1);
            aVar.f7668j = adi.mo315a(1);
            aVar.f7669k = adi.mo315a(1);
            aVar.f7670l = adi.mo315a(13);
            aVar.f7671m = adi.mo315a(11);
            aVar.f7672n = adi.mo315a(2) + 1;
            if (aVar.f7672n == 1) {
                if (aVar.f7662d == 0) {
                    wsVar.mo5650a(ByteBuffer.allocate(2));
                }
                return aVar;
            }
            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
        }
        throw new IOException("Expected Start Word 0xfff");
    }

    /* renamed from: b */
    private C1049a m14684b(C1007ws wsVar) {
        C1049a aVar = null;
        while (true) {
            C1049a a = m14683a(wsVar);
            if (a == null) {
                return aVar;
            }
            if (aVar == null) {
                aVar = a;
            }
            this.f7657n.add(new C1050ye(this, wsVar.mo5655b(), (long) (a.f7670l - a.mo6270a())));
            wsVar.mo5654a((wsVar.mo5655b() + ((long) a.f7670l)) - ((long) a.mo6270a()));
        }
    }

    public String toString() {
        return "AACTrackImpl{sampleRate=" + this.f7652i.f7664f + ", channelconfig=" + this.f7652i.f7665g + '}';
    }
}
