package atakplugin.UASTool;

class ajf extends ajb {

    /* renamed from: l */
    private final int f1620l = 60;

    ajf() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01a6, code lost:
        if (r2 != 51) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r14.f1608j.mo633d();
        r14.f1608j.mo640g();
        r14.f1608j.mo640g();
        r2 = r14.f1608j.mo643j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01c3, code lost:
        if (r14.f1608j.mo640g() != 0) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01c5, code lost:
        r15.f1474O++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01ca, code lost:
        if (r1 == null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01cc, code lost:
        atakplugin.UASTool.aji.m1822d(r1);
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01db, code lost:
        throw new atakplugin.UASTool.ahk(atakplugin.UASTool.aji.m1813b(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01dc, code lost:
        if (r1 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01de, code lost:
        atakplugin.UASTool.aji.m1822d(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01e1, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo1167a(atakplugin.UASTool.air r15) {
        /*
            r14 = this;
            java.lang.String r0 = "ssh-connection"
            super.mo1167a(r15)
            byte[] r1 = r15.f1479T
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r14.f1609k
            r2.append(r3)
            java.lang.String r3 = "@"
            r2.append(r3)
            java.lang.String r3 = r15.f1475P
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r15.f1477R
            r4 = 22
            if (r3 == r4) goto L_0x003b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = ":"
            r3.append(r2)
            int r2 = r15.f1477R
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x003b:
            r8 = r2
        L_0x003c:
            int r2 = r15.f1474O     // Catch:{ all -> 0x01e2 }
            int r3 = r15.f1473N     // Catch:{ all -> 0x01e2 }
            r9 = 0
            if (r2 < r3) goto L_0x0049
            if (r1 == 0) goto L_0x0048
            atakplugin.UASTool.aji.m1822d((byte[]) r1)
        L_0x0048:
            return r9
        L_0x0049:
            java.lang.String r10 = "password"
            if (r1 != 0) goto L_0x0089
            atakplugin.UASTool.ajh r2 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            if (r2 != 0) goto L_0x0057
            if (r1 == 0) goto L_0x0056
            atakplugin.UASTool.aji.m1822d((byte[]) r1)
        L_0x0056:
            return r9
        L_0x0057:
            atakplugin.UASTool.ajh r2 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r3.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r4 = "Password for "
            r3.append(r4)     // Catch:{ all -> 0x01e2 }
            r3.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01e2 }
            boolean r2 = r2.mo1170a(r3)     // Catch:{ all -> 0x01e2 }
            if (r2 == 0) goto L_0x0083
            atakplugin.UASTool.ajh r2 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            java.lang.String r2 = r2.mo1171b()     // Catch:{ all -> 0x01e2 }
            if (r2 == 0) goto L_0x007d
            byte[] r1 = atakplugin.UASTool.aji.m1820c((java.lang.String) r2)     // Catch:{ all -> 0x01e2 }
            goto L_0x0089
        L_0x007d:
            atakplugin.UASTool.ahi r15 = new atakplugin.UASTool.ahi     // Catch:{ all -> 0x01e2 }
            r15.<init>(r10)     // Catch:{ all -> 0x01e2 }
            throw r15     // Catch:{ all -> 0x01e2 }
        L_0x0083:
            atakplugin.UASTool.ahi r15 = new atakplugin.UASTool.ahi     // Catch:{ all -> 0x01e2 }
            r15.<init>(r10)     // Catch:{ all -> 0x01e2 }
            throw r15     // Catch:{ all -> 0x01e2 }
        L_0x0089:
            java.lang.String r2 = r14.f1609k     // Catch:{ all -> 0x01e2 }
            byte[] r11 = atakplugin.UASTool.aji.m1820c((java.lang.String) r2)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.ahy r2 = r14.f1607i     // Catch:{ all -> 0x01e2 }
            r2.mo996a()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r12 = 50
            r2.mo618a((byte) r12)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo627b((byte[]) r11)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte[] r3 = atakplugin.UASTool.aji.m1820c((java.lang.String) r0)     // Catch:{ all -> 0x01e2 }
            r2.mo627b((byte[]) r3)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte[] r3 = atakplugin.UASTool.aji.m1820c((java.lang.String) r10)     // Catch:{ all -> 0x01e2 }
            r2.mo627b((byte[]) r3)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo618a((byte) r9)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo627b((byte[]) r1)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.ahy r2 = r14.f1607i     // Catch:{ all -> 0x01e2 }
            r15.mo1061b((atakplugin.UASTool.ahy) r2)     // Catch:{ all -> 0x01e2 }
        L_0x00c1:
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r15.mo1031a((atakplugin.UASTool.afx) r2)     // Catch:{ all -> 0x01e2 }
            r14.f1608j = r2     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte r2 = r2.mo647n()     // Catch:{ all -> 0x01e2 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 52
            r13 = 1
            if (r2 != r3) goto L_0x00dc
            if (r1 == 0) goto L_0x00db
            atakplugin.UASTool.aji.m1822d((byte[]) r1)
        L_0x00db:
            return r13
        L_0x00dc:
            r3 = 53
            if (r2 != r3) goto L_0x0108
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo633d()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo640g()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo640g()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte[] r2 = r2.mo643j()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r3.mo643j()     // Catch:{ all -> 0x01e2 }
            java.lang.String r2 = atakplugin.UASTool.aji.m1813b((byte[]) r2)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.ajh r3 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            if (r3 == 0) goto L_0x00c1
            atakplugin.UASTool.ajh r3 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            r3.mo1174d(r2)     // Catch:{ all -> 0x01e2 }
            goto L_0x00c1
        L_0x0108:
            r3 = 60
            if (r2 != r3) goto L_0x01a4
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo633d()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo640g()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo640g()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte[] r2 = r2.mo643j()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r3.mo643j()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.ajh r3 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            if (r3 == 0) goto L_0x0193
            atakplugin.UASTool.ajh r3 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            boolean r3 = r3 instanceof atakplugin.UASTool.aja     // Catch:{ all -> 0x01e2 }
            if (r3 != 0) goto L_0x0131
            goto L_0x0193
        L_0x0131:
            atakplugin.UASTool.ajh r3 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.aja r3 = (atakplugin.UASTool.aja) r3     // Catch:{ all -> 0x01e2 }
            java.lang.String r4 = "Password Change Required"
            java.lang.String r5 = "New Password: "
            java.lang.String[] r6 = new java.lang.String[]{r5}     // Catch:{ all -> 0x01e2 }
            boolean[] r7 = new boolean[r13]     // Catch:{ all -> 0x01e2 }
            r7[r9] = r9     // Catch:{ all -> 0x01e2 }
            java.lang.String r5 = atakplugin.UASTool.aji.m1813b((byte[]) r2)     // Catch:{ all -> 0x01e2 }
            r2 = r3
            r3 = r8
            java.lang.String[] r2 = r2.mo1166a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x01e2 }
            if (r2 == 0) goto L_0x018d
            r2 = r2[r9]     // Catch:{ all -> 0x01e2 }
            byte[] r2 = atakplugin.UASTool.aji.m1820c((java.lang.String) r2)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.ahy r3 = r14.f1607i     // Catch:{ all -> 0x01e2 }
            r3.mo996a()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r3.mo618a((byte) r12)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r3.mo627b((byte[]) r11)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r0)     // Catch:{ all -> 0x01e2 }
            r3.mo627b((byte[]) r4)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte[] r4 = atakplugin.UASTool.aji.m1820c((java.lang.String) r10)     // Catch:{ all -> 0x01e2 }
            r3.mo627b((byte[]) r4)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r3.mo618a((byte) r13)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r3.mo627b((byte[]) r1)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r3.mo627b((byte[]) r2)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.aji.m1822d((byte[]) r2)     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.ahy r2 = r14.f1607i     // Catch:{ all -> 0x01e2 }
            r15.mo1061b((atakplugin.UASTool.ahy) r2)     // Catch:{ all -> 0x01e2 }
            goto L_0x00c1
        L_0x018d:
            atakplugin.UASTool.ahi r15 = new atakplugin.UASTool.ahi     // Catch:{ all -> 0x01e2 }
            r15.<init>(r10)     // Catch:{ all -> 0x01e2 }
            throw r15     // Catch:{ all -> 0x01e2 }
        L_0x0193:
            atakplugin.UASTool.ajh r15 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            if (r15 == 0) goto L_0x019e
            atakplugin.UASTool.ajh r15 = r14.f1606h     // Catch:{ all -> 0x01e2 }
            java.lang.String r0 = "Password must be changed."
            r15.mo1174d(r0)     // Catch:{ all -> 0x01e2 }
        L_0x019e:
            if (r1 == 0) goto L_0x01a3
            atakplugin.UASTool.aji.m1822d((byte[]) r1)
        L_0x01a3:
            return r9
        L_0x01a4:
            r3 = 51
            if (r2 != r3) goto L_0x01dc
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo633d()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo640g()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            r2.mo640g()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r2 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            byte[] r2 = r2.mo643j()     // Catch:{ all -> 0x01e2 }
            atakplugin.UASTool.afx r3 = r14.f1608j     // Catch:{ all -> 0x01e2 }
            int r3 = r3.mo640g()     // Catch:{ all -> 0x01e2 }
            if (r3 != 0) goto L_0x01d2
            int r2 = r15.f1474O     // Catch:{ all -> 0x01e2 }
            int r2 = r2 + r13
            r15.f1474O = r2     // Catch:{ all -> 0x01e2 }
            if (r1 == 0) goto L_0x003c
            atakplugin.UASTool.aji.m1822d((byte[]) r1)     // Catch:{ all -> 0x01e2 }
            r1 = 0
            goto L_0x003c
        L_0x01d2:
            atakplugin.UASTool.ahk r15 = new atakplugin.UASTool.ahk     // Catch:{ all -> 0x01e2 }
            java.lang.String r0 = atakplugin.UASTool.aji.m1813b((byte[]) r2)     // Catch:{ all -> 0x01e2 }
            r15.<init>(r0)     // Catch:{ all -> 0x01e2 }
            throw r15     // Catch:{ all -> 0x01e2 }
        L_0x01dc:
            if (r1 == 0) goto L_0x01e1
            atakplugin.UASTool.aji.m1822d((byte[]) r1)
        L_0x01e1:
            return r9
        L_0x01e2:
            r15 = move-exception
            if (r1 == 0) goto L_0x01e8
            atakplugin.UASTool.aji.m1822d((byte[]) r1)
        L_0x01e8:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ajf.mo1167a(atakplugin.UASTool.air):boolean");
    }
}
