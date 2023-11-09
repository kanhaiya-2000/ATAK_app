package atakplugin.UASTool;

import com.google.common.base.Ascii;

public class agu extends ahl {

    /* renamed from: J */
    private static final int f1160J = 30;

    /* renamed from: K */
    private static final int f1161K = 31;

    /* renamed from: a */
    static final byte[] f1162a = {2};

    /* renamed from: b */
    static final byte[] f1163b = {0, -1, -1, -1, -1, -1, -1, -1, -1, -55, Ascii.f8523SI, -38, -94, 33, 104, -62, 52, -60, -58, 98, -117, Byte.MIN_VALUE, -36, Ascii.f8517FS, -47, 41, 2, 78, 8, -118, 103, -52, 116, 2, Ascii.f8527VT, -66, -90, 59, 19, -101, 34, 81, 74, 8, 121, -114, 52, 4, -35, -17, -107, Ascii.f8515EM, -77, -51, 58, 67, Ascii.ESC, 48, 43, 10, 109, -14, 95, Ascii.DC4, 55, 79, -31, 53, 109, 109, 81, -62, 69, -28, -123, -75, 118, 98, 94, 126, -58, -12, 76, 66, -23, -90, 55, -19, 107, Ascii.f8527VT, -1, 92, -74, -12, 6, -73, -19, -18, 56, 107, -5, 90, -119, -97, -91, -82, -97, 36, 17, 124, 75, Ascii.f8526US, -26, 73, 40, 102, 81, -20, -28, 91, 61, -62, 0, 124, -72, -95, 99, -65, 5, -104, -38, 72, 54, Ascii.f8517FS, 85, -45, -102, 105, Ascii.SYN, bxu.f4219a, -88, -3, 36, -49, 95, -125, 101, 93, 35, -36, -93, -83, -106, Ascii.f8517FS, 98, -13, 86, 32, -123, 82, -69, -98, -43, 41, 7, 112, -106, -106, 109, 103, Ascii.f8516FF, 53, 78, 74, -68, -104, 4, -15, 116, 108, 8, -54, Ascii.CAN, 33, 124, 50, -112, 94, 70, 46, 54, -50, 59, -29, -98, 119, 44, Ascii.CAN, Ascii.f8524SO, -122, 3, -101, 39, -125, -94, -20, 7, -94, -113, -75, -59, 93, -16, 111, 76, 82, -55, -34, 43, -53, -10, -107, 88, Ascii.ETB, Ascii.CAN, 57, -107, 73, 124, -22, -107, 106, -27, Ascii.NAK, -46, 38, Ascii.CAN, -104, -6, 5, 16, Ascii.NAK, 114, -114, 90, -118, -84, -86, 104, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: c */
    static final int f1164c = 0;

    /* renamed from: d */
    static final int f1165d = 1;

    /* renamed from: L */
    private int f1166L = 0;

    /* renamed from: M */
    private int f1167M;

    /* renamed from: N */
    private afx f1168N;

    /* renamed from: O */
    private ahy f1169O;

    /* renamed from: e */
    ags f1170e;

    /* renamed from: f */
    byte[] f1171f;

    /* renamed from: g */
    byte[] f1172g;

    /* renamed from: h */
    byte[] f1173h;

    /* renamed from: i */
    byte[] f1174i;

    /* renamed from: j */
    byte[] f1175j;

    /* renamed from: a */
    public void mo824a(air air, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f1281E = air;
        this.f1171f = bArr;
        this.f1172g = bArr2;
        this.f1173h = bArr3;
        this.f1174i = bArr4;
        try {
            this.f1282F = (agz) Class.forName(air.mo1083i("sha-1")).newInstance();
            this.f1282F.mo834a();
        } catch (Exception e) {
            System.err.println(e);
        }
        this.f1168N = new afx();
        this.f1169O = new ahy(this.f1168N);
        try {
            ags ags = (ags) Class.forName(air.mo1083i("dh")).newInstance();
            this.f1170e = ags;
            ags.mo817a();
            this.f1170e.mo818a(f1163b);
            this.f1170e.mo819b(f1162a);
            this.f1175j = this.f1170e.mo820b();
            this.f1169O.mo996a();
            this.f1168N.mo618a((byte) Ascii.f8522RS);
            this.f1168N.mo631c(this.f1175j);
            if (bArr != null) {
                air.mo1061b(this.f1169O);
                if (ahg.m1351f().mo908a(1)) {
                    ahg.m1351f().mo907a(1, "SSH_MSG_KEXDH_INIT sent");
                    ahg.m1351f().mo907a(1, "expecting SSH_MSG_KEXDH_REPLY");
                }
                this.f1167M = 31;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: atakplugin.UASTool.aix} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v86, resolved type: atakplugin.UASTool.aiy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: atakplugin.UASTool.aix} */
    /* JADX WARNING: type inference failed for: r0v75, types: [atakplugin.UASTool.aiy] */
    /* JADX WARNING: type inference failed for: r0v80 */
    /* JADX WARNING: type inference failed for: r0v88 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0280  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo825a(atakplugin.UASTool.afx r13) {
        /*
            r12 = this;
            int r0 = r12.f1167M
            r1 = 31
            r2 = 0
            if (r0 == r1) goto L_0x0008
            return r2
        L_0x0008:
            r13.mo633d()
            r13.mo640g()
            int r0 = r13.mo640g()
            if (r0 == r1) goto L_0x002b
            java.io.PrintStream r13 = java.lang.System.err
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "type: must be 31 "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r13.println(r0)
            return r2
        L_0x002b:
            byte[] r0 = r13.mo643j()
            r12.f1285I = r0
            byte[] r0 = r13.mo641h()
            byte[] r13 = r13.mo643j()
            atakplugin.UASTool.ags r1 = r12.f1170e
            r1.mo821c(r0)
            atakplugin.UASTool.ags r1 = r12.f1170e
            byte[] r1 = r1.mo822c()
            byte[] r1 = r12.mo912a((byte[]) r1)
            r12.f1283G = r1
            atakplugin.UASTool.afx r1 = r12.f1168N
            r1.mo644k()
            atakplugin.UASTool.afx r1 = r12.f1168N
            byte[] r3 = r12.f1172g
            r1.mo627b((byte[]) r3)
            atakplugin.UASTool.afx r1 = r12.f1168N
            byte[] r3 = r12.f1171f
            r1.mo627b((byte[]) r3)
            atakplugin.UASTool.afx r1 = r12.f1168N
            byte[] r3 = r12.f1174i
            r1.mo627b((byte[]) r3)
            atakplugin.UASTool.afx r1 = r12.f1168N
            byte[] r3 = r12.f1173h
            r1.mo627b((byte[]) r3)
            atakplugin.UASTool.afx r1 = r12.f1168N
            byte[] r3 = r12.f1285I
            r1.mo627b((byte[]) r3)
            atakplugin.UASTool.afx r1 = r12.f1168N
            byte[] r3 = r12.f1175j
            r1.mo631c((byte[]) r3)
            atakplugin.UASTool.afx r1 = r12.f1168N
            r1.mo631c((byte[]) r0)
            atakplugin.UASTool.afx r0 = r12.f1168N
            byte[] r1 = r12.f1283G
            r0.mo631c((byte[]) r1)
            atakplugin.UASTool.afx r0 = r12.f1168N
            int r0 = r0.mo617a()
            byte[] r1 = new byte[r0]
            atakplugin.UASTool.afx r3 = r12.f1168N
            r3.mo635d((byte[]) r1)
            atakplugin.UASTool.agz r3 = r12.f1282F
            r3.mo835a(r1, r2, r0)
            atakplugin.UASTool.agz r0 = r12.f1282F
            byte[] r0 = r0.mo837c()
            r12.f1284H = r0
            byte[] r0 = r12.f1285I
            byte r0 = r0[r2]
            int r0 = r0 << 24
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r1
            byte[] r3 = r12.f1285I
            r4 = 2
            r5 = 1
            byte r3 = r3[r5]
            int r3 = r3 << 16
            r6 = 16711680(0xff0000, float:2.3418052E-38)
            r3 = r3 & r6
            r0 = r0 | r3
            byte[] r3 = r12.f1285I
            r7 = 3
            byte r3 = r3[r4]
            int r3 = r3 << 8
            r4 = 65280(0xff00, float:9.1477E-41)
            r3 = r3 & r4
            r0 = r0 | r3
            byte[] r3 = r12.f1285I
            r8 = 4
            byte r3 = r3[r7]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r0 = r0 | r3
            byte[] r3 = r12.f1285I
            java.lang.String r3 = atakplugin.UASTool.aji.m1819c(r3, r8, r0)
            int r8 = r8 + r0
            java.lang.String r0 = "ssh-rsa"
            boolean r0 = r3.equals(r0)
            r7 = 0
            if (r0 == 0) goto L_0x0187
            r12.f1166L = r2
            byte[] r0 = r12.f1285I
            int r3 = r8 + 1
            byte r0 = r0[r8]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r8 = r12.f1285I
            int r9 = r3 + 1
            byte r3 = r8[r3]
            int r3 = r3 << 16
            r3 = r3 & r6
            r0 = r0 | r3
            byte[] r3 = r12.f1285I
            int r8 = r9 + 1
            byte r3 = r3[r9]
            int r3 = r3 << 8
            r3 = r3 & r4
            r0 = r0 | r3
            byte[] r3 = r12.f1285I
            int r9 = r8 + 1
            byte r3 = r3[r8]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r0 = r0 | r3
            byte[] r3 = new byte[r0]
            byte[] r8 = r12.f1285I
            java.lang.System.arraycopy(r8, r9, r3, r2, r0)
            int r9 = r9 + r0
            byte[] r0 = r12.f1285I
            int r8 = r9 + 1
            byte r0 = r0[r9]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r1 = r12.f1285I
            int r9 = r8 + 1
            byte r1 = r1[r8]
            int r1 = r1 << 16
            r1 = r1 & r6
            r0 = r0 | r1
            byte[] r1 = r12.f1285I
            int r6 = r9 + 1
            byte r1 = r1[r9]
            int r1 = r1 << 8
            r1 = r1 & r4
            r0 = r0 | r1
            byte[] r1 = r12.f1285I
            int r4 = r6 + 1
            byte r1 = r1[r6]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
            byte[] r1 = new byte[r0]
            byte[] r6 = r12.f1285I
            java.lang.System.arraycopy(r6, r4, r1, r2, r0)
            atakplugin.UASTool.air r0 = r12.f1281E     // Catch:{ Exception -> 0x0150 }
            java.lang.String r4 = "signature.rsa"
            java.lang.String r0 = r0.mo1083i(r4)     // Catch:{ Exception -> 0x0150 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0150 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0150 }
            atakplugin.UASTool.aiy r0 = (atakplugin.UASTool.aiy) r0     // Catch:{ Exception -> 0x0150 }
            atakplugin.UASTool.aiy r0 = (atakplugin.UASTool.aiy) r0     // Catch:{ Exception -> 0x0150 }
            r0.mo1154a()     // Catch:{ Exception -> 0x014d }
            goto L_0x0157
        L_0x014d:
            r4 = move-exception
            r7 = r0
            goto L_0x0151
        L_0x0150:
            r4 = move-exception
        L_0x0151:
            java.io.PrintStream r0 = java.lang.System.err
            r0.println(r4)
            r0 = r7
        L_0x0157:
            r0.mo1160a(r3, r1)
            byte[] r1 = r12.f1284H
            r0.mo1155a(r1)
            boolean r13 = r0.mo1156b(r13)
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            boolean r0 = r0.mo908a(r5)
            if (r0 == 0) goto L_0x02a1
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "ssh_rsa_verify: signature "
            r1.append(r3)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r0.mo907a(r5, r1)
            goto L_0x02a1
        L_0x0187:
            java.lang.String r0 = "ssh-dss"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0299
            r12.f1166L = r5
            byte[] r0 = r12.f1285I
            int r3 = r8 + 1
            byte r0 = r0[r8]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r8 = r12.f1285I
            int r9 = r3 + 1
            byte r3 = r8[r3]
            int r3 = r3 << 16
            r3 = r3 & r6
            r0 = r0 | r3
            byte[] r3 = r12.f1285I
            int r8 = r9 + 1
            byte r3 = r3[r9]
            int r3 = r3 << 8
            r3 = r3 & r4
            r0 = r0 | r3
            byte[] r3 = r12.f1285I
            int r9 = r8 + 1
            byte r3 = r3[r8]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r0 = r0 | r3
            byte[] r3 = new byte[r0]
            byte[] r8 = r12.f1285I
            java.lang.System.arraycopy(r8, r9, r3, r2, r0)
            int r9 = r9 + r0
            byte[] r0 = r12.f1285I
            int r8 = r9 + 1
            byte r0 = r0[r9]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r9 = r12.f1285I
            int r10 = r8 + 1
            byte r8 = r9[r8]
            int r8 = r8 << 16
            r8 = r8 & r6
            r0 = r0 | r8
            byte[] r8 = r12.f1285I
            int r9 = r10 + 1
            byte r8 = r8[r10]
            int r8 = r8 << 8
            r8 = r8 & r4
            r0 = r0 | r8
            byte[] r8 = r12.f1285I
            int r10 = r9 + 1
            byte r8 = r8[r9]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r0 = r0 | r8
            byte[] r8 = new byte[r0]
            byte[] r9 = r12.f1285I
            java.lang.System.arraycopy(r9, r10, r8, r2, r0)
            int r10 = r10 + r0
            byte[] r0 = r12.f1285I
            int r9 = r10 + 1
            byte r0 = r0[r10]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r10 = r12.f1285I
            int r11 = r9 + 1
            byte r9 = r10[r9]
            int r9 = r9 << 16
            r9 = r9 & r6
            r0 = r0 | r9
            byte[] r9 = r12.f1285I
            int r10 = r11 + 1
            byte r9 = r9[r11]
            int r9 = r9 << 8
            r9 = r9 & r4
            r0 = r0 | r9
            byte[] r9 = r12.f1285I
            int r11 = r10 + 1
            byte r9 = r9[r10]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r0 = r0 | r9
            byte[] r9 = new byte[r0]
            byte[] r10 = r12.f1285I
            java.lang.System.arraycopy(r10, r11, r9, r2, r0)
            int r11 = r11 + r0
            byte[] r0 = r12.f1285I
            int r10 = r11 + 1
            byte r0 = r0[r11]
            int r0 = r0 << 24
            r0 = r0 & r1
            byte[] r1 = r12.f1285I
            int r11 = r10 + 1
            byte r1 = r1[r10]
            int r1 = r1 << 16
            r1 = r1 & r6
            r0 = r0 | r1
            byte[] r1 = r12.f1285I
            int r6 = r11 + 1
            byte r1 = r1[r11]
            int r1 = r1 << 8
            r1 = r1 & r4
            r0 = r0 | r1
            byte[] r1 = r12.f1285I
            int r4 = r6 + 1
            byte r1 = r1[r6]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
            byte[] r1 = new byte[r0]
            byte[] r6 = r12.f1285I
            java.lang.System.arraycopy(r6, r4, r1, r2, r0)
            atakplugin.UASTool.air r0 = r12.f1281E     // Catch:{ Exception -> 0x0263 }
            java.lang.String r4 = "signature.dss"
            java.lang.String r0 = r0.mo1083i(r4)     // Catch:{ Exception -> 0x0263 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0263 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0263 }
            atakplugin.UASTool.aix r0 = (atakplugin.UASTool.aix) r0     // Catch:{ Exception -> 0x0263 }
            atakplugin.UASTool.aix r0 = (atakplugin.UASTool.aix) r0     // Catch:{ Exception -> 0x0263 }
            r0.mo1154a()     // Catch:{ Exception -> 0x0260 }
            goto L_0x026a
        L_0x0260:
            r4 = move-exception
            r7 = r0
            goto L_0x0264
        L_0x0263:
            r4 = move-exception
        L_0x0264:
            java.io.PrintStream r0 = java.lang.System.err
            r0.println(r4)
            r0 = r7
        L_0x026a:
            r0.mo1158a(r1, r3, r8, r9)
            byte[] r1 = r12.f1284H
            r0.mo1155a(r1)
            boolean r13 = r0.mo1156b(r13)
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            boolean r0 = r0.mo908a(r5)
            if (r0 == 0) goto L_0x02a1
            atakplugin.UASTool.ahu r0 = atakplugin.UASTool.ahg.m1351f()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "ssh_dss_verify: signature "
            r1.append(r3)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r0.mo907a(r5, r1)
            goto L_0x02a1
        L_0x0299:
            java.io.PrintStream r13 = java.lang.System.err
            java.lang.String r0 = "unknown alg"
            r13.println(r0)
            r13 = 0
        L_0x02a1:
            r12.f1167M = r2
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.agu.mo825a(atakplugin.UASTool.afx):boolean");
    }

    /* renamed from: a */
    public String mo823a() {
        return this.f1166L == 1 ? "DSA" : "RSA";
    }

    /* renamed from: b */
    public int mo826b() {
        return this.f1167M;
    }
}
