package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public final class bsb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final brr f3523a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f3524b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final brp f3525c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final bsd f3526d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f3527e;

    /* renamed from: f */
    private volatile bqr f3528f;

    private bsb(C0234a aVar) {
        this.f3523a = aVar.f3529a;
        this.f3524b = aVar.f3530b;
        this.f3525c = aVar.f3531c.mo3182a();
        this.f3526d = aVar.f3532d;
        this.f3527e = aVar.f3533e != null ? aVar.f3533e : this;
    }

    /* renamed from: a */
    public brr mo3343a() {
        return this.f3523a;
    }

    /* renamed from: b */
    public String mo3345b() {
        return this.f3524b;
    }

    /* renamed from: c */
    public brp mo3347c() {
        return this.f3525c;
    }

    /* renamed from: a */
    public String mo3344a(String str) {
        return this.f3525c.mo3170a(str);
    }

    /* renamed from: b */
    public List<String> mo3346b(String str) {
        return this.f3525c.mo3175c(str);
    }

    /* renamed from: d */
    public bsd mo3348d() {
        return this.f3526d;
    }

    /* renamed from: e */
    public Object mo3349e() {
        return this.f3527e;
    }

    /* renamed from: f */
    public C0234a mo3350f() {
        return new C0234a();
    }

    /* renamed from: g */
    public bqr mo3351g() {
        bqr bqr = this.f3528f;
        if (bqr != null) {
            return bqr;
        }
        bqr a = bqr.m8628a(this.f3525c);
        this.f3528f = a;
        return a;
    }

    /* renamed from: h */
    public boolean mo3352h() {
        return this.f3523a.mo3195d();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f3524b);
        sb.append(", url=");
        sb.append(this.f3523a);
        sb.append(", tag=");
        Object obj = this.f3527e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: atakplugin.UASTool.bsb$a */
    public static class C0234a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public brr f3529a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f3530b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public brp.C0225a f3531c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public bsd f3532d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Object f3533e;

        public C0234a() {
            this.f3530b = "GET";
            this.f3531c = new brp.C0225a();
        }

        private C0234a(bsb bsb) {
            this.f3529a = bsb.f3523a;
            this.f3530b = bsb.f3524b;
            this.f3532d = bsb.f3526d;
            this.f3533e = bsb.f3527e;
            this.f3531c = bsb.f3525c.mo3174c();
        }

        /* renamed from: a */
        public C0234a mo3357a(brr brr) {
            Objects.requireNonNull(brr, "url == null");
            this.f3529a = brr;
            return this;
        }

        /* renamed from: a */
        public C0234a mo3360a(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            brr g = brr.m8819g(str);
            if (g != null) {
                return mo3357a(g);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        /* renamed from: a */
        public C0234a mo3363a(URL url) {
            Objects.requireNonNull(url, "url == null");
            brr a = brr.m8804a(url);
            if (a != null) {
                return mo3357a(a);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }

        /* renamed from: a */
        public C0234a mo3362a(String str, String str2) {
            this.f3531c.mo3186c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C0234a mo3367b(String str, String str2) {
            this.f3531c.mo3181a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C0234a mo3366b(String str) {
            this.f3531c.mo3185c(str);
            return this;
        }

        /* renamed from: a */
        public C0234a mo3356a(brp brp) {
            this.f3531c = brp.mo3174c();
            return this;
        }

        /* renamed from: a */
        public C0234a mo3355a(bqr bqr) {
            String bqr2 = bqr.toString();
            if (bqr2.isEmpty()) {
                return mo3366b("Cache-Control");
            }
            return mo3362a("Cache-Control", bqr2);
        }

        /* renamed from: a */
        public C0234a mo3354a() {
            return mo3361a("GET", (bsd) null);
        }

        /* renamed from: b */
        public C0234a mo3364b() {
            return mo3361a("HEAD", (bsd) null);
        }

        /* renamed from: a */
        public C0234a mo3358a(bsd bsd) {
            return mo3361a("POST", bsd);
        }

        /* renamed from: b */
        public C0234a mo3365b(bsd bsd) {
            return mo3361a("DELETE", bsd);
        }

        /* renamed from: c */
        public C0234a mo3368c() {
            return mo3365b(bsd.create((bru) null, new byte[0]));
        }

        /* renamed from: c */
        public C0234a mo3369c(bsd bsd) {
            return mo3361a("PUT", bsd);
        }

        /* renamed from: d */
        public C0234a mo3370d(bsd bsd) {
            return mo3361a("PATCH", bsd);
        }

        /* renamed from: a */
        public C0234a mo3361a(String str, bsd bsd) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (bsd != null && !bvb.m9790c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (bsd != null || !bvb.m9789b(str)) {
                this.f3530b = str;
                this.f3532d = bsd;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        /* renamed from: a */
        public C0234a mo3359a(Object obj) {
            this.f3533e = obj;
            return this;
        }

        /* renamed from: d */
        public bsb mo3371d() {
            if (this.f3529a != null) {
                return new bsb(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
