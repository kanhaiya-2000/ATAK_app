package atakplugin.UASTool;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ajq implements agm {

    /* renamed from: c */
    private static final int f1646c = 8;

    /* renamed from: d */
    private static final int f1647d = 16;

    /* renamed from: e */
    private Cipher f1648e;

    /* renamed from: a */
    public int mo803a() {
        return 8;
    }

    /* renamed from: b */
    public int mo806b() {
        return 16;
    }

    /* renamed from: c */
    public boolean mo807c() {
        return false;
    }

    /* renamed from: a */
    public void mo804a(int i, byte[] bArr, byte[] bArr2) {
        if (bArr.length > 16) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, 0, bArr3, 0, 16);
            bArr = bArr3;
        }
        try {
            this.f1648e = Cipher.getInstance("RC4");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "RC4");
            synchronized (Cipher.class) {
                this.f1648e.init(i == 0 ? 1 : 2, secretKeySpec);
            }
        } catch (Exception e) {
            this.f1648e = null;
            throw e;
        }
    }

    /* renamed from: a */
    public void mo805a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f1648e.update(bArr, i, i2, bArr2, i3);
    }
}
