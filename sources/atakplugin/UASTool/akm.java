package atakplugin.UASTool;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class akm implements agm {

    /* renamed from: c */
    private static final int f1701c = 8;

    /* renamed from: d */
    private static final int f1702d = 24;

    /* renamed from: e */
    private Cipher f1703e;

    /* renamed from: a */
    public int mo803a() {
        return 8;
    }

    /* renamed from: b */
    public int mo806b() {
        return 24;
    }

    /* renamed from: c */
    public boolean mo807c() {
        return false;
    }

    /* renamed from: a */
    public void mo804a(int i, byte[] bArr, byte[] bArr2) {
        if (bArr2.length > 8) {
            byte[] bArr3 = new byte[8];
            System.arraycopy(bArr2, 0, bArr3, 0, 8);
            bArr2 = bArr3;
        }
        if (bArr.length > 24) {
            byte[] bArr4 = new byte[24];
            System.arraycopy(bArr, 0, bArr4, 0, 24);
            bArr = bArr4;
        }
        try {
            this.f1703e = Cipher.getInstance("DESede/CTR/" + "NoPadding");
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(bArr));
            synchronized (Cipher.class) {
                this.f1703e.init(i == 0 ? 1 : 2, generateSecret, new IvParameterSpec(bArr2));
            }
        } catch (Exception e) {
            this.f1703e = null;
            throw e;
        }
    }

    /* renamed from: a */
    public void mo805a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f1703e.update(bArr, i, i2, bArr2, i3);
    }
}
