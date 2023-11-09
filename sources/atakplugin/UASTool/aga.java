package atakplugin.UASTool;

import com.google.common.base.Ascii;

class aga extends afy {

    /* renamed from: C */
    private static final int f936C = 131072;

    /* renamed from: D */
    private static final int f937D = 16384;

    /* renamed from: B */
    boolean f938B = true;

    /* renamed from: E */
    private final byte f939E = 1;

    /* renamed from: F */
    private final byte f940F = 2;

    /* renamed from: G */
    private final byte f941G = 3;

    /* renamed from: H */
    private final byte f942H = 4;

    /* renamed from: I */
    private final byte f943I = 5;

    /* renamed from: J */
    private final byte f944J = 6;

    /* renamed from: K */
    private final byte f945K = 7;

    /* renamed from: L */
    private final byte f946L = 8;

    /* renamed from: M */
    private final byte f947M = 9;

    /* renamed from: N */
    private final byte f948N = Ascii.f8527VT;

    /* renamed from: O */
    private final byte f949O = Ascii.f8516FF;

    /* renamed from: P */
    private final byte f950P = Ascii.f8514CR;

    /* renamed from: Q */
    private final byte f951Q = Ascii.f8524SO;

    /* renamed from: R */
    private final byte f952R = 17;

    /* renamed from: S */
    private final byte f953S = Ascii.DC2;

    /* renamed from: T */
    private final byte f954T = 19;

    /* renamed from: U */
    private final byte f955U = Ascii.f8522RS;

    /* renamed from: V */
    private afx f956V = null;

    /* renamed from: W */
    private afx f957W = null;

    /* renamed from: X */
    private ahy f958X = null;

    /* renamed from: Y */
    private afx f959Y = null;

    aga() {
        mo668c(131072);
        mo670d(131072);
        mo671e(16384);
        this.f904k = aji.m1820c("auth-agent@openssh.com");
        afx afx = new afx();
        this.f956V = afx;
        afx.mo644k();
        this.f959Y = new afx();
        this.f915v = true;
    }

