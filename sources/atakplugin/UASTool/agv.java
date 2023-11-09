package atakplugin.UASTool;

public class agv extends ahl {

    /* renamed from: J */
    private static final int f1176J = 31;

    /* renamed from: K */
    private static final int f1177K = 32;

    /* renamed from: L */
    private static final int f1178L = 33;

    /* renamed from: M */
    private static final int f1179M = 34;

    /* renamed from: a */
    static int f1180a = 1024;

    /* renamed from: b */
    static int f1181b = 1024;

    /* renamed from: c */
    static int f1182c = 1024;

    /* renamed from: d */
    static final int f1183d = 0;

    /* renamed from: e */
    static final int f1184e = 1;

    /* renamed from: N */
    private int f1185N = 0;

    /* renamed from: O */
    private int f1186O;

    /* renamed from: P */
    private afx f1187P;

    /* renamed from: Q */
    private ahy f1188Q;

    /* renamed from: R */
    private byte[] f1189R;

    /* renamed from: S */
    private byte[] f1190S;

    /* renamed from: T */
    private byte[] f1191T;

    /* renamed from: f */
    ags f1192f;

    /* renamed from: g */
    byte[] f1193g;

    /* renamed from: h */
    byte[] f1194h;

    /* renamed from: i */
    byte[] f1195i;

    /* renamed from: j */
    byte[] f1196j;

