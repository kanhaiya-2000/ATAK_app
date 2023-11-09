package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class brc {

    /* renamed from: a */
    public static final brc f3343a;

    /* renamed from: b */
    public static final brc f3344b;

    /* renamed from: c */
    public static final brc f3345c = new C0222a(false).mo3108c();

    /* renamed from: d */
    private static final bqy[] f3346d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final boolean f3347e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final boolean f3348f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final String[] f3349g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String[] f3350h;

    static {
        bqy[] bqyArr = {bqy.f3272aK, bqy.f3276aO, bqy.f3257W, bqy.f3293am, bqy.f3292al, bqy.f3302av, bqy.f3303aw, bqy.f3240F, bqy.f3244J, bqy.f3255U, bqy.f3238D, bqy.f3242H, bqy.f3313h};
        f3346d = bqyArr;
        brc c = new C0222a(true).mo3103a(bqyArr).mo3104a(bsm.TLS_1_2, bsm.TLS_1_1, bsm.TLS_1_0).mo3102a(true).mo3108c();
        f3343a = c;
        f3344b = new C0222a(c).mo3104a(bsm.TLS_1_0).mo3102a(true).mo3108c();
    }

    private brc(C0222a aVar) {
        this.f3347e = aVar.f3351a;
        this.f3349g = aVar.f3352b;
        this.f3350h = aVar.f3353c;
        this.f3348f = aVar.f3354d;
    }

    /* renamed from: a */
    public boolean mo3093a() {
        return this.f3347e;
    }

    /* renamed from: b */
    public List<bqy> mo3095b() {
        String[] strArr = this.f3349g;
        if (strArr == null) {
            return null;
        }
        bqy[] bqyArr = new bqy[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.f3349g;
            if (i >= strArr2.length) {
                return bsp.m9154a((T[]) bqyArr);
            }
            bqyArr[i] = bqy.m8668a(strArr2[i]);
            i++;
        }
    }

    /* renamed from: c */
    public List<bsm> mo3096c() {
        String[] strArr = this.f3350h;
        if (strArr == null) {
            return null;
        }
        bsm[] bsmArr = new bsm[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.f3350h;
            if (i >= strArr2.length) {
                return bsp.m9154a((T[]) bsmArr);
            }
            bsmArr[i] = bsm.m9130a(strArr2[i]);
            i++;
        }
    }

    /* renamed from: d */
    public boolean mo3097d() {
        return this.f3348f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3092a(SSLSocket sSLSocket, boolean z) {
        brc b = m8686b(sSLSocket, z);
        String[] strArr = b.f3350h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f3349g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private brc m8686b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3 = this.f3349g;
        if (strArr3 != null) {
            strArr = (String[]) bsp.m9165a(String.class, (T[]) strArr3, (T[]) sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        String[] strArr4 = this.f3350h;
        if (strArr4 != null) {
            strArr2 = (String[]) bsp.m9165a(String.class, (T[]) strArr4, (T[]) sSLSocket.getEnabledProtocols());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        if (z && bsp.m9148a((T[]) sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
            strArr = bsp.m9166a(strArr, "TLS_FALLBACK_SCSV");
        }
        return new C0222a(this).mo3105a(strArr).mo3107b(strArr2).mo3108c();
    }

    /* renamed from: a */
    public boolean mo3094a(SSLSocket sSLSocket) {
        if (!this.f3347e) {
            return false;
        }
        String[] strArr = this.f3350h;
        if (strArr != null && !m8685a(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f3349g;
        if (strArr2 == null || m8685a(strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m8685a(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String a : strArr) {
                if (bsp.m9148a((T[]) strArr2, a) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof brc)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        brc brc = (brc) obj;
        boolean z = this.f3347e;
        if (z != brc.f3347e) {
            return false;
        }
        return !z || (Arrays.equals(this.f3349g, brc.f3349g) && Arrays.equals(this.f3350h, brc.f3350h) && this.f3348f == brc.f3348f);
    }

    public int hashCode() {
        if (this.f3347e) {
            return ((((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + Arrays.hashCode(this.f3349g)) * 31) + Arrays.hashCode(this.f3350h)) * 31) + (this.f3348f ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f3347e) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f3349g != null ? mo3095b().toString() : str;
        if (this.f3350h != null) {
            str = mo3096c().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f3348f + ")";
    }

    /* renamed from: atakplugin.UASTool.brc$a */
    public static final class C0222a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f3351a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String[] f3352b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String[] f3353c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f3354d;

        C0222a(boolean z) {
            this.f3351a = z;
        }

        public C0222a(brc brc) {
            this.f3351a = brc.f3347e;
            this.f3352b = brc.f3349g;
            this.f3353c = brc.f3350h;
            this.f3354d = brc.f3348f;
        }

        /* renamed from: a */
        public C0222a mo3101a() {
            if (this.f3351a) {
                this.f3352b = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C0222a mo3103a(bqy... bqyArr) {
            if (this.f3351a) {
                String[] strArr = new String[bqyArr.length];
                for (int i = 0; i < bqyArr.length; i++) {
                    strArr[i] = bqyArr[i].f3332aS;
                }
                return mo3105a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C0222a mo3105a(String... strArr) {
            if (!this.f3351a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f3352b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: b */
        public C0222a mo3106b() {
            if (this.f3351a) {
                this.f3353c = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: a */
        public C0222a mo3104a(bsm... bsmArr) {
            if (this.f3351a) {
                String[] strArr = new String[bsmArr.length];
                for (int i = 0; i < bsmArr.length; i++) {
                    strArr[i] = bsmArr[i].f3579e;
                }
                return mo3107b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: b */
        public C0222a mo3107b(String... strArr) {
            if (!this.f3351a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f3353c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        /* renamed from: a */
        public C0222a mo3102a(boolean z) {
            if (this.f3351a) {
                this.f3354d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: c */
        public brc mo3108c() {
            return new brc(this);
        }
    }
}
