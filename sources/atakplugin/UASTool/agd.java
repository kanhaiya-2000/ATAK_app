package atakplugin.UASTool;

import atakplugin.UASTool.afy;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.net.Socket;
import java.util.Vector;

public class agd extends afy {

    /* renamed from: B */
    private static Vector f968B = new Vector();

    /* renamed from: C */
    private static final int f969C = 131072;

    /* renamed from: D */
    private static final int f970D = 16384;

    /* renamed from: E */
    private static final int f971E = 10000;

    /* renamed from: F */
    private Socket f972F = null;

    /* renamed from: G */
    private agx f973G = null;

    /* renamed from: H */
    private C0032a f974H = null;

    agd() {
        mo668c(131072);
        mo670d(131072);
        mo671e(16384);
        this.f910q = new ahc();
        this.f915v = true;
    }

    public void run() {
        try {
            C0032a aVar = this.f974H;
            if (aVar instanceof C0033b) {
                C0033b bVar = (C0033b) aVar;
                this.f973G = (agx) Class.forName(bVar.f979e).newInstance();
                PipedOutputStream pipedOutputStream = new PipedOutputStream();
                this.f910q.mo856a((InputStream) new afy.C0029b(pipedOutputStream, 32768), false);
                this.f973G.mo827a(this, mo673f(), pipedOutputStream);
                this.f973G.mo828a(bVar.f980f);
                new Thread(this.f973G).start();
            } else {
                C0034c cVar = (C0034c) aVar;
                Socket a = cVar.f982g == null ? aji.m1805a(cVar.f979e, cVar.f981f, 10000) : cVar.f982g.createSocket(cVar.f979e, cVar.f981f);
                this.f972F = a;
                a.setTcpNoDelay(true);
                this.f910q.mo855a(this.f972F.getInputStream());
                this.f910q.mo857a(this.f972F.getOutputStream());
            }
            mo688r();
            this.f911r = Thread.currentThread();
            afx afx = new afx(this.f909p);
            ahy ahy = new ahy(afx);
            try {
                air p = mo686p();
                while (true) {
                    if (this.f911r == null || this.f910q == null || this.f910q.f1234a == null) {
                        break;
                    }
                    int read = this.f910q.f1234a.read(afx.f888b, 14, (afx.f888b.length - 14) - 84);
                    if (read <= 0) {
                        mo680j();
                        break;
                    }
                    ahy.mo996a();
                    afx.mo618a((byte) 94);
                    afx.mo619a(this.f903j);
                    afx.mo619a(read);
                    afx.mo626b(read);
                    synchronized (this) {
                        if (!this.f914u) {
                            p.mo1042a(ahy, (afy) this, read);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            mo683m();
        } catch (Exception unused2) {
            mo678h(1);
            this.f914u = true;
            mo683m();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo651a(afx afx) {
        air air;
        mo649a(afx.mo633d());
        mo650a(afx.mo637e());
        mo674f(afx.mo633d());
        byte[] j = afx.mo643j();
        int d = afx.mo633d();
        afx.mo643j();
        afx.mo633d();
        try {
            air = mo686p();
        } catch (ahj unused) {
            air = null;
        }
        C0032a b = m1016b(air, aji.m1813b(j), d);
        this.f974H = b;
        if (b == null) {
            this.f974H = m1016b(air, (String) null, d);
        }
        if (this.f974H == null && ahg.m1351f().mo908a(3)) {
            ahg.m1351f().mo907a(3, "ChannelForwardedTCPIP: " + aji.m1813b(j) + ":" + d + " is not registered.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        return r2;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static atakplugin.UASTool.agd.C0032a m1016b(atakplugin.UASTool.air r4, java.lang.String r5, int r6) {
        /*
            java.util.Vector r0 = f968B
            monitor-enter(r0)
            r1 = 0
        L_0x0004:
            java.util.Vector r2 = f968B     // Catch:{ all -> 0x003a }
            int r2 = r2.size()     // Catch:{ all -> 0x003a }
            if (r1 >= r2) goto L_0x0037
            java.util.Vector r2 = f968B     // Catch:{ all -> 0x003a }
            java.lang.Object r2 = r2.elementAt(r1)     // Catch:{ all -> 0x003a }
            atakplugin.UASTool.agd$a r2 = (atakplugin.UASTool.agd.C0032a) r2     // Catch:{ all -> 0x003a }
            atakplugin.UASTool.agd$a r2 = (atakplugin.UASTool.agd.C0032a) r2     // Catch:{ all -> 0x003a }
            atakplugin.UASTool.air r3 = r2.f975a     // Catch:{ all -> 0x003a }
            if (r3 == r4) goto L_0x001b
            goto L_0x0032
        L_0x001b:
            int r3 = r2.f976b     // Catch:{ all -> 0x003a }
            if (r3 == r6) goto L_0x0028
            int r3 = r2.f976b     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0032
            int r3 = r2.f977c     // Catch:{ all -> 0x003a }
            if (r3 == r6) goto L_0x0028
            goto L_0x0032
        L_0x0028:
            if (r5 == 0) goto L_0x0035
            java.lang.String r3 = r2.f978d     // Catch:{ all -> 0x003a }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0035
        L_0x0032:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return r2
        L_0x0037:
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return r4
        L_0x003a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agd.m1016b(atakplugin.UASTool.air, java.lang.String, int):atakplugin.UASTool.agd$a");
    }

    /* renamed from: c */
    static String[] m1018c(air air) {
        int i;
        Vector vector = new Vector();
        synchronized (f968B) {
            for (int i2 = 0; i2 < f968B.size(); i2++) {
                C0032a aVar = (C0032a) f968B.elementAt(i2);
                if (aVar instanceof C0033b) {
                    vector.addElement(aVar.f977c + ":" + aVar.f979e + ":");
                } else {
                    vector.addElement(aVar.f977c + ":" + aVar.f979e + ":" + ((C0034c) aVar).f981f);
                }
            }
        }
        String[] strArr = new String[vector.size()];
        for (i = 0; i < vector.size(); i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    /* renamed from: c */
    static String m1017c(String str) {
        if (str == null) {
            return "localhost";
        }
        return (str.length() == 0 || str.equals("*")) ? "" : str;
    }

    /* renamed from: a */
    static void m1013a(air air, String str, int i, int i2, String str2, int i3, aiz aiz) {
        String c = m1017c(str);
        synchronized (f968B) {
            if (m1016b(air, c, i) == null) {
                C0034c cVar = new C0034c();
                cVar.f975a = air;
                cVar.f976b = i;
                cVar.f977c = i2;
                cVar.f979e = str2;
                cVar.f981f = i3;
                cVar.f978d = c;
                cVar.f982g = aiz;
                f968B.addElement(cVar);
            } else {
                throw new ahj("PortForwardingR: remote port " + i + " is already registered.");
            }
        }
    }

    /* renamed from: a */
    static void m1014a(air air, String str, int i, int i2, String str2, Object[] objArr) {
        String c = m1017c(str);
        synchronized (f968B) {
            if (m1016b(air, c, i) == null) {
                C0033b bVar = new C0033b();
                bVar.f975a = air;
                bVar.f976b = i;
                bVar.f977c = i;
                bVar.f979e = str2;
                bVar.f980f = objArr;
                bVar.f978d = c;
                f968B.addElement(bVar);
            } else {
                throw new ahj("PortForwardingR: remote port " + i + " is already registered.");
            }
        }
    }

    /* renamed from: a */
    static void m1010a(agd agd) {
        air air;
        C0032a aVar;
        try {
            air = agd.mo686p();
        } catch (ahj unused) {
            air = null;
        }
        if (air != null && (aVar = agd.f974H) != null) {
            m1011a(air, aVar.f976b);
        }
    }

    /* renamed from: a */
    static void m1011a(air air, int i) {
        m1012a(air, (String) null, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        r0 = new atakplugin.UASTool.afx(100);
        r1 = new atakplugin.UASTool.ahy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.mo996a();
        r0.mo618a((byte) 80);
        r0.mo627b(atakplugin.UASTool.aji.m1820c("cancel-tcpip-forward"));
        r0.mo618a((byte) 0);
        r0.mo627b(atakplugin.UASTool.aji.m1820c(r4));
        r0.mo619a(r5);
        r3.mo1061b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m1012a(atakplugin.UASTool.air r3, java.lang.String r4, int r5) {
        /*
            java.util.Vector r0 = f968B
            monitor-enter(r0)
            java.lang.String r1 = m1017c((java.lang.String) r4)     // Catch:{ all -> 0x0053 }
            atakplugin.UASTool.agd$a r1 = m1016b(r3, r1, r5)     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x0012
            r1 = 0
            atakplugin.UASTool.agd$a r1 = m1016b(r3, r1, r5)     // Catch:{ all -> 0x0053 }
        L_0x0012:
            if (r1 != 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0016:
            java.util.Vector r2 = f968B     // Catch:{ all -> 0x0053 }
            r2.removeElement(r1)     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x001f
            java.lang.String r4 = r1.f978d     // Catch:{ all -> 0x0053 }
        L_0x001f:
            if (r4 != 0) goto L_0x0023
            java.lang.String r4 = "0.0.0.0"
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            atakplugin.UASTool.afx r0 = new atakplugin.UASTool.afx
            r1 = 100
            r0.<init>((int) r1)
            atakplugin.UASTool.ahy r1 = new atakplugin.UASTool.ahy
            r1.<init>(r0)
            r1.mo996a()     // Catch:{ Exception -> 0x0052 }
            r2 = 80
            r0.mo618a((byte) r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "cancel-tcpip-forward"
            byte[] r2 = atakplugin.UASTool.aji.m1820c((java.lang.String) r2)     // Catch:{ Exception -> 0x0052 }
            r0.mo627b((byte[]) r2)     // Catch:{ Exception -> 0x0052 }
            r2 = 0
            r0.mo618a((byte) r2)     // Catch:{ Exception -> 0x0052 }
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)     // Catch:{ Exception -> 0x0052 }
            r0.mo627b((byte[]) r4)     // Catch:{ Exception -> 0x0052 }
            r0.mo619a((int) r5)     // Catch:{ Exception -> 0x0052 }
            r3.mo1061b((atakplugin.UASTool.ahy) r1)     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            return
        L_0x0053:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agd.m1012a(atakplugin.UASTool.air, java.lang.String, int):void");
    }

    /* renamed from: d */
    static void m1019d(air air) {
        int[] iArr;
        int i;
        int i2;
        synchronized (f968B) {
            iArr = new int[f968B.size()];
            i2 = 0;
            for (int i3 = 0; i3 < f968B.size(); i3++) {
                C0032a aVar = (C0032a) f968B.elementAt(i3);
                if (aVar.f975a == air) {
                    iArr[i2] = aVar.f976b;
                    i2++;
                }
            }
        }
        for (i = 0; i < i2; i++) {
            m1011a(air, iArr[i]);
        }
    }

    /* renamed from: u */
    public int mo719u() {
        C0032a aVar = this.f974H;
        if (aVar != null) {
            return aVar.f976b;
        }
        return 0;
    }

    /* renamed from: a */
    private void m1015a(aiz aiz) {
        C0032a aVar = this.f974H;
        if (aVar != null && (aVar instanceof C0034c)) {
            ((C0034c) aVar).f982g = aiz;
        }
    }

    /* renamed from: atakplugin.UASTool.agd$a */
    static abstract class C0032a {

        /* renamed from: a */
        air f975a;

        /* renamed from: b */
        int f976b;

        /* renamed from: c */
        int f977c;

        /* renamed from: d */
        String f978d;

        /* renamed from: e */
        String f979e;

        C0032a() {
        }
    }

    /* renamed from: atakplugin.UASTool.agd$b */
    static class C0033b extends C0032a {

        /* renamed from: f */
        Object[] f980f;

        C0033b() {
        }
    }

    /* renamed from: atakplugin.UASTool.agd$c */
    static class C0034c extends C0032a {

        /* renamed from: f */
        int f981f;

        /* renamed from: g */
        aiz f982g;

        C0034c() {
        }
    }
}
