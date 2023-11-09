package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import com.autel.internal.video.core.decoder2.common.VideoDefaultParams;
import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: atakplugin.UASTool.yu */
public class C1068yu extends C1018xc {

    /* renamed from: P */
    private static final int f7742P = 67108864;

    /* renamed from: A */
    int f7743A = 0;

    /* renamed from: B */
    int f7744B = 0;

    /* renamed from: C */
    int f7745C = 0;

    /* renamed from: D */
    int f7746D = 0;

    /* renamed from: E */
    int f7747E = 0;

    /* renamed from: F */
    int f7748F = 0;

    /* renamed from: G */
    int f7749G = 0;

    /* renamed from: H */
    int f7750H = 0;

    /* renamed from: I */
    int f7751I = 0;

    /* renamed from: J */
    String f7752J = "none";

    /* renamed from: K */
    private long[] f7753K;

    /* renamed from: L */
    private int f7754L = 0;

    /* renamed from: M */
    private C1007ws f7755M;

    /* renamed from: N */
    private List<C1024xh> f7756N;

    /* renamed from: O */
    private String f7757O = "eng";

    /* renamed from: d */
    C1027xk f7758d = new C1027xk();

    /* renamed from: e */
    C0737pi f7759e;

    /* renamed from: f */
    int f7760f;

    /* renamed from: g */
    int f7761g;

    /* renamed from: h */
    int f7762h = 0;

    /* renamed from: i */
    int f7763i;

    /* renamed from: j */
    int f7764j;

    /* renamed from: k */
    int f7765k;

    /* renamed from: l */
    aap f7766l = new aap();

    /* renamed from: m */
    boolean f7767m = false;

    /* renamed from: n */
    boolean f7768n = false;

    /* renamed from: o */
    boolean f7769o = false;

    /* renamed from: p */
    int f7770p = 0;

    /* renamed from: q */
    int f7771q = 0;

    /* renamed from: r */
    int f7772r = 0;

    /* renamed from: s */
    int f7773s = 0;

    /* renamed from: t */
    int f7774t = 0;

    /* renamed from: u */
    int f7775u = 0;

    /* renamed from: v */
    int f7776v = 0;

    /* renamed from: w */
    int f7777w = 0;

    /* renamed from: x */
    int f7778x = 0;

    /* renamed from: y */
    int f7779y = 0;

    /* renamed from: z */
    int f7780z = 0;

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

    /* renamed from: p */
    public String mo15p() {
        return "soun";
    }

    public C1068yu(C1007ws wsVar, String str) {
        super(wsVar.toString());
        this.f7757O = str;
        this.f7755M = wsVar;
        m14820i();
    }

    public C1068yu(C1007ws wsVar) {
        super(wsVar.toString());
        this.f7755M = wsVar;
        m14820i();
    }

    public void close() {
        this.f7755M.close();
    }

    /* renamed from: i */
    private void m14820i() {
        if (m14821j()) {
            this.f7759e = new C0737pi();
            C0793rd rdVar = new C0793rd(this.f7752J);
            rdVar.mo5577b(this.f7765k);
            rdVar.mo5573a((long) this.f7760f);
            rdVar.mo204a(1);
            rdVar.mo5579c(16);
            rdVar.mo170a((C0688nt) this.f7766l);
            this.f7759e.mo170a((C0688nt) rdVar);
            this.f7758d.mo6182b(new Date());
            this.f7758d.mo6177a(new Date());
            this.f7758d.mo6176a(this.f7757O);
            this.f7758d.mo6174a((long) this.f7760f);
            return;
        }
        throw new IOException();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7756N;
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7759e;
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7753K;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7758d;
    }

    /* renamed from: a */
    private void m14815a(int i, ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        byteBuffer.get();
        byteBuffer.getInt();
        byteBuffer.get();
        short s = byteBuffer.getShort();
        byteBuffer.get();
        byte b = byteBuffer.get();
        this.f7770p = b;
        if ((s & 1) == 1) {
            this.f7767m = true;
        }
        if ((s & 8) == 8) {
            this.f7768n = true;
        }
        if ((s & 16) == 16) {
            this.f7769o = true;
            this.f7770p = b + 1;
        } else {
            this.f7770p = 0;
        }
        for (int i2 = 14; i2 < i; i2++) {
            byteBuffer.get();
        }
    }

    /* renamed from: b */
    private boolean m14817b(int i, ByteBuffer byteBuffer) {
        this.f7771q = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
        this.f7772r = byteBuffer.getShort();
        this.f7773s = byteBuffer.getShort();
        this.f7774t = byteBuffer.getInt();
        for (int i2 = 11; i2 < i; i2++) {
            byteBuffer.get();
        }
        return true;
    }

