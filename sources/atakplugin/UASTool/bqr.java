package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

public final class bqr {

    /* renamed from: a */
    public static final bqr f3203a = new C0217a().mo3046a().mo3053e();

    /* renamed from: b */
    public static final bqr f3204b = new C0217a().mo3050c().mo3049b(Integer.MAX_VALUE, TimeUnit.SECONDS).mo3053e();

    /* renamed from: c */
    String f3205c;

    /* renamed from: d */
    private final boolean f3206d;

    /* renamed from: e */
    private final boolean f3207e;

    /* renamed from: f */
    private final int f3208f;

    /* renamed from: g */
    private final int f3209g;

    /* renamed from: h */
    private final boolean f3210h;

    /* renamed from: i */
    private final boolean f3211i;

    /* renamed from: j */
    private final boolean f3212j;

    /* renamed from: k */
    private final int f3213k;

    /* renamed from: l */
    private final int f3214l;

    /* renamed from: m */
    private final boolean f3215m;

    /* renamed from: n */
    private final boolean f3216n;

    private bqr(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f3206d = z;
        this.f3207e = z2;
        this.f3208f = i;
        this.f3209g = i2;
        this.f3210h = z3;
        this.f3211i = z4;
        this.f3212j = z5;
        this.f3213k = i3;
        this.f3214l = i4;
        this.f3215m = z6;
        this.f3216n = z7;
        this.f3205c = str;
    }

    private bqr(C0217a aVar) {
        this.f3206d = aVar.f3217a;
        this.f3207e = aVar.f3218b;
        this.f3208f = aVar.f3219c;
        this.f3209g = -1;
        this.f3210h = false;
        this.f3211i = false;
        this.f3212j = false;
        this.f3213k = aVar.f3220d;
        this.f3214l = aVar.f3221e;
        this.f3215m = aVar.f3222f;
        this.f3216n = aVar.f3223g;
    }

    /* renamed from: a */
    public boolean mo3034a() {
        return this.f3206d;
    }

    /* renamed from: b */
    public boolean mo3035b() {
        return this.f3207e;
    }

    /* renamed from: c */
    public int mo3036c() {
        return this.f3208f;
    }

    /* renamed from: d */
    public int mo3037d() {
        return this.f3209g;
    }

    /* renamed from: e */
    public boolean mo3038e() {
        return this.f3210h;
    }

    /* renamed from: f */
    public boolean mo3039f() {
        return this.f3211i;
    }

    /* renamed from: g */
    public boolean mo3040g() {
        return this.f3212j;
    }

    /* renamed from: h */
    public int mo3041h() {
        return this.f3213k;
    }

    /* renamed from: i */
    public int mo3042i() {
        return this.f3214l;
    }

    /* renamed from: j */
    public boolean mo3043j() {
        return this.f3215m;
    }

