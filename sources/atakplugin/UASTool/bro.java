package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class bro {

    /* renamed from: a */
    private final bsm f3391a;

    /* renamed from: b */
    private final bqy f3392b;

    /* renamed from: c */
    private final List<Certificate> f3393c;

    /* renamed from: d */
    private final List<Certificate> f3394d;

    private bro(bsm bsm, bqy bqy, List<Certificate> list, List<Certificate> list2) {
        this.f3391a = bsm;
        this.f3392b = bqy;
        this.f3393c = list;
        this.f3394d = list2;
    }

    /* renamed from: a */
    public static bro m8772a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            bqy a = bqy.m8668a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                bsm a2 = bsm.m9130a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = bsp.m9154a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = bsp.m9154a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new bro(a2, a, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    /* renamed from: a */
    public static bro m8771a(bsm bsm, bqy bqy, List<Certificate> list, List<Certificate> list2) {
        Objects.requireNonNull(bqy, "cipherSuite == null");
        return new bro(bsm, bqy, bsp.m9153a(list), bsp.m9153a(list2));
    }

    /* renamed from: a */
    public bsm mo3160a() {
        return this.f3391a;
    }

    /* renamed from: b */
    public bqy mo3161b() {
        return this.f3392b;
    }

    /* renamed from: c */
    public List<Certificate> mo3162c() {
        return this.f3393c;
    }

    /* renamed from: d */
    public Principal mo3163d() {
        if (!this.f3393c.isEmpty()) {
            return ((X509Certificate) this.f3393c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    /* renamed from: e */
    public List<Certificate> mo3164e() {
        return this.f3394d;
    }

    /* renamed from: f */
    public Principal mo3166f() {
        if (!this.f3394d.isEmpty()) {
            return ((X509Certificate) this.f3394d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bro)) {
            return false;
        }
        bro bro = (bro) obj;
        if (!bsp.m9164a((Object) this.f3392b, (Object) bro.f3392b) || !this.f3392b.equals(bro.f3392b) || !this.f3393c.equals(bro.f3393c) || !this.f3394d.equals(bro.f3394d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        bsm bsm = this.f3391a;
        return ((((((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + (bsm != null ? bsm.hashCode() : 0)) * 31) + this.f3392b.hashCode()) * 31) + this.f3393c.hashCode()) * 31) + this.f3394d.hashCode();
    }
}
