package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class bqv {

    /* renamed from: a */
    public static final bqv f3224a = new C0219a().mo3068a();

    /* renamed from: b */
    private final List<C0220b> f3225b;

    /* renamed from: c */
    private final bvr f3226c;

    private bqv(List<C0220b> list, bvr bvr) {
        this.f3225b = list;
        this.f3226c = bvr;
    }

    /* renamed from: a */
    public void mo3065a(String str, List<Certificate> list) {
        List<C0220b> a = mo3064a(str);
        if (!a.isEmpty()) {
            bvr bvr = this.f3226c;
            if (bvr != null) {
                list = bvr.mo3725a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                bwq bwq = null;
                bwq bwq2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    C0220b bVar = a.get(i2);
                    if (bVar.f3231c.equals("sha256/")) {
                        if (bwq == null) {
                            bwq = m8658b(x509Certificate);
                        }
                        if (bVar.f3232d.equals(bwq)) {
                            return;
                        }
                    } else if (bVar.f3231c.equals("sha1/")) {
                        if (bwq2 == null) {
                            bwq2 = m8656a(x509Certificate);
                        }
                        if (bVar.f3232d.equals(bwq2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(m8657a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(a.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo3066a(String str, Certificate... certificateArr) {
        mo3065a(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C0220b> mo3064a(String str) {
        List<C0220b> emptyList = Collections.emptyList();
        for (C0220b next : this.f3225b) {
            if (next.mo3069a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public bqv mo3063a(bvr bvr) {
        return this.f3226c != bvr ? new bqv(this.f3225b, bvr) : this;
    }

    /* renamed from: a */
    public static String m8657a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m8658b((X509Certificate) certificate).mo3933d();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static bwq m8656a(X509Certificate x509Certificate) {
        return bsp.m9149a(bwq.m10200e(x509Certificate.getPublicKey().getEncoded()));
    }

    /* renamed from: b */
    static bwq m8658b(X509Certificate x509Certificate) {
        return bsp.m9168b(bwq.m10200e(x509Certificate.getPublicKey().getEncoded()));
    }

    /* renamed from: atakplugin.UASTool.bqv$b */
    static final class C0220b {

        /* renamed from: e */
        private static final String f3228e = "*.";

        /* renamed from: a */
        final String f3229a;

        /* renamed from: b */
        final String f3230b;

        /* renamed from: c */
        final String f3231c;

        /* renamed from: d */
        final bwq f3232d;

        C0220b(String str, String str2) {
            String str3;
            this.f3229a = str;
            if (str.startsWith(f3228e)) {
                str3 = brr.m8819g("http://" + str.substring(2)).mo3204i();
            } else {
                str3 = brr.m8819g("http://" + str).mo3204i();
            }
            this.f3230b = str3;
            if (str2.startsWith("sha1/")) {
                this.f3231c = "sha1/";
                this.f3232d = bwq.m10197c(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.f3231c = "sha256/";
                this.f3232d = bwq.m10197c(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.f3232d == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3069a(String str) {
            if (!this.f3229a.startsWith(f3228e)) {
                return str.equals(this.f3230b);
            }
            String str2 = this.f3230b;
            return str.regionMatches(false, str.indexOf(46) + 1, str2, 0, str2.length());
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0220b) {
                C0220b bVar = (C0220b) obj;
                return this.f3229a.equals(bVar.f3229a) && this.f3231c.equals(bVar.f3231c) && this.f3232d.equals(bVar.f3232d);
            }
        }

        public int hashCode() {
            return ((((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + this.f3229a.hashCode()) * 31) + this.f3231c.hashCode()) * 31) + this.f3232d.hashCode();
        }

        public String toString() {
            return this.f3231c + this.f3232d.mo3933d();
        }
    }

    /* renamed from: atakplugin.UASTool.bqv$a */
    public static final class C0219a {

        /* renamed from: a */
        private final List<C0220b> f3227a = new ArrayList();

        /* renamed from: a */
        public C0219a mo3067a(String str, String... strArr) {
            Objects.requireNonNull(str, "pattern == null");
            for (String bVar : strArr) {
                this.f3227a.add(new C0220b(str, bVar));
            }
            return this;
        }

        /* renamed from: a */
        public bqv mo3068a() {
            return new bqv(bsp.m9153a(this.f3227a), (bvr) null);
        }
    }
}
