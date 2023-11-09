package atakplugin.UASTool;

import java.security.MessageDigest;

public class akh implements agz {

    /* renamed from: a */
    MessageDigest f1692a;

    /* renamed from: b */
    public int mo836b() {
        return 20;
    }

    /* renamed from: a */
    public void mo834a() {
        try {
            this.f1692a = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /* renamed from: a */
    public void mo835a(byte[] bArr, int i, int i2) {
        this.f1692a.update(bArr, i, i2);
    }

    /* renamed from: c */
    public byte[] mo837c() {
        return this.f1692a.digest();
    }
}
