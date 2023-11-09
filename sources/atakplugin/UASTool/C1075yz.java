package atakplugin.UASTool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.yz */
public class C1075yz extends C1053yh {

    /* renamed from: u */
    private static Logger f7810u = Logger.getLogger(adn.class.getName());

    /* renamed from: k */
    int f7811k = 0;

    /* renamed from: l */
    int f7812l = 1;

    /* renamed from: m */
    int f7813m;

    /* renamed from: n */
    int f7814n;

    /* renamed from: o */
    C0737pi f7815o;

    /* renamed from: p */
    List<C1024xh> f7816p;

    /* renamed from: q */
    List<ByteBuffer> f7817q;

    /* renamed from: r */
    boolean f7818r;

    /* renamed from: s */
    int f7819s;

    /* renamed from: t */
    int f7820t;

    /* renamed from: p */
    public String mo15p() {
        return "vide";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1075yz(atakplugin.UASTool.C1007ws r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = 0
            r0.<init>(r1, r2)
            r0.f7811k = r2
            r3 = 1
            r0.f7812l = r3
            r4 = 2
            r0.f7813m = r4
            r5 = 3
            r0.f7814n = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r0.f7816p = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r0.f7817q = r5
            r0.f7818r = r2
            r5 = -1
            r0.f7819s = r5
            r0.f7820t = r2
            atakplugin.UASTool.yh$a r5 = new atakplugin.UASTool.yh$a
            r5.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            atakplugin.UASTool.rj r6 = new atakplugin.UASTool.rj
            java.lang.String r7 = "mp4v"
            r6.<init>(r7)
            atakplugin.UASTool.pi r7 = new atakplugin.UASTool.pi
            r7.<init>()
            r0.f7815o = r7
            r7.mo170a((atakplugin.UASTool.C0688nt) r6)
            r9 = 0
            r11 = 0
            r12 = -1
        L_0x0048:
            java.nio.ByteBuffer r14 = r0.mo6273a((atakplugin.UASTool.C1053yh.C1054a) r5)
            r15 = 32
            if (r14 != 0) goto L_0x00bc
            long[] r1 = r0.f7688a_
            long[] r5 = new long[r3]
            long[] r7 = r0.f7688a_
            long[] r8 = r0.f7688a_
            int r8 = r8.length
            int r8 = r8 - r3
            r8 = r7[r8]
            r5[r2] = r8
            long[] r1 = atakplugin.UASTool.afs.m880a((long[]) r1, (long[]) r5)
            r0.f7688a_ = r1
            atakplugin.UASTool.adn r1 = new atakplugin.UASTool.adn
            r1.<init>()
            r1.mo348b(r3)
            atakplugin.UASTool.adk r2 = new atakplugin.UASTool.adk
            r2.<init>()
            r2.mo322a((int) r15)
            r3 = 4
            r2.mo326b((int) r3)
            atakplugin.UASTool.adl r3 = new atakplugin.UASTool.adl
            r3.<init>()
            java.util.List<java.nio.ByteBuffer> r5 = r0.f7817q
            atakplugin.UASTool.xh r5 = r0.mo6272a((java.util.List<? extends java.nio.ByteBuffer>) r5)
            long r7 = r5.mo7a()
            int r7 = atakplugin.UASTool.afi.m847a(r7)
            byte[] r7 = new byte[r7]
            java.nio.ByteBuffer r5 = r5.mo9b()
            r5.get(r7)
            r3.mo339a((byte[]) r7)
            r2.mo325a((atakplugin.UASTool.adl) r3)
            r1.mo345a((atakplugin.UASTool.adk) r2)
            atakplugin.UASTool.adu r2 = new atakplugin.UASTool.adu
            r2.<init>()
            r2.mo373a((int) r4)
            r1.mo346a((atakplugin.UASTool.adu) r2)
            atakplugin.UASTool.ade r2 = new atakplugin.UASTool.ade
            r2.<init>()
            r2.mo288a(r1)
            r6.mo170a((atakplugin.UASTool.C0688nt) r2)
            atakplugin.UASTool.xk r1 = r0.f7692e_
            int r2 = r0.f7820t
            long r2 = (long) r2
            r1.mo6174a((long) r2)
            return
        L_0x00bc:
            java.nio.ByteBuffer r2 = r14.duplicate()
            int r7 = atakplugin.UASTool.C0679nk.m12499f(r14)
            r8 = 176(0xb0, float:2.47E-43)
            r4 = 181(0xb5, float:2.54E-43)
            if (r7 == r8) goto L_0x01ae
            if (r7 == r4) goto L_0x01ae
            if (r7 == 0) goto L_0x01ae
            if (r7 == r15) goto L_0x01ae
            r8 = 178(0xb2, float:2.5E-43)
            if (r7 != r8) goto L_0x00d6
            goto L_0x01ae
        L_0x00d6:
            r4 = 179(0xb3, float:2.51E-43)
            if (r7 != r4) goto L_0x010f
            r0.f7818r = r3
            atakplugin.UASTool.adi r4 = new atakplugin.UASTool.adi
            r4.<init>(r14)
            r7 = 18
            int r4 = r4.mo315a(r7)
            r7 = r4 & 63
            int r8 = r4 >>> 7
            r8 = r8 & 63
            int r8 = r8 * 60
            int r7 = r7 + r8
            int r4 = r4 >>> 13
            r4 = r4 & 31
            int r4 = r4 * 60
            int r4 = r4 * 60
            int r7 = r7 + r4
            long r9 = (long) r7
            java.util.List r4 = r0.f7691d_
            java.util.List<atakplugin.UASTool.xh> r7 = r0.f7816p
            int r7 = r7.size()
            int r7 = r7 + r3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r4.add(r7)
            r1.add(r2)
            goto L_0x01c7
        L_0x010f:
            r4 = 182(0xb6, float:2.55E-43)
            if (r7 != r4) goto L_0x01a6
            atakplugin.UASTool.adi r4 = new atakplugin.UASTool.adi
            r4.<init>(r14)
            r8 = 2
            r4.mo315a(r8)
        L_0x011c:
            boolean r7 = r4.mo316a()
            if (r7 != 0) goto L_0x019c
            r4.mo316a()
            r7 = 0
        L_0x0126:
            int r14 = r0.f7820t
            int r15 = r3 << r7
            if (r14 >= r15) goto L_0x0194
            int r4 = r4.mo315a(r7)
            int r7 = r0.f7820t
            long r14 = (long) r7
            long r14 = r14 * r9
            int r7 = r4 % r7
            r19 = r9
            long r8 = (long) r7
            long r14 = r14 + r8
            r17 = -1
            int r7 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r7 == 0) goto L_0x0152
            long[] r7 = r0.f7688a_
            long[] r8 = new long[r3]
            long r9 = r14 - r12
            r16 = 0
            r8[r16] = r9
            long[] r7 = atakplugin.UASTool.afs.m880a((long[]) r7, (long[]) r8)
            r0.f7688a_ = r7
            goto L_0x0154
        L_0x0152:
            r16 = 0
        L_0x0154:
            java.io.PrintStream r7 = java.lang.System.err
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Frame increment: "
            r8.<init>(r9)
            long r9 = r14 - r12
            r8.append(r9)
            java.lang.String r9 = " vop time increment: "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r4 = " last_sync_point: "
            r8.append(r4)
            r9 = r19
            r8.append(r9)
            java.lang.String r4 = " time_code: "
            r8.append(r4)
            r8.append(r14)
            java.lang.String r4 = r8.toString()
            r7.println(r4)
            r1.add(r2)
            java.util.List<atakplugin.UASTool.xh> r2 = r0.f7816p
            atakplugin.UASTool.xh r4 = r0.mo6272a((java.util.List<? extends java.nio.ByteBuffer>) r1)
            r2.add(r4)
            r1.clear()
            r12 = r14
            goto L_0x01c7
        L_0x0194:
            r16 = 0
            r17 = -1
            int r7 = r7 + 1
            r8 = 2
            goto L_0x0126
        L_0x019c:
            r16 = 0
            r17 = -1
            r7 = 1
            long r9 = r9 + r7
            r8 = 2
            goto L_0x011c
        L_0x01a6:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Got start code I don't know. Ask Sebastian via mp4parser mailing list what to do"
            r1.<init>(r2)
            throw r1
        L_0x01ae:
            r16 = 0
            r17 = -1
            boolean r8 = r0.f7818r
            if (r8 != 0) goto L_0x01c7
            java.util.List<java.nio.ByteBuffer> r8 = r0.f7817q
            r8.add(r2)
            if (r7 != r15) goto L_0x01c1
            r0.m14875a(r14, r11, r6)
            goto L_0x01c7
        L_0x01c1:
            if (r7 != r4) goto L_0x01c7
            int r11 = r0.m14877b((java.nio.ByteBuffer) r14)
        L_0x01c7:
            r2 = 0
            r4 = 2
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.C1075yz.<init>(atakplugin.UASTool.ws):void");
    }

