package atakplugin.UASTool;

import atakplugin.UASTool.afy;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.Hashtable;
import java.util.Vector;

public class agf extends age {

    /* renamed from: B */
    public static final int f994B = 0;

    /* renamed from: M */
    public static final int f995M = 1;

    /* renamed from: N */
    public static final int f996N = 2;

    /* renamed from: O */
    public static final int f997O = 3;

    /* renamed from: P */
    public static final int f998P = 4;

    /* renamed from: Q */
    public static final int f999Q = 5;

    /* renamed from: R */
    public static final int f1000R = 6;

    /* renamed from: S */
    public static final int f1001S = 7;

    /* renamed from: T */
    public static final int f1002T = 8;

    /* renamed from: U */
    public static final int f1003U = 0;

    /* renamed from: V */
    public static final int f1004V = 1;

    /* renamed from: W */
    public static final int f1005W = 2;

    /* renamed from: X */
    private static final int f1006X = 32768;

    /* renamed from: Y */
    private static final int f1007Y = 2097152;

    /* renamed from: Z */
    private static final byte f1008Z = 1;

    /* renamed from: aA */
    private static final int f1009aA = 1;

    /* renamed from: aB */
    private static final int f1010aB = 2;

    /* renamed from: aC */
    private static final int f1011aC = 4;

    /* renamed from: aD */
    private static final int f1012aD = 8;

    /* renamed from: aE */
    private static final int f1013aE = 16;

    /* renamed from: aF */
    private static final int f1014aF = 32;

    /* renamed from: aG */
    private static final int f1015aG = 1;

    /* renamed from: aH */
    private static final int f1016aH = 2;

    /* renamed from: aI */
    private static final int f1017aI = 4;

    /* renamed from: aJ */
    private static final int f1018aJ = 8;

    /* renamed from: aK */
    private static final int f1019aK = Integer.MIN_VALUE;

    /* renamed from: aL */
    private static final int f1020aL = 262144;

    /* renamed from: aa */
    private static final byte f1021aa = 2;

    /* renamed from: ab */
    private static final byte f1022ab = 3;

    /* renamed from: ac */
    private static final byte f1023ac = 4;

    /* renamed from: ad */
    private static final byte f1024ad = 5;

    /* renamed from: ae */
    private static final byte f1025ae = 6;

    /* renamed from: af */
    private static final byte f1026af = 7;

    /* renamed from: ag */
    private static final byte f1027ag = 8;

    /* renamed from: ah */
    private static final byte f1028ah = 9;

    /* renamed from: ai */
    private static final byte f1029ai = 10;

    /* renamed from: aj */
    private static final byte f1030aj = 11;

    /* renamed from: ak */
    private static final byte f1031ak = 12;

    /* renamed from: al */
    private static final byte f1032al = 13;

    /* renamed from: am */
    private static final byte f1033am = 14;

    /* renamed from: an */
    private static final byte f1034an = 15;

    /* renamed from: ao */
    private static final byte f1035ao = 16;

    /* renamed from: ap */
    private static final byte f1036ap = 17;

    /* renamed from: aq */
    private static final byte f1037aq = 18;

    /* renamed from: ar */
    private static final byte f1038ar = 19;

    /* renamed from: as */
    private static final byte f1039as = 20;

    /* renamed from: at */
    private static final byte f1040at = 101;

    /* renamed from: au */
    private static final byte f1041au = 102;

    /* renamed from: av */
    private static final byte f1042av = 103;

    /* renamed from: aw */
    private static final byte f1043aw = 104;

    /* renamed from: ax */
    private static final byte f1044ax = 105;

    /* renamed from: ay */
    private static final byte f1045ay = -56;

    /* renamed from: az */
    private static final byte f1046az = -55;

    /* renamed from: bb */
    private static final String f1047bb = File.separator;

    /* renamed from: bc */
    private static final char f1048bc = File.separatorChar;

    /* renamed from: bd */
    private static boolean f1049bd = (((byte) File.separatorChar) == 92);

    /* renamed from: bh */
    private static final String f1050bh = "UTF-8";

    /* renamed from: aM */
    private boolean f1051aM = false;
    /* access modifiers changed from: private */

    /* renamed from: aN */
    public int f1052aN = 1;

    /* renamed from: aO */
    private int[] f1053aO = new int[1];
    /* access modifiers changed from: private */

    /* renamed from: aP */
    public afx f1054aP;

    /* renamed from: aQ */
    private ahy f1055aQ;

    /* renamed from: aR */
    private afx f1056aR;

    /* renamed from: aS */
    private ahy f1057aS;

    /* renamed from: aT */
    private int f1058aT = 3;
    /* access modifiers changed from: private */

    /* renamed from: aU */
    public int f1059aU = 3;

    /* renamed from: aV */
    private String f1060aV = String.valueOf(3);

    /* renamed from: aW */
    private Hashtable f1061aW = null;
    /* access modifiers changed from: private */

    /* renamed from: aX */
    public InputStream f1062aX = null;

    /* renamed from: aY */
    private boolean f1063aY = false;

    /* renamed from: aZ */
    private boolean f1064aZ = false;

    /* renamed from: ba */
    private boolean f1065ba = false;

    /* renamed from: be */
    private String f1066be;

    /* renamed from: bf */
    private String f1067bf;

    /* renamed from: bg */
    private String f1068bg;

    /* renamed from: bi */
    private String f1069bi = "UTF-8";

    /* renamed from: bj */
    private boolean f1070bj = true;
    /* access modifiers changed from: private */

    /* renamed from: bk */
    public C0038d f1071bk = new C0038d(16);

    /* renamed from: atakplugin.UASTool.agf$c */
    public interface C0037c {

        /* renamed from: c */
        public static final int f1080c = 0;

        /* renamed from: d */
        public static final int f1081d = 1;

