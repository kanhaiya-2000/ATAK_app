package atakplugin.UASTool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public abstract class bvu {
    /* renamed from: a */
    public abstract X509Certificate mo3737a(X509Certificate x509Certificate);

    /* renamed from: a */
    public static bvu m9900a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C0268a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return m9901a(x509TrustManager.getAcceptedIssuers());
        }
    }

    /* renamed from: a */
    public static bvu m9901a(X509Certificate... x509CertificateArr) {
        return new C0269b(x509CertificateArr);
    }

    /* renamed from: atakplugin.UASTool.bvu$a */
    static final class C0268a extends bvu {

        /* renamed from: a */
        private final X509TrustManager f4081a;

        /* renamed from: b */
        private final Method f4082b;

        C0268a(X509TrustManager x509TrustManager, Method method) {
            this.f4082b = method;
            this.f4081a = x509TrustManager;
        }

        /* renamed from: a */
        public X509Certificate mo3737a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f4082b.invoke(this.f4081a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                return null;
            }
        }
    }

    /* renamed from: atakplugin.UASTool.bvu$b */
    static final class C0269b extends bvu {

        /* renamed from: a */
        private final Map<X500Principal, List<X509Certificate>> f4083a = new LinkedHashMap();

        public C0269b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                List list = this.f4083a.get(subjectX500Principal);
                if (list == null) {
                    list = new ArrayList(1);
                    this.f4083a.put(subjectX500Principal, list);
                }
                list.add(x509Certificate);
            }
        }

        /* renamed from: a */
        public X509Certificate mo3737a(X509Certificate x509Certificate) {
            List<X509Certificate> list = this.f4083a.get(x509Certificate.getIssuerX500Principal());
            if (list == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : list) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }
}