    /* renamed from: b */
    private int m14877b(ByteBuffer byteBuffer) {
        adi adi = new adi(byteBuffer);
        if (!adi.mo316a()) {
            return 0;
        }
        int a = adi.mo315a(4);
        adi.mo315a(3);
        return a;
    }

    /* renamed from: a */
    private void m14875a(ByteBuffer byteBuffer, int i, C0801rj rjVar) {
        adi adi = new adi(byteBuffer);
        adi.mo316a();
        adi.mo315a(8);
        if (adi.mo316a()) {
            i = adi.mo315a(4);
            adi.mo315a(3);
        }
        if (adi.mo315a(4) == 15) {
            adi.mo315a(8);
            adi.mo315a(8);
        }
        if (adi.mo316a()) {
            adi.mo315a(2);
            adi.mo316a();
            if (adi.mo316a()) {
                throw new RuntimeException("Implemented when needed");
            }
        }
        int a = adi.mo315a(2);
        if (a == this.f7814n && i != 1) {
            adi.mo315a(4);
        }
        adi.mo316a();
        this.f7820t = adi.mo315a(16);
        adi.mo316a();
        if (adi.mo316a()) {
            f7810u.info("Fixed Frame Rate");
            int i2 = 0;
            while (this.f7820t >= (1 << i2)) {
                i2++;
            }
            this.f7819s = adi.mo315a(i2);
        }
        if (a == this.f7813m) {
            throw new RuntimeException("Please implmenet me");
        } else if (a == this.f7811k) {
            adi.mo316a();
            rjVar.mo5639b(adi.mo315a(13));
            adi.mo316a();
            rjVar.mo5641c(adi.mo315a(13));
            adi.mo316a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1024xh mo6272a(List<? extends ByteBuffer> list) {
        byte[] bArr = new byte[3];
        bArr[2] = 1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteBuffer[] byteBufferArr = new ByteBuffer[(list.size() * 2)];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = wrap;
            byteBufferArr[i2 + 1] = (ByteBuffer) list.get(i);
        }
        return new C1025xi(byteBufferArr);
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7815o;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7816p;
    }

    /* renamed from: a */
    public static void m14876a(String[] strArr) {
        File[] listFiles = new File("C:\\dev\\mp4parser\\frames").listFiles();
        Arrays.sort(listFiles);
        C1022xf xfVar = new C1022xf();
        xfVar.mo6161a((C1026xj) new C1075yz(new C1012wx(listFiles)));
        new C1030xn().mo6195a(xfVar).mo209b(Channels.newChannel(new FileOutputStream("output.mp4")));
    }

    /* renamed from: b */
    public static void m14878b(String[] strArr) {
        C1009wu wuVar = new C1009wu("C:\\content\\bbb.h263");
        C1022xf xfVar = new C1022xf();
        xfVar.mo6161a((C1026xj) new C1075yz(wuVar));
        new C1030xn().mo6195a(xfVar).mo209b(Channels.newChannel(new FileOutputStream("output.mp4")));
    }

    /* renamed from: c */
    public static void m14879c(String[] strArr) {
        ade ade = (ade) aft.m882a((C0695nz) new C0678nj("C:\\content\\bbb.mp4"), "/moov[0]/trak[0]/mdia[0]/minf[0]/stbl[0]/stsd[0]/mp4v[0]/esds[0]");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ade.mo18a(Channels.newChannel(byteArrayOutputStream));
        System.err.println(C0677ni.m12484a(byteArrayOutputStream.toByteArray()));
        System.err.println(ade.mo291k());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ade.mo18a(Channels.newChannel(byteArrayOutputStream2));
        System.err.println(C0677ni.m12484a(byteArrayOutputStream2.toByteArray()));
    }
}
