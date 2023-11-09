package atakplugin.UASTool;

import com.google.common.base.Ascii;

public class ajc extends ajb {

    /* renamed from: l */
    private static final int f1610l = 60;

    /* renamed from: m */
    private static final int f1611m = 61;

    /* renamed from: n */
    private static final int f1612n = 63;

    /* renamed from: o */
    private static final int f1613o = 64;

    /* renamed from: p */
    private static final int f1614p = 65;

    /* renamed from: q */
    private static final int f1615q = 66;

    /* renamed from: r */
    private static final byte[][] f1616r = {new byte[]{6, 9, 42, -122, 72, -122, -9, Ascii.DC2, 1, 2, 2}};

    /* renamed from: s */
    private static final String[] f1617s = {"gssapi-with-mic.krb5"};

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0112 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo1167a(atakplugin.UASTool.air r12) {
        /*
            r11 = this;
            super.mo1167a(r12)
            java.lang.String r0 = r11.f1609k
            byte[] r0 = atakplugin.UASTool.aji.m1820c((java.lang.String) r0)
            atakplugin.UASTool.ahy r1 = r11.f1607i
            r1.mo996a()
            atakplugin.UASTool.afx r1 = r11.f1608j
            r2 = 50
            r1.mo618a((byte) r2)
            atakplugin.UASTool.afx r1 = r11.f1608j
            r1.mo627b((byte[]) r0)
            atakplugin.UASTool.afx r1 = r11.f1608j
            java.lang.String r3 = "ssh-connection"
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r3)
            r1.mo627b((byte[]) r4)
            atakplugin.UASTool.afx r1 = r11.f1608j
            java.lang.String r4 = "gssapi-with-mic"
            byte[] r5 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)
            r1.mo627b((byte[]) r5)
            atakplugin.UASTool.afx r1 = r11.f1608j
            byte[][] r5 = f1616r
            int r5 = r5.length
            r1.mo619a((int) r5)
            r1 = 0
            r5 = 0
        L_0x003a:
            byte[][] r6 = f1616r
            int r7 = r6.length
            if (r5 >= r7) goto L_0x0049
            atakplugin.UASTool.afx r7 = r11.f1608j
            r6 = r6[r5]
            r7.mo627b((byte[]) r6)
            int r5 = r5 + 1
            goto L_0x003a
        L_0x0049:
            atakplugin.UASTool.ahy r5 = r11.f1607i
            r12.mo1061b((atakplugin.UASTool.ahy) r5)
            r5 = 0
        L_0x004f:
            atakplugin.UASTool.afx r6 = r11.f1608j
            atakplugin.UASTool.afx r6 = r12.mo1031a((atakplugin.UASTool.afx) r6)
            r11.f1608j = r6
            atakplugin.UASTool.afx r6 = r11.f1608j
            byte r6 = r6.mo647n()
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = 51
            if (r6 != r7) goto L_0x0064
            return r1
        L_0x0064:
            r8 = 60
            if (r6 != r8) goto L_0x01b1
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo633d()
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo640g()
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo640g()
            atakplugin.UASTool.afx r6 = r11.f1608j
            byte[] r6 = r6.mo643j()
            r8 = 0
        L_0x007e:
            byte[][] r9 = f1616r
            int r10 = r9.length
            if (r8 >= r10) goto L_0x0093
            r9 = r9[r8]
            boolean r9 = atakplugin.UASTool.aji.m1815b((byte[]) r6, (byte[]) r9)
            if (r9 == 0) goto L_0x0090
            java.lang.String[] r5 = f1617s
            r5 = r5[r8]
            goto L_0x0093
        L_0x0090:
            int r8 = r8 + 1
            goto L_0x007e
        L_0x0093:
            if (r5 != 0) goto L_0x0096
            return r1
        L_0x0096:
            java.lang.String r5 = r12.mo1083i(r5)     // Catch:{ Exception -> 0x01b0 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x01b0 }
            java.lang.Object r5 = r5.newInstance()     // Catch:{ Exception -> 0x01b0 }
            atakplugin.UASTool.agy r5 = (atakplugin.UASTool.agy) r5     // Catch:{ Exception -> 0x01b0 }
            atakplugin.UASTool.agy r5 = (atakplugin.UASTool.agy) r5     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r6 = r11.f1609k     // Catch:{  }
            java.lang.String r8 = r12.f1475P     // Catch:{  }
            r5.mo829a(r6, r8)     // Catch:{  }
            byte[] r6 = new byte[r1]
        L_0x00af:
            boolean r8 = r5.mo830a()
            if (r8 != 0) goto L_0x012a
            int r8 = r6.length     // Catch:{ ahj -> 0x0129 }
            byte[] r6 = r5.mo831a(r6, r1, r8)     // Catch:{ ahj -> 0x0129 }
            if (r6 == 0) goto L_0x00d2
            atakplugin.UASTool.ahy r8 = r11.f1607i
            r8.mo996a()
            atakplugin.UASTool.afx r8 = r11.f1608j
            r9 = 61
            r8.mo618a((byte) r9)
            atakplugin.UASTool.afx r8 = r11.f1608j
            r8.mo627b((byte[]) r6)
            atakplugin.UASTool.ahy r8 = r11.f1607i
            r12.mo1061b((atakplugin.UASTool.ahy) r8)
        L_0x00d2:
            boolean r8 = r5.mo830a()
            if (r8 != 0) goto L_0x00af
            atakplugin.UASTool.afx r6 = r11.f1608j
            atakplugin.UASTool.afx r6 = r12.mo1031a((atakplugin.UASTool.afx) r6)
            r11.f1608j = r6
            atakplugin.UASTool.afx r6 = r11.f1608j
            byte r6 = r6.mo647n()
            r6 = r6 & 255(0xff, float:3.57E-43)
            r8 = 64
            if (r6 != r8) goto L_0x00fd
            atakplugin.UASTool.afx r6 = r11.f1608j
            atakplugin.UASTool.afx r6 = r12.mo1031a((atakplugin.UASTool.afx) r6)
            r11.f1608j = r6
            atakplugin.UASTool.afx r6 = r11.f1608j
            byte r6 = r6.mo647n()
        L_0x00fa:
            r6 = r6 & 255(0xff, float:3.57E-43)
            goto L_0x0110
        L_0x00fd:
            r8 = 65
            if (r6 != r8) goto L_0x0110
            atakplugin.UASTool.afx r6 = r11.f1608j
            atakplugin.UASTool.afx r6 = r12.mo1031a((atakplugin.UASTool.afx) r6)
            r11.f1608j = r6
            atakplugin.UASTool.afx r6 = r11.f1608j
            byte r6 = r6.mo647n()
            goto L_0x00fa
        L_0x0110:
            if (r6 != r7) goto L_0x0113
            return r1
        L_0x0113:
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo633d()
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo640g()
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo640g()
            atakplugin.UASTool.afx r6 = r11.f1608j
            byte[] r6 = r6.mo643j()
            goto L_0x00af
        L_0x0129:
            return r1
        L_0x012a:
            atakplugin.UASTool.afx r6 = new atakplugin.UASTool.afx
            r6.<init>()
            byte[] r8 = r12.mo1066c()
            r6.mo627b((byte[]) r8)
            r6.mo618a((byte) r2)
            r6.mo627b((byte[]) r0)
            byte[] r0 = atakplugin.UASTool.aji.m1820c((java.lang.String) r3)
            r6.mo627b((byte[]) r0)
            byte[] r0 = atakplugin.UASTool.aji.m1820c((java.lang.String) r4)
            r6.mo627b((byte[]) r0)
            byte[] r0 = r6.f888b
            int r2 = r6.mo617a()
            byte[] r0 = r5.mo833b(r0, r1, r2)
            if (r0 != 0) goto L_0x0157
            return r1
        L_0x0157:
            atakplugin.UASTool.ahy r2 = r11.f1607i
            r2.mo996a()
            atakplugin.UASTool.afx r2 = r11.f1608j
            r3 = 66
            r2.mo618a((byte) r3)
            atakplugin.UASTool.afx r2 = r11.f1608j
            r2.mo627b((byte[]) r0)
            atakplugin.UASTool.ahy r0 = r11.f1607i
            r12.mo1061b((atakplugin.UASTool.ahy) r0)
            r5.mo832b()
            atakplugin.UASTool.afx r0 = r11.f1608j
            atakplugin.UASTool.afx r12 = r12.mo1031a((atakplugin.UASTool.afx) r0)
            r11.f1608j = r12
            atakplugin.UASTool.afx r12 = r11.f1608j
            byte r12 = r12.mo647n()
            r12 = r12 & 255(0xff, float:3.57E-43)
            r0 = 52
            if (r12 != r0) goto L_0x0186
            r12 = 1
            return r12
        L_0x0186:
            if (r12 != r7) goto L_0x01b0
            atakplugin.UASTool.afx r12 = r11.f1608j
            r12.mo633d()
            atakplugin.UASTool.afx r12 = r11.f1608j
            r12.mo640g()
            atakplugin.UASTool.afx r12 = r11.f1608j
            r12.mo640g()
            atakplugin.UASTool.afx r12 = r11.f1608j
            byte[] r12 = r12.mo643j()
            atakplugin.UASTool.afx r0 = r11.f1608j
            int r0 = r0.mo640g()
            if (r0 != 0) goto L_0x01a6
            goto L_0x01b0
        L_0x01a6:
            atakplugin.UASTool.ahk r0 = new atakplugin.UASTool.ahk
            java.lang.String r12 = atakplugin.UASTool.aji.m1813b((byte[]) r12)
            r0.<init>(r12)
            throw r0
        L_0x01b0:
            return r1
        L_0x01b1:
            r7 = 53
            if (r6 != r7) goto L_0x01de
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo633d()
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo640g()
            atakplugin.UASTool.afx r6 = r11.f1608j
            r6.mo640g()
            atakplugin.UASTool.afx r6 = r11.f1608j
            byte[] r6 = r6.mo643j()
            atakplugin.UASTool.afx r7 = r11.f1608j
            r7.mo643j()
            java.lang.String r6 = atakplugin.UASTool.aji.m1813b((byte[]) r6)
            atakplugin.UASTool.ajh r7 = r11.f1606h
            if (r7 == 0) goto L_0x004f
            atakplugin.UASTool.ajh r7 = r11.f1606h
            r7.mo1174d(r6)
            goto L_0x004f
        L_0x01de:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ajc.mo1167a(atakplugin.UASTool.air):boolean");
    }
}
