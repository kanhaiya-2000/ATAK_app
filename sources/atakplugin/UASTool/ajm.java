package atakplugin.UASTool;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ajm implements agm {

    /* renamed from: c */
    private static final int f1634c = 16;

    /* renamed from: d */
    private static final int f1635d = 24;

    /* renamed from: e */
    private Cipher f1636e;

    /* renamed from: a */
    public int mo803a() {
        return 16;
    }

    /* renamed from: b */
    public int mo806b() {
        return 24;
    }

    /* renamed from: c */
    public boolean mo807c() {
        return true;
    }

    /* renamed from: a */
    public void mo804a(int i, byte[] bArr, byte[] bArr2) {
        if (bArr2.length > 16) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr2, 0, bArr3, 0, 16);
            bArr2 = bArr3;
        }
        if (bArr.length > 24) {
            byte[] bArr4 = new byte[24];
            System.arraycopy(bArr, 0, bArr4, 0, 24);
            bArr = bArr4;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f1636e = Cipher.getInstance("AES/CBC/" + "NoPadding");
            synchronized (Cipher.class) {
                this.f1636e.init(i == 0 ? 1 : 2, secretKeySpec, new IvParameterSpec(bArr2));
            }
        } catch (Exception e) {
            this.f1636e = null;
            throw e;
        }
    }

    /* renamed from: a */
    public void mo805a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f1636e.update(bArr, i, i2, bArr2, i3);
    }
}
