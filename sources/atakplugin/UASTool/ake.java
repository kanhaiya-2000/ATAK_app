package atakplugin.UASTool;

import java.security.MessageDigest;

public class ake implements agz {

    /* renamed from: a */
    MessageDigest f1689a;

    /* renamed from: b */
    public int mo836b() {
        return 16;
    }

    /* renamed from: a */
    public void mo834a() {
        try {
            this.f1689a = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /* renamed from: a */
    public void mo835a(byte[] bArr, int i, int i2) {
        this.f1689a.update(bArr, i, i2);
    }

    /* renamed from: c */
    public byte[] mo837c() {
        return this.f1689a.digest();
    }
}
