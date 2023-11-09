package atakplugin.UASTool;

import atakplugin.UASTool.brp;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.util.Collections;
import java.util.List;

public final class bsh implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final bsb f3542a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final bry f3543b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f3544c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f3545d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final bro f3546e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final brp f3547f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final bsj f3548g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final bsh f3549h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final bsh f3550i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final bsh f3551j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final long f3552k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final long f3553l;

    /* renamed from: m */
    private volatile bqr f3554m;

    private bsh(C0235a aVar) {
        this.f3542a = aVar.f3555a;
        this.f3543b = aVar.f3556b;
        this.f3544c = aVar.f3557c;
        this.f3545d = aVar.f3558d;
        this.f3546e = aVar.f3559e;
        this.f3547f = aVar.f3560f.mo3182a();
        this.f3548g = aVar.f3561g;
        this.f3549h = aVar.f3562h;
        this.f3550i = aVar.f3563i;
        this.f3551j = aVar.f3564j;
        this.f3552k = aVar.f3565k;
        this.f3553l = aVar.f3566l;
    }

    /* renamed from: a */
    public bsb mo3372a() {
        return this.f3542a;
    }

    /* renamed from: b */
    public bry mo3376b() {
        return this.f3543b;
    }

    /* renamed from: c */
    public int mo3378c() {
        return this.f3544c;
    }

    /* renamed from: d */
    public boolean mo3380d() {
        int i = this.f3544c;
        return i >= 200 && i < 300;
    }

    /* renamed from: e */
    public String mo3381e() {
        return this.f3545d;
    }

    /* renamed from: f */
    public bro mo3382f() {
        return this.f3546e;
    }

    /* renamed from: a */
    public List<String> mo3375a(String str) {
        return this.f3547f.mo3175c(str);
    }

    /* renamed from: b */
    public String mo3377b(String str) {
        return mo3374a(str, (String) null);
    }

    /* renamed from: a */
    public String mo3374a(String str, String str2) {
        String a = this.f3547f.mo3170a(str);
        return a != null ? a : str2;
    }

    /* renamed from: g */
    public brp mo3383g() {
        return this.f3547f;
    }

    /* renamed from: a */
    public bsj mo3373a(long j) {
        bwp c = this.f3548g.mo3018c();
        c.mo3829c(j);
        bwl G = c.mo3811b().clone();
        if (G.mo3783a() > j) {
            bwl bwl = new bwl();
            bwl.write(G, j);
            G.mo3769B();
            G = bwl;
        }
        return bsj.m9112a(this.f3548g.mo3016a(), G.mo3783a(), G);
    }

    /* renamed from: h */
    public bsj mo3384h() {
        return this.f3548g;
    }

    /* renamed from: i */
    public C0235a mo3385i() {
        return new C0235a();
    }

    /* renamed from: j */
    public boolean mo3386j() {
        int i = this.f3544c;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: k */
    public bsh mo3387k() {
        return this.f3549h;
    }

    /* renamed from: l */
    public bsh mo3388l() {
        return this.f3550i;
    }

    /* renamed from: m */
    public bsh mo3389m() {
        return this.f3551j;
    }

    /* renamed from: n */
    public List<bqx> mo3390n() {
        String str;
        int i = this.f3544c;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return bva.m9778a(mo3383g(), str);
    }

    /* renamed from: o */
    public bqr mo3391o() {
        bqr bqr = this.f3554m;
        if (bqr != null) {
            return bqr;
        }
        bqr a = bqr.m8628a(this.f3547f);
        this.f3554m = a;
        return a;
    }

    /* renamed from: p */
    public long mo3392p() {
        return this.f3552k;
    }

    /* renamed from: q */
    public long mo3393q() {
        return this.f3553l;
    }

    public void close() {
        this.f3548g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f3543b + ", code=" + this.f3544c + ", message=" + this.f3545d + ", url=" + this.f3542a.mo3343a() + '}';
    }

    /* renamed from: atakplugin.UASTool.bsh$a */
    public static class C0235a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public bsb f3555a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public bry f3556b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f3557c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f3558d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public bro f3559e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public brp.C0225a f3560f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public bsj f3561g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public bsh f3562h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public bsh f3563i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public bsh f3564j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public long f3565k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public long f3566l;

        public C0235a() {
            this.f3557c = -1;
            this.f3560f = new brp.C0225a();
        }

        private C0235a(bsh bsh) {
            this.f3557c = -1;
            this.f3555a = bsh.f3542a;
            this.f3556b = bsh.f3543b;
            this.f3557c = bsh.f3544c;
            this.f3558d = bsh.f3545d;
            this.f3559e = bsh.f3546e;
            this.f3560f = bsh.f3547f.mo3174c();
            this.f3561g = bsh.f3548g;
            this.f3562h = bsh.f3549h;
            this.f3563i = bsh.f3550i;
            this.f3564j = bsh.f3551j;
            this.f3565k = bsh.f3552k;
            this.f3566l = bsh.f3553l;
        }

        /* renamed from: a */
        public C0235a mo3400a(bsb bsb) {
            this.f3555a = bsb;
            return this;
        }

        /* renamed from: a */
        public C0235a mo3399a(bry bry) {
            this.f3556b = bry;
            return this;
        }

        /* renamed from: a */
        public C0235a mo3395a(int i) {
            this.f3557c = i;
            return this;
        }

        /* renamed from: a */
        public C0235a mo3403a(String str) {
            this.f3558d = str;
            return this;
        }

        /* renamed from: a */
        public C0235a mo3397a(bro bro) {
            this.f3559e = bro;
            return this;
        }

        /* renamed from: a */
        public C0235a mo3404a(String str, String str2) {
            this.f3560f.mo3186c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C0235a mo3409b(String str, String str2) {
            this.f3560f.mo3181a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C0235a mo3408b(String str) {
            this.f3560f.mo3185c(str);
            return this;
        }

        /* renamed from: a */
        public C0235a mo3398a(brp brp) {
            this.f3560f = brp.mo3174c();
            return this;
        }

        /* renamed from: a */
        public C0235a mo3402a(bsj bsj) {
            this.f3561g = bsj;
            return this;
        }

        /* renamed from: a */
        public C0235a mo3401a(bsh bsh) {
            if (bsh != null) {
                m9083a("networkResponse", bsh);
            }
            this.f3562h = bsh;
            return this;
        }

        /* renamed from: b */
        public C0235a mo3407b(bsh bsh) {
            if (bsh != null) {
                m9083a("cacheResponse", bsh);
            }
            this.f3563i = bsh;
            return this;
        }

        /* renamed from: a */
        private void m9083a(String str, bsh bsh) {
            if (bsh.f3548g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (bsh.f3549h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (bsh.f3550i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (bsh.f3551j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        /* renamed from: c */
        public C0235a mo3410c(bsh bsh) {
            if (bsh != null) {
                m9087d(bsh);
            }
            this.f3564j = bsh;
            return this;
        }

        /* renamed from: d */
        private void m9087d(bsh bsh) {
            if (bsh.f3548g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C0235a mo3396a(long j) {
            this.f3565k = j;
            return this;
        }

        /* renamed from: b */
        public C0235a mo3406b(long j) {
            this.f3566l = j;
            return this;
        }

        /* renamed from: a */
        public bsh mo3405a() {
            if (this.f3555a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f3556b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f3557c >= 0) {
                return new bsh(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.f3557c);
            }
        }
    }
}