    /* renamed from: a */
    public void mo824a(air air, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f1281E = air;
        this.f1193g = bArr;
        this.f1194h = bArr2;
        this.f1195i = bArr3;
        this.f1196j = bArr4;
        try {
            this.f1282F = (agz) Class.forName(air.mo1083i("sha-1")).newInstance();
            this.f1282F.mo834a();
        } catch (Exception e) {
            System.err.println(e);
        }
        this.f1187P = new afx();
        this.f1188Q = new ahy(this.f1187P);
        try {
            ags ags = (ags) Class.forName(air.mo1083i("dh")).newInstance();
            this.f1192f = ags;
            ags.mo817a();
            this.f1188Q.mo996a();
            this.f1187P.mo618a((byte) 34);
            this.f1187P.mo619a(f1180a);
            this.f1187P.mo619a(f1181b);
            this.f1187P.mo619a(f1182c);
            air.mo1061b(this.f1188Q);
            if (ahg.m1351f().mo908a(1)) {
                ahu f = ahg.m1351f();
                f.mo907a(1, "SSH_MSG_KEX_DH_GEX_REQUEST(" + f1180a + "<" + f1181b + "<" + f1182c + ") sent");
                ahg.m1351f().mo907a(1, "expecting SSH_MSG_KEX_DH_GEX_GROUP");
            }
            this.f1186O = 31;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v96, resolved type: atakplugin.UASTool.aiy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: atakplugin.UASTool.aix} */
    /* JADX WARNING: type inference failed for: r0v85, types: [atakplugin.UASTool.aiy] */
    /* JADX WARNING: type inference failed for: r0v90 */
    /* JADX WARNING: type inference failed for: r0v98 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x02af  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo825a(atakplugin.UASTool.afx r12) {
        /*
            r11 = this;
            int r0 = r11.f1186O
            r1 = 31
            r2 = 33
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L_0x02d3
            if (r0 == r2) goto L_0x000d
            return r3
        L_0x000d:
            r12.mo633d()
            r12.mo640g()
            int r0 = r12.mo640g()
            if (r0 == r2) goto L_0x0030
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "type: must be SSH_MSG_KEX_DH_GEX_REPLY "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r12.println(r0)
            return r3
        L_0x0030:
            byte[] r0 = r12.mo643j()
            r11.f1285I = r0
            byte[] r0 = r12.mo641h()
            byte[] r12 = r12.mo643j()
            atakplugin.UASTool.ags r1 = r11.f1192f
            r1.mo821c(r0)
            atakplugin.UASTool.ags r1 = r11.f1192f
            byte[] r1 = r1.mo822c()
            byte[] r1 = r11.mo912a((byte[]) r1)
            r11.f1283G = r1
            atakplugin.UASTool.afx r1 = r11.f1187P
            r1.mo644k()
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1194h
            r1.mo627b((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1193g
            r1.mo627b((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1196j
            r1.mo627b((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1195i
            r1.mo627b((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1285I
            r1.mo627b((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            int r2 = f1180a
            r1.mo619a((int) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            int r2 = f1181b
            r1.mo619a((int) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            int r2 = f1182c
            r1.mo619a((int) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1189R
            r1.mo631c((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1190S
            r1.mo631c((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            byte[] r2 = r11.f1191T
            r1.mo631c((byte[]) r2)
            atakplugin.UASTool.afx r1 = r11.f1187P
            r1.mo631c((byte[]) r0)
            atakplugin.UASTool.afx r0 = r11.f1187P
            byte[] r1 = r11.f1283G
            r0.mo631c((byte[]) r1)
            atakplugin.UASTool.afx r0 = r11.f1187P
            int r0 = r0.mo617a()
            byte[] r1 = new byte[r0]
            atakplugin.UASTool.afx r2 = r11.f1187P
            r2.mo635d((byte[]) r1)
            atakplugin.UASTool.agz r2 = r11.f1282F
            r2.mo835a(r1, r3, r0)
            atakplugin.UASTool.agz r0 = r11.f1282F
            byte[] r0 = r0.mo837c()
            r11.f1284H = r0
            byte[] r0 = r11.f1285I
            byte r0 = r0[r3]
            int r0 = r0 << 24
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r1
            byte[] r2 = r11.f1285I
            r5 = 2
            byte r2 = r2[r4]
            int r2 = r2 << 16
            r6 = 16711680(0xff0000, float:2.3418052E-38)
            r2 = r2 & r6
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            r7 = 3
            byte r2 = r2[r5]
            int r2 = r2 << 8
            r5 = 65280(0xff00, float:9.1477E-41)
            r2 = r2 & r5
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            r8 = 4
            byte r2 = r2[r7]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            java.lang.String r2 = atakplugin.UASTool.aji.m1819c(r2, r8, r0)
            int r8 = r8 + r0
            java.lang.String r0 = "ssh-rsa"
            boolean r0 = r2.equals(r0)
            r7 = 0
            if (r0 == 0) goto L_0x01ae
            r11.f1185N = r3
            byte[] r0 = r11.f1285I
            int r2 = r8 + 1
            byte r0 = r0[r8]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r8 = r11.f1285I
            int r9 = r2 + 1
            byte r2 = r8[r2]
            int r2 = r2 << 16
            r2 = r2 & r6
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            int r8 = r9 + 1
            byte r2 = r2[r9]
            int r2 = r2 << 8
            r2 = r2 & r5
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            int r9 = r8 + 1
            byte r2 = r2[r8]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r0 = r0 | r2
            byte[] r2 = new byte[r0]
            byte[] r8 = r11.f1285I
            java.lang.System.arraycopy(r8, r9, r2, r3, r0)
            int r9 = r9 + r0
            byte[] r0 = r11.f1285I
            int r8 = r9 + 1
            byte r0 = r0[r9]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r1 = r11.f1285I
            int r9 = r8 + 1
            byte r1 = r1[r8]
            int r1 = r1 << 16
            r1 = r1 & r6
            r0 = r0 | r1
            byte[] r1 = r11.f1285I
            int r6 = r9 + 1
            byte r1 = r1[r9]
            int r1 = r1 << 8
            r1 = r1 & r5
            r0 = r0 | r1
            byte[] r1 = r11.f1285I
            int r5 = r6 + 1
            byte r1 = r1[r6]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
            byte[] r1 = new byte[r0]
            byte[] r6 = r11.f1285I
            java.lang.System.arraycopy(r6, r5, r1, r3, r0)
            atakplugin.UASTool.air r0 = r11.f1281E     // Catch:{ Exception -> 0x0177 }
            java.lang.String r5 = "signature.rsa"
            java.lang.String r0 = r0.mo1083i(r5)     // Catch:{ Exception -> 0x0177 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0177 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0177 }
            atakplugin.UASTool.aiy r0 = (atakplugin.UASTool.aiy) r0     // Catch:{ Exception -> 0x0177 }
            atakplugin.UASTool.aiy r0 = (atakplugin.UASTool.aiy) r0     // Catch:{ Exception -> 0x0177 }
            r0.mo1154a()     // Catch:{ Exception -> 0x0174 }
            goto L_0x017e
        L_0x0174:
            r5 = move-exception
            r7 = r0
            goto L_0x0178
        L_0x0177:
            r5 = move-exception
        L_0x0178:
            java.io.PrintStream r0 = java.lang.System.err
            r0.println(r5)
            r0 = r7
        L_0x017e:
            r0.mo1160a(r2, r1)
            byte[] r1 = r11.f1284H
            r0.mo1155a(r1)
            boolean r12 = r0.mo1156b(r12)
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            boolean r0 = r0.mo908a(r4)
            if (r0 == 0) goto L_0x02d0
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ssh_rsa_verify: signature "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.mo907a(r4, r1)
            goto L_0x02d0
        L_0x01ae:
            java.lang.String r0 = "ssh-dss"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x02c8
            r11.f1185N = r4
            byte[] r0 = r11.f1285I
            int r2 = r8 + 1
            byte r0 = r0[r8]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r8 = r11.f1285I
            int r9 = r2 + 1
            byte r2 = r8[r2]
            int r2 = r2 << 16
            r2 = r2 & r6
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            int r8 = r9 + 1
            byte r2 = r2[r9]
            int r2 = r2 << 8
            r2 = r2 & r5
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            int r9 = r8 + 1
            byte r2 = r2[r8]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r0 = r0 | r2
            byte[] r2 = new byte[r0]
            byte[] r8 = r11.f1285I
            java.lang.System.arraycopy(r8, r9, r2, r3, r0)
            int r9 = r9 + r0
            r11.f1189R = r2
            byte[] r0 = r11.f1285I
            int r2 = r9 + 1
            byte r0 = r0[r9]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r8 = r11.f1285I
            int r9 = r2 + 1
            byte r2 = r8[r2]
            int r2 = r2 << 16
            r2 = r2 & r6
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            int r8 = r9 + 1
            byte r2 = r2[r9]
            int r2 = r2 << 8
            r2 = r2 & r5
            r0 = r0 | r2
            byte[] r2 = r11.f1285I
            int r9 = r8 + 1
            byte r2 = r2[r8]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r0 = r0 | r2
            byte[] r2 = new byte[r0]
            byte[] r8 = r11.f1285I
            java.lang.System.arraycopy(r8, r9, r2, r3, r0)
            int r9 = r9 + r0
            byte[] r0 = r11.f1285I
            int r8 = r9 + 1
            byte r0 = r0[r9]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r9 = r11.f1285I
            int r10 = r8 + 1
            byte r8 = r9[r8]
            int r8 = r8 << 16
            r8 = r8 & r6
            r0 = r0 | r8
            byte[] r8 = r11.f1285I
            int r9 = r10 + 1
            byte r8 = r8[r10]
            int r8 = r8 << 8
            r8 = r8 & r5
            r0 = r0 | r8
            byte[] r8 = r11.f1285I
            int r10 = r9 + 1
            byte r8 = r8[r9]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r0 = r0 | r8
            byte[] r8 = new byte[r0]
            byte[] r9 = r11.f1285I
            java.lang.System.arraycopy(r9, r10, r8, r3, r0)
            int r10 = r10 + r0
            r11.f1190S = r8
            byte[] r0 = r11.f1285I
            int r8 = r10 + 1
            byte r0 = r0[r10]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r1 = r11.f1285I
            int r9 = r8 + 1
            byte r1 = r1[r8]
            int r1 = r1 << 16
            r1 = r1 & r6
            r0 = r0 | r1
            byte[] r1 = r11.f1285I
            int r6 = r9 + 1
            byte r1 = r1[r9]
            int r1 = r1 << 8
            r1 = r1 & r5
            r0 = r0 | r1
            byte[] r1 = r11.f1285I
            int r5 = r6 + 1
            byte r1 = r1[r6]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
            byte[] r1 = new byte[r0]
            byte[] r6 = r11.f1285I
            java.lang.System.arraycopy(r6, r5, r1, r3, r0)
            atakplugin.UASTool.air r0 = r11.f1281E     // Catch:{ Exception -> 0x028e }
            java.lang.String r5 = "signature.dss"
            java.lang.String r0 = r0.mo1083i(r5)     // Catch:{ Exception -> 0x028e }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x028e }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x028e }
            atakplugin.UASTool.aix r0 = (atakplugin.UASTool.aix) r0     // Catch:{ Exception -> 0x028e }
            atakplugin.UASTool.aix r0 = (atakplugin.UASTool.aix) r0     // Catch:{ Exception -> 0x028e }
            r0.mo1154a()     // Catch:{ Exception -> 0x028b }
            goto L_0x0295
        L_0x028b:
            r5 = move-exception
            r7 = r0
            goto L_0x028f
        L_0x028e:
            r5 = move-exception
        L_0x028f:
            java.io.PrintStream r0 = java.lang.System.err
            r0.println(r5)
            r0 = r7
        L_0x0295:
            byte[] r5 = r11.f1189R
            byte[] r6 = r11.f1190S
            r0.mo1158a(r1, r5, r2, r6)
            byte[] r1 = r11.f1284H
            r0.mo1155a(r1)
            boolean r12 = r0.mo1156b(r12)
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            boolean r0 = r0.mo908a(r4)
            if (r0 == 0) goto L_0x02d0
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ssh_dss_verify: signature "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.mo907a(r4, r1)
            goto L_0x02d0
        L_0x02c8:
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.String r0 = "unknown alg"
            r12.println(r0)
            r12 = 0
        L_0x02d0:
            r11.f1186O = r3
            return r12
        L_0x02d3:
            r12.mo633d()
            r12.mo640g()
            int r0 = r12.mo640g()
            if (r0 == r1) goto L_0x02f6
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "type: must be SSH_MSG_KEX_DH_GEX_GROUP "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r12.println(r0)
            return r3
        L_0x02f6:
            byte[] r0 = r12.mo641h()
            r11.f1189R = r0
            byte[] r12 = r12.mo641h()
            r11.f1190S = r12
            atakplugin.UASTool.ags r12 = r11.f1192f
            byte[] r0 = r11.f1189R
            r12.mo818a(r0)
            atakplugin.UASTool.ags r12 = r11.f1192f
            byte[] r0 = r11.f1190S
            r12.mo819b(r0)
            atakplugin.UASTool.ags r12 = r11.f1192f
            byte[] r12 = r12.mo820b()
            r11.f1191T = r12
            atakplugin.UASTool.ahy r12 = r11.f1188Q
            r12.mo996a()
            atakplugin.UASTool.afx r12 = r11.f1187P
            r0 = 32
            r12.mo618a((byte) r0)
            atakplugin.UASTool.afx r12 = r11.f1187P
            byte[] r0 = r11.f1191T
            r12.mo631c((byte[]) r0)
            atakplugin.UASTool.air r12 = r11.f1281E
            atakplugin.UASTool.ahy r0 = r11.f1188Q
            r12.mo1061b((atakplugin.UASTool.ahy) r0)
            atakplugin.UASTool.ahu r12 = atakplugin.UASTool.ahg.m1351f()
            boolean r12 = r12.mo908a(r4)
            if (r12 == 0) goto L_0x034e
            atakplugin.UASTool.ahu r12 = atakplugin.UASTool.ahg.m1351f()
            java.lang.String r0 = "SSH_MSG_KEX_DH_GEX_INIT sent"
            r12.mo907a(r4, r0)
            atakplugin.UASTool.ahu r12 = atakplugin.UASTool.ahg.m1351f()
            java.lang.String r0 = "expecting SSH_MSG_KEX_DH_GEX_REPLY"
            r12.mo907a(r4, r0)
        L_0x034e:
            r11.f1186O = r2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agv.mo825a(atakplugin.UASTool.afx):boolean");
    }

    /* renamed from: a */
    public String mo823a() {
        return this.f1185N == 1 ? "DSA" : "RSA";
    }

    /* renamed from: b */
    public int mo826b() {
        return this.f1186O;
    }
}
