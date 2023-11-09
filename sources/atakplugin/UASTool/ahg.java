package atakplugin.UASTool;

import atakplugin.UASTool.ahf;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class ahg {

    /* renamed from: a */
    public static final String f1249a = "0.1.51";

    /* renamed from: b */
    static Hashtable f1250b;

    /* renamed from: c */
    static ahu f1251c;

    /* renamed from: i */
    private static final ahu f1252i;

    /* renamed from: d */
    private Vector f1253d = new Vector();

    /* renamed from: e */
    private ahf f1254e;

    /* renamed from: f */
    private ahf f1255f;

    /* renamed from: g */
    private agp f1256g;

    /* renamed from: h */
    private ahb f1257h;

    static {
        Hashtable hashtable = new Hashtable();
        f1250b = hashtable;
        hashtable.put("kex", "diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1");
        f1250b.put("server_host_key", "ssh-rsa,ssh-dss");
        f1250b.put("cipher.s2c", "aes128-ctr,aes128-cbc,3des-ctr,3des-cbc,blowfish-cbc,aes192-cbc,aes256-cbc");
        f1250b.put("cipher.c2s", "aes128-ctr,aes128-cbc,3des-ctr,3des-cbc,blowfish-cbc,aes192-cbc,aes256-cbc");
        f1250b.put("mac.s2c", "hmac-md5,hmac-sha1,hmac-sha2-256,hmac-sha1-96,hmac-md5-96");
        f1250b.put("mac.c2s", "hmac-md5,hmac-sha1,hmac-sha2-256,hmac-sha1-96,hmac-md5-96");
        f1250b.put("compression.s2c", "none");
        f1250b.put("compression.c2s", "none");
        f1250b.put("lang.s2c", "");
        f1250b.put("lang.c2s", "");
        f1250b.put("compression_level", "6");
        f1250b.put("diffie-hellman-group-exchange-sha1", "com.jcraft.jsch.DHGEX");
        f1250b.put("diffie-hellman-group1-sha1", "com.jcraft.jsch.DHG1");
        f1250b.put("diffie-hellman-group14-sha1", "com.jcraft.jsch.DHG14");
        f1250b.put("diffie-hellman-group-exchange-sha256", "com.jcraft.jsch.DHGEX256");
        f1250b.put("dh", "com.jcraft.jsch.jce.DH");
        f1250b.put("3des-cbc", "com.jcraft.jsch.jce.TripleDESCBC");
        f1250b.put("blowfish-cbc", "com.jcraft.jsch.jce.BlowfishCBC");
        f1250b.put("hmac-sha1", "com.jcraft.jsch.jce.HMACSHA1");
        f1250b.put("hmac-sha1-96", "com.jcraft.jsch.jce.HMACSHA196");
        f1250b.put("hmac-sha2-256", "com.jcraft.jsch.jce.HMACSHA256");
        f1250b.put("hmac-md5", "com.jcraft.jsch.jce.HMACMD5");
        f1250b.put("hmac-md5-96", "com.jcraft.jsch.jce.HMACMD596");
        f1250b.put("sha-1", "com.jcraft.jsch.jce.SHA1");
        f1250b.put("sha-256", "com.jcraft.jsch.jce.SHA256");
        f1250b.put("md5", "com.jcraft.jsch.jce.MD5");
        f1250b.put("signature.dss", "com.jcraft.jsch.jce.SignatureDSA");
        f1250b.put("signature.rsa", "com.jcraft.jsch.jce.SignatureRSA");
        f1250b.put("keypairgen.dsa", "com.jcraft.jsch.jce.KeyPairGenDSA");
        f1250b.put("keypairgen.rsa", "com.jcraft.jsch.jce.KeyPairGenRSA");
        f1250b.put("random", "com.jcraft.jsch.jce.Random");
        f1250b.put("none", "com.jcraft.jsch.CipherNone");
        f1250b.put("aes128-cbc", "com.jcraft.jsch.jce.AES128CBC");
        f1250b.put("aes192-cbc", "com.jcraft.jsch.jce.AES192CBC");
        f1250b.put("aes256-cbc", "com.jcraft.jsch.jce.AES256CBC");
        f1250b.put("aes128-ctr", "com.jcraft.jsch.jce.AES128CTR");
        f1250b.put("aes192-ctr", "com.jcraft.jsch.jce.AES192CTR");
        f1250b.put("aes256-ctr", "com.jcraft.jsch.jce.AES256CTR");
        f1250b.put("3des-ctr", "com.jcraft.jsch.jce.TripleDESCTR");
        f1250b.put("arcfour", "com.jcraft.jsch.jce.ARCFOUR");
        f1250b.put("arcfour128", "com.jcraft.jsch.jce.ARCFOUR128");
        f1250b.put("arcfour256", "com.jcraft.jsch.jce.ARCFOUR256");
        f1250b.put("userauth.none", "com.jcraft.jsch.UserAuthNone");
        f1250b.put("userauth.password", "com.jcraft.jsch.UserAuthPassword");
        f1250b.put("userauth.keyboard-interactive", "com.jcraft.jsch.UserAuthKeyboardInteractive");
        f1250b.put("userauth.publickey", "com.jcraft.jsch.UserAuthPublicKey");
        f1250b.put("userauth.gssapi-with-mic", "com.jcraft.jsch.UserAuthGSSAPIWithMIC");
        f1250b.put("gssapi-with-mic.krb5", "com.jcraft.jsch.jgss.GSSContextKrb5");
        f1250b.put("zlib", "com.jcraft.jsch.jcraft.Compression");
        f1250b.put("zlib@openssh.com", "com.jcraft.jsch.jcraft.Compression");
        f1250b.put("pbkdf", "com.jcraft.jsch.jce.PBKDF");
        f1250b.put("StrictHostKeyChecking", "ask");
        f1250b.put("HashKnownHosts", "no");
        f1250b.put("PreferredAuthentications", "gssapi-with-mic,publickey,keyboard-interactive,password");
        f1250b.put("CheckCiphers", "aes256-ctr,aes192-ctr,aes128-ctr,aes256-cbc,aes192-cbc,aes128-cbc,3des-ctr,arcfour,arcfour128,arcfour256");
        f1250b.put("CheckKexes", "diffie-hellman-group14-sha1");
        f1250b.put("MaxAuthTries", "6");
        f1250b.put("ClearAllForwardings", "no");
        ahh ahh = new ahh();
        f1252i = ahh;
        f1251c = ahh;
    }

    /* renamed from: a */
    public synchronized void mo892a(ahf ahf) {
        if (ahf == null) {
            this.f1255f = this.f1254e;
        } else {
            this.f1255f = ahf;
        }
    }

    /* renamed from: a */
    public synchronized ahf mo884a() {
        return this.f1255f;
    }

    /* renamed from: b */
    public agp mo898b() {
        return this.f1256g;
    }

    /* renamed from: a */
    public void mo888a(agp agp) {
        this.f1256g = agp;
    }

    public ahg() {
        aht aht = new aht(this);
        this.f1254e = aht;
        this.f1255f = aht;
        this.f1256g = null;
        this.f1257h = null;
    }

    /* renamed from: a */
    public air mo885a(String str) {
        return mo887a((String) null, str, 22);
    }

    /* renamed from: a */
    public air mo886a(String str, String str2) {
        return mo887a(str, str2, 22);
    }

    /* renamed from: a */
    public air mo887a(String str, String str2, int i) {
        if (str2 != null) {
            return new air(this, str, str2, i);
        }
        throw new ahj("host must not be null.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo893a(air air) {
        synchronized (this.f1253d) {
            this.f1253d.addElement(air);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo901b(air air) {
        boolean remove;
        synchronized (this.f1253d) {
            remove = this.f1253d.remove(air);
        }
        return remove;
    }

    /* renamed from: a */
    public void mo889a(ahb ahb) {
        this.f1257h = ahb;
    }

    /* renamed from: b */
    public void mo899b(String str) {
        if (this.f1257h == null) {
            this.f1257h = new ahs(this);
        }
        ahb ahb = this.f1257h;
        if (ahb instanceof ahs) {
            synchronized (ahb) {
                ((ahs) this.f1257h).mo979a(str);
            }
        }
    }

    /* renamed from: a */
    public void mo894a(InputStream inputStream) {
        if (this.f1257h == null) {
            this.f1257h = new ahs(this);
        }
        ahb ahb = this.f1257h;
        if (ahb instanceof ahs) {
            synchronized (ahb) {
                ((ahs) this.f1257h).mo977a(inputStream);
            }
        }
    }

    /* renamed from: c */
    public ahb mo902c() {
        if (this.f1257h == null) {
            this.f1257h = new ahs(this);
        }
        return this.f1257h;
    }

    /* renamed from: c */
    public void mo903c(String str) {
        mo896a(str, (byte[]) null);
    }

    /* renamed from: b */
    public void mo900b(String str, String str2) {
        byte[] c = str2 != null ? aji.m1820c(str2) : null;
        mo896a(str, c);
        if (c != null) {
            aji.m1822d(c);
        }
    }

    /* renamed from: a */
    public void mo896a(String str, byte[] bArr) {
        mo891a((ahd) ahe.m1322a(str, (String) null, this), bArr);
    }

    /* renamed from: a */
    public void mo895a(String str, String str2, byte[] bArr) {
        mo891a((ahd) ahe.m1322a(str, str2, this), bArr);
    }

    /* renamed from: a */
    public void mo897a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        mo891a((ahd) ahe.m1323a(str, bArr, bArr2, this), bArr3);
    }

    /* renamed from: a */
    public void mo891a(ahd ahd, byte[] bArr) {
        if (bArr != null) {
            try {
                byte[] bArr2 = new byte[bArr.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                try {
                    ahd.mo867a(bArr2);
                    aji.m1822d(bArr2);
                } catch (Throwable th) {
                    th = th;
                    bArr = bArr2;
                    aji.m1822d(bArr);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aji.m1822d(bArr);
                throw th;
            }
        }
        ahf ahf = this.f1255f;
        if (ahf instanceof aht) {
            ((aht) ahf).mo986a(ahd);
        } else if (!(ahd instanceof ahe) || ahd.mo873e()) {
            synchronized (this) {
                ahf ahf2 = this.f1255f;
                if (!(ahf2 instanceof ahf.C0043a)) {
                    mo892a((ahf) new ahf.C0043a(ahf2));
                }
            }
            ((ahf.C0043a) this.f1255f).mo882a(ahd);
        } else {
            this.f1255f.mo877a(((ahe) ahd).mo875g().mo944e());
        }
    }

    /* renamed from: d */
    public void mo905d(String str) {
        Vector c = this.f1255f.mo880c();
        for (int i = 0; i < c.size(); i++) {
            ahd ahd = (ahd) c.elementAt(i);
            if (ahd.mo872d().equals(str)) {
                ahf ahf = this.f1255f;
                if (ahf instanceof aht) {
                    ((aht) ahf).mo987b(ahd);
                } else {
                    ahf.mo879b(ahd.mo868a());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo890a(ahd ahd) {
        this.f1255f.mo879b(ahd.mo868a());
    }

    /* renamed from: d */
    public Vector mo904d() {
        Vector vector = new Vector();
        Vector c = this.f1255f.mo880c();
        for (int i = 0; i < c.size(); i++) {
            vector.addElement(((ahd) c.elementAt(i)).mo872d());
        }
        return vector;
    }

    /* renamed from: e */
    public void mo906e() {
        this.f1255f.mo881d();
    }

    /* renamed from: e */
    public static String m1350e(String str) {
        String str2;
        synchronized (f1250b) {
            str2 = (String) f1250b.get(str);
        }
        return str2;
    }

    /* renamed from: a */
    public static void m1348a(Hashtable hashtable) {
        synchronized (f1250b) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                f1250b.put(str, (String) hashtable.get(str));
            }
        }
    }

    /* renamed from: c */
    public static void m1349c(String str, String str2) {
        f1250b.put(str, str2);
    }

    /* renamed from: a */
    public static void m1347a(ahu ahu) {
        if (ahu == null) {
            ahu = f1252i;
        }
        f1251c = ahu;
    }

    /* renamed from: f */
    static ahu m1351f() {
        return f1251c;
    }
}
