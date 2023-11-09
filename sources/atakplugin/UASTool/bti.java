package atakplugin.UASTool;

import atakplugin.UASTool.bsb;
import atakplugin.UASTool.btq;
import com.autel.util.okhttp.model.Headers;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class bti extends btq.C0243b implements bqz {

    /* renamed from: a */
    public Socket f3674a;

    /* renamed from: b */
    public volatile btq f3675b;

    /* renamed from: c */
    public int f3676c;

    /* renamed from: d */
    public bwp f3677d;

    /* renamed from: e */
    public bwo f3678e;

    /* renamed from: f */
    public int f3679f;

    /* renamed from: g */
    public final List<Reference<btm>> f3680g = new ArrayList();

    /* renamed from: h */
    public boolean f3681h;

    /* renamed from: i */
    public long f3682i = bfu.f2629b;

    /* renamed from: k */
    private final bsl f3683k;

    /* renamed from: l */
    private Socket f3684l;

    /* renamed from: m */
    private bro f3685m;

    /* renamed from: n */
    private bry f3686n;

    public bti(bsl bsl) {
        this.f3683k = bsl;
    }

    /* renamed from: a */
    public void mo3468a(int i, int i2, int i3, List<brc> list, boolean z) {
        if (this.f3686n == null) {
            bth bth = new bth(list);
            if (this.f3683k.mo3416a().mo2994i() == null) {
                if (list.contains(brc.f3345c)) {
                    String i4 = this.f3683k.mo3416a().mo2984a().mo3204i();
                    if (!bvp.m9870b().mo3724a(i4)) {
                        throw new btk(new UnknownServiceException("CLEARTEXT communication to " + i4 + " not permitted by network security policy"));
                    }
                } else {
                    throw new btk(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            }
            btk btk = null;
            while (this.f3686n == null) {
                try {
                    if (this.f3683k.mo3419d()) {
                        m9286a(i, i2, i3, bth);
                    } else {
                        m9288b(i, i2, i3, bth);
                    }
                } catch (IOException e) {
                    bsp.m9161a(this.f3674a);
                    bsp.m9161a(this.f3684l);
                    this.f3674a = null;
                    this.f3684l = null;
                    this.f3677d = null;
                    this.f3678e = null;
                    this.f3685m = null;
                    this.f3686n = null;
                    if (btk == null) {
                        btk = new btk(e);
                    } else {
                        btk.mo3479a(e);
                    }
                    if (!z || !bth.mo3467a(e)) {
                        throw btk;
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("already connected");
    }

    /* renamed from: a */
    private void m9286a(int i, int i2, int i3, bth bth) {
        bsb g = m9290g();
        brr a = g.mo3343a();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 <= 21) {
                m9285a(i, i2);
                g = m9284a(i2, i3, g, a);
                if (g == null) {
                    m9287a(i2, i3, bth);
                    return;
                }
                bsp.m9161a(this.f3684l);
                this.f3684l = null;
                this.f3678e = null;
                this.f3677d = null;
            } else {
                throw new ProtocolException("Too many tunnel connections attempted: " + 21);
            }
        }
    }

    /* renamed from: b */
    private void m9288b(int i, int i2, int i3, bth bth) {
        m9285a(i, i2);
        m9287a(i2, i3, bth);
    }

    /* renamed from: a */
    private void m9285a(int i, int i2) {
        Proxy b = this.f3683k.mo3417b();
        Socket createSocket = (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) ? this.f3683k.mo3416a().mo2986c().createSocket() : new Socket(b);
        this.f3684l = createSocket;
        createSocket.setSoTimeout(i2);
        try {
            bvp.m9870b().mo3722a(this.f3684l, this.f3683k.mo3418c(), i);
            this.f3677d = bxb.m10330a(bxb.m10341b(this.f3684l));
            this.f3678e = bxb.m10329a(bxb.m10336a(this.f3684l));
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.f3683k.mo3418c());
        }
    }

    /* renamed from: a */
    private void m9287a(int i, int i2, bth bth) {
        if (this.f3683k.mo3416a().mo2994i() != null) {
            m9289b(i, i2, bth);
        } else {
            this.f3686n = bry.HTTP_1_1;
            this.f3674a = this.f3684l;
        }
        if (this.f3686n == bry.SPDY_3 || this.f3686n == bry.HTTP_2) {
            this.f3674a.setSoTimeout(0);
            btq a = new btq.C0242a(true).mo3545a(this.f3674a, this.f3683k.mo3416a().mo2984a().mo3204i(), this.f3677d, this.f3678e).mo3541a(this.f3686n).mo3542a((btq.C0243b) this).mo3546a();
            a.mo3540f();
            this.f3679f = a.mo3536c();
            this.f3675b = a;
            return;
        }
        this.f3679f = 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0113 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0119 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9289b(int r6, int r7, atakplugin.UASTool.bth r8) {
        /*
            r5 = this;
            atakplugin.UASTool.bsl r6 = r5.f3683k
            atakplugin.UASTool.bqj r6 = r6.mo3416a()
            javax.net.ssl.SSLSocketFactory r7 = r6.mo2994i()
            r0 = 0
            java.net.Socket r1 = r5.f3684l     // Catch:{ AssertionError -> 0x010c }
            atakplugin.UASTool.brr r2 = r6.mo2984a()     // Catch:{ AssertionError -> 0x010c }
            java.lang.String r2 = r2.mo3204i()     // Catch:{ AssertionError -> 0x010c }
            atakplugin.UASTool.brr r3 = r6.mo2984a()     // Catch:{ AssertionError -> 0x010c }
            int r3 = r3.mo3205j()     // Catch:{ AssertionError -> 0x010c }
            r4 = 1
            java.net.Socket r7 = r7.createSocket(r1, r2, r3, r4)     // Catch:{ AssertionError -> 0x010c }
            javax.net.ssl.SSLSocket r7 = (javax.net.ssl.SSLSocket) r7     // Catch:{ AssertionError -> 0x010c }
            atakplugin.UASTool.brc r8 = r8.mo3466a((javax.net.ssl.SSLSocket) r7)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            boolean r1 = r8.mo3097d()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            if (r1 == 0) goto L_0x0041
            atakplugin.UASTool.bvp r1 = atakplugin.UASTool.bvp.m9870b()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.brr r2 = r6.mo2984a()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r2 = r2.mo3204i()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.util.List r3 = r6.mo2988e()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r1.mo3723a((javax.net.ssl.SSLSocket) r7, (java.lang.String) r2, (java.util.List<atakplugin.UASTool.bry>) r3)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
        L_0x0041:
            r7.startHandshake()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            javax.net.ssl.SSLSession r1 = r7.getSession()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.bro r1 = atakplugin.UASTool.bro.m8772a(r1)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            javax.net.ssl.HostnameVerifier r2 = r6.mo2995j()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.brr r3 = r6.mo2984a()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r3 = r3.mo3204i()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            javax.net.ssl.SSLSession r4 = r7.getSession()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            boolean r2 = r2.verify(r3, r4)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            if (r2 == 0) goto L_0x00b2
            atakplugin.UASTool.bqv r2 = r6.mo2996k()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.brr r6 = r6.mo2984a()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = r6.mo3204i()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.util.List r3 = r1.mo3162c()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r2.mo3065a((java.lang.String) r6, (java.util.List<java.security.cert.Certificate>) r3)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            boolean r6 = r8.mo3097d()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            if (r6 == 0) goto L_0x0083
            atakplugin.UASTool.bvp r6 = atakplugin.UASTool.bvp.m9870b()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r0 = r6.mo3719a((javax.net.ssl.SSLSocket) r7)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
        L_0x0083:
            r5.f3674a = r7     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.bxr r6 = atakplugin.UASTool.bxb.m10341b((java.net.Socket) r7)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.bwp r6 = atakplugin.UASTool.bxb.m10330a((atakplugin.UASTool.bxr) r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r5.f3677d = r6     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.net.Socket r6 = r5.f3674a     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.bxp r6 = atakplugin.UASTool.bxb.m10336a((java.net.Socket) r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.bwo r6 = atakplugin.UASTool.bxb.m10329a((atakplugin.UASTool.bxp) r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r5.f3678e = r6     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r5.f3685m = r1     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            if (r0 == 0) goto L_0x00a4
            atakplugin.UASTool.bry r6 = atakplugin.UASTool.bry.m8990a(r0)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            goto L_0x00a6
        L_0x00a4:
            atakplugin.UASTool.bry r6 = atakplugin.UASTool.bry.HTTP_1_1     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
        L_0x00a6:
            r5.f3686n = r6     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            if (r7 == 0) goto L_0x00b1
            atakplugin.UASTool.bvp r6 = atakplugin.UASTool.bvp.m9870b()
            r6.mo3726b((javax.net.ssl.SSLSocket) r7)
        L_0x00b1:
            return
        L_0x00b2:
            java.util.List r8 = r1.mo3162c()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r0 = 0
            java.lang.Object r8 = r8.get(r0)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            javax.net.ssl.SSLPeerUnverifiedException r0 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r1.<init>()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r2 = "Hostname "
            r1.append(r2)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            atakplugin.UASTool.brr r6 = r6.mo2984a()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = r6.mo3204i()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = " not verified:\n    certificate: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = atakplugin.UASTool.bqv.m8657a((java.security.cert.Certificate) r8)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = "\n    DN: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.security.Principal r6 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = r6.getName()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = "\n    subjectAltNames: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.util.List r6 = atakplugin.UASTool.bvt.m9894a(r8)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            java.lang.String r6 = r1.toString()     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            r0.<init>(r6)     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
            throw r0     // Catch:{ AssertionError -> 0x0107, all -> 0x0104 }
        L_0x0104:
            r6 = move-exception
            r0 = r7
            goto L_0x011a
        L_0x0107:
            r6 = move-exception
            r0 = r7
            goto L_0x010d
        L_0x010a:
            r6 = move-exception
            goto L_0x011a
        L_0x010c:
            r6 = move-exception
        L_0x010d:
            boolean r7 = atakplugin.UASTool.bsp.m9163a((java.lang.AssertionError) r6)     // Catch:{ all -> 0x010a }
            if (r7 == 0) goto L_0x0119
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x010a }
            r7.<init>(r6)     // Catch:{ all -> 0x010a }
            throw r7     // Catch:{ all -> 0x010a }
        L_0x0119:
            throw r6     // Catch:{ all -> 0x010a }
        L_0x011a:
            if (r0 == 0) goto L_0x0123
            atakplugin.UASTool.bvp r7 = atakplugin.UASTool.bvp.m9870b()
            r7.mo3726b((javax.net.ssl.SSLSocket) r0)
        L_0x0123:
            atakplugin.UASTool.bsp.m9161a((java.net.Socket) r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bti.m9289b(int, int, atakplugin.UASTool.bth):void");
    }

    /* renamed from: a */
    private bsb m9284a(int i, int i2, bsb bsb, brr brr) {
        String str = "CONNECT " + bsp.m9150a(brr, true) + " HTTP/1.1";
        while (true) {
            buv buv = new buv((brw) null, (btm) null, this.f3677d, this.f3678e);
            this.f3677d.timeout().mo3984a((long) i, TimeUnit.MILLISECONDS);
            this.f3678e.timeout().mo3984a((long) i2, TimeUnit.MILLISECONDS);
            buv.mo3685a(bsb.mo3347c(), str);
            buv.mo3690d();
            bsh a = buv.mo3691e().mo3400a(bsb).mo3405a();
            long a2 = bva.m9775a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            bxr b = buv.mo3688b(a2);
            bsp.m9170b(b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b.close();
            int c = a.mo3378c();
            if (c != 200) {
                if (c == 407) {
                    bsb a3 = this.f3683k.mo3416a().mo2987d().mo2997a(this.f3683k, a);
                    if (a3 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (Headers.HEAD_VALUE_CONNECTION_CLOSE.equalsIgnoreCase(a.mo3377b("Connection"))) {
                        return a3;
                    } else {
                        bsb = a3;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + a.mo3378c());
                }
            } else if (this.f3677d.mo3811b().mo3854i() && this.f3678e.mo3811b().mo3854i()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: g */
    private bsb m9290g() {
        return new bsb.C0234a().mo3357a(this.f3683k.mo3416a().mo2984a()).mo3362a(HttpHeaders.HOST, bsp.m9150a(this.f3683k.mo3416a().mo2984a(), true)).mo3362a("Proxy-Connection", "Keep-Alive").mo3362a("User-Agent", bsr.m9176a()).mo3371d();
    }

    /* renamed from: a */
    public bsl mo3080a() {
        return this.f3683k;
    }

    /* renamed from: e */
    public void mo3472e() {
        bsp.m9161a(this.f3684l);
    }

    /* renamed from: b */
    public Socket mo3081b() {
        return this.f3674a;
    }

    /* renamed from: a */
    public boolean mo3471a(boolean z) {
        int soTimeout;
        if (this.f3674a.isClosed() || this.f3674a.isInputShutdown() || this.f3674a.isOutputShutdown()) {
            return false;
        }
        if (this.f3675b == null && z) {
            try {
                soTimeout = this.f3674a.getSoTimeout();
                this.f3674a.setSoTimeout(1);
                if (this.f3677d.mo3854i()) {
                    this.f3674a.setSoTimeout(soTimeout);
                    return false;
                }
                this.f3674a.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f3674a.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo3470a(buc buc) {
        buc.mo3595a(btn.REFUSED_STREAM);
    }

    /* renamed from: a */
    public void mo3469a(btq btq) {
        this.f3679f = btq.mo3536c();
    }

    /* renamed from: c */
    public bro mo3082c() {
        return this.f3685m;
    }

    /* renamed from: f */
    public boolean mo3473f() {
        return this.f3675b != null;
    }

    /* renamed from: d */
    public bry mo3083d() {
        if (this.f3675b != null) {
            return this.f3675b.mo3521a();
        }
        bry bry = this.f3686n;
        return bry != null ? bry : bry.HTTP_1_1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f3683k.mo3416a().mo2984a().mo3204i());
        sb.append(":");
        sb.append(this.f3683k.mo3416a().mo2984a().mo3205j());
        sb.append(", proxy=");
        sb.append(this.f3683k.mo3417b());
        sb.append(" hostAddress=");
        sb.append(this.f3683k.mo3418c());
        sb.append(" cipherSuite=");
        bro bro = this.f3685m;
        sb.append(bro != null ? bro.mo3161b() : "none");
        sb.append(" protocol=");
        sb.append(this.f3686n);
        sb.append('}');
        return sb.toString();
    }
}
