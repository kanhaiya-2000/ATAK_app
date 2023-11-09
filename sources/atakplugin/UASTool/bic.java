package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b'\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0019"}, mo1538e = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"})
public abstract class bic {

    /* renamed from: a */
    public static final C0163a f2708a = C0163a.f2711c;

    /* renamed from: b */
    public static final C0164b f2709b = new C0164b((bfd) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final bic f2710c = bbg.f2499a.mo2236a();

    /* renamed from: a */
    public abstract int mo2525a(int i);

    /* renamed from: b */
    public int mo2528b() {
        return mo2525a(32);
    }

    /* renamed from: b */
    public int mo2529b(int i) {
        return mo2549a(0, i);
    }

    /* renamed from: a */
    public int mo2549a(int i, int i2) {
        int i3;
        int b;
        int i4;
        bid.m6984b(i, i2);
        int i5 = i2 - i;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i3 = mo2525a(bid.m6983b(i5));
            } else {
                do {
                    b = mo2528b() >>> 1;
                    i4 = b % i5;
                } while ((b - i4) + (i5 - 1) < 0);
                i3 = i4;
            }
            return i + i3;
        }
        while (true) {
            int b2 = mo2528b();
            if (i <= b2 && i2 > b2) {
                return b2;
            }
        }
    }

    /* renamed from: c */
    public long mo2530c() {
        return (((long) mo2528b()) << 32) + ((long) mo2528b());
    }

    /* renamed from: a */
    public long mo2550a(long j) {
        return mo2551a(0, j);
    }

    /* renamed from: a */
    public long mo2551a(long j, long j2) {
        long j3;
        long c;
        long j4;
        int b;
        bid.m6982a(j, j2);
        long j5 = j2 - j;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i = (int) j5;
                int i2 = (int) (j5 >>> 32);
                if (i != 0) {
                    b = mo2525a(bid.m6983b(i));
                } else if (i2 == 1) {
                    b = mo2528b();
                } else {
                    j3 = (((long) mo2525a(bid.m6983b(i2))) << 32) + ((long) mo2528b());
                }
                j3 = ((long) b) & 4294967295L;
            } else {
                do {
                    c = mo2530c() >>> 1;
                    j4 = c % j5;
                } while ((c - j4) + (j5 - 1) < 0);
                j3 = j4;
            }
            return j + j3;
        }
        while (true) {
            long c2 = mo2530c();
            if (j <= c2 && j2 > c2) {
                return c2;
            }
        }
    }

    /* renamed from: d */
    public boolean mo2531d() {
        return mo2525a(1) != 0;
    }

    /* renamed from: e */
    public double mo2532e() {
        return bib.m6937a(mo2525a(26), mo2525a(27));
    }

    /* renamed from: a */
    public double mo2547a(double d) {
        return mo2548a(0.0d, d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double mo2548a(double r7, double r9) {
        /*
            r6 = this;
            atakplugin.UASTool.bid.m6981a((double) r7, (double) r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L_0x003e
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x001b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L_0x001b
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            if (r2 == 0) goto L_0x003e
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L_0x002b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            if (r3 == 0) goto L_0x003e
            double r0 = r6.mo2532e()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L_0x0045
        L_0x003e:
            double r2 = r6.mo2532e()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L_0x0045:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x0053
            atakplugin.UASTool.bfe r7 = atakplugin.UASTool.bfe.f2604a
            double r7 = r7.mo2375d()
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L_0x0053:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bic.mo2548a(double, double):double");
    }

    /* renamed from: f */
    public float mo2533f() {
        return ((float) mo2525a(24)) / ((float) 16777216);
    }

    /* renamed from: a */
    public static /* synthetic */ byte[] m6941a(bic bic, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return bic.mo2552a(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo2552a(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "array"
            atakplugin.UASTool.bfq.m6567f(r7, r0)
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r8 >= 0) goto L_0x000b
            goto L_0x0015
        L_0x000b:
            if (r0 < r8) goto L_0x0015
            int r0 = r7.length
            if (r9 >= 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            if (r0 < r9) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            java.lang.String r3 = "fromIndex ("
            if (r0 == 0) goto L_0x0086
            if (r8 > r9) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            if (r2 == 0) goto L_0x005e
            int r0 = r9 - r8
            int r0 = r0 / 4
            r2 = 0
        L_0x0025:
            if (r2 >= r0) goto L_0x0048
            int r3 = r6.mo2528b()
            byte r4 = (byte) r3
            r7[r8] = r4
            int r4 = r8 + 1
            int r5 = r3 >>> 8
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 2
            int r5 = r3 >>> 16
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 3
            int r3 = r3 >>> 24
            byte r3 = (byte) r3
            r7[r4] = r3
            int r8 = r8 + 4
            int r2 = r2 + 1
            goto L_0x0025
        L_0x0048:
            int r9 = r9 - r8
            int r0 = r9 * 8
            int r0 = r6.mo2525a((int) r0)
        L_0x004f:
            if (r1 >= r9) goto L_0x005d
            int r2 = r8 + r1
            int r3 = r1 * 8
            int r3 = r0 >>> r3
            byte r3 = (byte) r3
            r7[r2] = r3
            int r1 = r1 + 1
            goto L_0x004f
        L_0x005d:
            return r7
        L_0x005e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r8)
            java.lang.String r8 = ") must be not greater than toIndex ("
            r7.append(r8)
            r7.append(r9)
            java.lang.String r8 = ")."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x0086:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = ") or toIndex ("
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ") are out of range: 0.."
            r0.append(r8)
            int r7 = r7.length
            r0.append(r7)
            r7 = 46
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bic.mo2552a(byte[], int, int):byte[]");
    }

    /* renamed from: a */
    public byte[] mo2527a(byte[] bArr) {
        bfq.m6567f(bArr, "array");
        return mo2552a(bArr, 0, bArr.length);
    }

    /* renamed from: c */
    public byte[] mo2553c(int i) {
        return mo2527a(new byte[i]);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo1538e = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bic$b */
    public static final class C0164b extends bic {
        @anx(mo1516a = "Use Default companion object instead", mo1518c = any.HIDDEN)
        /* renamed from: a */
        public static /* synthetic */ void m6959a() {
        }

        private C0164b() {
        }

        public /* synthetic */ C0164b(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public int mo2525a(int i) {
            return bic.f2710c.mo2525a(i);
        }

        /* renamed from: b */
        public int mo2528b() {
            return bic.f2710c.mo2528b();
        }

        /* renamed from: b */
        public int mo2529b(int i) {
            return bic.f2710c.mo2529b(i);
        }

        /* renamed from: a */
        public int mo2549a(int i, int i2) {
            return bic.f2710c.mo2549a(i, i2);
        }

        /* renamed from: c */
        public long mo2530c() {
            return bic.f2710c.mo2530c();
        }

        /* renamed from: a */
        public long mo2550a(long j) {
            return bic.f2710c.mo2550a(j);
        }

        /* renamed from: a */
        public long mo2551a(long j, long j2) {
            return bic.f2710c.mo2551a(j, j2);
        }

        /* renamed from: d */
        public boolean mo2531d() {
            return bic.f2710c.mo2531d();
        }

        /* renamed from: e */
        public double mo2532e() {
            return bic.f2710c.mo2532e();
        }

        /* renamed from: a */
        public double mo2547a(double d) {
            return bic.f2710c.mo2547a(d);
        }

        /* renamed from: a */
        public double mo2548a(double d, double d2) {
            return bic.f2710c.mo2548a(d, d2);
        }

        /* renamed from: f */
        public float mo2533f() {
            return bic.f2710c.mo2533f();
        }

        /* renamed from: a */
        public byte[] mo2527a(byte[] bArr) {
            bfq.m6567f(bArr, "array");
            return bic.f2710c.mo2527a(bArr);
        }

        /* renamed from: c */
        public byte[] mo2553c(int i) {
            return bic.f2710c.mo2553c(i);
        }

        /* renamed from: a */
        public byte[] mo2552a(byte[] bArr, int i, int i2) {
            bfq.m6567f(bArr, "array");
            return bic.f2710c.mo2552a(bArr, i, i2);
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, mo1538e = {"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"})
    @anx(mo1516a = "Use Default companion object instead", mo1518c = any.HIDDEN)
    /* renamed from: atakplugin.UASTool.bic$a */
    public static final class C0163a extends bic {

        /* renamed from: c */
        public static final C0163a f2711c = new C0163a();

        private C0163a() {
        }

        /* renamed from: a */
        public int mo2525a(int i) {
            return bic.f2709b.mo2525a(i);
        }
    }
}
