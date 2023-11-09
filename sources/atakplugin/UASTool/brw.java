package atakplugin.UASTool;

import atakplugin.UASTool.bqt;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class brw implements bqt.C0218a, Cloneable {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public static final List<brc> f3458A = bsp.m9154a((T[]) new brc[]{brc.f3343a, brc.f3344b, brc.f3345c});
    /* access modifiers changed from: private */

    /* renamed from: z */
    public static final List<bry> f3459z = bsp.m9154a((T[]) new bry[]{bry.HTTP_2, bry.SPDY_3, bry.HTTP_1_1});

    /* renamed from: a */
    final brj f3460a;

    /* renamed from: b */
    final Proxy f3461b;

    /* renamed from: c */
    final List<bry> f3462c;

    /* renamed from: d */
    final List<brc> f3463d;

    /* renamed from: e */
    final List<brt> f3464e;

    /* renamed from: f */
    final List<brt> f3465f;

    /* renamed from: g */
    final ProxySelector f3466g;

    /* renamed from: h */
    final brg f3467h;

    /* renamed from: i */
    final bqm f3468i;

    /* renamed from: j */
    final btf f3469j;

    /* renamed from: k */
    final SocketFactory f3470k;

    /* renamed from: l */
    final SSLSocketFactory f3471l;

    /* renamed from: m */
    final bvr f3472m;

    /* renamed from: n */
    final HostnameVerifier f3473n;

    /* renamed from: o */
    final bqv f3474o;

    /* renamed from: p */
    final bqk f3475p;

    /* renamed from: q */
    final bqk f3476q;

    /* renamed from: r */
    final bra f3477r;

    /* renamed from: s */
    final brk f3478s;

    /* renamed from: t */
    final boolean f3479t;

    /* renamed from: u */
    final boolean f3480u;

    /* renamed from: v */
    final boolean f3481v;

    /* renamed from: w */
    final int f3482w;

    /* renamed from: x */
    final int f3483x;

    /* renamed from: y */
    final int f3484y;

    /* synthetic */ brw(C0231a aVar, brx brx) {
        this(aVar);
    }

    static {
        bsn.f3580a = new brx();
    }

    public brw() {
        this(new C0231a());
    }

    private brw(C0231a aVar) {
        boolean z;
        this.f3460a = aVar.f3485a;
        this.f3461b = aVar.f3486b;
        this.f3462c = aVar.f3487c;
        List<brc> list = aVar.f3488d;
        this.f3463d = list;
        this.f3464e = bsp.m9153a(aVar.f3489e);
        this.f3465f = bsp.m9153a(aVar.f3490f);
        this.f3466g = aVar.f3491g;
        this.f3467h = aVar.f3492h;
        this.f3468i = aVar.f3493i;
        this.f3469j = aVar.f3494j;
        this.f3470k = aVar.f3495k;
        Iterator<brc> it = list.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                brc next = it.next();
                if (z || next.mo3093a()) {
                    z = true;
                }
            }
        }
        if (aVar.f3496l != null || !z) {
            this.f3471l = aVar.f3496l;
            this.f3472m = aVar.f3497m;
        } else {
            X509TrustManager B = m8922B();
            this.f3471l = m8923a(B);
            this.f3472m = bvr.m9883a(B);
        }
        this.f3473n = aVar.f3498n;
        this.f3474o = aVar.f3499o.mo3063a(this.f3472m);
        this.f3475p = aVar.f3500p;
        this.f3476q = aVar.f3501q;
        this.f3477r = aVar.f3502r;
        this.f3478s = aVar.f3503s;
        this.f3479t = aVar.f3504t;
        this.f3480u = aVar.f3505u;
        this.f3481v = aVar.f3506v;
        this.f3482w = aVar.f3507w;
        this.f3483x = aVar.f3508x;
        this.f3484y = aVar.f3509y;
    }

    /* renamed from: B */
    private X509TrustManager m8922B() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m8923a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public int mo3271a() {
        return this.f3482w;
    }

    /* renamed from: b */
    public int mo3272b() {
        return this.f3483x;
    }

    /* renamed from: c */
    public int mo3273c() {
        return this.f3484y;
    }

    /* renamed from: d */
    public Proxy mo3274d() {
        return this.f3461b;
    }

    /* renamed from: e */
    public ProxySelector mo3275e() {
        return this.f3466g;
    }

    /* renamed from: f */
    public brg mo3276f() {
        return this.f3467h;
    }

    /* renamed from: g */
    public bqm mo3277g() {
        return this.f3468i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public btf mo3278h() {
        bqm bqm = this.f3468i;
        return bqm != null ? bqm.f3165a : this.f3469j;
    }

    /* renamed from: i */
    public brk mo3279i() {
        return this.f3478s;
    }

    /* renamed from: j */
    public SocketFactory mo3280j() {
        return this.f3470k;
    }

    /* renamed from: k */
    public SSLSocketFactory mo3281k() {
        return this.f3471l;
    }

    /* renamed from: l */
    public HostnameVerifier mo3282l() {
        return this.f3473n;
    }

    /* renamed from: m */
    public bqv mo3283m() {
        return this.f3474o;
    }

    /* renamed from: n */
    public bqk mo3284n() {
        return this.f3476q;
    }

    /* renamed from: o */
    public bqk mo3285o() {
        return this.f3475p;
    }

    /* renamed from: p */
    public bra mo3286p() {
        return this.f3477r;
    }

    /* renamed from: q */
    public boolean mo3287q() {
        return this.f3479t;
    }

    /* renamed from: r */
    public boolean mo3288r() {
        return this.f3480u;
    }

    /* renamed from: s */
    public boolean mo3289s() {
        return this.f3481v;
    }

    /* renamed from: t */
    public brj mo3290t() {
        return this.f3460a;
    }

    /* renamed from: u */
    public List<bry> mo3291u() {
        return this.f3462c;
    }

    /* renamed from: v */
    public List<brc> mo3292v() {
        return this.f3463d;
    }

    /* renamed from: w */
    public List<brt> mo3293w() {
        return this.f3464e;
    }

    /* renamed from: x */
    public List<brt> mo3294x() {
        return this.f3465f;
    }

    /* renamed from: a */
    public bqt mo3060a(bsb bsb) {
        return new brz(this, bsb);
    }

    /* renamed from: y */
    public C0231a mo3295y() {
        return new C0231a(this);
    }

    /* renamed from: atakplugin.UASTool.brw$a */
    public static final class C0231a {

        /* renamed from: a */
        brj f3485a;

        /* renamed from: b */
        Proxy f3486b;

        /* renamed from: c */
        List<bry> f3487c;

        /* renamed from: d */
        List<brc> f3488d;

        /* renamed from: e */
        final List<brt> f3489e;

        /* renamed from: f */
        final List<brt> f3490f;

        /* renamed from: g */
        ProxySelector f3491g;

        /* renamed from: h */
        brg f3492h;

        /* renamed from: i */
        bqm f3493i;

        /* renamed from: j */
        btf f3494j;

        /* renamed from: k */
        SocketFactory f3495k;

        /* renamed from: l */
        SSLSocketFactory f3496l;

        /* renamed from: m */
        bvr f3497m;

        /* renamed from: n */
        HostnameVerifier f3498n;

        /* renamed from: o */
        bqv f3499o;

        /* renamed from: p */
        bqk f3500p;

        /* renamed from: q */
        bqk f3501q;

        /* renamed from: r */
        bra f3502r;

        /* renamed from: s */
        brk f3503s;

        /* renamed from: t */
        boolean f3504t;

        /* renamed from: u */
        boolean f3505u;

        /* renamed from: v */
        boolean f3506v;

        /* renamed from: w */
        int f3507w;

        /* renamed from: x */
        int f3508x;

        /* renamed from: y */
        int f3509y;

        public C0231a() {
            this.f3489e = new ArrayList();
            this.f3490f = new ArrayList();
            this.f3485a = new brj();
            this.f3487c = brw.f3459z;
            this.f3488d = brw.f3458A;
            this.f3491g = ProxySelector.getDefault();
            this.f3492h = brg.f3377a;
            this.f3495k = SocketFactory.getDefault();
            this.f3498n = bvt.f4078a;
            this.f3499o = bqv.f3224a;
            this.f3500p = bqk.f3160a;
            this.f3501q = bqk.f3160a;
            this.f3502r = new bra();
            this.f3503s = brk.f3385a;
            this.f3504t = true;
            this.f3505u = true;
            this.f3506v = true;
            this.f3507w = C0827sg.f6324a;
            this.f3508x = C0827sg.f6324a;
            this.f3509y = C0827sg.f6324a;
        }

        C0231a(brw brw) {
            ArrayList arrayList = new ArrayList();
            this.f3489e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f3490f = arrayList2;
            this.f3485a = brw.f3460a;
            this.f3486b = brw.f3461b;
            this.f3487c = brw.f3462c;
            this.f3488d = brw.f3463d;
            arrayList.addAll(brw.f3464e);
            arrayList2.addAll(brw.f3465f);
            this.f3491g = brw.f3466g;
            this.f3492h = brw.f3467h;
            this.f3494j = brw.f3469j;
            this.f3493i = brw.f3468i;
            this.f3495k = brw.f3470k;
            this.f3496l = brw.f3471l;
            this.f3497m = brw.f3472m;
            this.f3498n = brw.f3473n;
            this.f3499o = brw.f3474o;
            this.f3500p = brw.f3475p;
            this.f3501q = brw.f3476q;
            this.f3502r = brw.f3477r;
            this.f3503s = brw.f3478s;
            this.f3504t = brw.f3479t;
            this.f3505u = brw.f3480u;
            this.f3506v = brw.f3481v;
            this.f3507w = brw.f3482w;
            this.f3508x = brw.f3483x;
            this.f3509y = brw.f3484y;
        }

        /* renamed from: a */
        public C0231a mo3296a(long j, TimeUnit timeUnit) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                Objects.requireNonNull(timeUnit, "unit == null");
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || i <= 0) {
                    this.f3507w = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            } else {
                throw new IllegalArgumentException("timeout < 0");
            }
        }

        /* renamed from: b */
        public C0231a mo3315b(long j, TimeUnit timeUnit) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                Objects.requireNonNull(timeUnit, "unit == null");
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || i <= 0) {
                    this.f3508x = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            } else {
                throw new IllegalArgumentException("timeout < 0");
            }
        }

        /* renamed from: c */
        public C0231a mo3321c(long j, TimeUnit timeUnit) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                Objects.requireNonNull(timeUnit, "unit == null");
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || i <= 0) {
                    this.f3509y = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            } else {
                throw new IllegalArgumentException("timeout < 0");
            }
        }

        /* renamed from: a */
        public C0231a mo3305a(Proxy proxy) {
            this.f3486b = proxy;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3306a(ProxySelector proxySelector) {
            this.f3491g = proxySelector;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3301a(brg brg) {
            Objects.requireNonNull(brg, "cookieJar == null");
            this.f3492h = brg;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3314a(btf btf) {
            this.f3494j = btf;
            this.f3493i = null;
        }

        /* renamed from: a */
        public C0231a mo3298a(bqm bqm) {
            this.f3493i = bqm;
            this.f3494j = null;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3303a(brk brk) {
            Objects.requireNonNull(brk, "dns == null");
            this.f3503s = brk;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3308a(SocketFactory socketFactory) {
            Objects.requireNonNull(socketFactory, "socketFactory == null");
            this.f3495k = socketFactory;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3310a(SSLSocketFactory sSLSocketFactory) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            X509TrustManager a = bvp.m9870b().mo3720a(sSLSocketFactory);
            if (a != null) {
                this.f3496l = sSLSocketFactory;
                this.f3497m = bvr.m9883a(a);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + bvp.m9870b() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
        }

        /* renamed from: a */
        public C0231a mo3311a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.f3496l = sSLSocketFactory;
            this.f3497m = bvr.m9883a(x509TrustManager);
            return this;
        }

        /* renamed from: a */
        public C0231a mo3309a(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.f3498n = hostnameVerifier;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3299a(bqv bqv) {
            Objects.requireNonNull(bqv, "certificatePinner == null");
            this.f3499o = bqv;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3297a(bqk bqk) {
            Objects.requireNonNull(bqk, "authenticator == null");
            this.f3501q = bqk;
            return this;
        }

        /* renamed from: b */
        public C0231a mo3316b(bqk bqk) {
            Objects.requireNonNull(bqk, "proxyAuthenticator == null");
            this.f3500p = bqk;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3300a(bra bra) {
            Objects.requireNonNull(bra, "connectionPool == null");
            this.f3502r = bra;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3312a(boolean z) {
            this.f3504t = z;
            return this;
        }

        /* renamed from: b */
        public C0231a mo3319b(boolean z) {
            this.f3505u = z;
            return this;
        }

        /* renamed from: c */
        public C0231a mo3322c(boolean z) {
            this.f3506v = z;
            return this;
        }

        /* renamed from: a */
        public C0231a mo3302a(brj brj) {
            if (brj != null) {
                this.f3485a = brj;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        /* renamed from: a */
        public C0231a mo3307a(List<bry> list) {
            List<T> a = bsp.m9153a(list);
            if (!a.contains(bry.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + a);
            } else if (a.contains(bry.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + a);
            } else if (!a.contains((Object) null)) {
                this.f3487c = bsp.m9153a(a);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        /* renamed from: b */
        public C0231a mo3318b(List<brc> list) {
            this.f3488d = bsp.m9153a(list);
            return this;
        }

        /* renamed from: a */
        public List<brt> mo3313a() {
            return this.f3489e;
        }

        /* renamed from: a */
        public C0231a mo3304a(brt brt) {
            this.f3489e.add(brt);
            return this;
        }

        /* renamed from: b */
        public List<brt> mo3320b() {
            return this.f3490f;
        }

        /* renamed from: b */
        public C0231a mo3317b(brt brt) {
            this.f3490f.add(brt);
            return this;
        }

        /* renamed from: c */
        public brw mo3323c() {
            return new brw(this, (brx) null);
        }
    }
}
