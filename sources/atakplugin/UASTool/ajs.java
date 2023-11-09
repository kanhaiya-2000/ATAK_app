package atakplugin.UASTool;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ajs implements agm {

    /* renamed from: c */
    private static final int f1653c = 8;

    /* renamed from: d */
    private static final int f1654d = 32;

    /* renamed from: e */
    private static final int f1655e = 1536;

    /* renamed from: f */
    private Cipher f1656f;

    /* renamed from: a */
    public int mo803a() {
        return 8;
    }

    /* renamed from: b */
    public int mo806b() {
        return 32;
    }

    /* renamed from: c */
    public boolean mo807c() {
        return false;
    }

    /* renamed from: a */
    public void mo804a(int i, byte[] bArr, byte[] bArr2) {
        if (bArr.length > 32) {
            byte[] bArr3 = new byte[32];
            System.arraycopy(bArr, 0, bArr3, 0, 32);
            bArr = bArr3;
        }
        try {
            this.f1656f = Cipher.getInstance("RC4");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "RC4");
            synchronized (Cipher.class) {
                this.f1656f.init(i == 0 ? 1 : 2, secretKeySpec);
            }
            byte[] bArr4 = new byte[1];
            for (int i2 = 0; i2 < f1655e; i2++) {
                this.f1656f.update(bArr4, 0, 1, bArr4, 0);
            }
        } catch (Exception e) {
            this.f1656f = null;
            throw e;
        }
    }

    /* renamed from: a */
    public void mo805a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f1656f.update(bArr, i, i2, bArr2, i3);
    }
}