    public void run() {
        try {
            mo688r();
        } catch (Exception unused) {
            this.f914u = true;
            mo683m();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:54|(1:(2:57|117)(1:(3:58|(2:60|(2:120|62)(2:63|(2:119|65)(3:66|67|68)))(0)|69)))(0)|70|71|(2:113|73)(1:118)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:70:0x0153 */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0159 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x015a A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo658a(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            atakplugin.UASTool.ahy r0 = r6.f958X
            if (r0 != 0) goto L_0x0016
            atakplugin.UASTool.afx r0 = new atakplugin.UASTool.afx
            int r1 = r6.f909p
            r0.<init>((int) r1)
            r6.f957W = r0
            atakplugin.UASTool.ahy r0 = new atakplugin.UASTool.ahy
            atakplugin.UASTool.afx r1 = r6.f957W
            r0.<init>(r1)
            r6.f958X = r0
        L_0x0016:
            atakplugin.UASTool.afx r0 = r6.f956V
            r0.mo645l()
            atakplugin.UASTool.afx r0 = r6.f956V
            byte[] r0 = r0.f888b
            int r0 = r0.length
            atakplugin.UASTool.afx r1 = r6.f956V
            int r1 = r1.f889c
            int r1 = r1 + r9
            r2 = 0
            if (r0 >= r1) goto L_0x003f
            atakplugin.UASTool.afx r0 = r6.f956V
            int r0 = r0.f890d
            int r0 = r0 + r9
            byte[] r0 = new byte[r0]
            atakplugin.UASTool.afx r1 = r6.f956V
            byte[] r1 = r1.f888b
            atakplugin.UASTool.afx r3 = r6.f956V
            byte[] r3 = r3.f888b
            int r3 = r3.length
            java.lang.System.arraycopy(r1, r2, r0, r2, r3)
            atakplugin.UASTool.afx r1 = r6.f956V
            r1.f888b = r0
        L_0x003f:
            atakplugin.UASTool.afx r0 = r6.f956V
            r0.mo622a(r7, r8, r9)
            atakplugin.UASTool.afx r7 = r6.f956V
            int r7 = r7.mo633d()
            atakplugin.UASTool.afx r8 = r6.f956V
            int r8 = r8.mo617a()
            if (r7 <= r8) goto L_0x005b
            atakplugin.UASTool.afx r7 = r6.f956V
            int r8 = r7.f890d
            int r8 = r8 + -4
            r7.f890d = r8
            return
        L_0x005b:
            atakplugin.UASTool.afx r7 = r6.f956V
            int r7 = r7.mo640g()
            atakplugin.UASTool.air r8 = r6.mo686p()     // Catch:{ ahj -> 0x01ea }
            atakplugin.UASTool.ahf r9 = r8.mo1099v()
            atakplugin.UASTool.ajh r8 = r8.mo1076g()
            atakplugin.UASTool.afx r0 = r6.f959Y
            r0.mo644k()
            r0 = 11
            if (r7 != r0) goto L_0x00cc
            atakplugin.UASTool.afx r7 = r6.f959Y
            r8 = 12
            r7.mo618a((byte) r8)
            java.util.Vector r0 = r9.mo880c()
            monitor-enter(r0)
            r7 = 0
            r8 = 0
        L_0x0084:
            int r9 = r0.size()     // Catch:{ all -> 0x00c9 }
            if (r7 >= r9) goto L_0x009d
            java.lang.Object r9 = r0.elementAt(r7)     // Catch:{ all -> 0x00c9 }
            atakplugin.UASTool.ahd r9 = (atakplugin.UASTool.ahd) r9     // Catch:{ all -> 0x00c9 }
            atakplugin.UASTool.ahd r9 = (atakplugin.UASTool.ahd) r9     // Catch:{ all -> 0x00c9 }
            byte[] r9 = r9.mo868a()     // Catch:{ all -> 0x00c9 }
            if (r9 == 0) goto L_0x009a
            int r8 = r8 + 1
        L_0x009a:
            int r7 = r7 + 1
            goto L_0x0084
        L_0x009d:
            atakplugin.UASTool.afx r7 = r6.f959Y     // Catch:{ all -> 0x00c9 }
            r7.mo619a((int) r8)     // Catch:{ all -> 0x00c9 }
        L_0x00a2:
            int r7 = r0.size()     // Catch:{ all -> 0x00c9 }
            if (r2 >= r7) goto L_0x00c6
            java.lang.Object r7 = r0.elementAt(r2)     // Catch:{ all -> 0x00c9 }
            atakplugin.UASTool.ahd r7 = (atakplugin.UASTool.ahd) r7     // Catch:{ all -> 0x00c9 }
            atakplugin.UASTool.ahd r7 = (atakplugin.UASTool.ahd) r7     // Catch:{ all -> 0x00c9 }
            byte[] r7 = r7.mo868a()     // Catch:{ all -> 0x00c9 }
            if (r7 != 0) goto L_0x00b7
            goto L_0x00c3
        L_0x00b7:
            atakplugin.UASTool.afx r8 = r6.f959Y     // Catch:{ all -> 0x00c9 }
            r8.mo627b((byte[]) r7)     // Catch:{ all -> 0x00c9 }
            atakplugin.UASTool.afx r7 = r6.f959Y     // Catch:{ all -> 0x00c9 }
            byte[] r8 = atakplugin.UASTool.aji.f1621a     // Catch:{ all -> 0x00c9 }
            r7.mo627b((byte[]) r8)     // Catch:{ all -> 0x00c9 }
        L_0x00c3:
            int r2 = r2 + 1
            goto L_0x00a2
        L_0x00c6:
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            goto L_0x01d9
        L_0x00c9:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            throw r7
        L_0x00cc:
            r0 = 1
            if (r7 != r0) goto L_0x00dc
            atakplugin.UASTool.afx r7 = r6.f959Y
            r8 = 2
            r7.mo618a((byte) r8)
            atakplugin.UASTool.afx r7 = r6.f959Y
            r7.mo619a((int) r2)
            goto L_0x01d9
        L_0x00dc:
            r1 = 13
            if (r7 != r1) goto L_0x017f
            atakplugin.UASTool.afx r7 = r6.f956V
            byte[] r7 = r7.mo643j()
            atakplugin.UASTool.afx r0 = r6.f956V
            byte[] r0 = r0.mo643j()
            atakplugin.UASTool.afx r1 = r6.f956V
            r1.mo633d()
            java.util.Vector r1 = r9.mo880c()
            monitor-enter(r1)
        L_0x00f6:
            int r9 = r1.size()     // Catch:{ all -> 0x017c }
            r3 = 0
            if (r2 >= r9) goto L_0x015d
            java.lang.Object r9 = r1.elementAt(r2)     // Catch:{ all -> 0x017c }
            atakplugin.UASTool.ahd r9 = (atakplugin.UASTool.ahd) r9     // Catch:{ all -> 0x017c }
            atakplugin.UASTool.ahd r9 = (atakplugin.UASTool.ahd) r9     // Catch:{ all -> 0x017c }
            byte[] r4 = r9.mo868a()     // Catch:{ all -> 0x017c }
            if (r4 != 0) goto L_0x010c
            goto L_0x015a
        L_0x010c:
            byte[] r4 = r9.mo868a()     // Catch:{ all -> 0x017c }
            boolean r4 = atakplugin.UASTool.aji.m1815b((byte[]) r7, (byte[]) r4)     // Catch:{ all -> 0x017c }
            if (r4 != 0) goto L_0x0117
            goto L_0x015a
        L_0x0117:
            boolean r4 = r9.mo873e()     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x0153
            if (r8 != 0) goto L_0x0120
            goto L_0x015a
        L_0x0120:
            boolean r4 = r9.mo873e()     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x0153
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Passphrase for "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = r9.mo872d()     // Catch:{ all -> 0x017c }
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            boolean r4 = r8.mo1172b(r4)     // Catch:{ all -> 0x017c }
            if (r4 != 0) goto L_0x0142
            goto L_0x0153
        L_0x0142:
            java.lang.String r4 = r8.mo1169a()     // Catch:{ all -> 0x017c }
            if (r4 != 0) goto L_0x0149
            goto L_0x0153
        L_0x0149:
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)     // Catch:{ all -> 0x017c }
            boolean r4 = r9.mo867a(r4)     // Catch:{ ahj -> 0x0153 }
            if (r4 == 0) goto L_0x0120
        L_0x0153:
            boolean r4 = r9.mo873e()     // Catch:{ all -> 0x017c }
            if (r4 != 0) goto L_0x015a
            goto L_0x015e
        L_0x015a:
            int r2 = r2 + 1
            goto L_0x00f6
        L_0x015d:
            r9 = r3
        L_0x015e:
            monitor-exit(r1)     // Catch:{ all -> 0x017c }
            if (r9 == 0) goto L_0x0165
            byte[] r3 = r9.mo870b(r0)
        L_0x0165:
            if (r3 != 0) goto L_0x016f
            atakplugin.UASTool.afx r7 = r6.f959Y
            r8 = 30
            r7.mo618a((byte) r8)
            goto L_0x01d9
        L_0x016f:
            atakplugin.UASTool.afx r7 = r6.f959Y
            r8 = 14
            r7.mo618a((byte) r8)
            atakplugin.UASTool.afx r7 = r6.f959Y
            r7.mo627b((byte[]) r3)
            goto L_0x01d9
        L_0x017c:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x017c }
            throw r7
        L_0x017f:
            r8 = 18
            r1 = 6
            if (r7 != r8) goto L_0x0193
            atakplugin.UASTool.afx r7 = r6.f956V
            byte[] r7 = r7.mo643j()
            r9.mo879b(r7)
            atakplugin.UASTool.afx r7 = r6.f959Y
            r7.mo618a((byte) r1)
            goto L_0x01d9
        L_0x0193:
            r8 = 9
            if (r7 != r8) goto L_0x019d
            atakplugin.UASTool.afx r7 = r6.f959Y
            r7.mo618a((byte) r1)
            goto L_0x01d9
        L_0x019d:
            r8 = 19
            if (r7 != r8) goto L_0x01aa
            r9.mo881d()
            atakplugin.UASTool.afx r7 = r6.f959Y
            r7.mo618a((byte) r1)
            goto L_0x01d9
        L_0x01aa:
            r8 = 17
            r2 = 5
            if (r7 != r8) goto L_0x01ca
            atakplugin.UASTool.afx r7 = r6.f956V
            int r7 = r7.mo617a()
            byte[] r7 = new byte[r7]
            atakplugin.UASTool.afx r8 = r6.f956V
            r8.mo635d((byte[]) r7)
            boolean r7 = r9.mo877a(r7)
            atakplugin.UASTool.afx r8 = r6.f959Y
            if (r7 == 0) goto L_0x01c5
            goto L_0x01c6
        L_0x01c5:
            r1 = 5
        L_0x01c6:
            r8.mo618a((byte) r1)
            goto L_0x01d9
        L_0x01ca:
            atakplugin.UASTool.afx r7 = r6.f956V
            int r8 = r7.mo617a()
            int r8 = r8 - r0
            r7.mo626b((int) r8)
            atakplugin.UASTool.afx r7 = r6.f959Y
            r7.mo618a((byte) r2)
        L_0x01d9:
            atakplugin.UASTool.afx r7 = r6.f959Y
            int r7 = r7.mo617a()
            byte[] r7 = new byte[r7]
            atakplugin.UASTool.afx r8 = r6.f959Y
            r8.mo635d((byte[]) r7)
            r6.m981b(r7)
            return
        L_0x01ea:
            r7 = move-exception
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aga.mo658a(byte[], int, int):void");
    }

    /* renamed from: b */
    private void m981b(byte[] bArr) {
        this.f958X.mo996a();
        this.f957W.mo618a((byte) 94);
        this.f957W.mo619a(this.f903j);
        this.f957W.mo619a(bArr.length + 4);
        this.f957W.mo627b(bArr);
        try {
            mo686p().mo1042a(this.f958X, (afy) this, bArr.length + 4);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo679i() {
        super.mo679i();
        mo680j();
    }
}
