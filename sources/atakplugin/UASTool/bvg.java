package atakplugin.UASTool;

import atakplugin.UASTool.brt;
import atakplugin.UASTool.bsb;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class bvg implements brt {

    /* renamed from: a */
    private static final int f4032a = 20;

    /* renamed from: b */
    private final brw f4033b;

    /* renamed from: c */
    private btm f4034c;

    /* renamed from: d */
    private boolean f4035d;

    /* renamed from: e */
    private volatile boolean f4036e;

    public bvg(brw brw) {
        this.f4033b = brw;
    }

    /* renamed from: a */
    public void mo3703a() {
        this.f4036e = true;
        btm btm = this.f4034c;
        if (btm != null) {
            btm.mo3491e();
        }
    }

    /* renamed from: b */
    public boolean mo3705b() {
        return this.f4036e;
    }

    /* renamed from: c */
    public brw mo3706c() {
        return this.f4033b;
    }

    /* renamed from: a */
    public void mo3704a(boolean z) {
        this.f4035d = z;
    }

    /* renamed from: d */
    public boolean mo3707d() {
        return this.f4035d;
    }

    /* renamed from: e */
    public btm mo3708e() {
        return this.f4034c;
    }

    /* renamed from: a */
    public bsh mo3248a(brt.C0228a aVar) {
        bsb a = aVar.mo3249a();
        this.f4034c = new btm(this.f4033b.mo3286p(), m9811a(a.mo3343a()));
        bsh bsh = null;
        int i = 0;
        while (!this.f4036e) {
            try {
                bsh a2 = ((bvd) aVar).mo3700a(a, this.f4034c, (bvc) null, (bqz) null);
                if (bsh != null) {
                    a2 = a2.mo3385i().mo3410c(bsh.mo3385i().mo3402a((bsj) null).mo3405a()).mo3405a();
                }
                bsh = a2;
                a = m9812a(bsh);
                if (a == null) {
                    if (!this.f4035d) {
                        this.f4034c.mo3489c();
                    }
                    return bsh;
                }
                bsp.m9158a((Closeable) bsh.mo3384h());
                i++;
                if (i > 20) {
                    this.f4034c.mo3489c();
                    throw new ProtocolException("Too many follow-up requests: " + i);
                } else if (a.mo3348d() instanceof bvi) {
                    throw new HttpRetryException("Cannot retry streamed HTTP body", bsh.mo3378c());
                } else if (!m9813a(bsh, a.mo3343a())) {
                    this.f4034c.mo3489c();
                    this.f4034c = new btm(this.f4033b.mo3286p(), m9811a(a.mo3343a()));
                } else if (this.f4034c.mo3483a() != null) {
                    throw new IllegalStateException("Closing the body of " + bsh + " didn't close its backing stream. Bad interceptor?");
                }
            } catch (btk e) {
                if (!m9815a(e.mo3478a(), true, a)) {
                    throw e.mo3478a();
                }
            } catch (IOException e2) {
                if (!m9815a(e2, false, a)) {
                    throw e2;
                }
            } catch (Throwable th) {
                this.f4034c.mo3486a((IOException) null);
                this.f4034c.mo3489c();
                throw th;
            }
        }
        this.f4034c.mo3489c();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    private bqj m9811a(brr brr) {
        bqv bqv;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (brr.mo3195d()) {
            SSLSocketFactory k = this.f4033b.mo3281k();
            hostnameVerifier = this.f4033b.mo3282l();
            sSLSocketFactory = k;
            bqv = this.f4033b.mo3283m();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            bqv = null;
        }
        return new bqj(brr.mo3204i(), brr.mo3205j(), this.f4033b.mo3279i(), this.f4033b.mo3280j(), sSLSocketFactory, hostnameVerifier, bqv, this.f4033b.mo3285o(), this.f4033b.mo3274d(), this.f4033b.mo3291u(), this.f4033b.mo3292v(), this.f4033b.mo3275e());
    }

    /* renamed from: a */
    private boolean m9815a(IOException iOException, boolean z, bsb bsb) {
        this.f4034c.mo3486a(iOException);
        if (!this.f4033b.mo3289s()) {
            return false;
        }
        if ((z || !(bsb.mo3348d() instanceof bvi)) && m9814a(iOException, z) && this.f4034c.mo3492f()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m9814a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || !z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private bsb m9812a(bsh bsh) {
        String b;
        brr e;
        Proxy proxy;
        if (bsh != null) {
            bti b2 = this.f4034c.mo3488b();
            bsl a = b2 != null ? b2.mo3080a() : null;
            int c = bsh.mo3378c();
            String b3 = bsh.mo3372a().mo3345b();
            if (c == 307 || c == 308) {
                if (!b3.equals("GET") && !b3.equals("HEAD")) {
                    return null;
                }
            } else if (c == 401) {
                return this.f4033b.mo3284n().mo2997a(a, bsh);
            } else {
                if (c == 407) {
                    if (a != null) {
                        proxy = a.mo3417b();
                    } else {
                        proxy = this.f4033b.mo3274d();
                    }
                    if (proxy.type() == Proxy.Type.HTTP) {
                        return this.f4033b.mo3285o().mo2997a(a, bsh);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (c != 408) {
                    switch (c) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (bsh.mo3372a().mo3348d() instanceof bvi) {
                    return null;
                } else {
                    return bsh.mo3372a();
                }
            }
            if (!this.f4033b.mo3288r() || (b = bsh.mo3377b("Location")) == null || (e = bsh.mo3372a().mo3343a().mo3196e(b)) == null) {
                return null;
            }
            if (!e.mo3192c().equals(bsh.mo3372a().mo3343a().mo3192c()) && !this.f4033b.mo3287q()) {
                return null;
            }
            bsb.C0234a f = bsh.mo3372a().mo3350f();
            if (bvb.m9790c(b3)) {
                if (bvb.m9791d(b3)) {
                    f.mo3361a("GET", (bsd) null);
                } else {
                    f.mo3361a(b3, (bsd) null);
                }
                f.mo3366b(HttpHeaders.TRANSFER_ENCODING);
                f.mo3366b("Content-Length");
                f.mo3366b("Content-Type");
            }
            if (!m9813a(bsh, e)) {
                f.mo3366b(HttpHeaders.AUTHORIZATION);
            }
            return f.mo3357a(e).mo3371d();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private boolean m9813a(bsh bsh, brr brr) {
        brr a = bsh.mo3372a().mo3343a();
        return a.mo3204i().equals(brr.mo3204i()) && a.mo3205j() == brr.mo3205j() && a.mo3192c().equals(brr.mo3192c());
    }
}
