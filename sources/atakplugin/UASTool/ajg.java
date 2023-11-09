package atakplugin.UASTool;

class ajg extends ajb {
    ajg() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:87:0x024f, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo1167a(atakplugin.UASTool.air r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            super.mo1167a(r17)
            atakplugin.UASTool.ahf r2 = r17.mo1099v()
            java.util.Vector r2 = r2.mo880c()
            monitor-enter(r2)
            int r3 = r2.size()     // Catch:{ all -> 0x0250 }
            r4 = 0
            if (r3 > 0) goto L_0x0019
            monitor-exit(r2)     // Catch:{ all -> 0x0250 }
            return r4
        L_0x0019:
            java.lang.String r3 = r1.f1609k     // Catch:{ all -> 0x0250 }
            byte[] r3 = atakplugin.UASTool.aji.m1820c((java.lang.String) r3)     // Catch:{ all -> 0x0250 }
            r5 = 0
        L_0x0020:
            int r6 = r2.size()     // Catch:{ all -> 0x0250 }
            if (r5 >= r6) goto L_0x024e
            int r6 = r0.f1474O     // Catch:{ all -> 0x0250 }
            int r7 = r0.f1473N     // Catch:{ all -> 0x0250 }
            if (r6 < r7) goto L_0x002e
            monitor-exit(r2)     // Catch:{ all -> 0x0250 }
            return r4
        L_0x002e:
            java.lang.Object r6 = r2.elementAt(r5)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.ahd r6 = (atakplugin.UASTool.ahd) r6     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.ahd r6 = (atakplugin.UASTool.ahd) r6     // Catch:{ all -> 0x0250 }
            byte[] r7 = r6.mo868a()     // Catch:{ all -> 0x0250 }
            r8 = 53
            r9 = 51
            r10 = 50
            if (r7 == 0) goto L_0x00c9
            atakplugin.UASTool.ahy r11 = r1.f1607i     // Catch:{ all -> 0x0250 }
            r11.mo996a()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r11.mo618a((byte) r10)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r11.mo627b((byte[]) r3)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            java.lang.String r12 = "ssh-connection"
            byte[] r12 = atakplugin.UASTool.aji.m1820c((java.lang.String) r12)     // Catch:{ all -> 0x0250 }
            r11.mo627b((byte[]) r12)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            java.lang.String r12 = "publickey"
            byte[] r12 = atakplugin.UASTool.aji.m1820c((java.lang.String) r12)     // Catch:{ all -> 0x0250 }
            r11.mo627b((byte[]) r12)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r11.mo618a((byte) r4)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            java.lang.String r12 = r6.mo871c()     // Catch:{ all -> 0x0250 }
            byte[] r12 = atakplugin.UASTool.aji.m1820c((java.lang.String) r12)     // Catch:{ all -> 0x0250 }
            r11.mo627b((byte[]) r12)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r11.mo627b((byte[]) r7)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.ahy r11 = r1.f1607i     // Catch:{ all -> 0x0250 }
            r0.mo1061b((atakplugin.UASTool.ahy) r11)     // Catch:{ all -> 0x0250 }
        L_0x0083:
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r0.mo1031a((atakplugin.UASTool.afx) r11)     // Catch:{ all -> 0x0250 }
            r1.f1608j = r11     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            byte r11 = r11.mo647n()     // Catch:{ all -> 0x0250 }
            r11 = r11 & 255(0xff, float:3.57E-43)
            r12 = 60
            if (r11 != r12) goto L_0x0098
            goto L_0x00c5
        L_0x0098:
            if (r11 != r9) goto L_0x009b
            goto L_0x00c5
        L_0x009b:
            if (r11 != r8) goto L_0x00c5
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r11.mo633d()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r11.mo640g()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r11.mo640g()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r11 = r1.f1608j     // Catch:{ all -> 0x0250 }
            byte[] r11 = r11.mo643j()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r12 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r12.mo643j()     // Catch:{ all -> 0x0250 }
            java.lang.String r11 = atakplugin.UASTool.aji.m1813b((byte[]) r11)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.ajh r12 = r1.f1606h     // Catch:{ all -> 0x0250 }
            if (r12 == 0) goto L_0x0083
            atakplugin.UASTool.ajh r12 = r1.f1606h     // Catch:{ all -> 0x0250 }
            r12.mo1174d(r11)     // Catch:{ all -> 0x0250 }
            goto L_0x0083
        L_0x00c5:
            if (r11 == r12) goto L_0x00c9
            goto L_0x024a
        L_0x00c9:
            r11 = 5
            r12 = 5
        L_0x00cb:
            boolean r13 = r6.mo873e()     // Catch:{ all -> 0x0250 }
            if (r13 == 0) goto L_0x0116
            atakplugin.UASTool.ajh r13 = r1.f1606h     // Catch:{ all -> 0x0250 }
            if (r13 == 0) goto L_0x010e
            boolean r13 = r6.mo873e()     // Catch:{ all -> 0x0250 }
            if (r13 == 0) goto L_0x0101
            atakplugin.UASTool.ajh r13 = r1.f1606h     // Catch:{ all -> 0x0250 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0250 }
            r15.<init>()     // Catch:{ all -> 0x0250 }
            java.lang.String r14 = "Passphrase for "
            r15.append(r14)     // Catch:{ all -> 0x0250 }
            java.lang.String r14 = r6.mo872d()     // Catch:{ all -> 0x0250 }
            r15.append(r14)     // Catch:{ all -> 0x0250 }
            java.lang.String r14 = r15.toString()     // Catch:{ all -> 0x0250 }
            boolean r13 = r13.mo1172b(r14)     // Catch:{ all -> 0x0250 }
            if (r13 == 0) goto L_0x00f9
            goto L_0x0101
        L_0x00f9:
            atakplugin.UASTool.ahi r0 = new atakplugin.UASTool.ahi     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = "publickey"
            r0.<init>(r3)     // Catch:{ all -> 0x0250 }
            throw r0     // Catch:{ all -> 0x0250 }
        L_0x0101:
            atakplugin.UASTool.ajh r13 = r1.f1606h     // Catch:{ all -> 0x0250 }
            java.lang.String r13 = r13.mo1169a()     // Catch:{ all -> 0x0250 }
            if (r13 == 0) goto L_0x0116
            byte[] r13 = atakplugin.UASTool.aji.m1820c((java.lang.String) r13)     // Catch:{ all -> 0x0250 }
            goto L_0x0117
        L_0x010e:
            atakplugin.UASTool.ahj r0 = new atakplugin.UASTool.ahj     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = "USERAUTH fail"
            r0.<init>(r3)     // Catch:{ all -> 0x0250 }
            throw r0     // Catch:{ all -> 0x0250 }
        L_0x0116:
            r13 = 0
        L_0x0117:
            boolean r14 = r6.mo873e()     // Catch:{ all -> 0x0250 }
            if (r14 == 0) goto L_0x011f
            if (r13 == 0) goto L_0x013a
        L_0x011f:
            boolean r14 = r6.mo867a(r13)     // Catch:{ all -> 0x0250 }
            if (r14 == 0) goto L_0x013a
            if (r13 == 0) goto L_0x0138
            atakplugin.UASTool.ahf r12 = r17.mo1099v()     // Catch:{ all -> 0x0250 }
            boolean r12 = r12 instanceof atakplugin.UASTool.ahf.C0043a     // Catch:{ all -> 0x0250 }
            if (r12 == 0) goto L_0x0138
            atakplugin.UASTool.ahf r12 = r17.mo1099v()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.ahf$a r12 = (atakplugin.UASTool.ahf.C0043a) r12     // Catch:{ all -> 0x0250 }
            r12.mo883e()     // Catch:{ all -> 0x0250 }
        L_0x0138:
            r14 = r13
            goto L_0x0142
        L_0x013a:
            atakplugin.UASTool.aji.m1822d((byte[]) r13)     // Catch:{ all -> 0x0250 }
            int r12 = r12 + -1
            if (r12 != 0) goto L_0x00cb
            r14 = 0
        L_0x0142:
            atakplugin.UASTool.aji.m1822d((byte[]) r14)     // Catch:{ all -> 0x0250 }
            boolean r12 = r6.mo873e()     // Catch:{ all -> 0x0250 }
            if (r12 == 0) goto L_0x014d
            goto L_0x024a
        L_0x014d:
            if (r7 != 0) goto L_0x0153
            byte[] r7 = r6.mo868a()     // Catch:{ all -> 0x0250 }
        L_0x0153:
            if (r7 != 0) goto L_0x0157
            goto L_0x024a
        L_0x0157:
            atakplugin.UASTool.ahy r12 = r1.f1607i     // Catch:{ all -> 0x0250 }
            r12.mo996a()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r12 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r12.mo618a((byte) r10)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r10 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r10.mo627b((byte[]) r3)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r10 = r1.f1608j     // Catch:{ all -> 0x0250 }
            java.lang.String r12 = "ssh-connection"
            byte[] r12 = atakplugin.UASTool.aji.m1820c((java.lang.String) r12)     // Catch:{ all -> 0x0250 }
            r10.mo627b((byte[]) r12)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r10 = r1.f1608j     // Catch:{ all -> 0x0250 }
            java.lang.String r12 = "publickey"
            byte[] r12 = atakplugin.UASTool.aji.m1820c((java.lang.String) r12)     // Catch:{ all -> 0x0250 }
            r10.mo627b((byte[]) r12)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r10 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r12 = 1
            r10.mo618a((byte) r12)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r10 = r1.f1608j     // Catch:{ all -> 0x0250 }
            java.lang.String r13 = r6.mo871c()     // Catch:{ all -> 0x0250 }
            byte[] r13 = atakplugin.UASTool.aji.m1820c((java.lang.String) r13)     // Catch:{ all -> 0x0250 }
            r10.mo627b((byte[]) r13)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r10 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r10.mo627b((byte[]) r7)     // Catch:{ all -> 0x0250 }
            byte[] r7 = r17.mo1066c()     // Catch:{ all -> 0x0250 }
            int r10 = r7.length     // Catch:{ all -> 0x0250 }
            int r13 = r10 + 4
            atakplugin.UASTool.afx r14 = r1.f1608j     // Catch:{ all -> 0x0250 }
            int r14 = r14.f889c     // Catch:{ all -> 0x0250 }
            int r14 = r14 + r13
            int r14 = r14 - r11
            byte[] r14 = new byte[r14]     // Catch:{ all -> 0x0250 }
            int r15 = r10 >>> 24
            byte r15 = (byte) r15     // Catch:{ all -> 0x0250 }
            r14[r4] = r15     // Catch:{ all -> 0x0250 }
            int r15 = r10 >>> 16
            byte r15 = (byte) r15     // Catch:{ all -> 0x0250 }
            r14[r12] = r15     // Catch:{ all -> 0x0250 }
            r15 = 2
            int r9 = r10 >>> 8
            byte r9 = (byte) r9     // Catch:{ all -> 0x0250 }
            r14[r15] = r9     // Catch:{ all -> 0x0250 }
            r9 = 3
            byte r15 = (byte) r10     // Catch:{ all -> 0x0250 }
            r14[r9] = r15     // Catch:{ all -> 0x0250 }
            r9 = 4
            java.lang.System.arraycopy(r7, r4, r14, r9, r10)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r7 = r1.f1608j     // Catch:{ all -> 0x0250 }
            byte[] r7 = r7.f888b     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r9 = r1.f1608j     // Catch:{ all -> 0x0250 }
            int r9 = r9.f889c     // Catch:{ all -> 0x0250 }
            int r9 = r9 - r11
            java.lang.System.arraycopy(r7, r11, r14, r13, r9)     // Catch:{ all -> 0x0250 }
            byte[] r6 = r6.mo870b(r14)     // Catch:{ all -> 0x0250 }
            if (r6 != 0) goto L_0x01cf
            goto L_0x024e
        L_0x01cf:
            atakplugin.UASTool.afx r7 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r7.mo627b((byte[]) r6)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.ahy r6 = r1.f1607i     // Catch:{ all -> 0x0250 }
            r0.mo1061b((atakplugin.UASTool.ahy) r6)     // Catch:{ all -> 0x0250 }
        L_0x01d9:
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r0.mo1031a((atakplugin.UASTool.afx) r6)     // Catch:{ all -> 0x0250 }
            r1.f1608j = r6     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            byte r6 = r6.mo647n()     // Catch:{ all -> 0x0250 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = 52
            if (r6 != r7) goto L_0x01ef
            monitor-exit(r2)     // Catch:{ all -> 0x0250 }
            return r12
        L_0x01ef:
            if (r6 != r8) goto L_0x0219
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r6.mo633d()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r6.mo640g()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r6.mo640g()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            byte[] r6 = r6.mo643j()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r7 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r7.mo643j()     // Catch:{ all -> 0x0250 }
            java.lang.String r6 = atakplugin.UASTool.aji.m1813b((byte[]) r6)     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.ajh r7 = r1.f1606h     // Catch:{ all -> 0x0250 }
            if (r7 == 0) goto L_0x01d9
            atakplugin.UASTool.ajh r7 = r1.f1606h     // Catch:{ all -> 0x0250 }
            r7.mo1174d(r6)     // Catch:{ all -> 0x0250 }
            goto L_0x01d9
        L_0x0219:
            r9 = 51
            if (r6 != r9) goto L_0x024a
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r6.mo633d()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r6.mo640g()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            r6.mo640g()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r6 = r1.f1608j     // Catch:{ all -> 0x0250 }
            byte[] r6 = r6.mo643j()     // Catch:{ all -> 0x0250 }
            atakplugin.UASTool.afx r7 = r1.f1608j     // Catch:{ all -> 0x0250 }
            int r7 = r7.mo640g()     // Catch:{ all -> 0x0250 }
            if (r7 != 0) goto L_0x0240
            int r6 = r0.f1474O     // Catch:{ all -> 0x0250 }
            int r6 = r6 + r12
            r0.f1474O = r6     // Catch:{ all -> 0x0250 }
            goto L_0x024a
        L_0x0240:
            atakplugin.UASTool.ahk r0 = new atakplugin.UASTool.ahk     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = atakplugin.UASTool.aji.m1813b((byte[]) r6)     // Catch:{ all -> 0x0250 }
            r0.<init>(r3)     // Catch:{ all -> 0x0250 }
            throw r0     // Catch:{ all -> 0x0250 }
        L_0x024a:
            int r5 = r5 + 1
            goto L_0x0020
        L_0x024e:
            monitor-exit(r2)     // Catch:{ all -> 0x0250 }
            return r4
        L_0x0250:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0250 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ajg.mo1167a(atakplugin.UASTool.air):boolean");
    }
}