        /* renamed from: a */
        int mo783a(C0036b bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo659b() {
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo705a(int i, int i2, int i3, int i4) {
        super.mo705a(i, i2, i3, i4);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo706a(String str, int i, int i2, int i3, int i4) {
        super.mo706a(str, i, i2, i3, i4);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo707a(String str, String str2) {
        super.mo707a(str, str2);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo708a(Hashtable hashtable) {
        super.mo708a(hashtable);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo656a(boolean z) {
        super.mo656a(z);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo709a(byte[] bArr, byte[] bArr2) {
        super.mo709a(bArr, bArr2);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo710b(boolean z) {
        super.mo710b(z);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo715c(boolean z) {
        super.mo715c(z);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo716c(byte[] bArr) {
        super.mo716c(bArr);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo717d(String str) {
        super.mo717d(str);
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    /* renamed from: i */
    public void mo761i(int i) {
        if (i > 0) {
            this.f1071bk = new C0038d(i);
            return;
        }
        throw new ahj("setBulkRequests: " + i + " must be greater than 0.");
    }

    /* renamed from: u */
    public int mo718u() {
        return this.f1071bk.mo789c();
    }

    public agf() {
        mo668c(2097152);
        mo670d(2097152);
        mo671e(32768);
    }

    /* renamed from: d */
    public void mo669d() {
        try {
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            this.f910q.mo857a((OutputStream) pipedOutputStream);
            this.f910q.mo855a((InputStream) new afy.C0028a(pipedOutputStream, this.f909p));
            InputStream inputStream = this.f910q.f1234a;
            this.f1062aX = inputStream;
            if (inputStream != null) {
                new aik().mo1014a(mo686p(), this);
                this.f1054aP = new afx(this.f907n);
                this.f1055aQ = new ahy(this.f1054aP);
                this.f1056aR = new afx(this.f909p);
                this.f1057aS = new ahy(this.f1056aR);
                m1041E();
                C0035a a = m1046a(this.f1054aP, new C0035a());
                int i = a.f1072a;
                if (i <= 262144) {
                    int i2 = a.f1073b;
                    this.f1059aU = a.f1074c;
                    this.f1061aW = new Hashtable();
                    if (i > 0) {
                        m1069b(this.f1054aP, i);
                        while (i > 0) {
                            byte[] j = this.f1054aP.mo643j();
                            int length = i - (j.length + 4);
                            byte[] j2 = this.f1054aP.mo643j();
                            i = length - (j2.length + 4);
                            this.f1061aW.put(aji.m1813b(j), aji.m1813b(j2));
                        }
                    }
                    if (this.f1061aW.get("posix-rename@openssh.com") != null) {
                        if (this.f1061aW.get("posix-rename@openssh.com").equals("1")) {
                            this.f1063aY = true;
                        }
                    }
                    if (this.f1061aW.get("statvfs@openssh.com") != null && this.f1061aW.get("statvfs@openssh.com").equals("2")) {
                        this.f1064aZ = true;
                    }
                    if (this.f1061aW.get("hardlink@openssh.com") != null && this.f1061aW.get("hardlink@openssh.com").equals("1")) {
                        this.f1065ba = true;
                    }
                    this.f1068bg = new File(".").getCanonicalPath();
                    return;
                }
                throw new ait(4, "Received message is too long: " + i);
            }
            throw new ahj("channel is down");
        } catch (Exception e) {
            if (e instanceof ahj) {
                throw ((ahj) e);
            } else if (e instanceof Throwable) {
                throw new ahj(e.toString(), e);
            } else {
                throw new ahj(e.toString());
            }
        }
    }

    /* renamed from: w */
    public void mo771w() {
        mo683m();
    }

    /* renamed from: x */
    public void mo772x() {
        mo683m();
    }

    /* renamed from: c */
    public void mo750c(String str) {
        String D = m1039D(str);
        if (new File(D).isDirectory()) {
            try {
                D = new File(D).getCanonicalPath();
            } catch (Exception unused) {
            }
            this.f1068bg = D;
            return;
        }
        throw new ait(2, "No such directory");
    }

    /* renamed from: e */
    public void mo754e(String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            String E = m1040E(m1037C(str));
            byte[] w = m1102w(E);
            ais b = m1067b(w);
            if ((b.mo1124l() & 4) == 0) {
                throw new ait(4, "Can't change directory: " + E);
            } else if (b.mo1118f()) {
                m1103x(aji.m1804a(w, this.f1069bi));
            } else {
                throw new ait(4, "Can't change directory: " + E);
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: b */
    public void mo746b(String str, String str2) {
        mo741a(str, str2, (aiu) null, 0);
    }

    /* renamed from: a */
    public void mo739a(String str, String str2, int i) {
        mo741a(str, str2, (aiu) null, i);
    }

    /* renamed from: a */
    public void mo740a(String str, String str2, aiu aiu) {
        mo741a(str, str2, aiu, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0137, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0138, code lost:
        r14 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d9 A[Catch:{ Exception -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013b A[Catch:{ Exception -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00dc A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo741a(java.lang.String r22, java.lang.String r23, atakplugin.UASTool.aiu r24, int r25) {
        /*
            r21 = this;
            r1 = r21
            r0 = r24
            r8 = r25
            java.lang.String r2 = "/"
            r9 = 4
            java.io.InputStream r3 = r1.f1062aX     // Catch:{ Exception -> 0x0149 }
            atakplugin.UASTool.afy$a r3 = (atakplugin.UASTool.afy.C0028a) r3     // Catch:{ Exception -> 0x0149 }
            r3.mo692a()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r3 = r21.m1039D(r22)     // Catch:{ Exception -> 0x0149 }
            r4 = r23
            java.lang.String r4 = r1.m1037C(r4)     // Catch:{ Exception -> 0x0149 }
            java.util.Vector r5 = r1.m1104y(r4)     // Catch:{ Exception -> 0x0149 }
            int r6 = r5.size()     // Catch:{ Exception -> 0x0149 }
            r10 = 1
            if (r6 == r10) goto L_0x0040
            if (r6 != 0) goto L_0x0036
            boolean r0 = r1.m1036B(r4)     // Catch:{ Exception -> 0x0149 }
            if (r0 == 0) goto L_0x0033
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0149 }
            r0.<init>(r9, r4)     // Catch:{ Exception -> 0x0149 }
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x0033:
            atakplugin.UASTool.aji.m1812b((java.lang.String) r4)     // Catch:{ Exception -> 0x0149 }
        L_0x0036:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0149 }
            r0.<init>(r9, r2)     // Catch:{ Exception -> 0x0149 }
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x0040:
            r4 = 0
            java.lang.Object r5 = r5.elementAt(r4)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0149 }
            boolean r11 = r1.m1097s((java.lang.String) r5)     // Catch:{ Exception -> 0x0149 }
            java.util.Vector r12 = r1.m1105z(r3)     // Catch:{ Exception -> 0x0149 }
            int r13 = r12.size()     // Catch:{ Exception -> 0x0149 }
            if (r11 == 0) goto L_0x0075
            boolean r3 = r5.endsWith(r2)     // Catch:{ Exception -> 0x0149 }
            if (r3 != 0) goto L_0x006c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0149 }
            r3.<init>()     // Catch:{ Exception -> 0x0149 }
            r3.append(r5)     // Catch:{ Exception -> 0x0149 }
            r3.append(r2)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x0149 }
        L_0x006c:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0149 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0149 }
            r15 = r2
            r16 = r5
            goto L_0x007a
        L_0x0075:
            if (r13 > r10) goto L_0x0140
            r16 = r5
            r15 = 0
        L_0x007a:
            r6 = 0
        L_0x007b:
            if (r6 >= r13) goto L_0x013f
            java.lang.Object r2 = r12.elementAt(r6)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0149 }
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0149 }
            if (r11 == 0) goto L_0x00be
            char r2 = f1048bc     // Catch:{ Exception -> 0x0149 }
            int r2 = r7.lastIndexOf(r2)     // Catch:{ Exception -> 0x0149 }
            boolean r3 = f1049bd     // Catch:{ Exception -> 0x0149 }
            r4 = -1
            if (r3 == 0) goto L_0x009e
            r3 = 47
            int r3 = r7.lastIndexOf(r3)     // Catch:{ Exception -> 0x0149 }
            if (r3 == r4) goto L_0x009e
            if (r3 <= r2) goto L_0x009e
            r2 = r3
        L_0x009e:
            if (r2 != r4) goto L_0x00a4
            r15.append(r7)     // Catch:{ Exception -> 0x0149 }
            goto L_0x00ad
        L_0x00a4:
            int r2 = r2 + 1
            java.lang.String r2 = r7.substring(r2)     // Catch:{ Exception -> 0x0149 }
            r15.append(r2)     // Catch:{ Exception -> 0x0149 }
        L_0x00ad:
            java.lang.String r2 = r15.toString()     // Catch:{ Exception -> 0x0149 }
            int r3 = r16.length()     // Catch:{ Exception -> 0x0149 }
            int r4 = r2.length()     // Catch:{ Exception -> 0x0149 }
            r15.delete(r3, r4)     // Catch:{ Exception -> 0x0149 }
            r5 = r2
            goto L_0x00c0
        L_0x00be:
            r5 = r16
        L_0x00c0:
            r2 = 0
            if (r8 != r10) goto L_0x00f3
            atakplugin.UASTool.ais r4 = r1.m1099t(r5)     // Catch:{ Exception -> 0x00cc }
            long r2 = r4.mo1125m()     // Catch:{ Exception -> 0x00cc }
        L_0x00cc:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0149 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x0149 }
            long r17 = r4.length()     // Catch:{ Exception -> 0x0149 }
            int r4 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x00dc
            if (r4 != 0) goto L_0x00f3
            return
        L_0x00dc:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0149 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0149 }
            r2.<init>()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r3 = "failed to resume for "
            r2.append(r3)     // Catch:{ Exception -> 0x0149 }
            r2.append(r5)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0149 }
            r0.<init>(r9, r2)     // Catch:{ Exception -> 0x0149 }
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x00f3:
            r3 = r2
            if (r0 == 0) goto L_0x0119
            r17 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0149 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0149 }
            long r18 = r2.length()     // Catch:{ Exception -> 0x0149 }
            r2 = r24
            r23 = r15
            r14 = r3
            r3 = r17
            r4 = r7
            r17 = r5
            r20 = r6
            r9 = r7
            r6 = r18
            r2.mo1136a(r3, r4, r5, r6)     // Catch:{ Exception -> 0x0149 }
            if (r8 != r10) goto L_0x0120
            r0.mo1137a(r14)     // Catch:{ Exception -> 0x0149 }
            goto L_0x0120
        L_0x0119:
            r17 = r5
            r20 = r6
            r9 = r7
            r23 = r15
        L_0x0120:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0137 }
            r2.<init>(r9)     // Catch:{ all -> 0x0137 }
            r3 = r17
            r1.mo745b((java.io.InputStream) r2, (java.lang.String) r3, (atakplugin.UASTool.aiu) r0, (int) r8)     // Catch:{ all -> 0x0134 }
            r2.close()     // Catch:{ Exception -> 0x0149 }
            int r6 = r20 + 1
            r15 = r23
            r9 = 4
            goto L_0x007b
        L_0x0134:
            r0 = move-exception
            r14 = r2
            goto L_0x0139
        L_0x0137:
            r0 = move-exception
            r14 = 0
        L_0x0139:
            if (r14 == 0) goto L_0x013e
            r14.close()     // Catch:{ Exception -> 0x0149 }
        L_0x013e:
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x013f:
            return
        L_0x0140:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = "Copying multiple files, but the destination is missing or a file."
            r3 = 4
            r0.<init>(r3, r2)     // Catch:{ Exception -> 0x0149 }
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x0149:
            r0 = move-exception
            boolean r2 = r0 instanceof atakplugin.UASTool.ait
            if (r2 != 0) goto L_0x0168
            boolean r2 = r0 instanceof java.lang.Throwable
            if (r2 == 0) goto L_0x015d
            atakplugin.UASTool.ait r2 = new atakplugin.UASTool.ait
            java.lang.String r3 = r0.toString()
            r4 = 4
            r2.<init>(r4, r3, r0)
            throw r2
        L_0x015d:
            r4 = 4
            atakplugin.UASTool.ait r2 = new atakplugin.UASTool.ait
            java.lang.String r0 = r0.toString()
            r2.<init>(r4, r0)
            throw r2
        L_0x0168:
            atakplugin.UASTool.ait r0 = (atakplugin.UASTool.ait) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agf.mo741a(java.lang.String, java.lang.String, atakplugin.UASTool.aiu, int):void");
    }

    /* renamed from: a */
    public void mo730a(InputStream inputStream, String str) {
        mo733a(inputStream, str, (aiu) null, 0);
    }

    /* renamed from: a */
    public void mo731a(InputStream inputStream, String str, int i) {
        mo733a(inputStream, str, (aiu) null, i);
    }

    /* renamed from: a */
    public void mo732a(InputStream inputStream, String str, aiu aiu) {
        mo733a(inputStream, str, aiu, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo733a(java.io.InputStream r9, java.lang.String r10, atakplugin.UASTool.aiu r11, int r12) {
        /*
            r8 = this;
            r0 = 4
            java.io.InputStream r1 = r8.f1062aX     // Catch:{ Exception -> 0x0050 }
            atakplugin.UASTool.afy$a r1 = (atakplugin.UASTool.afy.C0028a) r1     // Catch:{ Exception -> 0x0050 }
            r1.mo692a()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r10 = r8.m1037C(r10)     // Catch:{ Exception -> 0x0050 }
            java.util.Vector r1 = r8.m1104y(r10)     // Catch:{ Exception -> 0x0050 }
            int r2 = r1.size()     // Catch:{ Exception -> 0x0050 }
            r3 = 1
            if (r2 == r3) goto L_0x0034
            if (r2 != 0) goto L_0x002a
            boolean r9 = r8.m1036B(r10)     // Catch:{ Exception -> 0x0050 }
            if (r9 == 0) goto L_0x0025
            atakplugin.UASTool.ait r9 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0050 }
            r9.<init>(r0, r10)     // Catch:{ Exception -> 0x0050 }
            throw r9     // Catch:{ Exception -> 0x0050 }
        L_0x0025:
            java.lang.String r9 = atakplugin.UASTool.aji.m1812b((java.lang.String) r10)     // Catch:{ Exception -> 0x0050 }
            r10 = r9
        L_0x002a:
            atakplugin.UASTool.ait r9 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0050 }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x0050 }
            r9.<init>(r0, r11)     // Catch:{ Exception -> 0x0050 }
            throw r9     // Catch:{ Exception -> 0x0050 }
        L_0x0034:
            r2 = 0
            java.lang.Object r1 = r1.elementAt(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0050 }
            if (r11 == 0) goto L_0x0049
            r3 = 0
            java.lang.String r4 = "-"
            r6 = -1
            r2 = r11
            r5 = r1
            r2.mo1136a(r3, r4, r5, r6)     // Catch:{ Exception -> 0x004d }
        L_0x0049:
            r8.mo745b((java.io.InputStream) r9, (java.lang.String) r1, (atakplugin.UASTool.aiu) r11, (int) r12)     // Catch:{ Exception -> 0x004d }
            return
        L_0x004d:
            r9 = move-exception
            r10 = r1
            goto L_0x0051
        L_0x0050:
            r9 = move-exception
        L_0x0051:
            boolean r11 = r9 instanceof atakplugin.UASTool.ait
            if (r11 == 0) goto L_0x0079
            atakplugin.UASTool.ait r9 = (atakplugin.UASTool.ait) r9
            int r11 = r9.f1573a
            if (r11 != r0) goto L_0x0078
            boolean r11 = r8.m1097s((java.lang.String) r10)
            if (r11 == 0) goto L_0x0078
            atakplugin.UASTool.ait r9 = new atakplugin.UASTool.ait
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            java.lang.String r10 = " is a directory"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r0, r10)
            throw r9
        L_0x0078:
            throw r9
        L_0x0079:
            boolean r10 = r9 instanceof java.lang.Throwable
            if (r10 == 0) goto L_0x0087
            atakplugin.UASTool.ait r10 = new atakplugin.UASTool.ait
            java.lang.String r11 = r9.toString()
            r10.<init>(r0, r11, r9)
            throw r10
        L_0x0087:
            atakplugin.UASTool.ait r10 = new atakplugin.UASTool.ait
            java.lang.String r9 = r9.toString()
            r10.<init>(r0, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agf.mo733a(java.io.InputStream, java.lang.String, atakplugin.UASTool.aiu, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038 A[Catch:{ Exception -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A[Catch:{ Exception -> 0x01a1 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo745b(java.io.InputStream r23, java.lang.String r24, atakplugin.UASTool.aiu r25, int r26) {
        /*
            r22 = this;
            r8 = r22
            r0 = r23
            r1 = r24
            r9 = r25
            r2 = r26
            r10 = 4
            java.io.InputStream r3 = r8.f1062aX     // Catch:{ Exception -> 0x01a1 }
            atakplugin.UASTool.afy$a r3 = (atakplugin.UASTool.afy.C0028a) r3     // Catch:{ Exception -> 0x01a1 }
            r3.mo692a()     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r3 = r8.f1069bi     // Catch:{ Exception -> 0x01a1 }
            byte[] r3 = atakplugin.UASTool.aji.m1816b((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x01a1 }
            r4 = 2
            r5 = 0
            r11 = 1
            if (r2 == r11) goto L_0x0020
            if (r2 != r4) goto L_0x0029
        L_0x0020:
            atakplugin.UASTool.ais r7 = r8.m1067b((byte[]) r3)     // Catch:{ Exception -> 0x0029 }
            long r12 = r7.mo1125m()     // Catch:{ Exception -> 0x0029 }
            goto L_0x002a
        L_0x0029:
            r12 = r5
        L_0x002a:
            if (r2 != r11) goto L_0x0050
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0050
            long r14 = r0.skip(r12)     // Catch:{ Exception -> 0x01a1 }
            int r7 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r7 < 0) goto L_0x0039
            goto L_0x0050
        L_0x0039:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x01a1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a1 }
            r2.<init>()     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r3 = "failed to resume for "
            r2.append(r3)     // Catch:{ Exception -> 0x01a1 }
            r2.append(r1)     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x01a1 }
            r0.<init>(r10, r1)     // Catch:{ Exception -> 0x01a1 }
            throw r0     // Catch:{ Exception -> 0x01a1 }
        L_0x0050:
            if (r2 != 0) goto L_0x0056
            r8.m1095q((byte[]) r3)     // Catch:{ Exception -> 0x01a1 }
            goto L_0x0059
        L_0x0056:
            r8.m1096r((byte[]) r3)     // Catch:{ Exception -> 0x01a1 }
        L_0x0059:
            atakplugin.UASTool.agf$a r1 = new atakplugin.UASTool.agf$a     // Catch:{ Exception -> 0x01a1 }
            r1.<init>()     // Catch:{ Exception -> 0x01a1 }
            atakplugin.UASTool.afx r3 = r8.f1054aP     // Catch:{ Exception -> 0x01a1 }
            atakplugin.UASTool.agf$a r14 = r8.m1046a((atakplugin.UASTool.afx) r3, (atakplugin.UASTool.agf.C0035a) r1)     // Catch:{ Exception -> 0x01a1 }
            int r1 = r14.f1072a     // Catch:{ Exception -> 0x01a1 }
            int r3 = r14.f1073b     // Catch:{ Exception -> 0x01a1 }
            atakplugin.UASTool.afx r7 = r8.f1054aP     // Catch:{ Exception -> 0x01a1 }
            r8.m1069b((atakplugin.UASTool.afx) r7, (int) r1)     // Catch:{ Exception -> 0x01a1 }
            r1 = 101(0x65, float:1.42E-43)
            if (r3 == r1) goto L_0x008d
            r7 = 102(0x66, float:1.43E-43)
            if (r3 != r7) goto L_0x0076
            goto L_0x008d
        L_0x0076:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x01a1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a1 }
            r1.<init>()     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r2 = "invalid type="
            r1.append(r2)     // Catch:{ Exception -> 0x01a1 }
            r1.append(r3)     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01a1 }
            r0.<init>(r10, r1)     // Catch:{ Exception -> 0x01a1 }
            throw r0     // Catch:{ Exception -> 0x01a1 }
        L_0x008d:
            if (r3 != r1) goto L_0x009a
            atakplugin.UASTool.afx r1 = r8.f1054aP     // Catch:{ Exception -> 0x01a1 }
            int r1 = r1.mo633d()     // Catch:{ Exception -> 0x01a1 }
            atakplugin.UASTool.afx r3 = r8.f1054aP     // Catch:{ Exception -> 0x01a1 }
            r8.m1054a((atakplugin.UASTool.afx) r3, (int) r1)     // Catch:{ Exception -> 0x01a1 }
        L_0x009a:
            atakplugin.UASTool.afx r1 = r8.f1054aP     // Catch:{ Exception -> 0x01a1 }
            byte[] r15 = r1.mo643j()     // Catch:{ Exception -> 0x01a1 }
            if (r2 == r11) goto L_0x00a4
            if (r2 != r4) goto L_0x00a5
        L_0x00a4:
            long r5 = r5 + r12
        L_0x00a5:
            int r12 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            atakplugin.UASTool.afx r1 = r8.f1056aR     // Catch:{ Exception -> 0x01a1 }
            byte[] r13 = r1.f888b     // Catch:{ Exception -> 0x01a1 }
            int r1 = r15.length     // Catch:{ Exception -> 0x01a1 }
            int r16 = r1 + 39
            atakplugin.UASTool.afx r1 = r8.f1056aR     // Catch:{ Exception -> 0x01a1 }
            byte[] r1 = r1.f888b     // Catch:{ Exception -> 0x01a1 }
            int r1 = r1.length     // Catch:{ Exception -> 0x01a1 }
            int r1 = r1 - r16
            int r17 = r1 + -84
            atakplugin.UASTool.agf$d r1 = r8.f1071bk     // Catch:{ Exception -> 0x01a1 }
            int r7 = r1.mo789c()     // Catch:{ Exception -> 0x01a1 }
            r18 = 0
            r19 = r5
            r1 = 0
        L_0x00c2:
            r2 = r16
            r3 = r17
            r4 = 0
        L_0x00c7:
            int r5 = r0.read(r13, r2, r3)     // Catch:{ Exception -> 0x01a1 }
            if (r5 <= 0) goto L_0x00d0
            int r2 = r2 + r5
            int r3 = r3 - r5
            int r4 = r4 + r5
        L_0x00d0:
            r6 = r4
            if (r3 <= 0) goto L_0x00d8
            if (r5 > 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            r4 = r6
            goto L_0x00c7
        L_0x00d8:
            if (r6 > 0) goto L_0x00dc
            goto L_0x0181
        L_0x00dc:
            r21 = r6
        L_0x00de:
            if (r21 <= 0) goto L_0x0174
            int r2 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            int r3 = r2 + -1
            if (r3 == r12) goto L_0x00ea
            int r2 = r2 - r12
            int r2 = r2 - r1
            if (r2 < r7) goto L_0x0158
        L_0x00ea:
            int r2 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            int r2 = r2 - r12
            int r2 = r2 - r1
            if (r2 < r7) goto L_0x0158
            int[] r2 = r8.f1053aO     // Catch:{ Exception -> 0x01a1 }
            boolean r2 = r8.m1066a((int[]) r2, (atakplugin.UASTool.agf.C0035a) r14)     // Catch:{ Exception -> 0x01a1 }
            if (r2 == 0) goto L_0x0158
            int[] r2 = r8.f1053aO     // Catch:{ Exception -> 0x01a1 }
            r2 = r2[r18]     // Catch:{ Exception -> 0x01a1 }
            if (r12 > r2) goto L_0x0103
            int r3 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            int r3 = r3 - r11
            if (r2 <= r3) goto L_0x012f
        L_0x0103:
            int r3 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r4 = " _ackid="
            java.lang.String r5 = " seq="
            java.lang.String r11 = "ack error: startid="
            if (r2 != r3) goto L_0x0134
            java.io.PrintStream r3 = java.lang.System.err     // Catch:{ Exception -> 0x01a1 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a1 }
            r10.<init>()     // Catch:{ Exception -> 0x01a1 }
            r10.append(r11)     // Catch:{ Exception -> 0x01a1 }
            r10.append(r12)     // Catch:{ Exception -> 0x01a1 }
            r10.append(r5)     // Catch:{ Exception -> 0x01a1 }
            int r5 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            r10.append(r5)     // Catch:{ Exception -> 0x01a1 }
            r10.append(r4)     // Catch:{ Exception -> 0x01a1 }
            r10.append(r2)     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x01a1 }
            r3.println(r2)     // Catch:{ Exception -> 0x01a1 }
        L_0x012f:
            int r1 = r1 + 1
            r10 = 4
            r11 = 1
            goto L_0x00ea
        L_0x0134:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x01a1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a1 }
            r1.<init>()     // Catch:{ Exception -> 0x01a1 }
            r1.append(r11)     // Catch:{ Exception -> 0x01a1 }
            r1.append(r12)     // Catch:{ Exception -> 0x01a1 }
            r1.append(r5)     // Catch:{ Exception -> 0x01a1 }
            int r3 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            r1.append(r3)     // Catch:{ Exception -> 0x01a1 }
            r1.append(r4)     // Catch:{ Exception -> 0x01a1 }
            r1.append(r2)     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01a1 }
            r2 = 4
            r0.<init>(r2, r1)     // Catch:{ Exception -> 0x01a1 }
            throw r0     // Catch:{ Exception -> 0x01a1 }
        L_0x0158:
            r10 = r1
            r11 = 0
            r1 = r22
            r2 = r15
            r3 = r19
            r5 = r13
            r0 = r6
            r6 = r11
            r11 = r7
            r7 = r21
            int r1 = r1.m1045a((byte[]) r2, (long) r3, (byte[]) r5, (int) r6, (int) r7)     // Catch:{ Exception -> 0x01a1 }
            int r21 = r21 - r1
            r6 = r0
            r1 = r10
            r7 = r11
            r10 = 4
            r11 = 1
            r0 = r23
            goto L_0x00de
        L_0x0174:
            r0 = r6
            r11 = r7
            long r2 = (long) r0     // Catch:{ Exception -> 0x01a1 }
            long r19 = r19 + r2
            if (r9 == 0) goto L_0x019a
            boolean r0 = r9.mo1137a(r2)     // Catch:{ Exception -> 0x01a1 }
            if (r0 != 0) goto L_0x019a
        L_0x0181:
            int r0 = r8.f1052aN     // Catch:{ Exception -> 0x01a1 }
            int r0 = r0 - r12
        L_0x0184:
            if (r0 <= r1) goto L_0x0191
            r2 = 0
            boolean r2 = r8.m1066a((int[]) r2, (atakplugin.UASTool.agf.C0035a) r14)     // Catch:{ Exception -> 0x01a1 }
            if (r2 != 0) goto L_0x018e
            goto L_0x0191
        L_0x018e:
            int r1 = r1 + 1
            goto L_0x0184
        L_0x0191:
            if (r9 == 0) goto L_0x0196
            r25.mo1135a()     // Catch:{ Exception -> 0x01a1 }
        L_0x0196:
            r8.m1065a((byte[]) r15, (atakplugin.UASTool.agf.C0035a) r14)     // Catch:{ Exception -> 0x01a1 }
            return
        L_0x019a:
            r0 = r23
            r7 = r11
            r10 = 4
            r11 = 1
            goto L_0x00c2
        L_0x01a1:
            r0 = move-exception
            boolean r1 = r0 instanceof atakplugin.UASTool.ait
            if (r1 != 0) goto L_0x01c0
            boolean r1 = r0 instanceof java.lang.Throwable
            if (r1 == 0) goto L_0x01b5
            atakplugin.UASTool.ait r1 = new atakplugin.UASTool.ait
            java.lang.String r2 = r0.toString()
            r3 = 4
            r1.<init>(r3, r2, r0)
            throw r1
        L_0x01b5:
            r3 = 4
            atakplugin.UASTool.ait r1 = new atakplugin.UASTool.ait
            java.lang.String r0 = r0.toString()
            r1.<init>(r3, r0)
            throw r1
        L_0x01c0:
            atakplugin.UASTool.ait r0 = (atakplugin.UASTool.ait) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agf.mo745b(java.io.InputStream, java.lang.String, atakplugin.UASTool.aiu, int):void");
    }

    /* renamed from: f */
    public OutputStream mo756f(String str) {
        return mo727a(str, (aiu) null, 0);
    }

    /* renamed from: a */
    public OutputStream mo726a(String str, int i) {
        return mo727a(str, (aiu) null, i);
    }

    /* renamed from: a */
    public OutputStream mo727a(String str, aiu aiu, int i) {
        return mo728a(str, aiu, i, 0);
    }

    /* renamed from: a */
    public OutputStream mo728a(String str, aiu aiu, int i, long j) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            String E = m1040E(m1037C(str));
            if (!m1097s(E)) {
                byte[] b = aji.m1816b(E, this.f1069bi);
                long j2 = 0;
                if (i == 1 || i == 2) {
                    try {
                        j2 = m1067b(b).mo1125m();
                    } catch (Exception unused) {
                    }
                }
                if (i == 0) {
                    m1095q(b);
                } else {
                    m1096r(b);
                }
                C0035a a = m1046a(this.f1054aP, new C0035a());
                int i2 = a.f1072a;
                int i3 = a.f1073b;
                m1069b(this.f1054aP, i2);
                if (i3 != 101) {
                    if (i3 != 102) {
                        throw new ait(4, "");
                    }
                }
                if (i3 == 101) {
                    m1054a(this.f1054aP, this.f1054aP.mo633d());
                }
                byte[] j3 = this.f1054aP.mo643j();
                if (i == 1 || i == 2) {
                    j += j2;
                }
                return new agg(this, j3, new long[]{j}, aiu);
            }
            throw new ait(4, E + " is a directory");
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: c */
    public void mo752c(String str, String str2) {
        mo748b(str, str2, (aiu) null, 0);
    }

    /* renamed from: b */
    public void mo747b(String str, String str2, aiu aiu) {
        mo748b(str, str2, aiu, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0151 A[Catch:{ Exception -> 0x0155 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo748b(java.lang.String r25, java.lang.String r26, atakplugin.UASTool.aiu r27, int r28) {
        /*
            r24 = this;
            r8 = r24
            r0 = r27
            r9 = r28
            r1 = 0
            r10 = 0
            r11 = 4
            java.io.InputStream r2 = r8.f1062aX     // Catch:{ Exception -> 0x0195 }
            atakplugin.UASTool.afy$a r2 = (atakplugin.UASTool.afy.C0028a) r2     // Catch:{ Exception -> 0x0195 }
            r2.mo692a()     // Catch:{ Exception -> 0x0195 }
            java.lang.String r2 = r24.m1037C(r25)     // Catch:{ Exception -> 0x0195 }
            r3 = r26
            java.lang.String r3 = r8.m1039D(r3)     // Catch:{ Exception -> 0x0195 }
            java.util.Vector r12 = r8.m1104y(r2)     // Catch:{ Exception -> 0x0195 }
            int r13 = r12.size()     // Catch:{ Exception -> 0x0195 }
            if (r13 == 0) goto L_0x018c
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0195 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0195 }
            boolean r14 = r2.isDirectory()     // Catch:{ Exception -> 0x0195 }
            r15 = 1
            if (r14 == 0) goto L_0x0050
            java.lang.String r2 = f1047bb     // Catch:{ Exception -> 0x0195 }
            boolean r4 = r3.endsWith(r2)     // Catch:{ Exception -> 0x0195 }
            if (r4 != 0) goto L_0x0047
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
            r4.<init>()     // Catch:{ Exception -> 0x0195 }
            r4.append(r3)     // Catch:{ Exception -> 0x0195 }
            r4.append(r2)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0195 }
        L_0x0047:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0195 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0195 }
            r7 = r2
            r16 = r3
            goto L_0x0055
        L_0x0050:
            if (r13 > r15) goto L_0x0184
            r16 = r3
            r7 = r10
        L_0x0055:
            r1 = r10
            r5 = 0
            r17 = 0
        L_0x0059:
            if (r5 >= r13) goto L_0x0183
            java.lang.Object r2 = r12.elementAt(r5)     // Catch:{ Exception -> 0x017e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x017e }
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x017e }
            atakplugin.UASTool.ais r2 = r8.m1099t(r6)     // Catch:{ Exception -> 0x017e }
            boolean r3 = r2.mo1118f()     // Catch:{ Exception -> 0x017e }
            if (r3 != 0) goto L_0x0163
            if (r14 == 0) goto L_0x009a
            r1 = 47
            int r1 = r6.lastIndexOf(r1)     // Catch:{ Exception -> 0x0097 }
            r3 = -1
            if (r1 != r3) goto L_0x007d
            r7.append(r6)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0086
        L_0x007d:
            int r1 = r1 + 1
            java.lang.String r1 = r6.substring(r1)     // Catch:{ Exception -> 0x0097 }
            r7.append(r1)     // Catch:{ Exception -> 0x0097 }
        L_0x0086:
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x0097 }
            int r3 = r16.length()     // Catch:{ Exception -> 0x017e }
            int r4 = r1.length()     // Catch:{ Exception -> 0x017e }
            r7.delete(r3, r4)     // Catch:{ Exception -> 0x017e }
            r4 = r1
            goto L_0x009c
        L_0x0097:
            r0 = move-exception
            goto L_0x0180
        L_0x009a:
            r4 = r16
        L_0x009c:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x015b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x015b }
            if (r9 != r15) goto L_0x00cd
            long r18 = r2.mo1125m()     // Catch:{ Exception -> 0x00c9 }
            long r20 = r3.length()     // Catch:{ Exception -> 0x00c9 }
            int r1 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r1 > 0) goto L_0x00b2
            if (r1 != 0) goto L_0x00cd
            return
        L_0x00b2:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x00c9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c9 }
            r1.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r2 = "failed to resume for "
            r1.append(r2)     // Catch:{ Exception -> 0x00c9 }
            r1.append(r4)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00c9 }
            r0.<init>(r11, r1)     // Catch:{ Exception -> 0x00c9 }
            throw r0     // Catch:{ Exception -> 0x00c9 }
        L_0x00c9:
            r0 = move-exception
            r10 = r4
            goto L_0x0180
        L_0x00cd:
            if (r0 == 0) goto L_0x00fa
            r18 = 1
            long r19 = r2.mo1125m()     // Catch:{ Exception -> 0x00f3 }
            r1 = r27
            r2 = r18
            r18 = r3
            r3 = r6
            r25 = r4
            r21 = r5
            r26 = r6
            r5 = r19
            r1.mo1136a(r2, r3, r4, r5)     // Catch:{ Exception -> 0x00f1 }
            if (r9 != r15) goto L_0x0102
            long r1 = r18.length()     // Catch:{ Exception -> 0x00f1 }
            r0.mo1137a(r1)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x0102
        L_0x00f1:
            r0 = move-exception
            goto L_0x00f6
        L_0x00f3:
            r0 = move-exception
            r25 = r4
        L_0x00f6:
            r10 = r25
            goto L_0x0180
        L_0x00fa:
            r18 = r3
            r25 = r4
            r21 = r5
            r26 = r6
        L_0x0102:
            boolean r17 = r18.exists()     // Catch:{ Exception -> 0x0157 }
            if (r9 != 0) goto L_0x0114
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0110 }
            r6 = r25
            r1.<init>(r6)     // Catch:{ all -> 0x014c }
            goto L_0x011b
        L_0x0110:
            r0 = move-exception
            r22 = r25
            goto L_0x014f
        L_0x0114:
            r6 = r25
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x014c }
            r1.<init>(r6, r15)     // Catch:{ all -> 0x014c }
        L_0x011b:
            r18 = r1
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0146 }
            r1.<init>(r6)     // Catch:{ all -> 0x0146 }
            long r19 = r1.length()     // Catch:{ all -> 0x0146 }
            r1 = r24
            r2 = r26
            r3 = r18
            r4 = r27
            r5 = r28
            r22 = r6
            r23 = r7
            r6 = r19
            r1.m1071b(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0144 }
            r18.close()     // Catch:{ Exception -> 0x0155 }
            int r5 = r21 + 1
            r1 = r22
            r7 = r23
            goto L_0x0059
        L_0x0144:
            r0 = move-exception
            goto L_0x0149
        L_0x0146:
            r0 = move-exception
            r22 = r6
        L_0x0149:
            r10 = r18
            goto L_0x014f
        L_0x014c:
            r0 = move-exception
            r22 = r6
        L_0x014f:
            if (r10 == 0) goto L_0x0154
            r10.close()     // Catch:{ Exception -> 0x0155 }
        L_0x0154:
            throw r0     // Catch:{ Exception -> 0x0155 }
        L_0x0155:
            r0 = move-exception
            goto L_0x015e
        L_0x0157:
            r0 = move-exception
            r22 = r25
            goto L_0x015e
        L_0x015b:
            r0 = move-exception
            r22 = r4
        L_0x015e:
            r1 = r17
            r10 = r22
            goto L_0x0196
        L_0x0163:
            r26 = r6
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x017e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017e }
            r2.<init>()     // Catch:{ Exception -> 0x017e }
            java.lang.String r3 = "not supported to get directory "
            r2.append(r3)     // Catch:{ Exception -> 0x017e }
            r3 = r26
            r2.append(r3)     // Catch:{ Exception -> 0x017e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x017e }
            r0.<init>(r11, r2)     // Catch:{ Exception -> 0x017e }
            throw r0     // Catch:{ Exception -> 0x017e }
        L_0x017e:
            r0 = move-exception
            r10 = r1
        L_0x0180:
            r1 = r17
            goto L_0x0196
        L_0x0183:
            return
        L_0x0184:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0195 }
            java.lang.String r2 = "Copying multiple files, but destination is missing or a file."
            r0.<init>(r11, r2)     // Catch:{ Exception -> 0x0195 }
            throw r0     // Catch:{ Exception -> 0x0195 }
        L_0x018c:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait     // Catch:{ Exception -> 0x0195 }
            r2 = 2
            java.lang.String r3 = "No such file"
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0195 }
            throw r0     // Catch:{ Exception -> 0x0195 }
        L_0x0195:
            r0 = move-exception
        L_0x0196:
            if (r1 != 0) goto L_0x01b2
            if (r10 == 0) goto L_0x01b2
            java.io.File r1 = new java.io.File
            r1.<init>(r10)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L_0x01b2
            long r2 = r1.length()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x01b2
            r1.delete()
        L_0x01b2:
            boolean r1 = r0 instanceof atakplugin.UASTool.ait
            if (r1 != 0) goto L_0x01c8
            boolean r1 = r0 instanceof java.lang.Throwable
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x01c2
            atakplugin.UASTool.ait r1 = new atakplugin.UASTool.ait
            r1.<init>(r11, r2, r0)
            throw r1
        L_0x01c2:
            atakplugin.UASTool.ait r0 = new atakplugin.UASTool.ait
            r0.<init>(r11, r2)
            throw r0
        L_0x01c8:
            atakplugin.UASTool.ait r0 = (atakplugin.UASTool.ait) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agf.mo748b(java.lang.String, java.lang.String, atakplugin.UASTool.aiu, int):void");
    }

    /* renamed from: a */
    public void mo736a(String str, OutputStream outputStream) {
        mo738a(str, outputStream, (aiu) null, 0, 0);
    }

    /* renamed from: a */
    public void mo737a(String str, OutputStream outputStream, aiu aiu) {
        mo738a(str, outputStream, aiu, 0, 0);
    }

    /* renamed from: a */
    public void mo738a(String str, OutputStream outputStream, aiu aiu, int i, long j) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            String E = m1040E(m1037C(str));
            if (aiu != null) {
                aiu.mo1136a(1, E, "??", m1099t(E).mo1125m());
                if (i == 1) {
                    aiu.mo1137a(j);
                }
            }
            m1071b(E, outputStream, aiu, i, j);
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: b */
    private void m1071b(String str, OutputStream outputStream, aiu aiu, int i, long j) {
        long j2;
        int i2;
        int i3;
        C0035a a;
        int i4;
        int i5;
        C0035a aVar;
        aiu aiu2 = aiu;
        try {
            m1094p(aji.m1816b(str, this.f1069bi));
            C0035a a2 = m1046a(this.f1054aP, new C0035a());
            int i6 = a2.f1072a;
            int i7 = a2.f1073b;
            m1069b(this.f1054aP, i6);
            int i8 = 101;
            if (i7 != 101) {
                if (i7 != 102) {
                    throw new ait(4, "");
                }
            }
            if (i7 == 101) {
                m1054a(this.f1054aP, this.f1054aP.mo633d());
            }
            byte[] j3 = this.f1054aP.mo643j();
            long j4 = 0;
            int i9 = 1;
            if (i == 1) {
                j4 = j + 0;
            }
            this.f1071bk.mo785a();
            int length = this.f1054aP.f888b.length - 13;
            if (this.f1059aU == 0) {
                j2 = j4;
                i3 = 1;
                i2 = 1024;
            } else {
                j2 = j4;
                i2 = length;
                i3 = 1;
            }
            loop0:
            while (true) {
                if (this.f1071bk.mo788b() < i3) {
                    int i10 = i2;
                    m1060a(j3, j2, i2, this.f1071bk);
                    j2 += (long) i10;
                    i4 = i10;
                    i5 = i3;
                } else {
                    int i11 = i3;
                    int i12 = i2;
                    a = m1046a(this.f1054aP, a2);
                    int i13 = a.f1072a;
                    int i14 = a.f1073b;
                    try {
                        C0038d.C0040b a3 = this.f1071bk.mo784a(a.f1074c);
                        if (i14 == i8) {
                            m1069b(this.f1054aP, i13);
                            int d = this.f1054aP.mo633d();
                            if (d == i9) {
                                break;
                            }
                            m1054a(this.f1054aP, d);
                        }
                        if (i14 != 103) {
                            break;
                        }
                        this.f1054aP.mo646m();
                        m1079d(this.f1054aP.f888b, 0, 4);
                        int d2 = this.f1054aP.mo633d();
                        int i15 = (i13 - 4) - d2;
                        int i16 = d2;
                        while (i16 > 0) {
                            int read = this.f1062aX.read(this.f1054aP.f888b, 0, i16 > this.f1054aP.f888b.length ? this.f1054aP.f888b.length : i16);
                            if (read < 0) {
                                break loop0;
                            }
                            outputStream.write(this.f1054aP.f888b, 0, read);
                            int i17 = i12;
                            long j5 = (long) read;
                            i16 -= read;
                            if (aiu2 == null || aiu2.mo1137a(j5)) {
                                i12 = i17;
                            } else {
                                m1075c((long) i16);
                                if (i15 > 0) {
                                    m1075c((long) i15);
                                }
                            }
                        }
                        OutputStream outputStream2 = outputStream;
                        int i18 = i12;
                        if (i15 > 0) {
                            m1075c((long) i15);
                        }
                        long j6 = (long) d2;
                        if (j6 < a3.f1090c) {
                            this.f1071bk.mo787a(a, this.f1054aP);
                            C0038d.C0040b bVar = a3;
                            m1060a(j3, a3.f1089b + j6, (int) (a3.f1090c - j6), this.f1071bk);
                            aVar = a;
                            j2 = bVar.f1089b + bVar.f1090c;
                        } else {
                            aVar = a;
                        }
                        int i19 = i11;
                        i5 = i19 < this.f1071bk.mo789c() ? i19 + 1 : i19;
                        i4 = i18;
                        a2 = aVar;
                        i8 = 101;
                        i9 = 1;
                    } catch (C0038d.C0039a e) {
                        OutputStream outputStream3 = outputStream;
                        C0035a aVar2 = a;
                        int i20 = i12;
                        int i21 = i11;
                        j2 = e.f1086a;
                        m1075c((long) aVar2.f1072a);
                        this.f1071bk.mo787a(aVar2, this.f1054aP);
                        i4 = i20;
                        a2 = aVar2;
                        i5 = i21;
                    }
                }
            }
            OutputStream outputStream4 = outputStream;
            outputStream.flush();
            if (aiu2 != null) {
                aiu.mo1135a();
            }
            this.f1071bk.mo787a(a, this.f1054aP);
            m1065a(j3, a);
        } catch (Exception e2) {
            if (e2 instanceof ait) {
                throw ((ait) e2);
            } else if (e2 instanceof Throwable) {
                throw new ait(4, "", e2);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: atakplugin.UASTool.agf$d */
    private class C0038d {

        /* renamed from: a */
        C0040b[] f1082a = null;

        /* renamed from: b */
        int f1083b;

        /* renamed from: c */
        int f1084c;

        /* renamed from: atakplugin.UASTool.agf$d$a */
        class C0039a extends Exception {

            /* renamed from: a */
            long f1086a;

            C0039a(long j) {
                this.f1086a = j;
            }
        }

        /* renamed from: atakplugin.UASTool.agf$d$b */
        class C0040b {

            /* renamed from: a */
            int f1088a;

            /* renamed from: b */
            long f1089b;

            /* renamed from: c */
            long f1090c;

            C0040b() {
            }
        }

        C0038d(int i) {
            this.f1082a = new C0040b[i];
            int i2 = 0;
            while (true) {
                C0040b[] bVarArr = this.f1082a;
                if (i2 < bVarArr.length) {
                    bVarArr[i2] = new C0040b();
                    i2++;
                } else {
                    mo785a();
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo785a() {
            this.f1084c = 0;
            this.f1083b = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo786a(int i, long j, int i2) {
            int i3 = this.f1084c;
            if (i3 == 0) {
                this.f1083b = 0;
            }
            int i4 = this.f1083b + i3;
            C0040b[] bVarArr = this.f1082a;
            if (i4 >= bVarArr.length) {
                i4 -= bVarArr.length;
            }
            bVarArr[i4].f1088a = i;
            this.f1082a[i4].f1089b = j;
            this.f1082a[i4].f1090c = (long) i2;
            this.f1084c++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0040b mo784a(int i) {
            boolean z = true;
            this.f1084c--;
            int i2 = this.f1083b;
            int i3 = i2 + 1;
            this.f1083b = i3;
            C0040b[] bVarArr = this.f1082a;
            if (i3 == bVarArr.length) {
                this.f1083b = 0;
            }
            if (bVarArr[i2].f1088a != i) {
                long d = mo790d();
                int i4 = 0;
                while (true) {
                    C0040b[] bVarArr2 = this.f1082a;
                    if (i4 >= bVarArr2.length) {
                        z = false;
                        break;
                    } else if (bVarArr2[i4].f1088a == i) {
                        this.f1082a[i4].f1088a = 0;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z) {
                    throw new C0039a(d);
                }
                throw new ait(4, "RequestQueue: unknown request id " + i);
            }
            this.f1082a[i2].f1088a = 0;
            return this.f1082a[i2];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo788b() {
            return this.f1084c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo789c() {
            return this.f1082a.length;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo787a(C0035a aVar, afx afx) {
            int i = this.f1084c;
            for (int i2 = 0; i2 < i; i2++) {
                aVar = agf.this.m1046a(afx, aVar);
                int i3 = aVar.f1072a;
                int i4 = 0;
                while (true) {
                    C0040b[] bVarArr = this.f1082a;
                    if (i4 >= bVarArr.length) {
                        break;
                    } else if (bVarArr[i4].f1088a == aVar.f1074c) {
                        this.f1082a[i4].f1088a = 0;
                        break;
                    } else {
                        i4++;
                    }
                }
                agf.this.m1075c((long) i3);
            }
            mo785a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public long mo790d() {
            long j = bfu.f2629b;
            int i = 0;
            while (true) {
                C0040b[] bVarArr = this.f1082a;
                if (i >= bVarArr.length) {
                    return j;
                }
                if (bVarArr[i].f1088a != 0 && j > this.f1082a[i].f1089b) {
                    j = this.f1082a[i].f1089b;
                }
                i++;
            }
        }
    }

    /* renamed from: g */
    public InputStream mo758g(String str) {
        return mo725a(str, (aiu) null, 0);
    }

    /* renamed from: a */
    public InputStream mo724a(String str, aiu aiu) {
        return mo725a(str, aiu, 0);
    }

    /* renamed from: b */
    public InputStream mo742b(String str, int i) {
        return mo725a(str, (aiu) null, 0);
    }

    /* renamed from: b */
    public InputStream mo743b(String str, aiu aiu, int i) {
        return mo725a(str, aiu, 0);
    }

    /* renamed from: a */
    public InputStream mo725a(String str, aiu aiu, long j) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            String E = m1040E(m1037C(str));
            byte[] b = aji.m1816b(E, this.f1069bi);
            ais b2 = m1067b(b);
            if (aiu != null) {
                aiu.mo1136a(1, E, "??", b2.mo1125m());
            }
            m1094p(b);
            C0035a a = m1046a(this.f1054aP, new C0035a());
            int i = a.f1072a;
            int i2 = a.f1073b;
            m1069b(this.f1054aP, i);
            if (i2 != 101) {
                if (i2 != 102) {
                    throw new ait(4, "");
                }
            }
            if (i2 == 101) {
                m1054a(this.f1054aP, this.f1054aP.mo633d());
            }
            byte[] j2 = this.f1054aP.mo643j();
            this.f1071bk.mo785a();
            return new agh(this, j, aiu, j2);
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: h */
    public Vector mo759h(String str) {
        Vector vector = new Vector();
        mo734a(str, (C0037c) new agi(this, vector));
        return vector;
    }

    /* renamed from: a */
    public void mo734a(String str, C0037c cVar) {
        byte[] bArr;
        boolean z;
        String str2;
        String str3;
        byte[] bArr2;
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            String C = m1037C(str);
            new Vector();
            int lastIndexOf = C.lastIndexOf(47);
            int i = 1;
            int i2 = 0;
            String substring = C.substring(0, lastIndexOf == 0 ? 1 : lastIndexOf);
            String substring2 = C.substring(lastIndexOf + 1);
            String b = aji.m1812b(substring);
            byte[][] bArr3 = new byte[1][];
            boolean a = m1064a(substring2, bArr3);
            if (a) {
                bArr = bArr3[0];
            } else {
                String b2 = aji.m1812b(C);
                if (m1099t(b2).mo1118f()) {
                    b = b2;
                    bArr = null;
                } else if (this.f1070bj) {
                    bArr = aji.m1808a(bArr3[0]);
                } else {
                    bArr = aji.m1816b(aji.m1812b(substring2), this.f1069bi);
                }
            }
            m1091m(aji.m1816b(b, this.f1069bi));
            C0035a a2 = m1046a(this.f1054aP, new C0035a());
            int i3 = a2.f1072a;
            int i4 = a2.f1073b;
            m1069b(this.f1054aP, i3);
            int i5 = 101;
            if (i4 != 101) {
                if (i4 != 102) {
                    throw new ait(4, "");
                }
            }
            if (i4 == 101) {
                m1054a(this.f1054aP, this.f1054aP.mo633d());
            }
            byte[] j = this.f1054aP.mo643j();
            int i6 = 0;
            while (true) {
                if (i6 != 0) {
                    break;
                }
                m1092n(j);
                a2 = m1046a(this.f1054aP, a2);
                int i7 = a2.f1072a;
                int i8 = a2.f1073b;
                if (i8 != i5) {
                    if (i8 != 104) {
                        throw new ait(4, "");
                    }
                }
                if (i8 == i5) {
                    m1069b(this.f1054aP, i7);
                    int d = this.f1054aP.mo633d();
                    if (d == i) {
                        break;
                    }
                    m1054a(this.f1054aP, d);
                }
                this.f1054aP.mo646m();
                m1079d(this.f1054aP.f888b, i2, 4);
                int i9 = i7 - 4;
                int d2 = this.f1054aP.mo633d();
                this.f1054aP.mo644k();
                while (d2 > 0) {
                    if (i9 > 0) {
                        this.f1054aP.mo645l();
                        int d3 = m1079d(this.f1054aP.f888b, this.f1054aP.f889c, this.f1054aP.f888b.length > this.f1054aP.f889c + i9 ? i9 : this.f1054aP.f888b.length - this.f1054aP.f889c);
                        this.f1054aP.f889c += d3;
                        i9 -= d3;
                    }
                    byte[] j2 = this.f1054aP.mo643j();
                    byte[] j3 = this.f1059aU <= 3 ? this.f1054aP.mo643j() : null;
                    ais a3 = ais.m1728a(this.f1054aP);
                    if (i6 == i) {
                        d2--;
                        i5 = 101;
                    } else {
                        if (bArr == null) {
                            str2 = null;
                            z = true;
                        } else if (!a) {
                            str2 = null;
                            z = aji.m1815b(bArr, j2);
                        } else {
                            if (!this.f1070bj) {
                                str2 = aji.m1804a(j2, this.f1069bi);
                                bArr2 = aji.m1816b(str2, "UTF-8");
                            } else {
                                bArr2 = j2;
                                str2 = null;
                            }
                            z = aji.m1807a(bArr, bArr2);
                        }
                        if (z) {
                            if (str2 == null) {
                                str2 = aji.m1804a(j2, this.f1069bi);
                            }
                            if (j3 == null) {
                                str3 = a3.toString() + " " + str2;
                            } else {
                                str3 = aji.m1804a(j3, this.f1069bi);
                            }
                            i6 = cVar.mo783a(new C0036b(str2, str3, a3));
                        } else {
                            C0037c cVar2 = cVar;
                        }
                        d2--;
                        i = 1;
                        i5 = 101;
                        i2 = 0;
                    }
                }
                C0037c cVar3 = cVar;
                i = 1;
            }
            m1065a(j, a2);
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: i */
    public String mo760i(String str) {
        try {
            if (this.f1059aU >= 3) {
                ((afy.C0028a) this.f1062aX).mo692a();
                m1090l(aji.m1816b(m1040E(m1037C(str)), this.f1069bi));
                C0035a a = m1046a(this.f1054aP, new C0035a());
                int i = a.f1072a;
                int i2 = a.f1073b;
                m1069b(this.f1054aP, i);
                if (i2 != 101) {
                    if (i2 != 104) {
                        throw new ait(4, "");
                    }
                }
                byte[] bArr = null;
                if (i2 == 104) {
                    int d = this.f1054aP.mo633d();
                    for (int i3 = 0; i3 < d; i3++) {
                        bArr = this.f1054aP.mo643j();
                        if (this.f1059aU <= 3) {
                            this.f1054aP.mo643j();
                        }
                        ais.m1728a(this.f1054aP);
                    }
                    return aji.m1804a(bArr, this.f1069bi);
                }
                m1054a(this.f1054aP, this.f1054aP.mo633d());
                return null;
            }
            throw new ait(8, "The remote sshd is too old to support symlink operation.");
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: d */
    public void mo753d(String str, String str2) {
        if (this.f1059aU >= 3) {
            try {
                ((afy.C0028a) this.f1062aX).mo692a();
                String C = m1037C(str);
                String C2 = m1037C(str2);
                String E = m1040E(C);
                int i = 0;
                if (str.charAt(0) != '/') {
                    String D = m1038D();
                    int length = D.length();
                    if (!D.endsWith("/")) {
                        i = 1;
                    }
                    E = E.substring(length + i);
                }
                if (!m1036B(C2)) {
                    m1073b(aji.m1816b(E, this.f1069bi), aji.m1816b(aji.m1812b(C2), this.f1069bi));
                    C0035a a = m1046a(this.f1054aP, new C0035a());
                    int i2 = a.f1072a;
                    int i3 = a.f1073b;
                    m1069b(this.f1054aP, i2);
                    if (i3 == 101) {
                        int d = this.f1054aP.mo633d();
                        if (d != 0) {
                            m1054a(this.f1054aP, d);
                            return;
                        }
                        return;
                    }
                    throw new ait(4, "");
                }
                throw new ait(4, C2);
            } catch (Exception e) {
                if (e instanceof ait) {
                    throw ((ait) e);
                } else if (e instanceof Throwable) {
                    throw new ait(4, "", e);
                } else {
                    throw new ait(4, "");
                }
            }
        } else {
            throw new ait(8, "The remote sshd is too old to support symlink operation.");
        }
    }

    /* renamed from: e */
    public void mo755e(String str, String str2) {
        if (this.f1065ba) {
            try {
                ((afy.C0028a) this.f1062aX).mo692a();
                String C = m1037C(str);
                String C2 = m1037C(str2);
                String E = m1040E(C);
                int i = 0;
                if (str.charAt(0) != '/') {
                    String D = m1038D();
                    int length = D.length();
                    if (!D.endsWith("/")) {
                        i = 1;
                    }
                    E = E.substring(length + i);
                }
                if (!m1036B(C2)) {
                    m1077c(aji.m1816b(E, this.f1069bi), aji.m1816b(aji.m1812b(C2), this.f1069bi));
                    C0035a a = m1046a(this.f1054aP, new C0035a());
                    int i2 = a.f1072a;
                    int i3 = a.f1073b;
                    m1069b(this.f1054aP, i2);
                    if (i3 == 101) {
                        int d = this.f1054aP.mo633d();
                        if (d != 0) {
                            m1054a(this.f1054aP, d);
                            return;
                        }
                        return;
                    }
                    throw new ait(4, "");
                }
                throw new ait(4, C2);
            } catch (Exception e) {
                if (e instanceof ait) {
                    throw ((ait) e);
                } else if (e instanceof Throwable) {
                    throw new ait(4, "", e);
                } else {
                    throw new ait(4, "");
                }
            }
        } else {
            throw new ait(8, "hardlink@openssh.com is not supported");
        }
    }

    /* renamed from: f */
    public void mo757f(String str, String str2) {
        String str3;
        if (this.f1059aU >= 2) {
            try {
                ((afy.C0028a) this.f1062aX).mo692a();
                String C = m1037C(str);
                String C2 = m1037C(str2);
                String E = m1040E(C);
                Vector y = m1104y(C2);
                int size = y.size();
                if (size < 2) {
                    if (size == 1) {
                        str3 = (String) y.elementAt(0);
                    } else if (!m1036B(C2)) {
                        str3 = aji.m1812b(C2);
                    } else {
                        throw new ait(4, C2);
                    }
                    m1081d(aji.m1816b(E, this.f1069bi), aji.m1816b(str3, this.f1069bi));
                    C0035a a = m1046a(this.f1054aP, new C0035a());
                    int i = a.f1072a;
                    int i2 = a.f1073b;
                    m1069b(this.f1054aP, i);
                    if (i2 == 101) {
                        int d = this.f1054aP.mo633d();
                        if (d != 0) {
                            m1054a(this.f1054aP, d);
                            return;
                        }
                        return;
                    }
                    throw new ait(4, "");
                }
                throw new ait(4, y.toString());
            } catch (Exception e) {
                if (e instanceof ait) {
                    throw ((ait) e);
                } else if (e instanceof Throwable) {
                    throw new ait(4, "", e);
                } else {
                    throw new ait(4, "");
                }
            }
        } else {
            throw new ait(8, "The remote sshd is too old to support rename operation.");
        }
    }

    /* renamed from: j */
    public void mo762j(String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            Vector y = m1104y(m1037C(str));
            int size = y.size();
            C0035a aVar = new C0035a();
            int i = 0;
            while (i < size) {
                m1088j(aji.m1816b((String) y.elementAt(i), this.f1069bi));
                aVar = m1046a(this.f1054aP, aVar);
                int i2 = aVar.f1072a;
                int i3 = aVar.f1073b;
                m1069b(this.f1054aP, i2);
                if (i3 == 101) {
                    int d = this.f1054aP.mo633d();
                    if (d != 0) {
                        m1054a(this.f1054aP, d);
                    }
                    i++;
                } else {
                    throw new ait(4, "");
                }
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: s */
    private boolean m1097s(String str) {
        try {
            m1084f(aji.m1816b(str, this.f1069bi));
            C0035a a = m1046a(this.f1054aP, new C0035a());
            int i = a.f1072a;
            int i2 = a.f1073b;
            m1069b(this.f1054aP, i);
            if (i2 != 105) {
                return false;
            }
            return ais.m1728a(this.f1054aP).mo1118f();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            Vector y = m1104y(m1037C(str));
            int size = y.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = (String) y.elementAt(i2);
                ais t = m1099t(str2);
                t.mo1108a(0);
                t.mo1109a(t.f1567E, i);
                m1070b(str2, t);
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: b */
    public void mo744b(int i, String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            Vector y = m1104y(m1037C(str));
            int size = y.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = (String) y.elementAt(i2);
                ais t = m1099t(str2);
                t.mo1108a(0);
                t.mo1109a(i, t.f1568F);
                m1070b(str2, t);
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: c */
    public void mo749c(int i, String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            Vector y = m1104y(m1037C(str));
            int size = y.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = (String) y.elementAt(i2);
                ais t = m1099t(str2);
                t.mo1108a(0);
                t.mo1112b(i);
                m1070b(str2, t);
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: c */
    public void mo751c(String str, int i) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            Vector y = m1104y(m1037C(str));
            int size = y.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = (String) y.elementAt(i2);
                ais t = m1099t(str2);
                t.mo1108a(0);
                t.mo1113b(t.mo1129q(), i);
                m1070b(str2, t);
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: k */
    public void mo763k(String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            Vector y = m1104y(m1037C(str));
            int size = y.size();
            C0035a aVar = new C0035a();
            int i = 0;
            while (i < size) {
                m1089k(aji.m1816b((String) y.elementAt(i), this.f1069bi));
                aVar = m1046a(this.f1054aP, aVar);
                int i2 = aVar.f1072a;
                int i3 = aVar.f1073b;
                m1069b(this.f1054aP, i2);
                if (i3 == 101) {
                    int d = this.f1054aP.mo633d();
                    if (d != 0) {
                        m1054a(this.f1054aP, d);
                    }
                    i++;
                } else {
                    throw new ait(4, "");
                }
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: l */
    public void mo764l(String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            m1072b(aji.m1816b(m1037C(str), this.f1069bi), (ais) null);
            C0035a a = m1046a(this.f1054aP, new C0035a());
            int i = a.f1072a;
            int i2 = a.f1073b;
            m1069b(this.f1054aP, i);
            if (i2 == 101) {
                int d = this.f1054aP.mo633d();
                if (d != 0) {
                    m1054a(this.f1054aP, d);
                    return;
                }
                return;
            }
            throw new ait(4, "");
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: m */
    public ais mo765m(String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            return m1099t(m1040E(m1037C(str)));
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: b */
    private ais m1067b(byte[] bArr) {
        try {
            m1084f(bArr);
            C0035a a = m1046a(this.f1054aP, new C0035a());
            int i = a.f1072a;
            int i2 = a.f1073b;
            m1069b(this.f1054aP, i);
            if (i2 == 105) {
                return ais.m1728a(this.f1054aP);
            }
            if (i2 == 101) {
                m1054a(this.f1054aP, this.f1054aP.mo633d());
            }
            throw new ait(4, "");
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: t */
    private ais m1099t(String str) {
        return m1067b(aji.m1816b(str, this.f1069bi));
    }

    /* renamed from: n */
    public aiv mo766n(String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            return m1100u(m1040E(m1037C(str)));
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: d */
    private aiv m1080d(byte[] bArr) {
        if (this.f1064aZ) {
            try {
                m1085g(bArr);
                C0035a a = m1046a(this.f1054aP, new C0035a());
                int i = a.f1072a;
                int i2 = a.f1073b;
                m1069b(this.f1054aP, i);
                if (i2 == 201) {
                    return aiv.m1758a(this.f1054aP);
                }
                if (i2 == 101) {
                    m1054a(this.f1054aP, this.f1054aP.mo633d());
                }
                throw new ait(4, "");
            } catch (Exception e) {
                if (e instanceof ait) {
                    throw ((ait) e);
                } else if (e instanceof Throwable) {
                    throw new ait(4, "", e);
                } else {
                    throw new ait(4, "");
                }
            }
        } else {
            throw new ait(8, "statvfs@openssh.com is not supported");
        }
    }

    /* renamed from: u */
    private aiv m1100u(String str) {
        return m1080d(aji.m1816b(str, this.f1069bi));
    }

    /* renamed from: o */
    public ais mo767o(String str) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            return m1101v(m1040E(m1037C(str)));
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: v */
    private ais m1101v(String str) {
        try {
            m1086h(aji.m1816b(str, this.f1069bi));
            C0035a a = m1046a(this.f1054aP, new C0035a());
            int i = a.f1072a;
            int i2 = a.f1073b;
            m1069b(this.f1054aP, i);
            if (i2 == 105) {
                return ais.m1728a(this.f1054aP);
            }
            if (i2 == 101) {
                m1054a(this.f1054aP, this.f1054aP.mo633d());
            }
            throw new ait(4, "");
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: w */
    private byte[] m1102w(String str) {
        m1083e(aji.m1816b(str, this.f1069bi));
        C0035a a = m1046a(this.f1054aP, new C0035a());
        int i = a.f1072a;
        int i2 = a.f1073b;
        m1069b(this.f1054aP, i);
        if (i2 == 101 || i2 == 104) {
            if (i2 == 101) {
                m1054a(this.f1054aP, this.f1054aP.mo633d());
            }
            int d = this.f1054aP.mo633d();
            byte[] bArr = null;
            while (true) {
                int i3 = d - 1;
                if (d <= 0) {
                    return bArr;
                }
                bArr = this.f1054aP.mo643j();
                if (this.f1059aU <= 3) {
                    this.f1054aP.mo643j();
                }
                ais.m1728a(this.f1054aP);
                d = i3;
            }
        } else {
            throw new ait(4, "");
        }
    }

    /* renamed from: a */
    public void mo735a(String str, ais ais) {
        try {
            ((afy.C0028a) this.f1062aX).mo692a();
            Vector y = m1104y(m1037C(str));
            int size = y.size();
            for (int i = 0; i < size; i++) {
                m1070b((String) y.elementAt(i), ais);
            }
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: b */
    private void m1070b(String str, ais ais) {
        try {
            m1061a(aji.m1816b(str, this.f1069bi), ais);
            C0035a a = m1046a(this.f1054aP, new C0035a());
            int i = a.f1072a;
            int i2 = a.f1073b;
            m1069b(this.f1054aP, i);
            if (i2 == 101) {
                int d = this.f1054aP.mo633d();
                if (d != 0) {
                    m1054a(this.f1054aP, d);
                    return;
                }
                return;
            }
            throw new ait(4, "");
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: y */
    public String mo773y() {
        return m1038D();
    }

    /* renamed from: z */
    public String mo774z() {
        return this.f1068bg;
    }

    /* renamed from: A */
    public String mo721A() {
        return this.f1060aV;
    }

    /* renamed from: B */
    public String mo722B() {
        if (this.f1067bf == null) {
            try {
                ((afy.C0028a) this.f1062aX).mo692a();
                this.f1067bf = aji.m1804a(m1102w(""), this.f1069bi);
            } catch (Exception e) {
                if (e instanceof ait) {
                    throw ((ait) e);
                } else if (e instanceof Throwable) {
                    throw new ait(4, "", e);
                } else {
                    throw new ait(4, "");
                }
            }
        }
        return this.f1067bf;
    }

    /* renamed from: D */
    private String m1038D() {
        if (this.f1066be == null) {
            this.f1066be = mo722B();
        }
        return this.f1066be;
    }

    /* renamed from: x */
    private void m1103x(String str) {
        this.f1066be = str;
    }

    /* renamed from: c */
    private void m1076c(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int read = this.f1062aX.read(bArr, i, i2);
            if (read > 0) {
                i += read;
                i2 -= read;
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1066a(int[] iArr, C0035a aVar) {
        C0035a a = m1046a(this.f1054aP, aVar);
        int i = a.f1072a;
        int i2 = a.f1073b;
        if (iArr != null) {
            iArr[0] = a.f1074c;
        }
        m1069b(this.f1054aP, i);
        if (i2 == 101) {
            int d = this.f1054aP.mo633d();
            if (d == 0) {
                return true;
            }
            m1054a(this.f1054aP, d);
            return true;
        }
        throw new ait(4, "");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1065a(byte[] bArr, C0035a aVar) {
        m1093o(bArr);
        return m1066a((int[]) null, aVar);
    }

    /* renamed from: E */
    private void m1041E() {
        this.f1055aQ.mo996a();
        m1048a((byte) 1, 5);
        this.f1054aP.mo619a(3);
        mo686p().mo1042a(this.f1055aQ, (afy) this, 9);
    }

    /* renamed from: e */
    private void m1083e(byte[] bArr) {
        m1049a((byte) 16, bArr);
    }

    /* renamed from: f */
    private void m1084f(byte[] bArr) {
        m1049a((byte) 17, bArr);
    }

    /* renamed from: g */
    private void m1085g(byte[] bArr) {
        m1050a((byte) 0, bArr, "statvfs@openssh.com");
    }

    /* renamed from: h */
    private void m1086h(byte[] bArr) {
        m1049a((byte) 7, bArr);
    }

    /* renamed from: i */
    private void m1087i(byte[] bArr) {
        m1049a((byte) 8, bArr);
    }

    /* renamed from: a */
    private void m1061a(byte[] bArr, ais ais) {
        this.f1055aQ.mo996a();
        m1048a((byte) 9, bArr.length + 9 + ais.mo1116d());
        afx afx = this.f1054aP;
        int i = this.f1052aN;
        this.f1052aN = i + 1;
        afx.mo619a(i);
        this.f1054aP.mo627b(bArr);
        ais.mo1114b(this.f1054aP);
        mo686p().mo1042a(this.f1055aQ, (afy) this, bArr.length + 9 + ais.mo1116d() + 4);
    }

    /* renamed from: j */
    private void m1088j(byte[] bArr) {
        m1049a((byte) 13, bArr);
    }

    /* renamed from: b */
    private void m1072b(byte[] bArr, ais ais) {
        this.f1055aQ.mo996a();
        m1048a((byte) 14, bArr.length + 9 + (ais != null ? ais.mo1116d() : 4));
        afx afx = this.f1054aP;
        int i = this.f1052aN;
        this.f1052aN = i + 1;
        afx.mo619a(i);
        this.f1054aP.mo627b(bArr);
        if (ais != null) {
            ais.mo1114b(this.f1054aP);
        } else {
            this.f1054aP.mo619a(0);
        }
        mo686p().mo1042a(this.f1055aQ, (afy) this, bArr.length + 9 + (ais != null ? ais.mo1116d() : 4) + 4);
    }

    /* renamed from: k */
    private void m1089k(byte[] bArr) {
        m1049a((byte) 15, bArr);
    }

    /* renamed from: b */
    private void m1073b(byte[] bArr, byte[] bArr2) {
        m1051a((byte) 20, bArr, bArr2);
    }

    /* renamed from: c */
    private void m1077c(byte[] bArr, byte[] bArr2) {
        m1052a((byte) 0, bArr, bArr2, "hardlink@openssh.com");
    }

    /* renamed from: l */
    private void m1090l(byte[] bArr) {
        m1049a((byte) 19, bArr);
    }

    /* renamed from: m */
    private void m1091m(byte[] bArr) {
        m1049a((byte) 11, bArr);
    }

    /* renamed from: n */
    private void m1092n(byte[] bArr) {
        m1049a((byte) 12, bArr);
    }

    /* renamed from: d */
    private void m1081d(byte[] bArr, byte[] bArr2) {
        m1052a((byte) 18, bArr, bArr2, this.f1063aY ? "posix-rename@openssh.com" : null);
    }

    /* renamed from: o */
    private void m1093o(byte[] bArr) {
        m1049a((byte) 4, bArr);
    }

    /* renamed from: p */
    private void m1094p(byte[] bArr) {
        m1058a(bArr, 1);
    }

    /* renamed from: q */
    private void m1095q(byte[] bArr) {
        m1058a(bArr, 26);
    }

    /* renamed from: r */
    private void m1096r(byte[] bArr) {
        m1058a(bArr, 10);
    }

    /* renamed from: a */
    private void m1058a(byte[] bArr, int i) {
        this.f1055aQ.mo996a();
        m1048a((byte) 3, bArr.length + 17);
        afx afx = this.f1054aP;
        int i2 = this.f1052aN;
        this.f1052aN = i2 + 1;
        afx.mo619a(i2);
        this.f1054aP.mo627b(bArr);
        this.f1054aP.mo619a(i);
        this.f1054aP.mo619a(0);
        mo686p().mo1042a(this.f1055aQ, (afy) this, bArr.length + 17 + 4);
    }

    /* renamed from: a */
    private void m1049a(byte b, byte[] bArr) {
        m1050a(b, bArr, (String) null);
    }

    /* renamed from: a */
    private void m1050a(byte b, byte[] bArr, String str) {
        this.f1055aQ.mo996a();
        int length = bArr.length + 9;
        if (str == null) {
            m1048a(b, length);
            afx afx = this.f1054aP;
            int i = this.f1052aN;
            this.f1052aN = i + 1;
            afx.mo619a(i);
        } else {
            length += str.length() + 4;
            m1048a((byte) f1045ay, length);
            afx afx2 = this.f1054aP;
            int i2 = this.f1052aN;
            this.f1052aN = i2 + 1;
            afx2.mo619a(i2);
            this.f1054aP.mo627b(aji.m1820c(str));
        }
        this.f1054aP.mo627b(bArr);
        mo686p().mo1042a(this.f1055aQ, (afy) this, length + 4);
    }

    /* renamed from: a */
    private void m1051a(byte b, byte[] bArr, byte[] bArr2) {
        m1052a(b, bArr, bArr2, (String) null);
    }

    /* renamed from: a */
    private void m1052a(byte b, byte[] bArr, byte[] bArr2, String str) {
        this.f1055aQ.mo996a();
        int length = bArr.length + 13 + bArr2.length;
        if (str == null) {
            m1048a(b, length);
            afx afx = this.f1054aP;
            int i = this.f1052aN;
            this.f1052aN = i + 1;
            afx.mo619a(i);
        } else {
            length += str.length() + 4;
            m1048a((byte) f1045ay, length);
            afx afx2 = this.f1054aP;
            int i2 = this.f1052aN;
            this.f1052aN = i2 + 1;
            afx2.mo619a(i2);
            this.f1054aP.mo627b(aji.m1820c(str));
        }
        this.f1054aP.mo627b(bArr);
        this.f1054aP.mo627b(bArr2);
        mo686p().mo1042a(this.f1055aQ, (afy) this, length + 4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m1045a(byte[] bArr, long j, byte[] bArr2, int i, int i2) {
        this.f1057aS.mo996a();
        if (this.f1056aR.f888b.length < this.f1056aR.f889c + 13 + 21 + bArr.length + i2 + 84) {
            i2 = this.f1056aR.f888b.length - ((((this.f1056aR.f889c + 13) + 21) + bArr.length) + 84);
        }
        m1053a(this.f1056aR, (byte) 6, bArr.length + 21 + i2);
        afx afx = this.f1056aR;
        int i3 = this.f1052aN;
        this.f1052aN = i3 + 1;
        afx.mo619a(i3);
        this.f1056aR.mo627b(bArr);
        this.f1056aR.mo620a(j);
        if (this.f1056aR.f888b != bArr2) {
            this.f1056aR.mo628b(bArr2, i, i2);
        } else {
            this.f1056aR.mo619a(i2);
            this.f1056aR.mo626b(i2);
        }
        mo686p().mo1042a(this.f1057aS, (afy) this, bArr.length + 21 + i2 + 4);
        return i2;
    }

    /* renamed from: a */
    private void m1059a(byte[] bArr, long j, int i) {
        m1060a(bArr, j, i, (C0038d) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1060a(byte[] bArr, long j, int i, C0038d dVar) {
        this.f1055aQ.mo996a();
        m1048a((byte) 5, bArr.length + 21);
        afx afx = this.f1054aP;
        int i2 = this.f1052aN;
        this.f1052aN = i2 + 1;
        afx.mo619a(i2);
        this.f1054aP.mo627b(bArr);
        this.f1054aP.mo620a(j);
        this.f1054aP.mo619a(i);
        mo686p().mo1042a(this.f1055aQ, (afy) this, bArr.length + 21 + 4);
        if (dVar != null) {
            dVar.mo786a(this.f1052aN - 1, j, i);
        }
    }

    /* renamed from: a */
    private void m1053a(afx afx, byte b, int i) {
        afx.mo618a((byte) 94);
        afx.mo619a(this.f903j);
        afx.mo619a(i + 4);
        afx.mo619a(i);
        afx.mo618a(b);
    }

    /* renamed from: a */
    private void m1048a(byte b, int i) {
        m1053a(this.f1054aP, b, i);
    }

    /* renamed from: y */
    private Vector m1104y(String str) {
        byte[] bArr;
        String str2;
        String str3 = str;
        Vector vector = new Vector();
        int lastIndexOf = str3.lastIndexOf(47);
        if (lastIndexOf < 0) {
            vector.addElement(aji.m1812b(str));
            return vector;
        }
        int i = 0;
        String substring = str3.substring(0, lastIndexOf == 0 ? 1 : lastIndexOf);
        String substring2 = str3.substring(lastIndexOf + 1);
        String b = aji.m1812b(substring);
        byte[][] bArr2 = new byte[1][];
        if (!m1064a(substring2, bArr2)) {
            if (!b.equals("/")) {
                b = b + "/";
            }
            vector.addElement(b + aji.m1812b(substring2));
            return vector;
        }
        byte[] bArr3 = bArr2[0];
        m1091m(aji.m1816b(b, this.f1069bi));
        C0035a a = m1046a(this.f1054aP, new C0035a());
        int i2 = a.f1072a;
        int i3 = a.f1073b;
        m1069b(this.f1054aP, i2);
        int i4 = 4;
        int i5 = 101;
        if (i3 == 101 || i3 == 102) {
            if (i3 == 101) {
                m1054a(this.f1054aP, this.f1054aP.mo633d());
            }
            byte[] j = this.f1054aP.mo643j();
            String str4 = null;
            while (true) {
                m1092n(j);
                a = m1046a(this.f1054aP, a);
                int i6 = a.f1072a;
                int i7 = a.f1073b;
                if (i7 != i5 && i7 != 104) {
                    throw new ait(i4, "");
                } else if (i7 == i5) {
                    m1069b(this.f1054aP, i6);
                    if (m1065a(j, a)) {
                        return vector;
                    }
                    return null;
                } else {
                    this.f1054aP.mo646m();
                    m1079d(this.f1054aP.f888b, i, i4);
                    int i8 = i6 - 4;
                    this.f1054aP.mo644k();
                    for (int d = this.f1054aP.mo633d(); d > 0; d--) {
                        if (i8 > 0) {
                            this.f1054aP.mo645l();
                            int read = this.f1062aX.read(this.f1054aP.f888b, this.f1054aP.f889c, this.f1054aP.f888b.length > this.f1054aP.f889c + i8 ? i8 : this.f1054aP.f888b.length - this.f1054aP.f889c);
                            if (read <= 0) {
                                break;
                            }
                            this.f1054aP.f889c += read;
                            i8 -= read;
                        }
                        byte[] j2 = this.f1054aP.mo643j();
                        if (this.f1059aU <= 3) {
                            this.f1054aP.mo643j();
                        }
                        ais.m1728a(this.f1054aP);
                        if (!this.f1070bj) {
                            str2 = aji.m1804a(j2, this.f1069bi);
                            bArr = aji.m1816b(str2, "UTF-8");
                        } else {
                            bArr = j2;
                            str2 = null;
                        }
                        if (aji.m1807a(bArr3, bArr)) {
                            if (str2 == null) {
                                str2 = aji.m1804a(j2, this.f1069bi);
                            }
                            if (str4 == null) {
                                if (!b.endsWith("/")) {
                                    str4 = b + "/";
                                } else {
                                    str4 = b;
                                }
                            }
                            vector.addElement(str4 + str2);
                        }
                    }
                    i = 0;
                    i4 = 4;
                    i5 = 101;
                }
            }
        } else {
            throw new ait(4, "");
        }
    }

    /* renamed from: s */
    private boolean m1098s(byte[] bArr) {
        int i;
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (bArr[i2] == 42 || bArr[i2] == 63) {
                return true;
            }
            if (bArr[i2] == 92 && (i = i2 + 1) < length) {
                i2 = i;
            }
            i2++;
        }
        return false;
    }

    /* renamed from: z */
    private Vector m1105z(String str) {
        byte[] bArr;
        Vector vector = new Vector();
        byte[] b = aji.m1816b(str, "UTF-8");
        int length = b.length - 1;
        while (length >= 0) {
            if (b[length] == 42 || b[length] == 63) {
                if (f1049bd || length <= 0 || b[length - 1] != 92 || length - 1 <= 0 || b[length - 1] != 92) {
                    break;
                }
                length--;
            }
            length--;
        }
        if (length < 0) {
            if (!f1049bd) {
                str = aji.m1812b(str);
            }
            vector.addElement(str);
            return vector;
        }
        while (length >= 0 && b[length] != f1048bc && (!f1049bd || b[length] != 47)) {
            length--;
        }
        if (length < 0) {
            if (!f1049bd) {
                str = aji.m1812b(str);
            }
            vector.addElement(str);
            return vector;
        }
        if (length == 0) {
            bArr = new byte[]{(byte) f1048bc};
        } else {
            bArr = new byte[length];
            System.arraycopy(b, 0, bArr, 0, length);
        }
        int length2 = (b.length - length) - 1;
        byte[] bArr2 = new byte[length2];
        System.arraycopy(b, length + 1, bArr2, 0, length2);
        try {
            String[] list = new File(aji.m1804a(bArr, "UTF-8")).list();
            String str2 = aji.m1813b(bArr) + f1047bb;
            for (int i = 0; i < list.length; i++) {
                if (aji.m1807a(bArr2, aji.m1816b(list[i], "UTF-8"))) {
                    vector.addElement(str2 + list[i]);
                }
            }
        } catch (Exception unused) {
        }
        return vector;
    }

    /* renamed from: a */
    private void m1054a(afx afx, int i) {
        if (this.f1059aU < 3 || afx.mo617a() < 4) {
            throw new ait(i, "Failure");
        }
        throw new ait(i, aji.m1804a(afx.mo643j(), "UTF-8"));
    }

    /* renamed from: A */
    private static boolean m1035A(String str) {
        return new File(str).isAbsolute();
    }

    /* renamed from: m */
    public void mo683m() {
        super.mo683m();
    }

    /* renamed from: a */
    private boolean m1064a(String str, byte[][] bArr) {
        byte[] b = aji.m1816b(str, "UTF-8");
        if (bArr != null) {
            bArr[0] = b;
        }
        return m1098s(b);
    }

    /* renamed from: B */
    private boolean m1036B(String str) {
        return m1064a(str, (byte[][]) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1069b(afx afx, int i) {
        afx.mo644k();
        m1079d(afx.f888b, 0, i);
        afx.mo626b(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public int m1079d(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i2 > 0) {
            int read = this.f1062aX.read(bArr, i3, i2);
            if (read > 0) {
                i3 += read;
                i2 -= read;
            } else {
                throw new IOException("inputstream is closed");
            }
        }
        return i3 - i;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1075c(long j) {
        while (j > 0) {
            long skip = this.f1062aX.skip(j);
            if (skip > 0) {
                j -= skip;
            } else {
                return;
            }
        }
    }

    /* renamed from: atakplugin.UASTool.agf$a */
    class C0035a {

        /* renamed from: a */
        int f1072a;

        /* renamed from: b */
        int f1073b;

        /* renamed from: c */
        int f1074c;

        C0035a() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0035a m1046a(afx afx, C0035a aVar) {
        afx.mo646m();
        m1079d(afx.f888b, 0, 9);
        aVar.f1072a = afx.mo633d() - 5;
        aVar.f1073b = afx.mo640g() & 255;
        aVar.f1074c = afx.mo633d();
        return aVar;
    }

    /* renamed from: C */
    private String m1037C(String str) {
        if (str.charAt(0) == '/') {
            return str;
        }
        String D = m1038D();
        if (D.endsWith("/")) {
            return D + str;
        }
        return D + "/" + str;
    }

    /* renamed from: D */
    private String m1039D(String str) {
        if (m1035A(str)) {
            return str;
        }
        String str2 = this.f1068bg;
        String str3 = f1047bb;
        if (str2.endsWith(str3)) {
            return this.f1068bg + str;
        }
        return this.f1068bg + str3 + str;
    }

    /* renamed from: E */
    private String m1040E(String str) {
        Vector y = m1104y(str);
        if (y.size() == 1) {
            return (String) y.elementAt(0);
        }
        throw new ait(4, str + " is not unique: " + y.toString());
    }

    /* renamed from: C */
    public int mo723C() {
        if (mo684n()) {
            return this.f1059aU;
        }
        throw new ait(4, "The channel is not connected.");
    }

    /* renamed from: p */
    public void mo768p(String str) {
        int C = mo723C();
        if (3 > C || C > 5 || str.equals("UTF-8")) {
            if (str.equals("UTF-8")) {
                str = "UTF-8";
            }
            this.f1069bi = str;
            this.f1070bj = str.equals("UTF-8");
            return;
        }
        throw new ait(4, "The encoding can not be changed for this sftp server.");
    }

    /* renamed from: q */
    public String mo769q(String str) {
        Hashtable hashtable = this.f1061aW;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    /* renamed from: r */
    public String mo770r(String str) {
        try {
            return aji.m1804a(m1102w(m1037C(str)), this.f1069bi);
        } catch (Exception e) {
            if (e instanceof ait) {
                throw ((ait) e);
            } else if (e instanceof Throwable) {
                throw new ait(4, "", e);
            } else {
                throw new ait(4, "");
            }
        }
    }

    /* renamed from: atakplugin.UASTool.agf$b */
    public class C0036b implements Comparable {

        /* renamed from: b */
        private String f1077b;

        /* renamed from: c */
        private String f1078c;

        /* renamed from: d */
        private ais f1079d;

        C0036b(String str, String str2, ais ais) {
            mo777a(str);
            mo779b(str2);
            mo776a(ais);
        }

        /* renamed from: a */
        public String mo775a() {
            return this.f1077b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo777a(String str) {
            this.f1077b = str;
        }

        /* renamed from: b */
        public String mo778b() {
            return this.f1078c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo779b(String str) {
            this.f1078c = str;
        }

        /* renamed from: c */
        public ais mo780c() {
            return this.f1079d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo776a(ais ais) {
            this.f1079d = ais;
        }

        public String toString() {
            return this.f1078c;
        }

        public int compareTo(Object obj) {
            if (obj instanceof C0036b) {
                return this.f1077b.compareTo(((C0036b) obj).mo775a());
            }
            throw new ClassCastException("a decendent of LsEntry must be given.");
        }
    }
}
