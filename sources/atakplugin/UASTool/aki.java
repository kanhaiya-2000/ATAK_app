package atakplugin.UASTool;

import java.security.MessageDigest;

public class aki implements agz {

    /* renamed from: a */
    MessageDigest f1693a;

    /* renamed from: b */
    public int mo836b() {
        return 32;
    }

    /* renamed from: a */
    public void mo834a() {
        try {
            this.f1693a = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /* renamed from: a */
    public void mo835a(byte[] bArr, int i, int i2) {
        this.f1693a.update(bArr, i, i2);
    }

    /* renamed from: c */
    public byte[] mo837c() {
        return this.f1693a.digest();
    }
}