    /* renamed from: k */
    public boolean mo3044k() {
        return this.f3216n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static atakplugin.UASTool.bqr m8628a(atakplugin.UASTool.brp r21) {
        /*
            r0 = r21
            int r1 = r21.mo3168a()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
        L_0x0018:
            if (r6 >= r1) goto L_0x0131
            java.lang.String r2 = r0.mo3169a((int) r6)
            java.lang.String r4 = r0.mo3171b((int) r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r8 = r4
            goto L_0x0038
        L_0x002f:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x012a
        L_0x0037:
            r7 = 0
        L_0x0038:
            r2 = 0
        L_0x0039:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x012a
            java.lang.String r3 = "=,;"
            int r3 = atakplugin.UASTool.bva.m9773a((java.lang.String) r4, (int) r2, (java.lang.String) r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0097
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0097
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0064
            goto L_0x0097
        L_0x0064:
            int r3 = r3 + 1
            int r0 = atakplugin.UASTool.bva.m9772a((java.lang.String) r4, (int) r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0087
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0087
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = atakplugin.UASTool.bva.m9773a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009b
        L_0x0087:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = atakplugin.UASTool.bva.m9773a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009b
        L_0x0097:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009b:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a7
            r5 = -1
            r9 = 1
            goto L_0x0125
        L_0x00a7:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b3
            r5 = -1
            r10 = 1
            goto L_0x0125
        L_0x00b3:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c1
            r5 = -1
            int r11 = atakplugin.UASTool.bva.m9781b(r0, r5)
            goto L_0x0125
        L_0x00c1:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00cf
            r5 = -1
            int r12 = atakplugin.UASTool.bva.m9781b(r0, r5)
            goto L_0x0125
        L_0x00cf:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00da
            r5 = -1
            r13 = 1
            goto L_0x0125
        L_0x00da:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e5
            r5 = -1
            r14 = 1
            goto L_0x0125
        L_0x00e5:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f0
            r5 = -1
            r15 = 1
            goto L_0x0125
        L_0x00f0:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0101
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = atakplugin.UASTool.bva.m9781b(r0, r2)
            r5 = -1
            goto L_0x0125
        L_0x0101:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x010f
            r5 = -1
            int r17 = atakplugin.UASTool.bva.m9781b(r0, r5)
            goto L_0x0125
        L_0x010f:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011b
            r18 = 1
            goto L_0x0125
        L_0x011b:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0125
            r19 = 1
        L_0x0125:
            r0 = r21
            r2 = r3
            goto L_0x0039
        L_0x012a:
            r5 = -1
            int r6 = r6 + 1
            r0 = r21
            goto L_0x0018
        L_0x0131:
            if (r7 != 0) goto L_0x0136
            r20 = 0
            goto L_0x0138
        L_0x0136:
            r20 = r8
        L_0x0138:
            atakplugin.UASTool.bqr r0 = new atakplugin.UASTool.bqr
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bqr.m8628a(atakplugin.UASTool.brp):atakplugin.UASTool.bqr");
    }

    public String toString() {
        String str = this.f3205c;
        if (str != null) {
            return str;
        }
        String l = m8629l();
        this.f3205c = l;
        return l;
    }

    /* renamed from: l */
    private String m8629l() {
        StringBuilder sb = new StringBuilder();
        if (this.f3206d) {
            sb.append("no-cache, ");
        }
        if (this.f3207e) {
            sb.append("no-store, ");
        }
        if (this.f3208f != -1) {
            sb.append("max-age=");
            sb.append(this.f3208f);
            sb.append(", ");
        }
        if (this.f3209g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f3209g);
            sb.append(", ");
        }
        if (this.f3210h) {
            sb.append("private, ");
        }
        if (this.f3211i) {
            sb.append("public, ");
        }
        if (this.f3212j) {
            sb.append("must-revalidate, ");
        }
        if (this.f3213k != -1) {
            sb.append("max-stale=");
            sb.append(this.f3213k);
            sb.append(", ");
        }
        if (this.f3214l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f3214l);
            sb.append(", ");
        }
        if (this.f3215m) {
            sb.append("only-if-cached, ");
        }
        if (this.f3216n) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* renamed from: atakplugin.UASTool.bqr$a */
    public static final class C0217a {

        /* renamed from: a */
        boolean f3217a;

        /* renamed from: b */
        boolean f3218b;

        /* renamed from: c */
        int f3219c = -1;

        /* renamed from: d */
        int f3220d = -1;

        /* renamed from: e */
        int f3221e = -1;

        /* renamed from: f */
        boolean f3222f;

        /* renamed from: g */
        boolean f3223g;

        /* renamed from: a */
        public C0217a mo3046a() {
            this.f3217a = true;
            return this;
        }

        /* renamed from: b */
        public C0217a mo3048b() {
            this.f3218b = true;
            return this;
        }

        /* renamed from: a */
        public C0217a mo3047a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f3219c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i);
        }

        /* renamed from: b */
        public C0217a mo3049b(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f3220d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        /* renamed from: c */
        public C0217a mo3051c(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f3221e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i);
        }

        /* renamed from: c */
        public C0217a mo3050c() {
            this.f3222f = true;
            return this;
        }

        /* renamed from: d */
        public C0217a mo3052d() {
            this.f3223g = true;
            return this;
        }

        /* renamed from: e */
        public bqr mo3053e() {
            return new bqr(this);
        }
    }
}
