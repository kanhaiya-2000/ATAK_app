package atakplugin.UASTool;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public abstract class bvr {
    /* renamed from: a */
    public abstract List<Certificate> mo3725a(List<Certificate> list, String str);

    /* renamed from: a */
    public static bvr m9883a(X509TrustManager x509TrustManager) {
        return bvp.m9870b().mo3718a(x509TrustManager);
    }

    /* renamed from: a */
    public static bvr m9884a(X509Certificate... x509CertificateArr) {
        return new bvq(bvu.m9901a(x509CertificateArr));
    }
}
