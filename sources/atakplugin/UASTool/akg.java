package atakplugin.UASTool;

import java.security.SecureRandom;

public class akg implements aie {

    /* renamed from: a */
    private byte[] f1690a;

    /* renamed from: b */
    private SecureRandom f1691b;

    public akg() {
        this.f1690a = new byte[16];
        this.f1691b = null;
        this.f1691b = new SecureRandom();
    }

    /* renamed from: a */
    public void mo1012a(byte[] bArr, int i, int i2) {
        if (i2 > this.f1690a.length) {
            this.f1690a = new byte[i2];
        }
        this.f1691b.nextBytes(this.f1690a);
        System.arraycopy(this.f1690a, 0, bArr, i, i2);
    }
}
