package atakplugin.UASTool;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ajp implements agm {

    /* renamed from: c */
    private static final int f1643c = 16;

    /* renamed from: d */
    private static final int f1644d = 32;

    /* renamed from: e */
    private Cipher f1645e;

    /* renamed from: a */
    public int mo803a() {
        return 16;
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
        if (bArr2.length > 16) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr2, 0, bArr3, 0, 16);
            bArr2 = bArr3;
        }
        if (bArr.length > 32) {
            byte[] bArr4 = new byte[32];
            System.arraycopy(bArr, 0, bArr4, 0, 32);
            bArr = bArr4;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f1645e = Cipher.getInstance("AES/CTR/" + "NoPadding");
            synchronized (Cipher.class) {
                this.f1645e.init(i == 0 ? 1 : 2, secretKeySpec, new IvParameterSpec(bArr2));
            }
        } catch (Exception e) {
            this.f1645e = null;
            throw e;
        }
    }

    /* renamed from: a */
    public void mo805a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f1645e.update(bArr, i, i2, bArr2, i3);
    }
}
