package atakplugin.UASTool;

import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.MessageProp;

public class akt implements agy {

    /* renamed from: a */
    private static final String f1724a = "javax.security.auth.useSubjectCredsOnly";

    /* renamed from: b */
    private static String f1725b = m1997a(f1724a);

    /* renamed from: c */
    private GSSContext f1726c = null;

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo829a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            org.ietf.jgss.Oid r6 = new org.ietf.jgss.Oid     // Catch:{ GSSException -> 0x0050 }
            java.lang.String r0 = "1.2.840.113554.1.2.2"
            r6.<init>(r0)     // Catch:{ GSSException -> 0x0050 }
            org.ietf.jgss.Oid r0 = new org.ietf.jgss.Oid     // Catch:{ GSSException -> 0x0050 }
            java.lang.String r1 = "1.2.840.113554.1.2.2.1"
            r0.<init>(r1)     // Catch:{ GSSException -> 0x0050 }
            org.ietf.jgss.GSSManager r1 = org.ietf.jgss.GSSManager.getInstance()     // Catch:{ GSSException -> 0x0050 }
            r2 = 0
            java.net.InetAddress r3 = java.net.InetAddress.getByName(r7)     // Catch:{ UnknownHostException -> 0x001b }
            java.lang.String r7 = r3.getCanonicalHostName()     // Catch:{ UnknownHostException -> 0x001b }
        L_0x001b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ GSSException -> 0x0050 }
            r3.<init>()     // Catch:{ GSSException -> 0x0050 }
            java.lang.String r4 = "host/"
            r3.append(r4)     // Catch:{ GSSException -> 0x0050 }
            r3.append(r7)     // Catch:{ GSSException -> 0x0050 }
            java.lang.String r7 = r3.toString()     // Catch:{ GSSException -> 0x0050 }
            org.ietf.jgss.GSSName r7 = r1.createName(r7, r0)     // Catch:{ GSSException -> 0x0050 }
            r0 = 0
            org.ietf.jgss.GSSContext r6 = r1.createContext(r7, r6, r2, r0)     // Catch:{ GSSException -> 0x0050 }
            r5.f1726c = r6     // Catch:{ GSSException -> 0x0050 }
            r7 = 1
            r6.requestMutualAuth(r7)     // Catch:{ GSSException -> 0x0050 }
            org.ietf.jgss.GSSContext r6 = r5.f1726c     // Catch:{ GSSException -> 0x0050 }
            r6.requestConf(r7)     // Catch:{ GSSException -> 0x0050 }
            org.ietf.jgss.GSSContext r6 = r5.f1726c     // Catch:{ GSSException -> 0x0050 }
            r6.requestInteg(r7)     // Catch:{ GSSException -> 0x0050 }
            org.ietf.jgss.GSSContext r6 = r5.f1726c     // Catch:{ GSSException -> 0x0050 }
            r6.requestCredDeleg(r7)     // Catch:{ GSSException -> 0x0050 }
            org.ietf.jgss.GSSContext r6 = r5.f1726c     // Catch:{ GSSException -> 0x0050 }
            r6.requestAnonymity(r0)     // Catch:{ GSSException -> 0x0050 }
            return
        L_0x0050:
            r6 = move-exception
            atakplugin.UASTool.ahj r7 = new atakplugin.UASTool.ahj
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.akt.mo829a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public boolean mo830a() {
        return this.f1726c.isEstablished();
    }

    /* renamed from: a */
    public byte[] mo831a(byte[] bArr, int i, int i2) {
        try {
            if (f1725b == null) {
                m1998b(f1724a, "false");
            }
            byte[] initSecContext = this.f1726c.initSecContext(bArr, 0, i2);
            if (f1725b == null) {
                m1998b(f1724a, "true");
            }
            return initSecContext;
        } catch (GSSException e) {
            throw new ahj(e.toString());
        } catch (SecurityException e2) {
            throw new ahj(e2.toString());
        } catch (Throwable th) {
            if (f1725b == null) {
                m1998b(f1724a, "true");
            }
            throw th;
        }
    }

    /* renamed from: b */
    public byte[] mo833b(byte[] bArr, int i, int i2) {
        try {
            return this.f1726c.getMIC(bArr, i, i2, new MessageProp(0, true));
        } catch (GSSException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public void mo832b() {
        try {
            this.f1726c.dispose();
        } catch (GSSException unused) {
        }
    }

    /* renamed from: a */
    private static String m1997a(String str) {
        try {
            return System.getProperty(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static void m1998b(String str, String str2) {
        try {
            System.setProperty(str, str2);
        } catch (Exception unused) {
        }
    }
}
