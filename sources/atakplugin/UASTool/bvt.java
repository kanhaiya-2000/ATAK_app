package atakplugin.UASTool;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class bvt implements HostnameVerifier {

    /* renamed from: a */
    public static final bvt f4078a = new bvt();

    /* renamed from: b */
    private static final int f4079b = 2;

    /* renamed from: c */
    private static final int f4080c = 7;

    private bvt() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return mo3735a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo3735a(String str, X509Certificate x509Certificate) {
        if (bsp.m9174e(str)) {
            return m9897b(str, x509Certificate);
        }
        return m9898c(str, x509Certificate);
    }

    /* renamed from: b */
    private boolean m9897b(String str, X509Certificate x509Certificate) {
        List<String> a = m9895a(x509Certificate, 7);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m9898c(String str, X509Certificate x509Certificate) {
        String a;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a2 = m9895a(x509Certificate, 2);
        int size = a2.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (m9896a(lowerCase, a2.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (a = new bvs(x509Certificate.getSubjectX500Principal()).mo3734a("cn")) == null) {
            return false;
        }
        return m9896a(lowerCase, a);
    }

    /* renamed from: a */
    public static List<String> m9894a(X509Certificate x509Certificate) {
        List<String> a = m9895a(x509Certificate, 7);
        List<String> a2 = m9895a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m9895a(X509Certificate x509Certificate, int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        Integer num = (Integer) next.get(0);
                        if (num != null) {
                            if (num.intValue() == i && (str = (String) next.get(1)) != null) {
                                arrayList.add(str);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    private boolean m9896a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
                return true;
            }
            return false;
        }
        return false;
    }
}
