package atakplugin.UASTool;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ajt implements agm {

    /* renamed from: c */
    private static final int f1657c = 8;

    /* renamed from: d */
    private static final int f1658d = 16;

    /* renamed from: e */
    private Cipher f1659e;

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
        return true;
    }

    /* renamed from: a */
    public void mo804a(int i, byte[] bArr, byte[] bArr2) {
        if (bArr2.length > 8) {
            byte[] bArr3 = new byte[8];
            System.arraycopy(bArr2, 0, bArr3, 0, 8);
            bArr2 = bArr3;
        }
        if (bArr.length > 16) {
            byte[] bArr4 = new byte[16];
            System.arraycopy(bArr, 0, bArr4, 0, 16);
            bArr = bArr4;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "Blowfish");
            this.f1659e = Cipher.getInstance("Blowfish/CBC/" + "NoPadding");
            synchronized (Cipher.class) {
                this.f1659e.init(i == 0 ? 1 : 2, secretKeySpec, new IvParameterSpec(bArr2));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: a */
    public void mo805a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f1659e.update(bArr, i, i2, bArr2, i3);
    }
}
