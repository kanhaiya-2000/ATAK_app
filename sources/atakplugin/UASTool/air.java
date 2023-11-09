package atakplugin.UASTool;

import atakplugin.UASTool.agp;
import atakplugin.UASTool.ahf;
import com.google.common.base.Ascii;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class air implements Runnable {

    /* renamed from: A */
    static final int f1431A = 99;

    /* renamed from: B */
    static final int f1432B = 100;

    /* renamed from: H */
    static aie f1433H = null;

    /* renamed from: L */
    static final int f1434L = 84;

    /* renamed from: Y */
    private static final int f1435Y = 262144;

    /* renamed from: a */
    static final int f1436a = 1;

    /* renamed from: aP */
    private static final byte[] f1437aP = aji.m1820c("keepalive@jcraft.com");

    /* renamed from: aQ */
    private static final byte[] f1438aQ = aji.m1820c("no-more-sessions@openssh.com");

    /* renamed from: b */
    static final int f1439b = 2;

    /* renamed from: c */
    static final int f1440c = 3;

    /* renamed from: d */
    static final int f1441d = 4;

    /* renamed from: e */
    static final int f1442e = 5;

    /* renamed from: f */
    static final int f1443f = 6;

    /* renamed from: g */
    static final int f1444g = 20;

    /* renamed from: h */
    static final int f1445h = 21;

    /* renamed from: i */
    static final int f1446i = 30;

    /* renamed from: j */
    static final int f1447j = 31;

    /* renamed from: k */
    static final int f1448k = 31;

    /* renamed from: l */
    static final int f1449l = 32;

    /* renamed from: m */
    static final int f1450m = 33;

    /* renamed from: n */
    static final int f1451n = 34;

    /* renamed from: o */
    static final int f1452o = 80;

    /* renamed from: p */
    static final int f1453p = 81;

    /* renamed from: q */
    static final int f1454q = 82;

    /* renamed from: r */
    static final int f1455r = 90;

    /* renamed from: s */
    static final int f1456s = 91;

    /* renamed from: t */
    static final int f1457t = 92;

    /* renamed from: u */
    static final int f1458u = 93;

    /* renamed from: v */
    static final int f1459v = 94;

    /* renamed from: w */
    static final int f1460w = 95;

    /* renamed from: x */
    static final int f1461x = 96;

    /* renamed from: y */
    static final int f1462y = 97;

    /* renamed from: z */
    static final int f1463z = 98;

    /* renamed from: C */
    String[] f1464C = null;

    /* renamed from: D */
    boolean f1465D = false;

    /* renamed from: E */
    boolean f1466E = false;

    /* renamed from: F */
    InputStream f1467F = null;

    /* renamed from: G */
    OutputStream f1468G = null;

    /* renamed from: I */
    afx f1469I;

    /* renamed from: J */
    ahy f1470J;

    /* renamed from: K */
    aiz f1471K = null;

    /* renamed from: M */
    protected boolean f1472M = false;

    /* renamed from: N */
    int f1473N = 6;

    /* renamed from: O */
    int f1474O = 0;

    /* renamed from: P */
    String f1475P = "127.0.0.1";

    /* renamed from: Q */
    String f1476Q = "127.0.0.1";

    /* renamed from: R */
    int f1477R = 22;

    /* renamed from: S */
    String f1478S = null;

    /* renamed from: T */
    byte[] f1479T = null;

    /* renamed from: U */
    ahg f1480U;

    /* renamed from: V */
    int[] f1481V = new int[1];

    /* renamed from: W */
    int[] f1482W = new int[1];

    /* renamed from: X */
    Runnable f1483X;

    /* renamed from: Z */
    private byte[] f1484Z;

    /* renamed from: aA */
    private Thread f1485aA = null;

    /* renamed from: aB */
    private Object f1486aB = new Object();

    /* renamed from: aC */
    private Hashtable f1487aC = null;

    /* renamed from: aD */
    private aia f1488aD = null;

    /* renamed from: aE */
    private ajh f1489aE;

    /* renamed from: aF */
    private String f1490aF = null;

    /* renamed from: aG */
    private int f1491aG = 0;

    /* renamed from: aH */
    private int f1492aH = 1;

    /* renamed from: aI */
    private ahf f1493aI = null;

    /* renamed from: aJ */
    private ahb f1494aJ = null;

    /* renamed from: aK */
    private long f1495aK = 0;

    /* renamed from: aL */
    private boolean f1496aL = false;

    /* renamed from: aM */
    private int f1497aM = 8;

    /* renamed from: aN */
    private int f1498aN = 8;

    /* renamed from: aO */
    private C0051b f1499aO = new C0051b();

    /* renamed from: aR */
    private aha f1500aR = null;

    /* renamed from: aa */
    private byte[] f1501aa = aji.m1820c("SSH-2.0-JSCH-0.1.51");

    /* renamed from: ab */
    private byte[] f1502ab;

    /* renamed from: ac */
    private byte[] f1503ac;

    /* renamed from: ad */
    private byte[] f1504ad;

    /* renamed from: ae */
    private byte[] f1505ae;

    /* renamed from: af */
    private byte[] f1506af;

    /* renamed from: ag */
    private byte[] f1507ag;

    /* renamed from: ah */
    private byte[] f1508ah;

    /* renamed from: ai */
    private byte[] f1509ai;

    /* renamed from: aj */
    private byte[] f1510aj;

    /* renamed from: ak */
    private byte[] f1511ak;

    /* renamed from: al */
    private int f1512al = 0;

    /* renamed from: am */
    private int f1513am = 0;

    /* renamed from: an */
    private agm f1514an;

    /* renamed from: ao */
    private agm f1515ao;

    /* renamed from: ap */
    private ahv f1516ap;

    /* renamed from: aq */
    private ahv f1517aq;

    /* renamed from: ar */
    private byte[] f1518ar;

    /* renamed from: as */
    private byte[] f1519as;

    /* renamed from: at */
    private ago f1520at;

    /* renamed from: au */
    private ago f1521au;

    /* renamed from: av */
    private ahc f1522av;

    /* renamed from: aw */
    private Socket f1523aw;

    /* renamed from: ax */
    private int f1524ax = 0;

    /* renamed from: ay */
    private volatile boolean f1525ay = false;

    /* renamed from: az */
    private boolean f1526az = false;

    air(ahg ahg, String str, String str2, int i) {
        this.f1480U = ahg;
        this.f1469I = new afx();
        this.f1470J = new ahy(this.f1469I);
        this.f1478S = str;
        this.f1475P = str2;
        this.f1476Q = str2;
        this.f1477R = i;
        m1648z();
        if (this.f1478S == null) {
            try {
                this.f1478S = (String) System.getProperties().get("user.name");
            } catch (SecurityException unused) {
            }
        }
        if (this.f1478S == null) {
            throw new ahj("username is not given.");
        }
    }

    /* renamed from: a */
    public void mo1033a() {
        mo1034a(this.f1524ax);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:139|140|(1:142)) */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x037d, code lost:
        if (atakplugin.UASTool.ahg.m1351f().mo908a(2) != false) goto L_0x037f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x037f, code lost:
        atakplugin.UASTool.ahg.m1351f().mo907a(2, "failed to load " + r13 + " method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x05ce, code lost:
        if ((r2 instanceof atakplugin.UASTool.ahj) != false) goto L_0x05d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x05d2, code lost:
        throw ((atakplugin.UASTool.ahj) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x05e9, code lost:
        throw new atakplugin.UASTool.ahj("Session.connect: " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x05ec, code lost:
        throw ((java.lang.RuntimeException) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x0375 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:251:0x05c2 */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x039f A[SYNTHETIC, Splitter:B:145:0x039f] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x05cc A[Catch:{ all -> 0x057a }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x05ea A[Catch:{ all -> 0x057a }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1034a(int r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            boolean r3 = r1.f1525ay
            if (r3 != 0) goto L_0x05f5
            atakplugin.UASTool.ahc r3 = new atakplugin.UASTool.ahc
            r3.<init>()
            r1.f1522av = r3
            atakplugin.UASTool.aie r3 = f1433H
            if (r3 != 0) goto L_0x0034
            java.lang.String r3 = "random"
            java.lang.String r3 = r1.mo1083i(r3)     // Catch:{ Exception -> 0x0028 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0028 }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Exception -> 0x0028 }
            atakplugin.UASTool.aie r3 = (atakplugin.UASTool.aie) r3     // Catch:{ Exception -> 0x0028 }
            atakplugin.UASTool.aie r3 = (atakplugin.UASTool.aie) r3     // Catch:{ Exception -> 0x0028 }
            f1433H = r3     // Catch:{ Exception -> 0x0028 }
            goto L_0x0034
        L_0x0028:
            r0 = move-exception
            r2 = r0
            atakplugin.UASTool.ahj r3 = new atakplugin.UASTool.ahj
            java.lang.String r4 = r2.toString()
            r3.<init>(r4, r2)
            throw r3
        L_0x0034:
            atakplugin.UASTool.aie r3 = f1433H
            atakplugin.UASTool.ahy.m1561a((atakplugin.UASTool.aie) r3)
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()
            r4 = 1
            boolean r3 = r3.mo908a(r4)
            if (r3 == 0) goto L_0x0068
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Connecting to "
            r5.append(r6)
            java.lang.String r6 = r1.f1475P
            r5.append(r6)
            java.lang.String r6 = " port "
            r5.append(r6)
            int r6 = r1.f1477R
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.mo907a(r4, r5)
        L_0x0068:
            r3 = 13
            r5 = 3
            r6 = 0
            r7 = 2
            r8 = 0
            atakplugin.UASTool.aia r9 = r1.f1488aD     // Catch:{ Exception -> 0x057d }
            if (r9 != 0) goto L_0x00b3
            atakplugin.UASTool.aiz r9 = r1.f1471K     // Catch:{ Exception -> 0x057d }
            if (r9 != 0) goto L_0x008b
            java.lang.String r9 = r1.f1475P     // Catch:{ Exception -> 0x057d }
            int r10 = r1.f1477R     // Catch:{ Exception -> 0x057d }
            java.net.Socket r9 = atakplugin.UASTool.aji.m1805a((java.lang.String) r9, (int) r10, (int) r2)     // Catch:{ Exception -> 0x057d }
            r1.f1523aw = r9     // Catch:{ Exception -> 0x057d }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ Exception -> 0x057d }
            java.net.Socket r10 = r1.f1523aw     // Catch:{ Exception -> 0x057d }
            java.io.OutputStream r10 = r10.getOutputStream()     // Catch:{ Exception -> 0x057d }
            goto L_0x00a3
        L_0x008b:
            java.lang.String r10 = r1.f1475P     // Catch:{ Exception -> 0x057d }
            int r11 = r1.f1477R     // Catch:{ Exception -> 0x057d }
            java.net.Socket r9 = r9.createSocket(r10, r11)     // Catch:{ Exception -> 0x057d }
            r1.f1523aw = r9     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.aiz r10 = r1.f1471K     // Catch:{ Exception -> 0x057d }
            java.io.InputStream r9 = r10.getInputStream(r9)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.aiz r10 = r1.f1471K     // Catch:{ Exception -> 0x057d }
            java.net.Socket r11 = r1.f1523aw     // Catch:{ Exception -> 0x057d }
            java.io.OutputStream r10 = r10.getOutputStream(r11)     // Catch:{ Exception -> 0x057d }
        L_0x00a3:
            java.net.Socket r11 = r1.f1523aw     // Catch:{ Exception -> 0x057d }
            r11.setTcpNoDelay(r4)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahc r11 = r1.f1522av     // Catch:{ Exception -> 0x057d }
            r11.mo855a((java.io.InputStream) r9)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahc r9 = r1.f1522av     // Catch:{ Exception -> 0x057d }
            r9.mo857a((java.io.OutputStream) r10)     // Catch:{ Exception -> 0x057d }
            goto L_0x00de
        L_0x00b3:
            monitor-enter(r9)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.aia r10 = r1.f1488aD     // Catch:{ all -> 0x0576 }
            atakplugin.UASTool.aiz r11 = r1.f1471K     // Catch:{ all -> 0x0576 }
            java.lang.String r12 = r1.f1475P     // Catch:{ all -> 0x0576 }
            int r13 = r1.f1477R     // Catch:{ all -> 0x0576 }
            r10.mo1005a(r11, r12, r13, r2)     // Catch:{ all -> 0x0576 }
            atakplugin.UASTool.ahc r10 = r1.f1522av     // Catch:{ all -> 0x0576 }
            atakplugin.UASTool.aia r11 = r1.f1488aD     // Catch:{ all -> 0x0576 }
            java.io.InputStream r11 = r11.mo1004a()     // Catch:{ all -> 0x0576 }
            r10.mo855a((java.io.InputStream) r11)     // Catch:{ all -> 0x0576 }
            atakplugin.UASTool.ahc r10 = r1.f1522av     // Catch:{ all -> 0x0576 }
            atakplugin.UASTool.aia r11 = r1.f1488aD     // Catch:{ all -> 0x0576 }
            java.io.OutputStream r11 = r11.mo1006b()     // Catch:{ all -> 0x0576 }
            r10.mo857a((java.io.OutputStream) r11)     // Catch:{ all -> 0x0576 }
            atakplugin.UASTool.aia r10 = r1.f1488aD     // Catch:{ all -> 0x0576 }
            java.net.Socket r10 = r10.mo1007c()     // Catch:{ all -> 0x0576 }
            r1.f1523aw = r10     // Catch:{ all -> 0x0576 }
            monitor-exit(r9)     // Catch:{ all -> 0x0576 }
        L_0x00de:
            if (r2 <= 0) goto L_0x00e7
            java.net.Socket r9 = r1.f1523aw     // Catch:{ Exception -> 0x057d }
            if (r9 == 0) goto L_0x00e7
            r9.setSoTimeout(r2)     // Catch:{ Exception -> 0x057d }
        L_0x00e7:
            r1.f1525ay = r4     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahu r9 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r9 = r9.mo908a(r4)     // Catch:{ Exception -> 0x057d }
            if (r9 == 0) goto L_0x00fc
            atakplugin.UASTool.ahu r9 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.String r10 = "Connection established"
            r9.mo907a(r4, r10)     // Catch:{ Exception -> 0x057d }
        L_0x00fc:
            atakplugin.UASTool.ahg r9 = r1.f1480U     // Catch:{ Exception -> 0x057d }
            r9.mo893a((atakplugin.UASTool.air) r1)     // Catch:{ Exception -> 0x057d }
            byte[] r9 = r1.f1501aa     // Catch:{ Exception -> 0x057d }
            int r10 = r9.length     // Catch:{ Exception -> 0x057d }
            int r10 = r10 + r4
            byte[] r11 = new byte[r10]     // Catch:{ Exception -> 0x057d }
            int r12 = r9.length     // Catch:{ Exception -> 0x057d }
            java.lang.System.arraycopy(r9, r8, r11, r8, r12)     // Catch:{ Exception -> 0x057d }
            int r9 = r10 + -1
            r12 = 10
            r11[r9] = r12     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahc r9 = r1.f1522av     // Catch:{ Exception -> 0x057d }
            r9.mo860a(r11, r8, r10)     // Catch:{ Exception -> 0x057d }
        L_0x0116:
            r9 = 0
            r10 = 0
        L_0x0118:
            atakplugin.UASTool.afx r11 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r11 = r11.f888b     // Catch:{ Exception -> 0x057d }
            int r11 = r11.length     // Catch:{ Exception -> 0x057d }
            if (r9 >= r11) goto L_0x0133
            atakplugin.UASTool.ahc r10 = r1.f1522av     // Catch:{ Exception -> 0x057d }
            int r10 = r10.mo853a()     // Catch:{ Exception -> 0x057d }
            if (r10 >= 0) goto L_0x0128
            goto L_0x0133
        L_0x0128:
            atakplugin.UASTool.afx r11 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r11 = r11.f888b     // Catch:{ Exception -> 0x057d }
            byte r13 = (byte) r10     // Catch:{ Exception -> 0x057d }
            r11[r9] = r13     // Catch:{ Exception -> 0x057d }
            int r9 = r9 + 1
            if (r10 != r12) goto L_0x0118
        L_0x0133:
            if (r10 < 0) goto L_0x056e
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            int r11 = r9 + -1
            byte r10 = r10[r11]     // Catch:{ Exception -> 0x057d }
            if (r10 != r12) goto L_0x014f
            int r9 = r9 + -1
            if (r9 <= 0) goto L_0x014f
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            int r11 = r9 + -1
            byte r10 = r10[r11]     // Catch:{ Exception -> 0x057d }
            if (r10 != r3) goto L_0x014f
            int r9 = r9 + -1
        L_0x014f:
            if (r9 <= r5) goto L_0x0116
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            int r10 = r10.length     // Catch:{ Exception -> 0x057d }
            if (r9 == r10) goto L_0x017f
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            byte r10 = r10[r8]     // Catch:{ Exception -> 0x057d }
            r11 = 83
            if (r10 != r11) goto L_0x0116
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            byte r10 = r10[r4]     // Catch:{ Exception -> 0x057d }
            if (r10 != r11) goto L_0x0116
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            byte r10 = r10[r7]     // Catch:{ Exception -> 0x057d }
            r11 = 72
            if (r10 != r11) goto L_0x0116
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            byte r10 = r10[r5]     // Catch:{ Exception -> 0x057d }
            r11 = 45
            if (r10 == r11) goto L_0x017f
            goto L_0x0116
        L_0x017f:
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            int r10 = r10.length     // Catch:{ Exception -> 0x057d }
            if (r9 == r10) goto L_0x0566
            r10 = 7
            if (r9 < r10) goto L_0x0566
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            r11 = 4
            byte r10 = r10[r11]     // Catch:{ Exception -> 0x057d }
            r11 = 49
            if (r10 != r11) goto L_0x019f
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            r11 = 6
            byte r10 = r10[r11]     // Catch:{ Exception -> 0x057d }
            r11 = 57
            if (r10 != r11) goto L_0x0566
        L_0x019f:
            byte[] r10 = new byte[r9]     // Catch:{ Exception -> 0x057d }
            r1.f1484Z = r10     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte[] r10 = r10.f888b     // Catch:{ Exception -> 0x057d }
            byte[] r11 = r1.f1484Z     // Catch:{ Exception -> 0x057d }
            java.lang.System.arraycopy(r10, r8, r11, r8, r9)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahu r9 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r9 = r9.mo908a(r4)     // Catch:{ Exception -> 0x057d }
            if (r9 == 0) goto L_0x01f2
            atakplugin.UASTool.ahu r9 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r10.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r11 = "Remote version string: "
            r10.append(r11)     // Catch:{ Exception -> 0x057d }
            byte[] r11 = r1.f1484Z     // Catch:{ Exception -> 0x057d }
            java.lang.String r11 = atakplugin.UASTool.aji.m1813b((byte[]) r11)     // Catch:{ Exception -> 0x057d }
            r10.append(r11)     // Catch:{ Exception -> 0x057d }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x057d }
            r9.mo907a(r4, r10)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahu r9 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r10.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r11 = "Local version string: "
            r10.append(r11)     // Catch:{ Exception -> 0x057d }
            byte[] r11 = r1.f1501aa     // Catch:{ Exception -> 0x057d }
            java.lang.String r11 = atakplugin.UASTool.aji.m1813b((byte[]) r11)     // Catch:{ Exception -> 0x057d }
            r10.append(r11)     // Catch:{ Exception -> 0x057d }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x057d }
            r9.mo907a(r4, r10)     // Catch:{ Exception -> 0x057d }
        L_0x01f2:
            r16.m1646x()     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r9 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r9 = r1.mo1031a((atakplugin.UASTool.afx) r9)     // Catch:{ Exception -> 0x057d }
            r1.f1469I = r9     // Catch:{ Exception -> 0x057d }
            byte r9 = r9.mo647n()     // Catch:{ Exception -> 0x057d }
            r10 = 20
            if (r9 != r10) goto L_0x0546
            atakplugin.UASTool.ahu r9 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r9 = r9.mo908a(r4)     // Catch:{ Exception -> 0x057d }
            if (r9 == 0) goto L_0x0218
            atakplugin.UASTool.ahu r9 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.String r10 = "SSH_MSG_KEXINIT received"
            r9.mo907a(r4, r10)     // Catch:{ Exception -> 0x057d }
        L_0x0218:
            atakplugin.UASTool.afx r9 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahl r9 = r1.m1637b((atakplugin.UASTool.afx) r9)     // Catch:{ Exception -> 0x057d }
        L_0x021e:
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r10 = r1.mo1031a((atakplugin.UASTool.afx) r10)     // Catch:{ Exception -> 0x057d }
            r1.f1469I = r10     // Catch:{ Exception -> 0x057d }
            int r10 = r9.mo826b()     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r11 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte r11 = r11.mo647n()     // Catch:{ Exception -> 0x057d }
            if (r10 != r11) goto L_0x0526
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x057d }
            r1.f1495aK = r10     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            boolean r10 = r9.mo825a((atakplugin.UASTool.afx) r10)     // Catch:{ Exception -> 0x057d }
            if (r10 == 0) goto L_0x050c
            int r10 = r9.mo826b()     // Catch:{ Exception -> 0x057d }
            if (r10 != 0) goto L_0x021e
            java.lang.String r10 = r1.f1475P     // Catch:{ ahj -> 0x0503 }
            int r11 = r1.f1477R     // Catch:{ ahj -> 0x0503 }
            r1.m1634a((java.lang.String) r10, (int) r11, (atakplugin.UASTool.ahl) r9)     // Catch:{ ahj -> 0x0503 }
            r16.m1647y()     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r10 = r1.mo1031a((atakplugin.UASTool.afx) r10)     // Catch:{ Exception -> 0x057d }
            r1.f1469I = r10     // Catch:{ Exception -> 0x057d }
            byte r10 = r10.mo647n()     // Catch:{ Exception -> 0x057d }
            r11 = 21
            if (r10 != r11) goto L_0x04e3
            atakplugin.UASTool.ahu r10 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r10 = r10.mo908a(r4)     // Catch:{ Exception -> 0x057d }
            if (r10 == 0) goto L_0x0273
            atakplugin.UASTool.ahu r10 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.String r11 = "SSH_MSG_NEWKEYS received"
            r10.mo907a(r4, r11)     // Catch:{ Exception -> 0x057d }
        L_0x0273:
            atakplugin.UASTool.afx r10 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            r1.m1630a((atakplugin.UASTool.afx) r10, (atakplugin.UASTool.ahl) r9)     // Catch:{ Exception -> 0x057d }
            java.lang.String r9 = "MaxAuthTries"
            java.lang.String r9 = r1.mo1083i(r9)     // Catch:{ NumberFormatException -> 0x04c4 }
            if (r9 == 0) goto L_0x0286
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x04c4 }
            r1.f1473N = r9     // Catch:{ NumberFormatException -> 0x04c4 }
        L_0x0286:
            java.lang.String r9 = "userauth.none"
            java.lang.String r9 = r1.mo1083i(r9)     // Catch:{ Exception -> 0x04b8 }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x04b8 }
            java.lang.Object r9 = r9.newInstance()     // Catch:{ Exception -> 0x04b8 }
            atakplugin.UASTool.ajb r9 = (atakplugin.UASTool.ajb) r9     // Catch:{ Exception -> 0x04b8 }
            atakplugin.UASTool.ajb r9 = (atakplugin.UASTool.ajb) r9     // Catch:{ Exception -> 0x04b8 }
            boolean r10 = r9.mo1167a(r1)     // Catch:{ Exception -> 0x057d }
            java.lang.String r11 = "PreferredAuthentications"
            java.lang.String r11 = r1.mo1083i(r11)     // Catch:{ Exception -> 0x057d }
            java.lang.String r12 = ","
            java.lang.String[] r12 = atakplugin.UASTool.aji.m1810a((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x057d }
            if (r10 != 0) goto L_0x02b7
            atakplugin.UASTool.aje r9 = (atakplugin.UASTool.aje) r9     // Catch:{ Exception -> 0x057d }
            java.lang.String r9 = r9.mo1168a()     // Catch:{ Exception -> 0x057d }
            if (r9 == 0) goto L_0x02b8
            java.lang.String r11 = r9.toLowerCase()     // Catch:{ Exception -> 0x057d }
            goto L_0x02b8
        L_0x02b7:
            r11 = r6
        L_0x02b8:
            java.lang.String r9 = ","
            java.lang.String[] r9 = atakplugin.UASTool.aji.m1810a((java.lang.String) r11, (java.lang.String) r9)     // Catch:{ Exception -> 0x057d }
            r13 = 0
        L_0x02bf:
            r14 = 0
        L_0x02c0:
            if (r10 != 0) goto L_0x0422
            if (r12 == 0) goto L_0x0422
            int r15 = r12.length     // Catch:{ Exception -> 0x057d }
            if (r13 >= r15) goto L_0x0422
            int r15 = r13 + 1
            r13 = r12[r13]     // Catch:{ Exception -> 0x057d }
            r5 = 0
        L_0x02cc:
            int r3 = r9.length     // Catch:{ Exception -> 0x057d }
            if (r5 >= r3) goto L_0x02dc
            r3 = r9[r5]     // Catch:{ Exception -> 0x057d }
            boolean r3 = r3.equals(r13)     // Catch:{ Exception -> 0x057d }
            if (r3 == 0) goto L_0x02d9
            r3 = 1
            goto L_0x02dd
        L_0x02d9:
            int r5 = r5 + 1
            goto L_0x02cc
        L_0x02dc:
            r3 = 0
        L_0x02dd:
            if (r3 != 0) goto L_0x02e4
            r13 = r15
            r3 = 13
            r5 = 3
            goto L_0x02c0
        L_0x02e4:
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r3 = r3.mo908a(r4)     // Catch:{ Exception -> 0x057d }
            if (r3 == 0) goto L_0x033c
            java.lang.String r3 = "Authentications that can continue: "
            int r5 = r15 + -1
        L_0x02f2:
            int r8 = r12.length     // Catch:{ Exception -> 0x057d }
            if (r5 >= r8) goto L_0x031d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r8.<init>()     // Catch:{ Exception -> 0x057d }
            r8.append(r3)     // Catch:{ Exception -> 0x057d }
            r3 = r12[r5]     // Catch:{ Exception -> 0x057d }
            r8.append(r3)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x057d }
            int r5 = r5 + 1
            int r8 = r12.length     // Catch:{ Exception -> 0x057d }
            if (r5 >= r8) goto L_0x02f2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r8.<init>()     // Catch:{ Exception -> 0x057d }
            r8.append(r3)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = ","
            r8.append(r3)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x057d }
            goto L_0x02f2
        L_0x031d:
            atakplugin.UASTool.ahu r5 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            r5.mo907a(r4, r3)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r5.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r8 = "Next authentication method: "
            r5.append(r8)     // Catch:{ Exception -> 0x057d }
            r5.append(r13)     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x057d }
            r3.mo907a(r4, r5)     // Catch:{ Exception -> 0x057d }
        L_0x033c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0375 }
            r3.<init>()     // Catch:{ Exception -> 0x0375 }
            java.lang.String r5 = "userauth."
            r3.append(r5)     // Catch:{ Exception -> 0x0375 }
            r3.append(r13)     // Catch:{ Exception -> 0x0375 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0375 }
            java.lang.String r3 = r1.mo1083i(r3)     // Catch:{ Exception -> 0x0375 }
            if (r3 == 0) goto L_0x039c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0375 }
            r3.<init>()     // Catch:{ Exception -> 0x0375 }
            java.lang.String r5 = "userauth."
            r3.append(r5)     // Catch:{ Exception -> 0x0375 }
            r3.append(r13)     // Catch:{ Exception -> 0x0375 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0375 }
            java.lang.String r3 = r1.mo1083i(r3)     // Catch:{ Exception -> 0x0375 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0375 }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Exception -> 0x0375 }
            atakplugin.UASTool.ajb r3 = (atakplugin.UASTool.ajb) r3     // Catch:{ Exception -> 0x0375 }
            atakplugin.UASTool.ajb r3 = (atakplugin.UASTool.ajb) r3     // Catch:{ Exception -> 0x0375 }
            goto L_0x039d
        L_0x0375:
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r3 = r3.mo908a(r7)     // Catch:{ Exception -> 0x057d }
            if (r3 == 0) goto L_0x039c
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r5.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r8 = "failed to load "
            r5.append(r8)     // Catch:{ Exception -> 0x057d }
            r5.append(r13)     // Catch:{ Exception -> 0x057d }
            java.lang.String r8 = " method"
            r5.append(r8)     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x057d }
            r3.mo907a(r7, r5)     // Catch:{ Exception -> 0x057d }
        L_0x039c:
            r3 = r6
        L_0x039d:
            if (r3 == 0) goto L_0x041b
            boolean r10 = r3.mo1167a(r1)     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            if (r10 == 0) goto L_0x03cc
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            boolean r3 = r3.mo908a(r4)     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            if (r3 == 0) goto L_0x03cc
            atakplugin.UASTool.ahu r3 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            r5.<init>()     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            java.lang.String r8 = "Authentication succeeded ("
            r5.append(r8)     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            r5.append(r13)     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            java.lang.String r8 = ")."
            r5.append(r8)     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            java.lang.String r5 = r5.toString()     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
            r3.mo907a(r4, r5)     // Catch:{ ahi -> 0x041a, ahk -> 0x03fe, RuntimeException -> 0x03fb, ahj -> 0x03f8, Exception -> 0x03ce }
        L_0x03cc:
            r14 = 0
            goto L_0x041b
        L_0x03ce:
            r0 = move-exception
            r3 = r0
            atakplugin.UASTool.ahu r5 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r5 = r5.mo908a(r7)     // Catch:{ Exception -> 0x057d }
            if (r5 == 0) goto L_0x03f6
            atakplugin.UASTool.ahu r5 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r8.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r9 = "an exception during authentication\n"
            r8.append(r9)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x057d }
            r8.append(r3)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x057d }
            r5.mo907a(r7, r3)     // Catch:{ Exception -> 0x057d }
        L_0x03f6:
            r14 = 0
            goto L_0x0422
        L_0x03f8:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x03fb:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x03fe:
            r0 = move-exception
            r3 = r0
            java.lang.String r3 = r3.mo911a()     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = ","
            java.lang.String[] r9 = atakplugin.UASTool.aji.m1810a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x057d }
            boolean r5 = r11.equals(r3)     // Catch:{ Exception -> 0x057d }
            if (r5 != 0) goto L_0x0412
            r13 = 0
            goto L_0x0413
        L_0x0412:
            r13 = r15
        L_0x0413:
            r11 = r3
            r3 = 13
            r5 = 3
            r8 = 0
            goto L_0x02bf
        L_0x041a:
            r14 = 1
        L_0x041b:
            r13 = r15
            r3 = 13
            r5 = 3
            r8 = 0
            goto L_0x02c0
        L_0x0422:
            if (r10 != 0) goto L_0x0460
            int r2 = r1.f1474O     // Catch:{ Exception -> 0x057d }
            int r3 = r1.f1473N     // Catch:{ Exception -> 0x057d }
            if (r2 < r3) goto L_0x044e
            atakplugin.UASTool.ahu r2 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            boolean r2 = r2.mo908a(r4)     // Catch:{ Exception -> 0x057d }
            if (r2 == 0) goto L_0x044e
            atakplugin.UASTool.ahu r2 = atakplugin.UASTool.ahg.m1351f()     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r3.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = "Login trials exceeds "
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            int r5 = r1.f1473N     // Catch:{ Exception -> 0x057d }
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x057d }
            r2.mo907a(r4, r3)     // Catch:{ Exception -> 0x057d }
        L_0x044e:
            if (r14 == 0) goto L_0x0458
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = "Auth cancel"
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0458:
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = "Auth fail"
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0460:
            java.net.Socket r3 = r1.f1523aw     // Catch:{ Exception -> 0x057d }
            if (r3 == 0) goto L_0x046f
            if (r2 > 0) goto L_0x046a
            int r2 = r1.f1524ax     // Catch:{ Exception -> 0x057d }
            if (r2 <= 0) goto L_0x046f
        L_0x046a:
            int r2 = r1.f1524ax     // Catch:{ Exception -> 0x057d }
            r3.setSoTimeout(r2)     // Catch:{ Exception -> 0x057d }
        L_0x046f:
            r1.f1526az = r4     // Catch:{ Exception -> 0x057d }
            java.lang.Object r2 = r1.f1486aB     // Catch:{ Exception -> 0x057d }
            monitor-enter(r2)     // Catch:{ Exception -> 0x057d }
            boolean r3 = r1.f1525ay     // Catch:{ all -> 0x04b4 }
            if (r3 == 0) goto L_0x04ab
            java.lang.Thread r3 = new java.lang.Thread     // Catch:{ all -> 0x04b4 }
            r3.<init>(r1)     // Catch:{ all -> 0x04b4 }
            r1.f1485aA = r3     // Catch:{ all -> 0x04b4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x04b4 }
            r5.<init>()     // Catch:{ all -> 0x04b4 }
            java.lang.String r8 = "Connect thread "
            r5.append(r8)     // Catch:{ all -> 0x04b4 }
            java.lang.String r8 = r1.f1475P     // Catch:{ all -> 0x04b4 }
            r5.append(r8)     // Catch:{ all -> 0x04b4 }
            java.lang.String r8 = " session"
            r5.append(r8)     // Catch:{ all -> 0x04b4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x04b4 }
            r3.setName(r5)     // Catch:{ all -> 0x04b4 }
            boolean r3 = r1.f1472M     // Catch:{ all -> 0x04b4 }
            if (r3 == 0) goto L_0x04a3
            java.lang.Thread r5 = r1.f1485aA     // Catch:{ all -> 0x04b4 }
            r5.setDaemon(r3)     // Catch:{ all -> 0x04b4 }
        L_0x04a3:
            java.lang.Thread r3 = r1.f1485aA     // Catch:{ all -> 0x04b4 }
            r3.start()     // Catch:{ all -> 0x04b4 }
            r16.m1628A()     // Catch:{ all -> 0x04b4 }
        L_0x04ab:
            monitor-exit(r2)     // Catch:{ all -> 0x04b4 }
            byte[] r2 = r1.f1479T
            atakplugin.UASTool.aji.m1822d((byte[]) r2)
            r1.f1479T = r6
            return
        L_0x04b4:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)     // Catch:{ all -> 0x04b4 }
            throw r3     // Catch:{ Exception -> 0x057d }
        L_0x04b8:
            r0 = move-exception
            r2 = r0
            atakplugin.UASTool.ahj r3 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x057d }
            r3.<init>(r5, r2)     // Catch:{ Exception -> 0x057d }
            throw r3     // Catch:{ Exception -> 0x057d }
        L_0x04c4:
            r0 = move-exception
            r2 = r0
            atakplugin.UASTool.ahj r3 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r5.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r8 = "MaxAuthTries: "
            r5.append(r8)     // Catch:{ Exception -> 0x057d }
            java.lang.String r8 = "MaxAuthTries"
            java.lang.String r8 = r1.mo1083i(r8)     // Catch:{ Exception -> 0x057d }
            r5.append(r8)     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x057d }
            r3.<init>(r5, r2)     // Catch:{ Exception -> 0x057d }
            throw r3     // Catch:{ Exception -> 0x057d }
        L_0x04e3:
            r2 = 0
            r1.f1496aL = r2     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r3.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = "invalid protocol(newkyes): "
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r5 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte r5 = r5.mo647n()     // Catch:{ Exception -> 0x057d }
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x057d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0503:
            r0 = move-exception
            r2 = r0
            r3 = 0
            r1.f1496aL = r3     // Catch:{ Exception -> 0x0509 }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0509:
            r0 = move-exception
            r2 = r0
            goto L_0x0580
        L_0x050c:
            r2 = 0
            r1.f1496aL = r2     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r3.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = "verify: "
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            r3.append(r10)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x057d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0526:
            r2 = 0
            r1.f1496aL = r2     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r3.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = "invalid protocol(kex): "
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r5 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte r5 = r5.mo647n()     // Catch:{ Exception -> 0x057d }
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x057d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0546:
            r2 = 0
            r1.f1496aL = r2     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x057d }
            r3.<init>()     // Catch:{ Exception -> 0x057d }
            java.lang.String r5 = "invalid protocol: "
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            atakplugin.UASTool.afx r5 = r1.f1469I     // Catch:{ Exception -> 0x057d }
            byte r5 = r5.mo647n()     // Catch:{ Exception -> 0x057d }
            r3.append(r5)     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x057d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0566:
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = "invalid server's version string"
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x056e:
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x057d }
            java.lang.String r3 = "connection is closed by foreign host"
            r2.<init>(r3)     // Catch:{ Exception -> 0x057d }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x0576:
            r0 = move-exception
            r2 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x0576 }
            throw r2     // Catch:{ Exception -> 0x057d }
        L_0x057a:
            r0 = move-exception
            r2 = r0
            goto L_0x05ed
        L_0x057d:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x0580:
            r1.f1496aL = r3     // Catch:{ all -> 0x057a }
            boolean r3 = r1.f1525ay     // Catch:{ Exception -> 0x05c2 }
            if (r3 == 0) goto L_0x05c2
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x05c2 }
            atakplugin.UASTool.ahy r5 = r1.f1470J     // Catch:{ Exception -> 0x05c2 }
            r5.mo996a()     // Catch:{ Exception -> 0x05c2 }
            atakplugin.UASTool.afx r5 = r1.f1469I     // Catch:{ Exception -> 0x05c2 }
            int r8 = r3.length()     // Catch:{ Exception -> 0x05c2 }
            r9 = 13
            int r8 = r8 + r9
            int r8 = r8 + r7
            int r8 = r8 + 84
            r5.mo639f(r8)     // Catch:{ Exception -> 0x05c2 }
            atakplugin.UASTool.afx r5 = r1.f1469I     // Catch:{ Exception -> 0x05c2 }
            r5.mo618a((byte) r4)     // Catch:{ Exception -> 0x05c2 }
            atakplugin.UASTool.afx r4 = r1.f1469I     // Catch:{ Exception -> 0x05c2 }
            r5 = 3
            r4.mo619a((int) r5)     // Catch:{ Exception -> 0x05c2 }
            atakplugin.UASTool.afx r4 = r1.f1469I     // Catch:{ Exception -> 0x05c2 }
            byte[] r3 = atakplugin.UASTool.aji.m1820c((java.lang.String) r3)     // Catch:{ Exception -> 0x05c2 }
            r4.mo627b((byte[]) r3)     // Catch:{ Exception -> 0x05c2 }
            atakplugin.UASTool.afx r3 = r1.f1469I     // Catch:{ Exception -> 0x05c2 }
            java.lang.String r4 = "en"
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)     // Catch:{ Exception -> 0x05c2 }
            r3.mo627b((byte[]) r4)     // Catch:{ Exception -> 0x05c2 }
            atakplugin.UASTool.ahy r3 = r1.f1470J     // Catch:{ Exception -> 0x05c2 }
            r1.mo1061b((atakplugin.UASTool.ahy) r3)     // Catch:{ Exception -> 0x05c2 }
        L_0x05c2:
            r16.mo1067d()     // Catch:{ Exception -> 0x05c5 }
        L_0x05c5:
            r3 = 0
            r1.f1525ay = r3     // Catch:{ all -> 0x057a }
            boolean r3 = r2 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x057a }
            if (r3 != 0) goto L_0x05ea
            boolean r3 = r2 instanceof atakplugin.UASTool.ahj     // Catch:{ all -> 0x057a }
            if (r3 == 0) goto L_0x05d3
            atakplugin.UASTool.ahj r2 = (atakplugin.UASTool.ahj) r2     // Catch:{ all -> 0x057a }
            throw r2     // Catch:{ all -> 0x057a }
        L_0x05d3:
            atakplugin.UASTool.ahj r3 = new atakplugin.UASTool.ahj     // Catch:{ all -> 0x057a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x057a }
            r4.<init>()     // Catch:{ all -> 0x057a }
            java.lang.String r5 = "Session.connect: "
            r4.append(r5)     // Catch:{ all -> 0x057a }
            r4.append(r2)     // Catch:{ all -> 0x057a }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x057a }
            r3.<init>(r2)     // Catch:{ all -> 0x057a }
            throw r3     // Catch:{ all -> 0x057a }
        L_0x05ea:
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ all -> 0x057a }
            throw r2     // Catch:{ all -> 0x057a }
        L_0x05ed:
            byte[] r3 = r1.f1479T
            atakplugin.UASTool.aji.m1822d((byte[]) r3)
            r1.f1479T = r6
            throw r2
        L_0x05f5:
            atakplugin.UASTool.ahj r2 = new atakplugin.UASTool.ahj
            java.lang.String r3 = "session is already connected"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.air.mo1034a(int):void");
    }

    /* renamed from: b */
    private ahl m1637b(afx afx) {
        int d = afx.mo633d();
        if (d != afx.mo617a()) {
            afx.mo640g();
            this.f1503ac = new byte[(afx.f889c - 5)];
        } else {
            this.f1503ac = new byte[((d - 1) - afx.mo640g())];
        }
        byte[] bArr = afx.f888b;
        int i = afx.f890d;
        byte[] bArr2 = this.f1503ac;
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        if (!this.f1496aL) {
            m1646x();
        }
        String[] a = ahl.m1379a(this.f1503ac, this.f1502ab);
        this.f1464C = a;
        if (a == null) {
            throw new ahj("Algorithm negotiation fail");
        } else if (this.f1526az || (!a[2].equals("none") && !this.f1464C[3].equals("none"))) {
            try {
                ahl ahl = (ahl) Class.forName(mo1083i(this.f1464C[0])).newInstance();
                ahl.mo824a(this, this.f1484Z, this.f1501aa, this.f1503ac, this.f1502ab);
                return ahl;
            } catch (Exception e) {
                throw new ahj(e.toString(), e);
            }
        } else {
            throw new ahj("NONE Cipher should not be chosen before authentification is successed.");
        }
    }

    /* renamed from: b */
    public void mo1058b() {
        m1646x();
    }

    /* renamed from: x */
    private void m1646x() {
        if (!this.f1496aL) {
            String i = mo1083i("cipher.c2s");
            String i2 = mo1083i("cipher.s2c");
            String[] p = m1644p(mo1083i("CheckCiphers"));
            if (p != null && p.length > 0) {
                i = aji.m1802a(i, p);
                i2 = aji.m1802a(i2, p);
                if (i == null || i2 == null) {
                    throw new ahj("There are not any available ciphers.");
                }
            }
            String i3 = mo1083i("kex");
            String[] q = m1645q(mo1083i("CheckKexes"));
            if (q == null || q.length <= 0 || (i3 = aji.m1802a(i3, q)) != null) {
                this.f1496aL = true;
                this.f1495aK = System.currentTimeMillis();
                afx afx = new afx();
                ahy ahy = new ahy(afx);
                ahy.mo996a();
                afx.mo618a((byte) Ascii.DC4);
                synchronized (f1433H) {
                    f1433H.mo1012a(afx.f888b, afx.f889c, 16);
                    afx.mo626b(16);
                }
                afx.mo627b(aji.m1820c(i3));
                afx.mo627b(aji.m1820c(mo1083i("server_host_key")));
                afx.mo627b(aji.m1820c(i));
                afx.mo627b(aji.m1820c(i2));
                afx.mo627b(aji.m1820c(mo1083i("mac.c2s")));
                afx.mo627b(aji.m1820c(mo1083i("mac.s2c")));
                afx.mo627b(aji.m1820c(mo1083i("compression.c2s")));
                afx.mo627b(aji.m1820c(mo1083i("compression.s2c")));
                afx.mo627b(aji.m1820c(mo1083i("lang.c2s")));
                afx.mo627b(aji.m1820c(mo1083i("lang.s2c")));
                afx.mo618a((byte) 0);
                afx.mo619a(0);
                afx.mo634d(5);
                byte[] bArr = new byte[afx.mo617a()];
                this.f1502ab = bArr;
                afx.mo635d(bArr);
                mo1061b(ahy);
                if (ahg.m1351f().mo908a(1)) {
                    ahg.m1351f().mo907a(1, "SSH_MSG_KEXINIT sent");
                    return;
                }
                return;
            }
            throw new ahj("There are not any available kexes.");
        }
    }

    /* renamed from: y */
    private void m1647y() {
        this.f1470J.mo996a();
        this.f1469I.mo618a((byte) Ascii.NAK);
        mo1061b(this.f1470J);
        if (ahg.m1351f().mo908a(1)) {
            ahg.m1351f().mo907a(1, "SSH_MSG_NEWKEYS sent");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0105  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1634a(java.lang.String r11, int r12, atakplugin.UASTool.ahl r13) {
        /*
            r10 = this;
            java.lang.String r0 = "StrictHostKeyChecking"
            java.lang.String r0 = r10.mo1083i(r0)
            java.lang.String r1 = r10.f1490aF
            if (r1 == 0) goto L_0x000b
            r11 = r1
        L_0x000b:
            byte[] r1 = r13.mo917g()
            java.lang.String r2 = r13.mo823a()
            java.lang.String r13 = r13.mo913c()
            java.lang.String r3 = r10.f1490aF
            if (r3 != 0) goto L_0x0038
            r3 = 22
            if (r12 == r3) goto L_0x0038
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "["
            r3.append(r4)
            r3.append(r11)
            java.lang.String r11 = "]:"
            r3.append(r11)
            r3.append(r12)
            java.lang.String r11 = r3.toString()
        L_0x0038:
            atakplugin.UASTool.ahb r12 = r10.mo1100w()
            java.lang.String r3 = "HashKnownHosts"
            java.lang.String r3 = r10.mo1083i(r3)
            java.lang.String r4 = "yes"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0058
            boolean r3 = r12 instanceof atakplugin.UASTool.ahs
            if (r3 == 0) goto L_0x0058
            r3 = r12
            atakplugin.UASTool.ahs r3 = (atakplugin.UASTool.ahs) r3
            atakplugin.UASTool.aha r3 = r3.mo980b((java.lang.String) r11, (byte[]) r1)
            r10.f1500aR = r3
            goto L_0x005f
        L_0x0058:
            atakplugin.UASTool.aha r3 = new atakplugin.UASTool.aha
            r3.<init>(r11, r1)
            r10.f1500aR = r3
        L_0x005f:
            monitor-enter(r12)
            int r3 = r12.mo846a((java.lang.String) r11, (byte[]) r1)     // Catch:{ all -> 0x031c }
            monitor-exit(r12)     // Catch:{ all -> 0x031c }
            java.lang.String r4 = "ask"
            boolean r4 = r0.equals(r4)
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 != 0) goto L_0x0078
            java.lang.String r4 = "yes"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x011f
        L_0x0078:
            if (r3 != r5) goto L_0x011f
            monitor-enter(r12)
            java.lang.String r4 = r12.mo847a()     // Catch:{ all -> 0x011c }
            monitor-exit(r12)     // Catch:{ all -> 0x011c }
            if (r4 != 0) goto L_0x0084
            java.lang.String r4 = "known_hosts"
        L_0x0084:
            atakplugin.UASTool.ajh r8 = r10.f1489aE
            if (r8 == 0) goto L_0x00ea
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!\nIT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!\nSomeone could be eavesdropping on you right now (man-in-the-middle attack)!\nIt is also possible that the "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r9 = " host key has just been changed.\n"
            r8.append(r9)
            java.lang.String r9 = "The fingerprint for the "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r9 = " key sent by the remote host is\n"
            r8.append(r9)
            r8.append(r13)
            java.lang.String r9 = ".\n"
            r8.append(r9)
            java.lang.String r9 = "Please contact your system administrator.\n"
            r8.append(r9)
            java.lang.String r9 = "Add correct host key in "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r4 = " to get rid of this message."
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            java.lang.String r8 = "ask"
            boolean r8 = r0.equals(r8)
            if (r8 == 0) goto L_0x00e5
            atakplugin.UASTool.ajh r8 = r10.f1489aE
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            java.lang.String r4 = "\nDo you want to delete the old key and insert the new key?"
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            boolean r4 = r8.mo1173c(r4)
            goto L_0x00eb
        L_0x00e5:
            atakplugin.UASTool.ajh r8 = r10.f1489aE
            r8.mo1174d(r4)
        L_0x00ea:
            r4 = 0
        L_0x00eb:
            if (r4 == 0) goto L_0x0105
            monitor-enter(r12)
            java.lang.String r4 = "DSA"
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0102 }
            if (r4 == 0) goto L_0x00f9
            java.lang.String r4 = "ssh-dss"
            goto L_0x00fb
        L_0x00f9:
            java.lang.String r4 = "ssh-rsa"
        L_0x00fb:
            r8 = 0
            r12.mo850a(r11, r4, r8)     // Catch:{ all -> 0x0102 }
            monitor-exit(r12)     // Catch:{ all -> 0x0102 }
            r4 = 1
            goto L_0x0120
        L_0x0102:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0102 }
            throw r11
        L_0x0105:
            atakplugin.UASTool.ahj r12 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "HostKey has been changed: "
            r13.append(r0)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.<init>(r11)
            throw r12
        L_0x011c:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x011c }
            throw r11
        L_0x011f:
            r4 = 0
        L_0x0120:
            java.lang.String r8 = "ask"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0130
            java.lang.String r8 = "yes"
            boolean r8 = r0.equals(r8)
            if (r8 == 0) goto L_0x01eb
        L_0x0130:
            if (r3 == 0) goto L_0x01eb
            if (r4 != 0) goto L_0x01eb
            java.lang.String r4 = "yes"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x01d2
            atakplugin.UASTool.ajh r4 = r10.f1489aE
            if (r4 == 0) goto L_0x018e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "The authenticity of host '"
            r8.append(r9)
            java.lang.String r9 = r10.f1475P
            r8.append(r9)
            java.lang.String r9 = "' can't be established.\n"
            r8.append(r9)
            r8.append(r2)
            java.lang.String r9 = " key fingerprint is "
            r8.append(r9)
            r8.append(r13)
            java.lang.String r13 = ".\n"
            r8.append(r13)
            java.lang.String r13 = "Are you sure you want to continue connecting?"
            r8.append(r13)
            java.lang.String r13 = r8.toString()
            boolean r13 = r4.mo1173c(r13)
            if (r13 == 0) goto L_0x0175
            r4 = 1
            goto L_0x01eb
        L_0x0175:
            atakplugin.UASTool.ahj r11 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "reject HostKey: "
            r12.append(r13)
            java.lang.String r13 = r10.f1475P
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x018e:
            if (r3 != r7) goto L_0x01b9
            atakplugin.UASTool.ahj r11 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "UnknownHostKey: "
            r12.append(r0)
            java.lang.String r0 = r10.f1475P
            r12.append(r0)
            java.lang.String r0 = ". "
            r12.append(r0)
            r12.append(r2)
            java.lang.String r0 = " key fingerprint is "
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x01b9:
            atakplugin.UASTool.ahj r11 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "HostKey has been changed: "
            r12.append(r13)
            java.lang.String r13 = r10.f1475P
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x01d2:
            atakplugin.UASTool.ahj r11 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "reject HostKey: "
            r12.append(r13)
            java.lang.String r13 = r10.f1475P
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x01eb:
            java.lang.String r13 = "no"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x01f6
            if (r7 != r3) goto L_0x01f6
            r4 = 1
        L_0x01f6:
            if (r3 != 0) goto L_0x02a6
            java.lang.String r13 = "DSA"
            boolean r13 = r2.equals(r13)
            if (r13 == 0) goto L_0x0203
            java.lang.String r13 = "ssh-dss"
            goto L_0x0205
        L_0x0203:
            java.lang.String r13 = "ssh-rsa"
        L_0x0205:
            atakplugin.UASTool.aha[] r11 = r12.mo852b(r11, r13)
            int r13 = r1.length
            byte[] r13 = atakplugin.UASTool.aji.m1817b(r1, r6, r13)
            java.lang.String r13 = atakplugin.UASTool.aji.m1813b((byte[]) r13)
        L_0x0212:
            int r0 = r11.length
            if (r6 >= r0) goto L_0x02a6
            r0 = r11[r3]
            java.lang.String r0 = r0.mo843c()
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x02a2
            r0 = r11[r6]
            java.lang.String r0 = r0.mo845e()
            java.lang.String r1 = "@revoked"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x02a2
            atakplugin.UASTool.ajh r11 = r10.f1489aE
            if (r11 == 0) goto L_0x0260
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "The "
            r12.append(r13)
            r12.append(r2)
            java.lang.String r13 = " host key for "
            r12.append(r13)
            java.lang.String r13 = r10.f1475P
            r12.append(r13)
            java.lang.String r13 = " is marked as revoked.\n"
            r12.append(r13)
            java.lang.String r13 = "This could mean that a stolen key is being used to "
            r12.append(r13)
            java.lang.String r13 = "impersonate this host."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.mo1174d(r12)
        L_0x0260:
            atakplugin.UASTool.ahu r11 = atakplugin.UASTool.ahg.m1351f()
            boolean r11 = r11.mo908a(r7)
            if (r11 == 0) goto L_0x0289
            atakplugin.UASTool.ahu r11 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Host '"
            r12.append(r13)
            java.lang.String r13 = r10.f1475P
            r12.append(r13)
            java.lang.String r13 = "' has provided revoked key."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.mo907a(r7, r12)
        L_0x0289:
            atakplugin.UASTool.ahj r11 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "revoked HostKey: "
            r12.append(r13)
            java.lang.String r13 = r10.f1475P
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x02a2:
            int r6 = r6 + 1
            goto L_0x0212
        L_0x02a6:
            if (r3 != 0) goto L_0x02d9
            atakplugin.UASTool.ahu r11 = atakplugin.UASTool.ahg.m1351f()
            boolean r11 = r11.mo908a(r7)
            if (r11 == 0) goto L_0x02d9
            atakplugin.UASTool.ahu r11 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Host '"
            r13.append(r0)
            java.lang.String r0 = r10.f1475P
            r13.append(r0)
            java.lang.String r0 = "' is known and mathces the "
            r13.append(r0)
            r13.append(r2)
            java.lang.String r0 = " host key"
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r11.mo907a(r7, r13)
        L_0x02d9:
            if (r4 == 0) goto L_0x030c
            atakplugin.UASTool.ahu r11 = atakplugin.UASTool.ahg.m1351f()
            boolean r11 = r11.mo908a(r5)
            if (r11 == 0) goto L_0x030c
            atakplugin.UASTool.ahu r11 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Permanently added '"
            r13.append(r0)
            java.lang.String r0 = r10.f1475P
            r13.append(r0)
            java.lang.String r0 = "' ("
            r13.append(r0)
            r13.append(r2)
            java.lang.String r0 = ") to the list of known hosts."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r11.mo907a(r5, r13)
        L_0x030c:
            if (r4 == 0) goto L_0x031b
            monitor-enter(r12)
            atakplugin.UASTool.aha r11 = r10.f1500aR     // Catch:{ all -> 0x0318 }
            atakplugin.UASTool.ajh r13 = r10.f1489aE     // Catch:{ all -> 0x0318 }
            r12.mo848a((atakplugin.UASTool.aha) r11, (atakplugin.UASTool.ajh) r13)     // Catch:{ all -> 0x0318 }
            monitor-exit(r12)     // Catch:{ all -> 0x0318 }
            goto L_0x031b
        L_0x0318:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0318 }
            throw r11
        L_0x031b:
            return
        L_0x031c:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x031c }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.air.m1634a(java.lang.String, int, atakplugin.UASTool.ahl):void");
    }

    /* renamed from: a */
    public afy mo1032a(String str) {
        if (this.f1525ay) {
            try {
                afy a = afy.m930a(str);
                mo1038a(a);
                a.mo659b();
                if (a instanceof age) {
                    m1631a((age) a);
                }
                return a;
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new ahj("session is down");
        }
    }

    /* renamed from: a */
    public void mo1041a(ahy ahy) {
        if (this.f1520at != null) {
            this.f1482W[0] = ahy.f1376a.f889c;
            ahy.f1376a.f888b = this.f1520at.mo809a(ahy.f1376a.f888b, 5, this.f1482W);
            ahy.f1376a.f889c = this.f1482W[0];
        }
        if (this.f1515ao != null) {
            ahy.mo998a(this.f1498aN);
            byte b = ahy.f1376a.f888b[4];
            synchronized (f1433H) {
                f1433H.mo1012a(ahy.f1376a.f888b, ahy.f1376a.f889c - b, b);
            }
        } else {
            ahy.mo998a(8);
        }
        ahv ahv = this.f1517aq;
        if (ahv != null) {
            ahv.mo989a(this.f1513am);
            this.f1517aq.mo992a(ahy.f1376a.f888b, 0, ahy.f1376a.f889c);
            this.f1517aq.mo991a(ahy.f1376a.f888b, ahy.f1376a.f889c);
        }
        if (this.f1515ao != null) {
            byte[] bArr = ahy.f1376a.f888b;
            this.f1515ao.mo805a(bArr, 0, ahy.f1376a.f889c, bArr, 0);
        }
        if (this.f1517aq != null) {
            ahy.f1376a.mo626b(this.f1517aq.mo993b());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f8 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public atakplugin.UASTool.afx mo1031a(atakplugin.UASTool.afx r22) {
        /*
            r21 = this;
            r6 = r21
            r7 = r22
        L_0x0004:
            r22.mo644k()
            atakplugin.UASTool.ahc r0 = r6.f1522av
            byte[] r1 = r7.f888b
            int r2 = r7.f889c
            int r3 = r6.f1497aM
            r0.mo866c(r1, r2, r3)
            int r0 = r7.f889c
            int r1 = r6.f1497aM
            int r0 = r0 + r1
            r7.f889c = r0
            atakplugin.UASTool.agm r8 = r6.f1514an
            if (r8 == 0) goto L_0x0028
            byte[] r9 = r7.f888b
            r10 = 0
            int r11 = r6.f1497aM
            byte[] r12 = r7.f888b
            r13 = 0
            r8.mo805a(r9, r10, r11, r12, r13)
        L_0x0028:
            byte[] r0 = r7.f888b
            r8 = 0
            byte r0 = r0[r8]
            int r0 = r0 << 24
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r1
            byte[] r1 = r7.f888b
            r9 = 1
            byte r1 = r1[r9]
            int r1 = r1 << 16
            r2 = 16711680(0xff0000, float:2.3418052E-38)
            r1 = r1 & r2
            r0 = r0 | r1
            byte[] r1 = r7.f888b
            r10 = 2
            byte r1 = r1[r10]
            int r1 = r1 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            byte[] r1 = r7.f888b
            r11 = 3
            byte r1 = r1[r11]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r12 = r0 | r1
            r13 = 262144(0x40000, float:3.67342E-40)
            r14 = 5
            if (r12 < r14) goto L_0x0059
            if (r12 <= r13) goto L_0x0067
        L_0x0059:
            atakplugin.UASTool.agm r2 = r6.f1514an
            atakplugin.UASTool.ahv r3 = r6.f1516ap
            r5 = 262144(0x40000, float:3.67342E-40)
            r0 = r21
            r1 = r22
            r4 = r12
            r0.m1629a((atakplugin.UASTool.afx) r1, (atakplugin.UASTool.agm) r2, (atakplugin.UASTool.ahv) r3, (int) r4, (int) r5)
        L_0x0067:
            int r0 = r12 + 4
            int r1 = r6.f1497aM
            int r15 = r0 - r1
            int r0 = r7.f889c
            int r0 = r0 + r15
            byte[] r1 = r7.f888b
            int r1 = r1.length
            if (r0 <= r1) goto L_0x0083
            int r0 = r7.f889c
            int r0 = r0 + r15
            byte[] r0 = new byte[r0]
            byte[] r1 = r7.f888b
            int r2 = r7.f889c
            java.lang.System.arraycopy(r1, r8, r0, r8, r2)
            r7.f888b = r0
        L_0x0083:
            int r0 = r6.f1497aM
            int r0 = r15 % r0
            r5 = 4
            if (r0 == 0) goto L_0x00c0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Bad packet length "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            atakplugin.UASTool.ahu r1 = atakplugin.UASTool.ahg.m1351f()
            boolean r1 = r1.mo908a(r5)
            if (r1 == 0) goto L_0x00ac
            atakplugin.UASTool.ahu r1 = atakplugin.UASTool.ahg.m1351f()
            r1.mo907a(r5, r0)
        L_0x00ac:
            atakplugin.UASTool.agm r2 = r6.f1514an
            atakplugin.UASTool.ahv r3 = r6.f1516ap
            int r0 = r6.f1497aM
            int r16 = r13 - r0
            r0 = r21
            r1 = r22
            r4 = r12
            r11 = 4
            r5 = r16
            r0.m1629a((atakplugin.UASTool.afx) r1, (atakplugin.UASTool.agm) r2, (atakplugin.UASTool.ahv) r3, (int) r4, (int) r5)
            goto L_0x00c1
        L_0x00c0:
            r11 = 4
        L_0x00c1:
            if (r15 <= 0) goto L_0x00ed
            atakplugin.UASTool.ahc r0 = r6.f1522av
            byte[] r1 = r7.f888b
            int r2 = r7.f889c
            r0.mo866c(r1, r2, r15)
            int r0 = r7.f889c
            int r0 = r0 + r15
            r7.f889c = r0
            atakplugin.UASTool.agm r0 = r6.f1514an
            if (r0 == 0) goto L_0x00ed
            byte[] r1 = r7.f888b
            int r2 = r6.f1497aM
            byte[] r3 = r7.f888b
            int r4 = r6.f1497aM
            r5 = r15
            r15 = r0
            r16 = r1
            r17 = r2
            r18 = r5
            r19 = r3
            r20 = r4
            r15.mo805a(r16, r17, r18, r19, r20)
            goto L_0x00ee
        L_0x00ed:
            r5 = r15
        L_0x00ee:
            atakplugin.UASTool.ahv r0 = r6.f1516ap
            if (r0 == 0) goto L_0x0133
            int r1 = r6.f1512al
            r0.mo989a((int) r1)
            atakplugin.UASTool.ahv r0 = r6.f1516ap
            byte[] r1 = r7.f888b
            int r2 = r7.f889c
            r0.mo992a(r1, r8, r2)
            atakplugin.UASTool.ahv r0 = r6.f1516ap
            byte[] r1 = r6.f1518ar
            r0.mo991a(r1, r8)
            atakplugin.UASTool.ahc r0 = r6.f1522av
            byte[] r1 = r6.f1519as
            int r2 = r1.length
            r0.mo866c(r1, r8, r2)
            byte[] r0 = r6.f1518ar
            byte[] r1 = r6.f1519as
            boolean r0 = java.util.Arrays.equals(r0, r1)
            if (r0 != 0) goto L_0x0133
            if (r5 > r13) goto L_0x012b
            atakplugin.UASTool.agm r2 = r6.f1514an
            atakplugin.UASTool.ahv r3 = r6.f1516ap
            int r5 = r13 - r5
            r0 = r21
            r1 = r22
            r4 = r12
            r0.m1629a((atakplugin.UASTool.afx) r1, (atakplugin.UASTool.agm) r2, (atakplugin.UASTool.ahv) r3, (int) r4, (int) r5)
            goto L_0x0004
        L_0x012b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "MAC Error"
            r0.<init>(r1)
            throw r0
        L_0x0133:
            int r0 = r6.f1512al
            int r0 = r0 + r9
            r6.f1512al = r0
            atakplugin.UASTool.ago r0 = r6.f1521au
            if (r0 == 0) goto L_0x0167
            byte[] r0 = r7.f888b
            byte r0 = r0[r11]
            int[] r1 = r6.f1481V
            int r2 = r7.f889c
            int r2 = r2 - r14
            int r2 = r2 - r0
            r1[r8] = r2
            atakplugin.UASTool.ago r0 = r6.f1521au
            byte[] r1 = r7.f888b
            int[] r2 = r6.f1481V
            byte[] r0 = r0.mo810b(r1, r14, r2)
            if (r0 == 0) goto L_0x015e
            r7.f888b = r0
            int[] r0 = r6.f1481V
            r0 = r0[r8]
            int r0 = r0 + r14
            r7.f889c = r0
            goto L_0x0167
        L_0x015e:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.String r1 = "fail in inflater"
            r0.println(r1)
            goto L_0x01f4
        L_0x0167:
            byte r0 = r22.mo647n()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == r9) goto L_0x01f8
            if (r0 != r10) goto L_0x0173
            goto L_0x0004
        L_0x0173:
            r1 = 3
            if (r0 != r1) goto L_0x01a7
            r22.mo646m()
            r22.mo633d()
            r22.mo638f()
            int r0 = r22.mo633d()
            atakplugin.UASTool.ahu r1 = atakplugin.UASTool.ahg.m1351f()
            boolean r1 = r1.mo908a(r9)
            if (r1 == 0) goto L_0x0004
            atakplugin.UASTool.ahu r1 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Received SSH_MSG_UNIMPLEMENTED for "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.mo907a(r9, r0)
            goto L_0x0004
        L_0x01a7:
            if (r0 != r11) goto L_0x01b4
            r22.mo646m()
            r22.mo633d()
            r22.mo638f()
            goto L_0x0004
        L_0x01b4:
            r1 = 93
            if (r0 != r1) goto L_0x01d6
            r22.mo646m()
            r22.mo633d()
            r22.mo638f()
            int r0 = r22.mo633d()
            atakplugin.UASTool.afy r0 = atakplugin.UASTool.afy.m929a((int) r0, (atakplugin.UASTool.air) r6)
            if (r0 != 0) goto L_0x01cd
            goto L_0x0004
        L_0x01cd:
            long r1 = r22.mo637e()
            r0.mo661b((long) r1)
            goto L_0x0004
        L_0x01d6:
            r1 = 52
            if (r0 != r1) goto L_0x01f4
            r6.f1526az = r9
            atakplugin.UASTool.ago r0 = r6.f1521au
            if (r0 != 0) goto L_0x01f4
            atakplugin.UASTool.ago r0 = r6.f1520at
            if (r0 != 0) goto L_0x01f4
            java.lang.String[] r0 = r6.f1464C
            r1 = 6
            r0 = r0[r1]
            r6.m1642n(r0)
            java.lang.String[] r0 = r6.f1464C
            r1 = 7
            r0 = r0[r1]
            r6.m1643o(r0)
        L_0x01f4:
            r22.mo646m()
            return r7
        L_0x01f8:
            r22.mo646m()
            r22.mo633d()
            r22.mo638f()
            int r0 = r22.mo633d()
            byte[] r1 = r22.mo643j()
            byte[] r2 = r22.mo643j()
            atakplugin.UASTool.ahj r3 = new atakplugin.UASTool.ahj
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "SSH_MSG_DISCONNECT: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = " "
            r4.append(r0)
            java.lang.String r1 = atakplugin.UASTool.aji.m1813b((byte[]) r1)
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = atakplugin.UASTool.aji.m1813b((byte[]) r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.air.mo1031a(atakplugin.UASTool.afx):atakplugin.UASTool.afx");
    }

    /* renamed from: a */
    private void m1629a(afx afx, agm agm, ahv ahv, int i, int i2) {
        if (agm.mo807c()) {
            if (i == 262144 || ahv == null) {
                ahv = null;
            }
            int i3 = i2 - afx.f889c;
            while (i3 > 0) {
                afx.mo644k();
                int length = i3 > afx.f888b.length ? afx.f888b.length : i3;
                this.f1522av.mo866c(afx.f888b, 0, length);
                if (ahv != null) {
                    ahv.mo992a(afx.f888b, 0, length);
                }
                i3 -= length;
            }
            if (ahv != null) {
                ahv.mo991a(afx.f888b, 0);
            }
            throw new ahj("Packet corrupt");
        }
        throw new ahj("Packet corrupt");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public byte[] mo1066c() {
        return this.f1505ae;
    }

    /* renamed from: a */
    private void m1630a(afx afx, ahl ahl) {
        m1633a(ahl);
        this.f1496aL = false;
    }

    /* renamed from: a */
    private void m1633a(ahl ahl) {
        byte[] bArr;
        byte[] d = ahl.mo914d();
        byte[] e = ahl.mo915e();
        agz f = ahl.mo916f();
        if (this.f1505ae == null) {
            byte[] bArr2 = new byte[e.length];
            this.f1505ae = bArr2;
            System.arraycopy(e, 0, bArr2, 0, e.length);
        }
        this.f1469I.mo644k();
        this.f1469I.mo631c(d);
        this.f1469I.mo621a(e);
        this.f1469I.mo618a((byte) 65);
        this.f1469I.mo621a(this.f1505ae);
        f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
        this.f1506af = f.mo837c();
        int length = (this.f1469I.f889c - this.f1505ae.length) - 1;
        byte[] bArr3 = this.f1469I.f888b;
        bArr3[length] = (byte) (bArr3[length] + 1);
        f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
        this.f1507ag = f.mo837c();
        byte[] bArr4 = this.f1469I.f888b;
        bArr4[length] = (byte) (bArr4[length] + 1);
        f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
        this.f1508ah = f.mo837c();
        byte[] bArr5 = this.f1469I.f888b;
        bArr5[length] = (byte) (bArr5[length] + 1);
        f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
        this.f1509ai = f.mo837c();
        byte[] bArr6 = this.f1469I.f888b;
        bArr6[length] = (byte) (bArr6[length] + 1);
        f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
        this.f1510aj = f.mo837c();
        byte[] bArr7 = this.f1469I.f888b;
        bArr7[length] = (byte) (bArr7[length] + 1);
        f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
        this.f1511ak = f.mo837c();
        try {
            this.f1514an = (agm) Class.forName(mo1083i(this.f1464C[3])).newInstance();
            while (true) {
                int b = this.f1514an.mo806b();
                bArr = this.f1509ai;
                if (b <= bArr.length) {
                    break;
                }
                this.f1469I.mo644k();
                this.f1469I.mo631c(d);
                this.f1469I.mo621a(e);
                this.f1469I.mo621a(this.f1509ai);
                f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
                byte[] c = f.mo837c();
                byte[] bArr8 = this.f1509ai;
                byte[] bArr9 = new byte[(bArr8.length + c.length)];
                System.arraycopy(bArr8, 0, bArr9, 0, bArr8.length);
                System.arraycopy(c, 0, bArr9, this.f1509ai.length, c.length);
                this.f1509ai = bArr9;
            }
            this.f1514an.mo804a(1, bArr, this.f1507ag);
            this.f1497aM = this.f1514an.mo803a();
            ahv ahv = (ahv) Class.forName(mo1083i(this.f1464C[5])).newInstance();
            this.f1516ap = ahv;
            byte[] a = m1636a(this.f1469I, d, e, this.f1511ak, f, ahv.mo993b());
            this.f1511ak = a;
            this.f1516ap.mo990a(a);
            this.f1518ar = new byte[this.f1516ap.mo993b()];
            this.f1519as = new byte[this.f1516ap.mo993b()];
            this.f1515ao = (agm) Class.forName(mo1083i(this.f1464C[2])).newInstance();
            while (true) {
                int b2 = this.f1515ao.mo806b();
                byte[] bArr10 = this.f1508ah;
                if (b2 > bArr10.length) {
                    this.f1469I.mo644k();
                    this.f1469I.mo631c(d);
                    this.f1469I.mo621a(e);
                    this.f1469I.mo621a(this.f1508ah);
                    f.mo835a(this.f1469I.f888b, 0, this.f1469I.f889c);
                    byte[] c2 = f.mo837c();
                    byte[] bArr11 = this.f1508ah;
                    byte[] bArr12 = new byte[(bArr11.length + c2.length)];
                    System.arraycopy(bArr11, 0, bArr12, 0, bArr11.length);
                    System.arraycopy(c2, 0, bArr12, this.f1508ah.length, c2.length);
                    this.f1508ah = bArr12;
                } else {
                    this.f1515ao.mo804a(0, bArr10, this.f1506af);
                    this.f1498aN = this.f1515ao.mo803a();
                    ahv ahv2 = (ahv) Class.forName(mo1083i(this.f1464C[4])).newInstance();
                    this.f1517aq = ahv2;
                    byte[] a2 = m1636a(this.f1469I, d, e, this.f1510aj, f, ahv2.mo993b());
                    this.f1510aj = a2;
                    this.f1517aq.mo990a(a2);
                    m1642n(this.f1464C[6]);
                    m1643o(this.f1464C[7]);
                    return;
                }
            }
        } catch (Exception e2) {
            if (e2 instanceof ahj) {
                throw e2;
            }
            throw new ahj(e2.toString(), e2);
        }
    }

    /* renamed from: a */
    private byte[] m1636a(afx afx, byte[] bArr, byte[] bArr2, byte[] bArr3, agz agz, int i) {
        int b = agz.mo836b();
        while (bArr3.length < i) {
            afx.mo644k();
            afx.mo631c(bArr);
            afx.mo621a(bArr2);
            afx.mo621a(bArr3);
            agz.mo835a(afx.f888b, 0, afx.f889c);
            byte[] bArr4 = new byte[(bArr3.length + b)];
            System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            System.arraycopy(agz.mo837c(), 0, bArr4, bArr3.length, b);
            aji.m1822d(bArr3);
            bArr3 = bArr4;
        }
        return bArr3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX WARNING: type inference failed for: r15v10, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00ca, code lost:
        m1638c(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00cd, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00de, code lost:
        throw new java.io.IOException("channel is broken");
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1042a(atakplugin.UASTool.ahy r13, atakplugin.UASTool.afy r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.mo1082i()
            long r0 = (long) r0
        L_0x0005:
            boolean r2 = r12.f1496aL
            r3 = 0
            if (r2 == 0) goto L_0x002b
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0023
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r12.f1495aK
            long r2 = r2 - r4
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            atakplugin.UASTool.ahj r13 = new atakplugin.UASTool.ahj
            java.lang.String r14 = "timeout in wating for rekeying process."
            r13.<init>(r14)
            throw r13
        L_0x0023:
            r2 = 10
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0029 }
            goto L_0x0005
        L_0x0029:
            goto L_0x0005
        L_0x002b:
            monitor-enter(r14)
            long r5 = r14.f908o     // Catch:{ all -> 0x00df }
            long r7 = (long) r15
            r2 = 1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x004e
            int r5 = r14.f900A     // Catch:{ InterruptedException -> 0x004b, all -> 0x0044 }
            int r5 = r5 + r2
            r14.f900A = r5     // Catch:{ InterruptedException -> 0x004b, all -> 0x0044 }
            r5 = 100
            r14.wait(r5)     // Catch:{ InterruptedException -> 0x004b, all -> 0x0044 }
            int r5 = r14.f900A     // Catch:{ all -> 0x00df }
        L_0x0040:
            int r5 = r5 - r2
            r14.f900A = r5     // Catch:{ all -> 0x00df }
            goto L_0x004e
        L_0x0044:
            r13 = move-exception
            int r15 = r14.f900A     // Catch:{ all -> 0x00df }
            int r15 = r15 - r2
            r14.f900A = r15     // Catch:{ all -> 0x00df }
            throw r13     // Catch:{ all -> 0x00df }
        L_0x004b:
            int r5 = r14.f900A     // Catch:{ all -> 0x00df }
            goto L_0x0040
        L_0x004e:
            long r5 = r14.f908o     // Catch:{ all -> 0x00df }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x005c
            long r0 = r14.f908o     // Catch:{ all -> 0x00df }
            long r0 = r0 - r7
            r14.f908o = r0     // Catch:{ all -> 0x00df }
            monitor-exit(r14)     // Catch:{ all -> 0x00df }
            goto L_0x00ca
        L_0x005c:
            monitor-exit(r14)     // Catch:{ all -> 0x00df }
            boolean r5 = r14.f914u
            if (r5 != 0) goto L_0x00d7
            boolean r5 = r14.mo684n()
            if (r5 == 0) goto L_0x00d7
            r5 = -1
            monitor-enter(r14)
            long r9 = r14.f908o     // Catch:{ all -> 0x00d4 }
            r6 = 0
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 <= 0) goto L_0x00a7
            long r3 = r14.f908o     // Catch:{ all -> 0x00d4 }
            int r15 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r15 <= 0) goto L_0x0077
            r3 = r7
        L_0x0077:
            int r15 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r15 == 0) goto L_0x0092
            int r15 = (int) r3     // Catch:{ all -> 0x00d4 }
            atakplugin.UASTool.agm r5 = r12.f1515ao     // Catch:{ all -> 0x00d4 }
            if (r5 == 0) goto L_0x0083
            int r5 = r12.f1498aN     // Catch:{ all -> 0x00d4 }
            goto L_0x0085
        L_0x0083:
            r5 = 8
        L_0x0085:
            atakplugin.UASTool.ahv r9 = r12.f1517aq     // Catch:{ all -> 0x00d4 }
            if (r9 == 0) goto L_0x008d
            int r6 = r9.mo993b()     // Catch:{ all -> 0x00d4 }
        L_0x008d:
            int r15 = r13.mo995a(r15, r5, r6)     // Catch:{ all -> 0x00d4 }
            r6 = r15
        L_0x0092:
            atakplugin.UASTool.afx r15 = r13.f1376a     // Catch:{ all -> 0x00d4 }
            byte r15 = r15.mo647n()     // Catch:{ all -> 0x00d4 }
            int r5 = r14.mo648a()     // Catch:{ all -> 0x00d4 }
            long r7 = r7 - r3
            int r8 = (int) r7     // Catch:{ all -> 0x00d4 }
            long r9 = r14.f908o     // Catch:{ all -> 0x00d4 }
            long r9 = r9 - r3
            r14.f908o = r9     // Catch:{ all -> 0x00d4 }
            r3 = r6
            r6 = r15
            r15 = r8
            goto L_0x00a9
        L_0x00a7:
            r2 = 0
            r3 = 0
        L_0x00a9:
            monitor-exit(r14)     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x00b5
            r12.m1638c((atakplugin.UASTool.ahy) r13)
            if (r15 != 0) goto L_0x00b2
            return
        L_0x00b2:
            r13.mo997a(r6, r5, r3, r15)
        L_0x00b5:
            monitor-enter(r14)
            boolean r2 = r12.f1496aL     // Catch:{ all -> 0x00d1 }
            if (r2 == 0) goto L_0x00bd
            monitor-exit(r14)     // Catch:{ all -> 0x00d1 }
            goto L_0x0005
        L_0x00bd:
            long r2 = r14.f908o     // Catch:{ all -> 0x00d1 }
            long r4 = (long) r15     // Catch:{ all -> 0x00d1 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x00ce
            long r0 = r14.f908o     // Catch:{ all -> 0x00d1 }
            long r0 = r0 - r4
            r14.f908o = r0     // Catch:{ all -> 0x00d1 }
            monitor-exit(r14)     // Catch:{ all -> 0x00d1 }
        L_0x00ca:
            r12.m1638c((atakplugin.UASTool.ahy) r13)
            return
        L_0x00ce:
            monitor-exit(r14)     // Catch:{ all -> 0x00d1 }
            goto L_0x0005
        L_0x00d1:
            r13 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00d1 }
            throw r13
        L_0x00d4:
            r13 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00d4 }
            throw r13
        L_0x00d7:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r14 = "channel is broken"
            r13.<init>(r14)
            throw r13
        L_0x00df:
            r13 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00df }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.air.mo1042a(atakplugin.UASTool.ahy, atakplugin.UASTool.afy, int):void");
    }

    /* renamed from: b */
    public void mo1061b(ahy ahy) {
        long i = (long) mo1082i();
        while (this.f1496aL) {
            if (i <= 0 || System.currentTimeMillis() - this.f1495aK <= i) {
                byte n = ahy.f1376a.mo647n();
                if (n == 20 || n == 21 || n == 30 || n == 31 || n == 31 || n == 32 || n == 33 || n == 34 || n == 1) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException unused) {
                }
            } else {
                throw new ahj("timeout in wating for rekeying process.");
            }
        }
        m1638c(ahy);
    }

    /* renamed from: c */
    private void m1638c(ahy ahy) {
        synchronized (this.f1486aB) {
            mo1041a(ahy);
            ahc ahc = this.f1522av;
            if (ahc != null) {
                ahc.mo854a(ahy);
                this.f1513am++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r7.mo683m();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x01d2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            r13.f1483X = r13
            atakplugin.UASTool.afx r0 = new atakplugin.UASTool.afx
            r0.<init>()
            atakplugin.UASTool.ahy r1 = new atakplugin.UASTool.ahy
            r1.<init>(r0)
            r2 = 1
            int[] r3 = new int[r2]
            int[] r4 = new int[r2]
            r5 = 0
            r6 = 0
        L_0x0013:
            r8 = r5
        L_0x0014:
            r7 = 0
        L_0x0015:
            boolean r9 = r13.f1525ay     // Catch:{ Exception -> 0x0342 }
            if (r9 == 0) goto L_0x036b
            java.lang.Runnable r9 = r13.f1483X     // Catch:{ Exception -> 0x0342 }
            if (r9 == 0) goto L_0x036b
            atakplugin.UASTool.afx r0 = r13.mo1031a((atakplugin.UASTool.afx) r0)     // Catch:{ InterruptedIOException -> 0x0328 }
            byte r7 = r0.mo647n()     // Catch:{ Exception -> 0x0342 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            if (r8 == 0) goto L_0x0053
            int r9 = r8.mo826b()     // Catch:{ Exception -> 0x0342 }
            if (r9 != r7) goto L_0x0053
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0342 }
            r13.f1495aK = r9     // Catch:{ Exception -> 0x0342 }
            boolean r7 = r8.mo825a((atakplugin.UASTool.afx) r0)     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x003c
            goto L_0x0014
        L_0x003c:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ Exception -> 0x0342 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0342 }
            r1.<init>()     // Catch:{ Exception -> 0x0342 }
            java.lang.String r3 = "verify: "
            r1.append(r3)     // Catch:{ Exception -> 0x0342 }
            r1.append(r7)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0342 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0342 }
            throw r0     // Catch:{ Exception -> 0x0342 }
        L_0x0053:
            r9 = 20
            if (r7 == r9) goto L_0x0321
            r9 = 21
            if (r7 == r9) goto L_0x0319
            switch(r7) {
                case 80: goto L_0x02f8;
                case 81: goto L_0x02c6;
                case 82: goto L_0x02c6;
                default: goto L_0x005e;
            }     // Catch:{ Exception -> 0x0342 }
        L_0x005e:
            r9 = 93
            switch(r7) {
                case 90: goto L_0x023b;
                case 91: goto L_0x0212;
                case 92: goto L_0x01f2;
                case 93: goto L_0x01d7;
                case 94: goto L_0x0174;
                case 95: goto L_0x0116;
                case 96: goto L_0x0101;
                case 97: goto L_0x00ec;
                case 98: goto L_0x00a4;
                case 99: goto L_0x008e;
                case 100: goto L_0x007a;
                default: goto L_0x0063;
            }     // Catch:{ Exception -> 0x0342 }
        L_0x0063:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0342 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0342 }
            r1.<init>()     // Catch:{ Exception -> 0x0342 }
            java.lang.String r3 = "Unknown SSH message type "
            r1.append(r3)     // Catch:{ Exception -> 0x0342 }
            r1.append(r7)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0342 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0342 }
            throw r0     // Catch:{ Exception -> 0x0342 }
        L_0x007a:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            if (r7 != 0) goto L_0x008b
            goto L_0x0014
        L_0x008b:
            r7.f918y = r6     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x008e:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            if (r7 != 0) goto L_0x00a0
            goto L_0x0014
        L_0x00a0:
            r7.f918y = r2     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x00a4:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            byte[] r9 = r0.mo643j()     // Catch:{ Exception -> 0x0342 }
            int r10 = r0.mo640g()     // Catch:{ Exception -> 0x0342 }
            if (r10 == 0) goto L_0x00ba
            r10 = 1
            goto L_0x00bb
        L_0x00ba:
            r10 = 0
        L_0x00bb:
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x0014
            r11 = 100
            java.lang.String r9 = atakplugin.UASTool.aji.m1813b((byte[]) r9)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r12 = "exit-status"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x0342 }
            if (r9 == 0) goto L_0x00d8
            int r9 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r7.mo676g(r9)     // Catch:{ Exception -> 0x0342 }
            r11 = 99
        L_0x00d8:
            if (r10 == 0) goto L_0x0014
            r1.mo996a()     // Catch:{ Exception -> 0x0342 }
            r0.mo618a((byte) r11)     // Catch:{ Exception -> 0x0342 }
            int r7 = r7.mo648a()     // Catch:{ Exception -> 0x0342 }
            r0.mo619a((int) r7)     // Catch:{ Exception -> 0x0342 }
            r13.mo1061b((atakplugin.UASTool.ahy) r1)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x00ec:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x0014
            r7.mo683m()     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x0101:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x0014
            r7.mo679i()     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x0116:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            byte[] r10 = r0.mo623a((int[]) r3, (int[]) r4)     // Catch:{ Exception -> 0x0342 }
            if (r7 != 0) goto L_0x012f
            goto L_0x0014
        L_0x012f:
            r11 = r4[r6]     // Catch:{ Exception -> 0x0342 }
            if (r11 != 0) goto L_0x0135
            goto L_0x0014
        L_0x0135:
            r11 = r3[r6]     // Catch:{ Exception -> 0x0342 }
            r12 = r4[r6]     // Catch:{ Exception -> 0x0342 }
            r7.mo666b(r10, r11, r12)     // Catch:{ Exception -> 0x0342 }
            r10 = r4[r6]     // Catch:{ Exception -> 0x0342 }
            int r11 = r7.f906m     // Catch:{ Exception -> 0x0342 }
            int r11 = r11 - r10
            r7.mo670d(r11)     // Catch:{ Exception -> 0x0342 }
            int r10 = r7.f906m     // Catch:{ Exception -> 0x0342 }
            int r11 = r7.f905l     // Catch:{ Exception -> 0x0342 }
            int r11 = r11 / 2
            if (r10 >= r11) goto L_0x0014
            r1.mo996a()     // Catch:{ Exception -> 0x0342 }
            r0.mo618a((byte) r9)     // Catch:{ Exception -> 0x0342 }
            int r9 = r7.mo648a()     // Catch:{ Exception -> 0x0342 }
            r0.mo619a((int) r9)     // Catch:{ Exception -> 0x0342 }
            int r9 = r7.f905l     // Catch:{ Exception -> 0x0342 }
            int r10 = r7.f906m     // Catch:{ Exception -> 0x0342 }
            int r9 = r9 - r10
            r0.mo619a((int) r9)     // Catch:{ Exception -> 0x0342 }
            monitor-enter(r7)     // Catch:{ Exception -> 0x0342 }
            boolean r9 = r7.f914u     // Catch:{ all -> 0x0171 }
            if (r9 != 0) goto L_0x0169
            r13.mo1061b((atakplugin.UASTool.ahy) r1)     // Catch:{ all -> 0x0171 }
        L_0x0169:
            monitor-exit(r7)     // Catch:{ all -> 0x0171 }
            int r9 = r7.f905l     // Catch:{ Exception -> 0x0342 }
            r7.mo670d(r9)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x0171:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0171 }
            throw r0     // Catch:{ Exception -> 0x0342 }
        L_0x0174:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo640g()     // Catch:{ Exception -> 0x0342 }
            r0.mo640g()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            byte[] r10 = r0.mo623a((int[]) r3, (int[]) r4)     // Catch:{ Exception -> 0x0342 }
            if (r7 != 0) goto L_0x018d
            goto L_0x0014
        L_0x018d:
            r11 = r4[r6]     // Catch:{ Exception -> 0x0342 }
            if (r11 != 0) goto L_0x0193
            goto L_0x0014
        L_0x0193:
            r11 = r3[r6]     // Catch:{ Exception -> 0x01d2 }
            r12 = r4[r6]     // Catch:{ Exception -> 0x01d2 }
            r7.mo658a(r10, r11, r12)     // Catch:{ Exception -> 0x01d2 }
            r10 = r4[r6]     // Catch:{ Exception -> 0x0342 }
            int r11 = r7.f906m     // Catch:{ Exception -> 0x0342 }
            int r11 = r11 - r10
            r7.mo670d(r11)     // Catch:{ Exception -> 0x0342 }
            int r10 = r7.f906m     // Catch:{ Exception -> 0x0342 }
            int r11 = r7.f905l     // Catch:{ Exception -> 0x0342 }
            int r11 = r11 / 2
            if (r10 >= r11) goto L_0x0014
            r1.mo996a()     // Catch:{ Exception -> 0x0342 }
            r0.mo618a((byte) r9)     // Catch:{ Exception -> 0x0342 }
            int r9 = r7.mo648a()     // Catch:{ Exception -> 0x0342 }
            r0.mo619a((int) r9)     // Catch:{ Exception -> 0x0342 }
            int r9 = r7.f905l     // Catch:{ Exception -> 0x0342 }
            int r10 = r7.f906m     // Catch:{ Exception -> 0x0342 }
            int r9 = r9 - r10
            r0.mo619a((int) r9)     // Catch:{ Exception -> 0x0342 }
            monitor-enter(r7)     // Catch:{ Exception -> 0x0342 }
            boolean r9 = r7.f914u     // Catch:{ all -> 0x01cf }
            if (r9 != 0) goto L_0x01c7
            r13.mo1061b((atakplugin.UASTool.ahy) r1)     // Catch:{ all -> 0x01cf }
        L_0x01c7:
            monitor-exit(r7)     // Catch:{ all -> 0x01cf }
            int r9 = r7.f905l     // Catch:{ Exception -> 0x0342 }
            r7.mo670d(r9)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x01cf:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01cf }
            throw r0     // Catch:{ Exception -> 0x0342 }
        L_0x01d2:
            r7.mo683m()     // Catch:{ Exception -> 0x0014 }
            goto L_0x0014
        L_0x01d7:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            if (r7 != 0) goto L_0x01e9
            goto L_0x0014
        L_0x01e9:
            long r9 = r0.mo637e()     // Catch:{ Exception -> 0x0342 }
            r7.mo661b((long) r9)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x01f2:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x0014
            int r9 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r7.mo676g(r9)     // Catch:{ Exception -> 0x0342 }
            r7.f914u = r2     // Catch:{ Exception -> 0x0342 }
            r7.f913t = r2     // Catch:{ Exception -> 0x0342 }
            r7.mo649a((int) r6)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x0212:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.afy r7 = atakplugin.UASTool.afy.m929a((int) r7, (atakplugin.UASTool.air) r13)     // Catch:{ Exception -> 0x0342 }
            int r9 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            long r10 = r0.mo637e()     // Catch:{ Exception -> 0x0342 }
            int r12 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x0014
            r7.mo650a((long) r10)     // Catch:{ Exception -> 0x0342 }
            r7.mo674f(r12)     // Catch:{ Exception -> 0x0342 }
            r7.f916w = r2     // Catch:{ Exception -> 0x0342 }
            r7.mo649a((int) r9)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x023b:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            byte[] r7 = r0.mo643j()     // Catch:{ Exception -> 0x0342 }
            java.lang.String r7 = atakplugin.UASTool.aji.m1813b((byte[]) r7)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r9 = "forwarded-tcpip"
            boolean r9 = r9.equals(r7)     // Catch:{ Exception -> 0x0342 }
            if (r9 != 0) goto L_0x028a
            java.lang.String r9 = "x11"
            boolean r9 = r9.equals(r7)     // Catch:{ Exception -> 0x0342 }
            if (r9 == 0) goto L_0x025d
            boolean r9 = r13.f1465D     // Catch:{ Exception -> 0x0342 }
            if (r9 != 0) goto L_0x028a
        L_0x025d:
            java.lang.String r9 = "auth-agent@openssh.com"
            boolean r9 = r9.equals(r7)     // Catch:{ Exception -> 0x0342 }
            if (r9 == 0) goto L_0x0269
            boolean r9 = r13.f1466E     // Catch:{ Exception -> 0x0342 }
            if (r9 != 0) goto L_0x028a
        L_0x0269:
            r1.mo996a()     // Catch:{ Exception -> 0x0342 }
            r7 = 92
            r0.mo618a((byte) r7)     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo619a((int) r7)     // Catch:{ Exception -> 0x0342 }
            r0.mo619a((int) r2)     // Catch:{ Exception -> 0x0342 }
            byte[] r7 = atakplugin.UASTool.aji.f1621a     // Catch:{ Exception -> 0x0342 }
            r0.mo627b((byte[]) r7)     // Catch:{ Exception -> 0x0342 }
            byte[] r7 = atakplugin.UASTool.aji.f1621a     // Catch:{ Exception -> 0x0342 }
            r0.mo627b((byte[]) r7)     // Catch:{ Exception -> 0x0342 }
            r13.mo1061b((atakplugin.UASTool.ahy) r1)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x028a:
            atakplugin.UASTool.afy r9 = atakplugin.UASTool.afy.m930a((java.lang.String) r7)     // Catch:{ Exception -> 0x0342 }
            r13.mo1038a((atakplugin.UASTool.afy) r9)     // Catch:{ Exception -> 0x0342 }
            r9.mo651a((atakplugin.UASTool.afx) r0)     // Catch:{ Exception -> 0x0342 }
            r9.mo659b()     // Catch:{ Exception -> 0x0342 }
            java.lang.Thread r10 = new java.lang.Thread     // Catch:{ Exception -> 0x0342 }
            r10.<init>(r9)     // Catch:{ Exception -> 0x0342 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0342 }
            r9.<init>()     // Catch:{ Exception -> 0x0342 }
            java.lang.String r11 = "Channel "
            r9.append(r11)     // Catch:{ Exception -> 0x0342 }
            r9.append(r7)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r7 = " "
            r9.append(r7)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r7 = r13.f1475P     // Catch:{ Exception -> 0x0342 }
            r9.append(r7)     // Catch:{ Exception -> 0x0342 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0342 }
            r10.setName(r7)     // Catch:{ Exception -> 0x0342 }
            boolean r7 = r13.f1472M     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x02c1
            r10.setDaemon(r7)     // Catch:{ Exception -> 0x0342 }
        L_0x02c1:
            r10.start()     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x02c6:
            atakplugin.UASTool.air$b r9 = r13.f1499aO     // Catch:{ Exception -> 0x0342 }
            java.lang.Thread r9 = r9.mo1101a()     // Catch:{ Exception -> 0x0342 }
            if (r9 == 0) goto L_0x0014
            atakplugin.UASTool.air$b r10 = r13.f1499aO     // Catch:{ Exception -> 0x0342 }
            r11 = 81
            if (r7 != r11) goto L_0x02d6
            r12 = 1
            goto L_0x02d7
        L_0x02d6:
            r12 = 0
        L_0x02d7:
            r10.mo1102a((int) r12)     // Catch:{ Exception -> 0x0342 }
            if (r7 != r11) goto L_0x02f3
            atakplugin.UASTool.air$b r7 = r13.f1499aO     // Catch:{ Exception -> 0x0342 }
            int r7 = r7.mo1106c()     // Catch:{ Exception -> 0x0342 }
            if (r7 != 0) goto L_0x02f3
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            atakplugin.UASTool.air$b r7 = r13.f1499aO     // Catch:{ Exception -> 0x0342 }
            int r10 = r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r7.mo1105b(r10)     // Catch:{ Exception -> 0x0342 }
        L_0x02f3:
            r9.interrupt()     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x02f8:
            r0.mo633d()     // Catch:{ Exception -> 0x0342 }
            r0.mo638f()     // Catch:{ Exception -> 0x0342 }
            r0.mo643j()     // Catch:{ Exception -> 0x0342 }
            int r7 = r0.mo640g()     // Catch:{ Exception -> 0x0342 }
            if (r7 == 0) goto L_0x0309
            r7 = 1
            goto L_0x030a
        L_0x0309:
            r7 = 0
        L_0x030a:
            if (r7 == 0) goto L_0x0014
            r1.mo996a()     // Catch:{ Exception -> 0x0342 }
            r7 = 82
            r0.mo618a((byte) r7)     // Catch:{ Exception -> 0x0342 }
            r13.mo1061b((atakplugin.UASTool.ahy) r1)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0014
        L_0x0319:
            r13.m1647y()     // Catch:{ Exception -> 0x0342 }
            r13.m1630a((atakplugin.UASTool.afx) r0, (atakplugin.UASTool.ahl) r8)     // Catch:{ Exception -> 0x0342 }
            goto L_0x0013
        L_0x0321:
            atakplugin.UASTool.ahl r7 = r13.m1637b((atakplugin.UASTool.afx) r0)     // Catch:{ Exception -> 0x0342 }
            r8 = r7
            goto L_0x0014
        L_0x0328:
            r9 = move-exception
            boolean r10 = r13.f1496aL     // Catch:{ Exception -> 0x0342 }
            if (r10 != 0) goto L_0x0338
            int r10 = r13.f1492aH     // Catch:{ Exception -> 0x0342 }
            if (r7 >= r10) goto L_0x0338
            r13.mo1089m()     // Catch:{ Exception -> 0x0342 }
        L_0x0334:
            int r7 = r7 + 1
            goto L_0x0015
        L_0x0338:
            boolean r10 = r13.f1496aL     // Catch:{ Exception -> 0x0342 }
            if (r10 == 0) goto L_0x0341
            int r10 = r13.f1492aH     // Catch:{ Exception -> 0x0342 }
            if (r7 >= r10) goto L_0x0341
            goto L_0x0334
        L_0x0341:
            throw r9     // Catch:{ Exception -> 0x0342 }
        L_0x0342:
            r0 = move-exception
            r13.f1496aL = r6
            atakplugin.UASTool.ahu r1 = atakplugin.UASTool.ahg.m1351f()
            boolean r1 = r1.mo908a(r2)
            if (r1 == 0) goto L_0x036b
            atakplugin.UASTool.ahu r1 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Caught an exception, leaving main loop due to "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.mo907a(r2, r0)
        L_0x036b:
            r13.mo1067d()     // Catch:{ Exception | NullPointerException -> 0x036e }
        L_0x036e:
            r13.f1525ay = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.air.run():void");
    }

    /* renamed from: d */
    public void mo1067d() {
        if (this.f1525ay) {
            if (ahg.m1351f().mo908a(1)) {
                ahu f = ahg.m1351f();
                f.mo907a(1, "Disconnecting from " + this.f1475P + " port " + this.f1477R);
            }
            afy.m932a(this);
            this.f1525ay = false;
            ahz.m1571b(this);
            agd.m1019d(this);
            agl.m1222d(this);
            synchronized (this.f1486aB) {
                if (this.f1485aA != null) {
                    Thread.yield();
                    this.f1485aA.interrupt();
                    this.f1485aA = null;
                }
            }
            this.f1483X = null;
            try {
                ahc ahc = this.f1522av;
                if (ahc != null) {
                    if (ahc.f1234a != null) {
                        this.f1522av.f1234a.close();
                    }
                    if (this.f1522av.f1235b != null) {
                        this.f1522av.f1235b.close();
                    }
                    if (this.f1522av.f1236c != null) {
                        this.f1522av.f1236c.close();
                    }
                }
                aia aia = this.f1488aD;
                if (aia == null) {
                    Socket socket = this.f1523aw;
                    if (socket != null) {
                        socket.close();
                    }
                } else {
                    synchronized (aia) {
                        this.f1488aD.mo1008d();
                    }
                    this.f1488aD = null;
                }
            } catch (Exception unused) {
            }
            this.f1522av = null;
            this.f1523aw = null;
            this.f1480U.mo901b(this);
        }
    }

    /* renamed from: a */
    public int mo1027a(int i, String str, int i2) {
        return mo1028a("127.0.0.1", i, str, i2);
    }

    /* renamed from: a */
    public int mo1028a(String str, int i, String str2, int i2) {
        return mo1029a(str, i, str2, i2, (aiq) null);
    }

    /* renamed from: a */
    public int mo1029a(String str, int i, String str2, int i2, aiq aiq) {
        return mo1030a(str, i, str2, i2, aiq, 0);
    }

    /* renamed from: a */
    public int mo1030a(String str, int i, String str2, int i2, aiq aiq, int i3) {
        ahz a = ahz.m1568a(this, str, i, str2, i2, aiq);
        a.mo1001a(i3);
        Thread thread = new Thread(a);
        thread.setName("PortWatcher Thread for " + str2);
        boolean z = this.f1472M;
        if (z) {
            thread.setDaemon(z);
        }
        thread.start();
        return a.f1381b;
    }

    /* renamed from: b */
    public void mo1059b(int i) {
        mo1048a("127.0.0.1", i);
    }

    /* renamed from: a */
    public void mo1048a(String str, int i) {
        ahz.m1572b(this, str, i);
    }

    /* renamed from: e */
    public String[] mo1072e() {
        return ahz.m1570a(this);
    }

    /* renamed from: b */
    public void mo1060b(int i, String str, int i2) {
        mo1049a((String) null, i, str, i2, (aiz) null);
    }

    /* renamed from: b */
    public void mo1062b(String str, int i, String str2, int i2) {
        mo1049a(str, i, str2, i2, (aiz) null);
    }

    /* renamed from: a */
    public void mo1036a(int i, String str, int i2, aiz aiz) {
        mo1049a((String) null, i, str, i2, aiz);
    }

    /* renamed from: a */
    public void mo1049a(String str, int i, String str2, int i2, aiz aiz) {
        agd.m1013a(this, str, i, m1639d(str, i), str2, i2, aiz);
    }

    /* renamed from: a */
    public void mo1035a(int i, String str) {
        mo1050a((String) null, i, str, (Object[]) null);
    }

    /* renamed from: a */
    public void mo1037a(int i, String str, Object[] objArr) {
        mo1050a((String) null, i, str, objArr);
    }

    /* renamed from: a */
    public void mo1050a(String str, int i, String str2, Object[] objArr) {
        agd.m1014a(this, str, i, m1639d(str, i), str2, objArr);
    }

    /* renamed from: f */
    public String[] mo1075f() {
        return agd.m1018c(this);
    }

    /* renamed from: atakplugin.UASTool.air$a */
    private class C0050a {

        /* renamed from: a */
        String f1527a;

        /* renamed from: b */
        int f1528b;

        /* renamed from: c */
        String f1529c;

        /* renamed from: d */
        int f1530d;

        private C0050a() {
            this.f1527a = null;
            this.f1528b = -1;
            this.f1529c = null;
            this.f1530d = -1;
        }
    }

    /* renamed from: m */
    private C0050a m1641m(String str) {
        String[] split = str.split(" ");
        if (split.length > 1) {
            Vector vector = new Vector();
            for (int i = 0; i < split.length; i++) {
                if (split[i].length() != 0) {
                    vector.addElement(split[i].trim());
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            while (i2 < vector.size()) {
                stringBuffer.append((String) vector.elementAt(i2));
                i2++;
                if (i2 < vector.size()) {
                    stringBuffer.append(":");
                }
            }
            str = stringBuffer.toString();
        }
        C0050a aVar = new C0050a();
        try {
            if (str.lastIndexOf(":") != -1) {
                aVar.f1530d = Integer.parseInt(str.substring(str.lastIndexOf(":") + 1));
                String substring = str.substring(0, str.lastIndexOf(":"));
                if (substring.lastIndexOf(":") != -1) {
                    aVar.f1529c = substring.substring(substring.lastIndexOf(":") + 1);
                    String substring2 = substring.substring(0, substring.lastIndexOf(":"));
                    String str2 = "127.0.0.1";
                    if (substring2.lastIndexOf(":") != -1) {
                        aVar.f1528b = Integer.parseInt(substring2.substring(substring2.lastIndexOf(":") + 1));
                        String substring3 = substring2.substring(0, substring2.lastIndexOf(":"));
                        if (substring3.length() == 0 || substring3.equals("*")) {
                            substring3 = "0.0.0.0";
                        }
                        if (!substring3.equals("localhost")) {
                            str2 = substring3;
                        }
                        aVar.f1527a = str2;
                    } else {
                        aVar.f1528b = Integer.parseInt(substring2);
                        aVar.f1527a = str2;
                    }
                    return aVar;
                }
                throw new ahj("parseForwarding: " + str);
            }
            throw new ahj("parseForwarding: " + str);
        } catch (NumberFormatException e) {
            throw new ahj("parseForwarding: " + e.toString());
        }
    }

    /* renamed from: b */
    public int mo1056b(String str) {
        C0050a m = m1641m(str);
        return mo1028a(m.f1527a, m.f1528b, m.f1529c, m.f1530d);
    }

    /* renamed from: c */
    public int mo1063c(String str) {
        C0050a m = m1641m(str);
        int d = m1639d(m.f1527a, m.f1528b);
        agd.m1013a(this, m.f1527a, m.f1528b, d, m.f1529c, m.f1530d, (aiz) null);
        return d;
    }

    /* renamed from: b */
    public afy mo1057b(String str, int i) {
        agb agb = new agb();
        agb.mo659b();
        mo1038a((afy) agb);
        agb.mo701c(str);
        agb.mo703i(i);
        return agb;
    }

    /* renamed from: atakplugin.UASTool.air$b */
    private class C0051b {

        /* renamed from: b */
        private Thread f1533b;

        /* renamed from: c */
        private int f1534c;

        /* renamed from: d */
        private int f1535d;

        private C0051b() {
            this.f1533b = null;
            this.f1534c = -1;
            this.f1535d = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1103a(Thread thread) {
            this.f1533b = thread;
            this.f1534c = -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Thread mo1101a() {
            return this.f1533b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1102a(int i) {
            this.f1534c = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo1104b() {
            return this.f1534c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo1106c() {
            return this.f1535d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1105b(int i) {
            this.f1535d = i;
        }
    }

    /* renamed from: d */
    private int m1639d(String str, int i) {
        int c;
        synchronized (this.f1499aO) {
            afx afx = new afx(100);
            ahy ahy = new ahy(afx);
            String c2 = agd.m1017c(str);
            this.f1499aO.mo1103a(Thread.currentThread());
            this.f1499aO.mo1105b(i);
            try {
                ahy.mo996a();
                afx.mo618a((byte) 80);
                afx.mo627b(aji.m1820c("tcpip-forward"));
                afx.mo618a((byte) 1);
                afx.mo627b(aji.m1820c(c2));
                afx.mo619a(i);
                mo1061b(ahy);
                int i2 = 0;
                int b = this.f1499aO.mo1104b();
                while (i2 < 10 && b == -1) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception unused) {
                    }
                    i2++;
                    b = this.f1499aO.mo1104b();
                }
                this.f1499aO.mo1103a((Thread) null);
                if (b == 1) {
                    c = this.f1499aO.mo1106c();
                } else {
                    throw new ahj("remote port forwarding failed for listen port " + i);
                }
            } catch (Exception e) {
                this.f1499aO.mo1103a((Thread) null);
                if (e instanceof Throwable) {
                    throw new ahj(e.toString(), e);
                }
                throw new ahj(e.toString());
            }
        }
        return c;
    }

    /* renamed from: c */
    public void mo1064c(int i) {
        mo1065c((String) null, i);
    }

    /* renamed from: c */
    public void mo1065c(String str, int i) {
        agd.m1012a(this, str, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        throw new atakplugin.UASTool.ahj(r3.toString(), r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051 A[ExcHandler: NoClassDefFoundError (r3v1 'e' java.lang.NoClassDefFoundError A[CUSTOM_DECLARE]), Splitter:B:12:0x0026] */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1642n(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "none"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x000c
            r3 = 0
            r2.f1520at = r3
            return
        L_0x000c:
            java.lang.String r0 = r2.mo1083i(r3)
            if (r0 == 0) goto L_0x005c
            java.lang.String r1 = "zlib"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0026
            boolean r1 = r2.f1526az
            if (r1 == 0) goto L_0x005c
            java.lang.String r1 = "zlib@openssh.com"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x005c
        L_0x0026:
            java.lang.Class r3 = java.lang.Class.forName(r0)     // Catch:{ NoClassDefFoundError -> 0x0051, Exception -> 0x0046 }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ NoClassDefFoundError -> 0x0051, Exception -> 0x0046 }
            atakplugin.UASTool.ago r3 = (atakplugin.UASTool.ago) r3     // Catch:{ NoClassDefFoundError -> 0x0051, Exception -> 0x0046 }
            atakplugin.UASTool.ago r3 = (atakplugin.UASTool.ago) r3     // Catch:{ NoClassDefFoundError -> 0x0051, Exception -> 0x0046 }
            r2.f1520at = r3     // Catch:{ NoClassDefFoundError -> 0x0051, Exception -> 0x0046 }
            r3 = 6
            java.lang.String r0 = "compression_level"
            java.lang.String r0 = r2.mo1083i(r0)     // Catch:{ Exception -> 0x003f, NoClassDefFoundError -> 0x0051 }
            int r3 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x003f, NoClassDefFoundError -> 0x0051 }
        L_0x003f:
            atakplugin.UASTool.ago r0 = r2.f1520at     // Catch:{ NoClassDefFoundError -> 0x0051, Exception -> 0x0046 }
            r1 = 1
            r0.mo808a(r1, r3)     // Catch:{ NoClassDefFoundError -> 0x0051, Exception -> 0x0046 }
            goto L_0x005c
        L_0x0046:
            r3 = move-exception
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r1 = r3.toString()
            r0.<init>(r1, r3)
            throw r0
        L_0x0051:
            r3 = move-exception
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj
            java.lang.String r1 = r3.toString()
            r0.<init>(r1, r3)
            throw r0
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.air.m1642n(java.lang.String):void");
    }

    /* renamed from: o */
    private void m1643o(String str) {
        if (str.equals("none")) {
            this.f1521au = null;
            return;
        }
        String i = mo1083i(str);
        if (i == null) {
            return;
        }
        if (str.equals("zlib") || (this.f1526az && str.equals("zlib@openssh.com"))) {
            try {
                ago ago = (ago) Class.forName(i).newInstance();
                this.f1521au = ago;
                ago.mo808a(0, 0);
            } catch (Exception e) {
                throw new ahj(e.toString(), e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1038a(afy afy) {
        afy.mo662b(this);
    }

    /* renamed from: a */
    public void mo1043a(aia aia) {
        this.f1488aD = aia;
    }

    /* renamed from: d */
    public void mo1069d(String str) {
        this.f1475P = str;
    }

    /* renamed from: d */
    public void mo1068d(int i) {
        this.f1477R = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo1071e(String str) {
        this.f1478S = str;
    }

    /* renamed from: a */
    public void mo1045a(ajh ajh) {
        this.f1489aE = ajh;
    }

    /* renamed from: g */
    public ajh mo1076g() {
        return this.f1489aE;
    }

    /* renamed from: a */
    public void mo1046a(InputStream inputStream) {
        this.f1467F = inputStream;
    }

    /* renamed from: a */
    public void mo1047a(OutputStream outputStream) {
        this.f1468G = outputStream;
    }

    /* renamed from: f */
    public void mo1074f(String str) {
        agl.m1223d(str);
    }

    /* renamed from: e */
    public void mo1070e(int i) {
        agl.m1224i(i);
    }

    /* renamed from: g */
    public void mo1078g(String str) {
        agl.m1219c(str);
    }

    /* renamed from: h */
    public void mo1080h(String str) {
        if (str != null) {
            this.f1479T = aji.m1820c(str);
        }
    }

    /* renamed from: a */
    public void mo1055a(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.f1479T = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    /* renamed from: a */
    public void mo1053a(Properties properties) {
        mo1052a((Hashtable) properties);
    }

    /* renamed from: a */
    public void mo1052a(Hashtable hashtable) {
        synchronized (this.f1486aB) {
            if (this.f1487aC == null) {
                this.f1487aC = new Hashtable();
            }
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                this.f1487aC.put(str, (String) hashtable.get(str));
            }
        }
    }

    /* renamed from: a */
    public void mo1051a(String str, String str2) {
        synchronized (this.f1486aB) {
            if (this.f1487aC == null) {
                this.f1487aC = new Hashtable();
            }
            this.f1487aC.put(str, str2);
        }
    }

    /* renamed from: i */
    public String mo1083i(String str) {
        Hashtable hashtable = this.f1487aC;
        if (hashtable != null) {
            Object obj = hashtable.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        String e = ahg.m1350e(str);
        if (e instanceof String) {
            return e;
        }
        return null;
    }

    /* renamed from: a */
    public void mo1044a(aiz aiz) {
        this.f1471K = aiz;
    }

    /* renamed from: h */
    public boolean mo1081h() {
        return this.f1525ay;
    }

    /* renamed from: i */
    public int mo1082i() {
        return this.f1524ax;
    }

    /* renamed from: f */
    public void mo1073f(int i) {
        Socket socket = this.f1523aw;
        if (socket != null) {
            try {
                socket.setSoTimeout(i);
                this.f1524ax = i;
            } catch (Exception e) {
                if (e instanceof Throwable) {
                    throw new ahj(e.toString(), e);
                }
                throw new ahj(e.toString());
            }
        } else if (i >= 0) {
            this.f1524ax = i;
        } else {
            throw new ahj("invalid timeout value");
        }
    }

    /* renamed from: j */
    public String mo1084j() {
        return aji.m1813b(this.f1484Z);
    }

    /* renamed from: k */
    public String mo1086k() {
        return aji.m1813b(this.f1501aa);
    }

    /* renamed from: j */
    public void mo1085j(String str) {
        this.f1501aa = aji.m1820c(str);
    }

    /* renamed from: l */
    public void mo1088l() {
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 2);
        mo1061b(ahy);
    }

    /* renamed from: m */
    public void mo1089m() {
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 80);
        afx.mo627b(f1437aP);
        afx.mo618a((byte) 1);
        mo1061b(ahy);
    }

    /* renamed from: n */
    public void mo1090n() {
        afx afx = new afx();
        ahy ahy = new ahy(afx);
        ahy.mo996a();
        afx.mo618a((byte) 80);
        afx.mo627b(f1438aQ);
        afx.mo618a((byte) 0);
        mo1061b(ahy);
    }

    /* renamed from: o */
    public aha mo1091o() {
        return this.f1500aR;
    }

    /* renamed from: p */
    public String mo1092p() {
        return this.f1475P;
    }

    /* renamed from: q */
    public String mo1093q() {
        return this.f1478S;
    }

    /* renamed from: r */
    public int mo1094r() {
        return this.f1477R;
    }

    /* renamed from: k */
    public void mo1087k(String str) {
        this.f1490aF = str;
    }

    /* renamed from: s */
    public String mo1096s() {
        return this.f1490aF;
    }

    /* renamed from: g */
    public void mo1077g(int i) {
        mo1073f(i);
        this.f1491aG = i;
    }

    /* renamed from: t */
    public int mo1097t() {
        return this.f1491aG;
    }

    /* renamed from: h */
    public void mo1079h(int i) {
        this.f1492aH = i;
    }

    /* renamed from: u */
    public int mo1098u() {
        return this.f1492aH;
    }

    /* renamed from: a */
    public void mo1054a(boolean z) {
        this.f1472M = z;
    }

    /* renamed from: p */
    private String[] m1644p(String str) {
        String[] strArr = null;
        if (!(str == null || str.length() == 0)) {
            if (ahg.m1351f().mo908a(1)) {
                ahg.m1351f().mo907a(1, "CheckCiphers: " + str);
            }
            String i = mo1083i("cipher.c2s");
            String i2 = mo1083i("cipher.s2c");
            Vector vector = new Vector();
            String[] a = aji.m1810a(str, ",");
            for (String str2 : a) {
                if (!(i2.indexOf(str2) == -1 && i.indexOf(str2) == -1) && !m1640l(mo1083i(str2))) {
                    vector.addElement(str2);
                }
            }
            if (vector.size() == 0) {
                return null;
            }
            int size = vector.size();
            strArr = new String[size];
            System.arraycopy(vector.toArray(), 0, strArr, 0, vector.size());
            if (ahg.m1351f().mo908a(1)) {
                for (int i3 = 0; i3 < size; i3++) {
                    ahg.m1351f().mo907a(1, strArr[i3] + " is not available.");
                }
            }
        }
        return strArr;
    }

    /* renamed from: l */
    static boolean m1640l(String str) {
        try {
            agm agm = (agm) Class.forName(str).newInstance();
            agm.mo804a(0, new byte[agm.mo806b()], new byte[agm.mo803a()]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: q */
    private String[] m1645q(String str) {
        String[] strArr = null;
        if (!(str == null || str.length() == 0)) {
            if (ahg.m1351f().mo908a(1)) {
                ahu f = ahg.m1351f();
                f.mo907a(1, "CheckKexes: " + str);
            }
            Vector vector = new Vector();
            String[] a = aji.m1810a(str, ",");
            for (int i = 0; i < a.length; i++) {
                if (!m1635a(this, mo1083i(a[i]))) {
                    vector.addElement(a[i]);
                }
            }
            if (vector.size() == 0) {
                return null;
            }
            int size = vector.size();
            strArr = new String[size];
            System.arraycopy(vector.toArray(), 0, strArr, 0, vector.size());
            if (ahg.m1351f().mo908a(1)) {
                for (int i2 = 0; i2 < size; i2++) {
                    ahu f2 = ahg.m1351f();
                    f2.mo907a(1, strArr[i2] + " is not available.");
                }
            }
        }
        return strArr;
    }

    /* renamed from: a */
    static boolean m1635a(air air, String str) {
        try {
            ((ahl) Class.forName(str).newInstance()).mo824a(air, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void mo1040a(ahf ahf) {
        this.f1493aI = ahf;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public ahf mo1099v() {
        ahf ahf = this.f1493aI;
        return ahf == null ? this.f1480U.mo884a() : ahf;
    }

    /* renamed from: a */
    public void mo1039a(ahb ahb) {
        this.f1494aJ = ahb;
    }

    /* renamed from: w */
    public ahb mo1100w() {
        ahb ahb = this.f1494aJ;
        return ahb == null ? this.f1480U.mo902c() : ahb;
    }

    /* renamed from: z */
    private void m1648z() {
        agp b = this.f1480U.mo898b();
        if (b != null) {
            agp.C0041a a = b.mo811a(this.f1476Q);
            String b2 = a.mo814b();
            if (b2 != null) {
                this.f1478S = b2;
            }
            String a2 = a.mo812a();
            if (a2 != null) {
                this.f1475P = a2;
            }
            int c = a.mo816c();
            if (c != -1) {
                this.f1477R = c;
            }
            m1632a(a, "kex");
            m1632a(a, "server_host_key");
            m1632a(a, "cipher.c2s");
            m1632a(a, "cipher.s2c");
            m1632a(a, "mac.c2s");
            m1632a(a, "mac.s2c");
            m1632a(a, "compression.c2s");
            m1632a(a, "compression.s2c");
            m1632a(a, "compression_level");
            m1632a(a, "StrictHostKeyChecking");
            m1632a(a, "HashKnownHosts");
            m1632a(a, "PreferredAuthentications");
            m1632a(a, "MaxAuthTries");
            m1632a(a, "ClearAllForwardings");
            String a3 = a.mo813a("HostKeyAlias");
            if (a3 != null) {
                mo1087k(a3);
            }
            String a4 = a.mo813a("UserKnownHostsFile");
            if (a4 != null) {
                ahs ahs = new ahs(this.f1480U);
                ahs.mo979a(a4);
                mo1039a((ahb) ahs);
            }
            String[] b3 = a.mo815b("IdentityFile");
            if (b3 != null) {
                String[] b4 = b.mo811a("").mo815b("IdentityFile");
                if (b4 != null) {
                    for (String c2 : b4) {
                        this.f1480U.mo903c(c2);
                    }
                } else {
                    b4 = new String[0];
                }
                if (b3.length - b4.length > 0) {
                    ahf.C0043a aVar = new ahf.C0043a(this.f1480U.mo884a(), true);
                    for (String str : b3) {
                        int i = 0;
                        while (true) {
                            if (i < b4.length) {
                                if (str.equals(b4[i])) {
                                    str = null;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                        if (str != null) {
                            aVar.mo882a((ahd) ahe.m1322a(str, (String) null, this.f1480U));
                        }
                    }
                    mo1040a((ahf) aVar);
                }
            }
            String a5 = a.mo813a("ServerAliveInterval");
            if (a5 != null) {
                try {
                    mo1077g(Integer.parseInt(a5));
                } catch (NumberFormatException unused) {
                }
            }
            String a6 = a.mo813a("ConnectTimeout");
            if (a6 != null) {
                try {
                    mo1073f(Integer.parseInt(a6));
                } catch (NumberFormatException unused2) {
                }
            }
            String a7 = a.mo813a("MaxAuthTries");
            if (a7 != null) {
                mo1051a("MaxAuthTries", a7);
            }
            String a8 = a.mo813a("ClearAllForwardings");
            if (a8 != null) {
                mo1051a("ClearAllForwardings", a8);
            }
        }
    }

    /* renamed from: a */
    private void m1631a(age age) {
        agp b = this.f1480U.mo898b();
        if (b != null) {
            agp.C0041a a = b.mo811a(this.f1476Q);
            String a2 = a.mo813a("ForwardAgent");
            if (a2 != null) {
                age.mo715c(a2.equals("yes"));
            }
            String a3 = a.mo813a("RequestTTY");
            if (a3 != null) {
                age.mo710b(a3.equals("yes"));
            }
        }
    }

    /* renamed from: A */
    private void m1628A() {
        agp b;
        if (!mo1083i("ClearAllForwardings").equals("yes") && (b = this.f1480U.mo898b()) != null) {
            agp.C0041a a = b.mo811a(this.f1476Q);
            String[] b2 = a.mo815b("LocalForward");
            if (b2 != null) {
                for (String b3 : b2) {
                    mo1056b(b3);
                }
            }
            String[] b4 = a.mo815b("RemoteForward");
            if (b4 != null) {
                for (String c : b4) {
                    mo1063c(c);
                }
            }
        }
    }

    /* renamed from: a */
    private void m1632a(agp.C0041a aVar, String str) {
        String a = aVar.mo813a(str);
        if (a != null) {
            mo1051a(str, a);
        }
    }
}
