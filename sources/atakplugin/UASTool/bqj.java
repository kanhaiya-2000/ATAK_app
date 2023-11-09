package atakplugin.UASTool;

import atakplugin.UASTool.brr;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class bqj {

    /* renamed from: a */
    final brr f3149a;

    /* renamed from: b */
    final brk f3150b;

    /* renamed from: c */
    final SocketFactory f3151c;

    /* renamed from: d */
    final bqk f3152d;

    /* renamed from: e */
    final List<bry> f3153e;

    /* renamed from: f */
    final List<brc> f3154f;

    /* renamed from: g */
    final ProxySelector f3155g;

    /* renamed from: h */
    final Proxy f3156h;

    /* renamed from: i */
    final SSLSocketFactory f3157i;

    /* renamed from: j */
    final HostnameVerifier f3158j;

    /* renamed from: k */
    final bqv f3159k;

    public bqj(String str, int i, brk brk, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, bqv bqv, bqk bqk, Proxy proxy, List<bry> list, List<brc> list2, ProxySelector proxySelector) {
        this.f3149a = new brr.C0226a().mo3222a(sSLSocketFactory != null ? "https" : "http").mo3235f(str).mo3220a(i).mo3231c();
        Objects.requireNonNull(brk, "dns == null");
        this.f3150b = brk;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f3151c = socketFactory;
        Objects.requireNonNull(bqk, "proxyAuthenticator == null");
        this.f3152d = bqk;
        Objects.requireNonNull(list, "protocols == null");
        this.f3153e = bsp.m9153a(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f3154f = bsp.m9153a(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f3155g = proxySelector;
        this.f3156h = proxy;
        this.f3157i = sSLSocketFactory;
        this.f3158j = hostnameVerifier;
        this.f3159k = bqv;
    }

    /* renamed from: a */
    public brr mo2984a() {
        return this.f3149a;
    }

    /* renamed from: b */
    public brk mo2985b() {
        return this.f3150b;
    }

    /* renamed from: c */
    public SocketFactory mo2986c() {
        return this.f3151c;
    }

    /* renamed from: d */
    public bqk mo2987d() {
        return this.f3152d;
    }

    /* renamed from: e */
    public List<bry> mo2988e() {
        return this.f3153e;
    }

    /* renamed from: f */
    public List<brc> mo2990f() {
        return this.f3154f;
    }

    /* renamed from: g */
    public ProxySelector mo2991g() {
        return this.f3155g;
    }

    /* renamed from: h */
    public Proxy mo2992h() {
        return this.f3156h;
    }

    /* renamed from: i */
    public SSLSocketFactory mo2994i() {
        return this.f3157i;
    }

    /* renamed from: j */
    public HostnameVerifier mo2995j() {
        return this.f3158j;
    }

    /* renamed from: k */
    public bqv mo2996k() {
        return this.f3159k;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bqj)) {
            return false;
        }
        bqj bqj = (bqj) obj;
        if (!this.f3149a.equals(bqj.f3149a) || !this.f3150b.equals(bqj.f3150b) || !this.f3152d.equals(bqj.f3152d) || !this.f3153e.equals(bqj.f3153e) || !this.f3154f.equals(bqj.f3154f) || !this.f3155g.equals(bqj.f3155g) || !bsp.m9164a((Object) this.f3156h, (Object) bqj.f3156h) || !bsp.m9164a((Object) this.f3157i, (Object) bqj.f3157i) || !bsp.m9164a((Object) this.f3158j, (Object) bqj.f3158j) || !bsp.m9164a((Object) this.f3159k, (Object) bqj.f3159k)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + this.f3149a.hashCode()) * 31) + this.f3150b.hashCode()) * 31) + this.f3152d.hashCode()) * 31) + this.f3153e.hashCode()) * 31) + this.f3154f.hashCode()) * 31) + this.f3155g.hashCode()) * 31;
        Proxy proxy = this.f3156h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f3157i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f3158j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        bqv bqv = this.f3159k;
        if (bqv != null) {
            i = bqv.hashCode();
        }
        return hashCode4 + i;
    }
}