    /* renamed from: c */
    private boolean m14818c(int i, ByteBuffer byteBuffer) {
        int i2;
        byteBuffer.get();
        short s = byteBuffer.getShort();
        this.f7779y = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
        this.f7743A = byteBuffer.getInt();
        this.f7744B = byteBuffer.getShort();
        this.f7745C = (byteBuffer.get() << 32) | (byteBuffer.getInt() & 65535);
        this.f7746D = byteBuffer.getShort();
        this.f7747E = byteBuffer.getShort();
        if ((s & 3) == 3) {
            this.f7748F = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
            this.f7749G = byteBuffer.getShort();
            this.f7750H = byteBuffer.getShort();
            i2 = 28;
        } else {
            i2 = 21;
        }
        if ((s & 4) > 0) {
            this.f7751I = byteBuffer.get();
            i2++;
        }
        if ((s & 8) > 0) {
            this.f7780z = 1;
        }
        while (i2 < i) {
            byteBuffer.get();
            i2++;
        }
        return true;
    }

    /* renamed from: d */
    private boolean m14819d(int i, ByteBuffer byteBuffer) {
        int i2;
        this.f7775u = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
        if (this.f7767m) {
            this.f7776v = (byteBuffer.get() << 16) | (byteBuffer.getShort() & 65535);
            this.f7777w = byteBuffer.getShort();
            i2 = 8;
        } else {
            this.f7778x = byteBuffer.getInt();
            i2 = 7;
        }
        while (i2 < i) {
            byteBuffer.get();
            i2++;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b3, code lost:
        if (r11 == true) goto L_0x008d;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m14821j() {
        /*
            r26 = this;
            r6 = r26
            atakplugin.UASTool.ws r0 = r6.f7755M
            r1 = 0
            r3 = 25000(0x61a8, double:1.23516E-319)
            java.nio.ByteBuffer r0 = r0.mo5653a(r1, r3)
            int r1 = r0.getInt()
            int r2 = r0.getInt()
            r3 = 1146377032(0x44545348, float:849.3013)
            if (r1 != r3) goto L_0x0513
            r4 = 1145586770(0x44484452, float:801.0675)
            if (r2 != r4) goto L_0x0513
        L_0x001e:
            r5 = 1398035021(0x5354524d, float:9.1191384E11)
            r7 = 0
            if (r1 != r5) goto L_0x0029
            r5 = 1145132097(0x44415441, float:773.31647)
            if (r2 == r5) goto L_0x0031
        L_0x0029:
            int r5 = r0.remaining()
            r8 = 100
            if (r5 > r8) goto L_0x04bf
        L_0x0031:
            long r3 = r0.getLong()
            int r1 = r0.position()
            r6.f7754L = r1
            r1 = -1
            r2 = 0
            r5 = -1
            r9 = -1
            r10 = -1
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x004d:
            r8 = 2
            if (r2 == 0) goto L_0x02c5
            int r0 = r6.f7764j
            r2 = 512(0x200, float:7.175E-43)
            r12 = 4096(0x1000, float:5.74E-42)
            if (r0 == r2) goto L_0x006a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 == r2) goto L_0x0068
            r2 = 2048(0x800, float:2.87E-42)
            if (r0 == r2) goto L_0x0066
            if (r0 == r12) goto L_0x0064
            r0 = -1
            goto L_0x006b
        L_0x0064:
            r0 = 3
            goto L_0x006b
        L_0x0066:
            r0 = 2
            goto L_0x006b
        L_0x0068:
            r0 = 1
            goto L_0x006b
        L_0x006a:
            r0 = 0
        L_0x006b:
            if (r0 != r1) goto L_0x006e
            return r7
        L_0x006e:
            if (r9 == 0) goto L_0x0077
            if (r9 == r8) goto L_0x0077
            switch(r9) {
                case 4: goto L_0x0077;
                case 5: goto L_0x0077;
                case 6: goto L_0x0077;
                case 7: goto L_0x0077;
                case 8: goto L_0x0077;
                case 9: goto L_0x0077;
                default: goto L_0x0075;
            }
        L_0x0075:
            r9 = 31
        L_0x0077:
            java.lang.String r1 = "dtsh"
            if (r5 != 0) goto L_0x00c4
            r2 = 21
            r10 = 1
            if (r11 != r10) goto L_0x0090
            if (r15 != 0) goto L_0x008b
            r1 = 17
            java.lang.String r2 = "dtsl"
            r6.f7752J = r2
            r20 = 17
            goto L_0x00b8
        L_0x008b:
            r6.f7752J = r1
        L_0x008d:
            r20 = 21
            goto L_0x00b8
        L_0x0090:
            if (r14 != r10) goto L_0x009b
            r1 = 18
            java.lang.String r2 = "dtse"
            r6.f7752J = r2
            r20 = 18
            goto L_0x00b8
        L_0x009b:
            if (r15 != r10) goto L_0x00b6
            r6.f7752J = r1
            r1 = r16
            if (r1 != 0) goto L_0x00aa
            if (r11 != 0) goto L_0x00aa
            r1 = 19
            r20 = 19
            goto L_0x00b8
        L_0x00aa:
            if (r1 != r10) goto L_0x00b1
            if (r11 != 0) goto L_0x00b1
            r20 = 20
            goto L_0x00b8
        L_0x00b1:
            if (r1 != 0) goto L_0x00b6
            if (r11 != r10) goto L_0x00b6
            goto L_0x008d
        L_0x00b6:
            r20 = 0
        L_0x00b8:
            int r1 = r6.f7779y
            r6.f7760f = r1
            r1 = 24
            r6.f7763i = r1
            r1 = r20
            goto L_0x01d2
        L_0x00c4:
            r2 = r16
            r7 = 1
            if (r10 >= r7) goto L_0x00ef
            java.lang.String r2 = "dtsc"
            if (r13 <= 0) goto L_0x00ea
            r7 = r17
            if (r7 == 0) goto L_0x00e5
            if (r7 == r8) goto L_0x00e0
            r10 = 6
            if (r7 == r10) goto L_0x00db
            r6.f7752J = r1
        L_0x00d8:
            r1 = 0
            goto L_0x01d2
        L_0x00db:
            r6.f7752J = r1
            r1 = 3
            goto L_0x01d2
        L_0x00e0:
            r6.f7752J = r2
            r1 = 4
            goto L_0x01d2
        L_0x00e5:
            r6.f7752J = r2
            r1 = 2
            goto L_0x01d2
        L_0x00ea:
            r6.f7752J = r2
            r1 = 1
            goto L_0x01d2
        L_0x00ef:
            r7 = r17
            r6.f7752J = r1
            if (r13 != 0) goto L_0x0161
            if (r15 != 0) goto L_0x0109
            r1 = 1
            if (r2 != r1) goto L_0x0109
            r1 = r18
            r10 = r19
            if (r1 != 0) goto L_0x010d
            if (r10 != 0) goto L_0x010d
            if (r11 != 0) goto L_0x010d
            if (r14 != 0) goto L_0x010d
            r1 = 5
            goto L_0x01d2
        L_0x0109:
            r1 = r18
            r10 = r19
        L_0x010d:
            if (r15 != 0) goto L_0x011d
            if (r2 != 0) goto L_0x011d
            if (r1 != 0) goto L_0x011d
            r7 = 1
            if (r10 != r7) goto L_0x011e
            if (r11 != 0) goto L_0x011e
            if (r14 != 0) goto L_0x011e
            r1 = 6
            goto L_0x01d2
        L_0x011d:
            r7 = 1
        L_0x011e:
            if (r15 != 0) goto L_0x012e
            if (r2 != r7) goto L_0x012e
            if (r1 != 0) goto L_0x012e
            if (r10 != r7) goto L_0x012e
            if (r11 != 0) goto L_0x012e
            if (r14 != 0) goto L_0x012e
            r1 = 9
            goto L_0x01d2
        L_0x012e:
            if (r15 != 0) goto L_0x013f
            if (r2 != 0) goto L_0x013f
            r7 = 1
            if (r1 != r7) goto L_0x013f
            if (r10 != 0) goto L_0x013f
            if (r11 != 0) goto L_0x013f
            if (r14 != 0) goto L_0x013f
            r1 = 10
            goto L_0x01d2
        L_0x013f:
            if (r15 != 0) goto L_0x0150
            r7 = 1
            if (r2 != r7) goto L_0x0150
            if (r1 != r7) goto L_0x0150
            if (r10 != 0) goto L_0x0150
            if (r11 != 0) goto L_0x0150
            if (r14 != 0) goto L_0x0150
            r1 = 13
            goto L_0x01d2
        L_0x0150:
            if (r15 != 0) goto L_0x00d8
            if (r2 != 0) goto L_0x00d8
            if (r1 != 0) goto L_0x00d8
            if (r10 != 0) goto L_0x00d8
            r1 = 1
            if (r11 != r1) goto L_0x00d8
            if (r14 != 0) goto L_0x00d8
            r1 = 14
            goto L_0x01d2
        L_0x0161:
            r1 = r18
            r10 = r19
            if (r7 != 0) goto L_0x0177
            if (r15 != 0) goto L_0x0177
            if (r2 != 0) goto L_0x0177
            if (r1 != 0) goto L_0x0177
            r13 = 1
            if (r10 != r13) goto L_0x0177
            if (r11 != 0) goto L_0x0177
            if (r14 != 0) goto L_0x0177
            r1 = 7
            goto L_0x01d2
        L_0x0177:
            r13 = 6
            if (r7 != r13) goto L_0x018a
            if (r15 != 0) goto L_0x018a
            if (r2 != 0) goto L_0x018a
            if (r1 != 0) goto L_0x018a
            r13 = 1
            if (r10 != r13) goto L_0x018a
            if (r11 != 0) goto L_0x018a
            if (r14 != 0) goto L_0x018a
            r1 = 8
            goto L_0x01d2
        L_0x018a:
            if (r7 != 0) goto L_0x019c
            if (r15 != 0) goto L_0x019c
            if (r2 != 0) goto L_0x019c
            r13 = 1
            if (r1 != r13) goto L_0x019c
            if (r10 != 0) goto L_0x019c
            if (r11 != 0) goto L_0x019c
            if (r14 != 0) goto L_0x019c
            r1 = 11
            goto L_0x01d2
        L_0x019c:
            r13 = 6
            if (r7 != r13) goto L_0x01af
            if (r15 != 0) goto L_0x01af
            if (r2 != 0) goto L_0x01af
            r13 = 1
            if (r1 != r13) goto L_0x01af
            if (r10 != 0) goto L_0x01af
            if (r11 != 0) goto L_0x01af
            if (r14 != 0) goto L_0x01af
            r1 = 12
            goto L_0x01d2
        L_0x01af:
            if (r7 != 0) goto L_0x01c1
            if (r15 != 0) goto L_0x01c1
            if (r2 != 0) goto L_0x01c1
            if (r1 != 0) goto L_0x01c1
            if (r10 != 0) goto L_0x01c1
            r13 = 1
            if (r11 != r13) goto L_0x01c1
            if (r14 != 0) goto L_0x01c1
            r1 = 15
            goto L_0x01d2
        L_0x01c1:
            if (r7 != r8) goto L_0x00d8
            if (r15 != 0) goto L_0x00d8
            if (r2 != 0) goto L_0x00d8
            if (r1 != 0) goto L_0x00d8
            if (r10 != 0) goto L_0x00d8
            r1 = 1
            if (r11 != r1) goto L_0x00d8
            if (r14 != 0) goto L_0x00d8
            r1 = 16
        L_0x01d2:
            atakplugin.UASTool.aap r2 = r6.f7766l
            int r7 = r6.f7779y
            long r10 = (long) r7
            r2.mo66b((long) r10)
            boolean r2 = r6.f7767m
            if (r2 == 0) goto L_0x01ec
            atakplugin.UASTool.aap r2 = r6.f7766l
            int r7 = r6.f7772r
            int r10 = r6.f7776v
            int r7 = r7 + r10
            int r7 = r7 * 1000
            long r10 = (long) r7
            r2.mo68c((long) r10)
            goto L_0x01f9
        L_0x01ec:
            atakplugin.UASTool.aap r2 = r6.f7766l
            int r7 = r6.f7772r
            int r10 = r6.f7775u
            int r7 = r7 + r10
            int r7 = r7 * 1000
            long r10 = (long) r7
            r2.mo68c((long) r10)
        L_0x01f9:
            atakplugin.UASTool.aap r2 = r6.f7766l
            int r7 = r6.f7772r
            int r10 = r6.f7775u
            int r7 = r7 + r10
            int r7 = r7 * 1000
            long r10 = (long) r7
            r2.mo63a((long) r10)
            atakplugin.UASTool.aap r2 = r6.f7766l
            int r7 = r6.f7763i
            r2.mo62a((int) r7)
            atakplugin.UASTool.aap r2 = r6.f7766l
            r2.mo65b((int) r0)
            atakplugin.UASTool.aap r0 = r6.f7766l
            r0.mo67c((int) r1)
            int r0 = r6.f7773s
            r1 = r0 & 8
            if (r1 > 0) goto L_0x0228
            r0 = r0 & r12
            if (r0 <= 0) goto L_0x0221
            goto L_0x0228
        L_0x0221:
            atakplugin.UASTool.aap r0 = r6.f7766l
            r1 = 0
            r0.mo69d(r1)
            goto L_0x022e
        L_0x0228:
            atakplugin.UASTool.aap r0 = r6.f7766l
            r1 = 1
            r0.mo69d(r1)
        L_0x022e:
            atakplugin.UASTool.aap r0 = r6.f7766l
            r0.mo70e(r9)
            atakplugin.UASTool.aap r0 = r6.f7766l
            int r1 = r6.f7774t
            r0.mo71f(r1)
            atakplugin.UASTool.aap r0 = r6.f7766l
            r1 = 0
            r0.mo72g(r1)
            atakplugin.UASTool.aap r0 = r6.f7766l
            r1 = 4
            r0.mo73h(r1)
            atakplugin.UASTool.aap r0 = r6.f7766l
            int r1 = r6.f7746D
            r0.mo74i(r1)
            int r0 = r6.f7771q
            if (r0 <= 0) goto L_0x025d
            int r0 = r6.f7775u
            if (r0 <= 0) goto L_0x025d
            atakplugin.UASTool.aap r0 = r6.f7766l
            r1 = 1
            r0.mo76j(r1)
            r1 = 0
            goto L_0x0263
        L_0x025d:
            atakplugin.UASTool.aap r0 = r6.f7766l
            r1 = 0
            r0.mo76j(r1)
        L_0x0263:
            atakplugin.UASTool.aap r0 = r6.f7766l
            int r2 = r6.f7780z
            r0.mo78k(r2)
            atakplugin.UASTool.aap r0 = r6.f7766l
            r0.mo82m(r1)
            r6.f7765k = r1
            r0 = 16
            r7 = 0
        L_0x0274:
            if (r7 < r0) goto L_0x0292
            atakplugin.UASTool.ws r1 = r6.f7755M
            int r2 = r6.f7754L
            r0 = r26
            java.util.List r0 = r0.m14814a(r1, r2, r3, r5)
            r6.f7756N = r0
            int r0 = r0.size()
            long[] r0 = new long[r0]
            r6.f7753K = r0
            int r1 = r6.f7764j
            long r1 = (long) r1
            java.util.Arrays.fill(r0, r1)
            r0 = 1
            return r0
        L_0x0292:
            r0 = 1
            int r1 = r6.f7746D
            int r1 = r1 >> r7
            r1 = r1 & r0
            if (r1 != r0) goto L_0x02bd
            r0 = 12
            if (r7 == 0) goto L_0x02b6
            if (r7 == r0) goto L_0x02b6
            r1 = 14
            if (r7 == r1) goto L_0x02b6
            r1 = 3
            if (r7 == r1) goto L_0x02b6
            r1 = 4
            if (r7 == r1) goto L_0x02b6
            r1 = 7
            if (r7 == r1) goto L_0x02b6
            r1 = 8
            if (r7 == r1) goto L_0x02b6
            int r1 = r6.f7765k
            int r1 = r1 + r8
            r6.f7765k = r1
            goto L_0x02bf
        L_0x02b6:
            int r1 = r6.f7765k
            r2 = 1
            int r1 = r1 + r2
            r6.f7765k = r1
            goto L_0x02c0
        L_0x02bd:
            r0 = 12
        L_0x02bf:
            r2 = 1
        L_0x02c0:
            int r7 = r7 + 1
            r0 = 16
            goto L_0x0274
        L_0x02c5:
            r22 = r16
            r7 = r17
            r23 = r18
            r24 = r19
            r1 = 1
            r17 = 12
            int r19 = r0.position()
            int r8 = r0.getInt()
            r25 = r2
            r2 = 2147385345(0x7ffe8001, float:NaN)
            if (r8 != r2) goto L_0x03cc
            if (r5 != r1) goto L_0x02ee
            r17 = r7
            r16 = r22
            r18 = r23
            r19 = r24
            r1 = -1
            r2 = 1
        L_0x02eb:
            r7 = 0
            goto L_0x004d
        L_0x02ee:
            atakplugin.UASTool.adi r2 = new atakplugin.UASTool.adi
            r2.<init>(r0)
            int r5 = r2.mo315a(r1)
            r7 = 5
            int r8 = r2.mo315a(r7)
            int r7 = r2.mo315a(r1)
            if (r5 != r1) goto L_0x03ca
            r5 = 31
            if (r8 != r5) goto L_0x03ca
            if (r7 == 0) goto L_0x030a
            goto L_0x03ca
        L_0x030a:
            r5 = 7
            int r8 = r2.mo315a(r5)
            int r8 = r8 + r1
            int r8 = r8 * 32
            r6.f7764j = r8
            r1 = 14
            int r1 = r2.mo315a(r1)
            int r5 = r6.f7762h
            int r8 = r1 + 1
            int r5 = r5 + r8
            r6.f7762h = r5
            r5 = 6
            int r9 = r2.mo315a(r5)
            r5 = 4
            int r8 = r2.mo315a(r5)
            int r5 = r6.m14816b(r8)
            r6.f7760f = r5
            r5 = 5
            int r8 = r2.mo315a(r5)
            int r5 = r6.m14813a(r8)
            r6.f7761g = r5
            r5 = 1
            int r8 = r2.mo315a(r5)
            if (r8 == 0) goto L_0x0345
            r8 = 0
            return r8
        L_0x0345:
            r2.mo315a(r5)
            r2.mo315a(r5)
            r2.mo315a(r5)
            r2.mo315a(r5)
            r8 = 3
            int r17 = r2.mo315a(r8)
            int r13 = r2.mo315a(r5)
            r2.mo315a(r5)
            r8 = 2
            r2.mo315a(r8)
            r2.mo315a(r5)
            if (r7 != r5) goto L_0x036b
            r7 = 16
            r2.mo315a(r7)
        L_0x036b:
            r2.mo315a(r5)
            r7 = 4
            int r5 = r2.mo315a(r7)
            r2.mo315a(r8)
            r7 = 3
            int r8 = r2.mo315a(r7)
            if (r8 == 0) goto L_0x0398
            r7 = 1
            if (r8 == r7) goto L_0x0398
            r7 = 2
            if (r8 == r7) goto L_0x0393
            r7 = 3
            if (r8 == r7) goto L_0x0393
            r7 = 5
            if (r8 == r7) goto L_0x038e
            r7 = 6
            if (r8 == r7) goto L_0x038e
            r7 = 0
            return r7
        L_0x038e:
            r7 = 24
            r6.f7763i = r7
            goto L_0x039c
        L_0x0393:
            r7 = 20
            r6.f7763i = r7
            goto L_0x039c
        L_0x0398:
            r7 = 16
            r6.f7763i = r7
        L_0x039c:
            r7 = 1
            r2.mo315a(r7)
            r2.mo315a(r7)
            r8 = 6
            if (r5 == r8) goto L_0x03b3
            r8 = 7
            if (r5 == r8) goto L_0x03ae
            r5 = 4
            r2.mo315a(r5)
            goto L_0x03b7
        L_0x03ae:
            r5 = 4
            r2.mo315a(r5)
            goto L_0x03b7
        L_0x03b3:
            r5 = 4
            r2.mo315a(r5)
        L_0x03b7:
            int r19 = r19 + r1
            int r1 = r19 + 1
            r0.position(r1)
            r16 = r22
            r18 = r23
            r19 = r24
            r2 = r25
            r1 = -1
            r5 = 1
            goto L_0x02eb
        L_0x03ca:
            r0 = 0
            return r0
        L_0x03cc:
            r1 = 20
            r2 = 16
            r10 = 1683496997(0x64582025, float:1.5947252E22)
            if (r8 != r10) goto L_0x04a7
            r8 = -1
            if (r5 != r8) goto L_0x03dd
            int r5 = r6.f7744B
            r6.f7764j = r5
            r5 = 0
        L_0x03dd:
            atakplugin.UASTool.adi r10 = new atakplugin.UASTool.adi
            r10.<init>(r0)
            r1 = 8
            r10.mo315a(r1)
            r1 = 2
            r10.mo315a(r1)
            r1 = 1
            int r18 = r10.mo315a(r1)
            if (r18 != 0) goto L_0x03f7
            r2 = 8
            r8 = 16
            goto L_0x03fb
        L_0x03f7:
            r2 = 12
            r8 = 20
        L_0x03fb:
            int r2 = r10.mo315a(r2)
            int r2 = r2 + r1
            int r8 = r10.mo315a(r8)
            int r8 = r8 + r1
            int r2 = r19 + r2
            r0.position(r2)
            int r2 = r0.getInt()
            r10 = 1515870810(0x5a5a5a5a, float:1.53652219E16)
            if (r2 != r10) goto L_0x0422
            if (r12 != r1) goto L_0x0417
            r2 = 1
            goto L_0x0419
        L_0x0417:
            r2 = r25
        L_0x0419:
            r20 = r3
            r10 = r22
            r4 = r24
            r12 = 1
            goto L_0x048c
        L_0x0422:
            r10 = 1191201283(0x47004a03, float:32842.01)
            if (r2 != r10) goto L_0x0436
            r10 = r22
            if (r10 != r1) goto L_0x042d
            r2 = 1
            goto L_0x042f
        L_0x042d:
            r2 = r25
        L_0x042f:
            r20 = r3
            r4 = r24
            r10 = 1
            goto L_0x048c
        L_0x0436:
            r20 = r3
            r10 = r22
            r3 = 496366178(0x1d95f262, float:3.969059E-21)
            if (r2 != r3) goto L_0x044c
            r3 = r23
            if (r3 != r1) goto L_0x0445
            r2 = 1
            goto L_0x0447
        L_0x0445:
            r2 = r25
        L_0x0447:
            r4 = r24
            r23 = 1
            goto L_0x048c
        L_0x044c:
            r3 = r23
            r4 = 1700671838(0x655e315e, float:6.557975E22)
            if (r2 != r4) goto L_0x045f
            r4 = r24
            if (r4 != r1) goto L_0x0459
            r2 = 1
            goto L_0x045b
        L_0x0459:
            r2 = r25
        L_0x045b:
            r23 = r3
            r4 = 1
            goto L_0x048c
        L_0x045f:
            r23 = r3
            r4 = r24
            r3 = 176167201(0xa801921, float:1.2335404E-32)
            if (r2 != r3) goto L_0x0470
            if (r14 != r1) goto L_0x046c
            r2 = 1
            goto L_0x046e
        L_0x046c:
            r2 = r25
        L_0x046e:
            r14 = 1
            goto L_0x048c
        L_0x0470:
            r3 = 1101174087(0x41a29547, float:20.32289)
            if (r2 != r3) goto L_0x047d
            if (r11 != r1) goto L_0x0479
            r2 = 1
            goto L_0x047b
        L_0x0479:
            r2 = r25
        L_0x047b:
            r11 = 1
            goto L_0x048c
        L_0x047d:
            r3 = 45126241(0x2b09261, float:2.5944893E-37)
            if (r2 != r3) goto L_0x048a
            if (r15 != r1) goto L_0x0486
            r2 = 1
            goto L_0x0488
        L_0x0486:
            r2 = r25
        L_0x0488:
            r15 = 1
            goto L_0x048c
        L_0x048a:
            r2 = r25
        L_0x048c:
            if (r2 != 0) goto L_0x0493
            int r3 = r6.f7762h
            int r3 = r3 + r8
            r6.f7762h = r3
        L_0x0493:
            int r3 = r19 + r8
            r0.position(r3)
            r19 = r4
            r17 = r7
            r16 = r10
            r3 = r20
            r18 = r23
            r1 = -1
            r7 = 0
            r10 = 1
            goto L_0x004d
        L_0x04a7:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "No DTS_SYNCWORD_* found at "
            r2.<init>(r3)
            int r0 = r0.position()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x04bf:
            long r7 = r0.getLong()
            int r5 = (int) r7
            if (r1 != r3) goto L_0x04cc
            if (r2 != r4) goto L_0x04cc
            r6.m14815a(r5, r0)
            goto L_0x0503
        L_0x04cc:
            r7 = 1129271877(0x434f5245, float:207.32137)
            if (r1 != r7) goto L_0x04de
            r7 = 1397968196(0x53534d44, float:9.075344E11)
            if (r2 != r7) goto L_0x04de
            boolean r1 = r6.m14817b(r5, r0)
            if (r1 != 0) goto L_0x0503
            r7 = 0
            return r7
        L_0x04de:
            r7 = 0
            r8 = 1096110162(0x41555052, float:13.332109)
            if (r1 != r8) goto L_0x04f0
            r8 = 759710802(0x2d484452, float:1.1383854E-11)
            if (r2 != r8) goto L_0x04f0
            boolean r1 = r6.m14818c(r5, r0)
            if (r1 != 0) goto L_0x0503
            return r7
        L_0x04f0:
            r8 = 1163416659(0x45585453, float:3461.2703)
            if (r1 != r8) goto L_0x0501
            r1 = 1398754628(0x535f4d44, float:9.5907401E11)
            if (r2 != r1) goto L_0x0501
            boolean r1 = r6.m14819d(r5, r0)
            if (r1 != 0) goto L_0x0503
            return r7
        L_0x0501:
            if (r7 < r5) goto L_0x050d
        L_0x0503:
            int r1 = r0.getInt()
            int r2 = r0.getInt()
            goto L_0x001e
        L_0x050d:
            r0.get()
            int r7 = r7 + 1
            goto L_0x0501
        L_0x0513:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "data does not start with 'DTSHDHDR' as required for a DTS-HD file"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1068yu.m14821j():boolean");
    }

    /* renamed from: a */
    private List<C1024xh> m14814a(C1007ws wsVar, int i, long j, int i2) {
        C1069a aVar = new C1069a(wsVar, (long) i, j, i2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteBuffer a = aVar.mo6298a();
            if (a == null) {
                System.err.println("all samples found");
                return arrayList;
            }
            arrayList.add(new C1070yv(this, a));
        }
    }

    /* renamed from: a */
    private int m14813a(int i) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 56;
            case 2:
                return 64;
            case 3:
                return 96;
            case 4:
                return 112;
            case 5:
                return 128;
            case 6:
                return 192;
            case 7:
                return 224;
            case 8:
                return 256;
            case 9:
                return 320;
            case 10:
                return 384;
            case 11:
                return 448;
            case 12:
                return 512;
            case 13:
                return 576;
            case 14:
                return 640;
            case 15:
                return 768;
            case 16:
                return 960;
            case 17:
                return 1024;
            case 18:
                return 1152;
            case 19:
                return VideoDefaultParams.mFormatWidth;
            case 20:
                return 1344;
            case 21:
                return 1408;
            case 22:
                return 1411;
            case 23:
                return 1472;
            case 24:
                return 1536;
            case 25:
                return -1;
            default:
                throw new IOException("Unknown bitrate value");
        }
    }

    /* renamed from: b */
    private int m14816b(int i) {
        switch (i) {
            case 1:
                return 8000;
            case 2:
                return 16000;
            case 3:
                return 32000;
            case 6:
                return 11025;
            case 7:
                return 22050;
            case 8:
                return 44100;
            case 11:
                return 12000;
            case 12:
                return 24000;
            case 13:
                return 48000;
            default:
                throw new IOException("Unknown Sample Rate");
        }
    }

    /* renamed from: atakplugin.UASTool.yu$a */
    class C1069a {

        /* renamed from: a */
        long f7781a;

        /* renamed from: b */
        int f7782b = 0;

        /* renamed from: c */
        C1007ws f7783c;

        /* renamed from: d */
        long f7784d;

        /* renamed from: e */
        ByteBuffer f7785e;

        /* renamed from: f */
        long f7786f;

        /* renamed from: h */
        private final int f7788h;

        C1069a(C1007ws wsVar, long j, long j2, int i) {
            this.f7783c = wsVar;
            this.f7781a = j;
            this.f7784d = j2 + j;
            this.f7788h = i;
            m14831b();
        }

        /* renamed from: a */
        public ByteBuffer mo6298a() {
            while (true) {
                try {
                    if (this.f7788h == 1) {
                        if (m14834d()) {
                            break;
                        }
                        m14837g();
                    } else if (m14833c()) {
                        break;
                    } else {
                        m14837g();
                    }
                } catch (EOFException unused) {
                    return null;
                }
            }
            m14839i();
            while (true) {
                if (this.f7788h == 1) {
                    if (m14836f()) {
                        break;
                    }
                    m14838h();
                } else if (m14835e()) {
                    break;
                } else {
                    m14838h();
                }
            }
            return m14840j();
        }

        /* renamed from: b */
        private void m14831b() {
            System.err.println("Fill Buffer");
            C1007ws wsVar = this.f7783c;
            long j = this.f7781a;
            this.f7785e = wsVar.mo5653a(j, Math.min(this.f7784d - j, 67108864));
        }

        /* renamed from: c */
        private boolean m14833c() {
            return m14830a((byte) 100, (byte) 88, (byte) 32, (byte) 37);
        }

        /* renamed from: d */
        private boolean m14834d() {
            return m14830a(Byte.MAX_VALUE, (byte) -2, Byte.MIN_VALUE, (byte) 1);
        }

        /* renamed from: a */
        private boolean m14830a(byte b, byte b2, byte b3, byte b4) {
            int limit = this.f7785e.limit();
            int i = this.f7782b;
            if (limit - i >= 4) {
                if (this.f7785e.get(i) == b && this.f7785e.get(this.f7782b + 1) == b2 && this.f7785e.get(this.f7782b + 2) == b3 && this.f7785e.get(this.f7782b + 3) == b4) {
                    return true;
                }
                return false;
            } else if (this.f7781a + ((long) i) + 4 < this.f7783c.mo5651a()) {
                return false;
            } else {
                throw new EOFException();
            }
        }

        /* renamed from: e */
        private boolean m14835e() {
            return m14832b((byte) 100, (byte) 88, (byte) 32, (byte) 37);
        }

        /* renamed from: f */
        private boolean m14836f() {
            return m14832b(Byte.MAX_VALUE, (byte) -2, Byte.MIN_VALUE, (byte) 1);
        }

        /* renamed from: b */
        private boolean m14832b(byte b, byte b2, byte b3, byte b4) {
            int limit = this.f7785e.limit();
            int i = this.f7782b;
            if (limit - i >= 4) {
                if ((this.f7781a + ((long) i)) % 1048576 == 0) {
                    PrintStream printStream = System.err;
                    StringBuilder sb = new StringBuilder();
                    sb.append(((this.f7781a + ((long) this.f7782b)) / 1024) / 1024);
                    printStream.println(sb.toString());
                }
                return this.f7785e.get(this.f7782b) == b && this.f7785e.get(this.f7782b + 1) == b2 && this.f7785e.get(this.f7782b + 2) == b3 && this.f7785e.get(this.f7782b + 3) == b4;
            }
            long j = this.f7781a;
            long j2 = this.f7784d;
            if (((long) i) + j + 4 > j2) {
                return j + ((long) i) == j2;
            }
            this.f7781a = this.f7786f;
            this.f7782b = 0;
            m14831b();
            return m14834d();
        }

        /* renamed from: g */
        private void m14837g() {
            this.f7782b++;
        }

        /* renamed from: h */
        private void m14838h() {
            this.f7782b += 4;
        }

        /* renamed from: i */
        private void m14839i() {
            long j = this.f7781a;
            int i = this.f7782b;
            this.f7786f = j + ((long) i);
            this.f7782b = i + 4;
        }

        /* renamed from: j */
        private ByteBuffer m14840j() {
            long j = this.f7786f;
            long j2 = this.f7781a;
            if (j >= j2) {
                this.f7785e.position((int) (j - j2));
                ByteBuffer slice = this.f7785e.slice();
                slice.limit((int) (((long) this.f7782b) - (this.f7786f - this.f7781a)));
                return slice;
            }
            throw new RuntimeException("damn! NAL exceeds buffer");
        }
    }
}
