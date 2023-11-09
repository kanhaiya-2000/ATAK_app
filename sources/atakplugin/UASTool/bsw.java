package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import atakplugin.UASTool.bsh;
import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class bsw {

    /* renamed from: a */
    public final bsb f3596a;

    /* renamed from: b */
    public final bsh f3597b;

    private bsw(bsb bsb, bsh bsh) {
        this.f3596a = bsb;
        this.f3597b = bsh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.mo3391o().mo3038e() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m9190a(atakplugin.UASTool.bsh r3, atakplugin.UASTool.bsb r4) {
        /*
            int r0 = r3.mo3378c()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.mo3377b((java.lang.String) r0)
            if (r0 != 0) goto L_0x005a
            atakplugin.UASTool.bqr r0 = r3.mo3391o()
            int r0 = r0.mo3036c()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            atakplugin.UASTool.bqr r0 = r3.mo3391o()
            boolean r0 = r0.mo3039f()
            if (r0 != 0) goto L_0x005a
            atakplugin.UASTool.bqr r0 = r3.mo3391o()
            boolean r0 = r0.mo3038e()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            atakplugin.UASTool.bqr r3 = r3.mo3391o()
            boolean r3 = r3.mo3035b()
            if (r3 != 0) goto L_0x006f
            atakplugin.UASTool.bqr r3 = r4.mo3351g()
            boolean r3 = r3.mo3035b()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bsw.m9190a(atakplugin.UASTool.bsh, atakplugin.UASTool.bsb):boolean");
    }

    /* renamed from: atakplugin.UASTool.bsw$a */
    public static class C0236a {

        /* renamed from: a */
        final long f3598a;

        /* renamed from: b */
        final bsb f3599b;

        /* renamed from: c */
        final bsh f3600c;

        /* renamed from: d */
        private Date f3601d;

        /* renamed from: e */
        private String f3602e;

        /* renamed from: f */
        private Date f3603f;

        /* renamed from: g */
        private String f3604g;

        /* renamed from: h */
        private Date f3605h;

        /* renamed from: i */
        private long f3606i;

        /* renamed from: j */
        private long f3607j;

        /* renamed from: k */
        private String f3608k;

        /* renamed from: l */
        private int f3609l = -1;

        public C0236a(long j, bsb bsb, bsh bsh) {
            this.f3598a = j;
            this.f3599b = bsb;
            this.f3600c = bsh;
            if (bsh != null) {
                this.f3606i = bsh.mo3392p();
                this.f3607j = bsh.mo3393q();
                brp g = bsh.mo3383g();
                int a = g.mo3168a();
                for (int i = 0; i < a; i++) {
                    String a2 = g.mo3169a(i);
                    String b = g.mo3171b(i);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f3601d = buy.m9769a(b);
                        this.f3602e = b;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f3605h = buy.m9769a(b);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f3603f = buy.m9769a(b);
                        this.f3604g = b;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.f3608k = b;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(a2)) {
                        this.f3609l = bva.m9781b(b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        public bsw mo3427a() {
            bsw b = m9192b();
            return (b.f3596a == null || !this.f3599b.mo3351g().mo3043j()) ? b : new bsw((bsb) null, (bsh) null);
        }

        /* renamed from: b */
        private bsw m9192b() {
            if (this.f3600c == null) {
                return new bsw(this.f3599b, (bsh) null);
            }
            if (this.f3599b.mo3352h() && this.f3600c.mo3382f() == null) {
                return new bsw(this.f3599b, (bsh) null);
            }
            if (!bsw.m9190a(this.f3600c, this.f3599b)) {
                return new bsw(this.f3599b, (bsh) null);
            }
            bqr g = this.f3599b.mo3351g();
            if (g.mo3034a() || m9191a(this.f3599b)) {
                return new bsw(this.f3599b, (bsh) null);
            }
            long d = m9194d();
            long c = m9193c();
            if (g.mo3036c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis((long) g.mo3036c()));
            }
            long j = 0;
            long millis = g.mo3042i() != -1 ? TimeUnit.SECONDS.toMillis((long) g.mo3042i()) : 0;
            bqr o = this.f3600c.mo3391o();
            if (!o.mo3040g() && g.mo3041h() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) g.mo3041h());
            }
            if (!o.mo3034a()) {
                long j2 = millis + d;
                if (j2 < j + c) {
                    bsh.C0235a i = this.f3600c.mo3385i();
                    if (j2 >= c) {
                        i.mo3409b(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d > 86400000 && m9195e()) {
                        i.mo3409b(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new bsw((bsb) null, i.mo3405a());
                }
            }
            String str = this.f3608k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f3603f != null) {
                str = this.f3604g;
            } else if (this.f3601d == null) {
                return new bsw(this.f3599b, (bsh) null);
            } else {
                str = this.f3602e;
            }
            brp.C0225a c2 = this.f3599b.mo3347c().mo3174c();
            bsn.f3580a.mo3330a(c2, str2, str);
            return new bsw(this.f3599b.mo3350f().mo3356a(c2.mo3182a()).mo3371d(), this.f3600c);
        }

        /* renamed from: c */
        private long m9193c() {
            bqr o = this.f3600c.mo3391o();
            if (o.mo3036c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) o.mo3036c());
            }
            if (this.f3605h != null) {
                Date date = this.f3601d;
                long time = this.f3605h.getTime() - (date != null ? date.getTime() : this.f3607j);
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f3603f == null || this.f3600c.mo3372a().mo3343a().mo3211p() != null) {
                return 0;
            } else {
                Date date2 = this.f3601d;
                long time2 = (date2 != null ? date2.getTime() : this.f3606i) - this.f3603f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        /* renamed from: d */
        private long m9194d() {
            Date date = this.f3601d;
            long j = 0;
            if (date != null) {
                j = Math.max(0, this.f3607j - date.getTime());
            }
            if (this.f3609l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f3609l));
            }
            long j2 = this.f3607j;
            return j + (j2 - this.f3606i) + (this.f3598a - j2);
        }

        /* renamed from: e */
        private boolean m9195e() {
            return this.f3600c.mo3391o().mo3036c() == -1 && this.f3605h == null;
        }

        /* renamed from: a */
        private static boolean m9191a(bsb bsb) {
            return (bsb.mo3344a("If-Modified-Since") == null && bsb.mo3344a("If-None-Match") == null) ? false : true;
        }
    }
}
